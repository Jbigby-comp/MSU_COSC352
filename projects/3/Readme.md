# Project 3: HTML Table Extractor in Assigned Language with Docker

## Objective
Write a program in your **assigned programming language** that downloads an HTML file from the page: [List of largest companies in the United States by revenue](https://en.wikipedia.org/wiki/List_of_largest_companies_in_the_United_States_by_revenue), extracts all tables, and writes each table to a separate CSV file in your project directory. The program must:

1. Download the HTML file from the provided URL.
2. Parse the HTML to extract all tables.
3. Write each table to a separate CSV file in the project directory, naming them sequentially (e.g., `table_1.csv`, `table_2.csv`).
4. Be implemented using only **native libraries**—no external modules or add-ons.
5. Be fully dockerized.

---

## Requirements

### 1. **Program Functionality**
   - The program must:
     - Download the HTML file from the provided Wikipedia page.
     - Identify and extract all tables.
     - Write each table to a separate CSV file in the project directory.
   - Example execution:
     ```bash
     $ ./extract_tables
     ```
     - If the downloaded HTML contains two tables, two CSV files should be created:
       ```
       table_1.csv
       table_2.csv
       ```

### 2. **Programming Language**
   - You must use your **assigned** programming language.
   - Only native libraries of the language may be used—**no external modules or add-ons**.

### 3. **Dockerization**
   - Create a `Dockerfile` that builds an image for the program.
   - The image must allow the program to run with `docker run project3`.
   - The container must be set up to run your specific assigned programming language.

### 4. **Git Usage**
   - You must use Git for version control.
   - Commit changes regularly and push to your assigned repository.

### 5. **Directory Structure**
   - Organize your project as follows:
     ```
     Projects/3/<firstname>_<lastname>/
     ├── Dockerfile
     ├── extract_tables.<ext>
     ├── README.md
     ```

### 6. **Execution Steps**
   - Build the Docker image:
     ```bash
     docker build . -t project3
     ```
   - Run the container:
     ```bash
     docker run -v $(pwd):/app project3
     ```

---

## Submission Instructions
1. Ensure your project follows the directory structure.
2. Your `Dockerfile` and source code should be included.
3. Commit and push your code to the assigned Git repository.
4. **Failure to use Git** will result in a **10-point deduction**.
5. **Failure to use Docker** will result in a **15-point deduction**.
6. Submissions that do not function correctly or do not adhere to the native-library restriction will be **penalized accordingly**.

---

