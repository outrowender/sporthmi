/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.setup;

public interface IDataSetup {
    public static final int GENERAL_PERMISSION_MANUAL = 0;
    public static final int GENERAL_PERMISSION_AUTOMATIC = 1;
    public static final int GENERAL_PERMISSION_NEVER = 2;
    public static final int GENERAL_PERMISSION_PENDING = 3;
    public static final int PERMISSION_PENDING = -1;
    public static final int PERMISSION_DENY = 0;
    public static final int PERMISSION_ALLOW = 1;

    public void activateDataConnection();

    public void deactivateDataConnection();

    public void setOnlinePermissionToAlways();

    public void activateRoamingPermission();

    public void deactivateRoamingPermission();

    public boolean isLocalNetModeEnabled();
}

