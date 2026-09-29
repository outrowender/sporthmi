/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.tghu.navi.app.setup.IRouteCriteria;

public interface IRouteCriteriaModelAccess {
    public static final int REROUTING_AUTO;
    public static final int REROUTING_MANUAL;
    public static final int REROUTING_OFF;
    public static final int FREEWAYS_WITH;
    public static final int FREEWAYS_AVOID;
    public static final int TOLL_ROADS_WITH;
    public static final int TOLL_ROADS_AVOID;
    public static final int TUNNELS_WITH;
    public static final int TUNNELS_AVOID;
    public static final int HOV_LANES_WITH;
    public static final int HOV_LANES_AVOID;
    public static final int FERRIES_WITH;
    public static final int FERRIES_AVOID;
    public static final int MOTORRAIL_WITH;
    public static final int MOTORRAIL_AVOID;
    public static final int TIME_RESTRICTED_WITH;
    public static final int TIME_RESTRICTED_AVOID;
    public static final int TIME_RESTRICTED_AUTO;
    public static final int SEASONAL_RESTRICTED_WITH;
    public static final int SEASONAL_RESTRICTED_AVOID;
    public static final int SEASONAL_RESTRICTED_AUTO;
    public static final int TRAILER_ON;
    public static final int TRAILER_OFF;
    public static final int TRAILER_AUTO;
    public static final int VIGNETTE_WITH;
    public static final int VIGNETTE_AVOID;
    public static final int VIGNETTE_AVOID_EXCEPT_COUNTRIES;
    public static final int WAY_ECOLOGICAL;
    public static final int WAY_FAST;
    public static final int WAY_SHORT;
    public static final int WAY_RECOMMENDED;
    public static final int WAY_AVOIDTOLL;
    public static final int WAY_FAST2;
    public static final int WAY_BITMASK_ECOLOGICAL;
    public static final int WAY_BITMASK_FAST;
    public static final int WAY_BITMASK_SHORT;
    public static final int WAY_BITMASK_RECOMMENDED;
    public static final int WAY_BITMASK_AVOIDTOLL;
    public static final int WAY_BITMASK_FAST2;

    default public void onStart(IRouteCriteria iRouteCriteria) {
    }
}

