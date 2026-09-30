/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.audio.cmd.AudioStateSetGetCmd;
import de.audi.app.ecall.core.audio.cmd.EcalHMIAudioServiceCmdListener;
import de.audi.app.ecall.core.audio.cmd.EcallAudioCmdDefaultListener;
import de.audi.app.ecall.core.audio.cmd.EcallAudioDSISoundCmdListener;
import de.audi.app.ecall.core.audio.cmd.EcallReleaseAllConnectionsCmdList;
import de.audi.app.ecall.core.audio.cmd.EcallReleaseConnectionCmd;
import de.audi.app.ecall.core.audio.cmd.EcallRequestConnectionCmd;
import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdManager;
import de.audi.app.ecall.core.osgi.EcallServiceTracker;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class EcallAudioCmdManager
extends AbstractEcallComponent
implements ServiceTrackerCustomizer,
IEcallAudioCmdManager {
    private volatile HMIAudioService hmiAudioService;
    private final EcallServiceTracker hmiAudioServiceTracker;
    private final CommandListManager manager;
    private final EcalHMIAudioServiceCmdListener hmiAudioServiceCmdListener;
    private final EcallAudioDSISoundCmdListener dsiSoundCmdListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;

    public EcallAudioCmdManager(IEcallApplication iEcallApplication, EcallAudioCmdDefaultListener ecallAudioCmdDefaultListener, EcallAudioCmdDefaultListener ecallAudioCmdDefaultListener2) {
        super(iEcallApplication, "App.Ecall.Audio");
        this.hmiAudioServiceTracker = new EcallServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = EcallAudioCmdManager.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.manager = new CommandListManager("EcallAudioCmdManager", iEcallApplication.getFrameworkAccess(), this.getLogger("App.Ecall.Audio.CL"), null, null);
        this.manager.start();
        this.hmiAudioServiceCmdListener = new EcalHMIAudioServiceCmdListener(iEcallApplication, ecallAudioCmdDefaultListener, this.manager);
        this.dsiSoundCmdListener = new EcallAudioDSISoundCmdListener(iEcallApplication, ecallAudioCmdDefaultListener2, this.manager);
    }

    EcallAudioCmdManager(IEcallApplication iEcallApplication, CommandListManager commandListManager, EcalHMIAudioServiceCmdListener ecalHMIAudioServiceCmdListener, EcallAudioDSISoundCmdListener ecallAudioDSISoundCmdListener) {
        super(iEcallApplication, "App.Ecall.Audio");
        this.hmiAudioServiceTracker = new EcallServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = EcallAudioCmdManager.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.hmiAudioServiceCmdListener = ecalHMIAudioServiceCmdListener;
        this.dsiSoundCmdListener = ecallAudioDSISoundCmdListener;
        this.manager = commandListManager;
    }

    public void init() {
        this.manager.start();
        this.hmiAudioServiceTracker.openTracker();
        this.hmiAudioServiceCmdListener.init();
        this.dsiSoundCmdListener.init();
    }

    public void deinit() {
        this.manager.destroy();
        this.hmiAudioServiceTracker.closeTracker();
        this.hmiAudioServiceCmdListener.deinit();
        this.dsiSoundCmdListener.deinit();
    }

    private void createAndStartCommandList(int n, int n2, String string, int n3) {
        CommandList commandList = new CommandList(this.manager);
        commandList.add(new EcallRequestConnectionCmd(this.log, n, this.hmiAudioService, n2));
        commandList.add(new AudioStateSetGetCmd(this.log, this.getEcallBapServiceAdapter(), n3));
        commandList.execute(string);
    }

    public void schedulePhoneEcallAudioScenario(int n, boolean bl) {
        this.log.log(1000000, "EcallAudioCmdManager#schedulePhoneEcallAudioScenario(): called. HasActiveCustomerCall: %1", bl);
        if (!bl) {
            this.createAndStartCommandList(226, 1, "SETUP_ECALL_MUTE_CONNECTION", n);
        }
    }

    public void schedulePhoneEcallHighAudioScenario(int n) {
        this.log.log(1000000, "EcallAudioCmdManager#schedulePhoneEcallHighAudioScenario(): called");
        this.createAndStartCommandList(227, 1, "SETUP_PHONE_ECALL_HIGH_CONNECTION", n);
    }

    public void schedulePhoneVoiceHighAudioScenario(int n) {
        this.log.log(1000000, "EcallAudioCmdManager#schedulePhoneVoiceHighAudioScenario(): called");
        this.createAndStartCommandList(228, 1, "SETUP_PHONE_VOICE_HIGH_CONNECTION", n);
    }

    public void schedulePhoneVoiceLowAudioScenario(int n) {
        this.log.log(1000000, "EcallAudioCmdManager#schedulePhoneVoiceLowAudioScenario(): called");
        this.createAndStartCommandList(225, 1, "SETUP_PHONE_VOICE_LOW_CONNECTION", n);
    }

    public void scheduleEcallMuteAudioScenario(int n) {
        this.log.log(1000000, "EcallAudioCmdManager#scheduleEcallMuteAudioScenario(): called");
        this.createAndStartCommandList(210, 0, "SETUP_ECALL_MUTE_CONNECTION", n);
    }

    public void scheduleMutePinAudioScenarioRequest() {
        this.log.log(1000000, "EcallAudioCmdManager#scheduleMutePinAudioScenarioRequest(): called");
        CommandList commandList = new CommandList(this.manager);
        commandList.add(new EcallRequestConnectionCmd(this.log, 213, this.hmiAudioService, 0));
        commandList.execute("SETUP_MUTEPIN_EC");
    }

    public void scheduleMutePinMuteRequest() {
        this.log.log(1000000, "EcallAudioCmdManager#scheduleMutePinMuteRequest(): called");
        CommandList commandList = new CommandList(this.manager);
        commandList.add(new EcallRequestConnectionCmd(this.log, 210, this.hmiAudioService, 0));
        commandList.execute("SETUP_MUTEPIN_MUTE_REQUEST");
    }

    public void scheduleMutePinMuteRelease() {
        this.log.log(1000000, "EcallAudioCmdManager#scheduleMutePinMuteRelease(): called");
        CommandList commandList = new CommandList(this.manager);
        commandList.add(new EcallReleaseConnectionCmd(this.log, 210, this.hmiAudioService));
        commandList.execute("SETUP_MUTEPIN_MUTE_RELEASE");
    }

    public void scheduleReleaseAllConnections(boolean bl) {
        this.log.log(1000000, "EcallAudioCmdManager#scheduleReleaseAllConnections(): called");
        EcallReleaseAllConnectionsCmdList ecallReleaseAllConnectionsCmdList = new EcallReleaseAllConnectionsCmdList(this.manager, this.log, this.hmiAudioService);
        ecallReleaseAllConnectionsCmdList.addToFirst(new AudioStateSetGetCmd(this.log, this.getEcallBapServiceAdapter(), bl ? 6 : 5));
        ecallReleaseAllConnectionsCmdList.execute("SETUP_RELEASE_ALL_CONNECTIONS");
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof HMIAudioService && HMIAudioService.CLIENT_ECALL.equals(serviceReference.getProperty("AUDIO_CLIENT_ID"))) {
            this.hmiAudioService = (HMIAudioService)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof HMIAudioService) {
            this.log.log(10000000, "EcallAudioCmdManager#removedService(): HMIAudioService=%1", object);
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.hmiAudioService = new NullHMIAudioService(this.log);
        }
    }

    void setHmiAudioService(HMIAudioService hMIAudioService) {
        this.hmiAudioService = hMIAudioService;
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

