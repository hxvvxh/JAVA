package collection;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

public class ClassToInstanceMap_Guava {

	/**
	 * ClassToInstanceMap
	 * ：它的键是类型，而值是符合键所指类型的对象。
	 * 两个实现类
	 * MutableClassToInstanceMap 和 ImmutableClassToInstanceMap

	 */
	
	
	public void Test() {
		ClassToInstanceMap map=MutableClassToInstanceMap.create();
		
		/**
		 * 两个方法putInstance/getInstance
		 * 从而避免强制类型转换，同时保证了类型安全。
		 */
		map.putInstance(String.class, "1");
		map.putInstance(Integer.class, 1);
		
		map.getInstance(String.class);
		
		
		
	}
}
