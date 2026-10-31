# SportHMI macOS Build - Quick Reference

## One-Line Build Command

```bash
cd /Users/tgt/Documents/wender/sporthmi && ./build-docker.sh
```

## Prerequisites Checklist

- [ ] Docker Desktop installed on macOS
- [ ] Docker Desktop is running
- [ ] `ibm-java-ws-sdk-pxi3260sr4ifx.zip` is in project root
- [ ] `cfr-0.152.jar` is in project root
- [ ] All source files are in `patched/de/` directories

## Installation Steps (First Time Only)

### Step 1: Install Docker Desktop
1. Visit https://www.docker.com/products/docker-desktop
2. Download for macOS (choose Intel or Apple Silicon version)
3. Run the installer
4. Move Docker.app to Applications folder
5. Launch Docker from Applications

### Step 2: Verify Docker Setup
```bash
./setup-docker.sh
```

This script checks:
- Docker is installed
- Docker daemon is running
- Enough disk space (5GB recommended)
- Docker connectivity

### Step 3: Build SportHMI
```bash
./build-docker.sh
```

## Build Output Location

The build produces:
- **Working directory**: `/Users/tgt/Documents/wender/sporthmi/patched/SportHMI.jar`
- **Copied to root**: `/Users/tgt/Documents/wender/sporthmi/SportHMI.jar`

## Files Reference

| File | Purpose |
|------|---------|
| `build-docker.sh` | Main build script for macOS |
| `setup-docker.sh` | Docker installation verification |
| `Dockerfile` | Docker image configuration |
| `docker-compose.yml` | Docker Compose setup |
| `BUILD_MACOS_DOCKER.md` | Full documentation |
| `patched/build.sh` | Original Linux build script |
| `process.sh` | Build environment setup |

## Troubleshooting Quick Fixes

| Problem | Solution |
|---------|----------|
| "Docker is not installed" | Install Docker Desktop from https://www.docker.com/products/docker-desktop |
| "Cannot connect to Docker daemon" | Launch Docker Desktop application |
| "Permission denied" | Run `chmod +x build-docker.sh` then try again |
| "Missing ibm-java-ws-sdk file" | Ensure zip file is in project root |
| "Out of disk space" | Run `docker system prune -a` to free space |

## Restarting or Rebuilding

### Clean rebuild (removes Docker image)
```bash
docker rmi sporthmi-builder:latest
./build-docker.sh
```

### Clean compilation only (keeps Docker image)
```bash
cd patched
rm -f SportHMI.jar
rm -rf de
# Copy fresh source files
source ../process.sh  # This regenerates from JAR
cd ..
./build-docker.sh
```

## Common Commands

```bash
# View build status
docker ps

# View all SportHMI containers
docker ps -a | grep sporthmi

# Enter container interactively
docker run -it -v $(pwd):/workspace sporthmi-builder:latest bash

# Check Java version in container
docker run sporthmi-builder:latest /workspace/jdk/bin/javac -version

# Remove old containers
docker container prune

# Check Docker images
docker images | grep sporthmi
```

## Performance Notes

- **First build**: 3-5 minutes (includes Docker image creation)
- **Subsequent builds**: 1-2 minutes (Docker image is cached)
- **Rebuild with clean**: Similar to first build time

## Support Resources

- Full documentation: [BUILD_MACOS_DOCKER.md](BUILD_MACOS_DOCKER.md)
- Docker documentation: https://docs.docker.com/
- Docker Desktop for Mac: https://docs.docker.com/desktop/install/mac-install/

## Environment Notes

- **Platform**: macOS (Intel/Apple Silicon compatible)
- **Container OS**: Ubuntu 20.04
- **Java Version**: IBM Java 1.2 SDK
- **Compiler Flags**: `-source 1.2 -target 1.2`
- **Default Shell**: bash

---

**Last Updated**: October 2026
**For questions**: Contact your development team lead
