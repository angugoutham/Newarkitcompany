CREATE TABLE `customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `Fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `username` varchar(40) NOT NULL UNIQUE,
  `password` varchar(40) NOT NULL,
  `email` varchar(20) ,
  `address` varchar(100),
  `phone` int(11) DEFAULT NULL,
  `status` varchar(20),
  PRIMARY KEY (`cid`) 
); 
create table silver_and_above(
cid int(11)not null,
creditline varchar(20),
primary key(cid),
foreign key(cid)REFERENCES customer(cid) on update cascade on delete cascade 
);

CREATE TABLE  creditcard ( 
cid int(10)not null,
creditcardnumber varchar(11) NOT NULL,
secnumber varchar(20) NOT NULL,
ownername varchar(20) NOT NULL,
CCTYPE varchar(10) NOT NULL,
ccADDRESS varchar(20) NOT NULL,
EXPDATE varchar(20) NOT NULL,
PRIMARY KEY(creditcardnumber),
foreign key(cid)REFERENCES customer(cid) on update cascade on delete cascade 
);

create table Shipping_address
(
cusid int(11)not null,
saname varchar(100) not null,
recipientname varchar(20),
street varchar(20),
snumber varchar(10),
city varchar(20),
zip varchar(20),
state varchar(20),
country varchar(20),
constraint Pk_1 primary key (cusid,saname),
foreign key (cusid) references customer(cid)on update cascade on delete cascade 
 );


 create table product
 (
 pid int(20)not null AUTO_INCREMENT,
 ptype varchar(25)default 'NA',
 pname varchar(20)default 'NA',
 description varchar(20)default 'NA',
 cputype varchar(20)default 'NA',
 printertype varchar(20)default 'NA',
 resolution varchar(20)default 'NA',
 btype varchar(20)default 'NA',
 weight varchar(20)default 'NA',
 pprice int(10),
 offerprice int(10)default '0',
 Pquantity int(10),
 primary key (pid)
 );
create table cart(
		cartid int(10) not NULL AUTO_INCREMENT, 
		cid int(10)not null,
		shippingaddressname varchar(100) not null,
		ccnumber varchar(11)not null,
		tstatus varchar(20), 
		tdate date, 
		Primary Key (cartid),
		Foreign Key (cid,shippingaddressname) references Shipping_address(cusid,saname)on update cascade on delete cascade,	
		Foreign Key (ccnumber) references creditcard(creditcardnumber)on update cascade on delete cascade
		);
		
create table appears_in
		(cartid int(11) NOT NULL,
		pid int(20),
		quantity int(20),
		pricesold int(20),
			constraint primary key (cartid,pid),
		Foreign Key (cartid) references cart(cartid)on update cascade on delete cascade,
		Foreign Key (pid) references product(pid)on update cascade on delete cascade
);
	create table price_sold(
	pid int (11) not null,
	pricesold varchar(20),
	primary key(pid),
	Foreign Key (pid) references product(pid)on update cascade on delete cascade
	);
	
 



INSERT INTO product ( ptype,pprice, pname,description, Pquantity, cputype, printertype, offerprice, btype, weight )
VALUES ('computer','1999', 'Hp','New', '12', 'i5', 'HP', '1900', 'Ion', '6pounds' );

INSERT INTO product ( ptype, pname, pprice, description, Pquantity, cputype, printertype, resolution)
VALUES ('Laptop', 'ASUS', '1399', 'Refurbished', '10', 'i3', 'Brother', '1920*1080');

INSERT INTO product ( pquantity,pprice,ptype, pname, description, cputype, printertype, resolution, offerprice, btype)
VALUES ('150','1020','Computer', 'Lenovo', 'Refurbished', 'i7', 'Canon', '1920*1080', '900', 'Ion' );

INSERT INTO product ( pquantity,description,ptype, pname, pprice, printertype, resolution, offerprice, btype, weight )
VALUES ('200','new','Laptop', 'HP', '599', 'HP', '3840*2160', '499', 'Ion', '5pounds' );

INSERT INTO product ( pname,description,pprice,ptype,pprice,description, Pquantity, cputype, printertype, resolution, offerprice, btype, weight )
VALUES ('printer','990','Returned', '21', 'pentium 5', 'Canon', '1600*900', '900', 'Ion', '6pounds' );

INSERT INTO product ( description,ptype, pname,pprice, Pquantity, cputype, printertype, resolution, offerprice, btype, weight )
VALUES ('new','Printer', 'DELL', '2600', '980','i7', 'HP', '1080*640', '900', 'Ion', '6pounds' );

INSERT INTO product ( Pquantity,ptype, pname, pprice, description, resolution, offerprice, btype, weight )
VALUES ('100','Printer', 'Alienware', '1500', 'Refurbished', '2150*1080', '1200', 'Lithium', '7pounds' );

INSERT INTO product ( pname,ptype, pprice, description, Pquantity, cputype, printertype, resolution, weight )
VALUES ('asus','Computer', '1000', 'Refurbished', '10', 'i3', 'Luther', '1280*840', '5pounds' );
