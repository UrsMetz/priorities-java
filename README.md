# Priorities

This projects aims at finding / practice finding a nice / clean / good solution to the following requirement:

Given a list of items (identified i.e. by a name) having a priority.
When asked to prioritize produce a list of those items that have the highest priority.
When asked again produce a list of those items with the next highest priority.

The Priority is an integer number and a higher number indicates a higher priority. Priorities do not need to be unique among the items.

## Examples

The input is given in the form `item name - corresponding priority`.
The numbers before the expected results signify the output after the nth invocation of our oracle. infty means infinity. (nothing) represents the empty list

Input
* Item 1 - 1

Should yield:

1) Item 1

2) (nothing)

3 - infty) (nothing)

Input
* Item 1 - 3
* Item 2 - 2
* Item 3 - 1

Should yield:

1) Item 1 as the result

2) Item 2

3) Item 3

4 - infty) (nothing)

Input
* Item 1 - 6
* Item 2 - 6
* Item 3 - 1

Should yield:

1) Item 1 and Item 2 as the result

2) Item 3

3 - infty) (nothing)

Input
* Item 1 - 4
* Item 2 - 3
* Item 3 - 3
* Item 4 - 1

Should yield:

1) Item 1

2) Item 2 and Item 3

3) Item 4

4 - infty) (nothing)
