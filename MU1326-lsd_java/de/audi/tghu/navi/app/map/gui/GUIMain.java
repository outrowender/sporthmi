/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IMapPartialPopupHandler;
import de.audi.tghu.navi.app.map.constants.PropertyEnum;
import de.audi.tghu.navi.app.map.gui.AbstractGUI;
import de.audi.tghu.navi.app.map.gui.EmptyMapPartialPopupHandler;
import de.audi.tghu.navi.app.map.gui.GUIEventDispatcher;
import de.audi.tghu.navi.app.map.gui.GUIMain$1;
import de.audi.tghu.navi.app.map.gui.ToolTipTimer;
import de.audi.tghu.navi.app.map.gui.layout.AbstractLayoutProvider;
import de.audi.tghu.navi.app.map.gui.layout.LayoutProviderG22Main;
import de.audi.tghu.navi.app.map.gui.layout.LayoutProviderG24;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionAction;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionActionDoNothing;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.map.utils.ConstantUtils;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.tmc.TmcMessage;

public class GUIMain
extends AbstractGUI {
    protected final AbstractLayoutProvider layoutProvider;
    private final ToolTipTimer tooltipTimer;
    private ListModelApp mCrosshairs;

    public GUIMain(NavigationEnv navigationEnv, AbstractMap abstractMap, IMapPartialPopupHandler iMapPartialPopupHandler) {
        super(abstractMap, navigationEnv, abstractMap.getMapGUILogChannel());
        abstractMap.getViews().getMapOptionView().setShowDetailsOfCrosshairListener(new GUIMain$1(this));
        this.setGridMaskVisible(false);
        this.setMapSetup3dMapGreyOut(false);
        this.setMapSetupAutozoomGreyOut(false);
        this.tooltipTimer = new ToolTipTimer(navigationEnv, abstractMap.getMapLogChannel(), abstractMap);
        this.mCrosshairs = navigationEnv.getListModel(-1876818432);
        this.mCrosshairs.setMaxColumns(3);
        this.mCrosshairs.setMaxRows(1);
        ListCell[] listCellArray = new ListCell[]{IntegerListCell.create(0), IntegerListCell.create(0), IntegerListCell.create(0)};
        this.mCrosshairs.addRow(listCellArray);
        this.layoutProvider = this.initLayoutProvider();
        this.partialPopup = iMapPartialPopupHandler;
    }

    public boolean warningsOnTheRoadActive() {
        return this.env.getChoiceModel(975177216).getValue() == 1;
    }

    public int naviMapLayoutList() {
        return 176;
    }

    public int navOffroadStatusChoice() {
        return -1122236928;
    }

    @Override
    protected String getName() {
        return "GUIMain";
    }

    protected GUIEventDispatcher getDispatcher() {
        return this.getMap().getMapManager().getGUIEventDispatcher();
    }

    @Override
    public void fireModelEvent(int n) {
        this.getLogger().log(-2137614336, "GUIMain#fireModelEvent( %1 )", (long)n);
        int n2 = this.env.getFramework().isFrontMU() ? 0 : 5;
        this.env.fireModelEvent(n, n2);
    }

    @Override
    public void controlMixedListNoUpdate(int n) {
        this.getDispatcher().getmMixedListControllerChoice().setValue(n);
    }

    @Override
    public void controlMixedList(int n, int n2) {
        if (n2 != 3) {
            Util.setModelStatus(this.getDispatcher().getmMixedListControllerChoice(), n2);
        }
        this.controlMixedListNoUpdate(n);
        this.getDispatcher().getmModelGroup().flush();
    }

    @Override
    public int getSidebarState() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1058801152);
        return choiceModelApp.getValue();
    }

    @Override
    public void closeSidebarWithoutAnimation() {
        this.setScrollOnRoutePressed(false);
        this.setMapScrollSidebarPressed(991692288, false);
        this.setMapScrollSidebarPressed(890963456, false);
        this.openOrCloseSidebar(0);
    }

    @Override
    public void openOrCloseSidebar(int n) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1058801152);
        int n2 = choiceModelApp.getValue();
        if (n == 3 && n2 == 0) {
            this.mGUILogChannel.log(1078071040, "GUIInterface#openOrCloseSidebar() - not closing sidebar. sidebar already closed.");
        } else if (n == 1 && n2 == 2) {
            this.mGUILogChannel.log(1078071040, "GUIInterface#openOrCloseSidebar() - not opening sidebar. sidebar already open.");
        } else {
            choiceModelApp.setValue(n);
        }
    }

    @Override
    public void setPressed(int n, boolean bl) {
        ButtonModelApp buttonModelApp = this.env.getButtonModel(n);
        if (buttonModelApp != null) {
            buttonModelApp.setPressed(bl);
        } else {
            this.mGUILogChannel.log(10000, "GUIInterface#setPressed(): model id %1 not found", (long)n);
        }
    }

    boolean getPressed(int n) {
        ButtonModelApp buttonModelApp = this.env.getButtonModel(n);
        if (buttonModelApp != null) {
            return buttonModelApp.getPressed();
        }
        this.mGUILogChannel.log(10000, "GUIInterface#getPressed(): model id %1 not found");
        return false;
    }

    @Override
    public void setCursorForPOIMap(int n) {
        this.env.getChoiceModel(1142687232).setValue(n);
    }

    @Override
    public void switchToRouteSelectionSidebar(int n) {
        this.mGUILogChannel.log(1078071040, "GUIInterface#switchToRouteSelectionSidebar( %1 )", (long)n);
        Util.setModelStatus(this.env.getRangeModel(1796998656), GUIMain.getSidebarSelectionRange(n));
        if (n == 0 || n == 1 || n == 2) {
            Util.setModelStatus(this.env.getListModel(1125910016), 0);
        } else {
            Util.setModelStatus(this.env.getListModel(1125910016), 1);
        }
    }

    private static int getSidebarSelectionRange(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
        }
        return 1;
    }

    @Override
    public void switchToNormalSidebar() {
        this.mGUILogChannel.log(1078071040, "GUIInterface#switchToNormalSidebar()");
        Util.setModelStatus(this.env.getRangeModel(1796998656), 0);
    }

    @Override
    public void showToolTip(String string, int n, int n2, int n3, Rect rect, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator, int n4) {
        if (bl2) {
            if (resourceLocator != null) {
                this.getMap().getViews().getMainMapView().showToolTipPicNav(string, resourceLocator);
            }
        } else {
            this.getMap().getViews().getMainMapView().showToolTip(string, bl, string2, n4);
        }
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForTMC(MapItemSelectionInfo mapItemSelectionInfo) {
        this.mGUILogChannel.log(-2137614336, "GUIMain#showToolTipTMC()");
        this.getMap().getViews().getMainMapView().showToolTipTMC(mapItemSelectionInfo);
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public MapItemSelectionAction hideToolTip() {
        this.getMap().getViews().getMainMapView().hideToolTip();
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public void hideOnlyToolTip() {
    }

    @Override
    public void refreshMapRepresentation() {
        if (this.naviMap.getMapRepresentation() != 1) {
            Util.setModelStatus(this.env.getChoiceModel(1780221440), 0);
            Util.setModelStatus(this.env.getButtonModel(52168192), 0);
        }
        this.setMapSetup3dMapGreyOut(this.checkMapSetup3dMapGreyOut());
        this.setMapSetupAutozoomGreyOut(this.checkMapSetupAutozoomGreyOut());
    }

    @Override
    public void refreshMapType(int n) {
        this.env.getChoiceModel(-1726151168).setValue(n);
        this.setMapSetupAutozoomGreyOut(this.checkMapSetupAutozoomGreyOut());
    }

    private boolean checkMapSetup3dMapGreyOut() {
        return this.naviMap.getMapRepresentation() == 3;
    }

    private boolean checkMapSetupAutozoomGreyOut() {
        int n = this.naviMap.getMapType();
        return this.naviMap.getMapRepresentation() == 3 || n == 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void drawAlternativeRoutesSelectionUI(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        Buffer buffer = new Buffer("CalculatedRouteListElement");
        Util.appendObjectArray(buffer, calculatedRouteListElementArray);
        this.getLogger().log(-2137614336, "GUIMain#drawAlternativeRoutesSelectionUI( %1 )", (Object)buffer);
        ListModelApp listModelApp = this.env.getListModel(1125910016);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-400751104);
        if (listModelApp.isTransactionRunning()) {
            this.getLogger().log(-1601830656, "GUIMain#drawAlternativeRoutesSelectionUI, end the transaction before doing the 2nd transaction!");
            listModelApp.endTransaction();
        }
        int n = 0;
        try {
            listModelApp.beginTransaction();
            RouteOptions[] routeOptionsArray = this.getMap().getRouteCalculationHandler().getRouteOptionsUsedForCalculation();
            if (routeOptionsArray == null) {
                routeOptionsArray = this.naviMap.getNaviInterface().getRouteCriteria().getRouteOptions(true);
            }
            buffer.clear();
            for (int i2 = 0; i2 < 3; ++i2) {
                ListCell[] listCellArray = new ListCell[13];
                int n2 = -1;
                long l = -1L;
                int n3 = 0;
                long l2 = 0L;
                int n4 = -1;
                boolean bl = true;
                if (calculatedRouteListElementArray != null && i2 < calculatedRouteListElementArray.length && calculatedRouteListElementArray[i2] != null) {
                    if (MapUtils.isCRLElementCalculated(calculatedRouteListElementArray[i2])) {
                        long l3;
                        ++n;
                        n2 = (int)calculatedRouteListElementArray[i2].getDistance();
                        l = calculatedRouteListElementArray[i2].getEtaWithSpeedAndFlowStatus() == 2 ? -1L : this.env.getFramework().getKombiTime() + calculatedRouteListElementArray[i2].getEtaWithSpeedAndFlow();
                        boolean bl2 = calculatedRouteListElementArray[i2].etaWithSpeedAndFlowStatus == 1;
                        l2 = l3 = calculatedRouteListElementArray[i2].getEtaWithSpeedAndFlow() - calculatedRouteListElementArray[i2].getEta();
                        n3 = l3 > 0L && bl2 ? 1 : (calculatedRouteListElementArray[i2].etaWithSpeedAndFlowStatus == 2 ? 2 : 0);
                        if (routeOptionsArray != null && i2 < routeOptionsArray.length) {
                            int n5 = routeOptionsArray[i2].getRouteType();
                            switch (n5) {
                                case 0: 
                                case 9: {
                                    n4 = 0;
                                    break;
                                }
                                case 1: {
                                    n4 = 1;
                                    break;
                                }
                                case 7: 
                                case 10: {
                                    n4 = 2;
                                    break;
                                }
                                case 5: {
                                    if (routeOptionsArray[i2].getTollroads() == 1) {
                                        n4 = 4;
                                        break;
                                    }
                                    n4 = 3;
                                    break;
                                }
                                default: {
                                    this.getLogger().log(-1601830656, "GUIMain#drawAlternativeRoutesSelectionUI() - unsupported route type : %1", (long)n5);
                                    n4 = -1;
                                }
                            }
                        }
                        bl = false;
                    } else if (calculatedRouteListElementArray[i2].calculationState == 4) {
                        bl = false;
                    }
                }
                listCellArray[1] = new LongListCell(l);
                listCellArray[0] = new IntegerListCell(n2, n2);
                listCellArray[5] = new IntegerListCell(n3, n3);
                listCellArray[6] = new LongListCell(l2);
                listCellArray[7] = IntegerListCell.create(bl ? 0 : 1);
                listCellArray[8] = IntegerListCell.create(n4);
                BaseListRow baseListRow = new BaseListRow(listCellArray);
                listModelApp.setRow(i2, baseListRow);
                if (!this.getLogger().isDebug()) continue;
                buffer.append("Route ").append(i2).append(": BaseListRow [CELL_POS_ETA=").append(baseListRow.getCell(1));
                buffer.append(", CELL_POS_ROUTE_LENGTH=").append(baseListRow.getCell(0));
                buffer.append(", CELL_POS_TRAFFIC_SYMBOL=").append(baseListRow.getCell(5));
                buffer.append(", CELL_POS_TRAFFIC_OFFSET=").append(baseListRow.getCell(6));
                buffer.append(", CELL_UPDATING_ICON_VISIBLE=").append(baseListRow.getCell(7));
                buffer.append(", CELL_ROUTE_TYPE=").append(baseListRow.getCell(8));
                buffer.append(i2 < 2 ? "], " : "]");
            }
            listModelApp.endTransaction();
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "GUIMain#drawAlternativeRoutesSelectionUI, exception occured during transaction! - %1", (Throwable)exception);
        }
        finally {
            if (listModelApp.isTransactionRunning()) {
                this.getLogger().log(10000, "GUIMain#drawAlternativeRoutesSelectionUI, transaction is still running, force end transaction and continue!");
                listModelApp.endTransaction();
            }
        }
        this.getLogger().log(-2137614336, "GUIMain#drawAlternativeRoutesSelectionUI() - count of valid routes: %1, %2", (Object)Integer.toString(n), (Object)buffer);
        choiceModelApp.setValue(n);
    }

    @Override
    public void updateChoiceValue(int n, int n2) {
        this.env.getChoiceModel(n).setValue(n2);
    }

    public void enablePOIInfo(boolean bl) {
        Util.setModelStatus(this.env.getRangeModel(1662780928), bl ? 1 : 0);
    }

    @Override
    public void enableScrollInfo(boolean bl) {
        Util.setModelStatus(this.env.getRangeModel(1813775872), bl ? 1 : 0);
    }

    @Override
    public void setMagnificationLimits(int n, int n2, int n3) {
        this.mGUILogChannel.log(-2137614336, "GUIInterface#setMagnificationLimits(%1, %2, %3)", (long)n, (long)n2, (long)n3);
        RangeModelApp rangeModelApp = this.env.getRangeModel(1545340416);
        int n4 = rangeModelApp.getMinimum();
        int n5 = rangeModelApp.getMaximum();
        boolean bl = false;
        if (n5 != n2 || n4 != n) {
            this.env.getRangeModel(1545340416).setLimits(n, n2, 1);
            bl |= true;
        }
        if (bl |= this.setMagnificationNoFlush(n3, true)) {
            this.updateMagnificationModelGroup();
        }
    }

    @Override
    public boolean setPinchZoomLimits(int n, int n2) {
        this.mGUILogChannel.log(-2137614336, "GUIInterface#setPinchZoomLimits( %1, %2 )", (long)n, (long)n2);
        RangeModelApp rangeModelApp = this.env.getRangeModel(35522048);
        int n3 = rangeModelApp.getMinimum();
        int n4 = rangeModelApp.getMaximum();
        if (n4 != n2 || n3 != n) {
            rangeModelApp.setLimits(n, n2, 1);
            return true;
        }
        return false;
    }

    @Override
    public void setMagnification(int n) {
        this.mGUILogChannel.log(-2137614336, "GUIInterface#setMagnification( %1 )", (long)n);
        this.setMagnification(n, true);
    }

    private void setMagnification(int n, boolean bl) {
        this.mGUILogChannel.log(14808325, "GUIInterface#setMagnification( %2, %1 )", bl, (long)n);
        if (this.setMagnificationNoFlush(n, bl)) {
            this.updateMagnificationModelGroup();
        }
    }

    private boolean setMagnificationNoFlush(int n, boolean bl) {
        this.mGUILogChannel.log(14808325, "GUIInterface#setMagnificationNoFlush( %2, %1 )", bl, (long)n);
        if (n < 0) {
            return false;
        }
        boolean bl2 = false;
        int n2 = this.env.getRangeModel(1545340416).getValue();
        if (n2 != n) {
            this.env.getRangeModel(1545340416).setValue(n);
            bl2 = true;
        }
        int n3 = 0;
        float f2 = 0.0f;
        float[] fArray = this.naviMap.getZoomHandler().getZoomList();
        if (fArray == null) {
            this.mGUILogChannel.log(-1601830656, "GUIInterface#setMagnificationNoFlush( %1 ) - failed to set value! zoomlist is null!", (long)n);
        } else {
            int n4 = n;
            if (n4 < 0) {
                n4 = 0;
            }
            if (n4 >= fArray.length) {
                n4 = fArray.length - 1;
            }
            f2 = fArray[n4] / 5292871;
            n3 = (int)(fArray[n4] + 63);
        }
        if (this.isUpdateMagnificationModelGroupNeccessary(f2)) {
            this.env.getMetricsModel(1528563200).setMetric(this.getDispatcher().getmMagnificationMetric());
            bl2 = true;
        }
        if (bl) {
            this.setPinchZoomValue(n3);
        }
        return bl2;
    }

    @Override
    public int getMagnificationValue(int n) {
        return this.env.getRangeModel(35522048).getValue();
    }

    @Override
    public int getMagnificationMaximum(int n) {
        return this.env.getRangeModel(35522048).getMaximum();
    }

    @Override
    public int getMagnificationMinimum(int n) {
        return this.env.getRangeModel(35522048).getMinimum();
    }

    @Override
    public void setPinchZoomValue(int n) {
        int n2 = this.env.getRangeModel(35522048).getValue();
        this.mGUILogChannel.log(-2137614336, "GUIInterface#setPinchZoomValue( %1 ) - oldValue: %2", (long)n, (long)n2);
        if (n < 0) {
            return;
        }
        if (n2 != n) {
            this.env.getRangeModel(35522048).setValue(n);
        }
    }

    @Override
    public void openOrCloseZoomBar(boolean bl) {
        this.env.getFramework().getHMIService().getEventDispatcher().doCheckedSleeping();
        RangeModelApp rangeModelApp = this.env.getRangeModel(1545340416);
        boolean bl2 = rangeModelApp.getPressed();
        if (bl2 != bl) {
            rangeModelApp.setPressed(bl);
            this.getDispatcher().getmMagnificationModelGroup().flush();
        }
    }

    @Override
    public boolean isZoomBarOpen() {
        RangeModelApp rangeModelApp = this.env.getRangeModel(1545340416);
        return rangeModelApp.getPressed();
    }

    @Override
    public void setRotation(int n) {
        this.env.getChoiceModel(1646003712).setValue(n & 0xFEFF0000);
    }

    @Override
    public void enableOrientation(boolean bl) {
        Util.setModelStatus(this.env.getChoiceModel(1646003712), bl ? 1 : 0);
    }

    @Override
    public void setDestDistanceNoUpdate(boolean bl, long l) {
        Distance distance = this.getDispatcher().getmDistance();
        distance.setValue((float)l / 31300);
        this.env.getMetricsModel(1947993600).setMetric(distance);
        this.env.getMetricsModel(1947993600).getMetric().setMetricValid(bl);
        this.env.getMetricsModel(1964770816).getMetric().setMetricValid(bl);
    }

    @Override
    public void clearDestDistance() {
        this.setDestDistanceNoUpdate(false, 0L);
        this.getDispatcher().getmModelGroup().flush();
    }

    @Override
    public boolean setETA(long l, int n, boolean bl) {
        DateMetric dateMetric = this.getDispatcher().getmEta();
        RgInfoForNextDestination rgInfoForNextDestination = this.env.getContainer().getRgInfoForNextDestination();
        int n2 = 0;
        if (rgInfoForNextDestination != null) {
            n2 = rgInfoForNextDestination.timeToNextDestStatus;
        } else {
            this.mGUILogChannel.log(-2137614336, "GUIInterface#setETA() - rgNextDestInfo == null");
        }
        boolean bl2 = n2 == 1;
        String string = dateMetric.format();
        dateMetric.setDate(bl2 ? l : -1L);
        if (string == null || !string.equals(dateMetric.format()) || bl) {
            this.env.getMetricsModel(1964770816).setMetric(dateMetric);
            return true;
        }
        return false;
    }

    @Override
    public boolean setRTT(long l, boolean bl) {
        DateMetric dateMetric = this.getDispatcher().getmRtt();
        boolean bl2 = this.naviMap.getRouteCalculationHandler().getTrafficDelayOnCurrentRoute() >= 0L;
        String string = dateMetric.format();
        dateMetric.setDate(bl2 ? l : -1L);
        if (string == null || !string.equals(dateMetric.format()) || bl) {
            this.env.getMetricsModel(1964770816).setMetric(dateMetric);
            return true;
        }
        return false;
    }

    @Override
    public void setDestinationIndex(int n) {
        this.env.getChoiceModel(1931216384).setValue(n);
    }

    @Override
    public void updateModelGroup() {
        this.getDispatcher().getmModelGroup().flush();
    }

    private void updateMagnificationModelGroup() {
        this.getDispatcher().getmMagnificationModelGroup().flush();
    }

    @Override
    public void setHeight(int n) {
        Distance distance = this.getDispatcher().getmHeight();
        String string = distance.format(Distance.getSystemUnit(), 2);
        distance.setValue((float)n / 31300);
        if (string == null || !string.equals(distance.format(Distance.getSystemUnit(), 2))) {
            this.setCCPAltitudeMetric(distance);
        }
    }

    public void setHeightInMeters(int n) {
        Distance distance = this.getDispatcher().getmHeight();
        String string = distance.format(Distance.getSystemUnit(), 2);
        distance.setValue(n);
        if (string == null || !string.equals(distance.format(Distance.getSystemUnit(), 2))) {
            this.setCCPAltitudeMetric(distance);
        }
    }

    public void setCCPAltitudeMetric(Distance distance) {
        this.env.getMetricsModel(1981548032).setMetric(distance);
    }

    @Override
    public void setSideBarRotaryIcon(int n) {
        int n2;
        int n3 = this.env.getRangeModel(1545340416).getStatus();
        if (n3 != n) {
            this.mGUILogChannel.log(-2137614336, "GUIInterface#setSideBarRotaryIcon( %1 ) - oldStatus: %2 [2=default/3=autoZoom/4=StreetViewAvailable/5=StreetViewLoading]", (long)n, (long)n3);
            this.env.getRangeModel(1545340416).setStatus(n);
            this.getDispatcher().getmMagnificationModelGroup().flush();
        }
        int n4 = this.env.getChoiceModel(253625856).getValue();
        int n5 = n2 = n == 3 ? 1 : 0;
        if (n4 != n2) {
            this.mGUILogChannel.log(-2137614336, "GUIInterface#setSideBarRotaryIcon() - oldValue: %1, newValue: %2 [0=autoZoom off/1=autoZoom on]", (long)n4, (long)n2);
            this.env.getChoiceModel(253625856).setValue(n2);
        }
    }

    @Override
    public int getSideBarRotaryIconState() {
        return this.env.getRangeModel(1545340416).getStatus();
    }

    @Override
    public void leaveBlockInRouteScreen(boolean bl) {
        if (bl) {
            this.env.getRangeModel(1562183168).fireEvent(0);
        } else {
            this.env.getButtonModel(119342592).fireEvent(0);
        }
    }

    @Override
    public void setSidebarBlockChoice(int n) {
        this.env.getChoiceModel(136119808).setValue(n);
    }

    @Override
    public void setTopBarVisible(boolean bl) {
        this.env.getChoiceModel(1193018880).setValue(bl ? 1 : 0);
        this.env.getChoiceModel(-417397248).setValue(bl ? 1 : 0);
    }

    @Override
    public void setScrollAlongRouteDirection(int n) {
        this.mGUILogChannel.log(-2137614336, "GUIInterface#setScrollAlongRouteDirection( %1 ) ", (long)n);
        this.env.getChoiceModel(656213504).setValue(n);
    }

    @Override
    public void setScrollAlongRouteDistance(String string) {
        this.mGUILogChannel.log(-2137614336, "GUIInterface#setScrollAlongRouteDistance( %1 ) ", (Object)string);
        this.env.getLabelModel(622659072).setText(string);
    }

    @Override
    public void setScrollAlongRouteDirectionAndDistanceVisible(boolean bl) {
        this.mGUILogChannel.log(-2137614336, "GUIInterface#setScrollAlongRouteDirectionAndDistanceVisible( %1 ) ", bl);
        if (bl) {
            Util.setModelStatus(this.env.getChoiceModel(639436288), 0);
        } else {
            Util.setModelStatus(this.env.getChoiceModel(639436288), 1);
        }
    }

    @Override
    public int getScreenWidth() {
        if (this.env.getFramework().isPorscheHigh() || this.env.getFramework().isBentley()) {
            return 800;
        }
        return this.layoutProvider.getScreenWidth();
    }

    @Override
    public int getScreenHeight() {
        if (this.env.getFramework().isPorscheHigh() || this.env.getFramework().isBentley()) {
            return 480;
        }
        return this.layoutProvider.getScreenHeight();
    }

    @Override
    public int getMapWidth() {
        return this.layoutProvider.getMapWidth();
    }

    @Override
    public int getMapHeight() {
        return this.layoutProvider.getMapHeight();
    }

    @Override
    public int getScreenSmallLeftOffset() {
        return this.getScreenLayoutAt(13);
    }

    @Override
    public int getScreenSmallRightOffset() {
        return this.getScreenLayoutAt(14);
    }

    @Override
    public int getStatusBarHeight() {
        return this.getScreenLayoutAt(2);
    }

    @Override
    public int getTopLineHeight() {
        return this.getScreenLayoutAt(9) + 10;
    }

    @Override
    public int getSideBarWidthOpen() {
        return this.getScreenLayoutAt(3);
    }

    @Override
    public int getSideBarWidth() {
        return this.getScreenLayoutAt(3);
    }

    @Override
    public int getSideBarWidthAR() {
        return this.getScreenLayoutAt(4);
    }

    @Override
    public int getMixedListOffset() {
        return this.getScreenLayoutAt(5);
    }

    @Override
    public int getScreenLayoutAt(int n) {
        ListModelApp listModelApp = this.getDispatcher().getmScreenLayout();
        int n2 = 0;
        if (listModelApp != null && listModelApp.getLength() != 0 && n < listModelApp.getMaxColumns()) {
            IntegerListCell integerListCell = (IntegerListCell)listModelApp.getCell(0, n);
            n2 = integerListCell == null ? 0 : integerListCell.getValue();
        }
        return n2;
    }

    @Override
    public void setCenterCarButtonVisibility(int n) {
        this.mGUILogChannel.log(14808325, "GUIInterface#setCenterCarButtonVisibility   1: visible, 0: hidden (%1)", (long)n);
        Util.setModelStatus(this.env.getButtonModel(1109132800), n);
    }

    boolean isCenterCarButtonVisible() {
        return this.env.getButtonModel(1109132800).getStatus() == 1;
    }

    int isAutoZoomAccepted() {
        return this.env.getChoiceModel(-1575156224).getStatus();
    }

    int isAutoZoomActive() {
        return this.env.getChoiceModel(-1575156224).getValue();
    }

    @Override
    public void setOnlineLogoVisible(boolean bl) {
        Util.setModelStatus(this.env.getLabelModel(-837024256), bl ? 1 : 0);
    }

    @Override
    public void setOptMenuType(int n) {
        this.updateChoiceValue(-736229888, n);
    }

    @Override
    public void setScrollOnRoutePressed(boolean bl) {
        this.mGUILogChannel.log(14808325, "GUIInterface#setScrollOnRoutePressed - status = %1", bl);
        this.setPressed(1813775872, bl);
        if (!bl) {
            this.setScrollAlongRouteDirectionAndDistanceVisible(bl);
        }
    }

    @Override
    public void setMapScrollSidebarPressed(int n, boolean bl) {
        this.mGUILogChannel.log(14808325, "GUIInterface#setMapScrollSidebarPressed - modelId = %2, status = %1", bl, (long)n);
        this.setPressed(n, bl);
    }

    @Override
    public boolean getScrollOnRoutePressed() {
        this.mGUILogChannel.log(14808325, "GUIInterface#getScrollOnRoutePressed");
        return this.getPressed(1813775872);
    }

    @Override
    public boolean getMapScrollSidebarPressed(int n) {
        this.mGUILogChannel.log(14808325, "GUIInterface#getMapScrollSidebarPressed() - modelId: %1", (long)n);
        return this.getPressed(n);
    }

    @Override
    public boolean isDemoMode() {
        return false;
    }

    @Override
    public int getCrosshairColorMode() {
        return this.env.getChoiceModel(19).getValue();
    }

    @Override
    public void setMapFollowUpPicNavImage(ResourceLocator resourceLocator) {
        this.mGUILogChannel.log(14808325, "GUIInterface#setMapFollowUpPicNavImage() - resourcelocator: %1", (Object)resourceLocator);
    }

    @Override
    public void setGEGreyOutOption(boolean bl) {
        this.mGUILogChannel.log(1078071040, "GUIInterface#setGEGreyOutOption() - geGreyout: %1", bl);
        this.env.getChoiceModel(-148830720).setValue(bl ? 0 : 1);
    }

    @Override
    public void fireHKBackEvent() {
        this.mGUILogChannel.log(-2137614336, "GUIMain#fireHKBackEvent()");
        VirtualButtonModelApp virtualButtonModelApp = this.env.getVirtualButtonModel(1813906944);
        virtualButtonModelApp.fireEvent(virtualButtonModelApp.getTerminalID());
    }

    @Override
    public void switchMapScreen(int n) {
        this.mGUILogChannel.log(-2137614336, "GUIMain#switchMapScreen( %1 ) - 0:standard, 1:briefing, 2:semidyn, 3:rubberband, 4:scrolling, 5: streetview", (long)n);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-467794432);
        switch (n) {
            case 1: {
                choiceModelApp.setValue(1);
                break;
            }
            case 2: {
                choiceModelApp.setValue(0);
                choiceModelApp.setStatus(1);
                break;
            }
            case 3: {
                choiceModelApp.setValue(0);
                choiceModelApp.setStatus(2);
                break;
            }
            case 4: {
                choiceModelApp.setValue(0);
                choiceModelApp.setStatus(3);
                break;
            }
            case 5: {
                choiceModelApp.setValue(0);
                choiceModelApp.setStatus(4);
                break;
            }
            case 6: {
                choiceModelApp.setValue(0);
                choiceModelApp.setStatus(5);
                break;
            }
            default: {
                choiceModelApp.setValue(0);
                choiceModelApp.setStatus(0);
            }
        }
    }

    @Override
    public void hidePopupBetterRouteAvailable() {
        this.getMap().getViews().getSemidynRGView().hidePopupBetterRouteAvailable();
    }

    @Override
    public void updateSetupModels(int n, int n2, int n3, int n4, int n5, int n6) {
        Buffer buffer = new Buffer();
        buffer.append("color=").append(n);
        buffer.append(", type=").append(n2);
        buffer.append(", display=").append(n3);
        buffer.append(", additional=").append(n4);
        buffer.append(", intersection=").append(n5);
        buffer.append(", autozoom=").append(n6);
        this.getLogger().log(-2137614336, "GUIMain#updateSetupModels() - %1", (Object)buffer.toString());
        this.getMap().getViews().getMapSetupView().updateSetupModels(n, n2, n3, n4, n5, n6);
    }

    @Override
    public void setGoogleSettingVisible(boolean bl) {
        this.getMap().getViews().getMapSetupView().setGoogleSettingVisible(bl);
    }

    @Override
    public void startRouteCalculation() {
        this.getLogger().log(-2137614336, "GUIMain#startRouteCalculation()");
        this.env.getChoiceModel(1981679104).setValue(4);
        this.env.getChoiceModel(723322368).setStatus(0);
    }

    @Override
    public void setRouteCriteriaIcons(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9) {
        this.getMap().getViews().getMainMapView().setRouteCriteriaIcons(n, bl, bl2, bl3, bl4, bl5, bl6, bl7, bl8, false, bl9);
    }

    @Override
    public int getRouteCriteriaBoxLeftOffset() {
        return this.getScreenLayoutAt(10);
    }

    @Override
    public void setFocusedProperty(int n) {
        this.getMap().getViews().getMainMapView().setFocusedProperty(n);
    }

    private String getScreenLayout() {
        Buffer buffer = new Buffer();
        buffer.append("COLUMN_SCREEN_WIDTH : ").append(this.getScreenLayoutAt(0));
        buffer.append("\nCOLUMN_SCREEN_HEIGH : ").append(this.getScreenLayoutAt(1));
        buffer.append("\nCOLUMN_DISTANCE_STATUSBAR_BOTTOM : ").append(this.getScreenLayoutAt(2));
        buffer.append("\nCOLUMN_DISTANCE_SIDEBAR_RIGHT : ").append(this.getScreenLayoutAt(3));
        buffer.append("\nCOLUMN_DISTANCE_SIDEBAR_AR_RIGHT : ").append(this.getScreenLayoutAt(4));
        buffer.append("\nCOLUMN_DISTANCE_ROUTEINFO_LEFT : ").append(this.getScreenLayoutAt(5));
        buffer.append("\nCOLUMN_DISTANCE_MAPTOOLTIP_UP : ").append(this.getScreenLayoutAt(6));
        buffer.append("\nCOLUMN_DISTANCE_MAPTOOLTIP_LEFT : ").append(this.getScreenLayoutAt(7));
        buffer.append("\nCOLUMN_DISTANCE_INFOLINE_BOTTOM : ").append(this.getScreenLayoutAt(8));
        buffer.append("\nCOLUMN_DISTANCE_REITERLINE_TOP : ").append(this.getScreenLayoutAt(9));
        buffer.append("\nCOLUMN_DISTANCE_ROUTECRITERIABOX_LEFT : ").append(this.getScreenLayoutAt(10));
        buffer.append("\nCOLUMN_DISTANCE_TUBE_LEFT : ").append(this.getScreenLayoutAt(11));
        buffer.append("\nCOLUMN_DISTANCE_TUBE_RIGHT : ").append(this.getScreenLayoutAt(12));
        buffer.append("\nCOLUMN_DISTANCE_TUBE_LEFT_KB : ").append(this.getScreenLayoutAt(13));
        buffer.append("\nCOLUMN_DISTANCE_TUBE_RIGHT_KB : ").append(this.getScreenLayoutAt(14));
        buffer.append("\nCOLUMN_DISTANCE_SIDEBAR_BOTTOM : ").append(this.getScreenLayoutAt(15));
        buffer.append("\nCOLUMN_DISTANCE_ROUTECRITERIABOX_TOP : ").append(this.getScreenLayoutAt(16));
        buffer.append("\nCOLUMN_DISTANCE_LEFT_DRAWER_ICON : ").append(this.getScreenLayoutAt(17));
        return buffer.toString();
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForAddressStreet(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForPoi(MapItemSelectionInfo mapItemSelectionInfo, Point point, boolean bl) {
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForTmc(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public void resetMapModels() {
    }

    protected AbstractLayoutProvider initLayoutProvider() {
        if (Util.isClusterMMI(this.env.getFramework())) {
            return new LayoutProviderG24(this.env);
        }
        return new LayoutProviderG22Main(this.env);
    }

    @Override
    public void setGridMaskVisible(boolean bl) {
        this.mGUILogChannel.log(-1601830656, "GUIMain#setGridMaskVisible( %1 ) ", bl);
        int n = bl ? 1 : 0;
        this.env.getChoiceModel(-618592768).setValue(n);
    }

    @Override
    public IMapPartialPopupHandler getPartialPopupHandler() {
        return new EmptyMapPartialPopupHandler(this.getLogger());
    }

    @Override
    public void resolvePicNavLocation(int n, int n2, ResourceLocator resourceLocator) {
    }

    protected int getIconResourceId(MapItemSelectionInfo mapItemSelectionInfo) {
        int n = -1;
        if (mapItemSelectionInfo.posInfo != null && mapItemSelectionInfo.posInfo.getTLocation() != null) {
            n = LocationFormatter.getIconResourceID(this.naviMap.getIconHandler(), mapItemSelectionInfo.posInfo.getTLocation());
        }
        if (n < 0 && mapItemSelectionInfo.navLocationAdditionalInfo != null) {
            n = LocationFormatter.getIconResourceID(this.naviMap.getIconHandler(), mapItemSelectionInfo.navLocationAdditionalInfo);
        }
        if (n < 0 && mapItemSelectionInfo.navLocationXtResolved != null) {
            n = LocationFormatter.getIconResourceID(this.naviMap.getIconHandler(), mapItemSelectionInfo.navLocationXtResolved);
        }
        return n;
    }

    @Override
    public void show(MapItemSelectionInfo mapItemSelectionInfo) {
        if (0 > mapItemSelectionInfo.posInfo.eInfoType || mapItemSelectionInfo.posInfo.eInfoType >= ConstantUtils.POSITIONINFOTYPE.length) {
            this.getLogger().log(-1601830656, "GUIMain#show() - invalid position info type : %1", (long)mapItemSelectionInfo.posInfo.eInfoType);
            return;
        }
        this.getLogger().log(-2137614336, "GUIMain#show( %1 ) - %2", (Object)ConstantUtils.POSITIONINFOTYPE[mapItemSelectionInfo.posInfo.eInfoType], (Object)mapItemSelectionInfo.toString());
        switch (mapItemSelectionInfo.posInfo.eInfoType) {
            case 4: {
                this.checkToShowToolTipForTMC(mapItemSelectionInfo);
                break;
            }
            case 3: {
                this.showToolTip(mapItemSelectionInfo.textDescriptionSingleLine, -1, -1, -1, null, null, true, false, null, this.getIconResourceId(mapItemSelectionInfo));
                break;
            }
            case 9: {
                this.showToolTip(mapItemSelectionInfo.textDescriptionSingleLine, -1, -1, -1, null, mapItemSelectionInfo.Url, false, true, mapItemSelectionInfo.getPicNavLocator(), -1);
                break;
            }
            case 0: {
                this.showToolTip(mapItemSelectionInfo.textDescriptionSingleLine, -1, -1, -1, null, mapItemSelectionInfo.Url, false, false, mapItemSelectionInfo.getPicNavLocator(), -1);
                break;
            }
            case 5: {
                this.showToolTip(mapItemSelectionInfo.textDescriptionSingleLine, -1, -1, -1, null, mapItemSelectionInfo.Url, false, false, mapItemSelectionInfo.getPicNavLocator(), -1);
                break;
            }
            default: {
                int n = -1;
                if (Util.isHURegionAsia()) {
                    n = this.getIconResourceId(mapItemSelectionInfo);
                }
                this.showToolTip(mapItemSelectionInfo.textDescriptionSingleLine, -1, -1, -1, null, mapItemSelectionInfo.Url, false, false, mapItemSelectionInfo.getPicNavLocator(), n);
            }
        }
    }

    @Override
    public MapItemSelectionAction checkToShow(MapItemSelectionInfo mapItemSelectionInfo, Point point, boolean bl, boolean bl2) {
        this.getLogger().log(-2137614336, "MapTooltip#show( %1, %2, %3 )", (Object)mapItemSelectionInfo, (Object)point, (Object)(bl ? "true" : "false"));
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public void showToolTip(String string, int n, int n2, PosInfo posInfo, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator) {
        this.getLogger().log(-2137614336, "MapTooltip#showToolTip(String str, int x, int y, PosInfo positionInfo, String url, boolean isStack, boolean isPicNav, ResourceLocator picNavLocator)");
    }

    @Override
    public ToolTipTimer getTooltipTimer() {
        return this.tooltipTimer;
    }

    protected void setMapSetupAutozoomGreyOut(boolean bl) {
        this.mGUILogChannel.log(1078071040, "GUIMain#setMapSetupAutozoomGreyOut() - greyOut: %1", bl);
        this.env.getChoiceModel(-1575156224).setStatus(bl ? 0 : 1);
    }

    protected void setMapSetup3dMapGreyOut(boolean bl) {
        this.mGUILogChannel.log(1078071040, "GUIMain#setMapSetup3dMapGreyOut() - greyOut: %1", bl);
        this.env.getChoiceModel(1294075392).setValue(bl ? 0 : 1);
    }

    @Override
    public boolean updateTollInfoJP(CalculatedRouteListElement calculatedRouteListElement) {
        return this.getMap().getViews().getMainMapView().updateTollInfoJP(calculatedRouteListElement);
    }

    @Override
    public void hideCrosshairs() {
        this.mGUILogChannel.log(-2137614336, "GUIMain#hideCrosshairs()");
        IntegerListCell integerListCell = (IntegerListCell)this.mCrosshairs.getCell(0, 2);
        if (integerListCell.getValue() != 0) {
            IntegerListCell integerListCell2 = IntegerListCell.create(0);
            this.mCrosshairs.setCell(0, 2, integerListCell2);
        }
    }

    @Override
    public void showCrosshairs(int n, int n2) {
        this.mGUILogChannel.log(-2137614336, "GUIMain#showCrosshairs(coordX: %1, coordY: %2), coordX, coordY");
        IntegerListCell integerListCell = IntegerListCell.create(n);
        this.mCrosshairs.setCell(0, 0, integerListCell);
        integerListCell = IntegerListCell.create(n2);
        this.mCrosshairs.setCell(0, 1, integerListCell);
        integerListCell = IntegerListCell.create(1);
        this.mCrosshairs.setCell(0, 2, integerListCell);
    }

    @Override
    public void setTrafficNoticeMapActive(boolean bl) {
        this.mGUILogChannel.log(14808325, "GUIMain#setTrafficNoticeMapActive(%1)", bl);
        this.env.getChoiceModel(-417200640).setValue(bl ? 1 : 0);
    }

    @Override
    public void show(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
    }

    protected int getNumAltRoutesModel() {
        return -400751104;
    }

    @Override
    public AbstractLayoutProvider getLayout() {
        return this.layoutProvider;
    }

    @Override
    public ListModelApp getRouteInfoBox() {
        return null;
    }

    @Override
    public void updateStateIndicator(PropertyEnum propertyEnum, int n) {
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForTmc(TmcMessage tmcMessage) {
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public void newPoiPreviewMapSelectionMade(boolean bl) {
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForNavi(NavLocation navLocation, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForNaviWithoutPin(NavLocation navLocation, String string, GuiTooltipInformationContainer guiTooltipInformationContainer, boolean bl) {
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForOffroadTour(GuiTooltipInformationContainer guiTooltipInformationContainer) {
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public boolean isUpdateMagnificationModelGroupNeccessary(float f2) {
        Distance distance = this.getDispatcher().getmMagnificationMetric();
        String string = distance.format(Distance.getSystemUnit(), 4);
        distance.setValue(f2);
        return string == null || !string.equals(distance.format(Distance.getSystemUnit(), 4));
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForPoiOnline(NavLocation navLocation, boolean bl, boolean bl2, boolean bl3, String string) {
        return new MapItemSelectionActionDoNothing();
    }
}

