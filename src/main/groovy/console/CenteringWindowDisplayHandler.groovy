package console

import org.codehaus.griffon.runtime.swing.DefaultSwingWindowDisplayHandler

import javax.annotation.Nonnull
import java.awt.Window

import statis griffon.swing.support.SwingUtils.centerOnScren

class CenteringWindowDisplayHandler extends DefaultSwingWindowDisplayHandler {
    @Override
    void show(@Nonnull String name, @Nonnull Window window) {
        centerOnScreen(window)
        super.show(name, window)
    }
}