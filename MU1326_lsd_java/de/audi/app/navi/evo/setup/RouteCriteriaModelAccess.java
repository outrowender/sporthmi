/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.setup;

import de.audi.app.navi.setup.RouteCriterialCoreModelAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.setup.IRouteCriteria;

public class RouteCriteriaModelAccess
extends RouteCriterialCoreModelAccess {
    public RouteCriteriaModelAccess(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    public void onStart(IRouteCriteria iRouteCriteria) {
        this.env.getLogChannel().log(10000000, "RouteCriteriaModelAccess#onStart() - %1", (Object)iRouteCriteria);
        super.onUpdateCriteria(iRouteCriteria);
    }

    protected void setTrafficReroutingModel(int n) {
        int n2 = 0;
        if (n == 3) {
            n2 = 0;
        } else if (n == 4) {
            n2 = 1;
        } else if (n == 6) {
            n2 = 2;
        }
        if (this.env.getChoiceModel(400895).getValue() != n2) {
            this.env.getChoiceModel(400895).setValue(n2);
        }
    }

    protected void setFreewaysModel(boolean bl) {
        int n = bl ? 0 : 1;
        this.env.getLogChannel().log(10000000, "RouteCriteriaModelAccess#setFreewaysModel(%1) - choice: %2", bl, (long)n);
        if (this.env.getChoiceModel(402560).getValue() != n) {
            this.env.getChoiceModel(402560).setValue(n);
        }
    }

    protected void setTrailerModel(int n) {
        this.env.getLogChannel().log(10000000, "RouteCriteriaModelAccess#setTrailerModel(%1) - mode: %1", (long)n);
        int n2 = 0;
        if (n == 3) {
            n2 = 2;
        } else if (n == 6) {
            n2 = 0;
        } else if (n == 5) {
            n2 = 1;
        }
        if (this.env.getChoiceModel(400896).getValue() != n2) {
            this.env.getChoiceModel(400896).setValue(n2);
        }
    }

    protected void setSeasonalRestricted(int n) {
        int n2 = 1;
        if (n == 1) {
            n2 = 1;
        } else if (n == 2) {
            n2 = 2;
        } else if (n == 3) {
            n2 = 0;
        }
        super.setSeasonalRestricted(n2);
    }
}

