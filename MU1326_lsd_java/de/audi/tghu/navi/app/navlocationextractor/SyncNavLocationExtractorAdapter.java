/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.navlocationextractor.AbstractAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationExctractor;
import de.audi.tghu.navi.app.navlocationextractor.SyncNavLocationExtractorAdapter$GetNavLocationCommand;
import org.dsi.ifc.global.NavLocation;

public class SyncNavLocationExtractorAdapter
implements NavLocationExctractor {
    private static final int TIMEOUT_FOR_EXTRACT_LOCATION;
    private AbstractAsyncNavLocationExtractor asyncNavLocationExtractor;

    public SyncNavLocationExtractorAdapter(AbstractAsyncNavLocationExtractor abstractAsyncNavLocationExtractor) {
        this.asyncNavLocationExtractor = abstractAsyncNavLocationExtractor;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public NavLocation extractNavLocationFromRow(EvoListRow evoListRow) {
        Object object = new Object();
        SyncNavLocationExtractorAdapter$GetNavLocationCommand syncNavLocationExtractorAdapter$GetNavLocationCommand = new SyncNavLocationExtractorAdapter$GetNavLocationCommand(this, object);
        CommandList commandList = this.asyncNavLocationExtractor.getExtractNavLocationCL(evoListRow, 1);
        if (commandList == null) {
            return null;
        }
        commandList.add(syncNavLocationExtractorAdapter$GetNavLocationCommand);
        Object object2 = object;
        synchronized (object2) {
            commandList.execute("SyncNavLocationExtractorAdapter#extractNavLocationFromRow()");
            try {
                object.wait(0);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        return syncNavLocationExtractorAdapter$GetNavLocationCommand.getResult();
    }
}

