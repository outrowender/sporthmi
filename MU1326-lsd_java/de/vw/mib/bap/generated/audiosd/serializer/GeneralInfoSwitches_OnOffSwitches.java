/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class GeneralInfoSwitches_OnOffSwitches
implements BAPEntity {
    private static final int RESERVED_BIT_6__7_BITSIZE;
    public boolean onlineTrafficOn;
    public boolean vicsOn;
    public boolean tmcOn;
    public boolean jpTrafficOn;
    public boolean rdsOn;
    public boolean tpTaOn;
    private static final int GENERAL_INFO_SWITCHES_ON_OFF_SWITCHES_BITSIZE;

    public GeneralInfoSwitches_OnOffSwitches() {
        this.internalReset();
        this.customInitialization();
    }

    public GeneralInfoSwitches_OnOffSwitches(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.onlineTrafficOn = false;
        this.vicsOn = false;
        this.tmcOn = false;
        this.jpTrafficOn = false;
        this.rdsOn = false;
        this.tpTaOn = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        GeneralInfoSwitches_OnOffSwitches generalInfoSwitches_OnOffSwitches = (GeneralInfoSwitches_OnOffSwitches)bAPEntity;
        return this.onlineTrafficOn == generalInfoSwitches_OnOffSwitches.onlineTrafficOn && this.vicsOn == generalInfoSwitches_OnOffSwitches.vicsOn && this.tmcOn == generalInfoSwitches_OnOffSwitches.tmcOn && this.jpTrafficOn == generalInfoSwitches_OnOffSwitches.jpTrafficOn && this.rdsOn == generalInfoSwitches_OnOffSwitches.rdsOn && this.tpTaOn == generalInfoSwitches_OnOffSwitches.tpTaOn;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("GeneralInfoSwitches_OnOffSwitches:");
        stringBuffer.append("\n - Bit 5: ");
        if (this.onlineTrafficOn) {
            stringBuffer.append("true  (online traffic ON (DF4.1)");
        } else {
            stringBuffer.append("false  (online traffic OFF (DF4.1)");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.vicsOn) {
            stringBuffer.append("true  (VICS ON");
        } else {
            stringBuffer.append("false  (VICS OFF");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.tmcOn) {
            stringBuffer.append("true  (TMC ON");
        } else {
            stringBuffer.append("false  (TMC OFF");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.jpTrafficOn) {
            stringBuffer.append("true  (JP traffic ON (dynamic)");
        } else {
            stringBuffer.append("false  (JP traffic OFF");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.rdsOn) {
            stringBuffer.append("true  (RDS ON");
        } else {
            stringBuffer.append("false  (RDS OFF");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.tpTaOn) {
            stringBuffer.append("true  (TP / TA ON");
        } else {
            stringBuffer.append("false  (TP / TA OFF");
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
        bitStream.resetBits(2);
        bitStream.pushBoolean(this.onlineTrafficOn);
        bitStream.pushBoolean(this.vicsOn);
        bitStream.pushBoolean(this.tmcOn);
        bitStream.pushBoolean(this.jpTrafficOn);
        bitStream.pushBoolean(this.rdsOn);
        bitStream.pushBoolean(this.tpTaOn);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(2);
        this.onlineTrafficOn = bitStream.popFrontBoolean();
        this.vicsOn = bitStream.popFrontBoolean();
        this.tmcOn = bitStream.popFrontBoolean();
        this.jpTrafficOn = bitStream.popFrontBoolean();
        this.rdsOn = bitStream.popFrontBoolean();
        this.tpTaOn = bitStream.popFrontBoolean();
    }
}

