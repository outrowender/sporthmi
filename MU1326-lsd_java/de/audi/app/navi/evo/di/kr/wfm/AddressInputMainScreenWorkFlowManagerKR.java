/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.wfm;

import de.audi.app.navi.evo.di.kr.wfm.AbstractAddressInputScreenWorkFlowManagerKR;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR$1;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR$2;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR$3;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR$4;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR$5;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR$6;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR$7;
import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR$8;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;

public class AddressInputMainScreenWorkFlowManagerKR
extends AbstractAddressInputScreenWorkFlowManagerKR {
    public AddressInputMainScreenWorkFlowManagerKR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        switch (n) {
            case 40012: {
                this.createKrMainScreenStartWorkFlow(commandList);
                break;
            }
            case 40013: {
                this.createKrMainScreenStartForOnlineWorkFlow(commandList);
                break;
            }
            case 40014: {
                this.createKrMainScreenStartForRemoteHmiWorkFlow(commandList);
            }
            case 40002: {
                this.createKrMainScreenProvinceWorkFlow(commandList, false);
                break;
            }
            case 40007: {
                this.createKrMainScreenProvinceWorkFlow(commandList, true);
                break;
            }
            case 40003: {
                this.createKrMainScreenCityWorkFlow(commandList, false);
                break;
            }
            case 40008: {
                this.createKrMainScreenCityWorkFlow(commandList, true);
                break;
            }
            case 40004: {
                this.createKrMainScreenFacilityNameWorkFlow(commandList);
                break;
            }
            case 40005: {
                this.createKrMainScreenTownStreetWorkFlow(commandList, false);
                break;
            }
            case 40009: {
                this.createKrMainScreenTownStreetWorkFlow(commandList, true);
                break;
            }
            case 40006: {
                this.createKrMainScreenNumberWorkFlow(commandList, false);
                break;
            }
            case 40010: {
                this.createKrMainScreenNumberWorkFlow(commandList, true);
                break;
            }
            case 40011: {
                this.createKrMainScreenStartGuidanceWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createKrMainScreenStartWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createKRMainScreenStartWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputMainScreenWorkFlowManagerKR$1(this, "Reset SpellerStack"));
        SpellerContext spellerContext = this.getSpellerContext(40);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new AddressInputMainScreenWorkFlowManagerKR$2(this, "Decide if to start the NDF with a given location"));
    }

    private void createKrMainScreenStartForOnlineWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createKrMainScreenStartForOnlineWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputMainScreenWorkFlowManagerKR$3(this, "Reset SpellerStack"));
        SpellerContext spellerContext = this.getSpellerContext(80);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new AddressInputMainScreenWorkFlowManagerKR$4(this, "Decide if to start the NDF with a given location"));
    }

    public void createKrMainScreenStartForRemoteHmiWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createKrMainScreenStartForRemoteHmiWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputMainScreenWorkFlowManagerKR$5(this, "Reset SpellerStack"));
        SpellerContext spellerContext = this.getSpellerContext(83);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new AddressInputMainScreenWorkFlowManagerKR$6(this));
        commandList.add(new AddressInputMainScreenWorkFlowManagerKR$7(this, "Decide if to start the NDF with a given location"));
    }

    private void createKrMainScreenProvinceWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createKrMainScreenProvinceWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(41);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getProvinceScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getProvinceScreenListener().getStartCommandList());
        }
    }

    private void createKrMainScreenCityWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createKrMainScreenCityWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(42);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getCityScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getCityScreenListener().getStartCommandList());
        }
    }

    private void createKrMainScreenFacilityNameWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createKrMainScreenFacilityNameWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputMainScreenWorkFlowManagerKR$8(this, "AddressInputMainScreenWorkFlowManagerKR#createKrMainScreenFacilityNameWorkFlow - Start POI-Hybrid"));
    }

    private void createKrMainScreenTownStreetWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createKrMainScreenTownStreetWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(46);
        spellerContext = this.inputManager.getActiveSpellerContextId() == 80 ? this.getSpellerContext(97) : (this.inputManager.getActiveSpellerContextId() == 83 ? this.getSpellerContext(98) : this.getSpellerContext(46));
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getTownStreetScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getTownStreetScreenListener().getStartCommandList());
        }
    }

    private void createKrMainScreenNumberWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createKrMainScreenNumberWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(47);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getNumberScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getNumberScreenListener().getStartCommandList());
        }
    }

    private void createKrMainScreenStartGuidanceWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createKrMainScreenStartGuidanceWorkFlow", (Object)this.CLASS_NAME);
    }
}

