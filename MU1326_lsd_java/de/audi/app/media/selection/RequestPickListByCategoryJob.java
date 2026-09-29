/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.selection.DataSelectionByCategoryJob;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.IPickListListener;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.atip.log.LogChannel;

public class RequestPickListByCategoryJob
extends DataSelectionByCategoryJob {
    public static final String KEY_PICKLIST_LISTENER;
    public static final String KEY_PICKLIST_ENTRIES;
    static final String LOGCLASS;
    final IPickListListener picklistListener;

    public RequestPickListByCategoryJob(LogChannel logChannel, SelectionBrowser selectionBrowser, IDataSelectionContext iDataSelectionContext, IPlayer iPlayer) {
        super(logChannel, selectionBrowser, iDataSelectionContext, iPlayer);
        this.picklistListener = (IPickListListener)iDataSelectionContext.getParameter("KEY_PICKLIST_LISTENER", null);
    }

    @Override
    public String getName() {
        return "RequestPickListByCategoryJob";
    }

    @Override
    public void performSelection() {
        this.logger.log(1078071040, "[%1.performSelection] requestPicklist", (Object)"RequestPickListByCategoryJob");
        this.selectionBrowser.requestPickList((long[])this.selectionContainer.getParameter("KEY_PICKLIST_ENTRIES", new long[0]));
    }

    @Override
    public void responsePicklist(boolean bl, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(1078071040, "[%1.responsePicklist] responsePicklist '%2'", (Object)"RequestPickListByCategoryJob", (Object)bl);
        this.notifyPickListListener(!bl, mediaListEntryArray);
        this.finishJob();
    }

    @Override
    public void abort(boolean bl) {
        if (bl) {
            this.notifyPickListListener(false, null);
        }
        super.abort(bl);
    }

    @Override
    protected void browseModeError() {
        this.abort(true);
    }

    @Override
    protected void browseFolderError() {
        this.abort(true);
    }

    private void notifyPickListListener(boolean bl, MediaListEntry[] mediaListEntryArray) {
        if (this.picklistListener != null) {
            this.picklistListener.responsePicklist(mediaListEntryArray, bl);
        }
    }
}

