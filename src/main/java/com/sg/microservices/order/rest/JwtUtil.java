package com.sg.microservices.order.rest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtUtil {
	
    private static final String signingKey = "my-jwt-secretkey";
	 
	 
	public static String getSubject(String token) {
		Jws<Claims> claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);
		String username = claims.getBody().getSubject();
		return username;
	}

	
	public String getPassword(String token) {
		Jws<Claims> claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);
		Object password = claims.getBody().get("password");
		return password.toString();
	}

	
	public static boolean validateJWT(String compactJws) {
		 System.out.println("validateJWT Started:::::");
		 boolean isValid = false;
        try {
            Jwts.parser().setSigningKey(signingKey).parseClaimsJws(compactJws);
            isValid = true;
            Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(compactJws).getBody();
            System.out.println("claims.getSubject():::"+claims.getSubject());

        } catch (SignatureException e) {
               System.out.println("Exception :::"+e);
        }
        return isValid;
	}

	}
