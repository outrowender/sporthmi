/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.eni.serializer.ActiveTrip_OriginGpsposition;
import de.vw.mib.bap.generated.eni.serializer.ActiveTrip_StartTime;
import de.vw.mib.bap.generated.eni.serializer.ActiveTrip_StopTime;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveTrip_Status
implements StatusProperty {
    public int tripstate;
    public static final int TRIPSTATE_STOP_TRIP_STOPPED = 4;
    public static final int TRIPSTATE_PENDING_ACTIVE_TRIP_AFTER_CLAMP15_CYCLE = 3;
    public static final int TRIPSTATE_ACTIVE_TRIP_IS_ACTIVE_AND_STARTED = 2;
    public static final int TRIPSTATE_INIT_NEW_TRIP_CREATED_NOT_STARTED = 1;
    public static final int TRIPSTATE_DEFAULT_TRIP_NOT_STARTED = 0;
    public int olbtripList_Reference;
    public static final int OLBTRIP_LIST_REFERENCE_MIN = 1;
    public ActiveTrip_OriginGpsposition originGpsposition = new ActiveTrip_OriginGpsposition();
    public ActiveTrip_StartTime startTime = new ActiveTrip_StartTime();
    public ActiveTrip_StopTime stopTime = new ActiveTrip_StopTime();
    public int mileageAtStart;
    public static final int MILEAGE_AT_START_MIN = 1;
    public int mileageAtStop;
    public static final int MILEAGE_AT_STOP_MIN = 1;
    public int mileageUnit;
    public static final int MILEAGE_UNIT_UNIT_MLS = 1;
    public static final int MILEAGE_UNIT_UNIT_KM = 0;

    public ActiveTrip_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveTrip_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.tripstate = 0;
        this.olbtripList_Reference = 1;
        this.mileageAtStart = 1;
        this.mileageAtStop = 1;
        this.mileageUnit = 0;
    }

    public void reset() {
        this.internalReset();
        this.originGpsposition.reset();
        this.startTime.reset();
        this.stopTime.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveTrip_Status activeTrip_Status = (ActiveTrip_Status)bAPEntity;
        return this.tripstate == activeTrip_Status.tripstate && this.olbtripList_Reference == activeTrip_Status.olbtripList_Reference && this.originGpsposition.equalTo(activeTrip_Status.originGpsposition) && this.startTime.equalTo(activeTrip_Status.startTime) && this.stopTime.equalTo(activeTrip_Status.stopTime) && this.mileageAtStart == activeTrip_Status.mileageAtStart && this.mileageAtStop == activeTrip_Status.mileageAtStop && this.mileageUnit == activeTrip_Status.mileageUnit;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActiveTrip_Status");
        stringBuffer.append("\n - tripstate:" + this.tripstate);
        stringBuffer.append("\n - olbtripList_Reference:" + this.olbtripList_Reference);
        stringBuffer.append("\n - originGpsposition:" + this.originGpsposition.toString());
        stringBuffer.append("\n - startTime:" + this.startTime.toString());
        stringBuffer.append("\n - stopTime:" + this.stopTime.toString());
        stringBuffer.append("\n - mileageAtStart:" + this.mileageAtStart);
        stringBuffer.append("\n - mileageAtStop:" + this.mileageAtStop);
        stringBuffer.append("\n - mileageUnit:" + this.mileageUnit);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.tripstate);
        bitStream.pushByte((byte)this.olbtripList_Reference);
        this.originGpsposition.serialize(bitStream);
        this.startTime.serialize(bitStream);
        this.stopTime.serialize(bitStream);
        bitStream.pushInt(this.mileageAtStart);
        bitStream.pushInt(this.mileageAtStop);
        bitStream.pushByte((byte)this.mileageUnit);
    }

    public void deserialize(BitStream bitStream) {
        this.tripstate = bitStream.popFrontByte();
        this.olbtripList_Reference = bitStream.popFrontByte();
        this.originGpsposition.deserialize(bitStream);
        this.startTime.deserialize(bitStream);
        this.stopTime.deserialize(bitStream);
        this.mileageAtStart = bitStream.popFrontInt();
        this.mileageAtStop = bitStream.popFrontInt();
        this.mileageUnit = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 33;
    }

    public int getFunctionId() {
        return ActiveTrip_Status.functionId();
    }
}

