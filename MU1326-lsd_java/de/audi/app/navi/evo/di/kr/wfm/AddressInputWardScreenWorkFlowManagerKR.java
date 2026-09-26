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

public class AddressInputWardScreenWorkFlowManagerKR
extends AbstractAddressInputScreenWorkFlowManagerKR {
    public AddressInputWardScreenWorkFlowManagerKR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 40302: {
                this.createKRWardScreenSelectListElementWorkFlow(commandList);
                break;
            }
            case 40303: {
                this.createKRWardScreenEnteredWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of ward screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createKRWardScreenSelectListElementWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createKRWardScreenSelectListElementWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
        this.spellerStack.pop();
    }

    private void createKRWardScreenEnteredWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createKRWardScreenEnteredWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(43);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(this.inputManager.getWardScreenListener().getStartCommandList());
    }
}

