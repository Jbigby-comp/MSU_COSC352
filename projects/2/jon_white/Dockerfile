FROM ubuntu:latest

# Install dependencies
RUN apt-get update && apt-get install -y \
    curl \
    git \
    build-essential \
    gcc \
    nim \
    && rm -rf /var/lib/apt/lists/*

# Create workspace directory
WORKDIR /workspace

# Copy hello.nim into the container
COPY hello.nim /workspace/hello.nim

# Compile hello.nim
RUN nim c -d:release -o:/workspace/hello /workspace/hello.nim

# Set the container to run the compiled program with arguments
ENTRYPOINT ["/workspace/hello"]