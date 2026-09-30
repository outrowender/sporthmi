/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.disambiguation;

import de.audi.app.navi.evo.addressinput.AddressInputFormModelAccessHelperEU;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorEvo;
import de.audi.app.navi.evo.addressinput.housenumber.HousenumberInputMatchSpellerListener;
import de.audi.app.navi.evo.addressinput.housenumber.HousenumberMatchspellerInputModelAccess;
import de.audi.app.navi.evo.search.DemoModeSearchGuiHandler;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHousenumberMatchSpellerSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.IAddressInputAsiaSpecificSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressDisambiguatorHMIListener {
    protected static final int NO_DISAMBIG_CHOICE_DEST = 0;
    private static final String LOGCLASS = "AddressDisambiguatorHMIListener";
    private AddressDisambiguatorEvo addressDisambiguator;
    private final NavigationEnv env;
    private final HomeAddressHandler homeAddressHandler;
    private final ADBInterAppService adbInterAppService;
    private final LogChannel lc;
    private boolean spellerStateRestored = false;

    public AddressDisambiguatorHMIListener(AddressDisambiguatorEvo addressDisambiguatorEvo, NavigationEnv navigationEnv, HomeAddressHandler homeAddressHandler, ADBInterAppService aDBInterAppService, IAddressInputForm iAddressInputForm, IPreviewMap iPreviewMap) {
        Object object;
        this.addressDisambiguator = addressDisambiguatorEvo;
        this.env = navigationEnv;
        this.homeAddressHandler = homeAddressHandler;
        this.adbInterAppService = aDBInterAppService;
        this.lc = navigationEnv.getSearchLogChannel();
        this.addressDisambiguator.matchSpeller.clear();
        AddressInputFormModelAccessHelperEU addressInputFormModelAccessHelperEU = new AddressInputFormModelAccessHelperEU(navigationEnv);
        HousenumberMatchspellerInputModelAccess housenumberMatchspellerInputModelAccess = new HousenumberMatchspellerInputModelAccess(navigationEnv, addressDisambiguatorEvo.matchSpeller.getID(), addressDisambiguatorEvo.tiledList.getID(), addressInputFormModelAccessHelperEU);
        if (Util.isHURegionAsia()) {
            object = new DisambMatchSpellerListenerAsia(new HousenumberMatchspellerInputSequence(housenumberMatchspellerInputModelAccess, SpellerStack.getInstance(), addressDisambiguatorEvo.commandListFactory, iPreviewMap, iAddressInputForm), new AddressInputHousenumberMatchSpellerSequence(addressDisambiguatorEvo.commandListFactory, navigationEnv, housenumberMatchspellerInputModelAccess, iPreviewMap, SpellerStack.getInstance(), null), navigationEnv, addressDisambiguatorEvo.matchSpeller.getID(), addressDisambiguatorEvo.tiledList.getID(), addressDisambiguatorEvo.menuModel.getID(), iPreviewMap);
            addressDisambiguatorEvo.matchSpeller.setSpellerListenerAsia((MatchspellerListenerAsia)object);
        } else {
            object = new DisambMatchSpellerListener(new HousenumberMatchspellerInputSequence(housenumberMatchspellerInputModelAccess, SpellerStack.getInstance(), addressDisambiguatorEvo.commandListFactory, iPreviewMap, iAddressInputForm), navigationEnv, addressDisambiguatorEvo.matchSpeller.getID(), addressDisambiguatorEvo.tiledList.getID(), addressDisambiguatorEvo.menuModel.getID(), iPreviewMap);
            addressDisambiguatorEvo.matchSpeller.setSpellerListener((SpellerListener)object);
        }
        object = new DisambPopUpButtonListener();
        navigationEnv.getButtonModel(401608).setButtonListener((ButtonListener)object);
        navigationEnv.getButtonModel(401609).setButtonListener((ButtonListener)object);
        navigationEnv.getButtonModel(401590).setButtonListener((ButtonListener)object);
        navigationEnv.getButtonModel(401591).setButtonListener((ButtonListener)object);
    }

    private void restoreSpellerState() {
        if (!this.spellerStateRestored) {
            CommandList commandList = this.addressDisambiguator.commandListFactory.createCommandList();
            commandList.add(new LIRestoreStateCommand(this.addressDisambiguator.getSpellerState()));
            commandList.execute("AddressDisambiguatorHMIListener#restoreSpellerStateCommandList");
            this.spellerStateRestored = true;
        }
    }

    private void executeUserAction(NavLocation navLocation, ICommandList iCommandList) {
        int n = this.env.getChoiceModel(401246).getValue();
        if (n == 1) {
            iCommandList.commandFinishedWithPostSequence(this.saveDestinationInContact(navLocation));
        } else if (n == 2) {
            this.saveHomeAddress(navLocation);
        } else if (n == 9) {
            iCommandList.commandFinishedWithPostCommand(DemoModeSearchGuiHandler.getSetPositionCommand(navLocation, this.addressDisambiguator.logger));
        } else {
            iCommandList.commandFinishedWithPostSequence(this.getStartRouteGudianceCL(navLocation));
        }
    }

    private CommandList saveDestinationInContact(NavLocation navLocation) {
        if (this.addressDisambiguator.logger.isDebug2()) {
            this.addressDisambiguator.logger.log(100000000, "%1#saveDestinationInContact - Store Address to ADB", (Object)LOGCLASS);
        }
        CommandList commandList = this.addressDisambiguator.commandListFactory.createCommandList();
        commandList.add(new LocationToStreamCommand(navLocation));
        commandList.add(new NavCommand("SaveLocationInAdbCommand"){

            public void execute() {
                NaviADBService.LocationInputHandler locationInputHandler = AddressDisambiguatorHMIListener.this.adbInterAppService.getCurrentLocationInputHandler();
                if (locationInputHandler != null) {
                    locationInputHandler.updateLocation((byte[])this.getCommandList().get("LOCATION_STREAM"));
                    AddressDisambiguatorHMIListener.this.adbInterAppService.removeHandler();
                } else {
                    ((AddressDisambiguatorHMIListener)AddressDisambiguatorHMIListener.this).addressDisambiguator.logger.log(100000, "%1#saveDestinationInContact() - LocationInputhandler is null", (Object)AddressDisambiguatorHMIListener.LOGCLASS);
                }
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    private void saveHomeAddress(NavLocation navLocation) {
        this.addressDisambiguator.logger.log(10000000, "AddressDisambiguatorHMIListener#saveHomeAddress: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.homeAddressHandler.onCreateEditHomeAddress(navLocation);
    }

    private CommandList getStartRouteGudianceCL(final NavLocation navLocation) {
        CommandList commandList = this.addressDisambiguator.commandListFactory.createCommandList();
        commandList.add(new NavCommand("AddressDisambiguatorHMIListener#DisambBaseListListener#itemSelected start RG"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostSequence(this.navigation.getStartGuidanceDependantSequence().getStartSequence(navLocation));
                this.env.getChoiceModel(401470).setValue(0);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    private class DisambPopUpButtonListener
    extends DefaultButtonListener {
        private DisambPopUpButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            AddressDisambiguatorHMIListener.this.lc.log(10000000, "AddressDisambiguatorHMIListener#keyPressed modelID=%1", (long)n);
            if (n != 401590) {
                if (n == 401591 || n == 401608) {
                    final NavLocation navLocation = AddressDisambiguatorHMIListener.this.addressDisambiguator.getTryMatchLocationResultData();
                    CommandList commandList = ((AddressDisambiguatorHMIListener)AddressDisambiguatorHMIListener.this).addressDisambiguator.commandListFactory.createCommandList();
                    commandList.add(new NavCommand("DisambPopUpButtonListener#keyPressed IgnoreHNRCommand"){

                        public void execute() {
                            AddressDisambiguatorHMIListener.this.executeUserAction(navLocation, this.getCommandList());
                            this.finishCommandIfNecessary();
                        }

                        private void finishCommandIfNecessary() {
                            if (this.getCommandList().getActiveCommand() == this) {
                                this.getCommandList().commandFinished();
                            }
                        }
                    });
                    commandList.execute("DisambPopUpButtonListener#keyPressed IgnoreHNRCommandList");
                } else if (n == 401609) {
                    final NavLocation navLocation = AddressDisambiguatorHMIListener.this.env.getContainer().getSelectedLocation();
                    CommandList commandList = ((AddressDisambiguatorHMIListener)AddressDisambiguatorHMIListener.this).addressDisambiguator.commandListFactory.createCommandList();
                    commandList.add(new NavCommand("DisambPopUpButtonListener#keyPressed NavigateToNearestHNRCommand"){

                        public void execute() {
                            AddressDisambiguatorHMIListener.this.executeUserAction(navLocation, this.getCommandList());
                            this.finishCommandIfNecessary();
                        }

                        private void finishCommandIfNecessary() {
                            if (this.getCommandList().getActiveCommand() == this) {
                                this.getCommandList().commandFinished();
                            }
                        }
                    });
                    commandList.execute("DisambPopUpButtonListener#keyPressed NavigateToNearestHNRCommandList");
                } else {
                    AddressDisambiguatorHMIListener.this.lc.log(100000, "AddressDisambiguatorHMIListener#keyPressed modelID=%1 not found in listener", (long)n);
                }
            }
            AddressDisambiguatorHMIListener.this.env.getButtonModel(n).fireEvent(n3);
        }
    }

    protected class DisambMatchSpellerListener
    extends HousenumberInputMatchSpellerListener {
        protected DisambMatchSpellerListener(HousenumberMatchspellerInputSequence housenumberMatchspellerInputSequence, NavigationEnv navigationEnv, int n, int n2, int n3, IPreviewMap iPreviewMap) {
            super(housenumberMatchspellerInputSequence, navigationEnv, n, n2, n3, iPreviewMap);
        }

        public void textChanged(int n, String string, char c2, int n2) {
            AddressDisambiguatorHMIListener.this.restoreSpellerState();
            super.textChanged(n, string, c2, n2);
        }

        public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            AddressDisambiguatorHMIListener.this.restoreSpellerState();
            super.itemFocused(evoListRow, n, n2, n3, n4);
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            ((AddressDisambiguatorHMIListener)AddressDisambiguatorHMIListener.this).addressDisambiguator.logger.log(1000000, "AddressDisambiguatorHMIListener#DisambListListener#itemSelected modelID=%1, index=%2, col=%3", (long)n, (long)n2, (long)n3);
            AddressDisambiguatorHMIListener.this.restoreSpellerState();
            if (!(evoListRow instanceof LiValueListRow)) {
                throw new IllegalArgumentException("AddressDisambiguatorHMIListener not a LiValueListRow object");
            }
            TiledListModelApp tiledListModelApp = ((AddressDisambiguatorHMIListener)AddressDisambiguatorHMIListener.this).addressDisambiguator.tiledList;
            int n5 = ((AddressDisambiguatorHMIListener)AddressDisambiguatorHMIListener.this).addressDisambiguator.terminal;
            ((AddressDisambiguatorHMIListener)AddressDisambiguatorHMIListener.this).addressDisambiguator.extractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                    AddressDisambiguatorHMIListener.this.executeUserAction(navLocation, iCommandList);
                }
            });
            tiledListModelApp.fireEvent(n5);
        }
    }

    protected class DisambMatchSpellerListenerAsia
    extends DisambMatchSpellerListener
    implements MatchspellerListenerAsia {
        private final IAddressInputAsiaSpecificSequence asiaSpecificSequence;

        protected DisambMatchSpellerListenerAsia(HousenumberMatchspellerInputSequence housenumberMatchspellerInputSequence, IAddressInputAsiaSpecificSequence iAddressInputAsiaSpecificSequence, NavigationEnv navigationEnv, int n, int n2, int n3, IPreviewMap iPreviewMap) {
            super(housenumberMatchspellerInputSequence, navigationEnv, n, n2, n3, iPreviewMap);
            this.asiaSpecificSequence = iAddressInputAsiaSpecificSequence;
        }

        public void nonAlphaNumTPCharsChanged(int n, int n2, String string) {
            this.logChannel.log(10000000, "DisambMatchSpellerListenerAsia#nonAlphaNumTPCharsChanged - modelId=%1, recognizedChars=%2", (Object)Integer.toString(n), (Object)string);
            AddressDisambiguatorHMIListener.this.restoreSpellerState();
            this.asiaSpecificSequence.nonAlphaNumTPCharsChanged(n, n2, string, this.env.getMatchSpellerModel(n));
        }

        public void inputModeTPChanged(int n, int n2, int n3) {
            this.logChannel.log(10000000, "DisambMatchSpellerListenerAsia#inputModeTPChanged - modelId=%1, mode=%2", (long)n, (long)n2);
            AddressDisambiguatorHMIListener.this.restoreSpellerState();
            this.asiaSpecificSequence.touchPadInputModeChanged(n2);
        }

        public void strokesChanged(int n, int n2, String string, char c2) {
        }

        public void requestValidHanziCharsWindow(int n, int n2, int n3, int n4) {
        }
    }
}

