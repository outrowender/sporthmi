/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.locationaccessor;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PhonemeData;

public interface IMyLocationAccessor {
    public int getAdditionalFlags();

    public int getAdditionalPoiAttributeBoolean(int var1);

    public String getAdditionalPoiAttributeString(int var1);

    public int getAdditionalPoiAttributeInt(int var1);

    public float getAdditionalPoiAttributeFloat(int var1);

    public int getConnectorCount();

    public int getConnectorAttributeBoolean(int var1, int var2);

    public float getConnectorAttributeFloat(int var1, int var2);

    public String getConnectorAttributeString(int var1, int var2);

    public int getConnectorAttributeInt(int var1, int var2);

    public String getCountry();

    public String getCountryAbbreviation();

    public int getCountryIconIndex();

    public String getState();

    public String getStateAbbreviation();

    public String getHousenumber();

    public int getIconIndex();

    public String getJunction();

    public int getLatitude();

    public int getLongitude();

    public String getMmiInternalData();

    public String getMotorWayExit();

    public String getPhonenumber();

    public String getPoiCategory();

    public int getPoiCategoryNumber();

    public String getPoiClass();

    public String getPoiName();

    public String getStreet();

    public String getStreetRefinement();

    public int getSubIconIndex();

    public String getTown();

    public String getTowncenter();

    public String getTownRefinement();

    public int getType();

    public String getURLAddress();

    public String getZipCode();

    public boolean isNavigable();

    public boolean isParentOfPOIs();

    public boolean isZipCodeNeededForRefinement();

    public boolean isTownRefinementNeededForRefinement();

    public boolean isZipCodeSpelled();

    public boolean isTownOrder9();

    public boolean isStateSpelled();

    public boolean isStreetBasename();

    public void removeAll();

    public void setLocation(NavLocation var1);

    public void setMmiInternalData(String var1) throws IllegalArgumentException;

    public PhonemeData getPhoneme(int var1);

    public String getPlaceName();

    public String getWard();

    public String getSubmunicipalTown();

    public String getVillage();

    public String getChome();

    public String getDistrict();

    public String getMapCode();

    public String getTownOriginalName();

    public boolean isLocationDisambiguationPossible();

    public String getCountryCode();

    public String getStreetIconText();

    public int getStreetIconId();

    public String getAdditionalLocationInformation(int var1);

    public boolean isFullPostalCode();

    public boolean isLocationInCityState();
}

