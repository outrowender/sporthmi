/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PredictiveNavState
extends PersistentState {
    private static final int VERSION;
    public static final int DEFAULT_OPERATION_MODE;
    private static final int OPERATION_MODE_ERROR;
    private int operationMode;

    public PredictiveNavState(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 4, 1004, 988, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.operationMode = 0;
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
            this.getLogChannel().log(10000, "LocalPersistNavLocationHelper.NavLocationState#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        this.logChannel.log(-2137614336, "PredictiveNavState serialize: operationMode=%1", (long)this.operationMode);
        if (this.operationMode != 0 && this.operationMode != 1 && this.operationMode != 2) {
            dataOutputStream.writeInt(-1);
        } else {
            dataOutputStream.writeInt(this.operationMode);
        }
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        if (n == -1) {
            this.logChannel.log(-2137614336, "PredictiveNavState deserialize: ERROR operationMode=%1", (long)this.operationMode);
            this.operationMode = 0;
        } else {
            this.logChannel.log(-2137614336, "PredictiveNavState deserialize: operationMode=%1", (long)this.operationMode);
            this.operationMode = n;
        }
    }

    public int getOperationMode() {
        return this.operationMode;
    }

    public void setOperationMode(int n) {
        this.operationMode = n;
    }
}

