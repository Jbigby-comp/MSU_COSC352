import sys

def greet(name, times):
    for _ in range(int(times)):
        print(f"Hello, {name}!")

if __name__ == "__main__":
    # Get arguments passed to the script
    name = sys.argv[1]
    times = sys.argv[2]
    greet(name, times)



# import sys

# def main():
#     if len(sys.argv) < 2:
#         print("Usage: python app.py <name> [number]")
#         sys.exit(1)
#     name = sys.argv[1]
#     number = int(sys.argv[2]) if len(sys.argv) > 2 else 1
    
#     for _ in range(number):
#         print(f"Hello {name}")

# if __name__ == "__main__":
#     main()
