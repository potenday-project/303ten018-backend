INSERT INTO MEMBER (id, login_id, password, name, sex, nickname, contact, age) VALUES(1,'test3','{bcrypt}$2a$10$NhckqMZ4Afg23ImctN0xwOqxWi8H1Vfh2yNEWhq12txTz066WpI2y','테스트','MAN','testnick2','aaaaa2',12);
INSERT INTO place (id, detail_address, short_address) VALUES(1, '테스트상세지역', '테스트간략지역');
INSERT INTO member_roles (member_id, roles) VALUES(1,'USER');
