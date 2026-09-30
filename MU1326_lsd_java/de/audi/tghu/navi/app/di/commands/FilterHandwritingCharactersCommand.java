/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.commands;

import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.tghu.navi.app.command.NavCommand;

public class FilterHandwritingCharactersCommand
extends NavCommand {
    private final String charactersToFilter;
    private final MatchspellerModelApp matchSpellerModelApp;

    public FilterHandwritingCharactersCommand(MatchspellerModelApp matchspellerModelApp, String string) {
        this.charactersToFilter = string;
        this.matchSpellerModelApp = matchspellerModelApp;
    }

    public void execute() {
        this.logger.log(1000000, "FilterHandwritingCharactersCommand#execute - call lispGetMatchingNVC( charactersToFilter=%1 )", (Object)this.charactersToFilter);
        this.getDSINavigation().lispGetMatchingNVC(this.charactersToFilter);
    }

    public void lispGetMatchingNVCResult(String string) {
        this.logger.log(1000000, "FilterHandwritingCharactersCommand#lispGetMatchingNVCResult - result=%1", (Object)string);
        this.matchSpellerModelApp.setValidNonAlphaNumTPCharacters(string);
        this.getCommandList().commandFinished();
    }
}

