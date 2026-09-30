/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.poi.online.AbstractOnlineSearchCommand;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;

public class OnlineSDSSearchStartCommand
extends AbstractOnlineSearchCommand {
    private final int lat;
    private final int lon;
    private final boolean isOneshot;

    public OnlineSDSSearchStartCommand(LogChannel logChannel, int n, int n2, boolean bl, IOnlineSearchForm iOnlineSearchForm) {
        super(logChannel);
        this.lat = n;
        this.lon = n2;
        this.isOneshot = bl;
        this.form = iOnlineSearchForm;
    }

    public void poiResult(int n, int n2, int n3) {
        this.logger.log(10000000, "OnlineSDSSearchStartCommand#poiResult( %1, %2 )", (long)n2, (long)n3);
        this.getCommandList().commandFinished();
    }

    public void execute() {
        this.logger.log(10000000, "OnlineSDSSearchStartCommand#execute");
        if (this.form != null) {
            this.form.setSearchTextLabel("");
        }
        this.dsiOnlineSearch.poiStartVoiceSelection(this.lon, this.lat, 500, 5, this.isOneshot, 10);
    }
}

