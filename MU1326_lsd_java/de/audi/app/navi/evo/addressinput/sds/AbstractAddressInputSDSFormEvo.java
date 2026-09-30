/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.details.GuiModelAccessDetailsEvo;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSModelAccess;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.DefaultMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.sds.AbstractAddressInputSDSForm;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public abstract class AbstractAddressInputSDSFormEvo
extends AbstractAddressInputSDSForm {
    protected GuiModelAccessDetailsEvo detailModelAccess;

    public AbstractAddressInputSDSFormEvo(IAddressInputForm iAddressInputForm, LogChannel logChannel, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, GuiModelAccessDetailsEvo guiModelAccessDetailsEvo, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(iAddressInputForm, logChannel, iCommandListFactory, spellerStack, cityHistory, navigationEnv, iPreviewMap, iAddressInputFormModelAccessHelper, new AddressInputSDSSequence(spellerStack, iCommandListFactory, cityHistory, logChannel, iPreviewMap, iAddressInputForm, navigationEnv));
        this.detailModelAccess = guiModelAccessDetailsEvo;
    }

    public AbstractAddressInputSDSFormEvo(IAddressInputForm iAddressInputForm, LogChannel logChannel, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, GuiModelAccessDetailsEvo guiModelAccessDetailsEvo, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, AddressInputSDSSequence addressInputSDSSequence) {
        super(iAddressInputForm, logChannel, iCommandListFactory, spellerStack, cityHistory, navigationEnv, iPreviewMap, iAddressInputFormModelAccessHelper, addressInputSDSSequence);
        this.detailModelAccess = guiModelAccessDetailsEvo;
    }

    protected void startDestinationInput(int n, NaviServiceListener naviServiceListener, boolean bl) {
        NavLocation navLocation;
        this.logChannel.log(10000000, "%1#startDestinationInput( %2 )", (Object)this.CLASS_NAME, (long)n);
        NavLocation navLocation2 = navLocation = bl ? this.env.getContainer().getLiCurrentLD() : this.getInitialLocation(n);
        if (navLocation == null) {
            navLocation = new NavLocation();
        }
        this.logChannel.log(10000000, "%1#startDestinationInput() - initLocation = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.inputModeManager.setInputMode(0, this.env);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIStripLocationCommand(navLocation, this.getDSIDestType(n)));
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
                AbstractAddressInputSDSFormEvo.this.logChannel.log(10000000, "%1#startDestinationInput() - strippedLocation = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
                this.getCommandList().commandFinishedWithPostSequence(AbstractAddressInputSDSFormEvo.this.addressInputService.getStartAddressInputCommandList(navLocation));
            }
        });
        AddressInputSDSModelAccess addressInputSDSModelAccess = new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper);
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(addressInputSDSModelAccess));
        commandList.add(new NavCommand("Reset sds destination input type"){

            public void execute() {
                AbstractAddressInputSDSFormEvo.this.inputModeManager.resetSDSDestinationType();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStartDestinationInput((byte)0);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStartDestinationInput((byte)1);
            }
        });
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#startDestinationInput()").toString());
    }

    public void startDestinationInputWithCurrentLD(int n, NaviServiceListener naviServiceListener) {
        this.startDestinationInput(n, naviServiceListener, true);
    }

    public void startDestinationInput(int n, NaviServiceListener naviServiceListener) {
        this.startDestinationInput(n, naviServiceListener, false);
    }

    public void nextDestinationInput(int n) {
        int n2 = this.getPositionForType(n);
        this.logChannel.log(10000000, "%1#nextDestinationInput(%3) - set NAV_DEST_FORM_CURSOR_POS_MENU to %2", (Object)this.CLASS_NAME, (long)n2, (long)n);
        this.env.getMenuModel(401121).setFocusedItem(n2, FocusAdvice.KEEP_POSITION, -1L);
    }

    protected abstract int getPositionForType(int var1);

    protected abstract NavLocation getInitialLocation(int var1);

    public void setCenter(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#setCenter( )", (Object)this.CLASS_NAME);
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        this.logChannel.log(10000000, "%1#setCenter() - initLocation = %2", (Object)this.CLASS_NAME, (Object)navLocation);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIStripLocationCommand(navLocation, 5));
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
                AbstractAddressInputSDSFormEvo.this.logChannel.log(10000000, "%1#setCenter() - strippedLocation = %2", (Object)this.CLASS_NAME, (Object)navLocation);
                this.getCommandList().commandFinishedWithPostSequence(AbstractAddressInputSDSFormEvo.this.addressInputService.getStartAddressInputCommandList(navLocation));
            }
        });
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetLocationPart((byte)0);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetLocationPart((byte)1);
            }
        });
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#setCenter()").toString());
    }

    public void setCountry(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setCountry( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setCountry(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setCity(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setCity( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setCity(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setStreet(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setStreet( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setStreet(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setJunction(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setJunction( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setJunction(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setHouseNumber(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setHouseNumber( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setHouseNumber(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setHouseNumberByIndex(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%2#setHouseNumberByIndex( %1 )", (Object)Integer.toString(n), (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setHouseNumberByIndex(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), n, naviServiceListener);
    }

    public void setZIPCode(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setZIPCode( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setZip(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setState(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setState( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setState(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setCountryAndState(String string, String string2, String string3, String string4, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AbstractAddressInputSDSFormEvo#setCountryAndState( %1, %2, %3, %4 )", (Object)string, (Object)string2, (Object)string3, (Object)string4);
        this.addressInputSDSSequence.setCountryAndState(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, string3, string4, naviServiceListener);
    }

    public void setChome(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setChome( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setChome(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setPlacename(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setPlacename( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setPlacename(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setWard(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setWard( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setWard(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setPrefecture(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setPrefecture( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setPrefecture(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setProvince(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setProvince( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setProvince(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setSubmunicipalTownOrStreet(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setSubmunicipalTownOrStreet( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setSubmunicipalTownOrStreet(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void setVillageAndStreet(String string, String string2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%3#setVillageAndStreet( %1, %2 )", (Object)string, (Object)string2, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.setVillageAndStreet(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, naviServiceListener);
    }

    public void validateSpelledStreetName(String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%2#validateSpelledStreetName( %1 )", (Object)string, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.validateSpelledStreetName(new DefaultMatchspellerModelAccess(), string, naviServiceListener);
    }

    public void updateDetailScreenInfo(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#updateDetailScreenInfo()", (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.updateDetailScreenInfo(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), naviServiceListener);
    }

    public void querySpelledCityResultList(String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%2#querySpelledCityResultList( %1 )", (Object)string, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.querySpelledCityResultList(new DefaultMatchspellerModelAccess(), string, naviServiceListener);
    }

    public void querySpelledStreetResultList(String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%2#querySpelledStreetResultList( %1 )", (Object)string, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.querySpelledStreetResultList(new DefaultMatchspellerModelAccess(), string, naviServiceListener);
    }

    public void querySpelledStreetResultList2(String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%2#querySpelledStreetResultList2( %1 )", (Object)string, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.querySpelledStreetResultList2(new DefaultMatchspellerModelAccess(), string, naviServiceListener);
    }

    public void selectSpelledCityName(boolean bl, Object object, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%2#selectSpelledCityName( %1 )", bl, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.selectSpelledCityName(new DefaultMatchspellerModelAccess(), bl, object, naviServiceListener);
    }

    public void selectSpelledStreetName(boolean bl, Object object, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%2#selectSpelledStreetName( %1 )", bl, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.selectSpelledStreetName(new DefaultMatchspellerModelAccess(), bl, object, naviServiceListener);
    }

    public void selectSpelledStreetName2(boolean bl, Object object, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%2#selectSpelledStreetName2( %1 )", bl, (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.selectSpelledStreetName2(new DefaultMatchspellerModelAccess(), bl, object, naviServiceListener);
    }

    public void queryCityListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#queryCityListLength( )", (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.queryCityListLength(naviServiceListener);
    }

    public void queryZIPCodeListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#queryZIPCodeListLength( )", (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.queryZIPCodeListLength(naviServiceListener);
    }

    public void queryHouseNrListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#queryHouseNrListLength( )", (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.queryHouseNrListLength(naviServiceListener);
    }

    public void queryStreetListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#queryStreetListLength( )", (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.queryStreetListLength(naviServiceListener);
    }

    public void queryIntersectionListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#queryIntersectionListLength( )", (Object)this.CLASS_NAME);
        this.addressInputSDSSequence.queryIntersectionListLength(naviServiceListener);
    }

    public void enterMapCode(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#enterMapCode() currently is only used for JP!", (Object)this.CLASS_NAME);
    }

    public void inputMapCode(String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#inputMapCode( %2 ) currently is only used for JP!", (Object)this.CLASS_NAME, (Object)string);
    }

    public void deleteLastMapCodeInput(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#deleteLastMapCodeInput() currently is only used for JP!", (Object)this.CLASS_NAME);
    }

    public void clearMapCode(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#clearMapCode() currently is only used for JP!", (Object)this.CLASS_NAME);
    }

    public void triggerMapCodeReturn(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#triggerMapCodeReturn() currently is only used for JP!", (Object)this.CLASS_NAME);
    }

    public void disambiguateMapCode(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#disambiguateMapCode() currently is only used for JP!", (Object)this.CLASS_NAME);
    }

    public void selectDisambiguatedMapCodeByIndex(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#selectDisambiguatedMapCodeByIndex() currently is only used for JP!", (Object)this.CLASS_NAME);
    }

    public String getLastValidMapCodeBlock() {
        this.logChannel.log(10000000, "%1#getLastValidMapCodeBlock() currently is only used for JP, and will return null in other systems!", (Object)this.CLASS_NAME);
        return null;
    }

    public String getCurrentMapCode() {
        this.logChannel.log(10000000, "%1#getCurrentMapCode() currently is only used for JP, and will return null in other systems!", (Object)this.CLASS_NAME);
        return null;
    }

    public boolean isCurrentMapCodeNavigable() {
        this.logChannel.log(10000000, "%1#isCurrentMapCodeNavigable() currently is only used for JP, and will return null in other systems!", (Object)this.CLASS_NAME);
        return false;
    }

    public boolean isFurtherMapCodeInputPossible() {
        this.logChannel.log(10000000, "%1#isFurtherMapCodeInputPossible() currently is only used for JP, and will return null in other systems!", (Object)this.CLASS_NAME);
        return false;
    }

    public void enterTelephoneNumber(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#enterTelephoneNumber() currently is only used for JP and KR!", (Object)this.CLASS_NAME);
    }

    public void inputTelephoneNumber(String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#inputTelephoneNumber( %2 ) currently is only used for JP and KR!", (Object)this.CLASS_NAME, (Object)string);
    }

    public void deleteLastTelephoneNumberInput(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#deleteLastTelephoneNumberInput() currently is only used for JP and KR!", (Object)this.CLASS_NAME);
    }

    public void clearTelephoneNumber(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#clearTelephoneNumber() currently is only used for JP and KR!", (Object)this.CLASS_NAME);
    }

    public void selectTelephoneNumberByIndex(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#selectTelephoneNumberByIndex() currently is only used for JP and KR!", (Object)this.CLASS_NAME);
    }

    public String getLastValidTelephoneNumberBlock() {
        this.logChannel.log(10000000, "%1#getLastValidTelephoneNumberBlock() currently is only used for JP and KR, and will return null in other systems!", (Object)this.CLASS_NAME);
        return null;
    }

    public String getCurrentTelephoneNumber() {
        this.logChannel.log(10000000, "%1#getCurrentTelephoneNumber() currently is only used for JP and KR, and will return null in other systems!", (Object)this.CLASS_NAME);
        return null;
    }

    public boolean isFurtherTelephonenumberInputPossible() {
        this.logChannel.log(10000000, "%1#isFurtherTelephonenumberInputPossible() currently is only used for JP and KR, and will return false in other systems!", (Object)this.CLASS_NAME);
        return false;
    }

    public void startTpegPOI(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#startTpegPOI() currently is only used for KR, and will return null in other systems!", (Object)this.CLASS_NAME);
    }

    public void getTpegPOIResultsByCategoryIndex(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#getTpegPOIResultsByCategoryIndex() currently is only used for KR, and will return null in other systems!", (Object)this.CLASS_NAME);
    }

    public void selectTpegPOIResultByIndex(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#selectTpegPOIResultByIndex() currently is only used for KR, and will return null in other systems!", (Object)this.CLASS_NAME);
    }

    protected int getDSIDestType(int n) {
        switch (n) {
            case 0: {
                return 2;
            }
            case 21: {
                return 16;
            }
            case 1: {
                if (Util.isHURegionCN() || Util.isHURegionTW()) {
                    return 15;
                }
                return 1;
            }
            case 2: {
                return 5;
            }
            case 3: {
                return 3;
            }
            case 10: {
                return 1;
            }
            case 4: {
                return 1;
            }
            case 5: {
                return 8;
            }
            case 6: {
                return 1;
            }
            case 7: 
            case 17: 
            case 18: {
                return 15;
            }
            case 8: {
                return 17;
            }
            case 14: {
                this.logChannel.log(10000, "%1#getDSIDestType ward type is not defined.", (Object)this.CLASS_NAME);
                return -1;
            }
            case 11: {
                return 23;
            }
            case 12: {
                return 25;
            }
            case 13: {
                return 21;
            }
            case 15: {
                return 24;
            }
        }
        this.logChannel.log(100000, "%1#getDSIDestType(): Unhandled naviServiceDestType %2, returning -1!", (Object)this.CLASS_NAME, (long)n);
        return -1;
    }

    protected int getDSILocationDisambiguationType(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
        }
        this.logChannel.log(100000, "%1#getDSILocationDisambiguationType(): Unhandled naviServiceLocationDisambiguationType %2, returning -1!", (Object)this.CLASS_NAME, (long)n);
        return -1;
    }
}

