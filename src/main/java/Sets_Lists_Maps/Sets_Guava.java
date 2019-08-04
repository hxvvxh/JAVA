package Sets_Lists_Maps;

import java.util.Set;

import com.google.common.collect.Sets;

public class Sets_Guava {

	/**
	 * Sets 的相关方法
	 * TODO ***************重点了解****************
	 */
	/**
	 * HashSet
	 * LinkedHashSet 
	 * TreeSet
	 */
	
	
	@org.junit.Test
	public void Test() {
		Set set1=CreateSet(2);
		set1.add(10);
		outSet(set1, "set1");
		Set set2=CreateSet(4);
		set2.add(11);
		outSet(set2, "set2");
		
		//copy 进一个可变集合
		Set set3=Sets.newCopyOnWriteArraySet(set2);
		outSet(set3,"set3");
		
		//两集合的并集合
		Set setUnion=Sets.union(set1, set2);
		outSet(setUnion, "union()-并集合");
		
		//两集合的交集合
		Set setinter=Sets.intersection(set1, set2);
		outSet(setinter, "intersection()");
		
		//A-B的差集
		Set setDiff=Sets.difference(set1, set2);
		outSet(setDiff, "difference()");
		
		//A并B- A交B
		Set setDiff2=Sets.symmetricDifference(set1, set2);
		outSet(setDiff2, "symmetricDifference()");
		
	}
	
	public Set<Integer> CreateSet(int i) {
		Set set=Sets.newHashSet();
		for(int j=0;j<i;j++) {
			set.add(j);
		}
		return set;
	}
	
	public void outSet(Set<Integer> set,String message) {
		System.out.println("***********"+message+"**********");
		set.forEach( c->{
			System.out.println(c);
		});
	}
}
