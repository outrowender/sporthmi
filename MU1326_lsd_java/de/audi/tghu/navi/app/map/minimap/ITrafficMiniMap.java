/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import org.dsi.ifc.base.DSIBase;
import org.osgi.framework.BundleContext;

public interface ITrafficMiniMap {
    public static final int FEATURE_DISABLED = 0;

    public void startDSI(BundleContext var1);

    public void stopDSI(BundleContext var1);

    public DSIBase getDSI();

    public void persistSettings();

    public void setActive(boolean var1);

    public void setCurrentSystemLanguage();

    public boolean isActive();

    public void tmpCommandSetActive(boolean var1);

    public void loadState();

    public void resetSettings();

    public void cleanup();

    public boolean isVisible();

    public void hideTrafficMiniMap();

    public void activateAndPersist(boolean var1);
}

