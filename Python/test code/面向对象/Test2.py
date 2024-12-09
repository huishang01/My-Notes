class Student:
    def __init__(self, name, age, address):
        self.name = name
        self.age = age
        self.address = address

    def __str__(self):
        return f'【{self.name}, {self.age}, {self.address}】'


stu = []
for i in range(10):
    name = input("姓名：")
    age = input("年龄：")
    address = input("地址：")
    student = Student(name, age, address)
    print("录入成功！")
    print(student)
    stu.append(student)

print(stu)
