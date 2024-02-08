# Understanding Check

**Prime numbers** are whole numbers whose only divisors (numbers that evenly divide them) are `1` and itself. A number that is not prime is called **composite**.The **Sieve of Erastosthenes** is an ancient algorithm to find prime numbers.

The algorithm works under the assumption that you can find the smallest primes, and then use them to find larger ones.

Essentially, you start with your list of all numbers, from `2` up to whatever number you want to stop at (since `1` is neither prime nor composite).

You start with the smallest prime, which is `2`, and remove all numbers from your list who are multiples of `2`, since that would mean `2` times some value would get you those numbers, making them not prime.

We repeat this process with the next prime `3`, then the next prime `5` (`4` would have been removed from our list), and so on until we've used all the primes in our list. At this point, our list would contain only the prime numbers between `2` and the ending value we selected.

In `Understanding.java`, do the following:
- Create an `int` variable `stop` that denotes our stopping value. Give it an initial value of `20`.
- Create an `Integer` `ArrayList` and use a loop to add all whole numbes from `2` to `stop` (inclusive).
- Create a regular `for` loop that goes through each index of the `ArrayList`.
- Inside of the loop, create an `int` variable `currentPrime` and set it to the current value from the `ArrayList`.
- Create another regular `for` loop inside of this one that again goes through each index of the `ArrayList`, starting at the index after the current outer index (if outer is `i`, it starts at `i + 1`).
- Inside the inner loop, check if the current array value is divisible by `currentPrime`. If it is, remove it from the list (and modify your index so you don't accidentally skip any).
- Outside of both loops, use a `for-each` loop to print out the remaining values. These remaining values should be the prime numbers.

To test your code, try other values for `stop`, like `50`, `100`, or `1000` and see if they work. (Look up a list of prime numbers for reference if you need to).

Once you have gotten to just warnings, save the Java file and commit and push your changes via GitHub Desktop.
