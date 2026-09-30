/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.interapp;

import de.audi.app.wlan.core.AbstractWlanComponent;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.atip.interapp.WlanServiceListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.networking.Node;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MediaWlanStateProvider
extends AbstractWlanComponent {
    private final int[] attributeNotifications = new int[]{12, 13};
    private final ServiceTracker tracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$atip$interapp$WlanServiceListener == null ? (class$de$audi$atip$interapp$WlanServiceListener = MediaWlanStateProvider.class$("de.audi.atip.interapp.WlanServiceListener")) : class$de$audi$atip$interapp$WlanServiceListener).getName()}, (ServiceTrackerCustomizer)this);
    private volatile List wlanListeners = new LinkedList();
    private volatile boolean wlanOn;
    private volatile int numberOfClients;
    static /* synthetic */ Class class$de$audi$atip$interapp$WlanServiceListener;

    public MediaWlanStateProvider(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
    }

    protected int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    public void updateRFActive(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        boolean bl = this.wlanOn = n == 1;
        this.log.log(10000000, "MediaWlanStateProvider#updateRFActive(): Updating media application, wlanOn=%1", bl);
        Iterator iterator = this.wlanListeners.iterator();
        while (iterator.hasNext()) {
            WlanServiceListener wlanServiceListener = (WlanServiceListener)iterator.next();
            if (wlanServiceListener == null) continue;
            wlanServiceListener.updateWlanState(bl);
        }
        this.log.log(10000000, "MediaWlanStateProvider#updateRFActive(): After call.");
    }

    public void updateNodeList(Node[] nodeArray, int n) {
        if (n != 1) {
            return;
        }
        this.numberOfClients = nodeArray == null ? 0 : nodeArray.length;
        int n2 = this.numberOfClients;
        this.log.log(10000000, "MediaWlanStateProvider#updateNodeList(): Updating media application: number of clients=%1", (long)n2);
        Iterator iterator = this.wlanListeners.iterator();
        while (iterator.hasNext()) {
            WlanServiceListener wlanServiceListener = (WlanServiceListener)iterator.next();
            if (wlanServiceListener == null) continue;
            wlanServiceListener.updateNumberOfClients(n2);
        }
        this.log.log(10000000, "MediaWlanStateProvider#updateNodeList(): After call.");
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof WlanServiceListener) {
            this.log.log(10000000, "MediaWlanStateProvider#addingService(): Adding WlanServiceListener");
            if (!this.wlanListeners.contains(object)) {
                this.wlanListeners.add(object);
                ((WlanServiceListener)object).updateWlanState(this.wlanOn);
                ((WlanServiceListener)object).updateNumberOfClients(this.numberOfClients);
            }
            return object;
        }
        return super.addingService(serviceReference);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof WlanServiceListener) {
            if (this.wlanListeners.contains(object)) {
                this.wlanListeners.remove(object);
            }
            this.bundleContext.ungetService(serviceReference);
        }
        super.removedService(serviceReference, object);
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        super.modifiedService(serviceReference, object);
    }

    public void init() {
        super.init();
        this.tracker.open();
    }

    public void deinit() {
        this.tracker.close();
        super.deinit();
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

