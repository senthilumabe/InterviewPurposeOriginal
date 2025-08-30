1.What is a REST API?
==========================================
REST (Representational State Transfer) is an architectural style for building APIs that use HTTP to perform CRUD operations on resources.

Resources are represented using URIs.

Uses HTTP methods: GET, POST, PUT, DELETE, PATCH.

Data is usually represented in JSON or XML.

Stateless – each request contains all required info.

Widely used for web and mobile backend services.

#########################################################################################################################

2.What are the key principles of REST?
==========================================
REST follows certain principles to ensure scalability and simplicity.

Statelessness – No session maintained on server.

Client-Server separation.

Uniform Interface – Standard resource representation.

Cacheable – Responses can be cached.

Layered System – Allows intermediate proxies.

Resource Identification via URIs.

#########################################################################################################################

3.What is the difference between REST and SOAP?
==========================================

REST → Lightweight, uses JSON, flexible, faster.

SOAP → Strict protocol, uses XML, built-in security (WS-Security).

REST is ideal for microservices and web/mobile APIs.

SOAP is preferred for enterprise apps needing ACID transactions.

#########################################################################################################################

What is an Idempotent method in REST?
==========================================
An idempotent method produces the same result regardless of how many times it is called.

GET – Fetching data doesn’t change state.

PUT – Updating same resource repeatedly gives same result.

DELETE – Deleting multiple times still removes resource.

POST – NOT idempotent, as it creates new resources.

#########################################################################################################################

What is the difference between PUT and PATCH in REST?
==========================================

PUT → Updates the entire resource (replaces existing).

PATCH → Updates only part of the resource.

Example:

PUT /user/1 with full JSON object.

PATCH /user/1 with only updated field(s).

#########################################################################################################################

How do you handle versioning in REST APIs?
==========================================
Versioning helps maintain backward compatibility.

URI Versioning: /api/v1/users

Query Params: /users?version=1

Headers: Accept: application/vnd.myapp.v1+json

Content Negotiation using MIME types.

Best practice: Use URI or header-based versioning.

#########################################################################################################################

What is HATEOAS in REST?
==========================================
HATEOAS (Hypermedia As The Engine Of Application State) allows clients to discover actions dynamically.

API responses include links for next actions.

Example response:

{
  "id": 1,
  "name": "John",
  "links": [
    {"rel": "self", "href": "/users/1"},
    {"rel": "orders", "href": "/users/1/orders"}
  ]
}


Improves client usability and reduces hardcoding.

#########################################################################################################################

How do you secure a REST API?
==========================================
Securing REST APIs ensures only authorized access.

HTTPS for encrypted communication.

Authentication (Basic Auth, JWT, OAuth2).

Authorization (role-based access).

Input validation to prevent injection attacks.

Rate limiting to prevent abuse.

#########################################################################################################################

What is the difference between Authentication and Authorization?
==========================================

Authentication → Verifies identity (e.g., login with username/password).

Authorization → Grants access to resources (e.g., admin vs. user).

Example:

AuthN = "Who are you?"

AuthZ = "What are you allowed to do?"

#########################################################################################################################

What are REST API status codes?
==========================================
REST uses HTTP status codes to indicate request results.

200 OK → Success.

201 Created → Resource created.

204 No Content → Successful, no response body.

400 Bad Request → Invalid request.

401 Unauthorized → Authentication required.

403 Forbidden → Access denied.

404 Not Found → Resource missing.

500 Internal Server Error → Server failure.

#########################################################################################################################

What is statelessness in REST?
==========================================
REST is stateless, meaning the server does not store client session information between requests.

Each request contains all required information (headers, tokens, data).

Server treats every request independently.

Improves scalability as no session state is stored on server.

Client is responsible for maintaining state (e.g., JWT tokens, cookies).

#########################################################################################################################

What are the advantages of REST APIs?
==========================================
REST APIs are widely adopted due to simplicity and flexibility.

Lightweight and fast (uses JSON).

Platform and language independent.

Scalable due to stateless design.

Easy to consume via standard HTTP methods.

Well-suited for mobile and microservice applications.

#########################################################################################################################

What are the disadvantages of REST APIs?
==========================================
Despite being popular, REST has some limitations.

