/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class StartEngineAuthentication_Status
implements StatusProperty {
    public final BAPString data = new BAPString(41);
    private static final int MAX_DATA_LENGTH = 41;
    public int status;
    public static final int STATUS_NOT_SUCCESSFUL_NO_IMMOBILIZER_CHALLENGE = 14;
    public static final int STATUS_NOT_SUCCESSFUL_COMMAND_INVALID = 13;
    public static final int STATUS_NOT_SUCCESSFUL_EXECUTION_OF_COMMAND_TIMED_OUT = 12;
    public static final int STATUS_NOT_SUCCESSFUL_WAITING_FOR_COMMAND_TIMED_OUT = 11;
    public static final int STATUS_NOT_SUCCESSFUL_FUNCTIONAL_PRECONDITIONS_VIOLATED_VEHICLE_UNLOCKED = 10;
    public static final int STATUS_NOT_SUCCESSFUL_FUNCTIONAL_PRECONDITIONS_VIOLATED_VEHICLE_IN_MOTION = 9;
    public static final int STATUS_NOT_SUCCESSFUL_FUNCTIONAL_PRECONDITIONS_VIOLATED_CLAMP_15_ACTIVE = 8;
    public static final int STATUS_NOT_SUCCESSFUL_FUNCTIONAL_PRECONDITIONS_VIOLATED = 7;
    public static final int STATUS_SUCCESSFUL_EXECUTION_OF_COMMAND_COMPLETED_RESULT_DATA_AVAILABLE = 6;
    public static final int STATUS_SUCCESSFUL_AUTHENTICATION_DATA_AVAILABLE = 5;
    public static final int STATUS_ABORT_NOT_SUCCESSFUL = 4;
    public static final int STATUS_ABORT_SUCCESSFUL = 3;
    public static final int STATUS_NOT_SUCCESSFUL = 2;
    public static final int STATUS_SUCCESSFUL = 1;
    public static final int STATUS_INIT_UNKNOWN = 0;

    public StartEngineAuthentication_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public StartEngineAuthentication_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.status = 0;
    }

    public void reset() {
        this.internalReset();
        this.data.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        StartEngineAuthentication_Status startEngineAuthentication_Status = (StartEngineAuthentication_Status)bAPEntity;
        return this.data.equalTo(startEngineAuthentication_Status.data) && this.status == startEngineAuthentication_Status.status;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StartEngineAuthentication_Status");
        stringBuffer.append("\n - data:").append(this.data.toString());
        stringBuffer.append("\n - status:").append(this.status);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.data.serialize(bitStream);
        bitStream.pushByte((byte)this.status);
    }

    public void deserialize(BitStream bitStream) {
        this.data.deserialize(bitStream);
        this.status = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 17;
    }

    public int getFunctionId() {
        return StartEngineAuthentication_Status.functionId();
    }
}

