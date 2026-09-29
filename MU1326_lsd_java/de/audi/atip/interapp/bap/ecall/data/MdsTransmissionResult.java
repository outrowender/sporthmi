/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

import de.audi.atip.interapp.bap.ecall.data.MdsTransmissionResult$Builder;

public final class MdsTransmissionResult {
    private final boolean mininumDataSetSentViaSmsSuceeded;
    private final boolean mininumDataSetSentViaSmsFailed;
    private final boolean mininumDataSetReceptionAcknowledgedSuceeded;
    private final boolean mininumDataSetReceptionAcknowledgedFailed;
    private final boolean dataSentViaInternetProtocolSuceeded;
    private final boolean dataSentViaInternetProtocolFailed;
    private final boolean dataSentViaInbandModemSuceeded;
    private final boolean dataSentViaInbandModemFailed;

    public static MdsTransmissionResult$Builder builder() {
        return new MdsTransmissionResult$Builder();
    }

    private MdsTransmissionResult(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.mininumDataSetSentViaSmsSuceeded = bl;
        this.mininumDataSetSentViaSmsFailed = bl2;
        this.mininumDataSetReceptionAcknowledgedSuceeded = bl3;
        this.mininumDataSetReceptionAcknowledgedFailed = bl4;
        this.dataSentViaInternetProtocolSuceeded = bl5;
        this.dataSentViaInternetProtocolFailed = bl6;
        this.dataSentViaInbandModemSuceeded = bl7;
        this.dataSentViaInbandModemFailed = bl8;
    }

    public int getResultDataSentViaSms() {
        if (this.mininumDataSetSentViaSmsFailed) {
            return 2;
        }
        if (this.mininumDataSetSentViaSmsSuceeded) {
            return 1;
        }
        return 0;
    }

    public int getResultDataReceptionAcknowledged() {
        if (this.mininumDataSetReceptionAcknowledgedFailed) {
            return 2;
        }
        if (this.mininumDataSetReceptionAcknowledgedSuceeded) {
            return 1;
        }
        return 0;
    }

    public int getResultDataSentViaInternetProtocol() {
        if (this.dataSentViaInternetProtocolFailed) {
            return 2;
        }
        if (this.dataSentViaInternetProtocolSuceeded) {
            return 1;
        }
        return 0;
    }

    public int getResultDataSentViaInbandModem() {
        if (this.dataSentViaInbandModemFailed) {
            return 2;
        }
        if (this.dataSentViaInbandModemSuceeded) {
            return 1;
        }
        return 0;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.dataSentViaInbandModemFailed ? 1231 : 1237);
        n = 31 * n + (this.dataSentViaInbandModemSuceeded ? 1231 : 1237);
        n = 31 * n + (this.dataSentViaInternetProtocolFailed ? 1231 : 1237);
        n = 31 * n + (this.dataSentViaInternetProtocolSuceeded ? 1231 : 1237);
        n = 31 * n + (this.mininumDataSetReceptionAcknowledgedFailed ? 1231 : 1237);
        n = 31 * n + (this.mininumDataSetReceptionAcknowledgedSuceeded ? 1231 : 1237);
        n = 31 * n + (this.mininumDataSetSentViaSmsFailed ? 1231 : 1237);
        n = 31 * n + (this.mininumDataSetSentViaSmsSuceeded ? 1231 : 1237);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        MdsTransmissionResult mdsTransmissionResult = (MdsTransmissionResult)object;
        if (this.dataSentViaInbandModemFailed != mdsTransmissionResult.dataSentViaInbandModemFailed) {
            return false;
        }
        if (this.dataSentViaInbandModemSuceeded != mdsTransmissionResult.dataSentViaInbandModemSuceeded) {
            return false;
        }
        if (this.dataSentViaInternetProtocolFailed != mdsTransmissionResult.dataSentViaInternetProtocolFailed) {
            return false;
        }
        if (this.dataSentViaInternetProtocolSuceeded != mdsTransmissionResult.dataSentViaInternetProtocolSuceeded) {
            return false;
        }
        if (this.mininumDataSetReceptionAcknowledgedFailed != mdsTransmissionResult.mininumDataSetReceptionAcknowledgedFailed) {
            return false;
        }
        if (this.mininumDataSetReceptionAcknowledgedSuceeded != mdsTransmissionResult.mininumDataSetReceptionAcknowledgedSuceeded) {
            return false;
        }
        if (this.mininumDataSetSentViaSmsFailed != mdsTransmissionResult.mininumDataSetSentViaSmsFailed) {
            return false;
        }
        return this.mininumDataSetSentViaSmsSuceeded == mdsTransmissionResult.mininumDataSetSentViaSmsSuceeded;
    }

    public String toString() {
        return new StringBuffer().append("MdsTransmissionResult [mininumDataSetSentViaSmsSuceeded=").append(this.mininumDataSetSentViaSmsSuceeded).append(", mininumDataSetSentViaSmsFailed=").append(this.mininumDataSetSentViaSmsFailed).append(", mininumDataSetReceptionAcknowledgedSuceeded=").append(this.mininumDataSetReceptionAcknowledgedSuceeded).append(", mininumDataSetReceptionAcknowledgedFailed=").append(this.mininumDataSetReceptionAcknowledgedFailed).append(", dataSentViaInternetProtocolSuceeded=").append(this.dataSentViaInternetProtocolSuceeded).append(", dataSentViaInternetProtocolFailed=").append(this.dataSentViaInternetProtocolFailed).append(", dataSentViaInbandModemSuceeded=").append(this.dataSentViaInbandModemSuceeded).append(", dataSentViaInbandModemFailed=").append(this.dataSentViaInbandModemFailed).append("]").toString();
    }
}

