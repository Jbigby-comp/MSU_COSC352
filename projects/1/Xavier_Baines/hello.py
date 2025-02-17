import sys

def hello_world(name: str, number: int):
    for _ in range(number):
        print(f"Hello {name}")

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print(f"Usage: python {sys.argv[0]} <name> <number>")
        sys.exit(1)
    
    name = sys.argv[1]
    
    try:
        number = int(sys.argv[2])
        if number <= 0:
            raise ValueError
    except ValueError:
        print("Error: <number> must be a positive integer.")
        sys.exit(1)
    
    hello_world(name, number)

