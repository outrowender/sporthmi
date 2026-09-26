/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.osgi;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.atip.interapp.media.IMediaServiceListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractMediaServiceListenerTracker
extends AbstractMediaTerminalComponent
implements ServiceTrackerCustomizer {
    private static final String LOGCLASS;
    private final Object mediaServiceListenerMutex = new Object();
    private final IServiceTracker serviceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$media$IMediaServiceListener == null ? (class$de$audi$atip$interapp$media$IMediaServiceListener = AbstractMediaServiceListenerTracker.class$("de.audi.atip.interapp.media.IMediaServiceListener")) : class$de$audi$atip$interapp$media$IMediaServiceListener, this);
    private List foundMediaServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaServiceListener;

    public AbstractMediaServiceListenerTracker(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    protected abstract void mediaServiceListenerAdded(IMediaServiceListener iMediaServiceListener) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"AbstractMediaServiceListenerTracker");
        Object object = this.mediaServiceListenerMutex;
        synchronized (object) {
            this.foundMediaServiceListener = new ArrayList(0);
        }
        this.serviceTracker.open();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"AbstractMediaServiceListenerTracker");
        this.serviceTracker.close();
        Object object = this.mediaServiceListenerMutex;
        synchronized (object) {
            this.foundMediaServiceListener = new ArrayList(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List getMediaServiceListener() {
        Object object = this.mediaServiceListenerMutex;
        synchronized (object) {
            return this.foundMediaServiceListener;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object addingService(ServiceReference serviceReference) {
        IMediaServiceListener iMediaServiceListener = (IMediaServiceListener)this.getTerminal().getServiceManager().getService(serviceReference);
        this.logger.main().log(1078071040, "[%1.addingService] '%2'.", (Object)"AbstractMediaServiceListenerTracker", (Object)iMediaServiceListener);
        if (iMediaServiceListener == null) {
            this.getTerminal().getServiceManager().releaseService(serviceReference);
            return null;
        }
        if (iMediaServiceListener.getTerminalID() != this.getTerminal().getTerminalID()) {
            this.logger.main().log(1078071040, "[%1.addingService] Belongs to other terminal '%2'.", (Object)"AbstractMediaServiceListenerTracker", (long)iMediaServiceListener.getTerminalID());
            this.getTerminal().getServiceManager().releaseService(serviceReference);
            return null;
        }
        Object object = this.mediaServiceListenerMutex;
        synchronized (object) {
            ArrayList arrayList = new ArrayList(this.foundMediaServiceListener.size() + 1);
            arrayList.addAll(this.foundMediaServiceListener);
            arrayList.add(iMediaServiceListener);
            this.foundMediaServiceListener = arrayList;
            this.mediaServiceListenerAdded(iMediaServiceListener);
        }
        return iMediaServiceListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        IMediaServiceListener iMediaServiceListener = (IMediaServiceListener)object;
        this.logger.main().log(1078071040, "[%1.removedService] '%2'", (Object)"AbstractMediaServiceListenerTracker", (Object)iMediaServiceListener);
        if (iMediaServiceListener == null) {
            return;
        }
        if (iMediaServiceListener.getTerminalID() != this.getTerminal().getTerminalID()) {
            this.logger.main().log(1078071040, "[%1.removedService] Belongs to other terminal '%2'", (Object)"AbstractMediaServiceListenerTracker", (long)iMediaServiceListener.getTerminalID());
            return;
        }
        this.getTerminal().getServiceManager().releaseService(serviceReference);
        Object object2 = this.mediaServiceListenerMutex;
        synchronized (object2) {
            LinkedList linkedList = new LinkedList(this.foundMediaServiceListener);
            linkedList.remove(iMediaServiceListener);
            this.foundMediaServiceListener = linkedList;
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

