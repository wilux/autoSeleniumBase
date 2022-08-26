package Config;

import Action.*;


public interface Actions {


    Click click();

    Write write();

    CheckBox checkBox();

    Choose choose();

    Keyboard keyboard();

    LinkStatus linkStatus();

    DragDrop dragDrop();

    Get get();

}
