/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

public interface IOperatorCallNaviService {
    public static final int ENTER_ROUTE_GUIDANCE = 0;
    public static final int ENTER_HOME_ADDRESS = 3;
    public static final int ENTER_CONTACT = 4;

    public void enterOperatorCall(int var1, int var2);
}

