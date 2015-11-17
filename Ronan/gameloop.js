function init(){
	drawUI();
	drawCharachter();
	drawNPC();
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
