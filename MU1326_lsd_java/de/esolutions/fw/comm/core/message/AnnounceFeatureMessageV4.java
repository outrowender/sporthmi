/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AnnounceFeatureMessage;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class AnnounceFeatureMessageV4
extends AnnounceFeatureMessage {
    private short agentEpoch;

    public AnnounceFeatureMessageV4(ISerializer iSerializer, short s, byte by, short s2) {
        super(iSerializer, s, by);
        this.agentEpoch = s2;
    }

    public AnnounceFeatureMessageV4(IDeserializer iDeserializer, boolean bl) throws SerializerException {
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

