/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.wfm;

import de.audi.app.navi.evo.di.kr.wfm.AbstractAddressInputScreenWorkFlowManagerKR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressInputMainScreenWorkFlowManagerKR
extends AbstractAddressInputScreenWorkFlowManagerKR {
    public AddressInputMainScreenWorkFlowManagerKR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

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
        this.logChannel.log(10000000, "%1#createKRMainScreenStartWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("Reset SpellerStack"){

            public void execute() {
                AddressInputMainScreenWorkFlowManagerKR.this.spellerStack.reset();
                this.getCommandList().commandFinished();
            }
        });
        SpellerContext spellerContext = this.getSpellerContext(40);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new NavCommand("Decide if to start the NDF with a given location"){

            public void execute() {
                Object object = this.commandList.get("startMainScreenNavLocation");
                if (object != null && object instanceof NavLocation) {
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerKR.this.inputManager.getMainScreenListener().getStartCommandList((NavLocation)object));
                } else {
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerKR.this.inputManager.getMainScreenListener().getStartCommandList());
                }
            }
        });
    }

    private void createKrMainScreenStartForOnlineWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createKrMainScreenStartForOnlineWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("Reset SpellerStack"){

            public void execute() {
                AddressInputMainScreenWorkFlowManagerKR.this.spellerStack.reset();
                this.getCommandList().commandFinished();
            }
        });
        SpellerContext spellerContext = this.getSpellerContext(80);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new NavCommand("Decide if to start the NDF with a given location"){

            public void execute() {
                Object object = this.commandList.get("startMainScreenNavLocation");
                if (object != null && object instanceof NavLocation) {
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerKR.this.inputManager.getMainScreenListener().getStartCommandListForOnline((NavLocation)object));
                } else {
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerKR.this.inputManager.getMainScreenListener().getStartCommandListForOnline());
                }
            }
        });
    }

    public void createKrMainScreenStartForRemoteHmiWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createKrMainScreenStartForRemoteHmiWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("Reset SpellerStack"){

            public void execute() {
                AddressInputMainScreenWorkFlowManagerKR.this.spellerStack.reset();
                this.getCommandList().commandFinished();
            }
        });
        SpellerContext spellerContext = this.getSpellerContext(83);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new NavCommand(){

            public void execute() {
                Object object = this.commandList.get("startMainScreenNavLocation");
                AddressInputMainScreenWorkFlowManagerKR.this.logChannel.log(10000000, "%1#createKrMainScreenStartForRemoteHmiWorkFlow with navLocation = %2", (Object)this.CLASS_NAME, object);
                if (object != null && object instanceof NavLocation) {
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerKR.this.inputManager.getMainScreenListener().getStartCommandList((NavLocation)object));
                } else {
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerKR.this.inputManager.getMainScreenListener().getStartCommandList());
                }
            }
        });
        commandList.add(new NavCommand("Decide if to start the NDF with a given location"){

            public void execute() {
                Object object = this.commandList.get("startMainScreenNavLocation");
                if (object != null && object instanceof NavLocation) {
                    AddressInputMainScreenWorkFlowManagerKR.this.logChannel.log(10000000, "%1#createKrMainScreenStartForRemoteHmiWorkFlow with navLocation = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort((NavLocation)object));
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerKR.this.inputManager.getMainScreenListener().getStartCommandList((NavLocation)object));
                } else {
                    AddressInputMainScreenWorkFlowManagerKR.this.logChannel.log(10000000, "%1#createKrMainScreenStartForRemoteHmiWorkFlow with null location!", (Object)this.CLASS_NAME);
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerKR.this.inputManager.getMainScreenListener().getStartCommandList());
                }
            }
        });
    }

    private void createKrMainScreenProvinceWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(10000000, "%1#createKrMainScreenProvinceWorkFlow", (Object)this.CLASS_NAME);
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
        this.logChannel.log(10000000, "%1#createKrMainScreenCityWorkFlow", (Object)this.CLASS_NAME);
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
        this.logChannel.log(10000000, "%1#createKrMainScreenFacilityNameWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("AddressInputMainScreenWorkFlowManagerKR#createKrMainScreenFacilityNameWorkFlow - Start POI-Hybrid"){

            public void execute() {
                IPoiService iPoiService = AddressInputMainScreenWorkFlowManagerKR.this.inputManager.getPoiService();
                NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
                if (Util.isEmpty(LocationFormatter.formatState(navLocation))) {
                    AddressInputMainScreenWorkFlowManagerKR.this.logChannel.log(10000000, "%1#execute() - SEARCH_CONTEXT_COUNTRY will be used because no state in currentLD is available", (Object)this.CLASS_NAME);
                    iPoiService.startPoiHybridSearch(5, navLocation, false);
                } else {
                    AddressInputMainScreenWorkFlowManagerKR.this.logChannel.log(10000000, "%1#execute() - SEARCH_CONTEXT_CITY will be used", (Object)this.CLASS_NAME);
                    iPoiService.startPoiHybridSearch(0, navLocation, false);
                }
                this.getCommandList().commandFinished();
            }
        });
    }

    private void createKrMainScreenTownStreetWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(10000000, "%1#createKrMainScreenTownStreetWorkFlow", (Object)this.CLASS_NAME);
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
        this.logChannel.log(10000000, "%1#createKrMainScreenNumberWorkFlow", (Object)this.CLASS_NAME);
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
        this.logChannel.log(10000000, "%1#createKrMainScreenStartGuidanceWorkFlow", (Object)this.CLASS_NAME);
    }
}

