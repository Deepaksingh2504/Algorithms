# Z Algorithm Notes

## Definition

Z[i] = Length of the longest common prefix between:

* s[0...]
* s[i...]

Example:

s = "ababab"

Z = [0, 0, 4, 0, 2, 0]

Because:

* Z[2] = 4 ("abab")
* Z[4] = 2 ("ab")

---

## Z Box

Maintain:

L = Left boundary of current Z-box

R = Right boundary of current Z-box

Meaning:

s[L...R] matches prefix s[0...(R-L)]

---

## Case 1: Outside Z Box

If:

i > R

No previous information available.

Create a new Z-box.

```java
L = R = i;

while(R < n && s.charAt(R) == s.charAt(R - L))
{
    R++;
}

Z[i] = R - L;
R--;
```

Important:

* R points to first mismatch after loop
* Z[i] = matched length
* R-- moves R to last matched position

---

## Case 2: Inside Z Box

If:

i <= R

Find corresponding position in prefix:

```java
k = i - L;
```

Meaning:

k = position of i inside current Z-box.

---

### If Match Fits Completely Inside Box

```java
if(Z[k] < R - i + 1)
{
    Z[i] = Z[k];
}
```

Reason:

Entire match is already known.

No comparisons required.

---

### If Match Touches Boundary

```java
else
{
    L = i;

    while(R < n && s.charAt(R) == s.charAt(R - L))
    {
        R++;
    }

    Z[i] = R - L;
    R--;
}
```

Reason:

Match may continue beyond current Z-box.

Need to extend and possibly create a larger Z-box.

---

## Important Meanings

### k = i - L

Position of i inside current Z-box.

Equivalent position in prefix.

---

### R - i + 1

Number of characters remaining in current Z-box from i onward.

Maximum match length that is guaranteed.

---

### R = i + Z[i] - 1

If:

Z[i] = match length

Then:

R = last matched index.

Example:

i = 4

Z[4] = 3

Matched indices:

4, 5, 6

Therefore:

R = 4 + 3 - 1 = 6

---

## Pattern Matching

Create:

pattern + "#" + text

Compute Z-array.

If:

Z[i] == pattern.length()

Pattern occurs at:

i - pattern.length() - 1

---

## Complexity

Time: O(n)

Space: O(n)
