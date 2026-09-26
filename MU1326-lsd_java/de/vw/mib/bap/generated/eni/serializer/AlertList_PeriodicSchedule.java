/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class AlertList_PeriodicSchedule
implements BAPEntity {
    public boolean onSunday;
    public boolean onSaturday;
    public boolean onFriday;
    public boolean onThursday;
    public boolean onWednesday;
    public boolean onTuesday;
    public boolean onMonday;
    public boolean periodic;

    public AlertList_PeriodicSchedule() {
        this.internalReset();
        this.customInitialization();
    }

    public AlertList_PeriodicSchedule(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.onSunday = false;
        this.onSaturday = false;
        this.onFriday = false;
        this.onThursday = false;
        this.onWednesday = false;
        this.onTuesday = false;
        this.onMonday = false;
        this.periodic = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AlertList_PeriodicSchedule alertList_PeriodicSchedule = (AlertList_PeriodicSchedule)bAPEntity;
        return this.onSunday == alertList_PeriodicSchedule.onSunday && this.onSaturday == alertList_PeriodicSchedule.onSaturday && this.onFriday == alertList_PeriodicSchedule.onFriday && this.onThursday == alertList_PeriodicSchedule.onThursday && this.onWednesday == alertList_PeriodicSchedule.onWednesday && this.onTuesday == alertList_PeriodicSchedule.onTuesday && this.onMonday == alertList_PeriodicSchedule.onMonday && this.periodic == alertList_PeriodicSchedule.periodic;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AlertList_PeriodicSchedule");
        stringBuffer.append(new StringBuffer().append("\n - onSunday:").append(this.onSunday).toString());
        stringBuffer.append(new StringBuffer().append("\n - onSaturday:").append(this.onSaturday).toString());
        stringBuffer.append(new StringBuffer().append("\n - onFriday:").append(this.onFriday).toString());
        stringBuffer.append(new StringBuffer().append("\n - onThursday:").append(this.onThursday).toString());
        stringBuffer.append(new StringBuffer().append("\n - onWednesday:").append(this.onWednesday).toString());
        stringBuffer.append(new StringBuffer().append("\n - onTuesday:").append(this.onTuesday).toString());
        stringBuffer.append(new StringBuffer().append("\n - onMonday:").append(this.onMonday).toString());
        stringBuffer.append(new StringBuffer().append("\n - periodic:").append(this.periodic).toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.onSunday);
        bitStream.pushBoolean(this.onSaturday);
        bitStream.pushBoolean(this.onFriday);
        bitStream.pushBoolean(this.onThursday);
        bitStream.pushBoolean(this.onWednesday);
        bitStream.pushBoolean(this.onTuesday);
        bitStream.pushBoolean(this.onMonday);
        bitStream.pushBoolean(this.periodic);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.onSunday = bitStream.popFrontBoolean();
        this.onSaturday = bitStream.popFrontBoolean();
        this.onFriday = bitStream.popFrontBoolean();
        this.onThursday = bitStream.popFrontBoolean();
        this.onWednesday = bitStream.popFrontBoolean();
        this.onTuesday = bitStream.popFrontBoolean();
        this.onMonday = bitStream.popFrontBoolean();
        this.periodic = bitStream.popFrontBoolean();
    }
}

