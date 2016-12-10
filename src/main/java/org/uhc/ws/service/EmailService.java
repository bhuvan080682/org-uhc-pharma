package org.uhc.ws.service;

import java.util.concurrent.Future;

import org.uhc.ws.model.Drug;

public interface EmailService {
	Boolean send(Drug drugs);
	void sendASync(Drug drugs);
	Future<Boolean> sendASyncWithResult(Drug drugs);
}
