### `SpringBoot`多数据源配置：

### 博客地址：[SpringBoot 多数据源配置](https://blog.csdn.net/haihui_yang/article/details/84720542)

**测试环境：同一台机器的两个不同的 `schema`，建表语句及 mock 数据如下：**

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
    
#### 验证方式

**note: 首先在本地数据库执行上面的 sql 语句，然后修改 `application.yml` 中对应的数据库配置，然后可以通过以下两种方式验证：**

1. `MutiDaoIT#muti_dao_IT` 集成测试，跑过即可（需要注意的是，跑的时候需要将 `build.gradle` 中 `exclude '**/*IT.java'` 注释掉才行）

2. 启动 `SpringBoot` 应用，然后请求 `http://localhost:8888/api/muti-data` 会得到以下数据：

    ```json
    [
        {
            "id": 1,
            "studentName": "jack",
            "age": 18
        },
        {
            "id": 2,
            "studentName": "HappyFeet",
            "age": 20
        },
        {
            "id": 1,
            "teacherName": "teacherA",
            "age": 38
        },
        {
            "id": 2,
            "teacherName": "teacherB",
            "age": 42
        }
    ]
    ``` 