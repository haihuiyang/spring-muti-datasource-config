###多数据源配置：

**测试环境：同一台机器的两个不同的 schema，建表语句及 mock 数据如下：**

    ```mysql
    create database test1;
    create database test2;
    
    create table if not exists test1.`student` (
        `id` int(4) not null auto_increment,
        `student_name` varchar(32),
        `age` int(11),
        primary key(`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    create table if not exists test2.`teacher` (
        `id` int(4) not null auto_increment,
        `teacher_name` varchar(32),
        `age` int(11),
        primary key(`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    insert into test1.student (id, student_name, age) values (1, 'jack', 18);
    insert into test1.student (id, student_name, age) values (2, 'HappyFeet', 20);
    
    insert into test2.teacher (id, teacher_name, age) values (1, 'teacherA', 38);
    insert into test2.teacher (id, teacher_name, age) values (2, 'teacherB', 42);
    
    ```
    