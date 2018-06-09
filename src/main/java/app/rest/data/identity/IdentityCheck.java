package app.rest.data.identity;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joaok on 09/06/2018.
 */
@Service
public class IdentityCheck {

	private Map<String, Boolean> accounts;

	public IdentityCheck() {
		accounts = new HashMap();
		accounts.put("joaok", true);
	}

	public boolean isAllowedToLogin(String username) {
		boolean exists = accounts.containsKey(username.toLowerCase());
		if (!exists)
			return false;
		return accounts.get(username.toLowerCase());
	}

}
