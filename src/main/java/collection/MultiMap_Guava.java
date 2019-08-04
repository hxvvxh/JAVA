package collection;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;

import Utils.HpUtils;

public class MultiMap_Guava {

	
	/**
	 * MultiMap 
	 * a -> [1, 2, 4]
	 * b -> 3 
	 * c -> 5 
	 * 
	 */
	/**
	 * 实现                                                       键行为类似                                                 值行为类似
	ArrayListMultimap           HashMap                    ArrayList
	HashMultimap                HashMap                     HashSet
	LinkedListMultimap*       LinkedHashMap*               LinkedList*
	LinkedHashMultimap**      LinkedHashMap                LinkedHashMap
	TreeMultimap                TreeMap                      TreeSet
	ImmutableListMultimap      ImmutableMap                ImmutableList
	ImmutableSetMultimap       ImmutableMap                 ImmutableSe
	 */
	
	@Test
	public void test() {
		/**
		 * Guava 的 Multimap 可以很容易地把一个键映射到多个值
		 * 不会有任何key对应这空集合，要么至少一个值，要么就不在map中
		 * 
		 * 一般不直接使用Multimap,都是使用ListMultimap,SetMultimap
		 * 
		 * Multimap<K, V>不是 Map<K,Collection>
		 * 
		 */
		Multimap<String,Integer> multimap=ArrayListMultimap.create();
		
		multimap.put("a", 1);
		multimap.put("a", 2);
		multimap.put("a", 3);
		multimap.put("b", 1);
		multimap.put("c", 1);
        
        /**
         * 相关方法
         */
		//asMap() ：返回map的视图 vaule值是collection集合的形式
        Map<String, Collection<Integer>> map=multimap.asMap();
        
        //集合形式返回键所对应的值视图  ,没有kay的话也会返回空集合
        //ListMultimap.get(key)返回 List，
        //SetMultimap.get(key)返回 Set
        Collection<Integer> getVaule=multimap.get("a");

        //放入单个元素
        multimap.put("d", 10);
        
        //放入list所有元素
        ArrayList<Integer> list= new ArrayList<Integer>();
        multimap.putAll("e",list);
		
        //移除key中的单个vaule/移除key所有元素
        multimap.remove("a", 1);
        multimap.removeAll("e");
        
        //移除key为b的所有vaule值，并使用list填充value
        multimap.replaceValues("b", list);
		
        
        //entries()返回的是key-vaule单个键映射：包含重复元素
        Collection<Entry<String, Integer>> coll=multimap.entries();
		for (Entry<String, Integer> entry1 : coll) {
			System.out.println("entries()"+entry1.getKey()+"*****"+entry1.getValue());
		}
		
		
		//返回map中所有不同的key
		Set<String> setString=multimap.keySet();
		
		//返回map中所有的key，以multiset的形式来表示相同key的个数
		Multiset<String> multiset=multimap.keys();
		
		
		for (com.google.common.collect.Multiset.Entry<String> entry : multiset.entrySet()) {
			System.out.println("keys()"+entry.getElement()+"*******"+entry.getCount());
		}
		
		//包含 Multimap 中的所有值 返回Collection<T>的形式（不按key区分）
		Collection<Integer> collIn=multimap.values();
		for (Integer integer : collIn) {
			System.out.println("values()"+integer);
		}
		
		
		//包含 Multimap 中的所有值 返回Collection<Collection<T>>的形式（按key区分）
		Collection<Collection<Integer>> collva=multimap.asMap().values();
		
		for (Collection<Integer> collection : collva) {
			for (Integer integer : collection) {
				System.out.println(".asMap().values()"+integer);
			}
			
			System.out.println("*********************");
		}
		
		//key-单个value，/所有vaule的个数
		multimap.size();
		//这个是所有key的个数
		multimap.keySet().size();
				
	}
	
	/**
	 * Multimaps
	 */
	@Test
	public void Test2() {
		
		HashMultimap<String,Integer> multimaps=HashMultimap.create();
		
		/**
		 * 相关方法
		 */
		multimaps.putAll("b", Ints.asList(2, 4, 6));
		multimaps.putAll("a", Ints.asList(4, 2, 1));
		multimaps.putAll("c", Ints.asList(2, 5, 3));
		HpUtils.outMap(multimaps, "创建的map");
		//创建指定的multimap的翻转
		HashMultimap<Integer,String> multimap2=Multimaps.invertFrom(multimaps, HashMultimap.create());

		HpUtils.outMap(multimap2, "Multimaps.invertFromMultimap toInvert,Multimap dest");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
