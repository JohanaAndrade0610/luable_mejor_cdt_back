create table if not exists user_info
(
    user_id  bigint primary key not null,
    name varchar(50) not null,
    email varchar(50),
    identification varchar(30),
    user_image_url varchar(50)
);

create table if not exists user_investment
(
    user_investment_id  bigint primary key not null,
    user_user_id int8 not null,
    amount decimal(18, 2),
    rate decimal(18, 2),
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    bank_name varchar(50),
    roi decimal(18,2)
);

alter table user_investment
    add constraint FK_user_id foreign key (user_user_id) references user_info (user_id);