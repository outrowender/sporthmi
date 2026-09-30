/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.app.connectivity.manager.contents.IDeviceSelection;

public interface ISelectionHandler {
    public void deviceSelected(IDeviceSelection var1, int var2);

    public void connectNewDeviceSelected(int var1);
}

