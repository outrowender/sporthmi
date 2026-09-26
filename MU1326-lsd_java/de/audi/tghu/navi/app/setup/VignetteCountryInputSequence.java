/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISPAddCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPDeleteAllCharactersCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPUndoCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.UnrequestItemsCommand;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.audi.tghu.navi.app.setup.VignetteCountryInputSequence$1;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class VignetteCountryInputSequence
implements IMatchspellerInputSequence {
    protected final NavigationEnv env;
    protected final IMatchspellerModelAccess modelAccess;
    protected final ICommandListFactory commandListFactory;
    protected LISpellerData initialSpellerState;

    protected VignetteCountryInputSequence(NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.modelAccess = iMatchspellerModelAccess;
        this.commandListFactory = iCommandListFactory;
    }

    protected SpellerContext getSpellerContext(int n) {
        return SpellerContextManager.getSpellerContext(n);
    }

    @Override
    public void requestNextResultListWindow(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute("VignetteCountryInputSequence#requestNextResultListWindows");
    }

    @Override
    public void requestPreviousResultListWindow(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPRequestValueListByListIndexCommand(n, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute("VignetteCountryInputSequence#requestPreviousResultListWindow");
    }

    @Override
    public void addCharacter(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute("VignetteCountryInputSequence#addCharacter");
    }

    @Override
    public void undoCharacter() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPUndoCharacterCommand());
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute("VignetteCountryInputSequence#undoCharacter");
    }

    @Override
    public void deleteAllCharacters() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPDeleteAllCharactersCommand());
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute("VignetteCountryInputSequence#deleteAllCharacters");
    }

    @Override
    public void restore() {
        this.env.getLogChannel().log(-2137614336, "[PoiInput]PoiClassesInputSequence#restoreToPreviousState() ");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIRestoreStateCommand(this.initialSpellerState));
        commandList.execute("VignetteCountryInputSequence#selectListElement");
    }

    @Override
    public CommandList createRestoreCommandList() {
        return null;
    }

    @Override
    public boolean hasActiveSubSequence() {
        return false;
    }

    @Override
    public void start(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (bl) {
            commandList.add(new LiGetStateCommand());
            commandList.add(new VignetteCountryInputSequence$1(this));
        }
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LIStartSpellerCommand(129, true, true, true));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute("VignetteCountryInputSequence#start");
    }

    @Override
    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
    }

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        return null;
    }

    @Override
    public void selectElementByIdentifier(String string) {
    }

    @Override
    public void showLocationInPreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
    }

    @Override
    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new UnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute("VignetteCountryInputSequence#unrequestItems");
    }

    @Override
    public void addCharacter(String string, int n, boolean bl) {
    }
}

