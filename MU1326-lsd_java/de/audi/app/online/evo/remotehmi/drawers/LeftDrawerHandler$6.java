/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.LeftDrawerHandler;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class LeftDrawerHandler$6
extends AbstractRemoteHMITask {
    private final /* synthetic */ EvoListRow val$evoListRow;
    private final /* synthetic */ int val$model;
    private final /* synthetic */ LeftDrawerHandler this$0;

    LeftDrawerHandler$6(LeftDrawerHandler leftDrawerHandler, String string, EvoListRow evoListRow, int n) {
        this.this$0 = leftDrawerHandler;
        this.val$evoListRow = evoListRow;
        this.val$model = n;
        super(string);
    }

    @Override
    public void run() {
        LeftDrawerHandler.access$900(this.this$0, this.val$evoListRow, this.val$model);
    }
}

