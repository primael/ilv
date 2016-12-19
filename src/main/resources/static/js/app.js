(function($) {

	var words = null;
	var recognition = null;
	
	if ('webkitSpeechRecognition' in window) {

		recognition = new webkitSpeechRecognition();
		recognition.lang = 'fr-FR';
		recognition.continuous = true;
		recognition.interimResults = true;

		recognition.onresult = function(event) {
			for (var i = event.resultIndex; i < event.results.length; i++) {
				if (event.results[i].isFinal) {
					var transcript = event.results[i][0].transcript;
					var item = $("<ul></ul>").text(transcript);
					$("#whatiheard").append(item);
					recognition.stop();
					redirect(transcript);
					return true;
				}
				var transcript = event.results[i][0].transcript;
				console.log(transcript);
			}
			console.log(event);
		}

	}

	function heard(){
		recognition.start();
	}
	function redirect(transcript) {
		if (transcript.indexOf('océan') !== -1) {
			removejscssfile("/js/animation/Text.js", "js");
			lazyLoad("/js/animation/controls/OrbitControls.js");
			lazyLoad("/js/animation/shaders/MirrorShader.js");
			lazyLoad("/js/animation/shaders/WaterShader.js");
			lazyLoad("/js/animation/Ocean.js");
			$("#containerText").remove();
		}
	}

	function lazyLoad(s) {
		var console = $("#listDebug");
		var d = window.document;
		b = d.body;
		e = d.createElement("script");

		e.async = true;
		e.src = s;
		b.appendChild(e);

		var item = $("<ul></ul>").text("script loaded [" + s + "]");
		console.append(item);
	}

	function removejscssfile(filename, filetype) {
		var targetelement = (filetype == "js") ? "script"
				: (filetype == "css") ? "link" : "none"
		var targetattr = (filetype == "js") ? "src"
				: (filetype == "css") ? "href" : "none"
		var allsuspects = document.getElementsByTagName(targetelement)
		for (var i = allsuspects.length; i >= 0; i--) {
			if (allsuspects[i]
					&& allsuspects[i].getAttribute(targetattr) != null
					&& allsuspects[i].getAttribute(targetattr)
							.indexOf(filename) != -1)
				allsuspects[i].parentNode.removeChild(allsuspects[i])
		}
	}

	// Load only text for begining
	lazyLoad("/js/animation/Text.js");
	lazyLoad("/js/detection/FacialDetection.js");

	$('#myModal').modal('show');

	$("#myModal").draggable({
		handle : ".modal-header"
	});

})(jQuery);