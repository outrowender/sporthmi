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
import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;
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
        abstractMap.getViews().getMapOptionView().setShowDetailsOfCrosshairListener(new SimpleButtonListener(){

            public void keyReleased(int n, int n2, int n3) {
                GUIMain.this.getMap().getActiveContext().keyReleased(n, n2);
            }
        });
        this.setGridMaskVisible(false);
        this.setMapSetup3dMapGreyOut(false);
        this.setMapSetupAutozoomGreyOut(false);
        this.tooltipTimer = new ToolTipTimer(navigationEnv, abstractMap.getMapLogChannel(), abstractMap);
        this.mCrosshairs = navigationEnv.getListModel(402064);
        this.mCrosshairs.setMaxColumns(3);
        this.mCrosshairs.setMaxRows(1);
        ListCell[] listCellArray = new ListCell[]{IntegerListCell.create(0), IntegerListCell.create(0), IntegerListCell.create(0)};
        this.mCrosshairs.addRow(listCellArray);
        this.layoutProvider = this.initLayoutProvider();
        this.partialPopup = iMapPartialPopupHandler;
    }

    public boolean warningsOnTheRoadActive() {
        return this.env.getChoiceModel(401466).getValue() == 1;
    }

    public int naviMapLayoutList() {
        return 176;
    }

    public int navOffroadStatusChoice() {
        return 400573;
    }

    protected String getName() {
        return "GUIMain";
    }

    protected GUIEventDispatcher getDispatcher() {
        return this.getMap().getMapManager().getGUIEventDispatcher();
    }

    public void fireModelEvent(int n) {
        this.getLogger().log(10000000, "GUIMain#fireModelEvent( %1 )", (long)n);
        int n2 = this.env.getFramework().isFrontMU() ? 0 : 5;
        this.env.fireModelEvent(n, n2);
    }

    public void controlMixedListNoUpdate(int n) {
        this.getDispatcher().getmMixedListControllerChoice().setValue(n);
    }

    public void controlMixedList(int n, int n2) {
        if (n2 != 3) {
            Util.setModelStatus(this.getDispatcher().getmMixedListControllerChoice(), n2);
        }
        this.controlMixedListNoUpdate(n);
        this.getDispatcher().getmModelGroup().flush();
    }

    public int getSidebarState() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(400447);
        return choiceModelApp.getValue();
    }

    public void closeSidebarWithoutAnimation() {
        this.setScrollOnRoutePressed(false);
        this.setMapScrollSidebarPressed(400443, false);
        this.setMapScrollSidebarPressed(400181, false);
        this.openOrCloseSidebar(0);
    }

    public void openOrCloseSidebar(int n) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(400447);
        int n2 = choiceModelApp.getValue();
        if (n == 3 && n2 == 0) {
            this.mGUILogChannel.log(1000000, "GUIInterface#openOrCloseSidebar() - not closing sidebar. sidebar already closed.");
        } else if (n == 1 && n2 == 2) {
            this.mGUILogChannel.log(1000000, "GUIInterface#openOrCloseSidebar() - not opening sidebar. sidebar already open.");
        } else {
            choiceModelApp.setValue(n);
        }
    }

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

    public void setCursorForPOIMap(int n) {
        this.env.getChoiceModel(400452).setValue(n);
    }

    public void switchToRouteSelectionSidebar(int n) {
        this.mGUILogChannel.log(1000000, "GUIInterface#switchToRouteSelectionSidebar( %1 )", (long)n);
        Util.setModelStatus(this.env.getRangeModel(400491), GUIMain.getSidebarSelectionRange(n));
        if (n == 0 || n == 1 || n == 2) {
            Util.setModelStatus(this.env.getListModel(400451), 0);
        } else {
            Util.setModelStatus(this.env.getListModel(400451), 1);
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

    public void switchToNormalSidebar() {
        this.mGUILogChannel.log(1000000, "GUIInterface#switchToNormalSidebar()");
        Util.setModelStatus(this.env.getRangeModel(400491), 0);
    }

    public void showToolTip(String string, int n, int n2, int n3, Rect rect, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator, int n4) {
        if (bl2) {
            if (resourceLocator != null) {
                this.getMap().getViews().getMainMapView().showToolTipPicNav(string, resourceLocator);
            }
        } else {
            this.getMap().getViews().getMainMapView().showToolTip(string, bl, string2, n4);
        }
    }

    public MapItemSelectionAction checkToShowToolTipForTMC(MapItemSelectionInfo mapItemSelectionInfo) {
        this.mGUILogChannel.log(10000000, "GUIMain#showToolTipTMC()");
        this.getMap().getViews().getMainMapView().showToolTipTMC(mapItemSelectionInfo);
        return new MapItemSelectionActionDoNothing();
    }

    public MapItemSelectionAction hideToolTip() {
        this.getMap().getViews().getMainMapView().hideToolTip();
        return new MapItemSelectionActionDoNothing();
    }

    public void hideOnlyToolTip() {
    }

    public void refreshMapRepresentation() {
        if (this.naviMap.getMapRepresentation() != 1) {
            Util.setModelStatus(this.env.getChoiceModel(400490), 0);
            Util.setModelStatus(this.env.getButtonModel(400387), 0);
        }
        this.setMapSetup3dMapGreyOut(this.checkMapSetup3dMapGreyOut());
        this.setMapSetupAutozoomGreyOut(this.checkMapSetupAutozoomGreyOut());
    }

    public void refreshMapType(int n) {
        this.env.getChoiceModel(400793).setValue(n);
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
    public void drawAlternativeRoutesSelectionUI(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        Buffer buffer = new Buffer("CalculatedRouteListElement");
        Util.appendObjectArray(buffer, calculatedRouteListElementArray);
        this.getLogger().log(10000000, "GUIMain#drawAlternativeRoutesSelectionUI( %1 )", (Object)buffer);
        ListModelApp listModelApp = this.env.getListModel(400451);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(400872);
        if (listModelApp.isTransactionRunning()) {
            this.getLogger().log(100000, "GUIMain#drawAlternativeRoutesSelectionUI, end the transaction before doing the 2nd transaction!");
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
                                    this.getLogger().log(100000, "GUIMain#drawAlternativeRoutesSelectionUI() - unsupported route type : %1", (long)n5);
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
        this.getLogger().log(10000000, "GUIMain#drawAlternativeRoutesSelectionUI() - count of valid routes: %1, %2", (Object)Integer.toString(n), (Object)buffer);
        choiceModelApp.setValue(n);
    }

    public void updateChoiceValue(int n, int n2) {
        this.env.getChoiceModel(n).setValue(n2);
    }

    public void enablePOIInfo(boolean bl) {
        Util.setModelStatus(this.env.getRangeModel(400483), bl ? 1 : 0);
    }

    public void enableScrollInfo(boolean bl) {
        Util.setModelStatus(this.env.getRangeModel(400492), bl ? 1 : 0);
    }

    public void setMagnificationLimits(int n, int n2, int n3) {
        this.mGUILogChannel.log(10000000, "GUIInterface#setMagnificationLimits(%1, %2, %3)", (long)n, (long)n2, (long)n3);
        RangeModelApp rangeModelApp = this.env.getRangeModel(400476);
        int n4 = rangeModelApp.getMinimum();
        int n5 = rangeModelApp.getMaximum();
        boolean bl = false;
        if (n5 != n2 || n4 != n) {
            this.env.getRangeModel(400476).setLimits(n, n2, 1);
            bl |= true;
        }
        if (bl |= this.setMagnificationNoFlush(n3, true)) {
            this.updateMagnificationModelGroup();
        }
    }

    public boolean setPinchZoomLimits(int n, int n2) {
        this.mGUILogChannel.log(10000000, "GUIInterface#setPinchZoomLimits( %1, %2 )", (long)n, (long)n2);
        RangeModelApp rangeModelApp = this.env.getRangeModel(400898);
        int n3 = rangeModelApp.getMinimum();
        int n4 = rangeModelApp.getMaximum();
        if (n4 != n2 || n3 != n) {
            rangeModelApp.setLimits(n, n2, 1);
            return true;
        }
        return false;
    }

    public void setMagnification(int n) {
        this.mGUILogChannel.log(10000000, "GUIInterface#setMagnification( %1 )", (long)n);
        this.setMagnification(n, true);
    }

    private void setMagnification(int n, boolean bl) {
        this.mGUILogChannel.log(100000000, "GUIInterface#setMagnification( %2, %1 )", bl, (long)n);
        if (this.setMagnificationNoFlush(n, bl)) {
            this.updateMagnificationModelGroup();
        }
    }

    private boolean setMagnificationNoFlush(int n, boolean bl) {
        this.mGUILogChannel.log(100000000, "GUIInterface#setMagnificationNoFlush( %2, %1 )", bl, (long)n);
        if (n < 0) {
            return false;
        }
        boolean bl2 = false;
        int n2 = this.env.getRangeModel(400476).getValue();
        if (n2 != n) {
            this.env.getRangeModel(400476).setValue(n);
            bl2 = true;
        }
        int n3 = 0;
        float f2 = 0.0f;
        float[] fArray = this.naviMap.getZoomHandler().getZoomList();
        if (fArray == null) {
            this.mGUILogChannel.log(100000, "GUIInterface#setMagnificationNoFlush( %1 ) - failed to set value! zoomlist is null!", (long)n);
        } else {
            int n4 = n;
            if (n4 < 0) {
                n4 = 0;
            }
            if (n4 >= fArray.length) {
                n4 = fArray.length - 1;
            }
            f2 = fArray[n4] / 100000.0f;
            n3 = (int)(fArray[n4] + 0.5f);
        }
        if (this.isUpdateMagnificationModelGroupNeccessary(f2)) {
            this.env.getMetricsModel(400475).setMetric(this.getDispatcher().getmMagnificationMetric());
            bl2 = true;
        }
        if (bl) {
            this.setPinchZoomValue(n3);
        }
        return bl2;
    }

    public int getMagnificationValue(int n) {
        return this.env.getRangeModel(400898).getValue();
    }

    public int getMagnificationMaximum(int n) {
        return this.env.getRangeModel(400898).getMaximum();
    }

    public int getMagnificationMinimum(int n) {
        return this.env.getRangeModel(400898).getMinimum();
    }

    public void setPinchZoomValue(int n) {
        int n2 = this.env.getRangeModel(400898).getValue();
        this.mGUILogChannel.log(10000000, "GUIInterface#setPinchZoomValue( %1 ) - oldValue: %2", (long)n, (long)n2);
        if (n < 0) {
            return;
        }
        if (n2 != n) {
            this.env.getRangeModel(400898).setValue(n);
        }
    }

    public void openOrCloseZoomBar(boolean bl) {
        this.env.getFramework().getHMIService().getEventDispatcher().doCheckedSleeping();
        RangeModelApp rangeModelApp = this.env.getRangeModel(400476);
        boolean bl2 = rangeModelApp.getPressed();
        if (bl2 != bl) {
            rangeModelApp.setPressed(bl);
            this.getDispatcher().getmMagnificationModelGroup().flush();
        }
    }

    public boolean isZoomBarOpen() {
        RangeModelApp rangeModelApp = this.env.getRangeModel(400476);
        return rangeModelApp.getPressed();
    }

    public void setRotation(int n) {
        this.env.getChoiceModel(400482).setValue(n & 0xFFFE);
    }

    public void enableOrientation(boolean bl) {
        Util.setModelStatus(this.env.getChoiceModel(400482), bl ? 1 : 0);
    }

    public void setDestDistanceNoUpdate(boolean bl, long l) {
        Distance distance = this.getDispatcher().getmDistance();
        distance.setValue((float)l / 1000.0f);
        this.env.getMetricsModel(400500).setMetric(distance);
        this.env.getMetricsModel(400500).getMetric().setMetricValid(bl);
        this.env.getMetricsModel(400501).getMetric().setMetricValid(bl);
    }

    public void clearDestDistance() {
        this.setDestDistanceNoUpdate(false, 0L);
        this.getDispatcher().getmModelGroup().flush();
    }

    public boolean setETA(long l, int n, boolean bl) {
        DateMetric dateMetric = this.getDispatcher().getmEta();
        RgInfoForNextDestination rgInfoForNextDestination = this.env.getContainer().getRgInfoForNextDestination();
        int n2 = 0;
        if (rgInfoForNextDestination != null) {
            n2 = rgInfoForNextDestination.timeToNextDestStatus;
        } else {
            this.mGUILogChannel.log(10000000, "GUIInterface#setETA() - rgNextDestInfo == null");
        }
        boolean bl2 = n2 == 1;
        String string = dateMetric.format();
        dateMetric.setDate(bl2 ? l : -1L);
        if (string == null || !string.equals(dateMetric.format()) || bl) {
            this.env.getMetricsModel(400501).setMetric(dateMetric);
            return true;
        }
        return false;
    }

    public boolean setRTT(long l, boolean bl) {
        DateMetric dateMetric = this.getDispatcher().getmRtt();
        boolean bl2 = this.naviMap.getRouteCalculationHandler().getTrafficDelayOnCurrentRoute() >= 0L;
        String string = dateMetric.format();
        dateMetric.setDate(bl2 ? l : -1L);
        if (string == null || !string.equals(dateMetric.format()) || bl) {
            this.env.getMetricsModel(400501).setMetric(dateMetric);
            return true;
        }
        return false;
    }

    public void setDestinationIndex(int n) {
        this.env.getChoiceModel(400499).setValue(n);
    }

    public void updateModelGroup() {
        this.getDispatcher().getmModelGroup().flush();
    }

    private void updateMagnificationModelGroup() {
        this.getDispatcher().getmMagnificationModelGroup().flush();
    }

    public void setHeight(int n) {
        Distance distance = this.getDispatcher().getmHeight();
        String string = distance.format(Distance.getSystemUnit(), 2);
        distance.setValue((float)n / 1000.0f);
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
        this.env.getMetricsModel(400502).setMetric(distance);
    }

    public void setSideBarRotaryIcon(int n) {
        int n2;
        int n3 = this.env.getRangeModel(400476).getStatus();
        if (n3 != n) {
            this.mGUILogChannel.log(10000000, "GUIInterface#setSideBarRotaryIcon( %1 ) - oldStatus: %2 [2=default/3=autoZoom/4=StreetViewAvailable/5=StreetViewLoading]", (long)n, (long)n3);
            this.env.getRangeModel(400476).setStatus(n);
            this.getDispatcher().getmMagnificationModelGroup().flush();
        }
        int n4 = this.env.getChoiceModel(400911).getValue();
        int n5 = n2 = n == 3 ? 1 : 0;
        if (n4 != n2) {
            this.mGUILogChannel.log(10000000, "GUIInterface#setSideBarRotaryIcon() - oldValue: %1, newValue: %2 [0=autoZoom off/1=autoZoom on]", (long)n4, (long)n2);
            this.env.getChoiceModel(400911).setValue(n2);
        }
    }

    public int getSideBarRotaryIconState() {
        return this.env.getRangeModel(400476).getStatus();
    }

    public void leaveBlockInRouteScreen(boolean bl) {
        if (bl) {
            this.env.getRangeModel(400733).fireEvent(0);
        } else {
            this.env.getButtonModel(400647).fireEvent(0);
        }
    }

    public void setSidebarBlockChoice(int n) {
        this.env.getChoiceModel(400648).setValue(n);
    }

    public void setTopBarVisible(boolean bl) {
        this.env.getChoiceModel(400455).setValue(bl ? 1 : 0);
        this.env.getChoiceModel(401383).setValue(bl ? 1 : 0);
    }

    public void setScrollAlongRouteDirection(int n) {
        this.mGUILogChannel.log(10000000, "GUIInterface#setScrollAlongRouteDirection( %1 ) ", (long)n);
        this.env.getChoiceModel(400679).setValue(n);
    }

    public void setScrollAlongRouteDistance(String string) {
        this.mGUILogChannel.log(10000000, "GUIInterface#setScrollAlongRouteDistance( %1 ) ", (Object)string);
        this.env.getLabelModel(400677).setText(string);
    }

    public void setScrollAlongRouteDirectionAndDistanceVisible(boolean bl) {
        this.mGUILogChannel.log(10000000, "GUIInterface#setScrollAlongRouteDirectionAndDistanceVisible( %1 ) ", bl);
        if (bl) {
            Util.setModelStatus(this.env.getChoiceModel(400678), 0);
        } else {
            Util.setModelStatus(this.env.getChoiceModel(400678), 1);
        }
    }

    public int getScreenWidth() {
        if (this.env.getFramework().isPorscheHigh() || this.env.getFramework().isBentley()) {
            return 800;
        }
        return this.layoutProvider.getScreenWidth();
    }

    public int getScreenHeight() {
        if (this.env.getFramework().isPorscheHigh() || this.env.getFramework().isBentley()) {
            return 480;
        }
        return this.layoutProvider.getScreenHeight();
    }

    public int getMapWidth() {
        return this.layoutProvider.getMapWidth();
    }

    public int getMapHeight() {
        return this.layoutProvider.getMapHeight();
    }

    public int getScreenSmallLeftOffset() {
        return this.getScreenLayoutAt(13);
    }

    public int getScreenSmallRightOffset() {
        return this.getScreenLayoutAt(14);
    }

    public int getStatusBarHeight() {
        return this.getScreenLayoutAt(2);
    }

    public int getTopLineHeight() {
        return this.getScreenLayoutAt(9) + 10;
    }

    public int getSideBarWidthOpen() {
        return this.getScreenLayoutAt(3);
    }

    public int getSideBarWidth() {
        return this.getScreenLayoutAt(3);
    }

    public int getSideBarWidthAR() {
        return this.getScreenLayoutAt(4);
    }

    public int getMixedListOffset() {
        return this.getScreenLayoutAt(5);
    }

    public int getScreenLayoutAt(int n) {
        ListModelApp listModelApp = this.getDispatcher().getmScreenLayout();
        int n2 = 0;
        if (listModelApp != null && listModelApp.getLength() != 0 && n < listModelApp.getMaxColumns()) {
            IntegerListCell integerListCell = (IntegerListCell)listModelApp.getCell(0, n);
            n2 = integerListCell == null ? 0 : integerListCell.getValue();
        }
        return n2;
    }

    public void setCenterCarButtonVisibility(int n) {
        this.mGUILogChannel.log(100000000, "GUIInterface#setCenterCarButtonVisibility   1: visible, 0: hidden (%1)", (long)n);
        Util.setModelStatus(this.env.getButtonModel(400450), n);
    }

    boolean isCenterCarButtonVisible() {
        return this.env.getButtonModel(400450).getStatus() == 1;
    }

    int isAutoZoomAccepted() {
        return this.env.getChoiceModel(400802).getStatus();
    }

    int isAutoZoomActive() {
        return this.env.getChoiceModel(400802).getValue();
    }

    public void setOnlineLogoVisible(boolean bl) {
        Util.setModelStatus(this.env.getLabelModel(400590), bl ? 1 : 0);
    }

    public void setOptMenuType(int n) {
        this.updateChoiceValue(401108, n);
    }

    public void setScrollOnRoutePressed(boolean bl) {
        this.mGUILogChannel.log(100000000, "GUIInterface#setScrollOnRoutePressed - status = %1", bl);
        this.setPressed(400492, bl);
        if (!bl) {
            this.setScrollAlongRouteDirectionAndDistanceVisible(bl);
        }
    }

    public void setMapScrollSidebarPressed(int n, boolean bl) {
        this.mGUILogChannel.log(100000000, "GUIInterface#setMapScrollSidebarPressed - modelId = %2, status = %1", bl, (long)n);
        this.setPressed(n, bl);
    }

    public boolean getScrollOnRoutePressed() {
        this.mGUILogChannel.log(100000000, "GUIInterface#getScrollOnRoutePressed");
        return this.getPressed(400492);
    }

    public boolean getMapScrollSidebarPressed(int n) {
        this.mGUILogChannel.log(100000000, "GUIInterface#getMapScrollSidebarPressed() - modelId: %1", (long)n);
        return this.getPressed(n);
    }

    public boolean isDemoMode() {
        return false;
    }

    public int getCrosshairColorMode() {
        return this.env.getChoiceModel(19).getValue();
    }

    public void setMapFollowUpPicNavImage(ResourceLocator resourceLocator) {
        this.mGUILogChannel.log(100000000, "GUIInterface#setMapFollowUpPicNavImage() - resourcelocator: %1", (Object)resourceLocator);
    }

    public void setGEGreyOutOption(boolean bl) {
        this.mGUILogChannel.log(1000000, "GUIInterface#setGEGreyOutOption() - geGreyout: %1", bl);
        this.env.getChoiceModel(401911).setValue(bl ? 0 : 1);
    }

    public void fireHKBackEvent() {
        this.mGUILogChannel.log(10000000, "GUIMain#fireHKBackEvent()");
        VirtualButtonModelApp virtualButtonModelApp = this.env.getVirtualButtonModel(401004);
        virtualButtonModelApp.fireEvent(virtualButtonModelApp.getTerminalID());
    }

    public void switchMapScreen(int n) {
        this.mGUILogChannel.log(10000000, "GUIMain#switchMapScreen( %1 ) - 0:standard, 1:briefing, 2:semidyn, 3:rubberband, 4:scrolling, 5: streetview", (long)n);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(401124);
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

    public void hidePopupBetterRouteAvailable() {
        this.getMap().getViews().getSemidynRGView().hidePopupBetterRouteAvailable();
    }

    public void updateSetupModels(int n, int n2, int n3, int n4, int n5, int n6) {
        Buffer buffer = new Buffer();
        buffer.append("color=").append(n);
        buffer.append(", type=").append(n2);
        buffer.append(", display=").append(n3);
        buffer.append(", additional=").append(n4);
        buffer.append(", intersection=").append(n5);
        buffer.append(", autozoom=").append(n6);
        this.getLogger().log(10000000, "GUIMain#updateSetupModels() - %1", (Object)buffer.toString());
        this.getMap().getViews().getMapSetupView().updateSetupModels(n, n2, n3, n4, n5, n6);
    }

    public void setGoogleSettingVisible(boolean bl) {
        this.getMap().getViews().getMapSetupView().setGoogleSettingVisible(bl);
    }

    public void startRouteCalculation() {
        this.getLogger().log(10000000, "GUIMain#startRouteCalculation()");
        this.env.getChoiceModel(401014).setValue(4);
        this.env.getChoiceModel(400683).setStatus(0);
    }

    public void setRouteCriteriaIcons(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9) {
        this.getMap().getViews().getMainMapView().setRouteCriteriaIcons(n, bl, bl2, bl3, bl4, bl5, bl6, bl7, bl8, false, bl9);
    }

    public int getRouteCriteriaBoxLeftOffset() {
        return this.getScreenLayoutAt(10);
    }

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

    public MapItemSelectionAction checkToShowToolTipForAddressStreet(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
        return new MapItemSelectionActionDoNothing();
    }

    public MapItemSelectionAction checkToShowToolTipForPoi(MapItemSelectionInfo mapItemSelectionInfo, Point point, boolean bl) {
        return new MapItemSelectionActionDoNothing();
    }

    public MapItemSelectionAction checkToShowToolTipForTmc(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
        return new MapItemSelectionActionDoNothing();
    }

    public void resetMapModels() {
    }

    protected AbstractLayoutProvider initLayoutProvider() {
        if (Util.isClusterMMI(this.env.getFramework())) {
            return new LayoutProviderG24(this.env);
        }
        return new LayoutProviderG22Main(this.env);
    }

    public void setGridMaskVisible(boolean bl) {
        this.mGUILogChannel.log(100000, "GUIMain#setGridMaskVisible( %1 ) ", bl);
        int n = bl ? 1 : 0;
        this.env.getChoiceModel(401883).setValue(n);
    }

    public IMapPartialPopupHandler getPartialPopupHandler() {
        return new EmptyMapPartialPopupHandler(this.getLogger());
    }

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

    public void show(MapItemSelectionInfo mapItemSelectionInfo) {
        if (0 > mapItemSelectionInfo.posInfo.eInfoType || mapItemSelectionInfo.posInfo.eInfoType >= ConstantUtils.POSITIONINFOTYPE.length) {
            this.getLogger().log(100000, "GUIMain#show() - invalid position info type : %1", (long)mapItemSelectionInfo.posInfo.eInfoType);
            return;
        }
        this.getLogger().log(10000000, "GUIMain#show( %1 ) - %2", (Object)ConstantUtils.POSITIONINFOTYPE[mapItemSelectionInfo.posInfo.eInfoType], (Object)mapItemSelectionInfo.toString());
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

    public MapItemSelectionAction checkToShow(MapItemSelectionInfo mapItemSelectionInfo, Point point, boolean bl, boolean bl2) {
        this.getLogger().log(10000000, "MapTooltip#show( %1, %2, %3 )", (Object)mapItemSelectionInfo, (Object)point, (Object)(bl ? "true" : "false"));
        return new MapItemSelectionActionDoNothing();
    }

    public void showToolTip(String string, int n, int n2, PosInfo posInfo, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator) {
        this.getLogger().log(10000000, "MapTooltip#showToolTip(String str, int x, int y, PosInfo positionInfo, String url, boolean isStack, boolean isPicNav, ResourceLocator picNavLocator)");
    }

    public ToolTipTimer getTooltipTimer() {
        return this.tooltipTimer;
    }

    protected void setMapSetupAutozoomGreyOut(boolean bl) {
        this.mGUILogChannel.log(1000000, "GUIMain#setMapSetupAutozoomGreyOut() - greyOut: %1", bl);
        this.env.getChoiceModel(400802).setStatus(bl ? 0 : 1);
    }

    protected void setMapSetup3dMapGreyOut(boolean bl) {
        this.mGUILogChannel.log(1000000, "GUIMain#setMapSetup3dMapGreyOut() - greyOut: %1", bl);
        this.env.getChoiceModel(401997).setValue(bl ? 0 : 1);
    }

    public boolean updateTollInfoJP(CalculatedRouteListElement calculatedRouteListElement) {
        return this.getMap().getViews().getMainMapView().updateTollInfoJP(calculatedRouteListElement);
    }

    public void hideCrosshairs() {
        this.mGUILogChannel.log(10000000, "GUIMain#hideCrosshairs()");
        IntegerListCell integerListCell = (IntegerListCell)this.mCrosshairs.getCell(0, 2);
        if (integerListCell.getValue() != 0) {
            IntegerListCell integerListCell2 = IntegerListCell.create(0);
            this.mCrosshairs.setCell(0, 2, integerListCell2);
        }
    }

    public void showCrosshairs(int n, int n2) {
        this.mGUILogChannel.log(10000000, "GUIMain#showCrosshairs(coordX: %1, coordY: %2), coordX, coordY");
        IntegerListCell integerListCell = IntegerListCell.create(n);
        this.mCrosshairs.setCell(0, 0, integerListCell);
        integerListCell = IntegerListCell.create(n2);
        this.mCrosshairs.setCell(0, 1, integerListCell);
        integerListCell = IntegerListCell.create(1);
        this.mCrosshairs.setCell(0, 2, integerListCell);
    }

    public void setTrafficNoticeMapActive(boolean bl) {
        this.mGUILogChannel.log(100000000, "GUIMain#setTrafficNoticeMapActive(%1)", bl);
        this.env.getChoiceModel(402151).setValue(bl ? 1 : 0);
    }

    public void show(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
    }

    protected int getNumAltRoutesModel() {
        return 400872;
    }

    public AbstractLayoutProvider getLayout() {
        return this.layoutProvider;
    }

    public ListModelApp getRouteInfoBox() {
        return null;
    }

    public void updateStateIndicator(PropertyEnum propertyEnum, int n) {
    }

    public MapItemSelectionAction checkToShowToolTipForTmc(TmcMessage tmcMessage) {
        return new MapItemSelectionActionDoNothing();
    }

    public void newPoiPreviewMapSelectionMade(boolean bl) {
    }

    public MapItemSelectionAction checkToShowToolTipForNavi(NavLocation navLocation, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        return new MapItemSelectionActionDoNothing();
    }

    public MapItemSelectionAction checkToShowToolTipForNaviWithoutPin(NavLocation navLocation, String string, GuiTooltipInformationContainer guiTooltipInformationContainer, boolean bl) {
        return new MapItemSelectionActionDoNothing();
    }

    public MapItemSelectionAction checkToShowToolTipForOffroadTour(GuiTooltipInformationContainer guiTooltipInformationContainer) {
        return new MapItemSelectionActionDoNothing();
    }

    public boolean isUpdateMagnificationModelGroupNeccessary(float f2) {
        Distance distance = this.getDispatcher().getmMagnificationMetric();
        String string = distance.format(Distance.getSystemUnit(), 4);
        distance.setValue(f2);
        return string == null || !string.equals(distance.format(Distance.getSystemUnit(), 4));
    }

    public MapItemSelectionAction checkToShowToolTipForPoiOnline(NavLocation navLocation, boolean bl, boolean bl2, boolean bl3, String string) {
        return new MapItemSelectionActionDoNothing();
    }
}

