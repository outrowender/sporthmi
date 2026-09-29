/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.intercommunication.RouteBriefingOptionConstants;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MapOverlayPlateController;

public abstract class AbstractRouteCriteriaBoxController
extends LayoutContainerController
implements RouteBriefingOptionConstants {
    protected static final int BITMAP_INDEX_REROUTING_AUTO;
    protected static final int BITMAP_INDEX_REROUTING_MANUAL;
    protected static final int BITMAP_INDEX_REROUTING_OFF;
    protected static final int BITMAP_INDEX_AEA;
    protected static final int BITMAP_INDEX_FERRY;
    protected static final int BITMAP_INDEX_MOTORAIL;
    protected static final int BITMAP_INDEX_TOLL;
    protected static final int BITMAP_INDEX_VIGNETTE;
    protected static final int BITMAP_INDEX_SEASONALLY_RESTRICTED;
    protected static final int BITMAP_INDEX_MOTORWAY;
    protected static final int BITMAP_INDEX_TIME_RESTRICTED;
    protected static final int BITMAP_INDEX_HOV_LANE;
    protected static final int BITMAP_INDEX_HOV_LANE_AVOID;
    protected static final int BITMAP_INDEX_MOTORWAY_ENTRANCE;
    protected static final int BITMAP_INDEX_MOTORWAY_EXIT;
    protected static final int BITMAP_INDEX_TOLL_SEGMENT;
    protected static final int BITMAP_INDEX_TOLL_AMOUNT;
    protected static final int BITMAP_INDEX_SEPARATING_LINE;
    protected MapOverlayPlateController plate;
    protected IconController[] icons;
    private boolean isSetUp = false;
    private boolean isInitialized = false;
    protected int[] itemState;
    protected int[] modelStubs;

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof MapOverlayPlateController) {
            this.plate = (MapOverlayPlateController)abstractWidget;
        }
        super.add(abstractWidget);
    }

    protected static boolean arrayChanged(int[] nArray, int[] nArray2) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] == nArray2[i2]) continue;
            return true;
        }
        return false;
    }

    protected static boolean arrayChanged(String[] stringArray, String[] stringArray2) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (Util.equals(stringArray[i2], stringArray2[i2])) continue;
            return true;
        }
        return false;
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.isInitialized = true;
    }

    protected static IconController createIcon(int[] nArray, int n) {
        return AbstractRouteCriteriaBoxController.createIcon(nArray, new int[]{n});
    }

    protected static IconController createIcon(int[] nArray, int[] nArray2) {
        IconController iconController = new IconController();
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconController.setRenderer(iconRendererHigh);
        if (nArray2 != null) {
            int[] nArray3 = new int[nArray2.length];
            for (int i2 = 0; i2 < nArray3.length; ++i2) {
                int n = nArray2[i2];
                if (0 <= n && n < nArray.length) {
                    nArray3[i2] = nArray[n];
                    continue;
                }
                nArray3[i2] = -1;
                mapOverlayLogCh.log(10000, "AbstractRouteCriteriaBoxController#createIcon Image with index %1 not available.", (long)n);
            }
            iconController.setBitmaps(nArray3);
        }
        return iconController;
    }

    protected static LabelController createLabel(int n, int n2) {
        LabelController labelController = new LabelController();
        labelController.setBounds(0, 0, n, n2);
        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
        labelController.setRenderer(labelRendererHigh);
        return labelController;
    }

    protected static LayoutContainerController createLayoutContainer(int n, int n2) {
        LayoutContainerController layoutContainerController = new LayoutContainerController();
        CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
        layoutContainerController.setRenderer(compositeRendererHigh);
        layoutContainerController.setWidth(n);
        layoutContainerController.setHeight(n2);
        return layoutContainerController;
    }

    @Override
    public void disconnecting() {
        super.disconnecting();
        this.isInitialized = false;
    }

    protected static void getRow(ListCell[][] listCellArray, int n, int[] nArray, int[] nArray2) {
        if (listCellArray != null) {
            ListCell[] listCellArray2 = listCellArray[n];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int n2 = nArray[i2];
                ListCell listCell = listCellArray2[n2];
                int n3 = -1;
                if (listCell instanceof IntegerListCell) {
                    n3 = ((IntegerListCell)listCell).getValue();
                } else {
                    mapOverlayLogCh.log(10000, "AbstractRouteCriteriaBoxController#getRow Cell at column %2, row %3 is not Integer, but %1.", (Object)listCell, (long)n2, (long)n);
                }
                nArray2[i2] = n3;
            }
        } else {
            mapOverlayLogCh.log(10000, "AbstractRouteCriteriaBoxController#getRow No data available.");
        }
    }

    protected static void getRow(TiledListModelGUI tiledListModelGUI, int n, String[] stringArray) {
        if (tiledListModelGUI != null) {
            int n2 = tiledListModelGUI.getMaxColumns();
            GuiListRow guiListRow = tiledListModelGUI.getGuiRow(n);
            for (int i2 = 0; i2 < n2; ++i2) {
                if (i2 >= stringArray.length) {
                    mapOverlayLogCh.log(10000, "AbstractRouteCriteriaBoxController#getRow Could not get complete row.");
                    return;
                }
                stringArray[i2] = guiListRow.getText(i2);
            }
        } else {
            mapOverlayLogCh.log(10000, "AbstractRouteCriteriaBoxController#getRow Base list model is null.");
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (!this.isRegion(AbstractRouteCriteriaBoxController.getRegionCode())) {
            mapOverlayLogCh.log(-2137614336, "AbstractRouteCriteriaBoxController#processModelUpdateEvent Widget is not intended for the current region: %1", (long)AbstractRouteCriteriaBoxController.getRegionCode());
            return;
        }
        if (!this.isConnected()) {
            mapOverlayLogCh.log(-2137614336, "AbstractRouteCriteriaBoxController#processModelUpdateEvent Widget is not connected.");
            return;
        }
        int n = modelUpdateEvent.getModelType();
        int n2 = modelUpdateEvent.getModelId();
        HMIModel hMIModel = hmiService.getModel(n2);
        mapOverlayLogCh.log(-2137614336, "AbstractRouteCriteriaBoxController#processModelUpdateEvent Received update from %1.", (long)n2);
        switch (n) {
            case 25: {
                this.updateContent(this.readDataFromBaseListModel(hMIModel), n2);
                break;
            }
            case 4: {
                this.updateContent(this.readDataFromListModel(hMIModel), n2);
                break;
            }
            default: {
                mapOverlayLogCh.log(10000, "AbstractRouteCriteriaBoxController#processModelUpdateEvent Model %1 not supported.", (long)n2);
            }
        }
    }

    public void processModelUpdateEvent(Object object, int n) {
        if (!this.isRegion(AbstractRouteCriteriaBoxController.getRegionCode())) {
            mapOverlayLogCh.log(10000, "AbstractRouteCriteriaBoxController#processModelUpdateEvent Widget is not intended for the current region: %1", (long)AbstractRouteCriteriaBoxController.getRegionCode());
            return;
        }
        this.updateContent(object, n);
    }

    private TiledListModelGUI readDataFromBaseListModel(Object object) {
        if (object instanceof BaseListModel) {
            return (TiledListModelGUI)object;
        }
        return null;
    }

    private ListCell[][] readDataFromListModel(Object object) {
        if (object instanceof ListModelGUI) {
            ListModelGUI listModelGUI = (ListModelGUI)object;
            int n = listModelGUI.getMaxColumns();
            int n2 = listModelGUI.getLength();
            mapOverlayLogCh.log(-2137614336, "AbstractRouteCriteriaBoxController#readDataFromModel nCols = %1, nRows = %2", (long)n, (long)n2);
            ListCell[][] listCellArray = new ListCell[n2][n];
            for (int i2 = 0; i2 < n2; ++i2) {
                boolean bl = listModelGUI.getRow(i2, listCellArray[i2]);
                if (bl) continue;
                mapOverlayLogCh.log(10000, "AbstractRouteCriteriaBoxController#readDataFromModel Couldn't get row with index %1.", (long)i2);
                return null;
            }
            return listCellArray;
        }
        return null;
    }

    @Override
    protected void initializeWidget() {
        if (!this.isRegion(AbstractRouteCriteriaBoxController.getRegionCode())) {
            mapOverlayLogCh.log(-2137614336, "AbstractRouteCriteriaBoxController#initializeWidget Widget is not intended for the current region: %1", (long)AbstractRouteCriteriaBoxController.getRegionCode());
            this.plate.setOnScreen(false);
            this.setOnScreen(false);
            return;
        }
        if (!this.isSetUp) {
            this.setUpIndividualProperties();
            this.setUpWidgets();
            this.setUpLayout();
            this.isSetUp = true;
        }
        this.updateContent(this.readDataFromListModel(this.model), this.getModelID());
        if (this.modelStubs != null) {
            for (int i2 = 0; i2 < this.modelStubs.length; ++i2) {
                int n = this.modelStubs[i2];
                this.updateContent(hmiService.getModel(n), n);
            }
        }
    }

    protected boolean isInitialized() {
        return this.isInitialized;
    }

    protected abstract void printBoxInfo(LogChannel logChannel) {
    }

    protected abstract boolean isRegion(int n) {
    }

    protected abstract void setUpIndividualProperties() {
    }

    protected abstract void setUpWidgets() {
    }

    protected abstract void setUpLayout() {
    }

    protected abstract void updateContent(Object object, int n) {
    }
}

