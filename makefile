compile:
	mvn exec:java -Dexec.mainClass="org.acme.Runner"


test:
	test

git: 
	git add .
	git commit -m "$(msg)"
	git push -u origin main


build: 
	docker build -t my-operator . 

run:
	docker network create my-network
	docker run --network my-network --name op my-operator

remove:
	docker stop op
	docker remove op