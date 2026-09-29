/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$13
extends CommandResponse {
    private final /* synthetic */ String val$lispCurrentInput;
    private final /* synthetic */ int val$lispCurrentSelectionCriterion;
    private final /* synthetic */ boolean val$lispIsFullMatch;
    private final /* synthetic */ boolean val$lispIsUndoAvailable;
    private final /* synthetic */ String val$lispValidCharacters;
    private final /* synthetic */ int val$lispMultiCriteriaCriterion1;
    private final /* synthetic */ int val$lispMultiCriteriaCriterion2;
    private final /* synthetic */ boolean val$lispMultiCriteriaIsActive;
    private final /* synthetic */ boolean val$lispMultiCriteriaIsAmbiguous;
    private final /* synthetic */ int val$lispInputFormat;
    private final /* synthetic */ long val$resultCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$13(DSINavigationDispatcher dSINavigationDispatcher, String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.this$0 = dSINavigationDispatcher;
        this.val$lispCurrentInput = string;
        this.val$lispCurrentSelectionCriterion = n;
        this.val$lispIsFullMatch = bl;
        this.val$lispIsUndoAvailable = bl2;
        this.val$lispValidCharacters = string2;
        this.val$lispMultiCriteriaCriterion1 = n2;
        this.val$lispMultiCriteriaCriterion2 = n3;
        this.val$lispMultiCriteriaIsActive = bl3;
        this.val$lispMultiCriteriaIsAmbiguous = bl4;
        this.val$lispInputFormat = n4;
        this.val$resultCode = l;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).lispUpdateSpellerResult(this.val$lispCurrentInput, this.val$lispCurrentSelectionCriterion, this.val$lispIsFullMatch, this.val$lispIsUndoAvailable, this.val$lispValidCharacters, this.val$lispMultiCriteriaCriterion1, this.val$lispMultiCriteriaCriterion2, this.val$lispMultiCriteriaIsActive, this.val$lispMultiCriteriaIsAmbiguous, this.val$lispInputFormat, this.val$resultCode);
    }
}

