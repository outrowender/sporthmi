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
    @Override
    public boolean addCountryUpdatedObserver(ICountryStateUpdatedObserver iCountryStateUpdatedObserver) {
        return false;
    }

    @Override
    public boolean removeCountryUpdatedObserver(ICountryStateUpdatedObserver iCountryStateUpdatedObserver) {
        return false;
    }

    @Override
    public boolean addCcpCountryUpdatedObserver(ICcpCountryUpdatedObserver iCcpCountryUpdatedObserver) {
        return false;
    }

    @Override
    public boolean removeCcpCountryUpdatedObserver(ICcpCountryUpdatedObserver iCcpCountryUpdatedObserver) {
        return false;
    }

    @Override
    public void countryUpdated(String string, String string2) {
    }

    @Override
    public void stateUpdated(String string, String string2) {
    }

    @Override
    public void ccpCountryUpdated(NavLocation navLocation) {
    }
}

