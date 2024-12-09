class Student:
    name = None

    def __init__(self, name):
        self.name = name

    def say(self):
        print(f"Hello {self.name} World")

    def sports(self, sport):
        print(f"I am {self.name}, I like {sport}")


s1 = Student("Cris")
s1.say()
s1.sports("basketball")

s2 = Student("Bob")
s2.say()
s2.sports("baseball")
