#usr/bin/python3
import time
import os

def title():
    print(""""
    ░██╗░░░░░░░██╗███████╗██████╗░░██████╗░██████╗░░█████╗░███████╗██╗░█████╗░
    ░██║░░██╗░░██║██╔════╝██╔══██╗██╔════╝░██╔══██╗██╔══██╗██╔════╝██║██╔══██╗
    ░╚██╗████╗██╔╝█████╗░░██████╦╝██║░░██╗░██████╔╝███████║█████╗░░██║███████║
    ░░████╔═████║░██╔══╝░░██╔══██╗██║░░╚██╗██╔══██╗██╔══██║██╔══╝░░██║██╔══██║
    ░░╚██╔╝░╚██╔╝░███████╗██████╦╝╚██████╔╝██║░░██║██║░░██║██║░░░░░██║██║░░██║
    ░░░╚═╝░░░╚═╝░░╚══════╝╚═════╝░░╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░░░░╚═╝╚═╝░░╚═╝
    """)

    titulo = "Bienvenido Walid"
    print(titulo + "\n" + "-"*len(titulo))


def today():
    question = input("Quieres poner la data [a]utomaticamente (hoy) o [m]anualmente: ").capitalize()
    if question == "M":
        return input("Pon la data (dd/mm/yy): ")
    else:
        return time.strftime("%d/%m/%y")

def txt(name, purpose, date, url):
    with open("webgrafia.txt", "a") as file:
        file.write("{}. {}. Recuperat el {}, des de {}\n".format(name, purpose, date, url))

def main():
    title()
    time.sleep(2)
    finish = False
    while not finish:
        url = input("Escribe la URL: ")
        name = url.split(".")[1].capitalize()

        purpose = input("Proposito de la pagina: ")
        date = today()
        txt(name, purpose, date, url)
        if input("Quieres escribir más webgrafias (s/n) ").capitalize() == "S":
            finish = False
            os.system('cls' if os.name == 'nt' else 'clear')
        else:
            print("Cerrando programa: ")

if __name__ == "__main__":
    main()