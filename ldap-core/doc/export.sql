//When importing an insert statement file, please make sure that each insert statement must end with a semicolon(;)
//If you have exported a file as insert statements using Ldapsoft's tool, all the records already ends with semicolon(;)
//--------------------------------------------------------------------------------------------------------------------------------



INSERT into dc=maxcrc,dc=com 
(objectclass,objectclass,dc) 
 VALUES('domain','top','maxcrc');


INSERT into ou=People,dc=maxcrc,dc=com 
(objectclass,objectclass,ou,description) 
 VALUES('top','organizationalUnit','People','Container for user entries');


INSERT into ou=ZhengQianYe,ou=TianHe,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,mail,mobile,ou,uid) 
 VALUES(Base64Encoded('6YOR5Lm+5Lia'),'top','person','organizationalPerson','inetOrgPerson',Base64Encoded('6YOR'),'dearabc@qq.com','1501875099','ZhengQianYe','2012586412314');


INSERT into cn=suchunyu,cn=DaJieGroup,ou=SuJia,o=GuangMingPhoto,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,mail,mobile) 
 VALUES('suchunyu','top','person','organizationalPerson','inetOrgPerson','su','chunyu@qq.com','15018750881');


INSERT into cn=suchunyan,ou=SuJia,o=GuangMingPhoto,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,mail,mobile,uid) 
 VALUES('suchunyan','top','person','organizationalPerson','inetOrgPerson','su','chuyan@qq.com','15018750882','20180624123456');


INSERT into cn=humeifeng,cn=FuQinJia,ou=SuJia,o=GuangMingPhoto,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,mail,mobile) 
 VALUES('humeifeng','top','person','organizationalPerson','inetOrgPerson','hu','meifeng@qq.com','15018750883');


INSERT into cn=WuHaiSheng,cn=DaJieGroup,ou=SuJia,o=GuangMingPhoto,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,mail,mobile) 
 VALUES('WuHaiSheng','top','person','organizationalPerson','inetOrgPerson','Wu','haisheng@qq.com','15236578512');


INSERT into cn=SuChunLai,ou=SuJia,o=GuangMingPhoto,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,mail,mobile) 
 VALUES('SuChunLai','top','person','organizationalPerson','inetOrgPerson','Su','chunlai@qq.com','15485468569');


INSERT into ou=ZongWuChu,dc=maxcrc,dc=com 
(objectclass,objectclass,ou) 
 VALUES('top','organizationalUnit','ZongWuChu');


INSERT into cn=JieSuanGroup,ou=ZongWuChu,dc=maxcrc,dc=com 
(cn,member,objectclass,objectclass) 
 VALUES('JieSuanGroup','ou=ZongWuChu,dc=maxcrc,dc=com','top','groupOfNames');


INSERT into cn=SuWangLiang,cn=FuQinJia,ou=SuJia,o=GuangMingPhoto,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,mail) 
 VALUES('SuWangLiang','top','person','organizationalPerson','inetOrgPerson','Su','wangliang@qq.com');


INSERT into cn=LinXiaoLian,cn=JieSuanGroup,ou=ZongWuChu,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,mail,mobile) 
 VALUES('LinXiaoLian','top','person','organizationalPerson','inetOrgPerson','Lin','xiaolian@qq.com','15878569647');


INSERT into cn=WangShuaiJie,cn=JieSuanGroup,ou=ZongWuChu,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,mail,mobile) 
 VALUES('WangShuaiJie','top','person','organizationalPerson','inetOrgPerson','Wang','shuaijie@qq.com','16895645852');


INSERT into cn=CeShiGroup,ou=ZongWuChu,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,uniquemember) 
 VALUES('CeShiGroup','top','groupOfUniqueNames','ou=ZongWuChu,dc=maxcrc,dc=com');


INSERT into cn=LiZhouMin,cn=CeShiGroup,ou=ZongWuChu,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,mail,mobile) 
 VALUES('LiZhouMin','top','person','organizationalPerson','inetOrgPerson','Li','zhoumin@qq.com','15785696568');


INSERT into cn=LiDong,ou=ZongWuChu,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,mail,mobile) 
 VALUES('LiDong','top','person','organizationalPerson','inetOrgPerson','Li','lidong@qq.com','0203586578');


INSERT into ou=TianHe,dc=maxcrc,dc=com 
(objectclass,objectclass,ou) 
 VALUES('top','organizationalUnit','TianHe');


INSERT into o=GuangMingPhoto,dc=maxcrc,dc=com 
(o,objectclass,objectclass) 
 VALUES('GuangMingPhoto','top','organization');


INSERT into ou=SuJia,o=GuangMingPhoto,dc=maxcrc,dc=com 
(objectclass,objectclass,ou) 
 VALUES('top','organizationalUnit','SuJia');


INSERT into cn=DaJieGroup,ou=SuJia,o=GuangMingPhoto,dc=maxcrc,dc=com 
(cn,member,objectclass,objectclass) 
 VALUES('DaJieGroup','cn=DaJieGroup,ou=SuJia,dc=maxcrc,dc=com','top','groupOfNames');


INSERT into cn=FuQinJia,ou=SuJia,o=GuangMingPhoto,dc=maxcrc,dc=com 
(cn,member,objectclass,objectclass) 
 VALUES('FuQinJia','ou=SuJia,dc=maxcrc,dc=com','top','groupOfNames');


INSERT into cn=LiuCuiLan,o=GuangMingPhoto,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,mail) 
 VALUES('LiuCuiLan','top','person','organizationalPerson','inetOrgPerson','Liu','liulan@qq.com');


INSERT into ou=ZhengQianYe2,ou=TianHe,dc=maxcrc,dc=com 
(cn,objectclass,objectclass,objectclass,objectclass,sn,carlicense,description,mail,mobile,ou,uid) 
 VALUES(Base64Encoded('6YOR5Lm+5LiaMg=='),'top','person','organizationalPerson','inetOrgPerson',Base64Encoded('6YOR'),'c',Base64Encoded('5LyY56eA55qE5Lq6'),'dearabc@qq.com','1501875099','ZhengQianYe2','20125864123143333');


INSERT into cn=zhengqianye3,ou=TianHe,dc=maxcrc,dc=com 
(cn,sn,description,objectclass) 
 VALUES('zhengqianye3',Base64Encoded('6YORMDAw'),Base64Encoded('5Y2B5YiG5LyY56eA55qE5Lq6MjAwMA=='),'person');


