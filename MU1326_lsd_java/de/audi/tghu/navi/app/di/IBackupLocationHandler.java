/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import org.dsi.ifc.global.NavLocation;

public interface IBackupLocationHandler {
    default public NavLocation getBackupLocation() {
    }

    default public NavLocation getPersistedBackupLocation() {
    }

    default public void invalidateBackupLocation() {
    }

    default public void persistBackupLocation(NavLocation navLocation) {
    }

    default public void setBackupLocation(NavLocation navLocation) {
    }
}

