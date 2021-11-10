# prisma-task

Firstly, I import your data to db. I use postgres(docker).

I add swagger, you can use 
http://localhost:8080/swagger-ui/index.html#/
to test the rest services.

Extra time is needed for :

* imlementing tests
* code review
* dockerize

p.s. my solutions for use cases are very costly because of the given data tables. If we construct such relations we have to obey normalization rules. Then we can add the relations in to entities and get the desired result without implement hard coding. I mean that, when we have well designed relation, if we get the list of users then we also have their borrowed book inside of this. it is not the right way getting them seperately and create a logic using java to get desired solution.
