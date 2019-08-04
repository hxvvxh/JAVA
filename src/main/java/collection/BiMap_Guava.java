package collection;

import java.util.StringTokenizer;

import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMap_Guava {

	/**
	 * BiMap 
	 * 双向map
	 * key:value 都必须是唯一的
	 * 
	 */
	
	/**
	 * BiMap的实现类

　　Key-Value Map Impl       Value-Key Map Imp             Corresponding BiMap
　　HashMap                 　　  HashMap                        HashBiMap
　　ImmutableMap           　　ImmutableMap                    ImmutableBiMap
　　EnumMap                　　  EnumMap                          EnumBiMap
　　EnumMap                 　　 HashMap                        EnumHashBiMap
	 */
	
	public void Test() {
		
		
		BiMap<String,Integer> bimap=HashBiMap.create();
		bimap.put("a", 1);
		bimap.put("b", 2);
		bimap.put("c", 3);
		//强制覆盖之前key的value值
		bimap.forcePut("c", 4);
		
		bimap.containsKey("a");
		bimap.containsValue(1);
		bimap.get("a");
		bimap.remove("a");
		bimap.remove("b", 2);
		
		
		//翻转双向map
		//另外一个关键点就是理解inverse方法，这个方法返回一个反转 后的BiMap
		//这个反转的map并不是一个新的map，而是一个视图，这意味着， 
        //你在这个反转后的map中的任何增删改操作都会影响原来的map
		BiMap<Integer, String> bimapver=bimap.inverse();
		
		
	}
}
class User{
	private String username;
	private Integer password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getPassword() {
		return password;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
	
	
}
