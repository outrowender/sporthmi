/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.guidance;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.FavLocationVehicleHandler;

public class EvoVehicleHmiListener
implements ButtonListener {
    protected final FavLocationVehicleHandler vehicle;
    protected final NavigationEnv env;
    protected LogChannel logChannel;

    public EvoVehicleHmiListener(NavigationEnv navigationEnv, FavLocationVehicleHandler favLocationVehicleHandler) {
        this.env = navigationEnv;
        this.vehicle = favLocationVehicleHandler;
        this.logChannel = navigationEnv.getLogChannel();
        this.setupListeners();
    }

    private void setupListeners() {
        this.env.getButtonModel(0x60200600).setButtonListener(this);
        this.env.getButtonModel(1629488640).setButtonListener(this);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "EvoVehicleHmiListener#keyPressed( %1 )", (long)n);
        switch (n) {
            case 401504: {
                this.vehicle.addToContact(n, n3);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401505: {
                this.vehicle.saveAsFavorite(n, n3);
                this.env.fireModelEvent(n, n3);
                break;
            }
            default: {
                this.logChannel.log(10000, "EvoVehicleHmiListener#keyPressed() - unhandled model: %1", (long)n);
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

