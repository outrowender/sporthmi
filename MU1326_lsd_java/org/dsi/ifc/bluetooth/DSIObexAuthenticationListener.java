/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

import org.dsi.ifc.base.DSIListener;

public interface DSIObexAuthenticationListener
extends DSIListener {
    public void authenticationRequired(int var1, boolean var2, String var3);

    public void indAuthentication(boolean var1);
}

