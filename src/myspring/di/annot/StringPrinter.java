package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("stringPrinter")
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
