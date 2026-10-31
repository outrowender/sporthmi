# SportHMI Build Guide for macOS using Docker

## Overview

This guide explains how to build SportHMI on macOS using Docker. The build requires IBM Java 1.2 SDK, which only runs on Linux. Docker allows us to run a Linux environment on macOS to compile the Java code.

## Prerequisites

### 1. Docker Desktop for macOS
You need Docker Desktop installed on your Mac to run the build environment.

**Installation:**
- Visit: https://www.docker.com/products/docker-desktop
- Download and install the macOS version
- Launch Docker Desktop after installation

**Verification:**
```bash
docker --version
docker run hello-world
```

### 2. Required Files
Ensure these files are present in your project root:
- `ibm-java-ws-sdk-pxi3260sr4ifx.zip` - IBM Java 1.2 SDK
- `cfr-0.152.jar` - Java decompiler
- `jxe2jar/` - JXE to JAR converter
- `patched/` - Directory with source code to build
- `process.sh` - Setup script
- `Dockerfile` - Docker image configuration
- `docker-compose.yml` - Docker Compose configuration
- `build-docker.sh` - macOS wrapper script

## Quick Start

### Option 1: Using the Automated Build Script (Recommended)

This is the simplest way to build on macOS. The script handles all Docker setup automatically.

```bash
cd /Users/tgt/Documents/wender/sporthmi
./build-docker.sh
```

**What this does:**
1. Checks if Docker is installed and running
2. Builds the Docker image with IBM Java 1.2 environment
3. Runs the build inside the container
4. Copies the resulting JAR file to the project root

**Expected output:**
```
[INFO] Building Docker image for SportHMI...
[SUCCESS] Docker image built successfully
[INFO] Running build inside Docker container...
[SUCCESS] Build completed!
[SUCCESS] SportHMI.jar copied to project root
[SUCCESS] All done!
```

### Option 2: Using Docker Compose

If you prefer more control or want to run commands manually inside the container:

```bash
# Build the image
docker-compose build

# Run the build
docker-compose run --rm sporthmi-build bash -c 'cd patched && source ../process.sh && bash build.sh'
```

### Option 3: Manual Docker Commands

For debugging or custom workflows:

```bash
# Build the image
docker build -t sporthmi-builder:latest -f Dockerfile .

# Run the container with interactive shell
docker run -it -v $(pwd):/workspace sporthmi-builder:latest

# Inside the container, run:
# cd patched
# source ../process.sh
# bash build.sh
```

## Build Process Explained

### What the Build Script Does

1. **Extracts IBM Java SDK**: Unzips the Java 1.2 compiler
2. **Converts JXE to JAR**: Runs the JXE to JAR converter (if needed)
3. **Decompiles JAR**: Extracts the compiled code using CFR decompiler
4. **Compiles Java Files**: Compiles the patched Java source files with Java 1.2
   - `de/audi/atip/model/CarModelBank.java`
   - `de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController.java`
   - `de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/OilTemperatureGaugeRendererHigh.java`
   - `de/audi/tghu/car/hmi/evohighscale/CarScreenFactory.java`
   - `de/audi/tghu/car/hmi/evohighscale/CarScreenBag1.java`
   - `de/audi/tghu/car/sm/CarSMMInitStates.java`
   - `de/audi/tghu/car/sm/CarSMMInitTransitions.java`
   - `de/audi/app/car/evo/sport/SportComponentEvo.java`
   - `de/audi/app/car/evo/sport/SportKombiComponentEvo.java`
5. **Creates JAR Archive**: Packages compiled classes into `SportHMI.jar`

### Output Files

After a successful build:
- **Primary output**: `/Users/tgt/Documents/wender/sporthmi/patched/SportHMI.jar`
- **Convenience copy**: `/Users/tgt/Documents/wender/sporthmi/SportHMI.jar`

## Troubleshooting

### Docker Not Running
**Error**: `Cannot connect to Docker daemon`

**Solution**:
1. Open Docker Desktop application
2. Wait for Docker to start (usually takes 10-30 seconds)
3. Try the build again

### Permission Denied on build-docker.sh
**Error**: `Permission denied: ./build-docker.sh`

**Solution**:
```bash
chmod +x build-docker.sh
./build-docker.sh
```

### Missing ibm-java-ws-sdk-pxi3260sr4ifx.zip
**Error**: `Building Docker image...` hangs or fails

**Solution**:
1. Ensure the IBM Java SDK zip file is in the project root
2. The file is required for Docker to build the image
3. If you don't have it, ask your team lead for a copy

### Docker Image Build Fails
**Error**: Build fails during `docker build`

**Solution**:
1. Check internet connection (Python packages need to download)
2. Verify all required files are present
3. Run with verbose output for debugging:
   ```bash
   docker build -t sporthmi-builder:latest -f Dockerfile . --progress=plain
   ```

### Out of Disk Space
**Error**: Docker fails with disk space warnings

**Solution**:
```bash
# Remove unused Docker images and containers
docker system prune -a

# This frees up space but removes all Docker data
```

## Advanced Usage

### Running Commands Inside the Container Interactively

```bash
docker run -it -v $(pwd):/workspace sporthmi-builder:latest bash
```

Then inside the container:
```bash
cd patched
source ../process.sh
bash build.sh
```

### Debugging Build Issues

If the build fails, you can inspect the compilation steps:

```bash
docker run -it -v $(pwd):/workspace sporthmi-builder:latest bash
cd patched
source ../process.sh
# Now run javac manually to see detailed errors
${JAVA_HOME}/bin/javac -source 1.2 -target 1.2 -cp ".:${JAR}" de/audi/atip/model/CarModelBank.java
```

### Checking Java Compiler Version in Container

```bash
docker run -it -v $(pwd):/workspace sporthmi-builder:latest bash
${JAVA_HOME}/bin/javac -version
```

## Cleaning Up

### Remove Build Artifacts
```bash
cd /Users/tgt/Documents/wender/sporthmi/patched
rm -f SportHMI.jar *.class
find . -name "*.class" -delete
```

### Remove Docker Image (when no longer needed)
```bash
docker rmi sporthmi-builder:latest
```

### Stop and Remove All Related Containers
```bash
docker ps -a | grep sporthmi | awk '{print $1}' | xargs docker rm -f
```

## File Reference

### Docker Configuration Files
- **Dockerfile**: Defines the Linux environment with IBM Java 1.2
- **docker-compose.yml**: Docker Compose configuration for consistency
- **build-docker.sh**: macOS wrapper script with status messages

### Build Scripts
- **process.sh**: Environment setup and prerequisites
- **patched/build.sh**: Main compilation script

### Output
- **patched/SportHMI.jar**: Compiled JAR archive (main output)
- **SportHMI.jar**: Copy of above in project root for convenience

## Notes

- The Docker image is built once and cached. Subsequent builds are much faster.
- All work happens in Docker containers; your macOS system is not modified.
- The entire project directory is mounted as a volume in the container, so changes are reflected immediately.
- Java version used: **IBM Java 1.2** (requires `-source 1.2 -target 1.2` flags)

## Additional Resources

- Docker Documentation: https://docs.docker.com/
- Java 1.2 Compiler Options: https://docs.oracle.com/javase/1.2/docs/tooldocs/solaris/javac.html
- Docker Desktop for Mac: https://docs.docker.com/desktop/install/mac-install/

## Support

If you encounter issues:
1. Check this troubleshooting section first
2. Verify Docker Desktop is running and healthy
3. Ensure all required files are present
4. Try running the build again (sometimes transient network issues)
5. Contact your development team with the error output
