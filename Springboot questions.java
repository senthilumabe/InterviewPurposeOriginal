	1.What is Spring Boot and why is it used?
	==========================================	
Spring Boot is an extension of the Spring Framework that simplifies application development by eliminating boilerplate configuration. It provides opinionated defaults, auto-configuration, and an embedded server, making it easy to build production-ready applications quickly.

Reduces XML configuration.

Provides embedded Tomcat/Jetty/Undertow.

Supports production-ready features (metrics, health checks, etc.).

Follows convention over configuration.

#########################################################################################################################

2.What are the main features of Spring Boot?
==========================================
Spring Boot comes with powerful features that make it developer-friendly and production-ready.

1) POM starters

2) Auto Configuration

3) Embedded Servers

4) Actuators

5) Elegant Configuration Management

==============
POM Starters
==============

=> Starters are a set of opinionated dependencies that simplify dependency management. 

=> They encapsulate common configurations and dependencies needed for specific functionalities, such as database connectivity, security, web services, and more. 

=> Starters make it easy to add required dependencies with minimal effort and reduce version compatibility issues. 

====================
Auto Configuration
====================

=> Spring Boot Auto-configuration is a feature that automatically configures the Spring framework and its components based on  the dependencies present in the classpath. 
=> It aims to minimize the need for manual configuration and reduce boilerplate code.

                   For example, => if you have the spring-boot-starter-web dependency in your classpath, Spring Boot assumes         you are trying to build a SpringMVC-based web application and automatically tries to register DispatcherServlet 
if it is not already registered.
 
                 One more example, => If you have any embedded database drivers in the classpath, such as H2 or HSQL, and if you haven’t configured a DataSource bean explicitly, then Spring Boot will automatically register a DataSource bean using in-memory database settings.

=================		
Embedded Servers
==================

=> Traditionally, while building web applications, you need to create a WAR file of your spring project and then deploy them on external servers like Tomcat, WildFly, etc. 
= > Spring Boot allows you to package your application as a standalone JAR file. It includes an embedded servlet container (Tomcat, Jetty, or Undertow) by default, making it easy to deploy and run applications without requiring an external server. 

============	
Actuators	
============

=> Used to monitor and manage spring boot application using built-in endpoints for health checks, metrics, logging, and more. Traditional Spring does not provide these features by default.	

                                -> how many beans loaded ?
				-> How many url-patterns mapped
				-> What configuration properties loaded ?
				-> What is health of app?
				-> Heap Dump
				-> Thread Dump

================================
Elegant Configuration Management
================================

=> Spring Boot allows you to externalize configuration properties, such as database connection details, server port, and logging settings. 
=> It supports various configuration formats like properties files, YAML files, environment variables, and more. 
=> The externalized configuration makes it easier to configure and manage application properties in different environments. 
 support.

#########################################################################################################################

3.What is Spring Boot Auto-Configuration and how does it work?
==========================================
Auto-Configuration reduces manual setup by automatically creating beans depending on available classes in the classpath.

Enabled by @EnableAutoConfiguration (part of @SpringBootApplication).

Works internally via spring.factories.

Example: Adding spring-boot-starter-web configures DispatcherServlet, Tomcat, Jackson, etc.

Can be excluded/overridden with @EnableAutoConfiguration(exclude=...).

#########################################################################################################################

4.What is the difference between Spring and Spring Boot?
==========================================

Spring → Requires manual bean configuration, XML/Java config, and external server deployment.

Spring Boot → Provides auto-configuration, embedded servers, starter dependencies, and production-ready features.

With Spring Boot, developers focus more on business logic rather than infrastructure.

#########################################################################################################################
5.What is @SpringBootApplication annotation?
==========================================
@SpringBootApplication is a convenience annotation that combines three important Spring annotations.

@Configuration → Marks the class as a source of bean definitions.

@EnableAutoConfiguration → Enables auto-configuration.

@ComponentScan → Scans for beans in the package.

#########################################################################################################################

6.How does Spring Boot handle dependency management?
==========================================
Spring Boot simplifies dependency management using a parent POM and version alignment.

