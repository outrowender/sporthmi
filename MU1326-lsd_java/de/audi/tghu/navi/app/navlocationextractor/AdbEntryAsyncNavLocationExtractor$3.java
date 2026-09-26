/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.AdbEntryAsyncNavLocationExtractor;

class AdbEntryAsyncNavLocationExtractor$3
extends NavCommand {
    private final /* synthetic */ AdbEntryAsyncNavLocationExtractor this$0;

    AdbEntryAsyncNavLocationExtractor$3(AdbEntryAsyncNavLocationExtractor adbEntryAsyncNavLocationExtractor) {
        this.this$0 = adbEntryAsyncNavLocationExtractor;
    }

    @Override
    public void execute() {
        this.this$0.putResultInCommandListMap("navLocation", this.dsiResponseContainer.getTransformedLocation(), this.getCommandList(), this.logger);
        this.getCommandList().commandFinished();
    }
}

