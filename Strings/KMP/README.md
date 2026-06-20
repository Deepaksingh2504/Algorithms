# KMP Quick Notes

## What problem does KMP solve?

Find whether a pattern exists inside a text efficiently.

Example:

Text = ABABCABABD

Pattern = ABABD

---

## Why not Frequency Map?

Frequency Map:

* Checks same characters.
* Good for Anagrams.

KMP:

* Checks same characters
* Same order
* Continuous substring

---

## LPS Meaning

LPS[i] = Length of the Longest Prefix which is also a Suffix for substring [0...i]

Example:

Pattern = ABABA

LPS = 0 0 1 2 3

Because:

ABABA

Prefix = ABA

Suffix = ABA

Length = 3

---

## Meaning of j

During LPS construction:

j = current length of matched prefix-suffix

During KMP search:

j = how many pattern characters currently match

---

## Most Important Line

j = lps[j-1];

Meaning:

"I got a mismatch. What's the biggest part I can still trust?"

Do NOT restart from 0 immediately.

Reuse previous matches.

---

## Building LPS

Match:

pattern[i] == pattern[j]

j++
lps[i] = j
i++

Mismatch:

j != 0

j = lps[j-1]

Mismatch:

j == 0

lps[i] = 0
i++

---

## KMP Search

i = text pointer

j = pattern pointer

Match:

i++
j++

Mismatch:

j != 0

j = lps[j-1]

Mismatch:

j == 0

i++

---

## Pattern Found

if(j == pattern.length())

Pattern exists.

Starting Index:

i - j

Reason:

i = current position after matching

j = matched length

start = i - j

---

## Count All Occurrences

if(j == pattern.length())
{
count++;
j = lps[j-1];
}

Important for overlapping matches.

Example:

Text = AAAAA

Pattern = AAA

Matches:

Index 0
Index 1
Index 2

Count = 3

---

## Complexity

Build LPS = O(m)

Search = O(n)

Total = O(n + m)

n = text length

m = pattern length

---

## EXAMPLE

LeetCode 28

Find the Index of the First Occurrence in a String

(Classic KMP)
