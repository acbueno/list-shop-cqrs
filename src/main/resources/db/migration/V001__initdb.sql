  	create table product (
        amount integer not null,
        price float(53) not null,
        total_price float(53) not null,
        id bigint not null auto_increment,
        purchase_id bigint not null,
        brand_name varchar(255) not null,
        description varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

       create table purchase (
        date_purchase date,
        id bigint not null auto_increment,
        namePurchase varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

     alter table product
       add constraint FKmufb7e3fv0laaooxy88vvwkcg
       foreign key (purchase_id)
       references purchase (id);