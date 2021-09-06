select * from orders;
select * from tour;
select * from payment;

-- 결제 insert test example
insert into payment(pprice,pway,pstatus,oidx) values(66000,'card','complete',74);
update payment set pdate = '2021-09-05' where pidx=1;

select * from payment natural join orders natural join tour natural join member;
select * from payment natural join tour where tdate='2021-09-06';
-- 결제 내역 조회[투어] 
-- 결제번호,카테고리,예약 날짜,인원,이름[다른 방법으로 가져오기],주문 번호,결제 방법,결제 금액,결제 일
select pidx,ocategory,tdate,tpeople,oidx,pway,pprice,pdate
from payment natural join orders natural join tour 
where pstatus='complete';

select * from payment where pstatus='complete' and oidx = (select oidx from orders where midx=3 and ocategory ='tour');









