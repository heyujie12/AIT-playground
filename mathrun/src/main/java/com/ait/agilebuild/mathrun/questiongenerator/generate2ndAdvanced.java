package com.ait.agilebuild.mathrun.questiongenerator;

import java.util.Random;

import com.ait.agilebuild.mathrun.model.QuestionDefinition;

public class generate2ndAdvanced {
	
	public QuestionDefinition getQ(){
		QuestionDefinition Qd= new QuestionDefinition();
		Qd.setDifficulty_level(3);
		Random random = new Random();
		int temp_firstValueA = random.nextInt(99)%(99-10+1) + 10;
		int temp_secondValueA = random.nextInt(99)%(99-10+1) + 10;
		int temp_firstValueB = random.nextInt(10)%(10-1+1) + 1;
		int temp_secondValueB = random.nextInt(10)%(10-1+1) + 1;
		Qd.setOperator(random.nextInt(3)%(3-1+1) + 1);
		switch(Qd.getOperator()){
			case 1:{
				if(temp_firstValueA + temp_secondValueA<=200){
					Qd.setFirst_value(temp_firstValueA);
					Qd.setOperatorCh("+");
					Qd.setSecond_value(temp_secondValueA);
					Qd.setCorrect_answer(temp_firstValueA + temp_secondValueA);
					return Qd;
				}else{
					return getQ();
				}
			}
			case 2:{
				if(temp_firstValueA - temp_secondValueA>0){
					Qd.setFirst_value(temp_firstValueA);
					Qd.setOperatorCh("-");
					Qd.setSecond_value(temp_secondValueA);
					Qd.setCorrect_answer(temp_firstValueA - temp_secondValueA);
					return Qd;
				}else{
					return getQ();
				}
			}
			case 3:{
					Qd.setFirst_value(temp_firstValueB);
					Qd.setSecond_value(temp_secondValueB);
					Qd.setOperatorCh("*");
					Qd.setCorrect_answer(temp_firstValueB * temp_secondValueB);
					return Qd;
			}
			default : return getQ();
		}
		
	}
}
