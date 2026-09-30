/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISPAddCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPDeleteAllCharactersCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPUndoCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelInputChangedCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.LIValueListWindowSizeCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.UnrequestItemsCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class AbstractMatchspellerInputSequence
implements IMatchspellerInputSequence {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    private static final int WINDOWSIZE_DEFAULT = -1;
    private static final int WINDOWSIZE_FAST = 5;
    protected final IMatchspellerModelAccess modelAccess;
    protected final SpellerStack spellerStack;
    protected final ICommandListFactory commandListFactory;
    protected IMatchspellerInputSequence childSequence;
    protected final IPreviewMap previewMap;

    protected AbstractMatchspellerInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, IPreviewMap iPreviewMap) {
        this.modelAccess = iMatchspellerModelAccess;
        this.spellerStack = spellerStack;
        this.commandListFactory = iCommandListFactory;
        this.previewMap = iPreviewMap;
    }

    protected SpellerContext getSpellerContext(int n) {
        return SpellerContextManager.getSpellerContext(n);
    }

    public void start(boolean bl) {
        CommandList commandList = this.createStartCommandList(bl);
        commandList.execute(this.CLASS_NAME + "#start");
    }

    public void start(char c2, boolean bl) {
        CommandList commandList = this.createStartCommandList(c2, bl);
        commandList.execute(this.CLASS_NAME + "#addCharacter");
    }

    public void requestNextResultListWindow(int n, int n2) {
        if (this.hasActiveSubSequence()) {
            this.childSequence.requestNextResultListWindow(n, n2);
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess, n2, n));
        commandList.execute(this.CLASS_NAME + "#requestNextResultListWindows");
    }

    public void requestPreviousResultListWindow(int n) {
        if (this.hasActiveSubSequence()) {
            this.childSequence.requestPreviousResultListWindow(n);
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPRequestValueListByListIndexCommand(n, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#requestPreviousResultListWindow");
    }

    public void addCharacter(String string) {
        if (this.hasActiveSubSequence()) {
            this.childSequence.addCharacter(string);
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#addCharacter");
    }

    public void addCharacter(String string, final int n, boolean bl) {
        if (this.hasActiveSubSequence()) {
            this.childSequence.addCharacter(string, n, bl);
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (bl) {
            commandList.add(new NavCommand(this.CLASS_NAME + "#addCharacter - if single result select it immediately"){

                public void execute() {
                    if (this.dsiResponseContainer.getLispValueListCount() == 1L) {
                        CommandList commandList = AbstractMatchspellerInputSequence.this.getSelectListElementCommandList(this.dsiResponseContainer.getLispValueList().getList()[0], true);
                        this.getCommandList().commandFinishedWithPostSequence(commandList);
                        this.env.fireModelEvent(n, 0);
                        return;
                    }
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.execute(this.CLASS_NAME + "#addCharacter");
    }

    public void undoCharacter() {
        if (this.hasActiveSubSequence()) {
            this.childSequence.undoCharacter();
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPUndoCharacterCommand());
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#undoCharacter");
    }

    public void deleteAllCharacters() {
        if (this.hasActiveSubSequence()) {
            this.childSequence.deleteAllCharacters();
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPDeleteAllCharactersCommand());
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#deleteAllCharacters");
    }

    public void restore() {
        if (this.childSequence != null) {
            this.childSequence.restore();
            this.childSequence = null;
            return;
        }
        SpellerStack.StackElement stackElement = this.spellerStack.pop();
        if (stackElement != null) {
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
            commandList.execute(this.CLASS_NAME + "#restore");
        }
    }

    public CommandList createRestoreCommandList() {
        if (this.childSequence != null) {
            CommandList commandList = this.childSequence.createRestoreCommandList();
            this.childSequence = null;
            return commandList;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public boolean hasActiveSubSequence() {
        return this.childSequence != null;
    }

    public void showLocationInPreviewMap(final IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        if (this.hasActiveSubSequence()) {
            this.childSequence.showLocationInPreviewMap(iPreviewMap, lIValueListElement);
            return;
        }
        if (iPreviewMap != null && lIValueListElement != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
            commandList.add(new NavCommand("set Previewmap Location from selected Position"){

                public void execute() {
                    NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
                    iPreviewMap.setPreviewLocation(navLocation, 1, null, null);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute(this.CLASS_NAME + "#showLocationInPreviewMap");
        }
    }

    public void unrequestItems(int n, int n2) {
        if (this.hasActiveSubSequence()) {
            this.childSequence.unrequestItems(n, n2);
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new UnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#unrequestItems");
    }

    protected abstract CommandList createStartCommandList(boolean var1);

    protected CommandList createStartCommandList(char c2, boolean bl) {
        CommandList commandList = this.createStartCommandList(bl);
        commandList.add(new LIValueListWindowSizeCommand(5));
        commandList.add(new LISPAddCharacterCommand(Character.toString(c2)));
        commandList.add(new NavCommand("Check if direct writing char is valid"){

            public void execute() {
                CommandList commandList = AbstractMatchspellerInputSequence.this.commandListFactory.createCommandList();
                if (this.dsiResponseContainer.getLispValueListCount() > 0L) {
                    commandList.add(new ModelUpdateSpellerAndResultListCommand(AbstractMatchspellerInputSequence.this.modelAccess));
                } else {
                    AbstractMatchspellerInputSequence.this.undoCharacter();
                }
                commandList.add(new LIValueListWindowSizeCommand(-1));
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    protected void addGetStateCommand(CommandList commandList, boolean bl, LIValueListElement lIValueListElement) {
        if (bl) {
            commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, this));
        }
    }
}

