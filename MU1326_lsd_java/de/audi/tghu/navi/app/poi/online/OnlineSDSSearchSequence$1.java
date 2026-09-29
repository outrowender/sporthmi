/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.poi.online.AbstractOnlineSearchCommand;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSDSSearchSequence;
import de.audi.tghu.navi.app.poi.online.OnlineSearchContext;

class OnlineSDSSearchSequence$1
extends AbstractOnlineSearchCommand {
    private final /* synthetic */ OnlineSDSSearchSequence this$0;

    OnlineSDSSearchSequence$1(OnlineSDSSearchSequence onlineSDSSearchSequence, LogChannel logChannel, IOnlineSearchForm iOnlineSearchForm, OnlineSearchContext onlineSearchContext) {
        this.this$0 = onlineSDSSearchSequence;
        super(logChannel, iOnlineSearchForm, onlineSearchContext);
    }

    @Override
    public void execute() {
        this.this$0.indicateError(46);
        this.form.setResultLengthValue(4160, 0, 2);
    }
}

