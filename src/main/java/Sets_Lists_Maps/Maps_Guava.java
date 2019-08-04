package Sets_Lists_Maps;

import java.util.Map;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;

import Utils.HpUtils;

import com.google.common.collect.MapDifference.ValueDifference;

public class Maps_Guava {

	/**
	 * Maps
	 * TODO **************重点了解**************
	 */
     /**
      * HashMap
      * LinkedHashMap
      * EnumMap
      * 
      */

	
	
	@org.junit.Test
	public void Test() {
		Map map1 = CreatMap(2);
		map1.put(10, "10");
		map1.put(11, "22");
		OutMap(map1, "map1");
		Map map2 = CreatMap(4);
		map2.put(11, "11");
		OutMap(map2, "map2");
		
		//获取两个map想比较的MapDifference
		MapDifference<Integer,String> mapdiff=Maps.difference(map1, map2);
		
		//两个map都有的映射：key和value都匹配
		Map<Integer,String> mapcommon=mapdiff.entriesInCommon();
		OutMap(mapcommon, "entriesInCommon");
		
		//两个map有相同的key但是value不同
		Map<Integer, ValueDifference<String>> mapdiff2=mapdiff.entriesDiffering();
		System.out.println("********entriesDiffering()***********");
		mapdiff2.forEach((k,v)->{
			System.out.println("key:"+k);
			//获取左边map的value
			System.out.println("leftValue()"+v.leftValue());
			//获取右边map的value
			System.out.println("rightValue()"+v.rightValue());
		});
		
		//获取key中A-B的map
		Map mapLeft=mapdiff.entriesOnlyOnLeft();
		OutMap(mapLeft, "entriesOnlyOnLeft()");
		
		//获取key中B-A的map
		Map mapright=mapdiff.entriesOnlyOnRight();
		OutMap(mapright, "entriesOnlyOnRight()");
		
		
		

	}
	
	/**
	 * Maps 关于函数式编程
	 * google提供了map的函数式编程方法
	 * 这是java没有的 因为java只是提供了collection的相关函数式编程的方法
	 * 
	 * google支持的map函数式编程支持map sortmap Multimap
	 * 这里只举例map
	 * @param i
	 * @return
	 */
	@org.junit.Test
	public void Test2() {
		Map<Integer,String> map=HpUtils.createMap(3);
		HpUtils.outMap(map, "map创建");
		
		//过滤key
		Map mapfilkey=Maps.filterKeys(map, c->c.toString().equals("1"));
		HpUtils.outMap(mapfilkey, "Maps.filterKeys(map,表达式)");
		//过滤value
		Map mapfilvalue=Maps.filterValues(map, c->c.equals("1"));
		HpUtils.outMap(mapfilvalue, "Maps.filterValues(map,表达式)");
		
		map.put(11, "hp");
		//按照entry来进行过滤
		Map mapfilterEntries=Maps.filterEntries(map, c->c.getKey()==11 &&c.getValue().equals("hp"));
		HpUtils.outMap(mapfilterEntries, "Maps.mapfilterEntries(map,表达式)");
	
		//转换!会将符合条件的value更改成true，反之是false
	    Map maptrans=Maps.transformValues(map, c->c.length()!=2);
	    HpUtils.outMap(maptrans, "Maps.transformValues(map,表达式)");
	
	    //Maps中transformEntries()方法可以实现对map的特殊操作
	    //在transformEntries(k,v1,v2)  入参分别为k：key  v1：map的之前的value类型 v2:需要转化的value类型
	    //在新建的EntryTransformer类中覆盖了transformEntry方法可以实现对之前value值的特殊转化
	    Map<Integer, Integer> maptranEntries=
	    Maps.transformEntries(map,new EntryTransformer<Integer,String,Integer>(){
			@Override
			public Integer transformEntry(Integer key, String value) {
				// TODO Auto-generated method stub
				return Integer.valueOf(value+1);
			}
	    });
	    HpUtils.outMap(maptranEntries, "Maps.transformEntries(map,new EntryTransformer(){})");
	    
	}
	
	
	
	

	public Map CreatMap(int i) {
		Map<Integer, String> map = Maps.newHashMap();
		for (int j = 0; j < i; j++) {
			map.put(j, String.valueOf(j));
		}
		return map;
	}

	public void OutMap(Map<Integer, String> map, String message) {
		System.out.println("********"+message+"***********");
		map.forEach((k, v) -> {
			System.out.println("key:" + k + "value:" + v);
		});
	}

}
