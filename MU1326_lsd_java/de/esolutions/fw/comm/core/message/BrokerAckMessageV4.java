/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.message.BrokerAckMessageV3;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class BrokerAckMessageV4
extends BrokerAckMessageV3 {
    private short assignedAgentID;
    private short assignedAgentEpoch;

    public BrokerAckMessageV4(ISerializer iSerializer, short s, ServiceInstanceID serviceInstanceID, short s2, short s3) {
        super(iSerializer, s, serviceInstanceID);
        this.assignedAgentID = s2;
        this.assignedAgentEpoch = s3;
    }

    public BrokerAckMessageV4(IDeserializer iDeserializer, boolean bl) throws SerializerException {
        super(iDeserializer, bl);
    }

    public void serializeElements(ISerializer iSerializer) throws SerializerException {
        super.serializeElements(iSerializer);
        iSerializer.putInt16(this.assignedAgentID);
        iSerializer.putInt16(this.assignedAgentEpoch);
    }

    public void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        super.deserializeElements(iDeserializer);
        this.assignedAgentID = iDeserializer.getInt16();
        this.assignedAgentEpoch = iDeserializer.getInt16();
    }

    public short getAssignedAgentID() {
        return this.assignedAgentID;
    }

    public short getAssignedAgentEpoch() {
        return this.assignedAgentEpoch;
    }
}

