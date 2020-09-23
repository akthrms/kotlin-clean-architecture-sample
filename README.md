# Kotlin - Clean Architecture Sample

Clean Architecture Sample with Kotlin and Spring Boot.

## Env

- Kotlin 1.3.72
- Spring Boot 2.3.4.RELEASE
- Arrow 0.10.5

## Usage

### Create

```sh
$ curl -X POST -H "Content-Type:application/json" -d "{\"content\": \"aaa\"}" http://localhost:8080/create
id: 1 is created.
```

### Select

```sh
$ curl -X GET http://localhost:8080/
exists 1 todos.
Todo(id=1, content=aaa, created=2020/09/24 02:09:06, updated=2020/09/24 02:09:06)
```

### Update

```sh
$ curl -X PUT -H "Content-Type:application/json" -d "{\"id\": \"1\", \"content\": \"bbb\"}" http://localhost:8080/update
id: 1 is updated.
```

### Delete

```sh
$ curl -X DELETE http://localhost:8080/1
id: 1 is deleted.
```
