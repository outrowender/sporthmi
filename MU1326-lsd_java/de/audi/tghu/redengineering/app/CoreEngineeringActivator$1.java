/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.swdl.EngineeringDiagnosisGateway
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.SDSService;
import de.audi.tghu.redengineering.app.CoreEngineeringActivator;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.mib.swdiagnosis.swdl.EngineeringDiagnosisGateway;
import org.dsi.ifc.swap.DSISWaP;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class CoreEngineeringActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ EngineeringEnv val$engineeringEnv;
    private final /* synthetic */ CoreEngineeringActivator this$0;

    CoreEngineeringActivator$1(CoreEngineeringActivator coreEngineeringActivator, EngineeringEnv engineeringEnv) {
        this.this$0 = coreEngineeringActivator;
        this.val$engineeringEnv = engineeringEnv;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = CoreEngineeringActivator.access$000(this.this$0).getService(serviceReference);
        if (object instanceof HMIAudioService) {
            Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
            if (HMIAudioService.CLIENT_SWDL.equals(object2)) {
                this.this$0.getEngineeringApp().getAudioManagementHandler().setHmiAudioService((HMIAudioService)object);
                return object;
            }
            CoreEngineeringActivator.access$100(this.this$0).ungetService(serviceReference);
            return null;
        }
        if (object instanceof SDSService) {
            this.val$engineeringEnv.setSdsService((SDSService)object);
            return object;
        }
        if (object instanceof DSISWaP) {
            this.this$0.getEngineeringApp().getFSCViewer().setDSI((DSISWaP)object);
            return object;
        }
        if (object instanceof SwDiagnosisManager) {
            EngineeringDiagnosisGateway engineeringDiagnosisGateway = new EngineeringDiagnosisGateway(CoreEngineeringActivator.access$200(this.this$0), this.val$engineeringEnv);
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)engineeringDiagnosisGateway);
            return object;
        }
        CoreEngineeringActivator.access$300(this.this$0).ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof HMIAudioService) {
            Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
            if (HMIAudioService.CLIENT_SWDL.equals(object2)) {
                this.this$0.getEngineeringApp().getAudioManagementHandler().setHmiAudioService(null);
            }
        } else if (object.equals(this.val$engineeringEnv.getSdsService())) {
            this.val$engineeringEnv.setSdsService(null);
        }
        CoreEngineeringActivator.access$400(this.this$0).ungetService(serviceReference);
    }
}

