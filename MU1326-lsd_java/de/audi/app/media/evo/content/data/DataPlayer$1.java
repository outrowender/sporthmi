/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.evo.content.data.DataPlayer;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.phone.ITelServiceMedia;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class DataPlayer$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ DataPlayer this$0;

    DataPlayer$1(DataPlayer dataPlayer) {
        this.this$0 = dataPlayer;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        DataPlayer.access$002(this.this$0, null);
        ChoiceModelApp choiceModelApp = this.this$0.getChoiceModel(-871431424);
        if (choiceModelApp != null) {
            choiceModelApp.setValue(0);
        } else {
            DataPlayer.access$100(this.this$0).main().log(-1601830656, "[%1.removedService] Failed to reset choice model: 'DATA_PLAYER_RINGTONE_AVAILABLE_CHOICE'.", (Object)"DataPlayer");
        }
        this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        DataPlayer.access$200(this.this$0).main().log(1078071040, "[%1.addingService] Phone service found.", (Object)"DataPlayer");
        DataPlayer.access$002(this.this$0, (ITelServiceMedia)this.this$0.getTerminal().getServiceManager().getService(serviceReference));
        this.this$0.getChoiceModel(-871431424).setValue(1);
        return DataPlayer.access$000(this.this$0);
    }
}

