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

public class RoutePersistenceController$State
extends PersistentState {
    public static final int VERSION;
    public static final int KEY;
    private boolean rgActive;
    private int insideArea;
    private long timeStamp;

    public RoutePersistenceController$State(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 1, 1004, 870, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.rgActive = false;
        this.insideArea = -1;
        this.timeStamp = 0L;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.rgActive = iStorageAccess.getBoolean(1004, 10, false);
        this.insideArea = iStorageAccess.getInt(1004, 20, -1);
        this.timeStamp = iStorageAccess.getLong(1004, 30, 0L);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeBoolean(this.rgActive);
        dataOutputStream.writeInt(this.insideArea);
        dataOutputStream.writeLong(this.timeStamp);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.rgActive = dataInputStream.readBoolean();
        this.insideArea = dataInputStream.readInt();
        this.timeStamp = dataInputStream.readLong();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.getLogChannel().log(-2137614336, "[RouteGuidance] RoutePersistenceController.State#convertContainer( %1, %2 )", (long)n, (long)n2);
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.rgActive = dataInputStream.readBoolean();
                this.insideArea = dataInputStream.readInt();
                this.timeStamp = dataInputStream.readLong();
            }
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "[RouteGuidance] RoutePersistenceController.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    public boolean isRgActive() {
        return this.rgActive;
    }

    public void setRgActive(boolean bl) {
        this.rgActive = bl;
    }

    public int getInsideArea() {
        return this.insideArea;
    }

    public void setInsideArea(int n) {
        this.insideArea = n;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long l) {
        this.timeStamp = l;
    }
}

