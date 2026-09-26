/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.readout.CoreReadableProvider;
import de.audi.app.messaging.core.readout.IMessageReaderObserver;
import de.audi.app.messaging.core.readout.IReadable;
import de.audi.app.messaging.core.readout.IReadableProvider;
import de.audi.app.messaging.core.readout.MessageReader$1;
import de.audi.app.messaging.core.readout.MessageReader$10;
import de.audi.app.messaging.core.readout.MessageReader$11;
import de.audi.app.messaging.core.readout.MessageReader$12;
import de.audi.app.messaging.core.readout.MessageReader$13;
import de.audi.app.messaging.core.readout.MessageReader$14;
import de.audi.app.messaging.core.readout.MessageReader$15;
import de.audi.app.messaging.core.readout.MessageReader$16;
import de.audi.app.messaging.core.readout.MessageReader$2;
import de.audi.app.messaging.core.readout.MessageReader$3;
import de.audi.app.messaging.core.readout.MessageReader$4;
import de.audi.app.messaging.core.readout.MessageReader$5;
import de.audi.app.messaging.core.readout.MessageReader$6;
import de.audi.app.messaging.core.readout.MessageReader$7;
import de.audi.app.messaging.core.readout.MessageReader$8;
import de.audi.app.messaging.core.readout.MessageReader$9;
import de.audi.app.messaging.core.readout.MessageReader$CoreActionProxy;
import de.audi.app.messaging.core.readout.MessageReader$DiagPlugIn;
import de.audi.app.messaging.core.readout.MessageReader$FolderNavigatorObserver;
import de.audi.app.messaging.core.readout.MessageReader$MyButtonListener;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.TTSStringUtil;
import de.esolutions.fw.util.commons.Buffer;
import java.io.UnsupportedEncodingException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class MessageReader
extends AbstractMessagingComponent
implements TTSListener,
IDiagProvider {
    public static final int READOUT_STATE_UNAVAILABLE;
    public static final int READOUT_STATE_IDLE;
    public static final int READOUT_STATE_PAUSED_RESUMABLE;
    public static final int READOUT_STATE_PAUSED_NOT_RESUMABLE;
    public static final int READOUT_STATE_READING;
    private static final int SESSION_STATE_INACTIVE;
    private static final int SESSION_STATE_PAUSED;
    private static final int SESSION_STATE_ACTIVE;
    private static final int READOUT_SK_START;
    private static final int READOUT_SK_STOP;
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

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MessageReader$MyButtonListener messageReader$MyButtonListener = new MessageReader$MyButtonListener(this, null);
        this.framework.getHmiServiceApp().getButtonModel(43196672).setButtonListener(messageReader$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(59973888).setButtonListener(messageReader$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(-23977728).setButtonListener(messageReader$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(-7200512).setButtonListener(messageReader$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(26419456).setButtonListener(messageReader$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(9642240).setButtonListener(messageReader$MyButtonListener);
        abstractMsgApplication.getActionProxyService().addSubscriber(new MessageReader$CoreActionProxy(this, null));
        abstractMsgApplication.getFolderNavigator().addObserver(new MessageReader$FolderNavigatorObserver(this, null));
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
        this.setIsReadingOut(false);
    }

    @Override
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

    private ServiceTracker createServiceTracker() {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = MessageReader.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName());
        serviceFilterBuilder.addProperty("TTS_CLIENT_ID", String.valueOf(TTSService.CLIENT_ID_MESSAGING));
        serviceFilterBuilder.endAnd();
        String string = serviceFilterBuilder.createFilterString();
        Filter filter = this.bundleContext.createFilter(string);
        MessageReader$1 messageReader$1 = new MessageReader$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)messageReader$1);
    }

    private void setTtsService(TTSSessionBasedService tTSSessionBasedService) {
        this.log.log(-2137614336, "[MessageReader#setTtsService]");
        this.ttsService = tTSSessionBasedService;
        this.setReadoutKeyActivation();
    }

    private void clearTtsService() {
        this.log.log(-2137614336, "[MessageReader#clearTtsService]");
        this.ttsService = null;
        this.setIsReadingOut(false);
        this.setSessionState(0);
        this.speakOnSessionResumed = false;
        this.setReadoutKeyActivation();
    }

    private void setReadoutPermitted(boolean bl) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$2(this, bl));
    }

    public void addObserver(IMessageReaderObserver iMessageReaderObserver) {
        this.log.log(-2137614336, "[MessageReader#addObserver] observer = %1", (Object)iMessageReaderObserver);
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
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$3(this));
    }

    public void start() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$4(this));
    }

    public void stop() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$5(this));
    }

    public void pause() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$6(this));
    }

    public void resume() {
        this.log.log(-2137614336, "[MessageReader#resume]");
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$7(this));
    }

    public void skipForward() {
        this.log.log(-2137614336, "[MessageReader#skipForward]");
        throw new UnsupportedOperationException();
    }

    public void skipBackward() {
        this.log.log(-2137614336, "[MessageReader#skipBackward]");
        throw new UnsupportedOperationException();
    }

    private void requestReadout(IReadable iReadable) {
        this.log.log(1078071040, "[MessageReader#requestReadout]");
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
            this.log.log(-1601830656, "[MessageReader#requestReadout] A message is already being read out, ignoring call.");
        }
    }

    private void requestAbortReadout() {
        this.log.log(1078071040, "[MessageReader#requestAbortReadout]");
        boolean bl = true;
        boolean bl2 = false;
        if (this.ttsService != null) {
            bl = false;
            bl2 = this.isReadingOut;
            if (bl2) {
                this.setIsInTransition(true);
                if (this.isReadoutFromTheBeginRequired) {
                    this.log.log(1078071040, "[MessageReader#requestAbortReadout] after abort readout");
                    this.ttsService.abortSpeaking();
                } else {
                    this.ttsService.stopSession();
                }
            }
        }
        if (bl) {
            this.logTtsServiceNull("[MessageReader#requestAbortReadout]");
        } else if (!bl2) {
            this.log.log(-1601830656, "[MessageReader#requestAbortReadout] Cannot abort, no message is being read out.");
        }
    }

    private void speak() {
        this.log.log(1078071040, "[MessageReader#speak]");
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
            this.log.log(1078071040, "[MessageReader#speak] text.length() = %1, dsiByteLength = %2", (Object)string2, (Object)string3);
            this.ttsService.speak(string);
        }
        if (bl) {
            this.logTtsServiceNull("[MessageReader#speak]");
        } else if (!this.isAudioAvailable) {
            this.logAudioUnavailable("[MessageReader#speak]");
        }
    }

    private void requestPause() {
        this.log.log(1078071040, "[MessageReader#requestPause]");
        if (this.ttsService == null) {
            this.logTtsServiceNull("[MessageReader#requestPause]");
        } else {
            this.ttsService.pause();
        }
    }

    public void requestResume() {
        this.log.log(1078071040, "[MessageReader#requestResume]");
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
        this.log.log(-1601830656, "%1 TTS service unavailable.", (Object)string);
    }

    private void logAudioUnavailable(String string) {
        this.log.log(-1601830656, "%1 Audio management unavailable.", (Object)string);
    }

    private void setSessionStarted(boolean bl) {
        this.log.log(-2137614336, "[MessageReader#setSessionStarted] isSessionStarted = %1", bl);
        this.isSessionStarted = bl;
        if (bl) {
            this.signalSessionStarted();
        } else {
            this.signalSessionStopped();
        }
    }

    public void setSessionState(int n) {
        this.log.log(-2137614336, "[MessageReader#setSessionState] sessionState = %1", (long)n);
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
        this.log.log(-2137614336, "[MessageReader#setReadoutState] readoutState = %1", (long)n);
        this.readoutState = n;
        ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(-40754944);
        choiceModelApp.setValue(n);
        this.emitUpdateReadoutState(n);
    }

    private int getReadoutState() {
        return this.readoutState;
    }

    private void setIsReadingOut(boolean bl) {
        this.log.log(-2137614336, "[MessageReader#setIsReadingOut] isReadingOut = %1", bl);
        ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(-1332600576);
        int n = bl ? 1 : 0;
        this.isReadingOut = bl;
        choiceModelApp.setValue(n);
        this.setReadoutState(bl ? 3 : 1);
    }

    private void setIsInTransition(boolean bl) {
        this.log.log(-2137614336, "[MessageReader#setIsInTransition] isInTransition = %1", bl);
        this.isInTransition = bl;
        this.setReadoutKeyActivation();
    }

    private void setReadoutKeyActivation() {
        ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(-1752030976);
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
            this.log.log(-2137614336, buffer.toString());
        }
    }

    private void emitUpdateReadoutState(int n) {
        this.log.log(-2137614336, "[MessageReader#emitUpdateReadoutState]");
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

    @Override
    public void audioAvailable(boolean bl) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$8(this, bl));
    }

    @Override
    public void sessionStarted() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$9(this));
    }

    @Override
    public void sessionPaused() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$10(this));
    }

    @Override
    public void sessionStopped() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$11(this));
    }

    @Override
    public void speakingFinished() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$12(this));
    }

    @Override
    public void speakingPaused() {
        int n = this.getSessionState();
        int n2 = n == 2 ? 2 : 4;
        this.log.log(1078071040, "[MessageReader#speakingPaused] getSessionState() = %1, preferredReadoutState = %2", (long)n, (long)n2);
        this.setReadoutState(2);
    }

    @Override
    public void speakingAborted() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$13(this));
    }

    @Override
    public void sessionResumed() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$14(this));
    }

    @Override
    public void speakingFailed() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$15(this));
    }

    @Override
    public void speakingStarted() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessageReader$16(this));
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new MessageReader$DiagPlugIn(this)};
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$300(MessageReader messageReader, TTSSessionBasedService tTSSessionBasedService) {
        messageReader.setTtsService(tTSSessionBasedService);
    }

    static /* synthetic */ void access$400(MessageReader messageReader) {
        messageReader.clearTtsService();
    }

    static /* synthetic */ LogChannel access$500(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ boolean access$602(MessageReader messageReader, boolean bl) {
        messageReader.isReadoutPermitted = bl;
        return messageReader.isReadoutPermitted;
    }

    static /* synthetic */ void access$700(MessageReader messageReader) {
        messageReader.setReadoutKeyActivation();
    }

    static /* synthetic */ boolean access$800(MessageReader messageReader) {
        return messageReader.isReadingOut;
    }

    static /* synthetic */ LogChannel access$900(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ IReadableProvider access$1000(MessageReader messageReader) {
        return messageReader.readableProvider;
    }

    static /* synthetic */ void access$1100(MessageReader messageReader, IReadable iReadable) {
        messageReader.requestReadout(iReadable);
    }

    static /* synthetic */ void access$1200(MessageReader messageReader) {
        messageReader.requestAbortReadout();
    }

    static /* synthetic */ LogChannel access$1300(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ int access$1400(MessageReader messageReader) {
        return messageReader.getReadoutState();
    }

    static /* synthetic */ LogChannel access$1500(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ LogChannel access$1600(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ void access$1700(MessageReader messageReader) {
        messageReader.requestPause();
    }

    static /* synthetic */ LogChannel access$1800(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ LogChannel access$1900(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ boolean access$2002(MessageReader messageReader, boolean bl) {
        messageReader.isAudioAvailable = bl;
        return messageReader.isAudioAvailable;
    }

    static /* synthetic */ LogChannel access$2100(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ void access$2200(MessageReader messageReader) {
        messageReader.speak();
    }

    static /* synthetic */ boolean access$2300(MessageReader messageReader) {
        return messageReader.isSessionStarted;
    }

    static /* synthetic */ LogChannel access$2400(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ boolean access$2502(MessageReader messageReader, boolean bl) {
        messageReader.speakOnSessionResumed = bl;
        return messageReader.speakOnSessionResumed;
    }

    static /* synthetic */ LogChannel access$2600(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ LogChannel access$2700(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ void access$2800(MessageReader messageReader, boolean bl) {
        messageReader.setIsReadingOut(bl);
    }

    static /* synthetic */ void access$2900(MessageReader messageReader, boolean bl) {
        messageReader.setIsInTransition(bl);
    }

    static /* synthetic */ IReadable access$3000(MessageReader messageReader) {
        return messageReader.readable;
    }

    static /* synthetic */ LogChannel access$3100(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ LogChannel access$3200(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ TTSSessionBasedService access$3300(MessageReader messageReader) {
        return messageReader.ttsService;
    }

    static /* synthetic */ void access$3400(MessageReader messageReader, String string) {
        messageReader.logTtsServiceNull(string);
    }

    static /* synthetic */ LogChannel access$3500(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ boolean access$3600(MessageReader messageReader) {
        return messageReader.isReadoutFromTheBeginRequired;
    }

    static /* synthetic */ LogChannel access$3700(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ boolean access$2500(MessageReader messageReader) {
        return messageReader.speakOnSessionResumed;
    }

    static /* synthetic */ LogChannel access$3800(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ LogChannel access$3900(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ LogChannel access$4000(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ LogChannel access$4100(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ AbstractMsgApplication access$4200(MessageReader messageReader) {
        return messageReader.msgApp;
    }

    static /* synthetic */ void access$4300(MessageReader messageReader, boolean bl) {
        messageReader.setReadoutPermitted(bl);
    }

    static /* synthetic */ LogChannel access$4400(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ boolean access$4500(MessageReader messageReader) {
        return messageReader.isLongKeyPressed;
    }

    static /* synthetic */ boolean access$4502(MessageReader messageReader, boolean bl) {
        messageReader.isLongKeyPressed = bl;
        return messageReader.isLongKeyPressed;
    }

    static /* synthetic */ LogChannel access$4600(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ LogChannel access$4700(MessageReader messageReader) {
        return messageReader.log;
    }

    static /* synthetic */ boolean access$3602(MessageReader messageReader, boolean bl) {
        messageReader.isReadoutFromTheBeginRequired = bl;
        return messageReader.isReadoutFromTheBeginRequired;
    }

    static /* synthetic */ LogChannel access$4800(MessageReader messageReader) {
        return messageReader.log;
    }
}

