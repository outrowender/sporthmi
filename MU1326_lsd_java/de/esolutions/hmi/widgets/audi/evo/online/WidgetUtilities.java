/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.hmi.model.update.ModelUpdateData$Key;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;

public class WidgetUtilities {
    private static final LogChannel log = AbstractWidget.framework.getLogChannel("App.Online.RemoteHMI.Grid");

    private WidgetUtilities() {
    }

    public static void updateListControllerDirectly(ListController listController, int n, ModelUpdateData modelUpdateData, int n2) {
        if (!listController.isConnected()) {
            return;
        }
        BaseListModel baseListModel = (BaseListModel)listController.getModel();
        ModelUpdateEvent modelUpdateEvent = AbstractModelBank.getHMIservice().getModelUpdateEvent(n2);
        modelUpdateEvent.setModelId(baseListModel.getID());
        modelUpdateEvent.setModelType(baseListModel.getModelType());
        modelUpdateEvent.setUpdateType(n);
        modelUpdateEvent.setHints(0);
        modelUpdateEvent.setClientData1(0);
        modelUpdateEvent.setClientData2(0);
        modelUpdateEvent.setClientData3(modelUpdateData);
        listController.processModelUpdateEvent(modelUpdateEvent);
    }

    public static void removeEvoListRowsImmediately(int n, int n2, ListController listController, int n3) {
        if (n < 0 || n2 <= 0 || listController == null) {
            log.log(-1601830656, "WidgetUtilities#removeEvoListRowsImmediately: invalid parameter listController=%1, beginningIndex=%2, rowCount=%3.", (Object)listController, (long)n, (long)n2);
            return;
        }
        BaseListModel baseListModel = (BaseListModel)listController.getModel();
        int n4 = baseListModel.getLength();
        if (n + n2 > n4) {
            log.log(-1601830656, "WidgetUtilities#removeEvoListRowsImmediately: invalid range beginningIndex=%1, rowCount=%2, but model length only=%3.", (long)n, (long)n2, (long)n4);
            return;
        }
        long[] lArray = new long[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            EvoListRow evoListRow = baseListModel.getRow(n + i2);
            lArray[i2] = evoListRow.getUniqueID();
        }
        baseListModel.remove(lArray);
        ModelUpdateData modelUpdateData = ModelUpdateData.obtain(9).put(ModelUpdateData$Key.INDEX, n).put(ModelUpdateData$Key.UNIQUEID, lArray[0]).put(ModelUpdateData$Key.COUNT, lArray.length);
        WidgetUtilities.updateListControllerDirectly(listController, 9, modelUpdateData, n3);
    }

    public static void appendEvoListRowsImmediately(EvoListRow[] evoListRowArray, ListController listController, int n) {
        int n2;
        int n3 = n2 = evoListRowArray == null ? 0 : evoListRowArray.length;
        if (n2 == 0 || listController == null) {
            log.log(-1601830656, "WidgetUtilities#appendEvoListRowsImmediately: invalid parameter listController=%1, rowsLength=%2.", (Object)listController, (long)n2);
            return;
        }
        BaseListModel baseListModel = (BaseListModel)listController.getModel();
        int n4 = baseListModel.getLength();
        baseListModel.append(evoListRowArray);
        ModelUpdateData modelUpdateData = ModelUpdateData.obtain(7).put(ModelUpdateData$Key.INDEX, n4).put(ModelUpdateData$Key.UNIQUEID, evoListRowArray[0].getUniqueID()).put(ModelUpdateData$Key.COUNT, n2);
        WidgetUtilities.updateListControllerDirectly(listController, 7, modelUpdateData, n);
    }

    public static void insertAfterEvoListRowsImmediately(long l, EvoListRow[] evoListRowArray, ListController listController, int n) {
        int n2;
        int n3 = n2 = evoListRowArray == null ? 0 : evoListRowArray.length;
        if (n2 == 0 || listController == null) {
            log.log(-1601830656, "WidgetUtilities#insertAfterEvoListRowsImmediately: invalid parameter listController=%1, rowsLength=%2.", (Object)listController, (long)n2);
            return;
        }
        BaseListModel baseListModel = (BaseListModel)listController.getModel();
        if (baseListModel.getIndexForUniqueID(l) == -1) {
            log.log(-1601830656, "WidgetUtilities#insertAfterEvoListRowsImmediately: cannot find index for uniqueId=%1.", l);
            return;
        }
        baseListModel.insertAfter(l, evoListRowArray);
        EvoListRow evoListRow = evoListRowArray[0];
        long l2 = evoListRow.getUniqueID();
        int n4 = baseListModel.getIndexForUniqueID(l2);
        ModelUpdateData modelUpdateData = ModelUpdateData.obtain(7).put(ModelUpdateData$Key.INDEX, n4).put(ModelUpdateData$Key.UNIQUEID, l2).put(ModelUpdateData$Key.COUNT, n2);
        WidgetUtilities.updateListControllerDirectly(listController, 7, modelUpdateData, n);
    }

    public static void insertBeforeEvoListRowsImmediately(long l, EvoListRow[] evoListRowArray, ListController listController, int n) {
        int n2;
        int n3 = n2 = evoListRowArray == null ? 0 : evoListRowArray.length;
        if (n2 == 0 || listController == null) {
            log.log(-1601830656, "WidgetUtilities#insertBeforeEvoListRowsImmediately: invalid parameter listController=%1, rowsLength=%2.", (Object)listController, (long)n2);
            return;
        }
        BaseListModel baseListModel = (BaseListModel)listController.getModel();
        if (baseListModel.getIndexForUniqueID(l) == -1) {
            log.log(-1601830656, "WidgetUtilities#insertBeforeEvoListRowsImmediately: cannot find index for uniqueId=%1.", l);
            return;
        }
        baseListModel.insertBefore(l, evoListRowArray);
        EvoListRow evoListRow = evoListRowArray[0];
        long l2 = evoListRow.getUniqueID();
        int n4 = baseListModel.getIndexForUniqueID(l2);
        ModelUpdateData modelUpdateData = ModelUpdateData.obtain(7).put(ModelUpdateData$Key.INDEX, n4).put(ModelUpdateData$Key.UNIQUEID, l2).put(ModelUpdateData$Key.COUNT, n2);
        WidgetUtilities.updateListControllerDirectly(listController, 7, modelUpdateData, n);
    }

    public static void notifyChangedContentImmediately(ListController listController, int n) {
        WidgetUtilities.updateListControllerDirectly(listController, 6, null, n);
    }

    public static void notifyChangedRowsImmediately(int n, int n2, ListController listController, int n3) {
        BaseListModel baseListModel = (BaseListModel)listController.getModel();
        ModelUpdateData modelUpdateData = ModelUpdateData.obtain(8).put(ModelUpdateData$Key.INDEX, n).put(ModelUpdateData$Key.UNIQUEID, baseListModel.getRow(n).getUniqueID()).put(ModelUpdateData$Key.COUNT, n2);
        WidgetUtilities.updateListControllerDirectly(listController, 8, modelUpdateData, n3);
    }

    static IGrid getLayoutedGrid(IGrid iGrid, int n) {
        switch (n) {
            case 0: {
                return iGrid;
            }
            case 2: {
                IGrid iGrid2 = iGrid.getDetail();
                return iGrid2 == null ? iGrid : iGrid2;
            }
            case 3: {
                return iGrid.getArtificialClone();
            }
            case 1: {
                return iGrid.getCloneForMediaList();
            }
            case -1: {
                return null;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Layout = ").append(n).append(" not supported! Add it to case-statement above!").toString());
    }
}

