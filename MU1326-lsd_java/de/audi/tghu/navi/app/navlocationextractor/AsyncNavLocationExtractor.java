/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;

public interface AsyncNavLocationExtractor {
    public static final String NAV_LOCATION_KEY;

    default public void executeCallbackWithNavLocation(EvoListRow evoListRow, int n, NavLocationCallback navLocationCallback) {
    }
}

