/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.app;

import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.log.LogChannel;

public abstract class AbstractAppConnector {
    protected final LogChannel logChannel;
    protected BAPServiceListener appServiceListener;

    AbstractAppConnector(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public void setAppServiceListener(BAPServiceListener bAPServiceListener) {
        this.appServiceListener = bAPServiceListener;
    }

    public BAPServiceListener getAppServiceListener() {
        return this.appServiceListener;
    }

    protected boolean hasAttribute(int n, int n2) {
        return (n & n2) == n2;
    }
}

