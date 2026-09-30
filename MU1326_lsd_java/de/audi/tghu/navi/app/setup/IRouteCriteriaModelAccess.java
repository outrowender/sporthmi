/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.tghu.navi.app.setup.IRouteCriteria;

public interface IRouteCriteriaModelAccess {
    public static final int REROUTING_AUTO = 0;
    public static final int REROUTING_MANUAL = 1;
    public static final int REROUTING_OFF = 2;
    public static final int FREEWAYS_WITH = 0;
    public static final int FREEWAYS_AVOID = 1;
    public static final int TOLL_ROADS_WITH = 0;
    public static final int TOLL_ROADS_AVOID = 1;
    public static final int TUNNELS_WITH = 0;
    public static final int TUNNELS_AVOID = 1;
    public static final int HOV_LANES_WITH = 0;
    public static final int HOV_LANES_AVOID = 1;
    public static final int FERRIES_WITH = 0;
    public static final int FERRIES_AVOID = 1;
    public static final int MOTORRAIL_WITH = 0;
    public static final int MOTORRAIL_AVOID = 1;
    public static final int TIME_RESTRICTED_WITH = 1;
    public static final int TIME_RESTRICTED_AVOID = 2;
    public static final int TIME_RESTRICTED_AUTO = 0;
    public static final int SEASONAL_RESTRICTED_WITH = 1;
    public static final int SEASONAL_RESTRICTED_AVOID = 2;
    public static final int SEASONAL_RESTRICTED_AUTO = 0;
    public static final int TRAILER_ON = 1;
    public static final int TRAILER_OFF = 0;
    public static final int TRAILER_AUTO = 2;
    public static final int VIGNETTE_WITH = 0;
    public static final int VIGNETTE_AVOID = 1;
    public static final int VIGNETTE_AVOID_EXCEPT_COUNTRIES = 2;
    public static final int WAY_ECOLOGICAL = 0;
    public static final int WAY_FAST = 1;
    public static final int WAY_SHORT = 2;
    public static final int WAY_RECOMMENDED = 3;
    public static final int WAY_AVOIDTOLL = 4;
    public static final int WAY_FAST2 = 5;
    public static final int WAY_BITMASK_ECOLOGICAL = 1;
    public static final int WAY_BITMASK_FAST = 2;
    public static final int WAY_BITMASK_SHORT = 4;
    public static final int WAY_BITMASK_RECOMMENDED = 8;
    public static final int WAY_BITMASK_AVOIDTOLL = 16;
    public static final int WAY_BITMASK_FAST2 = 32;

    public void onStart(IRouteCriteria var1);
}

