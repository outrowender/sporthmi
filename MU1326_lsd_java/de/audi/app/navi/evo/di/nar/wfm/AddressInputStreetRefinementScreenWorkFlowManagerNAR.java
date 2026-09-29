/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AbstractAddressInputScreenWorkFlowManagerNAR;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputStreetRefinementScreenWorkFlowManagerNAR$1;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputStreetRefinementScreenWorkFlowManagerNAR$2;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputStreetRefinementScreenWorkFlowManagerNAR$3;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;

public class AddressInputStreetRefinementScreenWorkFlowManagerNAR
extends AbstractAddressInputScreenWorkFlowManagerNAR {
    private final CityHistory cityHistory;

    public AddressInputStreetRefinementScreenWorkFlowManagerNAR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.cityHistory = cityHistory;
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 30702: {
                if (this.spellerStack.containsContextID(74)) {
                    this.createDiNarStreetRefinementScreenListElementSelectedHousenumberFirstWorkFlow(commandList);
                    break;
                }
                if (this.spellerStack.containsContextID(65)) {
                    this.createDiNarStreetRefinementScreenListElementSelectedStreetFirstWorkFlow(commandList);
                    break;
                }
                this.createDiNarStreetRefinementScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(-2137614336, "%1#handleWorkFlow - screenEventId %2 is in range of StreetRefinementScreen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createDiNarStreetRefinementScreenListElementSelectedHousenumberFirstWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createDiNarStreetRefinementScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, null, -1, null, SpellerContextManager.getSpellerContext(72), null));
        commandList.add(new AddressInputStreetRefinementScreenWorkFlowManagerNAR$1(this, new StringBuffer().append(this.CLASS_NAME).append("#createDiNarStreetRefinementScreenListElementSelectedHousenumberFirstWorkFlow - AddStreetAndCityToHistoryCommand with NavLocation from ResponseContainer").toString()));
        commandList.add(new AddressInputStreetRefinementScreenWorkFlowManagerNAR$2(this, "Check For PositionValid or start AdditionCriteriaSpeller for Housenumber"));
    }

    private void createDiNarStreetRefinementScreenListElementSelectedStreetFirstWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createDiNarStreetRefinementScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, null, -1, null, SpellerContextManager.getSpellerContext(72), null));
        commandList.add(new AddressInputStreetRefinementScreenWorkFlowManagerNAR$3(this, "AddStreetAndCityToHistoryCommand with NavLocation from ResponseContainer"));
    }

    private void createDiNarStreetRefinementScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createDiNarStreetRefinementScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, null, -1, null, SpellerContextManager.getSpellerContext(72), null));
    }

    static /* synthetic */ CityHistory access$000(AddressInputStreetRefinementScreenWorkFlowManagerNAR addressInputStreetRefinementScreenWorkFlowManagerNAR) {
        return addressInputStreetRefinementScreenWorkFlowManagerNAR.cityHistory;
    }
}

