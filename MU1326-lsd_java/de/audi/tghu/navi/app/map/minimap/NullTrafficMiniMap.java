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

    @Override
    public void startDSI(BundleContext bundleContext) {
    }

    @Override
    public void stopDSI(BundleContext bundleContext) {
    }

    @Override
    public DSIBase getDSI() {
        return null;
    }

    @Override
    public void persistSettings() {
    }

    @Override
    public void setActive(boolean bl) {
    }

    @Override
    public void setCurrentSystemLanguage() {
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void tmpCommandSetActive(boolean bl) {
    }

    @Override
    public void loadState() {
    }

    @Override
    public void resetSettings() {
    }

    @Override
    public void cleanup() {
    }

    @Override
    public void hideTrafficMiniMap() {
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public void activateAndPersist(boolean bl) {
    }
}

