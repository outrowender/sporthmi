/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.evo.KoreaSOSCallSpellerHandler;
import de.audi.app.phone.evo.KoreaSOSCallSpellerHandler$1;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

class KoreaSOSCallSpellerHandler$KoreaSOSDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ KoreaSOSCallSpellerHandler this$0;

    private KoreaSOSCallSpellerHandler$KoreaSOSDiag(KoreaSOSCallSpellerHandler koreaSOSCallSpellerHandler) {
        this.this$0 = koreaSOSCallSpellerHandler;
    }

    public void cmdDialKoreaSOSNumber(String string) {
        this.this$0.getTelEcallService().dialLowPrioritySOSCall(string);
    }

    /* synthetic */ KoreaSOSCallSpellerHandler$KoreaSOSDiag(KoreaSOSCallSpellerHandler koreaSOSCallSpellerHandler, KoreaSOSCallSpellerHandler$1 koreaSOSCallSpellerHandler$1) {
        this(koreaSOSCallSpellerHandler);
    }
}

