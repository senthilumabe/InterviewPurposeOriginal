1) Core Java (OOP & Language Features)

OOP pillars
Encapsulation (hide state via accessors), Inheritance (reuse/IS-A), Polymorphism (same interface, many forms — overloading/overriding), Abstraction (expose essentials, hide details via abstract classes/interfaces).
--------------------------------------------------------------------------------------------------------------------------
Abstract class vs Interface
Abstract: can have state, constructors, non-abstract methods. Interface: contract; Java 8 adds default/static methods; fields are public static final. A class can implement many interfaces, extend one class.
--------------------------------------------------------------------------------------------------------------------------
Overloading vs Overriding
Overloading: same name, different params (compile-time). Overriding: same signature in subclass (runtime; uses dynamic dispatch). Overriding respects access widening & covariant returns.
--------------------------------------------------------------------------------------------------------------------------
Access modifiers
public (everywhere), protected (package + subclasses), default/package-private (package), private (class only).
--------------------------------------------------------------------------------------------------------------------------
final / finally / finalize
final keyword (no change: variable/ method/ class), finally block (always runs), finalize() (legacy GC hook; deprecated—don’t use).
--------------------------------------------------------------------------------------------------------------------------
equals() vs ==
== compares references (objects) or values (primitives). equals() is logical equality; must obey reflexive, symmetric, transitive, consistent, and non-null.
--------------------------------------------------------------------------------------------------------------------------
hashCode() contract
Equal objects must have same hashCode. If used in hash collections, override both equals and hashCode consistently.
--------------------------------------------------------------------------------------------------------------------------
String vs StringBuilder vs StringBuffer
String immutable; concatenations create new objects. StringBuilder mutable, not thread-safe (fast). StringBuffer mutable, synchronized (slower).
--------------------------------------------------------------------------------------------------------------------------
Why String immutable?
Security (classloaders, URLs), caching (interning), thread-safety, safe hashCode caching.
--------------------------------------------------------------------------------------------------------------------------
Wrapper + auto(un)boxing
Automatic conversion between primitive and wrapper (e.g., int ↔ Integer). Beware NPE and performance overhead in tight loops.
--------------------------------------------------------------------------------------------------------------------------
Java pass-by-value
Always pass-by-value. For objects, the reference value is copied; you can mutate the object but not rebind caller’s reference.
--------------------------------------------------------------------------------------------------------------------------
Static vs instance
Static belongs to class (one copy). Instance members belong to objects. Static methods cannot access instance fields directly.
--------------------------------------------------------------------------------------------------------------------------
Inner classes
Member inner, static nested (no outer ref), local, anonymous. Use cases: scoping, adapters, callbacks.
--------------------------------------------------------------------------------------------------------------------------
Enums
Type-safe constants with fields/methods/constructors. Often used for state machines, strategy constants.
--------------------------------------------------------------------------------------------------------------------------
Optional (Java 8)
Container for possibly absent value; encourages null-safe APIs. Use map/flatMap/filter/orElse. Don’t use as fields in entities.
--------------------------------------------------------------------------------------------------------------------------
Method references
Shorthand for lambdas: Class::staticMethod, obj::instanceMethod, Class::new. Improves readability.
--------------------------------------------------------------------------------------------------------------------------
Functional interfaces
Single abstract method (SAM). Common ones: Predicate<T>, Function<T,R>, Consumer<T>, Supplier<T>.
--------------------------------------------------------------------------------------------------------------------------
Parallel vs sequential streams
Parallel uses ForkJoinPool (commonPool). Good for CPU-bound, large data, non-blocking operations. Beware contention, ordering, and thread-safety.
--------------------------------------------------------------------------------------------------------------------------
var (Java 10)
Local variable type inference. Improves readability; not available for fields, method params/returns.
--------------------------------------------------------------------------------------------------------------------------
Records (Java 14+)
Immutable data carriers with implicit equals/hashCode/toString. Great for DTOs (if allowed by your target runtime).
--------------------------------------------------------------------------------------------------------------------------
2) Collections Framework

