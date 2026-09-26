/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguationCallback;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguatorSequence;

class LocationDisambiguatorSequence$2
extends NavCommand {
    private final /* synthetic */ int val$action;
    private final /* synthetic */ int val$modelId;
    private final /* synthetic */ int val$terminalId;
    private final /* synthetic */ ILocationDisambiguationCallback val$callback;
    private final /* synthetic */ LocationDisambiguatorSequence this$0;

    LocationDisambiguatorSequence$2(LocationDisambiguatorSequence locationDisambiguatorSequence, String string, int n, int n2, int n3, ILocationDisambiguationCallback iLocationDisambiguationCallback) {
        this.this$0 = locationDisambiguatorSequence;
        this.val$action = n;
        this.val$modelId = n2;
        this.val$terminalId = n3;
        this.val$callback = iLocationDisambiguationCallback;
        super(string);
    }

    @Override
    public void execute() {
        LocationDisambiguationWrapper locationDisambiguationWrapper = LocationDisambiguationWrapper.newBuilder().addDisambiguatedLocations(this.dsiResponseContainer.getDisambiguatedNavLocations()).addAction(this.val$action).addModelId(this.val$modelId).addTerminalId(this.val$terminalId).build();
        this.val$callback.locationDisambiguationCallback(locationDisambiguationWrapper);
        this.getCommandList().commandFinished();
    }
}

