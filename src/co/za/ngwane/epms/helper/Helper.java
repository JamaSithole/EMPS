package co.za.ngwane.epms.helper;

import java.util.Date;
import java.util.logging.Logger;

public class Helper
{
	private static Logger logger = Logger.getLogger("co.za.tms.operation.Helper");

	public static final Date todaysDate = new java.util.Date();

	public static float addFloat(float val1, float val2)
	{
		float res = val1 + val2;
		return res;
	}

	public static float subFloat(float val1, float val2)
	{
		float res = val1 - val2;
		return res;
	}

	public static float multiFloat(float val1, float val2)
	{
		float res = val1 * val2;
		return res;
	}

	public static float divFloat(float val1, float val2)
	{
		float res = val1 / val2;
		return res;
	}

	public static float round(float rval, int rpl)
	{
		float p = (float) Math.pow(10, rpl);
		rval = rval * p;
		float tmp = Math.round(rval);
		return (float) tmp / p;
	}

}
