/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.property.PropertyModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IMapPropertyProvider;
import de.audi.tghu.navi.app.map.IView;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Date;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class MainMapView
implements IView {
    private final NavigationEnv env;
    private final IMapPropertyProvider mapPropertyProvider;
    public final BaseListModelApp mTooltip;
    private final ResourceLocatorModelApp mPicNavResLocator;
    private final ButtonModelApp mBtnShowAltRoute;
    private final ChoiceModelApp mLeftDrawerState;
    private final ButtonModelApp mOptMenuRubberband;
    private final PropertyModelApp mFocusedInfo;
    private final ListModelApp mRouteCriterionBox;
    private final BaseListModelApp mTollInfoBoxJP;
    private final ChoiceModelApp mHasTrafficDelay;
    private final MetricsModelApp mTrafficDelay;
    public ModelGroup mTooltipModels;
    private final int parkingAtThisLocationProperty;
    private int languageIndex;

    public MainMapView(NavigationEnv navigationEnv, IMapPropertyProvider iMapPropertyProvider) {
        this.env = navigationEnv;
        this.mapPropertyProvider = iMapPropertyProvider;
        this.mTooltipModels = new ModelGroup();
        this.mTooltip = navigationEnv.getBaseListModel(401365);
        this.mTooltip.append(new TooltipRow());
        this.mTooltip.setStatus(0);
        this.mPicNavResLocator = navigationEnv.getResourceLocatorModel(400506);
        this.mTooltipModels.add(this.mTooltip);
        this.mTooltipModels.add(this.mPicNavResLocator);
        this.mLeftDrawerState = navigationEnv.getChoiceModel(401401);
        this.mOptMenuRubberband = navigationEnv.getButtonModel(401402);
        this.mBtnShowAltRoute = navigationEnv.getButtonModel(400497);
        this.mHasTrafficDelay = navigationEnv.getChoiceModel(401466);
        this.mTrafficDelay = navigationEnv.getMetricsModel(401467);
        this.mFocusedInfo = navigationEnv.getPropertyModel(401551);
        this.mRouteCriterionBox = this.createListModelAppWithDefaultRouteBriefingIcons();
        this.mTollInfoBoxJP = Util.isHURegionJP() ? this.createListModelDefaultTollJP() : null;
        this.parkingAtThisLocationProperty = this.mapPropertyProvider.getDestParkingAtThisLocation();
        this.languageIndex = navigationEnv.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex();
    }

    private LogChannel getLogger() {
        return this.env.getLogChannel("App.Map.GUI.Main");
    }

    private boolean isTooltipVisible() {
        return this.mTooltip.getStatus() == 1;
    }

    public void showToolTip(String string) {
        if (string != null && string.trim().length() > 0) {
            this.getLogger().log(100000000, "MainMapView#showToolTip() - %1", (Object)string);
            this.mTooltip.setRow(0, TooltipRow.createTextOnly(string));
            this.mTooltip.setStatus(1);
            this.mTooltipModels.flush();
        } else {
            this.hideToolTip();
        }
    }

    public void showToolTip(String string, boolean bl, String string2, int n) {
        if (string != null && string.trim().length() > 0) {
            this.getLogger().log(100000000, "MainMapView#showToolTip() - %1", (Object)string);
            if (bl) {
                this.mTooltip.setRow(0, TooltipRow.createStack(string));
            } else if (n > 0) {
                this.mTooltip.setRow(0, TooltipRow.createPOI(string, n));
            } else if (!Util.isEmpty(string2)) {
                this.mTooltip.setRow(0, TooltipRow.createOnline(string));
            } else {
                this.mTooltip.setRow(0, TooltipRow.createTextOnly(string));
            }
            this.mTooltip.setStatus(1);
            this.mTooltipModels.flush();
        } else {
            this.hideToolTip();
        }
    }

    public void showToolTipTMC(MapItemSelectionInfo mapItemSelectionInfo) {
        this.getLogger().log(100000000, "MainMapView#showToolTipTMC, selectedValue is: (%1)", (Object)mapItemSelectionInfo);
        ExtRenderingInfo extRenderingInfo = mapItemSelectionInfo.tmc_roadSignInfo;
        String string = mapItemSelectionInfo.textDescriptionSingleLine;
        String string2 = mapItemSelectionInfo.tmc_roadNr;
        int n = mapItemSelectionInfo.tmc_eventIconID;
        IconCell iconCell = null;
        if (extRenderingInfo != null && extRenderingInfo.isValid()) {
            iconCell = new IconCell(new HMIResourceLocator(extRenderingInfo.getResourceId()), string2, extRenderingInfo.getFontReference(), extRenderingInfo.getFontSize(), extRenderingInfo.getFontColor(), extRenderingInfo.getDeltaX(), extRenderingInfo.getDeltaY());
        }
        IconCell iconCell2 = new IconCell(new HMIResourceLocator(n));
        this.mTooltip.setRow(0, TooltipRow.createTMC(string, iconCell, iconCell2));
        this.mTooltip.setStatus(1);
        this.mTooltipModels.flush();
    }

    public void showToolTipPicNav(String string, ResourceLocator resourceLocator) {
        this.getLogger().log(100000000, "MainMapView#showToolTipPicNav()");
        this.mTooltip.setRow(0, TooltipRow.createPicNav(string));
        this.mTooltip.setStatus(1);
        this.mPicNavResLocator.setResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
        this.mTooltipModels.flush();
    }

    public void hideToolTip() {
        this.getLogger().log(10000000, "MainMapView#hideToolTip() - isTooltipVisible = %1", this.isTooltipVisible());
        this.mTooltip.setRow(0, TooltipRow.createEmpty());
        this.mTooltip.setStatus(0);
        this.mTooltipModels.flush();
    }

    public void setLeftSideVisible(boolean bl) {
        this.getLogger().log(10000000, "MainMapView#setLeftSideVisible( %1 )", bl);
        this.mLeftDrawerState.setValue(bl ? 1 : 0);
    }

    public void addOptMenuRubberbandListener(ButtonListener buttonListener) {
        this.mOptMenuRubberband.setButtonListener(buttonListener);
    }

    public void setShowAltRouteListener(ButtonListener buttonListener) {
        this.mBtnShowAltRoute.setButtonListener(buttonListener);
    }

    public void setTrafficDelay(long l) {
        if (!Util.isPorscheGen2(this.env.getFramework())) {
            if (l != 0L) {
                this.mTrafficDelay.setMetric(new DateMetric(new Date(l), this.mapPropertyProvider.getPrefferedDelayFormat()));
                this.mHasTrafficDelay.setValue(l > 0L ? 1 : 2);
            } else {
                this.mTrafficDelay.setMetric(null);
                this.mHasTrafficDelay.setValue(0);
            }
        } else if (l >= 240000L) {
            this.mTrafficDelay.setMetric(new DateMetric(new Date(l), this.mapPropertyProvider.getPrefferedDelayFormat()));
            this.mHasTrafficDelay.setValue(l > 0L ? 1 : 2);
        } else {
            this.mTrafficDelay.setMetric(null);
            this.mHasTrafficDelay.setValue(0);
        }
    }

    private ListCell[] getDefaultRouteBriefingOptions() {
        this.getLogger().log(10000000, "MainMapView#getDefaultRouteBriefingOptions()");
        IntegerListCell integerListCell = IntegerListCell.create(0);
        ListCell[] listCellArray = new ListCell[11];
        listCellArray[0] = integerListCell;
        listCellArray[1] = IntegerListCell.create(0);
        listCellArray[2] = integerListCell;
        listCellArray[3] = integerListCell;
        listCellArray[4] = integerListCell;
        listCellArray[8] = integerListCell;
        listCellArray[6] = integerListCell;
        listCellArray[5] = integerListCell;
        listCellArray[9] = integerListCell;
        listCellArray[7] = integerListCell;
        listCellArray[10] = integerListCell;
        return listCellArray;
    }

    private ListModelApp createListModelAppWithRouteBriefingIcons(ListCell[] listCellArray) {
        this.getLogger().log(10000000, "MainMapView#createListModelAppWithRouteBriefingIcons()");
        ListModelApp listModelApp = this.env.getListModel(400990);
        listModelApp.clear();
        listModelApp.setMaxColumns(11);
        listModelApp.addRow(listCellArray);
        return listModelApp;
    }

    private ListModelApp createListModelAppWithDefaultRouteBriefingIcons() {
        return this.createListModelAppWithRouteBriefingIcons(this.getDefaultRouteBriefingOptions());
    }

    public void setRouteCriteriaIcons(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10) {
        Buffer buffer = new Buffer().append("reroutingType:").append(n).append(", ferry:").append(bl2).append(", motorail:").append(bl3).append(", avoid freeway:").append(bl4).append(", vignette:").append(bl5).append(", tollroad:").append(bl6).append(", avoid timeRestricted:").append(bl7).append(", seasonallyRestricted:").append(bl8).append(", enableTrailerMode:").append(bl9).append(", HOVLanes:").append(bl10);
        this.getLogger().log(10000000, "MainMapView#setRouteCriteriaIcons() - %1", (Object)buffer.toString());
        IntegerListCell integerListCell = IntegerListCell.create(1);
        IntegerListCell integerListCell2 = IntegerListCell.create(0);
        this.mRouteCriterionBox.beginTransaction();
        this.mRouteCriterionBox.setCell(0, 0, bl10 ? integerListCell : integerListCell2);
        this.mRouteCriterionBox.setCell(0, 1, IntegerListCell.create(n));
        this.mRouteCriterionBox.setCell(0, 2, bl ? integerListCell : integerListCell2);
        this.mRouteCriterionBox.setCell(0, 3, bl2 ? integerListCell : integerListCell2);
        this.mRouteCriterionBox.setCell(0, 4, bl3 ? integerListCell : integerListCell2);
        this.mRouteCriterionBox.setCell(0, 8, bl4 ? integerListCell : integerListCell2);
        this.mRouteCriterionBox.setCell(0, 6, bl5 ? integerListCell : integerListCell2);
        this.mRouteCriterionBox.setCell(0, 5, bl6 ? integerListCell : integerListCell2);
        this.mRouteCriterionBox.setCell(0, 9, bl7 ? integerListCell : integerListCell2);
        this.mRouteCriterionBox.setCell(0, 7, bl8 ? integerListCell : integerListCell2);
        this.mRouteCriterionBox.setCell(0, 10, bl9 ? integerListCell : integerListCell2);
        this.mRouteCriterionBox.endTransaction();
    }

    private BaseListModelApp createListModelDefaultTollJP() {
        this.getLogger().log(10000000, "MainMapView#createListModelDefaultTollJP()");
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(401968);
        baseListModelApp.removeAll();
        baseListModelApp.setStatus(0);
        EvoListRow evoListRow = new EvoListRow(0L, 4);
        evoListRow.setText(0, "");
        evoListRow.setText(1, "");
        evoListRow.setText(2, "");
        evoListRow.setText(3, "");
        baseListModelApp.append(evoListRow);
        return baseListModelApp;
    }

    public boolean updateTollInfoJP(CalculatedRouteListElement calculatedRouteListElement) {
        this.getLogger().log(1000000, "MainMapView#updateTollInfoJP()");
        if (this.mTollInfoBoxJP == null) {
            return false;
        }
        this.languageIndex = this.env.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex();
        this.mTollInfoBoxJP.setStatus(0);
        if (calculatedRouteListElement != null && calculatedRouteListElement.additionalRouteDataKeys != null && calculatedRouteListElement.additionalRouteDataKeys.length > 0) {
            this.mTollInfoBoxJP.removeAll();
            String string = Util.getMotorwayEntryExit(this.getLogger(), calculatedRouteListElement, 1, "");
            String string2 = Util.getMotorwayEntryExit(this.getLogger(), calculatedRouteListElement, 2, "");
            this.getLogger().log(1000000, "MainMapView#updateTollInfoJP() - exitName: %1, entranceName: %2", (Object)string2, (Object)string);
            EvoListRow evoListRow = new EvoListRow(calculatedRouteListElement.tollLength, 4);
            evoListRow.setText(0, string);
            evoListRow.setText(1, string2);
            evoListRow.setText(2, Util.formatDistance((int)calculatedRouteListElement.tollLength, 5));
            if (calculatedRouteListElement.tollCostAmount >= 0L) {
                String string3 = Util.formatJapaneseYen(calculatedRouteListElement.tollCostAmount, this.languageIndex);
                if (string3 == null) {
                    this.getLogger().log(10000, "MainMapView#updateTollInfoJP() - could not format toll cost, tollCostAmount: %1, languageIndex: %2", calculatedRouteListElement.tollCostAmount, (long)this.languageIndex);
                    string3 = "";
                }
                evoListRow.setText(3, string3);
            } else {
                evoListRow.setText(3, "");
            }
            this.mTollInfoBoxJP.append(evoListRow);
            this.mTollInfoBoxJP.setStatus(1);
            return true;
        }
        this.getLogger().log(10000000, "MainMapView#updateTollInfoJP() - hide toll info box.");
        this.mTollInfoBoxJP.setStatus(0);
        this.mTollInfoBoxJP.removeAll();
        return false;
    }

    public void setFocusedProperty(int n) {
        int[] nArray;
        if (this.mapPropertyProvider == null) {
            this.getLogger().log(100000, "MainMapView#setFocusedProperty( %1 ) - no mapPropertyProvider", (long)n);
            return;
        }
        this.getLogger().log(10000000, "MainMapView#setFocusedProperty( %1 )", (long)n);
        int n2 = -1;
        boolean bl = false;
        switch (n) {
            case -1: {
                bl = false;
                break;
            }
            case 1: {
                n2 = this.mapPropertyProvider.getDestOnBoardPOI();
                bl = true;
                break;
            }
            case 5: {
                n2 = this.mapPropertyProvider.getDestGoogle();
                bl = true;
                break;
            }
            case 9: {
                n2 = this.mapPropertyProvider.getDestPicNav();
                bl = true;
                break;
            }
            case 3: {
                n2 = this.mapPropertyProvider.getDestPOIStack();
                bl = true;
                break;
            }
            case 4: {
                n2 = this.mapPropertyProvider.getDestTMCEvent();
                bl = true;
                break;
            }
            default: {
                n2 = this.mapPropertyProvider.getDestCoordinate();
                bl = true;
            }
        }
        if (bl) {
            int[] nArray2 = new int[2];
            nArray2[0] = n2;
            nArray = nArray2;
            nArray2[1] = this.parkingAtThisLocationProperty;
        } else {
            nArray = new int[]{};
        }
        int[] nArray3 = nArray;
        this.mFocusedInfo.setProperties(this.mapPropertyProvider.getDrawerCategoryNaviMapView(), nArray3);
    }

    public void setOptionIconVisible(boolean bl) {
        this.getLogger().log(10000000, "MainMapView#setOptionIconVisible( %1 )", bl);
        this.env.getChoiceModel(401689).setValue(bl ? 0 : 1);
    }

    public static class TooltipRow
    extends EvoListRow {
        public static TooltipRow createTextOnly(String string) {
            return new TooltipRow(0, string, null, null, null, -1);
        }

        public static TooltipRow createStack(String string) {
            return new TooltipRow(0, string, null, null, null, 2);
        }

        public static TooltipRow createPOI(String string, int n) {
            HMIResourceLocator hMIResourceLocator = new HMIResourceLocator(n);
            return new TooltipRow(1, string, hMIResourceLocator, null, null, -1);
        }

        public static TooltipRow createOnline(String string) {
            return new TooltipRow(0, string, null, null, null, 1);
        }

        public static TooltipRow createTMC(String string, IconCell iconCell, IconCell iconCell2) {
            TooltipRow tooltipRow = new TooltipRow(2, string, null, null, null, -1);
            tooltipRow.setIconCell(3, iconCell);
            tooltipRow.setIconCell(4, iconCell2);
            return tooltipRow;
        }

        public static TooltipRow createPicNav(String string) {
            return new TooltipRow(3, string, null, null, null, -1);
        }

        public static TooltipRow createEmpty() {
            return new TooltipRow();
        }

        protected TooltipRow(EvoListRow evoListRow) {
            super(evoListRow);
            this.setInteger(0, evoListRow.getInteger(0));
            this.setText(1, evoListRow.getText(1));
            this.setIconCell(2, (IconCell)evoListRow.getCell(2));
            this.setIconCell(3, (IconCell)evoListRow.getCell(3));
            this.setIconCell(4, (IconCell)evoListRow.getCell(4));
            this.setInteger(5, evoListRow.getInteger(5));
        }

        protected TooltipRow() {
            this(-1, "", null, null, null, -1);
        }

        protected TooltipRow(int n, String string, HMIResourceLocator hMIResourceLocator, HMIResourceLocator hMIResourceLocator2, HMIResourceLocator hMIResourceLocator3, int n2) {
            super(0L, 6);
            this.setInteger(0, n);
            this.setText(1, string);
            this.setIconCell(2, new IconCell(hMIResourceLocator));
            this.setIconCell(3, new IconCell(hMIResourceLocator2));
            this.setIconCell(4, new IconCell(hMIResourceLocator3));
            this.setInteger(5, n2);
        }
    }
}

