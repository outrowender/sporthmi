/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMapView$NullMiniMapView;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;

public interface ITrafficMiniMapView {
    public static final ITrafficMiniMapView NULL_TMM_VIEW = new ITrafficMiniMapView$NullMiniMapView();

    default public boolean displayMiniMap(ResourceInformation resourceInformation) {
    }

    default public void hideMiniMap() {
    }

    default public void activateAndPersist() {
    }

    default public void deactivateAndPersist() {
    }

    default public boolean isActivated() {
    }

    default public void initModels() {
    }

    default public void setActive(boolean bl) {
    }

    default public boolean isVisible() {
    }
}

