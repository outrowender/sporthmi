/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.storage;

import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storage.ValueMissingException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

public abstract class AbstractStorageDataContainer {
    private static final int MAX_ARRAY_CAPACITY;
    private final IStorageAccess storageAccess;
    private final int namespace;
    private final int key;
    private final int containerVersion;
    private long crc32Checksum = -1L;
    private int size;

    public AbstractStorageDataContainer(IStorageAccess iStorageAccess, int n, int n2, int n3) {
        if (iStorageAccess == null || n2 < 1 || n3 < 1) {
            throw new IllegalArgumentException(new StringBuffer().append("IStorageAccess=").append(iStorageAccess).append(", namespace=").append(n2).append(", key=").append(n3).toString());
        }
        this.storageAccess = iStorageAccess;
        this.containerVersion = n;
        this.namespace = n2;
        this.key = n3;
    }

    protected final IStorageAccess getStorageAccess() {
        return this.storageAccess;
    }

    protected abstract void handleCRC32Error() {
    }

    protected abstract void handleStorageReadError(Exception exception) {
    }

    protected abstract void convertContainer(int n, int n2, DataInputStream dataInputStream) {
    }

    protected abstract void serialize(DataOutputStream dataOutputStream) {
    }

    protected abstract void deserialize(DataInputStream dataInputStream) {
    }

    public final void readAndDeserialize() {
        byte[] byArray = this.storageAccess.getByteArray(this.namespace, this.key, null);
        if (byArray == null) {
            this.handleStorageReadError(new ValueMissingException(this.namespace, this.key));
            return;
        }
        this.setSize(byArray.length);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        try {
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            long l = dataInputStream.readLong();
            CRC32 cRC32 = new CRC32();
            cRC32.update(byArray, 8, byArray.length - 8);
            if (l != cRC32.getValue()) {
                this.handleCRC32Error();
                this.crc32Checksum = -1L;
                return;
            }
            this.crc32Checksum = cRC32.getValue();
            int n = dataInputStream.readInt();
            if (n != this.containerVersion) {
                this.convertContainer(n, this.containerVersion, dataInputStream);
                this.serializeAndWrite();
            } else {
                this.deserialize(dataInputStream);
            }
            byteArrayInputStream.close();
            dataInputStream.close();
        }
        catch (Exception exception) {
            this.handleStorageReadError(exception);
        }
    }

    private void setSize(int n) {
        this.size = n;
    }

    protected int getSize() {
        return this.size;
    }

    public final void serializeAndWrite() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeInt(this.containerVersion);
            this.serialize(dataOutputStream);
            dataOutputStream.flush();
            byteArrayOutputStream.flush();
            byte[] byArray = byteArrayOutputStream.toByteArray();
            CRC32 cRC32 = new CRC32();
            cRC32.update(byArray);
            cRC32.getValue();
            if (cRC32.getValue() != this.crc32Checksum) {
                byteArrayOutputStream.reset();
                dataOutputStream.close();
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeLong(cRC32.getValue());
                dataOutputStream.write(byArray);
                dataOutputStream.flush();
                byteArrayOutputStream.flush();
                this.storageAccess.setByteArray(this.namespace, this.key, byteArrayOutputStream.toByteArray());
                this.crc32Checksum = cRC32.getValue();
                this.setSize(byArray.length + 8);
            }
            byteArrayOutputStream.close();
            dataOutputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public int getNamespace() {
        return this.namespace;
    }

    public int getKey() {
        return this.key;
    }

    protected final void serializeBooleanArray(boolean[] blArray, DataOutputStream dataOutputStream) {
        if (blArray == null) {
            dataOutputStream.writeInt(-1);
            return;
        }
        dataOutputStream.writeInt(blArray.length);
        byte[] byArray = new byte[blArray.length];
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            byArray[i2] = (byte)(blArray[i2] ? 1 : 0);
        }
        dataOutputStream.write(byArray);
    }

    protected boolean[] deserializeBooleanArray(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        if (n > 1024) {
            this.handleStorageReadError(new ArrayIndexOutOfBoundsException(n));
            return null;
        }
        if (n == -1) {
            return null;
        }
        byte[] byArray = new byte[n];
        dataInputStream.read(byArray);
        boolean[] blArray = new boolean[n];
        for (int i2 = 0; i2 < n; ++i2) {
            blArray[i2] = byArray[i2] != 0;
        }
        return blArray;
    }

    protected void serializeIntArray(int[] nArray, DataOutputStream dataOutputStream) {
        if (nArray == null) {
            dataOutputStream.writeInt(-1);
            return;
        }
        dataOutputStream.writeInt(nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            dataOutputStream.writeInt(nArray[i2]);
        }
    }

    protected int[] deserializeIntArray(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        if (n > 1024) {
            this.handleStorageReadError(new ArrayIndexOutOfBoundsException(n));
            return null;
        }
        if (n == -1) {
            return null;
        }
        int[] nArray = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            nArray[i2] = dataInputStream.readInt();
        }
        return nArray;
    }

    protected void serializeLongArray(long[] lArray, DataOutputStream dataOutputStream) {
        if (lArray == null) {
            dataOutputStream.writeInt(-1);
            return;
        }
        dataOutputStream.writeInt(lArray.length);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            dataOutputStream.writeLong(lArray[i2]);
        }
    }

    protected long[] deserializeLongArray(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        if (n > 1024) {
            this.handleStorageReadError(new ArrayIndexOutOfBoundsException(n));
            return null;
        }
        if (n == -1) {
            return null;
        }
        long[] lArray = new long[n];
        for (int i2 = 0; i2 < n; ++i2) {
            lArray[i2] = dataInputStream.readLong();
        }
        return lArray;
    }

    protected void serializeStringArray(String[] stringArray, DataOutputStream dataOutputStream) {
        if (stringArray == null) {
            dataOutputStream.writeInt(-1);
            return;
        }
        dataOutputStream.writeInt(stringArray.length);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            dataOutputStream.writeUTF(stringArray[i2]);
        }
    }

    protected String[] deserializeStringArray(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        if (n > 1024) {
            this.handleStorageReadError(new ArrayIndexOutOfBoundsException(n));
            return null;
        }
        if (n == -1) {
            return null;
        }
        String[] stringArray = new String[n];
        for (int i2 = 0; i2 < n; ++i2) {
            stringArray[i2] = dataInputStream.readUTF();
        }
        return stringArray;
    }

    protected int getContainerVersion() {
        return this.containerVersion;
    }
}

