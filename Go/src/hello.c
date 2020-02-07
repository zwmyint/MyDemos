/**
* https://blog.csdn.net/soonfly/article/details/51131141
* https://www.learn-c.org/
* 理解三个概念：
* 指针的类型（去掉变量名）
* 指针所值的类型（去掉变量名和左侧紧挨变量名的*）
* 指针的值（指针所指的内存存放的内容）
* ptrold + n = ptrnew 表示 ptrold + n * sizeof (ptrold所指的类型)
**/


#include <stdio.h>
int main() {
  char a[20]="You_are_a_girl";
  char *p=a;
  //a 和 &a 都表示数组的起始地址，*p表示指针所指向的地址中所存的内容
  printf("%p, %p, %c\n", a, &a, *p );
  //p就是a的起始地址
  printf("%p\n", p);
  //ptr存放的是指针p在内存中的存放的地址，这个地址不是数组a的起始地址！！
  char **ptr=&p;
  printf("%p\n", ptr);
  //*ptr表示指针ptr所存的内容，即是数组a的起始地址
  printf("%p\n", *ptr);
  //**ptr即是数组a起始地址所存放的内容
  printf("%c\n", **ptr);
  
  //表示指针p在内存中的存放的地址 + sizeof(char**)
  ptr++;
  printf("%d\n", sizeof(char **));
}

void func() {p
    int *p[3]; //p表示一个数组，数组的长度是3，数组中存放的内容是 int* 指针
    int (*p)[3]; //p 表示一个指向一个长度是3，存放int类型的数组的指针
    int (*p)(int); //p 表示一个指向一个参数是一个int，返回int类型的函数的指针
    int *(*p(int))[3];//p是一个参数为一个整型数据且返回一个指向由整型指针变量组成的数组的指针变量的函数
}
    