/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.folderbrowsing.IFolderNavigatorObserver;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.readout.CoreReadableProvider;
import de.audi.app.messaging.core.readout.IMessageReaderObserver;
import de.audi.app.messaging.core.readout.IReadable;
import de.audi.app.messaging.core.readout.IReadableProvider;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.tghu.tts.TTSStringUtil;
import de.esolutions.fw.util.commons.Buffer;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class MessageReader
extends AbstractMessagingComponent
implements TTSListener,
IDiagProvider {
    public static final int READOUT_STATE_UNAVAILABLE = 0;
    public static final int READOUT_STATE_IDLE = 1;
    public static final int READOUT_STATE_PAUSED_RESUMABLE = 2;
    public static final int READOUT_STATE_PAUSED_NOT_RESUMABLE = 4;
    public static final int READOUT_STATE_READING = 3;
    private static final int SESSION_STATE_INACTIVE = 0;
    private static final int SESSION_STATE_PAUSED = 1;
    private static final int SESSION_STATE_ACTIVE = 2;
    private static final int READOUT_SK_START = 0;
    private static final int READOUT_SK_STOP = 1;
    private final CopyOnWriteArrayList messageReaderObservers = new CopyOnWriteArrayList();
    private volatile TTSSessionBasedService ttsService;
    private final CoreReadableProvider coreReadableProvider;
    private volatile IReadableProvider readableProvider;
    private volatile IReadable readable = IReadable.EMPTY_READABLE;
    private volatile boolean isAudioAvailable = false;
    private volatile int readoutState = 0;
    private volatile boolean isReadingOut = false;
    private volatile boolean isSessionStarted = false;
    private volatile int sessionState = 0;
    private volatile boolean speakOnSessionResumed = false;
    private volatile boolean isInTransition = false;
    private volatile boolean isReadoutPermitted = false;
    private volatile boolean isReadoutFromTheBeginRequired = false;
    private volatile boolean isLongKeyPressed = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSService;

    public MessageReader(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.coreReadableProvider = new CoreReadableProvider(messagingBundleContext);
        this.addComponent(this.coreReadableProvider);
        this.setReadableProvider(this.coreReadableProvider);
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MyButtonListener myButtonListener = new MyButtonListener();
        this.framework.getHmiServiceApp().getButtonModel(2200322).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200323).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200318).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200319).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200321).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200320).setButtonListener(myButtonListener);
        abstractMsgApplication.getActionProxyService().addSubscriber(new CoreActionProxy());
        abstractMsgApplication.getFolderNavigator().addObserver(new FolderNavigatorObserver());
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
        this.setIsReadingOut(false);
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            Hashtable hashtable = new Hashtable();
            ((Dictionary)hashtable).put("TTS_CLIENT_ID", TTSService.CLIENT_ID_MESSAGING);
            iServiceRegistry.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = MessageReader.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)this, (Dictionary)hashtable);
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[MessageReader#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = MessageReader.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName());
        serviceFilterBuilder.addProperty("TTS_CLIENT_ID", String.valueOf(TTSService.CLIENT_ID_MESSAGING));
        serviceFilterBuilder.endAnd();
        String string = serviceFilterBuilder.createFilterString();
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                MessageReader.this.setTtsService((TTSSessionBasedService)object);
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                MessageReader.this.clearTtsService();
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    private void setTtsService(TTSSessionBasedService tTSSessionBasedService) {
        this.log.log(10000000, "[MessageReader#setTtsService]");
        this.ttsService = tTSSessionBasedService;
        this.setReadoutKeyActivation();
    }

    private void clearTtsService() {
        this.log.log(10000000, "[MessageReader#clearTtsService]");
        this.ttsService = null;
        this.setIsReadingOut(false);
        this.setSessionState(0);
        this.speakOnSessionResumed = false;
        this.setReadoutKeyActivation();
    }

    private void setReadoutPermitted(final boolean bl) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(10000000, "[MessageReader#setReadoutPermitted] isReadoutPermitted = %1", bl);
                MessageReader.this.isReadoutPermitted = bl;
                MessageReader.this.setReadoutKeyActivation();
            }
        });
    }

    public void addObserver(IMessageReaderObserver iMessageReaderObserver) {
        this.log.log(10000000, "[MessageReader#addObserver] observer = %1", (Object)iMessageReaderObserver);
        this.messageReaderObservers.add(iMessageReaderObserver);
        try {
            iMessageReaderObserver.updateReadoutState(this.readoutState);
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[MessageReader#addObserver]");
        }
    }

    public void setReadableProvider(IReadableProvider iReadableProvider) {
        this.readableProvider = iReadableProvider != null ? iReadableProvider : this.coreReadableProvider;
    }

    public IReadableProvider getReadableProvider() {
        return this.readableProvider;
    }

    public void toggle() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(10000000, "[MessageReader#toggle] A message is currently being read out: %1", MessageReader.this.isReadingOut);
                if (!MessageReader.this.isReadingOut) {
                    IReadable iReadable = MessageReader.this.readableProvider.getReadable();
                    if (iReadable == null) {
                        throw new IllegalStateException("Could not obtain a readable job.");
                    }
                    MessageReader.this.requestReadout(iReadable);
                } else {
                    MessageReader.this.requestAbortReadout();
                }
            }
        });
    }

    public void start() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(10000000, "[MessageReader#start]");
                if (MessageReader.this.getReadoutState() != 1) {
                    throw new IllegalStateException("A message is already being read.");
                }
                IReadable iReadable = MessageReader.this.readableProvider.getReadable();
                if (iReadable == null) {
                    throw new IllegalStateException("Could not obtain a readable job.");
                }
                MessageReader.this.requestReadout(iReadable);
            }
        });
    }

    public void stop() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(10000000, "[MessageReader#stop]");
                if (MessageReader.this.getReadoutState() != 1) {
                    MessageReader.this.requestAbortReadout();
                }
            }
        });
    }

    public void pause() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(10000000, "[MessageReader#pause]");
                MessageReader.this.requestPause();
            }
        });
    }

    public void resume() {
        this.log.log(10000000, "[MessageReader#resume]");
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(10000000, "[MessageReader#resume]");
                MessageReader.this.requestResume();
            }
        });
    }

    public void skipForward() {
        this.log.log(10000000, "[MessageReader#skipForward]");
        throw new UnsupportedOperationException();
    }

    public void skipBackward() {
        this.log.log(10000000, "[MessageReader#skipBackward]");
        throw new UnsupportedOperationException();
    }

    private void requestReadout(IReadable iReadable) {
        this.log.log(1000000, "[MessageReader#requestReadout]");
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        bl = this.ttsService != null;
        bl2 = this.isAudioAvailable;
        bl3 = this.isReadingOut;
        if (bl && bl2 && !bl3) {
            this.setIsInTransition(true);
            this.readable = iReadable;
            if (this.isReadoutFromTheBeginRequired) {
                this.logTtsServiceNull("[MessageReader#requestReadout] after readout restart");
                this.speak();
                this.isReadoutFromTheBeginRequired = false;
            } else {
                this.ttsService.startSession();
            }
            this.setIsReadingOut(true);
        }
        if (!bl) {
            this.logTtsServiceNull("[MessageReader#requestReadout]");
        } else if (!bl2) {
            this.logAudioUnavailable("[MessageReader#requestReadout]");
        } else if (bl3) {
            this.log.log(100000, "[MessageReader#requestReadout] A message is already being read out, ignoring call.");
        }
    }

    private void requestAbortReadout() {
        this.log.log(1000000, "[MessageReader#requestAbortReadout]");
        boolean bl = true;
        boolean bl2 = false;
        if (this.ttsService != null) {
            bl = false;
            bl2 = this.isReadingOut;
            if (bl2) {
                this.setIsInTransition(true);
                if (this.isReadoutFromTheBeginRequired) {
                    this.log.log(1000000, "[MessageReader#requestAbortReadout] after abort readout");
                    this.ttsService.abortSpeaking();
                } else {
                    this.ttsService.stopSession();
                }
            }
        }
        if (bl) {
            this.logTtsServiceNull("[MessageReader#requestAbortReadout]");
        } else if (!bl2) {
            this.log.log(100000, "[MessageReader#requestAbortReadout] Cannot abort, no message is being read out.");
        }
    }

    private void speak() {
        this.log.log(1000000, "[MessageReader#speak]");
        boolean bl = true;
        if (this.ttsService != null && this.isAudioAvailable) {
            byte[] byArray;
            bl = false;
            String string = this.readable != null ? this.readable.nextSpeakTask() : null;
            String string2 = string != null ? String.valueOf(string.length()) : String.valueOf(string);
            try {
                byArray = TTSStringUtil.getBytesDsiEncoding(string);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                Logs.logException(this.log, unsupportedEncodingException, "[MessageReader#speak]");
                byArray = null;
            }
            String string3 = byArray != null ? String.valueOf(byArray.length) : String.valueOf(byArray);
            this.log.log(1000000, "[MessageReader#speak] text.length() = %1, dsiByteLength = %2", (Object)string2, (Object)string3);
            this.ttsService.speak(string);
        }
        if (bl) {
            this.logTtsServiceNull("[MessageReader#speak]");
        } else if (!this.isAudioAvailable) {
            this.logAudioUnavailable("[MessageReader#speak]");
        }
    }

    private void requestPause() {
        this.log.log(1000000, "[MessageReader#requestPause]");
        if (this.ttsService == null) {
            this.logTtsServiceNull("[MessageReader#requestPause]");
        } else {
            this.ttsService.pause();
        }
    }

    public void requestResume() {
        this.log.log(1000000, "[MessageReader#requestResume]");
        if (this.ttsService == null) {
            this.logTtsServiceNull("[MessageReader#requestResume]");
        } else {
            this.ttsService.resume();
        }
    }

    private void signalSessionStarted() {
        this.msgApp.getMessagingReadoutService().notifyTtsSessionStarted();
    }

    private void signalSessionStopped() {
        this.msgApp.getMessagingReadoutService().notifyTtsSessionStopped();
    }

    private void logTtsServiceNull(String string) {
        this.log.log(100000, "%1 TTS service unavailable.", (Object)string);
    }

    private void logAudioUnavailable(String string) {
        this.log.log(100000, "%1 Audio management unavailable.", (Object)string);
    }

    private void setSessionStarted(boolean bl) {
        this.log.log(10000000, "[MessageReader#setSessionStarted] isSessionStarted = %1", bl);
        this.isSessionStarted = bl;
        if (bl) {
            this.signalSessionStarted();
        } else {
            this.signalSessionStopped();
        }
    }

    public void setSessionState(int n) {
        this.log.log(10000000, "[MessageReader#setSessionState] sessionState = %1", (long)n);
        this.sessionState = n;
        if (n == 0) {
            this.setSessionStarted(false);
        } else {
            this.setSessionStarted(true);
        }
    }

    private int getSessionState() {
        return this.sessionState;
    }

    private void setReadoutState(int n) {
        this.log.log(10000000, "[MessageReader#setReadoutState] readoutState = %1", (long)n);
        this.readoutState = n;
        ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(2200317);
        choiceModelApp.setValue(n);
        this.emitUpdateReadoutState(n);
    }

    private int getReadoutState() {
        return this.readoutState;
    }

    private void setIsReadingOut(boolean bl) {
        this.log.log(10000000, "[MessageReader#setIsReadingOut] isReadingOut = %1", bl);
        ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(2200240);
        int n = bl ? 1 : 0;
        this.isReadingOut = bl;
        choiceModelApp.setValue(n);
        this.setReadoutState(bl ? 3 : 1);
    }

    private void setIsInTransition(boolean bl) {
        this.log.log(10000000, "[MessageReader#setIsInTransition] isInTransition = %1", bl);
        this.isInTransition = bl;
        this.setReadoutKeyActivation();
    }

    private void setReadoutKeyActivation() {
        ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(2200215);
        boolean bl = false;
        int n = 0;
        bl = this.isReadoutPermitted && !this.isInTransition && this.ttsService != null && this.isAudioAvailable;
        n = bl ? 1 : 0;
        choiceModelApp.setValue(n);
        if (this.log.isDebug()) {
            Buffer buffer = new Buffer("[MessageReader#setReadoutKeyActivation] ");
            buffer.append("isReadoutPermitted = ").append(this.isReadoutPermitted);
            buffer.append(", isInTransition = ").append(this.isInTransition);
            buffer.append(", ttsService = ").append(this.ttsService);
            buffer.append(", isAudioAvailable = ").append(this.isAudioAvailable);
            buffer.append(", enabling readout key: ").append(bl);
            this.log.log(10000000, buffer.toString());
        }
    }

    private void emitUpdateReadoutState(int n) {
        this.log.log(10000000, "[MessageReader#emitUpdateReadoutState]");
        Iterator iterator = this.messageReaderObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IMessageReaderObserver)iterator.next()).updateReadoutState(n);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[MessageReader#emitUpdateReadoutState]");
            }
        }
    }

    public void audioAvailable(final boolean bl) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(1000000, "[MessageReader#audioAvailable] flag = %1", bl);
                MessageReader.this.isAudioAvailable = bl;
                MessageReader.this.setReadoutKeyActivation();
            }
        });
    }

    public void sessionStarted() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(1000000, "[MessageReader#sessionStarted]");
                MessageReader.this.setSessionState(2);
                MessageReader.this.speak();
            }
        });
    }

    public void sessionPaused() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                if (!MessageReader.this.isSessionStarted) {
                    MessageReader.this.log.log(1000000, "[MessageReader#sessionPaused] Session has been started in paused state. Waiting for session to be resumed.");
                    MessageReader.this.speakOnSessionResumed = true;
                    MessageReader.this.setSessionState(1);
                } else {
                    MessageReader.this.log.log(1000000, "[MessageReader#sessionPaused]");
                }
            }
        });
    }

    public void sessionStopped() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(1000000, "[MessageReader#sessionStopped]");
                MessageReader.this.setSessionState(0);
                MessageReader.this.speakOnSessionResumed = false;
                MessageReader.this.setIsReadingOut(false);
                MessageReader.this.setIsInTransition(false);
            }
        });
    }

    public void speakingFinished() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                if (MessageReader.this.readable != null && MessageReader.this.readable.hasNextSpeakTask()) {
                    MessageReader.this.log.log(1000000, "[MessageReader#speakingFinished] Proceeding with the next speak() task.");
                    MessageReader.this.speak();
                } else {
                    MessageReader.this.log.log(1000000, "[MessageReader#speakingFinished] Read message job done.");
                    boolean bl = true;
                    if (MessageReader.this.ttsService != null) {
                        bl = false;
                        if (MessageReader.this.isSessionStarted) {
                            MessageReader.this.setIsInTransition(true);
                            MessageReader.this.ttsService.stopSession();
                        }
                    }
                    if (bl) {
                        MessageReader.this.logTtsServiceNull("[MessageReader#speakingFinished]");
                    }
                }
            }
        });
    }

    public void speakingPaused() {
        int n = this.getSessionState();
        int n2 = n == 2 ? 2 : 4;
        this.log.log(1000000, "[MessageReader#speakingPaused] getSessionState() = %1, preferredReadoutState = %2", (long)n, (long)n2);
        this.setReadoutState(2);
    }

    public void speakingAborted() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(1000000, "[MessageReader#speakingAborted]");
                boolean bl = true;
                if (MessageReader.this.ttsService != null) {
                    bl = false;
                    if (MessageReader.this.isSessionStarted && !MessageReader.this.isReadoutFromTheBeginRequired) {
                        MessageReader.this.ttsService.stopSession();
                    }
                    if (MessageReader.this.isReadoutFromTheBeginRequired) {
                        MessageReader.this.setIsReadingOut(false);
                        MessageReader.this.start();
                    }
                }
                if (bl) {
                    MessageReader.this.logTtsServiceNull("[MessageReader#speakingAborted]");
                }
            }
        });
    }

    public void sessionResumed() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(1000000, "[MessageReader#sessionResumed]");
                MessageReader.this.setSessionState(2);
                if (MessageReader.this.speakOnSessionResumed) {
                    MessageReader.this.log.log(1000000, "[MessageReader#sessionResumed] Session started in paused state has been resumed. Requesting readout to commence.");
                    MessageReader.this.speakOnSessionResumed = false;
                    MessageReader.this.speak();
                }
            }
        });
    }

    public void speakingFailed() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(1000000, "[MessageReader#speakingFailed]");
                boolean bl = true;
                if (MessageReader.this.ttsService != null) {
                    bl = false;
                    if (MessageReader.this.isSessionStarted) {
                        MessageReader.this.setIsInTransition(true);
                        MessageReader.this.ttsService.stopSession();
                    }
                }
                if (bl) {
                    MessageReader.this.logTtsServiceNull("[MessageReader#speakingFailed]");
                }
            }
        });
    }

    public void speakingStarted() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessageReader.this.log.log(1000000, "[MessageReader#speakingStarted]");
                MessageReader.this.setIsReadingOut(true);
                MessageReader.this.setIsInTransition(false);
            }
        });
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DiagPlugIn()};
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    final class DiagPlugIn
    implements IDiagPlugIn {
        DiagPlugIn() {
        }

        public Object getTtsMarkup() {
            String string = null;
            IReadable iReadable = MessageReader.this.readableProvider.getReadable();
            if (iReadable == null) {
                string = String.valueOf(null);
            } else {
                ArrayList arrayList = new ArrayList(2);
                while (iReadable.hasNextSpeakTask()) {
                    arrayList.add(iReadable.nextSpeakTask());
                }
                string = Arrays.toMultiLineString(arrayList.toArray());
            }
            return string;
        }

        public Object getReadableProvider() {
            return String.valueOf(MessageReader.this.readableProvider);
        }
    }

    private final class CoreActionProxy
    extends DefaultCoreActionProxy
    implements IActionProxySubscriber {
        private CoreActionProxy() {
        }

        public void readoutScreensExited(int n) {
            MessageReader.this.log.log(10000000, "[MessageReader#readoutScreensExited]");
            MessageReader.this.stop();
        }
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            String string;
            switch (n) {
                case 2200322: {
                    string = "readoutStartButton";
                    break;
                }
                case 2200323: {
                    string = "readoutStopButton";
                    break;
                }
                case 2200318: {
                    string = "readoutPauseButton";
                    break;
                }
                case 2200319: {
                    string = "readoutResumeButton";
                    break;
                }
                case 2200321: {
                    string = "readoutSkipForwardButton";
                    break;
                }
                case 2200320: {
                    string = "readoutSkipBackwarButton";
                    break;
                }
                default: {
                    string = "unknown";
                }
            }
            MessageReader.this.log.log(1000000, "[MessageReader#keyTyped] model = %1", (Object)string);
            if (MessageReader.this.isLongKeyPressed) {
                MessageReader.this.isLongKeyPressed = false;
                return;
            }
            if (n == 2200322) {
                MessageReader.this.start();
            } else if (n == 2200323) {
                MessageReader.this.stop();
            } else if (n == 2200318) {
                MessageReader.this.pause();
            } else if (n == 2200319) {
                MessageReader.this.resume();
            } else if (n == 2200321) {
                MessageReader.this.skipForward();
            } else if (n == 2200320) {
                MessageReader.this.skipBackward();
            } else {
                MessageReader.this.log.log(10000, "[MessageReader#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }

        public void keyLongTyped(int n, int n2, int n3) {
            MessageReader.this.log.log(1000000, "[MessageReader#keyLongTyped] model = %1", (long)n);
            if (n == 2200322 || n == 2200323 || n == 2200318 || n == 2200319) {
                MessageReader.this.stop();
                MessageReader.this.isReadoutFromTheBeginRequired = true;
                MessageReader.this.isLongKeyPressed = true;
            }
        }
    }

    private final class FolderNavigatorObserver
    extends IFolderNavigatorObserver.EmptyImplementation {
        private FolderNavigatorObserver() {
        }

        public void indicateFolderChange(boolean bl) {
            MessageReader.this.log.log(10000000, "[MessageReader#indicateFolderChange] inProgress = %1", bl);
            if (!bl) {
                int n = MessageReader.this.msgApp.getFolderNavigator().getCurrentFolder().getHmiFolderType();
                MessageReader.this.setReadoutPermitted(n == 4);
            }
        }
    }
}

