# Traversing ArrayLists

Since `ArrayList` objects are data structures, it makes sense that we would want to be able to utilize some techniques we developed for arrays with them, like traversal.

---

## Basic Traversal

At its core, traversing `ArrayList` objects is extremely similar to traversing arrays, especially since we have the same zero-index system that arrays had. Here is how we could traverse an `ArrayList` using its indices with a `for` or `while` loops in an example from the `NotesTraversal1.java` file:

```java
ArrayList<Integer> intList = new ArrayList<Integer>();
intList.add(5);
intList.add(2);
intList.add(13);
for (int i = 0; i < intList.size(); i++) {
    System.out.println(intList.get(i));
}
int index = 0;
while (index < intList.size()) {
    System.out.println(intList.get(index));
    index++;
}
```

Notice the two primary differences from arrays:
1. We have to use `intList.size()` in the header instead of `.length` like we did for arrays.
2. We have to use `intList.get(i)` in the print statement instead of `[i]` like we did for arrays.

Just like with arrays, we have to be careful with our loop header, as providing a bad index will result in an `ArrayIndexOutOfBoundsException`. We have to make sure we only ever provide `0` through `size() - 1` as our indices to prevent this.

Conveniently, we can use our enhanced `for` loop, or `for-each` loop basically the same as we did for arrays. Here is an example from the `NotesTraversal2.java` file:

```java
ArrayList<Double> doubleList = new ArrayList<Double>();
doubleList.add(-4.5);
doubleList.add(12.1);
doubleList.add(80.23);
for (double num : doubleList) {
    System.out.println(num);
}
```

Just like with arrays, `num` is a temporary variable that is initialized with a copy of each value from `doubleList`, and therefore we don't have to utilize our indices to print out each element.

Notice that the `ArrayList` is type `Double` (the wrapper class), but our `for-each` loop utilizes `double` (the primitive type) instead. This is allowed due to **auto-unboxing**, where Java is able to automatically convert a wrapper class value to its associated primitive type value, without causing any issues. This makes it much easier to work with primitive values from `ArrayList` objects.

---

## Removing Elements in Traversal

The defining trait of `ArrayList` objects is being able to add and remove elements as needed. This is really important as it makes them much more distinct from arrays, but it can bring up interesting problems with traversals if we are not careful.

The core of this issue is that there is nothing wrong with adding or removing elements while traversing an `ArrayList` *if* you do it correctly. We are going to focus on removing elements (while adding elements does happen occasionally, it is rare and more unusual to do).

The issue is easiest to understand if we try to remove an element from an `ArrayList` while we traverse it. Here is an example of this from the `NotesRemove1.java` file that tries to remove all instances of `"Hello"` from the `ArrayList`:

```java
ArrayList<String> strList = new ArrayList<String>();
strList.add("Hi");
strList.add("Hello");
strList.add("Hello");
strList.add("Hey");
strList.add("Hello");
strList.add("Hola");
for (int i = 0; i < strList.size(); i++) {
    if (strList.get(i).equals("Hello")) {
        strList.remove(i);
    }
}
for (String str : strList) {
    System.out.println(str);
}
```

Here is the output of this code:

```
Hi
Hello
Hey
Hola
```

Our code seems to have missed one of the `"Hello"` `String` objects when it tried to remove each of them! This is because of what happens to the indices of elements when an element is removed from the `ArrayList`: all elements to the right have their indices shifted to the left by `1` (subtract `1`).

The `"Hello"` we see printed is the second one in the `ArrayList` (originally at index `2`). What happens is when `i = 1`, the code correctly identifies that the current element is `"Hello"` and removes it. This lowers the indices of all elements to the right by `1`, meaning that our second `"Hello"` gets shifted index `2 - 1 = 1` and is printed out by the print statement. Then, the loop moves on to `i = 2`, which is now the element `"Hey"`, and it misses the opportunity to delete that second `"Hello"`, but is able to find the third `"Hello"` and remove it.

This particular issue with removal is specifically in regards to consecutive elements (elements that are right next to each other). If we never had any `"Hello"` elements that were right next to each other, this wouldn't have been an issue! Regardless, we want to be able to correct for this issue when we traverse, since often we don't know or can't guarantee that these things wouldn't be right next to each other.

The solution is simple: when we remove an element (and only then), reduce the loop control variable by `1` so that when it increments for the next element, its forced to re-check the index it just removed (since `# - 1 + 1 = #`). Doing this would allow us to remove any number of elements that are right next to each other. Here is what this change would look like from the `NotesRemove2.java` file:

```java
ArrayList<String> strList = new ArrayList<String>();
strList.add("Hi");
strList.add("Hello");
strList.add("Hello");
strList.add("Hey");
strList.add("Hello");
strList.add("Hola");
for (int i = 0; i < strList.size(); i++) {
    if (strList.get(i).equals("Hello")) {
        strList.remove(i);
        i--;
    }
}
for (String str : strList) {
    System.out.println(str);
}
```

This produces the more correct output:

```
Hi
Hey 
Hola
```

The only change was the `i--;` inside of the `for` loop and `if` statement, otherwise the code is unchanged. This is a standard modification to do in a loop whenever you are removing elements from an `ArrayList`.

---

## Modification with `for-each` Traversal

We have discussed at length how there are certain situations where `for-each` loops are not appropriate for arrays, like when you need the index to work on, or when you need to modify the values in an array.

This still holds true for `ArrayList`, but now our definition of "modify the values" extends to adding or removing values. It is important to note that adding or removing elements from an `ArrayList` in a `for-each` loop is very odd to set up, since they require the index and a `for-each` loop does not traditionally track it, but it can happen.

If you change the `size()` of an `ArrayList` during a `for-each` loop, it can result in a `ConcurrentModificationException`, which would stop your program.

Here is an example from the `NotesModify1.java` file that demonstrates the `ConcurrentModificationException`:

```java
ArrayList<Person> peopleList = new ArrayList<Person>();
peopleList.add(new Person("Mr. G", 25));
peopleList.add(new Person("Sam", 33));
peopleList.add(new Person("Owen", 22));
for (Person person : peopleList) {
    System.out.println(person);
    peopleList.remove(0);
}
```

Despite printing the first `Person` successfully, this produces a `ConcurrentModificationException`, as the `size()` of the `ArrayList` was changing during the `for-each` loop.

In general, we should not use `for-each` loops in the following traversal situations:
- When we need access to the index.
- When we need to modify elements (like with `set()`).
- When we need to add or remove elements.

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
