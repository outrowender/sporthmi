/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.hotspot;

import de.audi.app.data.core.online.IOnline;
import de.audi.app.wlan.core.AbstractWlanComponent;
import de.audi.app.wlan.core.IWlanApplication;
import de.esolutions.fw.util.commons.StringUtils;
import org.dsi.ifc.networking.Node;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ConnectedClientList
extends AbstractWlanComponent {
    private final int[] attributeNotifications = new int[]{13};
    private final ServiceTracker tracker = new ServiceTracker(this.bundleContext, (class$de$audi$app$data$core$online$IOnline == null ? (class$de$audi$app$data$core$online$IOnline = ConnectedClientList.class$("de.audi.app.data.core.online.IOnline")) : class$de$audi$app$data$core$online$IOnline).getName(), (ServiceTrackerCustomizer)this);
    private IOnline iOnline;
    private int nodeCount;
    static /* synthetic */ Class class$de$audi$app$data$core$online$IOnline;

    public ConnectedClientList(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
    }

    protected int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    public void updateNodeList(Node[] nodeArray, int n) {
        if (n != 1) {
            return;
        }
        int n2 = nodeArray == null ? 0 : nodeArray.length;
        this.log.log(1000000, "[ConnectedClientList#updateNodeList] %1 clients attached (%2)", (Object)new Integer(n2), (Object)StringUtils.toString(nodeArray));
        if (this.iOnline != null) {
            if (n2 == 0) {
                this.iOnline.wlanHotspotActive(false);
            } else if (this.nodeCount == 0) {
                this.iOnline.wlanHotspotActive(true);
            }
            this.nodeCount = n2;
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IOnline) {
            this.iOnline = (IOnline)object;
            return object;
        }
        return super.addingService(serviceReference);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IOnline) {
            this.iOnline = null;
            this.bundleContext.ungetService(serviceReference);
        }
        super.removedService(serviceReference, object);
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IOnline) {
            this.iOnline = (IOnline)object;
        }
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

