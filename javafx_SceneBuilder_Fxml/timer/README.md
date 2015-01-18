Timer
==

Use JavaFX, FXML,  CSS and JavaFX Scene Builder to build a Mobile like Timer

![timer](timer.png)

- Controller implements Initializble
    - initialize runs after root elements are processed.
- TimeLine
    - getStatus.toString() : PAUSED, RUNNING, STOPPED
- focusedProperty():
    - addListener : listen if is focused (actived)
