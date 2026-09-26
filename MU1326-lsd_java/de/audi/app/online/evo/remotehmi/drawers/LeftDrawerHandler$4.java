/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.LeftDrawerHandler;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.Commands$SelectedLeftDrawerEntryPayload;
import de.audi.remotehmi.ui.mib2.DrawerEntryLeftDrawer;
import de.audi.remotehmi.util.LogAppender;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class LeftDrawerHandler$4
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$log;
    private final /* synthetic */ RemoteHMIService val$remoteHMIService;
    private final /* synthetic */ LeftDrawerHandler this$0;

    LeftDrawerHandler$4(LeftDrawerHandler leftDrawerHandler, String string, LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.this$0 = leftDrawerHandler;
        this.val$log = logChannel;
        this.val$remoteHMIService = remoteHMIService;
        super(string);
    }

    @Override
    protected LogAppender getParamsForDebugging(Object object) {
        return LogAppender$Factory.fromString(((Commands$SelectedLeftDrawerEntryPayload)object).getContextName());
    }

    @Override
    public void indicateCommand(int n, Object object) {
        Commands$SelectedLeftDrawerEntryPayload commands$SelectedLeftDrawerEntryPayload = (Commands$SelectedLeftDrawerEntryPayload)object;
        String string = commands$SelectedLeftDrawerEntryPayload.idValue;
        String string2 = commands$SelectedLeftDrawerEntryPayload.getContextName();
        this.val$log.log(1078071040, "LeftDrawerHandler#indicateCommand: Commands.STATE_SELECTED_LEFT_DRAWER_ENTRY and contextName '%1'", (Object)string2);
        DrawerEntryLeftDrawer drawerEntryLeftDrawer = LeftDrawerHandler.access$700(this.this$0, string);
        this.this$0.setCurrentlySelectedLeftDrawerEntry(drawerEntryLeftDrawer, LeftDrawerHandler.access$800(this.this$0).getContext(string2));
        this.val$remoteHMIService.flushModelGroup();
    }
}

