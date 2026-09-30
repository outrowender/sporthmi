/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.audio.AbstractTelAudioCmd;
import de.audi.app.phone.core.audio.TelAbortOutbandRingtonePlaybackCmdList;
import de.audi.app.phone.core.audio.TelAbortRingingMediaCmdList;
import de.audi.app.phone.core.audio.TelAbortRingtoneListMediaCmdList;
import de.audi.app.phone.core.audio.TelAbortRingtoneListWavePlayerCmdList;
import de.audi.app.phone.core.audio.TelAudioCmdDefaultListener;
import de.audi.app.phone.core.audio.TelAudioCmdListMobileSpeechRecognition;
import de.audi.app.phone.core.audio.TelAudioDSISoundCmdListener;
import de.audi.app.phone.core.audio.TelAudioScenarioBTHS1CmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioBTHS1MuteCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioBTHS2CmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioBTHS2MuteCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioHFPHandsfreeCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioHFPHandsfreeMuteCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioHFPHandsfreePrivateCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioHFPHandsfreePrivateMuteCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioIdleCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioRingingInbandHandsfreeCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioRingingInbandPrivateHFPCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioRingingMediaCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioRingingOutboundCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioRingtoneMuteOnCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioSIMHandsfreeCmdList;
import de.audi.app.phone.core.audio.TelAudioScenarioSIMHandsfreeMuteCmdList;
import de.audi.app.phone.core.audio.TelAudioWavePlayerCmdListener;
import de.audi.app.phone.core.audio.TelAudioWidebandSpeechCmdList;
import de.audi.app.phone.core.audio.TelHMIAudioServiceCmdListener;
import de.audi.app.phone.core.audio.TelRequestConnectionCmd;
import de.audi.app.phone.core.audio.TelRingingDefaultRingtoneFallbackCmdList;
import de.audi.app.phone.core.audio.TelRingtoneListDefaultRingtoneFallbackCmdList;
import de.audi.app.phone.core.audio.TelRingtoneListMediaCmdList;
import de.audi.app.phone.core.audio.TelRingtoneListWavePlayerCmdList;
import de.audi.app.phone.core.audio.TelUpdateRingtoneMuteStateCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.media.IMediaFilePlayerService;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.waveplayer.RingTonePlayer;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelAudioCmdManager
extends AbstractPhoneComponent
implements ServiceTrackerCustomizer {
    private final CommandListManager manager;
    private volatile PhoneServiceTracker hmiAudioServiceTracker = null;
    private volatile PhoneServiceTracker dsiSoundTracker;
    private volatile HMIAudioService hmiAudioService;
    private final TelAudioCmdDefaultListener defaultListener = new TelAudioCmdDefaultListener(this, this.log);
    private final TelHMIAudioServiceCmdListener hmiAudioServiceCmdListener;
    private final TelAudioWavePlayerCmdListener wavePlayerCmdListener;
    private final TelAudioDSISoundCmdListener dsiSoundCmdListener;
    private volatile DSISound dsiSound;
    private Monitor mediaRingingCmdListMonitor;
    private volatile int currentAudioScenario;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;

    public TelAudioCmdManager(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Audio");
        this.manager = new CommandListManager("TelAudioCmdManager", iTelApplication.getFrameworkAccess(), iTelApplication.getFrameworkAccess().getLogChannel("App.Phone.Audio.CL"), null, null);
        this.manager.start();
        this.hmiAudioServiceCmdListener = new TelHMIAudioServiceCmdListener(iTelApplication, this.defaultListener, this.manager);
        this.wavePlayerCmdListener = new TelAudioWavePlayerCmdListener(iTelApplication, this.defaultListener, this.manager);
        this.dsiSoundCmdListener = new TelAudioDSISoundCmdListener(iTelApplication, this.defaultListener, this.manager);
    }

    private void setCurrentAudioScenario(int n) {
        this.currentAudioScenario = n;
        this.defaultListener.setCurrentAudioScenario(n);
    }

    public void init() {
        long l = this.getApplication().getFrameworkAccess().getMonotonicTime();
        this.hmiAudioServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = TelAudioCmdManager.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.hmiAudioServiceTracker.openTracker();
        this.dsiSoundTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = TelAudioCmdManager.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.dsiSoundTracker.openTracker();
        this.hmiAudioServiceCmdListener.init();
        this.wavePlayerCmdListener.init();
        this.dsiSoundCmdListener.init();
        this.getApplication().getStartupLogChannel().log(1000000, "[TelAudioCmdManager#init] done in %1 ms", this.getApplication().getFrameworkAccess().getMonotonicTime() - l);
    }

    public void deinit() {
        this.manager.destroy();
        this.hmiAudioServiceCmdListener.deinit();
        this.wavePlayerCmdListener.deinit();
        this.dsiSoundCmdListener.deinit();
        if (this.hmiAudioServiceTracker != null) {
            this.hmiAudioServiceTracker.closeTracker();
            this.hmiAudioServiceTracker = null;
        }
        if (this.dsiSoundTracker != null) {
            this.dsiSoundTracker.closeTracker();
            this.dsiSoundTracker = null;
        }
    }

    private Command getAudioScenarioCommand(int n) {
        return new SetAudioScenarioCommand(this.log, this.hmiAudioService, n);
    }

    synchronized void scheduleAbortOutbandRinging(RingTonePlayer ringTonePlayer) {
        TelAbortOutbandRingtonePlaybackCmdList telAbortOutbandRingtonePlaybackCmdList = new TelAbortOutbandRingtonePlaybackCmdList(this.manager, this.log, this.hmiAudioService, ringTonePlayer);
        telAbortOutbandRingtonePlaybackCmdList.add(0, this.getAudioScenarioCommand(0));
        telAbortOutbandRingtonePlaybackCmdList.execute("ABORT_RINGING_OUTBAND");
    }

    synchronized void scheduleAbortMediaRinging(IMediaFilePlayerService iMediaFilePlayerService, IMediaFilePlayerSession iMediaFilePlayerSession, RingTonePlayer ringTonePlayer) {
        TelAbortRingingMediaCmdList telAbortRingingMediaCmdList = new TelAbortRingingMediaCmdList(this.manager, this.log, this.hmiAudioService, iMediaFilePlayerService, iMediaFilePlayerSession, ringTonePlayer);
        telAbortRingingMediaCmdList.add(0, this.getAudioScenarioCommand(0));
        telAbortRingingMediaCmdList.execute("ABORT_RINGING_MEDIA");
    }

    synchronized void scheduleAbortRingtoneListWavePlayerPlayback(RingTonePlayer ringTonePlayer) {
        TelAbortRingtoneListWavePlayerCmdList telAbortRingtoneListWavePlayerCmdList = new TelAbortRingtoneListWavePlayerCmdList(this.manager, this.log, this.hmiAudioService, ringTonePlayer);
        telAbortRingtoneListWavePlayerCmdList.add(0, this.getAudioScenarioCommand(0));
        telAbortRingtoneListWavePlayerCmdList.execute("ABORT_RINGTONE_LIST_OUTBAND");
    }

    synchronized void scheduleAbortRingtoneListMediaPlayback(IMediaFilePlayerService iMediaFilePlayerService, IMediaFilePlayerSession iMediaFilePlayerSession, RingTonePlayer ringTonePlayer) {
        TelAbortRingtoneListMediaCmdList telAbortRingtoneListMediaCmdList = new TelAbortRingtoneListMediaCmdList(this.manager, this.log, this.hmiAudioService, iMediaFilePlayerService, iMediaFilePlayerSession, ringTonePlayer);
        telAbortRingtoneListMediaCmdList.add(0, this.getAudioScenarioCommand(0));
        telAbortRingtoneListMediaCmdList.execute("ABORT_RINGTONE_LIST_MEDIA");
    }

    synchronized void scheduleOutbandRinging(RingTonePlayer ringTonePlayer, int n) {
        TelAudioScenarioRingingOutboundCmdList telAudioScenarioRingingOutboundCmdList = new TelAudioScenarioRingingOutboundCmdList(this.manager, this.log, this.hmiAudioService, ringTonePlayer, n);
        telAudioScenarioRingingOutboundCmdList.add(0, this.getAudioScenarioCommand(3));
        telAudioScenarioRingingOutboundCmdList.execute("RINGING_OUTBAND");
    }

    synchronized void scheduleOutbandRingtoneList(RingTonePlayer ringTonePlayer, int n) {
        TelRingtoneListWavePlayerCmdList telRingtoneListWavePlayerCmdList = new TelRingtoneListWavePlayerCmdList(this.manager, this.log, this.hmiAudioService, ringTonePlayer, n);
        telRingtoneListWavePlayerCmdList.add(0, this.getAudioScenarioCommand(17));
        telRingtoneListWavePlayerCmdList.execute("RINGTONE_LIST_OUTBAND");
    }

    synchronized void scheduleWidebandSpeech(boolean bl, boolean bl2, DSISoundListener dSISoundListener) {
        TelAudioWidebandSpeechCmdList telAudioWidebandSpeechCmdList = new TelAudioWidebandSpeechCmdList(this.manager, this.log, this.hmiAudioService, this.dsiSound, bl, bl2, dSISoundListener);
        telAudioWidebandSpeechCmdList.execute("WIDEBAND_SPEECH");
    }

    synchronized void scheduleMediaRinging(IMediaFilePlayerService iMediaFilePlayerService, IMediaFilePlayerSession iMediaFilePlayerSession) {
        TelAudioScenarioRingingMediaCmdList telAudioScenarioRingingMediaCmdList = new TelAudioScenarioRingingMediaCmdList(this.manager, this.log, this.hmiAudioService, iMediaFilePlayerService, iMediaFilePlayerSession);
        telAudioScenarioRingingMediaCmdList.add(0, this.getAudioScenarioCommand(19));
        telAudioScenarioRingingMediaCmdList.execute("RINGING_MEDIA");
    }

    synchronized void scheduleRingtoneListMediaPlayback(IMediaFilePlayerService iMediaFilePlayerService, IMediaFilePlayerSession iMediaFilePlayerSession) {
        TelRingtoneListMediaCmdList telRingtoneListMediaCmdList = new TelRingtoneListMediaCmdList(this.manager, this.log, this.hmiAudioService, iMediaFilePlayerService, iMediaFilePlayerSession);
        telRingtoneListMediaCmdList.add(0, this.getAudioScenarioCommand(18));
        telRingtoneListMediaCmdList.execute("RINGTONE_LIST_MEDIA");
    }

    synchronized void scheduleRingtoneListDefaultRingtoneFallback(RingTonePlayer ringTonePlayer, IMediaFilePlayerService iMediaFilePlayerService, IMediaFilePlayerSession iMediaFilePlayerSession) {
        TelRingtoneListDefaultRingtoneFallbackCmdList telRingtoneListDefaultRingtoneFallbackCmdList = new TelRingtoneListDefaultRingtoneFallbackCmdList(this.manager, this.log, this.hmiAudioService, ringTonePlayer, iMediaFilePlayerService, iMediaFilePlayerSession);
        telRingtoneListDefaultRingtoneFallbackCmdList.add(0, this.getAudioScenarioCommand(17));
        telRingtoneListDefaultRingtoneFallbackCmdList.execute("RINGTONE_LIST_DEFAULT_FALLBACK");
    }

    synchronized void scheduleRingtoneListDefaultRingtoneFallback(RingTonePlayer ringTonePlayer) {
        TelRingtoneListDefaultRingtoneFallbackCmdList telRingtoneListDefaultRingtoneFallbackCmdList = new TelRingtoneListDefaultRingtoneFallbackCmdList(this.manager, this.log, this.hmiAudioService, ringTonePlayer);
        telRingtoneListDefaultRingtoneFallbackCmdList.add(0, this.getAudioScenarioCommand(17));
        telRingtoneListDefaultRingtoneFallbackCmdList.execute("RINGTONE_LIST_DEFAULT_FALLBACK");
    }

    synchronized void scheduleRingingDefaultRingtoneFallback(RingTonePlayer ringTonePlayer, IMediaFilePlayerService iMediaFilePlayerService, IMediaFilePlayerSession iMediaFilePlayerSession) {
        TelRingingDefaultRingtoneFallbackCmdList telRingingDefaultRingtoneFallbackCmdList = new TelRingingDefaultRingtoneFallbackCmdList(this.manager, this.log, this.hmiAudioService, ringTonePlayer, iMediaFilePlayerService, iMediaFilePlayerSession);
        telRingingDefaultRingtoneFallbackCmdList.add(0, this.getAudioScenarioCommand(17));
        telRingingDefaultRingtoneFallbackCmdList.execute("RINGING_DEFAULT_FALLBACK");
    }

    synchronized void scheduleRingingDefaultRingtoneFallback(RingTonePlayer ringTonePlayer) {
        TelRingingDefaultRingtoneFallbackCmdList telRingingDefaultRingtoneFallbackCmdList = new TelRingingDefaultRingtoneFallbackCmdList(this.manager, this.log, this.hmiAudioService, ringTonePlayer);
        telRingingDefaultRingtoneFallbackCmdList.add(0, this.getAudioScenarioCommand(17));
        telRingingDefaultRingtoneFallbackCmdList.execute("RINGING_DEFAULT_FALLBACK");
    }

    synchronized void scheduleMobileSpeechRecognition(boolean bl) {
        TelAudioCmdListMobileSpeechRecognition telAudioCmdListMobileSpeechRecognition = new TelAudioCmdListMobileSpeechRecognition(this.manager, this.log, this.hmiAudioService, bl);
        Buffer buffer = new Buffer("MOBILE_SPEECH_RECOGNITION (");
        buffer.append(bl ? "ACTIVATE" : "DEACTIVATE");
        buffer.append(")");
        telAudioCmdListMobileSpeechRecognition.execute(buffer.toString());
    }

    synchronized void scheduleRingtoneMute(boolean bl) {
        if (bl) {
            TelAudioScenarioRingtoneMuteOnCmdList telAudioScenarioRingtoneMuteOnCmdList = new TelAudioScenarioRingtoneMuteOnCmdList(this.manager, this.log, this.hmiAudioService, this.getApplication());
            telAudioScenarioRingtoneMuteOnCmdList.add(0, this.getAudioScenarioCommand(5));
            telAudioScenarioRingtoneMuteOnCmdList.execute("RINGING_MUTE: ON");
        } else {
            CommandList commandList = new CommandList(this.manager);
            commandList.add(new TelUpdateRingtoneMuteStateCmd(this.log, this.hmiAudioService, false, this.getApplication()));
            commandList.execute("RINGING_MUTE: OFF");
        }
    }

    synchronized void scheduleInbandRingingHandsfree() {
        TelAudioScenarioRingingInbandHandsfreeCmdList telAudioScenarioRingingInbandHandsfreeCmdList = new TelAudioScenarioRingingInbandHandsfreeCmdList(this.manager, this.log, this.hmiAudioService);
        telAudioScenarioRingingInbandHandsfreeCmdList.add(0, this.getAudioScenarioCommand(1));
        telAudioScenarioRingingInbandHandsfreeCmdList.execute("RINGING_INBAND_HANDSFREE");
    }

    synchronized void scheduleInbandRingingPrivateHFP() {
        TelAudioScenarioRingingInbandPrivateHFPCmdList telAudioScenarioRingingInbandPrivateHFPCmdList = new TelAudioScenarioRingingInbandPrivateHFPCmdList(this.manager, this.log, this.hmiAudioService);
        telAudioScenarioRingingInbandPrivateHFPCmdList.add(0, this.getAudioScenarioCommand(2));
        telAudioScenarioRingingInbandPrivateHFPCmdList.execute("RINGING_INBAND_PRIVATE_HFP");
    }

    synchronized void scheduleAudioScenario(int n) {
        switch (n) {
            case 0: {
                TelAudioScenarioIdleCmdList telAudioScenarioIdleCmdList = new TelAudioScenarioIdleCmdList(this.manager, this.log, this.hmiAudioService);
                telAudioScenarioIdleCmdList.add(0, this.getAudioScenarioCommand(0));
                telAudioScenarioIdleCmdList.execute("IDLE");
                break;
            }
            case 12: {
                TelAudioScenarioHFPHandsfreeCmdList telAudioScenarioHFPHandsfreeCmdList = new TelAudioScenarioHFPHandsfreeCmdList(this.manager, this.log, this.hmiAudioService);
                telAudioScenarioHFPHandsfreeCmdList.add(0, this.getAudioScenarioCommand(12));
                telAudioScenarioHFPHandsfreeCmdList.execute("HFP_HANDSFREE");
                break;
            }
            case 14: {
                TelAudioScenarioHFPHandsfreePrivateCmdList telAudioScenarioHFPHandsfreePrivateCmdList = new TelAudioScenarioHFPHandsfreePrivateCmdList(this.manager, this.log, this.hmiAudioService);
                telAudioScenarioHFPHandsfreePrivateCmdList.add(0, this.getAudioScenarioCommand(14));
                telAudioScenarioHFPHandsfreePrivateCmdList.execute("HFP_PRIVATE");
                break;
            }
            case 13: {
                TelAudioScenarioHFPHandsfreeMuteCmdList telAudioScenarioHFPHandsfreeMuteCmdList = new TelAudioScenarioHFPHandsfreeMuteCmdList(this.manager, this.log, this.hmiAudioService);
                telAudioScenarioHFPHandsfreeMuteCmdList.add(0, this.getAudioScenarioCommand(13));
                telAudioScenarioHFPHandsfreeMuteCmdList.execute("HFP_HANDSFREE_MUTE");
                break;
            }
            case 15: {
                TelAudioScenarioHFPHandsfreePrivateMuteCmdList telAudioScenarioHFPHandsfreePrivateMuteCmdList = new TelAudioScenarioHFPHandsfreePrivateMuteCmdList(this.manager, this.log, this.hmiAudioService);
                telAudioScenarioHFPHandsfreePrivateMuteCmdList.add(0, this.getAudioScenarioCommand(15));
                telAudioScenarioHFPHandsfreePrivateMuteCmdList.execute("HFP_PRIVATE_MUTE");
                break;
            }
            case 6: {
                TelAudioScenarioSIMHandsfreeCmdList telAudioScenarioSIMHandsfreeCmdList = new TelAudioScenarioSIMHandsfreeCmdList(this.manager, this.log, this.hmiAudioService);
                telAudioScenarioSIMHandsfreeCmdList.add(0, this.getAudioScenarioCommand(6));
                telAudioScenarioSIMHandsfreeCmdList.execute("SIMAP_HANDSFREE");
                break;
            }
            case 7: {
                TelAudioScenarioSIMHandsfreeMuteCmdList telAudioScenarioSIMHandsfreeMuteCmdList = new TelAudioScenarioSIMHandsfreeMuteCmdList(this.manager, this.log, this.hmiAudioService);
                telAudioScenarioSIMHandsfreeMuteCmdList.add(0, this.getAudioScenarioCommand(13));
                telAudioScenarioSIMHandsfreeMuteCmdList.execute("SIMAP_HANDSFREE_MUTE");
                break;
            }
            case 8: {
                TelAudioScenarioBTHS1CmdList telAudioScenarioBTHS1CmdList = new TelAudioScenarioBTHS1CmdList(this.manager, this.log, this.hmiAudioService);
                telAudioScenarioBTHS1CmdList.add(0, this.getAudioScenarioCommand(8));
                telAudioScenarioBTHS1CmdList.execute("SIMAP_BTHS1");
                break;
            }
            case 9: {
                TelAudioScenarioBTHS1MuteCmdList telAudioScenarioBTHS1MuteCmdList = new TelAudioScenarioBTHS1MuteCmdList(this.manager, this.log, this.hmiAudioService);
                telAudioScenarioBTHS1MuteCmdList.add(0, this.getAudioScenarioCommand(9));
                telAudioScenarioBTHS1MuteCmdList.execute("SIMAP_BTHS1_MUTE");
                break;
            }
            case 10: {
                TelAudioScenarioBTHS2CmdList telAudioScenarioBTHS2CmdList = new TelAudioScenarioBTHS2CmdList(this.manager, this.log, this.hmiAudioService);
                telAudioScenarioBTHS2CmdList.add(0, this.getAudioScenarioCommand(10));
                telAudioScenarioBTHS2CmdList.execute("SIMAP_BTHS2");
                break;
            }
            case 11: {
                TelAudioScenarioBTHS2MuteCmdList telAudioScenarioBTHS2MuteCmdList = new TelAudioScenarioBTHS2MuteCmdList(this.manager, this.log, this.hmiAudioService);
                telAudioScenarioBTHS2MuteCmdList.add(0, this.getAudioScenarioCommand(11));
                telAudioScenarioBTHS2MuteCmdList.execute("SIMAP_BTHS1_MUTE");
                break;
            }
            default: {
                this.log.log(100000, "[TelAudioCmdManager#scheduleAudioScenario] unknown audio scenario %1", (long)n);
            }
        }
    }

    synchronized void scheduleRequestConnection(int n, int n2) {
        CommandList commandList = new CommandList(this.manager);
        commandList.add(new TelRequestConnectionCmd(this.log, n, this.hmiAudioService, n2));
        commandList.execute(new StringBuffer().append("requesting connection %1").append(n).toString());
    }

    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "TelAudioCmdManager#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "TelAudioCmdManager#addingService service is null");
            return null;
        }
        if (object instanceof HMIAudioService) {
            if (HMIAudioService.CLIENT_PHONE.equals(serviceReference.getProperty("AUDIO_CLIENT_ID"))) {
                this.log.log(10000000, "[TelAudioCmdManager#addingService] HMIAudioService=%1", object);
                this.setHMIAudioService((HMIAudioService)object);
                return object;
            }
        } else if (object instanceof DSISound) {
            this.log.log(1000000, "[TelWavePlayerHandler#addingService] WavePlayer=%1", object);
            this.setDSISound((DSISound)object);
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    void setDSISound(DSISound dSISound) {
        this.dsiSound = dSISound;
    }

    void setHMIAudioService(HMIAudioService hMIAudioService) {
        this.hmiAudioService = hMIAudioService;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (serviceReference == null) {
            this.log.log(10000, "TelAudioCmdManager#removedService reference is null");
            return;
        }
        if (object == null) {
            this.log.log(10000, "TelAudioCmdManager#removedService service is null");
            return;
        }
        if (object instanceof HMIAudioService) {
            this.log.log(10000000, "[TelAudioCmdManager#removedService] HMIAudioService=%1", object);
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.hmiAudioService = null;
        }
    }

    TelHMIAudioServiceCmdListener getHmiAudioServiceCmdListener() {
        return this.hmiAudioServiceCmdListener;
    }

    TelAudioWavePlayerCmdListener getWavePlayerCmdListener() {
        return this.wavePlayerCmdListener;
    }

    TelAudioDSISoundCmdListener getDsiSoundCmdListener() {
        return this.dsiSoundCmdListener;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class SetAudioScenarioCommand
    extends AbstractTelAudioCmd {
        final int audioScenario;

        SetAudioScenarioCommand(LogChannel logChannel, HMIAudioService hMIAudioService, int n) {
            super(logChannel, "SetAudioScenarioCommand", hMIAudioService);
            this.audioScenario = n;
        }

        public void execute() {
            TelAudioCmdManager.this.setCurrentAudioScenario(this.audioScenario);
            this.getCommandList().commandFinished();
        }
    }
}

