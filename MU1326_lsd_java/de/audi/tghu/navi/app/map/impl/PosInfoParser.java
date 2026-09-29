/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.handler.IPosInfoParser;
import de.audi.tghu.navi.app.map.impl.PosInfoParser$FirstIndexParser;
import de.audi.tghu.navi.app.map.impl.PosInfoParser$PosInfoParserEnv;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.PosInfo;

public class PosInfoParser
implements IPosInfoParser {
    private final PosInfoParser$PosInfoParserEnv env;
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
    private PosInfoParser$FirstIndexParser wrapper = new PosInfoParser$FirstIndexParser(this);
    private final LogChannel logger;

    public PosInfoParser(LogChannel logChannel, PosInfoParser$PosInfoParserEnv posInfoParserEnv) {
        this.env = posInfoParserEnv;
        this.logger = logChannel;
        this.clean();
    }

    private LogChannel getLogger() {
        return this.logger;
    }

    @Override
    public String getDescription() {
        return this.lvDescription;
    }

    @Override
    public PosInfo getPosInfo() {
        return this.lvPosInfo;
    }

    @Override
    public String getUrl() {
        return this.lvUrl;
    }

    @Override
    public NavLocation getResolvedOnlineNavLocation() {
        return this.resolvedOnlineNavLocation;
    }

    @Override
    public ResourceLocator getPicNavLocator() {
        return this.lvPicNavLocator;
    }

    @Override
    public boolean hasStackedPOIIndex() {
        return PosInfoParser$FirstIndexParser.access$000(this.wrapper) >= 0;
    }

    @Override
    public boolean hasPicNavIndex() {
        return PosInfoParser$FirstIndexParser.access$100(this.wrapper) >= 0;
    }

    @Override
    public MapPin getMapPin() {
        return this.lvMapPin;
    }

    @Override
    public NavLocation getHomeOrOffice() {
        return this.homeOrOffice;
    }

    @Override
    public void setActiveInfoListIndex(int n) {
        this.activeInfoIndex = n;
        this.lvPosInfo = n >= 0 && n < this.lvInfoList.length ? this.lvInfoList[n] : null;
    }

    @Override
    public int getActiveInfoListIndex() {
        return this.activeInfoIndex;
    }

    @Override
    public boolean isRouteSegment() {
        return this.isRouteSegment;
    }

    @Override
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
            this.getLogger().log(-2137614336, "PosInfoParser#extractLocationWithCityAndStreet(): town or street not present - town: %1, street: %2", (Object)navLocation.getTown(), (Object)navLocation.getStreet());
            return null;
        }
        return this.env.getTooltipFormatter().formatLocation(navLocation);
    }

    @Override
    public int parseInfoListForTmcMessages(PosInfo[] posInfoArray) {
        this.clean();
        this.lvInfoList = posInfoArray;
        int n = posInfoArray != null ? posInfoArray.length : 0;
        this.getLogger().log(14808325, "PosInfoParser#parseInfoListForTmcMessages(): PosInfo.length = %1", (long)n);
        this.wrapper.lookupFirstIndexes(posInfoArray);
        if (PosInfoParser$FirstIndexParser.access$200(this.wrapper) >= 0) {
            this.setActiveInfoListIndex(PosInfoParser$FirstIndexParser.access$200(this.wrapper));
            return 2;
        }
        return -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public int parseInfoList(PosInfo[] posInfoArray) {
        NavLocation navLocation;
        Object object;
        this.clean();
        this.lvInfoList = posInfoArray;
        int n = posInfoArray != null ? posInfoArray.length : 0;
        this.getLogger().log(14808325, "PosInfoParser#parseInfoList(): PosInfo.length = %1", (long)n);
        this.wrapper.lookupFirstIndexes(posInfoArray);
        if (PosInfoParser$FirstIndexParser.access$300(this.wrapper) >= 0) {
            object = this.env.getMapPin(posInfoArray[PosInfoParser$FirstIndexParser.access$300((PosInfoParser$FirstIndexParser)this.wrapper)].objectId);
            if (object == null) {
                this.getLogger().log(-1601830656, "PosInfoParser#parseInfoList() - can't find MapFlag for %1", (Object)posInfoArray[PosInfoParser$FirstIndexParser.access$300(this.wrapper)]);
            } else {
                this.setActiveInfoListIndex(PosInfoParser$FirstIndexParser.access$300(this.wrapper));
                this.getLogger().log(-2137614336, "PosInfoParser#parseInfoList - %1", object);
                if (((MapPin)object).type == 3 || ((MapPin)object).type == 2) {
                    this.getLogger().log(-2137614336, "PosInfoParser#parseInfoList - It's a online Pin");
                    this.lvMapPin = object;
                    navLocation = null;
                    OnlinePOIResultList onlinePOIResultList = this.env.getContextDependedOnlineResult();
                    if (onlinePOIResultList != null) {
                        this.resolvedOnlineNavLocation = navLocation = onlinePOIResultList.getTransformedLocationAt(((MapPin)object).index);
                        this.lvUrl = LocationFormatter.getURLAddress(navLocation);
                    } else {
                        this.getLogger().log(-1601830656, "PosInfoParser#parseInfoList - oprl is null");
                    }
                    if (navLocation == null || !navLocation.isPositionValid()) return 1;
                    this.lvDescription = this.env.getTooltipFormatter().formatOnlinePOI(onlinePOIResultList.getPOIElementAt(((MapPin)object).index), navLocation);
                } else {
                    if (((MapPin)object).type == 0) {
                        this.getLogger().log(-2137614336, "PosInfoParser#parseInfoList() - It's a favorite pin");
                        IFavorite iFavorite = this.env.getFavorite(((MapPin)object).index);
                        this.lvDescription = this.env.getTooltipFormatter().formatFavorite(iFavorite);
                        return 6;
                    }
                    switch (((MapPin)object).type) {
                        case 7: {
                            this.getLogger().log(-2137614336, "PosInfoParser#parseInfoList() - It's a Personal Destination");
                            this.lvDescription = this.env.getTooltipFormatter().formatAdbEntry(this.env.getAdbEntry(((MapPin)object).index), 2);
                            break;
                        }
                        case 6: {
                            this.getLogger().log(-2137614336, "PosInfoParser#parseInfoList() - It's a Business Destination");
                            this.lvDescription = this.env.getTooltipFormatter().formatAdbEntry(this.env.getAdbEntry(((MapPin)object).index), 1);
                            break;
                        }
                        case 1: {
                            this.getLogger().log(-2137614336, "PosInfoParser#parseInfoList() - It's home");
                            this.lvDescription = this.env.getTooltipFormatter().formatHomeLocation(this.env.getHomeAddress());
                            this.homeOrOffice = this.env.getHomeAddress();
                            break;
                        }
                        case 9: {
                            this.getLogger().log(-2137614336, "PosInfoParser#parseInfoList() - It's office");
                            this.lvDescription = this.env.getTooltipFormatter().formatHomeLocation(this.env.getOfficeAddress());
                            this.homeOrOffice = this.env.getOfficeAddress();
                            break;
                        }
                        case -1: {
                            this.getLogger().log(-2137614336, "PosInfoParser#parseInfoList() - It's a Home Destination 2");
                            return 7;
                        }
                        case 10: {
                            this.getLogger().log(-2137614336, "PosInfoParser#parseInfoList() - It's just a marker... ignoring...");
                            break;
                        }
                        default: {
                            this.getLogger().log(10000, "PosInfoParser#parseInfoList() - unknown type = %1", (long)((MapPin)object).type);
                        }
                    }
                }
            }
        }
        if (this.lvDescription == null && PosInfoParser$FirstIndexParser.access$200(this.wrapper) >= 0) {
            this.setActiveInfoListIndex(PosInfoParser$FirstIndexParser.access$200(this.wrapper));
            return 2;
        }
        if (this.lvDescription == null && PosInfoParser$FirstIndexParser.access$000(this.wrapper) >= 0) {
            this.lvDescription = this.extractPOI(posInfoArray, PosInfoParser$FirstIndexParser.access$000(this.wrapper));
            this.setActiveInfoListIndex(PosInfoParser$FirstIndexParser.access$000(this.wrapper));
        }
        if (this.lvDescription == null && PosInfoParser$FirstIndexParser.access$400(this.wrapper) >= 0) {
            this.lvDescription = this.extractPOI(posInfoArray, PosInfoParser$FirstIndexParser.access$400(this.wrapper));
            this.setActiveInfoListIndex(PosInfoParser$FirstIndexParser.access$400(this.wrapper));
        }
        if (this.lvDescription == null && PosInfoParser$FirstIndexParser.access$500(this.wrapper) >= 0) {
            this.lvDescription = this.extractPOI(posInfoArray, PosInfoParser$FirstIndexParser.access$500(this.wrapper));
            this.setActiveInfoListIndex(PosInfoParser$FirstIndexParser.access$500(this.wrapper));
        }
        if (this.lvDescription == null && PosInfoParser$FirstIndexParser.access$600(this.wrapper) >= 0) {
            this.lvDescription = this.extractPOI(posInfoArray, PosInfoParser$FirstIndexParser.access$600(this.wrapper));
            this.setActiveInfoListIndex(PosInfoParser$FirstIndexParser.access$600(this.wrapper));
        }
        if (this.lvDescription == null && PosInfoParser$FirstIndexParser.access$100(this.wrapper) >= 0) {
            this.lvPicNavLocator = posInfoArray[PosInfoParser$FirstIndexParser.access$100(this.wrapper)].getResourceLocator();
            if (this.lvPicNavLocator != null) {
                object = posInfoArray[PosInfoParser$FirstIndexParser.access$100(this.wrapper)].getTLocation();
                if (!(object != null && ((NavLocation)object).isPositionValid() || PosInfoParser$FirstIndexParser.access$700(this.wrapper) < 0)) {
                    object = posInfoArray[PosInfoParser$FirstIndexParser.access$700(this.wrapper)].getTLocation();
                }
                if (((NavLocation)object).isPositionValid()) {
                    this.setActiveInfoListIndex(PosInfoParser$FirstIndexParser.access$100(this.wrapper));
                    return 3;
                }
                this.getLogger().log(10000, "PosInfoParser#parseInfoList() - did not find valid location for address resolution!");
                return -1;
            }
            this.getLogger().log(-1601830656, "PosInfoParser#parseInfoList() - picNavLocator is null!");
        }
        if (this.lvDescription == null && PosInfoParser$FirstIndexParser.access$800(this.wrapper) >= 0) {
            this.setActiveInfoListIndex(PosInfoParser$FirstIndexParser.access$800(this.wrapper));
            object = posInfoArray[PosInfoParser$FirstIndexParser.access$800(this.wrapper)].getTLocation();
            if (object != null) {
                return 4;
            }
            this.getLogger().log(-1601830656, "PosInfoParser#parseInfoList() - given location is null!");
        }
        if (this.lvDescription == null && PosInfoParser$FirstIndexParser.access$900(this.wrapper) >= 0) {
            if (PosInfoParser$FirstIndexParser.access$700(this.wrapper) >= 0) {
                int n2 = PosInfoParser$FirstIndexParser.access$700(this.wrapper);
                this.lvDescription = this.extractLocationWithCityAndStreet(posInfoArray[n2]);
                if (this.lvDescription == null) {
                    this.lvDescription = posInfoArray[PosInfoParser$FirstIndexParser.access$900(this.wrapper)].getInfoTxt();
                    navLocation = posInfoArray[PosInfoParser$FirstIndexParser.access$900((PosInfoParser$FirstIndexParser)this.wrapper)].tLocation;
                    if (navLocation != null && navLocation.isPositionValid()) {
                        n2 = PosInfoParser$FirstIndexParser.access$900(this.wrapper);
                    }
                }
                this.setActiveInfoListIndex(n2);
            } else {
                this.lvDescription = posInfoArray[PosInfoParser$FirstIndexParser.access$900(this.wrapper)].getInfoTxt();
                this.setActiveInfoListIndex(PosInfoParser$FirstIndexParser.access$900(this.wrapper));
            }
        }
        if (this.lvDescription == null && PosInfoParser$FirstIndexParser.access$1000(this.wrapper) >= 0) {
            this.setActiveInfoListIndex(PosInfoParser$FirstIndexParser.access$1000(this.wrapper));
            NavLocation navLocation2 = posInfoArray[PosInfoParser$FirstIndexParser.access$1000(this.wrapper)].getTLocation();
            if (navLocation2 != null) {
                return 5;
            }
            this.getLogger().log(-1601830656, "PosInfoParser#parseInfoList() - given location is null!");
        }
        if (this.lvDescription == null && PosInfoParser$FirstIndexParser.access$700(this.wrapper) >= 0) {
            this.lvDescription = this.env.getTooltipFormatter().formatLocation(posInfoArray[PosInfoParser$FirstIndexParser.access$700(this.wrapper)].getTLocation());
            this.setActiveInfoListIndex(PosInfoParser$FirstIndexParser.access$700(this.wrapper));
            if (this.lvDescription == null && MapEnv.isDebugTooltip()) {
                this.lvDescription = new Buffer("longtitude=").append(posInfoArray[PosInfoParser$FirstIndexParser.access$700((PosInfoParser$FirstIndexParser)this.wrapper)].getTLocation().longitude).append(", latitude=").append(posInfoArray[PosInfoParser$FirstIndexParser.access$700((PosInfoParser$FirstIndexParser)this.wrapper)].getTLocation().latitude).toString();
            }
        }
        if (PosInfoParser$FirstIndexParser.access$1100(this.wrapper) < 0) return 0;
        this.isRouteSegment = true;
        this.routeSegmentIndex = posInfoArray[PosInfoParser$FirstIndexParser.access$1100((PosInfoParser$FirstIndexParser)this.wrapper)].objectId;
        return 0;
    }

    static /* synthetic */ PosInfoParser$PosInfoParserEnv access$1200(PosInfoParser posInfoParser) {
        return posInfoParser.env;
    }

    static /* synthetic */ LogChannel access$1300(PosInfoParser posInfoParser) {
        return posInfoParser.getLogger();
    }
}

