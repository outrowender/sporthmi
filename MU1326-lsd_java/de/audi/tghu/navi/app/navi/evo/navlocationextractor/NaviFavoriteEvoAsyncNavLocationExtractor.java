/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navi.evo.navlocationextractor;

import de.audi.app.navi.favorite.NaviFavoriteEvoRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.navi.evo.navlocationextractor.NaviFavoriteEvoAsyncNavLocationExtractor$1;
import de.audi.tghu.navi.app.navlocationextractor.AbstractAsyncNavLocationExtractor;

public class NaviFavoriteEvoAsyncNavLocationExtractor
extends AbstractAsyncNavLocationExtractor {
    private ICommandListFactory commandListFactory;

    public NaviFavoriteEvoAsyncNavLocationExtractor(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    @Override
    protected CommandList getExtractNavLocationCL(EvoListRow evoListRow, int n) {
        this.checkArgument(evoListRow);
        byte[] byArray = ((NaviFavoriteEvoRow)evoListRow).getFavoriteLocation();
        CommandList commandList = this.commandListFactory.createCommandList(n);
        commandList.add(new StreamToLocationCommand(byArray));
        commandList.add(new NaviFavoriteEvoAsyncNavLocationExtractor$1(this, "SaveResultInCommandListMap"));
        return commandList;
    }

    private void checkArgument(EvoListRow evoListRow) {
        if (!(evoListRow instanceof NaviFavoriteEvoRow)) {
            throw new IllegalArgumentException("this NavLocationExtractor works only with NaviFavoriteEvoRow objects");
        }
    }

    static /* synthetic */ void access$000(NaviFavoriteEvoAsyncNavLocationExtractor naviFavoriteEvoAsyncNavLocationExtractor, String string, Object object, ICommandList iCommandList, LogChannel logChannel) {
        naviFavoriteEvoAsyncNavLocationExtractor.putResultInCommandListMap(string, object, iCommandList, logChannel);
    }
}

