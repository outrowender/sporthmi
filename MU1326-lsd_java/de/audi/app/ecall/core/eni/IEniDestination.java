/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.eni;

import de.audi.atip.interapp.bap.eni.data.Destination;

interface IEniDestination {
    default public void updateDestination(Destination destination) {
    }
}

