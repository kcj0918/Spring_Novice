package myspring.di.xml;

public class StringPrinter implements Printer{
	private StringBuffer sb = new StringBuffer();
	
	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		sb.append(message);
	}
	
	public String toString() {
		return sb.toString();
	}
}
