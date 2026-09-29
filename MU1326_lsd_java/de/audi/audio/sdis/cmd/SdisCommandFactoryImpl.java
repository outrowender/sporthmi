/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.atip.start.ILastmodeHandler;
import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.ISdisCommandFactory;
import de.audi.audio.sdis.SdisStreamState;
import de.audi.audio.sdis.cmd.SdisCmdChangeAudioFocus;
import de.audi.audio.sdis.cmd.SdisCmdChangeFrontAudioFocus;
import de.audi.audio.sdis.cmd.SdisCmdChangeFrontLastMode;
import de.audi.audio.sdis.cmd.SdisCmdDemute;
import de.audi.audio.sdis.cmd.SdisCmdReleaseA2LS;
import de.audi.audio.sdis.cmd.SdisCmdReleaseSdisAudioConnections;
import de.audi.audio.sdis.cmd.SdisCmdRequestA2LS;
import de.audi.audio.sdis.cmd.SdisCmdResponsEnableA2LS;
import de.audi.audio.sdis.cmd.SdisCmdSendLockState;
import de.audi.audio.sdis.cmd.SdisCmdSetAudioRouteA2LS;
import de.audi.audio.sdis.cmd.SdisCmdSetAudioRouteMedia;
import de.audi.audio.sdis.cmd.SdisCmdSleep;
import de.audi.audio.sdis.cmd.SdisCmdStreamRegister;
import de.audi.audio.sdis.cmd.SdisCmdStreamRequestConf;
import de.audi.audio.sdis.cmd.SdisCmdStreamStart;
import de.audi.audio.sdis.cmd.SdisCmdStreamStop;
import de.audi.audio.sdis.cmd.SdisCmdStreamUnregister;
import de.audi.audio.sdis.cmd.SdisCmdUpdateAudioContext;
import de.audi.audio.sdis.cmd.SdisCmdWaitForAudible;
import de.audi.audio.sdis.ifc.NullDSIMediaRouter;
import de.audi.audio.sdis.ifc.SdisAudioListener;
import de.audi.tghu.command.Command;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.DSIMediaRouter;

