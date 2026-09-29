/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class LocalPersistNavLocationHelper$NavLocationState
extends PersistentState {
    public static final int VERSION;
    private byte[] serializedNavLocation = new byte[]{0};

    public LocalPersistNavLocationHelper$NavLocationState(IStorageAccess iStorageAccess, LogChannel logChannel, int n) {
        super(iStorageAccess, 1, 1004, n, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.serializedNavLocation = new byte[1];
        this.serializedNavLocation[0] = 0;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.logChannel.log(-2137614336, "NavLocationState#initFromOldKeys");
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        LocalPersistNavLocationHelper$NavLocationState.serializeByteArray(this.serializedNavLocation, dataOutputStream);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.serializedNavLocation = LocalPersistNavLocationHelper$NavLocationState.deserializeByteArray(dataInputStream);
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.serializedNavLocation = LocalPersistNavLocationHelper$NavLocationState.deserializeByteArray(dataInputStream);
            }
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "LocalPersistNavLocationHelper.NavLocationState#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    public byte[] getNavLocation() {
        return this.serializedNavLocation;
    }

    public void setNavLocation(byte[] byArray) {
        this.serializedNavLocation = byArray;
    }
}

