/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storage.ValueMissingException;
import de.audi.tghu.online.app.Online;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class OperatorCallTransmitCCPDataContainer
extends AbstractStorageDataContainer {
    private static final int VERSION;
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private int sendCCP = -1;

    public OperatorCallTransmitCCPDataContainer(IStorageAccess iStorageAccess) {
        super(iStorageAccess, 1, 1023, 31);
        this.readAndDeserialize();
    }

    @Override
    protected void handleCRC32Error() {
        this.logChannel.log(10000, "OperatorCallTransmitCCPDataContainer#handleCRC32Error!");
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        if (exception instanceof ValueMissingException) {
            this.logChannel.log(-1601830656, "OperatorCallTransmitCCPDataContainer#handleStorageReadError -> ok, if status of the checkbox has never been changed before. ", (Throwable)exception);
            this.sendCCP = -1;
        } else {
            this.logChannel.log(10000, "OperatorCallTransmitCCPDataContainer#handleStorageReadError", (Throwable)exception);
        }
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.logChannel.log(-2137614336, "OperatorCallTransmitCCPDataContainer#convertContainer!");
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        this.logChannel.log(1078071040, "OperatorCallTransmitCCPDataContainer#serialize: persisting ccp with ccpFlag = %1 ...", (long)this.sendCCP);
        dataOutputStream.writeInt(this.sendCCP);
        this.logChannel.log(1078071040, "OperatorCallTransmitCCPDataContainer#serialize: persisting ccp finished");
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.logChannel.log(1078071040, "OperatorCallTransmitCCPDataContainer#serialize: reading ccp from persistence ...");
        this.sendCCP = dataInputStream.readInt();
        this.logChannel.log(1078071040, "OperatorCallTransmitCCPDataContainer#serialize: reading ccp from persistence finished. CCP flag is %1", (long)this.sendCCP);
    }

    public int getSendCCPStatus() {
        return this.sendCCP;
    }

    public void setSendCcpAndPersist(int n) {
        if (n >= -1 && n <= 1) {
            this.sendCCP = n;
            this.serializeAndWrite();
        } else {
            this.logChannel.log(10000, "OperatorCallTransmitCCPDataContainer#setSendCCP: invalid status for sendCCP (%1). This should never happen!", (long)n);
        }
    }
}

