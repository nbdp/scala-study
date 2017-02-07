# 集合


## 知识点

1. 所有集合都扩展自Iterable特质
2. 集合有三大类，分别为序列、集、映射
3. 对于几乎所有集合类，scala都同时提供了可变和不可变版本
4. scala列表要么是空的，要么拥有一头一尾，其中尾部又是一个列表
5. 集是无先后次序的集合
6. 用LinkedHashSet来保留插入顺序，或者用SortedSet来顺序进行迭代
7. +将元素添加到无先后次序的集合中，+：和:+向前或向后追加到序列中，++将两个集合串接在一起；-和--移出元素
8. Iterable和Seq特质有数十个用于常见操作的方法。在编写冗长繁琐的循环之前，先看看这些方法是否满足你的需要。
9. 映射、折叠和拉链操作是很有用的技巧，用来将函数或操作应用到集合中的元素。