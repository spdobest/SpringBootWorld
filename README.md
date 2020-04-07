## How to do JDBC authentication with Spring Security
https://www.youtube.com/watch?v=LKvrFltAgCQ&list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE&index=7  
- In this tutorial we will learn how to connect external database like oracle, mysql etc
- In this JDBC authentication
    - We will check the admin id and password stored in the external database
    - if it matches, then it will move forward otherwise it will show error.
    - DataSource
    -  add user and admin id and password
    ```
       auth.jdbcAuthentication()
                      .dataSource(dataSource)
                      .withDefaultSchema()
                      .withUser(
                              User.withUsername("user")
                              .password("pass")
                              .roles("USER")
                      )
                      .withUser(
                              User.withUsername("admin")
                                      .password("pass")
                                      .roles("ADMIN")
                      );
    ```
- The default schema we got from the spring framework is available in below link
https://docs.spring.io/spring-security/site/docs/4.0.4.RELEASE/reference/html/appendix-schema.html
- Create a file named schema.sql and paste the below code
```
create table users(
      username varchar_ignorecase(50) not null primary key,
      password varchar_ignorecase(50) not null,
      enabled boolean not null);

  create table authorities (
      username varchar_ignorecase(50) not null,
      authority varchar_ignorecase(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));

      create unique index ix_auth_username on authorities (username,authority);

```
- Now create a data.swl file and insert data into users and authority table
```
INSERT INTO users(username,password,enabled)
values ('user','pass',true);

INSERT INTO users(username,password,enabled)
values ('admin','pass',true);

INSERT INTO authorities(username,authority)
values ('user','ROLE_USER');

INSERT INTO authorities(username,authority)
values ('admin','ROLE_ADMIN');
```