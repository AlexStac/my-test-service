alter table taxi_drive_info add column if not exists busy_indicator boolean default true;
alter table taxi_drive_info add column if not exists rating int;
alter table taxi_drive_info add column if not exists city_id int;
alter table taxi_drive_info add constraint taxi_drive_city_fk foreign key (city_id)
    references city_queue(city_id);
alter table taxi_drive_info drop column car_model;
alter table taxi_drive_info add column if not exists car_id int;
alter table taxi_drive_info add constraint taxi_drive_car_fk foreign key (car_id)
    references car(id);