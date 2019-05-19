INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES
	('uims', NULL, '449286663b65633368ee556f19b975e8', 'uims', 'client_credentials,password,authorization_code', 'http://localhost:8080/uims/login', NULL, NULL, NULL, NULL, 'true'),

INSERT INTO sys_user VALUES
	(null, 1, 'admin', '开发管理员', '449286663b65633368ee556f19b975e8', 'admin@uims.com', '13800138000', 0, 1, '0000-00-00 00:00:00', 1, '0000-00-00 00:00:00', 1);