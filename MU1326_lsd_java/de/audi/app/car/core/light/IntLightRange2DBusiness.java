/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.Range2DModelHandler;
import de.audi.app.car.common.handler.business.Range2DModelEventBusinessAdapter;
import de.audi.app.car.core.light.IntLightCurrentFocus;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carlight.DSICarLight;

public class IntLightRange2DBusiness
extends Range2DModelEventBusinessAdapter {
    private IntLightCurrentFocus focus;
    protected int[] profileMapping;

    public IntLightRange2DBusiness(IntLightCurrentFocus intLightCurrentFocus, DSICarLight dSICarLight, LogChannel logChannel) {
        super(dSICarLight, logChannel);
        this.focus = intLightCurrentFocus;
    }

    public boolean processKeyTyped(int n, ButtonModelHandler buttonModelHandler) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[IntLightRange2DBusiness#processKeyTyped] Key has been typed");
        }
        Range2DModelHandler range2DModelHandler = (Range2DModelHandler)buttonModelHandler;
        this.getLogChannel().log(1000000, "[IntLightRange2DBusiness#processKeyTyped] last profile: %1 current focus on %2 -> mappedProfile %3", (long)range2DModelHandler.getRange2DModel().getValueX(), (long)this.focus.getFocus(), (long)this.profileMapping[this.focus.getFocus()]);
        if (range2DModelHandler.getRange2DModel().getValueX() != this.focus.getFocus()) {
            this.getLogChannel().log(1000000, "dsi.setIntLightActiveProfile %1", (long)this.focus.getFocus());
            this.getDSICarLight().setIntLightActiveProfile(this.focus.getFocus());
        } else {
            buttonModelHandler.fireEvent();
        }
        return true;
    }

    protected DSICarLight getDSICarLight() {
        return (DSICarLight)this.getDSI();
    }

    public void setProfileMapping(int[] nArray) {
        this.profileMapping = nArray;
    }
}

