function loop(){
	var firstNumber = Math.floor((Math.random() * 10) + 1);
	var secondNumber = Math.floor((Math.random() * 10) + 1);
	var qArray = ['multiply','divide','add','sub'];
	var qType = qArray[Math.floor(Math.random() * qArray.length)];

	drawCharachter();
	drawNPC();
	composeQuestion(firstNumber,secondNumber,qType);

	
}
