/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.PhoneService;
import de.audi.atip.interapp.media.IMediaFilePlayerService;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.tghu.waveplayer.RingTonePlayer;
import de.audi.tghu.waveplayer.WavePlayer;
import de.audi.tghu.waveplayer.WavePlayerListener;
import de.audi.tone.app.volume.AbstractPhoneVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.audi.tone.app.volume.greyout.DefaultGreyOutAndPopupHandler;
import de.audi.tone.app.volume.samples.FileSamplePlayer;
import de.audi.tone.app.volume.samples.ISamplePlayer;
import de.audi.tone.app.volume.samples.NullSamplePlayer;
import de.audi.tone.app.volume.samples.RingtoneSamplePlayer;

public class PhoneRingtoneVolumeRange
extends AbstractPhoneVolumeRange {
    private final int[] volumeConnections = PhoneRingtoneVolumeRange.merge(AudioConnection.PHONE_RINGING, new int[]{87, 88, 87, 91});
    private final RingtoneSamplePlayer waveSamplePlayer;
    private final FileSamplePlayer fileSamplePlayer;
    private final String name;
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_PHONE;
    private volatile int wavePlayerState = -1;
    private volatile boolean connectionActive;

    PhoneRingtoneVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, 1000025, 1000075);
        this.name = "PhoneRingtoneVolumeRange";
        this.waveSamplePlayer = new RingtoneSamplePlayer(this.env);
        this.fileSamplePlayer = new FileSamplePlayer(this.env);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1000097);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, "PhoneRingtoneVolumeRange");
    }

    PhoneRingtoneVolumeRange(VolumeRangeManager volumeRangeManager, int n) {
        super(volumeRangeManager, n, 1000075);
        this.name = "PhoneRingtoneVolumeRange";
        this.waveSamplePlayer = new RingtoneSamplePlayer(this.env);
        this.fileSamplePlayer = new FileSamplePlayer(this.env);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1000097);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, "PhoneRingtoneVolumeRange");
    }

    protected void setUserDefinedRingtone(String string, String string2) {
        this.fileSamplePlayer.setUserDefinedRingtone(string, string2);
    }

    protected String getName() {
        return "PhoneRingtoneVolumeRange";
    }

    protected int getID() {
        return 3;
    }

    protected void registerService(Object object) {
        if (object instanceof IMediaFilePlayerService) {
            this.fileSamplePlayer.registerService(object);
        } else if (object instanceof WavePlayer) {
            RingTonePlayer ringTonePlayer = ((WavePlayer)object).getRingTonePlayer();
            if (ringTonePlayer != null) {
                this.waveSamplePlayer.registerService(ringTonePlayer);
                ringTonePlayer.setListener(new WavePlayerListenerImpl());
            }
        } else if (object instanceof PhoneService) {
            this.waveSamplePlayer.registerService(object);
        } else {
            this.env.lcMain.log(10000, "Unsupported serviced registered: %1", object);
        }
    }

    protected void deregisterService(Object object) {
        if (object instanceof IMediaService) {
            this.fileSamplePlayer.deregisterService(object);
        } else if (object instanceof WavePlayer) {
            this.waveSamplePlayer.deregisterService(object);
        } else if (object instanceof PhoneService) {
            this.waveSamplePlayer.deregisterService(object);
        } else {
            this.env.lcMain.log(10000, "Unsupported serviced unregistered: %1", object);
        }
    }

    protected ISamplePlayer getSamplePlayer() {
        switch (this.scenario) {
            case 2: {
                return this.waveSamplePlayer;
            }
            case 3: {
                return this.fileSamplePlayer;
            }
        }
        return NullSamplePlayer.getInstance();
    }

    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }

    protected void entered() {
        this.env.lcMain.log(10000000, "[PhoneRingtoneVolumeRange.entered] audioScenario:%1", (long)this.scenario);
        super.entered();
    }

    protected void requestMenuConnection() {
        super.requestMenuConnection();
        if (this.scenario == 3) {
            this.getSamplePlayer().play();
        }
    }

    protected void releaseMenuConnection() {
        super.releaseMenuConnection();
        if (this.scenario == 3) {
            this.env.lcMain.log(10000000, "[PhoneRingtoneVolumeRange.releaseMenuConnection] audioscenario: %1", (long)this.scenario);
            this.getSamplePlayer().stop();
        }
    }

    protected void audible(boolean bl) {
        if (this.scenario == 3) {
            this.env.lcMain.log(10000000, "[PhoneRingtoneVolumeRange.audible] audioscenario: %1, do nothing", (long)this.scenario);
            return;
        }
        this.connectionActive = bl;
        super.audible(bl);
        this.fadeToConnection();
    }

    private void fadeToConnection() {
        int n = this.getForegroundConnection();
        if (n == 87 && this.wavePlayerState == 0 && this.connectionActive) {
            this.env.lcHMI.log(1000000, "[PhoneRingtoneVolumeRange.fadeToConnection] outbandringing connection: %1 wavePlayerState: %2 ", (long)n, (long)this.wavePlayerState);
            this.audioService.fadeToConnection(0, n);
        } else if (n == 91 && this.connectionActive) {
            this.env.lcHMI.log(1000000, "[PhoneRingtoneVolumeRange.fadeToConnection] individual/mp3 ringing connectionActive: %1 connection: %2  ", this.connectionActive, (long)n);
            this.audioService.fadeToConnection(0, n);
        } else {
            this.env.lcHMI.log(1000000, "[PhoneRingtoneVolumeRange.fadeToConnection] do not fadeTo connection: %1 wavePlayerState: %2 ", (long)n, (long)this.wavePlayerState);
        }
    }

    private class WavePlayerListenerImpl
    implements WavePlayerListener {
        private WavePlayerListenerImpl() {
        }

        public void state(int n) {
            int n2 = PhoneRingtoneVolumeRange.this.getForegroundConnection();
            int n3 = PhoneRingtoneVolumeRange.this.audioService.getDSI().getStatus(n2);
            PhoneRingtoneVolumeRange.this.wavePlayerState = n;
            PhoneRingtoneVolumeRange.this.env.lcHMI.log(10000000, "[PhoneRingtoneVolumeRange.state]  waveplayer status:%1,  connection: %2 , connectionstate: %3", (long)n, (long)n2, (long)n3);
            if (n3 == 3) {
                PhoneRingtoneVolumeRange.this.env.lcHMI.log(10000000, "[PhoneRingtoneVolumeRange.state]  connection: %1 , connectionstate: %2 CONN_START_REQUESTED do not call fadeToConnectioin", (long)n2, (long)n3);
                return;
            }
            PhoneRingtoneVolumeRange.this.fadeToConnection();
        }

        public void playToneInfo(int n) {
        }
    }
}

