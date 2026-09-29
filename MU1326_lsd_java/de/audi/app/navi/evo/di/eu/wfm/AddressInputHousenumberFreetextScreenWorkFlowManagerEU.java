/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.wfm;

import de.audi.app.navi.evo.di.eu.wfm.AbstractAddressInputScreenWorkFlowManagerEU;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputHousenumberFreetextScreenWorkFlowManagerEU
extends AbstractAddressInputScreenWorkFlowManagerEU {
    public AddressInputHousenumberFreetextScreenWorkFlowManagerEU(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 402: {
                this.createEuHousenumberFreetextScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createEuHousenumberFreetextScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createEuHousenumberFreetextScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
    }
}

