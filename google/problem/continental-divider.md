### Problem
- [from](http://www.mitbbs.com/article_t1/JobHunting/32882153_0_1.html)

continental divider
给一个矩阵，其中0代表海洋，其他数字代表高度，秉着水往低处流的原则，求出能够
流向任意海洋的点。 比如说
```
0 0 0 1 2 3 0
0 1 2 2 4 3 2
2 1 1 3 3 2 0
0 3 3 3 2 3 3
```

那么就要给出 第二行的4 （这有这点出发，能够找到连通道四个0的区域的一条非递增
路线），当然也有可能找不到这样的点，或者找到多个点