Lack of built-in security standards (unlike SOAP).

No strict contract – can lead to inconsistent APIs.

Over-fetching or under-fetching of data.

Statelessness may require repeated authentication tokens.

#########################################################################################################################

What is content negotiation in REST?
==========================================
Content negotiation allows clients and servers to agree on data format.

Handled using HTTP headers.

Accept header → Specifies response type (e.g., application/json).

Content-Type header → Specifies request body format.

Enables supporting multiple formats (JSON, XML, YAML).

#########################################################################################################################

How do you test REST APIs?
==========================================
REST APIs can be tested using different tools and approaches.

Postman → Manual testing with UI.

cURL → Command-line testing.

JUnit + RestAssured → Automated API testing.

Swagger / OpenAPI → Interactive API documentation and testing.

Verify status codes, headers, and response bodies.

#########################################################################################################################

What are best practices for designing REST APIs?
==========================================
Following best practices ensures consistency and maintainability.

Use nouns for resource names (/users/getUsers).

Use plural form for collections.

Use HTTP methods properly (GET, POST, PUT, DELETE).

Implement versioning (/api/v1).

Return proper HTTP status codes.

Secure with HTTPS + authentication.

#########################################################################################################################

What is the difference between Monolithic APIs and RESTful Microservices?
==========================================

Monolithic API → Single, tightly-coupled application, harder to scale.

Microservices with REST → Split into independent services communicating via REST APIs.

Microservices are easier to scale, maintain, and deploy independently.

#########################################################################################################################

What is CORS in REST APIs?
==========================================
CORS (Cross-Origin Resource Sharing) allows web apps to access resources from different domains.

Controlled by server using headers like Access-Control-Allow-Origin.

Prevents unauthorized cross-site requests.

Common issue when front-end and back-end are on different ports.

Spring Boot can enable CORS with @CrossOrigin.

#########################################################################################################################

What are API Gateways and why are they used?
==========================================
An API Gateway acts as a single entry point for multiple APIs in microservices.

Routes requests to appropriate services.

Provides security, authentication, logging, rate limiting.

Examples: Netflix Zuul, Spring Cloud Gateway, Kong, Nginx.

Helps in centralizing cross-cutting concerns.

#########################################################################################################################

How do you handle errors in REST APIs?
==========================================
Proper error handling improves API usability.

Use meaningful status codes (400, 401, 404, 500).

Return structured error responses in JSON.

Example:

{
  "timestamp": "2023-08-15",
  "status": 404,
  "error": "Not Found",
  "message": "User not found",
  "path": "/users/10"
}


Helps clients understand issues clearly.

#########################################################################################################################
What is Swagger (OpenAPI) in REST?
==========================================
Swagger (now OpenAPI) is a tool and specification for documenting and testing REST APIs.

Provides interactive documentation via UI.

Helps in API testing directly from docs.

Generates API contracts in JSON/YAML.

Integrates with Spring Boot via springdoc-openapi or Swagger UI.

Improves collaboration between developers and testers.

#########################################################################################################################

What is the Richardson Maturity Model in REST?
==========================================
It defines levels of REST API maturity based on best practices.

Level 0 → Single endpoint, no REST principles.

Level 1 → Resources identified by URIs.

Level 2 → Proper use of HTTP methods & status codes.

Level 3 → HATEOAS (links for discoverability).

Higher levels mean more RESTful compliance.

#########################################################################################################################

How do you implement pagination in REST APIs?
==========================================
Pagination avoids returning large datasets in a single response.

Use query params: /users?page=1&size=20.

Response includes data + pagination metadata.

Example:

{
  "content": [...],
  "page": 1,
  "size": 20,
  "totalPages": 5,
  "totalElements": 100
}


Improves performance and usability.

#########################################################################################################################

What is throttling or rate limiting in REST APIs?
==========================================
Throttling controls the number of requests a client can make in a given time.

Prevents abuse or DDoS attacks.

Implemented using API Gateways or filters.

Example: "100 requests per minute per user".

Returns status 429 Too Many Requests when limit exceeded.

#########################################################################################################################

What are idempotent and safe methods in REST?
==========================================

