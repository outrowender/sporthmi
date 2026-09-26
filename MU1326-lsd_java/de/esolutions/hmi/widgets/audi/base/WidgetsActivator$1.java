/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.esolutions.hmi.widgets.audi.base.WidgetsActivator;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class WidgetsActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ KbdService val$kbdService;
    private final /* synthetic */ WidgetsActivator this$0;

    WidgetsActivator$1(WidgetsActivator widgetsActivator, KbdService kbdService) {
        this.this$0 = widgetsActivator;
        this.val$kbdService = kbdService;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.this$0.getBundleContext().getService(serviceReference);
        if (object instanceof TTSService) {
            if (this.val$kbdService != null && this.val$kbdService.isTouchKeypanel()) {
                Integer n = (Integer)serviceReference.getProperty("TTS_CLIENT_ID");
                if (n == 0) {
                    TTSSessionBasedService tTSSessionBasedService = (TTSSessionBasedService)object;
                    WidgetsActivator.access$000(this.this$0).getHMITerminalRegistry().setTTSService(tTSSessionBasedService);
                    return object;
                }
            } else {
                WidgetsActivator.access$100(this.this$0).getLogChannel("Fw.Widgets.TouchPad.Keypanel").log(1078071040, "WidgetsActivator#initializeTTSServiceTracker#addingService keypanel is no touch keypanel - ignore tts service registration");
            }
        } else if (object instanceof SwDiagnosisManager) {
            this.this$0.registerDiagnosisGateways((SwDiagnosisManager)object);
            return object;
        }
        this.this$0.getBundleContext().ungetService(serviceReference);
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof TTSService) {
            if (object instanceof TTSSessionBasedService) {
                ((TTSSessionBasedService)object).stopSession();
            }
            WidgetsActivator.access$200(this.this$0).getHMITerminalRegistry().setTTSService(null);
        } else if (object instanceof SwDiagnosisManager) {
            this.this$0.unregisterDiagnosisGateways((SwDiagnosisManager)object);
        }
    }
}

