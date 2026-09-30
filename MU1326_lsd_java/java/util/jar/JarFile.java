/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarVerifier;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class JarFile
extends ZipFile {
    public static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    static final String META_DIR = "META-INF/";
    private Manifest manifest;
    private ZipEntry manifestEntry;
    JarVerifier verifier;

    public JarFile(File file) throws IOException {
        this(file, true);
    }

    public JarFile(File file, boolean bl) throws IOException {
        super(file);
        if (bl) {
            this.verifier = new JarVerifier(file.getPath());
        }
        this.readMetaEntries();
    }

    public JarFile(File file, boolean bl, int n) throws IOException {
        super(file, n);
        if (bl) {
            this.verifier = new JarVerifier(file.getPath());
        }
        this.readMetaEntries();
    }

    public JarFile(String string) throws IOException {
        this(string, true);
    }

    public JarFile(String string, boolean bl) throws IOException {
        super(string);
        if (bl) {
            this.verifier = new JarVerifier(string);
        }
        this.readMetaEntries();
    }

    public Enumeration entries() {
        class JarFileEnumerator
        implements Enumeration {
            Enumeration ze;
            JarFile jf;
            final /* synthetic */ JarFile this$0;

            JarFileEnumerator(JarFile jarFile, Enumeration enumeration, JarFile jarFile2) {
                this.this$0 = jarFile;
                this.ze = enumeration;
                this.jf = jarFile2;
            }

            public boolean hasMoreElements() {
                return this.ze.hasMoreElements();
            }

            public Object nextElement() {
                JarEntry jarEntry = new JarEntry((ZipEntry)this.ze.nextElement());
                jarEntry.parentJar = this.jf;
                if (this.this$0.verifier != null) {
                    jarEntry.certificates = this.this$0.verifier.getCertificates(jarEntry.getName());
                }
                return jarEntry;
            }
        }
        return new JarFileEnumerator(this, super.entries(), this);
    }

    public JarEntry getJarEntry(String string) {
        return (JarEntry)this.getEntry(string);
    }

    public Manifest getManifest() throws IOException {
        if (this.manifest != null) {
            return this.manifest;
        }
        if (this.manifestEntry != null) {
            InputStream inputStream = super.getInputStream(this.manifestEntry);
            if (this.verifier != null) {
                byte[] byArray = new byte[inputStream.available()];
                inputStream.mark(byArray.length);
                inputStream.read(byArray, 0, byArray.length);
                inputStream.reset();
                this.verifier.addMetaEntry(this.manifestEntry.getName(), byArray);
            }
            try {
                this.manifest = new Manifest(inputStream, this.verifier != null);
            }
            finally {
                inputStream.close();
            }
            this.manifestEntry = null;
        }
        return this.manifest;
    }

    private void readMetaEntries() throws IOException {
        ZipEntry[] zipEntryArray = this.getMetaEntriesImpl(null);
        int n = META_DIR.length();
        boolean bl = false;
        if (zipEntryArray != null) {
            int n2 = 0;
            while (n2 < zipEntryArray.length) {
                ZipEntry zipEntry = zipEntryArray[n2];
                String string = zipEntry.getName();
                if (this.manifestEntry == null && this.manifest == null && string.regionMatches(true, n, MANIFEST_NAME, n, MANIFEST_NAME.length() - n)) {
                    this.manifestEntry = zipEntry;
                    if (this.verifier == null) {
                        break;
                    }
                } else if (this.verifier != null && string.length() > n && (string.regionMatches(true, string.length() - 3, ".SF", 0, 3) || string.regionMatches(true, string.length() - 4, ".DSA", 0, 4) || string.regionMatches(true, string.length() - 4, ".RSA", 0, 4))) {
                    bl = true;
                    InputStream inputStream = super.getInputStream(zipEntry);
                    byte[] byArray = new byte[inputStream.available()];
                    inputStream.read(byArray, 0, byArray.length);
                    inputStream.close();
                    this.verifier.addMetaEntry(string, byArray);
                }
                ++n2;
            }
        }
        if (!bl) {
            this.verifier = null;
        }
    }

    public InputStream getInputStream(ZipEntry zipEntry) throws IOException {
        InputStream inputStream;
        if (this.manifestEntry != null) {
            this.getManifest();
        }
        if (this.verifier != null) {
            this.verifier.setManifest(this.getManifest());
            if (this.verifier.readCertificates()) {
                this.verifier.removeMetaEntries();
                if (this.manifest != null) {
                    this.manifest.removeChunks();
                }
                if (!this.verifier.isSignedJar()) {
                    this.verifier = null;
                }
            }
        }
        if ((inputStream = super.getInputStream(zipEntry)) == null) {
            return null;
        }
        return new JarFileInputStream(inputStream, zipEntry, zipEntry.getSize() >= 0L ? this.verifier : null);
    }

    public ZipEntry getEntry(String string) {
        ZipEntry zipEntry = super.getEntry(string);
        if (zipEntry == null) {
            return zipEntry;
        }
        JarEntry jarEntry = new JarEntry(zipEntry);
        jarEntry.parentJar = this;
        if (this.verifier != null) {
            jarEntry.certificates = this.verifier.getCertificates(jarEntry.getName());
        }
        return jarEntry;
    }

    private native ZipEntry[] getMetaEntriesImpl(byte[] var1);

    static final class JarFileInputStream
    extends FilterInputStream {
        private long count;
        private ZipEntry zipEntry;
        private JarVerifier verifier;
        private JarVerifier.VerifierEntry entry;
        private MessageDigest digest;

        JarFileInputStream(InputStream inputStream, ZipEntry zipEntry, JarVerifier jarVerifier) {
            super(inputStream);
            if (jarVerifier != null) {
                this.zipEntry = zipEntry;
                this.verifier = jarVerifier;
                this.count = this.zipEntry.getSize();
                this.entry = this.verifier.initEntry(zipEntry.getName());
                if (this.entry != null) {
                    this.digest = this.entry.digest;
                }
            }
        }

        public int read() throws IOException {
            int n = super.read();
            if (this.entry != null) {
                if (n != -1) {
                    this.digest.update((byte)n);
                    --this.count;
                }
                if (n == -1 || this.count <= 0L) {
                    JarVerifier.VerifierEntry verifierEntry = this.entry;
                    this.entry = null;
                    this.verifier.verifySignatures(verifierEntry, this.zipEntry);
                }
            }
            return n;
        }

        public int read(byte[] byArray, int n, int n2) throws IOException {
            int n3 = super.read(byArray, n, n2);
            if (this.entry != null) {
                if (n3 != -1) {
                    int n4 = n3;
                    if (this.count < (long)n4) {
                        n4 = (int)this.count;
                    }
                    this.digest.update(byArray, n, n4);
                    this.count -= (long)n3;
                }
                if (n3 == -1 || this.count <= 0L) {
                    JarVerifier.VerifierEntry verifierEntry = this.entry;
                    this.entry = null;
                    this.verifier.verifySignatures(verifierEntry, this.zipEntry);
                }
            }
            return n3;
        }

        public long skip(long l) throws IOException {
            long l2 = 0L;
            long l3 = 0L;
            byte[] byArray = new byte[4096];
            while (l2 < l) {
                l3 = l - l2;
                int n = this.read(byArray, 0, l3 > (long)byArray.length ? byArray.length : (int)l3);
                if (n == -1) {
                    return l2;
                }
                l2 += (long)n;
            }
            return l2;
        }
    }
}

