import sys

def hello_name(name, num_repeat):
    for i in range(int(num_repeat)):
        print(f'{i+1}. Hello {name}!')

if __name__ == '__main__':
    if len(sys.argv) != 3:
        print('Error: Incorrect number of arguments\nUsage: python hello_name.py <name> <num_repeat>')
    elif not sys.argv[2].isdigit():
        print('Error: <num_repeat> must be a positive integer')
    else:
        name = sys.argv[1]
        num_repeat = sys.argv[2]
        hello_name(name, num_repeat)