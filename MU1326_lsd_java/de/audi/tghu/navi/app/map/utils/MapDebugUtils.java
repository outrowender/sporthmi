/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.navigation.AdditionalTurnListIcon;
import org.dsi.ifc.navigation.ManeuverElement;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class MapDebugUtils {
    public static int iDiff = 1000;
    public static final int KM = 1000;
    public static final int Min = 60000;

    public static MapFlag[] createMapFlags(int n, int n2) {
        int n3 = 91;
        int n4 = n - iDiff * 5;
        int n5 = n2 - iDiff * 5;
        MapFlag[] mapFlagArray = new MapFlag[n3];
        for (int i2 = 0; i2 < 10; ++i2) {
            for (int i3 = 0; i3 < 10; ++i3) {
                int n6 = i2 * 10 + i3;
                if (n6 >= n3) continue;
                mapFlagArray[n6] = new MapFlag(n4 + iDiff * 4 * i2, n5 + iDiff * i3, n6, 0L);
            }
        }
        return mapFlagArray;
    }

    public static NavRouteListData[] createNavRouteListData() {
        ArrayList arrayList = new ArrayList();
        NavRouteListData navRouteListData = new NavRouteListData();
        navRouteListData.startDistance = 2641;
        navRouteListData.endDistance = 1125;
        navRouteListData.remainingTravelTime = 720000;
        navRouteListData.remainingTravelTimeStatus = 0;
        arrayList.add(navRouteListData);
        navRouteListData = new NavRouteListData();
        navRouteListData.startDistance = 1125;
        navRouteListData.endDistance = 0;
        navRouteListData.remainingTravelTime = 420000;
        navRouteListData.remainingTravelTimeStatus = 0;
        arrayList.add(navRouteListData);
        return (NavRouteListData[])arrayList.toArray(new NavRouteListData[0]);
    }

    public static TurnListElement[] createTurnListElements2() {
        TurnListElement[] turnListElementArray = new TurnListElement[3];
        turnListElementArray[0] = new TurnListElement(0L, 60L, 0L, null, "", "", "", 0, "", "", 0, "", 0, null, null, 0, null, 0L, null);
        turnListElementArray[0].maneuver = new ManeuverElement[]{new ManeuverElement(16, 64, 0)};
        turnListElementArray[1] = new TurnListElement(1000L, 60L, 0L, null, "", "", "", 0, "", "", 0, "", 0, null, null, 0, null, 0L, null);
        turnListElementArray[1].maneuver = new ManeuverElement[]{new ManeuverElement(16, 64, 0)};
        turnListElementArray[2] = new TurnListElement(2000L, 60L, 0L, null, "", "", "", 0, "", "", 0, "", 0, null, null, 0, null, 0L, null);
        turnListElementArray[2].maneuver = new ManeuverElement[]{new ManeuverElement(16, 64, 0)};
        return turnListElementArray;
    }

    public static TurnListElement[] createTurnListElements() {
        String string = "TurnListElement(distance=1408,eta=240,etaWithTimeDelay=0,maneuver[1]={ManeuverElement(element=13,direction=64,attribute=0)},street=\"Rathausplatz\",turnToStreet=\"Steuartstra\u00dfe\",streetIconText=\"\",streetIconId=4899,exitNumber=\"\",signPostInfo=\"\",exitIconId=0,countryAbbreviation=\"\",type=0,additionalIcons[]={null},laneGuidance[]={null},destinationIndex=0,tollcost=null,length=0,streetCardinalDirection=\"\")";
        TurnListElement turnListElement = new TurnListElement();
        return null;
    }

    public static Runnable createTestCase(final IRouteInfo iRouteInfo) {
        final NavRouteListData navRouteListData = new NavRouteListData();
        navRouteListData.startDistance = 10000;
        navRouteListData.endDistance = 0;
        navRouteListData.remainingTravelTime = 600000;
        NavPoiInfo navPoiInfo = new NavPoiInfo();
        navPoiInfo.distance = 1000L;
        navPoiInfo.remainingTime = 60000L;
        navPoiInfo.poiLocations = new NavLocation[3];
        navPoiInfo.poiLocations[0] = new NavLocation();
        navPoiInfo.poiLocations[0].proprietaryData = new NavLocationDescriptor[]{new NavLocationDescriptor(4097, "Rasthof K\u00f6schinger Forst Ost"), new NavLocationDescriptor(520, "50331767"), new NavLocationDescriptor(282, "536870961")};
        navPoiInfo.poiLocations[1] = new NavLocation();
        navPoiInfo.poiLocations[1].proprietaryData = new NavLocationDescriptor[]{new NavLocationDescriptor(4097, "ARAL"), new NavLocationDescriptor(520, "50332649"), new NavLocationDescriptor(282, "553648177")};
        navPoiInfo.poiLocations[2] = new NavLocation();
        navPoiInfo.poiLocations[2].proprietaryData = new NavLocationDescriptor[]{new NavLocationDescriptor(4097, "Rasthof K\u00f6schinger Forst Ost"), new NavLocationDescriptor(520, "50333442"), new NavLocationDescriptor(282, "536870961")};
        TurnListElement[] turnListElementArray = new TurnListElement[6];
        turnListElementArray[0] = MapDebugUtils.createTurnListElement("0");
        turnListElementArray[0].distance = 9000L;
        turnListElementArray[0].eta = 540000L;
        turnListElementArray[0].maneuver = new ManeuverElement[]{new ManeuverElement(13, 192, 0)};
        turnListElementArray[1] = MapDebugUtils.createTurnListElement("1");
        turnListElementArray[1].distance = 0L;
        turnListElementArray[1].eta = 0L;
        turnListElementArray[1].maneuver = new ManeuverElement[]{new ManeuverElement(3, 0, 0)};
        final TurnListElement turnListElement = MapDebugUtils.createTurnListElement("2");
        turnListElement.type = 4;
        turnListElement.turnToStreet = "1 Taihu Toll Gate (Puhe No.2 Bridge Beijing Direction)";
        turnListElement.maneuver = new ManeuverElement[]{new ManeuverElement(133, 0, 1)};
        turnListElement.laneGuidance = new NavLaneGuidanceData[7];
        turnListElement.laneGuidance[0] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[0].laneType = 1;
        turnListElement.laneGuidance[1] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[1].laneType = (short)2;
        turnListElement.laneGuidance[2] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[2].laneType = (short)3;
        turnListElement.laneGuidance[3] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[3].laneType = (short)5;
        turnListElement.laneGuidance[4] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[4].laneType = (short)4;
        turnListElement.laneGuidance[5] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[5].laneType = (short)6;
        turnListElement.laneGuidance[6] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[6].laneType = 0;
        final TurnListElement turnListElement2 = MapDebugUtils.createTurnListElement("2");
        turnListElement2.type = 4;
        turnListElement2.turnToStreet = "2 Taihu Toll Gate (Puhe No.2 Bridge Beijing Direction)";
        turnListElement2.maneuver = new ManeuverElement[]{new ManeuverElement(133, 0, 1)};
        turnListElement2.laneGuidance = new NavLaneGuidanceData[3];
        turnListElement2.laneGuidance[0] = new NavLaneGuidanceData();
        turnListElement2.laneGuidance[0].laneType = 1;
        turnListElement2.laneGuidance[1] = new NavLaneGuidanceData();
        turnListElement2.laneGuidance[1].laneType = (short)3;
        turnListElement2.laneGuidance[2] = new NavLaneGuidanceData();
        turnListElement2.laneGuidance[2].laneType = (short)4;
        final TurnListElement turnListElement3 = MapDebugUtils.createTurnListElement("2");
        turnListElement3.type = 4;
        turnListElement3.turnToStreet = "2 Taihu Toll Gate (Puhe No.2 Bridge Beijing Direction)";
        turnListElement3.maneuver = new ManeuverElement[]{new ManeuverElement(133, 0, 1)};
        turnListElement3.laneGuidance = new NavLaneGuidanceData[3];
        turnListElement3.laneGuidance[0] = new NavLaneGuidanceData();
        turnListElement3.laneGuidance[0].laneType = 1;
        turnListElement3.laneGuidance[1] = new NavLaneGuidanceData();
        turnListElement3.laneGuidance[1].laneType = (short)3;
        turnListElement3.laneGuidance[2] = new NavLaneGuidanceData();
        turnListElement3.laneGuidance[2].laneType = (short)4;
        TurnListElement turnListElement4 = MapDebugUtils.createTurnListElement("fr_");
        turnListElement4.eta = 540000L;
        turnListElement4.distance = 9000L;
        turnListElement4.turnToStreet = "Ferry";
        turnListElement4.type = 5;
        turnListElement4.maneuver = new ManeuverElement[]{new ManeuverElement(137, 0, 1)};
        TurnListElement turnListElement5 = MapDebugUtils.createTurnListElement("sg_");
        turnListElement5.eta = 540000L;
        turnListElement5.distance = 9000L;
        turnListElement5.turnToStreet = "narrow road";
        turnListElement5.type = 1;
        turnListElement5.maneuver = new ManeuverElement[]{new ManeuverElement(6, 0, 128)};
        Runnable runnable = new Runnable(){

            public void run() {
                iRouteInfo.updateRgTurnList(new TurnListElement[0]);
                iRouteInfo.updateRgPoiInfo(new NavPoiInfo[0]);
                iRouteInfo.updateRgDestinationInfo(new NavRouteListData[]{navRouteListData});
                iRouteInfo.setTravelParameters(true, true, 10000L, 600000L, 10000, 0, 600000L, 600000L, 10000, 0, 0);
                iRouteInfo.forceRouteInfo(true);
                try {
                    Thread.sleep(300L);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                Object[] objectArray = new TurnListElement[]{turnListElement3, turnListElement2, turnListElement};
                MapDebugUtils.adjustEtaAndDist(objectArray);
                iRouteInfo.updateRgTurnList((TurnListElement[])objectArray);
                iRouteInfo.forceRouteInfo(true);
            }
        };
        return runnable;
    }

    public static Runnable createTestCase2(final IRouteInfo iRouteInfo) {
        final NavRouteListData navRouteListData = new NavRouteListData();
        navRouteListData.startDistance = 10000;
        navRouteListData.endDistance = 0;
        navRouteListData.remainingTravelTime = 600000;
        TurnListElement turnListElement = MapDebugUtils.createTurnListElement("0");
        turnListElement.distance = 9000L;
        turnListElement.eta = 540000L;
        turnListElement.maneuver = new ManeuverElement[]{new ManeuverElement(13, 192, 0)};
        final TurnListElement turnListElement2 = MapDebugUtils.createTurnListElement("fr_");
        turnListElement2.eta = 540000L;
        turnListElement2.distance = 9000L;
        turnListElement2.turnToStreet = "Ferry";
        turnListElement2.type = 5;
        turnListElement2.maneuver = new ManeuverElement[]{new ManeuverElement(137, 0, 1)};
        final TurnListElement turnListElement3 = MapDebugUtils.createTurnListElement("sg_");
        turnListElement3.eta = 540000L;
        turnListElement3.distance = 9000L;
        turnListElement3.turnToStreet = "narrow road";
        turnListElement3.type = 2;
        turnListElement3.maneuver = new ManeuverElement[]{new ManeuverElement(257, 0, 128)};
        turnListElement3.additionalIcons = new AdditionalTurnListIcon[]{new AdditionalTurnListIcon(5, 0x70000008, -1)};
        TurnListElement turnListElement4 = MapDebugUtils.createTurnListElement("or_");
        turnListElement4.eta = 540000L;
        turnListElement4.distance = 9000L;
        turnListElement4.turnToStreet = "Offroad";
        turnListElement4.type = 1;
        turnListElement4.maneuver = new ManeuverElement[]{new ManeuverElement(6, 0, 128)};
        TurnListElement turnListElement5 = MapDebugUtils.createTurnListElement("s1_");
        turnListElement5.type = 7;
        turnListElement5.maneuver[0].element = 3;
        TurnListElement turnListElement6 = MapDebugUtils.createTurnListElement("s2_");
        turnListElement6.type = 7;
        turnListElement6.maneuver[0].element = 3;
        TurnListElement turnListElement7 = MapDebugUtils.createTurnListElement("de_");
        turnListElement7.type = 7;
        turnListElement7.maneuver[0].element = 3;
        final TurnListElement turnListElement8 = MapDebugUtils.createTurnListElement("de_");
        turnListElement8.type = 2;
        turnListElement8.maneuver[0].element = 13;
        turnListElement8.maneuver[0].direction = (short)224;
        turnListElement8.maneuver[0].attribute = 0;
        turnListElement8.turnToStreet = "Zhangcheng Expressway Exit";
        turnListElement8.exitNumber = "Zhangjiakou South";
        turnListElement8.signPostInfo = "Exit Zhangjiakou South";
        turnListElement8.exitIconId = 1617231879;
        Runnable runnable = new Runnable(){

            public void run() {
                iRouteInfo.updateRgTurnList(new TurnListElement[0]);
                iRouteInfo.updateRgPoiInfo(new NavPoiInfo[0]);
                iRouteInfo.updateTmcMessagesAhead(new TmcMessage[0]);
                iRouteInfo.updateRgDestinationInfo(new NavRouteListData[]{navRouteListData});
                iRouteInfo.setTravelParameters(true, true, 10000L, 600000L, 10000, 0, 600000L, 600000L, 10000, 0, 0);
                iRouteInfo.forceRouteInfo(true);
                try {
                    Thread.sleep(500L);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                MapDebugUtils.adjustEtaAndDist(new Object[]{turnListElement3, turnListElement2, turnListElement8});
                iRouteInfo.updateRgTurnList(new TurnListElement[]{turnListElement3, turnListElement2, turnListElement8});
                iRouteInfo.forceRouteInfo(true);
            }
        };
        return runnable;
    }

    public static Runnable createTestCase3(final IRouteInfo iRouteInfo) {
        final NavRouteListData navRouteListData = new NavRouteListData();
        navRouteListData.startDistance = 10000;
        navRouteListData.endDistance = 0;
        navRouteListData.remainingTravelTime = 600000;
        final TurnListElement turnListElement = MapDebugUtils.createTurnListElement("IC");
        turnListElement.type = 2;
        ManeuverElement maneuverElement = new ManeuverElement();
        maneuverElement.element = 12;
        maneuverElement.direction = (short)64;
        ManeuverElement maneuverElement2 = new ManeuverElement();
        maneuverElement2.element = 12;
        maneuverElement2.direction = (short)192;
        turnListElement.maneuver[0] = maneuverElement2;
        turnListElement.maneuver[0] = maneuverElement2;
        turnListElement.exitIconId = 1617231886;
        final TurnListElement turnListElement2 = MapDebugUtils.createTurnListElement("SAPA");
        turnListElement2.type = 2;
        turnListElement2.maneuver[0].element = 18;
        turnListElement2.exitIconId = 1617231886;
        final TurnListElement turnListElement3 = MapDebugUtils.createTurnListElement("JCT");
        turnListElement3.type = 2;
        turnListElement3.maneuver[0].element = 38;
        turnListElement3.exitIconId = 1617231886;
        final TmcMessage tmcMessage = MapDebugUtils.createTMC("test");
        tmcMessage.distanceToEvent = 1000L;
        tmcMessage.eventDelayOnRoute = 400L;
        tmcMessage.destinationIndex = 0;
        tmcMessage.iconListId = new int[]{2};
        tmcMessage.roadName = "Gerolfinger Stra\u00dfe";
        Runnable runnable = new Runnable(){

            public void run() {
                iRouteInfo.updateRgTurnList(new TurnListElement[0]);
                iRouteInfo.updateRgPoiInfo(new NavPoiInfo[0]);
                iRouteInfo.updateTmcMessagesAhead(new TmcMessage[0]);
                iRouteInfo.updateRgDestinationInfo(new NavRouteListData[]{navRouteListData});
                iRouteInfo.setTravelParameters(true, true, 10000L, 600000L, 10000, 0, 600000L, 600000L, 10000, 0, 0);
                iRouteInfo.forceRouteInfo(true);
                try {
                    Thread.sleep(200L);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                turnListElement.distance = 1000L;
                turnListElement.eta = 60000L;
                turnListElement2.distance = 2000L;
                turnListElement2.eta = 120000L;
                turnListElement3.distance = 3000L;
                turnListElement3.eta = 180000L;
                iRouteInfo.updateTmcMessagesAhead(new TmcMessage[]{tmcMessage});
                iRouteInfo.updateRgTurnList(new TurnListElement[]{turnListElement, turnListElement2});
                iRouteInfo.forceRouteInfo(true);
            }
        };
        return runnable;
    }

    public static Runnable createTestCaseLaneGuidance(final IRouteInfo iRouteInfo) {
        final NavRouteListData navRouteListData = new NavRouteListData();
        navRouteListData.startDistance = 10000;
        navRouteListData.endDistance = 0;
        navRouteListData.remainingTravelTime = 600000;
        final TurnListElement turnListElement = MapDebugUtils.createTurnListElement("1");
        turnListElement.distance = 9000L;
        turnListElement.eta = 540000L;
        turnListElement.maneuver = new ManeuverElement[]{new ManeuverElement(13, 192, 0)};
        turnListElement.laneGuidance = new NavLaneGuidanceData[7];
        turnListElement.laneGuidance[0] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[0].guidanceInfo = 0;
        turnListElement.laneGuidance[0].laneDescription = 0;
        turnListElement.laneGuidance[0].laneDirection = (short)512;
        turnListElement.laneGuidance[0].laneType = 1;
        turnListElement.laneGuidance[0].pos = 0;
        turnListElement.laneGuidance[1] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[1].guidanceInfo = 0;
        turnListElement.laneGuidance[1].laneDescription = 0;
        turnListElement.laneGuidance[1].laneDirection = 0;
        turnListElement.laneGuidance[1].laneType = 1;
        turnListElement.laneGuidance[1].pos = 0;
        turnListElement.laneGuidance[2] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[2].guidanceInfo = 0;
        turnListElement.laneGuidance[2].laneDescription = 0;
        turnListElement.laneGuidance[2].laneDirection = 0;
        turnListElement.laneGuidance[2].laneType = 1;
        turnListElement.laneGuidance[2].pos = 0;
        turnListElement.laneGuidance[3] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[3].guidanceInfo = 0;
        turnListElement.laneGuidance[3].laneDescription = 0;
        turnListElement.laneGuidance[3].laneDirection = 0;
        turnListElement.laneGuidance[3].laneType = 1;
        turnListElement.laneGuidance[3].pos = 0;
        turnListElement.laneGuidance[4] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[4].guidanceInfo = 0;
        turnListElement.laneGuidance[4].laneDescription = 0;
        turnListElement.laneGuidance[4].laneDirection = 0;
        turnListElement.laneGuidance[4].laneType = 1;
        turnListElement.laneGuidance[4].pos = 0;
        turnListElement.laneGuidance[5] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[5].guidanceInfo = 0;
        turnListElement.laneGuidance[5].laneDescription = 0;
        turnListElement.laneGuidance[5].laneDirection = 0;
        turnListElement.laneGuidance[5].laneType = 1;
        turnListElement.laneGuidance[5].pos = 0;
        turnListElement.laneGuidance[6] = new NavLaneGuidanceData();
        turnListElement.laneGuidance[6].guidanceInfo = 0;
        turnListElement.laneGuidance[6].laneDescription = 1;
        turnListElement.laneGuidance[6].laneDirection = (short)2;
        turnListElement.laneGuidance[6].laneType = 1;
        turnListElement.laneGuidance[6].pos = 0;
        final TurnListElement turnListElement2 = MapDebugUtils.createTurnListElement("2");
        turnListElement2.distance = 9000L;
        turnListElement2.eta = 540000L;
        turnListElement2.maneuver = new ManeuverElement[]{new ManeuverElement(13, 192, 0)};
        turnListElement2.laneGuidance = new NavLaneGuidanceData[6];
        turnListElement2.laneGuidance[0] = new NavLaneGuidanceData();
        turnListElement2.laneGuidance[0].guidanceInfo = 0;
        turnListElement2.laneGuidance[0].laneDescription = 0;
        turnListElement2.laneGuidance[0].laneDirection = (short)8;
        turnListElement2.laneGuidance[0].laneType = 1;
        turnListElement2.laneGuidance[0].pos = 0;
        turnListElement2.laneGuidance[1] = new NavLaneGuidanceData();
        turnListElement2.laneGuidance[1].guidanceInfo = 0;
        turnListElement2.laneGuidance[1].laneDescription = 0;
        turnListElement2.laneGuidance[1].laneDirection = (short)64;
        turnListElement2.laneGuidance[1].laneType = 1;
        turnListElement2.laneGuidance[1].pos = 0;
        turnListElement2.laneGuidance[2] = new NavLaneGuidanceData();
        turnListElement2.laneGuidance[2].guidanceInfo = 0;
        turnListElement2.laneGuidance[2].laneDescription = 0;
        turnListElement2.laneGuidance[2].laneDirection = (short)1088;
        turnListElement2.laneGuidance[2].laneType = 1;
        turnListElement2.laneGuidance[2].pos = 0;
        turnListElement2.laneGuidance[3] = new NavLaneGuidanceData();
        turnListElement2.laneGuidance[3].guidanceInfo = 0;
        turnListElement2.laneGuidance[3].laneDescription = 0;
        turnListElement2.laneGuidance[3].laneDirection = (short)10;
        turnListElement2.laneGuidance[3].laneType = 1;
        turnListElement2.laneGuidance[3].pos = 0;
        turnListElement2.laneGuidance[4] = new NavLaneGuidanceData();
        turnListElement2.laneGuidance[4].guidanceInfo = 0;
        turnListElement2.laneGuidance[4].laneDescription = 1;
        turnListElement2.laneGuidance[4].laneDirection = (short)32;
        turnListElement2.laneGuidance[4].laneType = 1;
        turnListElement2.laneGuidance[4].pos = 0;
        turnListElement2.laneGuidance[5] = new NavLaneGuidanceData();
        turnListElement2.laneGuidance[5].guidanceInfo = 0;
        turnListElement2.laneGuidance[5].laneDescription = 1;
        turnListElement2.laneGuidance[5].laneDirection = (short)2;
        turnListElement2.laneGuidance[5].laneType = 1;
        turnListElement2.laneGuidance[5].pos = 0;
        final TurnListElement turnListElement3 = MapDebugUtils.createTurnListElement("3");
        turnListElement3.distance = 9000L;
        turnListElement3.eta = 540000L;
        turnListElement3.maneuver = new ManeuverElement[]{new ManeuverElement(13, 192, 0)};
        turnListElement3.laneGuidance = new NavLaneGuidanceData[6];
        turnListElement3.laneGuidance[0] = new NavLaneGuidanceData();
        turnListElement3.laneGuidance[0].guidanceInfo = 0;
        turnListElement3.laneGuidance[0].laneDescription = 0;
        turnListElement3.laneGuidance[0].laneDirection = (short)6;
        turnListElement3.laneGuidance[0].laneType = 1;
        turnListElement3.laneGuidance[0].pos = 0;
        turnListElement3.laneGuidance[1] = new NavLaneGuidanceData();
        turnListElement3.laneGuidance[1].guidanceInfo = 0;
        turnListElement3.laneGuidance[1].laneDescription = 0;
        turnListElement3.laneGuidance[1].laneDirection = (short)8;
        turnListElement3.laneGuidance[1].laneType = (short)2;
        turnListElement3.laneGuidance[1].pos = 0;
        turnListElement3.laneGuidance[2] = new NavLaneGuidanceData();
        turnListElement3.laneGuidance[2].guidanceInfo = 0;
        turnListElement3.laneGuidance[2].laneDescription = 0;
        turnListElement3.laneGuidance[2].laneDirection = (short)1088;
        turnListElement3.laneGuidance[2].laneType = 1;
        turnListElement3.laneGuidance[2].pos = 0;
        turnListElement3.laneGuidance[3] = new NavLaneGuidanceData();
        turnListElement3.laneGuidance[3].guidanceInfo = 0;
        turnListElement3.laneGuidance[3].laneDescription = 0;
        turnListElement3.laneGuidance[3].laneDirection = (short)64;
        turnListElement3.laneGuidance[3].laneType = (short)128;
        turnListElement3.laneGuidance[3].pos = 0;
        turnListElement3.laneGuidance[4] = new NavLaneGuidanceData();
        turnListElement3.laneGuidance[4].guidanceInfo = 0;
        turnListElement3.laneGuidance[4].laneDescription = 1;
        turnListElement3.laneGuidance[4].laneDirection = (short)32;
        turnListElement3.laneGuidance[4].laneType = 1;
        turnListElement3.laneGuidance[4].pos = 0;
        turnListElement3.laneGuidance[5] = new NavLaneGuidanceData();
        turnListElement3.laneGuidance[5].guidanceInfo = 0;
        turnListElement3.laneGuidance[5].laneDescription = 1;
        turnListElement3.laneGuidance[5].laneDirection = (short)64;
        turnListElement3.laneGuidance[5].laneType = 1;
        turnListElement3.laneGuidance[5].pos = 0;
        Runnable runnable = new Runnable(){

            public void run() {
                iRouteInfo.updateRgTurnList(new TurnListElement[0]);
                iRouteInfo.updateRgPoiInfo(new NavPoiInfo[0]);
                iRouteInfo.updateTmcMessagesAhead(new TmcMessage[0]);
                iRouteInfo.updateRgDestinationInfo(new NavRouteListData[]{navRouteListData});
                iRouteInfo.setTravelParameters(true, true, 10000L, 600000L, 10000, 0, 600000L, 600000L, 10000, 0, 0);
                iRouteInfo.forceRouteInfo(true);
                try {
                    Thread.sleep(1200L);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                turnListElement.distance = 5000L;
                turnListElement.eta = 300000L;
                turnListElement2.distance = 6000L;
                turnListElement2.eta = 360000L;
                turnListElement3.distance = 7000L;
                turnListElement3.eta = 420000L;
                iRouteInfo.updateRgTurnList(new TurnListElement[]{turnListElement, turnListElement2, turnListElement3});
                iRouteInfo.forceRouteInfo(true);
            }
        };
        return runnable;
    }

    public static TurnListElement createTurnListElement(String string) {
        TurnListElement turnListElement = new TurnListElement();
        turnListElement.maneuver = new ManeuverElement[]{new ManeuverElement(0, 192, 0)};
        turnListElement.street = string + "_street";
        turnListElement.turnToStreet = string + "_turn2Str";
        turnListElement.streetIconText = string + "_strIconTxt";
        turnListElement.exitNumber = string + "_exit";
        turnListElement.signPostInfo = string + "_sign";
        turnListElement.countryAbbreviation = string + "_abb";
        return turnListElement;
    }

    public static TmcMessage createTMC(String string) {
        TmcMessage tmcMessage = new TmcMessage();
        tmcMessage.eventText = new String[]{"heavy traffic", "Test TMC event cause with long text"};
        return tmcMessage;
    }

    public static void adjustEtaAndDist(Object[] objectArray) {
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (objectArray[i2] == null) continue;
            if (objectArray[i2] instanceof TurnListElement) {
                ((TurnListElement)objectArray[i2]).distance = (i2 + 1) * 1000;
                ((TurnListElement)objectArray[i2]).eta = (i2 + 1) * 60000;
            }
            if (objectArray[i2] instanceof NavPoiInfo) {
                ((NavPoiInfo)objectArray[i2]).distance = (i2 + 1) * 1000;
                ((NavPoiInfo)objectArray[i2]).remainingTime = (i2 + 1) * 60000;
            }
            if (!(objectArray[i2] instanceof TmcMessage)) continue;
            ((TmcMessage)objectArray[i2]).distanceToEvent = (i2 + 1) * 1000;
            ((TmcMessage)objectArray[i2]).startTimeToDestination = (i2 + 1) * 60000;
        }
    }
}

