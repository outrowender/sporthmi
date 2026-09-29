/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.evo.compose.OrganizerSearchEvo;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo$ISpellerMode;

public final class OrganizerSearchEvo$NoneSpellerMode
implements OrganizerSearchEvo$ISpellerMode {
    private final /* synthetic */ OrganizerSearchEvo this$0;

    public OrganizerSearchEvo$NoneSpellerMode(OrganizerSearchEvo organizerSearchEvo) {
        this.this$0 = organizerSearchEvo;
    }

    @Override
    public void spellerModeChanged() {
        OrganizerSearchEvo.access$700(this.this$0).log(1078071040, "[OrganizerSearchEvo#NoneSpellerMode#spellerModeChanged]");
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        OrganizerSearchEvo.access$800(this.this$0).log(1078071040, "[OrganizerSearchEvo.NoneSpellerMode#textChanged] text = %1, latestChar = %2", (Object)string, (long)c2);
        OrganizerSearchEvo.access$900(this.this$0);
        this.this$0.startSpeller();
    }

    @Override
    public String getValidChars(String string) {
        return null;
    }
}

