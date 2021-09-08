select * from orders;
-- 주문 정보를 가져오는 sql
select mname,date_format(tdate,'%Y-%m-%d') as tdate,tpeople,mphone from orders natural join member natural join tour where midx = 3 and ocategory='tour';

-- 예약 변경 주문 테이블
update orders set tidx = (select tidx from tour where tdate = '2021-09-07') where midx =3;
-- 예약 변경 [기존 날짜]
update tour set tcurrent = tcurrent -(select tpeople from orders where midx = 3) where tdate = '2021-09-08';
-- 예약 변경 [바뀐 날짜]
update tour set tcurrent = tcurrent +(select tpeople from orders where midx = 3) where tdate = '2021-09-07';

-- 투어 주문 생성`
insert into orders 
(ocategory,tidx,midx,oprice,tpeople) 
values(
	'tour',
    (select tidx from tour where tdate='2021-09-06'),
    (select midx from member where memail='cool2' and mname='정비트' and mphone='01044455585'),
	66000,
    3
);

-- 투어 주문 내역 조회 test - join 이용
-- 주문번호, 멤버이름,휴대전화,카테고리,예약날짜,인원,총금액,주문날짜 
select oidx,mname,mphone,ocategory,tdate,tpeople,oprice,odate 
from orders  natural join member natural join tour 
where ocategory = 'tour' and memail='cool2' and midx=3;