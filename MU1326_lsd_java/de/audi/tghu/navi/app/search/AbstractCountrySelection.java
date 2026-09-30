/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.search.CountrySelectionState;
import de.audi.tghu.navi.app.search.ICountrySelection;
import de.audi.tghu.navi.app.search.ICountrySelectionView;
import org.dsi.ifc.search.Country;

public abstract class AbstractCountrySelection
implements ICountrySelection {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    protected ICountrySelectionView countrySelectionView;
    protected final ICommandListFactory commandListFactory;

    public AbstractCountrySelection(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getSearchLogChannel();
        this.commandListFactory = iCommandListFactory;
    }

    public void updateCountriesList(Country[] countryArray) {
        this.countrySelectionView.updateCountriesList(countryArray);
        this.loadPersistentState();
    }

    public void loadPersistentState() {
        this.logChannel.log(10000000, "AbstractCountrySelection#loadPersistentState()");
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        CountrySelectionState countrySelectionState = new CountrySelectionState(iStorageAccess, this.logChannel);
        countrySelectionState.readAndDeserialize();
        this.countrySelectionView.restorePersistedSelection(countrySelectionState.getCountryCode(), countrySelectionState.getCountryIconId());
    }

    public void savePersistentState() {
        this.logChannel.log(10000000, "AbstractCountrySelection#savePersistentState()");
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        CountrySelectionState countrySelectionState = new CountrySelectionState(iStorageAccess, this.logChannel);
        countrySelectionState.setCountryCode(this.countrySelectionView.getSelectedRowCode());
        countrySelectionState.setCountryIconId(this.countrySelectionView.getSelectedCountryIconId());
        countrySelectionState.serializeAndWrite();
    }

    public String[] getActiveCountries() {
        if (this.countrySelectionView.getSelectedRowCode() == "XX") {
            return this.countrySelectionView.getAllCountryCodes();
        }
        return new String[]{this.countrySelectionView.getSelectedRowCode()};
    }

    public String[] getAllCountries() {
        return this.countrySelectionView.getAllCountryCodes();
    }

    public void resetSettings() {
        this.logChannel.log(10000000, "AbstractCountrySelection#resetSettings()");
        this.countrySelectionView.restoreDefaultSelection();
        this.savePersistentState();
    }
}

