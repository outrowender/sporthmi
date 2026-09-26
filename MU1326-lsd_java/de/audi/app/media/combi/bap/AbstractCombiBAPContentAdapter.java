/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.ICombiBAPContentAccessor;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;
import de.audi.app.media.combi.bap.NullCombiBAPContentAccessor;
import de.audi.app.media.content.IContent;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.log.LogChannel;

public abstract class AbstractCombiBAPContentAdapter
implements ICombiBAPContentAdapter {
    private static final String LOGCLASS;
    private static final NullCombiBAPContentAccessor NULL_COMBI_BAP_ACCESSOR;
    protected final LogChannel logger;
    private volatile ICombiBAPContentAccessor combiAccessor;
    private volatile ISource source;

    public AbstractCombiBAPContentAdapter(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public void init() {
    }

    @Override
    public void deinit() {
    }

    @Override
    public void activate(IContent iContent, ICombiBAPContentAccessor iCombiBAPContentAccessor) {
        this.logger.log(1078071040, "[%1.activate]", (Object)"AbstractCombiBAPContentAdapter");
        this.combiAccessor = iCombiBAPContentAccessor;
        if (null != iContent.getActiveSlot()) {
            this.source = iContent.getActiveSlot().getSource();
        } else {
            this.logger.log(-1601830656, "[%1.activate] active slot is null", (Object)"AbstractCombiBAPContentAdapter");
        }
    }

    @Override
    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"AbstractCombiBAPContentAdapter");
        this.combiAccessor = NULL_COMBI_BAP_ACCESSOR;
        this.source = null;
    }

    public final ICombiBAPContentAccessor getCombiAccessor() {
        return this.combiAccessor;
    }

    protected final ISource getActiveSource() {
        return this.source;
    }

    @Override
    public void gotoCurrentPlayingTrack() {
        this.combiAccessor.gotoCurrentPlayingTrackResult(false);
    }

    @Override
    public void gotoParentFolder() {
        this.logger.log(1078071040, "[%1.gotoParentFolder]", (Object)"AbstractCombiBAPContentAdapter");
        this.combiAccessor.gotoParentFolderResult(false);
    }

    @Override
    public void gotoRootFolder() {
        this.logger.log(14808325, "[%1.gotoRootFolder]", (Object)"AbstractCombiBAPContentAdapter");
        this.combiAccessor.gotoRootFolderResult(false);
    }

    @Override
    public void gotoSubFolder(CombiBAPMediaEntry combiBAPMediaEntry) {
        this.logger.log(14808325, "[%1.gotoSubFolder]", (Object)"AbstractCombiBAPContentAdapter");
        this.combiAccessor.gotoSubFolderResult(false);
    }

    @Override
    public void requestListByEntryID(int n, CombiBAPMediaEntry combiBAPMediaEntry, int n2) {
        this.logger.log(14808325, "[%1.requestListByEntryID]", (Object)"AbstractCombiBAPContentAdapter");
        this.combiAccessor.responseList(n, 0, 0, new MediaListEntry[0]);
    }

    @Override
    public void requestListByIndex(int n, int n2, int n3) {
        this.logger.log(14808325, "[%1.requestListByIndex]", (Object)"AbstractCombiBAPContentAdapter");
        this.combiAccessor.responseList(n, 0, 0, new MediaListEntry[0]);
    }

    @Override
    public void getNextListPos(CombiBAPMediaEntry combiBAPMediaEntry, int n) {
        this.logger.log(14808325, "[%1.getNextListPos]", (Object)"AbstractCombiBAPContentAdapter");
        this.combiAccessor.getNextListPosResult(false, combiBAPMediaEntry, null, 0);
    }

    @Override
    public void selectListEntry(CombiBAPMediaEntry combiBAPMediaEntry) {
        this.logger.log(14808325, "[%1.selectListEntry]", (Object)"AbstractCombiBAPContentAdapter");
        this.combiAccessor.selectListEntryResult(false);
    }

    @Override
    public boolean setRepeatScope(int n, boolean bl) {
        return false;
    }

    @Override
    public boolean skip(boolean bl, int n) {
        return false;
    }

    @Override
    public void startSeek(boolean bl) {
        this.logger.log(14808325, "[%1.startSeek]", (Object)"AbstractCombiBAPContentAdapter");
        this.combiAccessor.updateSeekState(false);
    }

    @Override
    public void stopSeek() {
        this.logger.log(14808325, "[%1.stopSeek]", (Object)"AbstractCombiBAPContentAdapter");
        this.combiAccessor.updateSeekState(false);
    }

    @Override
    public int getCurrentRepeatScope() {
        return -1;
    }

    @Override
    public boolean isMixActive() {
        return false;
    }

    @Override
    public void updateActiveSlot(ISourceSlot iSourceSlot) {
    }

    static {
        NULL_COMBI_BAP_ACCESSOR = new NullCombiBAPContentAccessor();
    }
}

