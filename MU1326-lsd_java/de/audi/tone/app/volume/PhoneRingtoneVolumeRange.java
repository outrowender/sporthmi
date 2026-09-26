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
import de.audi.tone.app.volume.AbstractPhoneVolumeRange;
import de.audi.tone.app.volume.PhoneRingtoneVolumeRange$WavePlayerListenerImpl;
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
        super(volumeRangeManager, 1497501440, -1958605056);
        this.name = "PhoneRingtoneVolumeRange";
        this.waveSamplePlayer = new RingtoneSamplePlayer(this.env);
        this.fileSamplePlayer = new FileSamplePlayer(this.env);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-1589506304);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, "PhoneRingtoneVolumeRange");
    }

    PhoneRingtoneVolumeRange(VolumeRangeManager volumeRangeManager, int n) {
        super(volumeRangeManager, n, -1958605056);
        this.name = "PhoneRingtoneVolumeRange";
        this.waveSamplePlayer = new RingtoneSamplePlayer(this.env);
        this.fileSamplePlayer = new FileSamplePlayer(this.env);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-1589506304);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, "PhoneRingtoneVolumeRange");
    }

    @Override
    protected void setUserDefinedRingtone(String string, String string2) {
        this.fileSamplePlayer.setUserDefinedRingtone(string, string2);
    }

    @Override
    protected String getName() {
        return "PhoneRingtoneVolumeRange";
    }

    @Override
    protected int getID() {
        return 3;
    }

    @Override
    protected void registerService(Object object) {
        if (object instanceof IMediaFilePlayerService) {
            this.fileSamplePlayer.registerService(object);
        } else if (object instanceof WavePlayer) {
            RingTonePlayer ringTonePlayer = ((WavePlayer)object).getRingTonePlayer();
            if (ringTonePlayer != null) {
                this.waveSamplePlayer.registerService(ringTonePlayer);
                ringTonePlayer.setListener(new PhoneRingtoneVolumeRange$WavePlayerListenerImpl(this, null));
            }
        } else if (object instanceof PhoneService) {
            this.waveSamplePlayer.registerService(object);
        } else {
            this.env.lcMain.log(10000, "Unsupported serviced registered: %1", object);
        }
    }

    @Override
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

    @Override
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

    @Override
    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }

    @Override
    protected void entered() {
        this.env.lcMain.log(-2137614336, "[PhoneRingtoneVolumeRange.entered] audioScenario:%1", (long)this.scenario);
        super.entered();
    }

    @Override
    protected void requestMenuConnection() {
        super.requestMenuConnection();
        if (this.scenario == 3) {
            this.getSamplePlayer().play();
        }
    }

    @Override
    protected void releaseMenuConnection() {
        super.releaseMenuConnection();
        if (this.scenario == 3) {
            this.env.lcMain.log(-2137614336, "[PhoneRingtoneVolumeRange.releaseMenuConnection] audioscenario: %1", (long)this.scenario);
            this.getSamplePlayer().stop();
        }
    }

    @Override
    protected void audible(boolean bl) {
        if (this.scenario == 3) {
            this.env.lcMain.log(-2137614336, "[PhoneRingtoneVolumeRange.audible] audioscenario: %1, do nothing", (long)this.scenario);
            return;
        }
        this.connectionActive = bl;
        super.audible(bl);
        this.fadeToConnection();
    }

    private void fadeToConnection() {
        int n = this.getForegroundConnection();
        if (n == 87 && this.wavePlayerState == 0 && this.connectionActive) {
            this.env.lcHMI.log(1078071040, "[PhoneRingtoneVolumeRange.fadeToConnection] outbandringing connection: %1 wavePlayerState: %2 ", (long)n, (long)this.wavePlayerState);
            this.audioService.fadeToConnection(0, n);
        } else if (n == 91 && this.connectionActive) {
            this.env.lcHMI.log(1078071040, "[PhoneRingtoneVolumeRange.fadeToConnection] individual/mp3 ringing connectionActive: %1 connection: %2  ", this.connectionActive, (long)n);
            this.audioService.fadeToConnection(0, n);
        } else {
            this.env.lcHMI.log(1078071040, "[PhoneRingtoneVolumeRange.fadeToConnection] do not fadeTo connection: %1 wavePlayerState: %2 ", (long)n, (long)this.wavePlayerState);
        }
    }

    static /* synthetic */ int access$102(PhoneRingtoneVolumeRange phoneRingtoneVolumeRange, int n) {
        phoneRingtoneVolumeRange.wavePlayerState = n;
        return phoneRingtoneVolumeRange.wavePlayerState;
    }

    static /* synthetic */ void access$200(PhoneRingtoneVolumeRange phoneRingtoneVolumeRange) {
        phoneRingtoneVolumeRange.fadeToConnection();
    }
}

