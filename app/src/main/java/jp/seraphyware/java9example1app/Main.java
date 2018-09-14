package jp.seraphyware.java9example1app;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import jp.seraphyware.java9example1lib.Lib;

public class Main {

	public static void main(String... args) throws Exception {
		Logger logger = System.getLogger(Main.class.getName());

		Lib lib = Lib.getDefault();
		logger.log(Level.INFO, lib.describe("hello, world"));

//		Lib lib2 = new jp.seraphyware.java9example1lib.priv.LibImpl();
//		logger.log(Level.INFO, lib2.describe("hello, world"));

		logger.log(Level.INFO, "実行を完了しました。");
	}
}
