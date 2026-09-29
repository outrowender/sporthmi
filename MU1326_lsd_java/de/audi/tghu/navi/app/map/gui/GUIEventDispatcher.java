/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.gui.AbstractGUI;
import de.audi.tghu.navi.app.map.gui.GUIEventListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GUIEventDispatcher
implements GUIEventListener {
    private static int BITMASK_ADD_INFO_ROUTEINFO = 1;
    private static int BITMASK_ADD_INFO_TURN = 2;
    private static int BITMASK_ADD_INFO_OVERVIEW = 4;
    private static int BITMASK_ADD_INFO_RANGE = 8;
    private static int BITMASK_ADD_INFO_ON = 16;
    private static int BITMASK_ADD_INFO_OFF = 32;
    protected MapManager mapManager;
    private List guiListeners = null;
    protected ListModelApp mScreenLayout = null;
    protected ListModelApp mToolTip = null;
    protected Distance mDistance = null;
    protected DateMetric mEta = null;
    protected DateMetric mRtt = null;
    protected Distance mMagnificationMetric = null;
    protected Distance mHeight = null;
    protected ChoiceModelApp mMixedListControllerChoice = null;
    protected ModelGroup mModelGroup = null;
    protected ModelGroup mMagnificationModelGroup = null;
    protected LabelModelApp mLoggingWindow = null;
    protected NavigationEnv env;

    public GUIEventDispatcher(NavigationEnv navigationEnv, MapManager mapManager) {
        this.mapManager = mapManager;
        this.env = navigationEnv;
        this.guiListeners = new ArrayList();
        this.init(navigationEnv);
    }

    private void init(NavigationEnv navigationEnv) {
        this.mScreenLayout = navigationEnv.getListModel(176);
        navigationEnv.getChoiceModel(1058801152).setChoiceListener(this);
        navigationEnv.getChoiceModel(1058801152).forceUpdate(true);
        navigationEnv.getVirtualButtonModel(1075578368).setVirtualButtonListener(this);
        navigationEnv.getVirtualButtonModel(404817408).setVirtualButtonListener(this);
        navigationEnv.getChoiceModel(991692288).setChoiceListener(this);
        navigationEnv.getChoiceModel(890963456).setChoiceListener(this);
        this.registerAlternativeRouteSelectionListener(navigationEnv);
        navigationEnv.getChoiceModel(1646003712).setChoiceListener(this);
        navigationEnv.getRangeModel(1545340416).setRangeListener(this);
        this.mMagnificationMetric = new Distance(0.0f, 1, 4);
        navigationEnv.getMetricsModel(1528563200).setMetric(this.mMagnificationMetric);
        navigationEnv.getRangeModel(35522048).setRangeListener(this);
        navigationEnv.getRangeModel(1813775872).setRangeListener(this);
        navigationEnv.getButtonModel(1595672064).setButtonListener(this);
        navigationEnv.getButtonModel(1612449280).setButtonListener(this);
        navigationEnv.getButtonModel(1746667008).setButtonListener(this);
        navigationEnv.getButtonModel(1109132800).setButtonListener(this);
        navigationEnv.getButtonModel(1109132800).setStatus(0);
        navigationEnv.getButtonModel(1411319296).setButtonListener(this);
        navigationEnv.getChoiceModel(-1742928384).setButtonListener(this);
        this.doInitETAModels();
        this.mHeight = new Distance(0.0f, 1);
        navigationEnv.getMetricsModel(1981548032).setMetric(this.mHeight);
        navigationEnv.getChoiceModel(-1742928384).setChoiceListener(this);
        navigationEnv.getButtonModel(-1759705600).setButtonListener(this);
        navigationEnv.getRangeModel(-752679424).setRangeListener(this);
        this.mMixedListControllerChoice = navigationEnv.getChoiceModel(1578894848);
        this.mMixedListControllerChoice.setChoiceListener(this);
        this.mMixedListControllerChoice.forceUpdate(true);
        this.mMixedListControllerChoice.setValue(2);
        this.mMixedListControllerChoice.setStatus(0);
        navigationEnv.getChoiceModel(0, 168).setChoiceListener(this);
        navigationEnv.getChoiceModel(1, 168).setChoiceListener(this);
        this.mToolTip = navigationEnv.getListModel(1243350528);
        this.mToolTip.setMaxColumns(11);
        this.mToolTip.setMaxRows(1);
        this.mToolTip.addRow(new ListCell[]{new TextListCell(""), IntegerListCell.create(0), IntegerListCell.create(0), IntegerListCell.create(0), IntegerListCell.create(0), IntegerListCell.create(0), IntegerListCell.create(0), IntegerListCell.create(0), IntegerListCell.create(0), IntegerListCell.create(0), IntegerListCell.create(0)});
        this.mModelGroup = new ModelGroup();
        this.mModelGroup.add(navigationEnv.getMetricsModel(1947993600));
        this.mModelGroup.add(navigationEnv.getMetricsModel(1964770816));
        this.mModelGroup.add(navigationEnv.getListModel(1562117632));
        this.mModelGroup.add(this.mMixedListControllerChoice);
        this.mMagnificationModelGroup = new ModelGroup();
        this.mMagnificationModelGroup.add(navigationEnv.getRangeModel(1545340416));
        this.mMagnificationModelGroup.add(navigationEnv.getMetricsModel(1528563200));
        this.initSBRS();
        navigationEnv.getChoiceModel(2015102464).setChoiceListener(this);
        navigationEnv.getChoiceModel(1998325248).setChoiceListener(this);
        this.mLoggingWindow = navigationEnv.getLabelModel(1763575296);
        navigationEnv.getVirtualButtonModel(1813906944).setVirtualButtonListener(this);
        navigationEnv.getVirtualButtonModel(-904002048).setVirtualButtonListener(this);
        navigationEnv.getVirtualButtonModel(1965098496).setVirtualButtonListener(this);
        navigationEnv.getChoiceModel(-1742666240).setButtonListener(this);
    }

    protected void registerAlternativeRouteSelectionListener(NavigationEnv navigationEnv) {
        navigationEnv.getListModel(1125910016).setListListener(this);
    }

    private void doInitETAModels() {
        this.mDistance = new Distance(0.0f, 1);
        this.mEta = new DateMetric(new Date(), 1);
        this.mRtt = new DateMetric(new Date(), 3);
        MetricsModelApp metricsModelApp = this.env.getMetricsModel(1947993600);
        MetricsModelApp metricsModelApp2 = this.env.getMetricsModel(1964770816);
        metricsModelApp.setMetric(this.mDistance);
        metricsModelApp.getMetric().setMetricValid(false);
        metricsModelApp2.setMetric(this.mEta);
        metricsModelApp2.getMetric().setMetricValid(false);
    }

    public void addListener(GUIEventListener gUIEventListener) {
        if (!this.guiListeners.contains(gUIEventListener)) {
            this.guiListeners.add(gUIEventListener);
        }
    }

    private Iterator iterator() {
        return this.guiListeners.iterator();
    }

    public Distance getmDistance() {
        return this.mDistance;
    }

    public ListModelApp getmScreenLayout() {
        return this.mScreenLayout;
    }

    public ListModelApp getmToolTip() {
        return this.mToolTip;
    }

    public DateMetric getmEta() {
        return this.mEta;
    }

    public DateMetric getmRtt() {
        return this.mRtt;
    }

    public Distance getmMagnificationMetric() {
        return this.mMagnificationMetric;
    }

    public Distance getmHeight() {
        return this.mHeight;
    }

    public ChoiceModelApp getmMixedListControllerChoice() {
        return this.mMixedListControllerChoice;
    }

    public ModelGroup getmModelGroup() {
        return this.mModelGroup;
    }

    public ModelGroup getmMagnificationModelGroup() {
        return this.mMagnificationModelGroup;
    }

    public LabelModelApp getLoggingWindow() {
        return this.mLoggingWindow;
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).touchPadPositionMoved(n, n2, n3, n4, n5, n6);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void touchPadReleased(int n, int n2, int n3) {
    }

    @Override
    public void touchPadPressed(int n, int n2, int n3) {
    }

    @Override
    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).touchScreenMoved(n, n2, n3, n4, n5, n6);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void touchScreenPressed(int n, int n2, int n3, int n4) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).touchScreenPressed(n, n2, n3, n4);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void touchScreenLongPressed(int n, int n2, int n3, int n4) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).touchScreenLongPressed(n, n2, n3, n4);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void touchScreenReleased(int n, int n2, int n3, int n4) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).touchScreenReleased(n, n2, n3, n4);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void touchScreenDoubleClick(int n, int n2, int n3, int n4) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).touchScreenDoubleClick(n, n2, n3, n4);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void touchScreenPinch(int n, float f2, int n2, int n3, int n4) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).touchScreenPinch(n, f2, n2, n3, n4);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void touchScreenRotate(int n, short s, int n2) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).touchScreenRotate(n, s, n2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void stickN(int n, int n2) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).stickN(n, n2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void stickNW(int n, int n2) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).stickNW(n, n2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void stickW(int n, int n2) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).stickW(n, n2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void stickSW(int n, int n2) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).stickSW(n, n2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void stickS(int n, int n2) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).stickS(n, n2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void stickSE(int n, int n2) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).stickSE(n, n2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void stickE(int n, int n2) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).stickE(n, n2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void stickNE(int n, int n2) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).stickNE(n, n2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void stickIdle(int n, int n2) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).stickIdle(n, n2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).itemReleased(n, n2, n3, n4);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).itemFocused(n, n2, n3, n4);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).keyPressed(n, n2, n3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).keyReleased(n, n2, n3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).keyTyped(n, n2, n3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            default: 
        }
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).itemSelected(n, n2, n3, n4);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                ((AbstractGUI)iterator.next()).decrement(n, n2, n3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void increment(int n, int n2, int n3) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            try {
                AbstractGUI abstractGUI = (AbstractGUI)iterator.next();
                abstractGUI.increment(n, n2, n3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    protected void initSBRS() {
        this.env.getListModel(1125910016).beginTransaction();
        this.env.getListModel(1125910016).clear();
        this.env.getListModel(1125910016).setMaxColumns(13);
        for (int i2 = 0; i2 < 3; ++i2) {
            ListCell[] listCellArray = new ListCell[13];
            listCellArray[0] = IntegerListCell.create(-1);
            listCellArray[1] = new LongListCell(-1L);
            listCellArray[5] = IntegerListCell.create(0);
            listCellArray[6] = IntegerListCell.create(0);
            listCellArray[7] = IntegerListCell.create(0);
            this.env.getListModel(1125910016).addRow(listCellArray);
        }
        this.env.getListModel(1125910016).endTransaction();
    }

    public int getSemiDynID() {
        return 1125910016;
    }
}

