# Dockerfile for building SportHMI with Java 1.2
# This image provides the IBM Java 1.2 SDK environment needed for legacy Java compilation
FROM ubuntu:20.04

# Set non-interactive mode to avoid prompts during apt-get
ENV DEBIAN_FRONTEND=noninteractive

# Install required system packages
RUN apt-get update && apt-get install -y \
    python3 \
    python3-pip \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /workspace

# Copy project files
COPY . /workspace

# Install Python dependencies
RUN python3 -m pip install bitstring --quiet

# Prepare the Java environment and extract IBM Java SDK
RUN cd /workspace && \
    mkdir -p /workspace/jdk && \
    cd /workspace/jdk && \
    unzip -q ../ibm-java-ws-sdk-pxi3260sr4ifx.zip

# Set environment variables
ENV JAVA_HOME=/workspace/jdk
ENV PATH=$JAVA_HOME/bin:$PATH

# Default command - this will be overridden when running the build
CMD ["/bin/bash"]
