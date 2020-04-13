#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t registry.cn-shanghai.aliyuncs.com/jason-scloud/product .

docker push registry.cn-shanghai.aliyuncs.com/jason-scloud/product