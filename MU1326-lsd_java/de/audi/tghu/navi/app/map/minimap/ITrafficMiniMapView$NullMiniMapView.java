/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMapView;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;

public final class ITrafficMiniMapView$NullMiniMapView
implements ITrafficMiniMapView {
    @Override
    public void setActive(boolean bl) {
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public boolean isActivated() {
        return false;
    }

    @Override
    public void initModels() {
    }

    @Override
    public void hideMiniMap() {
    }

    @Override
    public boolean displayMiniMap(ResourceInformation resourceInformation) {
        return false;
    }

    @Override
    public void deactivateAndPersist() {
    }

    @Override
    public void activateAndPersist() {
    }
}

