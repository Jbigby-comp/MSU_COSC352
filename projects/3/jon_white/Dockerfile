FROM python:3.9-slim

# Set the working directory
WORKDIR /app

# Copy the script into the container
COPY read_tables.py /app/extract_html_tables.py
COPY list_of_largest_companies_wiki.html /app/list_of_largest_companies_wiki.html

# Install required Python packages
RUN pip install pandas lxml

# Define the entrypoint
ENTRYPOINT ["python", "/app/extract_html_tables.py", "list_of_largest_companies_wiki.html"]
