/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.wfm;

import de.audi.app.navi.evo.di.kr.wfm.AbstractAddressInputScreenWorkFlowManagerKR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputCityScreenWorkFlowManagerKR
extends AbstractAddressInputScreenWorkFlowManagerKR {
    private static final int CITY_NEEDS_WARD = 402590;
    private static final int WARD_UNAVAILABLE = 0;

    public AddressInputCityScreenWorkFlowManagerKR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow with screenEventId = %2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 40202: {
                this.createKRCityScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            case 40203: {
                this.createKRCityScreenHistoryElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createKRCityScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createKRCityScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("Update speller stack based on whether ward screen is availbale"){

            public void execute() {
                if (this.env.getChoiceModel(402590).getValue() == 0) {
                    AddressInputCityScreenWorkFlowManagerKR.this.logChannel.log(10000000, "%1#createKRCityScreenListElementSelectedWorkFlow -- ward screen is unavailable.", (Object)this.CLASS_NAME);
                    AddressInputCityScreenWorkFlowManagerKR.this.spellerStack.pop();
                } else {
                    AddressInputCityScreenWorkFlowManagerKR.this.logChannel.log(10000000, "%1#createKRCityScreenListElementSelectedWorkFlow -- enter ward screen.", (Object)this.CLASS_NAME);
                }
                this.getCommandList().commandFinished();
            }
        });
    }

    private void createKRCityScreenHistoryElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createKRCityScreenHistoryElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("Update speller stack based on whether ward screen is availbale"){

            public void execute() {
                if (this.env.getChoiceModel(402590).getValue() == 0) {
                    AddressInputCityScreenWorkFlowManagerKR.this.logChannel.log(10000000, "%1#createKRCityScreenHistoryElementSelectedWorkFlow -- ward screen is unavailable.", (Object)this.CLASS_NAME);
                    AddressInputCityScreenWorkFlowManagerKR.this.spellerStack.pop();
                } else {
                    AddressInputCityScreenWorkFlowManagerKR.this.logChannel.log(10000000, "%1#createKRCityScreenHistoryElementSelectedWorkFlow -- enter ward screen.", (Object)this.CLASS_NAME);
                }
                this.getCommandList().commandFinished();
            }
        });
    }
}

