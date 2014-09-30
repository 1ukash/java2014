package ru.spbstu.telematics.lecture2.a;

import ru.spbstu.telematics.lecture2.b.Example2;


public class Example1 implements Creature, Comparable<Example1> {
	
  public class InnerState {
	  int stateID = 3;
	  String stateName;
	  
	  void doChange() {
		  stateID = stateID + val;
	  }
  }
  
  private static class StaticInnerState {
	  int stateID = 3;
	  String stateName;
	  
	  void doChange() {
		  stateID = stateID;
	  }
  }
  
  private Example2 ex = new Example2();
  private int val;
  public long val2;
  long val3;
  
  public final static int num;
  static {
	  num = 2;
  }
  
  {
	  val3 = 1;
  }
  
  public Example1(long val2, long val3) {
	super();
	this.val2 = val2;
	this.val3 = val3;
  }

  void hello() {
	  
	class Test {
		int a, b;
		
		void foor() {
			class Test2{
				
			}
		}
	}
	InnerState s = new InnerState();
	s.doChange();
	System.out.println(s.stateID);
  }
  
  public static void main(String[] args) {
	new Example1(1, 1).hello();
  }
  
  final int incrementAndGetVal() {
	  return ++val;
  }

	@Override
	public void live() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Example1 o) {
		// TODO Auto-generated method stub
		return 0;
	}
  
}
