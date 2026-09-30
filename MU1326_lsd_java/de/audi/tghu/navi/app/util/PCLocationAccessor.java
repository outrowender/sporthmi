/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.PhonemeData;

public class PCLocationAccessor
implements IMyLocationAccessor {
    NavLocation trans;

    private NavLocationDescriptor cloneNavLocationDescriptor(NavLocationDescriptor navLocationDescriptor) {
        return new NavLocationDescriptor(navLocationDescriptor.getSelectionCriterion(), navLocationDescriptor.getData());
    }

    public PCLocationAccessor(NavLocation navLocation) {
        this.setLocation(navLocation);
    }

    public PCLocationAccessor(PCLocationAccessor pCLocationAccessor) {
        this.trans = new NavLocation();
        if (pCLocationAccessor.trans.proprietaryData != null) {
            this.trans.proprietaryData = new NavLocationDescriptor[pCLocationAccessor.trans.proprietaryData.length];
            for (int i2 = 0; i2 < pCLocationAccessor.trans.proprietaryData.length; ++i2) {
                this.trans.proprietaryData[i2] = this.cloneNavLocationDescriptor(pCLocationAccessor.trans.proprietaryData[i2]);
            }
        }
        this.trans.positionValid = pCLocationAccessor.trans.positionValid;
        this.trans.longitude = pCLocationAccessor.trans.longitude;
        this.trans.latitude = pCLocationAccessor.trans.latitude;
        this.trans.altitude = pCLocationAccessor.trans.altitude;
        this.trans.versionOfLocationStructureValid = pCLocationAccessor.trans.versionOfLocationStructureValid;
        if (pCLocationAccessor.trans.townRefinement != null) {
            this.trans.townRefinement = pCLocationAccessor.trans.townRefinement;
        }
        if (pCLocationAccessor.trans.version != null) {
            this.trans.version = pCLocationAccessor.trans.version;
        }
        if (pCLocationAccessor.trans.country != null) {
            this.trans.country = pCLocationAccessor.trans.country;
        }
        if (pCLocationAccessor.trans.countryAbbreviation != null) {
            this.trans.countryAbbreviation = pCLocationAccessor.trans.countryAbbreviation;
        }
        if (pCLocationAccessor.trans.housenumber != null) {
            this.trans.housenumber = pCLocationAccessor.trans.housenumber;
        }
        if (pCLocationAccessor.trans.junction != null) {
            this.trans.junction = pCLocationAccessor.trans.junction;
        }
        if (pCLocationAccessor.trans.street != null) {
            this.trans.street = pCLocationAccessor.trans.street;
        }
        if (pCLocationAccessor.trans.streetRefinement != null) {
            this.trans.streetRefinement = pCLocationAccessor.trans.streetRefinement;
        }
        if (pCLocationAccessor.trans.town != null) {
            this.trans.town = pCLocationAccessor.trans.town;
        }
        if (pCLocationAccessor.trans.towncenter != null) {
            this.trans.towncenter = pCLocationAccessor.trans.towncenter;
        }
        if (pCLocationAccessor.trans.zipCode != null) {
            this.trans.zipCode = pCLocationAccessor.trans.zipCode;
        }
    }

    public PCLocationAccessor(NavSegmentID navSegmentID) {
        this.trans = new NavLocation();
        this.trans.positionValid = false;
    }

    public PCLocationAccessor(int n, int n2) {
        this.trans = new NavLocation();
        this.trans.positionValid = true;
        this.trans.latitude = n;
        this.trans.longitude = n2;
        this.trans.altitude = -1;
    }

    public PCLocationAccessor(String string) {
        this.trans = new NavLocation();
        this.trans.positionValid = false;
        this.trans.country = string;
    }

    public PCLocationAccessor(String string, String string2) {
        this.trans = new NavLocation();
        this.trans.positionValid = false;
        this.trans.countryAbbreviation = string;
        this.addSelCrit(138, string2);
    }

    public final void setLocation(NavLocation navLocation) {
        this.trans = navLocation;
    }

    private final String getDataOfSelectionCriteria(int n) {
        if (null != this.trans.proprietaryData) {
            for (int i2 = 0; i2 < this.trans.proprietaryData.length; ++i2) {
                if (this.trans.proprietaryData[i2].selectionCriterion != n) continue;
                return this.trans.proprietaryData[i2].getData();
            }
        }
        return null;
    }

    private void addSelCrit(int n, String string) {
        boolean bl = false;
        NavLocationDescriptor[] navLocationDescriptorArray = this.trans.proprietaryData;
        if (navLocationDescriptorArray != null) {
            for (int i2 = 0; i2 < navLocationDescriptorArray.length && !bl; ++i2) {
                if (navLocationDescriptorArray[i2].getData() == null || navLocationDescriptorArray[i2].selectionCriterion != n) continue;
                bl = true;
                navLocationDescriptorArray[i2] = new NavLocationDescriptor(n, string);
            }
            if (!bl) {
                NavLocationDescriptor[] navLocationDescriptorArray2 = new NavLocationDescriptor[navLocationDescriptorArray.length + 1];
                System.arraycopy((Object)navLocationDescriptorArray, 0, (Object)navLocationDescriptorArray2, 0, navLocationDescriptorArray.length);
                navLocationDescriptorArray = navLocationDescriptorArray2;
                navLocationDescriptorArray[navLocationDescriptorArray.length - 1] = new NavLocationDescriptor(n, string);
            }
        } else {
            navLocationDescriptorArray = new NavLocationDescriptor[]{new NavLocationDescriptor(n, string)};
        }
        this.trans.proprietaryData = navLocationDescriptorArray;
    }

    public final int getAdditionalFlags() {
        return 0;
    }

    public int getAdditionalPoiAttributeBoolean(int n) {
        return 0;
    }

    public String getAdditionalPoiAttributeString(int n) {
        return "";
    }

    public int getAdditionalPoiAttributeInt(int n) {
        return 0;
    }

    public float getAdditionalPoiAttributeFloat(int n) {
        return 0.0f;
    }

    public int getConnectorCount() {
        return 0;
    }

    public int getConnectorAttributeBoolean(int n, int n2) {
        return 0;
    }

    public float getConnectorAttributeFloat(int n, int n2) {
        return 0.0f;
    }

    public String getConnectorAttributeString(int n, int n2) {
        return "";
    }

    public int getConnectorAttributeInt(int n, int n2) {
        return 0;
    }

    public final String getCountry() {
        return this.trans.getCountry();
    }

    public final String getCountryAbbreviation() {
        return this.trans.getCountryAbbreviation();
    }

    public int getCountryIconIndex() {
        return 0;
    }

    public final String getHousenumber() {
        return this.trans.getHousenumber();
    }

    public final int getIconIndex() {
        return this.parseInt(this.getDataOfSelectionCriteria(520));
    }

    public final String getJunction() {
        return this.trans.getJunction();
    }

    public final int getLatitude() {
        if (this.trans.isPositionValid()) {
            return this.trans.getLatitude();
        }
        return 0;
    }

    public final int getLongitude() {
        if (this.trans.isPositionValid()) {
            return this.trans.getLongitude();
        }
        return 0;
    }

    public final String getMmiInternalData() {
        return this.getDataOfSelectionCriteria(768);
    }

    public final String getMotorWayExit() {
        return this.getDataOfSelectionCriteria(4);
    }

    public final String getPhonenumber() {
        return this.getDataOfSelectionCriteria(32776);
    }

    public final String getPoiCategory() {
        return this.getDataOfSelectionCriteria(32770);
    }

    public final int getPoiCategoryNumber() {
        return this.parseInt(this.getDataOfSelectionCriteria(32768));
    }

    public final String getPoiClass() {
        return this.getDataOfSelectionCriteria(32769);
    }

    public final String getPoiName() {
        return this.getDataOfSelectionCriteria(32771);
    }

    public final String getStreet() {
        return this.trans.getStreet();
    }

    public final String getStreetRefinement() {
        return this.trans.getStreetRefinement();
    }

    public final int getSubIconIndex() {
        return this.parseInt(this.getDataOfSelectionCriteria(282));
    }

    public final String getTown() {
        return this.trans.getTown();
    }

    public final String getTowncenter() {
        return this.trans.getTowncenter();
    }

    public final String getTownRefinement() {
        return this.trans.getTownRefinement();
    }

    public final int getType() {
        int n = 0;
        NavLocationDescriptor[] navLocationDescriptorArray = this.trans.proprietaryData;
        if (navLocationDescriptorArray != null) {
            for (int i2 = 0; i2 < navLocationDescriptorArray.length; ++i2) {
                if (navLocationDescriptorArray[i2].selectionCriterion != 4096) continue;
                n = Integer.parseInt(navLocationDescriptorArray[i2].getData());
                break;
            }
        }
        return n;
    }

    public final String getURLAddress() {
        return this.getDataOfSelectionCriteria(128);
    }

    public final String getZipCode() {
        return this.trans.getZipCode();
    }

    public final boolean isNavigable() {
        return this.trans.isPositionValid();
    }

    private int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    public final void removeAll() {
        this.trans.positionValid = false;
        this.trans.longitude = 0;
        this.trans.latitude = 0;
        this.trans.altitude = 0;
        this.trans.country = null;
        this.trans.countryAbbreviation = null;
        this.trans.housenumber = null;
        this.trans.junction = null;
        this.trans.street = null;
        this.trans.streetRefinement = null;
        this.trans.town = null;
        this.trans.towncenter = null;
        this.trans.townRefinement = null;
        this.trans.zipCode = null;
        this.trans.proprietaryData = null;
        this.trans.version = null;
        this.trans.versionOfLocationStructureValid = false;
    }

    public void setMmiInternalData(String string) throws IllegalArgumentException {
        this.addSelCrit(768, string);
    }

    public boolean isParentOfPOIs() {
        return false;
    }

    public boolean isZipCodeNeededForRefinement() {
        return false;
    }

    public boolean isTownRefinementNeededForRefinement() {
        return false;
    }

    public boolean isZipCodeSpelled() {
        return false;
    }

    public boolean isTownOrder9() {
        return false;
    }

    public String getState() {
        return this.getDataOfSelectionCriteria(138);
    }

    public String getStateAbbreviation() {
        return this.getDataOfSelectionCriteria(138);
    }

    public boolean isStateSpelled() {
        return false;
    }

    public boolean isStreetBasename() {
        return false;
    }

    public PhonemeData getPhoneme(int n) {
        return null;
    }

    public String getPlaceName() {
        return this.getDataOfSelectionCriteria(147);
    }

    public String getWard() {
        return this.getDataOfSelectionCriteria(152);
    }

    public String getSubmunicipalTown() {
        return this.getDataOfSelectionCriteria(148);
    }

    public String getVillage() {
        return this.getDataOfSelectionCriteria(149);
    }

    public String getChome() {
        return this.getDataOfSelectionCriteria(144);
    }

    public String getDistrict() {
        return this.getDataOfSelectionCriteria(143);
    }

    public String getMapCode() {
        return this.getDataOfSelectionCriteria(142);
    }

    public String getTownOriginalName() {
        return null;
    }

    public boolean isLocationDisambiguationPossible() {
        return false;
    }

    public String getCountryCode() {
        return null;
    }

    public String getStreetIconText() {
        return null;
    }

    public int getStreetIconId() {
        return -1;
    }

    public String getAdditionalLocationInformation(int n) {
        return "";
    }

    public boolean isFullPostalCode() {
        return false;
    }

    public boolean isLocationInCityState() {
        return false;
    }
}

