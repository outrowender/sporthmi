/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.wfm;

import de.audi.app.navi.evo.di.kr.wfm.AbstractAddressInputScreenWorkFlowManagerKR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;

public class AddressInputVillageStreetWorkFlowManagerKR
extends AbstractAddressInputScreenWorkFlowManagerKR {
    public AddressInputVillageStreetWorkFlowManagerKR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 40602: {
                this.createKRVillageStreetScreenSelectListElementWorkFlow(commandList);
                break;
            }
            case 40603: {
                this.createKRVillageStreetScreenEnteredWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of refinement screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createKRVillageStreetScreenSelectListElementWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createKRRefinementScreenSelectListElementWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
        this.spellerStack.pop();
    }

    private void createKRVillageStreetScreenEnteredWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createKRVillageStreetScreenEnteredWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(45);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(this.inputManager.getVillageStreetScreenListener().getStartCommandList());
    }
}

