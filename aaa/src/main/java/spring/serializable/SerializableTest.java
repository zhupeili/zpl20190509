package spring.serializable;

import java.io.Serializable;

public class SerializableTest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String a;
	private int b ;
	
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public SerializableTest(String a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	

}
