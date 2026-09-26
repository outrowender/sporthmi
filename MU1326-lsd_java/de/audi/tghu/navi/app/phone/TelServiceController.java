/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.phone;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.ITelServiceListener;
import de.audi.tghu.navi.app.AbstractNaviServiceComponent;
import de.audi.tghu.navi.app.phone.ITelServiceController;
import de.audi.tghu.navi.app.phone.TelServiceController$1;
import de.audi.tghu.navi.app.phone.TelServiceController$2;
import de.audi.tghu.navi.app.phone.TelServiceController$3;
import de.audi.tghu.navi.app.phone.TelServiceController$4;
import de.audi.tghu.navi.app.phone.TelServiceController$IOperation;
import org.dsi.ifc.global.ResourceLocator;

public class TelServiceController
extends AbstractNaviServiceComponent
implements ITelService,
ITelServiceController {
    static /* synthetic */ Class class$de$audi$atip$phone$ITelService;

    public TelServiceController(LogChannel logChannel) {
        super(logChannel);
    }

    @Override
    public ITelService getTelService() {
        return this;
    }

    @Override
    protected String[] getTrackedService() {
        return new String[]{(class$de$audi$atip$phone$ITelService == null ? (class$de$audi$atip$phone$ITelService = TelServiceController.class$("de.audi.atip.phone.ITelService")) : class$de$audi$atip$phone$ITelService).getName()};
    }

    @Override
    protected boolean trackedServiceAdded(Object object) {
        this.logChannel.log(-2137614336, "TelServiceController#trackedServiceAdded( %1 )", object);
        if (object instanceof ITelService) {
            return true;
        }
        this.logChannel.log(-2137614336, "TelServiceController#trackedServiceAdded() - not an ITelServiceSDS");
        return false;
    }

    @Override
    protected boolean trackedServiceRemoved(Object object) {
        this.logChannel.log(-2137614336, "TelServiceController#trackedServiceRemoved( %1 )", object);
        return object instanceof NaviServiceListener;
    }

    @Override
    protected void onStart() {
        this.logChannel.log(-2137614336, "TelServiceController#onStart( )");
    }

    @Override
    protected void onStop() {
        this.logChannel.log(-2137614336, "TelServiceController#onStop( )");
    }

    private void traverseServices(TelServiceController$IOperation telServiceController$IOperation) {
        Object[] objectArray = this.tracker.getServices();
        if (objectArray != null && objectArray.length > 0) {
            this.logChannel.log(-2137614336, "TelServiceController#traverseListeners - length: %1", (long)objectArray.length);
            if (objectArray.length > 1) {
                this.logChannel.log(-1601830656, "TelServiceController#traverseListeners - More than 1 ITelService! - length: %1", (long)objectArray.length);
            }
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ITelService iTelService = (ITelService)objectArray[i2];
                try {
                    telServiceController$IOperation.execute(iTelService);
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "TelServiceController#traverseListeners - error during update. - %1", (Object)super.getClass().getName());
                }
            }
        } else {
            this.logChannel.log(-2137614336, "TelServiceController#traverseListeners - no services");
        }
    }

    @Override
    public void dialNumber(String string, ITelServiceListener iTelServiceListener, boolean bl) {
        this.logChannel.log(-2137614336, "TelServiceController#dialNumber - number: %1", (Object)string);
        this.traverseServices(new TelServiceController$1(this, string, iTelServiceListener, bl));
    }

    @Override
    public void dialNumberFromADBEntry(String string, String string2, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, ITelServiceListener iTelServiceListener, boolean bl) {
        this.traverseServices(new TelServiceController$2(this, string, string2, s, s2, l, resourceLocator, n, n2, iTelServiceListener, bl));
    }

    @Override
    public void prepareDialing(String string, ITelServiceListener iTelServiceListener) {
        this.traverseServices(new TelServiceController$3(this, string, iTelServiceListener));
    }

    @Override
    public void prepareDialing(String string, String string2, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, ITelServiceListener iTelServiceListener) {
        this.traverseServices(new TelServiceController$4(this, string, string2, s, s2, l, resourceLocator, n, n2, iTelServiceListener));
    }

    @Override
    public void dialNumber(ITelCallSession iTelCallSession, boolean bl) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

