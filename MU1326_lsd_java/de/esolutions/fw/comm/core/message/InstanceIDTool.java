/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.ServiceUUID;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class InstanceIDTool {
    public static void serializeUUID(ServiceInstanceID serviceInstanceID, ISerializer iSerializer) throws SerializerException {
        ServiceUUID serviceUUID = serviceInstanceID.getServiceUUID();
        serviceUUID.serialize(iSerializer);
        iSerializer.putInt32(serviceInstanceID.getHandle());
    }

    public static ServiceInstanceID deserializeUUID(IDeserializer iDeserializer) throws SerializerException {
        ServiceUUID serviceUUID = new ServiceUUID(iDeserializer);
        int n = iDeserializer.getInt32();
        return new ServiceInstanceID(serviceUUID, n, null);
    }

    public static void serializeUUIDandIK(ServiceInstanceID serviceInstanceID, ISerializer iSerializer) throws SerializerException {
        ServiceUUID serviceUUID = serviceInstanceID.getServiceUUID();
        serviceUUID.serialize(iSerializer);
        iSerializer.putInt32(serviceInstanceID.getHandle());
        ServiceUUID serviceUUID2 = serviceInstanceID.getInterfaceKey();
        serviceUUID2.serialize(iSerializer);
    }

    public static ServiceInstanceID deserializeUUIDandIK(IDeserializer iDeserializer) throws SerializerException {
        ServiceUUID serviceUUID = new ServiceUUID(iDeserializer);
        int n = iDeserializer.getInt32();
        ServiceUUID serviceUUID2 = new ServiceUUID(iDeserializer);
        return new ServiceInstanceID(serviceUUID, n, serviceUUID2);
    }
}

