/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIDestinationImport;
import org.dsi.ifc.online.DSIDestinationImportListener;
import org.dsi.ifc.online.PortalADBEntry;
import org.dsi.ifc.online.PortalAddressData;
import org.dsi.ifc.online.PortalLocation;
import org.dsi.ifc.online.PortalMessagingData;
import org.dsi.ifc.online.PortalNavigationData;
import org.dsi.ifc.online.PortalPersonalData;
import org.dsi.ifc.online.PortalPhoneData;

public class OnlineDestinationSDSSim
implements DSIDestinationImport {
    private final DSIDestinationImportListener listener;
    int idCounter = 0;

    public OnlineDestinationSDSSim(DSIDestinationImportListener dSIDestinationImportListener) {
        this.listener = dSIDestinationImportListener;
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
    }

    private PortalADBEntry createEntry(String string, String string2, String string3, String string4) {
        PortalLocation portalLocation = new PortalLocation(-556655608, -413027806, "unstructured");
        PortalPersonalData portalPersonalData = new PortalPersonalData(string3, "", string4, "", "", "");
        PortalPhoneData portalPhoneData = new PortalPhoneData("01601112222", 1L);
        PortalAddressData portalAddressData = new PortalAddressData(0L, "street", "locality", "country", "postOfficeBox", "region", "postalCode", "unstructured");
        PortalNavigationData portalNavigationData = new PortalNavigationData(0L, true, portalLocation, 1L, "geoPosition", "street", "localaity");
        PortalMessagingData portalMessagingData = new PortalMessagingData(1L, "email@email.de", "url");
        PortalAddressData portalAddressData2 = new PortalAddressData(1L, "street2", "locality2", "country2", "postOfficeBox2", "region2", "postalCode2", "unstructured2");
        PortalADBEntry portalADBEntry = new PortalADBEntry(this.idCounter++, 0L, string, string2, 1, 112, 1L, 1L, portalPersonalData, new PortalPhoneData[]{portalPhoneData}, new PortalAddressData[]{portalAddressData, portalAddressData2}, new PortalNavigationData[]{portalNavigationData}, new PortalMessagingData[]{portalMessagingData});
        return portalADBEntry;
    }

    private PortalADBEntry createEntry2(String string, String string2, String string3, String string4) {
        PortalLocation portalLocation = new PortalLocation(-556655608, -413027806, "unstructured");
        PortalPersonalData portalPersonalData = new PortalPersonalData(string3, "", string4, "", "", "");
        PortalPhoneData portalPhoneData = new PortalPhoneData("01601112222", 1L);
        PortalAddressData portalAddressData = new PortalAddressData(0L, "street", "locality", "country", "postOfficeBox", "region", "postalCode", "unstructured");
        PortalNavigationData portalNavigationData = new PortalNavigationData(0L, true, portalLocation, 1L, "geoPosition", "street", "localaity");
        PortalMessagingData portalMessagingData = new PortalMessagingData(1L, "email@email.de", "url");
        PortalADBEntry portalADBEntry = new PortalADBEntry(this.idCounter++, 0L, string, string2, 1, 112, 1L, 1L, portalPersonalData, new PortalPhoneData[]{portalPhoneData}, new PortalAddressData[]{portalAddressData}, new PortalNavigationData[]{portalNavigationData}, new PortalMessagingData[]{portalMessagingData});
        return portalADBEntry;
    }

    private PortalADBEntry createEntry3(String string, String string2, String string3, String string4) {
        PortalPersonalData portalPersonalData = new PortalPersonalData(string3, "", string4, "", "", "");
        PortalPhoneData portalPhoneData = new PortalPhoneData("01601112222", 1L);
        PortalMessagingData portalMessagingData = new PortalMessagingData(1L, "email@email.de", "url");
        PortalADBEntry portalADBEntry = new PortalADBEntry(this.idCounter++, 0L, string, string2, 1, 112, 1L, 1L, portalPersonalData, new PortalPhoneData[]{portalPhoneData}, new PortalAddressData[0], new PortalNavigationData[0], new PortalMessagingData[]{portalMessagingData});
        return portalADBEntry;
    }

    @Override
    public void downloadAddressList(int n, boolean bl) {
        System.out.println(new StringBuffer().append("DSIDestinationImportSIM#downloadAddressList() [isImport=").append(bl).append("]").toString());
        PortalADBEntry[] portalADBEntryArray = new PortalADBEntry[]{this.createEntry("Hans Maulwurf", "Mein bester Freund", "Maulwurf", "Hans"), this.createEntry2("Peter Pan", "Mein Traumprinz", "Pan", "Peter"), this.createEntry3("Andreas Udi", "Unser Kunde", "Udi", "Andreas")};
        int n2 = 3002;
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        int n3 = n2;
        PortalADBEntry[] portalADBEntryArray2 = portalADBEntryArray;
        this.listener.downloadAddressListResult(portalADBEntryArray2, n3, 0);
    }

    @Override
    public void stopAction() {
    }

    @Override
    public void setADBImportStatus(long[] lArray, int n) {
    }
}

