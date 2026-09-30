/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;

public class SyncMarkerMessage
extends AbstractMessage {
    private int seqNum;
    private long timeStamp;
    private byte[] magic = new byte[]{101, 53, 48};

    public SyncMarkerMessage(int n, long l) {
        super(MessageType.SYNC_MARKER);
        this.seqNum = n;
        this.timeStamp = l;
    }

    public SyncMarkerMessage() {
        super(MessageType.SYNC_MARKER);
    }

    public void serializeElements(ISerializer iSerializer) throws SerializerException {
        iSerializer.putRawBytes(this.magic);
        iSerializer.putInt32(this.seqNum);
        iSerializer.putInt64(this.timeStamp);
    }

    public void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        iDeserializer.getRawBytes(this.magic);
        this.seqNum = iDeserializer.getInt32();
        this.timeStamp = iDeserializer.getInt64();
    }

    public int getSeqNum() {
        return this.seqNum;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public boolean isMagicValid() {
        return this.magic[0] == 101 && this.magic[1] == 53 && this.magic[2] == 48;
    }

    public void toStringBuffer(Buffer buffer) {
        buffer.append("SyncMarker: magic=");
        buffer.append(this.isMagicValid());
        buffer.append(" seqNum=");
        buffer.append(this.seqNum);
        buffer.append(" timeStamp=");
        buffer.append(this.timeStamp);
        buffer.append("/");
        buffer.append(TraceTimeStamp.longToUTCTimeString(this.timeStamp, true));
    }
}

