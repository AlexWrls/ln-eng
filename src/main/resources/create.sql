
create table public.words
(
    id        BIGSERIAL    not null primary key,
    word      varchar(100) not null,
    translate varchar(100) not null
);


-- ALTER TABLE public.profile
--     OWNER TO abnkxgdxakdjgr;
-- ALTER TABLE public.role
--     OWNER TO abnkxgdxakdjgr;
-- ALTER TABLE public.words
--     OWNER TO abnkxgdxakdjgr;
-- ALTER TABLE public.result_game
--     OWNER TO abnkxgdxakdjgr;

-- ================== INSERT ==========================

-- insert into public.profile( email, password)
-- VALUES ( 'bot-1', '$2a$10$HZLjPcuBehaPThFuBktD8u.g7qNKvrZ/3z7Rwn3u2ee3twwduJgMq');

--
-- insert into public.role(id_profile, role)
-- VALUES (1, 'USER');

