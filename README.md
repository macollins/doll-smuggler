## Running the Solution

Use lein to run the solution from the project directory:

`lein run <path to file>`

e.g.

`lein run test/resources/data/example_data.txt`
d

## Running the Tests

Use lein to run the tests from the project directory:

`lein test`

## Problem

You are a drug trafficker. Every day you meet with a different nice older lady (the mule) and find out how much weight she can carry in her handbag. You then meet with your supplier who has packed various drugs into a myriad of collectible porcelain dolls. Once packed with drugs, each of the precious dolls has a unique combination of weight and street value. Sometimes your supplier has more dolls than the nice lady can carry, though space in her handbag is never an issue. Your job is to choose which dolls the kind soul will carry, maximizing street value, while not going over her weight restriction.

Write a Clojure function which given:

* a set of dolls with a name and unique weight and value combination
* an overall weight restriction

Produces the optimal set of drug-packed porcelain dolls which:

* are within the total weight restriction
* maximize the total street value of drugs delivered

Include a set of executable high-level tests for your solution. The following is a set of inputs for which the correct result is known:

Input:

    max weight: 400

    available dolls:

    name    weight value
    luke        9   150
    anthony    13    35
    candice   153   200
    dorothy    50   160
    puppy      15    60
    thomas     68    45
    randal     27    60
    april      39    40
    nancy      23    30
    bonnie     52    10
    marc       11    70
    kate       32    30
    tbone      24    15
    tranny     48    10
    uma        73    40
    grumpkin   42    70
    dusty      43    75
    grumpy     22    80
    eddie       7    20
    tory       18    12
    sally       4    50
    babe       30    10

Result:

    packed dolls:

    name    weight value
    sally       4    50
    eddie       7    20
    grumpy     22    80
    dusty      43    75
    grumpkin   42    70
    marc       11    70
    randal     27    60
    puppy      15    60
    dorothy    50   160
    candice   153   200
    anthony    13    35
    luke        9   150

Hints:

* use leiningen - https://github.com/technomancy/leiningen
* read this - http://en.wikipedia.org/wiki/Knapsack_problem
* find more interesting example data for test cases on the internets

