-- oder table check 조건 ocategory -> tour / shop 만 허용
alter table project.order add constraint order_ck check (ocategory in('tour','shop'));
alter table project.tour drop constraint maxpeople_ck;
alter table project.tour add constraint maxpeople_ck check (0<=tcurrent and tcurrent<13);


commit;