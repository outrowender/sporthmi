/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public abstract class AbstractAsyncNavLocationExtractor
implements AsyncNavLocationExtractor {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public final void executeCallbackWithNavLocation(EvoListRow evoListRow, int n, final NavLocationCallback navLocationCallback) {
        CommandList commandList = this.getExtractNavLocationCL(evoListRow, n);
        if (commandList == null) {
            throw new IllegalStateException("Cannot extract navLocation and execute callback, as the CommandList for extracting navLocation was null");
        }
        commandList.add(new NavCommand(){

            public void execute() {
                this.logger.log(10000000, "%1# Retreived location: [%2]", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort((NavLocation)this.getCommandList().get("navLocation")));
                navLocationCallback.callBack((NavLocation)this.getCommandList().get("navLocation"), this.getCommandList());
                this.finishCommandIfNecessary();
            }

            private void finishCommandIfNecessary() {
                if (this.getCommandList().getActiveCommand() == this) {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.execute(this.CLASS_NAME + "#executeCallback");
    }

    protected void putResultInCommandListMap(String string, Object object, ICommandList iCommandList, LogChannel logChannel) {
        if (logChannel.isDebug2()) {
            logChannel.log(100000000, "%1#putResultInMap: result: %2", (Object)this.CLASS_NAME, object);
        }
        if (object != null) {
            iCommandList.put(string, object);
        } else {
            logChannel.log(100000, "%1#putResultInMap: NavLocation is null", (Object)this.CLASS_NAME);
        }
    }

    protected abstract CommandList getExtractNavLocationCL(EvoListRow var1, int var2);
}

