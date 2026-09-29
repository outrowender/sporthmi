/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$1;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$10;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$11;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$12;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$13;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$14;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$2;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$3;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$4;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$5;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$6;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$7;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$8;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$9;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPAddCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPDeleteAllCharactersCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.UnrequestItemsCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.Util;
import java.util.Stack;
import org.dsi.ifc.navigation.LIValueListElement;

public class PhonenumberInputSequence {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private static final String PREVIOUS_PHONE_NUMBER_KEY;
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final ICommandListFactory commandListFactory;
    private final IMatchspellerModelAccess modelAccess;
    private final SpellerStack spellerStack;
    private final IStartGuidanceToDestinationSequence routeGuidanceSequence;
    private static final Stack inputStack;

    public PhonenumberInputSequence(NavigationEnv navigationEnv, LogChannel logChannel, ICommandListFactory iCommandListFactory, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.commandListFactory = iCommandListFactory;
        this.modelAccess = iMatchspellerModelAccess;
        this.spellerStack = spellerStack;
        this.routeGuidanceSequence = iStartGuidanceToDestinationSequence;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PhonenumberInputSequence$1(this, "Reset Input Stack"));
        commandList.add(new PhonenumberInputSequence$2(this, "Reset SpellerStack"));
        SpellerContext spellerContext = SpellerContextManager.getSpellerContext(68);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LIStartSpellerCommand(8, true, true, true));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        return commandList;
    }

    public void undoCharacter() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PhonenumberInputSequence$3(this, "Get current input and remove last input"));
        commandList.add(new PhonenumberInputSequence$4(this, "Reorgnize the input stack"));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#undoCharacter").toString());
    }

    private void reorganizeInputStackForUndo(String string, String string2) {
        this.logChannel.log(-2137614336, "%1#reorganizeInputStackForUndo previousInput = %2, currentInput = %3", (Object)this.CLASS_NAME, (Object)string, (Object)string2);
        if (inputStack.isEmpty()) {
            this.logChannel.log(10000, "%1#reorganizeInputStackForUndo -- input stack is empty!", (Object)this.CLASS_NAME);
            return;
        }
        if (string.equals(string2) || string.indexOf(string2) == -1) {
            this.logChannel.log(10000, "%1#reorganizeInputStackForUndo -- undo action is not executed correctly!", (Object)this.CLASS_NAME);
            return;
        }
        String string3 = (String)inputStack.peek();
        String string4 = string.substring(string2.length(), string.length());
        this.logChannel.log(-2137614336, "%1#reorganizeInputStackForUndo stackTop = %2, differString = %3", (Object)this.CLASS_NAME, (Object)string3, (Object)string4);
        if (string3.equals(string4)) {
            inputStack.pop();
        } else {
            String string5 = string3.substring(0, string3.length() - 1);
            inputStack.pop();
            inputStack.push(string5);
        }
        this.logChannel.log(-2137614336, "%1#reorganizeInputStackForUndo -- after reorganization input stack = %2", (Object)this.CLASS_NAME, (Object)inputStack);
    }

    public void deleteAllCharacters() {
        this.getDeleteAllInputCommandList().execute(new StringBuffer().append(this.CLASS_NAME).append("#deleteAllCharacters").toString());
    }

    public void addCharacter(String string) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        String string2 = this.getCurrentTelephoneNumber();
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new PhonenumberInputSequence$5(this, "Check whether addCharacter execute successfully", string2));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addCharacter").toString());
    }

    public CommandList inputTelephoneNumber(String string, NaviServiceListener naviServiceListener) {
        CommandList commandList = this.commandListFactory.createCommandList();
        String string2 = this.getCurrentTelephoneNumber();
        String string3 = new StringBuffer().append(string2).append(string).toString();
        if (!this.isSDSInputValid(string3)) {
            commandList.add(new PhonenumberInputSequence$6(this, naviServiceListener));
        } else {
            commandList.add(new SetInputCommand(string3));
            commandList.add(new PhonenumberInputSequence$7(this, "Check if SetInputCommand is executed correctly based on its result", string3, string2, naviServiceListener));
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        }
        return commandList;
    }

    private boolean isSDSInputValid(String string) {
        return !Util.isEmpty(string) && string.length() <= 10;
    }

    public CommandList deleteLastTelephoneNumberInput() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PhonenumberInputSequence$8(this, "Check stack, calculate items to remove and set the input"));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        return commandList;
    }

    public CommandList getDeleteAllInputCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPDeleteAllCharactersCommand());
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.add(new PhonenumberInputSequence$9(this, "Reset Input Stack"));
        return commandList;
    }

    public String getLastValidTelephoneNumberBlock() {
        if (Util.isEmpty(this.getCurrentTelephoneNumber())) {
            return "";
        }
        if (inputStack.isEmpty()) {
            return this.getCurrentTelephoneNumber();
        }
        return (String)inputStack.peek();
    }

    public String getCurrentTelephoneNumber() {
        return this.env.getContainer().getLispCurrentInput();
    }

    private boolean reorganizeInputStackForAdd(DSIResponseContainer dSIResponseContainer, String string) {
        String string2 = dSIResponseContainer.getLispCurrentInput();
        if (string2 == null || dSIResponseContainer.getLispCurrentSelectionCriterion() != 8) {
            return false;
        }
        String string3 = string2.substring(string.length(), string2.length());
        if (Util.isEmpty(string3)) {
            return false;
        }
        inputStack.push(string3);
        return true;
    }

    public void showLocationInPreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        if (iPreviewMap != null && lIValueListElement != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
            commandList.add(new PhonenumberInputSequence$10(this, "set Previewmap Location from selected Position", iPreviewMap));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#showLocationInPreviewMap").toString());
        }
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
            commandList.add(new PhonenumberInputSequence$11(this, "show Previewmap around CCP", iPreviewMap));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#showPreviewMapAroundCCP").toString());
        }
    }

    public void executeElementSelected(LIValueListElement lIValueListElement, HomeAddressHandler homeAddressHandler) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (lIValueListElement.validDestination && lIValueListElement.latitude != 0 && lIValueListElement.longitude != 0) {
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
            commandList.add(new PhonenumberInputSequence$12(this, homeAddressHandler));
        }
        commandList.add(new PhonenumberInputSequence$13(this, "Pop SpellerStack"));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#excuteElementSelected").toString());
    }

    public CommandList getElementSelectedCommandList(int n) {
        this.logChannel.log(-2137614336, "%1#getElementSelectedCommandList - index=%2", (Object)this.CLASS_NAME, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PhonenumberInputSequence$14(this, "Get Location based on the index provided by SDS and start the followup sequence", n));
        return commandList;
    }

    public void requestNextResultListWindow(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess, n2, n));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestNextResultListWindows").toString());
    }

    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new UnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#unrequestItems").toString());
    }

    public boolean isFurtherTelephonenumberInputPossible() {
        boolean bl = !this.env.getContainer().isLispIsFullMatch() && !Util.isEmpty(this.env.getContainer().getLispValidCharacters());
        this.logChannel.log(-2137614336, "%1#isFurtherTelephonenumberInputPossible - isFurtherInputPossible=%2", (Object)this.CLASS_NAME, (Object)bl);
        return bl;
    }

    static /* synthetic */ Stack access$000() {
        return inputStack;
    }

    static /* synthetic */ SpellerStack access$100(PhonenumberInputSequence phonenumberInputSequence) {
        return phonenumberInputSequence.spellerStack;
    }

    static /* synthetic */ void access$200(PhonenumberInputSequence phonenumberInputSequence, String string, String string2) {
        phonenumberInputSequence.reorganizeInputStackForUndo(string, string2);
    }

    static /* synthetic */ boolean access$300(PhonenumberInputSequence phonenumberInputSequence, DSIResponseContainer dSIResponseContainer, String string) {
        return phonenumberInputSequence.reorganizeInputStackForAdd(dSIResponseContainer, string);
    }

    static /* synthetic */ LogChannel access$400(PhonenumberInputSequence phonenumberInputSequence) {
        return phonenumberInputSequence.logChannel;
    }

    static /* synthetic */ ICommandListFactory access$500(PhonenumberInputSequence phonenumberInputSequence) {
        return phonenumberInputSequence.commandListFactory;
    }

    static /* synthetic */ IStartGuidanceToDestinationSequence access$1000(PhonenumberInputSequence phonenumberInputSequence) {
        return phonenumberInputSequence.routeGuidanceSequence;
    }

    static {
        inputStack = new Stack();
    }
}

