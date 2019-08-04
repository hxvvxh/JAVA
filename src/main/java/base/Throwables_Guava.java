package base;

import java.io.IOException;

import com.google.common.base.Throwables;

public class Throwables_Guava {

	/**
	 * Throwables:简化异常的相关操作
	 */
	
	
	
	public void Test() throws Throwable{
		try {
			new RuntimeException("11111");
		}catch(Exception e) {
			
		}catch(Throwable t) {
			//异常类型为IoException时才抛出异常
			Throwables.propagateIfInstanceOf(t, IOException.class);
			
			/**
			 * 如果异常是error或者是RuntimeException时直接抛出
			 * 如果不是以上两种的异常则包装成RuntimeException在抛出
			 * 也就是说这个方法是必定抛出异常的
			 * 但是这里将检查项异常包装成了非检查项的异常，不是很好的做法
			 */
			Throwables.propagate(t);
			
			//异常为error和RuntimeException时才抛出异常
			Throwables.propagateIfPossible(t);
	
			//异常为NullPointerException 和error和RuntimeException时才抛出异常  
			Throwables.propagateIfPossible(t, NullPointerException.class);
			
			
			
			
		}
	}

}
