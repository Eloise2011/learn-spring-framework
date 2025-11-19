Error 1 :
Description:    
<span style="color: red; ">Parameter 0 of constructor in com.example.learn_spring_framework.game.GameRunner required a single bean, but 2 were found:</span>
This may be due to missing parameter name information
Action:
**Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed**



Lesson-Learnt 1: </br>
> When you are using **@Component** annotation on more than one class implementing / extending the same class and tries to instantiate them. When starting the springboot application, it will fail. </br> 
> Until you add **@Primary** to one of the classes, by default, it will instantiate this class with **@Primary** annotation on top of it.


Error 2:
项目启动没问题,但是访问具体资源路径时报错:
```text
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Tue Nov 18 11:11:17 CST 2025
There was an unexpected error (type=Not Found, status=404).
No static resource .
org.springframework.web.servlet.resource.NoResourceFoundException: No static resource .
at org.springframework.web.servlet.resource.ResourceHttpRequestHandler.handleRequest(ResourceHttpRequestHandler.java:585)
```




expected single matching bean but found 2: requestMappingHandlerMapping,controllerEndpointHandlerMapping




Lesson-Learnt 2:
最终发现是在userService中创建userList时失误:
错误:
```java
private static List<User> userList ;
```
正确:
```java
private static List<User> userList = new ArrayList<>();
```
做如上更改后重新编译启动再访问就没错了:
![Xnip2025-11-18_11-57-47.png](Note-Pics/Xnip2025-11-18_11-57-47.png)
您遇到的问题是一个典型的 "静态变量初始化时机" 问题。在Spring Boot的复杂启动序列中，未初始化的静态变量可能在某个意外的时机被访问，导致静默的失败，最终表现为控制器无法正确注册，从而返回404错误。
关键教训：在Spring Boot应用中，特别是使用DevTools时，应该始终显式初始化所有的字段，特别是静态字段，以避免这种难以调试的时序问题。


| app    | 功能                    | 快捷键                      | 使用场景             |  
|:-------|:----------------------|:-------------------------|:-----------------|  
| Idea   | maven change refresh  | **`command+shift+i`**    | 当pom文件有变动，需要重新加载 |
| Idea   | 启动springboot项目        | **`ctrl+shift+r`**       | 当项目代码有变动,需要重新启动  |
| Idea   | 启动springboot项目        | **`option+shift+enter`** | 当项目代码需要补全或       |