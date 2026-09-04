# Offline strategy

The showcase queue illustrates the minimum shape of an offline-first interaction:

1. create an opaque mutation with a stable client-generated id;
2. persist it locally when a request cannot be sent;
3. replay in creation order when connectivity returns;
4. remove only mutations acknowledged by the API.

Real offline systems require richer dependency handling, conflict states, retry policy, ownership isolation, observability, and user-facing recovery. Those production-specific mechanisms are intentionally described at a high level only.
