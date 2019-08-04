package Java_Set_List_Map;

import java.util.EnumSet;
import java.util.List;

import com.google.common.collect.Lists;

public enum pmtType {

	/**
	 * 枚举类的定义
	 * 枚举值中对应的必须有相关类的成员变量属性
	 * 成员变量提供get方法
	 * 提供带有参数的构造器
	 */
	
	SCHD("SCHD","正常还款",true),
	一("1","测试1",true),
	二("2","测试2",true),
	ODPT("ODPT","逾期还款",false);
	
	private pmtType(String code, String dec, Boolean index) {
		this.code = code;
		this.dec = dec;
		this.index = index;
	}
	private String code;
	private String dec;
	private Boolean index;
	public String getCode() {
		return code;
	}
	public String getDec() {
		return dec;
	}
	public Boolean getIndex() {
		return index;
	}
	
	
	
	public List<String> getIndexOut(){
		List<String> list=Lists.newArrayList();
		
		for(pmtType value :pmtType.values()) {
			if(value.index) {
				list.add(value.dec);
			}
		}
		return list;
	}
	
	public boolean isTrue(String code) {
		EnumSet<pmtType> set=EnumSet.allOf(pmtType.class);
		for(pmtType s:set) {
            if(s.getCode().equals(code)) {
            	return true;
            }
		}
		return false;
	}
	
}
