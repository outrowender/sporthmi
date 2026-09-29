/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.memory;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TourHandlerHmiListener$State
extends PersistentState {
    private static final int VERSION;
    private static final int KEY;
    private int offrDisclaimerPersistence;

    public TourHandlerHmiListener$State(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 1, 1004, 943, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.offrDisclaimerPersistence = 1;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.offrDisclaimerPersistence);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.offrDisclaimerPersistence = dataInputStream.readInt();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.logChannel.log(-2137614336, "TourHandlerHmiListener.State#convertContainer( %1, %2 )", (long)n, (long)n2);
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.offrDisclaimerPersistence = dataInputStream.readInt();
            }
        }
        catch (IOException iOException) {
            this.logChannel.log(10000, "TourHandlerHmiListener.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    public int getOffrDisclaimerPersistence() {
        return this.offrDisclaimerPersistence;
    }

    public void setOffrDisclaimerPersistence(int n) {
        this.offrDisclaimerPersistence = n;
    }
}

