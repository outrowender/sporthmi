/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.evo.compose.OrganizerSearchEvo;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo$1;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo$ISpellerMode;

final class OrganizerSearchEvo$MatchSpellerMode
implements OrganizerSearchEvo$ISpellerMode {
    private final /* synthetic */ OrganizerSearchEvo this$0;

    private OrganizerSearchEvo$MatchSpellerMode(OrganizerSearchEvo organizerSearchEvo) {
        this.this$0 = organizerSearchEvo;
    }

    @Override
    public void spellerModeChanged() {
        OrganizerSearchEvo.access$300(this.this$0).log(1078071040, "[TelEvoADBMatchSpellerHandler#MatchSpellerMode#spellerModeChanged]");
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        OrganizerSearchEvo.access$400(this.this$0).log(1078071040, "[OrganizerSearchEvo#MatchSpellerMode#textChanged] text = %1, latestChar = %2", (Object)string, (long)c2);
        OrganizerSearchEvo.access$501(this.this$0, n, string, c2, n2);
        OrganizerSearchEvo.access$600(this.this$0).getFramework().getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    @Override
    public String getValidChars(String string) {
        return string;
    }

    /* synthetic */ OrganizerSearchEvo$MatchSpellerMode(OrganizerSearchEvo organizerSearchEvo, OrganizerSearchEvo$1 organizerSearchEvo$1) {
        this(organizerSearchEvo);
    }
}

