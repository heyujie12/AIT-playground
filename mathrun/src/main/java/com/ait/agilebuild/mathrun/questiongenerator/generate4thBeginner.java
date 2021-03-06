package com.ait.agilebuild.mathrun.questiongenerator;

import java.util.Random;

import com.ait.agilebuild.mathrun.model.QuestionDefinition;

public class generate4thBeginner {
	public QuestionDefinition getQ(){
		QuestionDefinition Qd= new QuestionDefinition();
		Qd.setDifficulty_level(7);
		Random random = new Random();
	int temp_firstValueA = random.nextInt(1000)%(1000-100+1) + 100;
	int temp_secondValueA = random.nextInt(1000)%(1000-100+1) + 100;
	int temp_firstValueB = random.nextInt(200)%(200-20+1) + 20;
	int temp_secondValueB = random.nextInt(100)%(100-10+1) + 10;
	int temp_firstValueC = random.nextInt(100)%(100-1+1) + 1;
	int temp_secondValueC = random.nextInt(10)%(10-1+1) + 1;
	Qd.setOperator(random.nextInt(3)%(3-1+1) + 1);
	switch(Qd.getOperator()){
			case 1: {
				if(temp_firstValueA + temp_secondValueA<=1500){
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
			default: return getQ();
	}
}
}
