/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.joker;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.core.joker.AbstractJokerKeyComponent;
import de.audi.app.car.core.joker.AbstractJokerKeyComponent$1;
import de.audi.atip.hmi.intercommunication.JokerKeyMeaning;
import de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFL;
import de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFLListener;
import java.util.Iterator;

class AbstractJokerKeyComponent$CombiMFLHandler
implements CombiBAPServiceMFLListener,
CarServiceTrackerListener {
    private CombiBAPServiceMFL combiBAPServiceMFL;
    private int availableJokerKeyClusterFunctions = 0;
    private final /* synthetic */ AbstractJokerKeyComponent this$0;

    private AbstractJokerKeyComponent$CombiMFLHandler(AbstractJokerKeyComponent abstractJokerKeyComponent) {
        this.this$0 = abstractJokerKeyComponent;
    }

    @Override
    public void setAvailableJokerKeyClusterFunctions(int n) {
        if (this.combiBAPServiceMFL != null) {
            this.combiBAPServiceMFL.updateAvailableJokerKeyClusterFunctions(n);
        }
        if (this.availableJokerKeyClusterFunctions != n) {
            this.availableJokerKeyClusterFunctions = n;
            this.updateClusterFunctionsVisibilities();
            AbstractJokerKeyComponent.access$000(this.this$0);
        } else {
            this.this$0.getLogChannel().log(-2137614336, "[AbtractJokerKeyComponent.CombiMFLHandler#setAvailableJokerKeyClusterFunctions] available functions not changed (%1)", (long)n);
        }
    }

    private void updateClusterFunctionsVisibilities() {
        Iterator iterator = AbstractJokerKeyComponent.access$100(this.this$0).keySet().iterator();
        while (iterator.hasNext()) {
            int n = (Integer)iterator.next();
            if (!JokerKeyMeaning.isClusterFunction(n)) continue;
            this.this$0.setFunctionAvailable(n, this.isClusterFunctionAvailable(n));
        }
    }

    @Override
    public void confirmCurrentJokerKeyFunctions(int n, int n2, int n3, int n4, int n5) {
        int n6;
        switch (n) {
            case 1: {
                n6 = 15;
                break;
            }
            case 2: {
                n6 = 16;
                break;
            }
            case 3: {
                n6 = 17;
                break;
            }
            case 4: {
                n6 = 18;
                break;
            }
            case 5: {
                n6 = 19;
                break;
            }
            case 6: {
                n6 = 20;
                break;
            }
            case 0: {
                return;
            }
            default: {
                this.this$0.getLogChannel().log(-2137614336, "[AbstractJokerKeyComponent.CombiMFLHandler#confirmCurrentJokerKeyFunctions] unknown joker key function selected: %1", (long)n);
                return;
            }
        }
        this.this$0.getLogChannel().log(-2137614336, "[AbstractJokerKeyComponent.CombiMFLHandler#confirmCurrentJokerKeyFunctions] confirmation for jokerKeyFunction=%1 received", (long)n6);
        if (this.isClusterFunctionAvailable(n6)) {
            AbstractJokerKeyComponent.access$200(this.this$0, n6).activate();
        } else {
            this.this$0.getLogChannel().log(10000, "[AbstractJokerKeyComponent.CombiMFLHandler#confirmCurrentJokerKeyFunctions] jokerKeyFunction=%1 not available", (long)n6);
        }
    }

    private boolean isClusterFunctionAvailable(int n) {
        int n2;
        switch (n) {
            case 15: {
                n2 = 1;
                break;
            }
            case 16: {
                n2 = 2;
                break;
            }
            case 17: {
                n2 = 4;
                break;
            }
            case 18: {
                n2 = 8;
                break;
            }
            case 19: {
                n2 = 16;
                break;
            }
            case 20: {
                n2 = 32;
                break;
            }
            default: {
                return false;
            }
        }
        return (n2 & this.availableJokerKeyClusterFunctions) == n2;
    }

    private void updateClusterKeyConfiguration(int n) {
        if (this.combiBAPServiceMFL != null) {
            this.combiBAPServiceMFL.updateCurrentJokerKeyFunction(1, this.convertJokerKeyMeaning(n));
        }
    }

    private int convertJokerKeyMeaning(int n) {
        int n2;
        switch (n) {
            case 15: {
                n2 = 1;
                break;
            }
            case 16: {
                n2 = 2;
                break;
            }
            case 17: {
                n2 = 3;
                break;
            }
            case 18: {
                n2 = 4;
                break;
            }
            case 19: {
                n2 = 5;
                break;
            }
            case 20: {
                n2 = 6;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    @Override
    public void serviceAvailable(Object object) {
        this.combiBAPServiceMFL = (CombiBAPServiceMFL)object;
        if (this.combiBAPServiceMFL != null) {
            this.updateClusterKeyConfiguration(AbstractJokerKeyComponent.access$300(this.this$0));
            this.combiBAPServiceMFL.updateInstalledKeys(1);
        }
    }

    @Override
    public void serviceRemoved() {
        this.combiBAPServiceMFL = null;
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AbstractJokerKeyComponent.class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFL == null ? (AbstractJokerKeyComponent.class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFL = AbstractJokerKeyComponent.class$("de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFL")) : AbstractJokerKeyComponent.class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFL).getName()};
    }

    static /* synthetic */ void access$900(AbstractJokerKeyComponent$CombiMFLHandler abstractJokerKeyComponent$CombiMFLHandler, int n) {
        abstractJokerKeyComponent$CombiMFLHandler.updateClusterKeyConfiguration(n);
    }

    /* synthetic */ AbstractJokerKeyComponent$CombiMFLHandler(AbstractJokerKeyComponent abstractJokerKeyComponent, AbstractJokerKeyComponent$1 abstractJokerKeyComponent$1) {
        this(abstractJokerKeyComponent);
    }
}

