/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storage.ValueMissingException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public abstract class PersistentState
extends AbstractStorageDataContainer {
    private final IStorageAccess storageAccess;
    protected final LogChannel logChannel;

    public PersistentState(IStorageAccess iStorageAccess, int n, int n2, int n3, LogChannel logChannel) {
        super(iStorageAccess, n, n2, n3);
        this.storageAccess = iStorageAccess;
        this.logChannel = logChannel;
    }

    protected LogChannel getLogChannel() {
        return this.logChannel;
    }

    protected abstract void initWithDefaultValues() {
    }

    protected abstract void initFromOldKeys(IStorageAccess iStorageAccess) {
    }

    @Override
    protected void handleCRC32Error() {
        this.logChannel.log(10000, "PersistentState#handleCRC32Error - invalid persistent state, using default values");
        this.initWithDefaultValues();
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        if (exception instanceof ValueMissingException) {
            this.logChannel.log(1078071040, "PersistentState#handleStorageReadError - no persistent state available, trying old keys");
            this.initFromOldKeys(this.storageAccess);
        } else {
            this.logChannel.log(-1601830656, "PersistentState#handleStorageReadError - cannot read persistent state, using default values (namespace: %1, key: %2)", (long)this.getNamespace(), (long)this.getKey());
            this.initWithDefaultValues();
        }
    }

    protected static void serializeByteArray(byte[] byArray, DataOutputStream dataOutputStream) {
        if (byArray == null) {
            dataOutputStream.writeInt(-1);
            return;
        }
        dataOutputStream.writeInt(byArray.length);
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            dataOutputStream.writeByte(byArray[i2]);
        }
    }

    protected static byte[] deserializeByteArray(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        if (n == -1) {
            return null;
        }
        byte[] byArray = new byte[n];
        for (int i2 = 0; i2 < n; ++i2) {
            byArray[i2] = dataInputStream.readByte();
        }
        return byArray;
    }
}

