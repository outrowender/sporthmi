/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.ui.mib2.grid.ICursor;
import de.audi.remotehmi.ui.mib2.grid.IPageHistory;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.CircularMap;
import de.esolutions.fw.util.commons.Buffer;

public class RemoteHMIContext {
    private HMIProperties viewProperties;
    private AbstractHMIViewListener viewListener;
    private String viewId = "";
    private RemoteHMIAction lastAction;
    private String currentlySelectedLeftDrawerEntryId;
    private String currentlySelectedLeftDrawerSubEntryId;
    protected int viewType = 0;
    private final String contextName;
    private final int HISTORY_BUFFER_SIZE;
    CircularMap cursorHistory = new CircularMap(100);
    CircularMap pageHistory = new CircularMap(100);
    private boolean leftDrawerAvailable;

    public RemoteHMIContext(String string) {
        this.HISTORY_BUFFER_SIZE = 100;
        if (string == null) {
            throw new NullPointerException("Null not allowed. Please give a proper name when creating a context!");
        }
        this.contextName = string;
    }

    public AbstractHMIViewListener getViewListener() {
        return this.viewListener;
    }

    public HMIProperties getViewProperties() {
        return this.viewProperties;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void updateContext(int n, String string, HMIProperties hMIProperties, AbstractHMIViewListener abstractHMIViewListener) {
        this.viewType = n;
        this.viewId = string;
        this.viewProperties = hMIProperties;
        this.viewListener = abstractHMIViewListener;
    }

    public void updateHMIProperties(HMIProperties hMIProperties) {
        this.viewProperties = hMIProperties;
    }

    public String getViewId() {
        return this.viewId;
    }

    public void setLastAction(RemoteHMIAction remoteHMIAction) {
        this.lastAction = remoteHMIAction;
    }

    public RemoteHMIAction getLastAction() {
        return this.lastAction;
    }

    public int getLastActionType() {
        if (this.lastAction == null) {
            return 0;
        }
        return this.lastAction.getType();
    }

    public String getContextName() {
        return this.contextName;
    }

    public ICursor getOldCursor() {
        return (ICursor)this.cursorHistory.get(this.viewId);
    }

    public IPageHistory getPageHistory() {
        return (IPageHistory)this.pageHistory.get(this.viewId);
    }

    public void setPageHistory(IPageHistory iPageHistory) {
        if (iPageHistory == null) {
            throw new IllegalArgumentException("RemoteHMIContext#setPageHistory: pagehistory is null!");
        }
        this.pageHistory.put(this.viewId, iPageHistory);
    }

    public void setNewCursor(ICursor iCursor) {
        if (iCursor == null) {
            throw new IllegalArgumentException("RemoteHMIContext#setNewCursor: cursor is null!");
        }
        this.cursorHistory.put(this.viewId, iCursor);
    }

    public boolean hasCursor() {
        return this.cursorHistory.containsKey(this.viewId);
    }

    public boolean hasPageHistory() {
        return this.pageHistory.containsKey(this.viewId);
    }

    public void removeLastPageHistory() {
        this.pageHistory.removeLastKey();
    }

    public void removeLastCursor() {
        this.cursorHistory.removeLastKey();
    }

    public String getCurrentlySelectedLeftDrawerEntryId() {
        return this.currentlySelectedLeftDrawerEntryId;
    }

    public void setCurrentlySelectedLeftDrawerEntryId(String string) {
        this.currentlySelectedLeftDrawerEntryId = string;
    }

    public String getCurrentlySelectedLeftDrawerSubEntryId() {
        return this.currentlySelectedLeftDrawerSubEntryId;
    }

    public void setCurrentlySelectedLeftDrawerSubEntryId(String string) {
        this.currentlySelectedLeftDrawerSubEntryId = string;
    }

    public boolean isLeftDrawerAvailable() {
        return this.leftDrawerAvailable;
    }

    public void setLeftDrawerAvailable(boolean bl) {
        this.leftDrawerAvailable = bl;
    }

    public void onContextExit() {
        if (this.viewListener != null) {
            this.viewListener.onApplicationExit(this);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("RemoteHMIContext: ");
        buffer.append(this.contextName);
        return buffer.toString();
    }
}

