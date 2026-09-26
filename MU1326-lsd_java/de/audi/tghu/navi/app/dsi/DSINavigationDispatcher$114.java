/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$114
extends CommandResponse {
    private final /* synthetic */ String val$countryAbbreviation;
    private final /* synthetic */ String val$state;
    private final /* synthetic */ int val$selectionCriterion;
    private final /* synthetic */ String val$spellableCharacters;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$114(DSINavigationDispatcher dSINavigationDispatcher, String string, String string2, int n, String string3, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$countryAbbreviation = string;
        this.val$state = string2;
        this.val$selectionCriterion = n;
        this.val$spellableCharacters = string3;
        this.val$resultCode = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).getSpellableCharactersResult(this.val$countryAbbreviation, this.val$state, this.val$selectionCriterion, this.val$spellableCharacters, this.val$resultCode);
    }
}

