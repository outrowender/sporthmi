/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;

class SpellerController$2
extends SpellerButtonArgument {
    private final /* synthetic */ int val$sdsOkButtonCommandModel;
    private final /* synthetic */ int val$sdsOkButtonCommand;
    private final /* synthetic */ SpellerController this$0;

    SpellerController$2(SpellerController spellerController, int n, int n2) {
        this.this$0 = spellerController;
        this.val$sdsOkButtonCommandModel = n;
        this.val$sdsOkButtonCommand = n2;
    }

    @Override
    public void execute() {
        if (AbstractWidget.sdsService != null) {
            AbstractWidget.sdsService.keyTyped(this.val$sdsOkButtonCommandModel, this.val$sdsOkButtonCommand);
        } else {
            IWidgetLogChannel.tpLogChannelInternal.log(-1601830656, "SpellerController#SpellerButtonArgument#execute sdsService is NULL!");
        }
    }
}

