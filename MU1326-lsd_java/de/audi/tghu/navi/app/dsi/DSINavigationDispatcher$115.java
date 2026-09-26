/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;

class DSINavigationDispatcher$115
extends CommandResponse {
    private final /* synthetic */ NavLocation val$navLocation;
    private final /* synthetic */ int val$selectionCriterion;
    private final /* synthetic */ String val$spellableCharacters;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$115(DSINavigationDispatcher dSINavigationDispatcher, NavLocation navLocation, int n, String string, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$navLocation = navLocation;
        this.val$selectionCriterion = n;
        this.val$spellableCharacters = string;
        this.val$resultCode = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).liGetSpellableCharactersResult(this.val$navLocation, this.val$selectionCriterion, this.val$spellableCharacters, this.val$resultCode);
    }
}

