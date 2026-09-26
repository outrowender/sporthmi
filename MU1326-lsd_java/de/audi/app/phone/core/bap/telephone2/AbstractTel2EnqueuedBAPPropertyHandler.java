/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone2;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.bap.telephone2.AbstractTel2EnqueuedBAPPropertyHandler$1;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

abstract class AbstractTel2EnqueuedBAPPropertyHandler
extends AbstractPhoneComponent
implements ServiceTrackerCustomizer {
    private volatile PhoneServiceTracker bapServiceTracker;
    private volatile IGlobalTelephoneStateStruct telephoneState;
    private volatile CombiBAPServicePhone2 combiService;
    private final DispatcherBase bapCombiDispatcher;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2;

    AbstractTel2EnqueuedBAPPropertyHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, "App.Phone.BAP");
        this.bapCombiDispatcher = dispatcherBase;
    }

    @Override
    public void init() {
        this.bapServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 = AbstractTel2EnqueuedBAPPropertyHandler.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.bapServiceTracker.openTracker();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    @Override
    public void deinit() {
        if (this.bapServiceTracker != null) {
            this.bapServiceTracker.closeTracker();
            this.bapServiceTracker = null;
        }
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    private void enqueueUpdate() {
        this.scheduleExecution(new AbstractTel2EnqueuedBAPPropertyHandler$1(this));
    }

    private void scheduleExecution(Runnable runnable) {
        this.bapCombiDispatcher.execute(runnable);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "AbstractTel2EnqueuedBAPPropertyHandler#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "AbstractTel2EnqueuedBAPPropertyHandler#addingService service is null");
            return null;
        }
        if ((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 = AbstractTel2EnqueuedBAPPropertyHandler.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2).isInstance(object)) {
            this.setBAPServiceAndSendUpdate((CombiBAPServicePhone2)object);
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
        if ((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 = AbstractTel2EnqueuedBAPPropertyHandler.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2).isInstance(object)) {
            this.setBAPServiceAndSendUpdate(null);
            this.getApplication().getBundleContext().ungetService(serviceReference);
        }
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.setTelephoneState(iGlobalTelephoneStateStruct);
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000, "AbstractTel2EnqueuedBAPPropertyHandler#updateGlobalTelephoneStateProperty stateStruct is null");
            return;
        }
        if (this.doProcessGlobalTelephoneStateUpdate(n, iGlobalTelephoneStateStruct)) {
            this.enqueueUpdate();
        }
    }

    protected IGlobalTelephoneStateStruct getTelephoneState() {
        return this.telephoneState;
    }

    protected ITelDSIMobileEquipmentDeviceState getCallLeadingDeviceState() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
    }

    public void setBAPServiceAndSendUpdate(CombiBAPServicePhone2 combiBAPServicePhone2) {
        this.combiService = combiBAPServicePhone2;
        if (combiBAPServicePhone2 != null) {
            this.enqueueUpdate();
        } else {
            this.log.log(-1601830656, "AbstractTel2EnqueuedBAPPropertyHandler#setBAPServiceAndSendUpdate service is null");
        }
    }

    void setBAPService(CombiBAPServicePhone2 combiBAPServicePhone2) {
        this.combiService = combiBAPServicePhone2;
    }

    protected CombiBAPServicePhone2 getCombiService() {
        return this.combiService;
    }

    protected abstract boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }

    protected abstract void updateAsync() {
    }

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

