#データベース作成
create database if not exists prototype05;

#データベース指定
use prototype05;

#ユーザー情報テーブル作成
drop table if exists user_info;
create table user_info(
user_id int(10) primary key not null auto_increment,
user_password varchar(16) not null,
user_email varchar(70) not null,
user_name varchar(50) not null
);

#カスタマー情報テーブル作成
drop table if exists customer_info;
create table customer_info (
customer_id int(10) not null primary key auto_increment,
customer_name varchar(100) not null,
customer_pass varchar(25) not null,
email_address varchar(100) not null,
tel_number varchar(12) not null,
customer_address varchar(100) not null,
address_number varchar(30) not null,
customer_postcode int(7) not null,
customer_age tinyint not null
);

#カレンダー情報テーブル作成
drop table if exists calendar;
create table calendar(
day date
);

