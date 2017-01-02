INSERT INTO DRUG(drugName,company) values ('DOLO 650','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('CALPOL 650','GSK');
INSERT INTO DRUG(drugName,company) values ('DOLO 500','Cipla');
INSERT INTO DRUG(drugName,company) values ('Glycomet 500','GSK');
INSERT INTO DRUG(drugName,company) values ('Glycomet 500 SR','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('Glycomet Gp1','Cipla');
INSERT INTO DRUG(drugName,company) values ('Glycomet Gp2','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('Glycomet Gp3','Cipla');
INSERT INTO DRUG(drugName,company) values ('Glycomet Gp1 SR','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('Doloper','Cipla');
INSERT INTO DRUG(drugName,company) values ('Dolowin Plus','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('Suhagra 50','GSK');
INSERT INTO DRUG(drugName,company) values ('Suhagra 100','Cipla');
INSERT INTO DRUG(drugName,company) values ('Nodard Plus','GSK');
INSERT INTO DRUG(drugName,company) values ('Sumo Cold','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('Sumo Flam','Cipla');
INSERT INTO DRUG(drugName,company) values ('Sumo','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('Okacet','GSK');
INSERT INTO DRUG(drugName,company) values ('Okacet L','Cipla');
INSERT INTO DRUG(drugName,company) values ('Nicip','GSK');
INSERT INTO DRUG(drugName,company) values ('Nicip Plus','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('Nicip Cold And Flu','Cipla');
INSERT INTO DRUG(drugName,company) values ('Chest and Cold','Cipla');
INSERT INTO DRUG(drugName,company) values ('KofQ','GSK');
INSERT INTO DRUG(drugName,company) values ('Tusq','Cipla');
INSERT INTO DRUG(drugName,company) values ('Gelusil','GSK');
INSERT INTO DRUG(drugName,company) values ('Gelusil Syp','Cipla LABS');
INSERT INTO DRUG(drugName,company) values ('Digene','GSK');
INSERT INTO DRUG(drugName,company) values ('Allercet','Cipla LABS');
INSERT INTO DRUG(drugName,company) values ('Allercet DC','GSK');
INSERT INTO DRUG(drugName,company) values ('Allercet L','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('Gemer 500','Cipla');
INSERT INTO DRUG(drugName,company) values ('Hicet','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('Hicet L','Cipla');
INSERT INTO DRUG(drugName,company) values ('Imol Plus','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('Ibugesic Plus','GSK');
INSERT INTO DRUG(drugName,company) values ('Pan 40','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('Pan DSR','Cipla');
INSERT INTO DRUG(drugName,company) values ('Pan D','MICRO LABS');
INSERT INTO DRUG(drugName,company) values ('Pantakind','Cipla');

-- password is 'password'
INSERT INTO Account (referenceId, username, password, enabled, credentialsexpired, expired, locked, version, createdBy, createdAt, updatedBy, updatedAt) VALUES ('a07bd221-3ecd-4893-a0f0-78d7c0fbf94e', 'user', '$2a$10$9/44Rne7kQqPXa0cY6NfG.3XzScMrCxFYjapoLq/wFmHz7EC9praK', true, false, false, false, 0, 'user', NOW(), NULL, NULL);
-- password is 'operations'
INSERT INTO Account (referenceId, username, password, enabled, credentialsexpired, expired, locked, version, createdBy, createdAt, updatedBy, updatedAt) VALUES ('7bd137c8-ab64-4a45-bf2d-d9bae3574622', 'operations', '$2a$10$CoMVfutnv1qZ.fNlHY1Na.rteiJhsDF0jB1o.76qXcfdWN6As27Zm', true, false, false, false, 0, 'user', NOW(), NULL, NULL);

INSERT INTO Role (id, code, label, ordinal, effectiveAt, expiresAt, createdAt) VALUES (1, 'ROLE_USER', 'User', 0, '2015-01-01 00:00:00', NULL, NOW());
INSERT INTO Role (id, code, label, ordinal, effectiveAt, expiresAt, createdAt) VALUES (2, 'ROLE_ADMIN', 'Admin', 1, '2015-01-01 00:00:00', NULL, NOW());
INSERT INTO Role (id, code, label, ordinal, effectiveAt, expiresAt, createdAt) VALUES (3, 'ROLE_SYSADMIN', 'System Admin', 2, '2015-01-01 00:00:00', NULL, NOW());

INSERT INTO AccountRole (accountId, roleId) SELECT a.id, r.id FROM Account a, Role r WHERE a.username = 'user' and r.id = 1;
INSERT INTO AccountRole (accountId, roleId) SELECT a.id, r.id FROM Account a, Role r WHERE a.username = 'operations' and r.id = 3;


INSERT INTO CUSTOMER(name,phone,sex) values ('Bhuvanesh','9535331523','M');
INSERT INTO CUSTOMER(name,phone,sex) values ('Parvathamma','9900502098','F');
INSERT INTO CUSTOMER(name,phone,sex) values ('Nari','9845870007','M');

-- password is 'password'
--INSERT INTO Account (referenceId, username, password, enabled, credentialsexpired, expired, locked, version, createdBy, createdAt, updatedBy, updatedAt) VALUES ('a07bd221-3ecd-4893-a0f0-78d7c0fbf94e', 'user', '$2a$10$9/44Rne7kQqPXa0cY6NfG.3XzScMrCxFYjapoLq/wFmHz7EC9praK', true, false, false, false, 0, 'user', NOW(), NULL, NULL);
-- password is 'password'
--INSERT INTO Account (referenceId, username, password, enabled, credentialsexpired, expired, locked, version, createdBy, createdAt, updatedBy, updatedAt) VALUES ('a07bd221-3ecd-4893-a0f0-78d7c0fbf94e', 'unnathihealthcare', '$2a$10$9/44Rne7kQqPXa0cY6NfG.3XzScMrCxFYjapoLq/wFmHz7EC9praK', true, false, false, false, 0, 'user', NOW(), NULL, NULL);
-- password is 'operations'
--INSERT INTO Account (referenceId, username, password, enabled, credentialsexpired, expired, locked, version, createdBy, createdAt, updatedBy, updatedAt) VALUES ('7bd137c8-ab64-4a45-bf2d-d9bae3574622', 'unnathihealthcare', '$2a$10$CoMVfutnv1qZ.fNlHY1Na.rteiJhsDF0jB1o.76qXcfdWN6As27Zm', true, false, false, false, 0, 'user', NOW(), NULL, NULL);

--INSERT INTO Role (id, code, label, ordinal, effectiveAt, expiresAt, createdAt) VALUES (1, 'ROLE_USER', 'User', 0, '2015-01-01 00:00:00', NULL, NOW());
--INSERT INTO Role (id, code, label, ordinal, effectiveAt, expiresAt, createdAt) VALUES (2, 'ROLE_ADMIN', 'Admin', 1, '2015-01-01 00:00:00', NULL, NOW());
--INSERT INTO Role (id, code, label, ordinal, effectiveAt, expiresAt, createdAt) VALUES (3, 'ROLE_SYSADMIN', 'System Admin', 2, '2015-01-01 00:00:00', NULL, NOW());

--INSERT INTO AccountRole (accountId, roleId) SELECT a.id, r.id FROM Account a, Role r WHERE a.username = 'user' and r.id = 1;
--INSERT INTO AccountRole (accountId, roleId) SELECT a.id, r.id FROM Account a, Role r WHERE a.username = 'unnathihealthcare' and r.id = 3;
--INSERT INTO AccountRole (accountId, roleId) SELECT a.id, r.id FROM Account a, Role r WHERE a.username = 'unnathihealthcare' and r.id = 2;
