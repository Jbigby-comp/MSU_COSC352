import subprocess
import sys

# Check if the correct number of arguments is provided
if len(sys.argv) != 3:
    print("Usage: python meta_world.py <name> <number>")
    sys.exit(1)

name = sys.argv[1]
number = int(sys.argv[2])

# Define the content of the program to be written
program_content = f"""
print("Hello, {name}!")
"""

#print(program_content * number)

# Execute the code directly using exec
exec(program_content * number)

# Write the content to a new file called program.py
with open("program.py", "w") as f:
    f.write(program_content)

# Execute the written program the specified number of times in parallel
processes = [subprocess.Popen(["python", "program.py"], stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True) for _ in range(number)]

# Collect and display the output
for p in processes:
    stdout, stderr = p.communicate()
    print("META PROCESS->", stdout.strip())


