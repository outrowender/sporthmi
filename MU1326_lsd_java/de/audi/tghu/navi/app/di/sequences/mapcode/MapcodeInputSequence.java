/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPDeleteAllCharactersCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.ResetSpellerStackCommand;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguationCallback;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$1;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$10;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$11;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$12;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$13;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$14;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$2;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$3;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$4;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$5;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$6;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$7;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$8;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$9;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.SpellerStack$StackElement;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.util.Util;
import java.util.Stack;
import org.dsi.ifc.global.NavLocation;

public class MapcodeInputSequence {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private static final String PREVIOUS_MAP_CODE_KEY;
    private static final int MAPCODE_MAX_LENGTH;
    private static final int MAPCODE_MAX_LENGTH_WITH_ASTERISK;
    protected final NavigationEnv env;
    private final LogChannel logChannel;
    protected final ICommandListFactory commandListFactory;
    private final IMatchspellerModelAccess modelAccess;
    protected final IPreviewMap previewMap;
    private final SpellerStack spellerStack;
    private final ILocationDisambiguatorSequence disambiguationSequence;
    private static final Stack inputStack;
    private static final String STAR_STRING;

    public MapcodeInputSequence(NavigationEnv navigationEnv, LogChannel logChannel, ICommandListFactory iCommandListFactory, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, ILocationDisambiguatorSequence iLocationDisambiguatorSequence) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.commandListFactory = iCommandListFactory;
        this.modelAccess = iMatchspellerModelAccess;
        this.previewMap = iPreviewMap;
        this.spellerStack = spellerStack;
        this.disambiguationSequence = iLocationDisambiguatorSequence;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new MapcodeInputSequence$1(this, "Reset Input Stack"));
        commandList.add(new MapcodeInputSequence$2(this, "Reset Selected Location"));
        commandList.add(new ResetSpellerStackCommand());
        SpellerContext spellerContext = SpellerContextManager.getSpellerContext(67);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LIStartSpellerCommand(142, true, true, true));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        return commandList;
    }

    public void undoCharacter() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new MapcodeInputSequence$3(this, "Get current input and remove last input"));
        commandList.add(new MapcodeInputSequence$4(this, "Reorganize the input stack"));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        this.updateSelectedLocation(commandList);
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#undoCharacter").toString());
    }

    private void reorganizeInputStackForUndo(Stack stack, String string, String string2) {
        this.logChannel.log(-2137614336, "%1#reorganizeInputStackForUndo previousInput = %2, currentInput = %3", (Object)this.CLASS_NAME, (Object)string, (Object)string2);
        if (stack.isEmpty()) {
            this.logChannel.log(10000, "%1#reorganizeInputStackForUndo -- input stack is empty!", (Object)this.CLASS_NAME);
            return;
        }
        if (string.equals(string2) || string.indexOf(string2) == -1) {
            this.logChannel.log(10000, "%1#reorganizeInputStackForUndo -- undo action is not executed correctly!", (Object)this.CLASS_NAME);
            return;
        }
        String string3 = (String)stack.peek();
        String string4 = string.substring(string2.length(), string.length());
        this.logChannel.log(-2137614336, "%1#reorganizeInputStackForUndo stackTop = %2, defferString = %3", (Object)this.CLASS_NAME, (Object)string3, (Object)string4);
        if (string3.equals(string4)) {
            stack.pop();
        } else if (string3.indexOf(string4) != -1 && string3.endsWith(string4)) {
            String string5 = string3.substring(0, string3.length() - 1);
            stack.pop();
            stack.push(string5);
        } else {
            this.logChannel.log(10000, "%1#reorganizeInputStackForUndo -- unexpected result!", (Object)this.CLASS_NAME);
        }
        this.logChannel.log(-2137614336, "%1#reorganizeInputStackForUndo -- after reorganization input stack = %2", (Object)this.CLASS_NAME, (Object)stack);
    }

    public void deleteAllCharacters() {
        this.getDeleteAllInputCommandList().execute(new StringBuffer().append(this.CLASS_NAME).append("#deleteAllCharacters").toString());
    }

    public void addCharacter(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new MapcodeInputSequence$5(this, "Save current mapcode in command list", string));
        commandList.add(new MapcodeInputSequence$6(this, "Check whether addCharacter execute successfully", string));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        this.updateSelectedLocation(commandList);
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addCharacter").toString());
    }

    public CommandList inputMapCode(String string, NaviServiceListener naviServiceListener) {
        CommandList commandList = this.commandListFactory.createCommandList();
        String string2 = this.getCurrentMapCode();
        String string3 = new StringBuffer().append(string2).append(string).toString();
        if (!this.isSDSInputValid(string3)) {
            commandList.add(new MapcodeInputSequence$7(this, naviServiceListener));
        } else {
            commandList.add(new SetInputCommand(string3));
            commandList.add(new MapcodeInputSequence$8(this, "Check if SetInputCommand is executed correctly based on its result", string2, naviServiceListener, string));
        }
        return commandList;
    }

    private boolean isSDSInputValid(String string) {
        if (Util.isEmpty(string) || string.length() > 13) {
            return false;
        }
        if (string.indexOf(42) == -1 && string.length() > 12) {
            return false;
        }
        int n = string.indexOf("*");
        return n <= -1 || string.length() < ++n || string.indexOf("*", n) <= -1;
    }

    private boolean reorganizeInputStackForAdd(DSIResponseContainer dSIResponseContainer, String string, String string2) {
        String string3 = dSIResponseContainer.getLispCurrentInput();
        if (string3 == null || dSIResponseContainer.getLispCurrentSelectionCriterion() != 142) {
            this.logChannel.log(-1601830656, "%1#reorganizeInputStackForAdd - current input is null or selcrit for mapcode not available.", (Object)this.CLASS_NAME);
            return false;
        }
        String string4 = string3.substring(string.length(), string3.length());
        inputStack.push(string4);
        this.logChannel.log(-2137614336, "%1#reorganizeInputStackForAdd - currentStack=%2", (Object)this.CLASS_NAME, (Object)inputStack);
        return true;
    }

    public CommandList deleteLastMapCodeInput() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (inputStack.size() > 0) {
            String string = (String)inputStack.pop();
            String string2 = this.getCurrentMapCode();
            String string3 = string2.substring(0, string2.length() - string.length());
            this.logChannel.log(-2137614336, "%1#deleteLastMapCodeInput -- Input = %2", (Object)this.CLASS_NAME, (Object)string3);
            commandList.add(new SetInputCommand(string3));
            commandList.add(new MapcodeInputSequence$9(this, "Check if SetInputCommand is executed correctly based on its result"));
        } else {
            this.logChannel.log(-2137614336, "%1#deleteLastMapCodeInput -- No Input!", (Object)this.CLASS_NAME);
        }
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        this.updateSelectedLocation(commandList);
        return commandList;
    }

    public CommandList getDeleteAllInputCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPDeleteAllCharactersCommand());
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.add(new MapcodeInputSequence$10(this, "Reset Input Stack"));
        commandList.add(new MapcodeInputSequence$11(this, "Reset Selected Location"));
        return commandList;
    }

    public void disambiguateMapCode(ILocationDisambiguationCallback iLocationDisambiguationCallback, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand) {
        this.disambiguationSequence.startDisambiguationForMapCodeBySds(iLocationDisambiguationCallback, 0, notifyNaviServiceListenerCommand);
    }

    public void selectDisambiguatedMapCodeByIndex(int n, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand2) {
        this.disambiguationSequence.setLocationAsCurrentLdForSds(n, notifyNaviServiceListenerCommand, notifyNaviServiceListenerCommand2);
    }

    public String getLastValidMapCodeBlock() {
        if (Util.isEmpty(this.getCurrentMapCode())) {
            return "";
        }
        if (inputStack.isEmpty()) {
            this.getCurrentMapCode();
        }
        return (String)inputStack.peek();
    }

    public String getCurrentMapCode() {
        return this.env.getContainer().getLispCurrentInput();
    }

    public void updatePreviewMap() {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.updateSelectedLocation(commandList);
        commandList.add(new MapcodeInputSequence$12(this, new StringBuffer().append(this.CLASS_NAME).append("#UpdatePreviewMap -- focus on destination").toString()));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#UpdatePreviewMap").toString());
    }

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
            commandList.add(new MapcodeInputSequence$13(this, "show Previewmap around CCP", iPreviewMap));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#showPreviewMapAroundCCP").toString());
        }
    }

    protected void updateSelectedLocation(CommandList commandList) {
        commandList.add(new MapcodeInputSequence$14(this, "Based on the LIValueList from south side, update selectedLocation"));
    }

    public boolean isCurrentMapCodeNavigable() {
        NavLocation navLocation = this.env.getContainer().getSelectedLocation();
        return navLocation != null && navLocation.isPositionValid();
    }

    public boolean isFurtherMapCodeInputPossible() {
        boolean bl = !this.env.getContainer().isLispIsFullMatch() || !Util.isEmpty(this.env.getContainer().getLispValidCharacters());
        this.logChannel.log(-2137614336, "%1#isFurtherMapCodeInputPossible - isFurtherInputPossible=%2", (Object)this.CLASS_NAME, (Object)bl);
        return bl;
    }

    public CommandList getMapcodeHkReturnCommandList(NavCommand navCommand, NavCommand navCommand2) {
        this.logChannel.log(-2137614336, "%1#getMapcodeHkReturnCommandList", (Object)this.CLASS_NAME);
        SpellerStack$StackElement spellerStack$StackElement = this.spellerStack.pop();
        CommandList commandList = this.commandListFactory.createCommandList();
        if (spellerStack$StackElement == null) {
            commandList.add(navCommand2);
            return commandList;
        }
        commandList.add(new LIRestoreStateCommand(spellerStack$StackElement));
        commandList.add(navCommand);
        commandList.setErrorCommand(navCommand2);
        return commandList;
    }

    static /* synthetic */ Stack access$000() {
        return inputStack;
    }

    static /* synthetic */ void access$100(MapcodeInputSequence mapcodeInputSequence, Stack stack, String string, String string2) {
        mapcodeInputSequence.reorganizeInputStackForUndo(stack, string, string2);
    }

    static /* synthetic */ boolean access$200(MapcodeInputSequence mapcodeInputSequence, DSIResponseContainer dSIResponseContainer, String string, String string2) {
        return mapcodeInputSequence.reorganizeInputStackForAdd(dSIResponseContainer, string, string2);
    }

    static /* synthetic */ LogChannel access$300(MapcodeInputSequence mapcodeInputSequence) {
        return mapcodeInputSequence.logChannel;
    }

    static /* synthetic */ IMatchspellerModelAccess access$700(MapcodeInputSequence mapcodeInputSequence) {
        return mapcodeInputSequence.modelAccess;
    }

    static {
        inputStack = new Stack();
    }
}

