/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.coverflow;

import de.audi.app.media.dsi.coverflow.CoverflowDSIControllerImpl;
import de.audi.app.media.dsi.coverflow.ICoverflowListener;
import de.audi.app.media.dsi.coverflow.MediaAlbumInfo;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.albumbrowser.AlbumEntryInfo;
import org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener;

public class CoverflowDSIListener
implements DSIAlbumBrowserListener {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final CoverflowDSIControllerImpl controller;

    public CoverflowDSIListener(LogChannel logChannel, CoverflowDSIControllerImpl coverflowDSIControllerImpl) {
        this.logger = logChannel;
        this.controller = coverflowDSIControllerImpl;
    }

    @Override
    public void selectAlbum(long l) {
        this.logger.log(1078071040, "[%1.selectAlbum] [%2] '%3'.", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID(), l);
        ICoverflowListener iCoverflowListener = this.controller.getCoverflowListener();
        if (iCoverflowListener == null) {
            return;
        }
        iCoverflowListener.responseSelectedAlbum(l);
    }

    @Override
    public void albumIdxForFID(long l, long l2) {
        this.logger.log(1078071040, "[%1.albumIdxForFID] [%2] idx='%3', fid='%4'.", (Object)"CoverflowDSIListener", (Object)new Integer(this.controller.getInstanceID()), (Object)new Long(l2), (Object)new Long(l));
        ICoverflowListener iCoverflowListener = this.controller.getCoverflowListener();
        if (iCoverflowListener == null) {
            return;
        }
        iCoverflowListener.responseAlbumIdxForFid(l2, l);
    }

    @Override
    public void updateBrowserState(int n, int n2) {
        if (!this.isValid(n2, "updateBrowserState", this.controller.getInstanceID(), new Integer(n))) {
            return;
        }
        ICoverflowListener iCoverflowListener = this.controller.getCoverflowListener();
        if (iCoverflowListener == null) {
            return;
        }
        switch (n) {
            case 0: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_UNKNOWN", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(0);
                break;
            }
            case 1: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_INITIALIZED", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(1);
                break;
            }
            case 2: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_ACTIVE", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(2);
                break;
            }
            case 3: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_SCROLLING", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(3);
                break;
            }
            case 4: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_SELECTING", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(4);
                break;
            }
            case 5: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_ANIMATION_ENTRY", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(8);
                break;
            }
            case 6: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_PREVIEW", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(5);
                break;
            }
            case 7: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_ANIMATION_OPEN", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(6);
                break;
            }
            case 8: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_ANIMATION_CLOSE", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(7);
                break;
            }
            case 9: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_ANIMATION_PREV_OPEN", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(9);
                break;
            }
            case 12: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_ANIMATION_PREV_CLOSE", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(10);
                break;
            }
            case 10: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_ANIMATION_PREVSCROLLING", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(11);
                break;
            }
            case 11: {
                this.logger.log(1078071040, "[%1.updateBrowserState] [%2] BROWSERSTATE_STATE_SINGLE", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateBrowserState(12);
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1.updateBrowserState] [%2] Invalid browser state '%3' received.", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID(), (long)n);
            }
        }
    }

    @Override
    public void updateFocusedEntry(AlbumEntryInfo albumEntryInfo, int n) {
        if (!this.isValid(n, "updateFocusedEntry", this.controller.getInstanceID(), albumEntryInfo)) {
            return;
        }
        this.logger.log(1078071040, "[%1.updateFocusedEntry] [%2] '%3'.", (Object)"CoverflowDSIListener", (Object)new Integer(this.controller.getInstanceID()), (Object)albumEntryInfo);
        if (albumEntryInfo == null) {
            return;
        }
        ICoverflowListener iCoverflowListener = this.controller.getCoverflowListener();
        if (iCoverflowListener == null) {
            return;
        }
        iCoverflowListener.updateFocusedEntry(new MediaAlbumInfo(albumEntryInfo));
    }

    @Override
    public void updateNumEntries(long l, int n) {
        if (!this.isValid(n, "updateNumEntries", this.controller.getInstanceID(), new Long(l))) {
            return;
        }
        this.logger.log(1078071040, "[%1.updateNumEntries] [%2] '%3'.", (Object)"CoverflowDSIListener", (Object)new Integer(this.controller.getInstanceID()), l);
        ICoverflowListener iCoverflowListener = this.controller.getCoverflowListener();
        if (iCoverflowListener == null) {
            return;
        }
        iCoverflowListener.updateNumEntries(l);
    }

    @Override
    public void updateScrollMode(int n, int n2) {
        if (!this.isValid(n2, "updateScrollMode", this.controller.getInstanceID(), new Integer(n))) {
            return;
        }
        ICoverflowListener iCoverflowListener = this.controller.getCoverflowListener();
        if (iCoverflowListener == null) {
            return;
        }
        switch (n) {
            case 1: {
                this.logger.log(1078071040, "[%1.updateScrollMode] [%2] SCROLLMODE_FAST.", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateScrollMode(1);
                break;
            }
            case 0: {
                this.logger.log(1078071040, "[%1.updateScrollMode] [%2] SCROLLMODE_NORMAL.", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID());
                iCoverflowListener.updateScrollMode(0);
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1.updateScrollMode] [%2] Invalid scroll mode %3 received.", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID(), (long)n);
            }
        }
    }

    @Override
    public void updateListPosition(long l, int n) {
        if (!this.isValid(n, "updateListPosition", this.controller.getInstanceID(), new Long(l))) {
            return;
        }
        this.logger.log(1078071040, "[%1.updateListPosition] [%2] '%3'.", (Object)"CoverflowDSIListener", (long)this.controller.getInstanceID(), l);
        ICoverflowListener iCoverflowListener = this.controller.getCoverflowListener();
        if (iCoverflowListener == null) {
            return;
        }
        iCoverflowListener.updateListPosition(l);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        Buffer buffer = new Buffer(20);
        buffer.append("errorCode='").append(n).append("',requestType='").append(n2).append("',msg='").append(string).append("'");
        this.logger.log(10000, "[%1.asyncException] [%2] %3", (Object)"CoverflowDSIListener", (Object)new Integer(this.controller.getInstanceID()), (Object)buffer);
        ICoverflowListener iCoverflowListener = this.controller.getCoverflowListener();
        if (iCoverflowListener == null) {
            return;
        }
        iCoverflowListener.asyncException(n, string, n2);
    }

    private boolean isValid(int n, String string, int n2, Object object) {
        switch (n) {
            case 1: {
                return true;
            }
        }
        this.logger.log(-2137614336, "[%1.%2] [%3] Receive invalid DSI event (value='%4').", (Object)"CoverflowDSIListener", (Object)string, (Object)new Integer(n2), object);
        return false;
    }
}

