package jp.seraphyware.java9example1app;

import jp.seraphyware.java9example1lib.Lib;

public class Main {
	
	public static void main(String... args) throws Exception {
		Lib lib = Lib.getDefault();
		System.out.println(lib.describe("hello, world"));

		//Lib lib2 = new jp.seraphyware.java9example1lib.priv.LibImpl();
		//System.out.println(lib2.describe("hello, world"));
	}
}
