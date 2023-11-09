print("Welcome to treasure island. Your job is to find the treasure")
answer_one = input("Choose which way to turn left or right").lower()

if answer_one == "left":
    print("You made the right turn and are still alive")
    answer_two = input("Do you want to wait for the bridge to come down or just swim. Type wait or swim").lower()
else:
    print("A group of animals attack you, you have died")
    print("Game Over")
    exit()

if answer_two == "wait":
    print("You got on the boat and made it across the water")
    answer_three = input("What door do you go through, Yellow, Blue or Red. Answer with the door color you choose").lower()
else:
    print("You tried to swim and ended up drowning")
    print("Game Over")
    exit()

if answer_three == "yellow":
    print("You chose the right door and found the treasure")
    print("You win")
else:
    print("chose the wrong door and fell to your death")
    print("Game Over")
    exit()