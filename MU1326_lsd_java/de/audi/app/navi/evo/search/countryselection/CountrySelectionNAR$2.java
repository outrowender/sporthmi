/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search.countryselection;

import de.audi.app.navi.evo.search.countryselection.CountrySelectionNAR;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;

class CountrySelectionNAR$2
extends NavCommand {
    private final /* synthetic */ CountrySelectionNAR this$0;

    CountrySelectionNAR$2(CountrySelectionNAR countrySelectionNAR, String string) {
        this.this$0 = countrySelectionNAR;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LIRestoreStateCommand(SpellerStack.getInstance().pop().spellerData));
    }
}

