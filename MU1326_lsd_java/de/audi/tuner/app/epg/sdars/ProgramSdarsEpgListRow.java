/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.epg.sdars.AbstractProgramSdarsEpgListRow;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.sdars.EPGProgramInfo;

public class ProgramSdarsEpgListRow
extends AbstractProgramSdarsEpgListRow {
    private static final int INDEX_CHANNEL_NUMBER = 1;
    private static final int INDEX_CHANNEL_NAME = 2;
    private static final int INDEX_PROGRAM_START = 3;
    private static final int INDEX_PROGRAM_END = 4;
    private static final int INDEX_PROGRAM_NAME = 5;
    public static final int PROGRAM_COL_COUNT = 6;

    public ProgramSdarsEpgListRow(StationInfoExt stationInfoExt, EPGProgramInfo ePGProgramInfo, int n, long l) {
        super(1, 6, stationInfoExt, ePGProgramInfo, n, l);
        this.setText(1, Utilities.getFormatedStationNumber(stationInfoExt.stationNumber));
        this.setText(2, stationInfoExt.shortLabel);
        this.setText(5, ProgramSdarsEpgListRow.extractShortProgramName(ePGProgramInfo));
        this.updateTimesWithTimezoneOffset(l);
    }

    protected ProgramSdarsEpgListRow(ProgramSdarsEpgListRow programSdarsEpgListRow) {
        super(programSdarsEpgListRow);
    }

    public EvoListRow copy() {
        return new ProgramSdarsEpgListRow(this);
    }

    public boolean representsStation() {
        return false;
    }

    public boolean representsProgram() {
        return true;
    }

    public String getFormatedPerid() {
        return new Buffer(20).append(this.getText(3)).append(" - ").append(this.getText(4)).toString();
    }

    public void updateTimesWithTimezoneOffset(long l) {
        long l2 = (long)this.programInfo.startTime * 1000L + l;
        long l3 = (long)this.programInfo.endTime * 1000L + l;
        this.setText(3, Utilities.getFormatedTime(l2));
        this.setText(4, Utilities.getFormatedTime(l3));
    }

    protected static String extractShortProgramName(EPGProgramInfo ePGProgramInfo) {
        return Utilities.getFirstNotEmpty(ePGProgramInfo.shortProgramName, ePGProgramInfo.longProgramName);
    }

    protected static String extractLongProgramName(EPGProgramInfo ePGProgramInfo) {
        return Utilities.getFirstNotEmpty(ePGProgramInfo.longProgramName, ePGProgramInfo.shortProgramName);
    }

    public int getActionForSelection(int n) {
        return 2;
    }
}

