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
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IMediaSessionListener;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IPlaytimeStrategy;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IViewNpsListenerInterface;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent$1;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent$10;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent$11;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent$2;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent$3;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent$4;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent$5;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent$6;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent$7;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent$8;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent$9;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent$ProcessBufferEventTask;
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
    public static final String EVENT_MEDIA_LEFT_DRAWER_SELECTED;
    private IMediaOnlinePlayerService mediaService;
    private IMediaService generalMediaService;
    public static final int FOLDER_ENTRY;
    private List sessionList = new ArrayList();
    private LinkedList mediaSlots;
    private OnlineMediaSession currentSession;
    private IPlaytimeStrategy playtimeStrategy;
    private String lastStartedApplication = "";
    private static final String PREFIX_COVER_FOR_FPK;
    Thread thread;
    boolean simulationActive = true;
    public int counter = 0;

    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        PlaytimeStragegyFactory.service = remoteHMIService;
        this.playtimeStrategy = PlaytimeStragegyFactory.createSingleTrackPlaytimeStrategy(logChannel);
        remoteHMIService.addCommandHandler(-1400562176, new OnlineMediaComponent$1(this, "online-media-init", logChannel));
        remoteHMIService.addCommandHandler(-1299898880, new OnlineMediaComponent$2(this, "online-media-pause", logChannel));
        remoteHMIService.addCommandHandler(-1283121664, new OnlineMediaComponent$3(this, "online-media-resume", logChannel));
        remoteHMIService.addCommandHandler(-1249567232, new OnlineMediaComponent$4(this, "online-media-seek", logChannel));
        remoteHMIService.addCommandHandler(-1266344448, new OnlineMediaComponent$5(this, "online-media-skip", logChannel));
        remoteHMIService.addCommandHandler(-1232790016, new OnlineMediaComponent$6(this, "online-media-repeat", logChannel));
        remoteHMIService.addCommandHandler(-1216012800, new OnlineMediaComponent$7(this, "online-media-shuffle", logChannel));
        remoteHMIService.addCommandHandler(-1165681152, new OnlineMediaComponent$8(this, "online-media-update-cover", logChannel));
        remoteHMIService.addCommandHandler(-1148903936, new OnlineMediaComponent$9(this, "show-default-cover-in-fpk", logChannel));
    }

    public IMediaOnlinePlayerService getOnlineMediaService() {
        return this.mediaService;
    }

    public void setOnlineMediaService(IMediaOnlinePlayerService iMediaOnlinePlayerService) {
        this.mediaService = iMediaOnlinePlayerService;
    }

    @Override
    public void updateMetadata(String string, String string2, String string3, String string4) {
        this.logChannel.log(-2137614336, "OnlineMediaComponent#updateMetadata trackId = %1, title = '%2', album = '%3', artist = '%4'", (Object)string, (Object)string2, (Object)string3, (Object)string4);
        IViewNpsListenerInterface iViewNpsListenerInterface = (IViewNpsListenerInterface)((Object)this.remoteHmiService.getViewListener(15000));
        IMediaValues iMediaValues = iViewNpsListenerInterface.getMediaValues();
        iMediaValues.setTextInGivenOrder(string2, string3, string4);
        String string5 = iMediaValues.getTrackId();
        if (string5 == null) {
            string5 = "";
        }
        if (!string5.equals(string)) {
            this.logChannel.log(-2137614336, "OnlineMediaComponent#updateMetadata clearing old track id='%1' is different than new track id='%2' ", (Object)string5, (Object)string);
            iMediaValues.setTrackId(string);
            iViewNpsListenerInterface.updateCover("");
            RemoteHMIAction remoteHMIAction = new RemoteHMIAction(-575563776);
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

    @Override
    public void updatePlayPosition(int n, int n2) {
        this.logChannel.log(1078071040, "OnlineMediaComponent#queueing task: updatePlayPosition [time: %1]", (long)n);
        this.playtimeStrategy.updatePlayPosition(n, n2);
    }

    private void updateCoverUrl(String string, String string2) {
        String string3;
        if (this.currentSession == null) {
            this.logChannel.log(1078071040, "OnlineMediaComponent#updateCoverUrl: no valid session (null)");
            return;
        }
        IViewNpsListenerInterface iViewNpsListenerInterface = (IViewNpsListenerInterface)((Object)this.remoteHmiService.getViewListener(15000));
        IMediaValues iMediaValues = iViewNpsListenerInterface.getMediaValues();
        String string4 = string3 = iMediaValues.getTrackId() == null ? "" : iMediaValues.getTrackId();
        if (!string3.equals(string2)) {
            this.logChannel.log(-1601830656, "OnlineMediaComponent#updateCoverUrl: image name of downloaded coverartTrackId '%1' does not match current track id '%2'", (Object)string2, (Object)string3);
            return;
        }
        iViewNpsListenerInterface.updateCover(string);
        String[] stringArray = StringUtilities.split(string, "/app/rhmi/");
        if (stringArray != null && stringArray.length > 1) {
            String string5 = new StringBuffer().append("/net/mmx/mnt/ols/").append(stringArray[1]).toString();
            this.currentSession.updateCoverart(new ResourceLocator(string5));
            this.logChannel.log(-2137614336, "OnlineMediaComponent#updateCoverUrl: updating FPK Cover information. Using cover at '%1'.", (Object)string5);
        } else {
            this.logChannel.log(-2137614336, "OnlineMediaComponent#updateCoverUrl: not updating FPK Cover information. Could not extract FPK location from path '%1'.", (Object)string);
        }
    }

    private void showDefaultCoverInFPK() {
        this.currentSession.updateCoverart(null);
    }

    protected void repeat(boolean bl) {
        this.logChannel.log(1078071040, "OnlineMediaComponent#repeat: enabled: %1", bl);
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.setRepeat(bl);
        }
    }

    protected void shuffle(boolean bl) {
        this.logChannel.log(1078071040, "OnlineMediaComponent#shuffle: enabled %1", bl);
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.setShuffle(bl);
        }
    }

    protected void skip(int n) {
        this.logChannel.log(1078071040, "OnlineMediaComponent#skip: skipSteps: %1", (long)n);
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.skip(n);
        }
    }

    public void pause() {
        this.logChannel.log(1078071040, "OnlineMediaComponent#pause: Called");
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.pause();
        }
    }

    public void resume() {
        this.logChannel.log(1078071040, "OnlineMediaComponent#resume: Called");
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.resume();
        }
    }

    public void seek2Time(int n) {
        this.logChannel.log(1078071040, "OnlineMediaComponent#seek2Time: timepos %1", (long)n);
        OnlineMediaSession onlineMediaSession = this.getCurrentSession();
        if (onlineMediaSession != null) {
            onlineMediaSession.seek2Time(n);
        }
    }

    public void openSession(String string, String string2, String string3) {
        this.logChannel.log(1078071040, "OnlineMediaComponent#queueing openSession");
        if (!this.isCurrentServiceId(string3)) {
            this.logChannel.log(-1601830656, "OnlineMediaComponent#openSession: requested serviceId %1 is not the started service: %2", (Object)string3, (Object)this.lastStartedApplication);
            return;
        }
        if (this.mediaService == null) {
            this.logChannel.log(10000, "OnlineMediaComponent#openSession: mediaService is null");
            return;
        }
        OnlineMediaSession onlineMediaSession = this.getCurrentSession(string3);
        if (onlineMediaSession != null) {
            this.logChannel.log(1078071040, "OnlineMediaComponent#openSession: old session with same id(%1) found. Reopen", (Object)onlineMediaSession.getServiceID());
        } else {
            onlineMediaSession = new OnlineMediaSession(string, string3, string2, this.logChannel, this);
            this.sessionList.add(onlineMediaSession);
            this.resetMetaDataValues();
        }
        this.logChannel.log(1078071040, "OnlineMediaComponent#openSession: %1 opening Session [ID %2]", (Object)onlineMediaSession.getServiceID(), (Object)onlineMediaSession.getName());
        this.mediaService.open(onlineMediaSession);
        this.currentSession = onlineMediaSession;
        this.logChannel.log(1078071040, "OnlineMediaComponent#openSession: new Media Session %1 created", (Object)onlineMediaSession.getServiceID());
        if (this.remoteHmiService.getMediaDrawerContext() == null) {
            this.logChannel.log(-1601830656, "OnlineMediaComponent#openSession: mediaDrawerContext is null so can't set left drawer inner ring");
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new OnlineMediaComponent$10(this));
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
        this.thread = new Thread(new OnlineMediaComponent$11(this));
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

    @Override
    public void close(OnlineMediaSession onlineMediaSession) {
        onlineMediaSession.close();
        boolean bl = this.sessionList.remove(onlineMediaSession);
        this.logChannel.log(1078071040, "OnlineMediaComponent#close session was %1 removed", (Object)(bl ? "" : "not"));
        ResourceLocatorModelApp resourceLocatorModelApp = this.getModelBank().getResourceLocatorModel(3838);
        this.logChannel.log(1078071040, "OnlineMediaComponent#close hide provider logo.");
        resourceLocatorModelApp.setStatus(0);
    }

    private OnlineMediaSession getCurrentSession(String string) {
        this.logChannel.log(1078071040, "OnlineMediaComponent#getCurrentSession: serviceID %1", (Object)string);
        Iterator iterator = this.sessionList.iterator();
        while (iterator.hasNext()) {
            OnlineMediaSession onlineMediaSession = (OnlineMediaSession)iterator.next();
            if (!onlineMediaSession.getServiceID().equals(string)) continue;
            this.logChannel.log(1078071040, "OnlineMediaComponent#getCurrentSession: opened session found: name %1, serviceID %2", (Object)onlineMediaSession.getName(), (Object)onlineMediaSession.getServiceID());
            this.currentSession = onlineMediaSession;
            return onlineMediaSession;
        }
        this.logChannel.log(1078071040, "OnlineMediaComponent#getCurrentSession: unknown session for service %1", (Object)string);
        return null;
    }

    public OnlineMediaSession getCurrentSession() {
        String string = this.getCurrentContext();
        return this.getCurrentSession(string);
    }

    @Override
    public void processState(IOnlineMediaSession iOnlineMediaSession) {
        String string = iOnlineMediaSession.getState();
        if (string.equals("MEDIA_ERROR") || string.equals("MEDIA_CLOSED")) {
            this.logChannel.log(1078071040, "OnlineMediaComponent#processState: session state changed to ERROR/CLOSED so removing it");
            this.close((OnlineMediaSession)iOnlineMediaSession);
        }
        this.processGenericEvent("MEDIA_SESSION_UPDATE", iOnlineMediaSession);
    }

    @Override
    public void processShuffleChanged(IOnlineMediaSession iOnlineMediaSession, boolean bl) {
        this.processGenericEvent("MEDIA_SHUFFLE_CHANGED", iOnlineMediaSession);
    }

    @Override
    public void processRepeatChanged(IOnlineMediaSession iOnlineMediaSession, boolean bl) {
        this.processGenericEvent("MEDIA_REPEAT_CHANGED", iOnlineMediaSession);
    }

    public void processGenericEvent(String string, IOnlineMediaSession iOnlineMediaSession) {
        this.processGenericEvent(string, iOnlineMediaSession, null);
    }

    @Override
    public void processBufferChangedEvent(IOnlineMediaSession iOnlineMediaSession) {
        this.remoteHmiService.execute(new OnlineMediaComponent$ProcessBufferEventTask(this, "process-buffer-event", iOnlineMediaSession));
        this.playtimeStrategy.updateBufferPosition(iOnlineMediaSession);
    }

    @Override
    public void processGenericEvent(String string, IOnlineMediaSession iOnlineMediaSession, Object object) {
        if (string == null || string.length() == 0 || iOnlineMediaSession == null) {
            this.logChannel.log(-1601830656, "OnlineMediaComponent#processGenericEvent invalid parameters event: %1", (Object)string);
            return;
        }
        this.logChannel.log(1078071040, "OnlineMediaComponent#processGenericEvent processing event: %1 service: %2", (Object)string, (Object)iOnlineMediaSession.getServiceID());
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(-642672640);
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

    @Override
    public int getTerminalID() {
        return 0;
    }

    @Override
    public void sourceAvailable(int n, boolean bl) {
        this.logChannel.log(1078071040, "OnlineMediaComponent#sourceAvailable: MEDIA_COMPONENT SOURCE AVAILABLE %1", (long)n);
    }

    @Override
    public void sourceListChanged(Map map) {
        this.logChannel.log(1078071040, "OnlineMediaComponent#sourceListChanged() updating media Slots");
        this.mediaSlots = (LinkedList)map.get(new Integer(13));
    }

    public int getSlotId(String string) {
        this.logChannel.log(1078071040, "OnlineMediaComponent#getSlotId() for context: %1", (Object)string);
        if (this.mediaSlots == null) {
            this.logChannel.log(-2137614336, "OnlineMediaComponent#getSlotId() no media slot list was received!");
            return -1;
        }
        Iterator iterator = this.mediaSlots.iterator();
        while (iterator.hasNext()) {
            MediaSlotInfo mediaSlotInfo = (MediaSlotInfo)iterator.next();
            this.logChannel.log(-2137614336, "OnlineMediaComponent#getSlotId() checking slot: %1", (Object)mediaSlotInfo);
            if (!mediaSlotInfo.getMountPoint().equals(string)) continue;
            this.logChannel.log(1078071040, "OnlineMediaComponent#getSlotId() returning slot ID: %1", (long)mediaSlotInfo.getSlotIdx());
            return mediaSlotInfo.getSlotIdx();
        }
        this.logChannel.log(1078071040, "OnlineMediaComponent#getSlotId() no valid slot found!");
        return -1;
    }

    @Override
    public void updateActiveSource(MediaSlotInfo mediaSlotInfo, boolean bl) {
        IViewNpsListenerInterface iViewNpsListenerInterface = (IViewNpsListenerInterface)((Object)this.remoteHmiService.getViewListener(15000));
        iViewNpsListenerInterface.updateActiveSource(mediaSlotInfo);
    }

    @Override
    public void sourceDeactivated() {
    }

    private void informNPSListenerAboutPlayTimeStrategy(IViewNpsListenerInterface iViewNpsListenerInterface) {
        if (this.playtimeStrategy instanceof PlaytimeRadioStrategy) {
            iViewNpsListenerInterface.setRadioMode(true);
        } else {
            iViewNpsListenerInterface.setRadioMode(false);
        }
    }

    @Override
    public void setPlaytimeStrategy(IPlaytimeStrategy iPlaytimeStrategy) {
        this.playtimeStrategy = iPlaytimeStrategy;
    }

    @Override
    public void processSkipEvent(IOnlineMediaSession iOnlineMediaSession) {
        this.processGenericEvent("MEDIA_SKIP", iOnlineMediaSession);
    }

    @Override
    public void updatePlaybackState(int n) {
    }

    public void setLastStartedApplication(String string) {
        this.lastStartedApplication = string;
    }

    @Override
    public void drawerElementSelected(IMediaDrawerElement iMediaDrawerElement) {
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(-592340992);
        HMIProperties hMIProperties = remoteHMIAction.getParameters();
        hMIProperties.putString("onlineMediaEventType", "MEDIA_LEFT_DRAWER_SELECTED");
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    static /* synthetic */ void access$000(OnlineMediaComponent onlineMediaComponent, String string, String string2) {
        onlineMediaComponent.updateCoverUrl(string, string2);
    }

    static /* synthetic */ void access$100(OnlineMediaComponent onlineMediaComponent) {
        onlineMediaComponent.showDefaultCoverInFPK();
    }

    static /* synthetic */ LogChannel access$200(OnlineMediaComponent onlineMediaComponent) {
        return onlineMediaComponent.logChannel;
    }
}

