/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.profile;

import de.audi.app.connectivity.core.IApplicationComponent;
import de.audi.app.data.core.profile.AbstractDataProfile;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.networking.CDataProfile;

class ProfileList
implements IApplicationComponent,
BaseListModelListener {
    private static final int NUM_COLUMNS;
    private static final int ID_PROFILE_NAME;
    private static final int ID_APN;
    private static final int ID_PROVIDER;
    private final AbstractDataProfile profile;
    private CDataProfile[] availableProfiles;
    private final BaseListModelApp profileList;

    ProfileList(AbstractDataProfile abstractDataProfile, BaseListModelApp baseListModelApp) {
        this.profile = abstractDataProfile;
        this.profileList = baseListModelApp;
    }

    void updateProfiles(CDataProfile[] cDataProfileArray) {
        this.availableProfiles = cDataProfileArray;
        if (cDataProfileArray != null) {
            this.profileList.removeAll();
            for (int i2 = 0; i2 < cDataProfileArray.length; ++i2) {
                EvoListRow evoListRow = new EvoListRow(i2, 3);
                CDataProfile cDataProfile = cDataProfileArray[i2];
                evoListRow.setText(0, cDataProfile != null ? cDataProfile.dataProfileName : "");
                evoListRow.setText(1, cDataProfile != null ? cDataProfile.dataAPN : "");
                evoListRow.setText(2, cDataProfile != null ? cDataProfile.provider : "");
                this.profileList.append(evoListRow);
            }
        }
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (n == this.profileList.getID() && this.availableProfiles != null) {
            this.profile.profileSelected(this.availableProfiles[n2]);
            this.profileList.fireEvent(n4);
        }
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void init() {
        this.profileList.setListener(this);
    }

    @Override
    public void deinit() {
        this.profileList.resetListener();
        this.profileList.removeAll();
        this.availableProfiles = null;
    }
}

