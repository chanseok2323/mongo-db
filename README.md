# mongo-db를 이용한 간단한 게시판 
주로 aurora, mysql 같은 관계형 DBMS 만 사용을 해왔으며, mongo db를 이용해서 개발을 진행을 해보고 싶었습니다.

### 현재 로컬 개발 환경
- MongoDB 1.6
- Spring Boot 2.7.8
- Java 11

### 기본 MongoDB 명령어
- 접속 : mongosh -u 계정 -p 비밀번호
- 데이터베이스 리스트 조회 : show dbs
- 데이버테이스 선택 : show 이름
- 조회 : db.member.find({ "key": "value" }).pretty();
- insert : db.member.insertOne({"key":"value", "key":"value", "key":value});

### 기본 설정
- DB User 생성
    - db.createUser({user: "id", pwd: "pwd", roles:["role"]})
- @Document(collection = "member")
    - Document 
        Document는 쉽게 생각해서 RDBMS의 레코드와 비슷한 개념, 데이터 구조는 한 개 이상의 key-value pair로 구성
      - {
        _id: ObjectId("63b2e88fdc5e5af952e6ed6e"),
        name: 'chanseok',
        email: 'chanseok2323@gmail.com',
        age: 30
        }
      - _id 는 12bytes의 hexadecimal 값으로서, 각 document의 유일함(uniqueness)을 제공합니다.
      이 값의 첫 4bytes 는현재 timestamp, 다음 3bytes는 machine id, 다음 2bytes는 MongoDB 서버의 프로세스id, 마지막 3bytes는 순차번호
      - Document는 동적의 schema를 갖고 있음, 같은 Collection 안에 있는 Document 끼리 다른 schema를 갖고 있을 수 있음, 쉽게 말해 서로 다른 데이터(다른 key) 들을 가지고 있을 수 있음
    - collection 
        - MongoDB Document의 그룹, Document들이 Collection 내부에 위치
        - RDBMS의 테이블과 비슷한 개념