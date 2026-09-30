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
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
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
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.util.Util;
import java.util.Stack;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class MapcodeInputSequence {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    private static final String PREVIOUS_MAP_CODE_KEY = "PREVIOUS_MAP_CODE";
    private static final int MAPCODE_MAX_LENGTH = 12;
    private static final int MAPCODE_MAX_LENGTH_WITH_ASTERISK = 13;
    protected final NavigationEnv env;
    private final LogChannel logChannel;
    protected final ICommandListFactory commandListFactory;
    private final IMatchspellerModelAccess modelAccess;
    protected final IPreviewMap previewMap;
    private final SpellerStack spellerStack;
    private final ILocationDisambiguatorSequence disambiguationSequence;
    private static final Stack inputStack = new Stack();
    private static final String STAR_STRING = "*";

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
        commandList.add(new NavCommand("Reset Input Stack"){

            public void execute() {
                inputStack.clear();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("Reset Selected Location"){

            public void execute() {
                this.dsiResponseContainer.setSelectedLocation(null);
                this.getCommandList().commandFinished();
            }
        });
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
        commandList.add(new NavCommand("Get current input and remove last input"){

            public void execute() {
                String string = this.dsiResponseContainer.getLispCurrentInput();
                this.getCommandList().put(MapcodeInputSequence.PREVIOUS_MAP_CODE_KEY, string);
                this.getCommandList().commandFinishedWithPostCommand(new SetInputCommand(string.substring(0, string.length() - ((String)inputStack.peek()).length())));
            }
        });
        commandList.add(new NavCommand("Reorganize the input stack"){

            public void execute() {
                MapcodeInputSequence.this.reorganizeInputStackForUndo(inputStack, (String)this.getCommandList().get(MapcodeInputSequence.PREVIOUS_MAP_CODE_KEY), this.dsiResponseContainer.getLispCurrentInput());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        this.updateSelectedLocation(commandList);
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#undoCharacter").toString());
    }

    private void reorganizeInputStackForUndo(Stack stack, String string, String string2) {
        this.logChannel.log(10000000, "%1#reorganizeInputStackForUndo previousInput = %2, currentInput = %3", (Object)this.CLASS_NAME, (Object)string, (Object)string2);
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
        this.logChannel.log(10000000, "%1#reorganizeInputStackForUndo stackTop = %2, defferString = %3", (Object)this.CLASS_NAME, (Object)string3, (Object)string4);
        if (string3.equals(string4)) {
            stack.pop();
        } else if (string3.indexOf(string4) != -1 && string3.endsWith(string4)) {
            String string5 = string3.substring(0, string3.length() - 1);
            stack.pop();
            stack.push(string5);
        } else {
            this.logChannel.log(10000, "%1#reorganizeInputStackForUndo -- unexpected result!", (Object)this.CLASS_NAME);
        }
        this.logChannel.log(10000000, "%1#reorganizeInputStackForUndo -- after reorganization input stack = %2", (Object)this.CLASS_NAME, (Object)stack);
    }

    public void deleteAllCharacters() {
        this.getDeleteAllInputCommandList().execute(new StringBuffer().append(this.CLASS_NAME).append("#deleteAllCharacters").toString());
    }

    public void addCharacter(final String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("Save current mapcode in command list"){

            public void execute() {
                String string2 = this.dsiResponseContainer.getLispCurrentInput();
                this.getCommandList().put(MapcodeInputSequence.PREVIOUS_MAP_CODE_KEY, string2);
                this.getCommandList().commandFinishedWithPostCommand(new SetInputCommand(new StringBuffer().append(string2).append(string).toString()));
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("Check whether addCharacter execute successfully"){

            public void execute() {
                if (MapcodeInputSequence.this.reorganizeInputStackForAdd(this.dsiResponseContainer, (String)this.getCommandList().get(MapcodeInputSequence.PREVIOUS_MAP_CODE_KEY), string)) {
                    MapcodeInputSequence.this.logChannel.log(10000000, "%1#addCharacter -- after reorganization input stack = %2", (Object)this.CLASS_NAME, (Object)inputStack);
                    this.getCommandList().commandFinished();
                } else {
                    this.getCommandList().commandAborted("Unexcepted result");
                }
            }
        });
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        this.updateSelectedLocation(commandList);
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addCharacter").toString());
    }

    public CommandList inputMapCode(final String string, final NaviServiceListener naviServiceListener) {
        CommandList commandList = this.commandListFactory.createCommandList();
        final String string2 = this.getCurrentMapCode();
        String string3 = new StringBuffer().append(string2).append(string).toString();
        if (!this.isSDSInputValid(string3)) {
            commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

                protected void call(NaviServiceListener naviServiceListener) {
                    naviServiceListener.responseMapCodeResult((byte)3);
                }
            });
        } else {
            commandList.add(new SetInputCommand(string3));
            commandList.add(new NavCommand("Check if SetInputCommand is executed correctly based on its result"){

                public void execute() {
                    CommandList commandList = MapcodeInputSequence.this.commandListFactory.createCommandList();
                    if (!this.dsiResponseContainer.isLispIsFullMatch() && Util.isEmpty(this.dsiResponseContainer.getLispValidCharacters())) {
                        commandList.add(new SetInputCommand(string2));
                        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

                            protected void call(NaviServiceListener naviServiceListener) {
                                naviServiceListener.responseMapCodeResult((byte)3);
                            }
                        });
                    } else {
                        commandList.add(new NavCommand("Check whether SetInputCommand execute successfully"){

                            public void execute() {
                                if (MapcodeInputSequence.this.reorganizeInputStackForAdd(this.dsiResponseContainer, string2, string)) {
                                    MapcodeInputSequence.this.logChannel.log(10000000, "%1#inputMapCode -- input stack = %2", (Object)this.CLASS_NAME, (Object)inputStack);
                                    CommandList commandList = (this).MapcodeInputSequence.this.commandListFactory.createCommandList();
                                    commandList.add(new ModelUpdateSpellerAndResultListCommand(MapcodeInputSequence.this.modelAccess));
                                    MapcodeInputSequence.this.updateSelectedLocation(commandList);
                                    commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

                                        protected void call(NaviServiceListener naviServiceListener) {
                                            naviServiceListener.responseMapCodeResult((byte)0);
                                        }
                                    });
                                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                                } else {
                                    this.getCommandList().commandFinishedWithPostCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

                                        protected void call(NaviServiceListener naviServiceListener) {
                                            naviServiceListener.responseMapCodeResult((byte)3);
                                        }
                                    });
                                }
                            }
                        });
                    }
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            });
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
        int n = string.indexOf(STAR_STRING);
        return n <= -1 || string.length() < ++n || string.indexOf(STAR_STRING, n) <= -1;
    }

    private boolean reorganizeInputStackForAdd(DSIResponseContainer dSIResponseContainer, String string, String string2) {
        String string3 = dSIResponseContainer.getLispCurrentInput();
        if (string3 == null || dSIResponseContainer.getLispCurrentSelectionCriterion() != 142) {
            this.logChannel.log(100000, "%1#reorganizeInputStackForAdd - current input is null or selcrit for mapcode not available.", (Object)this.CLASS_NAME);
            return false;
        }
        String string4 = string3.substring(string.length(), string3.length());
        inputStack.push(string4);
        this.logChannel.log(10000000, "%1#reorganizeInputStackForAdd - currentStack=%2", (Object)this.CLASS_NAME, (Object)inputStack);
        return true;
    }

    public CommandList deleteLastMapCodeInput() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (inputStack.size() > 0) {
            String string = (String)inputStack.pop();
            String string2 = this.getCurrentMapCode();
            String string3 = string2.substring(0, string2.length() - string.length());
            this.logChannel.log(10000000, "%1#deleteLastMapCodeInput -- Input = %2", (Object)this.CLASS_NAME, (Object)string3);
            commandList.add(new SetInputCommand(string3));
            commandList.add(new NavCommand("Check if SetInputCommand is executed correctly based on its result"){

                public void execute() {
                    if (!this.dsiResponseContainer.isLispIsFullMatch() && Util.isEmpty(this.dsiResponseContainer.getLispValidCharacters())) {
                        this.getCommandList().commandAborted("Revieved invalid result from south side after SetInputCommand execution.");
                    } else {
                        this.getCommandList().commandFinished();
                    }
                }
            });
        } else {
            this.logChannel.log(10000000, "%1#deleteLastMapCodeInput -- No Input!", (Object)this.CLASS_NAME);
        }
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        this.updateSelectedLocation(commandList);
        return commandList;
    }

    public CommandList getDeleteAllInputCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPDeleteAllCharactersCommand());
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.add(new NavCommand("Reset Input Stack"){

            public void execute() {
                inputStack.clear();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("Reset Selected Location"){

            public void execute() {
                this.dsiResponseContainer.setSelectedLocation(null);
                this.getCommandList().commandFinished();
            }
        });
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
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#UpdatePreviewMap -- focus on destination").toString()){

            public void execute() {
                NavLocation navLocation = this.env.getContainer().getSelectedLocation();
                if (MapcodeInputSequence.this.previewMap != null && navLocation != null && navLocation.isPositionValid()) {
                    MapcodeInputSequence.this.previewMap.setPreviewLocation(navLocation, 1, null, null);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#UpdatePreviewMap").toString());
    }

    public void hidePreviewMap(IPreviewMap iPreviewMap) {
        if (iPreviewMap != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new HidePreviewMapCommand(iPreviewMap));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#hidePreviewMap").toString());
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
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#showPreviewMapAroundCCP").toString());
        }
    }

    protected void updateSelectedLocation(CommandList commandList) {
        commandList.add(new NavCommand("Based on the LIValueList from south side, update selectedLocation"){

            public void execute() {
                LIValueList lIValueList = this.env.getContainer().getLispValueList();
                if (Util.isListValid(lIValueList) && lIValueList.getList().length == 1) {
                    LIValueListElement lIValueListElement = lIValueList.getList()[0];
                    if (lIValueListElement.validDestination && lIValueListElement.latitude != 0 && lIValueListElement.longitude != 0) {
                        this.getCommandList().commandFinishedWithPostCommand(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
                    } else {
                        MapcodeInputSequence.this.logChannel.log(10000000, "LIValueListElement from south side contains invalid Geographic information, setSelectedLocation to null");
                        this.dsiResponseContainer.setSelectedLocation(null);
                        this.getCommandList().commandFinished();
                    }
                } else {
                    MapcodeInputSequence.this.logChannel.log(10000000, "LIValueList from south side is empty or invalid, setSelectedLocation to null");
                    this.dsiResponseContainer.setSelectedLocation(null);
                    this.getCommandList().commandFinished();
                }
            }
        });
    }

    public boolean isCurrentMapCodeNavigable() {
        NavLocation navLocation = this.env.getContainer().getSelectedLocation();
        return navLocation != null && navLocation.isPositionValid();
    }

    public boolean isFurtherMapCodeInputPossible() {
        boolean bl = !this.env.getContainer().isLispIsFullMatch() || !Util.isEmpty(this.env.getContainer().getLispValidCharacters());
        this.logChannel.log(10000000, "%1#isFurtherMapCodeInputPossible - isFurtherInputPossible=%2", (Object)this.CLASS_NAME, (Object)bl);
        return bl;
    }

    public CommandList getMapcodeHkReturnCommandList(NavCommand navCommand, NavCommand navCommand2) {
        this.logChannel.log(10000000, "%1#getMapcodeHkReturnCommandList", (Object)this.CLASS_NAME);
        SpellerStack.StackElement stackElement = this.spellerStack.pop();
        CommandList commandList = this.commandListFactory.createCommandList();
        if (stackElement == null) {
            commandList.add(navCommand2);
            return commandList;
        }
        commandList.add(new LIRestoreStateCommand(stackElement));
        commandList.add(navCommand);
        commandList.setErrorCommand(navCommand2);
        return commandList;
    }
}

