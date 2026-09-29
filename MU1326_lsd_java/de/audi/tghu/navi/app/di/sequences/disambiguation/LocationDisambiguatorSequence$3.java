/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguationCallback;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguatorSequence;

class LocationDisambiguatorSequence$3
extends NavCommand {
    private final /* synthetic */ ILocationDisambiguationCallback val$callback;
    private final /* synthetic */ int val$action;
    private final /* synthetic */ int val$modelId;
    private final /* synthetic */ int val$terminalId;
    private final /* synthetic */ LocationDisambiguatorSequence this$0;

    LocationDisambiguatorSequence$3(LocationDisambiguatorSequence locationDisambiguatorSequence, String string, ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
        this.this$0 = locationDisambiguatorSequence;
        this.val$callback = iLocationDisambiguationCallback;
        this.val$action = n;
        this.val$modelId = n2;
        this.val$terminalId = n3;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostSequence(LocationDisambiguatorSequence.access$000(this.this$0, this.dsiResponseContainer.getSelectedLocation(), this.val$callback, this.val$action, this.val$modelId, this.val$terminalId));
    }
}

