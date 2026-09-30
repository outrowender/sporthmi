/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.activator;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMMInfoProvider;
import de.audi.atip.statemachine.SMModule;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractSMMActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    private static final boolean DEBUG_MODE = false;
    private static final Object SMM_INFO_LOCK = new Object();
    private static SMMInfoProvider smmInfo = null;
    private ServiceTracker apTracker;
    protected int[] reqActionProxies;
    protected SMModule[] smmList;
    private ServiceRegistration[] smmSvcRegList;
    private List apRegs = new ArrayList();
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;
    static /* synthetic */ Class class$de$audi$atip$statemachine$SMModule;

    public abstract void init();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void initSMMInfoProvider() {
        Object object = SMM_INFO_LOCK;
        synchronized (object) {
            if (smmInfo == null) {
                smmInfo = new SMMInfoProvider(this.getFramework());
                this.getBundleContext().registerService((class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = AbstractSMMActivator.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName(), (Object)smmInfo, null);
            }
        }
    }

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.initSMMInfoProvider();
        smmInfo.addSMM(this.getName());
        smmInfo.addSMMInfo(this.getName(), "before Init");
        this.init();
        smmInfo.addSMMInfo(this.getName(), "after Init");
        if (this.reqActionProxies.length > 0) {
            smmInfo.addSMMInfo(this.getName(), "before ActionProxy Tracker");
            this.apTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = AbstractSMMActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName(), (ServiceTrackerCustomizer)this);
            this.apTracker.open();
            smmInfo.addSMMInfo(this.getName(), "after ActionProxy Tracker");
        } else {
            smmInfo.addSMMInfo(this.getName(), "no ActionProxies required");
        }
        smmInfo.addSMMInfo(this.getName(), "before registering services");
        this.smmSvcRegList = new ServiceRegistration[this.smmList.length];
        SMModule sMModule = null;
        for (int i2 = 0; i2 < this.smmList.length; ++i2) {
            sMModule = this.smmList[i2];
            if (sMModule == null) continue;
            Hashtable hashtable = new Hashtable();
            ((Dictionary)hashtable).put("smID", new Integer(sMModule.getTerminalID()));
            ((Dictionary)hashtable).put("smName", sMModule.getTerminalName());
            ((Dictionary)hashtable).put("subterminalID", new Integer(sMModule.getSubterminalID()));
            smmInfo.addSMMInfo(this.getName(), new StringBuffer().append("  registering service: ").append((class$de$audi$atip$statemachine$SMModule == null ? AbstractSMMActivator.class$("de.audi.atip.statemachine.SMModule") : class$de$audi$atip$statemachine$SMModule).getName()).append(" ").append(sMModule.getTerminalName()).append(" ").append(sMModule.getSubterminalID()).toString());
            this.smmSvcRegList[i2] = this.bundleContext.registerService((class$de$audi$atip$statemachine$SMModule == null ? AbstractSMMActivator.class$("de.audi.atip.statemachine.SMModule") : class$de$audi$atip$statemachine$SMModule).getName(), (Object)sMModule, (Dictionary)hashtable);
        }
        smmInfo.addSMMInfo(this.getName(), "after registering services");
    }

    public void stop(BundleContext bundleContext) {
        for (int i2 = 0; i2 < this.smmSvcRegList.length; ++i2) {
            if (this.smmSvcRegList[i2] == null) continue;
            this.smmSvcRegList[i2].unregister();
        }
        this.smmSvcRegList = null;
        if (this.apTracker != null) {
            this.apTracker.close();
            this.apTracker = null;
        }
        this.reqActionProxies = null;
        this.smmList = null;
        while (!this.apRegs.isEmpty()) {
            ServiceReference serviceReference = (ServiceReference)this.apRegs.remove(0);
            if (serviceReference == null) continue;
            this.bundleContext.ungetService(serviceReference);
        }
        super.stop(bundleContext);
    }

    public Object addingService(ServiceReference serviceReference) {
        smmInfo.addSMMInfo(this.getName(), "  before adding service");
        Object object = serviceReference.getProperty("moduleID");
        if (object instanceof Integer) {
            int n = (Integer)object;
            boolean bl = false;
            for (int i2 = 0; i2 < this.reqActionProxies.length; ++i2) {
                if (this.reqActionProxies[i2] != n) continue;
                ActionProxy actionProxy = (ActionProxy)this.bundleContext.getService(serviceReference);
                smmInfo.addSMMInfo(this.getName(), new StringBuffer().append("    adding ActionProxy: moduleID: ").append(n).toString());
                for (int i3 = 0; i3 < this.smmList.length; ++i3) {
                    SMModule sMModule = this.smmList[i3];
                    if (sMModule == null) continue;
                    bl = sMModule.addActionProxy(n, actionProxy) != null || bl;
                }
                if (bl) {
                    this.apRegs.add(serviceReference);
                } else {
                    this.bundleContext.ungetService(serviceReference);
                    actionProxy = null;
                }
                smmInfo.addSMMInfo(this.getName(), "  after adding service");
                return actionProxy;
            }
        } else {
            this.framework.getLogChannel("Fw.Framework").log(10000, "AbstractSMMActivator#addingService: property module ID not set or has wrong type");
        }
        smmInfo.addSMMInfo(this.getName(), "  after adding service");
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        int n = (Integer)serviceReference.getProperty("moduleID");
        for (int i2 = 0; this.smmList != null && i2 < this.smmList.length; ++i2) {
            SMModule sMModule = this.smmList[i2];
            if (sMModule == null) continue;
            sMModule.removeActionProxy(n, (ActionProxy)object);
        }
        if (this.bundleContext != null) {
            this.apRegs.remove(serviceReference);
            this.bundleContext.ungetService(serviceReference);
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

