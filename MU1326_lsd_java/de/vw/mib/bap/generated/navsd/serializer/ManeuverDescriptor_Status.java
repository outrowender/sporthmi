/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.navsd.serializer.ManeuverDescriptor_Status$Maneuver_1;
import de.vw.mib.bap.generated.navsd.serializer.ManeuverDescriptor_Status$Maneuver_2;
import de.vw.mib.bap.generated.navsd.serializer.ManeuverDescriptor_Status$Maneuver_3;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ManeuverDescriptor_Status
implements StatusProperty {
    public final ManeuverDescriptor_Status$Maneuver_1 maneuver_1 = new ManeuverDescriptor_Status$Maneuver_1();
    public final ManeuverDescriptor_Status$Maneuver_2 maneuver_2 = new ManeuverDescriptor_Status$Maneuver_2();
    public final ManeuverDescriptor_Status$Maneuver_3 maneuver_3 = new ManeuverDescriptor_Status$Maneuver_3();

    public ManeuverDescriptor_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ManeuverDescriptor_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.maneuver_1.reset();
        this.maneuver_2.reset();
        this.maneuver_3.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ManeuverDescriptor_Status maneuverDescriptor_Status = (ManeuverDescriptor_Status)bAPEntity;
        return this.maneuver_1.equalTo(maneuverDescriptor_Status.maneuver_1) && this.maneuver_2.equalTo(maneuverDescriptor_Status.maneuver_2) && this.maneuver_3.equalTo(maneuverDescriptor_Status.maneuver_3);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ManeuverDescriptor_Status:");
        stringBuffer.append("\n - Maneuver_1 - ");
        stringBuffer.append(this.maneuver_1.toString());
        stringBuffer.append("\n - Maneuver_2 - ");
        stringBuffer.append(this.maneuver_2.toString());
        stringBuffer.append("\n - Maneuver_3 - ");
        stringBuffer.append(this.maneuver_3.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.maneuver_1.bitSize();
        n += this.maneuver_2.bitSize();
        return n += this.maneuver_3.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.maneuver_1.serialize(bitStream);
        this.maneuver_2.serialize(bitStream);
        this.maneuver_3.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.maneuver_1.deserialize(bitStream);
        this.maneuver_2.deserialize(bitStream);
        this.maneuver_3.deserialize(bitStream);
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return ManeuverDescriptor_Status.functionId();
    }
}

