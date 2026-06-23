# Floyd's Cycle Detection Algorithm (Tortoise and Hare)

## Idea

Use two pointers:

* Slow Pointer → moves 1 step at a time
* Fast Pointer → moves 2 steps at a time

If a cycle exists, the fast pointer will eventually catch the slow pointer.

If no cycle exists, the fast pointer will reach null.

---

## Cycle Detection

### Pattern

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null)
{
    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast)
    {
        return true;
    }
}

return false;
```

### Time Complexity

O(n)

### Space Complexity

O(1)

---

## Why It Works

Inside a cycle:

* Slow moves 1 step
* Fast moves 2 steps

Fast gains 1 node per iteration.

Eventually fast catches slow.

Similar to two runners on a circular track.

---

## Applications

### 1. Detect Cycle in Linked List

LeetCode 141 - Linked List Cycle

---

### 2. Find Starting Node of Cycle

LeetCode 142 - Linked List Cycle II

After slow and fast meet:

```java
slow = head;

while (slow != fast)
{
    slow = slow.next;
    fast = fast.next;
}

return slow;
```

The meeting point is the start of the cycle.

---

## Fast & Slow Pointer Variation

The same idea is used to find the middle of a linked list.

### Middle of Linked List

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null)
{
    slow = slow.next;
    fast = fast.next.next;
}

return slow;
```

When fast reaches the end:

* slow is at the middle.

For even length lists, this returns the second middle node.

---

## Key Pattern to Remember

```java
while (fast != null && fast.next != null)
{
    slow = slow.next;
    fast = fast.next.next;
}
```

This pattern appears in:

* Linked List Cycle
* Linked List Cycle II
* Middle of Linked List
* Palindrome Linked List
* Reorder List

