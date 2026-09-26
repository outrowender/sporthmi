/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class NetworkProvider_Status
implements StatusProperty {
    public int networkProviderState;
    private static final int NETWORK_PROVIDER_STATE_BITSIZE;
    public static final int NETWORK_PROVIDER_STATE_NETWORK_PROVIDER_UNKNOWN;
    public static final int NETWORK_PROVIDER_STATE_NETWORK_PROVIDER_NAME_AVAILABLE;
    public final BAPString networkProviderName = new BAPString(40);
    private static final int MAX_NETWORK_PROVIDER_NAME_LENGTH;
    public int serviceProviderState;
    private static final int SERVICE_PROVIDER_STATE_BITSIZE;
    public static final int SERVICE_PROVIDER_STATE_SERVICE_PROVIDER_UNKNOWN;
    public static final int SERVICE_PROVIDER_STATE_SERVICE_PROVIDER_NAME_AVAILABLE;
    public final BAPString serviceProviderName = new BAPString(40);
    private static final int MAX_SERVICE_PROVIDER_NAME_LENGTH;

    public NetworkProvider_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public NetworkProvider_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.networkProviderState = 0;
        this.serviceProviderState = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.networkProviderName.reset();
        this.serviceProviderName.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        NetworkProvider_Status networkProvider_Status = (NetworkProvider_Status)bAPEntity;
        return this.networkProviderState == networkProvider_Status.networkProviderState && this.networkProviderName.equalTo(networkProvider_Status.networkProviderName) && this.serviceProviderState == networkProvider_Status.serviceProviderState && this.serviceProviderName.equalTo(networkProvider_Status.serviceProviderName);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NetworkProvider_Status:");
        stringBuffer.append("\n - NetworkProviderState: ");
        switch (this.networkProviderState) {
            case 0: {
                stringBuffer.append("0x00 (network provider unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (network provider name available)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - NetworkProviderName - ");
        stringBuffer.append(this.networkProviderName.toString());
        stringBuffer.append("\n - ServiceProviderState: ");
        switch (this.serviceProviderState) {
            case 0: {
                stringBuffer.append("0x00 (service provider unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (service provider name available)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ServiceProviderName - ");
        stringBuffer.append(this.serviceProviderName.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += this.networkProviderName.bitSize();
        n += 8;
        return n += this.serviceProviderName.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.networkProviderState);
        this.networkProviderName.serialize(bitStream);
        bitStream.pushByte((byte)this.serviceProviderState);
        this.serviceProviderName.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.networkProviderState = bitStream.popFrontByte();
        this.networkProviderName.deserialize(bitStream);
        this.serviceProviderState = bitStream.popFrontByte();
        this.serviceProviderName.deserialize(bitStream);
    }

    public static int functionId() {
        return 20;
    }

    @Override
    public int getFunctionId() {
        return NetworkProvider_Status.functionId();
    }
}

