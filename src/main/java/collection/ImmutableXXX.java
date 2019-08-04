package collection;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Sets;

public class ImmutableXXX {
    /**
     * ImmutableXXX 不可变集合，在某些特定的情况下不可变集合比可变集合更安全可靠
     */
	
	/**
	 * 关联可变集合和不可变集合
	 * 可变集合接口 属于 JDK 还是 Guava 不可变版本
        
       Collection JDK ImmutableCollection
       List JDK ImmutableList
       Set JDK ImmutableSet
       SortedSet/NavigableSet JDK ImmutableSortedSet
       Map JDK ImmutableMap
       SortedMap JDK ImmutableSortedMap


       Multiset Guava ImmutableMultiset
       SortedMultiset Guava ImmutableSortedMultiset
       Multimap Guava ImmutableMultimap
       ListMultimap Guava ImmutableListMultimap
       SetMultimap Guava ImmutableSetMultimap
       BiMap Guava ImmutableBiMap
       ClassToInstanceMap Guava ImmutableClassToInstanceMap
       Table Guava ImmutableTable
	 */
	
	
	
	
	public void Test() {
		/**
		 * ImmutableXXX 不可变的集合
		 * 所以的Guava的不可变集合都是不允许存在null的
		 */
		
		
		//不可变集合使用set为例来描述相关方法和创建
		Set set=Sets.newHashSet();
		
		//不可变集合：创建方式1
		ImmutableSet.<String>builder()
		            .add("1")
		            .addAll(set)
		            .build();
		//不可变集合：创建方式2
		ImmutableSet.copyOf(set);
		
		//不可变集合：创建方式3
        ImmutableSet.of("a","b","c");
        
        //有序不可变集合来说，排序是在构造集合的时候完成的，
        ImmutableSortedSet sortedSet=ImmutableSortedSet.of("a","c","b","d");
		
        /**
         * 所有不可变集合都有一个 asList()方法提供 ImmutableList 视图，来帮助你用列表形式方便地读取集合元素
         * 在底层集合支持的情况下，它总是使用高效的 contains 方法
         */
        
        //sortedSet.asList().get(k)从 ImmutableSortedSet 中读取第 k 个最小元素。
        sortedSet.asList().get(2);
        
        
        
		                    
	}
}
