/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.handler.IPosInfoParser;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.organizer.AdbEntry;

public class PosInfoParser
implements IPosInfoParser {
    private final PosInfoParserEnv env;
    private String lvDescription;
    private String lvUrl;
    private int activeInfoIndex;
    private PosInfo lvPosInfo;
    private PosInfo[] lvInfoList;
    private ResourceLocator lvPicNavLocator;
    private MapPin lvMapPin;
    private boolean isRouteSegment;
    private long routeSegmentIndex;
    private NavLocation homeOrOffice;
    private NavLocation resolvedOnlineNavLocation;
    private FirstIndexParser wrapper = new FirstIndexParser();
    private final LogChannel logger;

    public PosInfoParser(LogChannel logChannel, PosInfoParserEnv posInfoParserEnv) {
        this.env = posInfoParserEnv;
        this.logger = logChannel;
        this.clean();
    }

    private LogChannel getLogger() {
        return this.logger;
    }

    public String getDescription() {
        return this.lvDescription;
    }

    public PosInfo getPosInfo() {
        return this.lvPosInfo;
    }

    public String getUrl() {
        return this.lvUrl;
    }

    public NavLocation getResolvedOnlineNavLocation() {
        return this.resolvedOnlineNavLocation;
    }

    public ResourceLocator getPicNavLocator() {
        return this.lvPicNavLocator;
    }

    public boolean hasStackedPOIIndex() {
        return this.wrapper.firstStackedPOIIndex >= 0;
    }

    public boolean hasPicNavIndex() {
        return this.wrapper.firstPicNavIndex >= 0;
    }

    public MapPin getMapPin() {
        return this.lvMapPin;
    }

    public NavLocation getHomeOrOffice() {
        return this.homeOrOffice;
    }

    public void setActiveInfoListIndex(int n) {
        this.activeInfoIndex = n;
        this.lvPosInfo = n >= 0 && n < this.lvInfoList.length ? this.lvInfoList[n] : null;
    }

    public int getActiveInfoListIndex() {
        return this.activeInfoIndex;
    }

    public boolean isRouteSegment() {
        return this.isRouteSegment;
    }

    public long getRouteSegmentIndex() {
        return this.routeSegmentIndex;
    }

    private void clean() {
        this.lvDescription = null;
        this.lvPosInfo = null;
        this.lvUrl = null;
        this.activeInfoIndex = -1;
        this.lvInfoList = null;
        this.lvPicNavLocator = null;
        this.lvMapPin = null;
        this.homeOrOffice = null;
        this.resolvedOnlineNavLocation = null;
        this.isRouteSegment = false;
        this.routeSegmentIndex = -1L;
    }

    private int getCountOfPoisInSameCategory(PosInfo[] posInfoArray, int n) {
        NavLocation navLocation = posInfoArray[n].getTLocation();
        if (navLocation == null) {
            return 0;
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        int n2 = iMyLocationAccessor.getPoiCategoryNumber();
        int n3 = 1;
        for (int i2 = n + 1; i2 < posInfoArray.length; ++i2) {
            IMyLocationAccessor iMyLocationAccessor2;
            NavLocation navLocation2;
            if (posInfoArray[i2].getEInfoType() != 1 && posInfoArray[i2].getEInfoType() != 3 || (navLocation2 = posInfoArray[i2].getTLocation()) == null || (iMyLocationAccessor2 = Util.getLocationAccessor(navLocation2)).getPoiCategoryNumber() != n2) continue;
            ++n3;
        }
        return n3;
    }

    private String extractPOI(PosInfo[] posInfoArray, int n) {
        int n2 = this.getCountOfPoisInSameCategory(posInfoArray, n);
        if (n2 == 0) {
            this.getLogger().log(10000, "ExtractPOI(): location = null");
            return null;
        }
        NavLocation navLocation = posInfoArray[n].getTLocation();
        if (n2 > 1) {
            return this.env.getTooltipFormatter().formatPOIStack(navLocation, n2);
        }
        switch (posInfoArray[n].eInfoType) {
            case 3: {
                return this.env.getTooltipFormatter().formatPOIStack(navLocation, 1);
            }
            case 20: {
                return this.env.getTooltipFormatter().formatBuilding(navLocation);
            }
            case 2: {
                return this.env.getTooltipFormatter().formatPOI3D(navLocation);
            }
        }
        return this.env.getTooltipFormatter().formatPOI(navLocation);
    }

    private String extractLocationWithCityAndStreet(PosInfo posInfo) {
        if (posInfo == null) {
            this.getLogger().log(10000, "PosInfoParser#extractLocationWithCityAndStreet(): info = null");
            return null;
        }
        NavLocation navLocation = posInfo.getTLocation();
        if (navLocation == null) {
            this.getLogger().log(10000, "PosInfoParser#extractLocationWithCityAndStreet(): location = null");
            return null;
        }
        if (Util.isEmpty(navLocation.getStreet()) || Util.isEmpty(navLocation.getTown())) {
            this.getLogger().log(10000000, "PosInfoParser#extractLocationWithCityAndStreet(): town or street not present - town: %1, street: %2", (Object)navLocation.getTown(), (Object)navLocation.getStreet());
            return null;
        }
        return this.env.getTooltipFormatter().formatLocation(navLocation);
    }

    public int parseInfoListForTmcMessages(PosInfo[] posInfoArray) {
        this.clean();
        this.lvInfoList = posInfoArray;
        int n = posInfoArray != null ? posInfoArray.length : 0;
        this.getLogger().log(100000000, "PosInfoParser#parseInfoListForTmcMessages(): PosInfo.length = %1", (long)n);
        this.wrapper.lookupFirstIndexes(posInfoArray);
        if (this.wrapper.firstTMCIndex >= 0) {
            this.setActiveInfoListIndex(this.wrapper.firstTMCIndex);
            return 2;
        }
        return -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int parseInfoList(PosInfo[] posInfoArray) {
        NavLocation navLocation;
        Object object;
        this.clean();
        this.lvInfoList = posInfoArray;
        int n = posInfoArray != null ? posInfoArray.length : 0;
        this.getLogger().log(100000000, "PosInfoParser#parseInfoList(): PosInfo.length = %1", (long)n);
        this.wrapper.lookupFirstIndexes(posInfoArray);
        if (this.wrapper.firstTOPIndex >= 0) {
            object = this.env.getMapPin(posInfoArray[((FirstIndexParser)this.wrapper).firstTOPIndex].objectId);
            if (object == null) {
                this.getLogger().log(100000, "PosInfoParser#parseInfoList() - can't find MapFlag for %1", (Object)posInfoArray[this.wrapper.firstTOPIndex]);
            } else {
                this.setActiveInfoListIndex(this.wrapper.firstTOPIndex);
                this.getLogger().log(10000000, "PosInfoParser#parseInfoList - %1", object);
                if (((MapPin)object).type == 3 || ((MapPin)object).type == 2) {
                    this.getLogger().log(10000000, "PosInfoParser#parseInfoList - It's a online Pin");
                    this.lvMapPin = object;
                    navLocation = null;
                    OnlinePOIResultList onlinePOIResultList = this.env.getContextDependedOnlineResult();
                    if (onlinePOIResultList != null) {
                        this.resolvedOnlineNavLocation = navLocation = onlinePOIResultList.getTransformedLocationAt(((MapPin)object).index);
                        this.lvUrl = LocationFormatter.getURLAddress(navLocation);
                    } else {
                        this.getLogger().log(100000, "PosInfoParser#parseInfoList - oprl is null");
                    }
                    if (navLocation == null || !navLocation.isPositionValid()) return 1;
                    this.lvDescription = this.env.getTooltipFormatter().formatOnlinePOI(onlinePOIResultList.getPOIElementAt(((MapPin)object).index), navLocation);
                } else {
                    if (((MapPin)object).type == 0) {
                        this.getLogger().log(10000000, "PosInfoParser#parseInfoList() - It's a favorite pin");
                        IFavorite iFavorite = this.env.getFavorite(((MapPin)object).index);
                        this.lvDescription = this.env.getTooltipFormatter().formatFavorite(iFavorite);
                        return 6;
                    }
                    switch (((MapPin)object).type) {
                        case 7: {
                            this.getLogger().log(10000000, "PosInfoParser#parseInfoList() - It's a Personal Destination");
                            this.lvDescription = this.env.getTooltipFormatter().formatAdbEntry(this.env.getAdbEntry(((MapPin)object).index), 2);
                            break;
                        }
                        case 6: {
                            this.getLogger().log(10000000, "PosInfoParser#parseInfoList() - It's a Business Destination");
                            this.lvDescription = this.env.getTooltipFormatter().formatAdbEntry(this.env.getAdbEntry(((MapPin)object).index), 1);
                            break;
                        }
                        case 1: {
                            this.getLogger().log(10000000, "PosInfoParser#parseInfoList() - It's home");
                            this.lvDescription = this.env.getTooltipFormatter().formatHomeLocation(this.env.getHomeAddress());
                            this.homeOrOffice = this.env.getHomeAddress();
                            break;
                        }
                        case 9: {
                            this.getLogger().log(10000000, "PosInfoParser#parseInfoList() - It's office");
                            this.lvDescription = this.env.getTooltipFormatter().formatHomeLocation(this.env.getOfficeAddress());
                            this.homeOrOffice = this.env.getOfficeAddress();
                            break;
                        }
                        case -1: {
                            this.getLogger().log(10000000, "PosInfoParser#parseInfoList() - It's a Home Destination 2");
                            return 7;
                        }
                        case 10: {
                            this.getLogger().log(10000000, "PosInfoParser#parseInfoList() - It's just a marker... ignoring...");
                            break;
                        }
                        default: {
                            this.getLogger().log(10000, "PosInfoParser#parseInfoList() - unknown type = %1", (long)((MapPin)object).type);
                        }
                    }
                }
            }
        }
        if (this.lvDescription == null && this.wrapper.firstTMCIndex >= 0) {
            this.setActiveInfoListIndex(this.wrapper.firstTMCIndex);
            return 2;
        }
        if (this.lvDescription == null && this.wrapper.firstStackedPOIIndex >= 0) {
            this.lvDescription = this.extractPOI(posInfoArray, this.wrapper.firstStackedPOIIndex);
            this.setActiveInfoListIndex(this.wrapper.firstStackedPOIIndex);
        }
        if (this.lvDescription == null && this.wrapper.firstBuildingListPoi >= 0) {
            this.lvDescription = this.extractPOI(posInfoArray, this.wrapper.firstBuildingListPoi);
            this.setActiveInfoListIndex(this.wrapper.firstBuildingListPoi);
        }
        if (this.lvDescription == null && this.wrapper.firstPOI3DIndex >= 0) {
            this.lvDescription = this.extractPOI(posInfoArray, this.wrapper.firstPOI3DIndex);
            this.setActiveInfoListIndex(this.wrapper.firstPOI3DIndex);
        }
        if (this.lvDescription == null && this.wrapper.firstPOIIndex >= 0) {
            this.lvDescription = this.extractPOI(posInfoArray, this.wrapper.firstPOIIndex);
            this.setActiveInfoListIndex(this.wrapper.firstPOIIndex);
        }
        if (this.lvDescription == null && this.wrapper.firstPicNavIndex >= 0) {
            this.lvPicNavLocator = posInfoArray[this.wrapper.firstPicNavIndex].getResourceLocator();
            if (this.lvPicNavLocator != null) {
                object = posInfoArray[this.wrapper.firstPicNavIndex].getTLocation();
                if (!(object != null && ((NavLocation)object).isPositionValid() || this.wrapper.firstLocationIndex < 0)) {
                    object = posInfoArray[this.wrapper.firstLocationIndex].getTLocation();
                }
                if (((NavLocation)object).isPositionValid()) {
                    this.setActiveInfoListIndex(this.wrapper.firstPicNavIndex);
                    return 3;
                }
                this.getLogger().log(10000, "PosInfoParser#parseInfoList() - did not find valid location for address resolution!");
                return -1;
            }
            this.getLogger().log(100000, "PosInfoParser#parseInfoList() - picNavLocator is null!");
        }
        if (this.lvDescription == null && this.wrapper.firstXTRepresentation >= 0) {
            this.setActiveInfoListIndex(this.wrapper.firstXTRepresentation);
            object = posInfoArray[this.wrapper.firstXTRepresentation].getTLocation();
            if (object != null) {
                return 4;
            }
            this.getLogger().log(100000, "PosInfoParser#parseInfoList() - given location is null!");
        }
        if (this.lvDescription == null && this.wrapper.firstAreaIndex >= 0) {
            if (this.wrapper.firstLocationIndex >= 0) {
                int n2 = this.wrapper.firstLocationIndex;
                this.lvDescription = this.extractLocationWithCityAndStreet(posInfoArray[n2]);
                if (this.lvDescription == null) {
                    this.lvDescription = posInfoArray[this.wrapper.firstAreaIndex].getInfoTxt();
                    navLocation = posInfoArray[((FirstIndexParser)this.wrapper).firstAreaIndex].tLocation;
                    if (navLocation != null && navLocation.isPositionValid()) {
                        n2 = this.wrapper.firstAreaIndex;
                    }
                }
                this.setActiveInfoListIndex(n2);
            } else {
                this.lvDescription = posInfoArray[this.wrapper.firstAreaIndex].getInfoTxt();
                this.setActiveInfoListIndex(this.wrapper.firstAreaIndex);
            }
        }
        if (this.lvDescription == null && this.wrapper.firstPOIbyUID >= 0) {
            this.setActiveInfoListIndex(this.wrapper.firstPOIbyUID);
            NavLocation navLocation2 = posInfoArray[this.wrapper.firstPOIbyUID].getTLocation();
            if (navLocation2 != null) {
                return 5;
            }
            this.getLogger().log(100000, "PosInfoParser#parseInfoList() - given location is null!");
        }
        if (this.lvDescription == null && this.wrapper.firstLocationIndex >= 0) {
            this.lvDescription = this.env.getTooltipFormatter().formatLocation(posInfoArray[this.wrapper.firstLocationIndex].getTLocation());
            this.setActiveInfoListIndex(this.wrapper.firstLocationIndex);
            if (this.lvDescription == null && MapEnv.isDebugTooltip()) {
                this.lvDescription = new Buffer("longtitude=").append(posInfoArray[((FirstIndexParser)this.wrapper).firstLocationIndex].getTLocation().longitude).append(", latitude=").append(posInfoArray[((FirstIndexParser)this.wrapper).firstLocationIndex].getTLocation().latitude).toString();
            }
        }
        if (this.wrapper.firstRouteSegment < 0) return 0;
        this.isRouteSegment = true;
        this.routeSegmentIndex = posInfoArray[((FirstIndexParser)this.wrapper).firstRouteSegment].objectId;
        return 0;
    }

    private class FirstIndexParser {
        private int firstLocationIndex = -1;
        private int firstPOIIndex = -1;
        private int firstPOI3DIndex = -1;
        private int firstStackedPOIIndex = -1;
        private int firstTMCIndex = -1;
        private int firstTOPIndex = -1;
        private int firstAreaIndex = -1;
        private int firstXTRepresentation = -1;
        private int firstPicNavIndex = -1;
        private int firstPOIbyUID = -1;
        private int firstRouteSegment = -1;
        private int firstBuildingListPoi = -1;

        public FirstIndexParser() {
            this.clean();
        }

        private void clean() {
            this.firstLocationIndex = -1;
            this.firstPOIIndex = -1;
            this.firstPOI3DIndex = -1;
            this.firstStackedPOIIndex = -1;
            this.firstTMCIndex = -1;
            this.firstTOPIndex = -1;
            this.firstAreaIndex = -1;
            this.firstXTRepresentation = -1;
            this.firstPicNavIndex = -1;
            this.firstPOIbyUID = -1;
            this.firstRouteSegment = -1;
            this.firstBuildingListPoi = -1;
        }

        public void lookupFirstIndexes(PosInfo[] posInfoArray) {
            this.clean();
            Buffer buffer = new Buffer();
            if (posInfoArray == null || posInfoArray.length <= 0) {
                return;
            }
            block15: for (int i2 = 0; i2 < posInfoArray.length; ++i2) {
                buffer.append(" [").append(i2).append("] eInfoType = ").append(posInfoArray[i2].getEInfoType());
                switch (posInfoArray[i2].getEInfoType()) {
                    case 0: {
                        if (this.firstLocationIndex >= 0) continue block15;
                        this.firstLocationIndex = i2;
                        continue block15;
                    }
                    case 1: {
                        if (this.firstPOIIndex >= 0) continue block15;
                        this.firstPOIIndex = i2;
                        continue block15;
                    }
                    case 2: {
                        if (!PosInfoParser.this.env.is3DLandmarksEnabled() || this.firstPOI3DIndex >= 0) continue block15;
                        this.firstPOI3DIndex = i2;
                        continue block15;
                    }
                    case 16: {
                        if (this.firstPOI3DIndex >= 0) continue block15;
                        this.firstPOI3DIndex = i2;
                        continue block15;
                    }
                    case 20: {
                        if (this.firstBuildingListPoi >= 0) continue block15;
                        this.firstBuildingListPoi = i2;
                        continue block15;
                    }
                    case 3: {
                        if (this.firstStackedPOIIndex >= 0) continue block15;
                        this.firstStackedPOIIndex = i2;
                        continue block15;
                    }
                    case 4: {
                        if (this.firstTMCIndex >= 0) continue block15;
                        this.firstTMCIndex = i2;
                        continue block15;
                    }
                    case 5: {
                        if (this.firstTOPIndex >= 0) continue block15;
                        this.firstTOPIndex = i2;
                        continue block15;
                    }
                    case 7: {
                        if (this.firstAreaIndex >= 0) continue block15;
                        this.firstAreaIndex = i2;
                        continue block15;
                    }
                    case 8: {
                        if (this.firstXTRepresentation >= 0) continue block15;
                        this.firstXTRepresentation = i2;
                        continue block15;
                    }
                    case 9: 
                    case 10: {
                        if (this.firstPicNavIndex >= 0) continue block15;
                        this.firstPicNavIndex = i2;
                        continue block15;
                    }
                    case 11: {
                        if (this.firstPOIbyUID >= 0) continue block15;
                        this.firstPOIbyUID = i2;
                        continue block15;
                    }
                    case 13: {
                        if (this.firstRouteSegment >= 0) continue block15;
                        this.firstRouteSegment = i2;
                        continue block15;
                    }
                    default: {
                        PosInfoParser.this.getLogger().log(10000, "PosInfoParser#FirstIndexParser#lookupFirstIndexes() : unknown eInfoType = %1", (long)posInfoArray[i2].getEInfoType());
                    }
                }
            }
            PosInfoParser.this.getLogger().log(100000000, "PosInfoParser#FirstIndexParser#lookupFirstIndexes() :%1", (Object)buffer.toString());
        }
    }

    public static interface PosInfoParserEnv {
        public NavigationEnv getNaviEnv();

        public boolean is3DLandmarksEnabled();

        public OnlinePOIResultList getContextDependedOnlineResult();

        public NavLocation getHomeAddress();

        public NavLocation getOfficeAddress();

        public AdbEntry getAdbEntry(int var1);

        public IFavorite getFavorite(int var1);

        public MapPin getMapPin(long var1);

        public ITooltipFormatter getTooltipFormatter();
    }
}

