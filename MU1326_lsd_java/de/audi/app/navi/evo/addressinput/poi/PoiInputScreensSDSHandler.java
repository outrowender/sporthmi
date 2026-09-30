/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiInputScreensSDSHandler {
    private final LogChannel logChannel;
    private final PoiManager poiManager;
    private final ICommandListFactory commandListFactory;

    public PoiInputScreensSDSHandler(LogChannel logChannel, PoiManager poiManager, ICommandListFactory iCommandListFactory) {
        this.logChannel = logChannel;
        this.poiManager = poiManager;
        this.commandListFactory = iCommandListFactory;
    }

    public void startDestinationInput(final NaviServiceListener naviServiceListener) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.poiManager.handlePoiSelectionEvent(commandList, 10);
        if (naviServiceListener == null) {
            this.logChannel.log(10000, "NotifySDSCommand#execute() - navi service listener not available!");
        } else {
            commandList.setErrorCommand(new NavCommand(){

                public void execute() {
                    naviServiceListener.responseStartDestinationInput((byte)1);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.add(new NavCommand(){

                public void execute() {
                    naviServiceListener.responseStartDestinationInput((byte)0);
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.execute("PoiInputScreensSDSHandler#startDestinationInput");
    }

    public void startPoiSearchByName(final NaviServiceListener naviServiceListener) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.poiManager.handlePoiSelectionEvent(commandList, 5);
        if (naviServiceListener == null) {
            this.logChannel.log(10000, "NotifySDSCommand#execute() - navi service listener not available!");
        } else {
            commandList.setErrorCommand(new NavCommand(){

                public void execute() {
                    naviServiceListener.responseStartPoiSearchByName((byte)1);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.add(new NavCommand(){

                public void execute() {
                    naviServiceListener.responseStartPoiSearchByName((byte)0);
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.execute("PoiInputScreensSDSHandler#startPoiSearchByName");
    }

    public SDSListEntry getPoiTopPoiListEntryDetails(int n) {
        LIValueListElement lIValueListElement = this.poiManager.getPoiMainScreenHmiListener().getPoiMainScreenTopPoiListEntry(n);
        this.logChannel.log(10000000, "PoiInputScreensSDSHandler#getTopPoiListEntryDetails - line: %2, %1", (Object)lIValueListElement, (long)n);
        int n2 = lIValueListElement.getCriteriaNumber();
        String string = lIValueListElement.data;
        SDSListEntry sDSListEntry = new SDSListEntry(string, n2);
        return sDSListEntry;
    }
}

