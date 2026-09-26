/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.wfm;

import de.audi.app.navi.evo.di.cn.wfm.AbstractAddressInputScreenWorkFlowManagerCN;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputStreetScreenWorkFlowManagerCN
extends AbstractAddressInputScreenWorkFlowManagerCN {
    public AddressInputStreetScreenWorkFlowManagerCN(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        switch (n) {
            case 10402: {
                this.createCnStreetScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            case 10404: {
                this.createCnStreetScreenAmbiguousStreetSelectedWorkFlow(commandList);
                break;
            }
            case 10403: {
                this.createCnStreetScreenNonAmbiguousStreetSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of city screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createCnStreetScreenNonAmbiguousStreetSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createCnStreetScreenNonAmbiguousStreetSelectedWorkFlow", (Object)this.CLASS_NAME);
    }

    private void createCnStreetScreenAmbiguousStreetSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createCnStreetScreenAmbiguousStreetSelectedWorkFlow", (Object)this.CLASS_NAME);
    }

    private void createCnStreetScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createCNStreetScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
        AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 1);
    }
}

