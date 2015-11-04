package com.ait.agilebuild.mathrun.questiongenerator;

import java.util.Random;

import com.ait.agilebuild.mathrun.model.QuestionDefinition;

public class generate2ndMedium {
	
	public QuestionDefinition getQ(){
		QuestionDefinition Qd= new QuestionDefinition();
		Random random = new Random();
		Qd.setFirst_value(random.nextInt(99)%(99-10+1) + 10);
		Qd.setSecond_value(random.nextInt(99)%(99-10+1) + 10);
		Qd.setOperator(random.nextInt(2)%(2-1+1) + 1);
		if(Qd.getFirst_value() + Qd.getSecond_value()<=100 && Qd.getFirst_value() - Qd.getSecond_value()>0){
			switch(Qd.getOperator()){
				case 1: Qd.setCorrect_answer(Qd.getFirst_value() + Qd.getSecond_value());return Qd;
				case 2: Qd.setCorrect_answer(Qd.getFirst_value() - Qd.getSecond_value());return Qd;
				default: return getQ();
				}
		}else{
			return getQ();
		}
		
	}
}
