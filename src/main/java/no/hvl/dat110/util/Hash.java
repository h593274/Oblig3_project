package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author Henri
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint;
	private static MessageDigest md;
	
	static {
		try {
		md = MessageDigest.getInstance("MD5");
		
		} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
		}
	}
	
	
	public static BigInteger hashOf(String entity) {	
		
		BigInteger hashint = null;
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		// compute the hash of the input 'entity'
		
		byte[] big = md.digest(entity.getBytes());
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		String str = toHex(big);
		hashint = new BigInteger(str, 16);
		
		// return the BigInteger
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// compute the number of bits = bitSize()
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		return BigInteger.valueOf(2).pow(bitSize());
	}
	
	public static int bitSize() {
		
		int digestlen = md.getDigestLength();
		
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
