package org.uhc.ws.service;

import org.uhc.ws.model.Account;

public interface AccountService {
	
	Account findByUsername(String username);

}
