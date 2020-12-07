-- INSERT EMPLOYEES
insert into employee (employee_id, firstname, lastname, email, role) values (nextval('employee_seq'), 'John', 'Doe', 'Johndoe@gmail.com', 'IT Manager');

-- INSERT PROJECTS
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production');

-- INSERT PROJECT_EMPLOYEE_RELATION
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.lastname ='Doe' AND p.name = 'Large Production Deploy');

-- INSERT USER
insert into user_accounts (user_id, username, email, password, role, enabled) values (nextval('user_accounts_seq'), 'admin', 'admin@admin.com', '$2a$10$CnvzCuy5EwoSwv6NW9AsIO9Loqdka0PG.sfLkeyNZsd86cQdjwaai', 'ADMIN', 'true');