API 명세서
------------
| 기능 | Method | URL | request | response | 상태 코드 |
|------|--------|-----|---------|----------|------------|
| 할 일 등록|POST|/todos|요청 body|등록정보|201 Created|
| 단 건 조회|GET|/todos/{id}|요청 param|단 건 등록정보|200 OK, 404 Not Found|
| 단 건 수정|PATCH|/todos/id/{id}|요청 body|수정 된 정보|201 Created, 404, 400|
| 단 건 삭제|DELETE|/todos/{id}|요청 body|없음|200 OK, 404, 40|



ERD
----------------
![image](https://github.com/user-attachments/assets/f6e01af6-419d-464c-bda2-7d59cefcd806)



## 구현 내용
**1. 일정 생성**
  - POST
  - 경로 : /todos
  - 기능
     - authorName, workTodo, password를 사용자에게 받아 새로운 일정 생성
     - 자동으로 id가 부여되고, 생성 시 수정일은 작성일과 동일하게 설정되어 있다.
     - 일정 생성이 완료되면 생성 된 일정을 반환한다.
   
       
   <br>

**2. 일정 조회**
  - GET 
  - 경로 : /todos/{id}
  - 기능
     - 사용자가 전달한 id를 통해 일정을 조회한다.
     - 전달한 id에 해당하는 일정이 없는 경우 404 NOT FOUND 에러를 반환한다.
     - 조회에 성공하면 해당 일정 정보를 반환한다.

<br>
  
**3. 일정 수정**
  - PATCH 
  - 경로 : /todos/id/{id}
  - 기능
     - 사용자가 전달한 id와 수정 데이터를 받아 일정을 수정한다
         - id에 해당하는 일정이 없는 경우 404 NOT FOUND 에러를 반환한다.
         
     - 생성 당시 작성한 비밀번호와 요청데이터로 받은 비밀번호가 일치하는 경우에만 수정 가능
         - 비밀번호가 일치하지 않는 경우 400 BAD REQUEST 에러를 반환한다.

     - authorName과 workTodo를 수정할 수 있고, 수정일은 수정 한 시점으로 변경된다.
         - 수정 데이터가 비어있는 경우 400 BAD REQUEST 에러를 반환한다.
          
     - 수정 완료 시 수정 된 일정 정보를 반환한다.
   

<br>
  
**4. 일정 삭제**
  - DELETE 
  - 경로 : /todos/{id}
  - 기능
     - 사용자로부터 id와 비밀번호를 받아 검증 후 해당 id의 일정을 삭제.
       - id에 해당하는 일정이 없는 경우 404 NOT FOUND 에러를 반환한다.
       - 비밀번호가 일치하지 않는 경우 400 BAD REQUEST 에러를 반환한다.

  - 삭제 성공 시 상태 코드 200 OK를 반환한다.
