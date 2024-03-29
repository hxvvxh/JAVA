package NotGuava;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.collections4.map.LRUMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.MultiValueMap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimaps;

public class OthMap {
	
	/**
	 * TODO DualHashBidiMap可以通过key找到value，也可以通过value找到key
	 */
	public void testDualHashBidiMap(){
	    //双向map
	    BidiMap bidiMap = new DualHashBidiMap();
	    bidiMap.put("Ay", "Boy");
	    bidiMap.put("Al", "Girl");
	    System.out.println("Key-Value:Ay = " + bidiMap.get("Ay"));//Key-Value:Ay = Boy
	    System.out.println("Value-Key:Gril = " + bidiMap.getKey("Girl"));//Value-Key:Gril = Al
	}
	/**
	 * MultiMap：一个key不在是简单的指向一个对象，而是一组对象
	 */
	public void testMultiMap(){
	    //MultiHashMap已经废弃
//	    MultiMap giftMap = new MultiHashMap();
//	    giftMap.put("gift", "鲜花");
//	    giftMap.put("gift", "戒指");
//	    giftMap.put("gift", "伞");
//	    List list = (List) giftMap.get("gift");
//	    System.out.println(list);//[鲜花, 戒指, 伞]

	    MultiMap giftMap2 = new MultiValueMap();
	    giftMap2.put("gift", "鲜花");
	    giftMap2.put("gift", "戒指");
	    giftMap2.put("gift", "伞");
	    giftMap2.put("boy","ay");
	    giftMap2.put("girl","al");
	    List list2 = (List) giftMap2.get("gift");
	    List list3 = (List)giftMap2.get("boy");
	    System.out.println(list2);//[鲜花, 戒指, 伞]
	    System.out.println(list3);//[ay]

	}
	
	/**
	 * 固定大小map：LRUMap
	 * 
    1.put 当新增加一个集合元素对象，则表示该对象是最近被访问的
    2.get 操作会把当前访问的元素对象作为最近被访问的，会被移到链接表头
当执行containsKey和containsValue操作时，不会影响元素的访问情况。
	 */
	public void testLRUMap(){
	    LRUMap lruMap = new LRUMap(2);
	    //因为LRUMap是非线程安全，所以可以使用
	    // Collections.synchronizedMap(map)来保证线程安全
	    Map map = Collections.synchronizedMap(lruMap);
	    lruMap.put("boy", "ay");
	    lruMap.put("girl", "al");
	    lruMap.get("boy");//最近使用
	    lruMap.put("person", "person");
	    System.out.println(lruMap);//{boy=ay, person=person}
	}
	
	/**
	 * .多个关键字经过组合映射map：MultiKeyedMap
	 * /创建一个排序的map

MultiKeyMap.decorate(new LinkedMap()) creates an ordered map.
MultiKeyMap.decorate(new LRUMap()) creates an least recently used map.

MultiKeyMap.decorate(new ReferenceMap()) creates a garbage collector sensitive map.


	 */
	public void testMultiKeyMap(){
	      //初始化类
//	      MultiKeyMap multiKeyMap = MultiKeyMap.decorate(new LinkedMap());
		MultiKeyMap multiKeyMap = null ;
	      multiKeyMap.put(1,1,2,"112");
	      multiKeyMap.put(1,1,3,"113");
	      multiKeyMap.put(1,2,1,"121");
	      multiKeyMap.put(1,2,2,"122");
	      multiKeyMap.put(1,3,1,"131");
	      //查找一个值:由1，1，2这3个key可以获得唯一的value值
	      String value = (String)multiKeyMap.get(1,1,2);
	      System.out.println("value is : " + value);//value is : 112
	      String value3 = (String)multiKeyMap.get(2,1,1);
	      System.out.println("value3 is : " + value3);//value3 is : null
	      String value2 = (String)multiKeyMap.get(1,2,1);
	      System.out.println("value2 is " + value2);//value2 is 121
	      Object object1 = multiKeyMap.get(1);
	      System.out.println("object1 is : " + object1);//object1 is : null
	      Object object2 = multiKeyMap.get(1,2);
	      System.out.println("object2 is : " + object2);//object2 is : null
	  }
	
	
	/**
	 * 允许Key重复的Map：IdentityHashMap
	 * IdentityHashMap允许地址不同但内容相等作为key值，换句话说，在 IdentityHashMap 中，当且仅当 (k1==k2) 时，才认为两个键 k1 和 k2 相等
	 */
	public void testIdentityMap(){
	    class Boy{
	        private int id;
	        private String name;
	        public Boy(int id, String name) {
	            this.id = id;
	            this.name = name;
	        }
	        public int getId() {
	            return id;
	        }
	        public void setId(int id) {
	            this.id = id;
	        }
	        public String getName() {
	            return name;
	        }
	        public void setName(String name) {
	            this.name = name;
	        }
	        @Override
	        public String toString() {
	            return "Boy{" +
	                    "id=" + id +
	                    ", name='" + name + '\'' +
	                    '}';
	        }
	        @Override
	        public boolean equals(Object o) {
	            if (this == o) return true;
	            if (o == null || getClass() != o.getClass()) return false;
	            Boy boy = (Boy) o;
	            if (id != boy.id) return false;
	            return name != null ? name.equals(boy.name) : boy.name == null;
	        }
	        @Override
	        public int hashCode() {
	            int result = id;
	            result = 31 * result + (name != null ? name.hashCode() : 0);
	            return result;
	        }
	    }
	    //初始化
	    IdentityMap identityMap = new IdentityMap();
	    //key是相同的boy对象，内存地址不同，但是内容相同
	    identityMap.put(new Boy(1,"ay"),"ay");
	    identityMap.put(new Boy(1,"ay"),"al");
	    System.out.println(identityMap);//{Boy{id=1, name='ay'}=al, Boy{id=1, name='ay'}=ay}
	    //初始化正常map
	    Map map = new HashedMap();
	    //因为我们有重写hashCode方法和toString方法
	    map.put(new Boy(1,"ay"),"ay");
	    map.put(new Boy(1,"ay"),"al");
	    System.out.println(map);//{Boy{id=1, name='ay'}=al}
	}
}
