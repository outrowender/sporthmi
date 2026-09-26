/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

public interface SemidynamicRouteGuidance$ModelAccess {
    public static final int SIDEBAR_ALTERNATIVE_ROUTES;
    public static final int SIDEBAR_DYNAMIC_BYPASS;

    default public void setDynamicBypassAvailable(boolean bl) {
    }

    default public boolean isDynamicBypassAvailable() {
    }

    default public void setTrafficOffsetShort(String string) {
    }

    default public void setTrafficOffsetLong(String string) {
    }

    default public void setSidebarButtonMode(int n) {
    }
}

