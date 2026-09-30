/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.jp.AddressInputManagerJP;
import de.audi.app.navi.evo.di.jp.wfm.AbstractAddressInputScreenWorkFlowManagerJP;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;

public class AddressInputCityScreenWorkFlowManagerJP
extends AbstractAddressInputScreenWorkFlowManagerJP {
    private final int cityNeedsWard;
    private final int wardUnavailable;

    public AddressInputCityScreenWorkFlowManagerJP(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.cityNeedsWard = 402590;
        this.wardUnavailable = 0;
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow with screenEventId = %2", (Object)this.CLASS_NAME, (long)n);
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
                this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createJPCityScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createJPCityScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getWardSpellerContextDependingOnActiveContext(this.inputManager);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new NavCommand("Update speller stack based on whether ward screen is availbale"){

            public void execute() {
                if (this.env.getChoiceModel(402590).getValue() == 0) {
                    AddressInputCityScreenWorkFlowManagerJP.this.logChannel.log(10000000, "%1#createJPCityScreenListElementSelectedWorkFlow -- ward screen is unavailable.", (Object)this.CLASS_NAME);
                    AddressInputCityScreenWorkFlowManagerJP.this.spellerStack.pop();
                    if (AddressInputCityScreenWorkFlowManagerJP.this.spellerStack.getActiveSC().getContextID() == 34) {
                        AddressInputCityScreenWorkFlowManagerJP.this.spellerStack.pop();
                    }
                    if (AddressInputUtilEvo.isRemoteHMIPOIContext(this.env)) {
                        AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 1);
                    }
                } else {
                    AddressInputCityScreenWorkFlowManagerJP.this.logChannel.log(10000000, "%1#createJPCityScreenListElementSelectedWorkFlow -- enter ward screen.", (Object)this.CLASS_NAME);
                }
                this.getCommandList().commandFinished();
            }
        });
    }

    private void createJPCityScreenHistoryElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createJPCityScreenHistoryElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getWardSpellerContextDependingOnActiveContext(this.inputManager);
        commandList.add(0, new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new NavCommand("Update speller stack based on whether ward screen is availbale"){

            public void execute() {
                if (this.env.getChoiceModel(402590).getValue() == 0) {
                    AddressInputCityScreenWorkFlowManagerJP.this.logChannel.log(10000000, "%1#createJPCityScreenListElementSelectedWorkFlow -- ward screen is unavailable.", (Object)this.CLASS_NAME);
                    AddressInputCityScreenWorkFlowManagerJP.this.spellerStack.pop();
                    if (AddressInputCityScreenWorkFlowManagerJP.this.spellerStack.getActiveSC().getContextID() == 34) {
                        AddressInputCityScreenWorkFlowManagerJP.this.spellerStack.pop();
                    }
                    if (AddressInputUtilEvo.isRemoteHMIPOIContext(this.env)) {
                        AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 1);
                    }
                } else {
                    AddressInputCityScreenWorkFlowManagerJP.this.logChannel.log(10000000, "%1#createJPCityScreenListElementSelectedWorkFlow -- enter ward screen.", (Object)this.CLASS_NAME);
                }
                this.getCommandList().commandFinished();
            }
        });
    }

    private SpellerContext getWardSpellerContextDependingOnActiveContext(AddressInputManagerJP addressInputManagerJP) {
        SpellerContext spellerContext = null;
        spellerContext = addressInputManagerJP.getActiveSpellerContextId() == 91 ? this.getSpellerContext(93) : (addressInputManagerJP.getActiveSpellerContextId() == 92 ? this.getSpellerContext(94) : this.getSpellerContext(39));
        return spellerContext;
    }
}

