/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.IFormattingRequest;
import de.audi.atip.interapp.IFormattingResponse;
import org.dsi.ifc.global.NavLocation;

public interface INaviFormattingService {
    default public IFormattingResponse formatAddress(IFormattingRequest iFormattingRequest) {
    }

    default public IFormattingResponse formattingOneLine(IFormattingRequest iFormattingRequest) {
    }

    default public IFormattingResponse formattingTwoLines(IFormattingRequest iFormattingRequest) {
    }

    default public IFormattingResponse formattingThreeLines(IFormattingRequest iFormattingRequest) {
    }

    default public IFormattingRequest createNewFormattingRequest() {
    }

    default public IFormattingRequest createNewFormattingRequest(NavLocation navLocation, boolean bl) {
    }
}

