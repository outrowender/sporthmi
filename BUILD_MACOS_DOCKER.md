# Building SportHMI on macOS with Docker

This is the maintained build guide. It supersedes the earlier generated quick
references and implementation summaries, whose compatibility and timing claims
were not verified.

## Requirements

- Docker Desktop installed and running.
- The real `ibm-java-ws-sdk-pxi3260sr4ifx.zip`, not a Git LFS pointer.
- `MU1326_lsd.jar` copied from the working Ubuntu build machine to the repository
  root. This is the original firmware class library, not the output patch JAR.
- The existing `MU1326_lsd_java/` directory, which prevents the legacy setup
  script from running the decompiler.

Only the patched classes are compiled and packaged. They still depend on classes
from the original firmware JAR. Decompiled Java sources are not a replacement:
some contain invalid Java constructs and cannot be compiled unchanged.

The bundled SDK is IBM Java 6 for **32-bit x86 Linux**. The build targets Java 1.2
using `-source 1.2 -target 1.2`; it is not a Java 1.2 SDK. Docker must use
`linux/386`, including on Apple Silicon. The SDK lives at `/opt/ibm-java` inside
the image so mounting the repository does not hide it.

## First-time setup

From the repository root:

```bash
# If Homebrew is installed and git-lfs is missing:
brew install git-lfs
git lfs pull

# Copy the matching original JAR here from the Ubuntu build machine:
# MU1326_lsd.jar

unzip -tq ibm-java-ws-sdk-pxi3260sr4ifx.zip
ls -lh MU1326_lsd.jar
```

If Git LFS returns 404, run this on the Ubuntu machine that has the real files,
then retry `git lfs pull` on the Mac:

```bash
git lfs push --all origin
```

The firmware JAR is ignored by Git. Transfer it separately, or deliberately
configure Git LFS for it if you intend to version it.

## Build and rebuild

```bash
cd /path/to/sporthmi
./build-docker.sh
```

The wrapper finds Docker Desktop in either `/Applications` or
`~/Applications` if its CLI is not on PATH. It checks the inputs, builds the
image using Docker's cache, and runs the existing `patched/build.sh`.

Outputs after a successful build:

- `patched/SportHMI.jar`
- `SportHMI.jar` (a convenience copy)

Sources and generated classes remain on the host through the repository bind
mount. No deployment to the vehicle is performed.

## Manual commands

If Docker is not on PATH, select its installation:

```bash
if [ -d "$HOME/Applications/Docker.app" ]; then
    export PATH="$HOME/Applications/Docker.app/Contents/Resources/bin:$PATH"
else
    export PATH="/Applications/Docker.app/Contents/Resources/bin:$PATH"
fi

docker info
docker build --platform linux/386 -t sporthmi-builder:latest .
docker run --rm --platform linux/386 \
    -v "$PWD:/workspace" \
    sporthmi-builder:latest
```

The manual command writes only `patched/SportHMI.jar`; the wrapper also copies it
to the root.

Check the compiler or open a debugging shell:

```bash
docker run --rm --platform linux/386 sporthmi-builder:latest java -version
docker run --rm --platform linux/386 sporthmi-builder:latest javac -version
docker run --rm -it --platform linux/386 \
    -v "$PWD:/workspace" \
    sporthmi-builder:latest bash
```

Compose alternative:

```bash
docker compose build
docker compose run --rm sporthmi-build
```

## Troubleshooting

- **Docker daemon unavailable:** open Docker Desktop and wait for `docker info`
  to succeed.
- **Invalid SDK ZIP:** run `git lfs pull`. A small text pointer is not the SDK.
- **Missing `MU1326_lsd.jar`:** copy the matching original library from Ubuntu.
  Do not substitute `SportHMI.jar` or an unrelated firmware version.
- **Exec format error:** ensure both image build and container run use
  `--platform linux/386`.
- **Image build network failure:** retry with
  `docker build --platform linux/386 --progress=plain -t sporthmi-builder:latest .`
  and inspect the failing step. Images are pulled from Docker Hub; no additional
  package downloads are needed.

To remove only this project's image, after its containers have exited:

```bash
docker image rm sporthmi-builder:latest
```

Do not delete `patched/de/`: it contains the modified source files.
Build duration depends on network access and CPU emulation; no timing guarantee
is made.
