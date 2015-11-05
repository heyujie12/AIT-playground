package com.ait.agilebuild.mathrun.questiongenerator;

import java.util.Random;

import com.ait.agilebuild.mathrun.model.QuestionDefinition;

public class generate4thAdvanced {
	public QuestionDefinition getQ(){
		QuestionDefinition Qd= new QuestionDefinition();
		Random random = new Random();
		float temp_firstValueA = random.nextInt(1000)%(1000-10+1) + 10;
		float temp_secondValueA = random.nextInt(1000)%(1000-10+1) + 10;
		int temp_firstValueB = random.nextInt(200)%(200-10+1) + 10;
		int temp_secondValueB = random.nextInt(100)%(100-10+1) + 10;
		int temp_firstValueC = random.nextInt(500)%(500-1+1) + 1;
		int temp_secondValueC = random.nextInt(10)%(10-1+1) + 1;
		int temp_firstValueD = random.nextInt(100)%(100-1+1) + 1;
		int temp_secondValueD = random.nextInt(10)%(10-1+1) + 1;
		Qd.setOperator(random.nextInt(4)%(4-1+1) + 1);
		switch(Qd.getOperator()){
		case 1: {
			if(temp_firstValueA/100 + temp_secondValueA/100 <=10){
				Qd.setFirst_value(temp_firstValueA/100);
				Qd.setSecond_value(temp_secondValueA/100);
				Qd.setOperatorCh("+");
				Qd.setCorrect_answer(temp_firstValueA/100 + temp_secondValueA/100);
				return Qd;
			}else{
				return getQ();
			}
		}
		case 2: {
			if(temp_firstValueB - temp_secondValueB>0){
				Qd.setFirst_value(temp_firstValueB);
				Qd.setSecond_value(temp_secondValueB);
				Qd.setOperatorCh("-");
				Qd.setCorrect_answer(temp_firstValueB - temp_secondValueB);
				return Qd;
			}else{
				return getQ();
			}
		}
		case 3: {
				Qd.setFirst_value(temp_firstValueC);
				Qd.setSecond_value(temp_secondValueC);
				Qd.setOperatorCh("*");
				Qd.setCorrect_answer(temp_firstValueC * temp_secondValueC);
				return Qd;
		}
		case 4:{
				Qd.setFirst_value(temp_firstValueD);
				Qd.setSecond_value(temp_secondValueD);
				Qd.setOperatorCh("÷");
				Qd.setCorrect_answer(temp_firstValueD / temp_secondValueD);
				Qd.setRemainder(temp_firstValueD% temp_secondValueD);
				return Qd;
		}
		default: return getQ();
		}
	}
}
