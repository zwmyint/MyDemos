# for 循环
import time as t
example_list = [1, 2, 3, 4, 5, 6, 6, 7, 9]
for i in example_list:
    print(i)
    print("Inner for loop segment!")
print("Outer of for segment!")

# range 函数
# 包含左边的，但不包含右边的数字，下面的例子实际上输出1-4
# range(start, end, step)
for i in range(1, 5):
    print(i)

for i in range(1, 10, 3):
    print(i)

# if-else Statement
x, y, z = 3, 5, 7
if True:
    print("true")

if False:
    print("Nothing")

# <, >, <=, >=, ==, !=
if x < y < z:
    print("OK")

if x == y:
    print("x==y")

if x < y:
    print("x<y")
else:
    print("x>y")

if x < y:
    print(1)  # Only go the branch
elif x < z:
    print(2)
else:
    print(3)


# tuple 不可变

a_tuple = 1, 2, 3, 4
for i in a_tuple:
    print(i)

# list
a_list = [1, 2, 3, 4, 5, 7, 8]
a_list.append(6)

# 2 和 5 表示下标 [2,5)
print(a_list[2:5])

# dictionary
dic = {1: 2, '2': 3, 3: {'a': 'b'}}
print(dic[3])


print(t.time())


try:
    file = open('1.txt', 'r')
except Exception as e:
    print('file is not found!')


# zip， lambda， map 用法

# copy.copy() 只能深copy简单对象， copy.deepcopy() 完全深copy

# pickle 序列化数据到文件

# with

with open ('1.txt', 'rb') as file:
    print()


# Set