Uses spring-boot-starter-parent to manage dependency versions.

Developers only declare dependencies, not versions.

Ensures compatibility between dependencies.

Supports both Maven and Gradle.
#########################################################################################################################

7.What are Spring Boot DevTools?
==========================================
Spring Boot DevTools are tools for developer productivity.

Automatic Restart → Restarts app when code changes.

LiveReload → Refreshes browser automatically.

Disables Caching during development.

Should not be used in production.

#########################################################################################################################

8.How do you configure properties in Spring Boot?
==========================================
Spring Boot supports externalized configuration for flexible setups.

application.properties or application.yml.

Environment variables.

Command-line arguments.

External config servers (Spring Cloud Config).

Properties have a defined order of precedence.

#########################################################################################################################

9.What is the difference between application.properties and application.yml?
==========================================
Both are used for externalized configuration but differ in format.

Properties File → Key-value pairs (server.port=8080).

YAML File → Hierarchical, human-readable (server: port: 8080).

YAML supports multiple profiles more elegantly.

#########################################################################################################################

10.What are profiles in Spring Boot?
==========================================
Profiles allow you to configure applications differently for environments like dev, test, prod.

Defined via spring.profiles.active=dev.

Configurable using application-dev.yml, application-prod.yml.

Helps manage environment-specific settings like DB URLs and logging.

#########################################################################################################################

11.How do you implement exception handling in Spring Boot?
==========================================
Spring Boot provides flexible exception handling mechanisms.

Use @ControllerAdvice with @ExceptionHandler.

Extend ResponseEntityExceptionHandler.

Return structured JSON error messages.

Example:

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}


#########################################################################################################################

12.How does Spring Boot support logging?
==========================================
Spring Boot uses Commons Logging as abstraction and integrates with Logback by default.

Configurable via application.properties (logging.level.root=DEBUG).

Supports log file output.

Allows custom logback-spring.xml.

Logging levels: TRACE, DEBUG, INFO, WARN, ERROR, OFF.

#########################################################################################################################

13.What is the default server in Spring Boot? Can it be changed?
==========================================

Default server: Embedded Tomcat.

Can be changed to Jetty or Undertow.

To change, exclude Tomcat dependency and add spring-boot-starter-jetty.

#########################################################################################################################

14.How do you create a custom banner in Spring Boot?
==========================================
Spring Boot allows customizing startup banners.

Create banner.txt under resources.

Use ASCII text and placeholders (${spring.version}, ${java.version}).

Programmatic customization: SpringApplication.setBanner().

#########################################################################################################################

15.What are Spring Boot Initializr and CLI?
==========================================

Spring Initializr → Online generator (start.spring.io) for Spring Boot projects.

Spring Boot CLI → Command-line tool for running Groovy scripts.

Both simplify starting new projects quickly.

#########################################################################################################################

16.How do you enable scheduling in Spring Boot?
==========================================
Spring Boot provides scheduling for periodic tasks.

Use @EnableScheduling on config class.

Use @Scheduled(fixedRate = 5000) or cron expressions.

Example:

@Scheduled(cron = "0 0 * * * ?")
public void cleanup() { ... }
Supports cron expressions, fixed delay, and fixed rate.

#########################################################################################################################

17.What is the difference between @Component, @Service, @Repository, and @Controller?
==========================================
These are stereotype annotations for different layers.

@Component → Generic bean.

@Service → Business logic layer.

@Repository → Persistence layer, with exception translation.

@Controller → MVC controller for web apps.

#########################################################################################################################

18.How does Spring Boot support JPA and Hibernate?
==========================================
Spring Boot makes ORM integration seamless.

Starter: spring-boot-starter-data-jpa.

Auto-configures EntityManager, Hibernate, TransactionManager.

Supports schema creation and auditing.

Configured via application.properties.

#########################################################################################################################
19.How do you configure a DataSource in Spring Boot?
==========================================
Spring Boot auto-configures a DataSource when database dependencies are present.

Configuration via application.properties or application.yml.

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=secret
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

Uses HikariCP as the default connection pool.
You can also define a custom DataSource bean.

#########################################################################################################################

