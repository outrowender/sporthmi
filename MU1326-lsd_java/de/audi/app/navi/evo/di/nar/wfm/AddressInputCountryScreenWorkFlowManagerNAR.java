/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AbstractAddressInputScreenWorkFlowManagerNAR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputCountryScreenWorkFlowManagerNAR
extends AbstractAddressInputScreenWorkFlowManagerNAR {
    public AddressInputCountryScreenWorkFlowManagerNAR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 30102: {
                this.createNarCountryScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(-2137614336, "%1#handleWorkFlow - screenEventId %2 is in range of country screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createNarCountryScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createNarCountryScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
    }
}

