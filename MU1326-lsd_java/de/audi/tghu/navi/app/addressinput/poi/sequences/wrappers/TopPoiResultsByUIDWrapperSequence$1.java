/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.TopPoiResultsByUIDWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class TopPoiResultsByUIDWrapperSequence$1
extends NavCommand {
    private final /* synthetic */ TopPoiResultsByUIDWrapperSequence this$0;

    TopPoiResultsByUIDWrapperSequence$1(TopPoiResultsByUIDWrapperSequence topPoiResultsByUIDWrapperSequence) {
        this.this$0 = topPoiResultsByUIDWrapperSequence;
    }

    @Override
    public void execute() {
        this.this$0.initialSpellerState = this.dsiResponseContainer.getSpellerState();
        this.getCommandList().commandFinished();
    }
}