20.What is HikariCP in Spring Boot?
==========================================
HikariCP is the default connection pooling library used in Spring Boot.

Lightweight and high performance.

Reduces memory overhead.

Example config:

spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5

Preferred for production systems.

#########################################################################################################################
21.What is Spring Boot Actuator Metrics and Monitoring?
==========================================
Spring Boot Actuator provides built-in metrics and monitoring using Micrometer.

Collects JVM, memory, thread, and HTTP metrics.

Endpoints like /actuator/metrics/jvm.memory.used.

Supports integration with Prometheus, Grafana, Datadog.

Helps track application performance in production.

#########################################################################################################################

22.How do you secure Spring Boot Actuator endpoints?
==========================================
Actuator endpoints can expose sensitive data, so they must be secured.

Restrict exposure in application.properties:

management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=always


Secure with Spring Security to allow only authorized roles.

#########################################################################################################################

23.How do you implement caching in Spring Boot?(cache)
======================================================
In Spring Boot, a cache is the actual storage (memory, Redis, Caffeine, etc.) where results of expensive operations (like database queries or API calls) are stored temporarily, so they can be retrieved quickly later without recomputation.

Spring Boot provides simple caching support using annotations.

Enable with @EnableCaching.

Use @Cacheable to store results, @CacheEvict to clear, @CachePut to update.

Example:

@Cacheable("users")
public User getUserById(Long id) { ... }


Supports providers like EhCache, Redis, Caffeine.

#########################################################################################################################
24.What happens if two beans of the same type exist in the Spring context, and you do not use @Qualifier?

provide NoUniqueBeanDefinitionException error

instead of usign @Qualifier you can use @Primary

#########################################################################################################################
25.Do you want me to also explain how Spring decides which bean name to use by default (when you don’t provide a name explicitly)?

1. For stereotype annotations (@Component, @Service, etc.)

By default, the bean name is the class name with the first letter lowercased.

2. For @Bean methods inside a @Configuration class

By default, the bean name is the method name.

#########################################################################################################################
26.What is Spring Boot’s support for REST APIs?
==========================================
Spring Boot simplifies REST API development with minimal configuration.

@RestController for JSON responses.

Auto-configures Jackson for JSON serialization.

Exception handling with @ControllerAdvice.

Validation support using @Valid.

#########################################################################################################################
27.What is the difference between @RestController and @Controller?
==========================================

@Controller → Used in MVC for returning views (HTML/JSP).

@RestController → Combines @Controller and @ResponseBody.

Automatically serializes objects into JSON/XML.

Ideal for REST APIs.

#########################################################################################################################

28.How do you handle file uploads in Spring Boot?
==========================================
Spring Boot supports multipart file upload natively.

Enable in properties:

spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=10MB


Controller example:

@PostMapping("/upload")
public String upload(@RequestParam MultipartFile file) {
    return file.getOriginalFilename() + " uploaded!";
}


#########################################################################################################################

29.What are Spring Boot Conditional Annotations?
==========================================
Conditional annotations allow beans to be loaded only if conditions are met.

Examples:

@ConditionalOnClass → Loads bean if class exists in classpath.

@ConditionalOnMissingBean → Loads bean if not defined.

@ConditionalOnProperty → Based on property value.

Commonly used in auto-configuration.

#########################################################################################################################

30.How does Spring Boot manage internationalization (i18n)?
==========================================
Spring Boot provides i18n support for multi-language applications.

Define message bundles (messages.properties, messages_fr.properties).

Configure base name:

spring.messages.basename=messages


Use MessageSource or Accept-Language header.

#########################################################################################################################

31.What is the use of spring-boot-starter-parent?
==========================================
Acts as a parent POM in Maven for dependency management.

Provides default dependency versions.

Manages plugin configurations.

Ensures compatibility across libraries.

Avoids version conflicts.

#########################################################################################################################
32.How do you implement asynchronous execution in Spring Boot?
==========================================
Spring Boot supports async tasks using @Async.

Enable with @EnableAsync.

Example:

@Async
public CompletableFuture<String> process() {
    return CompletableFuture.completedFuture("Done");
}


