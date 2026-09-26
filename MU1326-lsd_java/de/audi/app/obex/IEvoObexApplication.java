/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.obex;

import de.audi.app.connectivity.IEvoConnectivity;
import de.audi.app.obex.core.IObexApplication;

public interface IEvoObexApplication
extends IObexApplication {
    default public IEvoConnectivity getEvoConnectivity() {
    }
}

