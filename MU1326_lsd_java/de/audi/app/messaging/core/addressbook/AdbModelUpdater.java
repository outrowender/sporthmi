/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.messaging.core.addressbook.AdbModelUpdater$DiagPlugIn;
import de.audi.app.messaging.core.addressbook.AddressSelectionListRow;
import de.audi.app.messaging.core.addressbook.NavigationLocationListRow;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.NaviADBService;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PhoneData;

public final class AdbModelUpdater
extends AbstractMessagingComponent
implements IDiagProvider {
    public AdbModelUpdater(MessagingBundleContext messagingBundleContext, String string) {
        super(messagingBundleContext, string);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    public void updateRecipientSelection(AdbEntry adbEntry, int n, int n2) {
        this.log.log(-2137614336, "AdbModelUpdater#updateRecipientSelection(): updating models for entry \"%1\" with id %2...", (Object)(adbEntry != null ? adbEntry.getCombinedName() : ""), adbEntry != null ? adbEntry.getEntryId() : -1L);
        BaseListModelApp baseListModelApp = this.framework.getHMIService().getBaseListModel(-124641024);
        if (n2 == 0) {
            AdbModelUpdater.fillWithNumber(adbEntry, baseListModelApp, n);
        } else if (n2 == 1) {
            AdbModelUpdater.fillWithEmail(adbEntry, baseListModelApp, n);
        } else {
            this.log.log(-1601830656, "AdbModelUpdater#updateRecipientSelection(): msgType %1 not supported", (long)n2);
        }
        if (baseListModelApp.getLength() == 1) {
            this.msgApp.getNewMessage().getSelectedRecipientList().addRecipientsTo(new MatchedAddress[]{((AddressSelectionListRow)baseListModelApp.getRow(0)).getMatchedAddress()});
        }
    }

    public void updateRecipientSelection(int n, String string) {
        this.log.log(-2137614336, "AdbModelUpdater#updateRecipientSelection(): updating models for address \"%1\"", (Object)string);
        BaseListModelApp baseListModelApp = this.framework.getHMIService().getBaseListModel(-124641024);
        baseListModelApp.removeAll();
        if (!Strings.isNullOrEmpty(string.trim())) {
            int n2 = ADBModelUtils.getIconTypeForPhoneNumber(0);
            MatchedAddress matchedAddress = new MatchedAddress(string, "", 0L, null);
            baseListModelApp.append(new AddressSelectionListRow(matchedAddress, n2, 0L, n == 1));
            MatchedAddress[] matchedAddressArray = new MatchedAddress[]{matchedAddress};
            this.msgApp.getNewMessage().getSelectedRecipientList().addRecipientsTo(matchedAddressArray);
        }
    }

    public static void fillWithNumber(AdbEntry adbEntry, BaseListModelApp baseListModelApp, int n) {
        baseListModelApp.removeAll();
        if (adbEntry != null && adbEntry.getPhoneData() != null) {
            for (int i2 = 0; i2 < adbEntry.getPhoneData().length; ++i2) {
                PhoneData phoneData;
                if (n != -1 && n != i2 || (phoneData = adbEntry.getPhoneData()[i2]) != null && phoneData.getNumber() != null && phoneData.getNumber().trim().length() == 0) continue;
                MatchedAddress matchedAddress = new MatchedAddress(phoneData.getNumber(), adbEntry.getCombinedName(), adbEntry.getEntryId(), adbEntry.getPersonalData().getContactPicture());
                baseListModelApp.append(new AddressSelectionListRow(matchedAddress, ADBModelUtils.getIconTypeForPhoneNumber(phoneData.getNumberType()), i2, false));
            }
        }
    }

    public static void fillWithEmail(AdbEntry adbEntry, BaseListModelApp baseListModelApp, int n) {
        baseListModelApp.removeAll();
        if (adbEntry != null && adbEntry.getEmailData() != null) {
            for (int i2 = 0; i2 < adbEntry.getEmailData().length; ++i2) {
                EmailData emailData;
                if (n != -1 && n != i2 || (emailData = adbEntry.getEmailData()[i2]) != null && emailData.getEmailAddr() != null && emailData.getEmailAddr().trim().length() == 0) continue;
                MatchedAddress matchedAddress = new MatchedAddress(emailData.getEmailAddr(), adbEntry.getCombinedName(), adbEntry.getEntryId(), adbEntry.getPersonalData().getContactPicture());
                baseListModelApp.append(new AddressSelectionListRow(matchedAddress, 0, i2, true));
            }
        }
    }

    public void fillWithNavLoc(AdbEntry adbEntry, BaseListModelApp baseListModelApp) {
        baseListModelApp.removeAll();
        if (adbEntry != null && adbEntry.getAddressData() != null) {
            for (int i2 = 0; i2 < adbEntry.getAddressData().length; ++i2) {
                AddressData addressData = adbEntry.getAddressData()[i2];
                this.log.log(-2137614336, "AdbModelUpdater#fillWithNavLoc: data: %1", (Object)addressData);
                NaviADBService naviADBService = this.msgApp.getMessagingAdbHandler().getADBNaviService();
                if (naviADBService == null || addressData == null || addressData.navLocation == null || addressData.navLocation.length == 0) continue;
                String[] stringArray = naviADBService.getLocationName(addressData.navLocation);
                this.log.log(-2137614336, "AdbModelUpdater#fillWithNavLoc: name: %1", (Object)stringArray);
                baseListModelApp.append(new NavigationLocationListRow(i2 == 0 ? 2 : 3, stringArray, addressData));
            }
        }
    }

    void updateMessageOptions(AdbEntry adbEntry) {
        this.log.log(-2137614336, "AdbModelUpdater#updateMessageOptions(): adbEntry: %1", (Object)adbEntry);
        this.msgApp.getMessageOptionsManager().responseGetAdbEntry(adbEntry);
        this.fillWithNavLoc(adbEntry, this.framework.getHMIService().getBaseListModel(-57532160));
    }

    public void clearNavDestinations() {
        this.log.log(-2137614336, "[AdbModelUpdater#clearNavDestinations]");
        this.framework.getHMIService().getBaseListModel(-57532160).removeAll();
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new AdbModelUpdater$DiagPlugIn(this)};
    }
}

