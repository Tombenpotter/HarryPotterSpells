package hps.common.util;

import java.util.ArrayList;

public class JavaHelper {
	public static Object[] listToArray(ArrayList list){
		Object[] array = new Object[list.size()];
		for(int i = 0; i < array.length; i++)
			array[i] = list.get(i);
		return array;
	}
}
