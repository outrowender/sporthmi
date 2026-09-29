/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.wfm;

import de.audi.app.navi.evo.di.kr.wfm.AbstractAddressInputScreenWorkFlowManagerKR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputProvinceScreenWorkFlowManagerKR
extends AbstractAddressInputScreenWorkFlowManagerKR {
    public AddressInputProvinceScreenWorkFlowManagerKR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleWorkFlow with screenEventId = %2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 40102: {
                this.createKRProvinceScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            case 40103: {
                this.createKRProvinceScreenHistoryElementSelectedWorkFlow(commandList);
                break;
            }
            case 40104: {
                this.createKrProvinceScreenNationWideSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of intersection screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createKRProvinceScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createKRProvinceScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
    }

    private void createKRProvinceScreenHistoryElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createKRProvinceScreenHistoryElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
    }

    private void createKrProvinceScreenNationWideSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createKrProvinceScreenNationWideSelectedWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
    }
}

