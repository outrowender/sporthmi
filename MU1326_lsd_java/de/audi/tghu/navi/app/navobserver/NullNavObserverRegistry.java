/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navobserver;

import de.audi.tghu.navi.app.navobserver.ICcpCountryUpdatedObserver;
import de.audi.tghu.navi.app.navobserver.ICountryStateUpdatedObserver;
import de.audi.tghu.navi.app.navobserver.INavObserverRegistry;
import org.dsi.ifc.global.NavLocation;

public class NullNavObserverRegistry
implements INavObserverRegistry {
    public boolean addCountryUpdatedObserver(ICountryStateUpdatedObserver iCountryStateUpdatedObserver) {
        return false;
    }

    public boolean removeCountryUpdatedObserver(ICountryStateUpdatedObserver iCountryStateUpdatedObserver) {
        return false;
    }

    public boolean addCcpCountryUpdatedObserver(ICcpCountryUpdatedObserver iCcpCountryUpdatedObserver) {
        return false;
    }

    public boolean removeCcpCountryUpdatedObserver(ICcpCountryUpdatedObserver iCcpCountryUpdatedObserver) {
        return false;
    }

    public void countryUpdated(String string, String string2) {
    }

    public void stateUpdated(String string, String string2) {
    }

    public void ccpCountryUpdated(NavLocation navLocation) {
    }
}

