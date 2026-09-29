/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.fw.arrays.fastlist;

import de.audi.app.bap.dsi.DSIServiceTracker;
import de.audi.app.bap.dsi.IDSIController;
import de.audi.app.bap.fw.arrays.AbstractListAdapter;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.audi.app.combi.bap.app.phone.list.CombinedNumbersListHandler;
import de.audi.app.combi.bap.fw.arrays.fastlist.ArrayHeaderFastList;
import de.audi.app.combi.bap.fw.arrays.fastlist.IListAdapterFastList;
import de.audi.app.combi.bap.utils.CombiLogger;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.osgi.framework.BundleContext;

public abstract class AbstractListAdapterFastList
extends AbstractListAdapter
implements IListAdapterFastList {
    protected final LogChannel logChannel = CombiLogger.getFastListLog();
    private DSIServiceTracker serviceTrackerDSIFastListScrolling;

    public AbstractListAdapterFastList(ArrayHandler arrayHandler) {
        super(arrayHandler);
    }

    @Override
    public IArrayHeader createArrayHeader() {
        return new ArrayHeaderFastList();
    }

    @Override
    public final void init(BundleContext bundleContext) {
        this.serviceTrackerDSIFastListScrolling = new DSIServiceTracker(bundleContext, this.getDSIController(), this.getDSIListener(), this.getDSIListenerClass(), this.getDSINotifications(), this.logChannel);
        this.serviceTrackerDSIFastListScrolling.start();
    }

    @Override
    public final void deinit() {
        this.serviceTrackerDSIFastListScrolling.stop();
    }

    public final void getListInitials(int n, int n2, int n3) {
        if (n3 == this.getDSIListID()) {
            CombiBAPArrayElement[] combiBAPArrayElementArray = ((CombinedNumbersListHandler)this.listHandler).getManagedList();
            this.responseInitials(n, n2, n3, AbstractListAdapterFastList.extractInitials(combiBAPArrayElementArray));
        }
    }

    private static DataInitials[] extractInitials(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        return new DataInitials[0];
    }

    public abstract void responseInitials(int n, int n2, int n3, DataInitials[] dataInitialsArray) {
    }

    protected abstract IDSIController getDSIController() {
    }

    protected abstract DSIListener getDSIListener() {
    }

    protected abstract Class getDSIListenerClass() {
    }

    protected abstract int getDSIListID() {
    }
}

