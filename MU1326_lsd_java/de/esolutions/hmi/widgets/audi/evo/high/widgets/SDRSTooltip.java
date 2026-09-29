/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.intercommunication.SDRSTooltipConstants;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.metrics.Distance;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MapOverlayPlateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MapOverlayPlateController;

public class SDRSTooltip
extends LayoutContainerController
implements SDRSTooltipConstants {
    private static final int ORIGINAL_ROUTE;
    private static final int BETTER_ROUTE;
    public static final int DETAILS_BUTTON;
    private static final int TEXT_DELAY;
    private static final int TEXT_TIMESAVING;
    private static final int TEXT_CLOSED_ROAD;
    private static final int TEXT_ONLY_ONE_DETOUR;
    private static final int TEXT_MORE_DETOUR;
    private static final int HEIGHT;
    private static final int WIDTH;
    private static final int TEXT_WIDTH;
    private static final int WIDTH_G24;
    private static final int TEXT_WIDTH_G24;
    private boolean isSetUp = false;
    private IconController tooltipIcon;
    private LabelController labelLine1;
    private ListCell[] listCells;
    private int selectedItemIndex = -1;
    private String textTimeDelay = "";
    private String textTimeSaving = "";
    private int numberOfDetours = 0;
    private int selectedDetour = 0;
    private int distanceToDetour = 0;
    private int[] textIDs;

    @Override
    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        if (!this.isSetUp) {
            this.setUpWidget();
        }
        super.connected(initializationContext);
        this.updateContent();
    }

    private static int getIntValue(ListCell[] listCellArray, int n) {
        if (listCellArray[n] instanceof IntegerListCell) {
            return ((IntegerListCell)listCellArray[n]).getValue();
        }
        mapOverlayLogCh.log(10000, "SDRSTooltip#getIntValue IntegerListCell expected, but received %1", (Object)listCellArray[n]);
        return -1;
    }

    private static String getStringValue(ListCell[] listCellArray, int n) {
        if (listCellArray[n] instanceof TextListCell) {
            return ((TextListCell)listCellArray[n]).getText();
        }
        mapOverlayLogCh.log(10000, "SDRSTooltip#getStringValue TextListCell expected, but received %1", (Object)listCellArray[n]);
        return "";
    }

    private String getText(int n) {
        if (this.textIDs != null && 0 <= n && n < this.textIDs.length) {
            return this.getInitContext().getScreenFactory().getText(this.textIDs[n]);
        }
        return "";
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        mapOverlayLogCh.log(-2137614336, "SDRSTooltip#processModelUpdateEvent Model-ID %1, Typ %2", (long)modelUpdateEvent.getModelId(), (long)modelUpdateEvent.getUpdateType());
        switch (modelUpdateEvent.getUpdateType()) {
            case 6: 
            case 8: 
            case 10: {
                this.updateContent();
                break;
            }
            case 2: {
                break;
            }
        }
    }

    private void setUpWidget() {
        if (!this.isSetUp) {
            this.isSetUp = true;
            MapOverlayPlateController mapOverlayPlateController = new MapOverlayPlateController();
            MapOverlayPlateRendererHigh mapOverlayPlateRendererHigh = new MapOverlayPlateRendererHigh(mapOverlayPlateController);
            mapOverlayPlateController.setRenderer(mapOverlayPlateRendererHigh);
            mapOverlayPlateController.setBounds(0, 0, this.isG24MMIKombi() ? 387 : 684, 44);
            ((AbstractWidgetController)this).add(mapOverlayPlateController);
            this.tooltipIcon = new IconController();
            IconRendererHigh iconRendererHigh = new IconRendererHigh(this.tooltipIcon);
            this.tooltipIcon.setRenderer(iconRendererHigh);
            this.tooltipIcon.setBitmaps(this.getBitmapIndices());
            ((AbstractWidgetController)this).add(this.tooltipIcon);
            this.tooltipIcon.setBounds(5, 6, 0, 0);
            this.labelLine1 = new LabelController();
            LabelRendererHigh labelRendererHigh = new LabelRendererHigh(this.labelLine1);
            this.labelLine1.setRenderer(labelRendererHigh);
            ((AbstractWidgetController)this).add(this.labelLine1);
            this.labelLine1.setBounds(40, 12, this.isG24MMIKombi() ? 336 : 663, 50);
        }
    }

    protected boolean isG24MMIKombi() {
        return AbstractWidget.isScreenResolution1440();
    }

    public void setTextIds(int[] nArray) {
        this.textIDs = nArray;
    }

    private static String replaceString(String string, String string2, String string3) {
        int n = string.indexOf(string2);
        if (n != -1) {
            return new StringBuffer().append(string.substring(0, n)).append(string3).append(string.substring(n + 2, string.length())).toString();
        }
        mapOverlayLogCh.log(-2137614336, "SDRSTooltip#updateContent There's no placeholder contained in the text %1.", (Object)string);
        return string;
    }

    private void updateContent() {
        if (!this.isSetUp) {
            mapOverlayLogCh.log(-2137614336, "SDRSTooltip#updateContent Widget is not set up.");
            return;
        }
        if (!(this.model instanceof ListModelGUI)) {
            mapOverlayLogCh.log(10000, "SDRSTooltip#updateContent Model is not a list model, but %1.", this.model);
            return;
        }
        int n = ((ListModelGUI)this.model).getMaxColumns();
        if (n >= 7) {
            if (this.listCells == null) {
                this.listCells = new ListCell[n];
            }
            if (((ListModelGUI)this.model).getRow(0, this.listCells)) {
                this.selectedItemIndex = SDRSTooltip.getIntValue(this.listCells, 0);
                this.textTimeDelay = SDRSTooltip.getStringValue(this.listCells, 1);
                this.textTimeSaving = SDRSTooltip.getStringValue(this.listCells, 2);
                this.numberOfDetours = SDRSTooltip.getIntValue(this.listCells, 3);
                int n2 = SDRSTooltip.getIntValue(this.listCells, 4);
                this.selectedDetour = SDRSTooltip.getIntValue(this.listCells, 5);
                this.distanceToDetour = SDRSTooltip.getIntValue(this.listCells, 6);
                if (0 <= this.selectedItemIndex && this.selectedItemIndex <= 1) {
                    this.tooltipIcon.setValue(this.selectedItemIndex);
                    this.tooltipIcon.setOnScreen(true);
                } else {
                    this.tooltipIcon.setOnScreen(false);
                }
                String string = "";
                if (this.selectedItemIndex == 1 && n2 == 1) {
                    string = this.getText(2);
                    mapOverlayLogCh.log(-2137614336, "SDRSTooltip#updateContent Selected route %1 contains a closed road.", (long)this.selectedItemIndex);
                } else if (this.selectedItemIndex == 2) {
                    int n3 = this.selectedDetour;
                    int n4 = this.distanceToDetour;
                    Distance distance = new Distance(n4, 5);
                    if (this.numberOfDetours == 1) {
                        string = this.getText(3);
                        string = SDRSTooltip.replaceString(string, "%1", distance.formatByMode(1));
                    } else {
                        string = this.getText(4);
                        string = SDRSTooltip.replaceString(string, "%1", Integer.toString(n3));
                        string = SDRSTooltip.replaceString(string, "%2", distance.formatByMode(1));
                    }
                } else {
                    string = this.getText(this.selectedItemIndex == 0 ? 0 : 1);
                    String string2 = this.selectedItemIndex == 0 ? this.textTimeDelay : this.textTimeSaving;
                    string = SDRSTooltip.replaceString(string, "%1", string2);
                }
                if (this.selectedItemIndex > 1) {
                    mapOverlayLogCh.log(-2137614336, "SDRSTooltip#updateContent Route index %1 is not valid.", (long)this.selectedItemIndex);
                }
                this.labelLine1.setModel(string);
                this.labelLine1.updateContent();
            }
        } else {
            mapOverlayLogCh.log(10000, "SDRSTooltip#updateContent Expected %1 columns, but model has %2 columns.", (long)0, (long)n);
        }
    }
}