Executes tasks in a separate thread pool.

#########################################################################################################################
33.What is the use of CommandLineRunner in Spring Boot?
==========================================
CommandLineRunner allows code execution after context startup.

Implemented as a bean.

Example:

@Component
public class StartupRunner implements CommandLineRunner {
    public void run(String... args) {
        System.out.println("Application started");
    }
}

Useful for data initialization, testing, or background jobs.

#########################################################################################################################
34.What is the difference between CommandLineRunner and ApplicationRunner?
==========================================
Both run code after the application starts.

CommandLineRunner → Accepts String... args.

ApplicationRunner → Uses ApplicationArguments.

ApplicationRunner is more powerful for parsing command-line options.

#########################################################################################################################
35.How does Spring Boot handle externalized configuration?
==========================================
Spring Boot loads properties from multiple sources with a defined priority.

application.properties or application.yml.

Command-line arguments.

Environment variables.

Config servers (Spring Cloud Config).

Priority ensures flexibility.

#########################################################################################################################

36.How do you create a custom Spring Boot starter?
==========================================
A custom starter packages common configurations for reuse.

First, I create a new Maven or Gradle module that acts as the starter and usually depends on spring-boot-starter.

Then I write an auto-configuration class with @Configuration, where I define the beans I want to auto-create. 

I typically use annotations like @ConditionalOnClass, @ConditionalOnMissingBean, and @EnableConfigurationProperties so the configuration is applied only when needed.

If I want the starter to be configurable via application.properties, I create a @ConfigurationProperties class.

After that, I register the auto-configuration by listing it in META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports (in Spring Boot 3.x; earlier versions used spring.factories).

Finally, I package the starter as a JAR and publish it, so any project can just add the dependency, and the auto-configured beans will be available immediately without extra setup."

#########################################################################################################################

37.What is the difference between JAR and WAR in Spring Boot?
==========================================

JAR → Self-contained executable with embedded server (default).

WAR → Deployable to external servers like Tomcat/WebLogic.

Spring Boot prefers JAR, but supports both.

#########################################################################################################################
38.How do you enable HTTPS in Spring Boot?
==========================================
Spring Boot supports SSL with simple configuration.

Generate a .jks keystore.

Add properties:

server.port=8443
server.ssl.key-store=classpath:keystore.jks
server.ssl.key-store-password=secret
server.ssl.key-alias=mycert

Application runs on HTTPS.

#########################################################################################################################

39.What are some ways to improve Spring Boot application performance?
==========================================

Use HikariCP for efficient DB pooling.

Enable caching with @EnableCaching.

Use asynchronous methods with @Async.

Enable lazy initialization for faster startup.

Monitor with Actuator + Micrometer.

########################################################################################################################
40.How do you externalize sensitive credentials in Spring Boot?
==========================================
Sensitive credentials should never be hardcoded.

Use environment variables.

Use Spring Cloud Config or HashiCorp Vault.

Example:

spring.datasource.password=${DB_PASSWORD}


Keeps secrets secure and environment-specific.

#########################################################################################################################

41.How do you override default Spring Boot configurations?
==========================================
Defaults can be overridden at different levels.

Use application.properties or application.yml.

Use @Bean definitions for custom beans.

Use profile-specific configs (application-dev.yml).

Override using @ConfigurationProperties.

#########################################################################################################################

42.How do you disable specific auto-configuration in Spring Boot?
==========================================

Use annotation:

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})


Or via properties:

spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

#########################################################################################################################

43.How do you use Lombok in Spring Boot?
==========================================
Lombok reduces boilerplate code in entity and DTO classes.

Add Lombok dependency.

Example:

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
}


Provides annotations like @Getter, @Setter, @Builder.

#########################################################################################################################
44.How do you enable lazy initialization in Spring Boot?
==========================================
Lazy initialization delays bean creation until required.

Enable in properties: It is the global

spring.main.lazy-initialization=true

for specific: use @Lazy

Improves startup time, especially for large apps.

#########################################################################################################################
45.What are the different logging levels supported in Spring Boot?
==========================================
Spring Boot supports multiple logging levels.

