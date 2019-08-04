package base;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class ComparisonChain_Guava {
public static void main(String[] args) {
	ComparisonChain_Guava g=new ComparisonChain_Guava();
	g.Test1();
}
public void Test1() {
	
	/**
	 * ComparisonChain 执行一种懒比较：
	 * 它执行比较操作直至发现非零的结果，在那之后的比较输入将被忽略。
	 * 也就是说当比较的结果都相同时返回结果为0/有一个不同是返回不为0
	 */
	int i1=ComparisonChain.start()
	               .compare("hp", "hp")
	               .compare("qq", "qq")
	               .result();
	
	int i2=ComparisonChain.start()
            .compare("qq", "qq")
            .compare("pp", "hp")
            .result();
	String s1=Objects.toStringHelper("输出的结果为：").add("i1/i2", i1+""+i2).toString();
	System.out.println(s1);
}
}
