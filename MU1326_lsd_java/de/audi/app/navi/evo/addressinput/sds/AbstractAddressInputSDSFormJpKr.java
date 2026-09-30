/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.details.GuiModelAccessDetailsEvo;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.sds.AbstractAddressInputSDSFormEvo;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.app.navi.evo.phonenumber.PhonenumberMatchSpellerModelAccess;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import org.dsi.ifc.global.NavLocation;

public abstract class AbstractAddressInputSDSFormJpKr
extends AbstractAddressInputSDSFormEvo {
    protected final PhonenumberInputSequence phoneNumberInputSequence;
    protected final IStartGuidanceToDestinationSequence startGuidanceSequence;
    protected final IDetailsScreen detailsScreen;

    public AbstractAddressInputSDSFormJpKr(IAddressInputForm iAddressInputForm, LogChannel logChannel, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, GuiModelAccessDetailsEvo guiModelAccessDetailsEvo, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IDetailsScreen iDetailsScreen) {
        super(iAddressInputForm, logChannel, iCommandListFactory, spellerStack, cityHistory, navigationEnv, iPreviewMap, guiModelAccessDetailsEvo, iAddressInputFormModelAccessHelper);
        PhonenumberMatchSpellerModelAccess phonenumberMatchSpellerModelAccess = new PhonenumberMatchSpellerModelAccess(navigationEnv, logChannel, PoiScreensEvo.getDiAsiaTelephoneNumberScreenMatchSpellerModel(), PoiScreensEvo.getDiAsiaTelephoneNumberScreenTiledListModel());
        this.phoneNumberInputSequence = new PhonenumberInputSequence(navigationEnv, logChannel, iCommandListFactory, phonenumberMatchSpellerModelAccess, iPreviewMap, spellerStack, iStartGuidanceToDestinationSequence);
        this.startGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.detailsScreen = iDetailsScreen;
    }

    public void enterTelephoneNumber(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#enterTelephoneNumber()", (Object)this.CLASS_NAME);
        CommandList commandList = this.phoneNumberInputSequence.getStartCommandList();
        this.setPhoneNumberNotifySDSCommand(naviServiceListener, commandList);
        this.setPhoneNumberErrorCommand(naviServiceListener, commandList);
        commandList.execute(this.CLASS_NAME + "#enterTelephoneNumber");
    }

    public void inputTelephoneNumber(String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#inputTelephoneNumber( %2 )", (Object)this.CLASS_NAME, (Object)string);
        CommandList commandList = this.phoneNumberInputSequence.inputTelephoneNumber(string, naviServiceListener);
        this.setPhoneNumberErrorCommand(naviServiceListener, commandList);
        commandList.execute(this.CLASS_NAME + "#inputTelephoneNumber");
    }

    private void setPhoneNumberNotifySDSCommand(NaviServiceListener naviServiceListener, CommandList commandList) {
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseTelephoneNumberResult((byte)0);
            }
        });
    }

    private void setPhoneNumberErrorCommand(NaviServiceListener naviServiceListener, CommandList commandList) {
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseTelephoneNumberResult((byte)1);
            }
        });
    }

    public void deleteLastTelephoneNumberInput(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#deleteLastTelephoneNumberInput()", (Object)this.CLASS_NAME);
        CommandList commandList = this.phoneNumberInputSequence.deleteLastTelephoneNumberInput();
        this.setPhoneNumberNotifySDSCommand(naviServiceListener, commandList);
        this.setPhoneNumberErrorCommand(naviServiceListener, commandList);
        commandList.execute(this.CLASS_NAME + "#deleteLastTelephoneNumberInput");
    }

    public void clearTelephoneNumber(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#clearTelephoneNumber()", (Object)this.CLASS_NAME);
        CommandList commandList = this.phoneNumberInputSequence.getDeleteAllInputCommandList();
        this.setPhoneNumberNotifySDSCommand(naviServiceListener, commandList);
        this.setPhoneNumberErrorCommand(naviServiceListener, commandList);
        commandList.execute(this.CLASS_NAME + "#clearTelephoneNumber");
    }

    public void selectTelephoneNumberByIndex(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#selectTelephoneNumberByIndex( %2 )", (Object)this.CLASS_NAME, (long)n);
        CommandList commandList = this.phoneNumberInputSequence.getElementSelectedCommandList(n);
        commandList.add(new NavCommand("Update Detail Screen"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                AbstractAddressInputSDSFormJpKr.this.detailModelAccess.onUpdateLocation(navLocation);
                AbstractAddressInputSDSFormJpKr.this.detailsScreen.enterDetailsScreen(navLocation);
                this.getCommandList().commandFinished();
            }
        });
        this.setPhoneNumberNotifySDSCommand(naviServiceListener, commandList);
        this.setPhoneNumberErrorCommand(naviServiceListener, commandList);
        commandList.execute(this.CLASS_NAME + "#selectTelephoneNumberByIndex");
    }

    public String getLastValidTelephoneNumberBlock() {
        this.logChannel.log(10000000, "%1#getLastValidTelephoneNumberBlock()", (Object)this.CLASS_NAME);
        return this.phoneNumberInputSequence.getLastValidTelephoneNumberBlock();
    }

    public String getCurrentTelephoneNumber() {
        this.logChannel.log(10000000, "%1#getCurrentTelephoneNumber()", (Object)this.CLASS_NAME);
        return this.phoneNumberInputSequence.getCurrentTelephoneNumber();
    }

    public boolean isFurtherTelephonenumberInputPossible() {
        return this.phoneNumberInputSequence.isFurtherTelephonenumberInputPossible();
    }
}

