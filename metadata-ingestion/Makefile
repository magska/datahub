PROJECT=metadata-ingestion
TEAM=data-exploration-and-security
PACKAGE_NAME=` echo $(PROJECT) | tr '-' '_'  `

PUSH_REGISTRY=l-docker-$(TEAM)-production.artifactory.klarna.net/$(TEAM)
PULL_REGISTRY=docker.artifactory.klarna.net/$(TEAM)

IMAGE_TAG=latest

DOCKER_IMAGE=datahub-${PACKAGE_NAME}:${IMAGE_TAG}
DOCKERFILE=Dockerfile
DOCKER_ARGS=-u 10000:10000 --entrypoint="" \
	-e AWS_ACCESS_KEY_ID=$(AWS_ACCESS_KEY_ID) \
	-e AWS_SECRET_ACCESS_KEY=$(AWS_SECRET_ACCESS_KEY) \
	-e AWS_SESSION_TOKEN=$(AWS_SESSION_TOKEN) \
	-w /$(PROJECT) -v `pwd`:/$(PROJECT) \
	-v $(HOME)/.aws:/root/.aws \


DOCKER_TEST_ARGS = $(DOCKER_ARGS) \
	  $(PULL_REGISTRY)/$(DOCKER_IMAGE)

default: help
help:
	@echo 'Usage: make [target] ...'
	@echo
	@echo 'Targets:'
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) \
	| awk 'BEGIN {FS = ":.*?## "}; {printf "%-16s %s\n", $$1, $$2}'

#----------- DOCKER ------------------------------------------------------------



docker-build: ## Build the docker image
	docker build \
	-t $(PUSH_REGISTRY)/$(DOCKER_IMAGE) \
	-t $(PULL_REGISTRY)/$(DOCKER_IMAGE) \
	-t ${DOCKER_IMAGE} \
	-f $(DOCKERFILE) .

docker-push: ## Push the docker image
	docker push $(PUSH_REGISTRY)/${DOCKER_IMAGE}

docker-pull: ## Pull the docker image
	pull $(PULL_REGISTRY)/$(DOCKER_IMAGE) \
	docker tag $(PULL_REGISTRY)/$(DOCKER_IMAGE) $(DOCKER_IMAGE) \
	docker tag $(PULL_REGISTRY)/$(DOCKER_IMAGE) $(PUSH_REGISTRY)/$(DOCKER_IMAGE)
