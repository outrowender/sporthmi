/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AbstractAddressInputScreenWorkFlowManagerNAR;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputMainScreenWorkFlowManagerNAR$1;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputMainScreenWorkFlowManagerNAR$2;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputMainScreenWorkFlowManagerNAR$3;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputMainScreenWorkFlowManagerNAR$4;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputMainScreenWorkFlowManagerNAR$5;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.global.NavLocation;

public class AddressInputMainScreenWorkFlowManagerNAR
extends AbstractAddressInputScreenWorkFlowManagerNAR {
    public AddressInputMainScreenWorkFlowManagerNAR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 30007: {
                this.createNarMainScreenStartWorkFlow(commandList);
                break;
            }
            case 30016: {
                this.createNarMainScreenWithoutStripStartWorkFlow(commandList);
                break;
            }
            case 30014: {
                this.createNarMainScreenStartForOnlineWorkFlow(commandList);
                break;
            }
            case 30017: {
                this.createNarMainScreenStartForRemoteHmiWorkFlow(commandList);
                break;
            }
            case 30008: {
                this.createNarMainScreenStartGuidanceWorkFlow(commandList);
                break;
            }
            case 30002: {
                this.createNarMainScreenCountryWorkFlow(commandList, false);
                break;
            }
            case 30009: {
                this.createNarMainScreenCountryWorkFlow(commandList, true);
                break;
            }
            case 30003: {
                this.createNarMainScreenCityZipWorkFlow(commandList, false);
                break;
            }
            case 30010: {
                this.createNarMainScreenCityZipWorkFlow(commandList, true);
                break;
            }
            case 30004: {
                this.createNarMainScreenStreetWorkFlow(commandList, false);
                break;
            }
            case 30018: {
                this.createNarMainScreenAddStreetWorkFlow(commandList, false);
                break;
            }
            case 30011: {
                this.createNarMainScreenStreetWorkFlow(commandList, true);
                break;
            }
            case 30005: {
                this.createNarMainScreenHousenumberWorkFlow(commandList, false, true);
                break;
            }
            case 30019: {
                this.createNarMainScreenHousenumberWorkFlow(commandList, false, false);
                break;
            }
            case 30012: {
                this.createNarMainScreenHousenumberWorkFlow(commandList, true, true);
                break;
            }
            case 30006: {
                this.createNarMainScreenIntersectionWorkFlow(commandList, false);
                break;
            }
            case 30013: {
                this.createNarMainScreenIntersectionWorkFlow(commandList, true);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createNarMainScreenStartWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createNarMainScreenStartWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputMainScreenWorkFlowManagerNAR$1(this, "Reset SpellerStack"));
        SpellerContext spellerContext = this.getSpellerContext(57);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        Object object = commandList.get("startMainScreenNavLocation");
        if (object != null && object instanceof NavLocation) {
            commandList.add(new LIStripLocationCommand((NavLocation)object, 17));
            commandList.add(this.createStartMainScreenWithNavLocationFromStripedLocationCommand());
        } else {
            commandList.add(new LIStripLocationCommand(this.inputManager.getInitialLocation(), 17));
            commandList.add(this.createStartMainScreenWithNavLocationFromStripedLocationCommand());
        }
    }

    private void createNarMainScreenWithoutStripStartWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createNarMainScreenWithoutStripStartWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputMainScreenWorkFlowManagerNAR$2(this, "Reset SpellerStack"));
        SpellerContext spellerContext = this.getSpellerContext(57);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        Object object = commandList.get("startMainScreenNavLocation");
        if (object != null && object instanceof NavLocation) {
            commandList.add(this.inputManager.getMainScreenListener().getStartCommandList((NavLocation)object));
        } else {
            commandList.add(this.inputManager.getMainScreenListener().getStartCommandList());
        }
    }

    private NavCommand createStartMainScreenWithNavLocationFromStripedLocationCommand() {
        return new AddressInputMainScreenWorkFlowManagerNAR$3(this, new StringBuffer().append(this.CLASS_NAME).append("createStartMainScreenWithNavLocationFromStripedLocationCommand").toString());
    }

    private void createNarMainScreenStartForOnlineWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createNarMainScreenStartForOnlineWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputMainScreenWorkFlowManagerNAR$4(this, "Reset SpellerStack"));
        SpellerContext spellerContext = this.getSpellerContext(76);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(this.inputManager.getMainScreenListener().getStartCommandListForOnline());
    }

    private void createNarMainScreenStartForRemoteHmiWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createNarMainScreenStartForRemoteHmiWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputMainScreenWorkFlowManagerNAR$5(this, "Reset SpellerStack"));
        SpellerContext spellerContext = this.getSpellerContext(102);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(this.inputManager.getMainScreenListener().getStartCommandList());
    }

    private void createNarMainScreenCountryWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createNarMainScreenCountryWorkFlow - startedWithDirectWriting=%2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl));
        SpellerContext spellerContext = this.getSpellerContext(58);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getCountryScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getCountryScreenListener().getStartCommandList());
        }
    }

    private void createNarMainScreenCityZipWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createNarMainScreenCityZipWorkFlow - startedWithDirectWriting=%2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl));
        SpellerContext spellerContext = this.inputManager.getActiveSpellerContextId() == 76 ? this.getSpellerContext(60) : (this.inputManager.getActiveSpellerContextId() == 102 ? this.getSpellerContext(103) : this.getSpellerContext(63));
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getCityZipScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getCityZipScreenListener().getStartCommandList());
        }
    }

    private void createNarMainScreenAddStreetWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createNarMainScreenAddStreetWorkFlow - startedWithDirectWriting=%2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl));
        SpellerContext spellerContext = this.getSpellerContext(64);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getStreetScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getStreetScreenListener().getStartCommandList());
        }
    }

    private void createNarMainScreenStreetWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createNarMainScreenStreetWorkFlow - startedWithDirectWriting=%2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl));
        SpellerContext spellerContext = this.getSpellerContext(65);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getStreetScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getStreetScreenListener().getStartCommandList());
        }
    }

    private void createNarMainScreenHousenumberWorkFlow(CommandList commandList, boolean bl, boolean bl2) {
        this.logChannel.log(-2137614336, "%1#createNarMainScreenHousenumberWorkFlow - startedWithDirectWriting=%2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl));
        SpellerContext spellerContext = bl2 ? this.getSpellerContext(74) : this.getSpellerContext(70);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            if (bl2) {
                commandList.add(this.inputManager.getHousenumberScreenListener().getStartCommandListHousenumberFirst(string));
            } else {
                commandList.add(this.inputManager.getHousenumberScreenListener().getStartCommandList(string));
            }
        } else if (bl2) {
            commandList.add(this.inputManager.getHousenumberScreenListener().getStartCommandListHousenumberFirst());
        } else {
            commandList.add(this.inputManager.getHousenumberScreenListener().getStartCommandList());
        }
    }

    private void createNarMainScreenIntersectionWorkFlow(CommandList commandList, boolean bl) {
        this.logChannel.log(-2137614336, "%1#createNarMainScreenJunctionWorkFlow - startedWithDirectWriting=%2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl));
        SpellerContext spellerContext = this.getSpellerContext(71);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        if (bl) {
            String string = AddressInputUtil.getLatestCharFromCommandList(commandList, this.env);
            commandList.add(this.inputManager.getIntersectionScreenListener().getStartCommandList(string));
        } else {
            commandList.add(this.inputManager.getIntersectionScreenListener().getStartCommandList());
        }
    }

    private void createNarMainScreenStartGuidanceWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createNarMainScreenStartGuidanceWorkFlow", (Object)this.CLASS_NAME);
    }
}

