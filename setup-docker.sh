#!/bin/bash
# Docker Setup Helper for macOS
# This script helps install and verify Docker Desktop is ready for SportHMI builds

set -e

# Colors for output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
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

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

echo -e "${BLUE}========================================${NC}"
echo -e "${BLUE}  Docker Setup Helper for SportHMI${NC}"
echo -e "${BLUE}========================================${NC}"
echo ""

# Check if Docker is installed
if command -v docker &> /dev/null; then
    print_success "Docker is installed"
    docker --version
else
    print_error "Docker is not installed"
    echo ""
    echo "To install Docker Desktop for macOS:"
    echo "1. Visit: https://www.docker.com/products/docker-desktop"
    echo "2. Download the macOS version (Intel or Apple Silicon)"
    echo "3. Install the .dmg file"
    echo "4. Launch Docker Desktop from Applications folder"
    echo "5. Run this script again"
    exit 1
fi

echo ""

# Check if Docker daemon is running
if docker info &> /dev/null; then
    print_success "Docker daemon is running"
else
    print_warning "Docker daemon is not running"
    echo ""
    echo "To start Docker:"
    echo "1. Open Applications folder"
    echo "2. Find 'Docker.app'"
    echo "3. Double-click to launch"
    echo "4. Wait for Docker to start (check menu bar for Docker icon)"
    echo "5. Run this script again"
    exit 1
fi

echo ""

# Check available disk space
DISK_AVAILABLE=$(df /var/tmp | awk 'NR==2 {print $4}')
DISK_NEEDED_MB=5000

print_status "Checking disk space..."
if [ "$DISK_AVAILABLE" -gt $((DISK_NEEDED_MB * 1024)) ]; then
    print_success "Sufficient disk space available"
else
    print_warning "Low disk space (need ~5GB for Docker images)"
fi

echo ""

# Test Docker with a simple command
print_status "Testing Docker with hello-world image..."
if docker run --rm hello-world &> /dev/null; then
    print_success "Docker is working correctly"
else
    print_error "Docker test failed"
    exit 1
fi

echo ""
echo -e "${GREEN}========================================${NC}"
print_success "All checks passed!"
echo -e "${GREEN}========================================${NC}"
echo ""
echo "You're ready to build SportHMI!"
echo ""
echo "To build, run:"
echo "  cd /Users/tgt/Documents/wender/sporthmi"
echo "  ./build-docker.sh"
echo ""
