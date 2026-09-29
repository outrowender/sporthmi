/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.ITelSearchQueryListener;

public interface ITelDSISearchAccess {
    default public void scheduleQuery(String string, int[] nArray, ITelSearchQueryListener iTelSearchQueryListener) {
    }

    default public void cancelActiveSearchQuery() {
    }
}

