#!/bin/bash

# Check if both arguments are provided
if [ -z "$1" ] || [ -z "$2" ]; then
    echo "Usage: $0 <name> <number>"
    exit 1
fi

# Check if the second argument is a valid positive number
if ! [[ "$2" =~ ^[0-9]+$ ]]; then
    echo "Error: The second argument must be a positive integer."
    exit 1
fi

# Loop to print the greeting the specified number of times
for ((i=1; i<=$2; i++)); do
    echo "$i) Hello, $1!"
done
