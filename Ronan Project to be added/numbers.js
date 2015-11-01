var ctx = document.getElementById('myCanvas').getContext('2d');
var qAnswer = 12;
var text = 0;
var lastText = null;

//number is clicked and drawn also has fuctionality for determining if it is 2 digits or not
function numClicked(input)
{
	//console.log(text);
	text = input;
 	//console.log(input);
	ctx.font="50px Georgia";

	//has 2 digits
	if(qAnswer >= 10){
		//do stuff with strings & take two strings
		ctx.clearRect(25,25,250,250);
		ctx.font="30px Georgia";
		var answerText = "";
		if(lastText != null)
			answerText = "" + lastText +text;
		else
			answerText = text;

		console.log(answerText);
		ctx.fillText(answerText,50,50);
		var combineAnswer = Number(answerText);
		//console.log(combineAnswer);
		if(answerText == qAnswer)
		{
			ctx.clearRect(25,25,200,200);
			ctx.fillText(answerText + " is the correct answer",100,50);
			console.log("Fair Play");
			loop();
		}
	}
	//has 1 digit
	else if (qAnswer < 10)
	{
		ctx.clearRect(25,150,550,250);
		ctx.font="30px Georgia";
		ctx.fillText(input,50,50);
	}


	else if (input == qAnswer){
		ctx.clearRect(25,200,100,100);
		ctx.fillText(input + " is the correct answer",50,50);
		loop();
	}

	lastText = input;
}
