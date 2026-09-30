/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.interapp;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.interapp.phone.ITelCallInformation;
import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.atip.phone.ITelServiceListener;
import org.dsi.ifc.global.ResourceLocator;

public class PhoneServiceImpl
extends AbstractPhoneServiceImpl {
    public PhoneServiceImpl(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
    }

    public String getNumberSpellerContent() {
        String string = this.getSpellerModel(300680).getText();
        this.log.log(1000000, "[PhoneServiceImpl#getNumberSpellerContent] returning %1", (Object)string);
        return string;
    }

    public void setNumberSpeller(String string) {
        this.log.log(1000000, "[PhoneServiceImpl#setNumberSpeller] value=%1", (Object)string);
        this.getSpellerModel(300680).setText(string);
        this.getButtonModel(300402).setStatus(string != null && string.length() > 0 && string.length() <= 40 ? 1 : 0);
    }

    public byte freezeDynamicLists() {
        byte by = 0;
        this.log.log(1000000, "[PhoneServiceImpl#freezeDynamicLists] returning value %1", (long)by);
        return by;
    }

    public byte unfreezeDynamicLists() {
        byte by = 0;
        this.log.log(1000000, "[PhoneServiceImpl#unfreezeDynamicLists] returning value %1", (long)by);
        return by;
    }

    public byte fillCallstackPickList(SDSListEntry[] sDSListEntryArray) {
        this.fillPickListModel(sDSListEntryArray);
        return 0;
    }

    public byte fillFavoritePickList(SDSListEntry[] sDSListEntryArray) {
        this.fillPickListModel(sDSListEntryArray);
        return 0;
    }

    public void prepareDialing(String string, String string2, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, ITelServiceListener iTelServiceListener) {
    }

    public void prepareDialing(String string, ITelServiceListener iTelServiceListener) {
    }

    public void dialNumber(final ITelCallSession iTelCallSession, boolean bl) {
        this.checkIfJumpToPhoneWillOccurAndInformEntDrawer(bl);
        ITelCallSession iTelCallSession2 = new ITelCallSession(){

            public void updateCallInformation(ITelCallInformation iTelCallInformation, int n) {
                iTelCallSession.updateCallInformation(iTelCallInformation, n);
            }

            public void onClose() {
                ((ITelEvoApplication)PhoneServiceImpl.this.getApplication()).getNewEntertainmentDrawerController().resetdialingNumberJumpToPhoneFlag();
                iTelCallSession.onClose();
            }

            public void onActive(ITelCallControl iTelCallControl) {
                iTelCallSession.onActive(iTelCallControl);
            }

            public String getTelephoneNumber() {
                return iTelCallSession.getTelephoneNumber();
            }

            public int getCallType() {
                return iTelCallSession.getCallType();
            }
        };
        super.dialNumber(iTelCallSession2, bl);
    }

    public void dialNumber(String string, final ITelServiceListener iTelServiceListener, boolean bl) {
        this.checkIfJumpToPhoneWillOccurAndInformEntDrawer(bl);
        ITelServiceListener iTelServiceListener2 = new ITelServiceListener(){

            public void dialNumberResponse(int n) {
                if (n != 0) {
                    ((ITelEvoApplication)PhoneServiceImpl.this.getApplication()).getNewEntertainmentDrawerController().resetdialingNumberJumpToPhoneFlag();
                }
                if (iTelServiceListener != null) {
                    iTelServiceListener.dialNumberResponse(n);
                }
            }
        };
        super.dialNumber(string, iTelServiceListener2, bl);
    }

    public void dialNumberFromADBEntry(String string, String string2, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, final ITelServiceListener iTelServiceListener, boolean bl) {
        this.checkIfJumpToPhoneWillOccurAndInformEntDrawer(bl);
        ITelServiceListener iTelServiceListener2 = new ITelServiceListener(){

            public void dialNumberResponse(int n) {
                if (n != 0) {
                    ((ITelEvoApplication)PhoneServiceImpl.this.getApplication()).getNewEntertainmentDrawerController().resetdialingNumberJumpToPhoneFlag();
                }
                if (iTelServiceListener != null) {
                    iTelServiceListener.dialNumberResponse(n);
                }
            }
        };
        super.dialNumberFromADBEntry(string, string2, s, s2, l, resourceLocator, n, n2, iTelServiceListener2, bl);
    }

    private void checkIfJumpToPhoneWillOccurAndInformEntDrawer(boolean bl) {
        if (bl) {
            ((ITelEvoApplication)this.getApplication()).getNewEntertainmentDrawerController().dialingNumberJumpToPhoneWillOccur();
        }
    }

    private void fillPickListModel(SDSListEntry[] sDSListEntryArray) {
        int n = sDSListEntryArray.length;
        BaseListModelApp baseListModelApp = this.getSDSPickListModel();
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        for (int i2 = 0; i2 < n; ++i2) {
            EvoListRow evoListRow = new EvoListRow(i2, 2);
            evoListRow.setLong(0, sDSListEntryArray[i2].getId());
            evoListRow.setText(1, sDSListEntryArray[i2].getName());
            baseListModelApp2.append(evoListRow);
        }
        baseListModelApp.update(baseListModelApp2);
    }

    public boolean isHfpPhoneConnected(boolean bl) {
        return false;
    }

    public boolean isBluetoothPhoneConnected() {
        return false;
    }
}

