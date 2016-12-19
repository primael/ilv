(function($) {

	var $btn = $('#btn');
	if ('webkitSpeechRecognition' in window) {

		var recognition = new webkitSpeechRecognition();
		recognition.lang = 'fr-FR';
		recognition.continuous = false;
		recognition.interimResults = false;

//		$btn.click(function(event) {
//			event.preventDefault();
			recognition.start();
//		})

		recognition.onresult = function(event) {
			console.log(event);
		}

	} else {
		$btn.hide();
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

	// Load only text for begining
	lazyLoad("/js/animation/Text.js");
	lazyLoad("/js/detection/FacialDetection.js");
	
	$('#myModal').modal('show');

	$("#myModal").draggable({
		handle : ".modal-header"
	});

})(jQuery);