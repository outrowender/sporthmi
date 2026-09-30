/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.remotehmi.HMIProperties;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMICalculationHelper;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class HMIViewListPOIListener
extends AbstractHMIViewListener
implements ListListener,
TimerListener {
    private static final long TIMER_DELAY = 5000L;
    private ListModelApp listModel;
    private Timer timer = null;
    private HMIProperties lastProps;
    private LabelModelApp fastScrollPreviewModel;
    private static final int MAX_COLUMS = 7;
    private String[] textlists;

    public HMIViewListPOIListener(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIService remoteHMIService) {
        super(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIService);
        modelGroup.add(onlineModelBankAccess.getModelApp(2300471));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300396));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300397));
        this.configureSoftkeyModels(new int[]{2300342, 2300340, 2300344, 2300346});
        this.listModel = onlineModelBankAccess.getListModel(2300338);
        this.listModel.setListListener(this);
        this.listModel.setMaxColumns(7);
        modelGroup.add(onlineModelBankAccess.getModelApp(2300350));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300348));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300349));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300343));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300341));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300347));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300345));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300339));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300338));
        this.fastScrollPreviewModel = onlineModelBankAccess.getLabelModel(0);
        this.fastScrollPreviewModel.setText("");
    }

    public synchronized void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        this.lastProps = hMIProperties;
        this.setTitles(2300350, 2300351, 2300348, 2300349, hMIProperties);
        this.setSoftkeys(new int[]{2300343, 2300341, 2300345, 2300347}, 2300339, hMIProperties);
        this.updateListModel(hMIProperties, bl);
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 2300338: {
                this.invokeActionItemSelected(n2);
                break;
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
        String string = this.textlists != null && this.textlists.length > n2 ? this.textlists[n2] : "";
        this.fastScrollPreviewModel.setText(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onExit() {
        super.onExit();
        HMIViewListPOIListener hMIViewListPOIListener = this;
        synchronized (hMIViewListPOIListener) {
            if (this.timer != null) {
                this.timer.cancel();
            }
        }
    }

    public void fireTimer(Timer timer) {
        if (this.listModel == null) {
            return;
        }
        this.updateListModel(this.lastProps, false);
    }

    private synchronized void updateListModel(HMIProperties hMIProperties, boolean bl) {
        if (bl) {
            this.listModel.resetHints();
            if (this.timer != null) {
                this.timer.cancel();
            }
            this.timer = new Timer("HMIViewListPOITimer", 5000L, false, this);
            this.timer.start();
        } else {
            this.listModel.addHint(8);
        }
        this.textlists = hMIProperties.getStringArray("listText");
        double[] dArray = hMIProperties.getDoubleArray("lat");
        double[] dArray2 = hMIProperties.getDoubleArray("lon");
        String[] stringArray = hMIProperties.getStringArray("listLeftIconUrl");
        int[] nArray = hMIProperties.getIntArray("listLLDMapping");
        boolean[] blArray = hMIProperties.getBooleanArray("listTextEnabled");
        boolean[] blArray2 = hMIProperties.getBooleanArray("listTextFocusable");
        this.setSelectedIds(hMIProperties.getStringArray("listTextId"));
        this.listModel.beginTransaction();
        this.listModel.clear();
        this.listModel.setMaxRows(this.textlists.length);
        ListCell[] listCellArray = new ListCell[7];
        for (int i2 = 0; i2 < this.textlists.length; ++i2) {
            listCellArray[0] = stringArray != null && stringArray.length > i2 && stringArray[i2] != null ? new IconCell(new HMIResourceLocator(stringArray[i2])) : new IconCell("");
            listCellArray[1] = new TextListCell(this.textlists[i2]);
            double d2 = dArray != null && dArray.length > i2 ? dArray[i2] : 0.0;
            double d3 = dArray2 != null && dArray2.length > i2 ? dArray2[i2] : 0.0;
            int n = NavigationUtilities.degreeToWgs84(d2);
            int n2 = NavigationUtilities.degreeToWgs84(d3);
            int n3 = 0;
            int n4 = 0;
            NaviService naviService = this.remoteHmiService.getNaviComponent().getNaviService();
            if (naviService != null) {
                n3 = naviService.computeRelativeDirection(n2, n);
                n4 = naviService.computeRelativeAirDistance(n2, n);
            } else {
                this.logChannel.log(100000, "HMIViewListPOIListener#updateListModel: no navi service");
            }
            listCellArray[2] = new IntegerListCell(n3);
            String string = RemoteHMICalculationHelper.calculateDistance(n4);
            listCellArray[3] = new TextListCell(string);
            listCellArray[4] = nArray.length > i2 ? new IntegerListCell(nArray[i2]) : new IntegerListCell(0);
            listCellArray[5] = blArray.length > i2 && !blArray[i2] ? new IntegerListCell(0) : new IntegerListCell(1);
            listCellArray[6] = blArray2.length > i2 && !blArray2[i2] ? new IntegerListCell(0) : new IntegerListCell(1);
            this.listModel.addRow(listCellArray);
        }
        if (hMIProperties.contains("initialCursorPosition")) {
            this.listModel.setSelected(hMIProperties.getInt("initialCursorPosition"));
        } else if (bl) {
            this.listModel.setSelected(0);
            this.setNewCursor(this.getOldCursor().withFocus(-1, -1, "", ""));
        } else if (this.getOldCursor().getFocus().getIndex() != -1) {
            this.listModel.setSelected(this.getOldCursor().getFocus().getIndex());
        }
        this.listModel.endTransaction();
    }

    public void cancelTimer(Timer timer) {
    }

    public int getViewID() {
        return 1500;
    }
}

