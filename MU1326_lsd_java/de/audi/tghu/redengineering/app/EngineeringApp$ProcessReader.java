/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.tghu.redengineering.app.EngineeringApp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class EngineeringApp$ProcessReader
implements Runnable {
    private final Process process;
    private final boolean error;
    private final /* synthetic */ EngineeringApp this$0;

    public EngineeringApp$ProcessReader(EngineeringApp engineeringApp, Process process, boolean bl) {
        this.this$0 = engineeringApp;
        this.process = process;
        this.error = bl;
    }

    @Override
    public void run() {
        InputStream inputStream = this.error ? this.process.getErrorStream() : this.process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
                Thread.sleep(0);
                EngineeringApp.access$000(this.this$0).getLabelModel(147).setText(string);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

