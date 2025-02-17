# Use an official Python runtime as a parent image
FROM python:3.9

# Set the working directory in the container
WORKDIR /app

# Copy the hello_name.py script into the container
COPY hello_name.py .

# Run hello_name.py using python when the container launches
ENTRYPOINT ["python3", "hello_name.py"]