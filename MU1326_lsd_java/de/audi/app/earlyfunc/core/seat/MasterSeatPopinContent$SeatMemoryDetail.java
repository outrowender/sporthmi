/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

public class MasterSeatPopinContent$SeatMemoryDetail {
    public static final int INVALID_MODEL_VALUE;
    public static final MasterSeatPopinContent$SeatMemoryDetail MEMORYDETAIL_MEMORY_NONE;
    public static final MasterSeatPopinContent$SeatMemoryDetail MEMORYDETAIL_ON_OFF_MEMORY_BLOCKED;
    public static final MasterSeatPopinContent$SeatMemoryDetail MEMORYDETAIL_ON_OFF_MEMORY_NOT_BLOCKED;
    public static final MasterSeatPopinContent$SeatMemoryDetail MEMORYDETAIL_PROGRAM_PRESS_ON_OFF;
    public static final MasterSeatPopinContent$SeatMemoryDetail MEMORYDETAIL_PROGRAM_PRESS_PROGRAM;
    public static final MasterSeatPopinContent$SeatMemoryDetail MEMORYDETAIL_PROGRAM_PRESS_SET;
    public static final MasterSeatPopinContent$SeatMemoryDetail MEMORYDETAIL_SET_PRESS_ON_OFF;
    public static final MasterSeatPopinContent$SeatMemoryDetail MEMORYDETAIL_SET_PRESS_PROGRAM;
    private static final MasterSeatPopinContent$SeatMemoryDetail[] ALL_SEAT_MEMORY_DETAILS;
    private final int memoryDetailID;
    private final int modelValue;
    private final String memoryDetailName;

    private MasterSeatPopinContent$SeatMemoryDetail(int n, String string, int n2) {
        this.memoryDetailID = n;
        this.memoryDetailName = string;
        this.modelValue = n2;
    }

    public int getMemoryDetailID() {
        return this.memoryDetailID;
    }

    public String getMemoryDetailName() {
        return this.memoryDetailName;
    }

    public int getModelValue() {
        return this.modelValue;
    }

    public boolean equals(Object object) {
        return object instanceof MasterSeatPopinContent$SeatMemoryDetail && this.equalsSeatMemoryDetail((MasterSeatPopinContent$SeatMemoryDetail)object);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.memoryDetailID;
        return n;
    }

    public boolean equalsSeatMemoryDetail(MasterSeatPopinContent$SeatMemoryDetail masterSeatPopinContent$SeatMemoryDetail) {
        return this.getMemoryDetailID() == masterSeatPopinContent$SeatMemoryDetail.getMemoryDetailID();
    }

    public String toString() {
        return this.getMemoryDetailName();
    }

    public static MasterSeatPopinContent$SeatMemoryDetail getMemoryDetailForID(int n) {
        if (n < ALL_SEAT_MEMORY_DETAILS.length && n > 0) {
            return ALL_SEAT_MEMORY_DETAILS[n];
        }
        return MEMORYDETAIL_MEMORY_NONE;
    }

    static {
        MEMORYDETAIL_MEMORY_NONE = new MasterSeatPopinContent$SeatMemoryDetail(0, "MEMORYDETAIL_MEMORY_NONE", -1);
        MEMORYDETAIL_ON_OFF_MEMORY_BLOCKED = new MasterSeatPopinContent$SeatMemoryDetail(1, "MEMORYDETAIL_ON_OFF_MEMORY_BLOCKED", -1);
        MEMORYDETAIL_ON_OFF_MEMORY_NOT_BLOCKED = new MasterSeatPopinContent$SeatMemoryDetail(2, "MEMORYDETAIL_ON_OFF_MEMORY_NOT_BLOCKED", -1);
        MEMORYDETAIL_PROGRAM_PRESS_ON_OFF = new MasterSeatPopinContent$SeatMemoryDetail(5, "MEMORYDETAIL_PROGRAM_PRESS_ON_OFF", -1);
        MEMORYDETAIL_PROGRAM_PRESS_PROGRAM = new MasterSeatPopinContent$SeatMemoryDetail(7, "MEMORYDETAIL_PROGRAM_PRESS_PROGRAM", 2);
        MEMORYDETAIL_PROGRAM_PRESS_SET = new MasterSeatPopinContent$SeatMemoryDetail(6, "MEMORYDETAIL_PROGRAM_PRESS_SET", 1);
        MEMORYDETAIL_SET_PRESS_ON_OFF = new MasterSeatPopinContent$SeatMemoryDetail(4, "MEMORYDETAIL_SET_PRESS_ON_OFF", -1);
        MEMORYDETAIL_SET_PRESS_PROGRAM = new MasterSeatPopinContent$SeatMemoryDetail(3, "MEMORYDETAIL_SET_PRESS_PROGRAM", 0);
        ALL_SEAT_MEMORY_DETAILS = new MasterSeatPopinContent$SeatMemoryDetail[]{MEMORYDETAIL_MEMORY_NONE, MEMORYDETAIL_ON_OFF_MEMORY_BLOCKED, MEMORYDETAIL_ON_OFF_MEMORY_NOT_BLOCKED, MEMORYDETAIL_SET_PRESS_PROGRAM, MEMORYDETAIL_SET_PRESS_ON_OFF, MEMORYDETAIL_PROGRAM_PRESS_ON_OFF, MEMORYDETAIL_PROGRAM_PRESS_SET, MEMORYDETAIL_PROGRAM_PRESS_PROGRAM};
    }
}

