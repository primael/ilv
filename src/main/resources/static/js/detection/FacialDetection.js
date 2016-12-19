var isDetect = false;
var videoInput = document.getElementById('inputVideo');
var canvasInput = document.getElementById('inputCanvas');

var htracker = new headtrackr.Tracker({
	ui : false
});
var sayCheese = new SayCheese('#inputVideo', {
	snapshots : true
});

statusMessages = {
	"whitebalance" : /* [[#{error.white.balance}]] */'error',
	"detecting" : /* [[#{detect.face}]] */'error',
	"hints" : /* [[#{error.face.timeout}]] */'error',
	"redetecting" : /* [[#{error.lost.face}]] */'error',
	"found" : /* [[#{detect.face.found}]] */'error'
};

/* Message du support */
supportMessages = {
	"no getUserMedia" : /* [[#{error.getusermedia.not-supported}]] */'error',
	"no camera" : /* [[#{error.camera.not-found}]] */'error'
};

document.addEventListener("headtrackrStatus", function(event) {
	if (event.status in supportMessages) {
		var message = $('#supportMessages');
		message.append(supportMessages[event.status]);
		message.toggle("slow");
		// } else if (event.status in statusMessages) {
		// var message = $('#trackerMessages');
		// message.append(statusMessages[event.status]);
	} else if (event.status == 'redetecting') {
		isDetect = false;
	}
}, true);

/* Face tracking setup */

htracker.init(videoInput, canvasInput);
htracker.start();

/* Say-cheese setup */

sayCheese.on('snapshot', function(snapshot) {
	if (isDetect === false) {
		$.post("/recognize", {
			data : snapshot.toDataURL('image/png')
		}).done(
				function(data) {
					console.log("sexe: " + data.faces[0].genre + " age: " + data.faces[0].age);
					var item = $('<ul></ul>');
					var image = $('<img class="media-object img-thumbnail img-responsive" style="width:64px;height:64px;"></img>');
					image.attr('src', snapshot.toDataURL('image/png'));
					item.append(image);
					var text = $('<ul></ul>');
					text.text("sexe: " + data.faces[0].genre + " age: " + data.faces[0].age);
					$("#whatisee").append(item, text);
				});
		isDetect = true;
	}
});

sayCheese.start();

document.addEventListener("facetrackingEvent", function(event) {
	if (event.detection == "CS") {
		sayCheese.takeSnapshot();
	}
}, true);