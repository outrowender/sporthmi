/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation.util;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.PhonemeData;

public interface ILocationAccessor {
    public int getAdditionalFlags();

    public String getCountry();

    public String getCountryAbbreviation();

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

    public String getStreetNearby();

    public String getStreetRefinement();

    public int getSubIconIndex();

    public String getTown();

    public String getTowncenter();

    public String getTownRefinement();

    public int getType();

    public String getURLAddress();

    public String getZipCode();

    public String getTownOriginalName();

    public boolean isNavigable();

    public boolean isParentOfPOIs();

    public boolean isZipCodeNeededForRefinement();

    public boolean isTownRefinementNeededForRefinement();

    public boolean isZipCodeSpelled();

    public boolean isTownOrder9();

    public boolean isFullPostalCode();

    public boolean isStateSpelled();

    public boolean isStreetBasename();

    public void removeAll();

    public void setLocation(NavLocation var1);

    public void setMmiInternalData(String var1) throws IllegalArgumentException;

    public int getCountryIconIndex();

    public int getAdditionalPoiAttributeBoolean(int var1);

    public String getAdditionalPoiAttributeString(int var1);

    public int getAdditionalPoiAttributeInt(int var1);

    public float getAdditionalPoiAttributeFloat(int var1);

    public int getConnectorCount();

    public int getConnectorAttributeBoolean(int var1, int var2);

    public float getConnectorAttributeFloat(int var1, int var2);

    public String getConnectorAttributeString(int var1, int var2);

    public int getConnectorAttributeInt(int var1, int var2);

    public PhonemeData getPhoneme(int var1);

    public void setIsPicNavLocation(boolean var1);

    public boolean getIsPicNavLocation();

    public String getCountryCode();

    public String getStreetIconText();

    public int getStreetIconId();

    public int[] getIconDecoratorInformation();

    public String getMapCode();

    public String getDistrict();

    public String getChome();

    public boolean isLocationDisambiguationPossible();

    public String getWard();

    public String getPlaceName();

    public String getSubmunicipalTown();

    public String getVillage();

    public String getAdditionalLocationInformation(int var1);

    public String getGpxName();

    public boolean isLocationInCityState();

    public NavSegmentID getTraceID();

    public boolean getAdditionalFlagStatus(int var1);
}

