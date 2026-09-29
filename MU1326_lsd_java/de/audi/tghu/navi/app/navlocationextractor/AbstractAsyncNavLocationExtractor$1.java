/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.AbstractAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class AbstractAsyncNavLocationExtractor$1
extends NavCommand {
    private final /* synthetic */ NavLocationCallback val$callback;
    private final /* synthetic */ AbstractAsyncNavLocationExtractor this$0;

    AbstractAsyncNavLocationExtractor$1(AbstractAsyncNavLocationExtractor abstractAsyncNavLocationExtractor, NavLocationCallback navLocationCallback) {
        this.this$0 = abstractAsyncNavLocationExtractor;
        this.val$callback = navLocationCallback;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1# Retreived location: [%2]", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort((NavLocation)this.getCommandList().get("navLocation")));
        this.val$callback.callBack((NavLocation)this.getCommandList().get("navLocation"), this.getCommandList());
        this.finishCommandIfNecessary();
    }

    private void finishCommandIfNecessary() {
        if (this.getCommandList().getActiveCommand() == this) {
            this.getCommandList().commandFinished();
        }
    }
}

