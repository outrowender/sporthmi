/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;

public interface ITrafficMiniMapView {
    public static final ITrafficMiniMapView NULL_TMM_VIEW = new NullMiniMapView();

    public boolean displayMiniMap(ResourceInformation var1);

    public void hideMiniMap();

    public void activateAndPersist();

    public void deactivateAndPersist();

    public boolean isActivated();

    public void initModels();

    public void setActive(boolean var1);

    public boolean isVisible();

    public static final class NullMiniMapView
    implements ITrafficMiniMapView {
        public void setActive(boolean bl) {
        }

        public boolean isVisible() {
            return false;
        }

        public boolean isActivated() {
            return false;
        }

        public void initModels() {
        }

        public void hideMiniMap() {
        }

        public boolean displayMiniMap(ResourceInformation resourceInformation) {
            return false;
        }

        public void deactivateAndPersist() {
        }

        public void activateAndPersist() {
        }
    }
}

