/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.interapp.TelConnectivityHandler$ConnectivityUpdateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.phone.ITelMESlotState;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelConnectivityHandler
extends AbstractPhoneComponent
implements ServiceTrackerCustomizer {
    private volatile PhoneServiceTracker connectivityPhoneStateListenerTracker;
    protected final ArrayList connectivityListeners = new ArrayList();
    private volatile TelConnectivityHandler$ConnectivityUpdateStruct connectivityUpdateStruct;
    private volatile IGlobalTelephoneStateStruct telState;
    private volatile ITelMESlotState primary;
    private volatile ITelMESlotState associated;
    private volatile ITelMESlotState data;
    private final Object slotStateMutex = new Object();
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityPhoneStateListener;

    private static TelConnectivityHandler$ConnectivityUpdateStruct getConnectivityUpdate(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        int n = iGlobalTelephoneStateStruct.getNadInstanceState() != null ? iGlobalTelephoneStateStruct.getNadInstanceState().getPhoneModuleState() : 0;
        return new TelConnectivityHandler$ConnectivityUpdateStruct(iGlobalTelephoneStateStruct.getNadMode(), n);
    }

    public TelConnectivityHandler(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.connectivityPhoneStateListenerTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$IConnectivityPhoneStateListener == null ? (class$de$audi$atip$interapp$IConnectivityPhoneStateListener = TelConnectivityHandler.class$("de.audi.atip.interapp.IConnectivityPhoneStateListener")) : class$de$audi$atip$interapp$IConnectivityPhoneStateListener).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.connectivityPhoneStateListenerTracker.openTracker();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.connectivityPhoneStateListenerTracker.closeTracker();
        this.connectivityPhoneStateListenerTracker = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof IConnectivityPhoneStateListener) {
            ITelMESlotState iTelMESlotState;
            ITelMESlotState iTelMESlotState2;
            ITelMESlotState iTelMESlotState3;
            Object object2 = this.connectivityListeners;
            synchronized (object2) {
                if (!this.connectivityListeners.contains(object)) {
                    this.log.log(1078071040, "[TelConnectivityHandler#addingService] service=%1", object);
                    this.connectivityListeners.add(object);
                }
            }
            object2 = (IConnectivityPhoneStateListener)object;
            this.updateConnectivityPhoneStateListener((IConnectivityPhoneStateListener)object2, this.connectivityUpdateStruct);
            this.updateESimListener(this.telState, (IConnectivityPhoneStateListener)object2);
            Object object3 = this.slotStateMutex;
            synchronized (object3) {
                iTelMESlotState3 = this.primary;
                iTelMESlotState2 = this.associated;
                iTelMESlotState = this.data;
            }
            this.updateSlotState(iTelMESlotState3, iTelMESlotState2, iTelMESlotState, (IConnectivityPhoneStateListener)object2);
            this.updateConnectedGatewayListener(this.telState, (IConnectivityPhoneStateListener)object2);
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IConnectivityPhoneStateListener) {
            this.getApplication().getBundleContext().ungetService(serviceReference);
            ArrayList arrayList = this.connectivityListeners;
            synchronized (arrayList) {
                this.log.log(-1601830656, "[TelConnectivityHandler#removedService] %1", object);
                this.connectivityListeners.remove(object);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[TelConnectivityHandler#updateGlobalTelephoneStateProperty] state is null --> NOP!");
            return;
        }
        this.telState = iGlobalTelephoneStateStruct;
        TelConnectivityHandler$ConnectivityUpdateStruct telConnectivityHandler$ConnectivityUpdateStruct = TelConnectivityHandler.getConnectivityUpdate(iGlobalTelephoneStateStruct);
        List list = null;
        ArrayList arrayList = this.connectivityListeners;
        synchronized (arrayList) {
            list = (List)this.connectivityListeners.clone();
        }
        this.processMESlotStates(iGlobalTelephoneStateStruct, list);
        if (this.updateListeners(telConnectivityHandler$ConnectivityUpdateStruct) && list != null) {
            this.updateConnectivityPhoneStateListeners(list, telConnectivityHandler$ConnectivityUpdateStruct);
        }
        this.updateESIMInfoToListeners(n, iGlobalTelephoneStateStruct, list);
        this.updateConnectedGatewayStateToListeners(n, iGlobalTelephoneStateStruct, list);
    }

    private void updateConnectedGatewayStateToListeners(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, List list) {
        if (iGlobalTelephoneStateStruct != null && list != null && n == 0xC000400) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                IConnectivityPhoneStateListener iConnectivityPhoneStateListener = (IConnectivityPhoneStateListener)iterator.next();
                if (iConnectivityPhoneStateListener == null) continue;
                this.updateConnectedGatewayListener(iGlobalTelephoneStateStruct, iConnectivityPhoneStateListener);
            }
        }
    }

    private void updateConnectedGatewayListener(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, IConnectivityPhoneStateListener iConnectivityPhoneStateListener) {
        if (iGlobalTelephoneStateStruct != null) {
            try {
                iConnectivityPhoneStateListener.updateConnectedGatewayState(iGlobalTelephoneStateStruct.getConnectedGatewayState().hasActiveCall());
            }
            catch (Exception exception) {
                this.log.log(10000, "[TelConnectivityHandler#updateConnectedGatewayListener] Exception caught, listener=%1, exception=%2", (Object)iConnectivityPhoneStateListener, (Throwable)exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void processMESlotStates(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, List list) {
        boolean bl;
        ITelMESlotState iTelMESlotState;
        ITelMESlotState iTelMESlotState2;
        ITelMESlotState iTelMESlotState3;
        Object object = this.slotStateMutex;
        synchronized (object) {
            iTelMESlotState3 = iGlobalTelephoneStateStruct.getPrimaryDeviceState() != null ? iGlobalTelephoneStateStruct.getPrimaryDeviceState().getDevice() : null;
            iTelMESlotState2 = iGlobalTelephoneStateStruct.getAssociatedDeviceState() != null ? iGlobalTelephoneStateStruct.getAssociatedDeviceState().getDevice() : null;
            iTelMESlotState = iGlobalTelephoneStateStruct.getNadInstanceState() != null ? iGlobalTelephoneStateStruct.getNadInstanceState().getDevice() : null;
            boolean bl2 = this.hasSlotStateChanged(iTelMESlotState3, this.primary);
            boolean bl3 = this.hasSlotStateChanged(iTelMESlotState2, this.associated);
            boolean bl4 = this.hasSlotStateChanged(iTelMESlotState, this.data);
            boolean bl5 = bl = bl2 || bl3 || bl4;
            if (bl2) {
                this.primary = iTelMESlotState3;
            }
            if (bl3) {
                this.associated = iTelMESlotState2;
            }
            if (bl4) {
                this.data = iTelMESlotState;
            }
        }
        if (bl && list != null) {
            if (this.log.isInfo()) {
                object = new Buffer();
                ((Buffer)object).append("primarySlotState=");
                ((Buffer)object).append(iTelMESlotState3);
                ((Buffer)object).append("\n");
                ((Buffer)object).append("associatedSlotState=");
                ((Buffer)object).append(iTelMESlotState2);
                ((Buffer)object).append("\n");
                ((Buffer)object).append("dataSlotState=");
                ((Buffer)object).append(iTelMESlotState);
                this.log.log(1078071040, "[TelConnectivityHandler#updateSlotState] %1", object);
            }
            object = new Buffer();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                IConnectivityPhoneStateListener iConnectivityPhoneStateListener = (IConnectivityPhoneStateListener)iterator.next();
                if (iConnectivityPhoneStateListener == null) continue;
                try {
                    ((Buffer)object).append(new StringBuffer().append(iConnectivityPhoneStateListener).append(",").toString());
                    this.updateSlotState(iTelMESlotState3, iTelMESlotState2, iTelMESlotState, iConnectivityPhoneStateListener);
                }
                catch (Exception exception) {
                    this.log.log(10000, "[TelConnectivityHandler#processMESlotStates] exception %1", (Throwable)exception);
                }
            }
            this.log.log(1078071040, "[TelConnectivityHandler#processMESlotStates] updated Listeners  %1", object);
        }
    }

    private boolean hasSlotStateChanged(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2) {
        return iTelMESlotState2 == null && iTelMESlotState != null || iTelMESlotState2 != null && !iTelMESlotState2.isEqual(iTelMESlotState);
    }

    private void updateSlotState(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3, IConnectivityPhoneStateListener iConnectivityPhoneStateListener) {
        iConnectivityPhoneStateListener.updateMESlotInfo(iTelMESlotState, iTelMESlotState2, iTelMESlotState3);
    }

    private void updateESIMInfoToListeners(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, List list) {
        if ((n == 0x9000400 || n == 0xA000400 || n == 0x8000400 || n == 0x7000400) && list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                IConnectivityPhoneStateListener iConnectivityPhoneStateListener = (IConnectivityPhoneStateListener)iterator.next();
                if (iConnectivityPhoneStateListener == null) continue;
                this.updateESimListener(iGlobalTelephoneStateStruct, iConnectivityPhoneStateListener);
            }
        }
    }

    private void updateESimListener(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, IConnectivityPhoneStateListener iConnectivityPhoneStateListener) {
        if (iGlobalTelephoneStateStruct != null) {
            try {
                iConnectivityPhoneStateListener.updateESIMInfo(iGlobalTelephoneStateStruct.getEUICCID(), iGlobalTelephoneStateStruct.getESIMMSISDN(), iGlobalTelephoneStateStruct.isESIMActive(), iGlobalTelephoneStateStruct.isESIMB2BModeActive());
            }
            catch (Exception exception) {
                this.log.log(10000, "[TelConnectivityHandler#updateESimListener] Exception caught, listener=%1, exception=%2", (Object)iConnectivityPhoneStateListener, (Throwable)exception);
            }
        }
    }

    private boolean updateListeners(TelConnectivityHandler$ConnectivityUpdateStruct telConnectivityHandler$ConnectivityUpdateStruct) {
        if (telConnectivityHandler$ConnectivityUpdateStruct != null) {
            if (this.connectivityUpdateStruct != null) {
                if (!this.connectivityUpdateStruct.equals(telConnectivityHandler$ConnectivityUpdateStruct)) {
                    this.connectivityUpdateStruct = telConnectivityHandler$ConnectivityUpdateStruct;
                    return true;
                }
            } else {
                this.connectivityUpdateStruct = telConnectivityHandler$ConnectivityUpdateStruct;
                return true;
            }
        }
        return false;
    }

    private void updateConnectivityPhoneStateListeners(List list, TelConnectivityHandler$ConnectivityUpdateStruct telConnectivityHandler$ConnectivityUpdateStruct) {
        if (list != null && telConnectivityHandler$ConnectivityUpdateStruct != null) {
            this.log.log(1078071040, "[TelConnectivityHandler#updateConnectivityPhoneStateListeners] update=%1", (Object)telConnectivityHandler$ConnectivityUpdateStruct);
            Buffer buffer = new Buffer();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                IConnectivityPhoneStateListener iConnectivityPhoneStateListener = (IConnectivityPhoneStateListener)iterator.next();
                if (iConnectivityPhoneStateListener == null) continue;
                buffer.append(new StringBuffer().append(iConnectivityPhoneStateListener).append(",").toString());
                this.updateConnectivityPhoneStateListener(iConnectivityPhoneStateListener, telConnectivityHandler$ConnectivityUpdateStruct);
            }
            this.log.log(1078071040, "[TelConnectivityHandler#updateConnectivityPhoneStateListeners] updatedListeners=%1", (Object)buffer);
        }
    }

    private void updateConnectivityPhoneStateListener(IConnectivityPhoneStateListener iConnectivityPhoneStateListener, TelConnectivityHandler$ConnectivityUpdateStruct telConnectivityHandler$ConnectivityUpdateStruct) {
        if (iConnectivityPhoneStateListener != null) {
            if (telConnectivityHandler$ConnectivityUpdateStruct != null) {
                iConnectivityPhoneStateListener.updatePhoneState(telConnectivityHandler$ConnectivityUpdateStruct.getNadMode(), telConnectivityHandler$ConnectivityUpdateStruct.getPhoneModuleState());
            }
        } else {
            this.log.log(-1601830656, "[TelConnectivityHandler#updateConnectivityPhoneStateListener] listener is null! --> NOP!");
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

