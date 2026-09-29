/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.ISeatPopinModelRow;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent$MassageProgram;
import de.audi.app.earlyfunc.core.seat.SeatDisplayContent;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Iterator;

public class SeatPopinModel {
    private final LogChannel logChannel;
    private boolean arePneumaticAvailabilitySettingsActive;
    private final BaseListModelApp seatPopinModel;
    private int intensityRange = 1;
    private MasterSeatPopinContent$MassageProgram tmpProgramSelection = MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_NONE;
    private static final int NOTAVAILABLE;
    private static final int AVAILABLE;
    public static final int ARROW_UP;
    public static final int ARROW_DOWN;
    public static final int ARROW_FORWARD;
    public static final int ARROW_BACKWARD;
    private static final int INVALID;

    public SeatPopinModel(LogChannel logChannel, BaseListModelApp baseListModelApp) {
        this.logChannel = logChannel;
        this.seatPopinModel = baseListModelApp;
    }

    public void init() {
        this.initiallyAddRowsToSeatPopupModel();
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[SeatPopinModel('%1')#init] BaseListModel was initialised with all values set to %2", (long)this.seatPopinModel.getID(), 0L);
        }
    }

    public void deinit() {
        this.seatPopinModel.clearAll();
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[SeatPopinModel('%1')#deinit] BaseListModel was cleared", (long)this.seatPopinModel.getID());
        }
    }

    public boolean arePneumaticAvailabilitySettingsActive() {
        return this.arePneumaticAvailabilitySettingsActive;
    }

    private int getIntensityRange() {
        return this.intensityRange;
    }

    public boolean isIntensityValid(int n) {
        boolean bl;
        boolean bl2 = bl = n > 0 && n <= this.getIntensityRange();
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[SeatPopinModel('%1')#isIntensityValid] received intensity value is %2: intensityRange='%3' , intensity='%4'", (Object)new Integer(this.seatPopinModel.getID()), (Object)(bl ? "valid" : "invalid"), (Object)new Integer(this.getIntensityRange()), (Object)new Integer(n));
        }
        return bl;
    }

    private void setIntensityRange(int n) {
        this.intensityRange = n;
    }

    private MasterSeatPopinContent$MassageProgram getTmpProgramSelection() {
        return this.tmpProgramSelection;
    }

    private void setTmpProgramSelection(MasterSeatPopinContent$MassageProgram masterSeatPopinContent$MassageProgram) {
        this.tmpProgramSelection = masterSeatPopinContent$MassageProgram;
    }

    private void initiallyAddRowsToSeatPopupModel() {
        BaseListModelApp baseListModelApp = this.seatPopinModel.getCopy();
        this.seatPopinModel.setLength(12);
        this.addContentRows(baseListModelApp);
        this.addMassageProgramRows(baseListModelApp);
        this.seatPopinModel.update(baseListModelApp);
    }

    private void addMassageProgramRows(BaseListModelApp baseListModelApp) {
        MasterSeatPopinContent$MassageProgram[] masterSeatPopinContent$MassageProgramArray = MasterSeatPopinContent$MassageProgram.getAllMassagePrograms();
        for (int i2 = 0; i2 < masterSeatPopinContent$MassageProgramArray.length; ++i2) {
            MasterSeatPopinContent$MassageProgram masterSeatPopinContent$MassageProgram = masterSeatPopinContent$MassageProgramArray[i2];
            if (masterSeatPopinContent$MassageProgram.getRowID() == -1L) continue;
            EvoListRow evoListRow = new EvoListRow(masterSeatPopinContent$MassageProgram.getRowID(), 7);
            this.initiallyFillAllColumns(baseListModelApp, evoListRow);
        }
    }

    private void addContentRows(BaseListModelApp baseListModelApp) {
        for (int i2 = 0; i2 < MasterSeatPopinContent.getAllSeatPopinContents().length; ++i2) {
            MasterSeatPopinContent masterSeatPopinContent = MasterSeatPopinContent.getContentForID(i2);
            if (masterSeatPopinContent.getRowID() == -1L) continue;
            EvoListRow evoListRow = new EvoListRow(masterSeatPopinContent.getRowID(), 7);
            this.initiallyFillAllColumns(baseListModelApp, evoListRow);
        }
    }

