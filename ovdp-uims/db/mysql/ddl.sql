CREATE TABLE IF NOT EXISTS oauth_access_token (
  token_id varchar(256) DEFAULT NULL,
  token blob,
  authentication_id varchar(190) NOT NULL,
  user_name varchar(256) DEFAULT NULL,
  client_id varchar(256) DEFAULT NULL,
  authentication blob,
  refresh_token varchar(256) DEFAULT NULL,
  PRIMARY KEY (authentication_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS oauth_approvals (
  userId varchar(256) DEFAULT NULL,
  clientId varchar(256) DEFAULT NULL,
  scope varchar(256) DEFAULT NULL,
  status varchar(10) DEFAULT NULL,
  expiresAt timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  lastModifiedAt timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS oauth_client_details (
  client_id varchar(150) NOT NULL,
  resource_ids varchar(256) DEFAULT NULL,
  client_secret varchar(256) DEFAULT NULL,
  scope varchar(256) DEFAULT NULL,
  authorized_grant_types varchar(256) DEFAULT NULL,
  web_server_redirect_uri varchar(256) DEFAULT NULL,
  authorities varchar(256) DEFAULT NULL,
  access_token_validity int(11) DEFAULT NULL,
  refresh_token_validity int(11) DEFAULT NULL,
  additional_information varchar(4096) DEFAULT NULL,
  autoapprove varchar(256) DEFAULT NULL,
  PRIMARY KEY (client_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS oauth_client_token (
  token_id varchar(256) DEFAULT NULL,
  token blob,
  authentication_id varchar(190) NOT NULL,
  user_name varchar(256) DEFAULT NULL,
  client_id varchar(256) DEFAULT NULL,
  PRIMARY KEY (authentication_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS oauth_code (
  code varchar(256) DEFAULT NULL,
  authentication blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
  token_id varchar(256) DEFAULT NULL,
  token blob,
  authentication blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS sys_user (
  id bigint unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_org bigint unsigned DEFAULT NULL COMMENT '所属组织',
  user_account varchar(100) NOT NULL COMMENT '用户帐号',
  user_name varchar(100) NOT NULL COMMENT '用户名',
  user_password varchar(100) NOT NULL COMMENT '密码',
  user_email varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  mobile_phone varchar(200) DEFAULT NULL COMMENT '手机号码',
  is_deleted tinyint unsigned DEFAULT 0 COMMENT '删除标记,1-删除,0-未删除',
  create_by bigint unsigned DEFAULT NULL COMMENT '创建人',
  gmt_create datetime NOT NULL COMMENT '创建时间',
  last_modified_by bigint unsigned DEFAULT NULL COMMENT '修改人',
  gmt_modified datetime NOT NULL COMMENT '修改时间',
  version int unsigned DEFAULT 0 COMMENT '版本'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

