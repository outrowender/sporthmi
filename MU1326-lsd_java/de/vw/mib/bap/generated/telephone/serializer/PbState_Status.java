/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PbState_Status
implements StatusProperty {
    public int downloadState;
    private static final int DOWNLOAD_STATE_BITSIZE;
    public static final int DOWNLOAD_STATE_NO_PHONE_BOOK_AVAILABLE;
    public static final int DOWNLOAD_STATE_CURRENTLY_BEING_LOADED;
    public static final int DOWNLOAD_STATE_COMPLETELY_LOADED_FROM_MOBILE_TO_UHV;
    public static final int DOWNLOAD_STATE_INCOMPLETELY_LOADED_DOWNLOADED_ENTRIES_AVAILABLE;
    public static final int DOWNLOAD_STATE_DOWNLOAD_ABORTED_ONLY_TEMPORARY_INDICATION;
    public int pbEntriesUhv;
    private static final int PB_ENTRIES_UHV_BITSIZE;

    public PbState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PbState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.downloadState = 0;
        this.pbEntriesUhv = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PbState_Status pbState_Status = (PbState_Status)bAPEntity;
        return this.downloadState == pbState_Status.downloadState && this.pbEntriesUhv == pbState_Status.pbEntriesUhv;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PbState_Status:");
        stringBuffer.append("\n - DownloadState: ");
        switch (this.downloadState) {
            case 0: {
                stringBuffer.append("0x00 (no phone book available)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (currently being loaded)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (completely loaded (from mobile to UHV))");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (incompletely loaded (from mobile to UHV), downloaded entries available)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (download aborted (last known phone book will be used, if available), only temporary indication (will be reset by FSG after 1000ms))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - PbEntriesUHV - ");
        stringBuffer.append(this.pbEntriesUhv);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.downloadState);
        bitStream.pushShort((short)this.pbEntriesUhv);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.downloadState = bitStream.popFrontByte();
        this.pbEntriesUhv = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 51;
    }

    @Override
    public int getFunctionId() {
        return PbState_Status.functionId();
    }
}

