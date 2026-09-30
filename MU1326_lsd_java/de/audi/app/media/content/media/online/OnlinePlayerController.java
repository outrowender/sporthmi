/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.content.IContentManager;
import de.audi.app.media.content.media.online.AbstractOnlinePlayerControllerJob;
import de.audi.app.media.content.media.online.DiagOnlinePlayerSession;
import de.audi.app.media.content.media.online.IOnlinePlayerController;
import de.audi.app.media.content.media.online.JobSessionClose;
import de.audi.app.media.content.media.online.JobSessionOpen;
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
    private static final String LOGCLASS = "OnlinePlayerController";
    private static final String DIAG_CLOSE_SESSION = "OnlinePlayer.close(session)";
    private static final String DIAG_OPEN_SESSION = "OnlinePlayer.open(session|audioConn|type|url)";
    private static final String DIAG_RESUME = "OnlinePlayer.resume(session)";
    private static final String DIAG_PAUSE = "OnlinePlayer.pause(session)";
    private static final String DIAG_UPDATE_TRACK_DATA = "OnlinePlayer.updatePlayingTrack(session|title|album|artist)";
    private static final String DIAG_SKIP = "OnlinePlayer.skip(session|count)";
    private static final String DIAG_SEEK = "OnlinePlayer.seek(session|forward)";
    private static final String DIAG_SEEK_TO_TIME = "OnlinePlayer.seekToTime(session|time)";
    private static final String DIAG_REPEAT_TITLE = "OnlinePlayer.repeatTitle(session|repeat)";
    private static final String DIAG_SHUFFLE = "OnlinePlayer.shuffle(session|shuffle)";
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
        this.EMPTY_JOB = new AbstractOnlinePlayerControllerJob(this.logger, "EMPTY"){

            public void start() {
            }
        };
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.queue.reset();
        this.contentManager.addContentListener(this);
        this.serviceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$media$IMediaOnlinePlayerService == null ? (class$de$audi$atip$interapp$media$IMediaOnlinePlayerService = OnlinePlayerController.class$("de.audi.atip.interapp.media.IMediaOnlinePlayerService")) : class$de$audi$atip$interapp$media$IMediaOnlinePlayerService, this, new Hashtable(0));
        this.diagManager.addCommandProvider(-1, this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.serviceManager.unregisterService(this.serviceRegistration);
        this.queue.reset();
    }

    public void open(final IMediaOnlinePlayerSession iMediaOnlinePlayerSession) {
        if (iMediaOnlinePlayerSession == null) {
            throw new IllegalArgumentException("Session is null.");
        }
        this.logger.log(1000000, "[%1.open] '%2'", (Object)LOGCLASS, (Object)iMediaOnlinePlayerSession.getServiceID());
        final OnlinePlayerController onlinePlayerController = this;
        this.mediaDispatcher.execute(new AbstractDispatcherRunnable("OnlinePlayerController.open"){

            public void run() {
                OnlinePlayerController.this.queue.enqueue(new JobSessionOpen(OnlinePlayerController.this.logger, onlinePlayerController, OnlinePlayerController.this.sourceController, OnlinePlayerController.this.contentManager, new OnlinePlayerSession(OnlinePlayerController.this.logger, iMediaOnlinePlayerSession)));
            }
        });
    }

    public void close(final IMediaOnlinePlayerSession iMediaOnlinePlayerSession) {
        if (iMediaOnlinePlayerSession == null) {
            throw new IllegalArgumentException("Session is null.");
        }
        this.logger.log(1000000, "[%1.close] [%2]", (Object)LOGCLASS, (Object)iMediaOnlinePlayerSession.getName());
        final OnlinePlayerController onlinePlayerController = this;
        this.mediaDispatcher.execute(new AbstractDispatcherRunnable("OnlinePlayerController.close"){

            public void run() {
                OnlinePlayerController.this.queue.enqueue(new JobSessionClose(OnlinePlayerController.this.logger, onlinePlayerController, iMediaOnlinePlayerSession));
            }
        });
    }

    public OnlinePlayerSession getActiveSession() {
        return this.activeSession;
    }

    public boolean isActiveSession(OnlinePlayerSession onlinePlayerSession) {
        return this.activeSession != null && this.activeSession.equals(onlinePlayerSession);
    }

    private boolean isActive() {
        return this.onlinePlayerContent != null;
    }

    public void attachSession(OnlinePlayerSession onlinePlayerSession) {
        this.logger.log(1000000, "[%1.attachSession] '%2'", (Object)LOGCLASS, (Object)onlinePlayerSession);
        if (!this.isActive()) {
            return;
        }
        this.onlinePlayerContent.attachSession(onlinePlayerSession);
        this.activeSession = onlinePlayerSession;
    }

    public void detachActiveSession() {
        this.logger.log(1000000, "[%1.detachActiveSession]", (Object)LOGCLASS);
        this.activeSession = null;
        this.onlinePlayerContent.detachSession(this);
    }

    private AbstractOnlinePlayerControllerJob getRunningJob() {
        AbstractOnlinePlayerControllerJob abstractOnlinePlayerControllerJob = (AbstractOnlinePlayerControllerJob)this.queue.getRunningJob();
        return abstractOnlinePlayerControllerJob != null ? abstractOnlinePlayerControllerJob : this.EMPTY_JOB;
    }

    public void contentActivated(IContent iContent, ISourceSlot iSourceSlot) {
        if (iContent.getContentType() != 8) {
            return;
        }
        this.logger.log(1000000, "[%1.contentActivated]", (Object)LOGCLASS);
        this.onlinePlayerContent = (OnlineContent)iContent;
        this.getRunningJob().onOnlineContentActivated();
    }

    public void contentDeactivated(IContent iContent) {
        if (iContent.getContentType() != 8) {
            return;
        }
        this.logger.log(1000000, "[%1.contentDeactivated]", (Object)LOGCLASS);
        if (this.activeSession != null) {
            this.logger.log(1000000, "[%1.contentDeactivated] Active session exists. Close it.", (Object)LOGCLASS);
            this.activeSession.onClose();
            this.activeSession = null;
        }
        this.onlinePlayerContent = null;
    }

    public void contentActivationFinished(IContent iContent) {
    }

    public void sessionAttached() {
    }

    public void sessionDettached() {
        this.logger.log(1000000, "[%1.sessionDettached]", (Object)LOGCLASS);
        this.getRunningJob().onActiveSessionDetached();
    }

    public String[] getDiagKeys() {
        return new String[]{DIAG_OPEN_SESSION, DIAG_CLOSE_SESSION, DIAG_PAUSE, DIAG_RESUME, DIAG_UPDATE_TRACK_DATA, DIAG_SEEK, DIAG_SEEK_TO_TIME, DIAG_SKIP, DIAG_SHUFFLE, DIAG_REPEAT_TITLE};
    }

    public void executeDiagCommand(String string, String[] stringArray) {
        if (DIAG_OPEN_SESSION.equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = new DiagOnlinePlayerSession(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]), stringArray[0], stringArray[3]);
            if (this.diagSessions.get(diagOnlinePlayerSession.getName()) != null) {
                return;
            }
            this.diagSessions.put(diagOnlinePlayerSession.getName(), diagOnlinePlayerSession);
            this.open(diagOnlinePlayerSession);
        } else if (DIAG_CLOSE_SESSION.equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            this.close(diagOnlinePlayerSession);
            this.diagSessions.remove(diagOnlinePlayerSession);
        } else if (DIAG_PAUSE.equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.pause();
        } else if (DIAG_RESUME.equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.resume();
        } else if (DIAG_UPDATE_TRACK_DATA.equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.updateTrackData(stringArray[1], stringArray[2], stringArray[3]);
        } else if (DIAG_SKIP.equals(string)) {
            int n = Integer.parseInt(stringArray[1]);
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.skip(n);
        } else if (DIAG_SEEK.equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.seek(Boolean.valueOf(stringArray[1]));
        } else if (DIAG_SEEK_TO_TIME.equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            int n = Integer.parseInt(stringArray[1]);
            diagOnlinePlayerSession.seekToTime(n);
        } else if (DIAG_REPEAT_TITLE.equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.repeatTitle(Boolean.valueOf(stringArray[1]));
        } else if (DIAG_SHUFFLE.equals(string)) {
            DiagOnlinePlayerSession diagOnlinePlayerSession = (DiagOnlinePlayerSession)this.diagSessions.get(stringArray[0]);
            diagOnlinePlayerSession.shuffle(Boolean.valueOf(stringArray[1]));
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

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
}

