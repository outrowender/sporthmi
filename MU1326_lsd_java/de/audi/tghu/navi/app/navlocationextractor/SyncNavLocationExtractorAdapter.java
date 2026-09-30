/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.AbstractAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationExctractor;
import org.dsi.ifc.global.NavLocation;

public class SyncNavLocationExtractorAdapter
implements NavLocationExctractor {
    private static final int TIMEOUT_FOR_EXTRACT_LOCATION = 30000;
    private AbstractAsyncNavLocationExtractor asyncNavLocationExtractor;

    public SyncNavLocationExtractorAdapter(AbstractAsyncNavLocationExtractor abstractAsyncNavLocationExtractor) {
        this.asyncNavLocationExtractor = abstractAsyncNavLocationExtractor;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavLocation extractNavLocationFromRow(EvoListRow evoListRow) {
        Object object = new Object();
        GetNavLocationCommand getNavLocationCommand = new GetNavLocationCommand(object);
        CommandList commandList = this.asyncNavLocationExtractor.getExtractNavLocationCL(evoListRow, 1);
        if (commandList == null) {
            return null;
        }
        commandList.add(getNavLocationCommand);
        Object object2 = object;
        synchronized (object2) {
            commandList.execute("SyncNavLocationExtractorAdapter#extractNavLocationFromRow()");
            try {
                object.wait(30000L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        return getNavLocationCommand.getResult();
    }

    class GetNavLocationCommand
    extends NavCommand {
        private NavLocation resultLocation;
        private Object waitingLock;

        public GetNavLocationCommand(Object object) {
            this.waitingLock = object;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void execute() {
            Object object = this.waitingLock;
            synchronized (object) {
                this.resultLocation = (NavLocation)this.getCommandList().get("navLocation");
                this.waitingLock.notify();
            }
            this.getCommandList().commandFinished();
        }

        public NavLocation getResult() {
            return this.resultLocation;
        }
    }
}

