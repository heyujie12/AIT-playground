package com.ait.agilebuild.mathrun.impl;

import java.util.Random;

import com.ait.agilebuild.mathrun.api.IQuestionsGenerator;
import com.ait.agilebuild.mathrun.model.QuestionDefinition;
import com.ait.agilebuild.mathrun.questiongenerator.generate2ndAdvanced;
import com.ait.agilebuild.mathrun.questiongenerator.generate2ndBeginner;
import com.ait.agilebuild.mathrun.questiongenerator.generate2ndMedium;
import com.ait.agilebuild.mathrun.questiongenerator.generate3rdAdvanced;
import com.ait.agilebuild.mathrun.questiongenerator.generate3rdBeginner;
import com.ait.agilebuild.mathrun.questiongenerator.generate3rdMedium;
import com.ait.agilebuild.mathrun.questiongenerator.generate4thAdvanced;
import com.ait.agilebuild.mathrun.questiongenerator.generate4thBeginner;
import com.ait.agilebuild.mathrun.questiongenerator.generate4thMedium;
import com.ait.agilebuild.mathrun.questiongenerator.generate5thAdvanced;
import com.ait.agilebuild.mathrun.questiongenerator.generate5thBeginner;
import com.ait.agilebuild.mathrun.questiongenerator.generate5thMedium;

public class QuestionsGenerator implements IQuestionsGenerator{

	QuestionDefinition Qd;
	Random random = new Random();
	
	
	public QuestionDefinition getQuestion(int difficulty_level) {
		switch(difficulty_level){
		case 1: return new generate2ndBeginner().getQ();
		case 2:	return new generate2ndMedium().getQ();
		case 3: return new generate2ndAdvanced().getQ();
		case 4: return new generate3rdBeginner().getQ();
		case 5:	return new generate3rdMedium().getQ();
		case 6:	return new generate3rdAdvanced().getQ();
		case 7: return new generate4thBeginner().getQ();
		case 8: return new generate4thMedium().getQ();
		case 9: return new generate4thAdvanced().getQ();
		case 10:return new generate5thBeginner().getQ();
		case 11:return new generate5thMedium().getQ();
		case 12:return new generate5thAdvanced().getQ();
		}
		return Qd;
	}
}

