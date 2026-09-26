/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.selection.AbstractDataSelectionJob;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.app.media.selection.PresetSelectionJob$1;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISourceController;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;

public class PresetSelectionJob
extends AbstractDataSelectionJob {
    private static final String LOGCLASS;
    private volatile MediaListEntry currentBrowsingFolder = null;
    private final ISourceController sourceController;
    private final ISelectionListener selectionListener;

    public PresetSelectionJob(SelectionBrowser selectionBrowser, IDataSelectionContext iDataSelectionContext, ISourceController iSourceController, LogChannel logChannel, ISelectionListener iSelectionListener) {
        super(logChannel, selectionBrowser, iDataSelectionContext);
        this.sourceController = iSourceController;
        this.selectionListener = iSelectionListener;
    }

    @Override
    public String getName() {
        return "PresetSelectionJob";
    }

    @Override
    public void start() {
        this.selectionBrowser.addSelectionListener(this.selectionListener);
        super.start();
    }

    @Override
    public void finishJob() {
        this.selectionBrowser.removeSelectionListener(this.selectionListener);
        super.finishJob();
    }

    @Override
    public void performSelection() {
        this.selectionBrowser.resetSelection();
        MediaListEntry mediaListEntry = this.selectionContainer.getFolderToSelect();
        if (null != mediaListEntry) {
            if (mediaListEntry.getEntryID() != -1L) {
                this.selectionBrowser.addSelection(true, 0, mediaListEntry.getEntryID(), mediaListEntry.getContentType(), false);
            } else if (this.currentBrowsingFolder != null) {
                this.selectionBrowser.addSelection(true, 0, this.currentBrowsingFolder.getEntryID(), this.currentBrowsingFolder.getContentType(), false);
            } else {
                this.abort(true);
            }
        } else {
            this.abort(true);
        }
    }

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        if (!bl) {
            this.currentBrowsingFolder = mediaListEntryArray[mediaListEntryArray.length - 1];
        }
        super.browseFolderChanged(bl, mediaListEntryArray, n);
    }

    @Override
    public void playSelection() {
        this.logger.log(1078071040, "[%1.triggerSourceActivation]", (Object)"PresetSelectionJob");
        ActivationContext activationContext = new ActivationContext(this.selectionContainer.getSourceSlot());
        activationContext.addParameter("SETPLAYSELECTION_BROWSERID", Util.createInteger(1));
        activationContext.addParameter("PLAYER_SELECTION_CALLBACK_HANDLER", new PresetSelectionJob$1(this));
        this.sourceController.activateSource(activationContext);
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    @Override
    protected void browseModeError() {
        this.selectionListener.notifySelectionChanged(null, false);
        this.finishJob();
    }

    @Override
    protected void browseFolderError() {
        this.selectionListener.notifySelectionChanged(null, false);
        this.finishJob();
    }
}

