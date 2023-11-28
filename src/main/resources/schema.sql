create table if not exists item (
  id identity,
  name varchar(50) not null,
  brand varchar(50) not null,
  year_of_creation int not null,
  price float not null
);