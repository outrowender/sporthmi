/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class GoogleMapLicensePersistenceHelper$GoogleMapLicenseState
extends PersistentState {
    public static final int VERSION;
    public static final int DEFAULT_GE_LICENSE_STATE;
    private int serializedState;

    public GoogleMapLicensePersistenceHelper$GoogleMapLicenseState(IStorageAccess iStorageAccess, LogChannel logChannel, int n) {
        super(iStorageAccess, 1, 1004, n, logChannel);
    }

    public void setGoogleMapLicenseState(int n) {
        this.serializedState = n;
    }

    public int getGoogleMapLicenseState() {
        return this.serializedState;
    }

    @Override
    protected void initWithDefaultValues() {
        this.serializedState = -1;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.initWithDefaultValues();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.deserialize(dataInputStream);
            }
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "GoogleMapLicensePersistenceHelper#GoogleMapLicenseState#convertContainer() - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.serializedState);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        int n;
        this.serializedState = n = dataInputStream.readInt();
    }
}

