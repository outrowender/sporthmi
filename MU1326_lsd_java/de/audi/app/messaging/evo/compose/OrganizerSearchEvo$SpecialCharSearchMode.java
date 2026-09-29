/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.evo.compose.OrganizerSearchEvo;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo$1;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo$ISpellerMode;
import de.audi.atip.interapp.phone.TelIntellicallIGIUtil;

final class OrganizerSearchEvo$SpecialCharSearchMode
implements OrganizerSearchEvo$ISpellerMode {
    private final /* synthetic */ OrganizerSearchEvo this$0;

    private OrganizerSearchEvo$SpecialCharSearchMode(OrganizerSearchEvo organizerSearchEvo) {
        this.this$0 = organizerSearchEvo;
    }

    @Override
    public void spellerModeChanged() {
        OrganizerSearchEvo.access$1000(this.this$0).log(1078071040, "[OrganizerSearchEvo#SpecialCharSearchMode#spellerModeChanged]");
        OrganizerSearchEvo.access$1100(this.this$0).removeAll();
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        OrganizerSearchEvo.access$1200(this.this$0).log(1078071040, "[OrganizerSearchEvo#SpecialCharSearchMode#textChanged] text = %1, latestChar= %2", (Object)string, (long)c2);
        OrganizerSearchEvo.access$1300(this.this$0).getInterpretationGuessItem().update(string);
        this.this$0.getSpellerModel().setText(string);
        this.this$0.getSpellerModel().setValidChars(TelIntellicallIGIUtil.VALID_PHONE_NUMBER_SYMBOLS);
        this.this$0.getSpellerModel().setStatus(1);
    }

    @Override
    public String getValidChars(String string) {
        return TelIntellicallIGIUtil.VALID_PHONE_NUMBER_SYMBOLS;
    }

    /* synthetic */ OrganizerSearchEvo$SpecialCharSearchMode(OrganizerSearchEvo organizerSearchEvo, OrganizerSearchEvo$1 organizerSearchEvo$1) {
        this(organizerSearchEvo);
    }
}

