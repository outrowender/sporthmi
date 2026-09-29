/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SourceList_Data$Attributes
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean mediumSupportBrowserList;
    public boolean noImportRunning;
    public boolean mediumIsNotBeingLoaded;
    public boolean mediumIsReadable;
    public boolean mediaIsPlayable;
    public boolean mediumAudioNoError;
    public boolean builtInAndReady;
    private static final int ATTRIBUTES_BITSIZE;

    public SourceList_Data$Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public SourceList_Data$Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.mediumSupportBrowserList = false;
        this.noImportRunning = false;
        this.mediumIsNotBeingLoaded = false;
        this.mediumIsReadable = false;
        this.mediaIsPlayable = false;
        this.mediumAudioNoError = false;
        this.builtInAndReady = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SourceList_Data$Attributes sourceList_Data$Attributes = (SourceList_Data$Attributes)bAPEntity;
        return this.reserved_bit_7 == sourceList_Data$Attributes.reserved_bit_7 && this.mediumSupportBrowserList == sourceList_Data$Attributes.mediumSupportBrowserList && this.noImportRunning == sourceList_Data$Attributes.noImportRunning && this.mediumIsNotBeingLoaded == sourceList_Data$Attributes.mediumIsNotBeingLoaded && this.mediumIsReadable == sourceList_Data$Attributes.mediumIsReadable && this.mediaIsPlayable == sourceList_Data$Attributes.mediaIsPlayable && this.mediumAudioNoError == sourceList_Data$Attributes.mediumAudioNoError && this.builtInAndReady == sourceList_Data$Attributes.builtInAndReady;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attributes:");
        stringBuffer.append("\n - Bit 7: ");
        if (this.reserved_bit_7) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 6: ");
        if (this.mediumSupportBrowserList) {
            stringBuffer.append("true  (medium support browser/list (DF4.2)");
        } else {
            stringBuffer.append("false  (medium not support browser/list (DF4.2)");
        }
        stringBuffer.append("\n - Bit 5: ");
        if (this.noImportRunning) {
            stringBuffer.append("true  (no import running");
        } else {
            stringBuffer.append("false  (import running");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.mediumIsNotBeingLoaded) {
            stringBuffer.append("true  (medium is not being loaded");
        } else {
            stringBuffer.append("false  (medium is being loaded");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.mediumIsReadable) {
            stringBuffer.append("true  (medium is readable");
        } else {
            stringBuffer.append("false  (medium is not readable");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.mediaIsPlayable) {
            stringBuffer.append("true  (media is playable");
        } else {
            stringBuffer.append("false  (medium is not playable (no playable files)");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.mediumAudioNoError) {
            stringBuffer.append("true  (medium/audio no error");
        } else {
            stringBuffer.append("false  (medium/audio source error");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.builtInAndReady) {
            stringBuffer.append("true  (built-in and ready (medium inserted)");
        } else {
            stringBuffer.append("false  (built-in but not ready (medium not inserted)");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.mediumSupportBrowserList);
        bitStream.pushBoolean(this.noImportRunning);
        bitStream.pushBoolean(this.mediumIsNotBeingLoaded);
        bitStream.pushBoolean(this.mediumIsReadable);
        bitStream.pushBoolean(this.mediaIsPlayable);
        bitStream.pushBoolean(this.mediumAudioNoError);
        bitStream.pushBoolean(this.builtInAndReady);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_7 = bitStream.popFrontBoolean();
        this.mediumSupportBrowserList = bitStream.popFrontBoolean();
        this.noImportRunning = bitStream.popFrontBoolean();
        this.mediumIsNotBeingLoaded = bitStream.popFrontBoolean();
        this.mediumIsReadable = bitStream.popFrontBoolean();
        this.mediaIsPlayable = bitStream.popFrontBoolean();
        this.mediumAudioNoError = bitStream.popFrontBoolean();
        this.builtInAndReady = bitStream.popFrontBoolean();
    }
}

