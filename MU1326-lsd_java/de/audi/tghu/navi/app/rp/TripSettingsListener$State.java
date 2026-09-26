/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rp;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TripSettingsListener$State
extends PersistentState {
    public static final int VERSION;
    public static final int KEY;
    private int timeMode;

    public TripSettingsListener$State(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 1, 1004, 1042, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.timeMode = 0;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.timeMode = iStorageAccess.getInt(1004, 360, 0);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.timeMode);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.timeMode = dataInputStream.readInt();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.getLogChannel().log(-2137614336, "TripSettingsListener.State#convertContainer( %1, %2 )", (long)n, (long)n2);
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.timeMode = dataInputStream.readInt();
            }
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "TripSettingsListener.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    public int getTimeMode() {
        return this.timeMode;
    }

    public void setTimeMode(int n) {
        this.timeMode = n;
    }
}

