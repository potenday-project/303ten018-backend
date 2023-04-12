INSERT INTO MEMBER (id, login_id, password, name, sex, nickname, contact, age) VALUES(1,'test1','{bcrypt}$2a$10$NhckqMZ4Afg23ImctN0xwOqxWi8H1Vfh2yNEWhq12txTz066WpI2y','테스트1','MAN','testnick1','aaaaa1',11);
INSERT INTO MEMBER (id, login_id, password, name, sex, nickname, contact, age) VALUES(2,'test2','{bcrypt}$2a$10$NhckqMZ4Afg23ImctN0xwOqxWi8H1Vfh2yNEWhq12txTz066WpI2y','테스트2','WOMAN','testnick2','aaaaa2',12);
INSERT INTO MEMBER (id, login_id, password, name, sex, nickname, contact, age) VALUES(3,'test3','{bcrypt}$2a$10$NhckqMZ4Afg23ImctN0xwOqxWi8H1Vfh2yNEWhq12txTz066WpI2y','테스트3','MAN','testnick3','aaaaa3',13);

INSERT INTO place (id, detail_address, short_address) VALUES(1, '테스트상세지역1', '테스트간략지역1');
INSERT INTO place (id, detail_address, short_address) VALUES(2, '테스트상세지역2', '테스트간략지역2');
INSERT INTO place (id, detail_address, short_address) VALUES(3, '테스트상세지역3', '테스트간략지역3');

INSERT INTO member_roles (member_id, roles) VALUES(1,'USER');
INSERT INTO member_roles (member_id, roles) VALUES(2,'USER');
INSERT INTO member_roles (member_id, roles) VALUES(3,'USER');

INSERT INTO board(id, create_date, modified_date, contents, meeting_date, participants_number, status, title, place_id) VALUES(1, TIMESTAMP '2023-04-11 11:48:39.150669', TIMESTAMP '2023-04-11 11:49:58.004084', '테스트 내용1', DATE '2023-04-01', 11, 'CLOSED', '테스트 게시판1', 1);
INSERT INTO board(id, create_date, modified_date, contents, meeting_date, participants_number, status, title, place_id) VALUES(2, TIMESTAMP '2023-04-12 11:48:39.150669', TIMESTAMP '2023-04-12 11:49:58.004084', '테스트 내용2', DATE '2023-04-02', 12, 'CLOSED', '테스트 게시판2', 2);
INSERT INTO board(id, create_date, modified_date, contents, meeting_date, participants_number, status, title, place_id) VALUES(3, TIMESTAMP '2023-04-13 11:48:39.150669', TIMESTAMP '2023-04-13 11:49:58.004084', '테스트 내용3', DATE '2023-04-03', 13, 'CLOSED', '테스트 게시판3', 3);

INSERT INTO board_membership(id, status, board_id, member_id) VALUES(1, 'REQUEST', 1, 1);
INSERT INTO board_membership(id, status, board_id, member_id) VALUES(2, 'REQUEST', 1, 2);
INSERT INTO board_membership(id, status, board_id, member_id) VALUES(3, 'REQUEST', 1, 3);
INSERT INTO board_membership(id, status, board_id, member_id) VALUES(4, 'REQUEST', 2, 2);
INSERT INTO board_membership(id, status, board_id, member_id) VALUES(5, 'REQUEST', 2, 3);
INSERT INTO board_membership(id, status, board_id, member_id) VALUES(6, 'REQUEST', 3, 1);
INSERT INTO board_membership(id, status, board_id, member_id) VALUES(7, 'REQUEST', 3, 3);
