/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.details;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;

public abstract class GuiModelAccessDetailsEvo
implements GuiModelAccessDetailsNavi {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final LogChannel logChannel;
    protected final IDestinationHandler detailsHandler;
    protected final LabelModelApp phonenumberLabel;
    protected final LabelModelApp additionalInfoLabel;
    protected final BaseListModelApp addressList;
    private final NavigationEnv env;

    public GuiModelAccessDetailsEvo(NavigationEnv navigationEnv, LogChannel logChannel, IDestinationHandler iDestinationHandler) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.additionalInfoLabel = navigationEnv.getLabelModel(2065630720);
        this.phonenumberLabel = navigationEnv.getLabelModel(2049181184);
        this.addressList = navigationEnv.getBaseListModel(2115962368);
        this.detailsHandler = iDestinationHandler;
    }

    @Override
    public void onUpdateLocation(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%2#onUpdateLocation - location=%1", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)this.CLASS_NAME);
        this.detailsHandler.setLocation(navLocation);
        String string = LocationFormatter.formatPhonenumber(navLocation);
        this.detailsHandler.setPhoneNumber(string);
        this.phonenumberLabel.setText(string);
        if (Util.isEmpty(this.phonenumberLabel.getText())) {
            this.phonenumberLabel.setStatus(3);
        } else {
            this.phonenumberLabel.setStatus(1);
        }
        String string2 = LocationFormatter.getURLAddress(navLocation);
        if (!Util.isEmpty(string2)) {
            this.env.getChoiceModel(-668989952).setValue(1);
            this.additionalInfoLabel.setText(string2);
        } else {
            this.logChannel.log(-2137614336, "%1#onUpdateLocation - no url found, disabling browser.", (Object)this.CLASS_NAME);
            this.env.getChoiceModel(-668989952).setValue(0);
            this.additionalInfoLabel.setText(LocationFormatter.formatPOIAdditionalInfo(navLocation));
        }
        this.env.getChoiceModel(-1927084544).setValue(this.isTpegAdditionInfoAvailable(navLocation));
    }

    @Override
    public void onUpdateLocation(OperatorCallResult operatorCallResult) {
        this.logChannel.log(-2137614336, "%2#onUpdateLocation - operatorCallResult=%1", (Object)operatorCallResult, (Object)this.CLASS_NAME);
        this.detailsHandler.setOperatorCallResult(operatorCallResult);
        String string = operatorCallResult.getAddress().getPhoneNumber();
        this.detailsHandler.setPhoneNumber(string);
        this.phonenumberLabel.setText(string);
        String string2 = operatorCallResult.getAddress().getUrl();
        this.additionalInfoLabel.setText(string2);
        this.env.getChoiceModel(-1927084544).setValue(0);
    }

    private int isTpegAdditionInfoAvailable(NavLocation navLocation) {
        int n = Util.getLocationAccessor(navLocation).getType();
        if (n == 4) {
            this.logChannel.log(-2137614336, "%1#isTpegAdditionInfoAvailable - location type Tpeg POI detected", (Object)this.CLASS_NAME);
            return 1;
        }
        return 0;
    }
}

