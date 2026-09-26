/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.car.jokerkey;

import de.audi.atip.interapp.car.jokerkey.ICarJokerKeyVisibilityClient;
import org.dsi.ifc.global.CarViewOption;

public interface ICarJokerKeyVisibilityProxy {
    default public boolean hasClients() {
    }

    default public void registerClient(ICarJokerKeyVisibilityClient iCarJokerKeyVisibilityClient) {
    }

    default public void unregisterClient(ICarJokerKeyVisibilityClient iCarJokerKeyVisibilityClient) {
    }

    default public void invokeCurrentVisibilityRequest() {
    }

    default public void notifyVisibilityChanged(int n, CarViewOption carViewOption) {
    }
}

