/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navobserver;

import de.audi.tghu.navi.app.navobserver.ICcpCountryUpdatedObserver;
import de.audi.tghu.navi.app.navobserver.ICountryStateUpdatedObserver;
import org.dsi.ifc.global.NavLocation;

public interface INavObserverRegistry {
    public boolean addCountryUpdatedObserver(ICountryStateUpdatedObserver var1);

    public boolean removeCountryUpdatedObserver(ICountryStateUpdatedObserver var1);

    public boolean addCcpCountryUpdatedObserver(ICcpCountryUpdatedObserver var1);

    public boolean removeCcpCountryUpdatedObserver(ICcpCountryUpdatedObserver var1);

    public void countryUpdated(String var1, String var2);

    public void stateUpdated(String var1, String var2);

    public void ccpCountryUpdated(NavLocation var1);
}

