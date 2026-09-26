/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.CreateTryMatchCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.navigation.TryMatchLocationResultData;

class CreateTryMatchCommand$1
extends NavCommand {
    private final /* synthetic */ TryMatchLocationResultData[] val$cachedResponse;
    private final /* synthetic */ CreateTryMatchCommand this$0;

    CreateTryMatchCommand$1(CreateTryMatchCommand createTryMatchCommand, String string, TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        this.this$0 = createTryMatchCommand;
        this.val$cachedResponse = tryMatchLocationResultDataArray;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "SearchResultAsyncNavLocationExtractor#GetCachedLiTryMatchLocationResultDataCommand#execute() cachedResponse[0].matchLevel: %2, cachedResponse.length: %3, cachedResponse[0].getLocation(): %1", (Object)LocationFormatter.formatLocationShort(this.val$cachedResponse[0].getLocation()), (long)this.val$cachedResponse[0].matchLevel, (long)this.val$cachedResponse.length);
        this.dsiResponseContainer.setTryMatchLocationResultData(this.val$cachedResponse);
        this.getCommandList().commandFinished();
    }
}

