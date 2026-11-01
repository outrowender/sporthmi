#!/bin/bash
# macOS Docker build wrapper for SportHMI
# This script handles Docker setup and executes the build inside a container

set -e

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
IMAGE_NAME="sporthmi-builder:latest"

# Docker Desktop can be installed per-user without adding its CLI to PATH.
if ! command -v docker > /dev/null 2>&1; then
    for docker_bin in \
        "$HOME/Applications/Docker.app/Contents/Resources/bin" \
        "/Applications/Docker.app/Contents/Resources/bin"; do
        if [ -x "$docker_bin/docker" ]; then
            export PATH="$docker_bin:$PATH"
            break
        fi
    done
fi

# Colors for output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

print_status() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

print_success() {
    echo -e "${GREEN}[SUCCESS]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

# Check if Docker is installed
if ! command -v docker &> /dev/null; then
    print_warning "Docker is not installed. Please install Docker Desktop for macOS"
    echo "Visit: https://www.docker.com/products/docker-desktop"
    exit 1
fi

# Check if Docker daemon is running
if ! docker info &> /dev/null; then
    print_warning "Docker daemon is not running. Please start Docker Desktop"
    exit 1
fi

print_status "Building Docker image for SportHMI..."
cd "$SCRIPT_DIR"

if ! unzip -tq ibm-java-ws-sdk-pxi3260sr4ifx.zip; then
    print_warning "The IBM SDK ZIP is missing or invalid. Run git lfs pull first."
    exit 1
fi

if [ ! -s MU1326_lsd.jar ]; then
    print_warning "Missing MU1326_lsd.jar. Copy the original firmware JAR from the Linux build machine."
    exit 1
fi

# Build the Docker image
docker build --platform linux/386 -t "$IMAGE_NAME" -f Dockerfile .

print_success "Docker image built successfully"

print_status "Running build inside Docker container..."
print_status "Build directory: $SCRIPT_DIR"

# Run the build inside the container
docker run \
    --rm \
    --platform linux/386 \
    -v "$SCRIPT_DIR:/workspace" \
    -w /workspace/patched \
    "$IMAGE_NAME" \
    bash build.sh

print_success "Build completed!"
print_status "Output file: $SCRIPT_DIR/patched/SportHMI.jar"

# Copy the jar file to the root for easy access
if [ ! -s "$SCRIPT_DIR/patched/SportHMI.jar" ]; then
    print_warning "Build did not produce a nonempty SportHMI.jar."
    exit 1
fi
cp "$SCRIPT_DIR/patched/SportHMI.jar" "$SCRIPT_DIR/SportHMI.jar"
print_success "SportHMI.jar copied to project root"

print_success "All done!"
