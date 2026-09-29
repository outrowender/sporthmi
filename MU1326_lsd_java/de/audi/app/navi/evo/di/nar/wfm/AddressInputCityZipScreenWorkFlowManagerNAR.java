/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AbstractAddressInputScreenWorkFlowManagerNAR;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputCityZipScreenWorkFlowManagerNAR$1;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputCityZipScreenWorkFlowManagerNAR$2;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputCityZipScreenWorkFlowManagerNAR
extends AbstractAddressInputScreenWorkFlowManagerNAR {
    private final CityHistory cityHistory;

    public AddressInputCityZipScreenWorkFlowManagerNAR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.cityHistory = cityHistory;
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 30202: {
                this.createNarCityZipScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            case 30203: {
                this.createNarCityZipScreenHistoryElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(-2137614336, "%1#handleWorkFlow - screenEventId %2 is in range of city zip screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createNarCityZipScreenHistoryElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createNarCityZipScreenHistoryElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, null, -1, null, SpellerContextManager.getSpellerContext(61), null));
        CommandList commandList2 = this.getCommandToCheckValidDestinationAndStartFollowSequence();
        if (commandList2 != null) {
            commandList.add(commandList2);
        }
    }

    private void createNarCityZipScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createNarCityZipScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("selectedElement");
        commandList.add(0, new LIGetStateCommand(this.spellerStack, lIValueListElement, -1, null, SpellerContextManager.getSpellerContext(106), null));
        CommandList commandList2 = this.getCommandToCheckValidDestinationAndStartFollowSequence();
        if (commandList2 != null) {
            commandList.add(commandList2);
        }
    }

    private CommandList getCommandToCheckValidDestinationAndStartFollowSequence() {
        if (this.spellerStack.containsContextID(74)) {
            return this.createCitySelectForHousenumberFirstWorkFlow();
        }
        if (this.spellerStack.containsContextID(65)) {
            return this.createCitySelectForStreetFirstWorkFlow();
        }
        return this.createCitySelectWorkFlow();
    }

    private CommandList createCitySelectWorkFlow() {
        this.env.getChoiceModel(-2027878912).setValue(0);
        return null;
    }

    private CommandList createCitySelectForStreetFirstWorkFlow() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new AddressInputCityZipScreenWorkFlowManagerNAR$1(this, new StringBuffer().append(this.CLASS_NAME).append("#createCitySelectForStreetFirstWorkFlow - decide if refinement screen is needed or NavLocation can be added to history").toString()));
        return commandList;
    }

    private CommandList createCitySelectForHousenumberFirstWorkFlow() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new AddressInputCityZipScreenWorkFlowManagerNAR$2(this, new StringBuffer().append(this.CLASS_NAME).append("#createCitySelectForHousenumberFirstWorkFlow decide if Housenumber freetext or alternative has to be used").toString()));
        return commandList;
    }

    static /* synthetic */ CityHistory access$000(AddressInputCityZipScreenWorkFlowManagerNAR addressInputCityZipScreenWorkFlowManagerNAR) {
        return addressInputCityZipScreenWorkFlowManagerNAR.cityHistory;
    }
}

