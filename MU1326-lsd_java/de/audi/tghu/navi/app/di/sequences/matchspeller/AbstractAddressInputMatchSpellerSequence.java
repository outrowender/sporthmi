/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToPOIOnlineSearchSequence;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToRemoteHmiFromCurrentLDSequence;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPAddCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPDeleteAllCharactersCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPUndoCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelInputChangedCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.SpellerStateChangedCommand;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.UnrequestItemsCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.commands.FilterHandwritingCharactersCommand;
import de.audi.tghu.navi.app.di.commands.LISPAddStrokeCommand;
import de.audi.tghu.navi.app.di.commands.LISPRequestNVCValidCharsCommand;
import de.audi.tghu.navi.app.di.commands.LISetNvcRangeCommand;
import de.audi.tghu.navi.app.di.commands.SetSpellerStrokeStatusCommand;
import de.audi.tghu.navi.app.di.commands.SetSpellerValidHanziCharsCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence$1;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence$2;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence$3;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence$4;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence$5;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence$6;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence$7;
import de.audi.tghu.navi.app.di.sequences.matchspeller.IAddressInputAsiaSpecificSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.IAddressInputMatchSpellerSequence;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class AbstractAddressInputMatchSpellerSequence
implements IAddressInputMatchSpellerSequence,
IAddressInputAsiaSpecificSequence {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final IAddressInputManager inputManager;
    protected final ICommandListFactory commandListFactory;
    protected final NavigationEnv env;
    protected final IMatchspellerModelAccess modelAccess;
    protected final IPreviewMap previewMap;
    protected final LogChannel logChannel;
    protected final SpellerStack spellerStack;
    protected Monitor addCharMonitor;

    public AbstractAddressInputMatchSpellerSequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager) {
        this.commandListFactory = iCommandListFactory;
        this.env = navigationEnv;
        this.modelAccess = iMatchspellerModelAccess;
        this.previewMap = iPreviewMap;
        this.spellerStack = spellerStack;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.inputManager = iAddressInputManager;
    }

    @Override
    public CommandList getStartCommandList(String string) {
        this.logChannel.log(-2137614336, "%1#getStartCommandList(), and latestChar is: %2 ", (Object)this.CLASS_NAME, (Object)string);
        CommandList commandList = this.getStartCommandList();
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new AbstractAddressInputMatchSpellerSequence$1(this, "Check if direct writing char is valid"));
        return commandList;
    }

    @Override
    public void requestNextResultListWindow(int n, int n2) {
        if (this.addCharMonitor != null && this.addCharMonitor.isActive()) {
            this.logChannel.log(-2137614336, "%1#requestNextResultListWindow - addCharIsActive discarding request=%2 with anchorindex=%3!", (Object)this.CLASS_NAME, (long)n2, (long)n);
        } else {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess, n2, n));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestNextResultListWindows").toString());
        }
    }

    @Override
    public void requestPreviousResultListWindow(int n) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPRequestValueListByListIndexCommand(n, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("requestPreviousResultListWindow").toString());
    }

    @Override
    public void addCharacter(String string) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addCharacter").toString());
    }

    @Override
    public void addStroke(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPAddStrokeCommand(string));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addStroke").toString());
    }

    @Override
    public void touchPadInputModeChanged(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPDeleteAllCharactersCommand(true));
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (n == 1) {
            commandList.add(new LISetNvcRangeCommand(2));
        } else if (n == 0) {
            commandList.add(new LISetNvcRangeCommand(1));
        } else {
            this.logChannel.log(10000, "%1#inputModeTPChanged - invalid id for mode=%2", (Object)this.CLASS_NAME, (long)n);
        }
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#inputModeTPChanged").toString());
    }

    @Override
    public void nonAlphaNumTPCharsChanged(int n, int n2, String string, MatchspellerModelApp matchspellerModelApp) {
        this.logChannel.log(-2137614336, "%1#nonAlphaNumTPCharsChanged - modelId=%2, recognizedChars=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new FilterHandwritingCharactersCommand(matchspellerModelApp, string));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#nonAlphaNumTPCharsChanged").toString());
    }

    @Override
    public void requestValidHanziCharsWindow(int n, int n2, int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPRequestNVCValidCharsCommand(3, n2, n3));
        commandList.add(new SetSpellerValidHanziCharsCommand(this.env.getMatchSpellerModel(n)));
        commandList.add(new SetSpellerStrokeStatusCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestValidHanziCharsWindow").toString());
    }

    @Override
    public void addCharacter(String string, int n, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (bl) {
            AbstractAddressInputMatchSpellerSequence$2 abstractAddressInputMatchSpellerSequence$2 = new AbstractAddressInputMatchSpellerSequence$2(this);
            commandList.add(new LIGetStateCommand(this.spellerStack, new IAdditionalStateInfo[]{abstractAddressInputMatchSpellerSequence$2}, new SpellerContext(51)));
        }
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (bl) {
            int n2 = this.spellerStack.getActiveSC().getContextID();
            commandList.add(new AbstractAddressInputMatchSpellerSequence$3(this, new StringBuffer().append(this.CLASS_NAME).append("#addCharacter - if single result select it immediately").toString(), n, n2));
        }
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addCharacter").toString());
    }

    public void sendLocationToOnline(NavigationEnv navigationEnv, int n, int n2, int n3, CommandList commandList) {
        if (commandList != null) {
            if (n3 == Util.getVariantSpecificOnlineContext()) {
                commandList.add(new ReturnNavLocationToPOIOnlineSearchSequence(this.commandListFactory).getStartCommandList());
            } else if (n3 == Util.getVariantSpecificRHMIContext()) {
                commandList.add(new ReturnNavLocationToRemoteHmiFromCurrentLDSequence(this.commandListFactory).getStartCommandList());
            }
            commandList.add(new AbstractAddressInputMatchSpellerSequence$4(this, "Delay fire model event", n, n2));
        } else {
            navigationEnv.fireModelEvent(n, n2);
        }
    }

    @Override
    public void undoCharacter() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPUndoCharacterCommand());
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#undoCharacter").toString());
    }

    @Override
    public void undoStroke() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPUndoCharacterCommand());
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#undoStroke").toString());
    }

    @Override
    public void deleteAllCharacters() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPDeleteAllCharactersCommand());
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#deleteAllCharacters").toString());
    }

    @Override
    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new UnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#unrequestItems").toString());
    }

    @Override
    public void showLocationInPreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        if (iPreviewMap != null && lIValueListElement != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
            commandList.add(new AbstractAddressInputMatchSpellerSequence$5(this, "set Previewmap Location from selected Position", iPreviewMap));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#showLocationInPreviewMap").toString());
        }
    }

    public void showCurrentLDInPreviewMap(IPreviewMap iPreviewMap) {
        if (iPreviewMap != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new AbstractAddressInputMatchSpellerSequence$6(this, "set Previewmap Location from currentLD", iPreviewMap));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#showCurrentLDInPreviewMap").toString());
        }
    }

    @Override
    public void hidePreviewMap(IPreviewMap iPreviewMap) {
        if (iPreviewMap != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new HidePreviewMapCommand(iPreviewMap));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#hidePreviewMap").toString());
        }
    }

    public void showPreviewMapAroundCCP(IPreviewMap iPreviewMap) {
        if (iPreviewMap != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new AbstractAddressInputMatchSpellerSequence$7(this, "show Previewmap around CCP", iPreviewMap));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#showPreviewMapAroundCCP").toString());
        }
    }

    public void spellerStateChanged(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new SpellerStateChangedCommand(n, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#spellerStateChanged").toString());
    }
}

