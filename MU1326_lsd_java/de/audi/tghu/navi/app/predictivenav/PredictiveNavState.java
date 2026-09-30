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
    private static final int VERSION = 4;
    public static final int DEFAULT_OPERATION_MODE = 0;
    private static final int OPERATION_MODE_ERROR = -1;
    private int operationMode;

    public PredictiveNavState(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 4, 1004, 988, logChannel);
    }

    protected void initWithDefaultValues() {
        this.operationMode = 0;
    }

    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
    }

    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) throws IOException {
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

    protected void serialize(DataOutputStream dataOutputStream) throws IOException {
        this.logChannel.log(10000000, "PredictiveNavState serialize: operationMode=%1", (long)this.operationMode);
        if (this.operationMode != 0 && this.operationMode != 1 && this.operationMode != 2) {
            dataOutputStream.writeInt(-1);
        } else {
            dataOutputStream.writeInt(this.operationMode);
        }
    }

    protected void deserialize(DataInputStream dataInputStream) throws IOException {
        int n = dataInputStream.readInt();
        if (n == -1) {
            this.logChannel.log(10000000, "PredictiveNavState deserialize: ERROR operationMode=%1", (long)this.operationMode);
            this.operationMode = 0;
        } else {
            this.logChannel.log(10000000, "PredictiveNavState deserialize: operationMode=%1", (long)this.operationMode);
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

