/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo;

import de.audi.app.media.AbstractMediaHMIApplication;
import de.audi.app.media.evo.MediaEVOTerminalExtensionImpl;
import de.audi.app.media.evo.actionproxy.MediaActionProxyImpl;
import de.audi.atip.base.IFrameworkAccess;
import java.util.HashMap;
import org.osgi.framework.BundleContext;

public class MediaEVOHMIApplicationImpl
extends AbstractMediaHMIApplication {
    private static final String LOGCLASS = "MediaEVOHMIApplicationImpl";
    private final MediaActionProxyImpl actionProxy;
    private final MediaEVOTerminalExtensionImpl[] extensions = new MediaEVOTerminalExtensionImpl[8];

    public MediaEVOHMIApplicationImpl(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        super(iFrameworkAccess, bundleContext);
        this.actionProxy = new MediaActionProxyImpl(iFrameworkAccess, this.mediaCore.getServiceManager(), this.mediaCore.getActionProxyDispatcher());
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        if (this.framework.isFrontMU()) {
            this.extensions[0] = new MediaEVOTerminalExtensionImpl(0, this.mediaCore.getLogger(), this.mediaCore.getServiceManager());
            this.extensions[0].init();
        }
        super.init();
        this.actionProxy.init();
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.actionProxy.deinit();
        for (int i2 = 0; i2 < this.extensions.length; ++i2) {
            if (null == this.extensions[i2]) continue;
            this.extensions[i2].deinit();
        }
        super.deinit();
    }

    public void screenFadedOut(int n, int n2) {
        this.logger.log(1000000, "[%1.screenFadedOut]", (Object)LOGCLASS);
        this.mediaCore.getActionProxyDispatcher().notifyActionProxyCall(37, n2, new HashMap(0));
    }

    public void screenConnected(int n, int n2) {
        this.logger.log(1000000, "[%1.screenConnected]", (Object)LOGCLASS);
        this.mediaCore.getActionProxyDispatcher().notifyActionProxyCall(37, n2, new HashMap(0));
    }
}

