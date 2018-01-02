package console

import griffon.inject.DependsOn
import griffon.swing.SwingWindowDisplayHandler
import griffon.core.event.EventHandler
import griffon.core.injection.Module
import org.codehaus.griffon.runtime.core.injection.AbstractModule
import org.kordamp.jipsy.ServiceProviderFor

@DependsOn('swing')
@ServiceProviderFor(Module)
class ApplicationModule extends AbstractModule {
    @Override
    protected void doConfigure() {
        bind(Evaluator)

            .to(GroovyShellEvaluator)
            .asSingleton()

        bind(SwingWindowDisplayHandler)

            .withClassifier(named('defaultWindowDisplayHandler'))
            .to(CenteringWindowDisplayHandler)
            .asSingleton()
    }
}