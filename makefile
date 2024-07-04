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

clean:
	kubectl delete -f deployment/deployment.yaml
	kubectl delete -f deployment/rbac.yaml

deploy: 
	kubectl apply -f deployment/namespace.yaml
	kubectl apply -f deployment/deployment.yaml
	kubectl apply -f deployment/rbac.yaml
	kubectl apply -f deployment/crd.yaml
	kubectl apply -f deployment/cr.yaml