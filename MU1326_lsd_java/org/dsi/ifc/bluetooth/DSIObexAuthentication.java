/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

import org.dsi.ifc.base.DSIBase;

public interface DSIObexAuthentication
extends DSIBase {
    public static final String VERSION = "2.11.13";
    public static final int RT_SETAUTHENTICATIONINFO = 1000;
    public static final int IN_AUTHENTICATIONREQUIRED = 3000;
    public static final int IN_INDAUTHENTICATION = 3001;

    public void setAuthenticationInfo(int var1, String var2, String var3);
}

