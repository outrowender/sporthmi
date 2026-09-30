/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.content.IContentManager;
import de.audi.app.media.content.media.fileplayer.AbstractFilePlayerControllerJob;
import de.audi.app.media.content.media.fileplayer.DiagFilePlayerSession;
import de.audi.app.media.content.media.fileplayer.FilePlayerSession;
import de.audi.app.media.content.media.fileplayer.IFilePlayerController;
import de.audi.app.media.content.media.fileplayer.JobSessionClose;
import de.audi.app.media.content.media.fileplayer.JobSessionOpen;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayerListener;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.interapp.media.IMediaFilePlayerService;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.osgi.framework.ServiceRegistration;

public class FilePlayerController
implements IMediaFilePlayerService,
IContentListener,
IFilePlayerController,
IFilePlayerListener,
IDiagnosisCommandProvider {
    private static final String LOGCLASS = "FilePlayerController";
    private static final String DIAG_CLOSE_SESSION = "FilePlayer.close";
    private static final String DIAG_OPEN_SESSION = "FilePlayer.open";
    private static final String DIAG_PLAY_SESSION = "FilePlayer.playURL";
    private static final String DIAG_RESUME_SESSION = "FilePlayer.resume";
    private static final String DIAG_PAUSE_SESSION = "FilePlayer.pause";
    private static final String DIAG_STOP_SESSION = "FilePlayer.stop";
    private static final String DIAG_VIDEO_SESSION = "FilePlayer.setScaling";
    private static final String DIAG_SEEK_SESSION = "FilePlayer.seek";
    private final LogChannel logger;
    private final ISourceController sourceController;
    private final IContentManager contentManager;
    private final DispatcherBase mediaDispatcher;
    private final IServiceManager serviceManager;
    private final IDiagnosisManager diagManager;
    private final IAudioManager audioManager;
    private final AbstractFilePlayerControllerJob EMPTY_JOB;
    private final Queue filePlayerControllerQueue;
    private final List suspendedSessionList;
    private final Map diagSessions;
    private FilePlayerSession activeSession;
    private FilePlayerContent filePlayerContent;
    private ServiceRegistration serviceRegistration;
    private volatile boolean mutedBeforeFileplayer;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaFilePlayerService;

    public FilePlayerController(LogChannel logChannel, ISourceController iSourceController, IContentManager iContentManager, IServiceManager iServiceManager, IDiagnosisManager iDiagnosisManager, IAudioManager iAudioManager, DispatcherBase dispatcherBase) {
        this.logger = logChannel;
        this.filePlayerControllerQueue = new Queue(logChannel, "FILEPLAYERCONTROLLER");
        this.diagSessions = new HashMap(1);
        this.suspendedSessionList = new ArrayList();
        this.sourceController = iSourceController;
        this.contentManager = iContentManager;
        this.audioManager = iAudioManager;
        this.mediaDispatcher = dispatcherBase;
        this.serviceManager = iServiceManager;
        this.diagManager = iDiagnosisManager;
        this.EMPTY_JOB = new AbstractFilePlayerControllerJob(this.logger, "EMPTY"){

            public void start() {
            }
        };
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.filePlayerControllerQueue.reset();
        this.contentManager.addContentListener(this);
        this.serviceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$media$IMediaFilePlayerService == null ? (class$de$audi$atip$interapp$media$IMediaFilePlayerService = FilePlayerController.class$("de.audi.atip.interapp.media.IMediaFilePlayerService")) : class$de$audi$atip$interapp$media$IMediaFilePlayerService, this, new Hashtable(0));
        this.diagManager.addCommandProvider(-1, this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.serviceManager.unregisterService(this.serviceRegistration);
        this.filePlayerControllerQueue.reset();
    }

    public void open(final IMediaFilePlayerSession iMediaFilePlayerSession) {
        if (iMediaFilePlayerSession == null) {
            throw new IllegalArgumentException("Session is null.");
        }
        this.logger.log(1000000, "[%1.open] '%2'", (Object)LOGCLASS, (Object)iMediaFilePlayerSession.getName());
        final FilePlayerController filePlayerController = this;
        this.mediaDispatcher.execute(new AbstractDispatcherRunnable("FilePlayerController.open"){

            public void run() {
                FilePlayerController.this.filePlayerControllerQueue.enqueue(new JobSessionOpen(FilePlayerController.this.logger, filePlayerController, iMediaFilePlayerSession));
            }
        });
    }

    public void close(final IMediaFilePlayerSession iMediaFilePlayerSession) {
        if (iMediaFilePlayerSession == null) {
            throw new IllegalArgumentException("Session is null.");
        }
        this.logger.log(1000000, "[%1.close] [%2]", (Object)LOGCLASS, (Object)iMediaFilePlayerSession.getName());
        final FilePlayerController filePlayerController = this;
        this.mediaDispatcher.execute(new AbstractDispatcherRunnable("FilePlayerController.close"){

            public void run() {
                FilePlayerController.this.filePlayerControllerQueue.enqueue(new JobSessionClose(FilePlayerController.this.logger, filePlayerController, iMediaFilePlayerSession));
            }
        });
    }

    public FilePlayerSession getActiveSession() {
        return this.activeSession;
    }

    public boolean isActiveSession(FilePlayerSession filePlayerSession) {
        return this.activeSession != null && this.activeSession.equals(filePlayerSession);
    }

    public boolean activateFilePlayer() {
        if (this.isActive()) {
            this.logger.log(1000000, "[%1.activateFilePlayer] Already active.", (Object)LOGCLASS);
            return false;
        }
        this.mutedBeforeFileplayer = this.audioManager.isMuted();
        this.sourceController.activateSource(new ActivationContext(this.sourceController.getSource(4).getSlot(0)));
        return true;
    }

    private boolean isActive() {
        return this.filePlayerContent != null;
    }

    public void attachSession(FilePlayerSession filePlayerSession) {
        this.logger.log(1000000, "[%1.attachSession] '%2'", (Object)LOGCLASS, (Object)filePlayerSession);
        if (!this.isActive()) {
            return;
        }
        this.filePlayerContent.attachSession(filePlayerSession);
        this.activeSession = filePlayerSession;
    }

    public void detachActiveSession() {
        this.logger.log(1000000, "[%1.detachActiveSession]", (Object)LOGCLASS);
        this.activeSession = null;
        this.filePlayerContent.detachSession(this);
    }

    public void restoreLastAudioContext() {
        this.logger.log(1000000, "[%1.restoreLastAudioContext]", (Object)LOGCLASS);
        if (this.mutedBeforeFileplayer) {
            this.audioManager.mute();
        }
        this.sourceController.restorePreviousFilePlayerSource();
    }

    public void releaseAudio() {
        this.logger.log(1000000, "[%1.releaseAudio]", (Object)LOGCLASS);
        this.audioManager.releaseAudio();
    }

    public void addSessionToPendingList(FilePlayerSession filePlayerSession) {
        if (this.suspendedSessionList.contains(filePlayerSession)) {
            this.logger.log(1000000, "[%1.addSessionToPendingList] [%2] Session already pending.", (Object)LOGCLASS, (Object)filePlayerSession);
            return;
        }
        this.logger.log(1000000, "[%1.addSessionToPendingList] [%2]", (Object)LOGCLASS, (Object)filePlayerSession);
        this.suspendedSessionList.add(filePlayerSession);
        filePlayerSession.onSuspend();
    }

    public boolean removeSessionFromPendingList(FilePlayerSession filePlayerSession) {
        this.logger.log(1000000, "[%1.removeSessionFromPendingList] [%2]", (Object)LOGCLASS, (Object)filePlayerSession);
        return this.suspendedSessionList.remove(filePlayerSession);
    }

    public FilePlayerSession removeHighPrioSessionFromPendingList() {
        this.logger.log(1000000, "[%1.removeHighPrioSessionFromPendingList]", (Object)LOGCLASS);
        FilePlayerSession filePlayerSession = null;
        Iterator iterator = this.suspendedSessionList.iterator();
        while (iterator.hasNext()) {
            FilePlayerSession filePlayerSession2 = (FilePlayerSession)iterator.next();
            if (filePlayerSession == null) {
                filePlayerSession = filePlayerSession2;
                continue;
            }
            if (filePlayerSession.getPriority() >= filePlayerSession2.getPriority()) continue;
            filePlayerSession = filePlayerSession2;
        }
        if (filePlayerSession == null) {
            return null;
        }
        this.suspendedSessionList.remove(filePlayerSession);
        return filePlayerSession;
    }

    private AbstractFilePlayerControllerJob getRunningJob() {
        AbstractFilePlayerControllerJob abstractFilePlayerControllerJob = (AbstractFilePlayerControllerJob)this.filePlayerControllerQueue.getRunningJob();
        return abstractFilePlayerControllerJob != null ? abstractFilePlayerControllerJob : this.EMPTY_JOB;
    }

    public void contentActivated(IContent iContent, ISourceSlot iSourceSlot) {
        if (iContent.getContentType() != 7) {
            return;
        }
        this.logger.log(1000000, "[%1.contentActivated]", (Object)LOGCLASS);
        this.filePlayerContent = (FilePlayerContent)iContent;
        this.getRunningJob().onFilePlayerActive();
    }

    public void contentDeactivated(IContent iContent) {
        if (iContent.getContentType() != 7) {
            return;
        }
        this.logger.log(1000000, "[%1.contentDeactivated]", (Object)LOGCLASS);
        this.filePlayerContent = null;
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
        return new String[]{DIAG_OPEN_SESSION, DIAG_CLOSE_SESSION, DIAG_PLAY_SESSION, DIAG_RESUME_SESSION, DIAG_PAUSE_SESSION, DIAG_STOP_SESSION, DIAG_VIDEO_SESSION, DIAG_SEEK_SESSION};
    }

    public void executeDiagCommand(String string, String[] stringArray) {
        if (DIAG_OPEN_SESSION.equals(string)) {
            DiagFilePlayerSession diagFilePlayerSession = new DiagFilePlayerSession(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]), stringArray[0]);
            if (this.diagSessions.get(diagFilePlayerSession.getName()) != null) {
                return;
            }
            this.diagSessions.put(diagFilePlayerSession.getName(), diagFilePlayerSession);
            this.open(diagFilePlayerSession);
        } else if (DIAG_CLOSE_SESSION.equals(string)) {
            DiagFilePlayerSession diagFilePlayerSession = (DiagFilePlayerSession)this.diagSessions.get(stringArray[0]);
            this.close(diagFilePlayerSession);
            this.diagSessions.remove(diagFilePlayerSession.getName());
        } else {
            DiagFilePlayerSession diagFilePlayerSession = (DiagFilePlayerSession)this.diagSessions.get(stringArray[0]);
            if (diagFilePlayerSession == null) {
                return;
            }
            if (DIAG_PLAY_SESSION.equals(string)) {
                diagFilePlayerSession.playURL(stringArray[1]);
            } else if (DIAG_RESUME_SESSION.equals(string)) {
                diagFilePlayerSession.resume();
            } else if (DIAG_PAUSE_SESSION.equals(string)) {
                diagFilePlayerSession.pause();
            } else if (DIAG_STOP_SESSION.equals(string)) {
                diagFilePlayerSession.stop();
            } else if (DIAG_VIDEO_SESSION.equals(string)) {
                diagFilePlayerSession.setVideoScaling();
            } else if (DIAG_SEEK_SESSION.equals(string)) {
                diagFilePlayerSession.seek(Boolean.valueOf(stringArray[1]));
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
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

