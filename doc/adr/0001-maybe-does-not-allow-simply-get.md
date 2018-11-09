# 1. `Maybe` does not allow to simply `.get()`

Date: 2018-11-08

## Context

Java's native `Optional` allows to simply attempt to fetch the possibly null value by the `get` method.
This will often lead to `null` being returned, defeating the entire purpose of having an `Optional` type.

## Decision

`Maybe` will not have `get` or any equivalent.

## Consequences

To fetch the contained value, `or` or `orThrow` *must* be used.
This forces the client to produce an alternative value for the negative case, or throw an appropriate exception

However, the `or` methods can still be used to explicitly return `null`, in which case, god bless you and godspeed.

