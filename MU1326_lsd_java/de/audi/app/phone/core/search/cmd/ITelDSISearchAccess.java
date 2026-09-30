/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.ITelSearchQueryListener;

public interface ITelDSISearchAccess {
    public void scheduleQuery(String var1, int[] var2, ITelSearchQueryListener var3);

    public void cancelActiveSearchQuery();
}

