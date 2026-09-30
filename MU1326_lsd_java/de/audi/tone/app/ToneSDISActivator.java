/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tone.sdis.ASIHMISyncSoundImpl;
import de.audi.tone.sdis.SdisAppSoundAudioListener;
import de.audi.tone.sdis.SdisAppSoundListener;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.audio.DSISound;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ToneSDISActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    private LogChannel lc;
    private ASIHMISyncSoundImpl asiProvider;
    private SdisAppSoundListener sdisSoundListener;
    private SdisAppSoundAudioListener sdisAudioListener;
    static /* synthetic */ Class class$de$audi$atip$agent$IASIProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ISoundHandlerListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$IAudioSdisListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.lc = this.framework.getLogChannel("App.Tone.SDIS");
        this.asiProvider = new ASIHMISyncSoundImpl(0, this.lc);
        this.sdisSoundListener = new SdisAppSoundListener(this.asiProvider, this.lc);
        this.sdisAudioListener = new SdisAppSoundAudioListener(this.asiProvider, this.lc);
        this.asiProvider.init();
        this.registerService(class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = ToneSDISActivator.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider, this.asiProvider);
        this.registerService(class$de$audi$atip$interapp$audio$ISoundHandlerListener == null ? (class$de$audi$atip$interapp$audio$ISoundHandlerListener = ToneSDISActivator.class$("de.audi.atip.interapp.audio.ISoundHandlerListener")) : class$de$audi$atip$interapp$audio$ISoundHandlerListener, this.sdisSoundListener);
        this.registerService(class$de$audi$atip$interapp$audio$IAudioSdisListener == null ? (class$de$audi$atip$interapp$audio$IAudioSdisListener = ToneSDISActivator.class$("de.audi.atip.interapp.audio.IAudioSdisListener")) : class$de$audi$atip$interapp$audio$IAudioSdisListener, this.sdisAudioListener);
        Hashtable hashtable = new Hashtable();
        hashtable.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_SDIS);
        this.registerService((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = ToneSDISActivator.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (Object)this.sdisAudioListener, (Dictionary)hashtable);
        new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = ToneSDISActivator.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName(), (ServiceTrackerCustomizer)this).open();
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        Object object2 = null;
        if (object instanceof DSISound) {
            this.asiProvider.registerDSISound((DSISound)object);
            object2 = object;
        }
        if (object2 != null) {
            Object object3 = serviceReference.getProperty("objectClass");
            this.lc.log(10000000, "[ToneSDISActivator.addingService] %1 -> %2", object3, object);
        } else {
            this.bundleContext.ungetService(serviceReference);
        }
        return object2;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        Object object2 = serviceReference.getProperty("objectClass");
        this.lc.log(10000000, "[ToneSDISActivator.removedService] %1 -> %2", object2, object);
        if (object instanceof DSISound) {
            this.asiProvider.deregisterDSISound();
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