    private void initiallyFillAllColumns(BaseListModelApp baseListModelApp, EvoListRow evoListRow) {
        for (int i2 = 0; i2 <= 6; ++i2) {
            evoListRow.setInteger(i2, 0);
        }
        baseListModelApp.append(evoListRow);
    }

    public void updateContentAvailability(ArrayList arrayList, boolean bl, int n) {
        if (arrayList != null && !arrayList.isEmpty()) {
            BaseListModelApp baseListModelApp = this.seatPopinModel.getCopy();
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                try {
                    SeatDisplayContent seatDisplayContent = (SeatDisplayContent)iterator.next();
                    EvoListRow evoListRow = this.getRowFromModel(baseListModelApp, seatDisplayContent.getSeatPopinContent(), "updateContentAvailability");
                    if (evoListRow == null) continue;
                    this.updateAllAvailabilityStates(seatDisplayContent, evoListRow);
                    if (seatDisplayContent.getSeatPopinContent().getRowID() > MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_NONE.getRowID()) {
                        evoListRow.setInteger(6, n);
                    }
                    baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(evoListRow.getUniqueID()), evoListRow);
                }
                catch (ClassCastException classCastException) {
                    this.logChannel.log(1000, "[SeatPopinModel('%1')#updateContentAvailability] %2", (Object)new Integer(this.seatPopinModel.getID()), (Object)classCastException.getMessage());
                }
            }
            this.seatPopinModel.update(baseListModelApp);
            this.arePneumaticAvailabilitySettingsActive = bl;
            this.setIntensityRange(n);
        }
    }

    private void updateAllAvailabilityStates(SeatDisplayContent seatDisplayContent, EvoListRow evoListRow) {
        evoListRow.setInteger(0, this.getAvailabilityState(seatDisplayContent.isContentAvailable()));
        evoListRow.setInteger(5, this.getAvailabilityState(seatDisplayContent.areHorizontalArrowsAvailable()));
        evoListRow.setInteger(4, this.getAvailabilityState(seatDisplayContent.areHorizontalArrowsAvailable()));
        evoListRow.setInteger(3, this.getAvailabilityState(seatDisplayContent.areVerticalArrowsAvailable()));
        evoListRow.setInteger(2, this.getAvailabilityState(seatDisplayContent.areVerticalArrowsAvailable()));
    }

    public void selectContent(MasterSeatPopinContent masterSeatPopinContent) {
        long l = MasterSeatPopinContent.MASSAGE.equalsMasterSeatPopinContent(masterSeatPopinContent) ? this.getTmpProgramSelection().getRowID() : masterSeatPopinContent.getRowID();
        boolean bl = this.seatPopinModel.setSelectedUniqueID(l);
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[SeatPopinModel('%1')#selectContent] BaseListModel.setSelectedUniqueID(%2) %3 : content='%4'", (Object)new Integer(this.seatPopinModel.getID()), (Object)new Long(l), (Object)(bl ? "succeeded" : "failed"), (Object)masterSeatPopinContent);
        }
    }

    public void selectMassageProgram(MasterSeatPopinContent$MassageProgram masterSeatPopinContent$MassageProgram, int n) {
        SelectedItem selectedItem;
        if (!MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_NONE.equalsMassageProgram(masterSeatPopinContent$MassageProgram)) {
            this.writeIntensityIntoModel(masterSeatPopinContent$MassageProgram, n);
        }
        if ((selectedItem = this.seatPopinModel.getSelected()) != null && selectedItem.getUniqueID() >= MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_NONE.getRowID()) {
            boolean bl = this.seatPopinModel.setSelectedUniqueID(masterSeatPopinContent$MassageProgram.getRowID());
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1078071040, "[SeatPopinModel('%1')#selectMassageProgram] BaseListModel.setSelectedUniqueID(%2) %3: selected program='%4'", (Object)new Integer(this.seatPopinModel.getID()), (Object)new Long(masterSeatPopinContent$MassageProgram.getRowID()), (Object)(bl ? "succeeded" : "failed"), (Object)masterSeatPopinContent$MassageProgram);
            }
        }
        this.setTmpProgramSelection(masterSeatPopinContent$MassageProgram);
    }

    private void writeIntensityIntoModel(MasterSeatPopinContent$MassageProgram masterSeatPopinContent$MassageProgram, int n) {
        EvoListRow evoListRow;
        if (this.isIntensityValid(n) && (evoListRow = this.getRowFromModel(this.seatPopinModel, masterSeatPopinContent$MassageProgram, "selectMassageProgram")) != null) {
            evoListRow.setInteger(1, n);
            this.seatPopinModel.setRow(this.seatPopinModel.getIndexForUniqueID(evoListRow.getUniqueID()), evoListRow);
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1078071040, "[SeatPopinModel('%1')#writeIntensityIntoModel] intensity='%2', massageProgram='%3' columnIndex='%4'", (Object)new Integer(this.seatPopinModel.getID()), (Object)new Integer(n), (Object)masterSeatPopinContent$MassageProgram, (Object)new Integer(1));
            }
        }
    }

    public void setArrowHighlighting(int n, MasterSeatPopinContent masterSeatPopinContent) {
        EvoListRow evoListRow;
        int n2 = this.getArrowColumnIndex(n);
        if (n2 != -1 && (evoListRow = this.getRowFromModel(this.seatPopinModel, masterSeatPopinContent, "setArrowHighlighting")) != null) {
            evoListRow.setInteger(n2, 2);
            evoListRow.setInteger(this.getColumnIndexOppositeDirection(n2), 1);
            this.seatPopinModel.setRow(this.seatPopinModel.getIndexForUniqueID(evoListRow.getUniqueID()), evoListRow);
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1078071040, "[SeatPopinModel('%1')#setArrowHighlighting] write state ARROW_ICON_HIGHLIGHTED into column '%2' and state ARROW_ICON_AVAILABLE into column '%3': content='%4'", (Object)new Integer(this.seatPopinModel.getID()), (Object)new Integer(n2), (Object)new Integer(this.getColumnIndexOppositeDirection(n2)), (Object)masterSeatPopinContent);
            }
        }
    }

    public void removeArrowHighlighting(int n, MasterSeatPopinContent masterSeatPopinContent) {
        EvoListRow evoListRow;
        int n2 = this.getArrowColumnIndex(n);
        if (n2 != -1 && (evoListRow = this.getRowFromModel(this.seatPopinModel, masterSeatPopinContent, "removeArrowHighlighting")) != null && evoListRow.getInteger(n2) > 1) {
            evoListRow.setInteger(n2, 1);
            this.seatPopinModel.setRow(this.seatPopinModel.getIndexForUniqueID(evoListRow.getUniqueID()), evoListRow);
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1078071040, "[SeatPopinModel('%1')#removeArrowHighlighting] change state ARROW_ICON_HIGHLIGHTED to ARROW_ICON_AVAILABLE: content='%2', column='%3'", (Object)new Integer(this.seatPopinModel.getID()), (Object)masterSeatPopinContent, (Object)new Integer(n2));
            }
        }
    }

    private int getAvailabilityState(boolean bl) {
        return bl ? 1 : 0;
    }

    private EvoListRow getRowFromModel(BaseListModelApp baseListModelApp, ISeatPopinModelRow iSeatPopinModelRow, String string) {
        EvoListRow evoListRow = baseListModelApp.getRow(baseListModelApp.getIndexForUniqueID(iSeatPopinModelRow.getRowID()));
        if (evoListRow == null) {
            this.logChannel.log(-1601830656, "[SeatPopinModel('%1')#%2] BaseListModel contains no row with ID '%3': searched row for content='%4'", (Object)new Integer(this.seatPopinModel.getID()), (Object)string, (Object)new Long(iSeatPopinModelRow.getRowID()), (Object)iSeatPopinModelRow);
        }
        return evoListRow;
    }

    private int getArrowColumnIndex(int n) {
        if (n == 3) {
            return 5;
        }
        if (n == 2) {
            return 4;
        }
        if (n == 1) {
            return 3;
        }
        if (n == 0) {
            return 2;
        }
        return -1;
    }

    private int getColumnIndexOppositeDirection(int n) {
        if (n == 4) {
            return 5;
        }
        if (n == 5) {
            return 4;
        }
        if (n == 2) {
            return 3;
        }
        return 2;
    }
}

