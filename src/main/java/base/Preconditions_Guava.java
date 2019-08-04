package base;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class Preconditions_Guava {

	
	
	
	@org.junit.Test
	public void Test() {
		/**
		 * 检查 boolean 是否为 true，用来检查传递给方法的参数。
		 * 检查失败时抛出IllegalArgumentException
		 * 返回值：void
		 */
		
		 Preconditions.checkArgument(true);		
		 
		 /**
		  * 检查传入的参数是否为null
		  * 检查失败时抛出NullPointerException
		  * 返回值：Object 入参值
		  */
		 List list=Lists.newArrayList();
		 Preconditions.checkNotNull(list);
		 
		 /**
		  * 了解即可！！！！
		  */
		 Preconditions.checkState(false);
		 
		 Preconditions.checkElementIndex(5, list.size());
		 
		 Preconditions.checkPositionIndex(5, 6);
		 
		 
		 
	}
}
