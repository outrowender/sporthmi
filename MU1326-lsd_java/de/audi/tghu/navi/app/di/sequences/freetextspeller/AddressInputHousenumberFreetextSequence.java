/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.housenumber.IHousenumberModelAccess;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$1;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$2;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$3;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$4;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$5;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$6;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$7;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$8;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$9;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.IAddressInputHousenumberFreetextSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputHousenumberFreetextSequence
implements IAddressInputHousenumberFreetextSequence {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
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

    @Override
    public CommandList getStartCommandList(String string) {
        CommandList commandList = this.getStartCommandList();
        commandList.add(new AddressInputHousenumberFreetextSequence$1(this, new StringBuffer().append(this.CLASS_NAME).append("#getStartCommandList - update housenumber").toString(), string));
        return commandList;
    }

    public CommandList getStartCommandListHousenumberFirst(String string) {
        CommandList commandList = this.getStartCommandListHousenumberFirst();
        commandList.add(new AddressInputHousenumberFreetextSequence$2(this, new StringBuffer().append(this.CLASS_NAME).append("#getStartCommandListHousenumberFirst - update housenumber").toString(), string));
        return commandList;
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new AddressInputHousenumberFreetextSequence$3(this, new StringBuffer().append(this.CLASS_NAME).append("#getStartCommandList - update model access").toString()));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(136, false, false, false));
        return commandList;
    }

    public CommandList getStartCommandListHousenumberFirst(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (bl) {
            commandList.add(new AddressInputHousenumberFreetextSequence$4(this, new StringBuffer().append(this.CLASS_NAME).append("#getStartCommandList - update model access").toString()));
        }
        commandList.add(new LISPCancelSpellerCommand());
        return commandList;
    }

    public CommandList getStartCommandListHousenumberFirst() {
        return this.getStartCommandListHousenumberFirst(true);
    }

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        return null;
    }

    @Override
    public CommandList getSelectElementByIdentifierCommandList(String string) {
        return null;
    }

    @Override
    public void selectAlternativeHousenumber() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new AddressInputHousenumberFreetextSequence$5(this, new StringBuffer().append(this.CLASS_NAME).append("#selectAlternativeHousenumber - getFirstElementFromCommandList and call lispSelectListItemCommand").toString()));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        }
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#selectAlternativeHousenumber").toString());
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
        commandList.add(new AddressInputHousenumberFreetextSequence$6(this));
        return commandList;
    }

    @Override
    public void ignoreHousenumber() {
        this.getIgnoreHousenumber().execute(new StringBuffer().append(this.CLASS_NAME).append("#ignoreHousenumber").toString());
    }

    public CommandList getSetHousenumberWithAutoSelect(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIStartSpellerCommand(135, false, false, false));
        commandList.add(new SetInputCommand(string, true));
        commandList.add(new AddressInputHousenumberFreetextSequence$7(this, new StringBuffer().append(this.CLASS_NAME).append("#getSetHousenumberWithAutoSelect - Check if Housenumber is valid").toString()));
        return commandList;
    }

    public CommandList getSetHousenumber(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new SetInputCommand(string));
        commandList.add(new AddressInputHousenumberFreetextSequence$8(this));
        return commandList;
    }

    @Override
    public void setHousenumber(String string, boolean bl) {
        this.getSetHousenumber(string).execute(new StringBuffer().append(this.CLASS_NAME).append("#setHousenumber").toString());
    }

    @Override
    public void updatePreviewHousenumber(String string) {
        this.modelAccess.updatePreviewHousenumber(string);
    }

    public CommandList getSetHousenumberByAdditionalCriteria() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIStartSpellerCommand(125, false, false, false));
        commandList.add(new AddressInputHousenumberFreetextSequence$9(this));
        return commandList;
    }

    public void hidePreviewMap(IPreviewMap iPreviewMap) {
        if (iPreviewMap != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new HidePreviewMapCommand(iPreviewMap));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#hidePreviewMap").toString());
        }
    }
}

