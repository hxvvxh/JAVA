package base;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

public class Ordering_Guava {
	/**
	 * 排序器Ordering
	 * 
	 * 不懂！！！！后续了解
	 */

	public void Test() {
        Ordering<Foo> ordering =Ordering.natural().nullsFirst().onResultOf(new Function<Foo,String>() {
			public String apply(Foo foo) {
				
				return foo.sortedBy;
			}
        	
        });
        
        
        
        
        
		
	}

}

class Foo {
	String sortedBy;
}
