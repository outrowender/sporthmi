/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rse;

import de.audi.atip.rse.AbstractRSEConnection;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.Criteria;
import de.audi.tghu.navi.app.rse.RSEManager;
import de.audi.tghu.navi.app.rse.RSESyncCriteria;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

class RSEFrontManager
extends RSEManager {
    private NavLocation transferedLocation;
    private Criteria transferedCriteria;

    protected RSEFrontManager(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    protected void setListeners() {
        this.env.getButtonModel(605881856).setButtonListener(this);
        this.env.getButtonModel(589104640).setButtonListener(this);
    }

    @Override
    public void decodeLocationStream(byte[] byArray, Criteria criteria) {
        this.logChannel.log(-2137614336, "RSEFrontManager#decodeLocationStream( %1, %2 )", (Object)byArray, (Object)criteria);
    }

    private void handleTransferedLocation(NavLocation navLocation, Criteria criteria) {
        this.logChannel.log(-2137614336, "RSEFrontManager#handleTransferedLocation( %1, %2 )", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)criteria);
        if (navLocation != null && navLocation.isPositionValid()) {
            this.transferedLocation = navLocation;
            this.transferedCriteria = criteria;
        } else {
            this.logChannel.log(-1601830656, "RSEFrontManager#handleTransferedLocation() - failed to handle transfered location. Location is not navigable!");
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "RSEFrontManager#keyPressed( %1 )", (long)n);
        switch (n) {
            case 400676: {
                this.env.fireTranslatedSMEvent(n3, 1);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400675: {
                this.env.fireTranslatedSMEvent(n3, 1);
                this.env.fireModelEvent(n, n3);
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "RSEFrontManager#keyPressed() - unknown model id: %1!", (long)n);
            }
        }
    }

    private void startRSEGuidance(int n) {
        this.logChannel.log(-2137614336, "RSEFrontManager#startRSEGuidance() - transferedCriteria: %1", (Object)this.transferedCriteria);
    }

    @Override
    public void setRSEConnection(AbstractRSEConnection abstractRSEConnection) {
        super.setRSEConnection(abstractRSEConnection);
        if (abstractRSEConnection != null) {
            this.logChannel.log(-2137614336, "RSEFrontManager#setRSEConnection() - connection established to rear unit. Sync criteria..");
        }
    }

    @Override
    public void syncCriteria(Criteria criteria) {
        this.logChannel.log(-2137614336, "RSEFrontManager#syncCriteria( %1 )", (Object)criteria);
        if (criteria != null) {
            this.sendCommand(new RSESyncCriteria(criteria));
        } else {
            this.logChannel.log(-1601830656, "RSEFrontManager#syncCriteria() - failed to sync criteria. Criteria is null!");
        }
    }

    @Override
    public CommandList prepareLocationTransfer(NavLocation navLocation, boolean bl) {
        this.logChannel.log(-1601830656, "RSEFrontManager#prepareLocationTransfer() - location transfer not supported on front unit!");
        return null;
    }

    @Override
    public CommandList prepareRouteTransfer(Route route) {
        this.logChannel.log(-1601830656, "RSEFrontManager#prepareLocationTransfer() - route transfer not supported on front unit!");
        return null;
    }
}

