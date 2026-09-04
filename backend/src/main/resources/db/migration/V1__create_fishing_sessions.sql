create table fishing_session (
    id uuid primary key,
    owner_id varchar(64) not null,
    title varchar(80) not null,
    started_at timestamp with time zone not null,
    status varchar(16) not null check (status in ('ACTIVE', 'COMPLETED'))
);
