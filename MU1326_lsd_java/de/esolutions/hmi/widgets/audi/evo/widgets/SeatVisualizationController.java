/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISeatRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SeatVisualizationArrowStateMachine;

public class SeatVisualizationController
extends AbstractWidgetController {
    public static final int SEAT_LEFT = 0;
    public static final int SEAT_RIGHT = 1;
    public static final int NUMBER_OF_SEAT_SIDES = 2;
    public static final int SEATFUNCTION_MASSAGE = 0;
    public static final int SEATFUNCTION_GURTHOEHE = 1;
    public static final int SEATFUNCTION_LEHNENKOPF = 2;
    public static final int SEATFUNCTION_LORDOSE = 3;
    public static final int SEATFUNCTION_SEITENWANGEN = 4;
    public static final int SEATFUNCTION_SITZTIEFE = 5;
    public static final int NUMBER_OF_SEAT_FUNCTIONS = 6;
    public static final int MASSAGE_PROGRAM_NONE = 0;
    public static final int MASSAGE_PROGRAM_WELLE = 1;
    public static final int MASSAGE_PROGRAM_KLOPFEN = 2;
    public static final int MASSAGE_PROGRAM_STRETCH = 3;
    public static final int MASSAGE_PROGRAM_RUECKEN = 4;
    public static final int MASSAGE_PROGRAM_SCHULTER = 5;
    public static final int MASSAGE_PROGRAM_KNETEN = 6;
    public static final int NUMBER_OF_MASSAGE_PROGRAMS = 7;
    public static final int ITEM_INDEX_NONE = -1;
    private ISeatRenderer renderer;
    private int side;
    private int selectedSeatFunction;
    private int selectedMassageProgram;
    private boolean[] seatFunctionAvailable;
    private boolean[] massageProgramAvailable;
    private SeatVisualizationArrowStateMachine arrowStateMachine;
    private int arrowUpState;
    private int arrowDownState;
    private int arrowForwardState;
    private int arrowBackwardState;
    private int[] massageTextIds;

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(ISeatRenderer iSeatRenderer) {
        this.renderer = iSeatRenderer;
    }

    protected void initializeWidget() {
        super.initializeWidget();
        this.seatFunctionAvailable = new boolean[6];
        this.massageProgramAvailable = new boolean[7];
        this.arrowStateMachine = new SeatVisualizationArrowStateMachine(logChannelSeat);
        if (this.model == null || !(this.model instanceof TiledListModelGUI)) {
            logChannelSeat.log(10000, "SeatVisualizationController#initializeWidget: only models of type TiledListModelGUI are supported");
            return;
        }
        this.updateSelectedItem();
        TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)this.model;
        for (int i2 = 0; i2 < 12; ++i2) {
            if (tiledListModelGUI.getGuiRow(i2) != null) {
                this.updateAvailability(tiledListModelGUI.getGuiRow(i2).getUniqueID(), true);
                continue;
            }
            logChannelSeat.log(100000, "SeatVisualizationController#initializeWidget: listmodel row %1 is null", (long)i2);
        }
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (!(this.model instanceof TiledListModelGUI)) {
            logChannelSeat.log(10000, "SeatVisualizationController#processModelUpdateEvent: only models of type TiledListModelGUI are supported");
            return;
        }
        if (modelUpdateEvent.getUpdateType() == 22) {
            logChannelSeat.log(10000000, "SeatVisualizationController#processModelUpdateEvent: Selection changed");
            this.updateSelectedItem();
            this.setCompositesDirty(true);
            modelUpdateEvent.consume();
        }
        if (modelUpdateEvent.getUpdateType() == 8) {
            logChannelSeat.log(10000000, "SeatVisualizationController#processModelUpdateEvent: Row changed");
            this.updateItemData(modelUpdateEvent);
            modelUpdateEvent.consume();
            this.setCompositesDirty(true);
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    private int rowIDToSeatFunction(long l) {
        int n = this.idToFunctionInternal(l);
        if (n == -1) {
            n = 0;
        }
        return n;
    }

    private int idToFunctionInternal(long l) {
        if (l == 1L) {
            return 1;
        }
        if (l == 2L) {
            return 2;
        }
        if (l == 3L) {
            return 3;
        }
        if (l == 4L) {
            return 4;
        }
        if (l == 5L) {
            return 5;
        }
        return -1;
    }

    private int rowIDToMassageProgram(long l) {
        int n = this.idToProgramInternal(l);
        if (n == -1) {
            logChannelSeat.log(10000, "SeatVisualizationController#updateSelected: unsupported rowID %1 in ListModel", l);
            n = 0;
        }
        return n;
    }

    private int idToProgramInternal(long l) {
        if (l == 101L) {
            return 0;
        }
        if (l == 102L) {
            return 2;
        }
        if (l == 103L) {
            return 4;
        }
        if (l == 104L) {
            return 5;
        }
        if (l == 105L) {
            return 1;
        }
        if (l == 106L) {
            return 3;
        }
        if (l == 107L) {
            return 6;
        }
        return -1;
    }

    protected void updateSelectedItem() {
        TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)this.model;
        SelectedItem selectedItem = tiledListModelGUI.getSelected();
        if (selectedItem == null) {
            logChannelSeat.log(100000, "SeatVisualizationController#updateSelected: selectedItem of list model is null");
            return;
        }
        long l = selectedItem.getUniqueID();
        this.selectedSeatFunction = this.rowIDToSeatFunction(l);
        if (this.selectedSeatFunction == 0) {
            int n = this.selectedMassageProgram;
            this.selectedMassageProgram = this.rowIDToMassageProgram(l);
            this.updateMassageIntensity(l, n != this.selectedMassageProgram);
        }
        this.updateArrowStates(l);
    }

    private void updateItemData(ModelUpdateEvent modelUpdateEvent) {
        long l = modelUpdateEvent.getClientData3().getLong(ModelUpdateData.Key.UNIQUEID);
        this.updateAvailability(l, false);
        if (this.rowIDToSeatFunction(l) == this.selectedSeatFunction) {
            if (this.selectedSeatFunction == 0) {
                this.updateMassageIntensity(l, false);
            }
            this.updateArrowStates(l);
        }
    }

    protected void updateAvailability(long l, boolean bl) {
        int n;
        TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)this.model;
        GuiListRow guiListRow = tiledListModelGUI.getGuiRow(tiledListModelGUI.getIndexForUniqueID(l));
        if (guiListRow.getColumnCount() < 7) {
            logChannelSeat.log(100000, "SeatVisualizationController#updateModelRow: not enough columns available in rowID %1", l);
            return;
        }
        boolean bl2 = guiListRow.getInteger(0) != 0;
        int n2 = this.idToFunctionInternal(l);
        if (n2 != -1) {
            this.seatFunctionAvailable[n2] = bl2;
        }
        if ((n = this.idToProgramInternal(l)) != -1) {
            this.massageProgramAvailable[n] = bl2;
            this.seatFunctionAvailable[0] = bl ? this.seatFunctionAvailable[0] | bl2 : bl2;
        }
    }

    protected void updateMassageIntensity(long l, boolean bl) {
        TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)this.model;
        GuiListRow guiListRow = tiledListModelGUI.getGuiRow(tiledListModelGUI.getIndexForUniqueID(l));
        if (guiListRow == null) {
            logChannelSeat.log(10000, "SeatVisualizationController#updateMassageIntensity row %1 not available in model %2", l, (long)tiledListModelGUI.getID());
            return;
        }
        this.arrowStateMachine.updateMaxIntensity(guiListRow.getInteger(6));
        int n = guiListRow.getInteger(1);
        if (bl) {
            this.arrowStateMachine.setIntensity(n);
        } else {
            this.arrowStateMachine.updateIntensity(n);
        }
    }

    protected void updateArrowStates(long l) {
        TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)this.model;
        GuiListRow guiListRow = tiledListModelGUI.getGuiRow(tiledListModelGUI.getIndexForUniqueID(l));
        if (guiListRow == null) {
            logChannelSeat.log(10000, "SeatVisualizationController#updateArrowStates row %1 not available in model %2", l, (long)tiledListModelGUI.getID());
            return;
        }
        logChannelSeat.log(10000000, "SeatVisualizationController#updateArrowStates row: %1", l);
        if (this.selectedSeatFunction == 0) {
            this.arrowUpState = 1;
            this.arrowDownState = 1;
            if (this.selectedMassageProgram == 0) {
                this.arrowForwardState = 0;
                this.arrowBackwardState = 0;
            } else {
                this.arrowForwardState = this.arrowStateMachine.getIncArrowState();
                this.arrowBackwardState = this.arrowStateMachine.getDecArrowState();
            }
        } else {
            this.arrowUpState = guiListRow.getInteger(2);
            this.arrowDownState = guiListRow.getInteger(3);
            this.arrowForwardState = guiListRow.getInteger(4);
            this.arrowBackwardState = guiListRow.getInteger(5);
        }
    }

    public int getSide() {
        return this.side;
    }

    public void setSide(int n) {
        this.side = n;
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (this.renderer != null) {
            this.renderer.setVisible(bl);
        }
    }

    public int getSelectedSeatFunction() {
        return this.selectedSeatFunction;
    }

    public int getSelectedMassageProgram() {
        return this.selectedMassageProgram;
    }

    public boolean isSeatFunctionAvailable(int n) {
        return this.isItemAvailable(n, this.seatFunctionAvailable);
    }

    public boolean isMassageProgramAvailable(int n) {
        return this.isItemAvailable(n, this.massageProgramAvailable);
    }

    private boolean isItemAvailable(int n, boolean[] blArray) {
        return blArray != null && n > -1 && n < blArray.length && blArray[n];
    }

    public int getSeatFunctionSlot(int n, boolean bl) {
        return this.getItemSlot(n, this.seatFunctionAvailable, bl);
    }

    public int getMassageProgramSlot(int n, boolean bl) {
        return this.getItemSlot(n, this.massageProgramAvailable, bl);
    }

    private int getItemSlot(int n, boolean[] blArray, boolean bl) {
        int n2 = 0;
        if (this.isItemAvailable(n, blArray)) {
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this.isItemAvailable(i2, blArray)) continue;
                ++n2;
            }
        } else if (!bl) {
            n2 = -1;
        }
        return n2;
    }

    public int getMassageIntensity() {
        return this.arrowStateMachine.getIntensity();
    }

    public int getArrowUpState() {
        return this.arrowUpState;
    }

    public int getArrowDownState() {
        return this.arrowDownState;
    }

    public int getArrowForwardState() {
        return this.arrowForwardState;
    }

    public int getArrowBackwardState() {
        return this.arrowBackwardState;
    }

    public void setTextIds(int[] nArray) {
        this.massageTextIds = nArray;
    }

    public String getMassageText(int n) {
        if (this.massageTextIds == null) {
            switch (n) {
                case 0: {
                    return "Aus";
                }
                case 1: {
                    return "Welle";
                }
                case 2: {
                    return "Klopfen";
                }
                case 3: {
                    return "Stretch";
                }
                case 4: {
                    return "Ruecken";
                }
                case 5: {
                    return "Schulter";
                }
            }
            return "Leer";
        }
        if (this.massageTextIds != null && n >= 0 && n < this.massageTextIds.length) {
            int n2 = this.massageTextIds[n];
            if (this.getInitContext() != null && this.getInitContext().getScreenFactory() != null) {
                return this.getInitContext().getScreenFactory().getText(n2);
            }
            return "";
        }
        return "";
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (this.terminal != null && this.terminal.getCarCodingHelper() != null && this.terminal.getCarCodingHelper().isR8()) {
            this.setOnScreen(true);
            this.setCompositesDirty(true);
        }
    }

    public void predisconnecting() {
        super.predisconnecting();
        if (this.terminal != null && this.terminal.getCarCodingHelper() != null && this.terminal.getCarCodingHelper().isR8()) {
            this.renderer.setVisible(false);
        }
    }
}

