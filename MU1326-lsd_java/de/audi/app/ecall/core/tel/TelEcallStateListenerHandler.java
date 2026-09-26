/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.tel;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.osgi.EcallServiceTracker;
import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;
import de.audi.app.ecall.core.tel.EcallState;
import de.audi.atip.interapp.phone.IEcallState;
import de.audi.atip.interapp.phone.ITelEcallStateListener;
import java.util.ArrayList;
import java.util.List;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelEcallStateListenerHandler
extends AbstractEcallComponent
implements IGlobalEcallStateListener,
ServiceTrackerCustomizer {
    private EcallServiceTracker telEcallStateListenerTracker;
    private List telEcallStateListeners = new ArrayList();
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelEcallStateListener;

    public TelEcallStateListenerHandler(IEcallApplication iEcallApplication, String string) {
        super(iEcallApplication, string);
    }

    @Override
    public void init() {
        this.getApplication().getEcallStateManager().registerListener(this);
        this.telEcallStateListenerTracker = new EcallServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$phone$ITelEcallStateListener == null ? (class$de$audi$atip$interapp$phone$ITelEcallStateListener = TelEcallStateListenerHandler.class$("de.audi.atip.interapp.phone.ITelEcallStateListener")) : class$de$audi$atip$interapp$phone$ITelEcallStateListener).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.telEcallStateListenerTracker.openTracker();
    }

    @Override
    public void deinit() {
        this.getApplication().getEcallStateManager().removeListener(this);
        this.telEcallStateListenerTracker.closeTracker();
        this.telEcallStateListenerTracker = null;
    }

    @Override
    public void updateGlobalEcallStateProperty(int n, IEcallStateStruct iEcallStateStruct) {
        this.log.log(-2137614336, "TelEcallStateListenerHandler#updateGlobalEcallStateProperty(): globalEcallState=%1", (Object)iEcallStateStruct);
        EcallState ecallState = new EcallState(iEcallStateStruct);
        switch (n) {
            case 4: {
                this.broadcastEcallState(2, ecallState);
                break;
            }
            case 1: {
                this.broadcastEcallState(1, ecallState);
                break;
            }
            case 3: {
                this.broadcastEcallState(0, ecallState);
                break;
            }
            case 10: {
                this.broadcastEcallState(3, ecallState);
                break;
            }
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        this.log.log(-2137614336, "BAPServiceEcallListenerClusterHandler#addingService(): service: %1", object);
        if (object instanceof ITelEcallStateListener) {
            this.telEcallStateListeners.add(object);
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof ITelEcallStateListener) {
            this.getApplication().getBundleContext().ungetService(serviceReference);
            for (int i2 = 0; i2 < this.telEcallStateListeners.size(); ++i2) {
                if (this.telEcallStateListeners.get(i2) != object) continue;
                this.telEcallStateListeners.remove(i2);
                break;
            }
        }
    }

    private void broadcastEcallState(int n, IEcallState iEcallState) {
        for (int i2 = 0; i2 < this.telEcallStateListeners.size(); ++i2) {
            ((ITelEcallStateListener)this.telEcallStateListeners.get(i2)).updateEcallState(n, iEcallState);
        }
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

