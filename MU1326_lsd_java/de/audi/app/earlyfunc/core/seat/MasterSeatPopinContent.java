/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.ISeatPopinModelRow;

public class MasterSeatPopinContent
implements ISeatPopinModelRow {
    public static final int CONFIG_TYPE_NONE = 0;
    public static final int CONFIG_TYPE_VISUALIZATION = 1;
    public static final int CONFIG_TYPE_SEAT_MEMORY = 2;
    public static final int CONFIG_TYPE_MASSAGE = 3;
    public static final int ARROW_DIMENSION_NONE = 0;
    public static final int ARROW_DIMENSION_HORIZONTAL = 1;
    public static final int ARROW_DIMENSION_VERTICAL = 2;
    public static final int ARROW_DIMENSION_BOTH = 3;
    private final int seatContentID;
    private final String seatContentName;
    private final long rowID;
    private final int voConfigType;
    private final int arrowDimension;
    public static final MasterSeatPopinContent NONE = new MasterSeatPopinContent(0, "NONE", 0, -1L, 0);
    public static final MasterSeatPopinContent GURTHOEHE = new MasterSeatPopinContent(1, "GURTHOEHE", 1, 1L, 2);
    public static final MasterSeatPopinContent LEHNENKOPF = new MasterSeatPopinContent(2, "LEHNENKOPF", 1, 2L, 1);
    public static final MasterSeatPopinContent LORDORSE = new MasterSeatPopinContent(3, "LORDOSE", 1, 3L, 3);
    public static final MasterSeatPopinContent SEITENWANGEN = new MasterSeatPopinContent(4, "SEITENWANGEN", 1, 4L, 3);
    public static final MasterSeatPopinContent SITZTIEFE = new MasterSeatPopinContent(5, "SITZTIEFE", 1, 5L, 1);
    public static final MasterSeatPopinContent MASSAGE = new MasterSeatPopinContent(6, "MASSAGE", 3, -1L, 3);
    public static final MasterSeatPopinContent MEMORY = new MasterSeatPopinContent(7, "MEMORY", 2, -1L, 0);
    private static final MasterSeatPopinContent[] ALL_SEAT_POPIN_CONTENTS = new MasterSeatPopinContent[]{NONE, GURTHOEHE, LEHNENKOPF, LORDORSE, SEITENWANGEN, SITZTIEFE, MASSAGE, MEMORY};

    private MasterSeatPopinContent(int n, String string, int n2, long l, int n3) {
        this.seatContentID = n;
        this.seatContentName = string;
        this.voConfigType = n2;
        this.rowID = l;
        this.arrowDimension = n3;
    }

    public boolean equals(Object object) {
        return object instanceof MasterSeatPopinContent && this.equalsMasterSeatPopinContent((MasterSeatPopinContent)object);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.seatContentID;
        return n;
    }

    public boolean equalsMasterSeatPopinContent(MasterSeatPopinContent masterSeatPopinContent) {
        return this.seatContentID == masterSeatPopinContent.getSeatContentID();
    }

    public int getSeatContentID() {
        return this.seatContentID;
    }

    public String getSeatContentName() {
        return this.seatContentName;
    }

    public int getVoConfigType() {
        return this.voConfigType;
    }

    public long getRowID() {
        return this.rowID;
    }

    public boolean hasValidRowID() {
        return this.rowID != -1L;
    }

    public int getArrowDimension() {
        return this.arrowDimension;
    }

    public boolean usesVOConfigType(int n) {
        return this.voConfigType == n;
    }

    public String toString() {
        return this.getSeatContentName();
    }

    public static MasterSeatPopinContent[] getAllSeatPopinContents() {
        return ALL_SEAT_POPIN_CONTENTS;
    }

    public static MasterSeatPopinContent getContentForID(int n) {
        if (n < ALL_SEAT_POPIN_CONTENTS.length && n > 0) {
            return ALL_SEAT_POPIN_CONTENTS[n];
        }
        return NONE;
    }

    public static class MassageProgram
    implements ISeatPopinModelRow {
        private final int dsiProgramNr;
        private final String programName;
        private final long rowID;
        public static final MassageProgram MASSAGE_PROGRAM_NONE = new MassageProgram(0, "MASSAGE_PROGRAM_NONE", 101L);
        public static final MassageProgram MASSAGE_PROGRAM_WELLE = new MassageProgram(1, "MASSAGE_PROGRAM_WELLE", 105L);
        public static final MassageProgram MASSAGE_PROGRAM_KLOPFEN = new MassageProgram(2, "MASSAGE_PROGRAM_KLOPFEN", 102L);
        public static final MassageProgram MASSAGE_PROGRAM_STRETCH = new MassageProgram(3, "MASSAGE_PROGRAM_STRETCH", 106L);
        public static final MassageProgram MASSAGE_PROGRAM_RUECKEN = new MassageProgram(4, "MASSAGE_PROGRAM_RUECKEN", 103L);
        public static final MassageProgram MASSAGE_PROGRAM_SCHULTER = new MassageProgram(5, "MASSAGE_PROGRAM_SCHULTER", 104L);
        public static final MassageProgram MASSAGE_PROGRAM_KNETEN = new MassageProgram(6, "MASSAGE_PROGRAM_KNETEN", 107L);
        private static final MassageProgram[] ALL_MASSAGE_PROGRAMS = new MassageProgram[]{MASSAGE_PROGRAM_NONE, MASSAGE_PROGRAM_WELLE, MASSAGE_PROGRAM_KLOPFEN, MASSAGE_PROGRAM_STRETCH, MASSAGE_PROGRAM_RUECKEN, MASSAGE_PROGRAM_SCHULTER, MASSAGE_PROGRAM_KNETEN};

        private MassageProgram(int n, String string, long l) {
            this.dsiProgramNr = n;
            this.programName = string;
            this.rowID = l;
        }

        public boolean equals(Object object) {
            return object instanceof MassageProgram && this.equalsMassageProgram((MassageProgram)object);
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + this.dsiProgramNr;
            return n;
        }

        public boolean equalsMassageProgram(MassageProgram massageProgram) {
            return this.getDsiProgramNr() == massageProgram.getDsiProgramNr();
        }

        public String toString() {
            return this.getProgramName();
        }

        public int getDsiProgramNr() {
            return this.dsiProgramNr;
        }

        public String getProgramName() {
            return this.programName;
        }

        public long getRowID() {
            return this.rowID;
        }

        public static MassageProgram[] getAllMassagePrograms() {
            return ALL_MASSAGE_PROGRAMS;
        }

        public static MassageProgram getMassageProgramForID(int n) {
            if (n < ALL_MASSAGE_PROGRAMS.length && n > 0) {
                return ALL_MASSAGE_PROGRAMS[n];
            }
            return MASSAGE_PROGRAM_NONE;
        }
    }

    public static class SeatMemoryDetail {
        public static final int INVALID_MODEL_VALUE = -1;
        public static final SeatMemoryDetail MEMORYDETAIL_MEMORY_NONE = new SeatMemoryDetail(0, "MEMORYDETAIL_MEMORY_NONE", -1);
        public static final SeatMemoryDetail MEMORYDETAIL_ON_OFF_MEMORY_BLOCKED = new SeatMemoryDetail(1, "MEMORYDETAIL_ON_OFF_MEMORY_BLOCKED", -1);
        public static final SeatMemoryDetail MEMORYDETAIL_ON_OFF_MEMORY_NOT_BLOCKED = new SeatMemoryDetail(2, "MEMORYDETAIL_ON_OFF_MEMORY_NOT_BLOCKED", -1);
        public static final SeatMemoryDetail MEMORYDETAIL_PROGRAM_PRESS_ON_OFF = new SeatMemoryDetail(5, "MEMORYDETAIL_PROGRAM_PRESS_ON_OFF", -1);
        public static final SeatMemoryDetail MEMORYDETAIL_PROGRAM_PRESS_PROGRAM = new SeatMemoryDetail(7, "MEMORYDETAIL_PROGRAM_PRESS_PROGRAM", 2);
        public static final SeatMemoryDetail MEMORYDETAIL_PROGRAM_PRESS_SET = new SeatMemoryDetail(6, "MEMORYDETAIL_PROGRAM_PRESS_SET", 1);
        public static final SeatMemoryDetail MEMORYDETAIL_SET_PRESS_ON_OFF = new SeatMemoryDetail(4, "MEMORYDETAIL_SET_PRESS_ON_OFF", -1);
        public static final SeatMemoryDetail MEMORYDETAIL_SET_PRESS_PROGRAM = new SeatMemoryDetail(3, "MEMORYDETAIL_SET_PRESS_PROGRAM", 0);
        private static final SeatMemoryDetail[] ALL_SEAT_MEMORY_DETAILS = new SeatMemoryDetail[]{MEMORYDETAIL_MEMORY_NONE, MEMORYDETAIL_ON_OFF_MEMORY_BLOCKED, MEMORYDETAIL_ON_OFF_MEMORY_NOT_BLOCKED, MEMORYDETAIL_SET_PRESS_PROGRAM, MEMORYDETAIL_SET_PRESS_ON_OFF, MEMORYDETAIL_PROGRAM_PRESS_ON_OFF, MEMORYDETAIL_PROGRAM_PRESS_SET, MEMORYDETAIL_PROGRAM_PRESS_PROGRAM};
        private final int memoryDetailID;
        private final int modelValue;
        private final String memoryDetailName;

        private SeatMemoryDetail(int n, String string, int n2) {
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
            return object instanceof SeatMemoryDetail && this.equalsSeatMemoryDetail((SeatMemoryDetail)object);
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + this.memoryDetailID;
            return n;
        }

        public boolean equalsSeatMemoryDetail(SeatMemoryDetail seatMemoryDetail) {
            return this.getMemoryDetailID() == seatMemoryDetail.getMemoryDetailID();
        }

        public String toString() {
            return this.getMemoryDetailName();
        }

        public static SeatMemoryDetail getMemoryDetailForID(int n) {
            if (n < ALL_SEAT_MEMORY_DETAILS.length && n > 0) {
                return ALL_SEAT_MEMORY_DETAILS[n];
            }
            return MEMORYDETAIL_MEMORY_NONE;
        }
    }
}

