/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AlternativeRouteStatePersitenceHelper$AlternativeRouteState
extends PersistentState {
    public static final int VERSION;
    private int serializedAlternativeRouteState;

    public AlternativeRouteStatePersitenceHelper$AlternativeRouteState(IStorageAccess iStorageAccess, LogChannel logChannel, int n) {
        super(iStorageAccess, 1, 1004, n, logChannel);
    }

    public void setAlternativeRouteState(int n) {
        this.serializedAlternativeRouteState = n;
    }

    public int getAlternativeRouteState() {
        return this.serializedAlternativeRouteState;
    }

    @Override
    protected void initWithDefaultValues() {
        this.serializedAlternativeRouteState = 1;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
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
            this.getLogChannel().log(10000, "AlternativeRouteStatePersitenceHelper.AlternativeRouteState#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        if (this.serializedAlternativeRouteState > 1 || this.serializedAlternativeRouteState < 0) {
            dataOutputStream.writeInt(-1);
        } else {
            dataOutputStream.writeInt(this.serializedAlternativeRouteState);
        }
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        this.serializedAlternativeRouteState = n == -1 ? 0 : n;
    }
}

