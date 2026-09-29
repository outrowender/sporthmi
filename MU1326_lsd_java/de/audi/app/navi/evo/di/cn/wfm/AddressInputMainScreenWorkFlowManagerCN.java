/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.wfm;

import de.audi.app.navi.evo.di.cn.wfm.AbstractAddressInputScreenWorkFlowManagerCN;
import de.audi.app.navi.evo.di.cn.wfm.AddressInputMainScreenWorkFlowManagerCN$1;
import de.audi.app.navi.evo.di.cn.wfm.AddressInputMainScreenWorkFlowManagerCN$2;
import de.audi.app.navi.evo.di.cn.wfm.AddressInputMainScreenWorkFlowManagerCN$3;
import de.audi.app.navi.evo.di.cn.wfm.AddressInputMainScreenWorkFlowManagerCN$4;
import de.audi.app.navi.evo.di.cn.wfm.AddressInputMainScreenWorkFlowManagerCN$5;
import de.audi.app.navi.evo.di.cn.wfm.AddressInputMainScreenWorkFlowManagerCN$6;
import de.audi.app.navi.evo.di.cn.wfm.AddressInputMainScreenWorkFlowManagerCN$7;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;

public class AddressInputMainScreenWorkFlowManagerCN
extends AbstractAddressInputScreenWorkFlowManagerCN {
    public AddressInputMainScreenWorkFlowManagerCN(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        switch (n) {
            case 10008: {
                this.createCnMainScreenStartWorkFlow(commandList);
                break;
            }
            case 10013: {
                this.createCnMainScreenStartForOnlineWorkFlow(commandList);
                break;
            }
            case 10014: {
                this.createCnMainScreenStartForRemoteHmiWorkFlow(commandList);
                break;
            }
            case 10002: {
                this.createCnMainScreenCityWorkFlow(commandList, false);
                break;
            }
            case 10009: {
                this.createCnMainScreenCityWorkFlow(commandList, true);
                break;
            }
            case 10003: {
                this.createCnMainScreenLocationNameWorkFlow(commandList);
                break;
            }
            case 10004: {
                this.createCnMainScreenStreetWorkFlow(commandList, false);
                break;
            }
            case 10010: {
                this.createCnMainScreenStreetWorkFlow(commandList, true);
                break;
            }
            case 10005: {
                this.createCnMainScreenHouseNumberWorkFlow(commandList, false);
                break;
            }
            case 10011: {
                this.createCnMainScreenHouseNumberWorkFlow(commandList, true);
                break;
            }
            case 10006: {
                this.createCnMainScreenIntersectionWorkFlow(commandList, false);
                break;
            }
            case 10012: {
                this.createCnMainScreenIntersectionWorkFlow(commandList, true);
                break;
            }
            case 10007: {
                this.createCnMainScreenStartGuidanceWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createCnMainScreenStartWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createCnMainScreenStartWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputMainScreenWorkFlowManagerCN$1(this, "Reset SpellerStack"));
        SpellerContext spellerContext = this.getSpellerContext(26);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new AddressInputMainScreenWorkFlowManagerCN$2(this, "Decide if to start the NDF with a given location"));
    }

    private void createCnMainScreenStartForOnlineWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createCnMainScreenStartForOnlineWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputMainScreenWorkFlowManagerCN$3(this, "Reset SpellerStack"));
        SpellerContext spellerContext = this.getSpellerContext(78);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new AddressInputMainScreenWorkFlowManagerCN$4(this, "Decide if to start the NDF with a given location"));
    }

    private void createCnMainScreenStartForRemoteHmiWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createCnMainScreenStartForRemoteHmiWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputMainScreenWorkFlowManagerCN$5(this, "Reset SpellerStack"));
        SpellerContext spellerContext = this.getSpellerContext(81);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new AddressInputMainScreenWorkFlowManagerCN$6(this, "Decide if to start the NDF with a given location"));
    }

    private void createCnMainScreenCityWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createCnMainScreenCityWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.inputManager.getActiveSpellerContextId() == 78 ? this.getSpellerContext(84) : (this.inputManager.getActiveSpellerContextId() == 81 ? this.getSpellerContext(85) : this.getSpellerContext(27));
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getCityZipScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getCityZipScreenListener().getStartCommandList());
        }
    }

    private void createCnMainScreenLocationNameWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createCnMainScreenLocationNameWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputMainScreenWorkFlowManagerCN$7(this, "Start POI"));
    }

    private void createCnMainScreenStreetWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createCnMainScreenStreetWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(29);
        spellerContext = this.inputManager.getActiveSpellerContextId() == 78 ? this.getSpellerContext(86) : (this.inputManager.getActiveSpellerContextId() == 81 ? this.getSpellerContext(87) : this.getSpellerContext(29));
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getStreetScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getStreetScreenListener().getStartCommandList());
        }
    }

    private void createCnMainScreenHouseNumberWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createCnMainScreenHouseNumberWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(30);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getHouseNumberScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getHouseNumberScreenListener().getStartCommandList());
        }
    }

    private void createCnMainScreenIntersectionWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createCnMainScreenIntersectionWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(31);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getIntersectionScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getIntersectionScreenListener().getStartCommandList());
        }
    }

    private void createCnMainScreenStartGuidanceWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createCnMainScreenStartGuidanceWorkFlow", (Object)this.CLASS_NAME);
    }
}

