/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.evo.intellicall.IntellicallFullMenuFocusHandler;
import de.audi.app.phone.evo.intellicall.IntellicallFullMenuFocusHandler$1;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

class IntellicallFullMenuFocusHandler$IntellicallFullMenuFocusHandlerDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ IntellicallFullMenuFocusHandler this$0;

    private IntellicallFullMenuFocusHandler$IntellicallFullMenuFocusHandlerDiag(IntellicallFullMenuFocusHandler intellicallFullMenuFocusHandler) {
        this.this$0 = intellicallFullMenuFocusHandler;
    }

    public void cmdIntellicallFullFocusCallList(int n) {
        this.this$0.focusCallList(n);
    }

    public void cmdIntellicallFullFocusDTMF() {
        this.this$0.focusDtmf();
    }

    public void cmdIntellicallFullFocusSearchField() {
        IntellicallFullMenuFocusHandler.access$100(this.this$0);
    }

    public void cmdIntellicallFullFocusMailbox() {
        this.this$0.focusMailbox();
    }

    public void cmdIntellicallFullFocusCallStackList(int n) {
        IntellicallFullMenuFocusHandler.access$200(this.this$0, -1718287360, FocusAdvice.KEEP_POSITION, n);
    }

    public void cmdIntellicallFullFocusSpellerContent() {
        this.this$0.focusSpellerContentLabel();
    }

    public void cmdIntellicallFullFocusSearchResultList(int n) {
        IntellicallFullMenuFocusHandler.access$200(this.this$0, -1365900288, FocusAdvice.KEEP_POSITION, n);
    }

    public void cmdIntellicallFullFocusActiveCall() {
        this.this$0.focusActiveCall();
    }

    public void cmdIntellicallFullFocusHeldCall() {
        this.this$0.focusHeldCall();
    }

    /* synthetic */ IntellicallFullMenuFocusHandler$IntellicallFullMenuFocusHandlerDiag(IntellicallFullMenuFocusHandler intellicallFullMenuFocusHandler, IntellicallFullMenuFocusHandler$1 intellicallFullMenuFocusHandler$1) {
        this(intellicallFullMenuFocusHandler);
    }
}

