/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.CommStringTool;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class RejectMessage
extends AbstractMessage {
    protected String errorString;
    protected short errorCode;
    public static final short UNKNOWN_ERROR = 0;
    public static final short DUAL_CONNECT = 1;
    public static final short VERSION_TOO_NEW = 2;
    public static final short VERSION_TOO_OLD = 3;
    public static final short AGENT_TOO_OLD = 4;
    public static final short FEATURE_MISMATCH = 5;
    public static final String[] ERROR_NAMES = new String[]{"Unknown Error", "Dual Connect", "Version too new", "Version too old", "Agent too old", "Feature mismatch"};

    public RejectMessage(ISerializer iSerializer, short s, String string) {
        super(MessageType.REJECT, iSerializer);
        this.errorCode = s;
        this.errorString = string;
    }

    public RejectMessage(IDeserializer iDeserializer, boolean bl) throws SerializerException {
        super(MessageType.REJECT, iDeserializer, bl);
    }

    public void serializeElements(ISerializer iSerializer) throws SerializerException {
        iSerializer.putUInt8(this.errorCode);
        CommStringTool.serializeCommString(this.errorString, iSerializer);
    }

    public void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        this.errorCode = iDeserializer.getUInt8();
        this.errorString = CommStringTool.deserializeCommString(iDeserializer);
    }

    public short getErrorCode() {
        return this.errorCode;
    }

    public String getErrorString() {
        return this.errorString;
    }
}

