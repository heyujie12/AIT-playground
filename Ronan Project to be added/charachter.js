var count = 0;
var widthMax = 7;
var heightMax = 4;
var placeX = 500;
var placeY = 225;
var begin = true;
var charX = 0;
var charY = 0;
	
function drawCharachter(){
	
	var ctx = document.getElementById('myCanvas').getContext('2d');
	var img = new Image();
	img.src = "images/braid.png";
	
	var frameSize = img.width/widthMax;
	var frameHeight = img.height/heightMax;

	requestAnimationFrame(drawCharachter);
	
	ctx.clearRect(placeX-5,placeY,frameSize+15,frameHeight);
	ctx.drawImage(img,charX,charY,frameSize,frameHeight,placeX,placeY,frameSize,frameHeight);
	//animation loop
	if(charX + frameSize >= img.width )
	{	
		charX = 0;
		charY = charY + frameHeight;
		placeX = placeX - 5;
	}
	else if(charY + frameHeight >= img.height)
	{
		reset();
	}
	else
		charX = charX + frameSize;
	
	//Charachter dies
	if(placeX <= 135)
	{
		ctx.clearRect(placeX-5,placeY,frameSize+15,frameHeight);
		placeX = 500;
	}
}
function reset()
{
	charX = 0;
	charY = 0;
}
window.requestAnimFrame = (function(){
  return  window.requestAnimationFrame       ||
          window.webkitRequestAnimationFrame ||
          window.mozRequestAnimationFrame    ||
          function( callback ){
            window.setTimeout(callback, 1000 / 60);
          };
})();


