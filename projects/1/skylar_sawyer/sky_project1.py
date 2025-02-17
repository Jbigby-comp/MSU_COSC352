import sys

def main():
    if len(sys.argv) < 2:
        print("Usage: python script.py <name> [number]")
        return

    name = sys.argv[1]
    times = int(sys.argv[2]) if len(sys.argv) > 2 and sys.argv[2].isdigit() else 1

    for _ in range(times):
        print(f"Hello {name}")

if __name__ == "__main__":
    main()
