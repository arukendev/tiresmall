--FAQ(작성중)
create table faq (
    f_no number(5) primary key,
    f_sortation varchar2(20 char) not null,
    f_title varchar2(100 char) not null,
    f_txt varchar2(2000 char) not null,
    f_date date not null
);
create sequence faq_seq;
insert into faq values(faq_seq.nextval, '주문배송', 'title1', 'txt1', sysdate);
insert into faq values(faq_seq.nextval, '상품', 'title2', 'txt2', sysdate);
insert into faq values(faq_seq.nextval, '장착', 'title3', 'txt3', sysdate);
insert into faq values(faq_seq.nextval, '반품교환취소', 'title4', 'txt4', sysdate);
insert into faq values(faq_seq.nextval, '기타', 'title5', 'txt5', sysdate);
select * from faq;