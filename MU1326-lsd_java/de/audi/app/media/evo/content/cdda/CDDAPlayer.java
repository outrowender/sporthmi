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
    private static final String LOGCLASS;
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

    @Override
    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"CDDAPlayer");
        super.init();
        this.getTerminal().getMediaPersistence().registerIntProperty("GLOBAL_KEY_DVDC_REPEAT_SCOPE", 0, 1, 0);
        RangeModelApp rangeModelApp = this.getRangeModel(-1844509952);
        rangeModelApp.setLimits(0, 100, 1);
        rangeModelApp.setValue(0);
        this.trackTimeModelGroup.add(this.getModel(-1878064384));
        this.trackTimeModelGroup.add(this.getModel(-1861287168));
        this.trackTimeModelGroup.add(rangeModelApp);
        this.playViewList.init();
    }

    @Override
    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"CDDAPlayer");
        super.deinit();
        this.trackTimeModelGroup.removeAll();
        this.playViewList.deinit();
    }

    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"CDDAPlayer");
        int n = iActivationContext.getSlot().getSource().getType();
        PlaybackModeHandler playbackModeHandler = n == 1 || n == 3 ? new CDDAPlaybackModeHandler(this.getTerminal(), this, true) : new PlaybackModeHandler(this.getTerminal(), this, true);
        super.activate(iActivationContext, playbackModeHandler);
        this.manualSeekHandler.activate();
        this.getChoiceModel(1997538048).setValue(0);
        this.getTerminal().addActionProxyListener(new int[]{31, 30}, (IActionProxyListener)this);
        this.addTrackListener(this);
    }

    @Override
    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"CDDAPlayer");
        super.deactivate();
        this.manualSeekHandler.deactivate();
        this.getTerminal().removeActionProxyListener(this);
        this.clearDetailInfo();
        this.invalidateCoverArt();
        this.playViewList.deactivate();
        this.getTerminal().getSDSDispatcher().removeCommandListener(this.getTerminal().getTerminalID(), this.sdsCommandHandler);
        this.getChoiceModel(1997538048).setValue(0);
    }

    @Override
    protected void playerStartupComplete() {
        this.logger.main().log(1078071040, "[%1.playerStartupComplete]", (Object)"CDDAPlayer");
        super.playerStartupComplete();
        this.logger.main().log(1078071040, "[%1.playerStartupComplete] Activate play view", (Object)"CDDAPlayer");
        this.playViewList.activate();
        this.getTerminal().getSDSDispatcher().addCommandListener(this.getTerminal().getTerminalID(), this.sdsCommandHandler);
    }

    private void invalidateCoverArt() {
        this.getResourceLocatorModel(-1945173248).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI, 1);
    }

    private void clearDetailInfo() {
        this.logger.main().log(1078071040, "[%1.clearDetailInfo]", (Object)"CDDAPlayer");
        this.getLabelModel(1611596544).setText("");
        this.getChoiceModel(-1810955520).setValue(0);
        this.getLabelModel(1578042112).setText("");
        this.getChoiceModel(-1978727680).setValue(0);
        this.getLabelModel(1594819328).setText("");
        this.getChoiceModel(-1961950464).setValue(0);
    }

    @Override
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logger.main().log(1078071040, "[%1.detailInfoChanged]", (Object)"CDDAPlayer");
        this.getLabelModel(1611596544).setText(mediaDetailInfo.getTitle().getI18NString());
        this.getChoiceModel(-1810955520).setValue(mediaDetailInfo.getTitle().getI18NKey());
        this.getLabelModel(1578042112).setText(mediaDetailInfo.getAlbum().getI18NString());
        this.getChoiceModel(-1978727680).setValue(mediaDetailInfo.getAlbum().getI18NKey());
        this.getLabelModel(1594819328).setText(mediaDetailInfo.getArtist().getI18NString());
        this.getChoiceModel(-1961950464).setValue(mediaDetailInfo.getArtist().getI18NKey());
        this.logNewTrackTitleToSerialPort(mediaDetailInfo.getTitle());
    }

    @Override
    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        this.getLabelModel(-1878064384).setText(playTime.getRestrictedPlayTimeStr());
        this.getLabelModel(-1861287168).setText(playTime.getRemainTimeStr());
        this.getRangeModel(-1844509952).setValue(playTime.getProgress());
        this.trackTimeModelGroup.flush();
        if (bl) {
            this.invalidateCoverArt();
        }
    }

    @Override
    public void coverArtChanged(ResourceLocator resourceLocator) {
        this.logger.hmi().log(1078071040, "[%1.coverArtChanged] '%2'", (Object)"CDDAPlayer", (Object)resourceLocator);
        int n = resourceLocator == null ? -1 : resourceLocator.getId();
        String string = resourceLocator == null ? ResourceLocatorModelApp.UNDEFINED_URI : resourceLocator.getUrl();
        this.getResourceLocatorModel(-1945173248).setResourceLocator(n, string, 0);
    }

    public void playEntry(long l, I18NString i18NString) {
        this.logger.main().log(1078071040, "[%1.playEntry] entryID='%2',title='%3'", (Object)"CDDAPlayer", (Object)String.valueOf(l), (Object)i18NString);
        PlayingTrack playingTrack = this.getCurrentPlayingTrack();
        this.playEntry(l);
        if (playingTrack.getEntryID() != l) {
            this.logger.main().log(-2137614336, "[%1.playEntry] Change track.", (Object)"CDDAPlayer");
            this.getLabelModel(1611596544).setText(i18NString.getI18NString());
            this.getChoiceModel(-1810955520).setValue(i18NString.getI18NKey());
            this.getLabelModel(1594819328).setText("");
            this.getLabelModel(-1878064384).setText("-:-");
            this.getLabelModel(-1861287168).setText("-:-");
            this.getRangeModel(-1844509952).setValue(0);
            this.trackTimeModelGroup.flush();
        }
    }

    public boolean playTrackNumber(int n) {
        this.logger.main().log(1078071040, "[%1.playTrackNumber] trackNumber='%2'", (Object)"CDDAPlayer", (long)n);
        long l = this.playViewList.getEntryID(n);
        if (l != -1L) {
            this.playEntry(l);
            return true;
        }
        return false;
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 30: {
                this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_PLAYER_SEEKTOTIME_ENTER", (Object)"CDDAPlayer");
                this.manualSeekHandler.manualSeekModeEnter();
                break;
            }
            case 31: {
                this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_PLAYER_SEEKTOTIME_LEFT", (Object)"CDDAPlayer");
                this.manualSeekHandler.manualSeekModeLeave(false);
                break;
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("CDDAPlayer").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }
}

