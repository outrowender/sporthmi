/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.jp.wfm.AbstractAddressInputScreenWorkFlowManagerJP;
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

public class AddressInputMainScreenWorkFlowManagerJP
extends AbstractAddressInputScreenWorkFlowManagerJP {
    public AddressInputMainScreenWorkFlowManagerJP(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        switch (n) {
            case 20012: {
                this.createJpMainScreenStartWorkFlow(commandList);
                break;
            }
            case 20013: {
                this.createJpMainScreenStartForOnlineWorkFlow(commandList);
                break;
            }
            case 20014: {
                this.createJpMainScreenStartForRemoteHmiWorkFlow(commandList);
                break;
            }
            case 20002: {
                this.createJpMainScreenPrefectureWorkFlow(commandList, false);
                break;
            }
            case 20007: {
                this.createJpMainScreenPrefectureWorkFlow(commandList, true);
                break;
            }
            case 20003: {
                this.createJpMainScreenCityWorkFlow(commandList, false);
                break;
            }
            case 20008: {
                this.createJpMainScreenCityWorkFlow(commandList, true);
                break;
            }
            case 20004: {
                this.createJpMainScreenFacilityNameWorkFlow(commandList);
                break;
            }
            case 20005: {
                this.createJpMainScreenPlaceWorkFlow(commandList, false);
                break;
            }
            case 20009: {
                this.createJpMainScreenPlaceWorkFlow(commandList, true);
                break;
            }
            case 20006: {
                this.createJpMainScreenChomeWorkFlow(commandList, false);
                break;
            }
            case 20010: {
                this.createJpMainScreenChomeWorkFlow(commandList, true);
                break;
            }
            case 20011: {
                this.createJpMainScreenStartGuidanceWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createJpMainScreenStartWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createJpMainScreenStartWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("Reset SpellerStack"){

            public void execute() {
                AddressInputMainScreenWorkFlowManagerJP.this.spellerStack.reset();
                this.getCommandList().commandFinished();
            }
        });
        SpellerContext spellerContext = this.getSpellerContext(32);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new NavCommand("Decide if to start the NDF with a given location"){

            public void execute() {
                Object object = this.commandList.get("startMainScreenNavLocation");
                if (object != null && object instanceof NavLocation) {
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerJP.this.inputManager.getMainScreenListener().getStartCommandList((NavLocation)object));
                } else {
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerJP.this.inputManager.getMainScreenListener().getStartCommandList());
                }
            }
        });
    }

    private void createJpMainScreenStartForOnlineWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createJpMainScreenStartForOnlineWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("Reset SpellerStack"){

            public void execute() {
                AddressInputMainScreenWorkFlowManagerJP.this.spellerStack.reset();
                this.getCommandList().commandFinished();
            }
        });
        SpellerContext spellerContext = this.getSpellerContext(79);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new NavCommand("Decide if to start the NDF with a given location"){

            public void execute() {
                Object object = this.commandList.get("startMainScreenNavLocation");
                if (object != null && object instanceof NavLocation) {
                    AddressInputMainScreenWorkFlowManagerJP.this.logChannel.log(10000000, "%1#createJpMainScreenStartForOnlineWorkFlow with navLocation = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort((NavLocation)object));
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerJP.this.inputManager.getMainScreenListener().getStartCommandListForOnline((NavLocation)object));
                } else {
                    AddressInputMainScreenWorkFlowManagerJP.this.logChannel.log(10000000, "%1#createJpMainScreenStartForOnlineWorkFlow with null location!", (Object)this.CLASS_NAME);
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerJP.this.inputManager.getMainScreenListener().getStartCommandListForOnline());
                }
            }
        });
    }

    public void createJpMainScreenStartForRemoteHmiWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createJpMainScreenStartForRemoteHmiWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("Reset SpellerStack"){

            public void execute() {
                AddressInputMainScreenWorkFlowManagerJP.this.spellerStack.reset();
                this.getCommandList().commandFinished();
            }
        });
        SpellerContext spellerContext = this.getSpellerContext(82);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new NavCommand(){

            public void execute() {
                Object object = this.commandList.get("startMainScreenNavLocation");
                if (object != null && object instanceof NavLocation) {
                    AddressInputMainScreenWorkFlowManagerJP.this.logChannel.log(10000000, "%1#createJpMainScreenStartForRemoteHmiWorkFlow with navLocation = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort((NavLocation)object));
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerJP.this.inputManager.getMainScreenListener().getStartCommandList((NavLocation)object));
                } else {
                    AddressInputMainScreenWorkFlowManagerJP.this.logChannel.log(10000000, "%1#createJpMainScreenStartForRemoteHmiWorkFlow with null location!", (Object)this.CLASS_NAME);
                    this.getCommandList().commandFinishedWithPostSequence(AddressInputMainScreenWorkFlowManagerJP.this.inputManager.getMainScreenListener().getStartCommandList());
                }
            }
        });
    }

    private void createJpMainScreenPrefectureWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(10000000, "%1#createJpMainScreenPrefectureWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(33);
        if (this.inputManager.getActiveSpellerContextId() == 79) {
            spellerContext = this.getSpellerContext(89);
        } else if (this.inputManager.getActiveSpellerContextId() == 82) {
            spellerContext = this.getSpellerContext(89);
        }
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getPrefectureScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getPrefectureScreenListener().getStartCommandList());
        }
    }

    private void createJpMainScreenCityWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(10000000, "%1#createJpMainScreenCityWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(34);
        if (this.inputManager.getActiveSpellerContextId() == 79) {
            spellerContext = this.getSpellerContext(91);
        } else if (this.inputManager.getActiveSpellerContextId() == 82) {
            spellerContext = this.getSpellerContext(92);
        }
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getCityScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getCityScreenListener().getStartCommandList());
        }
    }

    private void createJpMainScreenFacilityNameWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createJpMainScreenFacilityNameWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("AddressInputMainScreenWorkFlowManagerJP#createJpMainScreenFacilityNameWorkFlow - Start POI-Hybrid"){

            public void execute() {
                IPoiService iPoiService = AddressInputMainScreenWorkFlowManagerJP.this.inputManager.getPoiService();
                NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
                if (Util.isEmpty(LocationFormatter.formatState(navLocation))) {
                    AddressInputMainScreenWorkFlowManagerJP.this.logChannel.log(10000000, "%1#execute() - SEARCH_CONTEXT_COUNTRY will be used because no state in currentLD is available", (Object)this.CLASS_NAME);
                    iPoiService.startPoiHybridSearch(5, navLocation, false);
                } else {
                    AddressInputMainScreenWorkFlowManagerJP.this.logChannel.log(10000000, "%1#execute() - SEARCH_CONTEXT_CITY will be used", (Object)this.CLASS_NAME);
                    iPoiService.startPoiHybridSearch(0, navLocation, false);
                }
                this.getCommandList().commandFinished();
            }
        });
    }

    private void createJpMainScreenPlaceWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(10000000, "%1#createJpMainScreenPlaceWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(36);
        if (this.inputManager.getActiveSpellerContextId() == 79) {
            spellerContext = this.getSpellerContext(95);
        }
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getPlaceNameScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getPlaceNameScreenListener().getStartCommandList());
        }
    }

    private void createJpMainScreenChomeWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(10000000, "%1#createJpMainScreenChomeWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(37);
        if (this.inputManager.getActiveSpellerContextId() == 79) {
            spellerContext = this.getSpellerContext(96);
        }
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getChomeScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getChomeScreenListener().getStartCommandList());
        }
    }

    private void createJpMainScreenStartGuidanceWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createJpMainScreenStartGuidanceWorkFlow", (Object)this.CLASS_NAME);
    }
}

