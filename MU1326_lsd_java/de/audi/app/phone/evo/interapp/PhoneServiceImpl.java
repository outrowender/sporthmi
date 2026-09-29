/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.interapp;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.interapp.PhoneServiceImpl$1;
import de.audi.app.phone.evo.interapp.PhoneServiceImpl$2;
import de.audi.app.phone.evo.interapp.PhoneServiceImpl$3;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.atip.phone.ITelServiceListener;
import org.dsi.ifc.global.ResourceLocator;

public class PhoneServiceImpl
extends AbstractPhoneServiceImpl {
    public PhoneServiceImpl(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
    }

    @Override
    public String getNumberSpellerContent() {
        String string = this.getSpellerModel(-2003434496).getText();
        this.log.log(1078071040, "[PhoneServiceImpl#getNumberSpellerContent] returning %1", (Object)string);
        return string;
    }

    @Override
    public void setNumberSpeller(String string) {
        this.log.log(1078071040, "[PhoneServiceImpl#setNumberSpeller] value=%1", (Object)string);
        this.getSpellerModel(-2003434496).setText(string);
        this.getButtonModel(1922368512).setStatus(string != null && string.length() > 0 && string.length() <= 40 ? 1 : 0);
    }

    @Override
    public byte freezeDynamicLists() {
        byte by = 0;
        this.log.log(1078071040, "[PhoneServiceImpl#freezeDynamicLists] returning value %1", (long)by);
        return by;
    }

    @Override
    public byte unfreezeDynamicLists() {
        byte by = 0;
        this.log.log(1078071040, "[PhoneServiceImpl#unfreezeDynamicLists] returning value %1", (long)by);
        return by;
    }

    @Override
    public byte fillCallstackPickList(SDSListEntry[] sDSListEntryArray) {
        this.fillPickListModel(sDSListEntryArray);
        return 0;
    }

    @Override
    public byte fillFavoritePickList(SDSListEntry[] sDSListEntryArray) {
        this.fillPickListModel(sDSListEntryArray);
        return 0;
    }

    @Override
    public void prepareDialing(String string, String string2, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, ITelServiceListener iTelServiceListener) {
    }

    @Override
    public void prepareDialing(String string, ITelServiceListener iTelServiceListener) {
    }

    @Override
    public void dialNumber(ITelCallSession iTelCallSession, boolean bl) {
        this.checkIfJumpToPhoneWillOccurAndInformEntDrawer(bl);
        PhoneServiceImpl$1 phoneServiceImpl$1 = new PhoneServiceImpl$1(this, iTelCallSession);
        super.dialNumber(phoneServiceImpl$1, bl);
    }

    @Override
    public void dialNumber(String string, ITelServiceListener iTelServiceListener, boolean bl) {
        this.checkIfJumpToPhoneWillOccurAndInformEntDrawer(bl);
        PhoneServiceImpl$2 phoneServiceImpl$2 = new PhoneServiceImpl$2(this, iTelServiceListener);
        super.dialNumber(string, phoneServiceImpl$2, bl);
    }

    @Override
    public void dialNumberFromADBEntry(String string, String string2, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, ITelServiceListener iTelServiceListener, boolean bl) {
        this.checkIfJumpToPhoneWillOccurAndInformEntDrawer(bl);
        PhoneServiceImpl$3 phoneServiceImpl$3 = new PhoneServiceImpl$3(this, iTelServiceListener);
        super.dialNumberFromADBEntry(string, string2, s, s2, l, resourceLocator, n, n2, phoneServiceImpl$3, bl);
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

    @Override
    public boolean isHfpPhoneConnected(boolean bl) {
        return false;
    }

    @Override
    public boolean isBluetoothPhoneConnected() {
        return false;
    }

    static /* synthetic */ ITelApplication access$000(PhoneServiceImpl phoneServiceImpl) {
        return phoneServiceImpl.getApplication();
    }

    static /* synthetic */ ITelApplication access$100(PhoneServiceImpl phoneServiceImpl) {
        return phoneServiceImpl.getApplication();
    }

    static /* synthetic */ ITelApplication access$200(PhoneServiceImpl phoneServiceImpl) {
        return phoneServiceImpl.getApplication();
    }
}

