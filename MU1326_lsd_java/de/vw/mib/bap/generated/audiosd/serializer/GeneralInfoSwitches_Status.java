/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.audiosd.serializer.GeneralInfoSwitches_OnOffSwitches;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class GeneralInfoSwitches_Status
implements StatusProperty {
    public final GeneralInfoSwitches_OnOffSwitches onOffSwitches = new GeneralInfoSwitches_OnOffSwitches();
    public final Modification modification = new Modification();

    public GeneralInfoSwitches_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public GeneralInfoSwitches_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.onOffSwitches.reset();
        this.modification.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        GeneralInfoSwitches_Status generalInfoSwitches_Status = (GeneralInfoSwitches_Status)bAPEntity;
        return this.onOffSwitches.equalTo(generalInfoSwitches_Status.onOffSwitches) && this.modification.equalTo(generalInfoSwitches_Status.modification);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("GeneralInfoSwitches_Status:");
        stringBuffer.append("\n - OnOffSwitches - ");
        stringBuffer.append(this.onOffSwitches.toString());
        stringBuffer.append("\n - Modification - ");
        stringBuffer.append(this.modification.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.onOffSwitches.bitSize();
        return n += this.modification.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.onOffSwitches.serialize(bitStream);
        this.modification.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.onOffSwitches.deserialize(bitStream);
        this.modification.deserialize(bitStream);
    }

    public static int functionId() {
        return 25;
    }

    public int getFunctionId() {
        return GeneralInfoSwitches_Status.functionId();
    }

    public static final class Modification
    implements BAPEntity {
        private static final int RESERVED_BIT_6__7_BITSIZE = 2;
        public boolean onlineTrafficCanBeModified;
        public boolean vicsOnOffCanBeModified;
        public boolean tmcOnOffCanBeModfied;
        public boolean jpTrafficOnOffCanBeModified;
        public boolean rdsOnOffCanBeModified;
        public boolean tpTaOnCanBeModified;
        private static final int MODIFICATION_BITSIZE = 8;

        public Modification() {
            this.internalReset();
            this.customInitialization();
        }

        public Modification(BitStream bitStream) {
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

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Modification modification = (Modification)bAPEntity;
            return this.onlineTrafficCanBeModified == modification.onlineTrafficCanBeModified && this.vicsOnOffCanBeModified == modification.vicsOnOffCanBeModified && this.tmcOnOffCanBeModfied == modification.tmcOnOffCanBeModfied && this.jpTrafficOnOffCanBeModified == modification.jpTrafficOnOffCanBeModified && this.rdsOnOffCanBeModified == modification.rdsOnOffCanBeModified && this.tpTaOnCanBeModified == modification.tpTaOnCanBeModified;
        }

        private void customInitialization() {
        }

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

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(2);
            bitStream.pushBoolean(this.onlineTrafficCanBeModified);
            bitStream.pushBoolean(this.vicsOnOffCanBeModified);
            bitStream.pushBoolean(this.tmcOnOffCanBeModfied);
            bitStream.pushBoolean(this.jpTrafficOnOffCanBeModified);
            bitStream.pushBoolean(this.rdsOnOffCanBeModified);
            bitStream.pushBoolean(this.tpTaOnCanBeModified);
        }

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
}

