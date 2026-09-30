/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import de.esolutions.fw.dsi.admin.DSIAdmin;

public interface IListenerTracker {
    public Object[] getDSIListener(String var1, int var2);

    public void setDSIAdmin(DSIAdmin var1);

    public void open();

    public void close();
}

