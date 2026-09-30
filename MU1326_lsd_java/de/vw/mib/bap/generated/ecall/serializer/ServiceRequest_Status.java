/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.ecall.serializer.ServiceRequest_Extension1;
import de.vw.mib.bap.generated.ecall.serializer.ServiceRequest_Extension2;
import de.vw.mib.bap.generated.ecall.serializer.ServiceRequest_ServiceType;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceRequest_Status
implements StatusProperty {
    public ServiceRequest_ServiceType serviceType = new ServiceRequest_ServiceType();
    public int durationBeforeCallStart;
    public static final int DURATION_BEFORE_CALL_START_MIN = 0;
    public ServiceRequest_Extension1 extension1 = new ServiceRequest_Extension1();
    public ServiceRequest_Extension2 extension2 = new ServiceRequest_Extension2();

    public ServiceRequest_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceRequest_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.durationBeforeCallStart = 0;
    }

    public void reset() {
        this.internalReset();
        this.serviceType.reset();
        this.extension1.reset();
        this.extension2.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceRequest_Status serviceRequest_Status = (ServiceRequest_Status)bAPEntity;
        return this.serviceType.equalTo(serviceRequest_Status.serviceType) && this.durationBeforeCallStart == serviceRequest_Status.durationBeforeCallStart && this.extension1.equalTo(serviceRequest_Status.extension1) && this.extension2.equalTo(serviceRequest_Status.extension2);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ServiceRequest_Status");
        stringBuffer.append("\n - serviceType:").append(this.serviceType.toString());
        stringBuffer.append("\n - durationBeforeCallStart:").append(this.durationBeforeCallStart);
        stringBuffer.append("\n - extension1:").append(this.extension1.toString());
        stringBuffer.append("\n - extension2:").append(this.extension2.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.serviceType.serialize(bitStream);
        bitStream.pushByte((byte)this.durationBeforeCallStart);
        this.extension1.serialize(bitStream);
        this.extension2.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.serviceType.deserialize(bitStream);
        this.durationBeforeCallStart = bitStream.popFrontByte();
        this.extension1.deserialize(bitStream);
        this.extension2.deserialize(bitStream);
    }

    public static int functionId() {
        return 24;
    }

    public int getFunctionId() {
        return ServiceRequest_Status.functionId();
    }
}

