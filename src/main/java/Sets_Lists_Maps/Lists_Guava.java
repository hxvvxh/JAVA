package Sets_Lists_Maps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class Lists_Guava {

	
	
	/**
	 * Lists
	 * ArrayList 
	 * LinkedList
	 */
	@org.junit.Test
	public void Test() {
		/**
		 * Lists
		 * 方法：partition 分割
		 *     transform 指定类型转换!!!重点了解
		 */
		//创建list的
		ArrayList<String> arrayList=Lists.newArrayList();
		LinkedList<String> linkedList=Lists.newLinkedList();
		//创建指定大小的list
		Lists.newArrayListWithCapacity(100);
		Lists.newArrayListWithExpectedSize(100);
		
		//按指定大小去分割list
		List<List<String>> listParttion=Lists.partition(arrayList, 3);
		//翻转list
		List<String> reverseList=Lists.reverse(arrayList);
		outList(reverseList);
		
		ArrayList<hp> list2=createHp();
		
		//TODO  重点了解transform

		//对指定类型的list进行转换
		List<String> listString=Lists.transform(list2,new Function<hp, String>() {

			public String apply(hp input) {
				return input.getUsername();
			}
			
		});
		
		for (String string : listString) {
			System.out.println(string);
		}
		
		List<qing> lq=Lists.transform(list2, new Function<hp, qing>() {

			@Override
			public qing apply(hp input) {
				qing q=new qing();
				q.setName(input.getUsername());
				return q;
			}
			
		});
		
		for (qing q : lq) {
			System.out.println("");
			System.out.print("*************Lists.transform()******"+q.getName());
		}
				
	}
	
	
	
	
	public ArrayList<hp> createHp() {
		ArrayList<hp> list=Lists.newArrayList();
		hp h1=new hp();
		hp h2=new hp();
		hp h3=new hp();
		h1.setUsername("a");
		h2.setUsername("b");
		h3.setUsername("c");
		list.add(h1);
		list.add(h2);
		list.add(h3);
		return list;
		
		
	}
	
	public  void outList(List<String> list) {
		list.forEach(c->{
			System.out.println(c);
		});
	}
}

class hp{
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}

class qing{
	private String  name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