List/Set/Map
List: ordered, duplicates. Set: unique, no index. Map: key→value. Choose based on need for order, uniqueness, lookup speed
--------------------------------------------------------------------------------------------------------------------------
HashMap vs LinkedHashMap vs TreeMap
HashMap: O(1) average, no order. LinkedHashMap: insertion/access order. TreeMap: O(log n), sorted by key (Red-Black tree).
--------------------------------------------------------------------------------------------------------------------------
HashSet vs LinkedHashSet vs TreeSet
HashSet: hash-based, no order. LinkedHashSet: preserves insertion order. TreeSet: sorted set (O(log n)).
--------------------------------------------------------------------------------------------------------------------------
HashMap internals
Array of buckets; hash→index; collisions as nodes/trees (since Java 8). Resize on load factor; equals used to break ties.
--------------------------------------------------------------------------------------------------------------------------
Fail-fast vs fail-safe
Fail-fast (Iterator on ArrayList/HashMap) throws ConcurrentModificationException. Fail-safe (e.g., CopyOnWriteArrayList, ConcurrentHashMap) iterates over snapshot or safe structure.
--------------------------------------------------------------------------------------------------------------------------
ConcurrentHashMap vs HashMap
CHM is thread-safe with finer locks/segments; no null keys/values; better concurrency. HashMap is not thread-safe.
--------------------------------------------------------------------------------------------------------------------------
CopyOnWriteArrayList vs ArrayList
COWAL: copy on writes; iteration is snapshot & thread-safe; expensive writes, great for read-heavy scenarios.
--------------------------------------------------------------------------------------------------------------------------
PriorityQueue internals
Binary heap (min-heap by default). O(log n) add/remove; O(1) peek. Can pass Comparator.
--------------------------------------------------------------------------------------------------------------------------
Comparable vs Comparator
Comparable: natural order compareTo. Comparator: external ordering; multiple strategies.
--------------------------------------------------------------------------------------------------------------------------
Synchronized wrappers vs Concurrent collections
Collections.synchronizedList adds coarse locks; still can see CME on iteration unless manually synchronized. Concurrent collections designed for high throughput.
--------------------------------------------------------------------------------------------------------------------------
Immutable collections
Use Collections.unmodifiableList (shallow) or Java 9 List.of. Truly immutable requires defensive copies and no mutators.
--------------------------------------------------------------------------------------------------------------------------
Iteration options
Iterator, enhanced for, streams. For modification during iteration, use Iterator’s remove().
--------------------------------------------------------------------------------------------------------------------------
3) Concurrency & Multithreading
=================================

Thread lifecycle
New → Runnable → Running → Waiting/Timed Waiting/Blocked → Terminated. State transitions via start/sleep/wait/notify/join.
--------------------------------------------------------------------------------------------------------------------------
Create threads
Extend Thread, implement Runnable, or use ExecutorService (preferred). For results, use Callable.
--------------------------------------------------------------------------------------------------------------------------
Callable vs Runnable
Callable<V> returns value & can throw checked exception; Runnable cannot.
--------------------------------------------------------------------------------------------------------------------------
synchronized
Mutual exclusion and visibility. Can sync method or block on an intrinsic lock (monitor). Avoid locking on this exposed object.
--------------------------------------------------------------------------------------------------------------------------
volatile
Ensures visibility & ordering (happens-before on writes/reads). Doesn’t provide atomicity for compound actions.
--------------------------------------------------------------------------------------------------------------------------
Deadlock, livelock, starvation
Deadlock: circular waiting. Livelock: threads active but no progress. Starvation: thread never gets CPU/resource.
--------------------------------------------------------------------------------------------------------------------------
Avoiding deadlock
Lock ordering, tryLock with timeouts, reduce lock scope, use higher-level concurrency utilities.
--------------------------------------------------------------------------------------------------------------------------
wait/notify/notifyAll
Used with intrinsic locks. wait() releases monitor and waits; notify wakes one waiter; notifyAll wakes all.
--------------------------------------------------------------------------------------------------------------------------
ThreadLocal
Per-thread variable storage. Useful for request context, formatters. Remember to remove in pools to avoid leaks.
--------------------------------------------------------------------------------------------------------------------------
ReentrantLock vs synchronized
ReentrantLock provides tryLock, fairness, interruptible waits, separate Condition objects. synchronized is simpler, JVM-managed.
--------------------------------------------------------------------------------------------------------------------------
Atomic classes
Lock-free, CAS-based (e.g., AtomicInteger, AtomicReference) for atomic updates without full locks.
--------------------------------------------------------------------------------------------------------------------------
ExecutorService & pools
Fixed, cached, scheduled, work-stealing. Submit tasks, manage lifecycle with shutdown/awaitTermination.
--------------------------------------------------------------------------------------------------------------------------
Future & CompletableFuture
Future: result placeholder; blocking get. CompletableFuture: chaining, async composition, callbacks, better orchestration.
--------------------------------------------------------------------------------------------------------------------------
Parallel streams caveats
Shared mutability, IO-bound tasks, small datasets, or ordered collectors can kill performance. Measure!
--------------------------------------------------------------------------------------------------------------------------
4) Exception Handling

