package console

import griffon.core.artifact.GriffonController
import griffon.core.controller.ControllerAction
import griffon.inject.MVCMember
import griffon.metadata.ArtifactProviderFor
import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonController)
class ConsoleController {
    @MVCMember @Nonnull
    ConsoleModel model

    @ControllerAction
    void click() {
        model.clickCount++
    }
}