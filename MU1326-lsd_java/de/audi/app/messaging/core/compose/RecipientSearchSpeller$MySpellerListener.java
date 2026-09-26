/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.InterpretationGuessItem;
import de.audi.app.messaging.core.compose.RecipientSearchSpeller;
import de.audi.app.messaging.core.compose.RecipientSearchSpeller$1;
import de.audi.atip.hmi.model.listener.DefaultSpellerListener;

class RecipientSearchSpeller$MySpellerListener
extends DefaultSpellerListener {
    private final /* synthetic */ RecipientSearchSpeller this$0;

    private RecipientSearchSpeller$MySpellerListener(RecipientSearchSpeller recipientSearchSpeller) {
        this.this$0 = recipientSearchSpeller;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == -896392960) {
            RecipientSearchSpeller.access$600(this.this$0, n, n3);
        } else {
            RecipientSearchSpeller.access$700(this.this$0).log(10000, "[RecipientSearchSpeller#keyTyped] Unexpected modelId = %1", (long)n);
        }
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        RecipientSearchSpeller.access$800(this.this$0).log(-2137614336, "[RecipientSearchSpeller#textChanged] text = %1", (Object)string);
        InterpretationGuessItem interpretationGuessItem = RecipientSearchSpeller.access$900(this.this$0).getInterpretationGuessItem();
        interpretationGuessItem.update(string);
        boolean bl = interpretationGuessItem.isValid();
        int n3 = bl ? 0 : 1;
        RecipientSearchSpeller.access$1000(this.this$0).setControlButtonStates(-1, n3);
        RecipientSearchSpeller.access$1100(this.this$0).getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
        RecipientSearchSpeller.access$1200(this.this$0).log(1078071040, "[RecipientSearchSpeller#commandPressed] index = %1", (long)n2);
        if (this.this$0.isInEditorView && n2 == 4711) {
            RecipientSearchSpeller.access$1000(this.this$0).setSpellerInitiallyOpen(true);
            RecipientSearchSpeller.access$1300(this.this$0).getHmiServiceApp().getModelApp(n).fireEvent(n3);
        } else {
            RecipientSearchSpeller.access$1000(this.this$0).setSpellerInitiallyOpen(false);
        }
    }

    /* synthetic */ RecipientSearchSpeller$MySpellerListener(RecipientSearchSpeller recipientSearchSpeller, RecipientSearchSpeller$1 recipientSearchSpeller$1) {
        this(recipientSearchSpeller);
    }
}

