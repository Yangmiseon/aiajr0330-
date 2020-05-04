package ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {


		//List<E> ㅡ> ArrayList<E>
		//List<E> : 저장 순서를 가진다. 데이터의 중복저장 가능
		//순서 ㅡ> 일괄 처리가능(반복 적인 동일한 작업을 빠르게 처리)
		
		//ArrayList 인스턴스 생성 : Integer타입의 객체만 저장
		//ArrayList<Integer> list = new ArrayList<>();
		//List<Integer> list = new ArrayList<>();//다형성 
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		//List<E>타입에 정의된 메서드 
		//-> add(E):인스턴스의 저장(참조값저장)
		//remove(index):해당 index의 요소를 삭제
		//size() : List 요소의 갯수를 반환
		//get(index) :해당 index위치의 요소 반환(실제로 저장은 주소값) 
		
		//데이터의 저장-> 순서대로 저장됨
		list.add(new Integer(10));
		list.add(new Integer(20));
		list.add(new Integer(30));
		list.add(40);//Auto Boxing
		
		
		//데이터의 참조
		System.out.println("저장된 데이터 확인");
		//반복문을 통해 일괄참조 가능하다.
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//데이터의 삭제 : 내부적으로 시프트됨
		list.remove(1);
		System.out.println("삭제된 데이터 확인");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		System.out.println("--------------");
		Iterator<Integer> itr=list.iterator();
		
		while(itr.hasNext()){ 
			int curStr=itr.next(); 
			System.out.println(itr.next()); 
			
		}
		
	}

}
