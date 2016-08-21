#!/usr/bin/env python

from faker import Faker

fake = Faker()

sql1 = "insert into employee(first_name, last_name, job_title, hired_date, address, phone, email) " + \
        "values('%s', '%s', '%s', '%s', '%s', '%s', '%s');"
sql2 = "insert into project(project_name, deadline) values ('%s', '%s');"

for _ in range(20):
    firstName = fake.first_name()
    firstName.replace("'", "''", 5)
    lastName = fake.last_name()
    lastName.replace("'", "''", 5)
    jobTitle = fake.job()
    jobTitle.replace("'", "''", 5)
    hiredDate = fake.date_time_between('-20y', '-1y').strftime('%Y-%m-%d')
    address = fake.address()
    phone = fake.phone_number()
    email = fake.email()
    print(sql1 % (firstName, lastName, jobTitle, hiredDate, address, phone, email))

for _ in range(1, 10):
    projectName = "Project " + str(_)
    deadline = fake.date_time_between('+0y', '+1y').strftime('%Y-%m-%d')
    print(sql2 % (projectName, deadline))
