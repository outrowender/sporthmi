/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.app.connectivity.manager.contents.IDeviceSelection;

public interface ISelectionHandler {
    default public void deviceSelected(IDeviceSelection iDeviceSelection, int n) {
    }

    default public void connectNewDeviceSelected(int n) {
    }
}

