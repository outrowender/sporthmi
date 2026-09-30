/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.rrd;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import de.audi.tghu.navi.app.guidance.IVehicle;

public interface IRRDListProviderFactory {
    public IRRDListProvider getProviderForType(int var1, NavigationEnv var2, IVehicle var3);

    public void cleanUp();
}