Checked vs unchecked
Checked must be declared/handled (e.g., IOException). Unchecked (RuntimeException) indicate programming errors.
--------------------------------------------------------------------------------------------------------------------------
throw vs throws
throw to actually raise; throws in signature to declare.
--------------------------------------------------------------------------------------------------------------------------
try-with-resources
Auto-close resources implementing AutoCloseable; closes in reverse order; supports suppressed exceptions.
--------------------------------------------------------------------------------------------------------------------------
Custom exceptions
Extend RuntimeException for unchecked, or Exception for checked. Add context fields/messages; avoid overuse.
--------------------------------------------------------------------------------------------------------------------------
Common runtime exceptions
NPE, IOBE, AIOOBE, IllegalArgument, IllegalState, ClassCast, ConcurrentModification.

Suppressed exceptions
Thrown in close() are added as suppressed to the primary exception; accessible via getSuppressed().

5) Java I/O & NIO

Byte vs character streams
Byte: binary data (InputStream/OutputStream). Char: text (Reader/Writer) with encoding awareness.

BufferedReader vs Scanner
BufferedReader: fast line reading. Scanner: tokenization & parsing, slower.

FileReader vs FileInputStream
Reader for chars (uses encoding), Stream for bytes (raw).

Serialization
Converts object to byte stream. Mark transient fields to skip; maintain serialVersionUID. Prefer JSON/protobuf for services.

transient
Skip field in serialization. Useful for caches, sensitive data.

NIO
Channels + Buffers, non-blocking IO, Selectors for multiplexing; better performance for scalable servers.

Memory-mapped files
Map file into memory to read/write like an array; very fast for large files; watch for resource cleanup.

6) Streams & FP (Java 8)

Intermediate vs terminal
Intermediate: lazy (map/filter/flatMap/sorted/distinct). Terminal: triggers pipeline (collect, forEach, reduce, count).

map / filter / flatMap
map: transform elements. filter: keep matching. flatMap: flatten nested streams.

collect & Collectors
Gather results into collections/maps/strings. Common: groupingBy, partitioningBy, joining, mapping, toMap.

reduce
Combine elements into a single result (sum/product/custom). Use identity + accumulator (+ combiner for parallel).

distinct / sorted / limit / skip
Distinct by equality. sorted by natural/comparator. limit/skip for pagination-like slicing.

anyMatch/allMatch/noneMatch
Short-circuit predicates over a stream.

Optional usage
Use ofNullable, map, orElseGet, orElseThrow. Don’t use Optional for fields/params in entities.

Parallel stream gotchas
Avoid when operations are blocking, order-dependent, or stateful; reduce/collect must be associative & thread-safe.

7) Spring & Spring Boot

Spring vs Spring Boot
Spring: core DI/AOP/MVC. Boot: opinionated auto-config, starters, embedded servers for rapid setup.

@SpringBootApplication
Meta for @Configuration + @EnableAutoConfiguration + @ComponentScan.

Auto-configuration
Conditional beans based on classpath/properties; can customize via @ConditionalOn… and properties.

DI in Spring
Constructor injection preferred (immutability, testability). Setter for optional deps.

Starters
Curated dependencies bundling (e.g., spring-boot-starter-web, data-jpa).

Profiles
Activate environment-specific beans/config using @Profile or spring.profiles.active.

DB connection
Configure datasource properties; use spring-boot-starter-data-jpa with EntityManager/JpaRepository.

@ConfigurationProperties
Bind hierarchical properties to POJO; supports validation; cleaner than many @Value.

Stereotypes
@Component (generic), @Service (business), @Repository (DAO, exception translation).

Actuator
Operational endpoints: health, metrics, info, env, beans; secure before exposing.

Swagger/OpenAPI
Add dependency, annotate controllers; generates interactive API docs (e.g., springdoc-openapi).

Global exception handling
@ControllerAdvice + @ExceptionHandler to return consistent error responses.

AOP
Cross-cutting concerns (logging, security, transactions) via @Aspect, pointcuts, advices.

