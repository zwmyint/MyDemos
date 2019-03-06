# def function


def myFun():
    print("This is function.")


myFun()


def myFun(name, age):
    return name + ":" + str(age)


result = myFun('Tom', 12)
print(result)

# default args


def myFun(addr, name='tom', age=18):
    print(addr + ":" + name + ":" + str(age))


myFun('SH', 'Jack')
myFun('SH')

# local variable and golbal variable


# As is a final variable
APPLE = 'red'


def fun1():
    print(APPLE)  # red
    # APPLE = 'green' # UnboundLocalError
    print(APPLE)


fun1()


a = None


def fun2():
    a = 20
    print('inner fun2: ' + str(a))  # 20


fun2()
print(a)  # None


def fun3():
    global a
    a = 30    # Change global value
    print('inner fun3: ' + str(a))  # 30


fun3()
print(a)  # 30
