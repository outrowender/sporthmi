/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.audio.HMIAudioService;
import de.audi.tghu.redengineering.app.AudioManagementHandler;
import de.audi.tghu.redengineering.app.CoreEngineeringActivator;
import de.audi.tghu.redengineering.app.EngineeringAppEvo;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.audi.tghu.redengineering.app.EngineeringTextFactoryEvo;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public final class EngineeringActivator
extends CoreEngineeringActivator {
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        EngineeringEnv engineeringEnv = new EngineeringEnv(this.getFramework(), new EngineeringTextFactoryEvo());
        AudioManagementHandler audioManagementHandler = new AudioManagementHandler(engineeringEnv);
        EngineeringAppEvo engineeringAppEvo = new EngineeringAppEvo(bundleContext, engineeringEnv, audioManagementHandler);
        this.startCoreBundle(engineeringAppEvo, engineeringEnv);
        this.registerServices(engineeringAppEvo, audioManagementHandler);
    }

    private void registerServices(EngineeringAppEvo engineeringAppEvo, AudioManagementHandler audioManagementHandler) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(21));
        this.registerService(new String[]{(class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = EngineeringActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName()}, (Object)engineeringAppEvo, (Dictionary)hashtable);
        hashtable = new Hashtable();
        hashtable.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_SWDL);
        this.registerService((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = EngineeringActivator.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (Object)audioManagementHandler, (Dictionary)hashtable);
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