@Transactional
Demarcates transactions; rollback on runtime exceptions by default; propagation/isolation options.

DevTools
Auto-restart and live reload for faster dev cycle.

Caching
@EnableCaching, @Cacheable, @CacheEvict, @CachePut; plug providers (Caffeine, Redis).

Spring Security basics
Filter chain, AuthenticationManager, UserDetailsService. Default is form login; customize with SecurityFilterChain.

JWT security
Stateless tokens; filter extracts/validates token; set authentication in context; secure endpoints by roles.

Properties vs YAML
YAML supports hierarchy, lists; both map to Environment. Use profiles sections for env overrides.

Logging
SLF4J API with Logback default. Configure via logback-spring.xml or properties.

8) REST API

REST principles
Client-server, stateless, cacheable, layered, uniform interface, HATEOAS (optional).

REST vs SOAP
REST: resource-centric, JSON/HTTP, lightweight. SOAP: XML, strict contracts, WS-* features.

HTTP methods
GET (read), POST (create), PUT (replace), PATCH (partial update), DELETE (remove), HEAD/OPTIONS.

Idempotent & safe
GET/HEAD/OPTIONS safe (no state change). Idempotent: GET/PUT/DELETE (same result on repeats), PATCH/POST not necessarily.

HTTP status codes
200 OK, 201 Created, 204 No Content, 400 Bad Request, 401 Unauthorized, 403 Forbidden, 404 Not Found, 409 Conflict, 500 Server Error.

Validation
Use @Valid + Bean Validation (@NotNull, @Size), handle MethodArgumentNotValidException.

PUT vs PATCH
PUT replaces entire resource (idempotent). PATCH applies partial modifications (may be non-idempotent).

HATEOAS
Hypermedia links guide clients to next actions. Useful for discoverability; often skipped in internal APIs.

Pagination
Query params page, size, sort. Return metadata (totalElements, totalPages) and links.

Error handling
Consistent error model (code, message, details, traceId). Map exceptions to status codes.

URI vs URL
URL is a locator (subset). URI is an identifier; URL + URN are URIs.

Content negotiation
Use Accept/Content-Type headers; Spring maps via produces/consumes.

API versioning
URI path (/v1), header, or query param; path is simplest/most common.

Postman testing
Collections, environments, variables, tests (scripts), Newman for CI.

OAuth2 basics
AuthZ framework with flows (Auth Code, Client Credentials). Use Spring Security OAuth + JWT.

CORS
Cross-origin control of browsers; configure allowed origins, methods, headers; use @CrossOrigin or global config.

@RequestParam vs @PathVariable
Param: query string for filtering/paging; PathVariable: identifies a specific resource in path.

File upload
Use MultipartFile in Spring; set max file size; stream to storage.

ETag
Entity tag for caching & conditional requests (If-None-Match). Reduces bandwidth.

Statelessness
No server-side session; each request self-contained (token carries identity/claims).

9) Microservices

Microservices architecture
Small, independently deployable services around business capabilities, with decentralized data and CI/CD.

Monolith vs Microservices
Monolith: single deployable, simpler ops, harder scaling. Microservices: independent scaling/deploy, added complexity (network, data).

Service communication
REST/gRPC (sync), messaging via Kafka/RabbitMQ (async). Choose based on coupling/latency.

API Gateway
Single entry point: routing, auth, rate-limit, aggregation, TLS termination.

Service discovery
Registry where services register & clients/gateway discover (Eureka, Consul).

Circuit breaker
Prevents cascading failures; opens on errors/timeouts, then half-open test. Use Resilience4j.

Resilience4j usage
Decorate calls with CircuitBreaker, Retry, RateLimiter, Bulkhead, TimeLimiter.

Distributed tracing
Correlation across services using traceId/spanId (Sleuth, Zipkin, OpenTelemetry).

SAGA pattern
Manage distributed transactions via local transactions + compensations (choreography or orchestration).

Transactions across services
Avoid 2PC; use SAGA, idempotent operations, outbox pattern.

CQRS
Separate read/write models; optimize queries and scalability; often with event sourcing.

Event-driven
Publish/subscribe via Kafka etc. Loose coupling, async; eventual consistency.

Sync vs async
Sync: request/response, simple but tightly coupled. Async: resilient, decoupled, eventual consistency.

Config Server
Centralized external configuration for services; refresh via bus.

