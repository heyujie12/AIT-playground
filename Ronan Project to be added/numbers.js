var ctx = document.getElementById('myCanvas').getContext('2d');
var qAnswer = 0;
var text = 0;
var lastText = null;
var lastLastText = null;
//number is clicked and drawn also has fuctionality for determining if it is 2 digits or not
function numClicked(input)
{
	text = input;
	qAnswer = getAnswer();
	
	if(input != -1)
	{
		//has 1 digit
		if (qAnswer < 10)
		{
			ctx.clearRect(145,20,400,250);
			ctx.font="30px Georgia";
			ctx.fillText(input,150,50);
			if (input == qAnswer)
			{
				ctx.clearRect(145,20,750,250);
				ctx.fillText(input + " is the correct answer",450,50);
				loop();
			}
		}
		//has 2 digits
		else if(qAnswer >= 10 && qAnswer < 100){
			//do stuff with strings & take two strings
			ctx.clearRect(145,20,750,250);
			ctx.font="30px Georgia";
			var answerText = "";
			if(lastText != null)
				answerText = "" + lastText + text;
			else
				answerText = text;

			console.log(answerText);
			ctx.fillText(answerText,150,50);
			var combineAnswer = Number(answerText);

			if(answerText == qAnswer)
			{
				ctx.clearRect(145,20,750,250);
				ctx.fillText(answerText + " is the correct answer",450,50);
				console.log("Fair Play");
				lastText = 0;
				text = 0;
				loop();
			}
			else
				lastText = input;
		}
		
		//3 digits
		else if (qAnswer >= 100)
		{
			//do stuff with strings & take two strings
			ctx.clearRect(145,20,750,250);
			ctx.font="30px Georgia";
			var answerText = "";
			if(lastText == null && lastLastText == null)
				answerText = "" + 0 + 0 + text;
			else if(lastText != null && lastLastText == null)
				answerText = "" + 0 + lastText + text;
			else{
				answerText = "" + lastLastText + lastText + text ;
			}
			console.log(answerText);
			ctx.fillText(answerText,150,50);
			var combineAnswer = Number(answerText);
			if(answerText == qAnswer)
			{
				ctx.clearRect(145,20,750,250);
				ctx.fillText(answerText + " is the correct answer",450,50);
				console.log("Fair Play");
				text = 0;
				lastText = 0;
				lastLastText = 0;
				loop();
			}
			else
			{
				lastLastText = lastText;
				lastText = input;
			}	
			
		}
		//decimal
		//else if (qAnswer % 1 !=0) {};
		
	}
	else if(input == -1)
	{
		ctx.clearRect(145,20,750,250);
		ctx.font="30px Georgia";
		ctx.fillText(" ",150,50);
		lastText = 0;
		lastLastText = 0;
	}
}
