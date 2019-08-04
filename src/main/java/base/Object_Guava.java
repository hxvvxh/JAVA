package base;

import java.util.logging.Logger;

import org.junit.Test;

import com.google.common.base.Objects;

public class Object_Guava {
	
	public static void main(String[] args) {
		Object_Guava o=new Object_Guava();
		o.Test();
	}
public void Test() {
	/**
	 * Objects.equal(@Nullable Object a, @Nullable Object b)
	 * 比较两者是否相同/避免了null的敏感判断。避免NullPointerException
	 */
	Objects.equal(null, 'a');//false
	Objects.equal('a', null);//false
	Objects.equal(null, null);//true
	Objects.equal('a', 'a');//true
	
	//轻松编写有用的 toString 方法
	String s1=Objects.toStringHelper("还款的入参：").add("Partinfo", ".........").toString();
	System.out.println(s1);
	
	
	
	
	
	
}

























}
