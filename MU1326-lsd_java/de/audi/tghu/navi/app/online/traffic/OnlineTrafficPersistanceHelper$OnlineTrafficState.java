/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.online.traffic;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class OnlineTrafficPersistanceHelper$OnlineTrafficState
extends PersistentState {
    public static final int VERSION;
    public static final boolean DEFAULT_ONLINE_TRAFFIC_STATE;
    private boolean serializedState;

    public OnlineTrafficPersistanceHelper$OnlineTrafficState(IStorageAccess iStorageAccess, LogChannel logChannel, int n) {
        super(iStorageAccess, 1, 1004, n, logChannel);
    }

    public void setOnlineTrafficState(boolean bl) {
        this.serializedState = bl;
    }

    public boolean getOnlineTrafficState() {
        return this.serializedState;
    }

    @Override
    protected void initWithDefaultValues() {
        this.serializedState = true;
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
            this.getLogChannel().log(10000, "OnlineTrafficPersistanceHelper#OnlineTrafficState#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeBoolean(this.serializedState);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        boolean bl;
        this.serializedState = bl = dataInputStream.readBoolean();
    }
}

