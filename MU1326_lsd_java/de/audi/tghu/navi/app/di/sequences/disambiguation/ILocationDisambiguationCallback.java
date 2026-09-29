/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;

public interface ILocationDisambiguationCallback {
    public static final int ACTION_IS_ROUTE_GUIDANCE;
    public static final int ACTION_IS_FAVORITE;
    public static final int ACTION_IS_ADD_TO_CONTACT;
    public static final int ACTION_IS_ADD_TO_CONTACT_FROM_ADB;
    public static final int ACTION_IS_HOME_ADDRESS;
    public static final int ACTION_IS_POI;
    public static final int ACTION_IS_STOPOVER;

    default public void locationDisambiguationCallback(LocationDisambiguationWrapper locationDisambiguationWrapper) {
    }
}

