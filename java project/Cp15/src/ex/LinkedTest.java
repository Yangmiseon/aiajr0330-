package ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedTest {

	public static void main(String[] args) {

		String str1 = "one";
		String str2 = "twe";
		String str3 = "three";
		String str4 = "four";
		
		Data d1 = new Data(str1, str2);
		Data d2 = new Data(str2, str3);
		Data d3 = new Data(str3, null);
		
		//ㅇ2삭제하고싶을때
		d1.setNextValue(str3);
		
		//d4끼어들고싶을때
		Data d4 = new Data(str4, str2);
		d1.setNextValue(str4);
	}
	
	
	

}

class Data{
	Object value;
	Object nextValue;
	
	Data(Object obj, Object nextObj){
		this.value = obj;
		this.nextValue = nextValue;
	}
	
	Object getValue() {
		return value;
	}
	
	void setNextValue(Object nextValue) {
		this.nextValue = nextValue;
	}
}
