/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online;

import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.content.IContentManager;
import de.audi.app.media.content.media.online.AbstractOnlinePlayerControllerJob;
import de.audi.app.media.content.media.online.DiagOnlinePlayerSession;
import de.audi.app.media.content.media.online.IOnlinePlayerController;
import de.audi.app.media.content.media.online.OnlinePlayerController$1;
import de.audi.app.media.content.media.online.OnlinePlayerController$2;
import de.audi.app.media.content.media.online.OnlinePlayerController$3;
import de.audi.app.media.content.media.online.OnlinePlayerSession;
import de.audi.app.media.content.media.online.content.IOnlinePlayerListener;
import de.audi.app.media.content.media.online.content.OnlineContent;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.interapp.media.IMediaOnlinePlayerService;
import de.audi.atip.interapp.media.IMediaOnlinePlayerSession;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.osgi.framework.ServiceRegistration;

public class OnlinePlayerController
implements IMediaOnlinePlayerService,
IOnlinePlayerController,
IContentListener,
IOnlinePlayerListener,
IDiagnosisCommandProvider {
    private static final String LOGCLASS;
    private static final String DIAG_CLOSE_SESSION;
    private static final String DIAG_OPEN_SESSION;
    private static final String DIAG_RESUME;
    private static final String DIAG_PAUSE;
    private static final String DIAG_UPDATE_TRACK_DATA;
    private static final String DIAG_SKIP;
    private static final String DIAG_SEEK;
    private static final String DIAG_SEEK_TO_TIME;
    private static final String DIAG_REPEAT_TITLE;
    private static final String DIAG_SHUFFLE;
    private final LogChannel logger;
    private final ISourceController sourceController;
    private final IContentManager contentManager;
    private final DispatcherBase mediaDispatcher;
    private final IServiceManager serviceManager;
    private final IDiagnosisManager diagManager;
    private final AbstractOnlinePlayerControllerJob EMPTY_JOB;
    private final Queue queue;
    private final Map diagSessions;
    private OnlinePlayerSession activeSession;
    private OnlineContent onlinePlayerContent;
    private ServiceRegistration serviceRegistration;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaOnlinePlayerService;

    public OnlinePlayerController(LogChannel logChannel, ISourceController iSourceController, IContentManager iContentManager, IServiceManager iServiceManager, IDiagnosisManager iDiagnosisManager, DispatcherBase dispatcherBase) {
        this.logger = logChannel;
        this.queue = new Queue(logChannel, "ONLINECONTROLLER");
        this.sourceController = iSourceController;
        this.contentManager = iContentManager;
        this.mediaDispatcher = dispatcherBase;
        this.serviceManager = iServiceManager;
        this.diagManager = iDiagnosisManager;
        this.diagSessions = new HashMap();
        this.EMPTY_JOB = new OnlinePlayerController$1(this, this.logger, "EMPTY");
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"OnlinePlayerController");
        this.queue.reset();
        this.contentManager.addContentListener(this);
        this.serviceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$media$IMediaOnlinePlayerService == null ? (class$de$audi$atip$interapp$media$IMediaOnlinePlayerService = OnlinePlayerController.class$("de.audi.atip.interapp.media.IMediaOnlinePlayerService")) : class$de$audi$atip$interapp$media$IMediaOnlinePlayerService, this, new Hashtable(0));
        this.diagManager.addCommandProvider(-1, this);
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"OnlinePlayerController");
        this.serviceManager.unregisterService(this.serviceRegistration);
        this.queue.reset();
    }

    @Override
    public void open(IMediaOnlinePlayerSession iMediaOnlinePlayerSession) {
        if (iMediaOnlinePlayerSession == null) {
            throw new IllegalArgumentException("Session is null.");
        }
        this.logger.log(1078071040, "[%1.open] '%2'", (Object)"OnlinePlayerController", (Object)iMediaOnlinePlayerSession.getServiceID());
        OnlinePlayerController onlinePlayerController = this;
        this.mediaDispatcher.execute(new OnlinePlayerController$2(this, "OnlinePlayerController.open", onlinePlayerController, iMediaOnlinePlayerSession));
    }

    @Override
    public void close(IMediaOnlinePlayerSession iMediaOnlinePlayerSession) {
        if (iMediaOnlinePlayerSession == null) {
            throw new IllegalArgumentException("Session is null.");
        }
        this.logger.log(1078071040, "[%1.close] [%2]", (Object)"OnlinePlayerController", (Object)iMediaOnlinePlayerSession.getName());
        OnlinePlayerController onlinePlayerController = this;
        this.mediaDispatcher.execute(new OnlinePlayerController$3(this, "OnlinePlayerController.close", onlinePlayerController, iMediaOnlinePlayerSession));
    }

    @Override
    public OnlinePlayerSession getActiveSession() {
        return this.activeSession;
    }

    @Override
    public boolean isActiveSession(OnlinePlayerSession onlinePlayerSession) {
        return this.activeSession != null && this.activeSession.equals(onlinePlayerSession);
    }

    private boolean isActive() {
        return this.onlinePlayerContent != null;
    }

    @Override
    public void attachSession(OnlinePlayerSession onlinePlayerSession) {
        this.logger.log(1078071040, "[%1.attachSession] '%2'", (Object)"OnlinePlayerController", (Object)onlinePlayerSession);
        if (!this.isActive()) {
            return;
        }
        this.onlinePlayerContent.attachSession(onlinePlayerSession);
        this.activeSession = onlinePlayerSession;
    }

    @Override
    public void detachActiveSession() {
        this.logger.log(1078071040, "[%1.detachActiveSession]", (Object)"OnlinePlayerController");
        this.activeSession = null;
        this.onlinePlayerContent.detachSession(this);
    }

    private AbstractOnlinePlayerControllerJob getRunningJob() {
        AbstractOnlinePlayerControllerJob abstractOnlinePlayerControllerJob = (AbstractOnlinePlayerControllerJob)this.queue.getRunningJob();
        return abstractOnlinePlayerControllerJob != null ? abstractOnlinePlayerControllerJob : this.EMPTY_JOB;
    }

    @Override
    public void contentActivated(IContent iContent, ISourceSlot iSourceSlot) {
        if (iContent.getContentType() != 8) {
            return;
        }
        this.logger.log(1078071040, "[%1.contentActivated]", (Object)"OnlinePlayerController");
        this.onlinePlayerContent = (OnlineContent)iContent;
        this.getRunningJob().onOnlineContentActivated();
    }

    @Override
    public void contentDeactivated(IContent iContent) {
        if (iContent.getContentType() != 8) {
            return;
        }
        this.logger.log(1078071040, "[%1.contentDeactivated]", (Object)"OnlinePlayerController");
        if (this.activeSession != null) {
            this.logger.log(1078071040, "[%1.contentDeactivated] Active session exists. Close it.", (Object)"OnlinePlayerController");
            this.activeSession.onClose();
            this.activeSession = null;
        }
        this.onlinePlayerContent = null;
    }

    @Override
    public void contentActivationFinished(IContent iContent) {
    }

    @Override
    public void sessionAttached() {
    }

    @Override
    public void sessionDettached() {
        this.logger.log(1078071040, "[%1.sessionDettached]", (Object)"OnlinePlayerController");
        this.getRunningJob().onActiveSessionDetached();
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"OnlinePlayer.open(session|audioConn|type|url)", "OnlinePlayer.close(session)", "OnlinePlayer.pause(session)", "OnlinePlayer.resume(session)", "OnlinePlayer.updatePlayingTrack(session|title|album|artist)", "OnlinePlayer.seek(session|forward)", "OnlinePlayer.seekToTime(session|time)", "OnlinePlayer.skip(session|count)", "OnlinePlayer.shuffle(session|shuffle)", "OnlinePlayer.repeatTitle(session|repeat)"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if ("OnlinePlayer.open(session|audioConn|type|url)".equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = new DiagOnlinePlayerSession(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]), stringArray[0], stringArray[3]);
            if (this.diagSessions.get(diagOnlinePlayerSession.getName()) != null) {
                return;
            }
            this.diagSessions.put(diagOnlinePlayerSession.getName(), diagOnlinePlayerSession);
            this.open(diagOnlinePlayerSession);
        } else if ("OnlinePlayer.close(session)".equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            this.close(diagOnlinePlayerSession);
            this.diagSessions.remove(diagOnlinePlayerSession);
        } else if ("OnlinePlayer.pause(session)".equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.pause();
        } else if ("OnlinePlayer.resume(session)".equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.resume();
        } else if ("OnlinePlayer.updatePlayingTrack(session|title|album|artist)".equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.updateTrackData(stringArray[1], stringArray[2], stringArray[3]);
        } else if ("OnlinePlayer.skip(session|count)".equals(string)) {
            int n = Integer.parseInt(stringArray[1]);
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.skip(n);
        } else if ("OnlinePlayer.seek(session|forward)".equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.seek(Boolean.valueOf(stringArray[1]));
        } else if ("OnlinePlayer.seekToTime(session|time)".equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            int n = Integer.parseInt(stringArray[1]);
            diagOnlinePlayerSession.seekToTime(n);
        } else if ("OnlinePlayer.repeatTitle(session|repeat)".equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.repeatTitle(Boolean.valueOf(stringArray[1]));
        } else if ("OnlinePlayer.shuffle(session|shuffle)".equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.shuffle(Boolean.valueOf(stringArray[1]));
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("OnlinePlayerController").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void addSessionToPendingList(OnlinePlayerSession onlinePlayerSession) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(OnlinePlayerController onlinePlayerController) {
        return onlinePlayerController.logger;
    }

    static /* synthetic */ ISourceController access$100(OnlinePlayerController onlinePlayerController) {
        return onlinePlayerController.sourceController;
    }

    static /* synthetic */ IContentManager access$200(OnlinePlayerController onlinePlayerController) {
        return onlinePlayerController.contentManager;
    }

    static /* synthetic */ Queue access$300(OnlinePlayerController onlinePlayerController) {
        return onlinePlayerController.queue;
    }
}

