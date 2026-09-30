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
import org.dsi.ifc.global.ResourceLocator;

public class TelServiceController
extends AbstractNaviServiceComponent
implements ITelService,
ITelServiceController {
    static /* synthetic */ Class class$de$audi$atip$phone$ITelService;

    public TelServiceController(LogChannel logChannel) {
        super(logChannel);
    }

    public ITelService getTelService() {
        return this;
    }

    protected String[] getTrackedService() {
        return new String[]{(class$de$audi$atip$phone$ITelService == null ? (class$de$audi$atip$phone$ITelService = TelServiceController.class$("de.audi.atip.phone.ITelService")) : class$de$audi$atip$phone$ITelService).getName()};
    }

    protected boolean trackedServiceAdded(Object object) {
        this.logChannel.log(10000000, "TelServiceController#trackedServiceAdded( %1 )", object);
        if (object instanceof ITelService) {
            return true;
        }
        this.logChannel.log(10000000, "TelServiceController#trackedServiceAdded() - not an ITelServiceSDS");
        return false;
    }

    protected boolean trackedServiceRemoved(Object object) {
        this.logChannel.log(10000000, "TelServiceController#trackedServiceRemoved( %1 )", object);
        return object instanceof NaviServiceListener;
    }

    protected void onStart() {
        this.logChannel.log(10000000, "TelServiceController#onStart( )");
    }

    protected void onStop() {
        this.logChannel.log(10000000, "TelServiceController#onStop( )");
    }

    private void traverseServices(IOperation iOperation) {
        Object[] objectArray = this.tracker.getServices();
        if (objectArray != null && objectArray.length > 0) {
            this.logChannel.log(10000000, "TelServiceController#traverseListeners - length: %1", (long)objectArray.length);
            if (objectArray.length > 1) {
                this.logChannel.log(100000, "TelServiceController#traverseListeners - More than 1 ITelService! - length: %1", (long)objectArray.length);
            }
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ITelService iTelService = (ITelService)objectArray[i2];
                try {
                    iOperation.execute(iTelService);
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "TelServiceController#traverseListeners - error during update. - %1", (Object)iTelService.getClass().getName());
                }
            }
        } else {
            this.logChannel.log(10000000, "TelServiceController#traverseListeners - no services");
        }
    }

    public void dialNumber(final String string, final ITelServiceListener iTelServiceListener, final boolean bl) {
        this.logChannel.log(10000000, "TelServiceController#dialNumber - number: %1", (Object)string);
        this.traverseServices(new IOperation(){

            public void execute(ITelService iTelService) {
                iTelService.dialNumber(string, iTelServiceListener, bl);
            }
        });
    }

    public void dialNumberFromADBEntry(final String string, final String string2, final short s, final short s2, final long l, final ResourceLocator resourceLocator, final int n, final int n2, final ITelServiceListener iTelServiceListener, final boolean bl) {
        this.traverseServices(new IOperation(){

            public void execute(ITelService iTelService) {
                iTelService.dialNumberFromADBEntry(string, string2, s, s2, l, resourceLocator, n, n2, iTelServiceListener, bl);
            }
        });
    }

    public void prepareDialing(final String string, final ITelServiceListener iTelServiceListener) {
        this.traverseServices(new IOperation(){

            public void execute(ITelService iTelService) {
                iTelService.prepareDialing(string, iTelServiceListener);
            }
        });
    }

    public void prepareDialing(final String string, final String string2, final short s, final short s2, final long l, final ResourceLocator resourceLocator, final int n, final int n2, final ITelServiceListener iTelServiceListener) {
        this.traverseServices(new IOperation(){

            public void execute(ITelService iTelService) {
                iTelService.prepareDialing(string, string2, s, s2, l, resourceLocator, n, n2, iTelServiceListener);
            }
        });
    }

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

    private static interface IOperation {
        public void execute(ITelService var1);
    }
}

