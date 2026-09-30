/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.cdda;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.ManualSeekHandler;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.PlaybackModeHandler;
import de.audi.app.media.evo.content.cdda.CDDAPlaybackModeHandler;
import de.audi.app.media.evo.content.cdda.CDDAPlayerPlayViewList;
import de.audi.app.media.evo.content.cdda.SDSCDDACommandHandler;
import de.audi.app.media.i18n.I18NString;
import de.audi.app.media.source.IActivationContext;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;

public class CDDAPlayer
extends AbstractMediaPlayer
implements IPlayerTrackListener,
IActionProxyListener {
    private static final String LOGCLASS = "CDDAPlayer";
    private final ModelGroup trackTimeModelGroup;
    private final CDDAPlayerPlayViewList playViewList;
    private final ManualSeekHandler manualSeekHandler;
    private final SDSCDDACommandHandler sdsCommandHandler;

    public CDDAPlayer(IMediaTerminal iMediaTerminal, IContent iContent, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(iMediaTerminal, iContent, iMediaDSIPlayerController, false);
        this.playViewList = new CDDAPlayerPlayViewList(iMediaTerminal, this);
        this.trackTimeModelGroup = new ModelGroup();
        this.manualSeekHandler = new ManualSeekHandler(iMediaTerminal, this, true);
        this.sdsCommandHandler = new SDSCDDACommandHandler(this.logger.sds(), this);
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        super.init();
        this.getTerminal().getMediaPersistence().registerIntProperty("GLOBAL_KEY_DVDC_REPEAT_SCOPE", 0, 1, 0);
        RangeModelApp rangeModelApp = this.getRangeModel(200594);
        rangeModelApp.setLimits(0, 100, 1);
        rangeModelApp.setValue(0);
        this.trackTimeModelGroup.add(this.getModel(200592));
        this.trackTimeModelGroup.add(this.getModel(200593));
        this.trackTimeModelGroup.add(rangeModelApp);
        this.playViewList.init();
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        super.deinit();
        this.trackTimeModelGroup.removeAll();
        this.playViewList.deinit();
    }

    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1000000, "[%1.activate]", (Object)LOGCLASS);
        int n = iActivationContext.getSlot().getSource().getType();
        PlaybackModeHandler playbackModeHandler = n == 1 || n == 3 ? new CDDAPlaybackModeHandler(this.getTerminal(), this, true) : new PlaybackModeHandler(this.getTerminal(), this, true);
        super.activate(iActivationContext, playbackModeHandler);
        this.manualSeekHandler.activate();
        this.getChoiceModel(200823).setValue(0);
        this.getTerminal().addActionProxyListener(new int[]{31, 30}, (IActionProxyListener)this);
        this.addTrackListener(this);
    }

    public void deactivate() {
        this.logger.main().log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        super.deactivate();
        this.manualSeekHandler.deactivate();
        this.getTerminal().removeActionProxyListener(this);
        this.clearDetailInfo();
        this.invalidateCoverArt();
        this.playViewList.deactivate();
        this.getTerminal().getSDSDispatcher().removeCommandListener(this.getTerminal().getTerminalID(), this.sdsCommandHandler);
        this.getChoiceModel(200823).setValue(0);
    }

    protected void playerStartupComplete() {
        this.logger.main().log(1000000, "[%1.playerStartupComplete]", (Object)LOGCLASS);
        super.playerStartupComplete();
        this.logger.main().log(1000000, "[%1.playerStartupComplete] Activate play view", (Object)LOGCLASS);
        this.playViewList.activate();
        this.getTerminal().getSDSDispatcher().addCommandListener(this.getTerminal().getTerminalID(), this.sdsCommandHandler);
    }

    private void invalidateCoverArt() {
        this.getResourceLocatorModel(200588).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI, 1);
    }

    private void clearDetailInfo() {
        this.logger.main().log(1000000, "[%1.clearDetailInfo]", (Object)LOGCLASS);
        this.getLabelModel(200544).setText("");
        this.getChoiceModel(200596).setValue(0);
        this.getLabelModel(200542).setText("");
        this.getChoiceModel(200586).setValue(0);
        this.getLabelModel(200543).setText("");
        this.getChoiceModel(200587).setValue(0);
    }

    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logger.main().log(1000000, "[%1.detailInfoChanged]", (Object)LOGCLASS);
        this.getLabelModel(200544).setText(mediaDetailInfo.getTitle().getI18NString());
        this.getChoiceModel(200596).setValue(mediaDetailInfo.getTitle().getI18NKey());
        this.getLabelModel(200542).setText(mediaDetailInfo.getAlbum().getI18NString());
        this.getChoiceModel(200586).setValue(mediaDetailInfo.getAlbum().getI18NKey());
        this.getLabelModel(200543).setText(mediaDetailInfo.getArtist().getI18NString());
        this.getChoiceModel(200587).setValue(mediaDetailInfo.getArtist().getI18NKey());
        this.logNewTrackTitleToSerialPort(mediaDetailInfo.getTitle());
    }

    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        this.getLabelModel(200592).setText(playTime.getRestrictedPlayTimeStr());
        this.getLabelModel(200593).setText(playTime.getRemainTimeStr());
        this.getRangeModel(200594).setValue(playTime.getProgress());
        this.trackTimeModelGroup.flush();
        if (bl) {
            this.invalidateCoverArt();
        }
    }

    public void coverArtChanged(ResourceLocator resourceLocator) {
        this.logger.hmi().log(1000000, "[%1.coverArtChanged] '%2'", (Object)LOGCLASS, (Object)resourceLocator);
        int n = resourceLocator == null ? -1 : resourceLocator.getId();
        String string = resourceLocator == null ? ResourceLocatorModelApp.UNDEFINED_URI : resourceLocator.getUrl();
        this.getResourceLocatorModel(200588).setResourceLocator(n, string, 0);
    }

    public void playEntry(long l, I18NString i18NString) {
        this.logger.main().log(1000000, "[%1.playEntry] entryID='%2',title='%3'", (Object)LOGCLASS, (Object)String.valueOf(l), (Object)i18NString);
        PlayingTrack playingTrack = this.getCurrentPlayingTrack();
        this.playEntry(l);
        if (playingTrack.getEntryID() != l) {
            this.logger.main().log(10000000, "[%1.playEntry] Change track.", (Object)LOGCLASS);
            this.getLabelModel(200544).setText(i18NString.getI18NString());
            this.getChoiceModel(200596).setValue(i18NString.getI18NKey());
            this.getLabelModel(200543).setText("");
            this.getLabelModel(200592).setText("-:-");
            this.getLabelModel(200593).setText("-:-");
            this.getRangeModel(200594).setValue(0);
            this.trackTimeModelGroup.flush();
        }
    }

    public boolean playTrackNumber(int n) {
        this.logger.main().log(1000000, "[%1.playTrackNumber] trackNumber='%2'", (Object)LOGCLASS, (long)n);
        long l = this.playViewList.getEntryID(n);
        if (l != -1L) {
            this.playEntry(l);
            return true;
        }
        return false;
    }

    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 30: {
                this.logger.main().log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_PLAYER_SEEKTOTIME_ENTER", (Object)LOGCLASS);
                this.manualSeekHandler.manualSeekModeEnter();
                break;
            }
            case 31: {
                this.logger.main().log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_PLAYER_SEEKTOTIME_LEFT", (Object)LOGCLASS);
                this.manualSeekHandler.manualSeekModeLeave(false);
                break;
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }
}