public class SdisCommandFactoryImpl
implements ISdisCommandFactory {
    private static final int DEFAULT_CLIENT_ID;
    private final AudioEnv env;
    private DSIMediaRouter dsiMediaRouter;
    private HMIAudioService hmiAudioService;
    private IAudioFocusManager audioFocusManager;
    private ILastmodeHandler lastmodeHandler;
    private final SdisAudioListener sdisAudioListener;
    private SdisStreamState streamState;

    public SdisCommandFactoryImpl(AudioEnv audioEnv, IAudioFocusManager iAudioFocusManager, SdisAudioListener sdisAudioListener, SdisStreamState sdisStreamState) {
        this.env = audioEnv;
        this.dsiMediaRouter = new NullDSIMediaRouter(audioEnv.lcSDIS);
        this.hmiAudioService = new NullHMIAudioService(audioEnv.lcSDIS);
        this.audioFocusManager = iAudioFocusManager;
        this.sdisAudioListener = sdisAudioListener;
        this.lastmodeHandler = audioEnv.framework.getLastmodeHandler();
        this.streamState = sdisStreamState;
    }

    public void setDsiMediaRouter(DSIMediaRouter dSIMediaRouter) {
        this.env.lcSDIS.log(1078071040, "[SDISCommandFactoryImpl.setDsiMediaRouter] %1", (Object)dSIMediaRouter);
        this.dsiMediaRouter = dSIMediaRouter;
    }

    public void setHmiAudioService(HMIAudioService hMIAudioService) {
        this.hmiAudioService = hMIAudioService;
    }

    @Override
    public Command cmdAudioRouteA2LS() {
        return new SdisCmdSetAudioRouteA2LS(this.env, this.dsiMediaRouter);
    }

    @Override
    public Command cmdAudioRouteMedia(AudioRoute audioRoute) {
        return new SdisCmdSetAudioRouteMedia(this.env, this.dsiMediaRouter, audioRoute);
    }

    @Override
    public Command cmdStartStreaming() {
        return new SdisCmdStreamStart(this.env, this.dsiMediaRouter, 0, this.streamState);
    }

    @Override
    public Command cmdStopStreaming(boolean bl) {
        return new SdisCmdStreamStop(this.env, this.dsiMediaRouter, 0, this.streamState, bl);
    }

    @Override
    public Command cmdRequestConf(int n) {
        return new SdisCmdStreamRequestConf(this.env, this.dsiMediaRouter, 0, n, this.streamState);
    }

    @Override
    public Command cmdRequestConf(int n, int n2) {
        return new SdisCmdStreamRequestConf(this.env, this.dsiMediaRouter, 0, n, n2, this.streamState);
    }

    @Override
    public Command cmdReleaseSdisAudioConnections() {
        return new SdisCmdReleaseSdisAudioConnections(this.env, this.hmiAudioService, AudioConnection.SDIS_ENT_CONNECTIONS);
    }

    @Override
    public Command cmdSendInChange(int n) {
        AudioState audioState = new AudioState(n, 0);
        return new SdisCmdUpdateAudioContext(this.env, this.sdisAudioListener, audioState);
    }

    @Override
    public Command cmdSendReady(int n) {
        AudioState audioState = new AudioState(n, 1);
        return new SdisCmdUpdateAudioContext(this.env, this.sdisAudioListener, audioState);
    }

    @Override
    public Command cmdSendA2LSReady(int n) {
        AudioState audioState = new AudioState(n, 1);
        return new SdisCmdUpdateAudioContext(this.env, this.sdisAudioListener, audioState);
    }

    @Override
    public Command cmdAudioFocus(int n) {
        return new SdisCmdChangeAudioFocus(this.env, this.audioFocusManager, n);
    }

    @Override
    public Command cmdFrontAudioFocus(int n) {
        return new SdisCmdChangeFrontAudioFocus(this.env, this.audioFocusManager, n);
    }

    @Override
    public Command cmdWaitUntilRadioAudible() {
        return new SdisCmdWaitForAudible(this.env, AudioConnection.SDIS_ENT_RADIO_CONNS);
    }

    @Override
    public Command cmdWaitUntilTVAudible() {
        return new SdisCmdWaitForAudible(this.env, 307);
    }

    @Override
    public Command cmdWaitUntilA2LSAudible() {
        return new SdisCmdWaitForAudible(this.env, 308);
    }

    @Override
    public Command cmdRegister() {
        return new SdisCmdStreamRegister(this.env, this.dsiMediaRouter, 0, "NO_IP");
    }

    @Override
    public Command cmdUnregister() {
        return new SdisCmdStreamUnregister(this.env, this.dsiMediaRouter, 0);
    }

    @Override
    public Command cmdSleep() {
        return new SdisCmdSleep(this.env, 0);
    }

    @Override
    public Command cmdSleep(int n) {
        return new SdisCmdSleep(this.env, n);
    }

    @Override
    public Command cmdResponseEnableA2LS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        return new SdisCmdResponsEnableA2LS(this.env, aSIHMISyncAudioReply);
    }

    @Override
    public Command cmdRequestA2LS() {
        return new SdisCmdRequestA2LS(this.env, this.hmiAudioService);
    }

    @Override
    public Command cmdReleaseA2LS() {
        return new SdisCmdReleaseA2LS(this.env, this.hmiAudioService);
    }

    @Override
    public Command cmdSendLockState(VolumeLockState volumeLockState) {
        return new SdisCmdSendLockState(this.env, volumeLockState, this.sdisAudioListener);
    }

    @Override
    public Command cmdFrontLastMode(int n) {
        return new SdisCmdChangeFrontLastMode(this.env, this.lastmodeHandler, n);
    }

    @Override
    public Command cmdDemute() {
        return new SdisCmdDemute(this.env, this.hmiAudioService);
    }
}

