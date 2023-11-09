def add(num1, num2):
    return num1 + num2

def subtract(num1, num2):
    return num1 - num2

def multiply(num1, num2):
    return num1 * num2

def divide(num1, num2):
   return num1 / num2

ops = {
    "+": add,
    "-": subtract,
    "*": multiply,
    "/": divide
}

current_num = 0
first_num = int(input("Enter your first number"))
second_num = int(input("Enter your second number"))

for symbol in ops:
    print(symbol)

operation = input("Pick an operation")

function_to_use = ops[operation]

answer = function_to_use(first_num, second_num)
print(answer)