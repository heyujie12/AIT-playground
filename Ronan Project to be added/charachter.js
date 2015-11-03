var count = 0;
var widthMax = 7;
var heightMax = 4;
var placeX = 700;
var placeY = 350;
var begin = true;
var charX = 0;
var charY = 0;
var ctx = document.getElementById('myCanvas').getContext('2d');
var myreq;

function drawCharachter(){

	var img = new Image();
	img.src = "images/braid.png";

	var frameSize = img.width/widthMax;
	var frameHeight = img.height/heightMax;
	requestAnimationFrame(drawCharachter);

	//ctx.clearRect(placeX-5,placeY,frameSize+15,frameHeight);
	ctx.drawImage(img,charX,charY,frameSize,frameHeight,placeX,placeY,frameSize,frameHeight);
}
function animateCharachter(){
	var img = new Image();
	img.src = "images/braid.png";

	var frameSize = img.width/widthMax;
	var frameHeight = img.height/heightMax;


	myreq = requestAnimationFrame(animateCharachter);
	ctx.clearRect(100,placeY,frameSize+750,frameHeight);
	ctx.drawImage(img,charX,charY,frameSize,frameHeight,placeX,placeY,frameSize,frameHeight);
	//animation loop
	placeX = placeX - 1;
	if(charX + frameSize >= img.width )
	{
		charX = 0;
		charY = charY + frameHeight;

	}
	else if(charY + frameHeight >= img.height)
	{
		resetPlayerAnimation();
	}
	else
		charX = charX + frameSize;

	//Charachter dies
	if(placeX <= 135)
	{
		ctx.clearRect(placeX-5,placeY,frameSize+15,frameHeight);
		resetPlayerPosition();
	}
}
function stopPlayerAnimation(){
	window.cancelAnimationFrame(myreq);
}
function resetPlayerAnimation()
{
	charX = 0;
	charY = 0;
}
function resetPlayerPosition()
{
	placeX = 700;
}
window.requestAnimFrame = (function(){
  return  window.requestAnimationFrame       ||
          window.webkitRequestAnimationFrame ||
          window.mozRequestAnimationFrame    ||
          function( callback ){
            window.setTimeout(callback, 1000 / 60);
          };
})();


