# in-memory-repository-sorting-sample

Extends [in-memory-repository-sample](https://github.com/core-java-samples/in-memory-repository-sample) with sorting support.

## What It Demonstrates

Adds a `Comparator<Owner>` parameter to the repository interface.  The caller controls the sort order — the repository applies it before returning results.  Passing `null` skips sorting and returns records in insertion order.

## Structure

All code is in a single file: `InMemoryRepositorySortingApp.java`

```
InMemoryRepositorySortingApp.java
│
├── Owner                          # Entity — record with id and name
├── OwnerRepository                # Repository interface with Comparator<Owner> parameter
├── FakeOwnerRepository            # In-memory implementation using LinkedHashMap
└── InMemoryRepositorySortingApp   # Entry point + demo()
```

## Key Points

**Comparator as a parameter.** The repository interface accepts a `Comparator<Owner>` — the caller decides the order, the repository just applies it.

**Null means no sorting.** Passing `null` returns records in their natural insertion order — no special case needed in the caller.

**Original data is never mutated.** Sorting is applied on a stream — the underlying `LinkedHashMap` stays unchanged.

## Console Output

```
Owner[id=1, name=jack1]
Owner[id=2, name=jack2]
Owner[id=3, name=jack3]
Owner[id=4, name=jack4]
Owner[id=5, name=jack5]

Owner[id=5, name=jack5]
Owner[id=4, name=jack4]
Owner[id=3, name=jack3]
Owner[id=2, name=jack2]
Owner[id=1, name=jack1]

Owner[id=1, name=jack1]
Owner[id=2, name=jack2]
Owner[id=3, name=jack3]
Owner[id=4, name=jack4]
Owner[id=5, name=jack5]
```

First block — sorted by id ascending. Second — by id descending. Third — no sorting, insertion order.

## Run

```bash
./mvnw spring-boot:run
```

## See also

- Previous: [in-memory-repository-sample](https://github.com/core-java-samples/in-memory-repository-sample)
- Next: [pagination-pageable-sample](https://github.com/core-java-samples/pagination-pageable-sample)
