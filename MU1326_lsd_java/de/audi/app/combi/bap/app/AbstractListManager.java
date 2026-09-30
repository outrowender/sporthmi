/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app;

import de.audi.app.bap.dsi.DSIServiceTracker;
import de.audi.app.bap.fw.arrays.IListManager;
import de.audi.app.combi.bap.dsi.fastlist.IDSIFastListScrollingController;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.app.combi.bap.fw.arrays.fastlist.IListAdapterFastList;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.BundleContext;

public abstract class AbstractListManager
implements IListManager {
    protected final LogChannel logChannel;
    private final IFrameworkAccess frameworkAccess;
    private final boolean mostListSupported;
    protected final List fastListAdapters;
    private final IDSIFastListScrollingController dsiFastListScrollingController;
    private DSIServiceTracker dsiServiceTracker;

    public AbstractListManager(AbstractCombiModule abstractCombiModule, boolean bl, IDSIFastListScrollingController iDSIFastListScrollingController) {
        this.logChannel = abstractCombiModule.getLogChannel();
        this.frameworkAccess = abstractCombiModule.getFrameworkAccess();
        this.mostListSupported = bl;
        this.dsiFastListScrollingController = iDSIFastListScrollingController;
        this.fastListAdapters = new ArrayList(2);
    }

    public void init(BundleContext bundleContext) {
        if (this.mostListSupported) {
            this.initListAdapters(bundleContext);
            this.dsiServiceTracker = new DSIServiceTracker(bundleContext, this.dsiFastListScrollingController, this.logChannel);
            this.dsiServiceTracker.start();
            this.frameworkAccess.startDSIService(this.dsiFastListScrollingController.getDSIClass().getName(), 0);
        }
    }

    private void initListAdapters(BundleContext bundleContext) {
        if (!this.fastListAdapters.isEmpty()) {
            Iterator iterator = this.fastListAdapters.iterator();
            while (iterator.hasNext()) {
                IListAdapterFastList iListAdapterFastList = (IListAdapterFastList)iterator.next();
                iListAdapterFastList.init(bundleContext);
            }
        } else {
            this.logChannel.log(10000000, "[AbstractListManager#initListAdapters] No list adapters for FastList registered");
        }
    }

    public void deinit() {
        Iterator iterator = this.fastListAdapters.iterator();
        while (iterator.hasNext()) {
            IListAdapterFastList iListAdapterFastList = (IListAdapterFastList)iterator.next();
            iListAdapterFastList.deinit();
        }
        if (this.dsiServiceTracker != null) {
            this.dsiServiceTracker.stop();
        }
    }

    public void setOperationState(int n) {
        this.logChannel.log(10000000, "[AbstractListManager#setOperationState] %1", (long)n);
        if (this.dsiFastListScrollingController != null) {
            this.dsiFastListScrollingController.pushMOSTOperationState(this.convertMostOperationState(n));
        } else {
            this.logChannel.log(100000, "[AbstractListManager#setOperationState] DSI not available");
        }
    }

    protected abstract int convertMostOperationState(int var1);
}

