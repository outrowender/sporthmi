/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.esolutions.fw.util.commons.Buffer;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

public class OperatorCallHistoryStorage {
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private final String name;
    private final long dateTime;
    private boolean writeFlag;
    private final int poiStorageIndex;
    private int uniqueId;

    public OperatorCallHistoryStorage(int n, String string, long l, int n2, boolean bl) {
        this.uniqueId = n;
        this.name = string;
        this.dateTime = l;
        this.poiStorageIndex = n2;
        this.writeFlag = bl;
    }

    public void serialize(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(this.name);
        dataOutputStream.writeLong(this.dateTime);
        dataOutputStream.writeInt(this.poiStorageIndex);
        this.logChannel.log(100000000, "OperatorCallHistoryStorage#serialize: name = %1, poiStorageIndex = %2", (Object)this.name, (long)this.poiStorageIndex);
    }

    public boolean writePoisToPersistence() {
        return this.writeFlag;
    }

    public void setWriteFlag(boolean bl) {
        this.writeFlag = bl;
    }

    public int getPoiStorageIndex() {
        return this.poiStorageIndex;
    }

    public String getName() {
        return this.name;
    }

    public Date getDate() {
        return new Date(this.dateTime);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("date = ");
        buffer.append(this.dateTime);
        buffer.append("poiStorageId = ");
        buffer.append(new DecimalFormat("00").format(this.poiStorageIndex));
        buffer.append("writeFlag = ");
        buffer.append(this.writeFlag);
        buffer.append("name = ");
        buffer.append(this.name);
        return buffer.toString();
    }

    public int getUniqueId() {
        return this.uniqueId;
    }
}

