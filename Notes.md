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

### Consistent hashing
- Consistent hashing is a special kind of hashing technique such that when a hash table is resized, only 
n/m keys need to be remapped on average where n is the number of keys and m is the number of slots.
- In the problem of load balancing, for example, when a BLOB has to be assigned to one of 
In the problem of load balancing, for example, when a BLOB has to be assigned to one of \( n \) servers on a cluster, a standard hash function could be used in such a way that we calculate the hash value for that BLOB. Assuming the resultant value of the hash is \( \beta \), we perform a modular operation with the number of servers (\( n \) in this case) to determine the server in which we can place the BLOB: \( \zeta = \beta \% n \); hence the BLOB will be placed in the server whose server ID is the successor of \( \zeta \) in this case. However, when a server is added or removed during an outage or scaling (when \( n \) changes), all the BLOBs in every server should be reassigned and moved due to rehashing, but this operation is expensive.
\(2\pi\) radians. 

- Consistent hashing was designed to avoid the problem of having to reassign every BLOB when a server is added or removed throughout the cluster. The central idea is to use a hash function that maps both the BLOB and servers to a unit circle, usually 
2
π
{\displaystyle 2\pi } radians. For example, \(\zeta = \Phi \% 360\) (where \(\Phi\) is the hash of a BLOB or server's identifier, like IP address or UUID). Each BLOB is then assigned to the next server that appears on the circle in clockwise order. 

### Useful resources:
- https://www.hellointerview.com/learn/system-design/in-a-hurry/delivery
- https://blog.algomaster.io/p/how-to-answer-a-system-design-interview-problem

### Misc:
- https://leetcode.com/discuss/interview-question/system-design/1071562/Design-a-File-Download-Application-System
- https://medium.com/@mayankbansal933/food-delivery-app-lld-c1409ef49266
- https://leetcode.com/discuss/interview-question/4861889/Uber-or-Onsite-or-Implement-a-Rate-limiter
- https://leetcode.com/discuss/interview-question/5049157/Uber-machine-coding
