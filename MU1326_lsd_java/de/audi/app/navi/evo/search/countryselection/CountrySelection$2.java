/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search.countryselection;

import de.audi.app.navi.evo.search.countryselection.CountrySelection;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;

class CountrySelection$2
extends NavCommand {
    private final /* synthetic */ CountrySelection this$0;

    CountrySelection$2(CountrySelection countrySelection, String string) {
        this.this$0 = countrySelection;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LIRestoreStateCommand(SpellerStack.getInstance().pop().spellerData));
    }
}

