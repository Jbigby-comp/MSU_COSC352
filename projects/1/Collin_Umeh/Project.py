import sys

# Ensure the correct number of arguments are passed
if len(sys.argv) != 3:
    print("Usage: python Project.py <name> <number>")
    sys.exit(1)

name = sys.argv[1]
number = int(sys.argv[2])

for _ in range(number):
    print(f"Hello {name}")
