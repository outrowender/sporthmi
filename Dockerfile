FROM --platform=$BUILDPLATFORM alpine:3.22 AS sdk
COPY ibm-java-ws-sdk-pxi3260sr4ifx.zip /tmp/ibm-sdk.zip
RUN mkdir -p /opt/ibm-java \
    && unzip -q /tmp/ibm-sdk.zip -d /opt/ibm-java

# The bundled IBM SDK is 32-bit x86, including on Apple Silicon hosts.
# Debian slim already provides the required libstdc++ and zlib libraries.
FROM i386/debian:bookworm-slim
COPY --from=sdk /opt/ibm-java /opt/ibm-java
ENV JAVA_HOME=/opt/ibm-java
ENV PATH="${JAVA_HOME}/bin:${PATH}"
WORKDIR /workspace/patched
CMD ["bash", "build.sh"]