Idempotent Methods → Multiple identical requests produce the same result. (GET, PUT, DELETE).

Safe Methods → Do not modify server state. (GET, HEAD, OPTIONS).

POST is neither safe nor idempotent.

#########################################################################################################################

What is the difference between synchronous and asynchronous REST APIs?
==========================================

Synchronous → Client waits for server response (e.g., typical REST call).

Asynchronous → Server processes request later, client gets response via callback/queue.

Async APIs are useful for long-running operations.

#########################################################################################################################

What are hypermedia controls in REST?
==========================================
Hypermedia controls guide clients on next possible actions in REST APIs.

Implemented via HATEOAS.

Example response:

{
  "id": 5,
  "name": "Laptop",
  "links": [
    {"rel": "self", "href": "/products/5"},
    {"rel": "reviews", "href": "/products/5/reviews"}
  ]
}


Makes APIs more discoverable and self-descriptive.

#########################################################################################################################

What is the difference between API and REST API?
==========================================

API (Application Programming Interface) → General mechanism for communication between software.

REST API → A type of API that follows REST principles using HTTP.

All REST APIs are APIs, but not all APIs are RESTful.

#########################################################################################################################

How do you ensure backward compatibility in REST APIs?
==========================================
Backward compatibility ensures older clients still work with newer APIs.

Use versioning (/v1, /v2).

Avoid breaking existing endpoints.

Add new fields without removing old ones.

Use default values for missing fields.

Maintain deprecated APIs until migration.

#########################################################################################################################

What is API mocking and why is it used?
==========================================
API mocking is creating fake APIs that simulate real ones.

Helps frontend teams work before backend is ready.

Useful for testing and prototyping.

Can simulate success and error responses.

Tools: Postman Mock Server, WireMock, Mockoon.

#########################################################################################################################
What is caching in REST APIs and why is it important?
==========================================
Caching improves API performance by storing frequently accessed responses.

Reduces server load and improves speed.

Implemented using HTTP headers:

Cache-Control → Defines cache policies.

ETag → Helps validate cache freshness.

Expires → Defines expiration time.

Example: Browser caches GET /products response.

#########################################################################################################################

What is the difference between URI and URL in REST?
==========================================

URI (Uniform Resource Identifier) → Identifies a resource (general concept).

URL (Uniform Resource Locator) → A type of URI that specifies the location of resource (protocol + domain + path).

Example:

URI: /users/10

URL: https://api.example.com/users/10

#########################################################################################################################

What is JSON and why is it preferred in REST APIs?
==========================================
JSON (JavaScript Object Notation) is a lightweight data format.

Easy to read and write.

Language-independent but widely supported.

More compact than XML.

Faster serialization and parsing.

Default format for most REST APIs.

#########################################################################################################################

What is XML and when would you use it in REST APIs?
==========================================
XML (Extensible Markup Language) is a structured data format.

Supports complex data representation with attributes.

Heavier than JSON, slower parsing.

Preferred in enterprise systems needing strict schemas.

REST APIs can support both XML and JSON via content negotiation.

#########################################################################################################################

How do you document REST APIs?
==========================================
Good documentation helps clients consume APIs easily.

Swagger / OpenAPI → Interactive documentation.

Postman Collections → Shareable API docs.

API Blueprint / RAML → Specification-based docs.

Include endpoints, methods, request/response examples, error codes.

#########################################################################################################################

What is Postman and how is it used in REST API testing?
==========================================
Postman is a popular tool for developing and testing REST APIs.

Send GET, POST, PUT, DELETE requests easily.

Supports environments and variables.

Automates tests with scripts.

Can generate documentation and mock servers.

Widely used by developers and QA teams.

#########################################################################################################################

What is OAuth2 and how is it used in REST APIs?
==========================================
OAuth2 is an authorization framework for secure access.

Provides access tokens for API calls.

Common flows: Authorization Code, Client Credentials, Implicit, Password.

Example: Login with Google → third-party app uses Google’s OAuth2 tokens.

Widely used for secure REST APIs and microservices.

#########################################################################################################################

What is JWT and why is it used in REST APIs?
==========================================
JWT (JSON Web Token) is a compact token format used for authentication.

