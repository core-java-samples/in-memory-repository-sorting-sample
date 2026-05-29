# sortable-fake-repository-sample

Extends [in-memory-repository-sample](https://github.com/core-java-samples/fake-repository-sample) with managed sorting.

## Structure

All code is in a single file: `Main.java`

- `Owner` — entity
- `OwnerRepository` — repository interface with `Comparator<Owner>` parameter
- `FakeOwnerRepository` — in-memory implementation using `LinkedHashMap`

## Usage

```java
repository.findAll(Comparator.comparing(Owner::id));           // by id asc
repository.findAll(Comparator.comparingLong(Owner::id).reversed()); // by id desc
repository.findAll(null);                                      // no sorting
```

## Run

```bash
javac Main.java && java Main
```
