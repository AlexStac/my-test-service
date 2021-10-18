create table if not exists driver_rating
(
    driver_id bigint      not null,
    rating    numeric(3,2)        not null,
    count_rating   int        not null,
    constraint driver_rating_uq
        unique (driver_id)
);

comment on table driver_rating is 'Рейтинг водителей';
comment on column driver_rating.driver_id is 'Идентификатор водителя';
comment on column driver_rating.rating is 'Рейтинг водителя';
comment on column driver_rating.count_rating is 'Количество оценок';