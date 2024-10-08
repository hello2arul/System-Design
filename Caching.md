## Caching Strategies

### 1. Cache Aside
- **Description**: The application checks the cache for a key. If the key is present, it retrieves the value; if not, it fetches the value from the database, writes it to the cache, and returns the value.
- **Pros**: Simple to implement; allows for fine-grained control over cache management.
- **Cons**: Can lead to cache misses, which may result in performance hits.

### 2. Read Through
- **Description**: The cache acts as a proxy for the database. When a request for a key is made, the cache checks if the key exists. If not, it fetches the data from the database, stores it in the cache, and then returns the data to the application.
- **Pros**: Simplifies the application code; reduces cache miss penalties by always pre-fetching data.
- **Cons**: Cache must be able to handle reads effectively; can lead to stale data if not managed correctly.

### 3. Write Through
- **Description**: When data is written, it is simultaneously written to both the cache and the database.
- **Pros**: Ensures that the cache is always up-to-date; minimizes the risk of reading stale data.
- **Cons**: Write operations can be slower due to the dual writes; may not scale well for high-volume write operations.

### 4. Write Around
- **Description**: Data is written directly to the database, bypassing the cache. The next time the data is requested, it will be retrieved from the database and cached.
- **Pros**: Reduces the amount of stale data in the cache; can be efficient for write-heavy workloads.
- **Cons**: Initial read after a write may result in a cache miss, leading to potential latency.

### 5. Write Back (Write Behind)
- **Description**: Data is written to the cache first, and the actual write to the database is deferred to a later time. This allows for batching and asynchronous writes.
- **Pros**: Fast write operations and reduced load on the database; can improve overall application performance.
- **Cons**: Risk of data loss if the cache fails before the write to the database is completed; complexity in ensuring eventual consistency.


## Cache Invalidation & Eviction
* TTL
* Application updates cache
* FIFO
* LRU - Least Recently Used
* LFU - Least Frequently Used

## Where is cache?
* Client (browser)
* Proxies
* Application
* Database

### References:
* https://medium.com/@mmoshikoo/cache-strategies-996e91c80303