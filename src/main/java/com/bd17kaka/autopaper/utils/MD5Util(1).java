/**
 * 
 */
package com.bd17kaka.autopaper.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author Administrator
 *
 */
public class MD5Util {
	public static String getMD5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
		}
		// never goto here
		return "";
	}
}
