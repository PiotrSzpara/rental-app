drop table if exists apartments;
create table apartments(
    id int primary key auto_increment,
    name varchar(50) not null,
    price double not null ,
    area double not null ,
    description varchar(200)
)