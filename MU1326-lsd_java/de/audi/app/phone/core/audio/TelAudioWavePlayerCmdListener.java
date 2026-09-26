/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.app.phone.core.audio.TelAudioCmdDefaultListener;
import de.audi.app.phone.core.audio.TelAudioWavePlayerCmdListener$1;
import de.audi.app.phone.core.audio.TelAudioWavePlayerCmdListener$2;
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

    @Override
    public void init() {
        this.wavePlayerServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = TelAudioWavePlayerCmdListener.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.wavePlayerServiceTracker.openTracker();
    }

    @Override
    public void deinit() {
        if (this.wavePlayerServiceTracker != null) {
            this.wavePlayerServiceTracker.closeTracker();
            this.wavePlayerServiceTracker = null;
        }
    }

    @Override
    public void state(int n) {
        this.log.log(-2137614336, "[TelAudioWavePlayerCmdListener#state] status=%1", (long)n);
        CommandResponse.execute(this, new TelAudioWavePlayerCmdListener$1(this, n));
    }

    @Override
    public void playToneInfo(int n) {
        this.log.log(-2137614336, "[TelAudioWavePlayerCmdListener#playToneInfo] status=%1", (long)n);
        CommandResponse.execute(this, new TelAudioWavePlayerCmdListener$2(this, n));
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.log;
    }

    @Override
    public String getHandlerName() {
        return "TelAudioWavePlayerCmdListener";
    }

    @Override
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
            this.log.log(1078071040, "[TelAudioWavePlayerCmdListener#addingService] WavePlayer=%1", object);
            WavePlayer wavePlayer = (WavePlayer)object;
            if (wavePlayer != null) {
                this.setWavePlayerService(wavePlayer);
            }
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
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
            this.log.log(1078071040, "[TelAudioWavePlayerCmdListener#removedService] WavePlayer=%1", object);
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

    static /* synthetic */ ITelAudioCmdListener access$000(TelAudioWavePlayerCmdListener telAudioWavePlayerCmdListener) {
        return telAudioWavePlayerCmdListener.defaultListener;
    }

    static /* synthetic */ LogChannel access$100(TelAudioWavePlayerCmdListener telAudioWavePlayerCmdListener) {
        return telAudioWavePlayerCmdListener.log;
    }

    static /* synthetic */ LogChannel access$200(TelAudioWavePlayerCmdListener telAudioWavePlayerCmdListener) {
        return telAudioWavePlayerCmdListener.log;
    }
}

