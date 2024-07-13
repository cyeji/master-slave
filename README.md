# master-slave

## 개요

`가상 면접 사례로 배우는 대규모 시스템 설계` 책에서 언급된 내용을 토대로 직접 구현해보기

## 기술스택

- mysql
- docker
- springBoot

## mysql 로그 보기

```
docker exec -it master-mysql bash

// mysql 접속 (bash)
mysql -u root -p

// 현재 설정보기 (mysql)
SHOW VARIABLES LIKE "general_log%";

// 로그 기록 설정 (mysql)
SET GLOBAL general_log = 'ON';

// 로그 실시간 확인 (bash)
tail -f /var/lib/mysql/*.log
```

## MYSQL 레플리케이션 설정

MYSQL 9점대 기반

- vim, wget 설치

```bash

microdnf update -y

microdnf install -y vim

microdnf install -y wget

```