/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;

public interface ILocationDisambiguationCallback {
    public static final int ACTION_IS_ROUTE_GUIDANCE = 0;
    public static final int ACTION_IS_FAVORITE = 1;
    public static final int ACTION_IS_ADD_TO_CONTACT = 2;
    public static final int ACTION_IS_ADD_TO_CONTACT_FROM_ADB = 3;
    public static final int ACTION_IS_HOME_ADDRESS = 4;
    public static final int ACTION_IS_POI = 5;
    public static final int ACTION_IS_STOPOVER = 6;

    public void locationDisambiguationCallback(LocationDisambiguationWrapper var1);
}

