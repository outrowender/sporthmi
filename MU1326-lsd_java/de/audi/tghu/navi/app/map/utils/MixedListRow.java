/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.atip.hmi.intercommunication.MixedListConstants;
import de.audi.atip.hmi.intercommunication.MixedListConstants$LaneGuidance;
import de.audi.atip.hmi.intercommunication.MixedListConstants$TollGateInfo;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.map.routeinfo.LaneGuidanceWrapper;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelper;
import de.audi.tghu.navi.app.map.utils.MixedListRow$IRouteInfoEnv;
import de.audi.tghu.navi.app.util.IconUtil;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Date;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.AdditionalTurnListIcon;
import org.dsi.ifc.navigation.ManeuverElement;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListDataIcon;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public class MixedListRow
extends BaseListRow
implements MixedListConstants,
Comparable {
    private static final int TRAFFIC_LIGHT_ICON_VISIBLE;
    private static final int TRAFFIC_LIGHT_ICON_INVISIBLE;
    public static final int REAL_TURN_FALSE;
    public static final int REAL_TURN_TRUE;
    public static final String DEFAULT_EMPTY_STRING;
    protected MixedListRow$IRouteInfoEnv env;
    private LogChannel logger;
    public int content = -1;
    public String name = "";
    public long mDistance;
    public int destinationIndex;
    private LaneGuidanceWrapper lastLaneGuidanceWrapper = null;

    public MixedListRow(MixedListRow$IRouteInfoEnv iRouteInfoEnv, LogChannel logChannel) {
        this(new ListCell[69], iRouteInfoEnv, logChannel);
    }

    private MixedListRow(ListCell[] listCellArray, MixedListRow$IRouteInfoEnv mixedListRow$IRouteInfoEnv, LogChannel logChannel) {
        super(new ListCell[69]);
        boolean bl;
        this.env = mixedListRow$IRouteInfoEnv;
        this.logger = logChannel;
        listCellArray[0] = IntegerListCell.create(3);
        listCellArray[1] = this.env.getHelper().createEmptyIconCell();
        listCellArray[2] = this.env.getHelper().createEmptyIconCell();
        listCellArray[3] = this.env.getHelper().createEmptyTextListCell();
        listCellArray[66] = this.env.getHelper().createEmptyTextListCell();
        listCellArray[67] = this.env.getHelper().createEmptyTextListCell();
        listCellArray[4] = this.env.getHelper().createEmptyTextListCell();
        listCellArray[65] = this.env.getHelper().createZeroLongListCell();
        listCellArray[5] = this.env.getHelper().createEmptyIconCell();
        listCellArray[6] = this.env.getHelper().createEmptyIconCell();
        listCellArray[7] = this.env.getHelper().createEmptyIconCell();
        listCellArray[8] = this.env.getHelper().createEmptyIconCell();
        listCellArray[9] = this.env.getHelper().createEmptyIconCell();
        listCellArray[10] = this.env.getHelper().createEmptyIconCell();
        listCellArray[11] = this.env.getHelper().createEmptyTextListCell();
        listCellArray[12] = this.env.getHelper().createEmptyTextListCell();
        listCellArray[13] = this.env.getHelper().createEmptyTextListCell();
        listCellArray[14] = IntegerListCell.create(52);
        listCellArray[15] = IntegerListCell.create(53);
        listCellArray[16] = IntegerListCell.create(54);
        listCellArray[17] = IntegerListCell.create(55);
        listCellArray[18] = this.env.getHelper().createEmptyTextListCell();
        listCellArray[19] = this.env.getHelper().createEmptyTextListCell();
        listCellArray[20] = IntegerListCell.create(51);
        listCellArray[21] = this.env.getHelper().createEmptyIconCell();
        listCellArray[22] = new TextListCell(this.env.getTranslatedText(4));
        listCellArray[24] = this.env.getHelper().createEmptyIconCell();
        listCellArray[25] = new TextListCell(this.env.getTranslatedText(6));
        listCellArray[26] = this.env.getHelper().createEmptyTextListCell();
        listCellArray[27] = this.env.getHelper().createEmptyIconCell();
        boolean bl2 = bl = this.env.getNavigationEnv().getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex() == 26;
        if (bl) {
            listCellArray[28] = new TextListCell(this.env.getTranslatedText(3));
            listCellArray[29] = new TextListCell(this.env.getTranslatedText(0));
        } else {
            listCellArray[28] = new TextListCell(this.env.getTranslatedText(0));
            listCellArray[29] = new TextListCell(this.env.getTranslatedText(3));
        }
        listCellArray[30] = this.env.getHelper().createEmptyIconCell();
        listCellArray[31] = this.env.getHelper().createEmptyIconCell();
        listCellArray[32] = this.env.getHelper().createEmptyIconCell();
        listCellArray[33] = this.env.getHelper().createEmptyIconCell();
        listCellArray[34] = this.env.getHelper().createEmptyIconCell();
        listCellArray[35] = this.env.getHelper().createEmptyIconCell();
        listCellArray[36] = this.env.getHelper().createEmptyIconCell();
        listCellArray[37] = this.env.getHelper().createEmptyIconCell();
        listCellArray[38] = new TextListCell(this.env.getTranslatedText(1));
        listCellArray[45] = new IconCell(new HMIResourceLocator(-1, HMIResourceLocator.UNDEFINED_URI));
        listCellArray[46] = IntegerListCell.create(0);
        listCellArray[47] = this.env.getHelper().createZeroLongListCell();
        listCellArray[48] = IntegerListCell.create(0);
        listCellArray[51] = new TextListCell(this.env.formatDistStr(0L));
        listCellArray[52] = new TextListCell(this.env.getHelper().formatMillisecond(0L));
        listCellArray[49] = this.env.getHelper().createEmptyTextListCell();
        listCellArray[60] = new ObjectListCell(new MixedListConstants$TollGateInfo());
        listCellArray[61] = new ObjectListCell(new MixedListConstants$LaneGuidance());
        listCellArray[62] = this.env.getHelper().createZeroLongListCell();
        listCellArray[63] = this.env.getHelper().createZeroLongListCell();
        if (Util.isPorsche(this.env.getNavigationEnv().getFramework())) {
            listCellArray[22] = this.env.getHelper().createEmptyTextListCell();
        }
        listCellArray[64] = IntegerListCell.create(0);
        listCellArray[54] = this.env.getHelper().createEmptyTextListCell();
        listCellArray[68] = IntegerListCell.create(1);
        this.setCells(listCellArray);
    }

    private LogChannel getLogger() {
        return this.logger;
    }

    public boolean equals(Object object) {
        return this == object;
    }

    public String getDistToDestination() {
        switch (this.getCellFormat()) {
            case 1: {
                return this.getText(12);
            }
            case 2: 
            case 18: 
            case 21: 
            case 22: {
                return this.getText(4);
            }
        }
        return this.getText(19);
    }

    public final boolean isFormat(int n) {
        return this.getInteger(0) == n;
    }

    public boolean isBorderCrossingElement() {
        switch (this.getCellFormat()) {
            case 6: 
            case 7: 
            case 8: {
                return true;
            }
        }
        return false;
    }

    public boolean hasCellFormat(int n) {
        return this.getInteger(0) == n;
    }

    public int getCellFormat() {
        return ((IntegerListCell)this.getCell(0)).getValue();
    }

    public void setCellFormat(int n) {
        this.setInteger(0, n);
    }

    private void setCellDistanceToDest(long l) {
        ((LongListCell)this.getCell(47)).setValue(l);
        this.setCell(51, new TextListCell(this.env.formatDistStr(l)));
        this.setCell(62, new LongListCell(l));
    }

    private void setCellDestinationImage(HMIResourceLocator hMIResourceLocator) {
        ((IconCell)this.getCell(45)).setResourceLocator(hMIResourceLocator);
    }

    private void setCellBorderCrossingCountryFlag(int n) {
        this.getCells()[27] = new IconCell(new HMIResourceLocator(n));
    }

    public void setCellBorderCrossingTextPassing(String string) {
        this.setText(25, string);
        this.fillPrimaryText();
    }

    public void setCellBorderCrossingTextAllowedVelocity1(String string) {
        this.setText(28, string);
    }

    public void setCellBorderCrossingTextAllowedVelocity2(String string) {
        this.setText(29, string);
    }

    private void setCellBorderCrossingDistance(String string) {
        this.setText(26, string);
    }

    public void setCellBorderCrossingTextSpeedUnit(String string) {
        this.setText(38, string);
    }

    private void setCellBorderCrossingRoadclassIcon(int n, int n2) {
        this.getCells()[30 + n] = new IconCell(new HMIResourceLocator(n2));
    }

    private void setCellBorderCrossingSpeedIcon(int n, int n2) {
        this.getCells()[34 + n] = new IconCell(new HMIResourceLocator(n2));
    }

    private void setCellTurnArrow(int n) {
        this.setInteger(20, n);
    }

    public void setCellTurnRoadNameOr2ndLine(String string) {
        this.setText(18, string);
        this.fillPrimaryText();
    }

    private String getCellTurnRoadName() {
        return this.getText(18);
    }

    private void setCellTurnDistance(String string) {
        this.setText(19, string);
    }

    public void setCellUnifierID(int n) {
        this.setInteger(48, n);
    }

    protected void setCellPoiIcon(int n, int n2) {
        this.getCells()[5 + n] = new IconCell(new HMIResourceLocator(n2));
    }

    private void setCellTrafficLightIconVisibility(int n, int n2) {
        this.setInteger(68 + n, n2);
    }

    public void setCellPoiNameOr1stLine(String string) {
        this.setText(11, string);
        this.fillPrimaryText();
    }

    private String getCellPoiName() {
        return this.getText(11);
    }

    private void setCellPoiDistance(String string) {
        this.setText(12, string);
    }

    private void setCellPoiEta(DateMetric dateMetric) {
        this.setText(13, dateMetric.format());
        this.setCell(52, new TextListCell(dateMetric.format(5)));
        this.setCell(63, new LongListCell(dateMetric.getDate().getTime()));
    }

    private void setCellExitSign(int n) {
        ((IconCell)this.getCell(24)).initializeIconSimpleLocator(new HMIResourceLocator(n));
    }

    private void setCellExitSign(int n, String string, int n2, int n3, int n4, int n5, int n6) {
        ((IconCell)this.getCell(24)).initializeIconTextLocator(new HMIResourceLocator(n), string, n2, n3, n4, n5, n6);
    }

    private IconCell getCellTMCRoadIcon() {
        return (IconCell)this.getCell(2);
    }

    private void setCellTMCEventIcon(int n) {
        ((IconCell)this.getCell(1)).initializeIconSimpleLocator(new HMIResourceLocator(n));
    }

    private void setCellTMCEventText(String string) {
        this.setText(3, string);
        this.fillPrimaryText();
    }

    private void setCellTMCEventCause(String string) {
        this.setText(66, string);
    }

    private void setCellTMCRoadName(String string) {
        this.setText(67, string);
    }

    private void setCellTMCDistance(String string) {
        this.setText(4, string);
    }

    private void setCellTMCEventDelay(long l) {
        this.setCell(65, new LongListCell(l * 0));
    }

    public void setCellCalculating(String string) {
        this.setText(22, string);
    }

    private void setCellRoadDirection(String string) {
        this.setText(49, string);
    }

    private void setCellTollgateInfo(MixedListConstants$TollGateInfo mixedListConstants$TollGateInfo) {
        this.getCells()[60] = new ObjectListCell(mixedListConstants$TollGateInfo);
    }

    private void setCellLaneGuidance(MixedListConstants$LaneGuidance mixedListConstants$LaneGuidance) {
        this.getCells()[61] = new ObjectListCell(mixedListConstants$LaneGuidance);
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < this.getCells().length; ++i2) {
            buffer.append(this.getCell(i2).toString()).append(", ");
        }
        return buffer.toString();
    }

    public void updateDistanceToCCP() {
        String string = this.env.formatDistStr(this.mDistance);
        switch (this.getCellFormat()) {
            case 1: {
                this.setText(12, string);
                break;
            }
            case 2: 
            case 18: 
            case 21: 
            case 22: {
                this.setText(4, string);
                break;
            }
            default: {
                this.setText(19, string);
            }
        }
    }

    public void updateValuesForTurns(TurnListElement turnListElement) {
        if (null == turnListElement) {
            this.getLogger().log(1078071040, "MixedListRow#updateValuesForTurns() - turnListElement is null");
            return;
        }
        if (null == turnListElement.getManeuver()) {
            this.getLogger().log(1078071040, "MixedListRow#updateValuesForTurns() - turnListElement-maneuver is null");
            return;
        }
        if (turnListElement.getManeuver().length < 1) {
            this.getLogger().log(1078071040, "MixedListRow#updateValuesForTurns() - turnListElement-maneuver-lenth: %1", (long)turnListElement.getManeuver().length);
            return;
        }
        ManeuverElement maneuverElement = turnListElement.getManeuver()[0];
        int n = maneuverElement.getElement();
        this.name = this.env.getHelper().determineDisplayName(turnListElement);
        this.mDistance = turnListElement.getDistance();
        this.setCellDistanceToDest(this.mDistance);
        this.destinationIndex = turnListElement.destinationIndex;
        this.setCellDestinationImage(new HMIResourceLocator(-1, HMIResourceLocator.UNDEFINED_URI));
        if (n == 136) {
            this.updateTurnForBorderCrossing(turnListElement);
        } else {
            this.updateTurnDefault(turnListElement);
        }
        this.setInteger(46, this.env.getHelper().isRealTurnElement(maneuverElement) ? 1 : 0);
        this.setCellFormat(this.content);
        if (this.getLogger().isDebug2()) {
            this.getLogger().log(14808325, "MixedListRow#updateValuesForTurns(): (%1)", (Object)StringUtilities.formatMessage("content finally is: (%1), name finally is: (%2), turn arrow is: (%3), distance is: (%4), sign post: (%5), exit number: (%6)", new String[]{String.valueOf(this.content), this.name, String.valueOf(this.getInteger(20)), String.valueOf(turnListElement.distance), turnListElement.getSignPostInfo(), turnListElement.getExitNumber()}));
        }
    }

    private void updateTurnDefault(TurnListElement turnListElement) {
        ManeuverElement maneuverElement = turnListElement.getManeuver()[0];
        int n = maneuverElement.getElement();
        this.validateDisplayName();
        this.content = 0;
        this.setDirectionArrowByManeuver(turnListElement.getManeuver()[0]);
        if (n == 3 || n == 4 || n == 5) {
            IconCell iconCell;
            this.name = this.env.getDestName(turnListElement.destinationIndex);
            if (!this.env.getHelper().isFinalDestination(turnListElement.destinationIndex)) {
                this.setCell(64, IntegerListCell.create(turnListElement.destinationIndex + 1));
            }
            if ((iconCell = this.env.getHelper().createPicNavIconCell(this.env.getCurrentDestination())) != null) {
                this.content = 9;
                this.setCell(45, iconCell);
            }
        }
        this.setCell(21, this.env.getHelper().createTurnRoadIcon(turnListElement.streetIconId, turnListElement.streetIconText));
        this.getLogger().log(14808325, "MixedListRow#updateTurnDefault(): TurnName = %1, turnListLine.mDistance = %2", (Object)this.name, this.mDistance);
        this.validateDisplayName();
        this.setCellTurnRoadNameOr2ndLine(this.name);
        this.setCellTurnDistance(this.env.formatDistStr(this.mDistance));
        if (Util.isHURegionAsia()) {
            this.updateTurnDefaultAsia(turnListElement);
        } else {
            int n2 = this.env.getHelper().getDefaultFormat(turnListElement, this.env.getNavigationEnv());
            if (n2 == 16 || n2 == 20) {
                this.content = n2;
            }
            if (Util.isHURegionNAR()) {
                this.updateTurnDefaultNAR(turnListElement);
            }
        }
    }

    protected void updateTurnDefaultAsia(TurnListElement turnListElement) {
        int n = turnListElement.getType();
        int n2 = this.env.getHelper().getDefaultFormat(turnListElement, this.env.getNavigationEnv());
        if (this.getLogger().isDebug()) {
            this.getLogger().log(-2137614336, "MixedListRow#updateTurnDefaultAsia(): turnListElementType: (%1), calculatedTurnFormat: (%2)", (long)n, (long)n2);
        }
        if (n != 7) {
            if (89 == n2) {
                this.getLogger().log(14808325, "MixedListRow#updateTurnDefaultAsia(): FORMAT_ASIA_OFFROAD_WARNING");
                this.content = 89;
                this.name = Util.getFirstNotEmpty(turnListElement.turnToStreet, this.env.getTranslatedText(13));
                this.setCellTurnRoadNameOr2ndLine(this.name);
            } else if (88 == n2 || 90 == n2 || 80 == n2 || 91 == n2) {
                if (Util.isPorsche(this.env.getNavigationEnv().getFramework())) {
                    this.content = 90 == n2 || 80 == n2 ? 88 : n2;
                    this.setCellLinesFill1stAnd2ndLinePorsche(turnListElement);
                } else {
                    this.name = Util.getFirstNotEmpty(turnListElement.turnToStreet, "---");
                    this.setCellTurnRoadNameOr2ndLine(this.name);
                    this.content = 91;
                }
                this.setCellPoiIconAdditionalIcon(turnListElement, n2);
            } else if (84 == n2) {
                this.content = 84;
                this.name = Util.getFirstNotEmpty(this.env.getTranslatedText(10), turnListElement.turnToStreet);
                this.setCellTurnRoadNameOr2ndLine(this.name);
                if (Util.isPorsche(this.env.getNavigationEnv().getFramework())) {
                    this.setCellPoiNameOr1stLine(this.name);
                }
                this.setCellPoiIconAdditionalIcon(turnListElement, n2);
            } else if (94 == n2 || 95 == n2 || 96 == n2 || 93 == n2) {
                if (this.getLogger().isDebug2()) {
                    this.getLogger().log(14808325, "MixedListRow#updateTurnDefaultAsia(): IC_SAPA_JCT calculatedTurnFormat : (%1)", (long)n2);
                }
                this.content = n2;
                this.setCellPoiIconExitIcon(turnListElement);
                if (Util.isPorsche(this.env.getNavigationEnv().getFramework())) {
                    this.setCellLinesFill1stAnd2ndLinePorsche(turnListElement);
                } else {
                    this.name = Util.getFirstNotEmpty(turnListElement.turnToStreet, "---");
                    this.setCellTurnRoadNameOr2ndLine(this.name);
                    this.setCellPoiNameOr1stLine(Util.getFirstNotEmpty(turnListElement.exitNumber, turnListElement.signPostInfo));
                }
            } else if (92 == n2) {
                if (turnListElement.getLaneGuidance() != null && turnListElement.getLaneGuidance().length > 0) {
                    this.content = n2;
                    this.name = Util.getFirstNotEmpty(turnListElement.exitNumber, "---");
                    int n3 = Util.isPorsche(this.env.getNavigationEnv().getFramework()) ? 5 : 12;
                    MixedListConstants$TollGateInfo mixedListConstants$TollGateInfo = this.env.getHelper().getTollGateInfo(turnListElement.getLaneGuidance(), n3);
                    this.setCellTollgateInfo(mixedListConstants$TollGateInfo);
                } else {
                    this.content = 97;
                    this.name = Util.getFirstNotEmpty(turnListElement.turnToStreet, "---");
                    this.setCellPoiNameOr1stLine(this.name);
                    int n4 = this.env.getIconHandler().resolveAdditionalInfoIconResourceID(turnListElement.additionalIcons[0].getIconId(), turnListElement.additionalIcons[0].getVariant());
                    this.setCellPoiIcon(0, n4);
                }
                this.getLogger().log(14808325, "MixedListRow#updateTurnDefaultAsia(): FORMAT_ASIA_TOLLGATE");
            } else if (70 == n2 || 71 == n2) {
                this.content = n2;
                LaneGuidanceWrapper laneGuidanceWrapper = new LaneGuidanceWrapper(this.getLogger(), turnListElement.getLaneGuidance());
                MixedListConstants$LaneGuidance mixedListConstants$LaneGuidance = null;
                if (this.lastLaneGuidanceWrapper != null && this.lastLaneGuidanceWrapper.equals(laneGuidanceWrapper)) {
                    mixedListConstants$LaneGuidance = this.lastLaneGuidanceWrapper.toLaneGuidance();
                } else {
                    mixedListConstants$LaneGuidance = laneGuidanceWrapper.toLaneGuidance();
                    this.lastLaneGuidanceWrapper = laneGuidanceWrapper;
                }
                this.name = Util.getFirstNotEmpty(turnListElement.turnToStreet, "---");
                this.setCellTurnRoadNameOr2ndLine(this.name);
                if (mixedListConstants$LaneGuidance != null) {
                    this.setCellLaneGuidance(mixedListConstants$LaneGuidance);
                } else {
                    this.getLogger().log(-1601830656, "MixedListRow#updateTurnDefaultAsia(): laneGuidance is null!");
                }
            }
        } else {
            NavLocation navLocation = this.env.getLocationOfDestination(turnListElement.getDestinationIndex());
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
            int n5 = iMyLocationAccessor.getType();
            if (n5 == 1) {
                int n6 = this.env.getIconHandler().resolvePOIIconResourceID(iMyLocationAccessor.getIconIndex(), iMyLocationAccessor.getSubIconIndex());
                this.content = 83;
                this.setCellPoiIcon(0, n6);
                this.setCellPoiNameOr1stLine(LocationFormatter.formatPOIName(navLocation));
                if (Util.isPorsche(this.env.getNavigationEnv().getFramework())) {
                    String string = RouteInfoHelper.getFormattedCityDistrict2(navLocation, this.env.getNavigationEnv());
                    this.setCellPoiNameOr1stLine(string);
                    this.setCellTurnRoadNameOr2ndLine(LocationFormatter.formatPOIName(navLocation));
                }
                this.getLogger().log(-2137614336, "MixedListRow#updateTurnDefaultAsia(): LOCATIONTYPE_POI destType(%1), poiDestinationIcon(%2), destinationIndex(%3)", (long)n5, (long)n6, (long)turnListElement.getDestinationIndex());
            } else {
                String string = RouteInfoHelper.getFormattedCityDistrict(navLocation, this.env.getNavigationEnv());
                this.setCellPoiNameOr1stLine(string);
                if (Util.isPorsche(this.env.getNavigationEnv().getFramework())) {
                    string = RouteInfoHelper.getFormattedCityDistrict2(navLocation, this.env.getNavigationEnv());
                    this.setCellPoiNameOr1stLine(string);
                    this.content = 83;
                } else {
                    this.content = 82;
                }
                this.getLogger().log(-2137614336, "MixedListRow#updateTurnDefaultAsia(): LOCATIONTYPE_DEFAULT destType is (%1)", (long)n5);
            }
        }
        if (this.getLogger().isDebug2()) {
            this.getLogger().log(14808325, "MixedListRow#updateTurnDefaultAsia(): (%1)", (Object)StringUtilities.formatMessage("content finally is: (%1), name finally is: (%2), turn arrow is: (%3), distance is: (%4), sign post: (%5), exit number: (%6)", new String[]{String.valueOf(this.content), this.name, String.valueOf(this.getInteger(20)), String.valueOf(turnListElement.distance), turnListElement.getSignPostInfo(), turnListElement.getExitNumber()}));
        }
    }

    protected void setCellPoiIconExitIcon(TurnListElement turnListElement) {
        if (turnListElement.getExitIconId() > 0) {
            int n = this.env.getIconHandler().resolveAdditionalInfoIconResourceID(turnListElement.getExitIconId(), -1);
            this.setCellPoiIcon(0, n);
        }
    }

    private void setCellLinesFill1stAnd2ndLinePorsche(TurnListElement turnListElement) {
        if (Util.isEmpty(turnListElement.turnToStreet)) {
            if (!Util.isEmpty(turnListElement.exitNumber) && !Util.isEmpty(turnListElement.signPostInfo)) {
                this.name = turnListElement.exitNumber;
                this.setCellTurnRoadNameOr2ndLine(turnListElement.signPostInfo);
            } else if (Util.isEmpty(turnListElement.exitNumber)) {
                this.name = Util.getFirstNotEmpty(turnListElement.signPostInfo, "---");
                this.setCellTurnRoadNameOr2ndLine("");
            } else {
                this.name = Util.getFirstNotEmpty(turnListElement.exitNumber, "---");
                this.setCellTurnRoadNameOr2ndLine("");
            }
            this.setCellPoiNameOr1stLine(this.name);
        } else if (Util.isEmpty(turnListElement.exitNumber) && Util.isEmpty(turnListElement.signPostInfo)) {
            this.name = Util.getFirstNotEmpty(turnListElement.turnToStreet, "---");
            this.setCellPoiNameOr1stLine(this.name);
            this.setCellTurnRoadNameOr2ndLine("");
        } else {
            this.name = Util.getFirstNotEmpty(turnListElement.turnToStreet, "---");
            this.setCellPoiNameOr1stLine(this.name);
            this.setCellTurnRoadNameOr2ndLine(Util.getFirstNotEmpty(turnListElement.exitNumber, turnListElement.signPostInfo));
        }
    }

    protected void setCellPoiIconAdditionalIcon(TurnListElement turnListElement, int n) {
        if (turnListElement.additionalIcons != null && turnListElement.additionalIcons.length > 0 && turnListElement.additionalIcons[0].getIconId() > 0) {
            int n2 = this.env.getIconHandler().resolveAdditionalInfoIconResourceID(turnListElement.additionalIcons[0].getIconId(), turnListElement.additionalIcons[0].getVariant());
            this.setCellPoiIcon(0, n2);
            if (this.getLogger().isDebug2()) {
                this.getLogger().log(14808325, "MixedListRow#updateTurnDefaultAsia(): FORMAT_ASIA_(%1), name: (%2), IconLength: (%3), Icon0: (%4)", (Object)String.valueOf(n), (Object)this.name, (Object)String.valueOf(turnListElement.additionalIcons.length), (Object)String.valueOf(turnListElement.additionalIcons[0].getIconId()));
            }
        }
    }

    private void setTrafficLightIcon(TurnListElement turnListElement) {
        this.setCellTrafficLightIconVisibility(0, 1);
        if (turnListElement.additionalIcons != null) {
            for (int i2 = 0; i2 < turnListElement.additionalIcons.length; ++i2) {
                AdditionalTurnListIcon additionalTurnListIcon = turnListElement.additionalIcons[i2];
                if (additionalTurnListIcon.getType() != 2) continue;
                this.setCellTrafficLightIconVisibility(0, 0);
                break;
            }
        }
    }

    private void updateTurnDefaultNAR(TurnListElement turnListElement) {
        this.updateRoadDirectionForNAR(turnListElement.getStreetCardinalDirection());
        this.updateExitSignForNAR(turnListElement.getExitNumber(), turnListElement.getExitIconId());
    }

    private void updateRoadDirectionForNAR(String string) {
        this.getLogger().log(14808325, "MixedListRow#updateRoadDirectionForNAR(): roadDirection: %1", (Object)string);
        this.setCellRoadDirection(string);
    }

    private void updateExitSignForNAR(String string, int n) {
        if (this.getLogger().isDebug2()) {
            this.getLogger().log(14808325, "MixedListRow#updateExitSignForNAR(): exitNumber = %1, exitSignID = %2", (Object)string, (long)n);
        }
        if (!Util.isEmpty(string)) {
            ExtRenderingInfo extRenderingInfo = this.env.getIconHandler().resolveExitIconResourceID(n, string.length());
            if (extRenderingInfo != null && extRenderingInfo.isValid()) {
                this.getLogger().log(14808325, "MixedListRow#updateExitSignForNAR(): exitSignInfo = %1", (Object)extRenderingInfo);
                this.setCellExitSign(extRenderingInfo.getResourceId(), string, extRenderingInfo.getFontSize(), extRenderingInfo.getFontSize(), extRenderingInfo.getFontColor(), extRenderingInfo.getDeltaX(), extRenderingInfo.getDeltaY());
            } else {
                this.setCellExitSign(-1);
            }
        } else {
            this.setCellExitSign(-1);
        }
    }

    private void updateTurnForBorderCrossing(TurnListElement turnListElement) {
        boolean bl;
        this.content = 8;
        String string = turnListElement.getCountryAbbreviation();
        int n = this.env.getIconHandler().resolveCountryIconResourceID(turnListElement.getStreetIconId());
        this.setCellBorderCrossingCountryFlag(n);
        Buffer buffer = new Buffer(this.env.getTranslatedText(6));
        if (n == -1 && !Util.isEmpty(this.name)) {
            this.getLogger().log(-1601830656, "MixedListRow#updateTurnForBorderCrossing(): no flag icon available, adding name instead: %1", (Object)this.name);
            buffer.append(": ").append(this.name);
        } else if (n == -1 && !Util.isEmpty(string)) {
            this.getLogger().log(-1601830656, "MixedListRow#updateTurnForBorderCrossing(): no flag icon available, adding country abbreviation instead: %1", (Object)string);
            buffer.append(": ").append(string);
        }
        this.setCellBorderCrossingTextPassing(buffer.toString());
        boolean bl2 = bl = this.env.getNavigationEnv().getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex() == 26;
        if (Util.isClusterMMI(this.env.getNavigationEnv().getFramework())) {
            this.setCellBorderCrossingTextAllowedVelocity1(this.env.getTranslatedText(53));
            this.setCellBorderCrossingTextAllowedVelocity2(this.env.getTranslatedText(3));
        } else if (bl) {
            this.setCellBorderCrossingTextAllowedVelocity1(this.env.getTranslatedText(3));
            this.setCellBorderCrossingTextAllowedVelocity2(this.env.getTranslatedText(0));
        } else {
            this.setCellBorderCrossingTextAllowedVelocity1(this.env.getTranslatedText(0));
            this.setCellBorderCrossingTextAllowedVelocity2(this.env.getTranslatedText(3));
        }
        this.getLogger().log(14808325, "MixedListRow#updateTurnForBorderCrossing(): Border crossing, name: %1, countryAbbreviation: %2, turnListLine.mDistance = %3", (Object)this.name, (Object)string, this.mDistance);
        this.setCellBorderCrossingDistance(this.env.formatDistStr(this.mDistance));
        switch (this.env.getSpeedUnitForCountry(string)) {
            case 1: {
                this.setCellBorderCrossingTextSpeedUnit(this.env.getTranslatedText(2));
                break;
            }
            default: {
                this.setCellBorderCrossingTextSpeedUnit(this.env.getTranslatedText(1));
            }
        }
        for (int i2 = 0; i2 < 4; ++i2) {
            this.setCellBorderCrossingRoadclassIcon(i2, -1);
            this.setCellBorderCrossingSpeedIcon(i2, -1);
        }
        RoadClassSpeedInfo[] roadClassSpeedInfoArray = this.env.getSpeedInfo();
        if (!Util.isEmpty(string) && roadClassSpeedInfoArray != null) {
            int n2 = 0;
            for (int i3 = 0; i3 < roadClassSpeedInfoArray.length; ++i3) {
                RoadClassSpeedInfo roadClassSpeedInfo = roadClassSpeedInfoArray[i3];
                if (roadClassSpeedInfo == null || !string.equals(roadClassSpeedInfo.getCountryAbbreviation())) continue;
                int n3 = roadClassSpeedInfo.getVariant();
                int n4 = this.env.getIconHandler().resolveRoadClassIconResourceID(roadClassSpeedInfo.getRoadClassIconReference(), n3);
                int n5 = this.env.getIconHandler().resolveTrafficRegulationIconResourceID(roadClassSpeedInfo.getRoadSignIconReference(), n3);
                if (this.getLogger().isDebug2()) {
                    this.getLogger().log(14808325, "MixedListRow#updateTurnForBorderCrossing() - found matching type and abbreviation at index %1, roadClassIconResourceID: %2, roadSignIconResourceID: %3", (long)i3, (long)n4, (long)n5);
                }
                if (n4 == -1 || n5 == -1) continue;
                this.setCellBorderCrossingRoadclassIcon(n2, n4);
                this.setCellBorderCrossingSpeedIcon(n2, n5);
                ++n2;
            }
            this.getLogger().log(-2137614336, "MixedListRow#updateTurnForBorderCrossing() - found %1 pair(s) of road class/sign icons to display", (long)n2);
        } else {
            int n6 = roadClassSpeedInfoArray == null ? 0 : roadClassSpeedInfoArray.length;
            this.getLogger().log(-1601830656, "MixedListRow#updateTurnForBorderCrossing() - no country abbreviation or no speed info available - countryAbbreviation: %1, ", (Object)string, (long)n6);
        }
    }

    public int[] updateValuesForPOI(NavPoiInfo navPoiInfo) {
        long l;
        this.mDistance = l = navPoiInfo.getDistance();
        this.setCellDistanceToDest(l);
        this.destinationIndex = navPoiInfo.destinationIndex;
        int n = navPoiInfo.getPoiLocations().length;
        if (this.getLogger().isDebug2()) {
            this.getLogger().log(14808325, "MixedListRow#updateValuesForPOI(): POIDistance = %1, poiArrayLen = %2", this.mDistance, (long)n);
        }
        if (Util.isHURegionNAR()) {
            this.name = navPoiInfo.getSignpostInfo();
            this.getLogger().log(14808325, "MixedListRow#updateValuesForPOI(): SignpostInfo = %1", (Object)this.name);
            if (Util.isEmpty(this.name)) {
                this.name = this.env.getTranslatedText(9);
            }
        } else if (n > 0) {
            this.name = LocationFormatter.formatPOIName(navPoiInfo.getPoiLocations()[0]);
        } else {
            this.getLogger().log(1078071040, "MixedListRow#updateValuesForPOI(): navPoiInfo.getPoiLocations() is empty");
        }
        this.content = 1;
        this.updatePoiIconsNavLocation(navPoiInfo.getPoiLocations(), 0, 5);
        if (this.getLogger().isDebug2()) {
            this.getLogger().log(14808325, "MixedListRow#updateValuesForPOI(): POI info: (%1)", (Object)StringUtilities.formatMessage("POI type:(%1), POI name:(%2), POI distance:(%3) ", new String[]{String.valueOf(navPoiInfo.getType()), this.name, String.valueOf(this.mDistance)}));
        }
        this.validateDisplayName();
        this.setCellPoiNameOr1stLine(this.name);
        this.setCellPoiDistance(this.env.formatDistStr(this.mDistance));
        this.setCellPoiEta(this.env.getRTTMetric());
        this.setCellFormat(this.content);
        if (Util.isHURegionAsia()) {
            this.updatePoiForAsia(navPoiInfo);
        } else if (Util.isHURegionNAR()) {
            this.updatePoiForNAR(navPoiInfo);
        }
        int[] nArray = new int[6];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray[i2] = ((IconCell)this.getCells()[5 + i2]).getResourceLocator().getResourceID();
        }
        return nArray;
    }

    private void updatePoiForAsia(NavPoiInfo navPoiInfo) {
        this.getLogger().log(-2137614336, "MixedListRow#updatePoiForAisa(), navPoiInfo type: (%1)", (long)navPoiInfo.type);
        switch (navPoiInfo.type) {
            case 1: {
                if (navPoiInfo.exitPoiLocation != null) {
                    this.name = LocationFormatter.formatPOIName(navPoiInfo.exitPoiLocation);
                    if (!Util.isEmpty(this.name)) {
                        this.setCellPoiNameOr1stLine(this.name);
                    }
                    this.setCellExitSign(LocationFormatter.getIconResourceID(this.env.getIconHandler(), navPoiInfo.exitPoiLocation));
                    break;
                }
                this.getLogger().log(-1601830656, "MixedListRow#updatePoiForAisa() - exitPoiLocation is null");
                break;
            }
            case 2: {
                if (navPoiInfo.poiLocations != null && navPoiInfo.poiLocations.length > 0) {
                    this.name = LocationFormatter.formatPOIName(navPoiInfo.poiLocations[0]);
                    if (!Util.isEmpty(this.name)) {
                        this.setCellPoiNameOr1stLine(this.name);
                    }
                    this.setCellExitSign(LocationFormatter.getIconResourceID(this.env.getIconHandler(), navPoiInfo.poiLocations[0]));
                    int n = ((IconCell)this.getCells()[5]).getResourceLocator().getResourceID() != -1 ? 1 : 0;
                    this.updatePoiIconsNavRouteListDataIcon(navPoiInfo.getPoiIcons(), n, 5);
                    break;
                }
                this.getLogger().log(-2137614336, "MixedListRow#updatePoiForAisa() - poiLocations is empty");
                break;
            }
            default: {
                this.getLogger().log(-1601830656, "MixedListRow#updatePoiForAisa() - unknown type : %1", (long)navPoiInfo.type);
            }
        }
    }

    private void updatePoiForNAR(NavPoiInfo navPoiInfo) {
        this.getLogger().log(14808325, "MixedListRow#updatePoiForNAR()");
        this.updateExitSignForNAR(navPoiInfo.getExitNumber(), navPoiInfo.getExitIconId());
    }

    private void updatePoiIconsNavLocation(NavLocation[] navLocationArray, int n, int n2) {
        if (navLocationArray == null) {
            this.getLogger().log(10000, "MixedListRow#updatePoiIconsNavLocation() - poiData is null!");
            return;
        }
        if (this.getLogger().isDebug2()) {
            this.getLogger().log(14808325, "MixedListRow#updatePoiIconsNavLocation() - poiData.length: %1, offset: %2, maxLength: %3 ", (long)navLocationArray.length, (long)n, (long)n2);
        }
        int n3 = Math.min(navLocationArray.length, n2);
        int[][] nArrayArray = new int[n3][];
        for (int i2 = 0; i2 < n3; ++i2) {
            if (navLocationArray[i2] == null) continue;
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocationArray[i2]);
            nArrayArray[i2] = new int[]{iMyLocationAccessor.getIconIndex(), iMyLocationAccessor.getSubIconIndex()};
        }
        this.updatePoiIcons(nArrayArray, n, n2);
    }

    private void updatePoiIconsNavRouteListDataIcon(NavRouteListDataIcon[] navRouteListDataIconArray, int n, int n2) {
        if (navRouteListDataIconArray == null) {
            this.getLogger().log(10000, "MixedListRow#updatePoiIconsNavRouteListDataIcon() - poiData is null!");
            return;
        }
        if (this.getLogger().isDebug2()) {
            this.getLogger().log(14808325, "MixedListRow#updatePoiIconsNavRouteListDataIcon() - poiData.length: %1, offset: %2, maxLength: %3 ", (long)navRouteListDataIconArray.length, (long)n, (long)n2);
        }
        int n3 = Math.min(navRouteListDataIconArray.length, n2);
        int[][] nArrayArray = new int[n3][];
        for (int i2 = 0; i2 < n3; ++i2) {
            if (navRouteListDataIconArray[i2] == null) continue;
            nArrayArray[i2] = new int[]{navRouteListDataIconArray[i2].getCriteria1(), navRouteListDataIconArray[i2].getCriteria2()};
        }
        this.updatePoiIcons(nArrayArray, n, n2);
    }

    private void updatePoiIcons(int[][] nArray, int n, int n2) {
        int n3;
        if (nArray == null || n < 0 || n >= 6 || n2 <= 0) {
            this.getLogger().log(10000, "MixedListRow#updatePoiIcons() - iconIdArray: %1, offset: %2, maxLength: %3 ", (Object)nArray, (long)n, (long)n2);
            return;
        }
        if (n + n2 > 6) {
            n2 = 6 - n;
            this.getLogger().log(-1601830656, "MixedListRow#updatePoiIcons() - adjusted maxLength to %1, offset: %2 ", (long)n2, (long)n);
        }
        int n4 = nArray.length;
        if (this.getLogger().isDebug2()) {
            this.getLogger().log(14808325, "MixedListRow#updatePoiIcons() - poiArrayLen: %1, offset: %2, maxLength: %3 ", (long)n4, (long)n, (long)n2);
        }
        int[] nArray2 = new int[n2];
        int n5 = 0;
        for (n3 = 0; n3 < n4; ++n3) {
            if (nArray[n3] == null || nArray[n3].length < 2) continue;
            int n6 = LocationFormatter.getIconResourceID(this.env.getIconHandler(), nArray[n3][0], nArray[n3][1]);
            for (int i2 = 0; i2 < n5; ++i2) {
                if (nArray2[i2] != n6) continue;
                this.getLogger().log(14808325, "MixedListRow#updatePoiIcons(): iconId %1 already found", (long)n6);
                n6 = -1;
                break;
            }
            if (n6 == -1) continue;
            nArray2[n5] = n6;
            this.setCellPoiIcon(n + n5, n6);
            if (++n5 >= n2) break;
        }
        for (n3 = n + n5; n3 < 6; ++n3) {
            this.setCellPoiIcon(n3, -1);
        }
    }

    public int[] updateValuesForTMC(TmcMessage tmcMessage, int n) {
        int[] nArray;
        long l;
        this.mDistance = l = tmcMessage.getDistanceToEvent();
        this.setCellDistanceToDest(l);
        this.destinationIndex = tmcMessage.destinationIndex;
        String[] stringArray = tmcMessage.getEventText();
        if (stringArray != null && stringArray.length > 0) {
            this.name = stringArray[0];
            if (stringArray.length > 1) {
                this.setCellTMCEventCause(stringArray[1]);
            }
        } else {
            this.getLogger().log(10000, "MixedListRow#updateValuesForTMC(): eventText[] of tmcMessagesAhead[%1] is either null or empty", (long)n);
        }
        RenderingInfo renderingInfo = null;
        if (tmcMessage.getRoadNumber() != null) {
            renderingInfo = this.env.getIconHandler().resolveStreetIconResourceID(tmcMessage.getStreetSignId(), tmcMessage.getRoadNumber().length());
        }
        if (renderingInfo != null && renderingInfo.isValid()) {
            this.getLogger().log(14808325, "   Msg #%1: has valid icon data", (long)n);
            this.getCellTMCRoadIcon().initializeIconTextLocator(new HMIResourceLocator(renderingInfo.getResourceId()), tmcMessage.getRoadNumber(), ((ExtRenderingInfo)renderingInfo).getFontReference(), ((ExtRenderingInfo)renderingInfo).getFontSize(), ((ExtRenderingInfo)renderingInfo).getFontColor(), ((ExtRenderingInfo)renderingInfo).getDeltaX(), ((ExtRenderingInfo)renderingInfo).getDeltaY());
        } else {
            this.getLogger().log(14808325, "   Msg #%1: has invalid icon data", (long)n);
            this.getCellTMCRoadIcon().initializeIconSimpleLocator(new HMIResourceLocator(-1));
        }
        int[] nArray2 = tmcMessage.getIconListId();
        if (nArray2 != null) {
            this.getLogger().log(14808325, "   Msg #%1: has %2 TMC icon(s) (showing only the first)", (long)n, (long)nArray2.length);
            nArray = new int[nArray2.length];
            for (int i2 = 0; i2 < nArray2.length; ++i2) {
                nArray[i2] = this.env.getIconHandler().resolveTMCIconResourceID(nArray2[i2], 0);
                if (i2 != 0) continue;
                this.setCellTMCEventIcon(nArray[i2]);
            }
        } else {
            this.getLogger().log(10000, "   Msg #%1: IconListId is null", (long)n);
            nArray = new int[]{-1};
        }
        this.validateDisplayName();
        this.setCellTMCEventText(this.name);
        this.setCellTMCRoadName(tmcMessage.getRoadName());
        this.setCellTMCEventDelay(tmcMessage.getEventDelayOnRoute());
        this.setCellTMCDistance(this.env.formatDistStr(this.mDistance));
        if (Util.isHURegionNAR()) {
            this.updateTMCForNAR(tmcMessage);
        }
        this.content = this.env.getHelper().getDefaultFormat(tmcMessage);
        this.setCellFormat(this.content);
        return nArray;
    }

    private void updateTMCForNAR(TmcMessage tmcMessage) {
        this.updateRoadDirectionForNAR(tmcMessage.getStreetCardinalDirection());
        this.updateExitSignForNAR(tmcMessage.getExitNumber(), tmcMessage.getExitIconId());
    }

    public ListCell[] getCopy() {
        ListCell[] listCellArray = new ListCell[69];
        ListCell[] listCellArray2 = this.cells;
        listCellArray[0] = IntegerListCell.create(((IntegerListCell)listCellArray2[0]).getValue());
        listCellArray[1] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[1]).getResourceLocator()));
        listCellArray[2] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[2]).getResourceLocator()), ((IconCell)listCellArray2[2]).getIconText(), ((IconCell)listCellArray2[2]).getFontReference(), ((IconCell)listCellArray2[2]).getFontSize(), ((IconCell)listCellArray2[2]).getTextColor(), ((IconCell)listCellArray2[2]).getDeltaX(), ((IconCell)listCellArray2[2]).getDeltaY());
        listCellArray[3] = new TextListCell(((TextListCell)listCellArray2[3]).getText());
        listCellArray[66] = new TextListCell(((TextListCell)listCellArray2[66]).getText());
        listCellArray[67] = new TextListCell(((TextListCell)listCellArray2[67]).getText());
        listCellArray[4] = new TextListCell(((TextListCell)listCellArray2[4]).getText());
        listCellArray[65] = new LongListCell(((LongListCell)listCellArray2[65]).getValue());
        listCellArray[5] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[5]).getResourceLocator()));
        listCellArray[6] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[6]).getResourceLocator()));
        listCellArray[7] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[7]).getResourceLocator()));
        listCellArray[8] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[8]).getResourceLocator()));
        listCellArray[9] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[9]).getResourceLocator()));
        listCellArray[10] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[10]).getResourceLocator()));
        listCellArray[68] = IntegerListCell.create(((IntegerListCell)listCellArray2[68]).getValue());
        listCellArray[11] = new TextListCell(((TextListCell)listCellArray2[11]).getText());
        listCellArray[12] = new TextListCell(((TextListCell)listCellArray2[12]).getText());
        listCellArray[13] = new TextListCell(((TextListCell)listCellArray2[13]).getText());
        listCellArray[14] = IntegerListCell.create(((IntegerListCell)listCellArray2[14]).getValue());
        listCellArray[15] = IntegerListCell.create(((IntegerListCell)listCellArray2[15]).getValue());
        listCellArray[16] = IntegerListCell.create(((IntegerListCell)listCellArray2[16]).getValue());
        listCellArray[17] = IntegerListCell.create(((IntegerListCell)listCellArray2[17]).getValue());
        listCellArray[18] = new TextListCell(((TextListCell)listCellArray2[18]).getText());
        listCellArray[19] = new TextListCell(((TextListCell)listCellArray2[19]).getText());
        listCellArray[20] = IntegerListCell.create(((IntegerListCell)listCellArray2[20]).getValue());
        listCellArray[21] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[21]).getResourceLocator()), ((IconCell)listCellArray2[21]).getIconText(), ((IconCell)listCellArray2[21]).getFontReference(), ((IconCell)listCellArray2[21]).getFontSize(), ((IconCell)listCellArray2[21]).getTextColor(), ((IconCell)listCellArray2[21]).getDeltaX(), ((IconCell)listCellArray2[21]).getDeltaY());
        listCellArray[22] = new TextListCell(((TextListCell)listCellArray2[22]).getText());
        listCellArray[24] = new IconCell((IconCell)listCellArray2[24]);
        listCellArray[25] = new TextListCell(((TextListCell)listCellArray2[25]).getText());
        listCellArray[26] = new TextListCell(((TextListCell)listCellArray2[26]).getText());
        listCellArray[27] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[27]).getResourceLocator()));
        listCellArray[28] = new TextListCell(((TextListCell)listCellArray2[28]).getText());
        listCellArray[29] = new TextListCell(((TextListCell)listCellArray2[29]).getText());
        listCellArray[30] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[30]).getResourceLocator()));
        listCellArray[31] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[31]).getResourceLocator()));
        listCellArray[32] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[32]).getResourceLocator()));
        listCellArray[33] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[33]).getResourceLocator()));
        listCellArray[34] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[34]).getResourceLocator()));
        listCellArray[35] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[35]).getResourceLocator()));
        listCellArray[36] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[36]).getResourceLocator()));
        listCellArray[37] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[37]).getResourceLocator()));
        listCellArray[38] = new TextListCell(((TextListCell)listCellArray2[38]).getText());
        listCellArray[45] = new IconCell(new HMIResourceLocator(((IconCell)listCellArray2[45]).getResourceLocator()));
        listCellArray[46] = IntegerListCell.create(((IntegerListCell)listCellArray2[46]).getValue());
        listCellArray[47] = new LongListCell(((LongListCell)listCellArray2[47]).getValue());
        listCellArray[48] = IntegerListCell.create(((IntegerListCell)listCellArray2[48]).getValue());
        listCellArray[51] = new TextListCell(((TextListCell)listCellArray2[51]).getText());
        listCellArray[52] = new TextListCell(((TextListCell)listCellArray2[52]).getText());
        listCellArray[49] = new TextListCell(((TextListCell)listCellArray2[49]).getText());
        listCellArray[60] = new ObjectListCell(((ObjectListCell)listCellArray2[60]).getValue());
        listCellArray[61] = new ObjectListCell(((ObjectListCell)listCellArray2[61]).getValue());
        listCellArray[62] = new LongListCell(((LongListCell)listCellArray2[62]).getValue());
        listCellArray[63] = new LongListCell(((LongListCell)listCellArray2[63]).getValue());
        listCellArray[64] = IntegerListCell.create(((IntegerListCell)listCellArray2[64]).getValue());
        listCellArray[54] = new TextListCell(((TextListCell)listCellArray2[54]).getText());
        return listCellArray;
    }

    public int getDestinationType() {
        int n = -1;
        int n2 = this.getInteger(20);
        if (n2 == 69) {
            n = 0;
        } else if (n2 >= 70 && n2 <= 78) {
            n = 1;
        }
        return n;
    }

    public void clear() {
        this.mDistance = 0L;
        this.destinationIndex = 0;
        this.setCellFormat(-1);
    }

    @Override
    public int compareTo(Object object) {
        if (object instanceof MixedListRow) {
            MixedListRow mixedListRow = (MixedListRow)object;
            int n = this.getCellFormat();
            int n2 = mixedListRow.getCellFormat();
            if (n != -1 && n2 == -1) {
                return -1;
            }
            if (n == -1 && n2 != -1) {
                return 1;
            }
            if (this.destinationIndex < mixedListRow.destinationIndex) {
                return -1;
            }
            if (this.destinationIndex > mixedListRow.destinationIndex) {
                return 1;
            }
            if (this.mDistance > mixedListRow.mDistance) {
                return -1;
            }
            if (this.mDistance < mixedListRow.mDistance) {
                return 1;
            }
            if (n == n2) {
                return 0;
            }
            if (n == 0 || n == 8 || n == 9) {
                return -1;
            }
            if (n2 == 0 || n2 == 8 || n2 == 9) {
                return 1;
            }
            return n == 1 ? -1 : 1;
        }
        return -1;
    }

    private void fillPrimaryText() {
        switch (this.getCellFormat()) {
            case 1: {
                this.setText(54, this.getText(11));
                break;
            }
            case 2: 
            case 18: 
            case 21: 
            case 22: {
                this.setText(54, this.getText(3));
                break;
            }
            case 8: {
                this.setText(54, this.getText(25));
                break;
            }
            default: {
                this.setText(54, this.getText(18));
            }
        }
    }

    public String getShortDescription() {
        Buffer buffer = new Buffer();
        switch (this.getCellFormat()) {
            case 1: {
                this.appendShortDescriptionPOI(buffer);
                break;
            }
            case 2: {
                this.appendShortDescriptionTMC(buffer);
                break;
            }
            case 18: {
                this.appendShortDescriptionTMC(buffer);
                buffer.append(", ").append(this.getText(67));
                break;
            }
            case 21: {
                this.appendShortDescriptionTMC(buffer);
                String[] stringArray = new DateMetric(new Date(this.getLong(65)), 23).getStringValueAndUnit();
                buffer.append(", ").append(stringArray[0]).append(stringArray[1].trim());
                break;
            }
            case 22: {
                this.appendShortDescriptionTMC(buffer);
                buffer.append(", ").append(this.getText(66));
                break;
            }
            case 8: {
                this.appendShortDescriptionBorderCrossing(buffer);
                break;
            }
            default: {
                this.appendShortDescriptionTurn(buffer);
            }
        }
        return buffer.toString();
    }

    private void appendShortDescriptionTurn(Buffer buffer) {
        buffer.append(this.getText(18)).append(", ").append(this.getText(19));
    }

    private void appendShortDescriptionPOI(Buffer buffer) {
        buffer.append(this.getText(11)).append(", ").append(this.getText(12)).append(", ").append(this.getText(13));
    }

    private void appendShortDescriptionTMC(Buffer buffer) {
        buffer.append(this.getText(3)).append(", ").append(this.getText(4));
    }

    private void appendShortDescriptionBorderCrossing(Buffer buffer) {
        buffer.append(this.getText(25)).append(", ").append(this.getText(26));
    }

    private void validateDisplayName() {
        if (Util.isEmpty(this.name)) {
            this.name = "---";
        }
    }

    private void setDirectionArrowByManeuver(ManeuverElement maneuverElement) {
        int n = this.env.getRouteLength() - this.destinationIndex - 1;
        int n2 = IconUtil.getManeuverIconID(this.getLogger(), maneuverElement, 0, n);
        this.setCellTurnArrow(n2);
        this.getLogger().log(14808325, "MixedListRow#setDirectionArrowByManeuver(): offset is: (%1) turnArrowIcon is: (%2)", (long)n, (long)n2);
    }
}

