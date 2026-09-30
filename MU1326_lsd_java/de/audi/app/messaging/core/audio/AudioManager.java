/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.audio;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tghu.waveplayer.WavePlayer;
import de.audi.tghu.waveplayer.WavePlayerListener;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class AudioManager
extends AbstractMessagingComponent
implements IMessagingComponent,
HMIAudioServiceListener,
WavePlayerListener {
    private volatile HMIAudioService hmiAudioService;
    private volatile SystemTonePlayer systemTonePlayer;
    private volatile boolean newMessagesAvailable = false;
    private volatile int newMessageToneId = 12;
    private volatile boolean newMessageToneEnabled = true;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$de$audi$tghu$waveplayer$WavePlayer;

    public AudioManager(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getNewMessageIndicationManager().addObserver(new NewMessageIndicationManagerObserver());
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            Hashtable hashtable = new Hashtable();
            ((Dictionary)hashtable).put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_TTS_MESSAGING);
            iServiceRegistry.registerService((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = AudioManager.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (Object)this, (Dictionary)hashtable);
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[AudioManager#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private void setHmiAudioService(HMIAudioService hMIAudioService) {
        this.log.log(10000000, "[AudioManager#setHmiAudioService]");
        this.hmiAudioService = hMIAudioService;
    }

    private void clearHmiAudioService() {
        this.log.log(10000000, "[AudioManager#clearHmiAudioService]");
        this.hmiAudioService = null;
    }

    private void setSystemTonePlayer(SystemTonePlayer systemTonePlayer) {
        this.log.log(10000000, "[AudioManager#setSystemTonePlayer]");
        this.systemTonePlayer = systemTonePlayer;
        if (systemTonePlayer != null) {
            systemTonePlayer.setListener(this);
        }
    }

    private void clearSystemTonePlayer() {
        this.log.log(10000000, "[AudioManager#clearSystemTonePlayer]");
        SystemTonePlayer systemTonePlayer = this.systemTonePlayer;
        this.systemTonePlayer = null;
        if (systemTonePlayer != null) {
            systemTonePlayer.removeListener(this);
        }
    }

    public void setNewMessageToneId(int n) {
        this.newMessageToneId = n;
    }

    public void setNewMessageToneEnabled(boolean bl) {
        this.newMessageToneEnabled = bl;
    }

    private void playNewMessageTone() {
        this.log.log(1000000, "[AudioManager#playNewMessageTone]");
        if (this.hmiAudioService == null) {
            this.log.log(10000, "[AudioManager#playNewMessageTone] Audio service not available.");
        } else {
            this.hmiAudioService.requestConnection(123, 0);
        }
    }

    private void setNewMessagesAvailable() {
        boolean bl = this.msgApp.getNewMessageIndicationManager().newMessagesAvailable();
        this.log.log(1000000, "[AudioManager#setNewMessagesAvailable] newMessageToneEnabled = %1; this.newMessagesAvailable = %2, newMessagesAvailable = %3", this.newMessageToneEnabled, this.newMessagesAvailable, bl);
        if (this.newMessagesAvailable != bl || this.framework.getSysConst(4168) == 7) {
            boolean bl2;
            this.newMessagesAvailable = bl;
            boolean bl3 = bl2 = this.msgApp.getFramework().getHMIService().getChoiceModel(300455).getValue() == 1;
            if (bl && this.newMessageToneEnabled && !bl2) {
                this.playNewMessageTone();
            }
        }
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.beginOr();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = AudioManager.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName());
        serviceFilterBuilder.addProperty("AUDIO_CLIENT_ID", String.valueOf(HMIAudioService.CLIENT_TTS_MESSAGING));
        serviceFilterBuilder.endAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = AudioManager.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName());
        serviceFilterBuilder.endOr();
        String string = serviceFilterBuilder.createFilterString();
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                if (object instanceof HMIAudioService) {
                    AudioManager.this.setHmiAudioService((HMIAudioService)object);
                } else {
                    AudioManager.this.setSystemTonePlayer(((WavePlayer)object).getSystemTonePlayer());
                }
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                if (object instanceof HMIAudioService) {
                    AudioManager.this.clearHmiAudioService();
                } else {
                    AudioManager.this.clearSystemTonePlayer();
                }
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    public void fadedIn(int n, int n2) {
        if (n == 123 && n2 == 0) {
            if (this.systemTonePlayer != null) {
                this.log.log(1000000, "[AudioManager#fadedIn] Playing new message tone with newMessageToneId = %1", (long)this.newMessageToneId);
                this.systemTonePlayer.playTone(0, this.newMessageToneId);
            } else {
                this.log.log(10000, "[AudioManager#fadedIn] SystemTonePlayer not available, releasing audio connection.");
                if (this.hmiAudioService != null) {
                    this.hmiAudioService.releaseConnection(123, 0);
                }
            }
        }
    }

    public void updateAMAvailable(boolean bl) {
        this.log.log(1000000, "[AudioManager#updateAMAvailable] available = %1", bl);
    }

    public void stopConnection(int n, int n2) {
        if (n == 123) {
            this.log.log(1000000, "[AudioManager#stopConnection] connection = %1, hmiTerminal = %2", (long)n, (long)n2);
        }
    }

    public void pauseConnection(int n, int n2) {
        if (n == 123) {
            this.log.log(1000000, "[AudioManager#pauseConnection] connection = %1, hmiTerminal = %2", (long)n, (long)n2);
        }
    }

    public void startConnection(int n, int n2) {
        if (n == 123 && n2 == 0) {
            this.log.log(1000000, "[AudioManager#startConnection] connection = %1, hmiTerminal = %2", (long)n, (long)n2);
            if (this.hmiAudioService == null) {
                this.log.log(10000, "[AudioManager#startConnection] Audio service not available.");
            } else {
                this.hmiAudioService.fadeToConnection(123, 0);
            }
        }
    }

    public void errorConnection(int n, int n2, int n3) {
        if (n == 123) {
            this.log.log(10000, "[AudioManager#errorConnection] connection = %1, hmiTerminal = %2, errorCode = %3", (long)n, (long)n2, (long)n3);
        }
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
    }

    public void state(int n) {
        this.log.log(1000000, "[AudioManager#state] status = %1", (long)n);
        if (n != 0 && this.hmiAudioService != null) {
            this.hmiAudioService.releaseConnection(123, 0);
        }
    }

    public void playToneInfo(int n) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class NewMessageIndicationManagerObserver
    implements INewMessageIndicationManagerObserver {
        private NewMessageIndicationManagerObserver() {
        }

        public void indicateIndicationStateChanged(int n) {
            AudioManager.this.log.log(10000000, "[AudioManager#indicateIndicationStateChanged] stateAspect = %1", (long)n);
            if (n == 0) {
                AudioManager.this.setNewMessagesAvailable();
            }
        }
    }
}

