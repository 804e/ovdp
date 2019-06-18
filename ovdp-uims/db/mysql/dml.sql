/*密码123456*/
INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES
    ('uims', NULL, 'e10adc3949ba59abbe56e057f20f883e', 'uims', 'client_credentials,password,authorization_code', 'http://localhost:8080/uims/login', NULL, NULL, NULL, NULL, 'true');
INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES
    ('client-demo', NULL, 'e10adc3949ba59abbe56e057f20f883e', 'uims', 'client_credentials,password,authorization_code', 'http://localhost:8080/uims/login', NULL, NULL, NULL, NULL, 'true');

/*密码admin*/
INSERT INTO sys_user VALUES
    (1, 'admin', '开发管理员', '21232f297a57a5a743894a0e4a801fc3', 'admin@uims.com', '13800138000', 0, 1, '0000-00-00 00:00:00', 1, '0000-00-00 00:00:00', 1);