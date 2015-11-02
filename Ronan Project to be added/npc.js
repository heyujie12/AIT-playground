var npcWidthMax = 4;
var npcHeightMax = 1;
var fixedX = 0;
var fixedY = 275;
var begin = true;
var npcX = 0;
var npcY = 0;
	
function drawNPC(){

	var ctx = document.getElementById('myCanvas').getContext('2d');
	var img = new Image();
	img.src = "images/enemy.png";
	var npcFrameSize = img.width/npcWidthMax;
	var npcFrameHeight = img.height;

	requestAnimationFrame(drawNPC);
	ctx.clearRect(fixedX-5,fixedY,npcFrameSize+15,npcFrameHeight);
	ctx.drawImage(img,npcX,npcY,npcFrameSize,npcFrameHeight,fixedX,fixedY,npcFrameSize,npcFrameHeight);
}
function animateNPC(){

	var ctx = document.getElementById('myCanvas').getContext('2d');
	var img = new Image();
	img.src = "images/enemy.png";
	var npcFrameSize = img.width/npcWidthMax;
	var npcFrameHeight = img.height;

	requestAnimationFrame(animateNPC);
	
	ctx.clearRect(fixedX-5,fixedY,npcFrameSize+15,npcFrameHeight);
	ctx.drawImage(img,npcX,npcY,npcFrameSize,npcFrameHeight,fixedX,fixedY,npcFrameSize,npcFrameHeight);
	
	if(npcX + npcFrameSize >= img.width)
	{	
		npcX = 0;
	}
	else
		npcX = npcX + npcFrameSize;

}
function resetNPCAnimation()
{
	npcX = 0;
	npcY = 0;
}
window.requestAnimFrame = (function(){
  return  window.requestAnimationFrame       ||
          window.webkitRequestAnimationFrame ||
          window.mozRequestAnimationFrame    ||
          function( callback ){
            window.setTimeout(callback, 1000 / 60);
          };
})();