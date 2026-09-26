/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.ManualSeekHandler$SetPlayPositionTask;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;

public class ManualSeekHandler
extends AbstractMediaTerminalComponent
implements TimerListener,
RangeListener,
IPlayerTrackListener,
IPlayerListener {
    static final String LOGCLASS;
    static final int MANUAL_SEEK_CONFIRMATION_TIMEOUT;
    static final int MANUAL_SEEK_OFF;
    static final int MANUAL_SEEK_ON_NO_INTERACTION;
    static final int MANUAL_SEEK_ON_INTERACTION;
    final IPlayer player;
    private final Object manualSeekMutex = new Object();
    final Timer manualSeekTimer;
    final ModelGroup manualSeekingModelGroup;
    final ModelGroup manualSeekingDetailInfoModelGroup;
    private final boolean leaveManualSeekOnTrackChange;
    private MediaDetailInfo currentDetailinfo;
    private PlayTime currentPlaytime;
    private ResourceLocator currentCoverArt;
    private int seekPosition;
    private int manualSeekState = 0;
    private boolean manualSeekAvailable = false;

    public ManualSeekHandler(IMediaTerminal iMediaTerminal, IPlayer iPlayer, boolean bl) {
        super(iMediaTerminal);
        this.player = iPlayer;
        this.leaveManualSeekOnTrackChange = bl;
        this.manualSeekingModelGroup = new ModelGroup();
        this.manualSeekingDetailInfoModelGroup = new ModelGroup();
        this.manualSeekTimer = new Timer("ManualSeekTimer", 0, true, this);
    }

    boolean isLeaveManualSeekOnTrackChange() {
        return this.leaveManualSeekOnTrackChange;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activate() {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"ManualSeekHandler");
        this.setManualSeekAvailable(false);
        this.setManualSeekState(0);
        Object object = this.manualSeekMutex;
        synchronized (object) {
            this.currentPlaytime = new PlayTime(-1, -1);
            this.currentDetailinfo = new MediaDetailInfo();
            this.currentCoverArt = null;
        }
        this.manualSeekingModelGroup.add(this.getModel(0x3E0E0300));
        this.manualSeekingModelGroup.add(this.getModel(1024328448));
        this.manualSeekingModelGroup.add(this.getModel(1057882880));
        this.manualSeekingDetailInfoModelGroup.add(this.getModel(-1995439360));
        this.manualSeekingDetailInfoModelGroup.add(this.getModel(-1978662144));
        this.manualSeekingDetailInfoModelGroup.add(this.getModel(-1945107712));
        this.manualSeekingDetailInfoModelGroup.add(this.getModel(-1961884928));
        this.manualSeekingDetailInfoModelGroup.add(this.getModel(-1911553280));
        this.manualSeekingDetailInfoModelGroup.add(this.getModel(-1894776064));
        this.manualSeekingDetailInfoModelGroup.add(this.getModel(-1877998848));
        this.getButtonModel(-1928330496).setButtonListener(this);
        this.getRangeModel(1024328448).setRangeListener(this);
        this.player.addPlayerListener(this);
        this.player.addTrackListener(this);
    }

    PlayTime getCurrentPlaytime() {
        return this.currentPlaytime;
    }

    MediaDetailInfo getCurrentDetailinfo() {
        return this.currentDetailinfo;
    }

    ResourceLocator getCurrentCoverArt() {
        return this.currentCoverArt;
    }

    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"ManualSeekHandler");
        this.manualSeekTimer.cancel();
        this.player.removePlayerListener(this);
        this.player.removeTrackListener(this);
        this.setManualSeekAvailable(false);
        this.setManualSeekState(0);
        this.manualSeekingModelGroup.removeAll();
        this.manualSeekingDetailInfoModelGroup.removeAll();
        this.getButtonModel(-1928330496).setButtonListener(null);
        this.getRangeModel(1024328448).setRangeListener(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void manualSeekModeEnter() {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            if (this.isManualSeek()) {
                return;
            }
            this.logger.main().log(1078071040, "[%1.manualSeekModeEnter] Enter manual seek mode.", (Object)"ManualSeekHandler");
            if (!this.isManualSeekAvailable()) {
                this.logger.main().log(1078071040, "[%1.manualSeekModeEnter]  Manual seeking not possible.", (Object)"ManualSeekHandler");
                return;
            }
            if (this.currentDetailinfo != null && this.currentDetailinfo.isImportRunning()) {
                this.logger.main().log(1078071040, "[%1.manualSeekModeEnter] File is currently imported. Seek not supported.", (Object)"ManualSeekHandler");
                return;
            }
            this.setDetailInfos();
            this.manualSeekSetCurrentPlayPosition(this.currentPlaytime);
            this.setManualSeekState(1);
            this.getButtonModel(-1928330496).setPressed(true);
            this.getChoiceModel(990774016).setValue(1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void manualSeekModeLeave(boolean bl) {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            if (!this.isManualSeek()) {
                return;
            }
            this.logger.main().log(1078071040, "[%2.manualSeekModeLeave] '%1'", bl, (Object)"ManualSeekHandler");
            this.manualSeekTimer.cancel();
            if (bl && this.isManualSeekOnInteraction()) {
                this.logger.main().log(1078071040, "[%1.manualSeekModeLeave] Set current time pos.", (Object)"ManualSeekHandler");
                this.getTerminal().getDispatcher().execute(new ManualSeekHandler$SetPlayPositionTask(this.player, this.seekPosition));
            }
            this.getButtonModel(-1928330496).setPressed(false);
            this.getChoiceModel(990774016).setValue(0);
            this.setManualSeekState(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean isManualSeek() {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            return this.manualSeekState != 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isManualSeekUpdatePlayPosition() {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            return this.manualSeekState == 1;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean isManualSeekOnInteraction() {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            return this.manualSeekState == 2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setManualSeekState(int n) {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            this.manualSeekState = n;
        }
    }

    int getManualSeekState() {
        return this.manualSeekState;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setManualSeekAvailable(boolean bl) {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            if (this.manualSeekAvailable == bl) {
                return;
            }
            this.logger.main().log(1078071040, "[%2.setManualSeekAvailable] '%1'", bl, (Object)"ManualSeekHandler");
            this.manualSeekAvailable = bl;
            this.getChoiceModel(336528128).setValue(this.manualSeekAvailable ? 1 : 0);
            this.resetManualSeekModeLeave(bl);
        }
    }

    void resetManualSeekModeLeave(boolean bl) {
        if (!bl && this.isManualSeek()) {
            this.manualSeekModeLeave(false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean isManualSeekAvailable() {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            return this.manualSeekAvailable;
        }
    }

    public void manualSeekSetCurrentPlayPosition(PlayTime playTime) {
        this.seekPosition = playTime.getPlayTime();
        this.getRangeModel(1024328448).setLimits(0, playTime.getRestrictedTotalTime(), 1);
        this.getRangeModel(1024328448).setValue(playTime.getRestrictedPlayTime());
        this.getLabelModel(0x3E0E0300).setText(playTime.getRestrictedPlayTimeStr());
        this.getLabelModel(1057882880).setText(playTime.getRemainTimeStr());
        this.manualSeekingModelGroup.flush();
    }

    int getSeekPosition() {
        return this.seekPosition;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void resetDetailInfos() {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            this.getLabelModel(-1945107712).setText("");
            this.getChoiceModel(-1877998848).setValue(0);
            this.getLabelModel(-1978662144).setText("");
            this.getChoiceModel(-1894776064).setValue(0);
            this.getLabelModel(-1995439360).setText("");
            this.getChoiceModel(-1911553280).setValue(0);
            this.getResourceLocatorModel(-1961884928).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI, 1);
        }
        this.manualSeekingDetailInfoModelGroup.flush();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setDetailInfos() {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            this.resetDetailInfos();
            if (this.currentDetailinfo != null) {
                if (this.currentDetailinfo.getTitle().isEmpty()) {
                    this.getLabelModel(-1945107712).setText(this.currentDetailinfo.getFilename().getI18NString());
                    this.getChoiceModel(-1877998848).setValue(this.currentDetailinfo.getFilename().getI18NKey());
                } else {
                    this.getLabelModel(-1945107712).setText(this.currentDetailinfo.getTitle().getI18NString());
                    this.getChoiceModel(-1877998848).setValue(this.currentDetailinfo.getTitle().getI18NKey());
                    this.getLabelModel(-1978662144).setText(this.currentDetailinfo.getArtist().getI18NString());
                    this.getChoiceModel(-1894776064).setValue(this.currentDetailinfo.getArtist().getI18NKey());
                    this.getLabelModel(-1995439360).setText(this.currentDetailinfo.getAlbum().getI18NString());
                    this.getChoiceModel(-1911553280).setValue(this.currentDetailinfo.getAlbum().getI18NKey());
                }
                this.updateResourceLocatorModel();
            }
        }
        this.manualSeekingDetailInfoModelGroup.flush();
    }

    void updateResourceLocatorModel() {
        int n = this.currentCoverArt == null ? (int)MediaUtils.removeEntryIdFlags(this.currentDetailinfo.getAlbumID()) : this.currentCoverArt.getId();
        String string = this.currentCoverArt == null ? ResourceLocatorModelApp.UNDEFINED_URI : this.currentCoverArt.getUrl();
        this.getResourceLocatorModel(-1961884928).setResourceLocator(n, string, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final void updateManualSeekTime(int n) {
        PlayTime playTime;
        Object object = this.manualSeekMutex;
        synchronized (object) {
            if (!this.isManualSeek()) {
                this.logger.hmi().log(1078071040, "[%1.updateManualSeekTime] Not in seek mode any more.", (Object)"ManualSeekHandler");
                return;
            }
            this.seekPosition += n;
            if (this.seekPosition > this.currentPlaytime.getTotalTimeOfTrack()) {
                this.seekPosition = this.currentPlaytime.getTotalTimeOfTrack();
            }
            this.setManualSeekState(2);
            this.manualSeekTimer.restart();
        }
        object = this.getRangeModel(1024328448);
        Object object2 = this.manualSeekMutex;
        synchronized (object2) {
            if (this.seekPosition < 0) {
                this.seekPosition = 0;
            }
            playTime = new PlayTime(this.seekPosition, this.currentPlaytime.getTotalTimeOfTrack());
        }
        object.setValue(playTime.getRestrictedPlayTime());
        this.getLabelModel(0x3E0E0300).setText(playTime.getRestrictedPlayTimeStr());
        this.getLabelModel(1057882880).setText(playTime.getRemainTimeStr());
        this.manualSeekingModelGroup.flush();
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.logger.hmi().log(1078071040, "[%1.cancelTimer] Timer canceled.", (Object)"ManualSeekHandler");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        this.logger.hmi().log(1078071040, "[%1.fireTimer] Timer fired.", (Object)"ManualSeekHandler");
        Object object = this.manualSeekMutex;
        synchronized (object) {
            if (!this.isManualSeek()) {
                this.logger.hmi().log(1078071040, "[%1.fireTimer] Not in seek mode any more.", (Object)"ManualSeekHandler");
                return;
            }
            this.getTerminal().getDispatcher().execute(new ManualSeekHandler$SetPlayPositionTask(this.player, this.seekPosition));
            this.setManualSeekState(1);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200253: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] PLAYER_MANUAL_SEEK_PLAYTIME_RANGE.", (Object)"ManualSeekHandler");
                this.manualSeekModeLeave(n2 == 17);
                break;
            }
            case 200845: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] PLAYER_MANUAL_SEEK_PLAYTIME_RANGE.", (Object)"ManualSeekHandler");
                this.manualSeekModeEnter();
                this.getButtonModel(-1928330496).fireEvent(n3);
                break;
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.updateManualSeekTime(-n2);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.updateManualSeekTime(n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            this.currentPlaytime = playTime;
            if (this.leaveManualSeekOnTrackChange && bl) {
                this.logger.main().log(1078071040, "[%1.trackChanged]", (Object)"ManualSeekHandler");
                this.manualSeekModeLeave(false);
            }
            if (this.isManualSeekUpdatePlayPosition()) {
                this.manualSeekSetCurrentPlayPosition(this.currentPlaytime);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            this.logger.main().log(1078071040, "[%1.detailInfoChanged]", (Object)"ManualSeekHandler");
            this.currentDetailinfo = mediaDetailInfo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void coverArtChanged(ResourceLocator resourceLocator) {
        Object object = this.manualSeekMutex;
        synchronized (object) {
            this.logger.main().log(1078071040, "[%1.coverArtChanged]", (Object)"ManualSeekHandler");
            this.currentCoverArt = resourceLocator;
        }
    }

    @Override
    public void playerStartupComplete() {
    }

    @Override
    public void repeatScopeChanged(int n, boolean bl) {
    }

    @Override
    public void repeatModeChanged(int n) {
    }

    @Override
    public void capabilitiesChanged(Capabilities capabilities) {
        this.logger.main().log(1078071040, "[%1.capabilitiesChanged]", (Object)"ManualSeekHandler");
        this.setManualSeekAvailable(capabilities.isSetTimePos());
    }

    @Override
    public void playbackStateChanged(int n) {
        this.logger.main().log(1078071040, "[%1.playbackStateChanged]", (Object)"ManualSeekHandler");
    }

    public void playbackFolderChanged(MediaListEntry mediaListEntry) {
    }

    @Override
    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    @Override
    public void commandBlocked() {
    }

    @Override
    public void currentPMLevelChanged(int n) {
    }
}

