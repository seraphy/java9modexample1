package jp.seraphyware.java9example1lib;

public interface Lib {
	
	String describe(String value);
	
	static Lib getDefault() {
		return new jp.seraphyware.java9example1lib.priv.LibImpl();
	}
}
