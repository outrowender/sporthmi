/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceState_DataTransmissionState
implements BAPEntity {
    public boolean dataTransmissionViaInbandModemFailed;
    public boolean dataSentViaInbandModemSuccessfully;
    public boolean dataTransmissionViaIpConnectionFailed;
    public boolean dataSentSuccessfully;
    public boolean mdsReceptionOnBackEndFailed;
    public boolean mdsReceivedOnBackEndSuccessfully;
    public boolean mdsTransmissionViaSmsFailedE_g_NoNet;
    public boolean mdsMinimumDataSetSentViaSmsSuccessfully;

    public ServiceState_DataTransmissionState() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceState_DataTransmissionState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.dataTransmissionViaInbandModemFailed = false;
        this.dataSentViaInbandModemSuccessfully = false;
        this.dataTransmissionViaIpConnectionFailed = false;
        this.dataSentSuccessfully = false;
        this.mdsReceptionOnBackEndFailed = false;
        this.mdsReceivedOnBackEndSuccessfully = false;
        this.mdsTransmissionViaSmsFailedE_g_NoNet = false;
        this.mdsMinimumDataSetSentViaSmsSuccessfully = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceState_DataTransmissionState serviceState_DataTransmissionState = (ServiceState_DataTransmissionState)bAPEntity;
        return this.dataTransmissionViaInbandModemFailed == serviceState_DataTransmissionState.dataTransmissionViaInbandModemFailed && this.dataSentViaInbandModemSuccessfully == serviceState_DataTransmissionState.dataSentViaInbandModemSuccessfully && this.dataTransmissionViaIpConnectionFailed == serviceState_DataTransmissionState.dataTransmissionViaIpConnectionFailed && this.dataSentSuccessfully == serviceState_DataTransmissionState.dataSentSuccessfully && this.mdsReceptionOnBackEndFailed == serviceState_DataTransmissionState.mdsReceptionOnBackEndFailed && this.mdsReceivedOnBackEndSuccessfully == serviceState_DataTransmissionState.mdsReceivedOnBackEndSuccessfully && this.mdsTransmissionViaSmsFailedE_g_NoNet == serviceState_DataTransmissionState.mdsTransmissionViaSmsFailedE_g_NoNet && this.mdsMinimumDataSetSentViaSmsSuccessfully == serviceState_DataTransmissionState.mdsMinimumDataSetSentViaSmsSuccessfully;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ServiceState_DataTransmissionState");
        stringBuffer.append("\n - dataTransmissionViaInbandModemFailed:").append(this.dataTransmissionViaInbandModemFailed);
        stringBuffer.append("\n - dataSentViaInbandModemSuccessfully:").append(this.dataSentViaInbandModemSuccessfully);
        stringBuffer.append("\n - dataTransmissionViaIpConnectionFailed:").append(this.dataTransmissionViaIpConnectionFailed);
        stringBuffer.append("\n - dataSentSuccessfully:").append(this.dataSentSuccessfully);
        stringBuffer.append("\n - mdsReceptionOnBackEndFailed:").append(this.mdsReceptionOnBackEndFailed);
        stringBuffer.append("\n - mdsReceivedOnBackEndSuccessfully:").append(this.mdsReceivedOnBackEndSuccessfully);
        stringBuffer.append("\n - mdsTransmissionViaSmsFailedE_g_NoNet:").append(this.mdsTransmissionViaSmsFailedE_g_NoNet);
        stringBuffer.append("\n - mdsMinimumDataSetSentViaSmsSuccessfully:").append(this.mdsMinimumDataSetSentViaSmsSuccessfully);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.dataTransmissionViaInbandModemFailed);
        bitStream.pushBoolean(this.dataSentViaInbandModemSuccessfully);
        bitStream.pushBoolean(this.dataTransmissionViaIpConnectionFailed);
        bitStream.pushBoolean(this.dataSentSuccessfully);
        bitStream.pushBoolean(this.mdsReceptionOnBackEndFailed);
        bitStream.pushBoolean(this.mdsReceivedOnBackEndSuccessfully);
        bitStream.pushBoolean(this.mdsTransmissionViaSmsFailedE_g_NoNet);
        bitStream.pushBoolean(this.mdsMinimumDataSetSentViaSmsSuccessfully);
    }

    public void deserialize(BitStream bitStream) {
        this.dataTransmissionViaInbandModemFailed = bitStream.popFrontBoolean();
        this.dataSentViaInbandModemSuccessfully = bitStream.popFrontBoolean();
        this.dataTransmissionViaIpConnectionFailed = bitStream.popFrontBoolean();
        this.dataSentSuccessfully = bitStream.popFrontBoolean();
        this.mdsReceptionOnBackEndFailed = bitStream.popFrontBoolean();
        this.mdsReceivedOnBackEndSuccessfully = bitStream.popFrontBoolean();
        this.mdsTransmissionViaSmsFailedE_g_NoNet = bitStream.popFrontBoolean();
        this.mdsMinimumDataSetSentViaSmsSuccessfully = bitStream.popFrontBoolean();
    }
}

