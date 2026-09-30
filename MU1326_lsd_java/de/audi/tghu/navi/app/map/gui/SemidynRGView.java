/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IMapPartialPopupHandler;
import de.audi.tghu.navi.app.map.IView;
import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import java.util.Date;

public class SemidynRGView
implements IView {
    protected static final int NO_ROAD_BLOCK = 1;
    protected static final int ROAD_BLOCK = 0;
    protected IMapPartialPopupHandler mapPartialPopupHandler;
    private ChoiceModelApp mBetterRouteAvailable;
    private MetricsModelApp mSDRSPopupMetrics;
    private MetricsModelApp mSDRSDetourSavingTimeMetrics;
    private LabelModelApp mSDRSSavingTime;
    private ListModelApp mSdrsList;
    private MenuModelApp mSdrsMenu;
    private ListModelApp mSDRSTooltip;
    protected ButtonModelApp mBtnShowBetterRoute;
    protected ButtonModelApp mBtnPopupShowBetterRoute;
    protected ButtonModelApp mBtnPopupIgnoreBetterRoute;
    protected ButtonModelApp mVirtualBtnPopupIgnoreBetterRoute;
    protected ButtonModelApp mBtnPopupShowDetour;
    protected ButtonModelApp mBtnPopupIgnoreDetour;
    protected ButtonModelApp mVirtualBtnPopupIgnoreBlockedRoute;
    private ListModelApp mSBRSList;
    protected ChoiceModelApp roadBlockedModel;
    public static final int ROAD_BLOCKED_FALSE = 0;
    public static final int ROAD_BLOCKED_TRUE = 1;
    private RangeModelApp detoursModel;
    public static final int ITEM_CURRENT_ROUTE = 0;
    public static final int ITEM_RECOMMENDED_ROUTE = 1;
    public static final int ITEM_DETOUR_DETAILS = 2;
    private final LogChannel logger;
    protected NavigationEnv env;

    public SemidynRGView(NavigationEnv navigationEnv, IMapPartialPopupHandler iMapPartialPopupHandler) {
        this.env = navigationEnv;
        this.logger = navigationEnv.getLogChannel("App.Map.GUI.Main");
        this.mapPartialPopupHandler = iMapPartialPopupHandler;
        this.initModels(navigationEnv);
    }

    protected void initModels(NavigationEnv navigationEnv) {
        this.mBetterRouteAvailable = navigationEnv.getChoiceModel(401368);
        this.mSDRSPopupMetrics = navigationEnv.getMetricsModel(401369);
        this.mSDRSSavingTime = navigationEnv.getLabelModel(401577);
        this.mSDRSDetourSavingTimeMetrics = navigationEnv.getMetricsModel(402512);
        this.mSdrsList = navigationEnv.getListModel(400451);
        this.mSdrsMenu = navigationEnv.getMenuModel(401705);
        this.mSDRSTooltip = navigationEnv.getListModel(401028);
        this.mSDRSTooltip.setMaxColumns(7);
        ListCell[] listCellArray = new ListCell[]{IntegerListCell.create(0), new TextListCell(""), new TextListCell(""), IntegerListCell.create(0), IntegerListCell.create(0), IntegerListCell.create(0), IntegerListCell.create(0)};
        this.mSDRSTooltip.addRow(listCellArray);
        this.mSBRSList = navigationEnv.getListModel(400451);
        this.mBtnShowBetterRoute = navigationEnv.getButtonModel(401396);
        this.mBtnPopupShowBetterRoute = navigationEnv.getButtonModel(401398);
        this.mBtnPopupIgnoreBetterRoute = navigationEnv.getButtonModel(401419);
        this.mVirtualBtnPopupIgnoreBetterRoute = navigationEnv.getButtonModel(402045);
        this.mBtnPopupShowDetour = navigationEnv.getButtonModel(401399);
        this.mBtnPopupIgnoreDetour = navigationEnv.getButtonModel(401424);
        this.mVirtualBtnPopupIgnoreBlockedRoute = navigationEnv.getButtonModel(402044);
        this.roadBlockedModel = navigationEnv.getChoiceModel(402153);
        this.detoursModel = navigationEnv.getRangeModel(402387);
    }

    protected LogChannel getLogger() {
        return this.logger;
    }

    public boolean isBetterRouteIndicatorVisible() {
        return this.mBetterRouteAvailable.getValue() == 1;
    }

    public void showPopupBetterRouteAvailable(long l) {
        this.updateSavedTime(l);
        this.mSDRSPopupMetrics.setStatus(1);
        this.mBetterRouteAvailable.setValue(1);
    }

    public void showShortInfo() {
        this.mSDRSPopupMetrics.setStatus(0);
        this.mBetterRouteAvailable.setValue(1);
    }

    public void showShortInfo(long l) {
        this.updateSavedTime(l);
        this.mSDRSPopupMetrics.setStatus(0);
        this.mBetterRouteAvailable.setValue(1);
    }

    public void updateSavedTime(long l) {
        boolean bl = l < 0L;
        DateMetric dateMetric = new DateMetric(new Date(l), 5);
        this.mSDRSPopupMetrics.setMetric(dateMetric);
        DateMetric dateMetric2 = new DateMetric(new Date(l), 5);
        this.mSDRSDetourSavingTimeMetrics.setMetric(dateMetric2);
        this.mSDRSDetourSavingTimeMetrics.setStatus(bl ? 0 : 1);
        this.mSDRSSavingTime.setText(bl ? this.env.getTranslatedText(52, "Sperrung meiden") : dateMetric.format());
        this.roadBlockedModel.setValue(bl ? 1 : 0);
    }

    public void hidePopupBetterRouteAvailable() {
        this.mBetterRouteAvailable.setValue(0);
    }

    public boolean isPopupBetterRouteAvailableVisible() {
        return this.mBetterRouteAvailable.getValue() == 1;
    }

    public void enterSemidynRGView() {
    }

    public void setRouteChangeInfo(int n, int n2, long l, long l2) {
        if (n == 0 || n == 1) {
            this.mSBRSList.setCell(n, 1, new LongListCell(l));
            this.mSBRSList.setCell(n, 0, IntegerListCell.create(n2));
            this.mSBRSList.setCell(n, 5, new IntegerListCell(0, 1));
            int n3 = 0;
            n3 = l2 == 0L ? 0 : (l2 > 0L ? 1 : 2);
            this.mSBRSList.setCell(n, 5, new IntegerListCell(n3, n3));
            this.mSBRSList.setCell(n, 6, new LongListCell(0L));
            this.mSBRSList.setCell(n, 8, IntegerListCell.create(0));
        }
    }

    public void showSDRSTooltip(long l, long l2, int n, int n2, int n3, long l3) {
        this.logger.log(10000000, "SemidynRGView#showSDRSTooltip( delay:%1ms, saving:%2ms )", l, l2);
        String string = this.env.getTranslatedText(52, "Sperrung meiden");
        String string2 = l >= 0L ? MapUtils.formatTime(l) : "";
        String string3 = l2 >= 0L ? MapUtils.formatTime(l2) : string;
        int n4 = l >= 0L ? 0 : 1;
        this.mSDRSTooltip.setCell(0, 1, new TextListCell(string2));
        this.mSDRSTooltip.setCell(0, 2, new TextListCell(string3));
        this.mSDRSTooltip.setCell(0, 3, IntegerListCell.create(n2));
        this.mSDRSTooltip.setCell(0, 4, IntegerListCell.create(n4));
        this.mSDRSTooltip.setCell(0, 0, IntegerListCell.create(n));
        this.mSDRSTooltip.setCell(0, 5, IntegerListCell.create(n3));
        this.mSDRSTooltip.setCell(0, 6, IntegerListCell.create((int)l3));
    }

    public void addSwitchToSemidynListener(ButtonListener buttonListener) {
        this.mBtnShowBetterRoute.setButtonListener(buttonListener);
        this.mBtnPopupShowBetterRoute.setButtonListener(buttonListener);
        this.mBtnPopupShowDetour.setButtonListener(buttonListener);
    }

    public void setIgnoreBetterRouteListener(ButtonListener buttonListener) {
        this.mBtnPopupIgnoreBetterRoute.setButtonListener(buttonListener);
        this.mVirtualBtnPopupIgnoreBetterRoute.setButtonListener(buttonListener);
    }

    public void setDetourNowListener(SimpleButtonListener simpleButtonListener) {
    }

    public void setIgnoreDetourListener(ButtonListener buttonListener) {
        this.mBtnPopupIgnoreDetour.setButtonListener(buttonListener);
        this.mVirtualBtnPopupIgnoreBlockedRoute.setButtonListener(buttonListener);
    }

    public void showPopupSemidynBlockMain() {
        this.mapPartialPopupHandler.showPopupSemidynBlockMain();
    }

    public void showPopupSemidynBetterMain() {
        this.mapPartialPopupHandler.showPopupSemidynBetterMain();
    }

    public void hidePopupSemidynBlockMain() {
        this.mapPartialPopupHandler.hidePopupSemidynBlockMain();
    }

    public void hidePopupSemidynBetterMain() {
        this.mapPartialPopupHandler.hidePopupSemidynBetterMain();
    }

    public void focusRoute(int n) {
        this.getLogger().log(100000000, "SemidynRGView#focusRoute( %1 )", (long)n);
        if (n == 0 || n == 1) {
            this.mSdrsMenu.setFocusedItem(1, FocusAdvice.KEEP_POSITION, -1L);
        }
    }

    public void setSelectedDetour(int n) {
        this.detoursModel.setValue(n);
    }

    public int getSelectedDetour() {
        return this.detoursModel.getValue();
    }

    public int getIndexOfSelectedDetour() {
        return this.detoursModel.getValue() - this.detoursModel.getMinimum();
    }

    public void incrementSelectedDetour(int n) {
        int n2 = Util.getIncrementedValueForRangeModel(this.detoursModel, n);
        this.detoursModel.setValue(n2);
    }

    public void setNumberOfDetours(int n) {
        this.detoursModel.setLimits(1, n, 1);
    }

    public void setNewRouteEta(long l) {
    }
}

