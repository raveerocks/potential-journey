# Binary Exponentiation

Binary exponentiation (also known as exponentiation by squaring) is a trick which allows to calculate a<sup>n</sup> using only O(logn) multiplications (instead of O(n) multiplications required by the naive approach).

It also has important applications in many tasks unrelated to arithmetic, since it can be used with any operations that have the property of **associativity:**

<p align="center">
 (X ⋅ Y)⋅ Z = X ⋅ (Y ⋅ Z)
</p>

Most obviously this applies to modular multiplication, to multiplication of matrices etc.

## Algorithm

Raising a to the power of n is expressed naively as multiplication by a done n−1 times: a<sup>n</sup>=a⋅a⋅…⋅a. However, this approach is not practical for large a or n.
<p align="center">
a<sup>b+c</sup>=a<sup>b</sup>⋅a<sup>c</sup> and a<sup>2b</sup>=a<sup>b</sup>⋅a<sup>b</sup>=(a<sup>b</sup>)<sup>2</sup>.

The idea of binary exponentiation is, that we split the work using the binary representation of the exponent.
</p>
Let's write n in base 2, for example:
<p align="center">
  3<sup>13</sup>=3<sup>1101<sub>2</sub></sup>=3<sup>8</sup>⋅3<sup>4</sup>⋅3<sup>1</sup>
</p>
 
 Since the number n has exactly ⌊log<sub>2</sub>n⌋+1 digits in base 2, we only need to perform O(logn) multiplications, if we know the powers a<sup>1</sup>,a <sup>2</sup>,a<sup>4</sup>,a<sup>8</sup>,…,a<sup>⌊logn⌋</sup>.
 
 So we only need to know a fast way to compute those. Luckily this is very easy, since an element in the sequence is just the square of the previous element.

<p align="center">
  3<sup>1</sup> = 3<br>
  3<sup>2</sup> = (3<sup>1</sup>)<sup>2</sup> = 3<sup>2</sup> = 9<br>
  3<sup>4</sup> = (3<sup>2</sup>)<sup>2</sup> = 9<sup>2</sup> = 81<br>
  3<sup>8</sup> = (3<sup>4</sup>)<sup>2</sup> = 81<sup>2</sup> = 6561<br>
  </p>
  
  So to get the final answer for 3<sup>13</sup>, we only need to multiply three of them (skipping 3<sup>2</sup>because the corresponding bit in n is not set): 3<sup>13</sup> = 6561⋅81⋅3 = 1594323
  
  The final complexity of this algorithm is O(logn): we have to compute logn powers of a, and then have to do at most logn multiplications to get the final answer from them.
  
  The following recursive approach expresses the same idea:
