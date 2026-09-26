/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.epg.sdars.AbstractProgramSdarsEpgListRow;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.sdars.EPGDescription;

class SDARSEPGHandler$DescriptionScreenHelper {
    private final LabelModelApp detailLabelStationName;
    private final LabelModelApp detailLabelPeriod;
    private final LabelModelApp detailLabelProgramName;
    private final LabelModelApp detailLabelDescription;
    private final ChoiceModelApp detailChoiceActiveProgram;
    private static final int DETAIL_NOT_ACTIVE_PROGRAM;
    private static final int DETAIL_ACTIVE_PROGRAM;
    private AbstractProgramSdarsEpgListRow programRowToShowDetailsFor;
    private StationInfoExt currentSelectedStation;
    private int programRowIndexToShowDetailsFor;

    public SDARSEPGHandler$DescriptionScreenHelper(TunerBasics tunerBasics) {
        TunerModels tunerModels = tunerBasics.getModels();
        this.detailLabelStationName = tunerModels.getLabelModel(92930304);
        this.detailLabelPeriod = tunerModels.getLabelModel(1401487616);
        this.detailLabelProgramName = tunerModels.getLabelModel(76153088);
        this.detailLabelDescription = tunerModels.getLabelModel(445251840);
        this.detailChoiceActiveProgram = tunerModels.getChoiceModel(-1635188480);
    }

    public void setChannelName(String string) {
        this.detailLabelStationName.setText(string);
    }

    public void initFor(AbstractProgramSdarsEpgListRow abstractProgramSdarsEpgListRow, int n, StationInfoExt stationInfoExt) {
        this.programRowToShowDetailsFor = abstractProgramSdarsEpgListRow;
        this.programRowIndexToShowDetailsFor = n;
        this.currentSelectedStation = stationInfoExt;
        this.setChannelName(abstractProgramSdarsEpgListRow.getChannelName());
        this.detailLabelPeriod.setText(abstractProgramSdarsEpgListRow.getFormatedPerid());
        this.detailLabelProgramName.setText(abstractProgramSdarsEpgListRow.getLongProgramName());
        this.detailLabelDescription.setText("");
        this.detailChoiceActiveProgram.setValue(0);
        this.detailLabelDescription.setStatus(0);
    }

    public void updateEPGDescriptionIfMatches(EPGDescription ePGDescription) {
        if (this.programRowToShowDetailsFor != null && this.programRowToShowDetailsFor.getSID() == ePGDescription.sID && this.programRowToShowDetailsFor.getProgramID() == ePGDescription.programID) {
            Buffer buffer = new Buffer(ePGDescription.seriesDescription.length() + ePGDescription.programDescription.length() + 2);
            if (!Utilities.isEmpty(ePGDescription.seriesDescription)) {
                buffer.append(ePGDescription.seriesDescription).append("\n\n");
            }
            buffer.append(ePGDescription.programDescription);
            this.detailLabelDescription.setText(buffer.toString());
            this.detailLabelDescription.setStatus(1);
            this.detailChoiceActiveProgram.setValue(this.programRowIndexToShowDetailsFor == 0 && this.currentSelectedStation.getSID() == ePGDescription.sID ? 1 : 0);
        }
    }

    public void updateTimeZoneOffset(long l) {
        if (this.programRowToShowDetailsFor != null) {
            this.programRowToShowDetailsFor.updateTimesWithTimezoneOffset(l);
            this.detailLabelPeriod.setText(this.programRowToShowDetailsFor.getFormatedPerid());
        }
    }
}

