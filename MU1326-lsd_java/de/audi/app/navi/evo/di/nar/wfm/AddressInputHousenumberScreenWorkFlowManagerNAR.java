/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.additionalstate.SaveHousenumberFirstValueStateInfo;
import de.audi.app.navi.evo.di.nar.wfm.AbstractAddressInputScreenWorkFlowManagerNAR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;

public class AddressInputHousenumberScreenWorkFlowManagerNAR
extends AbstractAddressInputScreenWorkFlowManagerNAR {
    public AddressInputHousenumberScreenWorkFlowManagerNAR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 30603: {
                this.createNarHousenumberFirstScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            case 30602: {
                this.createNarHousenumberScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            case 30604: {
                this.createNarHousenumberScreenIgnoreHousenumberSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(-2137614336, "%1#handleWorkFlow - screenEventId %2 is in range of housenumber matchspeller screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createNarHousenumberScreenIgnoreHousenumberSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createNarHousenumberScreenIgnoreHousenumberSelectedWorkFlow()", (Object)this.CLASS_NAME);
        while (this.spellerStack.getActiveSC().getContextID() == 70) {
            this.spellerStack.pop();
        }
    }

    private void createNarHousenumberScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createNarHousenumberScreenListElementSelectedWorkFlow()", (Object)this.CLASS_NAME);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, new SpellerContext(70)));
    }

    private void createNarHousenumberFirstScreenListElementSelectedWorkFlow(CommandList commandList) {
        String string = (String)commandList.get("HousenumberFirst Value");
        SaveHousenumberFirstValueStateInfo saveHousenumberFirstValueStateInfo = new SaveHousenumberFirstValueStateInfo(string);
        SpellerContext spellerContext = SpellerContextManager.getSpellerContext(65);
        commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, new IAdditionalStateInfo[]{saveHousenumberFirstValueStateInfo}, spellerContext, null));
        commandList.add(this.inputManager.getStreetScreenListener().getStartCommandList());
        this.logChannel.log(-2137614336, "%1#createNarHousenumberFirstScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
    }
}

