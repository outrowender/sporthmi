/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager$3$1;
import de.audi.app.terminalmode.smartphone.carlife.ResourceUpdate;
import de.audi.app.terminalmode.smartphone.carlife.UpdateCarlifeModes;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.Generics;

class CarlifeDSIAppNotInstalledManager$3
implements Consumer {
    private final /* synthetic */ CarlifeDSIAppNotInstalledManager this$0;

    CarlifeDSIAppNotInstalledManager$3(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager) {
        this.this$0 = carlifeDSIAppNotInstalledManager;
    }

    public void accept(Boolean bl) {
        if (bl.booleanValue()) {
            GCopyOnWriteList gCopyOnWriteList = Generics.newCopyOnWriteArrayList();
            gCopyOnWriteList.add(new ResourceUpdate(Resource.NOTIFICATION, ResourceOwner.DEVICE));
            GCopyOnWriteList gCopyOnWriteList2 = Generics.newCopyOnWriteArrayList();
            CarlifeDSIAppNotInstalledManager.access$200(this.this$0).getCommandListHelper().create().addSingle(new UpdateCarlifeModes(CarlifeDSIAppNotInstalledManager.access$200(this.this$0), gCopyOnWriteList, gCopyOnWriteList2, CarlifeDSIAppNotInstalledManager.access$300(this.this$0), new CarlifeDSIAppNotInstalledManager$3$1(this))).execute("CarlifeDSIAppNotInstalledManager.updateCarlifeModes");
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Boolean)object);
    }
}

