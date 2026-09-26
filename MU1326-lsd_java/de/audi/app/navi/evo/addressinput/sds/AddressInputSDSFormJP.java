/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.details.GuiModelAccessDetailsEvo;
import de.audi.app.navi.evo.addressinput.sds.AbstractAddressInputSDSFormJpKr;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormJP$1;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormJP$2;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormJP$3;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormJP$4;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSModelAccess;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.mapcode.MapcodeMatchSpellerModelAccess;
import de.audi.atip.interapp.NaviService$OneshotData;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.asia.DisambiguatedNavLocation;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguationCallback;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public class AddressInputSDSFormJP
extends AbstractAddressInputSDSFormJpKr
implements ILocationDisambiguationCallback {
    private final MapcodeInputSequence mapcodeInputSequence;
    private final ILocationDisambiguatorPopupHandler popupHandler;
    private NaviServiceListener disambiguationNaviServiceListener = null;

    public AddressInputSDSFormJP(IAddressInputForm iAddressInputForm, LogChannel logChannel, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, GuiModelAccessDetailsEvo guiModelAccessDetailsEvo, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ILocationDisambiguatorSequence iLocationDisambiguatorSequence, ILocationDisambiguatorPopupHandler iLocationDisambiguatorPopupHandler, IDetailsScreen iDetailsScreen) {
        super(iAddressInputForm, logChannel, iCommandListFactory, spellerStack, cityHistory, navigationEnv, iPreviewMap, guiModelAccessDetailsEvo, iAddressInputFormModelAccessHelper, iStartGuidanceToDestinationSequence, iDetailsScreen);
        MapcodeMatchSpellerModelAccess mapcodeMatchSpellerModelAccess = new MapcodeMatchSpellerModelAccess(navigationEnv, logChannel, DIScreensEvo.getDiJpMapcodeScreenSpellerModel(), DIScreensEvo.getDiJpMapcodeScreenButtonModel());
        this.mapcodeInputSequence = new MapcodeInputSequence(navigationEnv, logChannel, iCommandListFactory, mapcodeMatchSpellerModelAccess, iPreviewMap, spellerStack, iLocationDisambiguatorSequence);
        this.popupHandler = iLocationDisambiguatorPopupHandler;
    }

    @Override
    protected NavLocation getInitialLocation(int n) {
        NavLocation navLocation = null;
        NavLocation navLocation2 = this.env.getContainer().getSoPosPositionDescription();
        if (navLocation2 == null) {
            this.logChannel.log(1078071040, "%1#getInitialLocation() - LiCurrentLD is used because vehicleCountryLocation is null", (Object)this.CLASS_NAME);
            navLocation = this.env.getContainer().getLiCurrentLD();
        } else {
            this.logChannel.log(1078071040, "%1#getInitialLocation() - VehicleCountryLocation is used", (Object)this.CLASS_NAME);
            navLocation = navLocation2;
        }
        return navLocation;
    }

    @Override
    protected int getPositionForType(int n) {
        switch (n) {
            case 17: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 12: {
                return 4;
            }
            case 13: {
                return 5;
            }
            case 3: {
                return 5;
            }
        }
        return 6;
    }

    @Override
    public void setOneShotData(Map map, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#setOneShotData()", (Object)this.CLASS_NAME);
        if (map != null) {
            Object object = map.get("SDS_ONE_SHOT_PREFECTURE");
            Object object2 = map.get("SDS_ONE_SHOT_CITY");
            Object object3 = map.get("SDS_ONE_SHOT_WARD");
            Object object4 = map.get("SDS_ONE_SHOT_PLACENAME");
            Object object5 = map.get("SDS_ONE_SHOT_CHOME");
            Object object6 = map.get("SDS_ONE_SHOT_HOUSENUMBER");
            String string = null;
            String string2 = null;
            String string3 = null;
            String string4 = null;
            String string5 = null;
            String string6 = null;
            String string7 = null;
            String string8 = null;
            String string9 = null;
            String string10 = null;
            String string11 = null;
            String string12 = null;
            if (object instanceof NaviService$OneshotData) {
                string = ((NaviService$OneshotData)object).getText();
                string2 = ((NaviService$OneshotData)object).getStringId();
            }
            if (object2 instanceof NaviService$OneshotData) {
                string3 = ((NaviService$OneshotData)object2).getText();
                string4 = ((NaviService$OneshotData)object2).getStringId();
            }
            if (object3 instanceof NaviService$OneshotData) {
                string5 = ((NaviService$OneshotData)object3).getText();
                string6 = ((NaviService$OneshotData)object3).getStringId();
            }
            if (object4 instanceof NaviService$OneshotData) {
                string7 = ((NaviService$OneshotData)object4).getText();
                string8 = ((NaviService$OneshotData)object4).getStringId();
            }
            if (object5 instanceof NaviService$OneshotData) {
                string9 = ((NaviService$OneshotData)object5).getText();
                string10 = ((NaviService$OneshotData)object5).getStringId();
            }
            if (object6 instanceof NaviService$OneshotData) {
                string11 = ((NaviService$OneshotData)object6).getText();
                string12 = ((NaviService$OneshotData)object6).getStringId();
            }
            this.logChannel.log(-2137614336, "%1#setOneShotData(prefecture = %2, city = %3, ward = %4)", (Object)this.CLASS_NAME, (Object)string, (Object)string3, (Object)string5);
            this.logChannel.log(-2137614336, "%1#setOneShotData(placeName = %2, chome = %3, houseNumber = %4)", (Object)this.CLASS_NAME, (Object)string7, (Object)string9, (Object)string11);
            this.logChannel.log(-2137614336, "%1#setOneShotData(Ids: prefectureId = %2, cityId = %3, wardId = %4 )", (Object)this.CLASS_NAME, (Object)string2, (Object)string4, (Object)string6);
            this.logChannel.log(-2137614336, "%1#setOneShotData(Ids: placeNameId = %2, chomeId = %3, houseNumberId = %4 )", (Object)this.CLASS_NAME, (Object)string8, (Object)string10, (Object)string12);
            this.addressInputSDSSequence.setOneShotDataJP(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string3, string5, string7, string9, string11, string2, string4, string6, string8, string10, string12, naviServiceListener);
        } else {
            this.logChannel.log(-1601830656, "%1#setOneShotData - oneShotDataMap is null!", (Object)this.CLASS_NAME);
            naviServiceListener.responseSetOneShotData((byte)1);
        }
    }

    @Override
    public void enterMapCode(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#enterMapCode()", (Object)this.CLASS_NAME);
        CommandList commandList = this.mapcodeInputSequence.getStartCommandList();
        commandList.add(this.getMapCodeNotifySDSCommand(naviServiceListener));
        commandList.setErrorCommand(this.getMapCodeErrorCommand(naviServiceListener));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#enterMapCode").toString());
    }

    @Override
    public void inputMapCode(String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#inputMapCode( %2 )", (Object)this.CLASS_NAME, (Object)string);
        CommandList commandList = this.mapcodeInputSequence.inputMapCode(string, naviServiceListener);
        commandList.setErrorCommand(this.getMapCodeErrorCommand(naviServiceListener));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#inputMapCode").toString());
    }

    @Override
    public void deleteLastMapCodeInput(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#deleteLastMapCodeInput()", (Object)this.CLASS_NAME);
        CommandList commandList = this.mapcodeInputSequence.deleteLastMapCodeInput();
        commandList.add(this.getMapCodeNotifySDSCommand(naviServiceListener));
        commandList.setErrorCommand(this.getMapCodeErrorCommand(naviServiceListener));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#deleteLastMapCodeInput").toString());
    }

    @Override
    public void clearMapCode(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#clearMapCode()", (Object)this.CLASS_NAME);
        CommandList commandList = this.mapcodeInputSequence.getDeleteAllInputCommandList();
        commandList.add(this.getMapCodeNotifySDSCommand(naviServiceListener));
        commandList.setErrorCommand(this.getMapCodeErrorCommand(naviServiceListener));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#clearMapCode").toString());
    }

    @Override
    public void triggerMapCodeReturn(NaviServiceListener naviServiceListener) {
        CommandList commandList = this.mapcodeInputSequence.getMapcodeHkReturnCommandList(this.getMapCodeNotifySDSCommand(naviServiceListener), this.getMapCodeErrorCommand(naviServiceListener));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#triggerMapCodeReturn").toString());
    }

    @Override
    public void disambiguateMapCode(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#disambiguateMapCode()", (Object)this.CLASS_NAME);
        this.disambiguationNaviServiceListener = naviServiceListener;
        this.mapcodeInputSequence.disambiguateMapCode(this, this.getMapCodeErrorCommand(naviServiceListener));
    }

    @Override
    public void selectDisambiguatedMapCodeByIndex(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#selectDisambiguatedMapCodeByIndex( %2 )", (Object)this.CLASS_NAME, (long)n);
        this.mapcodeInputSequence.selectDisambiguatedMapCodeByIndex(n, this.getMapCodeNotifySDSCommand(naviServiceListener), this.getMapCodeErrorCommand(naviServiceListener));
    }

    @Override
    public String getLastValidMapCodeBlock() {
        this.logChannel.log(-2137614336, "%1#getLastValidMapCodeBlock()", (Object)this.CLASS_NAME);
        return this.mapcodeInputSequence.getLastValidMapCodeBlock();
    }

    @Override
    public String getCurrentMapCode() {
        this.logChannel.log(-2137614336, "%1#getCurrentMapCode()", (Object)this.CLASS_NAME);
        return this.mapcodeInputSequence.getCurrentMapCode();
    }

    @Override
    public boolean isCurrentMapCodeNavigable() {
        this.logChannel.log(-2137614336, "%1#isCurrentMapCodeNavigable()", (Object)this.CLASS_NAME);
        return this.mapcodeInputSequence.isCurrentMapCodeNavigable();
    }

    @Override
    public boolean isFurtherMapCodeInputPossible() {
        this.logChannel.log(-2137614336, "%1#isFurtherMapCodeInputPossible()", (Object)this.CLASS_NAME);
        return this.mapcodeInputSequence.isFurtherMapCodeInputPossible();
    }

    private NotifyNaviServiceListenerCommand getMapCodeNotifySDSCommand(NaviServiceListener naviServiceListener) {
        return new AddressInputSDSFormJP$1(this, naviServiceListener);
    }

    private NotifyNaviServiceListenerCommand getMapCodeErrorCommand(NaviServiceListener naviServiceListener) {
        return new AddressInputSDSFormJP$2(this, naviServiceListener);
    }

    @Override
    public void locationDisambiguationCallback(LocationDisambiguationWrapper locationDisambiguationWrapper) {
        this.logChannel.log(-2137614336, "%1#locationDisambiguationCallback() - action=%2, modelId=%3", (Object)this.CLASS_NAME, (long)locationDisambiguationWrapper.getAction(), (long)locationDisambiguationWrapper.getModelId());
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new AddressInputSDSFormJP$3(this, "Update map code disambiguation pick list", locationDisambiguationWrapper));
        commandList.add(new AddressInputSDSFormJP$4(this, "Start Popup Handling", locationDisambiguationWrapper));
        commandList.add(this.getMapCodeNotifySDSCommand(this.disambiguationNaviServiceListener));
        commandList.setErrorCommand(this.getMapCodeErrorCommand(this.disambiguationNaviServiceListener));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#locationDisambiguationCallback").toString());
    }

    static /* synthetic */ void access$000(AddressInputSDSFormJP addressInputSDSFormJP, DisambiguatedNavLocation[] disambiguatedNavLocationArray) {
        addressInputSDSFormJP.updateMapCodeSDSDisambiguatedPickList(disambiguatedNavLocationArray);
    }

    static /* synthetic */ ILocationDisambiguatorPopupHandler access$100(AddressInputSDSFormJP addressInputSDSFormJP) {
        return addressInputSDSFormJP.popupHandler;
    }
}

