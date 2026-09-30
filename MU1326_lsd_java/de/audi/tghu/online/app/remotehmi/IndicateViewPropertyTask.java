/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIView;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;

public class IndicateViewPropertyTask
extends AbstractRemoteHMITask {
    private final RemoteHMIService remoteHMIService;
    private final String contextName;
    private final RemoteHMIView view;
    private final ContextManagerComponent contextManagerComponent;
    private final LogChannel logChannel;

    public IndicateViewPropertyTask(String string, LogAppender logAppender, RemoteHMIService remoteHMIService, String string2, RemoteHMIView remoteHMIView, ContextManagerComponent contextManagerComponent, LogChannel logChannel) {
        super(string, logAppender);
        this.remoteHMIService = remoteHMIService;
        this.contextName = string2;
        this.view = remoteHMIView;
        this.contextManagerComponent = contextManagerComponent;
        this.logChannel = logChannel;
    }

    public void run() {
        this.indicateViewPropertiesImmediately(this.contextName, this.view);
    }

    public Long getDelayMillis() {
        return new Long(0L);
    }

    public boolean isCoalescable() {
        return true;
    }

    public boolean coalesceWith(RemoteHMITask remoteHMITask) {
        if (!(remoteHMITask instanceof IndicateViewPropertyTask)) {
            return false;
        }
        IndicateViewPropertyTask indicateViewPropertyTask = (IndicateViewPropertyTask)remoteHMITask;
        boolean bl = this.contextName == indicateViewPropertyTask.contextName && this.view.getViewID().equals(indicateViewPropertyTask.view.getViewID());
        this.logChannel.log(1000000, "IndicateViewPropertyTask#coalesceWith: Task will %1 be coalesced with other.", (Object)(bl ? "" : "not"));
        if (bl) {
            indicateViewPropertyTask.view.setProperties(this.view.getProperties());
        }
        return bl;
    }

    private void indicateViewPropertiesImmediately(String string, RemoteHMIView remoteHMIView) {
        RemoteHMIContext remoteHMIContext = this.contextManagerComponent.getContext(string);
        if (remoteHMIContext == null) {
            this.logChannel.log(10000, "IndicateViewPropertyTask#indicateViewPropertiesImmediately: context is null. No screen update.");
            return;
        }
        if (remoteHMIView == null) {
            this.logChannel.log(100000, "IndicateViewPropertyTask#indicateViewPropertiesImmediately: update sending view is null. No screen update.");
            return;
        }
        String string2 = remoteHMIView.getViewID();
        int n = remoteHMIView.getViewType();
        String string3 = remoteHMIContext.getViewId();
        int n2 = remoteHMIContext.getViewType();
        if (string2 != string3 || n != n2) {
            String string4 = "UpdateAppListTask#indicateViewPropertiesImmediately: An update for a different view was sent. The update will be ignored. Update sent from view (type/id)='%1'/%2, but current view='%3'/%4";
            this.logChannel.log(100000, string4, (Object)new Integer(n), (Object)string2, (Object)new Integer(n2), (Object)string3);
            return;
        }
        HMIProperties hMIProperties = remoteHMIView.getProperties();
        remoteHMIContext.updateHMIProperties(hMIProperties);
        if (!this.contextManagerComponent.isContextActive(remoteHMIContext)) {
            this.logChannel.log(10000000, "IndicateViewPropertyTask#indicateViewPropertiesImmediately: context %1 not active", (Object)string);
            return;
        }
        if (!this.remoteHMIService.ignoreRemoteHMIActive() && !this.contextManagerComponent.isRemoteHMIActive()) {
            this.logChannel.log(10000000, "IndicateViewPropertyTask#indicateViewPropertiesImmediately: remoteHMI not active");
            return;
        }
        AbstractHMIViewListener abstractHMIViewListener = remoteHMIContext.getViewListener();
        if (abstractHMIViewListener == null) {
            this.logChannel.log(100000, "IndicateViewPropertyTask#indicateViewPropertiesImmediately: currentViewListener is NULL");
            return;
        }
        try {
            abstractHMIViewListener.updateViewProperties(hMIProperties, false, remoteHMIContext);
            this.remoteHMIService.flushModelGroup();
        }
        catch (Exception exception) {
            this.logChannel.log(100000, "IndicateViewPropertyTask#indicateViewPropertiesImmediately: Exception in updateViewProperties, %1", (Throwable)exception);
        }
    }
}

