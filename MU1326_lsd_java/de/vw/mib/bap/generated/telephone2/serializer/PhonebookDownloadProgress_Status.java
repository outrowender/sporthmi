/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PhonebookDownloadProgress_Status
implements StatusProperty {
    public int downloadState;
    private static final int DOWNLOAD_STATE_BITSIZE = 8;
    public static final int DOWNLOAD_STATE_NO_PHONE_BOOK_AVAILABLE = 0;
    public static final int DOWNLOAD_STATE_CURRENTLY_BEING_LOADED = 1;
    public static final int DOWNLOAD_STATE_COMPLETELY_LOADED_FROM_MOBILE_TO_FSG = 2;
    public static final int DOWNLOAD_STATE_INCOMPLETELY_LOADED_DOWNLOADED_ENTRIES_AVAILABLE = 3;
    public static final int DOWNLOAD_STATE_DOWNLOAD_ABORTED_ONLY_TEMPORARY_INDICATION = 4;
    public int progressPhonebookDownload;
    private static final int PROGRESS_PHONEBOOK_DOWNLOAD_BITSIZE = 8;
    public int totalPbEntries;
    private static final int TOTAL_PB_ENTRIES_BITSIZE = 16;
    public int currentlyLoadedPbEntries;
    private static final int CURRENTLY_LOADED_PB_ENTRIES_BITSIZE = 16;

    public PhonebookDownloadProgress_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PhonebookDownloadProgress_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.downloadState = 0;
        this.progressPhonebookDownload = 0;
        this.totalPbEntries = 0;
        this.currentlyLoadedPbEntries = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        PhonebookDownloadProgress_Status phonebookDownloadProgress_Status = (PhonebookDownloadProgress_Status)bAPEntity;
        return this.downloadState == phonebookDownloadProgress_Status.downloadState && this.progressPhonebookDownload == phonebookDownloadProgress_Status.progressPhonebookDownload && this.totalPbEntries == phonebookDownloadProgress_Status.totalPbEntries && this.currentlyLoadedPbEntries == phonebookDownloadProgress_Status.currentlyLoadedPbEntries;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PhonebookDownloadProgress_Status:");
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
                stringBuffer.append("0x02 (completely loaded (from mobile to FSG))");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (incompletely loaded (from mobile to FSG), downloaded entries available)");
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
        stringBuffer.append("\n - ProgressPhonebookDownload - ");
        stringBuffer.append(this.progressPhonebookDownload);
        stringBuffer.append("\n - TotalPbEntries - ");
        stringBuffer.append(this.totalPbEntries);
        stringBuffer.append("\n - CurrentlyLoadedPbEntries - ");
        stringBuffer.append(this.currentlyLoadedPbEntries);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 16;
        return n += 16;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.downloadState);
        bitStream.pushByte((byte)this.progressPhonebookDownload);
        bitStream.pushShort((short)this.totalPbEntries);
        bitStream.pushShort((short)this.currentlyLoadedPbEntries);
    }

    public void deserialize(BitStream bitStream) {
        this.downloadState = bitStream.popFrontByte();
        this.progressPhonebookDownload = bitStream.popFrontByte();
        this.totalPbEntries = bitStream.popFrontShort();
        this.currentlyLoadedPbEntries = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 26;
    }

    public int getFunctionId() {
        return PhonebookDownloadProgress_Status.functionId();
    }
}

