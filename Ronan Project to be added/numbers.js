var ctx = document.getElementById('myCanvas').getContext('2d');
var qAnswer = 8;
var text = 0;
var lastText = null;

//number is clicked and drawn also has fuctionality for determining if it is 2 digits or not
function numClicked(input)
{
	text = input;

	//has 2 digits
	if(input != -1)
	{
		if(qAnswer >= 10){
			//do stuff with strings & take two strings
			ctx.clearRect(145,20,400,250);
			ctx.font="30px Georgia";
			var answerText = "";
			if(lastText != null)
				answerText = "" + lastText +text;
			else
				answerText = text;

			console.log(answerText);
			ctx.fillText(answerText,150,50);
			var combineAnswer = Number(answerText);
			//console.log(combineAnswer);
			if(answerText == qAnswer)
			{
				ctx.clearRect(145,20,400,250);
				ctx.fillText(answerText + " is the correct answer",150,50);
				console.log("Fair Play");
				loop();
			}
		}
		//has 1 digit
		else if (qAnswer < 10)
		{
			ctx.clearRect(145,20,400,250);
			ctx.font="30px Georgia";
			ctx.fillText(input,150,50);
			if (input == qAnswer)
			{
				ctx.clearRect(145,20,400,250);
				ctx.fillText(input + " is the correct answer",150,50);
				loop();
			}
		}
		lastText = input;
	}
	else if(input == -1)
	{
		ctx.clearRect(145,20,400,250);
		ctx.font="30px Georgia";
		ctx.fillText(" ",150,50);
		lastText = 0;
	}
}
