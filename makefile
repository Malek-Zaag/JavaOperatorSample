compile:
	mvn exec:java -Dexec.mainClass="org.acme.Runner"


test:
	test

git: 
	git add .
	git commit -m "$(msg)"
	git push -u origin main