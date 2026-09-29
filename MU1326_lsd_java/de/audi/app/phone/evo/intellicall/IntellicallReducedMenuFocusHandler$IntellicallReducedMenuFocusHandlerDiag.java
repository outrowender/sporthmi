/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.evo.intellicall.IntellicallReducedMenuFocusHandler;
import de.audi.app.phone.evo.intellicall.IntellicallReducedMenuFocusHandler$1;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

class IntellicallReducedMenuFocusHandler$IntellicallReducedMenuFocusHandlerDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ IntellicallReducedMenuFocusHandler this$0;

    private IntellicallReducedMenuFocusHandler$IntellicallReducedMenuFocusHandlerDiag(IntellicallReducedMenuFocusHandler intellicallReducedMenuFocusHandler) {
        this.this$0 = intellicallReducedMenuFocusHandler;
    }

    public void cmdIntellicallReducedFocusCallList(int n) {
        this.this$0.focusCallList(n);
    }

    public void cmdIntellicallReducedFocusDTMF() {
        this.this$0.focusDtmf();
    }

    public void cmdIntellicallReducedFocusActiveCall() {
        this.this$0.focusActiveCall();
    }

    public void cmdIntellicallReducedFocusHeldCall() {
        this.this$0.focusHeldCall();
    }

    /* synthetic */ IntellicallReducedMenuFocusHandler$IntellicallReducedMenuFocusHandlerDiag(IntellicallReducedMenuFocusHandler intellicallReducedMenuFocusHandler, IntellicallReducedMenuFocusHandler$1 intellicallReducedMenuFocusHandler$1) {
        this(intellicallReducedMenuFocusHandler);
    }
}

