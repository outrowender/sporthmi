/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.setup.IRouteCriteria;
import de.audi.tghu.navi.app.util.Util;
import java.util.Arrays;
import org.dsi.ifc.navigation.RouteOptions;

public class RouteCriteria
implements IRouteCriteria {
    private int trafficRerouting = 0;
    private int freeways = 0;
    private int vignettes = 0;
    private int[] vignetteCountries = new int[0];
    private int tollRoads = 0;
    private int ferries = 0;
    private int motorrail = 0;
    private int timeRestrictedRoads = 0;
    private int seasonRestricted = 0;
    private int trailer = 0;
    private int tunnels = 0;
    private int hovLanes = 0;
    private int unpaved;
    private int ipd;
    private int routeCalcType = -1;
    private NavigationEnv env;

    public RouteCriteria(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    public RouteCriteria(IRouteCriteria iRouteCriteria, NavigationEnv navigationEnv) {
        this(navigationEnv);
        this.setValuesFromObject(iRouteCriteria);
    }

    public final void setValuesFromObject(IRouteCriteria iRouteCriteria) {
        this.ferries = iRouteCriteria.getFerries();
        this.freeways = iRouteCriteria.getFreeways();
        this.motorrail = iRouteCriteria.getMotorrail();
        this.seasonRestricted = iRouteCriteria.getSeasonRestricted();
        this.timeRestrictedRoads = iRouteCriteria.getTimeRestrictedRoads();
        this.tollRoads = iRouteCriteria.getTollRoads();
        this.trafficRerouting = iRouteCriteria.getTrafficRerouting();
        this.trailer = iRouteCriteria.getTrailer();
        this.vignettes = iRouteCriteria.getVignettes();
        this.vignetteCountries = iRouteCriteria.getVignetteCountries();
        this.routeCalcType = iRouteCriteria.getRouteOptions(true)[0].getRouteType();
        this.tunnels = iRouteCriteria.getTunnels();
        this.hovLanes = iRouteCriteria.getHovLanes();
        this.unpaved = iRouteCriteria.getUnpaved();
        this.ipd = iRouteCriteria.getIpd();
    }

    private void setDynamicFlags4Asia(RouteOptions routeOptions, RouteOptions routeOptions2, RouteOptions routeOptions3) {
        int n;
        if (this.trafficRerouting == 3) {
            n = 6;
        } else if (this.trafficRerouting == 6) {
            n = 7;
        } else if (this.trafficRerouting == 4) {
            n = 10;
        } else {
            this.env.getLogChannel().log(10000, "RouteCriteria#setRouteTypesJPKR() - unknown traffic re-routing option: %1, using off", (long)this.trafficRerouting);
            n = 7;
        }
        routeOptions.dynamic = n;
        routeOptions2.dynamic = n;
        routeOptions3.dynamic = n;
    }

    private void setRouteTypesJPKR(RouteOptions routeOptions, RouteOptions routeOptions2, RouteOptions routeOptions3) {
        routeOptions.setRouteType(5);
        routeOptions2.setRouteType(5);
        routeOptions3.setRouteType(0);
        this.setDynamicFlags4Asia(routeOptions, routeOptions2, routeOptions3);
    }

    private void setTollRoadsJPKR(RouteOptions routeOptions, RouteOptions routeOptions2, RouteOptions routeOptions3) {
        routeOptions.setTollroads(1);
        routeOptions2.setTollroads(3);
        routeOptions3.setTollroads(1);
    }

    private void setRouteTypesCNTW(RouteOptions routeOptions, RouteOptions routeOptions2, RouteOptions routeOptions3) {
        routeOptions.setRouteType(0);
        routeOptions2.setRouteType(7);
        routeOptions3.setRouteType(1);
        this.setDynamicFlags4Asia(routeOptions, routeOptions2, routeOptions3);
    }

    private void setRouteTypesNAR(RouteOptions routeOptions, RouteOptions routeOptions2, RouteOptions routeOptions3) {
        routeOptions.setRouteType(0);
        routeOptions2.setRouteType(0);
        routeOptions3.setRouteType(1);
        routeOptions.dynamic = 10;
        routeOptions2.dynamic = 10;
        routeOptions3.dynamic = 10;
    }

    private void setRouteTypesDefault(RouteOptions routeOptions, RouteOptions routeOptions2, RouteOptions routeOptions3) {
        if (this.trafficRerouting == 3) {
            routeOptions.setRouteType(9);
            routeOptions2.setRouteType(9);
            routeOptions3.setRouteType(10);
            routeOptions.dynamic = 6;
            routeOptions2.dynamic = 6;
            routeOptions3.dynamic = 6;
        } else if (this.trafficRerouting == 4) {
            routeOptions.setRouteType(0);
            routeOptions2.setRouteType(0);
            routeOptions3.setRouteType(7);
            routeOptions.dynamic = 10;
            routeOptions2.dynamic = 10;
            routeOptions3.dynamic = 10;
        } else if (this.trafficRerouting == 6) {
            routeOptions.setRouteType(0);
            routeOptions2.setRouteType(0);
            routeOptions3.setRouteType(7);
            routeOptions.dynamic = 7;
            routeOptions2.dynamic = 7;
            routeOptions3.dynamic = 7;
        } else {
            this.env.getLogChannel().log(10000, "RouteCriteria#setRouteTypesDefault() - unknown traffic re-routing option: %1", (long)this.trafficRerouting);
        }
    }

    private int getDynamicRouteCalcType(int n) {
        if (Util.isHURegionAsia()) {
            return n;
        }
        if (this.trafficRerouting == 3) {
            if (n == 0) {
                return 9;
            }
            if (n == 7) {
                return 10;
            }
        }
        return n;
    }

    public RouteOptions[] getRouteOptions(boolean bl) {
        if (this.env.getLogChannel().isDebug2()) {
            this.env.getLogChannel().log(100000000, "RouteCriteria#getRouteOptions() - singleRoute: %1", bl);
        }
        RouteOptions routeOptions = new RouteOptions();
        RouteOptions routeOptions2 = new RouteOptions();
        RouteOptions routeOptions3 = new RouteOptions();
        this.setCommonOptions(routeOptions);
        this.setCommonOptions(routeOptions2);
        this.setCommonOptions(routeOptions3);
        int n = this.env.getFramework().getSysConst(442);
        switch (n) {
            case 2: 
            case 5: {
                this.setRouteTypesCNTW(routeOptions, routeOptions2, routeOptions3);
                break;
            }
            case 3: 
            case 4: {
                this.setRouteTypesJPKR(routeOptions, routeOptions2, routeOptions3);
                if (bl && this.routeCalcType != -1) {
                    if (this.routeCalcType == 5) break;
                    routeOptions.setTollroads(1);
                    break;
                }
                this.setTollRoadsJPKR(routeOptions, routeOptions2, routeOptions3);
                break;
            }
            case 1: {
                if (Util.isPorsche(this.env.getFramework())) {
                    this.setRouteTypesDefault(routeOptions, routeOptions2, routeOptions3);
                    break;
                }
                this.setRouteTypesNAR(routeOptions, routeOptions2, routeOptions3);
                break;
            }
            default: {
                this.setRouteTypesDefault(routeOptions, routeOptions2, routeOptions3);
            }
        }
        if (bl && this.routeCalcType != -1) {
            routeOptions.setRouteType(this.getDynamicRouteCalcType(this.routeCalcType));
        }
        if (this.env.getLogChannel().isDebug2()) {
            this.env.getLogChannel().log(100000000, "RouteCriteria#getRouteOptions() - route 1: %1, route 2: %2, route 3: %3", (Object)routeOptions, (Object)routeOptions2, (Object)routeOptions3);
        }
        return new RouteOptions[]{routeOptions, routeOptions2, routeOptions3};
    }

    private void setCommonOptions(RouteOptions routeOptions) {
        if (this.freeways == 1) {
            routeOptions.setMotorways(4);
        } else if (this.freeways == 2) {
            routeOptions.setMotorways(3);
        }
        if (this.vignettes == 1) {
            routeOptions.setVignette(1);
        } else if (this.vignettes == 2) {
            routeOptions.setVignette(2);
        } else if (this.vignettes == 7) {
            routeOptions.setVignette(8);
        }
        if (this.tunnels == 1) {
            routeOptions.setTunnels(1);
        } else if (this.tunnels == 2) {
            routeOptions.setTunnels(2);
        } else if (this.tunnels == 7) {
            routeOptions.setTunnels(8);
        }
        if (this.hovLanes == 1) {
            routeOptions.setHovCarPoolsLane(1);
        } else if (this.hovLanes == 2) {
            routeOptions.setHovCarPoolsLane(0);
        }
        routeOptions.setVignetteCountryList(this.vignetteCountries);
        if (this.tollRoads == 1) {
            routeOptions.setTollroads(1);
        } else if (this.tollRoads == 2) {
            routeOptions.setTollroads(3);
        }
        if (this.ferries == 1) {
            routeOptions.setFerries(1);
        } else if (this.ferries == 2) {
            routeOptions.setFerries(3);
        }
        if (this.motorrail == 1) {
            routeOptions.setCartrain(1);
        } else if (this.motorrail == 2) {
            routeOptions.setCartrain(3);
        }
        if (this.timeRestrictedRoads == 1) {
            routeOptions.setTimeDomain(1);
        } else if (this.timeRestrictedRoads == 2) {
            routeOptions.setTimeDomain(2);
        } else if (this.timeRestrictedRoads == 3) {
            routeOptions.setTimeDomain(5);
        }
        if (this.seasonRestricted == 1) {
            routeOptions.setSeasonalTimeDomain(1);
        } else if (this.seasonRestricted == 2) {
            routeOptions.setSeasonalTimeDomain(2);
        } else if (this.seasonRestricted == 3) {
            routeOptions.setSeasonalTimeDomain(5);
        }
        if (this.trailer == 6 || !Util.isTrailerModeAvailable(this.env.getFramework())) {
            routeOptions.setTrailer(2);
        } else if (this.trailer == 5) {
            routeOptions.setTrailer(1);
        } else if (this.trailer == 3) {
            int n = 2;
            int n2 = this.env.getChoiceModel(401782).getValue();
            n = n2 == 1 ? 1 : 2;
            routeOptions.setTrailer(n);
        }
        if (this.unpaved == 0) {
            routeOptions.setUnpaved(0);
        } else if (this.unpaved == 2) {
            routeOptions.setUnpaved(2);
        } else if (this.unpaved == 1) {
            routeOptions.setUnpaved(1);
        }
        if (this.ipd == 0) {
            routeOptions.setIpd(0);
        } else if (this.ipd == 2) {
            routeOptions.setIpd(2);
        } else if (this.ipd == 1) {
            routeOptions.setIpd(1);
        }
    }

    public int getTrafficRerouting() {
        return this.trafficRerouting;
    }

    public void setTrafficRerouting(int n) {
        this.trafficRerouting = n;
    }

    public int getFreeways() {
        return this.freeways;
    }

    public void setFreeways(int n) {
        this.freeways = n;
    }

    public int getTollRoads() {
        return this.tollRoads;
    }

    public void setTollRoads(int n) {
        this.tollRoads = n;
    }

    public int getFerries() {
        return this.ferries;
    }

    public void setFerries(int n) {
        this.ferries = n;
    }

    public int getMotorrail() {
        return this.motorrail;
    }

    public void setMotorrail(int n) {
        this.motorrail = n;
    }

    public int getTimeRestrictedRoads() {
        return this.timeRestrictedRoads;
    }

    public void setTimeRestrictedRoads(int n) {
        this.timeRestrictedRoads = n;
    }

    public int getSeasonRestricted() {
        return this.seasonRestricted;
    }

    public void setSeasonRestricted(int n) {
        this.seasonRestricted = n;
    }

    public int getTrailer() {
        return this.trailer;
    }

    public void setTrailer(int n) {
        this.trailer = n;
    }

    public int getVignettes() {
        return this.vignettes;
    }

    public void setVignettes(int n) {
        this.vignettes = n;
    }

    public int[] getVignetteCountries() {
        int[] nArray = new int[this.vignetteCountries.length];
        System.arraycopy((Object)this.vignetteCountries, 0, (Object)nArray, 0, this.vignetteCountries.length);
        return nArray;
    }

    public void setVignetteCountries(int[] nArray) {
        if (nArray == null) {
            this.vignetteCountries = new int[0];
            return;
        }
        int[] nArray2 = new int[nArray.length];
        System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, nArray.length);
        this.vignetteCountries = nArray2;
    }

    public int getRouteOption() {
        return this.routeCalcType;
    }

    public void setRouteOption(int n) {
        this.routeCalcType = n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1850);
        stringBuffer.append("RouteCriteria(trafficRerouting=");
        stringBuffer.append(this.trafficRerouting);
        stringBuffer.append(",freeways=");
        stringBuffer.append(this.freeways);
        stringBuffer.append(",vignettes=");
        stringBuffer.append(this.vignettes);
        stringBuffer.append(',');
        stringBuffer.append("vignetteCountryList[]= {");
        if (this.vignetteCountries != null) {
            int n = this.vignetteCountries.length;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.vignetteCountries[i2]);
                if (i2 == n - 1) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.vignetteCountries);
        }
        stringBuffer.append('}');
        stringBuffer.append(",tollRoads=");
        stringBuffer.append(this.tollRoads);
        stringBuffer.append(",ferries=");
        stringBuffer.append(this.ferries);
        stringBuffer.append(",motorrail=");
        stringBuffer.append(this.motorrail);
        stringBuffer.append(",timeRestrictedRoads=");
        stringBuffer.append(this.timeRestrictedRoads);
        stringBuffer.append(",seasonRestricted=");
        stringBuffer.append(this.seasonRestricted);
        stringBuffer.append(",trailer=");
        stringBuffer.append(this.trailer);
        stringBuffer.append(",routeCalcType=");
        stringBuffer.append(this.routeCalcType);
        stringBuffer.append(",tunnels=");
        stringBuffer.append(this.tunnels);
        stringBuffer.append(",hovLanes=");
        stringBuffer.append(this.hovLanes);
        return stringBuffer.toString();
    }

    public boolean equals(Object object) {
        if (object == null || !(object instanceof RouteCriteria)) {
            return false;
        }
        RouteCriteria routeCriteria = (RouteCriteria)object;
        return this.ferries == routeCriteria.ferries && this.freeways == routeCriteria.freeways && this.motorrail == routeCriteria.motorrail && this.seasonRestricted == routeCriteria.seasonRestricted && this.timeRestrictedRoads == routeCriteria.timeRestrictedRoads && this.tollRoads == routeCriteria.tollRoads && this.trafficRerouting == routeCriteria.trafficRerouting && this.trailer == routeCriteria.trailer && this.routeCalcType == routeCriteria.routeCalcType && this.vignettes == routeCriteria.vignettes && this.tunnels == routeCriteria.tunnels && this.hovLanes == routeCriteria.hovLanes && Arrays.equals(this.vignetteCountries, routeCriteria.vignetteCountries);
    }

    public int hashCode() {
        int n;
        int n2 = 0;
        for (n = 0; n < this.vignetteCountries.length; ++n) {
            n2 += this.vignetteCountries[n];
        }
        n = this.trafficRerouting + this.freeways + this.tollRoads + this.ferries + this.motorrail + this.timeRestrictedRoads + this.seasonRestricted + this.trailer + this.vignettes + this.routeCalcType + this.tunnels + this.hovLanes + n2;
        return n;
    }

    public void setTunnels(int n) {
        this.tunnels = n;
    }

    public int getTunnels() {
        return this.tunnels;
    }

    public int getHovLanes() {
        return this.hovLanes;
    }

    public void setHovLanes(int n) {
        this.hovLanes = n;
    }

    public void setUnpaved(int n) {
        this.unpaved = n;
    }

    public int getUnpaved() {
        return this.unpaved;
    }

    public void setIpd(int n) {
        this.ipd = n;
    }

    public int getIpd() {
        return this.ipd;
    }
}

