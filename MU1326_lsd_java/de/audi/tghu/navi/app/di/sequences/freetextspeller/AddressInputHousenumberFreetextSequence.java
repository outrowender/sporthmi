/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.housenumber.IHousenumberModelAccess;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.IAddressInputHousenumberFreetextSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputHousenumberFreetextSequence
implements IAddressInputHousenumberFreetextSequence {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected final IAddressInputManager inputManager;
    protected final ICommandListFactory commandListFactory;
    protected final IHousenumberModelAccess modelAccess;
    protected final IPreviewMap previewMap;

    public AddressInputHousenumberFreetextSequence(ICommandListFactory iCommandListFactory, IHousenumberModelAccess iHousenumberModelAccess, IPreviewMap iPreviewMap, IAddressInputManager iAddressInputManager) {
        this.commandListFactory = iCommandListFactory;
        this.modelAccess = iHousenumberModelAccess;
        this.previewMap = iPreviewMap;
        this.inputManager = iAddressInputManager;
    }

    public CommandList getStartCommandList(final String string) {
        CommandList commandList = this.getStartCommandList();
        commandList.add(new NavCommand(this.CLASS_NAME + "#getStartCommandList - update housenumber"){

            public void execute() {
                AddressInputHousenumberFreetextSequence.this.modelAccess.updatePreviewHousenumber(string);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public CommandList getStartCommandListHousenumberFirst(final String string) {
        CommandList commandList = this.getStartCommandListHousenumberFirst();
        commandList.add(new NavCommand(this.CLASS_NAME + "#getStartCommandListHousenumberFirst - update housenumber"){

            public void execute() {
                AddressInputHousenumberFreetextSequence.this.modelAccess.updatePreviewHousenumber(string);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(this.CLASS_NAME + "#getStartCommandList - update model access"){

            public void execute() {
                AddressInputHousenumberFreetextSequence.this.modelAccess.onStart(this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(136, false, false, false));
        return commandList;
    }

    public CommandList getStartCommandListHousenumberFirst(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (bl) {
            commandList.add(new NavCommand(this.CLASS_NAME + "#getStartCommandList - update model access"){

                public void execute() {
                    AddressInputHousenumberFreetextSequence.this.modelAccess.onStart(this.dsiResponseContainer.getLiCurrentLD());
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.add(new LISPCancelSpellerCommand());
        return commandList;
    }

    public CommandList getStartCommandListHousenumberFirst() {
        return this.getStartCommandListHousenumberFirst(true);
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        return null;
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        return null;
    }

    public void selectAlternativeHousenumber() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(this.CLASS_NAME + "#selectAlternativeHousenumber - getFirstElementFromCommandList and call lispSelectListItemCommand"){

            public void execute() {
                LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
                LIValueListElement lIValueListElement = lIValueList.getList()[0];
                CommandList commandList = AddressInputHousenumberFreetextSequence.this.commandListFactory.createCommandList();
                commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
                commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#selectAlternativeHousenumber - call modelAccess onHousenumberValid").toString()){

                    public void execute() {
                        (this).AddressInputHousenumberFreetextSequence.this.modelAccess.onHousenumberValid();
                        (this).AddressInputHousenumberFreetextSequence.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                        this.getCommandList().commandFinished();
                    }
                });
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        }
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        commandList.execute(this.CLASS_NAME + "#selectAlternativeHousenumber");
    }

    protected LIValueListElement getHouseNumber(LIValueListElement[] lIValueListElementArray, boolean bl) {
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            if (bl && !Util.isEmpty(lIValueListElementArray[i2].getData()) && lIValueListElementArray[i2].isHouseNumberInZipCode()) {
                return lIValueListElementArray[i2];
            }
            if (bl || !Util.isEmpty(lIValueListElementArray[i2].getData()) || lIValueListElementArray[i2].isHouseNumberInZipCode()) continue;
            return lIValueListElementArray[i2];
        }
        return new LIValueListElement();
    }

    public CommandList getIgnoreHousenumber() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(){

            public void execute() {
                LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
                LIValueListElement lIValueListElement = lIValueList.getList()[1];
                CommandList commandList = AddressInputHousenumberFreetextSequence.this.commandListFactory.createCommandList();
                commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
                commandList.add(new NavCommand(){

                    public void execute() {
                        (this).AddressInputHousenumberFreetextSequence.this.modelAccess.onHousenumberValid();
                        (this).AddressInputHousenumberFreetextSequence.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                        CommandList commandList = (this).AddressInputHousenumberFreetextSequence.this.commandListFactory.createCommandList();
                        commandList.add(new UpdateAddressInputFormScreenModelsCommand((this).AddressInputHousenumberFreetextSequence.this.modelAccess));
                        commandList.add(new CmdNaviPreviewMapUpdate((this).AddressInputHousenumberFreetextSequence.this.previewMap, 1, null, null));
                        commandList.add(new SetBackupLocationForAddressInputFormCommand((this).AddressInputHousenumberFreetextSequence.this.inputManager));
                        this.getCommandList().commandFinishedWithPostSequence(commandList);
                    }
                });
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    public void ignoreHousenumber() {
        this.getIgnoreHousenumber().execute(this.CLASS_NAME + "#ignoreHousenumber");
    }

    public CommandList getSetHousenumberWithAutoSelect(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIStartSpellerCommand(135, false, false, false));
        commandList.add(new SetInputCommand(string, true));
        commandList.add(new NavCommand(this.CLASS_NAME + "#getSetHousenumberWithAutoSelect - Check if Housenumber is valid"){

            public void execute() {
                if (this.dsiResponseContainer.getLiCurrentLD().isPositionValid()) {
                    AddressInputHousenumberFreetextSequence.this.modelAccess.onHousenumberValid();
                    AddressInputHousenumberFreetextSequence.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                    CommandList commandList = AddressInputHousenumberFreetextSequence.this.commandListFactory.createCommandList();
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(AddressInputHousenumberFreetextSequence.this.modelAccess));
                    commandList.add(new CmdNaviPreviewMapUpdate(AddressInputHousenumberFreetextSequence.this.previewMap, 1, null, null));
                    commandList.add(new SetBackupLocationForAddressInputFormCommand(AddressInputHousenumberFreetextSequence.this.inputManager));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        return commandList;
    }

    public CommandList getSetHousenumber(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new SetInputCommand(string));
        commandList.add(new NavCommand(){

            public void execute() {
                LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
                long l = this.dsiResponseContainer.getLispValueListCount();
                if (this.dsiResponseContainer.isLispIsFullMatch() && l == 1L) {
                    AddressInputHousenumberFreetextSequence.this.modelAccess.onHousenumberValid();
                    LIValueListElement lIValueListElement = lIValueList.getList()[0];
                    CommandList commandList = AddressInputHousenumberFreetextSequence.this.commandListFactory.createCommandList();
                    commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
                    commandList.add(new NavCommand(){

                        public void execute() {
                            (this).AddressInputHousenumberFreetextSequence.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                            this.getCommandList().commandFinished();
                        }
                    });
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(AddressInputHousenumberFreetextSequence.this.modelAccess));
                    commandList.add(new CmdNaviPreviewMapUpdate(AddressInputHousenumberFreetextSequence.this.previewMap, 1, null, null));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else if (!this.dsiResponseContainer.isLispIsFullMatch() && l == 2L) {
                    String string = AddressInputHousenumberFreetextSequence.this.getHouseNumber(lIValueList.getList(), true).getData();
                    AddressInputHousenumberFreetextSequence.this.modelAccess.onHousenumberInvalid(string);
                    this.getCommandList().commandFinished();
                } else if (this.env.getFramework().isPGen2()) {
                    this.getCommandList().commandFinished();
                } else {
                    this.getCommandList().commandAborted("Unexpected result for house number list!");
                }
            }
        });
        return commandList;
    }

    public void setHousenumber(String string, boolean bl) {
        this.getSetHousenumber(string).execute(this.CLASS_NAME + "#setHousenumber");
    }

    public void updatePreviewHousenumber(String string) {
        this.modelAccess.updatePreviewHousenumber(string);
    }

    public CommandList getSetHousenumberByAdditionalCriteria() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIStartSpellerCommand(125, false, false, false));
        commandList.add(new NavCommand(){

            public void execute() {
                LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
                long l = this.dsiResponseContainer.getLispValueListCount();
                if (this.dsiResponseContainer.isLispIsFullMatch() && l == 1L) {
                    AddressInputHousenumberFreetextSequence.this.modelAccess.onHousenumberValid();
                    LIValueListElement lIValueListElement = lIValueList.getList()[0];
                    CommandList commandList = AddressInputHousenumberFreetextSequence.this.commandListFactory.createCommandList();
                    commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
                    commandList.add(new NavCommand(){

                        public void execute() {
                            (this).AddressInputHousenumberFreetextSequence.this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
                            this.getCommandList().commandFinished();
                        }
                    });
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(AddressInputHousenumberFreetextSequence.this.modelAccess));
                    commandList.add(new CmdNaviPreviewMapUpdate(AddressInputHousenumberFreetextSequence.this.previewMap, 1, null, null));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else if (!this.dsiResponseContainer.isLispIsFullMatch() && l == 2L) {
                    String string = AddressInputHousenumberFreetextSequence.this.getHouseNumber(lIValueList.getList(), true).getData();
                    AddressInputHousenumberFreetextSequence.this.modelAccess.onHousenumberInvalid(string);
                    this.getCommandList().commandFinished();
                } else {
                    this.getCommandList().commandAborted("Unexpected result for house number list!");
                }
            }
        });
        return commandList;
    }

    public void hidePreviewMap(IPreviewMap iPreviewMap) {
        if (iPreviewMap != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new HidePreviewMapCommand(iPreviewMap));
            commandList.execute(this.CLASS_NAME + "#hidePreviewMap");
        }
    }
}

