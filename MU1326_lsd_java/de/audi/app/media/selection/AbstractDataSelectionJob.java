/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.IDataSelectionJob;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractDataSelectionJob
extends AbstractQueueJob
implements IDataSelectionJob {
    protected final SelectionBrowser selectionBrowser;
    protected final IDataSelectionContext selectionContainer;
    protected final LogChannel logger;
    protected int state;
    protected final int STATE_UNKNOWN;
    protected final int STATE_STARTUP;
    protected final int STATE_BROWSER_ACTIVATED;
    protected final int STATE_BROWSE_MODE_CHANGED;
    protected final int STATE_BROWSER_DEACTIVATED;

    public AbstractDataSelectionJob(LogChannel logChannel, SelectionBrowser selectionBrowser, IDataSelectionContext iDataSelectionContext) {
        this.STATE_UNKNOWN = 0;
        this.STATE_STARTUP = 1;
        this.STATE_BROWSER_ACTIVATED = 2;
        this.STATE_BROWSE_MODE_CHANGED = 3;
        this.STATE_BROWSER_DEACTIVATED = 4;
        this.logger = logChannel;
        this.selectionBrowser = selectionBrowser;
        this.selectionContainer = iDataSelectionContext;
        this.state = 1;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public void abort(boolean bl) {
        this.selectionBrowser.responseSetSelection(false, this.selectionContainer);
        if (bl) {
            this.setState(4);
            this.selectionBrowser.deactivate();
        }
    }

    @Override
    public void start() {
        this.setState(1);
        this.selectionBrowser.activate(this.selectionContainer.getSourceSlot());
    }

    @Override
    public void browserActivated() {
        this.setState(2);
        this.selectionBrowser.setBrowseMode(this.selectionContainer.getBrowseMode());
    }

    public int getBrowserID() {
        return this.selectionBrowser.getBrowserID();
    }

    public boolean waitForPlayposition() {
        return false;
    }

    @Override
    public void browseModeChanged(boolean bl, int n) {
        if (bl) {
            this.browseModeError();
            return;
        }
        this.setState(3);
        if (null != this.selectionContainer.getFolder()) {
            this.selectionBrowser.changeFolder(this.selectionContainer.getFolder());
        } else {
            this.performSelection();
        }
    }

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        if (bl) {
            this.browseFolderError();
            return;
        }
        if (this.state != 3) {
            return;
        }
        this.performSelection();
    }

    @Override
    public abstract void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    public abstract void performSelection() {
    }

    @Override
    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
        if (bl || 0L >= l4) {
            this.abort(true);
        } else {
            this.playSelection();
        }
    }

    @Override
    public void responsePicklist(boolean bl, MediaListEntry[] mediaListEntryArray) {
    }

    public void finishJob() {
        if (this.state == 4) {
            this.logger.log(-1601830656, "[%1.finishJob] Browser already deactivated", (Object)this.getName());
            return;
        }
        this.setState(4);
        this.selectionBrowser.deactivate();
    }

    @Override
    public void browserDeactivated(boolean bl) {
        if (this.state == 4 || bl) {
            this.getExecutionContext().jobFinished();
        }
    }

    private void setState(int n) {
        this.state = n;
        switch (this.state) {
            case 1: {
                this.logger.log(1078071040, "[%1.setState STATE_STARTUP]", (Object)this.getName());
                break;
            }
            case 2: {
                this.logger.log(1078071040, "[%1.setState STATE_BROWSER_ACTIVATED]", (Object)this.getName());
                break;
            }
            case 3: {
                this.logger.log(1078071040, "[%1.setState STATE_BROWSE_MODE_CHANGED]", (Object)this.getName());
                break;
            }
            case 4: {
                this.logger.log(1078071040, "[%1.setState BROWSER_DEACTIVATED]", (Object)this.getName());
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.setState UNKNOWN]", (Object)this.getName());
            }
        }
    }

    public abstract void playSelection() {
    }

    protected abstract void browseModeError() {
    }

    protected abstract void browseFolderError() {
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("[").append(this.getName()).append(": ");
        buffer.append(this.selectionContainer).append(";");
        return buffer.toString();
    }
}

