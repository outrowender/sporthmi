/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.util.PriviAction;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.AccessController;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.InitManifest;

public class Manifest
implements Cloneable {
    private Attributes mainAttributes = new Attributes();
    private HashMap entryAttributes = new HashMap();
    private HashMap chunks;

    public Manifest() {
    }

    public Manifest(InputStream inputStream) throws IOException {
        this.read(inputStream);
    }

    Manifest(InputStream inputStream, boolean bl) throws IOException {
        if (bl) {
            this.chunks = new HashMap();
        }
        this.read(inputStream);
    }

    public void clear() {
        this.entryAttributes.clear();
        this.mainAttributes.clear();
    }

    public Attributes getAttributes(String string) {
        return (Attributes)this.getEntries().get(string);
    }

    public Map getEntries() {
        return this.entryAttributes;
    }

    public Attributes getMainAttributes() {
        return this.mainAttributes;
    }

    public Manifest(Manifest manifest) {
        this.mainAttributes = (Attributes)manifest.mainAttributes.clone();
        this.entryAttributes = (HashMap)manifest.entryAttributes.clone();
    }

    public Object clone() {
        return new Manifest(this);
    }

    public void write(OutputStream outputStream) throws IOException {
        new WriteManifest().write(this, outputStream);
    }

    public void read(InputStream inputStream) throws IOException {
        new InitManifest(inputStream, this.mainAttributes, this.entryAttributes, this.chunks, null);
    }

    public int hashCode() {
        return this.mainAttributes.hashCode() ^ this.entryAttributes.hashCode();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        if (!this.mainAttributes.equals(((Manifest)object).mainAttributes)) {
            return false;
        }
        return this.entryAttributes.equals(((Manifest)object).entryAttributes);
    }

    byte[] getChunk(String string) {
        return (byte[])this.chunks.get(string);
    }

    void removeChunks() {
        this.chunks = null;
    }

    static class WriteManifest {
        private static final int LIMIT = 70;
        private static byte[] sepBuf = new byte[]{13, 10};
        private static Attributes.Name nameAttribute = new Attributes.Name("Name", false);
        byte[] oneByte = new byte[1];
        char[] oneChar = new char[1];
        private CharacterConverter converter;
        private byte[] outBuf = new byte[70];
        OutputStream os;

        WriteManifest() {
        }

        private void writeEntry(Attributes.Name name, String string) throws IOException {
            int n;
            int n2 = 0;
            int n3 = 70;
            byte[] byArray = (String.valueOf(name.toString()) + ": ").getBytes("ISO8859_1");
            if (byArray.length > n3) {
                while (byArray.length - n2 >= n3) {
                    n = byArray.length - n2;
                    if (n > n3) {
                        n = n3;
                    }
                    if (n2 > 0) {
                        this.os.write(32);
                    }
                    this.os.write(byArray, n2, n);
                    this.os.write(sepBuf);
                    n2 += n;
                    n3 = 69;
                }
            }
            n = byArray.length - n2;
            System.arraycopy((Object)byArray, n2, (Object)this.outBuf, 0, n);
            int n4 = 0;
            while (n4 < string.length()) {
                byte[] byArray2;
                this.oneChar[0] = string.charAt(n4);
                if (this.oneChar[0] < '\u0080' || this.converter == null) {
                    this.oneByte[0] = (byte)this.oneChar[0];
                    byArray2 = this.oneByte;
                } else {
                    byArray2 = this.converter.convert(this.oneChar, 0, 1);
                }
                if (n + byArray2.length > n3) {
                    if (n3 != 70) {
                        this.os.write(32);
                    }
                    this.os.write(this.outBuf, 0, n);
                    this.os.write(sepBuf);
                    n3 = 69;
                    n = 0;
                }
                if (byArray2.length == 1) {
                    this.outBuf[n] = byArray2[0];
                } else {
                    System.arraycopy((Object)byArray2, 0, (Object)this.outBuf, n, byArray2.length);
                }
                n += byArray2.length;
                ++n4;
            }
            if (n > 0) {
                if (n3 != 70) {
                    this.os.write(32);
                }
                this.os.write(this.outBuf, 0, n);
                this.os.write(sepBuf);
            }
        }

        void write(Manifest manifest, OutputStream outputStream) throws IOException {
            Object object;
            Iterator iterator;
            String string;
            this.os = outputStream;
            String string2 = (String)AccessController.doPrivileged(new PriviAction("manifest.write.encoding"));
            if (string2 != null) {
                if ("".equals(string2)) {
                    string2 = "UTF8";
                }
                this.converter = CharacterConverter.getConverter(string2);
                if (this.converter == null) {
                    throw new UnsupportedEncodingException(string2);
                }
            }
            if ((string = manifest.mainAttributes.getValue(Attributes.Name.MANIFEST_VERSION)) != null) {
                this.writeEntry(Attributes.Name.MANIFEST_VERSION, string);
                iterator = manifest.mainAttributes.keySet().iterator();
                while (iterator.hasNext()) {
                    object = (Attributes.Name)iterator.next();
                    if (((Attributes.Name)object).equals(Attributes.Name.MANIFEST_VERSION)) continue;
                    this.writeEntry((Attributes.Name)object, manifest.mainAttributes.getValue((Attributes.Name)object));
                }
            }
            this.os.write(sepBuf);
            iterator = manifest.entryAttributes.keySet().iterator();
            while (iterator.hasNext()) {
                object = (String)iterator.next();
                this.writeEntry(nameAttribute, (String)object);
                Attributes attributes = (Attributes)manifest.entryAttributes.get(object);
                Iterator iterator2 = attributes.keySet().iterator();
                while (iterator2.hasNext()) {
                    Attributes.Name name = (Attributes.Name)iterator2.next();
                    this.writeEntry(name, attributes.getValue(name));
                }
                this.os.write(sepBuf);
            }
        }
    }
}

