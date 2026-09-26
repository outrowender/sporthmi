/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.wfm;

import de.audi.app.navi.evo.di.kr.wfm.AbstractAddressInputScreenWorkFlowManagerKR;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputCityScreenWorkFlowManagerKR$1;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputCityScreenWorkFlowManagerKR$2;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputCityScreenWorkFlowManagerKR
extends AbstractAddressInputScreenWorkFlowManagerKR {
    private static final int CITY_NEEDS_WARD;
    private static final int WARD_UNAVAILABLE;

    public AddressInputCityScreenWorkFlowManagerKR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleWorkFlow with screenEventId = %2", (Object)this.CLASS_NAME, (long)n);
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
        this.logChannel.log(-2137614336, "%1#createKRCityScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputCityScreenWorkFlowManagerKR$1(this, "Update speller stack based on whether ward screen is availbale"));
    }

    private void createKRCityScreenHistoryElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createKRCityScreenHistoryElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputCityScreenWorkFlowManagerKR$2(this, "Update speller stack based on whether ward screen is availbale"));
    }
}

