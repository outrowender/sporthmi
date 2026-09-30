/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSubstringSearchListener;
import de.audi.tghu.navi.app.addressinput.poi.personal.PersonalPoiHandler;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiDSIHandler
implements IPoiSubstringSearchListener {
    private static final int MINIMUM_AMOUNT_OF_VISIBLE_ITEMS = 5;
    private static final int TIME_DELAY_BETWEEN_UPDATES = 200;
    private static final int ITEM_DELAY_BETWEEN_UPDATES = 20;
    private IPoiManager poiManager;
    private PoiSearchAreaSequence poiSearchAreaHandler;
    private PersonalPoiHandler personalPOIHandler;
    private final NavigationEnv env;
    private long timestamp;
    private final LogChannel logChannel;

    public PoiDSIHandler(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        if (valueListStatus == null) {
            this.logChannel.log(100000, "PoiDSIHandler#updatePoiSubstringSearchStatus() - substringSearchStatus is null");
            return;
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "PoiDSIHandler#updatePoiSubstringSearchStatus(%1)", (Object)valueListStatus);
        }
        if (this.isInitialSearchStatus(valueListStatus)) {
            this.env.getContainer().setPoiSubstringSearchStatus(valueListStatus);
        }
        boolean bl = this.commitUpdate(valueListStatus);
        boolean bl2 = this.restartRRD(valueListStatus);
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "PoiDSIHandler#updatePoiSubstringSearchStatus - commitUpdate=%1, restartRRD = %2", bl, bl2);
        }
        if (bl) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "PoiDSIHandler#updatePoiSubstringSearchStatus() --> Update model");
            }
            this.timestamp = System.currentTimeMillis();
            this.env.getContainer().setPoiSubstringSearchStatus(valueListStatus);
            this.poiManager.updatePoiSubstringSearchStatus(valueListStatus);
            if (bl2) {
                this.poiManager.allowRestartOfRRDCalculation();
            }
        }
    }

    private boolean isInitialSearchStatus(ValueListStatus valueListStatus) {
        return valueListStatus.status == 2 && valueListStatus.distance == 0 && valueListStatus.numberOfAvailableItems == 0;
    }

    private boolean restartRRD(ValueListStatus valueListStatus) {
        int n = this.env.getContainer().getPoiSubstringSearchStatus().getNumberOfAvailableItems();
        int n2 = valueListStatus.getNumberOfAvailableItems();
        return n < 10 && n < n2;
    }

    private boolean commitUpdate(ValueListStatus valueListStatus) {
        ValueListStatus valueListStatus2 = this.env.getContainer().getPoiSubstringSearchStatus();
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "PoiDSIHandler#commitUpdate() --> substringSearchStatusCONTAINER = %1", (Object)valueListStatus2);
            this.logChannel.log(100000000, "PoiDSIHandler#commitUpdate() --> substringSearchStatusUPDATE    = %1", (Object)valueListStatus);
        }
        if (valueListStatus2 == null) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "PoiDSIHandler#commitUpdate() --> update because no status in responseContainer");
            }
            return true;
        }
        if (valueListStatus2.getStatus() == 3 && valueListStatus.getStatus() == 3) {
            this.logChannel.log(1000000, "PoiDSIHandler#commitUpdate - received search status POISEARCHSTATUS_FINISHED although the current status was already set to POISEARCHSTATUS_FINISHED. --> hmi should just receive searchFinished ONCE for each search");
        }
        if (valueListStatus.getStatus() == 3) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "PoiDSIHandler#commitUpdate() --> update because searchStatus is Finished");
            }
            return true;
        }
        if (valueListStatus2.getNumberOfAvailableItems() < 5) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "PoiDSIHandler#commitUpdate() --> update because we had less than 5 items before");
            }
            return true;
        }
        if (System.currentTimeMillis() - this.timestamp > 200L) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "PoiDSIHandler#commitUpdate() --> update because more than 200 milliseconds have past since last update");
            }
            return true;
        }
        if (valueListStatus.getNumberOfAvailableItems() - valueListStatus2.getNumberOfAvailableItems() > 20) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "PoiDSIHandler#commitUpdate() --> update because we have more than 20 new results");
            }
            return true;
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "PoiDSIHandler#commitUpdate() --> no Update (improve widget performance)");
        }
        return false;
    }

    public void setPoiManager(IPoiManager iPoiManager) {
        this.poiManager = iPoiManager;
    }

    public void setPersonalPoiHandler(PersonalPoiHandler personalPoiHandler) {
        this.personalPOIHandler = personalPoiHandler;
    }

    public void setPoiSearchAreaHandler(PoiSearchAreaSequence poiSearchAreaSequence) {
        this.poiSearchAreaHandler = poiSearchAreaSequence;
    }

    public void updateRgActive(boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "PoiDSIHandler#updateRgActive - rgActive=%1", bl);
        }
        if (this.poiManager != null) {
            this.poiManager.updateRgActive(bl);
        }
        if (this.poiSearchAreaHandler != null) {
            this.poiSearchAreaHandler.updateRgActive(bl);
        }
    }

    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray) {
        if (bapManeuverDescriptorArray == null) {
            return;
        }
        for (int i2 = 0; i2 < bapManeuverDescriptorArray.length; ++i2) {
            BapManeuverDescriptor bapManeuverDescriptor = bapManeuverDescriptorArray[i2];
            if (bapManeuverDescriptor == null || bapManeuverDescriptor.getMainElement() != 10) continue;
            this.logChannel.log(10000000, "PoiDSIHandler#updateBapManeuverDescriptor() - route recalculated");
            if (this.poiManager == null) break;
            this.poiManager.cancelAlongRouteSearch(true);
            break;
        }
    }

    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray) {
        if (this.personalPOIHandler != null) {
            this.personalPOIHandler.updateEtcAvailablePersonalPOIDataBases(navDataBaseArray);
        }
    }

    public void updatePersonalPOISearchStatus(int n) {
        if (this.personalPOIHandler != null) {
            this.personalPOIHandler.updatePersonalPOISearchStatus(n);
        }
    }
}

