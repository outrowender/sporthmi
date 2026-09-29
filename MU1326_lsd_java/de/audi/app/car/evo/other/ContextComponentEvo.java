/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.other;

import de.audi.app.car.common.ap.IActionProxyListener;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.other.AbstractContextComponent;
import java.util.Map;

public class ContextComponentEvo
extends AbstractContextComponent
implements IActionProxyListener {
    public ContextComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(20, this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(20, this);
    }

    @Override
    protected void initVisibility() {
    }

    @Override
    protected void deinitVisibility() {
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        this.getLogChannel().log(1078071040, "[ContextComponentEvo#actionProxyCallPerformed] id='%1'", (long)n);
        switch (n) {
            case 20: {
                Integer n2 = (Integer)map.get("CONTEXT");
                if (n2 == null) {
                    this.getLogChannel().log(1000, "[ContextComponentEvo#actionProxyCallPerformed] 'AP_CAR_EVO_ID_SET_CONTEXT'; parameter 'CONTEXT' is no integer or not available");
                    break;
                }
                this.setCarContext(n2);
                break;
            }
            default: {
                this.getLogChannel().log(-1601830656, "[ContextComponentEvo#actionProxyCallPerformed] methodID not supported");
            }
        }
    }

    @Override
    public int getID() {
        return 51;
    }
}

