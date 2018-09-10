package jp.seraphyware.java9example1lib.priv;

public class LibImpl implements jp.seraphyware.java9example1lib.Lib {

	@Override
	public String describe(String value) {
		try {
			return javax.xml.bind.DatatypeConverter.printBase64Binary(value.getBytes("UTF-8"));
		} catch (java.io.IOException ex) {
			throw new java.io.UncheckedIOException(ex);
		}
	}
}
