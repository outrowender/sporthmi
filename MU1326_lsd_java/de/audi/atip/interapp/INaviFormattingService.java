/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.IFormattingRequest;
import de.audi.atip.interapp.IFormattingResponse;
import org.dsi.ifc.global.NavLocation;

public interface INaviFormattingService {
    public IFormattingResponse formatAddress(IFormattingRequest var1);

    public IFormattingResponse formattingOneLine(IFormattingRequest var1);

    public IFormattingResponse formattingTwoLines(IFormattingRequest var1);

    public IFormattingResponse formattingThreeLines(IFormattingRequest var1);

    public IFormattingRequest createNewFormattingRequest();

    public IFormattingRequest createNewFormattingRequest(NavLocation var1, boolean var2);
}

