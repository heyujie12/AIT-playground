package com.ait.agilebuild.mathrun.questiongenerator;

import java.util.Random;

import com.ait.agilebuild.mathrun.model.QuestionDefinition;

public class generate2ndBeginner {

	
	public QuestionDefinition getQ(){
		QuestionDefinition Qd = new QuestionDefinition();
		Qd.setDifficulty_level(1);
		Random random = new Random();
		Qd.setFirst_value(random.nextInt(99)%(99-10+1) + 10) ;
		Qd.setSecond_value(random.nextInt(10)%(10-0+1) + 0);
		Qd.setOperator(random.nextInt(2)%(2-1+1) + 1);
		if(Qd.getFirst_value() + Qd.getSecond_value()<100 && Qd.getFirst_value() - Qd.getSecond_value()>0){
			switch(Qd.getOperator()){
				case 1: Qd.setCorrect_answer(Qd.getFirst_value() + Qd.getSecond_value());Qd.setOperatorCh("+");return Qd;
				case 2: Qd.setCorrect_answer(Qd.getFirst_value() - Qd.getSecond_value());Qd.setOperatorCh("-");return Qd;
				default: return getQ();
				}
		}else{
			return getQ();
		}
	}
}
