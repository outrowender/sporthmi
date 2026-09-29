/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.guidance;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.ISimpleDetourModelAccess;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public class SimpleDetourModelAccess
implements ISimpleDetourModelAccess {
    private NavigationEnv env;

    public SimpleDetourModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    @Override
    public void reset(int n) {
        this.env.getRangeModel(1562183168).setLimits(0, n, 1);
        this.env.getRangeModel(1562183168).setValue(0);
    }

    @Override
    public void detourAdded(boolean bl) {
        this.env.getChoiceModel(1830618624).setValue(bl ? 1 : 0);
    }

    @Override
    public void refreshDistanceTextfield(int n) {
        Buffer buffer = new Buffer();
        buffer.append(Util.formatDistance(n, 3));
        this.env.getTextfieldModel(1578960384).setText1(buffer.toString());
    }

    @Override
    public void updateBlockingAvailable(boolean bl) {
        this.env.getChoiceModel(-1558247936).setValue(bl ? 1 : 0);
    }
}