Load balancing
Client-side (Ribbon) or server-side (LB/Gateway/Service Mesh).

Sidecar pattern
Helper container next to app (proxies, agents) for cross-cutting concerns.

Service-to-service security
mTLS, JWT between services, network policies, zero-trust.

Containerization
Docker images; Kubernetes orchestrates scaling, resilience, rollouts.

10) SQL & Database

JOIN types
INNER: matches only. LEFT: all left + matches. RIGHT: all right + matches. FULL: all rows with matches where present.

Find duplicates
Group by columns; HAVING COUNT(*) > 1. Or window functions to mark duplicates.

Index
Data structure speeding lookups. Types: B-tree, hash, bitmap (vendor). Speeds reads; slows writes.

Clustered vs non-clustered
Clustered defines physical order (one per table). Non-clustered is separate structure with pointers.

Primary vs unique key
Both enforce uniqueness; PK also identifies rows, usually not nullable; one PK, many unique constraints allowed.

Foreign key
Referential integrity between parent and child tables; can cascade actions.

Normalization
1NF (atomic), 2NF (no partial dep), 3NF (no transitive dep). Reduces redundancy; balance with performance.

TRUNCATE vs DELETE vs DROP
TRUNCATE: remove all rows, fast, DDL. DELETE: row-level, logs, can filter. DROP: removes table/structure.

Nth highest salary
Use ORDER BY salary DESC OFFSET n-1 ROWS FETCH NEXT 1 ROW (DB-specific) or window function DENSE_RANK().

Stored procedure vs function
Proc: actions, can modify state; no requirement to return value. Function: returns value, side-effect-free ideally, can be used in SELECT.

CTE
Named temporary result set (WITH) for readability; supports recursion.

Pagination
LIMIT/OFFSET (MySQL/Postgres) or ROW_NUMBER() over ordered set.

View
Saved query logic; virtual table; helpful for security/abstraction.

UNION vs UNION ALL
UNION removes duplicates (sort). UNION ALL keeps duplicates (faster).

ACID
Atomicity, Consistency, Isolation, Durability — transaction guarantees.

Isolation levels
Read Uncommitted, Read Committed, Repeatable Read, Serializable; trade-offs for anomalies.

Deadlock detection
DB detects & kills one transaction; avoid by ordering locks, keeping transactions short, proper indexes.

EXPLAIN PLAN
Shows how the optimizer will execute the query; use to tune (indexes, joins, scans).

CHAR vs VARCHAR
CHAR fixed length (padded), VARCHAR variable length; VARCHAR saves space for variable-size strings.

SQL injection & prevention
Always use prepared statements/parameterized queries; avoid string concatenation; validate inputs; least privilege.

11) System Design Basics

E-commerce high-level design
Services: catalog, cart, order, payment, inventory, user, search. Use DB per service, cache (Redis), message bus (Kafka), API gateway, auth, CDN.

URL shortener
Hash (base62) IDs, handle collisions, store mapping, TTL for analytics, cache hot links, rate limiting, custom aliases, read-heavy.

Chat application
WebSocket/long-polling, presence service, message persistence, delivery receipts, partitions by room/user, offline queue.

Load balancing
L4/L7 LBs, health checks, sticky sessions (discouraged), weighted routing, blue-green/canary deployments.

Caching strategies
Local vs distributed cache, eviction (LRU/LFU), write-through/write-back, cache-aside, TTL & invalidation.

Sharding & replication
Sharding for horizontal scale (by userId etc.), replication for availability (primary-replica), handle rebalancing & hotspots.

Message queues
Kafka/RabbitMQ to decouple producers/consumers; at-least-once/ exactly-once semantics; idempotent consumers.

12) Design Patterns (bonus must-know)

Singleton
Single instance with private constructor + static accessor; consider enum for thread-safety and serialization safety.

Factory / Abstract Factory
Create objects without exposing instantiation logic; Abstract Factory creates families of related objects.

Builder
Stepwise construction of complex objects; promotes immutability and readability (fluent APIs).

Strategy
Swap algorithms at runtime via interface; inject via composition.

Observer (Pub/Sub)
Observers subscribe to subject; notified on state change. GUIs, event systems.

Decorator
Add behavior dynamically by wrapping; e.g., I/O streams.

Adapter
Convert one interface into another expected by clients; integration scenarios.

Facade
Simplified interface to complex subsystem; reduces coupling.