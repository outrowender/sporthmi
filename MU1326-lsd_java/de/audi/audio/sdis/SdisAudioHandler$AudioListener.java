/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.audio.DefaultHMIAudioServiceListener;
import de.audi.atip.interapp.audio.IAudioSdisListener;
import de.audi.audio.sdis.AudioContextController;
import de.audi.audio.sdis.SdisAudioHandler;
import de.audi.audio.sdis.SdisLabels;
import de.audi.audio.sdis.cmd.SdisCmdWaitForAudible;
import de.audi.tghu.command.Command;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;

class SdisAudioHandler$AudioListener
extends DefaultHMIAudioServiceListener
implements IAudioSdisListener {
    private final /* synthetic */ SdisAudioHandler this$0;

    SdisAudioHandler$AudioListener(SdisAudioHandler sdisAudioHandler) {
        this.this$0 = sdisAudioHandler;
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        Command command;
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.errorConnection] connection: %1, hmiTerminal: %2, errroCode: %3", (long)n, (long)n2, (long)n3);
        if (this.isRearAudioTerminal(n2) && (command = SdisAudioHandler.access$1600(this.this$0)) instanceof SdisCmdWaitForAudible) {
            command.getCommandList().commandAborted("Connection error");
        }
        if (n == 308) {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.errorConnection] disableA2LS");
            this.this$0.sdisAudioService.disableA2LSFromHU();
        }
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.updateAMAvailable] available: %1", bl);
        if (!bl) {
            int n = SdisAudioHandler.access$1200(this.this$0);
            this.this$0.sdisAudioService.setAudioContext(0);
            SdisAudioHandler.access$1202(this.this$0, n);
        } else {
            this.this$0.sdisAudioService.setAudioContext(SdisAudioHandler.access$1200(this.this$0));
        }
    }

    @Override
    public void stopConnection(int n, int n2) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.stopConnection] connection: %1, hmiTerminal: %2", (long)n, (long)n2);
        if (this.isRearAudioTerminal(n2)) {
            this.finishWaitCommand(n);
        } else {
            if (n == 308) {
                this.finishWaitCommand(n);
            }
            if (n == 308 && SdisAudioHandler.access$300(this.this$0).getAudioContext() == 1) {
                SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.stopConnection] disableA2LS");
                this.this$0.sdisAudioService.disableA2LSFromHU();
            }
        }
    }

    @Override
    public void pauseConnection(int n, int n2) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.pauseConnection] connection: %1, hmiTerminal: %2", (long)n, (long)n2);
        if (this.isRearAudioTerminal(n2) || n == 308) {
            this.finishWaitCommand(n);
        }
    }

    @Override
    public void startConnection(int n, int n2) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.startConnection] connection: %1, hmiTerminal: %2", (long)n, (long)n2);
        if (this.isRearAudioTerminal(n2) || n == 308) {
            this.finishWaitCommand(n);
        } else {
            if (AudioConnection.contains(AudioConnection.MUTE_SDIS_CONNECTIONS, n)) {
                this.this$0.sdisAudioService.disableA2LSFromHU();
            }
            if (n == 8) {
                this.this$0.sdisAudioListener.updateVolume(0);
            }
        }
    }

    @Override
    public void fadedIn(int n, int n2) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.fadedIn] connection: %1, hmiTerminal: %2", (long)n, (long)n2);
        if (this.isRearAudioTerminal(n2) || n == 308) {
            this.finishWaitCommand(n);
        }
    }

    @Override
    public void updateVolumeLock(int n, int n2, boolean bl) {
        VolumeLockState volumeLockState = new VolumeLockState(0, 0);
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.updateVolumeLock] volumeLockActive: %1, connection: %2", bl, (long)n);
        if (AudioConnection.contains(AudioConnection.ENT_RADIO_CONNS, n)) {
            volumeLockState = SdisAudioHandler.access$1700(this.this$0, AudioContextController.AUDIO_CONTEXT_RADIO);
        } else if (n == 27 || n == 307) {
            volumeLockState = SdisAudioHandler.access$1700(this.this$0, AudioContextController.AUDIO_CONTEXT_TV);
        } else if (AudioConnection.contains(AudioConnection.ENT_MEDIA_CONNS, n) || AudioConnection.contains(AudioConnection.SDIS_ENT_CONNECTIONS, n)) {
            volumeLockState = SdisAudioHandler.access$1700(this.this$0, AudioContextController.AUDIO_CONTEXT_MEDIA);
        } else {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.updateVolumeLock] invalid volume lock connection: %1", (long)n);
            return;
        }
        if (this.this$0.hasLockStateChanged(volumeLockState, bl)) {
            this.this$0.setLockState(volumeLockState, bl);
            SdisAudioHandler.access$1800(this.this$0, volumeLockState.getAudioContext());
        }
    }

    private void finishWaitCommand(int n) {
        Command command = SdisAudioHandler.access$1600(this.this$0);
        if (command instanceof SdisCmdWaitForAudible) {
            ((SdisCmdWaitForAudible)command).finishCmd(n);
        } else {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.finishWaitCommand] active command is not SdisCmdWaitForAudible -> %1. do not finish", (Object)(command != null ? command.getName() : "null"));
        }
    }

    private boolean isRearAudioTerminal(int n) {
        return n != 0;
    }

    private void updateAudibleState(int n) {
        int n2 = this.getAudibleReason(n);
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.updateAudibleState]  newAudibleState: %1 audibleState: %2", (long)n2, (long)SdisAudioHandler.access$1500(this.this$0));
        if (this.hasAudibleStateChanged(n2)) {
            SdisAudioHandler.access$1502(this.this$0, n2);
            this.this$0.sdisAudioListener.updateAudibleState(SdisAudioHandler.access$1500(this.this$0));
        }
    }

    private int getAudibleReason(int n) {
        int n2 = SdisAudioHandler.access$1500(this.this$0);
        if (AudioConnection.isSdisSoundSourceEntertainment(n)) {
            n2 = 0;
        }
        if (3 == n) {
            n2 = 32;
        }
        if (AudioConnection.contains(AudioConnection.MUTE_SDIS_CONNECTIONS, n)) {
            n2 = 4096;
        }
        if (AudioConnection.isSdisSoundSourcePhone(n)) {
            n2 = 2;
        }
        if (AudioConnection.isSdisSoundSourceNavigation(n)) {
            n2 = 1;
        }
        if (AudioConnection.contains(AudioConnection.TA_PTY31, n)) {
            n2 = 8;
        }
        if (AudioConnection.isSdisSoundSourceSds(n)) {
            n2 = 4;
        }
        if (AudioConnection.contains(AudioConnection.VOLUME_MENU_CONNECTIONS, n) || AudioConnection.contains(AudioConnection.READOUT_CONTACT_CONNS, n) || n == 126) {
            n2 = 4096;
        }
        String string = SdisLabels.getAudibleState(n2);
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.getAudibleReason]  reason: %1 connection: %2", (Object)string, (long)n);
        return n2;
    }

    boolean hasAudibleStateChanged(int n) {
        return SdisAudioHandler.access$1500(this.this$0) != n;
    }

    @Override
    public void updateActiveConnection(int n, int n2) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.updateActiveConnection] AC:%1, HT:%2", (long)n, (long)n2);
        if (n2 == 0) {
            this.updateAudibleState(n);
        }
    }

    @Override
    public void updateActiveEntertainmentConnection(int n, int n2) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.AudioListener.updateActiveEntertainmentConnection] AC:%1, HT:%2", (long)n, (long)n2);
    }
}

