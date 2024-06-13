package map;

import core.map.Map;
import utils.LoadSave;

public class MapTest extends Map {

    public MapTest() {
        super(LoadSave.loadImage("backgrounds/loading_background.png"));
    }
}
