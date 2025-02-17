# Use an official lightweight Python image
FROM python:3.9-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Python script into the container
COPY hello_name.py .

# Define the command to run the script with arguments
ENTRYPOINT ["python", "hello_name.py"]
