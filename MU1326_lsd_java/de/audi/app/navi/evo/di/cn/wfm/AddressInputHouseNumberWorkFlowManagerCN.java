/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.wfm;

import de.audi.app.navi.evo.di.cn.wfm.AbstractAddressInputScreenWorkFlowManagerCN;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputHouseNumberWorkFlowManagerCN
extends AbstractAddressInputScreenWorkFlowManagerCN {
    public AddressInputHouseNumberWorkFlowManagerCN(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        switch (n) {
            case 10502: {
                this.createCNHousenumberScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createCNHousenumberScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createCNHousenumberScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
    }
}

