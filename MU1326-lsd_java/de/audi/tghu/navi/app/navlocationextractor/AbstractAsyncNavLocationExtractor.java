/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.AbstractAsyncNavLocationExtractor$1;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import de.audi.tghu.navi.app.util.Util;

public abstract class AbstractAsyncNavLocationExtractor
implements AsyncNavLocationExtractor {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());

    @Override
    public final void executeCallbackWithNavLocation(EvoListRow evoListRow, int n, NavLocationCallback navLocationCallback) {
        CommandList commandList = this.getExtractNavLocationCL(evoListRow, n);
        if (commandList == null) {
            throw new IllegalStateException("Cannot extract navLocation and execute callback, as the CommandList for extracting navLocation was null");
        }
        commandList.add(new AbstractAsyncNavLocationExtractor$1(this, navLocationCallback));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#executeCallback").toString());
    }

    protected void putResultInCommandListMap(String string, Object object, ICommandList iCommandList, LogChannel logChannel) {
        if (logChannel.isDebug2()) {
            logChannel.log(14808325, "%1#putResultInMap: result: %2", (Object)this.CLASS_NAME, object);
        }
        if (object != null) {
            iCommandList.put(string, object);
        } else {
            logChannel.log(-1601830656, "%1#putResultInMap: NavLocation is null", (Object)this.CLASS_NAME);
        }
    }

    protected abstract CommandList getExtractNavLocationCL(EvoListRow evoListRow, int n) {
    }
}

