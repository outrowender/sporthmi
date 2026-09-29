/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.poi.online.AbstractOnlineSearchCommand;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSDSSearchSequence;
import de.audi.tghu.navi.app.poi.online.OnlineSearchContext;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public class OnlineSDSSearchVoiceDataAvailableCommand
extends AbstractOnlineSearchCommand {
    private final LogChannel logChannel;
    private final String path;
    private final int audioFormat;
    private final OnlineSDSSearchSequence sds;
    private String[] suggestions = new String[0];

    public OnlineSDSSearchVoiceDataAvailableCommand(LogChannel logChannel, IOnlineSearchForm iOnlineSearchForm, OnlineSearchContext onlineSearchContext, OnlineSDSSearchSequence onlineSDSSearchSequence, String string, int n, boolean bl) {
        super(logChannel, iOnlineSearchForm, onlineSearchContext);
        this.logChannel = logChannel;
        this.sds = onlineSDSSearchSequence;
        this.path = string;
        this.audioFormat = n;
        this.spellingSuggestion = bl;
    }

    @Override
    public void poiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
        super.poiValueList(n, n2, poiOnlineSearchValuelist, n3, n4);
        this.logChannel.log(1078071040, "OnlineSDSSearchVoiceDataAvailableCommand#poiValueList: Forwarding value list without suggestions to SDS!");
        this.sds.poiValueList(poiOnlineSearchValuelist, this.suggestions);
    }

    @Override
    public void poiResult(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "OnlineSDSSearchVoiceDataAvailableCommand#poiResult: Called, resultsource %1, returnCode %2, type %3", (long)n2, (long)n3, (long)n);
        this.returnCode = n3;
        if (n3 != 10) {
            this.sds.blockDUM(true);
        }
        if (this.sds.indicateError(n3)) {
            this.logChannel.log(1078071040, "OnlineSDSSearchVoiceDataAvailableCommand#poiResult: forwarding error handling to haptic");
            super.poiResult(n, n2, n3);
        }
    }

    @Override
    public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
        this.logChannel.log(1078071040, "OnlineSDSSearchVoiceDataAvailableCommand#poiSpellingSuggestion: called");
        this.suggestions = stringArray;
    }

    @Override
    public void execute() {
        if (!this.sds.isSearchCanceled()) {
            this.logChannel.log(1078071040, "OnlineSDSSearchVoiceDataAvailableCommand#execute: Called.");
            this.dsiOnlineSearch.poiRawVoiceDataAvailable(this.path, this.audioFormat);
        } else {
            this.logChannel.log(1078071040, "OnlineSDSSearchVoiceDataAvailableCommand#execute: search has been canceled, not executing command");
        }
    }
}

