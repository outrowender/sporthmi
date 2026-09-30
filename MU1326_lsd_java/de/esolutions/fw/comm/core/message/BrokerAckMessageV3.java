/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.message.BrokerAckMessage;
import de.esolutions.fw.comm.core.message.InstanceIDTool;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class BrokerAckMessageV3
extends BrokerAckMessage {
    public BrokerAckMessageV3(ISerializer iSerializer, short s, ServiceInstanceID serviceInstanceID) {
        super(iSerializer, s, serviceInstanceID);
    }

    public BrokerAckMessageV3(IDeserializer iDeserializer, boolean bl) throws SerializerException {
        super(iDeserializer, bl);
    }

    public void serializeElements(ISerializer iSerializer) throws SerializerException {
        iSerializer.putInt16(this.brokerAgentID);
        InstanceIDTool.serializeUUIDandIK(this.brokerInstanceID, iSerializer);
    }

    public void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        this.brokerAgentID = iDeserializer.getInt16();
        this.brokerInstanceID = InstanceIDTool.deserializeUUIDandIK(iDeserializer);
    }
}

