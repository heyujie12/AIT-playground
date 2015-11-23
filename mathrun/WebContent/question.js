var questionType = "";
var number1 = null;
var number2 = null;
var answer = null;
var questionText = "";
var ctx = document.getElementById('myCanvas').getContext('2d');
var answer;

//function composeQuestion(num1,num2,type){
function composeQuestion(){

	var num1 = Math.floor((Math.random() * 20) + 1);
	var num2 = Math.floor((Math.random() * 10) + 1);
	var qArray = ['multiply','divide','add','sub'];
	var type = qArray[Math.floor(Math.random() * qArray.length)];
	var timeForQuestion = 10;

	number1 = num1;
	number2 = num2;

	questionType = type;

	if(type == "multiply")
		questionText = number1 + " x " + number2 + " = ";
	else if(type == "divide")
		questionText = number1 + " / " + number2 + " = ";
	else if(type == "add")
		questionText = number1 + " + " + number2 + " = ";
	else if(type == "sub")
		questionText = number1 + " - " + number2 + " = ";
	//else if(type == "complex")
		//add code here

	setAnswer();
	ctx.clearRect(20,20,125,150);
	ctx.font="30px Georgia";
	ctx.fillText(questionText,25,50);
	//ctx.fillText("_ _ _",150,55)
}
function setAnswer()
{

	if(questionType == "multiply")
		answer = number1 * number2;
	else if(questionType == "divide")
		answer = number1 / number2;
	else if(questionType == "add")
		answer = number1 + number2;
	else if(questionType == "sub")
		answer = number1 - number2;

	if(answer > 0 && answer % 1 == 0)
			console.log(answer);
	else
		composeQuestion();
}
function getAnswer()
{
	return answer;
}