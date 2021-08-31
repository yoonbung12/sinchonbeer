-- 멤버 테이블(member)
create table project.member(
midx int not null primary key,
memail varchar(50) not null,
mname varchar(50) not null,
mpw varchar(50) not null,
mphone varchar(30) not null
);
desc member;

-- 상품 테이블(goods)
create table project.goods(
	gidx int not null primary key,
    gname varchar(20) not null,
    gprice int not null,
    gphoto varchar(45) not null,
    gtext text not null
);
desc goods;

-- 장바구니 테이블(basket)
create table project.basket(
bidx int not null primary key,
bcount int not null,
midx int not null,
gidx int not null,
foreign key(midx) references project.member(midx),
foreign key(gidx) references project.goods(gidx)
);
desc project.goods;

-- 투어 테이블(tour)
create table project.tour(
tidx int not null primary key,
tdate date not null,
tcurrent int not null,
ttotal int not null,
tprice int not null
);
desc project.tour;

-- 주소 테이블(address)
create table project.address(
aidx int not null primary key,
address varchar(255) not null,
midx int not null,
foreign key(midx) references project.member(midx)
);
desc project.address;

-- 주문 테이블(order)
create table project.order(
oidx int not null primary key,
odate date not null,
ocategory varchar(20) not null,
tidx int not null,
midx int not null,
aidx int not null,
foreign key(tidx) references project.tour(tidx),
foreign key(midx) references project.member(midx),
foreign key(aidx) references project.address(aidx)
);
desc project.order;
alter table project.order add  oprice int not null;

-- 결제 테이블(payment)
create table project.payment(
pidx int not null primary key,
pprice int not null,
pdate date not null,
pway varchar(10) not null,
pstatus varchar(10) not null,
oidx int not null,
foreign key(oidx) references project.order(oidx)
);
desc project.payment;

-- 리뷰 테이블(review)
create table project.review(
ridx int not null primary key,
rtitle varchar(255) not null,
rtext text not null,
rphoto varchar(45) ,
rdate date not null,
rcategory varchar(20) not null,
rlikes int,
pidx int not null,
foreign key(ridx) references project.payment(pidx)
);
desc project.review;

-- 댓글 테이블(comment)
create table project.comment(
cidx int not null primary key,
rpdate date not null,
ctext text not null,
ridx int not null,
midx int not null,
foreign key(ridx) references project.review(ridx),
foreign key(midx) references project.member(midx)
);
commit;
