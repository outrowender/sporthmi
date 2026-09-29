/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Control_Controlcode
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean fleetModeEnabled;
    public boolean on;
    public boolean setDefault;

    public FSG_Control_Controlcode() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Control_Controlcode(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fleetModeEnabled = false;
        this.on = false;
        this.setDefault = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Control_Controlcode fSG_Control_Controlcode = (FSG_Control_Controlcode)bAPEntity;
        return this.fleetModeEnabled == fSG_Control_Controlcode.fleetModeEnabled && this.on == fSG_Control_Controlcode.on && this.setDefault == fSG_Control_Controlcode.setDefault;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Control_Controlcode");
        stringBuffer.append("\n - fleetModeEnabled:").append(this.fleetModeEnabled);
        stringBuffer.append("\n - on:").append(this.on);
        stringBuffer.append("\n - setDefault:").append(this.setDefault);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.fleetModeEnabled);
        bitStream.pushBoolean(this.on);
        bitStream.pushBoolean(this.setDefault);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this.fleetModeEnabled = bitStream.popFrontBoolean();
        this.on = bitStream.popFrontBoolean();
        this.setDefault = bitStream.popFrontBoolean();
    }
}

