/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.TryBestMatchResultData;

public class CheckTryBestMatchResultCommand
extends NavCommand {
    public void execute() {
        TryBestMatchResultData[] tryBestMatchResultDataArray = this.dsiResponseContainer.getTryBestMatchResultData();
        if (tryBestMatchResultDataArray != null && tryBestMatchResultDataArray.length > 0 && tryBestMatchResultDataArray[0] != null && tryBestMatchResultDataArray[0].getLocation() != null) {
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(tryBestMatchResultDataArray[0].getLocation());
            boolean bl = iMyLocationAccessor.isNavigable();
            if (!bl) {
                this.navigation.getFunctionCounter().incCounter(52);
                this.logger.log(10000000, "CheckTryBestMatchResultCommand#execute() - try best match result was not a valid destination. %1", (Object)LocationFormatter.formatLocationShort(tryBestMatchResultDataArray[0].getLocation()));
                this.env.getChoiceModel(401137).setValue(0);
            } else {
                this.logger.log(10000000, "CheckTryBestMatchResultCommand#execute() - try best match result was a valid destination. ");
                this.env.getChoiceModel(401137).setValue(1);
            }
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "CheckTryBestMatchResultCommand#execute() - no try best match results available!");
            this.getCommandList().commandAborted("no try best match results");
        }
    }
}

