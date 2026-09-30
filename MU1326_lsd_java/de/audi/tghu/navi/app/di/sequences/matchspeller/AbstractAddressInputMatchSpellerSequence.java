/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
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
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.UnrequestItemsCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.commands.FilterHandwritingCharactersCommand;
import de.audi.tghu.navi.app.di.commands.LISPAddStrokeCommand;
import de.audi.tghu.navi.app.di.commands.LISPRequestNVCValidCharsCommand;
import de.audi.tghu.navi.app.di.commands.LISetNvcRangeCommand;
import de.audi.tghu.navi.app.di.commands.SetSpellerStrokeStatusCommand;
import de.audi.tghu.navi.app.di.commands.SetSpellerValidHanziCharsCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.IAddressInputAsiaSpecificSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.IAddressInputMatchSpellerSequence;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class AbstractAddressInputMatchSpellerSequence
implements IAddressInputMatchSpellerSequence,
IAddressInputAsiaSpecificSequence {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
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

    public CommandList getStartCommandList(String string) {
        this.logChannel.log(10000000, "%1#getStartCommandList(), and latestChar is: %2 ", (Object)this.CLASS_NAME, (Object)string);
        CommandList commandList = this.getStartCommandList();
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new NavCommand("Check if direct writing char is valid"){

            public void execute() {
                if (this.dsiResponseContainer.getLispValueListCount() > 0L) {
                    this.getCommandList().commandFinishedWithPostCommand(new ModelUpdateSpellerAndResultListCommand(AbstractAddressInputMatchSpellerSequence.this.modelAccess));
                    return;
                }
                AbstractAddressInputMatchSpellerSequence.this.undoCharacter();
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public void requestNextResultListWindow(int n, int n2) {
        if (this.addCharMonitor != null && this.addCharMonitor.isActive()) {
            this.logChannel.log(10000000, "%1#requestNextResultListWindow - addCharIsActive discarding request=%2 with anchorindex=%3!", (Object)this.CLASS_NAME, (long)n2, (long)n);
        } else {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess, n2, n));
            commandList.execute(this.CLASS_NAME + "#requestNextResultListWindows");
        }
    }

    public void requestPreviousResultListWindow(int n) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPRequestValueListByListIndexCommand(n, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(this.CLASS_NAME + "requestPreviousResultListWindow");
    }

    public void addCharacter(String string) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#addCharacter");
    }

    public void addStroke(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPAddStrokeCommand(string));
        commandList.execute(this.CLASS_NAME + "#addStroke");
    }

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
        commandList.execute(this.CLASS_NAME + "#inputModeTPChanged");
    }

    public void nonAlphaNumTPCharsChanged(int n, int n2, String string, MatchspellerModelApp matchspellerModelApp) {
        this.logChannel.log(10000000, "%1#nonAlphaNumTPCharsChanged - modelId=%2, recognizedChars=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new FilterHandwritingCharactersCommand(matchspellerModelApp, string));
        commandList.execute(this.CLASS_NAME + "#nonAlphaNumTPCharsChanged");
    }

    public void requestValidHanziCharsWindow(int n, int n2, int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPRequestNVCValidCharsCommand(3, n2, n3));
        commandList.add(new SetSpellerValidHanziCharsCommand(this.env.getMatchSpellerModel(n)));
        commandList.add(new SetSpellerStrokeStatusCommand(this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#requestValidHanziCharsWindow");
    }

    public void addCharacter(String string, final int n, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (bl) {
            IAdditionalStateInfo iAdditionalStateInfo = new IAdditionalStateInfo(){

                public void gatherInfo() {
                }

                public void restoreBefore() {
                }

                public void restoreAfter() {
                    DSIResponseContainer dSIResponseContainer = AbstractAddressInputMatchSpellerSequence.this.env.getContainer();
                    String string = dSIResponseContainer.getLispValidCharacters();
                    String string2 = dSIResponseContainer.getLispCurrentInput();
                    boolean bl = dSIResponseContainer.isLispIsFullMatch();
                    boolean bl2 = dSIResponseContainer.isLispIsUndoAvailable();
                    LIValueList lIValueList = dSIResponseContainer.getLispValueList();
                    long l = dSIResponseContainer.getLispValueListCount();
                    AbstractAddressInputMatchSpellerSequence.this.modelAccess.onStart(dSIResponseContainer.getLiCurrentLD());
                    int n = 0;
                    if (lIValueList.getList() != null && lIValueList.getList().length > 0) {
                        n = lIValueList.getList()[0].listIndex;
                    }
                    AbstractAddressInputMatchSpellerSequence.this.modelAccess.onUpdateResultList(lIValueList, l, string2, bl, -1, n);
                    AbstractAddressInputMatchSpellerSequence.this.modelAccess.onUpdateSpeller(string, string2, bl, bl2);
                }
            };
            commandList.add(new LIGetStateCommand(this.spellerStack, new IAdditionalStateInfo[]{iAdditionalStateInfo}, new SpellerContext(51)));
        }
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (bl) {
            final int n2 = this.spellerStack.getActiveSC().getContextID();
            commandList.add(new NavCommand(this.CLASS_NAME + "#addCharacter - if single result select it immediately"){

                public void execute() {
                    if (this.dsiResponseContainer.getLispValueListCount() == 1L) {
                        AbstractAddressInputMatchSpellerSequence.this.logChannel.log(10000000, "%1#setSpellerStatusWaiting for model=%2", (Object)this.CLASS_NAME, (long)n);
                        SpellerModelApp spellerModelApp = this.env.getSpellerModel(n);
                        spellerModelApp.setControlButtonStates(0, 0);
                        LIValueListElement lIValueListElement = this.dsiResponseContainer.getLispValueList().getList()[0];
                        CommandList commandList = AbstractAddressInputMatchSpellerSequence.this.getSelectListElementCommandList(lIValueListElement);
                        AbstractAddressInputMatchSpellerSequence.this.sendLocationToOnline(this.env, n, 0, n2, commandList);
                        this.getCommandList().commandFinishedWithPostSequence(commandList);
                        return;
                    }
                    AbstractAddressInputMatchSpellerSequence.this.spellerStack.pop();
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.execute(this.CLASS_NAME + "#addCharacter");
    }

    public void sendLocationToOnline(NavigationEnv navigationEnv, final int n, final int n2, int n3, CommandList commandList) {
        if (commandList != null) {
            if (n3 == Util.getVariantSpecificOnlineContext()) {
                commandList.add(new ReturnNavLocationToPOIOnlineSearchSequence(this.commandListFactory).getStartCommandList());
            } else if (n3 == Util.getVariantSpecificRHMIContext()) {
                commandList.add(new ReturnNavLocationToRemoteHmiFromCurrentLDSequence(this.commandListFactory).getStartCommandList());
            }
            commandList.add(new NavCommand("Delay fire model event"){

                public void execute() {
                    this.env.fireModelEvent(n, n2);
                    this.getCommandList().commandFinished();
                }
            });
        } else {
            navigationEnv.fireModelEvent(n, n2);
        }
    }

    public void undoCharacter() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPUndoCharacterCommand());
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#undoCharacter");
    }

    public void undoStroke() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPUndoCharacterCommand());
        commandList.execute(this.CLASS_NAME + "#undoStroke");
    }

    public void deleteAllCharacters() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPDeleteAllCharactersCommand());
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#deleteAllCharacters");
    }

    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new UnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#unrequestItems");
    }

    public void showLocationInPreviewMap(final IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
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

    public void showCurrentLDInPreviewMap(final IPreviewMap iPreviewMap) {
        if (iPreviewMap != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new NavCommand("set Previewmap Location from currentLD"){

                public void execute() {
                    NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
                    iPreviewMap.setPreviewLocation(navLocation, 1, null, null);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute(this.CLASS_NAME + "#showCurrentLDInPreviewMap");
        }
    }

    public void hidePreviewMap(IPreviewMap iPreviewMap) {
        if (iPreviewMap != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new HidePreviewMapCommand(iPreviewMap));
            commandList.execute(this.CLASS_NAME + "#hidePreviewMap");
        }
    }

    public void showPreviewMapAroundCCP(final IPreviewMap iPreviewMap) {
        if (iPreviewMap != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new NavCommand("show Previewmap around CCP"){

                public void execute() {
                    iPreviewMap.setPreviewAreaAroundCCP(1);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute(this.CLASS_NAME + "#showPreviewMapAroundCCP");
        }
    }

    public void spellerStateChanged(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new SpellerStateChangedCommand(n, this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#spellerStateChanged");
    }
}

