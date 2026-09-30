/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.interapp.media.IMediaDrawerContextListener;
import de.audi.atip.interapp.media.IMediaDrawerElement;
import de.audi.atip.interapp.media.IMediaOnlinePlayerService;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.interapp.media.IMediaServiceListener;
import de.audi.atip.interapp.media.MediaSlotInfo;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.media.IMediaValues;
import de.audi.remotehmi.media.IOnlineMediaSession;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IMediaSessionListener;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IPlaytimeStrategy;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IViewNpsListenerInterface;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaSession;
import de.audi.tghu.online.app.remotehmi.onlinemedia.PlaytimeRadioStrategy;
import de.audi.tghu.online.app.remotehmi.onlinemedia.PlaytimeStragegyFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;

public class OnlineMediaComponent
extends AbstractRemoteHMIComponent
implements IMediaSessionListener,
IMediaServiceListener,
IMediaDrawerContextListener {
    public static final String EVENT_MEDIA_LEFT_DRAWER_SELECTED = "MEDIA_LEFT_DRAWER_SELECTED";
    private IMediaOnlinePlayerService mediaService;
    private IMediaService generalMediaService;
    public static final int FOLDER_ENTRY = 1;
    private List sessionList = new ArrayList();
    private LinkedList mediaSlots;
    private OnlineMediaSession currentSession;
    private IPlaytimeStrategy playtimeStrategy;
    private String lastStartedApplication = "";
    private static final String PREFIX_COVER_FOR_FPK = "/net/mmx/mnt/ols/";
    Thread thread;
    boolean simulationActive = true;
    public int counter = 0;

    public void init(final LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        PlaytimeStragegyFactory.service = remoteHMIService;
        this.playtimeStrategy = PlaytimeStragegyFactory.createSingleTrackPlaytimeStrategy(logChannel);
        remoteHMIService.addCommandHandler(2000300, new AbstractCommandHandler("online-media-init"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "OnlineMediaHandler#indicateCommand() ONLINEMEDIA [openSession] received");
                if (object instanceof HMIProperties) {
                    HMIProperties hMIProperties = (HMIProperties)object;
                    OnlineMediaComponent.this.openSession(hMIProperties.getString("sessionId"), hMIProperties.getString("cncURL"), hMIProperties.getString("serviceId"));
                }
            }
        });
        remoteHMIService.addCommandHandler(2000306, new AbstractCommandHandler("online-media-pause"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "OnlineMediaHandler#indicateCommand() ONLINEMEDIA [pause] received");
                OnlineMediaComponent.this.pause();
            }
        });
        remoteHMIService.addCommandHandler(2000307, new AbstractCommandHandler("online-media-resume"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "OnlineMediaHandler#indicateCommand() ONLINEMEDIA [resume] received");
                OnlineMediaComponent.this.resume();
            }
        });
        remoteHMIService.addCommandHandler(2000309, new AbstractCommandHandler("online-media-seek"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "OnlineMediaHandler#indicateCommand() ONLINEMEDIA [seek2Time] received");
                if (object instanceof HMIProperties) {
                    HMIProperties hMIProperties = (HMIProperties)object;
                    OnlineMediaComponent.this.seek2Time(hMIProperties.getInt("timePos"));
                }
            }
        });
        remoteHMIService.addCommandHandler(2000308, new AbstractCommandHandler("online-media-skip"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "OnlineMediaHandler#indicateCommand() ONLINEMEDIA [skip] received");
                if (object instanceof HMIProperties) {
                    HMIProperties hMIProperties = (HMIProperties)object;
                    OnlineMediaComponent.this.skip(hMIProperties.getInt("skipSteps"));
                }
            }
        });
        remoteHMIService.addCommandHandler(2000310, new AbstractCommandHandler("online-media-repeat"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "OnlineMediaHandler#indicateCommand() ONLINEMEDIA [repeat] received");
                if (object instanceof HMIProperties) {
                    HMIProperties hMIProperties = (HMIProperties)object;
                    OnlineMediaComponent.this.repeat(hMIProperties.getBoolean("enabled"));
                }
            }
        });
        remoteHMIService.addCommandHandler(2000311, new AbstractCommandHandler("online-media-shuffle"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "OnlineMediaHandler#indicateCommand() ONLINEMEDIA [shuffle] received");
                if (object instanceof HMIProperties) {
                    HMIProperties hMIProperties = (HMIProperties)object;
                    OnlineMediaComponent.this.shuffle(hMIProperties.getBoolean("enabled"));
                }
            }
        });
        remoteHMIService.addCommandHandler(2000314, new AbstractCommandHandler("online-media-update-cover"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "OnlineMediaHandler#indicateCommand() ONLINEMEDIA [updateCoverUrl] received");
                if (object instanceof String[]) {
                    String[] stringArray = (String[])object;
                    OnlineMediaComponent.this.updateCoverUrl(stringArray[0], stringArray[1]);
                } else {
                    logChannel.log(10000, "OnlineMediaHandler#indicateCommand() wrong payload received. It should be of class String[], but it is of class %1. Payload=%2", (Object)object.getClass().getName(), object);
                }
            }
        });
        remoteHMIService.addCommandHandler(2000315, new AbstractCommandHandler("show-default-cover-in-fpk"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "OnlineMediaHandler#indicateCommand() ONLINEMEDIA [showDefaultCoverInFPK] received");
                OnlineMediaComponent.this.showDefaultCoverInFPK();
            }
        });
    }

    public IMediaOnlinePlayerService getOnlineMediaService() {
        return this.mediaService;
    }

    public void setOnlineMediaService(IMediaOnlinePlayerService iMediaOnlinePlayerService) {
        this.mediaService = iMediaOnlinePlayerService;
    }

    public void updateMetadata(String string, String string2, String string3, String string4) {
        this.logChannel.log(10000000, "OnlineMediaComponent#updateMetadata trackId = %1, title = '%2', album = '%3', artist = '%4'", (Object)string, (Object)string2, (Object)string3, (Object)string4);
        IViewNpsListenerInterface iViewNpsListenerInterface = (IViewNpsListenerInterface)((Object)this.remoteHmiService.getViewListener(15000));
        IMediaValues iMediaValues = iViewNpsListenerInterface.getMediaValues();
        iMediaValues.setTextInGivenOrder(string2, string3, string4);
        String string5 = iMediaValues.getTrackId();
        if (string5 == null) {
            string5 = "";
        }
        if (!string5.equals(string)) {
            this.logChannel.log(10000000, "OnlineMediaComponent#updateMetadata clearing old track id='%1' is different than new track id='%2' ", (Object)string5, (Object)string);
            iMediaValues.setTrackId(string);
            iViewNpsListenerInterface.updateCover("");
            RemoteHMIAction remoteHMIAction = new RemoteHMIAction(10007005);
            HMIProperties hMIProperties = remoteHMIAction.getParameters();
            hMIProperties.putString("onlineMediaTrackId", string);
            this.remoteHmiService.invokeAction(remoteHMIAction);
            iMediaValues.clearTimeValues();
            iMediaValues.setGridListIndex(-1);
            iViewNpsListenerInterface.updateTimeValues();
        }
        iViewNpsListenerInterface.updateMetadataValues();
        this.currentSession.setDefaultBuffer();
        this.playtimeStrategy.updateBufferPosition(this.currentSession);
        this.informNPSListenerAboutPlayTimeStrategy(iViewNpsListenerInterface);
    }

    public void updatePlayPosition(int n, int n2) {
        this.logChannel.log(1000000, "OnlineMediaComponent#queueing task: updatePlayPosition [time: %1]", (long)n);
        this.playtimeStrategy.updatePlayPosition(n, n2);
    }

    private void updateCoverUrl(String string, String string2) {
        String string3;
        if (this.currentSession == null) {
            this.logChannel.log(1000000, "OnlineMediaComponent#updateCoverUrl: no valid session (null)");
            return;
        }
        IViewNpsListenerInterface iViewNpsListenerInterface = (IViewNpsListenerInterface)((Object)this.remoteHmiService.getViewListener(15000));
        IMediaValues iMediaValues = iViewNpsListenerInterface.getMediaValues();
        String string4 = string3 = iMediaValues.getTrackId() == null ? "" : iMediaValues.getTrackId();
        if (!string3.equals(string2)) {
            this.logChannel.log(100000, "OnlineMediaComponent#updateCoverUrl: image name of downloaded coverartTrackId '%1' does not match current track id '%2'", (Object)string2, (Object)string3);
            return;
        }
        iViewNpsListenerInterface.updateCover(string);
        String[] stringArray = StringUtilities.split(string, "/app/rhmi/");
        if (stringArray != null && stringArray.length > 1) {
            String string5 = new StringBuffer().append(PREFIX_COVER_FOR_FPK).append(stringArray[1]).toString();
            this.currentSession.updateCoverart(new ResourceLocator(string5));
            this.logChannel.log(10000000, "OnlineMediaComponent#updateCoverUrl: updating FPK Cover information. Using cover at '%1'.", (Object)string5);
        } else {
            this.logChannel.log(10000000, "OnlineMediaComponent#updateCoverUrl: not updating FPK Cover information. Could not extract FPK location from path '%1'.", (Object)string);
        }
    }

    private void showDefaultCoverInFPK() {
        this.currentSession.updateCoverart(null);
    }

    protected void repeat(boolean bl) {
        this.logChannel.log(1000000, "OnlineMediaComponent#repeat: enabled: %1", bl);
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.setRepeat(bl);
        }
    }

    protected void shuffle(boolean bl) {
        this.logChannel.log(1000000, "OnlineMediaComponent#shuffle: enabled %1", bl);
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.setShuffle(bl);
        }
    }

    protected void skip(int n) {
        this.logChannel.log(1000000, "OnlineMediaComponent#skip: skipSteps: %1", (long)n);
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.skip(n);
        }
    }

    public void pause() {
        this.logChannel.log(1000000, "OnlineMediaComponent#pause: Called");
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.pause();
        }
    }

    public void resume() {
        this.logChannel.log(1000000, "OnlineMediaComponent#resume: Called");
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.resume();
        }
    }

    public void seek2Time(int n) {
        this.logChannel.log(1000000, "OnlineMediaComponent#seek2Time: timepos %1", (long)n);
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.seek2Time(n);
        }
    }

    public void openSession(String string, String string2, String string3) {
        this.logChannel.log(1000000, "OnlineMediaComponent#queueing openSession");
        if (!this.isCurrentServiceId(string3)) {
            this.logChannel.log(100000, "OnlineMediaComponent#openSession: requested serviceId %1 is not the started service: %2", (Object)string3, (Object)this.lastStartedApplication);
            return;
        }
        if (this.mediaService == null) {
            this.logChannel.log(10000, "OnlineMediaComponent#openSession: mediaService is null");
            return;
        }
        OnlineMediaSession onlineMediaSession = this.getCurrentSession(string3);
        if (onlineMediaSession != null) {
            this.logChannel.log(1000000, "OnlineMediaComponent#openSession: old session with same id(%1) found. Reopen", (Object)onlineMediaSession.getServiceID());
        } else {
            onlineMediaSession = new OnlineMediaSession(string, string3, string2, this.logChannel, this);
            this.sessionList.add(onlineMediaSession);
            this.resetMetaDataValues();
        }
        this.logChannel.log(1000000, "OnlineMediaComponent#openSession: %1 opening Session [ID %2]", (Object)onlineMediaSession.getServiceID(), (Object)onlineMediaSession.getName());
        this.mediaService.open(onlineMediaSession);
        this.currentSession = onlineMediaSession;
        this.logChannel.log(1000000, "OnlineMediaComponent#openSession: new Media Session %1 created", (Object)onlineMediaSession.getServiceID());
        if (this.remoteHmiService.getMediaDrawerContext() == null) {
            this.logChannel.log(100000, "OnlineMediaComponent#openSession: mediaDrawerContext is null so can't set left drawer inner ring");
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new IMediaDrawerElement(){

            public boolean isSelected() {
                return false;
            }

            public boolean isFocused() {
                return false;
            }

            public String getName() {
                return null;
            }

            public int getIconID() {
                return 1;
            }

            public int getID() {
                return 1;
            }
        });
        this.remoteHmiService.getMediaDrawerContext().setDrawerElements(arrayList, this);
    }

    private boolean isCurrentServiceId(String string) {
        if (this.lastStartedApplication.length() == 0) {
            return true;
        }
        return string.equals(this.lastStartedApplication);
    }

    private void resetMetaDataValues() {
        this.updatePlayPosition(0, 0);
    }

    public void play(String string, int n) {
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.play(string, n);
        }
    }

    public void startSimulation() {
        if (this.thread != null) {
            return;
        }
        this.thread = new Thread(new Runnable(){

            public void run() {
                System.out.println("Simulation: starting...");
                while (OnlineMediaComponent.this.counter < 100) {
                    System.out.println(new StringBuffer().append("Simulation: counter: ").append(OnlineMediaComponent.this.counter).toString());
                    OnlineMediaComponent.this.updatePlayPosition(OnlineMediaComponent.this.counter++, 100);
                    try {
                        Thread.sleep(1000L);
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            }
        });
        this.thread.start();
    }

    public void fastForward() {
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.seek(true);
        }
    }

    public void fastRewind() {
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.seek(false);
        }
    }

    public void close(OnlineMediaSession onlineMediaSession) {
        onlineMediaSession.close();
        boolean bl = this.sessionList.remove(onlineMediaSession);
        this.logChannel.log(1000000, "OnlineMediaComponent#close session was %1 removed", (Object)(bl ? "" : "not"));
        ResourceLocatorModelApp resourceLocatorModelApp = this.getModelBank().getResourceLocatorModel(3838);
        this.logChannel.log(1000000, "OnlineMediaComponent#close hide provider logo.");
        resourceLocatorModelApp.setStatus(0);
    }

    private OnlineMediaSession getCurrentSession(String string) {
        this.logChannel.log(1000000, "OnlineMediaComponent#getCurrentSession: serviceID %1", (Object)string);
        Iterator iterator = this.sessionList.iterator();
        while (iterator.hasNext()) {
            OnlineMediaSession onlineMediaSession = (OnlineMediaSession)iterator.next();
            if (!onlineMediaSession.getServiceID().equals(string)) continue;
            this.logChannel.log(1000000, "OnlineMediaComponent#getCurrentSession: opened session found: name %1, serviceID %2", (Object)onlineMediaSession.getName(), (Object)onlineMediaSession.getServiceID());
            this.currentSession = onlineMediaSession;
            return onlineMediaSession;
        }
        this.logChannel.log(1000000, "OnlineMediaComponent#getCurrentSession: unknown session for service %1", (Object)string);
        return null;
    }

    public OnlineMediaSession getCurrentSession() {
        String string = this.getCurrentContext();
        return this.getCurrentSession(string);
    }

    public void processState(IOnlineMediaSession iOnlineMediaSession) {
        String string = iOnlineMediaSession.getState();
        if (string.equals("MEDIA_ERROR") || string.equals("MEDIA_CLOSED")) {
            this.logChannel.log(1000000, "OnlineMediaComponent#processState: session state changed to ERROR/CLOSED so removing it");
            this.close((OnlineMediaSession)iOnlineMediaSession);
        }
        this.processGenericEvent("MEDIA_SESSION_UPDATE", iOnlineMediaSession);
    }

    public void processShuffleChanged(IOnlineMediaSession iOnlineMediaSession, boolean bl) {
        this.processGenericEvent("MEDIA_SHUFFLE_CHANGED", iOnlineMediaSession);
    }

    public void processRepeatChanged(IOnlineMediaSession iOnlineMediaSession, boolean bl) {
        this.processGenericEvent("MEDIA_REPEAT_CHANGED", iOnlineMediaSession);
    }

    public void processGenericEvent(String string, IOnlineMediaSession iOnlineMediaSession) {
        this.processGenericEvent(string, iOnlineMediaSession, null);
    }

    public void processBufferChangedEvent(IOnlineMediaSession iOnlineMediaSession) {
        this.remoteHmiService.execute(new ProcessBufferEventTask("process-buffer-event", iOnlineMediaSession));
        this.playtimeStrategy.updateBufferPosition(iOnlineMediaSession);
    }

    public void processGenericEvent(String string, IOnlineMediaSession iOnlineMediaSession, Object object) {
        if (string == null || string.length() == 0 || iOnlineMediaSession == null) {
            this.logChannel.log(100000, "OnlineMediaComponent#processGenericEvent invalid parameters event: %1", (Object)string);
            return;
        }
        this.logChannel.log(1000000, "OnlineMediaComponent#processGenericEvent processing event: %1 service: %2", (Object)string, (Object)iOnlineMediaSession.getServiceID());
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(10007001);
        HMIProperties hMIProperties = remoteHMIAction.getParameters();
        hMIProperties.putString("onlineMediaEventType", string);
        hMIProperties.put("onlineMediaSession", iOnlineMediaSession);
        if (object != null) {
            hMIProperties.put("onlineMediaEventPayload", object);
        }
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    private String getCurrentContext() {
        return this.remoteHmiService.getContext().getContextName();
    }

    public IMediaService getMediaService() {
        return this.generalMediaService;
    }

    public void setMediaService(IMediaService iMediaService) {
        this.generalMediaService = iMediaService;
    }

    public int getTerminalID() {
        return 0;
    }

    public void sourceAvailable(int n, boolean bl) {
        this.logChannel.log(1000000, "OnlineMediaComponent#sourceAvailable: MEDIA_COMPONENT SOURCE AVAILABLE %1", (long)n);
    }

    public void sourceListChanged(Map map) {
        this.logChannel.log(1000000, "OnlineMediaComponent#sourceListChanged() updating media Slots");
        this.mediaSlots = (LinkedList)map.get(new Integer(13));
    }

    public int getSlotId(String string) {
        this.logChannel.log(1000000, "OnlineMediaComponent#getSlotId() for context: %1", (Object)string);
        if (this.mediaSlots == null) {
            this.logChannel.log(10000000, "OnlineMediaComponent#getSlotId() no media slot list was received!");
            return -1;
        }
        Iterator iterator = this.mediaSlots.iterator();
        while (iterator.hasNext()) {
            MediaSlotInfo mediaSlotInfo = (MediaSlotInfo)iterator.next();
            this.logChannel.log(10000000, "OnlineMediaComponent#getSlotId() checking slot: %1", (Object)mediaSlotInfo);
            if (!mediaSlotInfo.getMountPoint().equals(string)) continue;
            this.logChannel.log(1000000, "OnlineMediaComponent#getSlotId() returning slot ID: %1", (long)mediaSlotInfo.getSlotIdx());
            return mediaSlotInfo.getSlotIdx();
        }
        this.logChannel.log(1000000, "OnlineMediaComponent#getSlotId() no valid slot found!");
        return -1;
    }

    public void updateActiveSource(MediaSlotInfo mediaSlotInfo, boolean bl) {
        IViewNpsListenerInterface iViewNpsListenerInterface = (IViewNpsListenerInterface)((Object)this.remoteHmiService.getViewListener(15000));
        iViewNpsListenerInterface.updateActiveSource(mediaSlotInfo);
    }

    public void sourceDeactivated() {
    }

    private void informNPSListenerAboutPlayTimeStrategy(IViewNpsListenerInterface iViewNpsListenerInterface) {
        if (this.playtimeStrategy instanceof PlaytimeRadioStrategy) {
            iViewNpsListenerInterface.setRadioMode(true);
        } else {
            iViewNpsListenerInterface.setRadioMode(false);
        }
    }

    public void setPlaytimeStrategy(IPlaytimeStrategy iPlaytimeStrategy) {
        this.playtimeStrategy = iPlaytimeStrategy;
    }

    public void processSkipEvent(IOnlineMediaSession iOnlineMediaSession) {
        this.processGenericEvent("MEDIA_SKIP", iOnlineMediaSession);
    }

    public void updatePlaybackState(int n) {
    }

    public void setLastStartedApplication(String string) {
        this.lastStartedApplication = string;
    }

    public void drawerElementSelected(IMediaDrawerElement iMediaDrawerElement) {
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(10007004);
        HMIProperties hMIProperties = remoteHMIAction.getParameters();
        hMIProperties.putString("onlineMediaEventType", EVENT_MEDIA_LEFT_DRAWER_SELECTED);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public class ProcessBufferEventTask
    extends AbstractRemoteHMITask {
        IOnlineMediaSession session;

        public ProcessBufferEventTask(String string, IOnlineMediaSession iOnlineMediaSession) {
            super(string);
            this.session = iOnlineMediaSession;
        }

        public void run() {
            OnlineMediaComponent.this.processGenericEvent("MEDIA_BUFFER_FILLED_CHANGED", this.session, null);
        }

        public boolean isCoalescable() {
            return true;
        }

        public Long getDelayMillis() {
            return new Long(300L);
        }

        public boolean coalesceWith(RemoteHMITask remoteHMITask) {
            if (!(remoteHMITask instanceof ProcessBufferEventTask)) {
                return false;
            }
            OnlineMediaComponent.this.logChannel.log(1000000, "ProcessBufferEventTask#processBufferEvent coalesceWith: avoided processing");
            return true;
        }
    }
}

