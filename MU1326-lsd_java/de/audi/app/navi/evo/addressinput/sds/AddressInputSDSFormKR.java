/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.details.GuiModelAccessDetailsEvo;
import de.audi.app.navi.evo.addressinput.sds.AbstractAddressInputSDSFormJpKr;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormKR$1;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormKR$2;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormKR$3;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormKR$4;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormKR$5;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormKR$6;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormKR$7;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSModelAccess;
import de.audi.app.navi.evo.tpegpoi.models.TpegPOICategoryScreenModelAccess;
import de.audi.app.navi.evo.tpegpoi.models.TpegPOIResultListScreenModelAccess;
import de.audi.atip.interapp.NaviService$OneshotData;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.disambiguation.LISPGetLocationFromIndexCommand;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOICategoryListSequence;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIResultListSequence;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public class AddressInputSDSFormKR
extends AbstractAddressInputSDSFormJpKr {
    private final IVehicle vehicle;
    private final IconHandler iconHandler;
    private final IRouteManager routeManager;
    private TpegPOICategoryListSequence categoryListSequence;
    private TpegPOIResultListSequence resultListSequence;

    public AddressInputSDSFormKR(IAddressInputForm iAddressInputForm, LogChannel logChannel, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, GuiModelAccessDetailsEvo guiModelAccessDetailsEvo, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, IVehicle iVehicle, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IconHandler iconHandler, IRouteManager iRouteManager, IDetailsScreen iDetailsScreen) {
        super(iAddressInputForm, logChannel, iCommandListFactory, spellerStack, cityHistory, navigationEnv, iPreviewMap, guiModelAccessDetailsEvo, iAddressInputFormModelAccessHelper, iStartGuidanceToDestinationSequence, iDetailsScreen);
        this.vehicle = iVehicle;
        this.iconHandler = iconHandler;
        this.routeManager = iRouteManager;
        this.initCategoryListSequence();
        this.initResultListSequence();
    }

    private void initCategoryListSequence() {
        int n = -1860041216;
        int n2 = -1826486784;
        TpegPOICategoryScreenModelAccess tpegPOICategoryScreenModelAccess = new TpegPOICategoryScreenModelAccess(this.env, n, n2);
        this.categoryListSequence = new TpegPOICategoryListSequence(this.env, this.commandListFactory, tpegPOICategoryScreenModelAccess, this.spellerStack, this.vehicle);
    }

    private void initResultListSequence() {
        int n = -1809709568;
        TpegPOIResultListScreenModelAccess tpegPOIResultListScreenModelAccess = new TpegPOIResultListScreenModelAccess(this.env, n, this.iconHandler, this.vehicle, this.routeManager);
        this.resultListSequence = new TpegPOIResultListSequence(this.env, this.commandListFactory, tpegPOIResultListScreenModelAccess, this.spellerStack, this.startGuidanceSequence, this.previewMap);
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
            case 18: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 4;
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
            Object object = map.get("SDS_ONE_SHOT_PROVINCE");
            Object object2 = map.get("SDS_ONE_SHOT_CITY");
            Object object3 = map.get("SDS_ONE_SHOT_WARD");
            Object object4 = map.get("SDS_ONE_SHOT_SUBMUNICIPALTOWN_AND_STREET");
            Object object5 = map.get("SDS_ONE_SHOT_VILLAGE_AND_STREET");
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
            this.logChannel.log(-2137614336, "%1#setOneShotData(province = %2, city = %3, ward = %4)", (Object)this.CLASS_NAME, (Object)string, (Object)string3, (Object)string5);
            this.logChannel.log(-2137614336, "%1#setOneShotData(subTownOrStreetName = %2, villageAndStreet = %3, houseNumber = %4)", (Object)this.CLASS_NAME, (Object)string7, (Object)string9, (Object)string11);
            this.logChannel.log(-2137614336, "%1#setOneShotData(Ids: prefectureId = %2, cityId = %3, wardId = %4 )", (Object)this.CLASS_NAME, (Object)string2, (Object)string4, (Object)string6);
            this.logChannel.log(-2137614336, "%1#setOneShotData(Ids: subTownOrStreetNameId = %2, villageAndStreetId = %3, houseNumberId = %4 )", (Object)this.CLASS_NAME, (Object)string8, (Object)string10, (Object)string12);
            this.addressInputSDSSequence.setOneShotDataKR(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string3, string5, string7, string9, string11, string2, string4, string6, string8, string10, string12, naviServiceListener);
        } else {
            this.logChannel.log(-1601830656, "%1#setOneShotData - oneShotDataMap is null!", (Object)this.CLASS_NAME);
            naviServiceListener.responseSetOneShotData((byte)1);
        }
    }

    @Override
    public void startTpegPOI(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#startTpegPOI()", (Object)this.CLASS_NAME);
        CommandList commandList = this.categoryListSequence.getStartTpegPOICommandList();
        commandList.add(new AddressInputSDSFormKR$1(this, "Response SDS based on result from south side", naviServiceListener));
        commandList.setErrorCommand(new AddressInputSDSFormKR$2(this, naviServiceListener));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#startTpegPOI").toString());
    }

    @Override
    public void getTpegPOIResultsByCategoryIndex(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#getTpegPOIResultsByCategoryIndex() - index = %2", (Object)this.CLASS_NAME, (long)n);
        CommandList commandList = this.resultListSequence.getResultListCommandList(n);
        commandList.add(new AddressInputSDSFormKR$3(this, "Response SDS based on result from south side", naviServiceListener));
        commandList.setErrorCommand(new AddressInputSDSFormKR$4(this, naviServiceListener));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#getTpegPOIResultsByCategoryIndex").toString());
    }

    @Override
    public void selectTpegPOIResultByIndex(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#selectTpegPOIResultByIndex() - index = %2", (Object)this.CLASS_NAME, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(SpellerStack.getInstance(), new SpellerContext(110)));
        commandList.add(new LISPGetLocationFromIndexCommand(n));
        commandList.add(new AddressInputSDSFormKR$5(this, "Update liCurrentLD"));
        commandList.add(new AddressInputSDSFormKR$6(this, "Response SDS based on result from south side", naviServiceListener));
        commandList.setErrorCommand(new AddressInputSDSFormKR$7(this, naviServiceListener));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#selectTpegPOIResultByIndex").toString());
    }
}

