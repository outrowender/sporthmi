/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.dsi.IDSIControllerStateListener;
import de.audi.app.media.dsi.media.IMediaBrowserListener;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.app.media.dsi.media.MediaDSIBrowserControllerImpl;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public abstract class AbstractMediaBrowser
implements IMediaBrowserListener,
IDSIControllerStateListener {
    private static final String LOGCLASS;
    private final IMediaDSIBrowserController dsiMediaBrowser;
    protected final LogChannel logger;
    private final Object activateDeactivateMutex = new Object();
    private ISourceSlot activeSourceSlot;
    private BrowseListContextImpl browseListContext;
    private final ISourceController sourceController;
    private volatile boolean browserInvalidation;

    public AbstractMediaBrowser(LogChannel logChannel, LogChannel logChannel2, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, int n, ISourceController iSourceController) {
        this.logger = logChannel;
        this.dsiMediaBrowser = new MediaDSIBrowserControllerImpl(n, iServiceManager, iFrameworkAccess, dispatcherBase, logChannel2);
        this.sourceController = iSourceController;
    }

    protected abstract void browserActivated(IBrowseListContext iBrowseListContext) {
    }

    protected abstract void browserDeactivated(ISourceSlot iSourceSlot, boolean bl) {
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"AbstractMediaBrowser");
        this.dsiMediaBrowser.init();
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"AbstractMediaBrowser");
        this.dsiMediaBrowser.deinit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activate(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.activate]", (Object)"AbstractMediaBrowser");
        Object object = this.activateDeactivateMutex;
        synchronized (object) {
            this.activeSourceSlot = iSourceSlot;
        }
        if (!this.dsiMediaBrowser.isStarted()) {
            this.logger.log(1078071040, "[%1.activate (%2)] Start DSI.", (Object)"AbstractMediaBrowser", (long)this.dsiMediaBrowser.getInstanceID());
            this.dsiMediaBrowser.startDSI();
        }
        this.dsiMediaBrowser.setStateListener(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void deactivate(boolean bl) {
        Object object = this.activateDeactivateMutex;
        synchronized (object) {
            this.logger.log(1078071040, "[%1.deactivate(%3)] '%2'", (Object)"AbstractMediaBrowser", (Object)String.valueOf(bl), (long)this.dsiMediaBrowser.getInstanceID());
            this.browserInvalidation = bl;
            this.dsiMediaBrowser.setStateListener(null);
            if (this.activeSourceSlot == null) {
                this.logger.log(1078071040, "[%1.deactivate] Browser not activated.", (Object)"AbstractMediaBrowser");
                return;
            }
            ISourceSlot iSourceSlot = this.activeSourceSlot;
            if (!this.browserInvalidation) {
                this.activeSourceSlot = null;
                this.dsiMediaBrowser.setBrowserListener(null);
            }
            this.dsiMediaBrowser.deactivate();
            if (this.browseListContext != null) {
                this.browseListContext.deinit();
                this.browseListContext = null;
            }
            this.browserDeactivated(iSourceSlot, this.browserInvalidation);
        }
    }

    public void deactivate() {
        this.deactivate(false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void browseSourceActivated() {
        Object object = this.activateDeactivateMutex;
        synchronized (object) {
            this.logger.log(1078071040, "[%1.browseSourceActivated]", (Object)"AbstractMediaBrowser");
            if (this.activeSourceSlot == null) {
                this.logger.log(1078071040, "[%1.browseSourceActivated] Not active any more.", (Object)"AbstractMediaBrowser");
                return;
            }
            if (this.browseListContext == null) {
                this.browseListContext = new BrowseListContextImpl(this.logger, this.dsiMediaBrowser, this.activeSourceSlot, this.sourceController);
                this.browseListContext.init();
            }
            this.browserActivated(this.browseListContext);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void browseSourceDeactivated() {
        this.logger.log(1078071040, "[%1.browseSourceDeactivated]", (Object)"AbstractMediaBrowser");
        Object object = this.activateDeactivateMutex;
        synchronized (object) {
            if (this.browserInvalidation) {
                this.activate(this.activeSourceSlot);
                this.browserInvalidation = false;
            }
        }
    }

    @Override
    public final void browseSourceInvalidated() {
        this.logger.log(1078071040, "[%1.browseSourceDeactivated]", (Object)"AbstractMediaBrowser");
        this.deactivate(true);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.log(1078071040, "[%1.asyncException] Receive async exception. Deactivated the browser.", (Object)"AbstractMediaBrowser");
        this.deactivate(false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void dsiAvailable() {
        Object object = this.activateDeactivateMutex;
        synchronized (object) {
            this.logger.log(1078071040, "[%1.dsiAvailable] Browser DSI available.", (Object)"AbstractMediaBrowser");
            if (this.activeSourceSlot == null) {
                this.logger.log(1078071040, "[%1.dsiAvailable] Not active. Ignore.", (Object)"AbstractMediaBrowser");
                return;
            }
            this.dsiMediaBrowser.setBrowserListener(this);
            this.dsiMediaBrowser.activate((MediaSourceSlot)this.activeSourceSlot);
        }
    }

    @Override
    public void dsiUnavailable() {
    }

    protected void diagResetBrowser() {
        this.browseSourceInvalidated();
    }
}

