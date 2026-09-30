/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr;

import de.audi.app.navi.evo.di.AbstractAddressInputWorkFlowManagerEvo;
import de.audi.app.navi.evo.di.kr.AddressInputManagerKR;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputCityScreenWorkFlowManagerKR;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputNumberScreenWorkFlowManagerKR;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputProvinceScreenWorkFlowManagerKR;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputTownStreetScreenWorkFlowManagerKR;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputVillageStreetWorkFlowManagerKR;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputWardScreenWorkFlowManagerKR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputWorkFlowManagerKR
extends AbstractAddressInputWorkFlowManagerEvo {
    protected AddressInputManagerKR addressInputManager;
    private final AddressInputMainScreenWorkFlowManagerKR mainScreenWorkFlowManager;
    private final AddressInputProvinceScreenWorkFlowManagerKR provinceScreenWorkFlowManager;
    private final AddressInputCityScreenWorkFlowManagerKR cityScreenWorkFlowManager;
    private final AddressInputWardScreenWorkFlowManagerKR wardScreenWorkFlowManager;
    private final AddressInputTownStreetScreenWorkFlowManagerKR townStreetSrceenWorkFlowManager;
    private final AddressInputVillageStreetWorkFlowManagerKR villageStreetWorkFlowManager;
    private final AddressInputNumberScreenWorkFlowManagerKR numberScreenWorkFlowManager;

    public AddressInputWorkFlowManagerKR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.mainScreenWorkFlowManager = new AddressInputMainScreenWorkFlowManagerKR(navigationEnv, iCommandListFactory, spellerStack);
        this.provinceScreenWorkFlowManager = new AddressInputProvinceScreenWorkFlowManagerKR(navigationEnv, iCommandListFactory, spellerStack);
        this.cityScreenWorkFlowManager = new AddressInputCityScreenWorkFlowManagerKR(navigationEnv, iCommandListFactory, spellerStack);
        this.wardScreenWorkFlowManager = new AddressInputWardScreenWorkFlowManagerKR(navigationEnv, iCommandListFactory, spellerStack);
        this.townStreetSrceenWorkFlowManager = new AddressInputTownStreetScreenWorkFlowManagerKR(navigationEnv, iCommandListFactory, spellerStack);
        this.villageStreetWorkFlowManager = new AddressInputVillageStreetWorkFlowManagerKR(navigationEnv, iCommandListFactory, spellerStack);
        this.numberScreenWorkFlowManager = new AddressInputNumberScreenWorkFlowManagerKR(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        commandList.setErrorCommand(null);
        this.logChannel.log(10000000, "%1#handleWorkFlow - eventId=%2", (Object)this.CLASS_NAME, (long)n);
        if (this.isSystemKR(n)) {
            if (this.isKRMainScreen(n)) {
                return this.mainScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isKRProvinceScreen(n)) {
                return this.provinceScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isKRCityScreen(n)) {
                return this.cityScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isKRWardScreen(n)) {
                return this.wardScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isKRFacilityScreen(n)) {
                return commandList;
            }
            if (this.isKRTownStreetScreen(n)) {
                return this.townStreetSrceenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isKRVillageStreetScreen(n)) {
                return this.villageStreetWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isKRNumberScreen(n)) {
                return this.numberScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            this.logChannel.log(10000, "%1#handleWorkFlow - received invalid screenEventId. ID=%2 is in range of KR system, but no match found.", (Object)this.CLASS_NAME, (long)n);
        } else {
            this.logChannel.log(10000, "%1#handleWorkFlow - received invalid screenEventId. ID=%2 isn't in value range of KR system.", (Object)this.CLASS_NAME, (long)n);
        }
        return commandList;
    }

    public void setAddressInputManager(IAddressInputManager iAddressInputManager) {
        if (iAddressInputManager instanceof AddressInputManagerKR) {
            this.addressInputManager = (AddressInputManagerKR)iAddressInputManager;
            this.mainScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.provinceScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.cityScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.wardScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.townStreetSrceenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.villageStreetWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.numberScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
        }
    }
}

