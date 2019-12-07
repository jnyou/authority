prompt PL/SQL Developer import file
prompt Created on 2019年12月7日 by 夏小颜
set feedback off
set define off
prompt Disabling triggers for MEMBER...
alter table MEMBER disable all triggers;
prompt Disabling triggers for PRODUCT...
alter table PRODUCT disable all triggers;
prompt Disabling triggers for ORDERS...
alter table ORDERS disable all triggers;
prompt Disabling triggers for TRAVELLER...
alter table TRAVELLER disable all triggers;
prompt Disabling triggers for ORDER_TRAVELLER...
alter table ORDER_TRAVELLER disable all triggers;
prompt Disabling triggers for PERMISSION...
alter table PERMISSION disable all triggers;
prompt Disabling triggers for ROLE...
alter table ROLE disable all triggers;
prompt Disabling triggers for ROLE_PERMISSION...
alter table ROLE_PERMISSION disable all triggers;
prompt Disabling triggers for SYSLOG...
alter table SYSLOG disable all triggers;
prompt Disabling triggers for USERS...
alter table USERS disable all triggers;
prompt Disabling triggers for USERS_ROLE...
alter table USERS_ROLE disable all triggers;
prompt Disabling foreign key constraints for ORDERS...
alter table ORDERS disable constraint SYS_C005444;
alter table ORDERS disable constraint SYS_C005445;
prompt Disabling foreign key constraints for ORDER_TRAVELLER...
alter table ORDER_TRAVELLER disable constraint SYS_C005448;
alter table ORDER_TRAVELLER disable constraint SYS_C005449;
prompt Disabling foreign key constraints for ROLE_PERMISSION...
alter table ROLE_PERMISSION disable constraint SYS_C005472;
alter table ROLE_PERMISSION disable constraint SYS_C005473;
prompt Disabling foreign key constraints for USERS_ROLE...
alter table USERS_ROLE disable constraint SYS_C005468;
alter table USERS_ROLE disable constraint SYS_C005469;
prompt Deleting USERS_ROLE...
delete from USERS_ROLE;
commit;
prompt Deleting USERS...
delete from USERS;
commit;
prompt Deleting SYSLOG...
delete from SYSLOG;
commit;
prompt Deleting ROLE_PERMISSION...
delete from ROLE_PERMISSION;
commit;
prompt Deleting ROLE...
delete from ROLE;
commit;
prompt Deleting PERMISSION...
delete from PERMISSION;
commit;
prompt Deleting ORDER_TRAVELLER...
delete from ORDER_TRAVELLER;
commit;
prompt Deleting TRAVELLER...
delete from TRAVELLER;
commit;
prompt Deleting ORDERS...
delete from ORDERS;
commit;
prompt Deleting PRODUCT...
delete from PRODUCT;
commit;
prompt Deleting MEMBER...
delete from MEMBER;
commit;
prompt Loading MEMBER...
insert into MEMBER (id, name, nickname, phonenum, email)
values ('E61D65F673D54F68B0861025C69773DB', '张三', '小三', '18888888888', 'zs@163.com');
commit;
prompt 1 records loaded
prompt Loading PRODUCT...
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('676C5BD1D35E429A8C2E114939C5685A', 'blithe-002', '北京三日游', '北京', to_timestamp('10-10-2018 10:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1200, '不错的旅行', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('12B7ABF2A4C544568B0A7C69F36BF8B7', 'blithe-003', '上海五日游', '上海', to_timestamp('25-04-2018 14:30:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1800, '魔都我来了', 0);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('9F71F01CB448476DAFB309AA6DF9497F', 'bilthe-001', '北京三日游', '北京', to_timestamp('10-10-2018 10:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1200, '不错的旅行', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('174789382170492BBC3D4BEA3848C703', 'ce', 'test', '北京', to_timestamp('23-11-2019 22:03:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 500, '开心', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('DDFC5404A3A84A029BAABD7EC31D9E60', 'do', '天津之眼一日游', '河南', to_timestamp('05-12-2019 13:35:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 200, '来玩了', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('D4DA60BFDB4D4ED59900BCEA859F5ED2', 'ce', 'test', '北京', to_timestamp('23-11-2019 22:03:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 500, '开心', 0);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('F8D208EC8ECB4638AEED7C7B95505214', 'test', 'ce', '南京', to_timestamp('23-11-2019 22:03:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 300, null, 0);
commit;
prompt 7 records loaded
prompt Loading ORDERS...
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('0E7231DC797C486290E8713CA3C6ECCC', '12345', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '676C5BD1D35E429A8C2E114939C5685A', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('5DC6A48DD4E94592AE904930EA866AFA', '54321', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 1, 1, '676C5BD1D35E429A8C2E114939C5685A', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('2FF351C4AC744E2092DCF08CFD314420', '67890', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('A0657832D93E4B10AE88A2D4B70B1A28', '98765', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 1, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('E4DD4C45EED84870ABA83574A801083E', '11111', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('96CC8BD43C734CC2ACBFF09501B4DD5D', '22222', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 1, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('55F9AF582D5A4DB28FB4EC3199385762', '33333', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('CA005CF1BE3C4EF68F88ABC7DF30E976', '44444', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 1, 0, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('3081770BC3984EF092D9E99760FDABDE', '55555', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
commit;
prompt 9 records loaded
prompt Loading TRAVELLER...
insert into TRAVELLER (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('3FE27DF2A4E44A6DBC5D0FE4651D3D3E', '张龙', '男', '13333333333', 0, '123456789009876543', 0);
insert into TRAVELLER (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('EE7A71FB6945483FBF91543DBE851960', '张小龙', '男', '15555555555', 0, '987654321123456789', 1);
commit;
prompt 2 records loaded
prompt Loading ORDER_TRAVELLER...
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('0E7231DC797C486290E8713CA3C6ECCC', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('2FF351C4AC744E2092DCF08CFD314420', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('3081770BC3984EF092D9E99760FDABDE', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('55F9AF582D5A4DB28FB4EC3199385762', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('5DC6A48DD4E94592AE904930EA866AFA', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('96CC8BD43C734CC2ACBFF09501B4DD5D', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('A0657832D93E4B10AE88A2D4B70B1A28', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('CA005CF1BE3C4EF68F88ABC7DF30E976', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('E4DD4C45EED84870ABA83574A801083E', 'EE7A71FB6945483FBF91543DBE851960');
commit;
prompt 9 records loaded
prompt Loading PERMISSION...
insert into PERMISSION (id, permissionname, url)
values ('099A7456685C455F9DEE743FB84976F7', 'user queryAll', '/user/queryAll');
insert into PERMISSION (id, permissionname, url)
values ('6938E712FEF44D00925DCF77C48543EC', 'user queryById', '/user/queryById');
insert into PERMISSION (id, permissionname, url)
values ('5986974104B04BDCA2DACF890BD3088D', 'role queryAll', '/role/queryAll');
commit;
prompt 3 records loaded
prompt Loading ROLE...
insert into ROLE (id, rolename, roledesc)
values ('71AF046BB6D14635962FF80FBEBEAC9F', 'zs', '张三角色名');
insert into ROLE (id, rolename, roledesc)
values ('1111', 'ADMIN', 'vip');
insert into ROLE (id, rolename, roledesc)
values ('2222', 'USER', 'vip');
commit;
prompt 3 records loaded
prompt Loading ROLE_PERMISSION...
insert into ROLE_PERMISSION (permissionid, roleid)
values ('099A7456685C455F9DEE743FB84976F7', '1111');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('099A7456685C455F9DEE743FB84976F7', '2222');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('5986974104B04BDCA2DACF890BD3088D', '71AF046BB6D14635962FF80FBEBEAC9F');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('6938E712FEF44D00925DCF77C48543EC', '1111');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('6938E712FEF44D00925DCF77C48543EC', '71AF046BB6D14635962FF80FBEBEAC9F');
commit;
prompt 5 records loaded
prompt Loading SYSLOG...
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('3D0849A466DD4282B6297E467276F8AD', to_timestamp('07-12-2019 17:26:16.617000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'blithe', '0:0:0:0:0:0:0:1', '/user/queryAll', 372, '【类名】class org.springframework.security.core.context.SecurityContextImpl【方法名】queryAll');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('B5D57B9BE04D425EBAD81DAF08809E62', to_timestamp('07-12-2019 17:28:08.727000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'blithe', '0:0:0:0:0:0:0:1', '/orders/queryAll', 0, '【类名】class org.springframework.security.core.context.SecurityContextImpl【方法名】queryAll');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('FBC54C23CED44EAA83470FF8AA8AC4A4', to_timestamp('07-12-2019 17:32:22.426000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'blithe', '0:0:0:0:0:0:0:1', '/permission/queryAll', 8, '【类名】class org.springframework.security.core.context.SecurityContextImpl【方法名】queryAll');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('E3D847253088424785221B86E5318636', to_timestamp('07-12-2019 17:32:25.273000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'blithe', '0:0:0:0:0:0:0:1', '/product/queryAll', 197, '【类名】class org.springframework.security.core.context.SecurityContextImpl【方法名】queryAllProduct');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('0A489203B7FC4940B02017FBFE85AFD4', to_timestamp('07-12-2019 17:32:46.830000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'blithe', '0:0:0:0:0:0:0:1', '/orders/queryAll', 0, '【类名】class org.springframework.security.core.context.SecurityContextImpl【方法名】queryAllProduct');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('E5B11B025F284491935D16752DAA2F5D', to_timestamp('07-12-2019 17:38:19.440000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'blithe', '0:0:0:0:0:0:0:1', '/orders/queryAll', 637, '【类名】class org.springframework.security.core.context.SecurityContextImpl【方法名】queryOrders');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('9977C140BDC24C8CAD976E6E2FADF2A8', to_timestamp('07-12-2019 17:47:48.140000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'zhangsan', '0:0:0:0:0:0:0:1', '/user/queryAll', 14, '【类名】class org.springframework.security.core.context.SecurityContextImpl【方法名】queryAll');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('649AF00A47F84124911CD3EDB56144D7', to_timestamp('07-12-2019 17:47:51.442000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'zhangsan', '0:0:0:0:0:0:0:1', '/sysLog/queryAll', 10, '【类名】class org.springframework.security.core.context.SecurityContextImpl【方法名】queryAll');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('C85C00505C7645F59A4B44652798E5D3', to_timestamp('07-12-2019 17:52:13.164000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'blithe', '0:0:0:0:0:0:0:1', '/sysLog/queryAll', 121, '【类名】class org.springframework.security.core.context.SecurityContextImpl【方法名】queryAll');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('C99B99DD4AD348CF9B4056CE0DE103E8', to_timestamp('07-12-2019 17:31:52.081000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'blithe', '0:0:0:0:0:0:0:1', '/permission/queryAll', 81, '【类名】class org.springframework.security.core.context.SecurityContextImpl【方法名】queryAll');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('66218FAEAD8B41E4A030A5D573649089', to_timestamp('07-12-2019 17:32:08.567000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'blithe', '0:0:0:0:0:0:0:1', '/orders/queryAll', 1, '【类名】class org.springframework.security.core.context.SecurityContextImpl【方法名】queryAll');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('A9E02D44639045E1B1F4870A5F7799CC', to_timestamp('07-12-2019 17:47:17.174000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'blithe', '0:0:0:0:0:0:0:1', '/sysLog/queryAll', 95, '【类名】class org.springframework.security.core.context.SecurityContextImpl【方法名】queryAll');
commit;
prompt 12 records loaded
prompt Loading USERS...
insert into USERS (id, email, username, password, phonenum, status)
values ('DB30D35D558D49DE9C2C0F7851C02B51', '1447177020@qq.com', 'nkxs', '$2a$10$9EHgjYh/vGkGgsLIzBJk3upEomqqmzpZKFp2Cimd5er8Uq47MTji2', '13344444444', 1);
insert into USERS (id, email, username, password, phonenum, status)
values ('9A07C13510A94CD58AF36532986D9C92', '1', 'test', '$2a$10$zvcJRRoEVwwnL2ZE17lzG.CLtzirSG.0wqE42ofh23cuVfik.849a', null, 0);
insert into USERS (id, email, username, password, phonenum, status)
values ('111-222', 'youjiannan@qq.com', 'blithe', '$2a$10$bLUQWKxqk3gVBVPchXunt.g9CaFMSFZ8IlUD2Rz1oQ5Gp4vvAlf0S', '18296557705', 1);
insert into USERS (id, email, username, password, phonenum, status)
values ('19FE8BAA814745CEB37C5696D8BF42AF', '3', 'aaa', '$2a$10$GTC2bN83uaDJRwyG6X6CL.zwDjSB8ngo7lmsYlmAabV78qqV/eCJS', '18296557705', 1);
insert into USERS (id, email, username, password, phonenum, status)
values ('58249EDFE6E04A66B56546BD2220CD31', '20160601120@stu.swpu.edu.cn', 'zhangsan', '$2a$10$6uBnz7F8JPvvYLPv52a0ieZx.JR1LRT10rKExuGE6ZXdrNdUE9feC', '18296557705', 1);
insert into USERS (id, email, username, password, phonenum, status)
values ('29C1D34C31FD4F59969EDEE2A2CC5418', '22', '111', '$2a$10$F.D4qcmyA7QJ6r6QxujXpeqR95FDfZf3c5r3dIz0J8DK1bx3Q/4YO', '12', 1);
commit;
prompt 6 records loaded
prompt Loading USERS_ROLE...
insert into USERS_ROLE (userid, roleid)
values ('111-222', '1111');
insert into USERS_ROLE (userid, roleid)
values ('111-222', '2222');
insert into USERS_ROLE (userid, roleid)
values ('29C1D34C31FD4F59969EDEE2A2CC5418', '2222');
insert into USERS_ROLE (userid, roleid)
values ('58249EDFE6E04A66B56546BD2220CD31', '1111');
insert into USERS_ROLE (userid, roleid)
values ('58249EDFE6E04A66B56546BD2220CD31', '2222');
insert into USERS_ROLE (userid, roleid)
values ('58249EDFE6E04A66B56546BD2220CD31', '71AF046BB6D14635962FF80FBEBEAC9F');
insert into USERS_ROLE (userid, roleid)
values ('9A07C13510A94CD58AF36532986D9C92', '2222');
insert into USERS_ROLE (userid, roleid)
values ('DB30D35D558D49DE9C2C0F7851C02B51', '1111');
insert into USERS_ROLE (userid, roleid)
values ('DB30D35D558D49DE9C2C0F7851C02B51', '2222');
commit;
prompt 9 records loaded
prompt Enabling foreign key constraints for ORDERS...
alter table ORDERS enable constraint SYS_C005444;
alter table ORDERS enable constraint SYS_C005445;
prompt Enabling foreign key constraints for ORDER_TRAVELLER...
alter table ORDER_TRAVELLER enable constraint SYS_C005448;
alter table ORDER_TRAVELLER enable constraint SYS_C005449;
prompt Enabling foreign key constraints for ROLE_PERMISSION...
alter table ROLE_PERMISSION enable constraint SYS_C005472;
alter table ROLE_PERMISSION enable constraint SYS_C005473;
prompt Enabling foreign key constraints for USERS_ROLE...
alter table USERS_ROLE enable constraint SYS_C005468;
alter table USERS_ROLE enable constraint SYS_C005469;
prompt Enabling triggers for MEMBER...
alter table MEMBER enable all triggers;
prompt Enabling triggers for PRODUCT...
alter table PRODUCT enable all triggers;
prompt Enabling triggers for ORDERS...
alter table ORDERS enable all triggers;
prompt Enabling triggers for TRAVELLER...
alter table TRAVELLER enable all triggers;
prompt Enabling triggers for ORDER_TRAVELLER...
alter table ORDER_TRAVELLER enable all triggers;
prompt Enabling triggers for PERMISSION...
alter table PERMISSION enable all triggers;
prompt Enabling triggers for ROLE...
alter table ROLE enable all triggers;
prompt Enabling triggers for ROLE_PERMISSION...
alter table ROLE_PERMISSION enable all triggers;
prompt Enabling triggers for SYSLOG...
alter table SYSLOG enable all triggers;
prompt Enabling triggers for USERS...
alter table USERS enable all triggers;
prompt Enabling triggers for USERS_ROLE...
alter table USERS_ROLE enable all triggers;
set feedback on
set define on
prompt Done.
