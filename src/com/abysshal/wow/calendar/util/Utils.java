package com.abysshal.wow.calendar.util;

import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

import org.apache.mina.util.Base64;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.abysshal.wow.calendar.model.UserAuthToken;

public class Utils {
	private static ObjectMapper mapper = new ObjectMapper();

	public static ObjectMapper getObjectMapper() {
		return mapper;
	}

	public static String MD5(String text) {
		java.security.MessageDigest md = null;
		try {
			md = java.security.MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (md != null) {
			md.update(text.getBytes());
			BigInteger i = new BigInteger(1, md.digest());
			return String.format("%1$032x", i);
		} else {
			return null;
		}
	}

	public static String encodeBase64(String plain) {
		return new String(Base64.encodeBase64Chunked(plain.getBytes()));
	}

	public static String decodeBase64(String encoded) {
		return new String(Base64.decodeBase64(encoded.getBytes()));
	}

	public static String encodeAuthToken(UserAuthToken uat) {
		try {
			String tmp = getObjectMapper().writeValueAsString(uat);
			return encodeBase64(tmp);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static UserAuthToken decodeAuthToken(String str) {
		try {
			return getObjectMapper().readValue(decodeBase64(str),
					UserAuthToken.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
