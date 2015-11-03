function init(){
	drawCharachter();
	drawNPC();
}
function loop(){
	var firstNumber = Math.floor((Math.random() * 10) + 1);
	var secondNumber = Math.floor((Math.random() * 10) + 1);
	var qArray = ['multiply','divide','add','sub'];
	var qType = qArray[Math.floor(Math.random() * qArray.length)];
	var timeForQuestion = 10;
	
	stopPlayerAnimation();
	stopNPCAnimation();
	composeQuestion(firstNumber,secondNumber,qType);
	resetPlayerPosition();
	animateCharachter();
	animateNPC();
	

	
}
