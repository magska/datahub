FROM  l-docker-data-exploration-and-security-production.artifactory.klarna.net/data-exploration-and-security/base/python:3.8-buster

USER root
COPY . .

#Python
RUN pip install --upgrade pip wheel && \
    pip install -e .
