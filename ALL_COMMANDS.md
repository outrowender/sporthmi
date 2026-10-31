# SportHMI macOS Build - Complete Command Reference

> **All commands needed to build SportHMI on macOS after porting to Docker**

## Table of Contents
1. [Initial Setup](#initial-setup)
2. [Regular Builds](#regular-builds)
3. [Docker Management](#docker-management)
4. [Troubleshooting](#troubleshooting)
5. [Advanced](#advanced)

---

## Initial Setup

### Step 1: Install Docker Desktop (One-time only)

**Download and install:**
```bash
# Visit in browser or use this link
https://www.docker.com/products/docker-desktop
```

Then:
1. Download the correct version (Intel or Apple Silicon)
2. Open the downloaded `.dmg` file
3. Drag Docker to Applications folder
4. Launch Docker from Applications folder
5. Wait for Docker to start (2-3 minutes)

**Verify installation:**
```bash
docker --version
```

### Step 2: Verify Everything is Ready

```bash
cd /Users/tgt/Documents/wender/sporthmi
./setup-docker.sh
```

This command:
- ✓ Checks Docker is installed
- ✓ Checks Docker daemon is running
- ✓ Validates disk space
- ✓ Tests Docker connectivity

---

## Regular Builds

### Standard Build (Most Common)

**One command does everything:**
```bash
cd /Users/tgt/Documents/wender/sporthmi
./build-docker.sh
```

**What happens:**
1. Checks Docker is ready
2. Builds Docker image (if first time)
3. Compiles Java files with Java 1.2
4. Creates SportHMI.jar
5. Copies jar to project root

**Expected output:**
```
[INFO] Building Docker image for SportHMI...
[SUCCESS] Docker image built successfully
[INFO] Running build inside Docker container...
[SUCCESS] Build completed!
[SUCCESS] SportHMI.jar copied to project root
[SUCCESS] All done!
```

### Using Docker Compose (Alternative)

**Build and run:**
```bash
cd /Users/tgt/Documents/wender/sporthmi
docker-compose build
docker-compose run --rm sporthmi-build bash -c 'cd patched && source ../process.sh && bash build.sh'
```

---

## Docker Management

### View Docker Images

**Show all SportHMI images:**
```bash
docker images | grep sporthmi
```

**Show all images on system:**
```bash
docker images
```

### View Containers

**Show running containers:**
```bash
docker ps
```

**Show all containers (including stopped):**
```bash
docker ps -a
```

**Show SportHMI containers:**
```bash
docker ps -a | grep sporthmi
```

### Interactive Development

**Enter container with shell:**
```bash
cd /Users/tgt/Documents/wender/sporthmi
docker run -it -v $(pwd):/workspace sporthmi-builder:latest bash
```

Inside container, compile manually:
```bash
cd patched
source ../process.sh
# Single file compilation for testing
${JAVA_HOME}/bin/javac -source 1.2 -target 1.2 -cp ".:${JAR}" de/audi/atip/model/CarModelBank.java
```

### Check Java Version in Container

```bash
docker run sporthmi-builder:latest /workspace/jdk/bin/javac -version
```

### Run Custom Commands

**Inside container:**
```bash
docker run -v $(pwd):/workspace sporthmi-builder:latest bash -c 'cd /workspace/patched && source ../process.sh && bash build.sh'
```

### Stop All SportHMI Containers

```bash
docker ps -a | grep sporthmi | awk '{print $1}' | xargs docker stop
```

### Remove Specific Container

```bash
docker rm sporthmi-builder
```

### Remove Container by ID

```bash
docker ps -a                    # Get container ID
docker rm <CONTAINER_ID>        # Replace with actual ID
```

---

## Cleaning & Maintenance

### Clean Build (Remove Old Artifacts)

**Remove compiled classes:**
```bash
cd /Users/tgt/Documents/wender/sporthmi/patched
rm -f SportHMI.jar
find . -name "*.class" -delete
```

### Clean Rebuild (Completely Fresh)

```bash
# Remove Docker image
docker rmi sporthmi-builder:latest

# Run build again (will recreate image)
cd /Users/tgt/Documents/wender/sporthmi
./build-docker.sh
```

### Free Up Disk Space

**Remove all Docker artifacts:**
```bash
docker system prune -a
```

**Warning**: This removes all Docker images and containers (reclaims ~5GB typically)

### Remove Only Stopped Containers

```bash
docker container prune
```

### Remove Unused Images

```bash
docker image prune
```

### Remove SportHMI Image Only

```bash
docker rmi sporthmi-builder:latest
```

---

## Troubleshooting

### Docker Not Found

**Error:**
```
docker: command not found
```

**Fix:**
```bash
# Install Docker Desktop
# https://www.docker.com/products/docker-desktop
```

### Docker Daemon Not Running

**Error:**
```
Cannot connect to Docker daemon at unix:///var/run/docker.sock
```

**Fix:**
```bash
# Launch Docker from Applications
# OR
open /Applications/Docker.app

# Wait for Docker icon in menu bar
# Then try again
```

### Permission Denied on Script

**Error:**
```
Permission denied: ./build-docker.sh
```

**Fix:**
```bash
chmod +x /Users/tgt/Documents/wender/sporthmi/build-docker.sh
chmod +x /Users/tgt/Documents/wender/sporthmi/setup-docker.sh

# Then try building again
./build-docker.sh
```

### Out of Disk Space

**Error:**
```
No space left on device
```

**Fix:**
```bash
# Free Docker space
docker system prune -a

# Check disk usage
df -h

# If still low, delete old build artifacts
cd /Users/tgt/Documents/wender/sporthmi/patched
rm -f SportHMI.jar
find . -name "*.class" -delete
```

### Build Fails: Missing Java SDK

**Error:**
```
unzip: cannot find ../ibm-java-ws-sdk-pxi3260sr4ifx.zip
```

**Fix:**
```bash
# Verify file exists in project root
cd /Users/tgt/Documents/wender/sporthmi
ls -lh ibm-java-ws-sdk-pxi3260sr4ifx.zip

# If missing, get it from team or copy from another machine
```

### Image Build Fails

**Error:**
```
ERROR: failed to build Docker image
```

**Fix with verbose output:**
```bash
cd /Users/tgt/Documents/wender/sporthmi
docker build -t sporthmi-builder:latest -f Dockerfile . --progress=plain
```

Then look for the specific error message.

### Compilation Error in Java Files

**Error:**
```
error: cannot find symbol
```

**Debug:**
```bash
# Get container ID
docker ps -a | grep sporthmi

# Access container interactively
docker exec -it <CONTAINER_ID> bash

# Check the JAR was extracted
ls /workspace/MU1326_lsd_java | head

# Check Java version
${JAVA_HOME}/bin/javac -version
```

---

## Advanced

### Rebuild Docker Image with Progress

```bash
docker build --progress=plain --no-cache -t sporthmi-builder:latest -f Dockerfile .
```

### View Image Layers

```bash
docker history sporthmi-builder:latest
```

### Inspect Running Container

```bash
docker inspect <CONTAINER_ID>
```

### View Container Logs

```bash
docker logs <CONTAINER_ID>
```

### Container Resource Usage

```bash
docker stats sporthmi-builder
```

### Mount Different Directory

```bash
docker run -v /custom/path:/workspace -it sporthmi-builder:latest bash
```

### Build with Custom Java Options

Edit inside the container:
```bash
docker run -it -v $(pwd):/workspace sporthmi-builder:latest bash
cd patched
source ../process.sh
${JAVA_HOME}/bin/javac -source 1.2 -target 1.2 -deprecation -cp ".:${JAR}" de/audi/atip/model/CarModelBank.java
```

### Run Multiple Build Steps

```bash
docker run -v $(pwd):/workspace sporthmi-builder:latest bash <<EOF
cd /workspace/patched
source ../process.sh
echo "Converting JXE to JAR..."
echo "Decompiling JAR..."
echo "Compiling Java files..."
bash build.sh
echo "Done!"
EOF
```

### Commit Changes to New Image

```bash
docker commit <CONTAINER_ID> sporthmi-builder:modified
```

### Export Image for Sharing

```bash
docker save sporthmi-builder:latest > sporthmi-builder.tar
```

### Import Shared Image

```bash
docker load < sporthmi-builder.tar
```

---

## Quick Reference Table

| Task | Command |
|------|---------|
| Build SportHMI | `./build-docker.sh` |
| Verify setup | `./setup-docker.sh` |
| Enter container | `docker run -it -v $(pwd):/workspace sporthmi-builder:latest bash` |
| View images | `docker images` |
| View containers | `docker ps -a` |
| Clean rebuild | `docker rmi sporthmi-builder:latest && ./build-docker.sh` |
| Remove all Docker data | `docker system prune -a` |
| View build output | `docker logs <CONTAINER_ID>` |
| Check Java version | `docker run sporthmi-builder:latest /workspace/jdk/bin/javac -version` |

---

## Environment Variables

When building inside container, these are automatically set:

```bash
JAVA_HOME=/workspace/jdk
PATH=/workspace/jdk/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
JAVA=/workspace/MU1326_lsd_java
JAR=/workspace/MU1326_lsd.jar
```

---

## File Locations

| File | Path |
|------|------|
| Build script | `/Users/tgt/Documents/wender/sporthmi/build-docker.sh` |
| Setup script | `/Users/tgt/Documents/wender/sporthmi/setup-docker.sh` |
| Dockerfile | `/Users/tgt/Documents/wender/sporthmi/Dockerfile` |
| Docker Compose | `/Users/tgt/Documents/wender/sporthmi/docker-compose.yml` |
| Output JAR | `/Users/tgt/Documents/wender/sporthmi/patched/SportHMI.jar` |
| Output copy | `/Users/tgt/Documents/wender/sporthmi/SportHMI.jar` |
| Source files | `/Users/tgt/Documents/wender/sporthmi/patched/de/` |
| Java SDK | `/Users/tgt/Documents/wender/sporthmi/jdk/` (created in container) |

---

## Performance Benchmarks

**First run (with Docker image creation):**
```
~3-5 minutes total
- Docker image download/build: 2-3 min
- Java compilation: 1-2 min
```

**Subsequent runs (image cached):**
```
~1-2 minutes total
- All compilation and jar creation
```

**Clean rebuild (remove and recreate image):**
```
~3-5 minutes total
- Same as first run
```

---

**Last Updated**: October 31, 2026
**For Help**: See `BUILD_MACOS_DOCKER.md` for detailed documentation
