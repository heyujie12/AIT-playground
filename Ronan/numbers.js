var ctx = document.getElementById('myCanvas').getContext('2d');
var qAnswer = 0;
var text = 0;
var lastText = null;
var lastLastText = null;
var numberOfAttempts = 0;
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
			ctx.clearRect(145,20,750,250);
			ctx.font="30px Georgia";
			ctx.fillText(input,150,50);
			numberOfAttempts = numberOfAttempts + 1;
			if (input == qAnswer)
			{
				ctx.clearRect(145,20,750,250);
				ctx.fillText(input + " is correct "+numberOfAttempts+" Attempts",450,50);
				numberOfAttempts = 0;
				updateScore(5);
				text = null;
				loop();
			}
		}
		//has 2 digits
		else if(qAnswer >= 10 && qAnswer < 100){
			//do stuff with strings & take two strings
			ctx.clearRect(145,20,750,250);
			ctx.font="30px Georgia";
			var answerText = "";
			if(lastText != null){
				answerText = "" + lastText + text;
				numberOfAttempts = numberOfAttempts + 1;
			}
			else
				answerText = text;

			console.log(answerText);
			ctx.fillText(answerText,150,50);
			var combineAnswer = Number(answerText);

			if(answerText == qAnswer)
			{
				ctx.clearRect(145,20,750,250);
				ctx.fillText(answerText +" is correct "+numberOfAttempts+" Attempts",450,50);
				numberOfAttempts = 0;
				updateScore(5);
				lastText = null;
				text = null;
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
				answerText = "" + lastLastText + lastText + text;
				numberOfAttempts = numberOfAttempts + 1;
			}
			console.log(answerText);
			ctx.fillText(answerText,150,50);
			var combineAnswer = Number(answerText);
			if(answerText == qAnswer)
			{
				ctx.clearRect(145,20,750,250);
				ctx.fillText(answerText + " is correct "+numberOfAttempts+" Attempts",450,50);
				//Send Attempts + Time Taken
				numberOfAttempts = 0;
				updateScore(5);
				text = null;
				lastText = null;
				lastLastText = null;
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
		lastText = null;
		lastLastText = null;
	}
}
