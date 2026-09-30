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

    public int getAdditionalFlags() {
        return this.accessor.getAdditionalFlags();
    }

    public int getAdditionalPoiAttributeBoolean(int n) {
        return this.accessor.getAdditionalPoiAttributeBoolean(n);
    }

    public int getAdditionalPoiAttributeInt(int n) {
        return this.accessor.getAdditionalPoiAttributeInt(n);
    }

    public float getAdditionalPoiAttributeFloat(int n) {
        return this.accessor.getAdditionalPoiAttributeFloat(n);
    }

    public String getAdditionalPoiAttributeString(int n) {
        return this.accessor.getAdditionalPoiAttributeString(n);
    }

    public String getChome() {
        return this.accessor.getChome();
    }

    public int getConnectorCount() {
        return this.accessor.getConnectorCount();
    }

    public int getConnectorAttributeBoolean(int n, int n2) {
        return this.accessor.getConnectorAttributeBoolean(n, n2);
    }

    public float getConnectorAttributeFloat(int n, int n2) {
        return this.accessor.getConnectorAttributeFloat(n, n2);
    }

    public String getConnectorAttributeString(int n, int n2) {
        return this.accessor.getConnectorAttributeString(n, n2);
    }

    public int getConnectorAttributeInt(int n, int n2) {
        return this.accessor.getConnectorAttributeInt(n, n2);
    }

    public String getCountry() {
        return this.accessor.getCountry();
    }

    public int getCountryIconIndex() {
        return this.accessor.getCountryIconIndex();
    }

    public String getCountryAbbreviation() {
        return this.accessor.getCountryAbbreviation();
    }

    public String getCountryCode() {
        return this.accessor.getCountryCode();
    }

    public String getDistrict() {
        return this.accessor.getDistrict();
    }

    public String getHousenumber() {
        return this.accessor.getHousenumber();
    }

    public int getIconIndex() {
        return this.accessor.getIconIndex();
    }

    public String getJunction() {
        return this.accessor.getJunction();
    }

    public int getLatitude() {
        return this.accessor.getLatitude();
    }

    public int getLongitude() {
        return this.accessor.getLongitude();
    }

    public String getMapCode() {
        return this.accessor.getMapCode();
    }

    public String getMmiInternalData() {
        return this.accessor.getMmiInternalData();
    }

    public String getMotorWayExit() {
        return this.accessor.getMotorWayExit();
    }

    public PhonemeData getPhoneme(int n) {
        return this.accessor.getPhoneme(n);
    }

    public String getPhonenumber() {
        return this.accessor.getPhonenumber();
    }

    public String getPlaceName() {
        return this.accessor.getPlaceName();
    }

    public String getPoiCategory() {
        return this.accessor.getPoiCategory();
    }

    public int getPoiCategoryNumber() {
        return this.accessor.getPoiCategoryNumber();
    }

    public String getPoiClass() {
        return this.accessor.getPoiClass();
    }

    public String getPoiName() {
        return this.accessor.getPoiName();
    }

    public String getState() {
        return Util.isHURegionNAR() || Util.isHURegionAsia() ? this.accessor.getState() : null;
    }

    public String getStateAbbreviation() {
        return Util.isHURegionNAR() || Util.isHURegionAsia() ? this.accessor.getStateAbbreviation() : null;
    }

    public String getStreet() {
        return this.accessor.getStreet();
    }

    public String getStreetRefinement() {
        return this.accessor.getStreetRefinement();
    }

    public int getSubIconIndex() {
        return this.accessor.getSubIconIndex();
    }

    public String getSubmunicipalTown() {
        return this.accessor.getSubmunicipalTown();
    }

    public String getStreetIconText() {
        return this.accessor.getStreetIconText();
    }

    public int getStreetIconId() {
        return this.accessor.getStreetIconId();
    }

    public String getTown() {
        return this.accessor.getTown();
    }

    public String getTowncenter() {
        return this.accessor.getTowncenter();
    }

    public String getTownOriginalName() {
        return this.accessor.getTownOriginalName();
    }

    public String getTownRefinement() {
        return this.accessor.getTownRefinement();
    }

    public int getType() {
        return this.accessor.getType();
    }

    public String getURLAddress() {
        return this.accessor.getURLAddress();
    }

    public String getVillage() {
        return this.accessor.getVillage();
    }

    public String getWard() {
        return this.accessor.getWard();
    }

    public String getZipCode() {
        return this.accessor.getZipCode();
    }

    public boolean isLocationDisambiguationPossible() {
        return this.accessor.isLocationDisambiguationPossible();
    }

    public boolean isNavigable() {
        return this.accessor.isNavigable();
    }

    public boolean isParentOfPOIs() {
        return this.accessor.isParentOfPOIs();
    }

    public boolean isStateSpelled() {
        return Util.isHURegionNAR() ? this.accessor.isStateSpelled() : false;
    }

    public boolean isStreetBasename() {
        return Util.isHURegionNAR() ? this.accessor.isStreetBasename() : false;
    }

    public boolean isTownOrder9() {
        return this.accessor.isTownOrder9();
    }

    public boolean isTownRefinementNeededForRefinement() {
        return this.accessor.isTownRefinementNeededForRefinement();
    }

    public boolean isZipCodeNeededForRefinement() {
        return this.accessor.isZipCodeNeededForRefinement();
    }

    public boolean isZipCodeSpelled() {
        return this.accessor.isZipCodeSpelled();
    }

    public void removeAll() {
        this.accessor.removeAll();
    }

    public void setLocation(NavLocation navLocation) {
        this.accessor.setLocation(navLocation);
    }

    public void setMmiInternalData(String string) throws IllegalArgumentException {
        this.accessor.setMmiInternalData(string);
    }

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

    public boolean isFullPostalCode() {
        return this.accessor.isFullPostalCode();
    }

    public boolean isLocationInCityState() {
        return this.accessor.isLocationInCityState();
    }
}

