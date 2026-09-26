/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class GeneralInfoSwitches_Status$Modification
implements BAPEntity {
    private static final int RESERVED_BIT_6__7_BITSIZE;
    public boolean onlineTrafficCanBeModified;
    public boolean vicsOnOffCanBeModified;
    public boolean tmcOnOffCanBeModfied;
    public boolean jpTrafficOnOffCanBeModified;
    public boolean rdsOnOffCanBeModified;
    public boolean tpTaOnCanBeModified;
    private static final int MODIFICATION_BITSIZE;

    public GeneralInfoSwitches_Status$Modification() {
        this.internalReset();
        this.customInitialization();
    }

    public GeneralInfoSwitches_Status$Modification(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.onlineTrafficCanBeModified = false;
        this.vicsOnOffCanBeModified = false;
        this.tmcOnOffCanBeModfied = false;
        this.jpTrafficOnOffCanBeModified = false;
        this.rdsOnOffCanBeModified = false;
        this.tpTaOnCanBeModified = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        GeneralInfoSwitches_Status$Modification generalInfoSwitches_Status$Modification = (GeneralInfoSwitches_Status$Modification)bAPEntity;
        return this.onlineTrafficCanBeModified == generalInfoSwitches_Status$Modification.onlineTrafficCanBeModified && this.vicsOnOffCanBeModified == generalInfoSwitches_Status$Modification.vicsOnOffCanBeModified && this.tmcOnOffCanBeModfied == generalInfoSwitches_Status$Modification.tmcOnOffCanBeModfied && this.jpTrafficOnOffCanBeModified == generalInfoSwitches_Status$Modification.jpTrafficOnOffCanBeModified && this.rdsOnOffCanBeModified == generalInfoSwitches_Status$Modification.rdsOnOffCanBeModified && this.tpTaOnCanBeModified == generalInfoSwitches_Status$Modification.tpTaOnCanBeModified;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Modification:");
        stringBuffer.append("\n - Bit 5: ");
        if (this.onlineTrafficCanBeModified) {
            stringBuffer.append("true  (online traffic can be modified (DF4.1)");
        } else {
            stringBuffer.append("false  (online traffic cannot be modified (DF4.1)");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.vicsOnOffCanBeModified) {
            stringBuffer.append("true  (VICS ON/OFF can be modified");
        } else {
            stringBuffer.append("false  (VICS ON/OFF cannot be modified");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.tmcOnOffCanBeModfied) {
            stringBuffer.append("true  (TMC ON/OFF can be modfied");
        } else {
            stringBuffer.append("false  (TMC ON/OFF cannot be modified");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.jpTrafficOnOffCanBeModified) {
            stringBuffer.append("true  (JP Traffic ON/OFF can be modified");
        } else {
            stringBuffer.append("false  (JP Traffic ON/OFF cannot be modified");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.rdsOnOffCanBeModified) {
            stringBuffer.append("true  (RDS ON/OFF can be modified");
        } else {
            stringBuffer.append("false  (RDS ON/OFF cannot be modfied");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.tpTaOnCanBeModified) {
            stringBuffer.append("true  (TP / TA ON can be modified");
        } else {
            stringBuffer.append("false  (TP / TA ON cannot be modified");
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
        bitStream.pushBoolean(this.onlineTrafficCanBeModified);
        bitStream.pushBoolean(this.vicsOnOffCanBeModified);
        bitStream.pushBoolean(this.tmcOnOffCanBeModfied);
        bitStream.pushBoolean(this.jpTrafficOnOffCanBeModified);
        bitStream.pushBoolean(this.rdsOnOffCanBeModified);
        bitStream.pushBoolean(this.tpTaOnCanBeModified);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(2);
        this.onlineTrafficCanBeModified = bitStream.popFrontBoolean();
        this.vicsOnOffCanBeModified = bitStream.popFrontBoolean();
        this.tmcOnOffCanBeModfied = bitStream.popFrontBoolean();
        this.jpTrafficOnOffCanBeModified = bitStream.popFrontBoolean();
        this.rdsOnOffCanBeModified = bitStream.popFrontBoolean();
        this.tpTaOnCanBeModified = bitStream.popFrontBoolean();
    }
}

