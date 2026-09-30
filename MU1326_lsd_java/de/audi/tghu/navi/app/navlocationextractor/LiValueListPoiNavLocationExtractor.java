/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationExctractor;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class LiValueListPoiNavLocationExtractor
implements NavLocationExctractor {
    private static final int TIMEOUT_FOR_EXTRACT_LOCATION = 3000;
    private ICommandListFactory commandListFactory;

    public LiValueListPoiNavLocationExtractor(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    public NavLocation extractNavLocationFromRow(EvoListRow evoListRow) {
        LIValueListElement lIValueListElement = this.getLiValueListElementFromRow(evoListRow);
        return this.extractNavLocationFromLiValueListElementForPOIs(lIValueListElement);
    }

    protected abstract LIValueListElement getLiValueListElementFromRow(EvoListRow var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private NavLocation extractNavLocationFromLiValueListElementForPOIs(LIValueListElement lIValueListElement) {
        Object object = new Object();
        GetNavLocationCommand getNavLocationCommand = new GetNavLocationCommand(object);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                this.getCommandList().put("tempSpellerState", this.dsiResponseContainer.getSpellerState());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(getNavLocationCommand);
        commandList.add(new NavCommand(){

            public void execute() {
                LISpellerData lISpellerData = (LISpellerData)this.getCommandList().get("tempSpellerState");
                this.getCommandList().commandFinishedWithPostCommand(new LIRestoreStateCommand(lISpellerData));
            }
        });
        Object object2 = object;
        synchronized (object2) {
            commandList.execute("PoiInputHMIListener#saveAsFavorite");
            try {
                object.wait(3000L);
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
                this.resultLocation = this.dsiResponseContainer.getLiCurrentLD();
                this.waitingLock.notify();
            }
            this.getCommandList().commandFinished();
        }

        public NavLocation getResult() {
            return this.resultLocation;
        }
    }
}

