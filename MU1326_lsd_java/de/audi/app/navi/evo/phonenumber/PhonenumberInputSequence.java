/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToAddressbookSequence;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPAddCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPDeleteAllCharactersCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.UnrequestItemsCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.util.Util;
import java.util.Stack;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PhonenumberInputSequence {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    private static final String PREVIOUS_PHONE_NUMBER_KEY = "PREVIOUS_PHONE_NUMBER";
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final ICommandListFactory commandListFactory;
    private final IMatchspellerModelAccess modelAccess;
    private final SpellerStack spellerStack;
    private final IStartGuidanceToDestinationSequence routeGuidanceSequence;
    private static final Stack inputStack = new Stack();

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
        commandList.add(new NavCommand("Reset Input Stack"){

            public void execute() {
                inputStack.clear();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("Reset SpellerStack"){

            public void execute() {
                PhonenumberInputSequence.this.spellerStack.reset();
                this.getCommandList().commandFinished();
            }
        });
        SpellerContext spellerContext = SpellerContextManager.getSpellerContext(68);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LIStartSpellerCommand(8, true, true, true));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        return commandList;
    }

    public void undoCharacter() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("Get current input and remove last input"){

            public void execute() {
                String string = this.dsiResponseContainer.getLispCurrentInput();
                this.getCommandList().put(PhonenumberInputSequence.PREVIOUS_PHONE_NUMBER_KEY, string);
                SetInputCommand setInputCommand = inputStack.isEmpty() ? new SetInputCommand("") : new SetInputCommand(string.substring(0, string.length() - ((String)inputStack.peek()).length()));
                this.getCommandList().commandFinishedWithPostCommand(setInputCommand);
            }
        });
        commandList.add(new NavCommand("Reorgnize the input stack"){

            public void execute() {
                PhonenumberInputSequence.this.reorganizeInputStackForUndo((String)this.getCommandList().get(PhonenumberInputSequence.PREVIOUS_PHONE_NUMBER_KEY), this.dsiResponseContainer.getLispCurrentInput());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#undoCharacter").toString());
    }

    private void reorganizeInputStackForUndo(String string, String string2) {
        this.logChannel.log(10000000, "%1#reorganizeInputStackForUndo previousInput = %2, currentInput = %3", (Object)this.CLASS_NAME, (Object)string, (Object)string2);
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
        this.logChannel.log(10000000, "%1#reorganizeInputStackForUndo stackTop = %2, differString = %3", (Object)this.CLASS_NAME, (Object)string3, (Object)string4);
        if (string3.equals(string4)) {
            inputStack.pop();
        } else {
            String string5 = string3.substring(0, string3.length() - 1);
            inputStack.pop();
            inputStack.push(string5);
        }
        this.logChannel.log(10000000, "%1#reorganizeInputStackForUndo -- after reorganization input stack = %2", (Object)this.CLASS_NAME, (Object)inputStack);
    }

    public void deleteAllCharacters() {
        this.getDeleteAllInputCommandList().execute(new StringBuffer().append(this.CLASS_NAME).append("#deleteAllCharacters").toString());
    }

    public void addCharacter(String string) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        final String string2 = this.getCurrentTelephoneNumber();
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new NavCommand("Check whether addCharacter execute successfully"){

            public void execute() {
                if (PhonenumberInputSequence.this.reorganizeInputStackForAdd(this.dsiResponseContainer, string2)) {
                    PhonenumberInputSequence.this.logChannel.log(10000000, "%1#addCharacter -- after reorganization input stack = %2", (Object)this.CLASS_NAME, (Object)inputStack);
                    this.getCommandList().commandFinished();
                } else {
                    this.getCommandList().commandAborted("Unexcepted result");
                }
            }
        });
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addCharacter").toString());
    }

    public CommandList inputTelephoneNumber(String string, final NaviServiceListener naviServiceListener) {
        CommandList commandList = this.commandListFactory.createCommandList();
        final String string2 = this.getCurrentTelephoneNumber();
        final String string3 = new StringBuffer().append(string2).append(string).toString();
        if (!this.isSDSInputValid(string3)) {
            commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

                protected void call(NaviServiceListener naviServiceListener) {
                    naviServiceListener.responseTelephoneNumberResult((byte)3);
                }
            });
        } else {
            commandList.add(new SetInputCommand(string3));
            commandList.add(new NavCommand("Check if SetInputCommand is executed correctly based on its result"){

                public void execute() {
                    CommandList commandList = PhonenumberInputSequence.this.commandListFactory.createCommandList();
                    String string = this.dsiResponseContainer.getLispCurrentInput();
                    String string22 = string3;
                    if (Util.isEmpty(string22)) {
                        string22 = "";
                    }
                    if (!this.dsiResponseContainer.isLispIsFullMatch() && Util.isEmpty(this.dsiResponseContainer.getLispValidCharacters()) && this.dsiResponseContainer.getLispValueListCount() == 0L || !string.startsWith(string22)) {
                        commandList.add(new SetInputCommand(string2));
                        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

                            protected void call(NaviServiceListener naviServiceListener) {
                                naviServiceListener.responseTelephoneNumberResult((byte)3);
                            }
                        });
                    } else {
                        commandList.add(new NavCommand("Check whether SetInputCommand execute successfully"){

                            public void execute() {
                                if (PhonenumberInputSequence.this.reorganizeInputStackForAdd(this.dsiResponseContainer, string2)) {
                                    PhonenumberInputSequence.this.logChannel.log(10000000, "%1#inputTelephoneNumber -- input stack = %2", (Object)this.CLASS_NAME, (Object)inputStack);
                                    this.getCommandList().commandFinishedWithPostCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

                                        protected void call(NaviServiceListener naviServiceListener) {
                                            naviServiceListener.responseTelephoneNumberResult((byte)0);
                                        }
                                    });
                                } else {
                                    this.getCommandList().commandFinishedWithPostCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

                                        protected void call(NaviServiceListener naviServiceListener) {
                                            naviServiceListener.responseTelephoneNumberResult((byte)3);
                                        }
                                    });
                                }
                            }
                        });
                    }
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            });
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        }
        return commandList;
    }

    private boolean isSDSInputValid(String string) {
        return !Util.isEmpty(string) && string.length() <= 10;
    }

    public CommandList deleteLastTelephoneNumberInput() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("Check stack, calculate items to remove and set the input"){

            public void execute() {
                CommandList commandList = PhonenumberInputSequence.this.commandListFactory.createCommandList();
                if (!inputStack.isEmpty()) {
                    final String string = (String)inputStack.pop();
                    final String string2 = PhonenumberInputSequence.this.getCurrentTelephoneNumber();
                    String string3 = string2.substring(0, string2.length() - string.length());
                    this.logger.log(10000000, "%1#deleteLastTelephoneNumberInput -- Input = %2", (Object)this.CLASS_NAME, (Object)string3);
                    commandList.add(new SetInputCommand(string3));
                    commandList.add(new NavCommand("Check if SetInputCommand is executed correctly based on its result"){

                        public void execute() {
                            PhonenumberInputSequence.this.reorganizeInputStackForUndo(string, string2);
                            this.getCommandList().commandFinished();
                        }
                    });
                } else {
                    commandList.add(new SetInputCommand(""));
                }
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
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

    public void showLocationInPreviewMap(final IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        if (iPreviewMap != null && lIValueListElement != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
            commandList.add(new NavCommand("set Previewmap Location from selected Position"){

                public void execute() {
                    NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
                    iPreviewMap.setPreviewPOIsOnboardDistant(new NavLocation[]{navLocation}, 1, null, null);
                    this.getCommandList().commandFinished();
                }
            });
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

    public void executeElementSelected(LIValueListElement lIValueListElement, final HomeAddressHandler homeAddressHandler) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (lIValueListElement.validDestination && lIValueListElement.latitude != 0 && lIValueListElement.longitude != 0) {
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
            commandList.add(new NavCommand(){

                public void execute() {
                    NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
                    if (navLocation != null && navLocation.isPositionValid()) {
                        if (this.env.getInputModeManager().getInputMode() == 2) {
                            this.logger.log(10000000, "Selected location is valid, Saving location as home address.");
                            homeAddressHandler.onCreateEditHomeAddress(navLocation);
                            this.getCommandList().commandFinished();
                        } else if (this.env.getInputModeManager().getInputMode() == 1) {
                            this.logger.log(10000000, "Selected location is valid, saving location to contact.");
                            ReturnNavLocationToAddressbookSequence returnNavLocationToAddressbookSequence = new ReturnNavLocationToAddressbookSequence(PhonenumberInputSequence.this.commandListFactory);
                            this.getCommandList().commandFinishedWithPostSequence(returnNavLocationToAddressbookSequence.getStartCommandListWithLocation(navLocation));
                        } else {
                            this.logger.log(10000000, "Selected location is valid, Route Guidance is starting");
                            PhonenumberInputSequence.this.routeGuidanceSequence.start(navLocation);
                            this.getCommandList().commandFinished();
                        }
                    } else {
                        this.getCommandList().commandAborted("Selected location is invalid.");
                    }
                }
            });
        }
        commandList.add(new NavCommand("Pop SpellerStack"){

            public void execute() {
                this.logger.log(10000000, "%1#spellerStack.pop()", (Object)this.CLASS_NAME);
                PhonenumberInputSequence.this.spellerStack.pop();
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#excuteElementSelected").toString());
    }

    public CommandList getElementSelectedCommandList(final int n) {
        this.logChannel.log(10000000, "%1#getElementSelectedCommandList - index=%2", (Object)this.CLASS_NAME, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("Get Location based on the index provided by SDS and start the followup sequence"){

            public void execute() {
                CommandList commandList = PhonenumberInputSequence.this.commandListFactory.createCommandList();
                LIValueList lIValueList = this.env.getContainer().getLispValueList();
                LIValueListElement lIValueListElement = null;
                try {
                    lIValueListElement = lIValueList.getList()[n];
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    this.getCommandList().commandAborted("Invalid index provided for selecting the location!");
                }
                if (lIValueListElement != null && lIValueListElement.validDestination && lIValueListElement.latitude != 0 && lIValueListElement.longitude != 0) {
                    commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
                    SpellerContext spellerContext = SpellerContextManager.getSpellerContext(120);
                    commandList.add(new LIGetStateCommand(PhonenumberInputSequence.this.spellerStack, spellerContext));
                    commandList.add(new NavCommand("Get selected destination, check it and if valid set as currentLd"){

                        public void execute() {
                            NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
                            if (navLocation != null && navLocation.isPositionValid()) {
                                this.logger.log(10000000, "NavLocation is valid, show Detail screen");
                                this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(navLocation));
                            } else {
                                this.getCommandList().commandFinished();
                            }
                        }
                    });
                }
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
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
        this.logChannel.log(10000000, "%1#isFurtherTelephonenumberInputPossible - isFurtherInputPossible=%2", (Object)this.CLASS_NAME, (Object)bl);
        return bl;
    }
}

