package touhou;

import Bases.GameObject;
import Bases.Utils;

public class PlayerSpell extends GameObject {
    final int bulletSpeed = 10;

    public PlayerSpell(){
        image = Utils.loadImage("assets/images/player-bullets/a/1.png");
    }

    @Override
    public void run(){
        y -= bulletSpeed;
    }
}
