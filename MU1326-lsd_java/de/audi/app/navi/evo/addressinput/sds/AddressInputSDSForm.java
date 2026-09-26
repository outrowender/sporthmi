/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.details.GuiModelAccessDetailsEvo;
import de.audi.app.navi.evo.addressinput.sds.AbstractAddressInputSDSFormEvo;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSModelAccess;
import de.audi.atip.interapp.NaviService$OneshotData;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public class AddressInputSDSForm
extends AbstractAddressInputSDSFormEvo {
    public AddressInputSDSForm(IAddressInputForm iAddressInputForm, LogChannel logChannel, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, GuiModelAccessDetailsEvo guiModelAccessDetailsEvo, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(iAddressInputForm, logChannel, iCommandListFactory, spellerStack, cityHistory, navigationEnv, iPreviewMap, guiModelAccessDetailsEvo, iAddressInputFormModelAccessHelper);
    }

    @Override
    public void setOneShotData(Map map, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#setOneShotData()", (Object)this.CLASS_NAME);
        if (map != null) {
            Object object = map.get("SDS_ONE_SHOT_CITY");
            Object object2 = map.get("SDS_ONE_SHOT_STREET");
            Object object3 = map.get("SDS_ONE_SHOT_HOUSENUMBER");
            String string = null;
            String string2 = null;
            String string3 = null;
            String string4 = null;
            String string5 = null;
            String string6 = null;
            if (object != null && object instanceof NaviService$OneshotData) {
                string = ((NaviService$OneshotData)object).getText();
                string4 = ((NaviService$OneshotData)object).getStringId();
            }
            if (object2 != null && object2 instanceof NaviService$OneshotData) {
                string2 = ((NaviService$OneshotData)object2).getText();
                string5 = ((NaviService$OneshotData)object2).getStringId();
            }
            if (object3 != null && object3 instanceof NaviService$OneshotData) {
                string3 = ((NaviService$OneshotData)object3).getText();
                string6 = ((NaviService$OneshotData)object3).getStringId();
            }
            this.logChannel.log(-2137614336, "%1#setOneShotData( %2, %3, %4 )", (Object)this.CLASS_NAME, (Object)string, (Object)string2, (Object)string3);
            this.logChannel.log(-2137614336, "%1#setOneShotData(Ids: %2, %3, %4 )", (Object)this.CLASS_NAME, (Object)string4, (Object)string5, (Object)string6);
            this.addressInputSDSSequence.setOneShotDataEU(new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), new AddressInputSDSModelAccess(this.env, this.addressInputService, this.detailModelAccess, this.modelAccessHelper), string, string2, string3, string4, string5, string6, naviServiceListener);
        } else {
            this.logChannel.log(-1601830656, "%1#setOneShotData - oneShotDataMap is null!", (Object)this.CLASS_NAME);
            naviServiceListener.responseSetOneShotData((byte)1);
        }
    }

    @Override
    protected int getPositionForType(int n) {
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
            case 5: {
                return 4;
            }
            case 3: {
                return 3;
            }
        }
        return 5;
    }

    @Override
    protected NavLocation getInitialLocation(int n) {
        if (this.env.getFramework().isNar()) {
            return this.env.getContainer().getLiCurrentLD();
        }
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
    protected boolean speechCountryNeedsSync() {
        NavLocation navLocation;
        NavLocation navLocation2 = Vehicle.getInstance().getVehicleCountryLocation();
        return !Util.checkIfCountryAbbreviationIsEqual(navLocation2, navLocation = this.env.getContainer().getLiCurrentLD());
    }
}

