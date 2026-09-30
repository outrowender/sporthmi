/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.phone.IEcallState;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractTel1EnqueuedBAPPropertyHandler
extends AbstractPhoneComponent
implements ServiceTrackerCustomizer {
    private volatile PhoneServiceTracker bapServiceTracker;
    private volatile IGlobalTelephoneStateStruct telephoneState;
    private volatile CombiBAPServicePhone combiService;
    private final DispatcherBase bapCombiDispatcher;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone;

    public AbstractTel1EnqueuedBAPPropertyHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, "App.Phone.BAP");
        this.bapCombiDispatcher = dispatcherBase;
    }

    public void init() {
        this.bapServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone = AbstractTel1EnqueuedBAPPropertyHandler.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.bapServiceTracker.openTracker();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    public void deinit() {
        if (this.bapServiceTracker != null) {
            this.bapServiceTracker.closeTracker();
            this.bapServiceTracker = null;
        }
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    protected void enqueueUpdate() {
        this.scheduleExecution(new Runnable(){

            public void run() {
                AbstractTel1EnqueuedBAPPropertyHandler.this.updateAsync();
            }
        });
    }

    private void scheduleExecution(Runnable runnable) {
        this.bapCombiDispatcher.execute(runnable);
    }

    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "AbstractTel1EnqueuedBAPPropertyHandler#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "AbstractTel1EnqueuedBAPPropertyHandler#addingService service is null");
            return null;
        }
        if ((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone = AbstractTel1EnqueuedBAPPropertyHandler.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone).isInstance(object)) {
            this.setBAPService((CombiBAPServicePhone)object);
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (serviceReference == null) {
            this.log.log(10000, "AbstractTel1EnqueuedBAPPropertyHandler#removedService reference is null");
            return;
        }
        if (object == null) {
            this.log.log(10000, "AbstractTel1EnqueuedBAPPropertyHandler#removedService service is null");
            return;
        }
        if ((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone = AbstractTel1EnqueuedBAPPropertyHandler.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone).isInstance(object)) {
            this.setBAPService(null);
            this.getApplication().getBundleContext().ungetService(serviceReference);
        }
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000, "AbstractTel1EnqueuedBAPPropertyHandler#updateGlobalTelephoneStateProperty stateStruct is null");
            return;
        }
        this.setTelephoneState(iGlobalTelephoneStateStruct);
        if (iGlobalTelephoneStateStruct == null) {
            return;
        }
        if (this.doProcessGlobalTelephoneStateUpdate(n, iGlobalTelephoneStateStruct)) {
            boolean bl;
            IEcallState iEcallState = iGlobalTelephoneStateStruct.getConnectedGatewayState();
            boolean bl2 = iEcallState != null && iEcallState.hasActiveCall() && iEcallState.isEmergencyCallType();
            boolean bl3 = bl = iEcallState != null && iEcallState.isLowPrioritySOSEmergencyCallType();
            if (!bl2 || bl) {
                this.enqueueUpdate();
            } else {
                this.log.log(1000000, "AbstractTelEnqueuedBAPPropertyHandler#updateGlobalTelephoneStateProperty(): unhandled. Ecall has active call.");
            }
        }
    }

    protected IGlobalTelephoneStateStruct getTelephoneState() {
        return this.telephoneState;
    }

    protected ITelDSIMobileEquipmentDeviceState getCallLeadingDeviceState() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
    }

    public void setBAPService(CombiBAPServicePhone combiBAPServicePhone) {
        this.combiService = combiBAPServicePhone;
        if (combiBAPServicePhone != null) {
            this.enqueueUpdate();
        }
    }

    protected CombiBAPServicePhone getCombiService() {
        return this.combiService;
    }

    protected abstract boolean doProcessGlobalTelephoneStateUpdate(int var1, IGlobalTelephoneStateStruct var2);

    protected abstract void updateAsync();

    public void setTelephoneState(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
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

