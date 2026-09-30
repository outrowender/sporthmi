/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.internal;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.internal.ChargingStation;
import org.dsi.ifc.internal.LocationHelper;
import org.dsi.ifc.internal.PhonemeParser;
import org.dsi.ifc.navigation.PhonemeData;
import org.dsi.ifc.navigation.util.ILocationAccessor;

public class EBLocationAccessor
implements ILocationAccessor {
    private static final String VERSION = "EB-MIBHigh-20130924";
    private ChargingStation m_ChargingStation = null;
    private LocationHelper m_Helper = null;
    private PhonemeParser m_PhonemeParser = null;

    public NavLocationDescriptor cloneLocationDescriptor(NavLocationDescriptor navLocationDescriptor) {
        return new NavLocationDescriptor(navLocationDescriptor.getSelectionCriterion(), navLocationDescriptor.getData());
    }

    public EBLocationAccessor(NavLocation navLocation) {
        this.setLocation(navLocation);
    }

    public EBLocationAccessor(EBLocationAccessor eBLocationAccessor) {
        this.setLocation(eBLocationAccessor.getLocation());
    }

    public EBLocationAccessor(int n, int n2) {
        NavLocation navLocation = new NavLocation();
        navLocation.latitude = n;
        navLocation.longitude = n2;
        navLocation.altitude = 0;
        navLocation.positionValid = n != 0 || n2 != 0;
        this.setLocation(navLocation);
    }

    public EBLocationAccessor(NavSegmentID navSegmentID) {
        NavLocation navLocation = new NavLocation();
        navLocation.positionValid = false;
        this.setLocation(navLocation);
        this.m_Helper.addProprietaryData(281, String.valueOf(navSegmentID.elements[0]));
    }

    public EBLocationAccessor(String string) {
        NavLocation navLocation = new NavLocation();
        navLocation.positionValid = false;
        navLocation.country = string;
        this.setLocation(navLocation);
    }

    public void setLocation(NavLocation navLocation) {
        if (navLocation == null) {
            navLocation = new NavLocation();
            navLocation.positionValid = false;
        }
        this.init(navLocation);
    }

    private void init(NavLocation navLocation) {
        if (null == this.m_Helper) {
            this.m_Helper = new LocationHelper(navLocation);
        } else {
            this.m_Helper.setLocation(navLocation);
        }
        if (null == this.m_ChargingStation) {
            this.m_ChargingStation = new ChargingStation(this.m_Helper);
        }
        if (null == this.m_PhonemeParser) {
            this.m_PhonemeParser = new PhonemeParser(this.m_Helper);
        }
    }

    public NavLocation getLocation() {
        if (null != this.m_Helper) {
            return this.m_Helper.getLocation();
        }
        return null;
    }

    public final int getAdditionalFlags() {
        int n = this.m_Helper.getValueForInternalType(1);
        if (n == -1) {
            n = 0;
        }
        return n;
    }

    public final String getCountry() {
        return this.getLocation().getCountry();
    }

    public final String getCountryAbbreviation() {
        return this.getLocation().getCountryAbbreviation();
    }

    public final String getHousenumber() {
        return this.getLocation().getHousenumber();
    }

    public final int getIconIndex() {
        return this.m_Helper.getValueOfSelectionCriterion(520);
    }

    public final String getJunction() {
        return this.getLocation().getJunction();
    }

    public final int getLatitude() {
        if (this.getLocation().isPositionValid()) {
            return this.getLocation().getLatitude();
        }
        return 0;
    }

    public final int getLongitude() {
        if (this.getLocation().isPositionValid()) {
            return this.getLocation().getLongitude();
        }
        return 0;
    }

    public final String getMmiInternalData() {
        return this.m_Helper.getDataOfSelectionCriterion(768);
    }

    public final String getMotorWayExit() {
        return "";
    }

    public final String getPhonenumber() {
        return this.m_Helper.getDataOfSelectionCriterion(8);
    }

    public final String getPoiCategory() {
        return this.m_Helper.getDataOfSelectionCriterion(32770);
    }

    public final int getPoiCategoryNumber() {
        return this.m_Helper.getValueOfSelectionCriterion(4096);
    }

    public final String getPoiClass() {
        return this.m_Helper.getDataOfSelectionCriterion(32769);
    }

    public final String getPoiName() {
        return this.m_Helper.getDataOfSelectionCriterion(4097);
    }

    public final String getStreet() {
        return this.getLocation().getStreet();
    }

    public final String getStreetRefinement() {
        return this.getLocation().getStreetRefinement();
    }

    public final int getSubIconIndex() {
        return this.m_Helper.getValueOfSelectionCriterion(282);
    }

    public final String getTown() {
        return this.getLocation().getTown();
    }

    public final String getTowncenter() {
        return this.getLocation().getTowncenter();
    }

    public final String getTownRefinement() {
        return this.getLocation().getTownRefinement();
    }

    public final int getType() {
        if (this.getPoiName().length() > 0) {
            return 1;
        }
        if (this.m_Helper.isFlagSet(5)) {
            return 2;
        }
        return 0;
    }

    public final String getURLAddress() {
        return this.m_Helper.getDataOfSelectionCriterion(128);
    }

    public final String getZipCode() {
        return this.getLocation().getZipCode();
    }

    public final boolean isNavigable() {
        return this.getLocation().isPositionValid();
    }

    public final void removeAll() {
        this.m_Helper.clearLocation();
    }

    public void setMmiInternalData(String string) throws IllegalArgumentException {
        this.m_Helper.addProprietaryData(768, string);
    }

    public boolean isParentOfPOIs() {
        return this.m_Helper.isFlagSet(1001);
    }

    public String getTownOriginalName() {
        boolean bl;
        String string = "";
        int n = Integer.parseInt(this.m_Helper.getDataForInternalType(2009));
        String string2 = this.m_Helper.getDataForInternalType(2001);
        String string3 = this.m_Helper.getDataForInternalType(2010);
        boolean bl2 = n == 6 || n == 7 || n == 8 || n == 9;
        boolean bl3 = bl = n == 11 || n == 12 || n == 13 || n == 14;
        if (bl2) {
            string = string2;
        } else if (bl) {
            string = string3;
        }
        return string;
    }

    public boolean isTownOrder9() {
        return (this.getAdditionalFlags() & Integer.MIN_VALUE) == Integer.MIN_VALUE;
    }

    public boolean isTownRefinementNeededForRefinement() {
        return (this.getAdditionalFlags() & 0x10000000) == 0x10000000;
    }

    public boolean isZipCodeNeededForRefinement() {
        return (this.getAdditionalFlags() & 0x20000000) == 0x20000000;
    }

    public boolean isZipCodeSpelled() {
        return (this.getAdditionalFlags() & 0x40000000) == 0x40000000;
    }

    public boolean isPOI24h() {
        return (this.getAdditionalFlags() & 1) == 1;
    }

    public boolean isPOIDiesel() {
        return (this.getAdditionalFlags() & 8) == 8;
    }

    public String getState() {
        return this.m_Helper.getDataForInternalType(2002);
    }

    public String getStateAbbreviation() {
        return this.m_Helper.getDataForInternalType(2003);
    }

    public String getStreetNearby() {
        return "";
    }

    public boolean isFullPostalCode() {
        return (this.getAdditionalFlags() & 0x8000000) == 0x8000000;
    }

    public boolean isStateSpelled() {
        return (this.getAdditionalFlags() & 0x4000000) == 0x4000000;
    }

    public boolean isStreetBasename() {
        return (this.getAdditionalFlags() & 0x10) == 16;
    }

    public int getCountryIconIndex() {
        int n = this.m_Helper.getValueForInternalType(2005);
        if (n < 0) {
            n = 0;
        }
        return n;
    }

    public int getAdditionalPoiAttributeBoolean(int n) {
        int n2 = -1;
        try {
            switch (n) {
                case 1: {
                    n2 = this.m_ChargingStation.getPay();
                    break;
                }
                case 2: {
                    n2 = this.m_ChargingStation.getSubscription();
                    break;
                }
                case 3: {
                    n2 = this.m_ChargingStation.getOnSitePayment();
                    break;
                }
                case 5: {
                    n2 = this.isPOI24h() ? 1 : 0;
                    break;
                }
                default: {
                    System.out.println("getAdditionalPoiAttributeBoolean invalid key: " + n);
                    break;
                }
            }
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return n2;
    }

    public String getAdditionalPoiAttributeString(int n) {
        String string = "";
        try {
            switch (n) {
                case 0: {
                    string = this.m_ChargingStation.getProvider();
                    break;
                }
                case 6: {
                    string = this.m_Helper.getDataOfSelectionCriterion(1282);
                    break;
                }
                default: {
                    System.out.println("getAdditionalPoiAttributeString invalid key: " + n);
                    break;
                }
            }
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return string;
    }

    public int getAdditionalPoiAttributeInt(int n) {
        int n2 = -1;
        try {
            switch (n) {
                case 4: {
                    n2 = this.m_ChargingStation.getAccess();
                    break;
                }
                case 5: {
                    n2 = this.isPOI24h() ? 1 : 0;
                    break;
                }
                default: {
                    System.out.println("getAdditionalPoiAttributeInt invalid key: " + n);
                    break;
                }
            }
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return n2;
    }

    public float getAdditionalPoiAttributeFloat(int n) {
        float f2 = -1.0f;
        try {
            switch (n) {
                default: 
            }
            System.out.println("getAdditionalPoiAttributeFloat invalid key: " + n);
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return f2;
    }

    public int getConnectorCount() {
        int n = -1;
        try {
            n = this.m_ChargingStation.getNoOfConnectorTypes();
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return n;
    }

    public int getConnectorAttributeBoolean(int n, int n2) {
        int n3 = -1;
        try {
            switch (n) {
                default: 
            }
            System.out.println("getConnectorAttributeFloat invalid key: " + n);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("ConnectorType Index invalid: " + indexOutOfBoundsException.getMessage());
        }
        return n3;
    }

    public float getConnectorAttributeFloat(int n, int n2) {
        float f2 = -1.0f;
        try {
            switch (n) {
                case 5: {
                    f2 = this.m_ChargingStation.getConnector((int)n2).powerOutput;
                    break;
                }
                default: {
                    System.out.println("getConnectorAttributeFloat invalid key: " + n);
                    break;
                }
            }
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return f2;
    }

    public String getConnectorAttributeString(int n, int n2) {
        String string = "";
        try {
            switch (n) {
                case 0: {
                    string = this.m_ChargingStation.getConnector((int)n2).chargeMode;
                    break;
                }
                case 1: {
                    string = this.m_ChargingStation.getConnector((int)n2).chargeLevel;
                    break;
                }
                case 2: {
                    string = this.m_ChargingStation.getConnector((int)n2).name;
                    break;
                }
                case 4: {
                    string = this.m_ChargingStation.getConnector((int)n2).fuseProtection;
                    break;
                }
                default: {
                    System.out.println("getConnectorAttributeString invalid key: " + n);
                    break;
                }
            }
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return string;
    }

    public int getConnectorAttributeInt(int n, int n2) {
        int n3 = -1;
        try {
            switch (n) {
                case 6: {
                    n3 = this.m_ChargingStation.getConnector((int)n2).countAvailable;
                    break;
                }
                case 3: {
                    n3 = this.m_ChargingStation.getConnector((int)n2).type;
                    break;
                }
                default: {
                    System.out.println("getConnectorAttributeInt invalid key: " + n);
                    break;
                }
            }
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return n3;
    }

    public boolean getIsPicNavLocation() {
        return false;
    }

    public PhonemeData getPhoneme(int n) {
        PhonemeData phonemeData = null;
        boolean bl = this.isTownOrder9();
        switch (n) {
            case 0: {
                phonemeData = this.m_PhonemeParser.getCountryPhoneme();
                break;
            }
            case 1: {
                phonemeData = this.m_PhonemeParser.getStatePhoneme();
                break;
            }
            case 4: 
            case 6: {
                phonemeData = this.m_PhonemeParser.getSuburbPhoneme();
                break;
            }
            case 5: {
                phonemeData = this.m_PhonemeParser.getStreetPhoneme();
                break;
            }
            case 7: {
                phonemeData = this.m_PhonemeParser.getJunctionPhoneme();
                break;
            }
            case 2: {
                if (bl) {
                    phonemeData = this.m_PhonemeParser.getSuburbPhoneme();
                    break;
                }
                phonemeData = this.m_PhonemeParser.getCityPhoneme();
                break;
            }
            case 3: {
                if (bl) {
                    phonemeData = this.m_PhonemeParser.getCityPhoneme();
                    break;
                }
                phonemeData = this.m_PhonemeParser.getStatePhoneme();
                break;
            }
            case 8: {
                phonemeData = this.m_PhonemeParser.getPOIPhoneme();
                break;
            }
        }
        return phonemeData;
    }

    public void setIsPicNavLocation(boolean bl) {
    }

    public String getCountryCode() {
        return this.m_Helper.getDataForInternalType(2072);
    }

    public int[] getIconDecoratorInformation() {
        return null;
    }

    public int getStreetIconId() {
        return 0;
    }

    public String getStreetIconText() {
        return null;
    }

    public String getChome() {
        return null;
    }

    public String getDistrict() {
        return null;
    }

    public String getMapCode() {
        return null;
    }

    public boolean isLocationDisambiguationPossible() {
        return false;
    }

    public boolean isLocationInCityState() {
        return false;
    }

    public String getGpxName() {
        return this.m_Helper.getDataForInternalType(2073);
    }

    public String getAdditionalLocationInformation(int n) {
        String string = "";
        switch (n) {
            case 1: {
                String string2 = this.m_Helper.getDataForInternalType(2009);
                if (string2 != "") {
                    int n2 = Integer.parseInt(string2);
                    string = this.m_Helper.getTownByDestinationType(n2);
                }
                if (string != "" || (string = this.m_Helper.getTownByDestinationType(11)) != "") break;
                string = this.m_Helper.getTownByDestinationType(6);
                break;
            }
        }
        return string;
    }

    public String getVillage() {
        return null;
    }

    public String getSubmunicipalTown() {
        return null;
    }

    public String getPlaceName() {
        return null;
    }

    public String getWard() {
        return null;
    }

    public boolean getAdditionalFlagStatus(int n) {
        return false;
    }

    public NavSegmentID getTraceID() {
        return null;
    }
}

