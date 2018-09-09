$(document).ready(function(){
	$(".nav1").css("height","300px");
	$(".tabs li a:first").addClass("current");
	$(".tabs li a").click(function() {
		$(".tabs li a").removeClass("current");
		$(this).addClass("current");
		$(".tabs li ul").animate({height:"0"},"fast");
		$(this).next().animate({height:"300"},"slow");
	});
});