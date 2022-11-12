create table public.words
(
    id        BIGSERIAL    not null primary key,
    word      varchar(100) not null,
    translate varchar(100) not null
);

-- ================== DELETE STOP WORD ==========================
delete from words
where word like'%fuck%'
   or word like'crap%'
   or word like'%whore%'
   or word like'%slut%'
   or word like'%douchebag%'
   or word like'%gay%'
   or word like'%faggot%'
   or word like'%homo%'
   or word like'%bastard%'
   or word like'%asshole%'
   or word like'%jerk%'
   or word like'%prick%'
   or word like'%dick%'
   or word like'%cunt%'
   or word like'%pussy%'
   or word like'%sucker%'
   or word like'%nerd%'
   or word like'%dumb%'
   or word like'%fool%'
   or word like'%stupid%'
   or word like'%retard%'
   or word like'%bitch%';

