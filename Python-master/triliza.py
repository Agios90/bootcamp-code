from random import randint
import time

print("Lets play a game\n")

#Ζωγραφιζει το state της τριλιζας
def drawtriliza(x1,x2,x3,x4,x5,x6,x7,x8,x9):
    print(x1,"|",x2,"|",x3)
    print("----------")
    print(x4,"|",x5,"|",x6)
    print("----------")
    print(x7,"|",x8,"|",x9)
    print("\n")

#Παιρνει input απ'τον χρήστη ελέγχοντας για λάθη
def kinisi(x1,x2,x3,x4,x5,x6,x7,x8,x9):
    c1=input("Δώσε μου γραμμή (1-3): ")
    c2=input("Δώσε μου στήλη (1-3): ")
    print("\n")
    placed=False
    if c1=='1' and c2=='1' and x1==" ":
        x1="O"
        placed=True
    if c1=='1' and c2=='2' and x2==" ":
        x2="O"
        placed=True
    if c1=='1' and c2=='3' and x3==" ":
        x3="O"
        placed=True
    if c1=='2' and c2=='1' and x4==" ":
        x4="O"
        placed=True
    if c1=='2' and c2=='2' and x5==" ":
        x5="O"
        placed=True
    if c1=='2' and c2=='3' and x6==" ":
        x6="O"
        placed=True
    if c1=='3' and c2=='1' and x7==" ":
        x7="O"
        placed=True
    if c1=='3' and c2=='2' and x8==" ":
        x8="O"
        placed=True
    if c1=='3' and c2=='3' and x9==" ":
        x9="O"
        placed=True
    if placed==False:
        print("Ώπα, κάτι πήγε λάθος (λάθος input). Δώσε ξανά.")
        time.sleep(1)
        x1,x2,x3,x4,x5,x6,x7,x8,x9 = kinisi(x1,x2,x3,x4,x5,x6,x7,x8,x9)
    return x1,x2,x3,x4,x5,x6,x7,x8,x9

#Κάνει μια τυχαία επιτρέψιμη κίνηση
def random_kinisi_pc(x1,x2,x3,x4,x5,x6,x7,x8,x9):
    placed=False
    while not placed:
        r=randint(1,9)
        if r==1 and x1==" ":
            x1="X"
            placed=True
        if r==2 and x2==" ":
            x2="X"
            placed=True
        if r==3 and x3==" ":
            x3="X"
            placed=True
        if r==4 and x4==" ":
            x4="X"
            placed=True
        if r==5 and x5==" ":
            x5="X"
            placed=True
        if r==6 and x6==" ":
            x6="X"
            placed=True
        if r==7 and x7==" ":
            x7="X"
            placed=True
        if r==8 and x8==" ":
            x8="X"
            placed=True
        if r==9 and x9==" ":
            x9="X"
            placed=True
    return(x1,x2,x3,x4,x5,x6,x7,x8,x9)

#def optimised_kinisi_pc... to-do
#
#
#
#
#


#ελέγχει αν το παιχνίδι τέλειωσε και επιστρέφει κατάλληλο μήνυμα
def checkifover(x1,x2,x3,x4,x5,x6,x7,x8,x9):
    wincon1 = (x1==x2==x3=="O" or x1==x2==x3=="X")
    wincon2 = (x4==x5==x6=="O" or x4==x5==x6=="X")
    wincon3 = (x7==x8==x9=="O" or x7==x8==x9=="X")
    wincon4 = (x1==x4==x7=="O" or x1==x4==x7=="X")
    wincon5 = (x2==x5==x8=="O" or x2==x5==x8=="X")
    wincon6 = (x3==x6==x9=="O" or x3==x6==x9=="X")
    wincon7 = (x1==x5==x9=="O" or x1==x5==x9=="X")
    wincon8 = (x3==x5==x7=="O" or x3==x5==x7=="X")
    if wincon1 or wincon2 or wincon3 or wincon4 or wincon5 or wincon6 or wincon7 or wincon8:
        print("Game Over")
        time.sleep(2)
        exit()
        return True
    else:
        if (x1==" " or x2==" " or x3==" " or x4==" " or x5==" " or x6==" " or x7==" " or x8==" " or x9==" "):
            return False
        else:
            print("No available spaces. Game Over")
            time.sleep(2)
            exit()
            return True

#αρχικοποίηση συντεταγμένων
x1=" "
x2=" "
x3=" "
x4=" "
x5=" "
x6=" "
x7=" "
x8=" "
x9=" "

# αν θέλουμε το PC να παιξει πρώτο
x1,x2,x3,x4,x5,x6,x7,x8,x9 = random_kinisi_pc(x1,x2,x3,x4,x5,x6,x7,x8,x9)
drawtriliza(x1,x2,x3,x4,x5,x6,x7,x8,x9)

#main loop
while not checkifover(x1,x2,x3,x4,x5,x6,x7,x8,x9):
    x1,x2,x3,x4,x5,x6,x7,x8,x9 = kinisi(x1,x2,x3,x4,x5,x6,x7,x8,x9)
    drawtriliza(x1,x2,x3,x4,x5,x6,x7,x8,x9)
    time.sleep(1)
    if not checkifover(x1,x2,x3,x4,x5,x6,x7,x8,x9):
        print("Σειρά μου τώρα \n")
        time.sleep(1)
        x1,x2,x3,x4,x5,x6,x7,x8,x9 = random_kinisi_pc(x1,x2,x3,x4,x5,x6,x7,x8,x9)
        #to-do optimised kinisi pc
        drawtriliza(x1,x2,x3,x4,x5,x6,x7,x8,x9)
