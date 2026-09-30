/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.IActiveSourceListener;
import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.audio.NullAudioFocusManager;
import de.audi.atip.log.LogChannel;
import java.util.Hashtable;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class AudioFocusSyncer
extends AbstractMediaTerminalComponent
implements IActiveSourceListener {
    private static final String LOGCLASS = "AudioFocusSyncer";
    protected final LogChannel log;
    private volatile ServiceRegistration audioFocusClientRegistration;
    volatile IAudioFocusManager audioFocusManager;
    private final IServiceTracker audioFocusManagerTracker;
    protected final int[] audioFocusOnTerminal = new int[8];
    private final Object audioFocusMutex = new Object();
    private final int[] syncApplications;
    protected final int audioFocusMasterTerminalId;
    protected final int audioFocusSlaveTerminalId;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusManager;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusClient;

    public AudioFocusSyncer(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.audioFocusMasterTerminalId = 2;
        this.audioFocusSlaveTerminalId = 0;
        this.audioFocusManager = new NullAudioFocusManager(iMediaTerminal.getLogger().audio());
        this.log = iMediaTerminal.getLogger().audio();
        this.syncApplications = iMediaTerminal.getConfiguration().isTVinMedia() ? new int[]{2, 38} : new int[]{1, 38};
        this.audioFocusManagerTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$audio$IAudioFocusManager == null ? (class$de$audi$atip$audio$IAudioFocusManager = AudioFocusSyncer.class$("de.audi.atip.audio.IAudioFocusManager")) : class$de$audi$atip$audio$IAudioFocusManager, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                AudioFocusSyncer.this.log.log(1000000, "[%1.addingService] Audio focus manager found.", (Object)AudioFocusSyncer.LOGCLASS);
                AudioFocusSyncer.this.audioFocusManager = (IAudioFocusManager)AudioFocusSyncer.this.getTerminal().getServiceManager().getService(serviceReference);
                return AudioFocusSyncer.this.audioFocusManager;
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                AudioFocusSyncer.this.log.log(1000000, "[%1.addingService] Audio focus manager removed", (Object)AudioFocusSyncer.LOGCLASS);
                AudioFocusSyncer.this.audioFocusManager = new NullAudioFocusManager(AudioFocusSyncer.this.log);
                AudioFocusSyncer.this.getTerminal().getServiceManager().releaseService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
    }

    public void init() {
        this.log.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.audioFocusClientRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$audio$IAudioFocusClient == null ? (class$de$audi$atip$audio$IAudioFocusClient = AudioFocusSyncer.class$("de.audi.atip.audio.IAudioFocusClient")) : class$de$audi$atip$audio$IAudioFocusClient, new IAudioFocusClient(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void updateAudioFocus(int n, int n2) {
                AudioFocusSyncer.this.log.log(1000000, "[%1.updateAudioFocus] tId=%2, appid=%3", (Object)AudioFocusSyncer.LOGCLASS, (long)n, (long)n2);
                Object object = AudioFocusSyncer.this.audioFocusMutex;
                synchronized (object) {
                    if (0 == n) {
                        AudioFocusSyncer.this.synchronizeAudioFocus(0, 2, n2);
                    } else if (2 == n) {
                        AudioFocusSyncer.this.synchronizeAudioFocus(2, 0, n2);
                    }
                }
            }
        }, new Hashtable(0));
        this.audioFocusManagerTracker.open();
        this.getTerminal().getSourceController().addActiveSourceListener(this);
    }

    public void deinit() {
        this.log.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.getTerminal().getSourceController().removeActiveSourceListener(this);
        this.audioFocusClientRegistration.unregister();
        this.audioFocusManagerTracker.close();
    }

    public void requestAudioFocus(int n) {
        this.log.log(1000000, "[%1.requestAudioFocus] %2", (Object)LOGCLASS, (long)n);
        this.audioFocusManager.setActiveAudioApp(0, n);
    }

    public void requestAudioFocus(int n, int n2) {
        this.log.log(1000000, "[%1.requestAudioFocus] %2 %3", (Object)LOGCLASS, (long)n, (long)n2);
        this.audioFocusManager.setActiveAudioApp(n2, n);
    }

    private void synchronizeAudioFocus(int n, int n2, int n3) {
        if (this.syncApplicationContains(n3) && this.syncApplicationContains(this.audioFocusOnTerminal[n2]) && this.audioFocusOnTerminal[n2] != n3) {
            this.log.log(100000000, "[%1.synchronizeAudioFocus] tId=%2, appid=%3", (Object)LOGCLASS, (long)n2, (long)n3);
            this.requestAudioFocus(n3, n2);
        }
        this.audioFocusOnTerminal[n] = n3;
    }

    private boolean syncApplicationContains(int n) {
        for (int i2 = 0; i2 < this.syncApplications.length; ++i2) {
            if (this.syncApplications[i2] != n) continue;
            return true;
        }
        return false;
    }

    public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
        this.log.log(10000000, "[%1.activeSourceChanged]", (Object)LOGCLASS);
        if (bl) {
            int n = activeSourceState.getSlot().getSource().getType();
            if (8 == n || 7 == n) {
                return;
            }
            if (this.audioFocusOnTerminal[2] == 38) {
                this.requestAudioFocus(2, 2);
            } else if (this.audioFocusOnTerminal[0] == 38) {
                this.requestAudioFocus(2, 0);
            }
        }
    }

    public void sourceDeactivated() {
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

