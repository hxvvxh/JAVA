package Java_Set_List_Map;

import java.util.EnumSet;

public class EnumSet_java {

	
	/**
	 * EnumSet
	 * EnumSet这是一个用来操作Enum的集合，是一个抽象类，
	 * 它有两个继承类：JumboEnumSet和RegularEnumSet
	 */
	
	@org.junit.Test
	public void Test() {
		
		//创建一个包含了枚举类所有元素的EnumSet集合
		EnumSet<pmtType> enumSet=EnumSet.allOf(pmtType.class);
	    outSet(enumSet, "allOf()");
		
		//创建有指定枚举类的空enumSet集合
		EnumSet enumSet2=EnumSet.noneOf(pmtType.class);
		outSet(enumSet2, "noneOf()");
		
		enumSet2.add(pmtType.ODPT);
		enumSet2.add(pmtType.SCHD);
		outSet(enumSet2, "add之后");
		
		enumSet2.remove(pmtType.ODPT);
		outSet(enumSet2, "remove之后");
		
		//创建一个有指定枚举类从from 到to 范围内的enumSet
		EnumSet<pmtType>  enumSet3=EnumSet.range(pmtType.SCHD, pmtType.二);
		outSet(enumSet3, "range()");
		
	}
	
	public void outSet(EnumSet<pmtType> set,String message) {
		System.out.println("***********"+message+"**********");
		set.forEach(c->{
			System.out.println(c.getCode());
		});
	}
}
