#Swagger setting options
---
```
springboot 3.2.4
springdoc-openapi-starter-webmvc-ui 2.2.0
```


## 의존성 주입
[의존성 주입 및 Information 설정 방법](https://aljjabaegi.tistory.com/713)

## Information setting
### SwaggerConfig
```
 - @OpenApiDefinition
   - @Info
```

## Operation setting
[Operation 설정 방법](https://aljjabaegi.tistory.com/714)
```
 - @Tag
 - @Operation
```

## Response setting
[Response 설정 방법](https://aljjabaegi.tistory.com/715)
```
 - @Schema
 - @ControllerAdvice
 - OperationCustomizer
```

## application.yml setting
[application.yml 설정 방법](https://aljjabaegi.tistory.com/716)
```
 - doc-expansion
 - display-request-duration
 - filter
 - try-it-out-enable
 - operations-sorter
```

## JWT Athorization setting
[JWT 설정 방법](https://aljjabaegi.tistory.com/717)
```
 - @SecurityScheme
```

## Grouping setting
[Grouping 설정 방법](https://aljjabaegi.tistory.com/718)
```
 - GroupedOpenApi
```
