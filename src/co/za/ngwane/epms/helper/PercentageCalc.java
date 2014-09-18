package co.za.ngwane.epms.helper;

import java.math.BigDecimal;

public class PercentageCalc {

	public static String getPercentage(float target, float actual) {

		@SuppressWarnings("unused")
		String result = "";
		String temp = "";
		float val = 0f;
		try {
			val = actual * 100 / target;
			val = round(val, 2);
			
			System.out.println("Answer = " + val);
			
			temp = String.valueOf(val);
			System.out.println("The Value is : = " + temp.substring(temp.indexOf('.')+1));
			
			BigDecimal somevalue = new BigDecimal(temp.substring(temp.indexOf('.')+1));
			if(somevalue.intValue() < 1){
				temp = temp.substring(0, temp.indexOf('.'));
				System.out.println("Final Score Less Than 1 = " + temp );
			}else{
				temp = String.valueOf(val);
				System.out.println("Final Score = " + temp );
			}
			

		} catch (Exception e) {
			result = "0";
		}
		return temp + "%";
	}

	public static float getPercentageValue(float target, float actual) {

		float val = 0f;
		try {
			val = actual * 100 / target;
			val = round(val, 2);

		} catch (Exception e) {
			val = 0;
		}
		return val;
	}

	public static float round(float rval, int rpl) {
		float p = (float) Math.pow(10, rpl);
		rval = rval * p;
		double tmp = Math.round(rval);
		return (float) tmp / p;
	}
	public static void main(String[] args){
		getPercentage(30, 11);
	}

}
