package console

import griffon.core.artifact.GriffonModel
import griffon.transform.Observable
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonModel)
class ConsoleModel {
    String scriptSource
    @Observable Object scriptResult
    @Observable boolean enabled = true
}