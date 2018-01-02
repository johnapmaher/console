package console

import org.codehaus.griffon.runtime.swing.DefaultSwingWindowDisplayHandler

import javax.annotation.Nonnull
import java.awt.Window

import static griffon.swing.support.SwingUtils.centerOnScreen

class CenteringWindowDisplayHandler extends DefaultSwingWindowDisplayHandler {
    @Override
    void show(@Nonnull String name, @Nonnull Window window) {
        centerOnScreen(window)
        super.show(name, window)
    }
}


This handler is only concerned with centering the window on the screen before showing it.
View

The view classes contain the visual components for your application. Please paste the following code into griffon-app/views/console/ConsoleView.groovy.
griffon-app/views/console/ConsoleView.groovy


  

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50


  	

package console

import griffon.core.artifact.GriffonView
import griffon.inject.MVCMember
import griffon.metadata.ArtifactProviderFor

import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonView)
class ConsoleView {
    @MVCMember @Nonnull
    FactoryBuilderSupport builder                                            
    @MVCMember @Nonnull
    ConsoleModel model                                                       

    void initUI() {
        builder.with {
            actions {
                action(executeScriptAction,                                  
                    enabled: bind { model.enabled })
            }

            application(title: application.configuration['application.title'],
                pack: true, locationByPlatform: true, id: 'mainWindow',
                iconImage:   imageIcon('/griffon-icon-48x48.png').image,
                iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                             imageIcon('/griffon-icon-32x32.png').image,
                             imageIcon('/griffon-icon-16x16.png').image]) {
                panel(border: emptyBorder(6)) {
                    borderLayout()

                    scrollPane(constraints: CENTER) {
                        textArea(text: bind(target: model, 'scriptSource'),  
                            enabled: bind { model.enabled },                 
                            columns: 40, rows: 10)
                    }

                    hbox(constraints: SOUTH) {
                        button(executeScriptAction)                          
                        hstrut(5)
                        label('Result:')
                        hstrut(5)
                        textField(editable: false,
                                  text: bind { model.scriptResult })         
                    }
                }
            }
        }
    }
}