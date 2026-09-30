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
import java.io.IOException;

public class OperatorCallTransmitCCPDataContainer
extends AbstractStorageDataContainer {
    private static final int VERSION = 1;
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private int sendCCP = -1;

    public OperatorCallTransmitCCPDataContainer(IStorageAccess iStorageAccess) {
        super(iStorageAccess, 1, 1023, 31);
        this.readAndDeserialize();
    }

    protected void handleCRC32Error() {
        this.logChannel.log(10000, "OperatorCallTransmitCCPDataContainer#handleCRC32Error!");
    }

    protected void handleStorageReadError(Exception exception) {
        if (exception instanceof ValueMissingException) {
            this.logChannel.log(100000, "OperatorCallTransmitCCPDataContainer#handleStorageReadError -> ok, if status of the checkbox has never been changed before. ", (Throwable)exception);
            this.sendCCP = -1;
        } else {
            this.logChannel.log(10000, "OperatorCallTransmitCCPDataContainer#handleStorageReadError", (Throwable)exception);
        }
    }

    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) throws IOException {
        this.logChannel.log(10000000, "OperatorCallTransmitCCPDataContainer#convertContainer!");
    }

    protected void serialize(DataOutputStream dataOutputStream) throws IOException {
        this.logChannel.log(1000000, "OperatorCallTransmitCCPDataContainer#serialize: persisting ccp with ccpFlag = %1 ...", (long)this.sendCCP);
        dataOutputStream.writeInt(this.sendCCP);
        this.logChannel.log(1000000, "OperatorCallTransmitCCPDataContainer#serialize: persisting ccp finished");
    }

    protected void deserialize(DataInputStream dataInputStream) throws IOException {
        this.logChannel.log(1000000, "OperatorCallTransmitCCPDataContainer#serialize: reading ccp from persistence ...");
        this.sendCCP = dataInputStream.readInt();
        this.logChannel.log(1000000, "OperatorCallTransmitCCPDataContainer#serialize: reading ccp from persistence finished. CCP flag is %1", (long)this.sendCCP);
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

