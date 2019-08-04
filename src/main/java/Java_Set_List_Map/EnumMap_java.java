package Java_Set_List_Map;

import java.util.EnumMap;

public class EnumMap_java {
	
	/**
	 * EnumMap
	 * EnumMap从名字我们可以看出这个Map是给枚举类用的。它的key为枚举元素，value自定义
	 * 性能高
	 * 它的内部是用数组的数据结构来维护
	 */
	@org.junit.Test
	public void Test() {
		//定义枚举类map
		EnumMap<pmtType, Integer> enumMap=new EnumMap<>(pmtType.class);
		
		/**
		 * 相关方法
		 */
		//put方法的key只能存放定义的枚举类
		enumMap.put(pmtType.SCHD, 1);
		//这个方法是不对的
//		enumMap.put("SCHD", 2);
		//获取
		int i=enumMap.get(pmtType.SCHD);
		System.out.println(i);
		//删除
		enumMap.remove(pmtType.SCHD);
		
		enumMap.containsKey(pmtType.SCHD);
		enumMap.containsValue(1);
		enumMap.entrySet();
		enumMap.values();
	}
	

}
