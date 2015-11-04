package com.ait.agilebuild.mathrun.questiongenerator;

import java.util.Random;

import com.ait.agilebuild.mathrun.model.QuestionDefinition;

public class generate3rdBeginner {
	public QuestionDefinition getQ(){
		QuestionDefinition Qd= new QuestionDefinition();
		Random random = new Random();
		int temp_firstValueA = random.nextInt(300)%(300-10+1) + 10;
		int temp_secondValueA = random.nextInt(99)%(99-10+1) + 10;
		int temp_firstValueB = random.nextInt(100)%(100-10+1) + 10;
		int temp_secondValueB = random.nextInt(100)%(100-10+1) + 10;
		Qd.setOperator(random.nextInt(2)%(2-1+1) + 1);
		switch(Qd.getOperator()){
				case 1: {
					if(temp_firstValueA + temp_secondValueA<=300){
						Qd.setFirst_value(temp_firstValueA);
						Qd.setSecond_value(temp_secondValueA);
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
						Qd.setCorrect_answer(temp_firstValueB + temp_secondValueB);
						return Qd;
					}else{
						return getQ();
					}
				}
				default: return getQ();
		}
	}
}
