#!/usr/bin/env python

from faker import Faker

fake = Faker()

sql1 = "insert into employee(first_name, last_name, job_title, hired_date) values('%s', '%s', '%s', '%s');"
sql2 = "insert into project(project_name, deadline) values ('%s', '%s');"

for _ in range(20):
    firstName = fake.first_name()
    firstName.replace("'", "''")
    lastName = fake.last_name()
    lastName.replace("'", "''")
    jobTitle = fake.job()
    jobTitle.replace("'", "''")
    hiredDate = fake.date_time_between('-20y', '-1y').strftime('%Y-%m-%d')
    print(sql1 % (firstName, lastName, jobTitle, hiredDate))

for _ in range(1, 10):
    projectName = "Project " + str(_)
    deadline = fake.date_time_between('+0y', '+1y').strftime('%Y-%m-%d')
    print(sql2 % (projectName, deadline))
