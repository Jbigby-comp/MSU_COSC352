# Project 2: Hello World Program in Assigned Language with Docker

## Objective
Write a "Hello World" program in your assigned programming language. Each person will implement the program using only **native libraries**—no external modules or add-ons are allowed.

The program must:
1. Accept a command-line argument `<name>` and print out `"Hello <name>"`.
2. Accept an additional argument `<number>` to print out `"Hello <name>"` the specified number of times.

This program **must be dockerized**.

---

## Requirements
1. **Program Functionality**:
   - The program should take two command-line arguments:
     - `<name>`: A string input representing the name.
     - `<number>`: An integer input representing how many times the greeting is printed.
   - Output Example:
     ```bash
     $ ./hello Alice 3
     Hello Alice
     Hello Alice
     Hello Alice
     ```

2. **Programming Language**:
   - You must write the program in your **assigned** programming language.
   - Only native libraries of the language may be used—**no external modules or add-ons**.

3. **Dockerization**:
   - Create a `Dockerfile` that builds an image for the program.
   - The image must allow the program to run with `docker run project2 <name> <number>`.
   - The container must be set up to run your specific assigned programming language.

4. **Directory Structure**:
   - Place your project in the following directory:
     ```
     Projects/2/<firstname>_<lastname>/
     ```
   - The directory should contain:
     - The source code file for your program.
     - A `Dockerfile`.

5. **Execution Steps**:
   - Build the Docker image with:
     ```bash
     docker build . -t project2
     ```
   - Run the container with:
     ```bash
     docker run project2 <name> <number>
     ```

---

## Submission Instructions
1. Create the directory structure as specified.
2. Place your `Dockerfile` and source code in the directory.
3. Ensure that your program and Docker configuration meet the requirements.
4. **You must submit your project via Git**—failure to do so will result in a **10-point deduction**.
5. **Failure to use Docker** will result in a **15-point deduction**.

---

