/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMap;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMapView;
import org.dsi.ifc.base.DSIBase;
import org.osgi.framework.BundleContext;

public class NullTrafficMiniMap
implements ITrafficMiniMap {
    public ITrafficMiniMapView getView(IFrameworkAccess iFrameworkAccess) {
        return null;
    }

    public void startDSI(BundleContext bundleContext) {
    }

    public void stopDSI(BundleContext bundleContext) {
    }

    public DSIBase getDSI() {
        return null;
    }

    public void persistSettings() {
    }

    public void setActive(boolean bl) {
    }

    public void setCurrentSystemLanguage() {
    }

    public boolean isActive() {
        return false;
    }

    public void tmpCommandSetActive(boolean bl) {
    }

    public void loadState() {
    }

    public void resetSettings() {
    }

    public void cleanup() {
    }

    public void hideTrafficMiniMap() {
    }

    public boolean isVisible() {
        return false;
    }

    public void activateAndPersist(boolean bl) {
    }
}

