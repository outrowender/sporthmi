/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;

public class KzbMergeManager
implements IWidgetLogChannel {
    private EALManager ealManager;

    public KzbMergeManager(EALManager eALManager) {
        this.ealManager = eALManager;
    }

    public boolean mergeKzbAsynchron(int n, int n2, String string) {
        logChannel3DEngine.log(-2137614336, "KzbMergeManager#mergeKzbAsynchron: start asynchron merging of %1 kzb", (Object)string);
        int n3 = -1;
        if (this.ealManager != null) {
            return this.ealManager.mergeProjectAsync(n, n2, n3);
        }
        return false;
    }
}

