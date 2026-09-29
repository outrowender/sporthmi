/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.guidance;

import de.audi.app.navi.evo.guidance.EvoVehicleHmiListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.FavLocationVehicleHandler;

public class EvoVehicleHmiListenerAsia
extends EvoVehicleHmiListener {
    public EvoVehicleHmiListenerAsia(NavigationEnv navigationEnv, FavLocationVehicleHandler favLocationVehicleHandler) {
        super(navigationEnv, favLocationVehicleHandler);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "EvoVehicleHmiListener#keyPressed( %1 )", (long)n);
        switch (n) {
            case 401504: {
                this.vehicle.addToContact(n, n3);
                break;
            }
            case 401505: {
                this.vehicle.saveAsFavorite(n, n3);
                break;
            }
            default: {
                this.logChannel.log(10000, "EvoVehicleHmiListener#keyPressed() - unhandled model: %1", (long)n);
            }
        }
    }
}

