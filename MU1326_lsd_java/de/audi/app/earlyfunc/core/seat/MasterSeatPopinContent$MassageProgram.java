/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.ISeatPopinModelRow;

public class MasterSeatPopinContent$MassageProgram
implements ISeatPopinModelRow {
    private final int dsiProgramNr;
    private final String programName;
    private final long rowID;
    public static final MasterSeatPopinContent$MassageProgram MASSAGE_PROGRAM_NONE = new MasterSeatPopinContent$MassageProgram(0, "MASSAGE_PROGRAM_NONE", 0);
    public static final MasterSeatPopinContent$MassageProgram MASSAGE_PROGRAM_WELLE = new MasterSeatPopinContent$MassageProgram(1, "MASSAGE_PROGRAM_WELLE", 0);
    public static final MasterSeatPopinContent$MassageProgram MASSAGE_PROGRAM_KLOPFEN = new MasterSeatPopinContent$MassageProgram(2, "MASSAGE_PROGRAM_KLOPFEN", 0);
    public static final MasterSeatPopinContent$MassageProgram MASSAGE_PROGRAM_STRETCH = new MasterSeatPopinContent$MassageProgram(3, "MASSAGE_PROGRAM_STRETCH", 0);
    public static final MasterSeatPopinContent$MassageProgram MASSAGE_PROGRAM_RUECKEN = new MasterSeatPopinContent$MassageProgram(4, "MASSAGE_PROGRAM_RUECKEN", 0);
    public static final MasterSeatPopinContent$MassageProgram MASSAGE_PROGRAM_SCHULTER = new MasterSeatPopinContent$MassageProgram(5, "MASSAGE_PROGRAM_SCHULTER", 0);
    public static final MasterSeatPopinContent$MassageProgram MASSAGE_PROGRAM_KNETEN = new MasterSeatPopinContent$MassageProgram(6, "MASSAGE_PROGRAM_KNETEN", 0);
    private static final MasterSeatPopinContent$MassageProgram[] ALL_MASSAGE_PROGRAMS = new MasterSeatPopinContent$MassageProgram[]{MASSAGE_PROGRAM_NONE, MASSAGE_PROGRAM_WELLE, MASSAGE_PROGRAM_KLOPFEN, MASSAGE_PROGRAM_STRETCH, MASSAGE_PROGRAM_RUECKEN, MASSAGE_PROGRAM_SCHULTER, MASSAGE_PROGRAM_KNETEN};

    private MasterSeatPopinContent$MassageProgram(int n, String string, long l) {
        this.dsiProgramNr = n;
        this.programName = string;
        this.rowID = l;
    }

    public boolean equals(Object object) {
        return object instanceof MasterSeatPopinContent$MassageProgram && this.equalsMassageProgram((MasterSeatPopinContent$MassageProgram)object);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.dsiProgramNr;
        return n;
    }

    public boolean equalsMassageProgram(MasterSeatPopinContent$MassageProgram masterSeatPopinContent$MassageProgram) {
        return this.getDsiProgramNr() == masterSeatPopinContent$MassageProgram.getDsiProgramNr();
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

    @Override
    public long getRowID() {
        return this.rowID;
    }

    public static MasterSeatPopinContent$MassageProgram[] getAllMassagePrograms() {
        return ALL_MASSAGE_PROGRAMS;
    }

    public static MasterSeatPopinContent$MassageProgram getMassageProgramForID(int n) {
        if (n < ALL_MASSAGE_PROGRAMS.length && n > 0) {
            return ALL_MASSAGE_PROGRAMS[n];
        }
        return MASSAGE_PROGRAM_NONE;
    }
}

