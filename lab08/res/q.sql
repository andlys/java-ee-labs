use lys_db;
select * from student;
select * from student_contact;
select * from discipline;
select * from faculty;
select * from enrollment;
select * from lectures;
delete from discipline where id > 3;
delete from discipline where id = 2;
select 
    e_s.id as eid,
    e_s.did,
    d.name,
    d.credits,
    e_s.sid,
    e_s.fio,
    e_s.course
from
    (select 
        e.id, e.id_discipline AS did, s.id AS sid, s.fio, s.course
    from
        enrollment e
    join student s ON e.id_student = s.id) e_s
        join
    discipline d ON d.id = e_s.did
group by d.name , e_s.id , e_s.did , d.credits , e_s.sid , e_s.fio , e_s.course;
select now();
insert into student (fio, course) values ('asgdfg', 4);
