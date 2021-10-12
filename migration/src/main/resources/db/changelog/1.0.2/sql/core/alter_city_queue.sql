alter table city_queue add column if not exists port varchar(10);
alter table city_queue add unique (port);
alter table city_queue add primary key (city_id);