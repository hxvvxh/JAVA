package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Multisets;

public class Multiset_Guava {

	/**
	 * MuitiSet:一个可允许主键重复的set集合
	 * 继承与JDK的Collection
	 * Multiset 不是 Map
	 * MuitiSet:不能保证顺序，但是元素可以重复
	 * 
	 * set :{   key1     - num
	 *          key2     - num
	 *          
	 * ag:  {   "acctnbr"      2
	 *          "acctloannbr"  3
	 */
	
	
	/**
	 * Multiset 中的元素计数只能是正数。任何元素的计数都不能为负，也不能是 0。
       multiset.size()返回集合的大小，等同于所有元素计数的总和
                 对于不重复元素的个数，应使用 elementSet().size()方法
       Multiset 支持直接增加、减少或设置元素的计数。setCount(elem, 0)等同于移除所有 elem。
                 对 multiset 中没有的元素，multiset.count(elem)始终返回 0

	 */
	
	@org.junit.Test
	public void Test() {

		// MuitiSet 只是接口，不可以直接去实例化
		/**
		 * Map         对应的 Multiset       是否支持 null 元素
           HashMap     HashMultiset               是
           TreeMap     TreeMultiset               是（如果 comparator 支持的话）
         LinkedHashMap LinkedHashMultiset         是
     ConcurrentHashMap ConcurrentHashMultiset     否
          ImmutableMap ImmutableMultiset          否

		 */
		
		
		//（1）HashMultiset  创建
		HashMultiset<String> hashset=HashMultiset.create();
		
		//添加元素
		hashset.add("q");hashset.add("q");
		hashset.add("q");hashset.add("q");
		hashset.add("p");hashset.add("p");
       	//返回一个有set所有元素的迭代器(包含重复的元素)
		Iterator<String> it=hashset.iterator();
	    
		//返回元素个数（包含重复元素）	
		int conut=hashset.size();
		System.out.println(conut);
		
		//返回元素个数（不包含重复元素）
		int c=hashset.elementSet().size();
		System.out.println(c);
		
		/**
		 * entrySet()--类似与map的entrySet()方法--不同之处就是返回的set集合是没有重复元素的
		 * Entry.getElement() 获取元素
		 * Entry.getCount()   获取个数
		 */
		Set<Entry<String>> entry=hashset.entrySet();
		for (Entry<String> entry2 : entry) {
			System.out.println(entry2.getElement()+""+entry2.getCount());
		}
		
		
		//elementSet()返回所有不重复元素的 Set，和 Map 的 keySet()类似
		Set<String> element=hashset.elementSet();
		for (String string : element) {
			System.out.println(string);	
		}
		
		//返回set中对象的数量
		int i=hashset.count("q");
		System.out.println(i);
		
		//(1)移除一个q
		hashset.remove("q");
		//(2)移除指定数量的q
		hashset.remove("q",2);
        
		//设置指定数量的元素 相等于是add 5个 ai
		hashset.setCount("ai", 5);
		
		//将集合全部添加到Multiset
		Set set=new HashSet();
		hashset.addAll(set);
		
		hashset.contains("a");
		hashset.isEmpty();
		hashset.toArray();
		hashset.clear();
	}
	
	/**
	 * Multisets
	 * 扩展方法
	 */
	public void Test2() {
		
		Multiset<String> multiset1=HashMultiset.create();
		Multiset<String> multiset2=HashMultiset.create();
		
		multiset1.add("a", 2);
		multiset2.add("a", 5);
		
		//multiset2是否包含multiset1的所有元素
		boolean b1=multiset2.containsAll(multiset1);
		//对 multiset1 中的重复元素，仅在 multiset2 中删除相同个数。
		Multisets.removeOccurrences(multiset2, multiset1);
		//取交集
		//和Sets的交集有本质上的区别Sets的入参为Set而Mulitset的入参是collector
		Multisets.intersection(multiset1, multiset2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
