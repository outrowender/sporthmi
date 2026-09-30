/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.car.jokerkey;

import de.audi.atip.interapp.car.jokerkey.ICarJokerKeyVisibilityClient;
import org.dsi.ifc.global.CarViewOption;

public interface ICarJokerKeyVisibilityProxy {
    public boolean hasClients();

    public void registerClient(ICarJokerKeyVisibilityClient var1);

    public void unregisterClient(ICarJokerKeyVisibilityClient var1);

    public void invokeCurrentVisibilityRequest();

    public void notifyVisibilityChanged(int var1, CarViewOption var2);
}

