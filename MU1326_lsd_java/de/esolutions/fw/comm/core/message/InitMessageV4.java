/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.InitMessage;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class InitMessageV4
extends InitMessage {
    private short agentEpoch;

    public InitMessageV4(ISerializer iSerializer, short s, byte by, short s2) {
        super(iSerializer, s, by);
        this.agentEpoch = s2;
    }

    public InitMessageV4(IDeserializer iDeserializer, boolean bl) throws SerializerException {
        super(iDeserializer, bl);
    }

    public void serializeElements(ISerializer iSerializer) throws SerializerException {
        super.serializeElements(iSerializer);
        iSerializer.putInt16(this.agentEpoch);
    }

    public void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        super.deserializeElements(iDeserializer);
        this.agentEpoch = iDeserializer.getInt16();
    }

    public short getAgentEpoch() {
        return this.agentEpoch;
    }
}