TRACE → Fine-grained debugging.

DEBUG → Debug-level logs.

INFO → Application flow.

WARN → Warnings.

ERROR → Error messages.

OFF → Disable logging.

Configurable in application.properties:

logging.level.org.springframework=DEBUG


#########################################################################################################################

46.How do you package and deploy a Spring Boot application?
==========================================
Spring Boot applications are packaged as executable JARs or WARs.

Package with Maven:
------------------
mvn clean package


Run:
-----
java -jar myapp.jar
	
Can also be deployed via Docker, Kubernetes, or external servers.

#########################################################################################################################
47.What is dependency injection?
=> The process of injecting one class object into another class is called as 'Dependency Injection'.

=> We can perform Dependency Injection in 3 ways

		1) Setter Injection

		2) Constructor Injection

		3) Field Injection
==============================
Setter Injection (SI)
=============================

=> Setter Injection means, Injecting dependent object into target object using target class setter method.

ex:

@Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

=========================
Constructor Injection  ( CI )
========================

=> Constructor Injection means, Injecting dependent object into target object using target class constructor.

ex:

 @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

===================
Field Injection - FI
===================

=> Field Injection means, injecting depending object into target class using target class variable is called as Field Injection.

ex:

@Autowired
    private UserRepository userRepository;

Note:
======
Constructor injection is most recommendable and it is also better than other injection.
why CI is better than other?
----------------------------

-> It provide Immutability. Which means , It allows dependencies to be declared as final, ensuring that they cannot be modified after the object is created. This   promotes thread safety and makes the code more robust. and also prevent accidently modification.

-> It enforces that all required dependencies are provided when the object is created, preventing NullPointerException errors at runtime.

-> It simplifies unit testing by allowing dependencies to be easily mocked and injected during test execution, without      relying on reflection or complex setups.

Field injection is not recommendable why?
-----------------------------------------

=> - difficult to unit test.

=> - Field injection does not enforce immutability since dependencies can be altered anytime.

=> - If a required dependency is missing, field injection does not give compile-time errors.

=> - If your class requires a new dependency later, you must manually inject it into fields

#############################################################################################################################
48.what is IOC container?

-> IoC stands for Inversion Of Control.

-> IoC is responsible for Dependency Injection in Spring Applications.

-> Dependency Injection means creating and injecting dependent bean objects into target bean classes.

It is responsible for instantiating, configuring and managing the beans in your spring application. The beans are nothing but the objects which are created and managed by the Spring IoC container.
#############################################################################################################################
49.How to Start IoC in Spring ? 
=======================

1) BeanFactory (Outdated)

2) ApplicationContext (recommended)


	Ex:     ApplicationContext context = new ClassPathXmlApplicationContext(String configFile);
	
How IOC starting in Spring Boot ?
======================================

=> SpringApplication.run ( ) method contains logic to start IOC container

#############################################################################################################################
50.what is bean scopes?

============
Bean Scopes
============

=> Scope represents how many objects should be created for a Spring Bean

=> In Spring framework we have below scopes

			1) singleton    ( default scope )

			2) prototye 

			3) request

			4) session

=> To represent bean scope we will use    "scope" attribute

		<bean id="id"  class="pkg.classname"  scope = "singleton | prototye | request | session " />


-> Singleton scope means only one object will be created for the class in IOC Container. This is default scope of spring bean.

-> Prototype scope means every time new object will be created.

Note: request & session scopes are related to Spring Web MVC Module.

#############################################################################################################################
51. what is Autowiring?

Autowiring means IoC container will identify dependent bean and it will inject into target bean 
	(we no need to use any ref attribute in bean configuration file)

-> Autowiring will work based on below modes

				1) byName
				2) byType
				3) constructor
				4) no

#############################################################################################################################
52. How run() method work internally?
=====================================
=> run is a static method which is available in spring application.

=> Step 1: The run Method is Invoked
You write this in the main method:
SpringApplication.run(MySpringBootApplication.class, args);


This triggers the execution of the Spring Boot application. The SpringApplication class handles everything that follows.

