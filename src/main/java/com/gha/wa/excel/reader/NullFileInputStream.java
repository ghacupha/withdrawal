/**
 * 
 */
package com.gha.wa.excel.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Null object for the FileInputStream
 * @author edwin.njeru
 *
 */
public class NullFileInputStream extends FileInputStream {
	
	private FileInputStream fileInputStream;
	
	private static String empty = new String();
	private boolean isNil = true;
	
	public NullFileInputStream() throws FileNotFoundException {
		super(empty);
	}

	/**
	 * @return the isNil
	 */
	public boolean isNil() {
		return isNil;
	}
}
