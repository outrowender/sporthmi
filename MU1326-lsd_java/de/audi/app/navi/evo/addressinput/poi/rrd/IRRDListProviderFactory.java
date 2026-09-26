/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.rrd;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import de.audi.tghu.navi.app.guidance.IVehicle;

public interface IRRDListProviderFactory {
    default public IRRDListProvider getProviderForType(int n, NavigationEnv navigationEnv, IVehicle iVehicle) {
    }

    default public void cleanUp() {
    }
}