=> Step 2: Create a SpringApplication Instance
- Internally, the run method first creates an instance of the SpringApplication class.
- This class acts as the coordinator, orchestrating how the application is initialized and started.
- The class determines whether the application is a web app or a non-web app (based on available libraries).

=> Step 3: Prepare the Environment
Spring Boot sets up the environment:
- Reads configuration files like application.properties or application.yml.
- Loads system properties and environment variables.
- Determines profiles (e.g., dev, test, or prod) based on the active profile setting.

=> Step 4: Print Banner and Initialize Logging
- A banner (the Spring Boot ASCII art) is displayed unless disabled.
- Logging frameworks such as Logback or SLF4J are configured to handle log output for the application.

=> Step 5: Create an Application Context
- Spring Boot creates the application context, which is the core container holding all the Spring-managed beans.
- If it's a web application, a WebApplicationContext is created. For non-web apps, a generic ApplicationContext is created.
- The application context is responsible for:- Scanning for components using annotations like @Component and @Service.
- Wiring dependencies between beans (via @Autowired or constructor injection).

=> Step 6: Load Beans
- Beans are initialized and registered into the application context.
- Beans are created based on annotations like:- @Component
- @Service
- @Controller
- @Repository

- Dependency injection resolves relationships between beans.

=> Step 7: Call CommandLineRunner and ApplicationRunner
- Any beans implementing CommandLineRunner or ApplicationRunner interfaces are executed. These are commonly used for tasks such as startup logic.

=> Step 8: Start Embedded Web Server (if applicable)
- If the application is a web app:- An embedded web server like Tomcat, Jetty, or Undertow is started.
- The server binds to the default port (usually 8080) or the port configured in application.properties.

=> Step 9: Publish Events
- Spring Boot publishes lifecycle events such as:- ContextRefreshedEvent: Signals that the application context has been fully loaded.
- ApplicationReadyEvent: Indicates that the application is fully initialized and ready to handle requests.

=> Step 10: Run the Application
- Once all steps are completed, the application is up and running.
- If it's a web application, the embedded server waits for HTTP requests.
- For non-web applications, any startup logic is executed, and the program may terminate (if not configured to wait indefinitely).

#############################################################################################################################
53.How does @Transactional work under the hood?
=> Answer: It uses proxies to manage transactions at the method level.

=> When you annotate a method (or class) with @Transactional, Spring:

- Starts a transaction when the method begins.
- Commits the transaction if the method completes successfully.
- Rolls back the transaction if an exception occurs.

=> You can place it @Transactional,
- On a method: Only that method runs in a transaction.
- On a class: All public methods in the class are transactional.

#############################################################################################################################
54.Explain the internal work of Springboot?

=> Spring Boot Application starts using a main method, and the main method is called the "run" method i.e. SpringApplication.run(),.

=> From this run method, the application context of IOC (Inversion Of Control) searches the class annotated with @Configuration annotation which calls all the beans in the classpath and initializes those classes. 

=> Beans are stored inside a particular space in JVM (Java Virtual Machine). That particular space is known as the IOC Container.

=> After beans are created the requests will go to the dispatcher servlet and the dispatcher servlet will distribute all the requests among the appropriate controllers. 
#############################################################################################################################
55.Explain Springboot Architecture? and Spring MVC Architecture?

=> Client makes an HTTP request(GET, POST, PUT, DELETE) to the browser.

=> Then the request will go to the controller where all the requests will be mapped and handled.

=> After mapping done, in Service layer all the business logic will be performed. It performs the logic on the data that is mapped to JPA(Java Persistence API) using model classes.

=> In repository layer, all the CRUD operations is done for the rest APIs.

=> A JSP page is returned to the user if no errors are there.
Spring MVC Architecture:
------------------------
=> Spring MVC follows the Model-View-Controller design pattern to build web applications in a clean and organized way. 

=> At the center is the DispatcherServlet, which acts as the front controller—it receives all incoming HTTP requests and routes them to the appropriate Controller. 

=> The controller processes the request, interacts with the Model (which holds the business logic and data), and returns a View (like a JSP or HTML page) to display the result. 

###################################################################################################################################




