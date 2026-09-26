/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.other;

import de.audi.app.car.common.ap.IActionProxyListener;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.other.AbstractMenuStateComponent;
import java.util.Map;

public class MenuStateComponentEvo
extends AbstractMenuStateComponent
implements IActionProxyListener {
    public MenuStateComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(1, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(2, this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(1, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(2, this);
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        this.getLogChannel().log(1078071040, "[MenuStateComponentEvo#actionProxyCallPerformed] id='%1'", (long)n);
        switch (n) {
            case 1: {
                Boolean bl = (Boolean)map.get("ENTERED");
                if (bl == null) {
                    this.getLogChannel().log(1000, "[MenuStateComponentEvo#actionProxyCallPerformed] 'AP_CAR_ENTERED'; parameter 'ENTERED' is no boolean or not available");
                    break;
                }
                this.setCarMenusVisible(bl);
                break;
            }
            case 2: {
                Boolean bl = (Boolean)map.get("ENTERED");
                if (bl == null) {
                    this.getLogChannel().log(1000, "[MenuStateComponentEvo#actionProxyCallPerformed] 'AP_PHEV_GOODBYE_ENTERED'; parameter 'ENTERED' is no boolean or not available");
                    break;
                }
                this.setPHEVGoodbyeVisible(bl);
                break;
            }
            default: {
                this.getLogChannel().log(-1601830656, "[MenuStateComponentEvo#actionProxyCallPerformed] methodID not supported");
            }
        }
    }

    @Override
    public int getID() {
        return 12;
    }
}

