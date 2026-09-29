/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.ADBSDSUtils;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.ADBSDSAddressDetails;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.AdbEntry;

public class ADBDestSetCommand
extends AbstractSystemCallCommand {
    private final int locationCategory;
    private final ADBSDSService adbService;
    private final NaviService naviService;
    private final NBestStorageAccess nBestStorage;
    private final AddressBookSDSHandler adbSDSHandler;
    private final NaviSDSHandler naviSDSHandler;
    private int eventID = 3001;

    public ADBDestSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, ADBSDSService aDBSDSService, NaviService naviService, NBestStorageAccess nBestStorageAccess, AddressBookSDSHandler addressBookSDSHandler, NaviSDSHandler naviSDSHandler) {
        super(logChannel, string, sDSHandlerService);
        this.locationCategory = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.adbService = aDBSDSService;
        this.naviService = naviService;
        this.nBestStorage = nBestStorageAccess;
        this.adbSDSHandler = addressBookSDSHandler;
        this.naviSDSHandler = naviSDSHandler;
    }

    private static String[] vCardGeoPosToDegrees(String string) {
        if (!SDSUtils.isEmpty(string) && string.indexOf(59) > 0 && string.indexOf(59) < string.length()) {
            String[] stringArray = new String[]{string.substring(0, string.indexOf(59)), string.substring(string.indexOf(59) + 1)};
            return stringArray;
        }
        return new String[0];
    }

    @Override
    public void execute() {
        int n;
        this.logger.log(-2137614336, "%1#execute: locationCategory=%2", (Object)this.getName(), (long)this.locationCategory);
        switch (this.locationCategory) {
            case 1: 
            case 2: {
                n = this.adbSDSHandler.getNavLocationTypeByCategory(this.locationCategory);
                this.eventID = 3000;
                break;
            }
            default: {
                n = this.getNavLocTypeForLineSelection();
            }
        }
        if (n == -1) {
            this.sendResult(3001);
            return;
        }
        this.logger.log(-2137614336, "%1#execute: navLocationType=%2", (Object)super.getName(), (long)n);
        ADBSDSAddressDetails aDBSDSAddressDetails = this.adbService.getAddressDetails(n);
        if (aDBSDSAddressDetails == null) {
            this.logger.log(10000, "%1#execute: adbDetails is null!", (Object)super.getName());
            this.sendResult(3001);
            return;
        }
        this.naviSDSHandler.setSDSAddressInputMode((byte)4);
        this.setAddressOnNaviService(n, aDBSDSAddressDetails);
    }

    private void setAddressOnNaviService(int n, ADBSDSAddressDetails aDBSDSAddressDetails) {
        this.logger.log(-2137614336, "%1#setAddressOnNaviService: navLocType= %2", (Object)super.getName(), (long)n);
        switch (n) {
            case 4: 
            case 5: {
                String string = aDBSDSAddressDetails.getGeoPos();
                String[] stringArray = ADBDestSetCommand.vCardGeoPosToDegrees(string);
                if (stringArray.length != 2) {
                    this.logger.log(10000, "%1#setAddressOnNaviService: latLng array from geoPos has invalid length!", (Object)super.getName());
                    this.sendResult(3001);
                    return;
                }
                this.logger.log(-2137614336, "%1#setAddressOnNaviService: call setDestination() with ADB contact geo coordinate=%2", (Object)super.getName(), (Object)string);
                this.naviService.setDestination(stringArray[0], stringArray[1]);
                break;
            }
            case 2: 
            case 3: {
                this.logger.log(-2137614336, "%1#setAddressOnNaviService: call setLocation() with ADB contact nav address.", (Object)super.getName());
                this.naviService.setLocation(aDBSDSAddressDetails.getNavLocation());
                break;
            }
            case 0: 
            case 1: {
                AdbEntry adbEntry = aDBSDSAddressDetails.getAdbEntry();
                int n2 = aDBSDSAddressDetails.getAddressIndex();
                this.logger.log(-2137614336, "%1#setAddressOnNaviService: call setDestination() with ADB contact postal address at idx=%2", (Object)super.getName(), (long)n2);
                this.naviService.setDestination(adbEntry, n2);
                break;
            }
            default: {
                this.sendResult(3001);
                return;
            }
        }
    }

    private int getNavLocTypeForLineSelection() {
        int n = -1;
        switch (this.locationCategory) {
            case 3: {
                n = this.sdsHandlerService.getSelectedRow();
                break;
            }
            case 0: {
                n = this.nBestStorage.getLastRecogLine();
                break;
            }
            default: {
                this.logger.log(-2137614336, "%1#handleLineSelection: unhandled locationCategory %2!", (Object)this.getName(), (long)this.locationCategory);
                return -1;
            }
        }
        int n2 = this.adbSDSHandler.getNavLocationType(n);
        if (this.locationCategory == 3) {
            this.eventID = 3000;
            return n2;
        }
        this.eventID = SDSUtils.translate(n2, ADBSDSUtils.detailedAddressTypes2EventId);
        this.logger.log(-2137614336, "%1#execute: navLocType %2 mapped onto %3!", (Object)this.getName(), (long)n2, (long)this.eventID);
        if (this.eventID == 128) {
            this.logger.log(10000, "%1#execute: invalid/unhandled locationCategory!", (Object)this.getName());
            return -1;
        }
        return n2;
    }

    public void sdsDestinationSetResult(int n) {
        this.logger.log(-2137614336, "%1#sdsDestinationSetResult: result=%2", (Object)this.getName(), (long)n);
        this.sendResult(n == 0 ? this.eventID : (n == 3 ? 3004 : 3001));
    }
}

