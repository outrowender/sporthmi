/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.atip.utils.generics.GList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface IDeviceListListener {
    public void updateDeviceList(GList<TMDevice> var1);
}

