/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.sm;

import de.audi.atip.interapp.sm.AbstractInterappState;
import de.audi.atip.interapp.sm.IInterappConBluetoothEvent;
import de.audi.atip.interapp.sm.IInterappConDataEvent;
import de.audi.atip.interapp.sm.IInterappConManagerEvent;
import de.audi.atip.interapp.sm.IInterappConWlanEvent;
import de.audi.atip.interapp.sm.IInterappEvent;
import de.audi.atip.interapp.sm.IInterappPhoneEvent;
import de.audi.atip.interapp.sm.IInterappSM;
import de.audi.atip.log.LogChannel;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractInterappSM
implements IInterappSM,
ServiceTrackerCustomizer {
    private int instanceId;
    protected final LogChannel log;
    private int transitionDepthCounter = 0;
    private AbstractInterappState currentState;
    protected BundleContext bundleContext;
    private ServiceTracker serviceTracker;
    private ServiceRegistration registration;
    private AbstractInterappSM[] statemachineInstances = new AbstractInterappSM[7];
    static /* synthetic */ Class class$de$audi$atip$interapp$sm$AbstractInterappSM;

    public AbstractInterappSM(BundleContext bundleContext, LogChannel logChannel, int n) {
        this.bundleContext = bundleContext;
        this.log = logChannel;
        this.instanceId = n;
        this.currentState = null;
    }

    public abstract AbstractInterappState getDefaultState();

    public void handleRemoteEvent(IInterappEvent iInterappEvent) {
        this.handleEvent(this.getCurrentState(), iInterappEvent);
    }

    public void dispatchEvent(IInterappEvent iInterappEvent) {
        for (int i2 = 0; i2 < this.statemachineInstances.length; ++i2) {
            if (this.statemachineInstances[i2] == null) continue;
            try {
                if (this.statemachineInstances[i2].getSmComponentId() == this.instanceId) {
                    this.handleEvent(this.getCurrentState(), iInterappEvent);
                    continue;
                }
                this.statemachineInstances[i2].handleRemoteEvent(iInterappEvent);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private void handleEvent(AbstractInterappState abstractInterappState, IInterappEvent iInterappEvent) {
        String string = abstractInterappState.getStateName();
        String string2 = iInterappEvent.getName();
        this.log.log(1000000, "AbstractInterappSM#dispatchEvent %1 to state %2", (Object)string2, (Object)string);
        switch (iInterappEvent.getSmComponent()) {
            case 1: {
                abstractInterappState.handleEvent((IInterappPhoneEvent)iInterappEvent);
                break;
            }
            case 6: {
                abstractInterappState.handleEvent((IInterappPhoneEvent)iInterappEvent);
                break;
            }
            case 2: {
                abstractInterappState.handleEvent((IInterappConBluetoothEvent)iInterappEvent);
                break;
            }
            case 3: {
                abstractInterappState.handleEvent((IInterappConWlanEvent)iInterappEvent);
                break;
            }
            case 4: {
                abstractInterappState.handleEvent((IInterappConDataEvent)iInterappEvent);
                break;
            }
            case 5: {
                abstractInterappState.handleEvent((IInterappConManagerEvent)iInterappEvent);
                break;
            }
            default: {
                this.log.log(10000, "AbstractInterappSM#dispatchEvent %1 type not implemented!", (Object)string2);
            }
        }
    }

    void transitionTo(IInterappEvent iInterappEvent, AbstractInterappState abstractInterappState) {
        if (this.transitionDepthCounter != 0) {
            this.log.log(10000, "AbstractInterappSM#transitionTo recursivity detected! state %1 transitionDepthCounter %2 ", (Object)abstractInterappState.getStateName(), (long)this.transitionDepthCounter);
            throw new IllegalStateException("AbstractInterappSM#transitionTo recursivity detected");
        }
        try {
            AbstractInterappState abstractInterappState2;
            ++this.transitionDepthCounter;
            String string = this.currentState.getStateName();
            String string2 = abstractInterappState.getStateName();
            this.log.log(1000000, "[AbstractInterappSM#transitionTo] %1 --> %2", (Object)string, (Object)string2);
            AbstractInterappState abstractInterappState3 = this.currentState.exitAction(iInterappEvent, abstractInterappState);
            int n = 3;
            do {
                abstractInterappState2 = abstractInterappState3;
                string2 = abstractInterappState2.getStateName();
                this.log.log(1000000, "[AbstractInterappSM#transitionTo] (%2) calling %1.entryAction", (Object)string2, (long)n);
            } while (!abstractInterappState2.equals(abstractInterappState3 = abstractInterappState2.entryAction(iInterappEvent, this.currentState)) && --n > 0);
            if (!abstractInterappState2.equals(abstractInterappState3)) {
                this.log.log(10000, "AbstractInterappSM#transitionTo maximum redirection count exceeded!");
                throw new IllegalStateException("AbstractInterappSM#transitionTo maximum redirection count exceeded!");
            }
            this.setCurrentState(abstractInterappState3);
            if (this.transitionDepthCounter > 0) {
                --this.transitionDepthCounter;
            } else {
                this.log.log(100000, "AbstractInterappSM#transitionTo state %1 transitionDepthCounter %2 ", (Object)abstractInterappState.getStateName(), (long)this.transitionDepthCounter);
            }
        }
        catch (Exception exception) {
            this.transitionDepthCounter = 0;
            this.log.log(1000, "AbstractInterappSM#transitionTo %1 exception occured: %2", (Object)abstractInterappState.getStateName(), (Throwable)exception);
        }
    }

    private void setCurrentState(AbstractInterappState abstractInterappState) {
        this.currentState = abstractInterappState;
    }

    private AbstractInterappState getCurrentState() {
        return this.currentState;
    }

    public String getCurrentStateName() {
        return this.currentState.getStateName();
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof AbstractInterappSM) {
            AbstractInterappSM abstractInterappSM;
            this.statemachineInstances[abstractInterappSM.getSmComponentId()] = abstractInterappSM = (AbstractInterappSM)object;
            return object;
        }
        return null;
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof AbstractInterappSM) {
            AbstractInterappSM abstractInterappSM = (AbstractInterappSM)object;
            this.statemachineInstances[abstractInterappSM.getSmComponentId()] = null;
            this.bundleContext.ungetService(serviceReference);
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof AbstractInterappSM) {
            AbstractInterappSM abstractInterappSM;
            this.statemachineInstances[abstractInterappSM.getSmComponentId()] = abstractInterappSM = (AbstractInterappSM)object;
        }
    }

    public int getSmComponentId() {
        return this.instanceId;
    }

    public void init() {
        this.currentState = this.getDefaultState();
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$atip$interapp$sm$AbstractInterappSM == null ? (class$de$audi$atip$interapp$sm$AbstractInterappSM = AbstractInterappSM.class$("de.audi.atip.interapp.sm.AbstractInterappSM")) : class$de$audi$atip$interapp$sm$AbstractInterappSM).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
        this.registration = this.bundleContext.registerService((class$de$audi$atip$interapp$sm$AbstractInterappSM == null ? (class$de$audi$atip$interapp$sm$AbstractInterappSM = AbstractInterappSM.class$("de.audi.atip.interapp.sm.AbstractInterappSM")) : class$de$audi$atip$interapp$sm$AbstractInterappSM).getName(), (Object)this, (Dictionary)new Hashtable(0));
    }

    public void deinit() {
        this.serviceTracker.close();
        this.serviceTracker = null;
        this.registration.unregister();
        this.registration = null;
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

