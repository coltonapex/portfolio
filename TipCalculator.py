total = input("what was the bill total?")
tip_percent = input("What percent do you want to tip? Your options are 10, 12, 15")
people = input("How many people are splitting the bill")

float_tip_percent = float(tip_percent) / 100
float_total = float(total)
tip_amount = float_total * float_tip_percent
int_people = int(people)
total_and_tip = float_total + tip_amount
amount_pay = total_and_tip / int_people
final_total = round(amount_pay,2)
print(f"Each person should pay: {final_total}")