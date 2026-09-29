/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer;

import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.content.IContentManager;
import de.audi.app.media.content.media.fileplayer.AbstractFilePlayerControllerJob;
import de.audi.app.media.content.media.fileplayer.DiagFilePlayerSession;
import de.audi.app.media.content.media.fileplayer.FilePlayerController$1;
import de.audi.app.media.content.media.fileplayer.FilePlayerController$2;
import de.audi.app.media.content.media.fileplayer.FilePlayerController$3;
import de.audi.app.media.content.media.fileplayer.FilePlayerSession;
import de.audi.app.media.content.media.fileplayer.IFilePlayerController;
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
    private static final String LOGCLASS;
    private static final String DIAG_CLOSE_SESSION;
    private static final String DIAG_OPEN_SESSION;
    private static final String DIAG_PLAY_SESSION;
    private static final String DIAG_RESUME_SESSION;
    private static final String DIAG_PAUSE_SESSION;
    private static final String DIAG_STOP_SESSION;
    private static final String DIAG_VIDEO_SESSION;
    private static final String DIAG_SEEK_SESSION;
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
        this.EMPTY_JOB = new FilePlayerController$1(this, this.logger, "EMPTY");
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"FilePlayerController");
        this.filePlayerControllerQueue.reset();
        this.contentManager.addContentListener(this);
        this.serviceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$media$IMediaFilePlayerService == null ? (class$de$audi$atip$interapp$media$IMediaFilePlayerService = FilePlayerController.class$("de.audi.atip.interapp.media.IMediaFilePlayerService")) : class$de$audi$atip$interapp$media$IMediaFilePlayerService, this, new Hashtable(0));
        this.diagManager.addCommandProvider(-1, this);
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"FilePlayerController");
        this.serviceManager.unregisterService(this.serviceRegistration);
        this.filePlayerControllerQueue.reset();
    }

    @Override
    public void open(IMediaFilePlayerSession iMediaFilePlayerSession) {
        if (iMediaFilePlayerSession == null) {
            throw new IllegalArgumentException("Session is null.");
        }
        this.logger.log(1078071040, "[%1.open] '%2'", (Object)"FilePlayerController", (Object)iMediaFilePlayerSession.getName());
        FilePlayerController filePlayerController = this;
        this.mediaDispatcher.execute(new FilePlayerController$2(this, "FilePlayerController.open", filePlayerController, iMediaFilePlayerSession));
    }

    @Override
    public void close(IMediaFilePlayerSession iMediaFilePlayerSession) {
        if (iMediaFilePlayerSession == null) {
            throw new IllegalArgumentException("Session is null.");
        }
        this.logger.log(1078071040, "[%1.close] [%2]", (Object)"FilePlayerController", (Object)iMediaFilePlayerSession.getName());
        FilePlayerController filePlayerController = this;
        this.mediaDispatcher.execute(new FilePlayerController$3(this, "FilePlayerController.close", filePlayerController, iMediaFilePlayerSession));
    }

    @Override
    public FilePlayerSession getActiveSession() {
        return this.activeSession;
    }

    @Override
    public boolean isActiveSession(FilePlayerSession filePlayerSession) {
        return this.activeSession != null && this.activeSession.equals(filePlayerSession);
    }

    @Override
    public boolean activateFilePlayer() {
        if (this.isActive()) {
            this.logger.log(1078071040, "[%1.activateFilePlayer] Already active.", (Object)"FilePlayerController");
            return false;
        }
        this.mutedBeforeFileplayer = this.audioManager.isMuted();
        this.sourceController.activateSource(new ActivationContext(this.sourceController.getSource(4).getSlot(0)));
        return true;
    }

    private boolean isActive() {
        return this.filePlayerContent != null;
    }

    @Override
    public void attachSession(FilePlayerSession filePlayerSession) {
        this.logger.log(1078071040, "[%1.attachSession] '%2'", (Object)"FilePlayerController", (Object)filePlayerSession);
        if (!this.isActive()) {
            return;
        }
        this.filePlayerContent.attachSession(filePlayerSession);
        this.activeSession = filePlayerSession;
    }

    @Override
    public void detachActiveSession() {
        this.logger.log(1078071040, "[%1.detachActiveSession]", (Object)"FilePlayerController");
        this.activeSession = null;
        this.filePlayerContent.detachSession(this);
    }

    @Override
    public void restoreLastAudioContext() {
        this.logger.log(1078071040, "[%1.restoreLastAudioContext]", (Object)"FilePlayerController");
        if (this.mutedBeforeFileplayer) {
            this.audioManager.mute();
        }
        this.sourceController.restorePreviousFilePlayerSource();
    }

    @Override
    public void releaseAudio() {
        this.logger.log(1078071040, "[%1.releaseAudio]", (Object)"FilePlayerController");
        this.audioManager.releaseAudio();
    }

    @Override
    public void addSessionToPendingList(FilePlayerSession filePlayerSession) {
        if (this.suspendedSessionList.contains(filePlayerSession)) {
            this.logger.log(1078071040, "[%1.addSessionToPendingList] [%2] Session already pending.", (Object)"FilePlayerController", (Object)filePlayerSession);
            return;
        }
        this.logger.log(1078071040, "[%1.addSessionToPendingList] [%2]", (Object)"FilePlayerController", (Object)filePlayerSession);
        this.suspendedSessionList.add(filePlayerSession);
        filePlayerSession.onSuspend();
    }

    @Override
    public boolean removeSessionFromPendingList(FilePlayerSession filePlayerSession) {
        this.logger.log(1078071040, "[%1.removeSessionFromPendingList] [%2]", (Object)"FilePlayerController", (Object)filePlayerSession);
        return this.suspendedSessionList.remove(filePlayerSession);
    }

    @Override
    public FilePlayerSession removeHighPrioSessionFromPendingList() {
        this.logger.log(1078071040, "[%1.removeHighPrioSessionFromPendingList]", (Object)"FilePlayerController");
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

    @Override
    public void contentActivated(IContent iContent, ISourceSlot iSourceSlot) {
        if (iContent.getContentType() != 7) {
            return;
        }
        this.logger.log(1078071040, "[%1.contentActivated]", (Object)"FilePlayerController");
        this.filePlayerContent = (FilePlayerContent)iContent;
        this.getRunningJob().onFilePlayerActive();
    }

    @Override
    public void contentDeactivated(IContent iContent) {
        if (iContent.getContentType() != 7) {
            return;
        }
        this.logger.log(1078071040, "[%1.contentDeactivated]", (Object)"FilePlayerController");
        this.filePlayerContent = null;
    }

    @Override
    public void contentActivationFinished(IContent iContent) {
    }

    @Override
    public void sessionAttached() {
    }

    @Override
    public void sessionDettached() {
        this.logger.log(1078071040, "[%1.sessionDettached]", (Object)"FilePlayerController");
        this.getRunningJob().onActiveSessionDetached();
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"FilePlayer.open", "FilePlayer.close", "FilePlayer.playURL", "FilePlayer.resume", "FilePlayer.pause", "FilePlayer.stop", "FilePlayer.setScaling", "FilePlayer.seek"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if ("FilePlayer.open".equals(string)) {
            DiagFilePlayerSession diagFilePlayerSession = new DiagFilePlayerSession(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]), stringArray[0]);
            if (this.diagSessions.get(diagFilePlayerSession.getName()) != null) {
                return;
            }
            this.diagSessions.put(diagFilePlayerSession.getName(), diagFilePlayerSession);
            this.open(diagFilePlayerSession);
        } else if ("FilePlayer.close".equals(string)) {
            DiagFilePlayerSession diagFilePlayerSession = (DiagFilePlayerSession)this.diagSessions.get(stringArray[0]);
            this.close(diagFilePlayerSession);
            this.diagSessions.remove(diagFilePlayerSession.getName());
        } else {
            DiagFilePlayerSession diagFilePlayerSession = (DiagFilePlayerSession)this.diagSessions.get(stringArray[0]);
            if (diagFilePlayerSession == null) {
                return;
            }
            if ("FilePlayer.playURL".equals(string)) {
                diagFilePlayerSession.playURL(stringArray[1]);
            } else if ("FilePlayer.resume".equals(string)) {
                diagFilePlayerSession.resume();
            } else if ("FilePlayer.pause".equals(string)) {
                diagFilePlayerSession.pause();
            } else if ("FilePlayer.stop".equals(string)) {
                diagFilePlayerSession.stop();
            } else if ("FilePlayer.setScaling".equals(string)) {
                diagFilePlayerSession.setVideoScaling();
            } else if ("FilePlayer.seek".equals(string)) {
                diagFilePlayerSession.seek(Boolean.valueOf(stringArray[1]));
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("FilePlayerController").append("@").append(this.hashCode());
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

    static /* synthetic */ LogChannel access$000(FilePlayerController filePlayerController) {
        return filePlayerController.logger;
    }

    static /* synthetic */ Queue access$100(FilePlayerController filePlayerController) {
        return filePlayerController.filePlayerControllerQueue;
    }
}

