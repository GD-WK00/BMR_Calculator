
public class Calculations {
	
	int finalCaloriesResult = 0;
	int finalProteinCount = 0;
	int finalFatCount = 0;
	int finalCarbohydratesCount = 0;
	
	Calculations(String userHeight, String userWeight,String userAge,int gender, int activity, int goal) {
		
		double ageDoubleType = Double.parseDouble(userAge);
		double weightDoubleType = Double.parseDouble(userWeight);
		double heighteDoubleType = Double.parseDouble(userHeight);
		double result = 0;
		
		int weightIntType = Integer.parseInt(userWeight);
		
		if(gender==0) {
			result =  (66 + (13.7 * weightDoubleType) + (5 * heighteDoubleType) - (6.8 * ageDoubleType)) * ActivityType(activity) + GoalType(goal);
		}
		else {
			result =  (655 + (9.6 * weightDoubleType) + (1.8 * heighteDoubleType) - (4.7 * ageDoubleType)) * ActivityType(activity) + GoalType(goal);
		}
		
		finalCaloriesResult = (int) Math.round(result);
		finalProteinCount = 2 * weightIntType;
		finalFatCount = (int) Math.round((result*0.25)/9);
		finalCarbohydratesCount = (int) Math.round((result-(finalProteinCount*4)-(finalFatCount*9))/4);
	}
	
	double ActivityType(int activity) {
		
		double activityConstant = 0;
		
		switch(activity) {
		case 0:
			activityConstant = 1.2;
			break;
		case 1:
			activityConstant = 1.375;
			break;
		case 2:
			activityConstant = 1.55;
			break;
		case 3:
			activityConstant = 1.725;
			break;
		}
		
		return activityConstant;
	}
	
	double GoalType(int goal) {
		
		double goalConstant = 0;
		
		switch(goal) {
		case 0:
			goalConstant = -300;
			break;
		case 1:
			goalConstant = 0;
			break;
		case 2:
			goalConstant = 300;
			break;
		}
		
		return goalConstant;
	}
	
	protected int FinalCaloriesResult() {	
		return finalCaloriesResult;
	}
	protected int FinalProteinResult() {	
		return finalProteinCount;
	}
	protected int FinalFatResult() {	
		return finalFatCount;
	}
	protected int FinalCarbohydratesResult() {	
		return finalCarbohydratesCount;
	}
}

