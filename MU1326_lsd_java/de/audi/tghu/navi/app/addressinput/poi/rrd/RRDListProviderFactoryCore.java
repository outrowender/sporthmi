/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import de.audi.app.navi.evo.addressinput.poi.rrd.IRRDListProviderFactory;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import de.audi.tghu.navi.app.addressinput.poi.rrd.PoiResultRRDListProvider;
import de.audi.tghu.navi.app.guidance.IVehicle;

public class RRDListProviderFactoryCore
implements IRRDListProviderFactory {
    protected LogChannel logChannel;
    protected Navigation navigation;

    public RRDListProviderFactoryCore(LogChannel logChannel, Navigation navigation) {
        this.logChannel = logChannel;
        this.navigation = navigation;
    }

    public IRRDListProvider getProviderForType(int n, NavigationEnv navigationEnv, IVehicle iVehicle) {
        switch (n) {
            case 3: {
                this.logChannel.log(10000000, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_SDS");
                return new PoiResultRRDListProvider(navigationEnv, 3901, iVehicle);
            }
        }
        return null;
    }

    public void cleanUp() {
        this.logChannel = null;
        this.navigation = null;
    }
}

