/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navi.evo.navlocationextractor;

import de.audi.app.navi.favorite.NaviFavoriteEvoRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.navlocationextractor.AbstractAsyncNavLocationExtractor;

public class NaviFavoriteEvoAsyncNavLocationExtractor
extends AbstractAsyncNavLocationExtractor {
    private ICommandListFactory commandListFactory;

    public NaviFavoriteEvoAsyncNavLocationExtractor(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    protected CommandList getExtractNavLocationCL(EvoListRow evoListRow, int n) {
        this.checkArgument(evoListRow);
        byte[] byArray = ((NaviFavoriteEvoRow)evoListRow).getFavoriteLocation();
        CommandList commandList = this.commandListFactory.createCommandList(n);
        commandList.add(new StreamToLocationCommand(byArray));
        commandList.add(new NavCommand("SaveResultInCommandListMap"){

            public void execute() {
                Object object = this.getCommandList().get("STREAMED_LOCATION");
                NaviFavoriteEvoAsyncNavLocationExtractor.this.putResultInCommandListMap("navLocation", object, this.getCommandList(), this.logger);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    private void checkArgument(EvoListRow evoListRow) {
        if (!(evoListRow instanceof NaviFavoriteEvoRow)) {
            throw new IllegalArgumentException("this NavLocationExtractor works only with NaviFavoriteEvoRow objects");
        }
    }
}

