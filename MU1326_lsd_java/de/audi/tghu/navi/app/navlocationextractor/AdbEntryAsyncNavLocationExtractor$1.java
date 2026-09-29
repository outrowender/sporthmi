/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.AdbEntryAsyncNavLocationExtractor;

class AdbEntryAsyncNavLocationExtractor$1
extends NavCommand {
    private final /* synthetic */ AdbEntryAsyncNavLocationExtractor this$0;

    AdbEntryAsyncNavLocationExtractor$1(AdbEntryAsyncNavLocationExtractor adbEntryAsyncNavLocationExtractor) {
        this.this$0 = adbEntryAsyncNavLocationExtractor;
    }

    @Override
    public void execute() {
        this.this$0.putResultInCommandListMap("navLocation", AdbEntryAsyncNavLocationExtractor.access$000(this.this$0, this.dsiResponseContainer), this.getCommandList(), this.logger);
        this.getCommandList().commandFinished();
    }
}

