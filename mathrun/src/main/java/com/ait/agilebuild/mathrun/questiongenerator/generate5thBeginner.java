package com.ait.agilebuild.mathrun.questiongenerator;

import java.util.Random;

import com.ait.agilebuild.mathrun.model.QuestionDefinition;

public class generate5thBeginner {
	public QuestionDefinition getQ(){
		QuestionDefinition Qd= new QuestionDefinition();
		Qd.setDifficulty_level(10);
		Random random = new Random();
		int temp_firstValueA = random.nextInt(1500)%(1500-500+1) + 500;
		int temp_secondValueA = random.nextInt(1500)%(1500-500+1) + 500;
		int temp_firstValueB = random.nextInt(300)%(300-150+1) + 150;
		int temp_secondValueB = random.nextInt(100)%(100-50+1) + 50;
		int temp_firstValueC = random.nextInt(100)%(100-20+1) + 20;
		int temp_secondValueC = random.nextInt(10)%(10-1+1) + 1;
		int temp_firstValueD = random.nextInt(100)%(100-10+1) + 10;
		int temp_secondValueD = random.nextInt(10)%(10-1+1) + 1;
		Qd.setOperator(random.nextInt(4)%(4-1+1) + 1);
		switch(Qd.getOperator()){
				case 1: {
					if(temp_firstValueA + temp_secondValueA<=2000){
						Qd.setFirst_value(temp_firstValueA);
						Qd.setSecond_value(temp_secondValueA);
						Qd.setOperatorCh("+");
						Qd.setCorrect_answer(temp_firstValueA + temp_secondValueA);
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
