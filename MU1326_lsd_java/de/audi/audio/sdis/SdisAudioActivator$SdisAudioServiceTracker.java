/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.audio.sdis.SdisAudioDiag
 */
package de.audi.audio.sdis;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.IBluetoothA2LSService;
import de.audi.atip.interapp.audio.SDISRangeListener;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.NullAudioDrawerContext;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.def.NullBluetoothA2LSService;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.util.osgi.NullDSISound;
import de.audi.audio.sdis.ISdisCommandFactory;
import de.audi.audio.sdis.SdisAudioActivator;
import de.audi.audio.sdis.SdisAudioActivator$1;
import de.audi.audio.sdis.ifc.NullDSIMediaRouter;
import de.mib.swdiagnosis.audio.sdis.SdisAudioDiag;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaRouter;
import org.osgi.framework.ServiceReference;

class SdisAudioActivator$SdisAudioServiceTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ SdisAudioActivator this$0;

    private SdisAudioActivator$SdisAudioServiceTracker(SdisAudioActivator sdisAudioActivator) {
        this.this$0 = sdisAudioActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = SdisAudioActivator.access$100(this.this$0).getService(serviceReference);
        SdisAudioActivator.access$200((SdisAudioActivator)this.this$0).lcSDIS.log(1078071040, "[AudioSDISActivator.addingService] %1", object);
        if (object instanceof HMIAudioService) {
            Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
            if (!HMIAudioService.CLIENT_SDIS.equals(object2)) {
                return null;
            }
            SdisAudioActivator.access$300(this.this$0).setHmiAudioService((HMIAudioService)object);
            SdisAudioActivator.access$400(this.this$0).setAudioService((HMIAudioService)object);
            return object;
        }
        if (object instanceof AudioDrawerContext) {
            SdisAudioActivator.access$400(this.this$0).setAudioDrawerContext((AudioDrawerContext)object);
        }
        if (object instanceof DSIMediaRouter) {
            int[] nArray = new int[]{2, 1};
            DSIMediaRouter dSIMediaRouter = (DSIMediaRouter)object;
            dSIMediaRouter.setNotification(nArray, (DSIListener)SdisAudioActivator.access$400((SdisAudioActivator)this.this$0).dsiMediaRouterListener);
            SdisAudioActivator.access$300(this.this$0).setDsiMediaRouter(dSIMediaRouter);
            return object;
        }
        if (object instanceof DSISound) {
            SdisAudioActivator.access$400(this.this$0).setDSISound((DSISound)object);
            return object;
        }
        if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new SdisAudioDiag(SdisAudioActivator.access$400(this.this$0), this.this$0.asiProvider.sdisAudioListener, (ISdisCommandFactory)SdisAudioActivator.access$300(this.this$0)));
            return object;
        }
        if (object instanceof SDISRangeListener) {
            SdisAudioActivator.access$400(this.this$0).setRangeListener((SDISRangeListener)object);
            return object;
        }
        if (object instanceof IBluetoothA2LSService) {
            SdisAudioActivator.access$400((SdisAudioActivator)this.this$0).sdisAudioService.setBluetoothService((IBluetoothA2LSService)object);
            return object;
        }
        if (object instanceof IMediaService) {
            SdisAudioActivator.access$400((SdisAudioActivator)this.this$0).mediaService = (IMediaService)object;
            return object;
        }
        return null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        SdisAudioActivator.access$200((SdisAudioActivator)this.this$0).lcSDIS.log(1078071040, "[AudioSDISActivator.removedService] %1", object);
        if (object instanceof DSIMediaRouter) {
            SdisAudioActivator.access$300(this.this$0).setDsiMediaRouter(new NullDSIMediaRouter(SdisAudioActivator.access$200((SdisAudioActivator)this.this$0).lcSDIS));
        } else if (object instanceof DSISound) {
            SdisAudioActivator.access$400(this.this$0).setDSISound(new NullDSISound(SdisAudioActivator.access$200((SdisAudioActivator)this.this$0).lcSDIS));
        } else if (object instanceof HMIAudioService) {
            Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
            if (HMIAudioService.CLIENT_SDIS.equals(object2)) {
                SdisAudioActivator.access$300(this.this$0).setHmiAudioService(new NullHMIAudioService(SdisAudioActivator.access$200((SdisAudioActivator)this.this$0).lcSDIS));
            }
        } else if (object instanceof AudioDrawerContext) {
            SdisAudioActivator.access$400(this.this$0).setAudioDrawerContext(new NullAudioDrawerContext(SdisAudioActivator.access$200((SdisAudioActivator)this.this$0).lcSDIS));
        } else if (object instanceof IBluetoothA2LSService) {
            SdisAudioActivator.access$400((SdisAudioActivator)this.this$0).sdisAudioService.setBluetoothService(new NullBluetoothA2LSService(SdisAudioActivator.access$200((SdisAudioActivator)this.this$0).lcSDIS));
        } else if (object instanceof IMediaService) {
            SdisAudioActivator.access$400((SdisAudioActivator)this.this$0).mediaService = null;
        }
    }

    /* synthetic */ SdisAudioActivator$SdisAudioServiceTracker(SdisAudioActivator sdisAudioActivator, SdisAudioActivator$1 sdisAudioActivator$1) {
        this(sdisAudioActivator);
    }
}

