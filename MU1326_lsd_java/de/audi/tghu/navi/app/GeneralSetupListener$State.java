/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class GeneralSetupListener$State
extends PersistentState {
    public static final int VERSION;
    public static final int KEY;
    private int trafficSignDisplay;
    private int rseConfirmTransfer;

    public GeneralSetupListener$State(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 2, 1004, 840, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.trafficSignDisplay = 1;
        this.rseConfirmTransfer = 0;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.trafficSignDisplay = iStorageAccess.getInt(1004, 370, 1);
        this.rseConfirmTransfer = iStorageAccess.getInt(1004, 390, 0);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.trafficSignDisplay);
        dataOutputStream.writeInt(this.rseConfirmTransfer);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.trafficSignDisplay = dataInputStream.readInt();
        this.rseConfirmTransfer = dataInputStream.readInt();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.getLogChannel().log(-2137614336, "GeneralSetupListener.State#convertContainer( %1, %2 )", (long)n, (long)n2);
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.trafficSignDisplay = dataInputStream.readInt();
                this.rseConfirmTransfer = dataInputStream.readInt();
            }
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "GeneralSetupListener.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    public int getTrafficSignDisplay() {
        return this.trafficSignDisplay;
    }

    public void setTrafficSignDisplay(int n) {
        this.trafficSignDisplay = n;
    }

    public int getRseConfirmTransfer() {
        return this.rseConfirmTransfer;
    }

    public void setRseConfirmTransfer(int n) {
        this.rseConfirmTransfer = n;
    }
}

