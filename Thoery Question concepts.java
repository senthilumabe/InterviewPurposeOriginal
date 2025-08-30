1. Core Java (OOP & Language Features)

Principles of OOP — Encapsulation, Inheritance, Polymorphism, Abstraction

Difference between abstract class and interface (Java 8 default/static methods in interfaces)

Method overloading vs overriding

Access modifiers — public, private, protected, default

final, finally, finalize — differences

equals() vs ==

hashCode() contract and best practices

String, StringBuilder, StringBuffer differences

Immutability of String — why and how

Wrapper classes and autoboxing/unboxing

Java memory model — stack vs heap

pass-by-value in Java (especially with objects)

Static vs instance variables/methods

Inner classes, static inner classes, anonymous classes

Enums in Java — advantages, usage

Java 8 features — lambda, streams, functional interfaces, method references

Optional in Java 8

var keyword in Java 10

Records (Java 14+) — if relevant to job

2. Java Collections Framework

List, Set, Map — differences and usage

HashMap vs LinkedHashMap vs TreeMap

HashSet vs LinkedHashSet vs TreeSet

How HashMap works internally — hashCode(), equals(), buckets, collisions, resizing

Fail-fast vs fail-safe iterators

ConcurrentHashMap vs HashMap

CopyOnWriteArrayList vs ArrayList

PriorityQueue — internal working

Comparable vs Comparator

Difference between Collections.synchronizedList and Concurrent collections

Immutable collections — ways to create

Iterating collections — iterator, enhanced for loop, streams

3. Concurrency & Multithreading

Thread lifecycle (new, runnable, running, waiting, terminated)

Thread creation — extending Thread vs implementing Runnable vs ExecutorService

Callable vs Runnable

synchronized keyword — method vs block

volatile keyword

Deadlock, livelock, starvation

How to avoid deadlock

wait(), notify(), notifyAll() — usage

ThreadLocal — purpose & example usage

ReentrantLock vs synchronized

Atomic variables — AtomicInteger, AtomicReference

ExecutorService — fixed thread pool, cached thread pool

Future & CompletableFuture

Parallel streams in Java 8

4. Exception Handling

Checked vs unchecked exceptions

throw vs throws

try-with-resources (AutoCloseable)

Custom exceptions — best practices

Common runtime exceptions — NullPointerException, IndexOutOfBoundsException

Suppressed exceptions in try-with-resources

5. Java I/O & NIO

Byte stream vs character stream

BufferedReader vs Scanner

FileReader vs FileInputStream

Serialization & Deserialization

transient keyword

Java NIO — Channels, Buffers, Selectors

Memory-mapped files

6. Java 8 Streams & Functional Programming

Intermediate vs terminal operations in streams

map(), filter(), flatMap()

collect() and Collectors (groupingBy, partitioningBy, joining)

reduce()

distinct(), sorted(), limit(), skip()

anyMatch(), allMatch(), noneMatch()

Optional — usage and pitfalls

Parallel streams — when to use, when not to

7. Spring Boot & Spring Framework

Spring Boot vs Spring MVC

Spring Boot auto-configuration — how it works

Common Spring Boot annotations — @SpringBootApplication, @Component, @Service, @Repository, @RestController, @Configuration, @Bean

Dependency Injection — constructor vs setter

@Autowired vs @Qualifier

Spring Bean scopes — singleton, prototype, request, session

Bean lifecycle — init/destroy methods

Spring Boot starters — purpose

application.properties vs application.yml

Profiles in Spring Boot (@Profile)

Externalized configuration — Environment, @Value

Spring Boot Actuator — common endpoints

Spring Boot logging — SLF4J, Logback

Exception handling in REST APIs — @ControllerAdvice, @ExceptionHandler

8. REST API

REST principles

HTTP methods — GET, POST, PUT, PATCH, DELETE

HTTP status codes (2xx, 4xx, 5xx)

Idempotency

Path params vs query params

JSON serialization/deserialization — Jackson

Content negotiation — @RequestMapping produces/consumes

Versioning strategies — URI, headers, query params

CORS — handling in Spring Boot

REST API security — Basic Auth, JWT

Pagination & sorting in APIs

9. Microservices

Monolith vs Microservices

Inter-service communication — REST, Feign Client

Service registry — Eureka, Consul

API Gateway — Zuul, Spring Cloud Gateway

Circuit breaker — Resilience4j, Hystrix

Configuration server

Distributed tracing — Sleuth, Zipkin

Fault tolerance patterns

Synchronous vs asynchronous communication

10. SQL & Database

Primary key vs unique key

Normalization (1NF, 2NF, 3NF)

INNER JOIN vs LEFT JOIN vs RIGHT JOIN vs FULL JOIN

Indexes — clustered vs non-clustered

Transactions — ACID properties

Isolation levels

SQL injection & prevention

Writing optimized queries

GROUP BY & HAVING

Common SQL functions — COUNT, SUM, AVG, MIN, MAX

Pagination queries (LIMIT, OFFSET)

11. System Design Basics (for 5 yrs exp)

High-level design of an e-commerce app

Designing a URL shortener

Designing a chat application

Load balancing

Caching strategies (LRU, LFU)

Database sharding & replication

Message queues — RabbitMQ, Kafka basics