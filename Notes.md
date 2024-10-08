### Thin vs Thick client
* In a Thick client architecture, most of the application logic resides on the client device, reducing the server's dependency.
* On the other hand, thin clients delegate most of the processing tasks to the server, with the client primarily responsible for rendering the user interface and handling user input.

### JWT
#### Use Cases
#### Authentication:

1. Login: After a user logs in, the server generates a JWT and sends it to the client.
Subsequent Requests: The client includes the JWT in the Authorization header of each request to authenticate.

### gRPC
- RPC protocal developed by Google.
- Built on HTTP2
- Doesn't have head of line blocking and allows for the serving of many RPC requests over the same connection at the same time.
- Multiplexing is a feature of HTTP/2 that allows for the sending of multiple requests and responses over a single TCP connection.

### Pub/Sub
### 1. Push
- The pub/sub server initiates requests to deliver messages to the subscriber application
### 2. Pull
- In a pull subscription, a subscriber client requests messages from the Pub/Sub server.
### 3. Hybrid

### Useful resources:
- https://www.hellointerview.com/learn/system-design/in-a-hurry/delivery
- https://blog.algomaster.io/p/how-to-answer-a-system-design-interview-problem

### Misc:
- https://leetcode.com/discuss/interview-question/system-design/1071562/Design-a-File-Download-Application-System
- https://medium.com/@mayankbansal933/food-delivery-app-lld-c1409ef49266
- https://leetcode.com/discuss/interview-question/4861889/Uber-or-Onsite-or-Implement-a-Rate-limiter
- https://leetcode.com/discuss/interview-question/5049157/Uber-machine-coding
