/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SemidynamicRouteGuidance_Status$Delay
implements BAPEntity {
    public int minute;
    private static final int MINUTE_BITSIZE;
    public int hour;
    private static final int HOUR_BITSIZE;

    public SemidynamicRouteGuidance_Status$Delay() {
        this.internalReset();
        this.customInitialization();
    }

    public SemidynamicRouteGuidance_Status$Delay(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.minute = 0;
        this.hour = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SemidynamicRouteGuidance_Status$Delay semidynamicRouteGuidance_Status$Delay = (SemidynamicRouteGuidance_Status$Delay)bAPEntity;
        return this.minute == semidynamicRouteGuidance_Status$Delay.minute && this.hour == semidynamicRouteGuidance_Status$Delay.hour;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Delay:");
        stringBuffer.append("\n - Minute - ");
        stringBuffer.append(this.minute);
        stringBuffer.append("\n - Hour - ");
        stringBuffer.append(this.hour);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.minute);
        bitStream.pushByte((byte)this.hour);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.minute = bitStream.popFrontByte();
        this.hour = bitStream.popFrontByte();
    }
}