//
//	public void create_2ndClassBeginner(){
//		Qd.setFirst_value(random.nextInt(99)%(99-10+1) + 10) ;
//		Qd.setSecond_value(random.nextInt(10)%(10-0+1) + 0);
//		Qd.setOperator(random.nextInt(2)%(2-1+1) + 1);
//		if(Qd.getFirst_value() + Qd.getSecond_value()<100 && Qd.getFirst_value() - Qd.getSecond_value()>0){
//			switch(Qd.getOperator()){
//				case 1: Qd.setCorrect_answer(Qd.getFirst_value() + Qd.getSecond_value());
//				case 2: Qd.setCorrect_answer(Qd.getFirst_value() - Qd.getSecond_value());
//				default: create_2ndClassBeginner();
//				}
//		}else{
//			create_2ndClassBeginner();
//		}
//	}
//	
//	
//	public void create_2ndClassMedium(){
//		Qd.setFirst_value(random.nextInt(99)%(99-10+1) + 10);
//		Qd.setSecond_value(random.nextInt(99)%(99-10+1) + 10);
//		Qd.setOperator(random.nextInt(2)%(2-1+1) + 1);
//		if(Qd.getFirst_value() + Qd.getSecond_value()<=100 && Qd.getFirst_value() - Qd.getSecond_value()>0){
//			switch(Qd.getOperator()){
//				case 1: Qd.setCorrect_answer(Qd.getFirst_value() + Qd.getSecond_value());
//				case 2: Qd.setCorrect_answer(Qd.getFirst_value() - Qd.getSecond_value());
//				default: create_2ndClassMedium();
//				}
//		}else{
//			create_2ndClassMedium();
//		}
//		
//	}
//	
//	
//	public void create_2ndClassAdvanced(){
//		int temp_firstValueA = random.nextInt(99)%(99-10+1) + 10;
//		int temp_secondValueA = random.nextInt(99)%(99-10+1) + 10;
//		int temp_firstValueB = random.nextInt(10)%(10-1+1) + 1;
//		int temp_secondValueB = random.nextInt(10)%(10-1+1) + 1;
//		Qd.setOperator(random.nextInt(3)%(3-1+1) + 1);
//		switch(Qd.getOperator()){
//			case 1:{
//				if(temp_firstValueA + temp_secondValueA<=200){
//					Qd.setFirst_value(temp_firstValueA);
//					Qd.setSecond_value(temp_secondValueA);
//					Qd.setCorrect_answer(temp_firstValueA + temp_secondValueA);
//				}else{
//					create_2ndClassAdvanced();
//				}
//			}
//			case 2:{
//				if(temp_firstValueA - temp_secondValueA>0){
//					Qd.setFirst_value(temp_firstValueA);
//					Qd.setSecond_value(temp_secondValueA);
//					Qd.setCorrect_answer(temp_firstValueA - temp_secondValueA);
//				}else{
//					create_2ndClassAdvanced();
//				}
//			}
//			case 3:{
//					Qd.setFirst_value(temp_firstValueB);
//					Qd.setSecond_value(temp_secondValueB);
//					Qd.setCorrect_answer(temp_firstValueB * temp_secondValueB);
//			}
//			default : create_2ndClassAdvanced();
//		}
//		
//	}
//	
//	public void create_3rdClassBeginner(){
//		int temp_firstValueA = random.nextInt(300)%(300-10+1) + 10;
//		int temp_secondValueA = random.nextInt(99)%(99-10+1) + 10;
//		int temp_firstValueB = random.nextInt(100)%(100-10+1) + 10;
//		int temp_secondValueB = random.nextInt(100)%(100-10+1) + 10;
//		Qd.setOperator(random.nextInt(2)%(2-1+1) + 1);
//		switch(Qd.getOperator()){
//				case 1: {
//					if(temp_firstValueA + temp_secondValueA<=300){
//						Qd.setFirst_value(temp_firstValueA);
//						Qd.setSecond_value(temp_secondValueA);
//						Qd.setCorrect_answer(temp_firstValueA + temp_secondValueA);
//					}else{
//						create_3rdClassBeginner();
//					}
//				}
//				case 2: {
//					if(temp_firstValueB - temp_secondValueB>0){
//						Qd.setFirst_value(temp_firstValueB);
//						Qd.setSecond_value(temp_secondValueB);
//						Qd.setCorrect_answer(temp_firstValueB + temp_secondValueB);
//					}else{
//						create_3rdClassBeginner();
//					}
//				}
//				default: create_3rdClassBeginner();
//		}
//	}
//	
//	public void create_3rdClassMedium(){
//		int temp_firstValueA = random.nextInt(600)%(600-10+1) + 10;
//		int temp_secondValueA = random.nextInt(100)%(100-10+1) + 10;
//		int temp_firstValueB = random.nextInt(100)%(100-10+1) + 10;
//		int temp_secondValueB = random.nextInt(100)%(100-10+1) + 10;
//		int temp_firstValueC = random.nextInt(10)%(10-1+1) + 1;
//		int temp_secondValueC = random.nextInt(10)%(10-1+1) + 1;
//		Qd.setOperator(random.nextInt(3)%(3-1+1) + 1);
//		switch(Qd.getOperator()){
//				case 1: {
//					if(temp_firstValueA + temp_secondValueA<=600){
//						Qd.setFirst_value(temp_firstValueA);
//						Qd.setSecond_value(temp_secondValueA);
//						Qd.setCorrect_answer(temp_firstValueA + temp_secondValueA);
//					}else{
//						create_3rdClassMedium();
//					}
//				}
//				case 2: {
//					if(temp_firstValueB - temp_secondValueB>0){
//						Qd.setFirst_value(temp_firstValueB);
//						Qd.setSecond_value(temp_secondValueB);
//						Qd.setCorrect_answer(temp_firstValueB + temp_secondValueB);
//					}else{
//						create_3rdClassMedium();
//					}
//				}
//				case 3: {
//						Qd.setFirst_value(temp_firstValueC);
//						Qd.setSecond_value(temp_secondValueC);
//						Qd.setCorrect_answer(temp_firstValueC * temp_secondValueC);
//				}
//				default: create_3rdClassMedium();
//		}
//	}
//	
//	
//	public void create_3rdClassAdvanced(){
//		int temp_firstValueA = random.nextInt(600)%(600-10+1) + 10;
//		int temp_secondValueA = random.nextInt(600)%(600-10+1) + 10;
//		int temp_firstValueB = random.nextInt(100)%(100-10+1) + 10;
//		int temp_secondValueB = random.nextInt(100)%(100-10+1) + 10;
//		int temp_firstValueC = random.nextInt(100)%(100-1+1) + 1;
//		int temp_secondValueC = random.nextInt(10)%(10-1+1) + 1;
//		Qd.setOperator(random.nextInt(3)%(3-1+1) + 1);
//		switch(Qd.getOperator()){
//				case 1: {
//					if(temp_firstValueA + temp_secondValueA<=1000){
//						Qd.setFirst_value(temp_firstValueA);
//						Qd.setSecond_value(temp_secondValueA);
//						Qd.setCorrect_answer(temp_firstValueA + temp_secondValueA);
//					}else{
//						create_3rdClassAdvanced();
//					}
//				}
//				case 2: {
//					if(temp_firstValueB - temp_secondValueB>0){
//						Qd.setFirst_value(temp_firstValueB);
//						Qd.setSecond_value(temp_secondValueB);
//						Qd.setCorrect_answer(temp_firstValueB + temp_secondValueB);
//					}else{
//						create_3rdClassAdvanced();
//					}
//				}
//				case 3: {
//						Qd.setFirst_value(temp_firstValueC);
//						Qd.setSecond_value(temp_secondValueC);
//						Qd.setCorrect_answer(temp_firstValueC * temp_secondValueC);
//				}
//				default: create_3rdClassAdvanced();
//		}
//	}
//	
//	public void create_4thClassBeginner(){
//		int temp_firstValueA = random.nextInt(1000)%(1000-10+1) + 10;
//		int temp_secondValueA = random.nextInt(1000)%(1000-10+1) + 10;
//		int temp_firstValueB = random.nextInt(200)%(200-10+1) + 10;
//		int temp_secondValueB = random.nextInt(100)%(100-10+1) + 10;
//		int temp_firstValueC = random.nextInt(100)%(100-1+1) + 1;
//		int temp_secondValueC = random.nextInt(10)%(10-1+1) + 1;
//		Qd.setOperator(random.nextInt(3)%(3-1+1) + 1);
//		switch(Qd.getOperator()){
//				case 1: {
//					if(temp_firstValueA + temp_secondValueA<=1500){
//						Qd.setFirst_value(temp_firstValueA);
//						Qd.setSecond_value(temp_secondValueA);
//						Qd.setCorrect_answer(temp_firstValueA + temp_secondValueA);
//					}else{
//						create_4thClassBeginner();
//					}
//				}
//				case 2: {
//					if(temp_firstValueB - temp_secondValueB>0){
//						Qd.setFirst_value(temp_firstValueB);
//						Qd.setSecond_value(temp_secondValueB);
//						Qd.setCorrect_answer(temp_firstValueB + temp_secondValueB);
//					}else{
//						create_4thClassBeginner();
//					}
//				}
//				case 3: {
//						Qd.setFirst_value(temp_firstValueC);
//						Qd.setSecond_value(temp_secondValueC);
//						Qd.setCorrect_answer(temp_firstValueC * temp_secondValueC);
//				}
//				default: create_4thClassBeginner();
//		}
//	}
//	
//	public void create_4thClassMedium(){
//		int temp_firstValueA = random.nextInt(1000)%(1000-10+1) + 10;
//		int temp_secondValueA = random.nextInt(1000)%(1000-10+1) + 10;
//		int temp_firstValueB = random.nextInt(200)%(200-10+1) + 10;
//		int temp_secondValueB = random.nextInt(100)%(100-10+1) + 10;
//		int temp_firstValueC = random.nextInt(100)%(100-1+1) + 1;
//		int temp_secondValueC = random.nextInt(10)%(10-1+1) + 1;
//		int temp_firstValueD = random.nextInt(100)%(100-1+1) + 1;
//		int temp_secondValueD = random.nextInt(10)%(10-1+1) + 1;
//		Qd.setOperator(random.nextInt(4)%(4-1+1) + 1);
//		switch(Qd.getOperator()){
//				case 1: {
//					if(temp_firstValueA + temp_secondValueA<=2000){
//						Qd.setFirst_value(temp_firstValueA);
//						Qd.setSecond_value(temp_secondValueA);
//						Qd.setCorrect_answer(temp_firstValueA + temp_secondValueA);
//					}else{
//						create_4thClassMedium();
//					}
//				}
//				case 2: {
//					if(temp_firstValueB - temp_secondValueB>0){
//						Qd.setFirst_value(temp_firstValueB);
//						Qd.setSecond_value(temp_secondValueB);
//						Qd.setCorrect_answer(temp_firstValueB + temp_secondValueB);
//					}else{
//						create_4thClassMedium();
//					}
//				}
//				case 3: {
//						Qd.setFirst_value(temp_firstValueC);
//						Qd.setSecond_value(temp_secondValueC);
//						Qd.setCorrect_answer(temp_firstValueC * temp_secondValueC);
//				}
//				case 4:{
//						Qd.setFirst_value(temp_firstValueD);
//						Qd.setSecond_value(temp_secondValueD);
//						Qd.setCorrect_answer(temp_firstValueD / temp_secondValueD);
//						Qd.setRemainder(temp_firstValueD% temp_secondValueD);
//				}
//				default: create_4thClassMedium();
//		}
//	}
//	
//	
//	public void create_4thClassAdvanced(){
//		float temp_firstValueA = random.nextInt(1000)%(1000-10+1) + 10;
//		float temp_secondValueA = random.nextInt(1000)%(1000-10+1) + 10;
//		int temp_firstValueB = random.nextInt(200)%(200-10+1) + 10;
//		int temp_secondValueB = random.nextInt(100)%(100-10+1) + 10;
//		int temp_firstValueC = random.nextInt(500)%(500-1+1) + 1;
//		int temp_secondValueC = random.nextInt(10)%(10-1+1) + 1;
//		int temp_firstValueD = random.nextInt(100)%(100-1+1) + 1;
//		int temp_secondValueD = random.nextInt(10)%(10-1+1) + 1;
//		Qd.setOperator(random.nextInt(4)%(4-1+1) + 1);
//		switch(Qd.getOperator()){
//		case 1: {
//			if(temp_firstValueA/100 + temp_secondValueA/100 <=10){
//				Qd.setFirst_value(temp_firstValueA/100);
//				Qd.setSecond_value(temp_secondValueA/100);
//				Qd.setCorrect_answer(temp_firstValueA/100 + temp_secondValueA/100);
//			}else{
//				create_4thClassAdvanced();
//			}
//		}
//		case 2: {
//			if(temp_firstValueB - temp_secondValueB>0){
//				Qd.setFirst_value(temp_firstValueB);
//				Qd.setSecond_value(temp_secondValueB);
//				Qd.setCorrect_answer(temp_firstValueB + temp_secondValueB);
//			}else{
//				create_4thClassAdvanced();
//			}
//		}
//		case 3: {
//				Qd.setFirst_value(temp_firstValueC);
//				Qd.setSecond_value(temp_secondValueC);
//				Qd.setCorrect_answer(temp_firstValueC * temp_secondValueC);
//		}
//		case 4:{
//				Qd.setFirst_value(temp_firstValueD);
//				Qd.setSecond_value(temp_secondValueD);
//				Qd.setCorrect_answer(temp_firstValueD / temp_secondValueD);
//				Qd.setRemainder(temp_firstValueD% temp_secondValueD);
//		}
//		default: create_4thClassAdvanced();
//		}
//	}
//	
//	public void create_5thClassBeginner(){
//		int temp_firstValueA = random.nextInt(1500)%(1500-10+1) + 10;
//		int temp_secondValueA = random.nextInt(1500)%(1500-10+1) + 10;
//		int temp_firstValueB = random.nextInt(300)%(300-10+1) + 10;
//		int temp_secondValueB = random.nextInt(100)%(100-10+1) + 10;
//		int temp_firstValueC = random.nextInt(100)%(100-1+1) + 1;
//		int temp_secondValueC = random.nextInt(10)%(10-1+1) + 1;
//		int temp_firstValueD = random.nextInt(100)%(100-1+1) + 1;
//		int temp_secondValueD = random.nextInt(10)%(10-1+1) + 1;
//		Qd.setOperator(random.nextInt(4)%(4-1+1) + 1);
//		switch(Qd.getOperator()){
//				case 1: {
//					if(temp_firstValueA + temp_secondValueA<=2000){
//						Qd.setFirst_value(temp_firstValueA);
//						Qd.setSecond_value(temp_secondValueA);
//						Qd.setCorrect_answer(temp_firstValueA + temp_secondValueA);
//					}else{
//						create_5thClassBeginner();
//					}
//				}
//				case 2: {
//					if(temp_firstValueB - temp_secondValueB>0){
//						Qd.setFirst_value(temp_firstValueB);
//						Qd.setSecond_value(temp_secondValueB);
//						Qd.setCorrect_answer(temp_firstValueB + temp_secondValueB);
//					}else{
//						create_5thClassBeginner();
//					}
//				}
//				case 3: {
//						Qd.setFirst_value(temp_firstValueC);
//						Qd.setSecond_value(temp_secondValueC);
//						Qd.setCorrect_answer(temp_firstValueC * temp_secondValueC);
//				}
//				case 4:{
//						Qd.setFirst_value(temp_firstValueD);
//						Qd.setSecond_value(temp_secondValueD);
//						Qd.setCorrect_answer(temp_firstValueD / temp_secondValueD);
//						Qd.setRemainder(temp_firstValueD% temp_secondValueD);
//				}
//				default: create_5thClassBeginner();
//		}
//	}
//	
//	
//	public void create_5thClassMedium(){
//		float temp_firstValueA = random.nextInt(1500)%(1500-10+1) + 10;
//		float temp_secondValueA = random.nextInt(1500)%(1500-10+1) + 10;
//		int temp_firstValueB = random.nextInt(500)%(500-10+1) + 10;
//		int temp_secondValueB = random.nextInt(100)%(100-10+1) + 10;
//		int temp_firstValueC = random.nextInt(500)%(500-1+1) + 1;
//		int temp_secondValueC = random.nextInt(10)%(10-1+1) + 1;
//		int temp_firstValueD = random.nextInt(100)%(100-1+1) + 1;
//		int temp_secondValueD = random.nextInt(10)%(10-1+1) + 1;
//		Qd.setOperator(random.nextInt(4)%(4-1+1) + 1);
//		switch(Qd.getOperator()){
//				case 1: {
//					if(temp_firstValueA/100 + temp_secondValueA/100 <=10){
//						Qd.setFirst_value(temp_firstValueA);
//						Qd.setSecond_value(temp_secondValueA);
//						Qd.setCorrect_answer(temp_firstValueA + temp_secondValueA);
//					}else{
//						create_5thClassMedium();
//					}
//				}
//				case 2: {
//					if(temp_firstValueB - temp_secondValueB>0){
//						Qd.setFirst_value(temp_firstValueB);
//						Qd.setSecond_value(temp_secondValueB);
//						Qd.setCorrect_answer(temp_firstValueB + temp_secondValueB);
//					}else{
//						create_5thClassMedium();
//					}
//				}
//				case 3: {
//						Qd.setFirst_value(temp_firstValueC);
//						Qd.setSecond_value(temp_secondValueC);
//						Qd.setCorrect_answer(temp_firstValueC * temp_secondValueC);
//				}
//				case 4:{
//						Qd.setFirst_value(temp_firstValueD);
//						Qd.setSecond_value(temp_secondValueD);
//						Qd.setCorrect_answer(temp_firstValueD / temp_secondValueD);
//						Qd.setRemainder(temp_firstValueD% temp_secondValueD);
//				}
//				default: create_5thClassMedium();
//		}
//	}
//	
//	public void create_5thClassAdvanced(){
//		float temp_firstValueA = random.nextInt(1500)%(1500-10+1) + 10;
//		float temp_secondValueA = random.nextInt(1500)%(1500-10+1) + 10;
//		int temp_firstValueB = random.nextInt(1000)%(1000-10+1) + 10;
//		int temp_secondValueB = random.nextInt(500)%(500-10+1) + 10;
//		int temp_firstValueC = random.nextInt(1000)%(1000-1+1) + 1;
//		int temp_secondValueC = random.nextInt(10)%(10-1+1) + 1;
//		int temp_firstValueD = random.nextInt(100)%(100-1+1) + 1;
//		int temp_secondValueD = random.nextInt(10)%(10-1+1) + 1;
//		Qd.setOperator(random.nextInt(4)%(4-1+1) + 1);
//		switch(Qd.getOperator()){
//				case 1: {
//						Qd.setFirst_value(temp_firstValueA/100);
//						Qd.setSecond_value(temp_secondValueA/100);
//						Qd.setCorrect_answer(temp_firstValueA/100 + temp_secondValueA/100);
//				}
//				case 2: {
//					if(temp_firstValueB - temp_secondValueB>0){
//						Qd.setFirst_value(temp_firstValueB);
//						Qd.setSecond_value(temp_secondValueB);
//						Qd.setCorrect_answer(temp_firstValueB + temp_secondValueB);
//					}else{
//						create_5thClassAdvanced();
//					}
//				}
//				case 3: {
//						Qd.setFirst_value(temp_firstValueC);
//						Qd.setSecond_value(temp_secondValueC);
//						Qd.setCorrect_answer(temp_firstValueC * temp_secondValueC);
//				}
//				case 4:{
//						Qd.setFirst_value(temp_firstValueD);
//						Qd.setSecond_value(temp_secondValueD);
//						Qd.setCorrect_answer(temp_firstValueD / temp_secondValueD);
//						Qd.setRemainder(temp_firstValueD% temp_secondValueD);
//				}
//				default: create_5thClassAdvanced();
//		}
//	}
//	
//	public QuestionDefinition getQuestion(){
//		return Qd;
//	}
//	
//}
