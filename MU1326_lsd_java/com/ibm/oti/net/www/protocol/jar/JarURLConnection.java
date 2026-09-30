/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.jar;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.VM;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TreeSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

public class JarURLConnection
extends java.net.JarURLConnection {
    static Hashtable jarCache = new Hashtable();
    private static final String encoding = "UTF8";
    InputStream jarInput;
    private JarFile jarFile;
    private JarEntry jarEntry;
    ReferenceQueue cacheQueue = new ReferenceQueue();
    static TreeSet lru = new TreeSet(new LRUComparitor());
    static int Limit = (Integer)AccessController.doPrivileged(new PrivilegedAction(){

        public Object run() {
            return Integer.getInteger("jar.cacheSize", 500);
        }
    });

    static {
        VM.closeJars();
    }

    public JarURLConnection(URL uRL) throws MalformedURLException {
        super(uRL);
    }

    public void connect() throws IOException {
        this.jarFileURLConnection = this.getJarFileURL().openConnection();
        this.findJarFile();
        this.findJarEntry();
        this.connected = true;
    }

    public JarFile getJarFile() throws IOException {
        if (!this.connected) {
            this.connect();
        }
        return this.jarFile;
    }

    private void findJarFile() throws IOException {
        URL uRL = this.getJarFileURL();
        if (uRL.getProtocol().equals("file")) {
            String string = uRL.getFile();
            String string2 = uRL.getHost();
            if (string2 != null && string2.length() > 0) {
                string = "//" + string2 + string;
            }
            string = Util.decode(string, false, encoding);
            this.jarFile = this.getUseCaches() ? this.openJarFile(string, string, false) : new JarFile(string);
            return;
        }
        final String string = this.jarFileURLConnection.getURL().toExternalForm();
        if (this.getUseCaches()) {
            this.jarFile = (JarFile)AccessController.doPrivileged(new PrivilegedAction(){

                public Object run() {
                    try {
                        return JarURLConnection.this.openJarFile(null, string, false);
                    }
                    catch (IOException iOException) {
                        return null;
                    }
                }
            });
            if (this.jarFile != null) {
                return;
            }
        }
        final InputStream inputStream = this.jarFileURLConnection.getInputStream();
        try {
            this.jarFile = (JarFile)AccessController.doPrivileged(new PrivilegedAction(){

                public Object run() {
                    try {
                        File file = File.createTempFile("j9jar_", ".tmp", null);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] byArray = new byte[4096];
                        int n = 0;
                        while ((n = inputStream.read(byArray)) > -1) {
                            fileOutputStream.write(byArray, 0, n);
                        }
                        fileOutputStream.close();
                        String string2 = file.getPath();
                        if (JarURLConnection.this.getUseCaches()) {
                            return JarURLConnection.this.openJarFile(string2, string, true);
                        }
                        return JarURLConnection.this.openJarFile(string2, string2, true);
                    }
                    catch (IOException iOException) {
                        return null;
                    }
                }
            });
        }
        finally {
            inputStream.close();
        }
        if (this.jarFile == null) {
            throw new IOException();
        }
    }

    JarFile openJarFile(String string, String string2, boolean bl) throws IOException {
        CacheEntry cacheEntry;
        while ((cacheEntry = (CacheEntry)this.cacheQueue.poll()) != null) {
            jarCache.remove(cacheEntry.key);
        }
        cacheEntry = (CacheEntry)jarCache.get(string2);
        JarFile jarFile = null;
        if (cacheEntry != null) {
            jarFile = (JarFile)cacheEntry.get();
        }
        if (jarFile == null && string != null) {
            int n = 1 + (bl ? 4 : 0);
            jarFile = new JarFile(new File(string), true, n);
            jarCache.put(string2, new CacheEntry(jarFile, string2, this.cacheQueue));
        } else {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(this.getPermission());
            }
            if (bl) {
                lru.remove(new LRUKey(jarFile, 0L));
            }
        }
        if (bl) {
            lru.add(new LRUKey(jarFile, new Date().getTime()));
            if (lru.size() > Limit) {
                lru.remove(lru.first());
            }
        }
        return jarFile;
    }

    public JarEntry getJarEntry() throws IOException {
        if (!this.connected) {
            this.connect();
        }
        return this.jarEntry;
    }

    private void findJarEntry() throws IOException {
        if (this.getEntryName() == null) {
            return;
        }
        this.jarEntry = this.jarFile.getJarEntry(this.getEntryName());
        if (this.jarEntry == null) {
            throw new FileNotFoundException(this.getEntryName());
        }
    }

    public InputStream getInputStream() throws IOException {
        if (!this.connected) {
            this.connect();
        }
        if (this.jarInput != null) {
            return this.jarInput;
        }
        if (this.jarEntry == null) {
            throw new IOException(Msg.getString("K00fc"));
        }
        this.jarInput = this.jarFile.getInputStream(this.jarEntry);
        return this.jarInput;
    }

    public String getContentType() {
        try {
            if (this.url.getFile().endsWith("!/")) {
                return this.getJarFileURL().openConnection().getContentType();
            }
        }
        catch (IOException iOException) {}
        return JarURLConnection.guessContentTypeFromName(this.url.getFile());
    }

    public int getContentLength() {
        try {
            if (this.url.getFile().endsWith("!/")) {
                return this.getJarFileURL().openConnection().getContentLength();
            }
        }
        catch (IOException iOException) {}
        return -1;
    }

    public Object getContent() throws IOException {
        if (!this.connected) {
            this.connect();
        }
        if (this.jarEntry == null) {
            return this.jarFile;
        }
        return super.getContent();
    }

    public Permission getPermission() throws IOException {
        if (this.jarFileURLConnection != null) {
            return this.jarFileURLConnection.getPermission();
        }
        return this.getJarFileURL().openConnection().getPermission();
    }

    public static void closeCachedFiles() {
        Enumeration enumeration = jarCache.elements();
        while (enumeration.hasMoreElements()) {
            try {
                ZipFile zipFile = (ZipFile)((CacheEntry)enumeration.nextElement()).get();
                if (zipFile == null) continue;
                zipFile.close();
            }
            catch (IOException iOException) {}
        }
    }

    static final class LRUKey {
        JarFile jar;
        long ts;

        LRUKey(JarFile jarFile, long l) {
            this.jar = jarFile;
            this.ts = l;
        }

        public boolean equals(Object object) {
            return this.jar == ((LRUKey)object).jar;
        }
    }

    static final class CacheEntry
    extends WeakReference {
        Object key;

        CacheEntry(Object object, String string, ReferenceQueue referenceQueue) {
            super(object, referenceQueue);
            this.key = string;
        }
    }

    static final class LRUComparitor
    implements Comparator {
        LRUComparitor() {
        }

        public int compare(Object object, Object object2) {
            if (((LRUKey)object).ts > ((LRUKey)object2).ts) {
                return 1;
            }
            return ((LRUKey)object).ts == ((LRUKey)object2).ts ? 0 : -1;
        }

        public boolean equals(Object object, Object object2) {
            return object.equals(object2);
        }
    }
}

