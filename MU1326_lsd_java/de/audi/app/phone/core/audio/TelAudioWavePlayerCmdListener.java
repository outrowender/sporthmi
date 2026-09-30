/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.app.phone.core.audio.TelAudioCmdDefaultListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.waveplayer.RingTonePlayer;
import de.audi.tghu.waveplayer.WavePlayer;
import de.audi.tghu.waveplayer.WavePlayerListener;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelAudioWavePlayerCmdListener
extends AbstractPhoneComponent
implements WavePlayerListener,
ICommandResponseSupplier,
ServiceTrackerCustomizer {
    private volatile PhoneServiceTracker wavePlayerServiceTracker;
    private final ITelAudioCmdListener defaultListener;
    private final CommandListManager cmdListManager;
    private volatile RingTonePlayer ringtonePlayer;
    static /* synthetic */ Class class$de$audi$tghu$waveplayer$WavePlayer;

    public TelAudioWavePlayerCmdListener(ITelApplication iTelApplication, TelAudioCmdDefaultListener telAudioCmdDefaultListener, CommandListManager commandListManager) {
        super(iTelApplication, "App.Phone.Audio");
        this.defaultListener = telAudioCmdDefaultListener;
        this.cmdListManager = commandListManager;
    }

    public void init() {
        this.wavePlayerServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = TelAudioWavePlayerCmdListener.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.wavePlayerServiceTracker.openTracker();
    }

    public void deinit() {
        if (this.wavePlayerServiceTracker != null) {
            this.wavePlayerServiceTracker.closeTracker();
            this.wavePlayerServiceTracker = null;
        }
    }

    public void state(final int n) {
        this.log.log(10000000, "[TelAudioWavePlayerCmdListener#state] status=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ITelAudioCmdListener iTelAudioCmdListener = TelAudioWavePlayerCmdListener.this.defaultListener;
                try {
                    iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    TelAudioWavePlayerCmdListener.this.log.log(10000, "[TelAudioWavePlayerCmdListener#state] %1", (Throwable)classCastException);
                }
                iTelAudioCmdListener.state(n);
            }
        });
    }

    public void playToneInfo(final int n) {
        this.log.log(10000000, "[TelAudioWavePlayerCmdListener#playToneInfo] status=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ITelAudioCmdListener iTelAudioCmdListener = TelAudioWavePlayerCmdListener.this.defaultListener;
                try {
                    iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    TelAudioWavePlayerCmdListener.this.log.log(10000, "[TelAudioWavePlayerCmdListener#playToneInfo] %1", (Throwable)classCastException);
                }
                iTelAudioCmdListener.playToneInfo(n);
            }
        });
    }

    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    public LogChannel getLogChannel() {
        return this.log;
    }

    public String getHandlerName() {
        return "TelAudioWavePlayerCmdListener";
    }

    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "TelAudioWavePlayerCmdListener#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "TelAudioWavePlayerCmdListener#addingService service is null");
            return null;
        }
        if (object instanceof WavePlayer) {
            this.log.log(1000000, "[TelAudioWavePlayerCmdListener#addingService] WavePlayer=%1", object);
            WavePlayer wavePlayer = (WavePlayer)object;
            if (wavePlayer != null) {
                this.setWavePlayerService(wavePlayer);
            }
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (serviceReference == null) {
            this.log.log(10000, "TelAudioWavePlayerCmdListener#removedService reference is null");
            return;
        }
        if (object == null) {
            this.log.log(10000, "TelAudioWavePlayerCmdListener#removedService service is null");
            return;
        }
        if (object instanceof WavePlayer) {
            this.log.log(1000000, "[TelAudioWavePlayerCmdListener#removedService] WavePlayer=%1", object);
            this.getApplication().getBundleContext().ungetService(serviceReference);
            if (this.ringtonePlayer != null) {
                this.ringtonePlayer.removeListener(this);
            }
            this.ringtonePlayer = null;
        }
    }

    void setWavePlayerService(WavePlayer wavePlayer) {
        this.ringtonePlayer = wavePlayer.getRingTonePlayer();
        this.ringtonePlayer.setListener(this);
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

