/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PhonemeData;
import org.dsi.ifc.navigation.util.ILocationAccessor;
import org.dsi.ifc.navigation.util.ILocationAccessorFactory;

public class PCLocationAccessorWrapper
implements IMyLocationAccessor {
    private final ILocationAccessor accessor;

    public PCLocationAccessorWrapper(ILocationAccessor iLocationAccessor) {
        this.accessor = iLocationAccessor;
    }

    public PCLocationAccessorWrapper(ILocationAccessorFactory iLocationAccessorFactory, PCLocationAccessorWrapper pCLocationAccessorWrapper) {
        this.accessor = iLocationAccessorFactory.cloneLocationAccessor(pCLocationAccessorWrapper.getAccessor());
    }

    public ILocationAccessor getAccessor() {
        return this.accessor;
    }

    @Override
    public int getAdditionalFlags() {
        return this.accessor.getAdditionalFlags();
    }

    @Override
    public int getAdditionalPoiAttributeBoolean(int n) {
        return this.accessor.getAdditionalPoiAttributeBoolean(n);
    }

    @Override
    public int getAdditionalPoiAttributeInt(int n) {
        return this.accessor.getAdditionalPoiAttributeInt(n);
    }

    @Override
    public float getAdditionalPoiAttributeFloat(int n) {
        return this.accessor.getAdditionalPoiAttributeFloat(n);
    }

    @Override
    public String getAdditionalPoiAttributeString(int n) {
        return this.accessor.getAdditionalPoiAttributeString(n);
    }

    @Override
    public String getChome() {
        return this.accessor.getChome();
    }

    @Override
    public int getConnectorCount() {
        return this.accessor.getConnectorCount();
    }

    @Override
    public int getConnectorAttributeBoolean(int n, int n2) {
        return this.accessor.getConnectorAttributeBoolean(n, n2);
    }

    @Override
    public float getConnectorAttributeFloat(int n, int n2) {
        return this.accessor.getConnectorAttributeFloat(n, n2);
    }

    @Override
    public String getConnectorAttributeString(int n, int n2) {
        return this.accessor.getConnectorAttributeString(n, n2);
    }

    @Override
    public int getConnectorAttributeInt(int n, int n2) {
        return this.accessor.getConnectorAttributeInt(n, n2);
    }

    @Override
    public String getCountry() {
        return this.accessor.getCountry();
    }

    @Override
    public int getCountryIconIndex() {
        return this.accessor.getCountryIconIndex();
    }

    @Override
    public String getCountryAbbreviation() {
        return this.accessor.getCountryAbbreviation();
    }

    @Override
    public String getCountryCode() {
        return this.accessor.getCountryCode();
    }

    @Override
    public String getDistrict() {
        return this.accessor.getDistrict();
    }

    @Override
    public String getHousenumber() {
        return this.accessor.getHousenumber();
    }

    @Override
    public int getIconIndex() {
        return this.accessor.getIconIndex();
    }

    @Override
    public String getJunction() {
        return this.accessor.getJunction();
    }

    @Override
    public int getLatitude() {
        return this.accessor.getLatitude();
    }

    @Override
    public int getLongitude() {
        return this.accessor.getLongitude();
    }

    @Override
    public String getMapCode() {
        return this.accessor.getMapCode();
    }

    @Override
    public String getMmiInternalData() {
        return this.accessor.getMmiInternalData();
    }

    @Override
    public String getMotorWayExit() {
        return this.accessor.getMotorWayExit();
    }

    @Override
    public PhonemeData getPhoneme(int n) {
        return this.accessor.getPhoneme(n);
    }

    @Override
    public String getPhonenumber() {
        return this.accessor.getPhonenumber();
    }

    @Override
    public String getPlaceName() {
        return this.accessor.getPlaceName();
    }

    @Override
    public String getPoiCategory() {
        return this.accessor.getPoiCategory();
    }

    @Override
    public int getPoiCategoryNumber() {
        return this.accessor.getPoiCategoryNumber();
    }

    @Override
    public String getPoiClass() {
        return this.accessor.getPoiClass();
    }

    @Override
    public String getPoiName() {
        return this.accessor.getPoiName();
    }

    @Override
    public String getState() {
        return Util.isHURegionNAR() || Util.isHURegionAsia() ? this.accessor.getState() : null;
    }

    @Override
    public String getStateAbbreviation() {
        return Util.isHURegionNAR() || Util.isHURegionAsia() ? this.accessor.getStateAbbreviation() : null;
    }

    @Override
    public String getStreet() {
        return this.accessor.getStreet();
    }

    @Override
    public String getStreetRefinement() {
        return this.accessor.getStreetRefinement();
    }

    @Override
    public int getSubIconIndex() {
        return this.accessor.getSubIconIndex();
    }

    @Override
    public String getSubmunicipalTown() {
        return this.accessor.getSubmunicipalTown();
    }

    @Override
    public String getStreetIconText() {
        return this.accessor.getStreetIconText();
    }

    @Override
    public int getStreetIconId() {
        return this.accessor.getStreetIconId();
    }

    @Override
    public String getTown() {
        return this.accessor.getTown();
    }

    @Override
    public String getTowncenter() {
        return this.accessor.getTowncenter();
    }

    @Override
    public String getTownOriginalName() {
        return this.accessor.getTownOriginalName();
    }

    @Override
    public String getTownRefinement() {
        return this.accessor.getTownRefinement();
    }

    @Override
    public int getType() {
        return this.accessor.getType();
    }

    @Override
    public String getURLAddress() {
        return this.accessor.getURLAddress();
    }

    @Override
    public String getVillage() {
        return this.accessor.getVillage();
    }

    @Override
    public String getWard() {
        return this.accessor.getWard();
    }

    @Override
    public String getZipCode() {
        return this.accessor.getZipCode();
    }

    @Override
    public boolean isLocationDisambiguationPossible() {
        return this.accessor.isLocationDisambiguationPossible();
    }

    @Override
    public boolean isNavigable() {
        return this.accessor.isNavigable();
    }

    @Override
    public boolean isParentOfPOIs() {
        return this.accessor.isParentOfPOIs();
    }

    @Override
    public boolean isStateSpelled() {
        return Util.isHURegionNAR() ? this.accessor.isStateSpelled() : false;
    }

    @Override
    public boolean isStreetBasename() {
        return Util.isHURegionNAR() ? this.accessor.isStreetBasename() : false;
    }

    @Override
    public boolean isTownOrder9() {
        return this.accessor.isTownOrder9();
    }

    @Override
    public boolean isTownRefinementNeededForRefinement() {
        return this.accessor.isTownRefinementNeededForRefinement();
    }

    @Override
    public boolean isZipCodeNeededForRefinement() {
        return this.accessor.isZipCodeNeededForRefinement();
    }

    @Override
    public boolean isZipCodeSpelled() {
        return this.accessor.isZipCodeSpelled();
    }

    @Override
    public void removeAll() {
        this.accessor.removeAll();
    }

    @Override
    public void setLocation(NavLocation navLocation) {
        this.accessor.setLocation(navLocation);
    }

    @Override
    public void setMmiInternalData(String string) {
        this.accessor.setMmiInternalData(string);
    }

    @Override
    public String getAdditionalLocationInformation(int n) {
        return this.accessor.getAdditionalLocationInformation(n);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PCLocationAccessorWrapper [getAdditionalFlags()=");
        stringBuffer.append(this.getAdditionalFlags());
        stringBuffer.append(", getChome()=");
        stringBuffer.append(this.getChome());
        stringBuffer.append(", getCountry()=");
        stringBuffer.append(this.getCountry());
        stringBuffer.append(", getCountryAbbreviation()=");
        stringBuffer.append(this.getCountryAbbreviation());
        stringBuffer.append(", getCountryCode()=");
        stringBuffer.append(this.getCountryCode());
        stringBuffer.append(", getDistrict()=");
        stringBuffer.append(this.getDistrict());
        stringBuffer.append(", getHousenumber()=");
        stringBuffer.append(this.getHousenumber());
        stringBuffer.append(", getIconIndex()=");
        stringBuffer.append(this.getIconIndex());
        stringBuffer.append(", getJunction()=");
        stringBuffer.append(this.getJunction());
        stringBuffer.append(", getLatitude()=");
        stringBuffer.append(this.getLatitude());
        stringBuffer.append(", getLongitude()=");
        stringBuffer.append(this.getLongitude());
        stringBuffer.append(", getMapCode()=");
        stringBuffer.append(this.getMapCode());
        stringBuffer.append(", getMmiInternalData()=");
        stringBuffer.append(this.getMmiInternalData());
        stringBuffer.append(", getMotorWayExit()=");
        stringBuffer.append(this.getMotorWayExit());
        stringBuffer.append(", getPhonenumber()=");
        stringBuffer.append(this.getPhonenumber());
        stringBuffer.append(", getPlaceName()=");
        stringBuffer.append(this.getPlaceName());
        stringBuffer.append(", getPoiCategory()=");
        stringBuffer.append(this.getPoiCategory());
        stringBuffer.append(", getPoiCategoryNumber()=");
        stringBuffer.append(this.getPoiCategoryNumber());
        stringBuffer.append(", getPoiClass()=");
        stringBuffer.append(this.getPoiClass());
        stringBuffer.append(", getPoiName()=");
        stringBuffer.append(this.getPoiName());
        stringBuffer.append(", getState()=");
        stringBuffer.append(this.getState());
        stringBuffer.append(", getStateAbbreviation()=");
        stringBuffer.append(this.getStateAbbreviation());
        stringBuffer.append(", getStreet()=");
        stringBuffer.append(this.getStreet());
        stringBuffer.append(", getStreetRefinement()=");
        stringBuffer.append(this.getStreetRefinement());
        stringBuffer.append(", getStreetIconText()=");
        stringBuffer.append(this.getStreetIconText());
        stringBuffer.append(", getStreetIconID()=");
        stringBuffer.append(this.getStreetIconId());
        stringBuffer.append(", getSubIconIndex()=");
        stringBuffer.append(this.getSubIconIndex());
        stringBuffer.append(", getSubmunicipalTown()=");
        stringBuffer.append(this.getSubmunicipalTown());
        stringBuffer.append(", getTown()=");
        stringBuffer.append(this.getTown());
        stringBuffer.append(", getTowncenter()=");
        stringBuffer.append(this.getTowncenter());
        stringBuffer.append(", getTownOriginalName()=");
        stringBuffer.append(this.getTownOriginalName());
        stringBuffer.append(", getTownRefinement()=");
        stringBuffer.append(this.getTownRefinement());
        stringBuffer.append(", getType()=");
        stringBuffer.append(this.getType());
        stringBuffer.append(", getURLAddress()=");
        stringBuffer.append(this.getURLAddress());
        stringBuffer.append(", getVillage()=");
        stringBuffer.append(this.getVillage());
        stringBuffer.append(", getWard()=");
        stringBuffer.append(this.getWard());
        stringBuffer.append(", getZipCode()=");
        stringBuffer.append(this.getZipCode());
        stringBuffer.append(", isLocationDisambiguationPossible()=");
        stringBuffer.append(this.isLocationDisambiguationPossible());
        stringBuffer.append(", isNavigable()=");
        stringBuffer.append(this.isNavigable());
        stringBuffer.append(", isParentOfPOIs()=");
        stringBuffer.append(this.isParentOfPOIs());
        stringBuffer.append(", isStateSpelled()=");
        stringBuffer.append(this.isStateSpelled());
        stringBuffer.append(", isStreetBasename()=");
        stringBuffer.append(this.isStreetBasename());
        stringBuffer.append(", isTownOrder9()=");
        stringBuffer.append(this.isTownOrder9());
        stringBuffer.append(", isTownRefinementNeededForRefinement()=");
        stringBuffer.append(this.isTownRefinementNeededForRefinement());
        stringBuffer.append(", isZipCodeNeededForRefinement()=");
        stringBuffer.append(this.isZipCodeNeededForRefinement());
        stringBuffer.append(", isZipCodeSpelled()=");
        stringBuffer.append(this.isZipCodeSpelled());
        stringBuffer.append(", isFullPostalCode()=");
        stringBuffer.append(this.isFullPostalCode());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override
    public boolean isFullPostalCode() {
        return this.accessor.isFullPostalCode();
    }

    @Override
    public boolean isLocationInCityState() {
        return this.accessor.isLocationInCityState();
    }
}

