/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.LeftDrawerHandler;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.Commands$SelectedLeftDrawerSubEntryPayload;
import de.audi.remotehmi.util.LogAppender;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;

class LeftDrawerHandler$5
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$log;
    private final /* synthetic */ LeftDrawerHandler this$0;

    LeftDrawerHandler$5(LeftDrawerHandler leftDrawerHandler, String string, LogChannel logChannel) {
        this.this$0 = leftDrawerHandler;
        this.val$log = logChannel;
        super(string);
    }

    @Override
    protected LogAppender getParamsForDebugging(Object object) {
        return LogAppender$Factory.fromString(((Commands$SelectedLeftDrawerSubEntryPayload)object).getContextName());
    }

    @Override
    public void indicateCommand(int n, Object object) {
        Commands$SelectedLeftDrawerSubEntryPayload commands$SelectedLeftDrawerSubEntryPayload = (Commands$SelectedLeftDrawerSubEntryPayload)object;
        String string = commands$SelectedLeftDrawerSubEntryPayload.idValue;
        String string2 = commands$SelectedLeftDrawerSubEntryPayload.getContextName();
        this.val$log.log(1078071040, "LeftDrawerHandler#indicateCommand: Commands.STATE_SELECTED_LEFT_DRAWER_SUB_ENTRY and contextName '%1'", (Object)string2);
        this.this$0.setCurrentlySelectedLeftDrawerSubEntry(string, LeftDrawerHandler.access$800(this.this$0).getContext(string2));
    }
}

