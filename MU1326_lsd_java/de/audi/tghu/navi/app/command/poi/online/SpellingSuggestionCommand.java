/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.poi.online.AbstractOnlineSearchCommand;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;

public class SpellingSuggestionCommand
extends AbstractOnlineSearchCommand {
    private final IOnlineSearchForm modelAccess;

    public SpellingSuggestionCommand(LogChannel logChannel, IOnlineSearchForm iOnlineSearchForm) {
        super(logChannel);
        this.modelAccess = iOnlineSearchForm;
        logChannel.log(1000000, "SpellingSuggestionCommand#SpellingSuggestionCommand()");
    }

    public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
        this.logger.log(10000000, "SpellingSuggestionCommand#poiSpellingSuggestion( %1, %2 )", (Object)string, (Object)stringArray);
        if (stringArray != null && stringArray.length > 0) {
            this.modelAccess.setSpellingsuggestion(stringArray[0]);
        }
        this.modelAccess.setResultsComplete();
        this.getCommandList().commandFinished();
    }

    public void execute() {
        this.logger.log(10000000, "SpellingSuggestionCommand#execute");
        this.dsiOnlineSearch.poiRequestSpellingSuggestion();
    }
}

