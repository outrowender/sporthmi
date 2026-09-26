/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiResultScreenEvoListener;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;

class AbstractPoiResultScreenEvoListener$2
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ AbstractPoiScreenInputSequence val$inputSequence;
    private final /* synthetic */ int val$titledListModelId;
    private final /* synthetic */ AbstractPoiResultScreenEvoListener this$0;

    AbstractPoiResultScreenEvoListener$2(AbstractPoiResultScreenEvoListener abstractPoiResultScreenEvoListener, String string, int n, AbstractPoiScreenInputSequence abstractPoiScreenInputSequence, int n2) {
        this.this$0 = abstractPoiResultScreenEvoListener;
        this.val$model = n;
        this.val$inputSequence = abstractPoiScreenInputSequence;
        this.val$titledListModelId = n2;
        super(string);
    }

    @Override
    public void execute() {
        int n = SpellerStack.getInstance().getActiveSC().getContextID();
        if (n == 10 || n == 9 || n == 11 || n == 15) {
            if (!this.this$0.previewMapComplete || this.this$0.preparePreviewMapCommand.getHidePreviewMap()) {
                this.this$0.createPreparePreviewMapCommand(this.val$model, this.val$inputSequence, this.val$titledListModelId);
            }
        } else {
            this.logger.log(-2137614336, "AbstractPoiResultScreenEvoListener#displayPreviewMap call will be ignored for context %1", (Object)SpellerContextManager.contextIDToString(n));
        }
        AbstractPoiResultScreenEvoListener.access$102(this.this$0, false);
        this.getCommandList().commandFinished();
    }
}

