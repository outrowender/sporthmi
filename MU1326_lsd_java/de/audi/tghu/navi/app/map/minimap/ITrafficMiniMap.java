/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import org.dsi.ifc.base.DSIBase;
import org.osgi.framework.BundleContext;

public interface ITrafficMiniMap {
    public static final int FEATURE_DISABLED;

    default public void startDSI(BundleContext bundleContext) {
    }

    default public void stopDSI(BundleContext bundleContext) {
    }

    default public DSIBase getDSI() {
    }

    default public void persistSettings() {
    }

    default public void setActive(boolean bl) {
    }

    default public void setCurrentSystemLanguage() {
    }

    default public boolean isActive() {
    }

    default public void tmpCommandSetActive(boolean bl) {
    }

    default public void loadState() {
    }

    default public void resetSettings() {
    }

    default public void cleanup() {
    }

    default public boolean isVisible() {
    }

    default public void hideTrafficMiniMap() {
    }

    default public void activateAndPersist(boolean bl) {
    }
}

