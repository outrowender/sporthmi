/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Consts;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.io.Serializable;
import java.util.Arrays;
import org.dsi.ifc.navigation.RouteOptions;

public class Criteria
implements Serializable {
    private static final long serialVersionUID;
    private static final int FLAG_DYNAMIC;
    private static final int FLAG_AVOIDFERRIES;
    private static final int FLAG_AVOIDMOTORWAYS;
    private static final int FLAG_AVOIDTOLLROADS;
    private static final int FLAG_AVOIDTUNNELS;
    private static final int FLAG_AVOIDCARTRAIN;
    private static final int FLAG_HYBRIDMODE;
    private static final int FLAG_SLOPES;
    private static final int FLAG_LEFTRIGHTTURN;
    private static final int FLAG_RESIDENTIALAREAHANDLING;
    private static final int FLAG_TRAILER;
    private static final int FLAG_BORDER;
    private static final int FLAG_ECONOMICTURNS;
    private static final int FLAG_WEIGHTING_NORMAL;
    private static final int FLAG_WEIGHTING_OPTIMAL;
    private static final int FLAG_TROLLROADSCOSTPENALTY;
    private static final int FLAG_SLOPESMAXFACTOR;
    private static final int FLAG_UNPAVED;
    private static final int FLAG_IPD;
    private static final int FLAG_AVOIDHOVLANES;
    private int altRouteState;
    private int routeCalculationType;
    private int dailyRestricted;
    private int seasonRestricted;
    private int vignetteType;
    private int[] vignetteCountries = new int[0];
    private byte[] flags = new byte[Consts.FLAG_DEFAULT_VALUES.length];
    private NavigationEnv env;

    public Criteria(NavigationEnv navigationEnv) {
        this(navigationEnv, null);
    }

    public Criteria(NavigationEnv navigationEnv, Criteria criteria) {
        this.env = navigationEnv;
        this.initialize(criteria);
    }

    public final void initialize(Criteria criteria) {
        if (criteria != null) {
            this.initialize(criteria.getAltRouteState(), criteria.getRouteCalculationType(), criteria.getDailyRestricted(), criteria.getSeasonRestricted(), criteria.getVignetteType(), criteria.getVignetteCountries(), criteria.getFlags());
        }
    }

    public final void initialize(int n, int n2, int n3, int n4, int n5, int[] nArray, byte[] byArray) {
        this.setAltRouteState(n);
        this.setRouteCalculationType(n2);
        this.setDailyRestricted(n3);
        this.setSeasonRestricted(n4);
        this.setVignetteType(n5);
        this.setVignetteCountries(nArray);
        this.setFlags(byArray);
    }

    public int getAltRouteState() {
        return this.altRouteState;
    }

    public final void setAltRouteState(int n) {
        this.altRouteState = n;
    }

    public int getRouteCalculationType() {
        return this.routeCalculationType;
    }

    public final void setRouteCalculationType(int n) {
        this.routeCalculationType = n;
    }

    public int getDailyRestricted() {
        return this.dailyRestricted;
    }

    public final void setDailyRestricted(int n) {
        this.dailyRestricted = n;
    }

    public int getSeasonRestricted() {
        return this.seasonRestricted;
    }

    public final void setSeasonRestricted(int n) {
        this.seasonRestricted = n;
    }

    public int getVignetteType() {
        return this.vignetteType;
    }

    public final void setVignetteType(int n) {
        this.vignetteType = n;
    }

    public final void setVignetteCountries(int[] nArray) {
        if (nArray != null) {
            this.vignetteCountries = new int[nArray.length];
            System.arraycopy((Object)nArray, 0, (Object)this.vignetteCountries, 0, nArray.length);
        } else {
            this.vignetteCountries = new int[0];
        }
    }

    public int[] getVignetteCountries() {
        return this.vignetteCountries;
    }

    public byte[] getFlags() {
        return this.flags;
    }

    public final void setFlags(byte[] byArray) {
        if (byArray != null) {
            this.flags = new byte[byArray.length];
            System.arraycopy((Object)byArray, 0, (Object)this.flags, 0, byArray.length);
        } else {
            this.flags = new byte[0];
        }
    }

    public void setDynamicMode(int n) {
        this.flags[0] = (byte)n;
    }

    public void setAvoidMotorways(boolean bl) {
        this.flags[2] = bl ? (byte)1 : 0;
    }

    public void setAvoidHovLanes(boolean bl) {
        this.flags[20] = bl ? (byte)1 : 0;
    }

    public void setAvoidTollroads(boolean bl) {
        this.flags[3] = bl ? (byte)1 : 0;
    }

    public void setAvoidTunnels(boolean bl) {
        this.flags[4] = bl ? (byte)1 : 0;
    }

    public void setAvoidCarTrain(boolean bl) {
        this.flags[5] = bl ? (byte)1 : 0;
    }

    public void setAvoidFerries(boolean bl) {
        this.flags[1] = bl ? (byte)1 : 0;
    }

    public boolean isDynamic() {
        return this.flags[0] != 2;
    }

    public byte getDynamicMode() {
        return this.flags[0];
    }

    public boolean isAvoidMotorways() {
        return this.flags[2] == 1;
    }

    public boolean isAvoidHovLanes() {
        return this.flags[20] == 1;
    }

    public boolean isAvoidTollroads() {
        return this.flags[3] == 1;
    }

    public boolean isAvoidTunnels() {
        return this.flags[4] == 1;
    }

    public boolean isAvoidCarTrain() {
        return this.flags[5] == 1;
    }

    public boolean isAvoidFerries() {
        return this.flags[1] == 1;
    }

    public byte getHybridMode() {
        return this.flags[6];
    }

    public byte getSlopes() {
        return this.flags[7];
    }

    public byte getResidentialAreaHandling() {
        return this.flags[9];
    }

    public byte getTrailer() {
        return this.flags[10];
    }

    public byte getBorder() {
        return this.flags[11];
    }

    public byte getHovCarPoolsLane() {
        if (this.isAvoidHovLanes()) {
            return 0;
        }
        return 1;
    }

    public byte getEconomicTurns() {
        return this.flags[13];
    }

    public byte getLeftRightTurn() {
        return this.flags[8];
    }

    public int getWeightingNormal() {
        return this.flags[14];
    }

    public int getWeightingOptimal() {
        return this.flags[15];
    }

    public int getTollroadsCostPenalty() {
        return this.flags[16];
    }

    public int getSlopesMaxFaktor() {
        return this.flags[17];
    }

    public int getUnpavedRoads() {
        return this.flags[18];
    }

    public int getIPDData() {
        return this.flags[19];
    }

    public void initializeRouteOptions(RouteOptions routeOptions) {
        if (routeOptions != null) {
            switch (this.getRouteCalculationType()) {
                case 0: {
                    routeOptions.setRouteType(0);
                    break;
                }
                case 1: {
                    routeOptions.setRouteType(1);
                    break;
                }
                case 2: {
                    routeOptions.setRouteType(7);
                    break;
                }
                default: {
                    this.env.getLogChannel().log(-1601830656, "Criteria#initializeRouteOptions() - unknown routeCalculationType: %1", (long)this.getRouteCalculationType());
                }
            }
            if (Util.isHURegionNAR()) {
                routeOptions.setDynamic(10);
            } else {
                switch (this.getDynamicMode()) {
                    case 0: {
                        routeOptions.setDynamic(5);
                        break;
                    }
                    case 1: {
                        routeOptions.setDynamic(10);
                        break;
                    }
                    case 2: {
                        routeOptions.setDynamic(7);
                        break;
                    }
                    default: {
                        routeOptions.setDynamic(5);
                    }
                }
            }
            if (this.getRouteCalculationType() == 0) {
                routeOptions.setMotorways(this.isAvoidMotorways() ? 3 : 4);
            } else {
                routeOptions.setMotorways(this.isAvoidMotorways() ? 3 : 1);
            }
            routeOptions.setTunnels(this.isAvoidTunnels() ? 3 : 1);
            routeOptions.setTollroads(this.isAvoidTollroads() ? 3 : 1);
            routeOptions.setCartrain(this.isAvoidCarTrain() ? 3 : 1);
            routeOptions.setFerries(this.isAvoidFerries() ? 3 : 1);
            switch (this.getDailyRestricted()) {
                case 0: {
                    routeOptions.setTimeDomain(5);
                    break;
                }
                case 1: {
                    routeOptions.setTimeDomain(1);
                    break;
                }
                case 2: {
                    routeOptions.setTimeDomain(2);
                    break;
                }
                default: {
                    this.env.getLogChannel().log(-1601830656, "Criteria#initializeRouteOptions() - unknown seasonRestricted: %1", (long)this.getDailyRestricted());
                }
            }
            switch (this.getSeasonRestricted()) {
                case 0: {
                    routeOptions.setSeasonalTimeDomain(5);
                    break;
                }
                case 1: {
                    routeOptions.setSeasonalTimeDomain(1);
                    break;
                }
                case 2: {
                    routeOptions.setSeasonalTimeDomain(2);
                    break;
                }
                default: {
                    this.env.getLogChannel().log(-1601830656, "Criteria#initializeRouteOptions() - unknown seasonRestricted: %1", (long)this.getSeasonRestricted());
                }
            }
            switch (this.getVignetteType()) {
                case 0: {
                    routeOptions.setVignette(1);
                    break;
                }
                case 1: {
                    routeOptions.setVignette(2);
                    break;
                }
                case 2: {
                    if (Util.isHURegionNAR()) {
                        routeOptions.setVignette(9);
                        break;
                    }
                    routeOptions.setVignette(8);
                    break;
                }
                default: {
                    this.env.getLogChannel().log(-1601830656, "Criteria#initializeRouteOptions() - unknown vignetteType: %1", (long)this.getVignetteType());
                }
            }
            int[] nArray = new int[this.getVignetteCountries().length];
            System.arraycopy((Object)this.getVignetteCountries(), 0, (Object)nArray, 0, this.getVignetteCountries().length);
            routeOptions.setVignetteCountryList(nArray);
            routeOptions.setCityMaut(this.getVignetteType() == 0 ? 1 : 2);
            if (Util.isHURegionNAR()) {
                routeOptions.setDynamicSpeedFlow(7);
                routeOptions.setDynamicTrafficPattern(7);
                routeOptions.setDynamicTrafficPatternOnline(7);
                routeOptions.setDynamicTrafficPatternRecorded(7);
            } else {
                boolean bl = this.isDynamic() && this.getRouteCalculationType() != 2;
                routeOptions.setDynamicTrafficPattern(bl ? 6 : 7);
                routeOptions.setDynamicTrafficPatternOnline(bl ? 6 : 7);
                routeOptions.setDynamicSpeedFlow(this.isDynamic() ? 6 : 7);
                routeOptions.setDynamicTrafficPatternRecorded(7);
            }
            routeOptions.setWeighting(this.getRouteCalculationType() == 2 ? this.getWeightingOptimal() : this.getWeightingNormal());
            routeOptions.setHybridMode(this.getHybridMode());
            routeOptions.setSlopes(this.getSlopes());
            routeOptions.setLeftRightTurn(this.getLeftRightTurn());
            routeOptions.setResidentialAreaHandling(this.getResidentialAreaHandling());
            routeOptions.setTrailer(this.getTrailer());
            routeOptions.setBorder(this.getBorder());
            routeOptions.setHovCarPoolsLane(this.getHovCarPoolsLane());
            routeOptions.setEconomicTurns(this.getEconomicTurns());
            routeOptions.setTollroadsCostPenalty(this.getTollroadsCostPenalty());
            routeOptions.setSlopesMaxFactor(this.getSlopesMaxFaktor());
            routeOptions.setUnpaved(this.getUnpavedRoads());
            routeOptions.setIpd(this.getIPDData());
        } else {
            this.env.getLogChannel().log(-2137614336, "Criteria#initializeRouteOptions() - RouteOptions object is null!");
        }
    }

    public boolean equals(Object object) {
        if (object instanceof Criteria) {
            Criteria criteria = (Criteria)object;
            boolean bl = true;
            bl &= this.altRouteState == criteria.getAltRouteState();
            bl &= this.routeCalculationType == criteria.getRouteCalculationType();
            bl &= this.dailyRestricted == criteria.getDailyRestricted();
            bl &= this.seasonRestricted == criteria.getSeasonRestricted();
            bl &= Arrays.equals(this.flags, criteria.getFlags());
            bl &= this.vignetteType == criteria.getVignetteType();
            return bl &= Arrays.equals(this.vignetteCountries, criteria.getVignetteCountries());
        }
        return false;
    }

    public String toString() {
        int n;
        Buffer buffer = new Buffer();
        buffer.append('[');
        buffer.append(this.altRouteState).append('|');
        buffer.append(this.routeCalculationType).append('|');
        buffer.append(this.dailyRestricted).append('|');
        buffer.append(this.seasonRestricted).append('|');
        buffer.append(this.vignetteType).append('|');
        int[] nArray = this.getVignetteCountries();
        for (n = 0; n < nArray.length; ++n) {
            buffer.append(nArray[n]);
            buffer.append(n == nArray.length - 1 ? (char)'|' : ',');
        }
        for (n = 0; n < this.flags.length; ++n) {
            buffer.append(this.flags[n]);
            buffer.append(',');
        }
        buffer.append(']');
        return buffer.toString();
    }
}

