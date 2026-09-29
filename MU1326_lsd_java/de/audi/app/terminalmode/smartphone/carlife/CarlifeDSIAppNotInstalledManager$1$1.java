/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager$1;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager$1$1$1;
import de.audi.app.terminalmode.smartphone.carlife.ResourceUpdate;
import de.audi.app.terminalmode.smartphone.carlife.UpdateCarlifeModes;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.Generics;

class CarlifeDSIAppNotInstalledManager$1$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ CarlifeDSIAppNotInstalledManager$1 this$1;

    CarlifeDSIAppNotInstalledManager$1$1(CarlifeDSIAppNotInstalledManager$1 carlifeDSIAppNotInstalledManager$1, String string) {
        this.this$1 = carlifeDSIAppNotInstalledManager$1;
        super(string);
    }

    @Override
    public void run() {
        GCopyOnWriteList gCopyOnWriteList = Generics.newCopyOnWriteArrayList();
        gCopyOnWriteList.add(new ResourceUpdate(Resource.NOTIFICATION, ResourceOwner.MAINUNIT));
        GCopyOnWriteList gCopyOnWriteList2 = Generics.newCopyOnWriteArrayList();
        CarlifeDSIAppNotInstalledManager.access$200(CarlifeDSIAppNotInstalledManager$1.access$100(this.this$1)).getCommandListHelper().create().addSingle(new UpdateCarlifeModes(CarlifeDSIAppNotInstalledManager.access$200(CarlifeDSIAppNotInstalledManager$1.access$100(this.this$1)), gCopyOnWriteList, gCopyOnWriteList2, CarlifeDSIAppNotInstalledManager.access$300(CarlifeDSIAppNotInstalledManager$1.access$100(this.this$1)), new CarlifeDSIAppNotInstalledManager$1$1$1(this))).execute("CarlifeDSIAppNotInstalledManager.updateCarlifeModes");
        CarlifeDSIAppNotInstalledManager.access$002(CarlifeDSIAppNotInstalledManager$1.access$100(this.this$1), null);
    }
}

