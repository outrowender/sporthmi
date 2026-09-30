/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PasswordProtectedInputStream;
import com.ibm.oti.util.SHAOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.AccessController;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class KeyStore
extends KeyStoreSpi {
    static final int RANDOM_BYTES = 32;
    protected Hashtable database = new Hashtable();

    protected int getKeyStoreMagic() {
        return 77;
    }

    protected int getKeyStoreVersion() {
        return 2;
    }

    protected int getKeyStoreOldVeresion() {
        return 1;
    }

    private static byte[] digestPassword(char[] cArray) {
        SHAOutputStream sHAOutputStream = new SHAOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(sHAOutputStream);
        try {
            int n = 0;
            while (n < cArray.length) {
                dataOutputStream.write(cArray[n]);
                ++n;
            }
            dataOutputStream.flush();
            dataOutputStream.close();
        }
        catch (IOException iOException) {}
        return sHAOutputStream.getHashAsBytes();
    }

    protected static void writeCertificate(Certificate certificate, ObjectOutputStream objectOutputStream) throws IOException, CertificateEncodingException {
        byte[] byArray = certificate.getEncoded();
        String string = certificate.getType();
        objectOutputStream.writeObject(string);
        objectOutputStream.writeObject(byArray);
    }

    protected static Certificate readCertificate(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException, CertificateException {
        String string = (String)objectInputStream.readObject();
        byte[] byArray = (byte[])objectInputStream.readObject();
        CertificateFactory certificateFactory = CertificateFactory.getInstance(string);
        return certificateFactory.generateCertificate(new ByteArrayInputStream(byArray));
    }

    private static byte[] digestHeader(long l, byte[] byArray, char[] cArray) {
        SHAOutputStream sHAOutputStream = new SHAOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(sHAOutputStream);
        try {
            dataOutputStream.writeLong(l);
            dataOutputStream.write(byArray);
            int n = 0;
            while (n < cArray.length) {
                dataOutputStream.write(cArray[n]);
                ++n;
            }
            dataOutputStream.flush();
            dataOutputStream.close();
        }
        catch (IOException iOException) {}
        return sHAOutputStream.getHashAsBytes();
    }

    public Enumeration engineAliases() {
        return this.database.keys();
    }

    public boolean engineContainsAlias(String string) {
        return this.database.containsKey(string);
    }

    public void engineDeleteEntry(String string) throws KeyStoreException {
        this.database.remove(string);
    }

    public Certificate engineGetCertificate(String string) {
        KeyStoreEntry keyStoreEntry = (KeyStoreEntry)this.database.get(string);
        if (keyStoreEntry != null) {
            if (keyStoreEntry instanceof KeyStoreCertificate) {
                return ((KeyStoreCertificate)keyStoreEntry).cert;
            }
            if (keyStoreEntry instanceof KeyStoreKey) {
                return ((KeyStoreKey)keyStoreEntry).chain[0];
            }
        }
        return null;
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration enumeration = this.database.keys();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            KeyStoreEntry keyStoreEntry = (KeyStoreEntry)this.database.get(string);
            Certificate certificate2 = null;
            if (keyStoreEntry == null) continue;
            if (keyStoreEntry instanceof KeyStoreCertificate) {
                certificate2 = ((KeyStoreCertificate)keyStoreEntry).cert;
            } else if (keyStoreEntry instanceof KeyStoreKey) {
                certificate2 = ((KeyStoreKey)keyStoreEntry).chain[0];
            }
            if (certificate2 == null || !certificate2.equals(certificate)) continue;
            return string;
        }
        return null;
    }

    public Certificate[] engineGetCertificateChain(String string) {
        KeyStoreEntry keyStoreEntry = (KeyStoreEntry)this.database.get(string);
        if (keyStoreEntry != null && keyStoreEntry instanceof KeyStoreKey) {
            return ((KeyStoreKey)keyStoreEntry).chain;
        }
        return null;
    }

    public Date engineGetCreationDate(String string) {
        KeyStoreEntry keyStoreEntry = (KeyStoreEntry)this.database.get(string);
        if (keyStoreEntry != null) {
            return keyStoreEntry.creationDate;
        }
        return null;
    }

    public Key engineGetKey(String string, char[] cArray) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        KeyStoreEntry keyStoreEntry = (KeyStoreEntry)this.database.get(string);
        if (keyStoreEntry != null && keyStoreEntry instanceof KeyStoreKey) {
            byte[] byArray = KeyStore.digestPassword(cArray);
            KeyStoreKey keyStoreKey = (KeyStoreKey)keyStoreEntry;
            if (keyStoreKey.key instanceof Key) {
                if (Arrays.equals(byArray, keyStoreKey.digest)) {
                    return (Key)keyStoreKey.key;
                }
                throw new UnrecoverableKeyException();
            }
        }
        return null;
    }

    public boolean engineIsCertificateEntry(String string) {
        KeyStoreEntry keyStoreEntry = (KeyStoreEntry)this.database.get(string);
        if (keyStoreEntry == null) {
            return false;
        }
        return keyStoreEntry instanceof KeyStoreCertificate;
    }

    public boolean engineIsKeyEntry(String string) {
        KeyStoreEntry keyStoreEntry = (KeyStoreEntry)this.database.get(string);
        if (keyStoreEntry == null) {
            return false;
        }
        return keyStoreEntry instanceof KeyStoreKey;
    }

    public void engineLoad(InputStream inputStream, char[] cArray) throws IOException, NoSuchAlgorithmException, CertificateException {
        byte[] byArray;
        Object object;
        if (inputStream == null) {
            return;
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int n = dataInputStream.readInt();
        if (n != this.getKeyStoreMagic()) {
            throw new IOException(Msg.getString("K00fd"));
        }
        int n2 = dataInputStream.readInt();
        if (n2 != this.getKeyStoreVersion() && n2 != this.getKeyStoreOldVeresion()) {
            throw new IOException(Msg.getString("K00fd"));
        }
        long l = dataInputStream.readLong();
        byte[] byArray2 = new byte[32];
        dataInputStream.readFully(byArray2);
        byte[] byArray3 = new byte[20];
        dataInputStream.readFully(byArray3);
        if (cArray != null && !Arrays.equals(byArray3, (byte[])(object = KeyStore.digestHeader(l, byArray2, cArray)))) {
            throw new IOException(Msg.getString("K00fe"));
        }
        if (n2 == this.getKeyStoreOldVeresion()) {
            byArray = new String(cArray).getBytes();
            object = new ObjectInputStream(new PasswordProtectedInputStream(inputStream, byArray));
        } else {
            object = new ObjectInputStream(inputStream);
        }
        try {
            byArray = object;
            this.database = (Hashtable)AccessController.doPrivileged(new PrivilegedAction((ObjectInputStream)byArray){
                private final /* synthetic */ ObjectInputStream val$stream;
                {
                    this.val$stream = objectInputStream;
                }

                public Object run() {
                    try {
                        return this.val$stream.readObject();
                    }
                    catch (Exception exception) {
                        return null;
                    }
                }
            });
            if (this.database == null) {
                throw new IOException("Error reading keystore");
            }
        }
        finally {
            ((ObjectInputStream)object).close();
        }
    }

    public void engineSetCertificateEntry(String string, Certificate certificate) throws KeyStoreException {
        KeyStoreEntry keyStoreEntry = (KeyStoreEntry)this.database.get(string);
        if (keyStoreEntry != null && keyStoreEntry instanceof KeyStoreKey) {
            throw new KeyStoreException(Msg.getString("K0185"));
        }
        this.database.put(string, new KeyStoreCertificate(certificate));
    }

    public void engineSetKeyEntry(String string, byte[] byArray, Certificate[] certificateArray) throws KeyStoreException {
        this.database.put(string, new KeyStoreKey(byArray, certificateArray));
    }

    public void engineSetKeyEntry(String string, Key key, char[] cArray, Certificate[] certificateArray) throws KeyStoreException {
        KeyStoreKey keyStoreKey = new KeyStoreKey(key, certificateArray);
        keyStoreKey.digest = KeyStore.digestPassword(cArray);
        this.database.put(string, keyStoreKey);
    }

    public int engineSize() {
        return this.database.size();
    }

    public void engineStore(OutputStream outputStream, char[] cArray) throws IOException, NoSuchAlgorithmException, CertificateException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        long l = System.currentTimeMillis();
        byte[] byArray = new byte[32];
        new SecureRandom().nextBytes(byArray);
        byte[] byArray2 = KeyStore.digestHeader(l, byArray, cArray);
        dataOutputStream.writeInt(this.getKeyStoreMagic());
        dataOutputStream.writeInt(this.getKeyStoreVersion());
        dataOutputStream.writeLong(l);
        dataOutputStream.write(byArray);
        dataOutputStream.write(byArray2);
        dataOutputStream.flush();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this.database);
        objectOutputStream.close();
    }

    protected static class KeyStoreKey
    extends KeyStoreEntry {
        static final long serialVersionUID = -3264292225350417776L;
        protected Object key;
        protected Certificate[] chain;
        byte[] digest;

        protected KeyStoreKey() {
        }

        protected KeyStoreKey(byte[] byArray) {
            this(byArray, null);
        }

        protected KeyStoreKey(Key key) {
            this(key, null);
        }

        protected KeyStoreKey(Object object, Certificate[] certificateArray) {
            this.key = object;
            this.chain = certificateArray;
        }

        public Object getKey() {
            return this.key;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException, CertificateEncodingException {
            objectOutputStream.writeObject(this.key);
            objectOutputStream.writeObject(this.digest);
            if (this.chain == null) {
                objectOutputStream.writeObject(this.chain);
            } else {
                objectOutputStream.writeObject(new Integer(this.chain.length));
                int n = 0;
                while (n < this.chain.length) {
                    KeyStore.writeCertificate(this.chain[n], objectOutputStream);
                    ++n;
                }
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException, CertificateException {
            this.key = objectInputStream.readObject();
            this.digest = (byte[])objectInputStream.readObject();
            Object object = objectInputStream.readObject();
            if (object != null) {
                Integer n = (Integer)object;
                this.chain = new Certificate[n.intValue()];
                int n2 = 0;
                while (n2 < n) {
                    this.chain[n2] = KeyStore.readCertificate(objectInputStream);
                    ++n2;
                }
            }
        }
    }

    protected static class KeyStoreEntry
    implements Serializable {
        static final long serialVersionUID = -6740993172540267582L;
        Date creationDate = new Date();

        protected KeyStoreEntry() {
        }
    }

    protected static class KeyStoreCertificate
    extends KeyStoreEntry {
        static final long serialVersionUID = 253492815225434760L;
        Certificate cert;

        public KeyStoreCertificate(Certificate certificate) {
            this.cert = certificate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException, CertificateEncodingException {
            KeyStore.writeCertificate(this.cert, objectOutputStream);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException, CertificateException {
            this.cert = KeyStore.readCertificate(objectInputStream);
        }
    }
}

