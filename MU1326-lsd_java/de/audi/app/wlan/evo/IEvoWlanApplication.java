/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.evo;

import de.audi.app.connectivity.IEvoConnectivity;
import de.audi.app.wlan.core.IWlanApplication;

public interface IEvoWlanApplication
extends IWlanApplication {
    default public IEvoConnectivity getConnectivity() {
    }
}

