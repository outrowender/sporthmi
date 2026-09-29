/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

import de.audi.atip.interapp.bap.ecall.data.MdsTransmissionResult;

public final class MdsTransmissionResult$Builder {
    private boolean mininumDataSetSentViaSmsSuceeded;
    private boolean mininumDataSetSentViaSmsFailed;
    private boolean mininumDataSetReceptionAcknowledgedSuceeded;
    private boolean mininumDataSetReceptionAcknowledgedFailed;
    private boolean dataSentViaInternetProtocolSuceeded;
    private boolean dataSentViaInternetProtocolFailed;
    private boolean dataSentViaInbandModemSuceeded;
    private boolean dataSentViaInbandModemFailed;

    public MdsTransmissionResult$Builder setMininumDataSetSentViaSmsSuceeded(boolean bl) {
        this.mininumDataSetSentViaSmsSuceeded = bl;
        return this;
    }

    public MdsTransmissionResult$Builder setMininumDataSetSentViaSmsFailed(boolean bl) {
        this.mininumDataSetSentViaSmsFailed = bl;
        return this;
    }

    public MdsTransmissionResult$Builder setMininumDataSetReceptionAcknowledgedSuceeded(boolean bl) {
        this.mininumDataSetReceptionAcknowledgedSuceeded = bl;
        return this;
    }

    public MdsTransmissionResult$Builder setMininumDataSetReceptionAcknowledgedFailed(boolean bl) {
        this.mininumDataSetReceptionAcknowledgedFailed = bl;
        return this;
    }

    public MdsTransmissionResult$Builder setMininumDataSetSentViaInternetProtocolSuceeded(boolean bl) {
        this.dataSentViaInternetProtocolSuceeded = bl;
        return this;
    }

    public MdsTransmissionResult$Builder setMininumDataSetSentViaInternetProtocolFailed(boolean bl) {
        this.dataSentViaInternetProtocolFailed = bl;
        return this;
    }

    public MdsTransmissionResult$Builder setMininumDataSetSentViaInbandModemSuceeded(boolean bl) {
        this.dataSentViaInbandModemSuceeded = bl;
        return this;
    }

    public MdsTransmissionResult$Builder setMininumDataSetSentViaInbandModemFailed(boolean bl) {
        this.dataSentViaInbandModemFailed = bl;
        return this;
    }

    public MdsTransmissionResult build() {
        return new MdsTransmissionResult(this.mininumDataSetSentViaSmsSuceeded, this.mininumDataSetSentViaSmsFailed, this.mininumDataSetReceptionAcknowledgedSuceeded, this.mininumDataSetReceptionAcknowledgedFailed, this.dataSentViaInternetProtocolSuceeded, this.dataSentViaInternetProtocolFailed, this.dataSentViaInbandModemSuceeded, this.dataSentViaInbandModemFailed);
    }
}

