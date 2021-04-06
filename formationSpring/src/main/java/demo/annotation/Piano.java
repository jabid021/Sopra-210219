package demo.annotation;

import org.springframework.stereotype.Component;

import demo.xml.Instrument;

@Component
public class Piano implements Instrument {
	@Override
	public String toString() {
		return "plink plink plink";
	}
}
