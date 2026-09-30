/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.wfm;

import de.audi.app.navi.evo.di.cn.wfm.AbstractAddressInputScreenWorkFlowManagerCN;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputCityScreenWorkFlowManagerCN
extends AbstractAddressInputScreenWorkFlowManagerCN {
    public AddressInputCityScreenWorkFlowManagerCN(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        switch (n) {
            case 10102: {
                this.createCNCityScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            case 10103: {
                this.createCNCityScreenHistoryElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId %2 is in range of city screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createCNCityScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createCNCityScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
    }

    private void createCNCityScreenHistoryElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createCNCityScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
    }
}

