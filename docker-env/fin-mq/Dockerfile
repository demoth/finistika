FROM rabbitmq:management
MAINTAINER Kanedias (kairllur@yandex.ru)

#ENV RABBITMQ_DEFAULT_USER chara
#ENV RABBITMQ_DEFAULT_PASS determination

COPY rabbitmq.config /etc/rabbitmq/
COPY predefined-queues.json /etc/rabbitmq/conf.d/
