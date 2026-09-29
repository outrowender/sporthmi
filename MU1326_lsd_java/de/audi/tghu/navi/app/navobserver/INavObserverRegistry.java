/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navobserver;

import de.audi.tghu.navi.app.navobserver.ICcpCountryUpdatedObserver;
import de.audi.tghu.navi.app.navobserver.ICountryStateUpdatedObserver;
import org.dsi.ifc.global.NavLocation;

public interface INavObserverRegistry {
    default public boolean addCountryUpdatedObserver(ICountryStateUpdatedObserver iCountryStateUpdatedObserver) {
    }

    default public boolean removeCountryUpdatedObserver(ICountryStateUpdatedObserver iCountryStateUpdatedObserver) {
    }

    default public boolean addCcpCountryUpdatedObserver(ICcpCountryUpdatedObserver iCcpCountryUpdatedObserver) {
    }

    default public boolean removeCcpCountryUpdatedObserver(ICcpCountryUpdatedObserver iCcpCountryUpdatedObserver) {
    }

    default public void countryUpdated(String string, String string2) {
    }

    default public void stateUpdated(String string, String string2) {
    }

    default public void ccpCountryUpdated(NavLocation navLocation) {
    }
}

