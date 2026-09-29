/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.setup;

public interface IDataSetup {
    public static final int GENERAL_PERMISSION_MANUAL;
    public static final int GENERAL_PERMISSION_AUTOMATIC;
    public static final int GENERAL_PERMISSION_NEVER;
    public static final int GENERAL_PERMISSION_PENDING;
    public static final int PERMISSION_PENDING;
    public static final int PERMISSION_DENY;
    public static final int PERMISSION_ALLOW;

    default public void activateDataConnection() {
    }

    default public void deactivateDataConnection() {
    }

    default public void setOnlinePermissionToAlways() {
    }

    default public void activateRoamingPermission() {
    }

    default public void deactivateRoamingPermission() {
    }

    default public boolean isLocalNetModeEnabled() {
    }
}

