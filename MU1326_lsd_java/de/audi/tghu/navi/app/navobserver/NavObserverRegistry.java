/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navobserver;

import de.audi.tghu.navi.app.navobserver.ICcpCountryUpdatedObserver;
import de.audi.tghu.navi.app.navobserver.ICountryStateUpdatedObserver;
import de.audi.tghu.navi.app.navobserver.INavObserverRegistry;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.NavLocation;

public class NavObserverRegistry
implements INavObserverRegistry {
    private List destinationCountryUpdatedObservers = new ArrayList();
    private List ccpCountryUpdatedObservers = new ArrayList();

    @Override
    public boolean addCountryUpdatedObserver(ICountryStateUpdatedObserver iCountryStateUpdatedObserver) {
        if (null != iCountryStateUpdatedObserver) {
            return this.destinationCountryUpdatedObservers.add(iCountryStateUpdatedObserver);
        }
        return false;
    }

    @Override
    public boolean removeCountryUpdatedObserver(ICountryStateUpdatedObserver iCountryStateUpdatedObserver) {
        if (null != iCountryStateUpdatedObserver) {
            return this.destinationCountryUpdatedObservers.remove(iCountryStateUpdatedObserver);
        }
        return false;
    }

    @Override
    public boolean addCcpCountryUpdatedObserver(ICcpCountryUpdatedObserver iCcpCountryUpdatedObserver) {
        if (null != iCcpCountryUpdatedObserver) {
            return this.ccpCountryUpdatedObservers.add(iCcpCountryUpdatedObserver);
        }
        return false;
    }

    @Override
    public boolean removeCcpCountryUpdatedObserver(ICcpCountryUpdatedObserver iCcpCountryUpdatedObserver) {
        if (null != iCcpCountryUpdatedObserver) {
            return this.ccpCountryUpdatedObservers.remove(iCcpCountryUpdatedObserver);
        }
        return false;
    }

    @Override
    public void countryUpdated(String string, String string2) {
        for (int i2 = 0; i2 < this.destinationCountryUpdatedObservers.size(); ++i2) {
            ICountryStateUpdatedObserver iCountryStateUpdatedObserver = (ICountryStateUpdatedObserver)this.destinationCountryUpdatedObservers.get(i2);
            if (null == iCountryStateUpdatedObserver) continue;
            iCountryStateUpdatedObserver.countryUpdated(string, string2);
        }
    }

    @Override
    public void stateUpdated(String string, String string2) {
        for (int i2 = 0; i2 < this.destinationCountryUpdatedObservers.size(); ++i2) {
            ICountryStateUpdatedObserver iCountryStateUpdatedObserver = (ICountryStateUpdatedObserver)this.destinationCountryUpdatedObservers.get(i2);
            if (null == iCountryStateUpdatedObserver) continue;
            iCountryStateUpdatedObserver.stateUpdated(string, string2);
        }
    }

    @Override
    public void ccpCountryUpdated(NavLocation navLocation) {
        for (int i2 = 0; i2 < this.ccpCountryUpdatedObservers.size(); ++i2) {
            ICcpCountryUpdatedObserver iCcpCountryUpdatedObserver = (ICcpCountryUpdatedObserver)this.ccpCountryUpdatedObservers.get(i2);
            if (null == iCcpCountryUpdatedObserver) continue;
            iCcpCountryUpdatedObserver.ccpCountryUpdated(navLocation);
        }
    }
}

