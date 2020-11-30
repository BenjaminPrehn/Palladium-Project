-- INSERT EMPLOYEES
insert into employee (employee_id, firstname, lastname, email, role) values (nextval('employee_seq'), 'John', 'Doe', 'Johndoe@gmail.com', 'IT Manager');

-- INSERT PROJECTS
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production');

