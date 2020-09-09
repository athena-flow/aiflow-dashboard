drop database if exists dashboard;
drop user 'dashboard'@'127.0.0.1';
-- 支持emoji：需要mysql数据库参数： character_set_server=utf8mb4
create database dashboard default character set utf8mb4 collate utf8mb4_unicode_ci;
use dashboard;
create user 'dashboard'@'127.0.0.1' identified by 'dashboard123456';
grant all privileges on dashboard.* to 'dashboard'@'127.0.0.1';
flush privileges;