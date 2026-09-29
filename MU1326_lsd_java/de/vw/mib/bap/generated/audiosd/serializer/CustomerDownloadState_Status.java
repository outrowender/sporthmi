/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CustomerDownloadState_Status
implements StatusProperty {
    public int customerDownloadState;
    private static final int CUSTOMER_DOWNLOAD_STATE_BITSIZE;
    public static final int CUSTOMER_DOWNLOAD_STATE_NO_CUSTOMER_DOWNLOAD_ACTIVE;
    public static final int CUSTOMER_DOWNLOAD_STATE_CUSTOMER_DOWNLOAD_ACTIVE_ONGOING;
    public static final int CUSTOMER_DOWNLOAD_STATE_CUSTOMER_DOWNLOAD_FAILED;
    public static final int CUSTOMER_DOWNLOAD_STATE_CUSTOMER_DOWNLOAD_PAUSED;
    public int progressCustomerDownload;
    private static final int PROGRESS_CUSTOMER_DOWNLOAD_BITSIZE;

    public CustomerDownloadState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CustomerDownloadState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.customerDownloadState = 0;
        this.progressCustomerDownload = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CustomerDownloadState_Status customerDownloadState_Status = (CustomerDownloadState_Status)bAPEntity;
        return this.customerDownloadState == customerDownloadState_Status.customerDownloadState && this.progressCustomerDownload == customerDownloadState_Status.progressCustomerDownload;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CustomerDownloadState_Status:");
        stringBuffer.append("\n - CustomerDownloadState: ");
        switch (this.customerDownloadState) {
            case 0: {
                stringBuffer.append("0x00 (no customer download active)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (customer download active/ongoing)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (customer download failed)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (customer download paused)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ProgressCustomerDownload - ");
        stringBuffer.append(this.progressCustomerDownload);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.customerDownloadState);
        bitStream.pushByte((byte)this.progressCustomerDownload);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.customerDownloadState = bitStream.popFrontByte();
        this.progressCustomerDownload = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 48;
    }

    @Override
    public int getFunctionId() {
        return CustomerDownloadState_Status.functionId();
    }
}

