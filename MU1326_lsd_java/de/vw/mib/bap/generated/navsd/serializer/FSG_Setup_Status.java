/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.navsd.serializer.FSG_Setup_Status$FunctionSupport;
import de.vw.mib.bap.generated.navsd.serializer.FSG_Setup_Status$Supported_POI_Types;
import de.vw.mib.bap.generated.navsd.serializer.FSG_Setup_Status$VoiceGuidance;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public final FSG_Setup_Status$VoiceGuidance voiceGuidance = new FSG_Setup_Status$VoiceGuidance();
    public final FSG_Setup_Status$Supported_POI_Types supported_Poi_Types = new FSG_Setup_Status$Supported_POI_Types();
    public final FSG_Setup_Status$FunctionSupport functionSupport = new FSG_Setup_Status$FunctionSupport();
    public static final int DUMMY2_MAX;
    public static final int DUMMY2_MIN;
    public int dummy2;
    private static final int DUMMY2_BITSIZE;
    public static final int DUMMY3_MAX;
    public static final int DUMMY3_MIN;
    public int dummy3;
    private static final int DUMMY3_BITSIZE;
    public static final int DUMMY4_MAX;
    public static final int DUMMY4_MIN;
    public int dummy4;
    private static final int DUMMY4_BITSIZE;

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.dummy2 = 0;
        this.dummy3 = 0;
        this.dummy4 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.voiceGuidance.reset();
        this.supported_Poi_Types.reset();
        this.functionSupport.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.voiceGuidance.equalTo(fSG_Setup_Status.voiceGuidance) && this.supported_Poi_Types.equalTo(fSG_Setup_Status.supported_Poi_Types) && this.functionSupport.equalTo(fSG_Setup_Status.functionSupport) && this.dummy2 == fSG_Setup_Status.dummy2 && this.dummy3 == fSG_Setup_Status.dummy3 && this.dummy4 == fSG_Setup_Status.dummy4;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Setup_Status:");
        stringBuffer.append("\n - VoiceGuidance - ");
        stringBuffer.append(this.voiceGuidance.toString());
        stringBuffer.append("\n - Supported_POI_Types - ");
        stringBuffer.append(this.supported_Poi_Types.toString());
        stringBuffer.append("\n - FunctionSupport - ");
        stringBuffer.append(this.functionSupport.toString());
        stringBuffer.append("\n - Dummy2 - ");
        stringBuffer.append(this.dummy2);
        stringBuffer.append("\n - Dummy3 - ");
        stringBuffer.append(this.dummy3);
        stringBuffer.append("\n - Dummy4 - ");
        stringBuffer.append(this.dummy4);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.voiceGuidance.bitSize();
        n += this.supported_Poi_Types.bitSize();
        n += this.functionSupport.bitSize();
        n += 8;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.voiceGuidance.serialize(bitStream);
        this.supported_Poi_Types.serialize(bitStream);
        this.functionSupport.serialize(bitStream);
        bitStream.pushByte((byte)this.dummy2);
        bitStream.pushByte((byte)this.dummy3);
        bitStream.pushByte((byte)this.dummy4);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.voiceGuidance.deserialize(bitStream);
        this.supported_Poi_Types.deserialize(bitStream);
        this.functionSupport.deserialize(bitStream);
        this.dummy2 = bitStream.popFrontByte();
        this.dummy3 = bitStream.popFrontByte();
        this.dummy4 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 53;
    }

    @Override
    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }
}

