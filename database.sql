
create database claims;
use claims;
drop table claim_request;
create table claim_request (
                               id int primary key auto_increment,
                               claimDate timestamp default current_timestamp(),
                               insuredPerson varchar(55),
                               cardNumber varchar(55),
                               examDate DATE,
                               document varchar(55),
                               claimAmount bigint,
                               `status` varchar(10),
                               receiverBankName varchar(55),
                               receiverBankAccount varchar(55),
                               notes text
);

create table customer (
                          id int primary key auto_increment,
                          fullName varchar(55),
                          insuranceCard varchar(55)
);

insert into customer(fullName, insuranceCard)  values('Tran Van Nguyen', '03021030301');

drop table dependent;
create table dependent (
                           id int primary key auto_increment,
                           customerId int,
                           denpendentId int,
                           foreign key (customerId) references customer(id),
                           foreign key (denpendentId) references customer(id)

);

