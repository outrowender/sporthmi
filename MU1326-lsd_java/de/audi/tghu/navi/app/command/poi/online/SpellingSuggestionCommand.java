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
        logChannel.log(1078071040, "SpellingSuggestionCommand#SpellingSuggestionCommand()");
    }

    @Override
    public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
        this.logger.log(-2137614336, "SpellingSuggestionCommand#poiSpellingSuggestion( %1, %2 )", (Object)string, (Object)stringArray);
        if (stringArray != null && stringArray.length > 0) {
            this.modelAccess.setSpellingsuggestion(stringArray[0]);
        }
        this.modelAccess.setResultsComplete();
        this.getCommandList().commandFinished();
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "SpellingSuggestionCommand#execute");
        this.dsiOnlineSearch.poiRequestSpellingSuggestion();
    }
}

