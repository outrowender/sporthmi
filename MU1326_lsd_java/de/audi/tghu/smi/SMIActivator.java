/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.SMIDiagnosis
 */
package de.audi.tghu.smi;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.activator.FrameworkException;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.statemachine.SMModule;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.atip.testsupport.ITestSupportService;
import de.audi.tghu.smi.SMI;
import de.mib.swdiagnosis.SMIDiagnosis;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SMIActivator
extends AbstractFrameworkActivator
implements ServiceTrackerCustomizer {
    private ServiceTracker sdsTracker;
    private ServiceTrackerCustomizer sdsTrackerDispatcher = new SDSTrackerDispatcher();
    private ServiceTrackerCustomizer bemTrackerDispatcher = new BEMTrackerDispatcher();
    private ServiceTracker smmTracker;
    private ServiceTracker bemTracker;
    private SMI smi;
    private ServiceRegistration smiSvcReg;
    static /* synthetic */ Class class$de$audi$atip$hmi$KbdService;
    static /* synthetic */ Class class$de$audi$atip$statemachine$SMModule;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$statemachine$sds$TTSASR;
    static /* synthetic */ Class class$de$audi$atip$testsupport$ITestSupportService;
    static /* synthetic */ Class class$de$audi$atip$statemachine$SMInterpreter;

    public SMIActivator() {
        super("FwSMI");
    }

    public SMI getService() {
        return this.smi;
    }

    protected void startInternal(BundleContext bundleContext) {
        KbdService kbdService = null;
        ServiceReference serviceReference = this.getFramework().getBundleCxt().getServiceReference((class$de$audi$atip$hmi$KbdService == null ? (class$de$audi$atip$hmi$KbdService = SMIActivator.class$("de.audi.atip.hmi.KbdService")) : class$de$audi$atip$hmi$KbdService).getName());
        if (serviceReference != null) {
            kbdService = (KbdService)this.getFramework().getBundleCxt().getService(serviceReference);
        }
        if (kbdService == null) {
            throw new FrameworkException("No key board service available! The start of the SMI has been aborted!");
        }
        this.smi = new SMI(this.framework, kbdService);
        this.smmTracker = new ServiceTracker(bundleContext, new String[]{(class$de$audi$atip$statemachine$SMModule == null ? (class$de$audi$atip$statemachine$SMModule = SMIActivator.class$("de.audi.atip.statemachine.SMModule")) : class$de$audi$atip$statemachine$SMModule).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = SMIActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()}, (ServiceTrackerCustomizer)this);
        this.smmTracker.open();
        this.sdsTracker = new ServiceTracker(bundleContext, (class$de$audi$atip$statemachine$sds$TTSASR == null ? (class$de$audi$atip$statemachine$sds$TTSASR = SMIActivator.class$("de.audi.atip.statemachine.sds.TTSASR")) : class$de$audi$atip$statemachine$sds$TTSASR).getName(), this.sdsTrackerDispatcher);
        this.sdsTracker.open();
        this.bemTracker = new ServiceTracker(bundleContext, (class$de$audi$atip$testsupport$ITestSupportService == null ? (class$de$audi$atip$testsupport$ITestSupportService = SMIActivator.class$("de.audi.atip.testsupport.ITestSupportService")) : class$de$audi$atip$testsupport$ITestSupportService).getName(), this.bemTrackerDispatcher);
        this.bemTracker.open();
        this.smiSvcReg = bundleContext.registerService((class$de$audi$atip$statemachine$SMInterpreter == null ? (class$de$audi$atip$statemachine$SMInterpreter = SMIActivator.class$("de.audi.atip.statemachine.SMInterpreter")) : class$de$audi$atip$statemachine$SMInterpreter).getName(), (Object)this.smi, null);
    }

    public void stop(BundleContext bundleContext) {
        if (this.smiSvcReg != null) {
            this.smiSvcReg.unregister();
        }
        this.smi.removeAllSMMs();
        if (this.smmTracker != null) {
            this.smmTracker.close();
            this.smmTracker = null;
        }
        this.smi = null;
        if (this.bemTracker != null) {
            this.bemTracker.close();
            this.bemTracker = null;
        }
        super.stop(bundleContext);
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getBundleContext().getService(serviceReference);
        if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new SMIDiagnosis(this.framework, this.smi));
        } else {
            SMModule sMModule = (SMModule)object;
            if (sMModule == null) {
                this.smi.getLogger().smi.log(10000, "[SMIActivator#addingService] SMM tracker received an invalid service (wrong type)");
                return null;
            }
            this.smi.triggerSMModuleAddition(sMModule);
        }
        return object;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        SMModule sMModule = (SMModule)object;
        this.smi.triggerSMModuleRemoval(sMModule);
        this.getBundleContext().ungetService(serviceReference);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class BEMTrackerDispatcher
    implements ServiceTrackerCustomizer {
        private BEMTrackerDispatcher() {
        }

        public Object addingService(ServiceReference serviceReference) {
            ITestSupportService iTestSupportService = (ITestSupportService)SMIActivator.this.getBundleContext().getService(serviceReference);
            if (iTestSupportService != null) {
                SMIActivator.this.smi.getSOSHandler().setTestSupportService(iTestSupportService);
                return iTestSupportService;
            }
            return null;
        }

        public void modifiedService(ServiceReference serviceReference, Object object) {
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            SMIActivator.this.getBundleContext().ungetService(serviceReference);
            SMIActivator.this.smi.getSOSHandler().setTestSupportService(null);
        }
    }

    private class SDSTrackerDispatcher
    implements ServiceTrackerCustomizer {
        private SDSTrackerDispatcher() {
        }

        public Object addingService(ServiceReference serviceReference) {
            TTSASR tTSASR = (TTSASR)SMIActivator.this.getBundleContext().getService(serviceReference);
            if (tTSASR != null) {
                ((SMIActivator)SMIActivator.this).smi.getLogger().smi.log(1000000, "[SMIActivator-SDSTrackerDispatcher#addingService] adding SDS Service...");
                SMIActivator.this.smi.setSDSService(tTSASR);
                ((SMIActivator)SMIActivator.this).smi.getLogger().smi.log(1000000, "[SMIActivator-SDSTrackerDispatcher#addingService] triggering the SDSApp to fire initialize-event");
                tTSASR.initializeStateMachine();
                return tTSASR;
            }
            return null;
        }

        public void modifiedService(ServiceReference serviceReference, Object object) {
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            ((SMIActivator)SMIActivator.this).smi.getLogger().smi.log(1000, "[SDSTrackerDispatcher#removedService] removed SDS Service...");
            SMIActivator.this.getBundleContext().ungetService(serviceReference);
            SMIActivator.this.smi.setSDSService(null);
        }
    }
}

