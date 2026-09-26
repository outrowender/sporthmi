/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.jp.AddressInputManagerJP;
import de.audi.app.navi.evo.di.jp.wfm.AbstractAddressInputScreenWorkFlowManagerJP;
import de.audi.app.navi.evo.di.jp.wfm.AddressInputCityScreenWorkFlowManagerJP$1;
import de.audi.app.navi.evo.di.jp.wfm.AddressInputCityScreenWorkFlowManagerJP$2;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;

public class AddressInputCityScreenWorkFlowManagerJP
extends AbstractAddressInputScreenWorkFlowManagerJP {
    private final int cityNeedsWard;
    private final int wardUnavailable;

    public AddressInputCityScreenWorkFlowManagerJP(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.cityNeedsWard = -1641806336;
        this.wardUnavailable = 0;
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleWorkFlow with screenEventId = %2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 20202: {
                this.createJPCityScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            case 20203: {
                this.createJPCityScreenHistoryElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(-2137614336, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createJPCityScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createJPCityScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getWardSpellerContextDependingOnActiveContext(this.inputManager);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new AddressInputCityScreenWorkFlowManagerJP$1(this, "Update speller stack based on whether ward screen is availbale"));
    }

    private void createJPCityScreenHistoryElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createJPCityScreenHistoryElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getWardSpellerContextDependingOnActiveContext(this.inputManager);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new AddressInputCityScreenWorkFlowManagerJP$2(this, "Update speller stack based on whether ward screen is availbale"));
    }

    private SpellerContext getWardSpellerContextDependingOnActiveContext(AddressInputManagerJP addressInputManagerJP) {
        SpellerContext spellerContext = null;
        spellerContext = addressInputManagerJP.getActiveSpellerContextId() == 91 ? this.getSpellerContext(93) : (addressInputManagerJP.getActiveSpellerContextId() == 92 ? this.getSpellerContext(94) : this.getSpellerContext(39));
        return spellerContext;
    }
}

