/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.wfm;

import de.audi.app.navi.evo.di.eu.wfm.AbstractAddressInputScreenWorkFlowManagerEU;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.global.NavLocation;

public class AddressInputMainScreenWorkFlowManagerEU
extends AbstractAddressInputScreenWorkFlowManagerEU {
    public AddressInputMainScreenWorkFlowManagerEU(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 7: {
                this.createEuMainScreenStartWorkFlow(commandList);
                break;
            }
            case 14: {
                this.createEuMainScreenStartForOnlineWorkFlow(commandList);
                break;
            }
            case 17: {
                this.createEuMainScreenStartForRemoteHmiWorkFlow(commandList);
                break;
            }
            case 8: {
                this.createEuMainScreenStartGuidanceWorkFlow(commandList);
                break;
            }
            case 2: {
                this.createEuMainScreenCountryWorkFlow(commandList, false);
                break;
            }
            case 9: {
                this.createEuMainScreenCountryWorkFlow(commandList, true);
                break;
            }
            case 3: {
                this.createEuMainScreenCityZipWorkFlow(commandList, false);
                break;
            }
            case 10: {
                this.createEuMainScreenCityZipWorkFlow(commandList, true);
                break;
            }
            case 4: {
                this.createEuMainScreenStreetWorkFlow(commandList, false);
                break;
            }
            case 11: {
                this.createEuMainScreenStreetWorkFlow(commandList, true);
                break;
            }
            case 5: {
                this.createEuMainScreenHousenumberWorkFlow(commandList, false);
                break;
            }
            case 12: {
                this.createEuMainScreenHousenumberWorkFlow(commandList, true);
                break;
            }
            case 6: {
                this.createEuMainScreenJunctionWorkFlow(commandList, false);
                break;
            }
            case 13: {
                this.createEuMainScreenJunctionWorkFlow(commandList, true);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createEuMainScreenStartForRemoteHmiWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createEuMainScreenStartForRemoteHmiWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("Reset SpellerStack"){

            public void execute() {
                AddressInputMainScreenWorkFlowManagerEU.this.spellerStack.reset();
                this.getCommandList().commandFinished();
            }
        });
        SpellerContext spellerContext = this.getSpellerContext(75);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(this.inputManager.getMainScreenListener().getStartCommandList());
    }

    private void createEuMainScreenStartWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createEuMainScreenStartWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("Reset SpellerStack"){

            public void execute() {
                AddressInputMainScreenWorkFlowManagerEU.this.spellerStack.reset();
                this.getCommandList().commandFinished();
            }
        });
        SpellerContext spellerContext = this.getSpellerContext(19);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        Object object = commandList.get("startMainScreenNavLocation");
        if (object != null && object instanceof NavLocation) {
            commandList.add(this.inputManager.getMainScreenListener().getStartCommandList((NavLocation)object));
        } else {
            commandList.add(this.inputManager.getMainScreenListener().getStartCommandList());
        }
    }

    private void createEuMainScreenStartForOnlineWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createEuMainScreenStartForOnlineWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new NavCommand("Reset SpellerStack"){

            public void execute() {
                AddressInputMainScreenWorkFlowManagerEU.this.spellerStack.reset();
                this.getCommandList().commandFinished();
            }
        });
        SpellerContext spellerContext = this.getSpellerContext(48);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(this.inputManager.getMainScreenListener().getStartCommandListForOnline());
    }

    private void createEuMainScreenCountryWorkFlow(CommandList commandList, boolean bl) {
        SpellerContext spellerContext;
        this.logChannel.log(10000000, "%1#createEuMainScreenCountryWorkFlow - startedWithDirectWriting=%2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl));
        if (this.inputManager.getActiveSpellerContextId() == 75) {
            this.logChannel.log(10000000, "%1#CTX - CTX_DI_EU_COUNTRY_SCREEN_FOR_REMOTE_HMI", (Object)this.CLASS_NAME);
            spellerContext = this.getSpellerContext(104);
        } else {
            spellerContext = this.getSpellerContext(20);
        }
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getCountryScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getCountryScreenListener().getStartCommandList());
        }
    }

    private void createEuMainScreenCityZipWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(10000000, "%1#createEuMainScreenCityZipWorkFlow - startedWithDirectWriting=%2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl));
        SpellerContext spellerContext = this.inputManager.getActiveSpellerContextId() == 48 ? this.getSpellerContext(49) : (this.inputManager.getActiveSpellerContextId() == 75 ? this.getSpellerContext(77) : this.getSpellerContext(21));
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getCityZipScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getCityZipScreenListener().getStartCommandList());
        }
    }

    private void createEuMainScreenStreetWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(10000000, "%1#createEuMainScreenStreetWorkFlow - startedWithDirectWriting=%2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl));
        SpellerContext spellerContext = this.getSpellerContext(22);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getStreetScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getStreetScreenListener().getStartCommandList());
        }
    }

    private void createEuMainScreenHousenumberWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(10000000, "%1#createEuMainScreenHousenumberWorkFlow - startedWithDirectWriting=%2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl));
        SpellerContext spellerContext = this.getSpellerContext(23);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (AddressInputUtil.useHousenumberFreetextSpeller(this.env)) {
            if (bl) {
                String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
                commandList.add(this.inputManager.getHousenumberFreetextScreenListener().getStartCommandList(string));
            } else {
                commandList.add(this.inputManager.getHousenumberFreetextScreenListener().getStartCommandList());
            }
        } else if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getHousenumberMatchSpellerScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getHousenumberMatchSpellerScreenListener().getStartCommandList());
        }
    }

    private void createEuMainScreenJunctionWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(10000000, "%1#createEuMainScreenJunctionWorkFlow - startedWithDirectWriting=%2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl));
        SpellerContext spellerContext = this.getSpellerContext(24);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getJunctionScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getJunctionScreenListener().getStartCommandList());
        }
    }

    private void createEuMainScreenStartGuidanceWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createEuMainScreenStartGuidanceWorkFlow", (Object)this.CLASS_NAME);
    }
}

