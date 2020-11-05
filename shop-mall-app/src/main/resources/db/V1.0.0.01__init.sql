CREATE SEQUENCE IF NOT EXISTS "s_jenkins_group"
    START WITH 1
	INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."db_jenkins_group" (
  "id" int8 NOT NULL DEFAULT nextval('s_jenkins_group'::regclass),
  "group_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "deleted" int2 NOT NULL DEFAULT 0,
  "create_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "update_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT "db_jenkins_group_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."db_jenkins_group"
  OWNER TO "postgres";

COMMENT ON COLUMN "public"."db_jenkins_group"."id" IS '主键自增';

COMMENT ON COLUMN "public"."db_jenkins_group"."group_name" IS '业务线名称';

COMMENT ON COLUMN "public"."db_jenkins_group"."deleted" IS '是否删除（0：否；1：是）';

COMMENT ON COLUMN "public"."db_jenkins_group"."create_date" IS '创建时间';

COMMENT ON COLUMN "public"."db_jenkins_group"."update_date" IS '更新时间';

COMMENT ON TABLE "public"."db_jenkins_group" IS '业务组表';

CREATE SEQUENCE IF NOT EXISTS "s_jenkins_app"
    START WITH 1
	INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."db_jenkins_app" (
  "id" int8 NOT NULL DEFAULT nextval('s_jenkins_app'::regclass),
  "app_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "description" text COLLATE "pg_catalog"."default",
  "project_type" int2 NOT NULL DEFAULT 1,
  "code_address" varchar(500) COLLATE "pg_catalog"."default" NOT NULL,
  "group_id" int8 NOT NULL,
  "app_config" text COLLATE "pg_catalog"."default",
  "deleted" int2 NOT NULL DEFAULT 0,
  "create_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "update_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT "db_jenkins_app_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."db_jenkins_app"
  OWNER TO "postgres";

COMMENT ON COLUMN "public"."db_jenkins_app"."id" IS '主键自增';

COMMENT ON COLUMN "public"."db_jenkins_app"."app_name" IS '应用名称';

COMMENT ON COLUMN "public"."db_jenkins_app"."description" IS '应用说明';

COMMENT ON COLUMN "public"."db_jenkins_app"."project_type" IS '应用类型（1：java；2：web）';

COMMENT ON COLUMN "public"."db_jenkins_app"."code_address" IS '代码地址';

COMMENT ON COLUMN "public"."db_jenkins_app"."group_id" IS '所属业务线';

COMMENT ON COLUMN "public"."db_jenkins_app"."app_config" IS '应用配置';

COMMENT ON COLUMN "public"."db_jenkins_app"."deleted" IS '是否删除（0：否；1：是）';

COMMENT ON COLUMN "public"."db_jenkins_app"."create_date" IS '创建时间';

COMMENT ON COLUMN "public"."db_jenkins_app"."update_date" IS '更新时间';

COMMENT ON TABLE "public"."db_jenkins_app" IS '应用表';

CREATE SEQUENCE IF NOT EXISTS "s_jenkins_app_instance"
    START WITH 1
	INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."db_jenkins_app_instance" (
  "id" int8 NOT NULL DEFAULT nextval('s_jenkins_app_instance'::regclass),
  "job_id" int8 NOT NULL,
  "job_state" int2 NOT NULL DEFAULT 0,
  "server_host" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "server_port" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "git_branch" varchar(255) COLLATE "pg_catalog"."default",
  "instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "instance_json" text COLLATE "pg_catalog"."default",
  "deleted" int2 NOT NULL DEFAULT 0,
  "create_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "update_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT "db_jenkins_app_instance_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."db_jenkins_app_instance"
  OWNER TO "postgres";

COMMENT ON COLUMN "public"."db_jenkins_app_instance"."id" IS '主键自增';

COMMENT ON COLUMN "public"."db_jenkins_app_instance"."job_id" IS '应用编号';

COMMENT ON COLUMN "public"."db_jenkins_app_instance"."job_state" IS '应用状态（0：未启动；1：启动中；2：启动成功）';

COMMENT ON COLUMN "public"."db_jenkins_app_instance"."server_host" IS '主机';

COMMENT ON COLUMN "public"."db_jenkins_app_instance"."server_port" IS '端口';

COMMENT ON COLUMN "public"."db_jenkins_app_instance"."git_branch" IS '分支';

COMMENT ON COLUMN "public"."db_jenkins_app_instance"."instance_id" IS '实例编号';

COMMENT ON COLUMN "public"."db_jenkins_app_instance"."instance_json" IS '实例详情';

COMMENT ON COLUMN "public"."db_jenkins_app_instance"."deleted" IS '是否删除（0：否；1：是）';

COMMENT ON COLUMN "public"."db_jenkins_app_instance"."create_date" IS '创建时间';

COMMENT ON COLUMN "public"."db_jenkins_app_instance"."update_date" IS '更新时间';

COMMENT ON TABLE "public"."db_jenkins_app_instance" IS '应用实例表';

CREATE SEQUENCE IF NOT EXISTS "s_menu"
    START WITH 1
	INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."db_menu" (
  "id" int8 NOT NULL DEFAULT nextval('s_menu'::regclass),
  "menu_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "parent_id" int8 NOT NULL DEFAULT 0,
  "menu_type" int2 NOT NULL,
  "menu_url" varchar(255) COLLATE "pg_catalog"."default",
  "icon" varchar(255) COLLATE "pg_catalog"."default",
  "deleted" int2 NOT NULL DEFAULT 0,
  "create_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "update_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT "db_menu_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."db_menu"
  OWNER TO "postgres";

COMMENT ON COLUMN "public"."db_menu"."id" IS '主键自增';

COMMENT ON COLUMN "public"."db_menu"."menu_name" IS '菜单名称';

COMMENT ON COLUMN "public"."db_menu"."parent_id" IS '父编号';

COMMENT ON COLUMN "public"."db_menu"."menu_type" IS '菜单类型（1：菜单；2：接口）';

COMMENT ON COLUMN "public"."db_menu"."menu_url" IS '地址';

COMMENT ON COLUMN "public"."db_menu"."icon" IS '图标';

COMMENT ON COLUMN "public"."db_menu"."deleted" IS '是否删除（0：否；1：是）';

COMMENT ON COLUMN "public"."db_menu"."create_date" IS '创建时间';

COMMENT ON COLUMN "public"."db_menu"."update_date" IS '更新时间';

COMMENT ON TABLE "public"."db_menu" IS '菜单表';

CREATE SEQUENCE IF NOT EXISTS "s_role"
    START WITH 1
	INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."db_role" (
  "id" int8 NOT NULL DEFAULT nextval('s_role'::regclass),
  "role_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "deleted" int2 NOT NULL DEFAULT 0,
  "create_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "update_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT "db_role_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."db_role"
  OWNER TO "postgres";

COMMENT ON COLUMN "public"."db_role"."id" IS '主键自增';

COMMENT ON COLUMN "public"."db_role"."role_name" IS '角色名称';

COMMENT ON COLUMN "public"."db_role"."deleted" IS '是否删除（0：否；1：是）';

COMMENT ON COLUMN "public"."db_role"."create_date" IS '创建时间';

COMMENT ON COLUMN "public"."db_role"."update_date" IS '更新时间';

COMMENT ON TABLE "public"."db_role" IS '角色表';

CREATE SEQUENCE IF NOT EXISTS "s_role_menu"
    START WITH 1
	INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."db_role_menu" (
  "id" int8 NOT NULL DEFAULT nextval('s_role_menu'::regclass),
  "role_id" int8 NOT NULL,
  "menu_id" int8 NOT NULL,
  "deleted" int2 NOT NULL DEFAULT 0,
  "create_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "update_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT "db_role_menu_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."db_role_menu"
  OWNER TO "postgres";

COMMENT ON COLUMN "public"."db_role_menu"."id" IS '主键自增';

COMMENT ON COLUMN "public"."db_role_menu"."role_id" IS '角色编号';

COMMENT ON COLUMN "public"."db_role_menu"."menu_id" IS '菜单编号';

COMMENT ON COLUMN "public"."db_role_menu"."deleted" IS '是否删除（0：否；1：是）';

COMMENT ON COLUMN "public"."db_role_menu"."create_date" IS '创建时间';

COMMENT ON COLUMN "public"."db_role_menu"."update_date" IS '更新时间';

COMMENT ON TABLE "public"."db_role_menu" IS '角色菜单关系表';

CREATE SEQUENCE IF NOT EXISTS "s_user"
    START WITH 1
	INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."db_user" (
  "id" int8 NOT NULL DEFAULT nextval('s_user'::regclass),
  "user_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "real_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "pwd" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "header_img" varchar(500) COLLATE "pg_catalog"."default" NOT NULL,
  "deleted" int2 NOT NULL DEFAULT 0,
  "create_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "update_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT "db_user_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."db_user"
  OWNER TO "postgres";

COMMENT ON COLUMN "public"."db_user"."id" IS '主键自增';

COMMENT ON COLUMN "public"."db_user"."user_name" IS '用户名';

COMMENT ON COLUMN "public"."db_user"."real_name" IS '真实姓名';

COMMENT ON COLUMN "public"."db_user"."pwd" IS '密码';

COMMENT ON COLUMN "public"."db_user"."header_img" IS '头像';

COMMENT ON COLUMN "public"."db_user"."deleted" IS '是否删除（0：否；1：是）';

COMMENT ON COLUMN "public"."db_user"."create_date" IS '创建时间';

COMMENT ON COLUMN "public"."db_user"."update_date" IS '更新时间';

COMMENT ON TABLE "public"."db_user" IS '用户表';

CREATE SEQUENCE IF NOT EXISTS "s_user_role"
    START WITH 1
	INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."db_user_role" (
  "id" int8 NOT NULL DEFAULT nextval('s_user_role'::regclass),
  "user_id" int8 NOT NULL,
  "role_id" int8 NOT NULL,
  "deleted" int2 NOT NULL DEFAULT 0,
  "create_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "update_date" timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT "db_user_role_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."db_user_role"
  OWNER TO "postgres";

COMMENT ON COLUMN "public"."db_user_role"."id" IS '主键自增';

COMMENT ON COLUMN "public"."db_user_role"."user_id" IS '用户编号';

COMMENT ON COLUMN "public"."db_user_role"."role_id" IS '角色编号';

COMMENT ON COLUMN "public"."db_user_role"."deleted" IS '是否删除（0：否；1：是）';

COMMENT ON COLUMN "public"."db_user_role"."create_date" IS '创建时间';

COMMENT ON COLUMN "public"."db_user_role"."update_date" IS '更新时间';

COMMENT ON TABLE "public"."db_user_role" IS '用户角色关系表';