Encoded as Header.Payload.Signature.

Stored in client-side (usually in localStorage or cookies).

Eliminates server-side session storage → supports stateless APIs.

Example Payload:

{
  "sub": "user123",
  "role": "admin",
  "exp": 1699999999
}


#########################################################################################################################

What is API monitoring and why is it important?
==========================================
API monitoring ensures REST APIs are performing as expected.

Tracks uptime, latency, error rates.

Detects failures early.

Tools: New Relic, Postman Monitors, Prometheus, Grafana.

Helps maintain reliability and SLA compliance.

#########################################################################################################################

What is the difference between Public, Private, and Partner APIs?
==========================================

Public APIs → Available to external developers (e.g., Twitter API).

Private APIs → Used only within an organization.

Partner APIs → Shared with specific partners or organizations.

Helps control access and usage policies.

#########################################################################################################################
What is HATEOAS in REST?
==========================================
HATEOAS (Hypermedia As The Engine Of Application State) makes REST APIs more discoverable.

Responses include links to related resources.

Client can navigate dynamically without hardcoding URLs.

Example:

{
  "id": 101,
  "name": "Book",
  "links": [
    {"rel": "self", "href": "/books/101"},
    {"rel": "reviews", "href": "/books/101/reviews"}
  ]
}


Improves API flexibility and usability.

#########################################################################################################################

What are HTTP headers in REST APIs?
==========================================
Headers provide metadata about requests and responses.

Common headers:

Content-Type → Format of request body.

Accept → Expected response format.

Authorization → Credentials or tokens.

Cache-Control → Defines caching rules.

Essential for security, performance, and interoperability.

#########################################################################################################################

What is the difference between SOAP and REST APIs?
==========================================

SOAP (Simple Object Access Protocol):

XML-based, strict contract.

Built-in security (WS-Security).

Heavier and slower.

REST (Representational State Transfer):

JSON/XML, flexible contract.

Lightweight, faster, easier.

More widely used in modern web and mobile apps.

#########################################################################################################################

What is API versioning and why is it important?
==========================================
API versioning allows evolving APIs without breaking old clients.

Methods of versioning:

URI versioning → /api/v1/users.

Header versioning → Accept: application/vnd.api.v1+json.

Query parameter versioning → /users?version=1.

Ensures backward compatibility.

#########################################################################################################################

What is an API contract?
==========================================
An API contract defines the agreement between client and server.

Specifies endpoints, request/response formats, authentication, error codes.

Tools like OpenAPI/Swagger are used.

Ensures consistency and reduces misunderstandings.

Acts like a blueprint for API development.

#########################################################################################################################

How do you handle file uploads in REST APIs?
==========================================
File uploads are usually handled via multipart requests.

Endpoint example: POST /upload with multipart/form-data.

Spring Boot provides MultipartFile for handling uploads.

Files can be stored on server filesystem, cloud storage, or DB.

Validate file type and size for security.

#########################################################################################################################

What is gRPC and how is it different from REST?
==========================================
gRPC is a high-performance RPC framework by Google.

Uses HTTP/2 for faster communication.

Relies on Protocol Buffers (Protobuf) instead of JSON.

Supports bidirectional streaming.

Faster than REST, but less human-readable.

REST is better for public APIs, gRPC for internal microservices.

#########################################################################################################################

What is the difference between PUT and PATCH in REST?
==========================================

PUT → Replaces the entire resource.

PATCH → Updates partial resource.

Example:

PUT /users/5 with full user object.

PATCH /users/5 with only { "email": "new@email.com" }.

#########################################################################################################################

How do you secure REST APIs?
==========================================
Security is critical in REST API design.

Use HTTPS to encrypt data.

Implement authentication & authorization (JWT, OAuth2).

Validate input data to prevent injection attacks.

Apply rate limiting and throttling.

Hide sensitive data in responses.

Use CORS policies carefully.

#########################################################################################################################

What are idempotency keys in REST APIs?
==========================================
Idempotency keys prevent duplicate operations in POST requests.

Client sends a unique key in headers:
Idempotency-Key: 12345.

Server ensures same key → same result.

Useful in payment APIs to avoid double charges.

#########################################################################################################################


















