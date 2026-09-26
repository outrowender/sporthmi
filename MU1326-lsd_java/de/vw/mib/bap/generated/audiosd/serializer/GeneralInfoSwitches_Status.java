/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.audiosd.serializer.GeneralInfoSwitches_OnOffSwitches;
import de.vw.mib.bap.generated.audiosd.serializer.GeneralInfoSwitches_Status$Modification;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class GeneralInfoSwitches_Status
implements StatusProperty {
    public final GeneralInfoSwitches_OnOffSwitches onOffSwitches = new GeneralInfoSwitches_OnOffSwitches();
    public final GeneralInfoSwitches_Status$Modification modification = new GeneralInfoSwitches_Status$Modification();

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

    @Override
    public void reset() {
        this.internalReset();
        this.onOffSwitches.reset();
        this.modification.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        GeneralInfoSwitches_Status generalInfoSwitches_Status = (GeneralInfoSwitches_Status)bAPEntity;
        return this.onOffSwitches.equalTo(generalInfoSwitches_Status.onOffSwitches) && this.modification.equalTo(generalInfoSwitches_Status.modification);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("GeneralInfoSwitches_Status:");
        stringBuffer.append("\n - OnOffSwitches - ");
        stringBuffer.append(this.onOffSwitches.toString());
        stringBuffer.append("\n - Modification - ");
        stringBuffer.append(this.modification.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.onOffSwitches.bitSize();
        return n += this.modification.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.onOffSwitches.serialize(bitStream);
        this.modification.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.onOffSwitches.deserialize(bitStream);
        this.modification.deserialize(bitStream);
    }

    public static int functionId() {
        return 25;
    }

    @Override
    public int getFunctionId() {
        return GeneralInfoSwitches_Status.functionId();
    }
}

