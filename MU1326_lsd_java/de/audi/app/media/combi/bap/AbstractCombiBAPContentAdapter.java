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
    private static final String LOGCLASS = "AbstractCombiBAPContentAdapter";
    private static final NullCombiBAPContentAccessor NULL_COMBI_BAP_ACCESSOR = new NullCombiBAPContentAccessor();
    protected final LogChannel logger;
    private volatile ICombiBAPContentAccessor combiAccessor;
    private volatile ISource source;

    public AbstractCombiBAPContentAdapter(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void init() {
    }

    public void deinit() {
    }

    public void activate(IContent iContent, ICombiBAPContentAccessor iCombiBAPContentAccessor) {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.combiAccessor = iCombiBAPContentAccessor;
        if (null != iContent.getActiveSlot()) {
            this.source = iContent.getActiveSlot().getSource();
        } else {
            this.logger.log(100000, "[%1.activate] active slot is null", (Object)LOGCLASS);
        }
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.combiAccessor = NULL_COMBI_BAP_ACCESSOR;
        this.source = null;
    }

    public final ICombiBAPContentAccessor getCombiAccessor() {
        return this.combiAccessor;
    }

    protected final ISource getActiveSource() {
        return this.source;
    }

    public void gotoCurrentPlayingTrack() {
        this.combiAccessor.gotoCurrentPlayingTrackResult(false);
    }

    public void gotoParentFolder() {
        this.logger.log(1000000, "[%1.gotoParentFolder]", (Object)LOGCLASS);
        this.combiAccessor.gotoParentFolderResult(false);
    }

    public void gotoRootFolder() {
        this.logger.log(100000000, "[%1.gotoRootFolder]", (Object)LOGCLASS);
        this.combiAccessor.gotoRootFolderResult(false);
    }

    public void gotoSubFolder(CombiBAPMediaEntry combiBAPMediaEntry) {
        this.logger.log(100000000, "[%1.gotoSubFolder]", (Object)LOGCLASS);
        this.combiAccessor.gotoSubFolderResult(false);
    }

    public void requestListByEntryID(int n, CombiBAPMediaEntry combiBAPMediaEntry, int n2) {
        this.logger.log(100000000, "[%1.requestListByEntryID]", (Object)LOGCLASS);
        this.combiAccessor.responseList(n, 0, 0, new MediaListEntry[0]);
    }

    public void requestListByIndex(int n, int n2, int n3) {
        this.logger.log(100000000, "[%1.requestListByIndex]", (Object)LOGCLASS);
        this.combiAccessor.responseList(n, 0, 0, new MediaListEntry[0]);
    }

    public void getNextListPos(CombiBAPMediaEntry combiBAPMediaEntry, int n) {
        this.logger.log(100000000, "[%1.getNextListPos]", (Object)LOGCLASS);
        this.combiAccessor.getNextListPosResult(false, combiBAPMediaEntry, null, 0);
    }

    public void selectListEntry(CombiBAPMediaEntry combiBAPMediaEntry) {
        this.logger.log(100000000, "[%1.selectListEntry]", (Object)LOGCLASS);
        this.combiAccessor.selectListEntryResult(false);
    }

    public boolean setRepeatScope(int n, boolean bl) {
        return false;
    }

    public boolean skip(boolean bl, int n) {
        return false;
    }

    public void startSeek(boolean bl) {
        this.logger.log(100000000, "[%1.startSeek]", (Object)LOGCLASS);
        this.combiAccessor.updateSeekState(false);
    }

    public void stopSeek() {
        this.logger.log(100000000, "[%1.stopSeek]", (Object)LOGCLASS);
        this.combiAccessor.updateSeekState(false);
    }

    public int getCurrentRepeatScope() {
        return -1;
    }

    public boolean isMixActive() {
        return false;
    }

    public void updateActiveSlot(ISourceSlot iSourceSlot) {
    }
}

