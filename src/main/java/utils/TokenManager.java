package utils;

import services.AuthService;

public class TokenManager {

	private static String token;

	public static String getToken() {

		if (token == null) {

			AuthService authService = new AuthService();

			token = authService.generateToken();
		}

		return token;
	}
}