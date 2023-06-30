create table comment
(
    comment_id bigint,
    id         bigint       not null auto_increment,
    post_id    bigint       not null,
    user_id    bigint       not null,
    message    varchar(2048) not null,
    primary key (id)
) engine = InnoDB;

create table country
(
    id   bigint       not null auto_increment,
    name varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table post
(
    deactivated_at datetime(6),
    id             bigint       not null auto_increment,
    user_id        bigint       not null,
    body           varchar(2048) not null,
    title          varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table post_tag
(
    post_id bigint not null,
    tag_id  bigint not null,
    primary key (post_id, tag_id)
) engine = InnoDB;;

create table role
(
    id   bigint       not null auto_increment,
    name varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table tag
(
    id   bigint       not null auto_increment,
    name varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table time_zone
(
    id   bigint       not null auto_increment,
    name varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table user
(
    birth_date   datetime(6),
    country_id   bigint,
    id           bigint       not null auto_increment,
    time_zone_id bigint,
    about        varchar(2048),
    display_name varchar(255) not null,
    email        varchar(255) not null,
    password     varchar(255) not null,
    photo        varchar(255),
    social_links varchar(255),
    primary key (id)
) engine = InnoDB;

create table user_role
(
    role_id bigint not null,
    user_id bigint not null,
    primary key (role_id, user_id)
) engine = InnoDB;

alter table comment
    add constraint fk_comment_user_id foreign key (user_id) references user (id);

alter table comment
    add constraint fk_comment_comment_id foreign key (comment_id) references comment (id);

alter table comment
    add constraint fk_comment_post_id foreign key (post_id) references post (id);

alter table post
    add constraint fk_post_user_id foreign key (user_id) references user (id);

alter table post_tag
    add constraint fk_post_tag_post_id foreign key (post_id) references post (id);

alter table post_tag
    add constraint fk_post_tag_tag_id foreign key (tag_id) references tag (id);

alter table user
    add constraint fk_user_country_id foreign key (country_id) references country (id);

alter table user
    add constraint fk_user_time_zone_id foreign key (time_zone_id) references time_zone (id);

alter table user_role
    add constraint fk_user_role_role_id foreign key (role_id) references role (id);

alter table user_role
    add constraint fk_user_role_user_id foreign key (user_id) references user (id);