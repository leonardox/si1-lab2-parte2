# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tarefa (
  id                        bigint not null,
  nome                      varchar(255),
  prioridade                varchar(255),
  semana                    integer,
  constraint pk_tarefa primary key (id))
;

create sequence tarefa_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists tarefa;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists tarefa_seq;

