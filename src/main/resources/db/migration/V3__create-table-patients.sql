create table doctors(

    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    phone varchar(8) not null,
    street varchar(100) not null,
    neighbourhood varchar(100) not null,
    zipCode varchar(9) not null,
    additionalInfo varchar(100),
    number varchar(20),
    state char(2) not null,
    city varchar(100) not null,

    primary key(id)

);