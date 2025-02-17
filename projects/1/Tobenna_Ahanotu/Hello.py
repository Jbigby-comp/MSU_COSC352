import sys

def main():
    if len(sys.argv) != 3:
        print("Usage: python hello.py <name> <number>")
        sys.exit(1)

    name = sys.argv[1]
    
    try:
        number = int(sys.argv[2])
    except ValueError:
        print("Error: <number> must be an integer.")
        sys.exit(1)

    for _ in range(number):
        print(f"Hello {name}")

if __name__ == "__main__":
    main()
