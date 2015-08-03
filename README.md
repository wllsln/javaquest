javaquest
===========

This repo explores different problems with solutions written in Java. Some of these may be from various interview questions I've encountered, or maybe just interesting things I found on the web.

IntSearch.java
----------
This is an implementation to find the index of the first occurrence of a number in an array and the count of such many indexes. I have implemented using binary search for performance to be decent despite large array size.

The findMatches function is divided up as such:
- binary search to find at least one occurence of the query
- binary search to find first duplicate
- binary search to find last duplicate

So overall complexity is O(log n) + O(log n) + O(log n) = 3* O(log n) => O(log n)
