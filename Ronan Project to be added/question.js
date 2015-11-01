var questionType = "";
var number1 = null;
var number2 = null;
var answer = null;
var questionText = "";
var ctx = document.getElementById('myCanvas').getContext('2d');

function composeQuestion(num1,num2,type){
	number1 = num1;
	number2 = num2;

	questionType = type;

	if(type == "multiply")
		questionText = number1 + " x " + number2;
	else if(type == "divide")
		questionText = number1 + " / " + number2;
	else if(type == "add")
		questionText = number1 + " + " + number2;
	else if(type == "sub")
		questionText = number1 + " - " + number2;
	else if(type == "complex")
		//add code here

	ctx.font="20px Georgia";
	ctx.clearRect(875,225,400,400);
	ctx.fillText(questionText,900,250);
}