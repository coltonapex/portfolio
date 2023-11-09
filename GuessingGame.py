import random
def rand():
    rand_num = random.randint(1, 100)
    return rand_num

def check(guess, answer):

    if guess > answer:
        print("Guess was too high try again")
    elif guess < answer:
        print("Guess was too low try again")
    else:
        print(f"Guess was correct. The answer was {answer}")

print("I'm thinking of a number between 1 and 100")
difficulty = input("Choose a difficulty. Hard or easy. Type h for hard or e for easy")
diff_ans = difficulty.lower()

if diff_ans == "h":
    print("You have chose hard you have 5 attempts to guess the correct number")
    attempts = 5
    answer = rand()
    while attempts > 0:
        guess = int(input("Guess a number between 1 and 100"))
        check(guess, answer)
        attempts -=1
        print(f"Attempts left {attempts}")

if diff_ans == "e":
    print("You have chose easy you have 10 attempts to guess the correct number")
    attempts = 10
    answer = rand()
    while attempts > 0:
        guess = int(input("Guess a number between 1 and 100"))
        check(guess, answer)
        attempts -=1
        print(f"Attempts left {attempts}")