/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.ui.mib2.Commands$StateGridResourceAvailablePayload;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.GridResourceAvailableTask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import java.util.List;
import java.util.Set;

class RemoteHMIService$10
extends AbstractCommandHandler {
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$10(RemoteHMIService remoteHMIService, String string) {
        this.this$0 = remoteHMIService;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void indicateCommand(int n, Object object) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        Commands$StateGridResourceAvailablePayload commands$StateGridResourceAvailablePayload = (Commands$StateGridResourceAvailablePayload)object;
        String string = commands$StateGridResourceAvailablePayload.getContextName();
        this.this$0.logChannel.log(1078071040, "RemoteHMIService#indicateCommand: grid-resource-available: called with contextName '%1'", (Object)string);
        RemoteHMIContext remoteHMIContext = this.this$0.getContextManagerComponent().getContext(string);
        if (remoteHMIContext == null) {
            this.this$0.logChannel.log(1078071040, "RemoteHMIService#indicateCommand: grid-resource-available: cancelled because context '%1' is not available anymore", (Object)string);
            return;
        }
        HMIProperties hMIProperties = commands$StateGridResourceAvailablePayload.getProperties();
        Object object2 = hMIProperties.get("gridList");
        if (!(object2 instanceof IGridList)) {
            this.this$0.logChannel.log(10000, "RemoteHMIService#indicateCommand: grid-resource-available: gridList is null for context '%1' and properties = %2.", (Object)string, (Object)hMIProperties);
            return;
        }
        IGridList iGridList = (IGridList)object2;
        List list = commands$StateGridResourceAvailablePayload.getLocalLocations();
        List list2 = iGridList;
        synchronized (list2) {
            int n2 = iGridList.updateAllCellImages(list);
            bl3 = n2 != 0;
            bl2 = iGridList.updateAllDecoratorImages(list);
        }
        list2 = HMIProperties.getResourceProperties();
        Set set = hMIProperties.replaceStringValue(list2, list);
        boolean bl4 = bl = !set.isEmpty();
        if (!this.this$0.getContextManagerComponent().isContextActive(remoteHMIContext)) {
            this.this$0.logChannel.log(1078071040, "RemoteHMIService#indicateCommand: grid-resource-available: not rendering because '%1' is not the active context", (Object)string);
            return;
        }
        if (!(bl3 || bl || bl2)) {
            String string2 = "RemoteHMIService#indicateCommand: grid-resource-available: not rendering because no image changes in context '%1'.";
            this.this$0.logChannel.log(1078071040, string2, (Object)string);
            return;
        }
        AbstractHMIViewListener abstractHMIViewListener = remoteHMIContext.getViewListener();
        if (bl) {
            String string3 = "RemoteHMIService#indicateCommand: grid-resource-available: applying property changes in context '%1'.";
            this.this$0.logChannel.log(1078071040, string3, (Object)string);
            this.this$0.applyPropertyChanges(abstractHMIViewListener, set, hMIProperties);
        }
        int n3 = bl3 ? 3 : 0;
        this.this$0.updateViews(this.this$0.logChannel, string, iGridList, bl2, set, abstractHMIViewListener, n3);
    }

    @Override
    public RemoteHMITask createTask(int n, Object object) {
        Commands$StateGridResourceAvailablePayload commands$StateGridResourceAvailablePayload = (Commands$StateGridResourceAvailablePayload)object;
        return new GridResourceAvailableTask(this, commands$StateGridResourceAvailablePayload.getContextName(), this.getFullName(), n, commands$StateGridResourceAvailablePayload, this.this$0.logChannel);
    }
}

