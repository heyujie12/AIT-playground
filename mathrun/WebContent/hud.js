var ctx = document.getElementById('myCanvas').getContext('2d');
var lives = 5;
var score = 0;
function drawUI(){
    ctx.font="30px Georgia";
	ctx.clearRect(1400,20,350,300);

	ctx.fillText("Lives:",1400,50);
	ctx.fillText(lives,1500,45);
	ctx.fillText("Score:",1400,100);
	ctx.fillText(score,1500,100);
 }
 function updateScore(change){

	score = score + change;
	drawUI();
}
function updateLives(change){
	
	lives = lives + change;
	drawUI();
	if(lives == 0)
		gameOverText()
}
function getLives()
{
	return lives;
}
function gameOverText(){
	
    ctx.font="50px Georgia";
	ctx.clearRect(470,330,350,300);
	ctx.fillText("Game Over",600,350);
}
