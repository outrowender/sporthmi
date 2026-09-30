/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AbstractAddressInputScreenWorkFlowManagerNAR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputStreetScreenWorkFlowManagerNAR
extends AbstractAddressInputScreenWorkFlowManagerNAR {
    private static final Object STREET_NAME_AS_STRING = "StreetForHistory";

    public AddressInputStreetScreenWorkFlowManagerNAR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 30302: {
                this.createNarStreetScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            case 30304: {
                this.createNarStreetScreenAmbiguousListElementSelectedWorkFlow(commandList);
                break;
            }
            case 30303: {
                this.createNarStreetScreenNonambiguousListElementSelectedWorkFlow(commandList);
                break;
            }
            case 30305: {
                this.createNarStreetScreenHistoryElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId %2 is in range of street screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createNarStreetScreenHistoryElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createNarStreetScreenHistoryElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        LIStreetHistoryEntry lIStreetHistoryEntry = (LIStreetHistoryEntry)commandList.get("selectedElement");
        LIValueListElement lIValueListElement = new LIValueListElement();
        lIValueListElement.data = lIStreetHistoryEntry.name;
        commandList.put(STREET_NAME_AS_STRING, lIStreetHistoryEntry.name);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, lIValueListElement, -1, null, SpellerContextManager.getSpellerContext(88), null));
    }

    private NavCommand createSetStreetForHistory(final String string) {
        return new NavCommand(this.CLASS_NAME + "#getSelectListElementCommandList - Set Street For CityHistory"){

            public void execute() {
                this.logger.log(10000000, "%1#getSelectListElementCommandList#Set Street for CityHistory --> Element for history", (Object)string);
                this.getDSINavigation().liSetStreetForCityHistory(string);
                this.getCommandList().commandFinished();
            }
        };
    }

    private void createNarStreetScreenNonambiguousListElementSelectedWorkFlow(CommandList commandList) {
    }

    private void createNarStreetScreenAmbiguousListElementSelectedWorkFlow(CommandList commandList) {
        if (this.spellerStack.containsContextID(65)) {
            this.logChannel.log(10000000, "%1#createNarStreetScreenListElementSelectedWorkFlow - Spellerstack contains StreetFirst context", (Object)this.CLASS_NAME);
            commandList.add(this.inputManager.getCityZipScreenListener().getStartCommandList());
            commandList.add(this.createSetStreetForHistory((String)commandList.get(STREET_NAME_AS_STRING)));
        } else {
            this.logChannel.log(10000000, "%1#createNarStreetScreenListElementSelectedWorkFlow - Spellerstack does not contain StreetFirst context", (Object)this.CLASS_NAME);
            commandList.add(this.inputManager.getStreetRefinementScreenListener().getStartCommandList());
        }
    }

    private void createNarStreetScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createNarStreetScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("selectedElement");
        commandList.put(STREET_NAME_AS_STRING, lIValueListElement.data);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, lIValueListElement, -1, null, SpellerContextManager.getSpellerContext(66), null));
    }
}

