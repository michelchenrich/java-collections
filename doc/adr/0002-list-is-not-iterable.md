# 2. `List` is not iterable

Date: 2018-11-09

## Context

Implementing the `Iterable` interface allows the collection object to be iterated via the imperative `for` keyword.

## Decision

The declarative alternative, `run`, must be used for plain iteration,
whereas `map`, `flatMap`, `reduce` and `filter` must be used for iteration which returns a new collection or value.

## Consequences

This decision forces clients to use a more declarative style for programming against collections,
instead of the common imperative style, which often leads to a mutation-first thinking.