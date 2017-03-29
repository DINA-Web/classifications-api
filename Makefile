#!make

APIB = blueprint.apib
PWD = $(shell pwd)

all: init up dox report

init:
	# need to do this bec the dredd validator complains on .apib format with tabs
	cat classifications.apib | tr -d '\t' > $(APIB) 
up:
	docker network create mockery
	docker run -d --name mock --network mockery \
		-v $(PWD)/$(APIB):/usr/src/app/api.md -p 3000:3000 \
		ajnasz/api-mock

down:
	docker stop mock
	docker rm -vf mock
	docker network rm mockery

test:
	docker run -it --rm --network mockery \
		-v $(PWD):/tmp apiaryio/dredd \
		dredd /tmp/$(APIB) http://mock:3000

report:
	docker run -it --rm --network mockery \
		-v $(PWD):/tmp apiaryio/dredd \
		dredd /tmp/$(APIB) http://mock:3000 --dry-run > $(APIB).log

dox:
	docker run -ti --rm -v $(PWD):/docs humangeo/aglio \
		/usr/local/bin/aglio -i $(APIB) -o $(APIB).html

clean:
	rm -f $(APIB) $(APIB).html $(APIB).log

swagger2apib:
	docker run -ti --rm -v $(PWD):/tmp apiaryio/nodejs-ruby:4 bash -c \
		"npm install -g swagger2blueprint \
		npm install -g swagger-converter \
		npm install -g api-spec-converter \
		npm install swagger-tools \
		npm install -g swagger-tools" 



