function init(){
	drawUI();
	drawCharachter();
	drawNPC();
	
	ajaxloop();
}

function ajaxloop(progression, index){
	if(index === undefined){
		index = 1;
	}
	$.ajax({
		  type: "POST",
		  data: {level: 5, progression: JSON.stringify(progression)},
		  url: "/mathrun/questions",
		  success: function(result){
			  console.log(result);
			  var lastQ = result.progression[result.progression.length - 1];
			  lastQ.attempt_duration = [100];
			  lastQ.attempts= lastQ.correct_answer;
			  lastQ.time = 100;
			  if(index < 10){
				  ajaxloop(result, ++index);
			  }
		  },
//		  dataType: dataType
		});
}
function loop(){
	if(getLives() != 0)
	{	
		stopPlayerAnimation();
		stopNPCAnimation();
		composeQuestion();
		resetPlayerPosition();
		animateCharachter();
		animateNPC();
	}
	else 
		gameOver();
}
function gameOver(){
	stopPlayerAnimation();
	stopNPCAnimation();
	resetPlayerPosition();
}
