function init(){
	drawCharachter();
	drawNPC();
}
function loop(){	
	stopPlayerAnimation();
	stopNPCAnimation();
	composeQuestion();
	resetPlayerPosition();
	animateCharachter();
	animateNPC();
}
