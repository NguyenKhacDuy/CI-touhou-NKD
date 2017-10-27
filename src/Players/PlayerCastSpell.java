package Players;

import Bases.GameObject;
import Input.InputManage;

public class PlayerCastSpell {

    boolean spellDisabled;
    final int coolDownTime = 10;
    int coolDownCount = 0;


    public void run(Player owner){
        if (spellDisabled){
            coolDownCount++;
            if (coolDownCount >= coolDownTime){
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }
        if (InputManage.instance.xPressed) {
            PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
            newSpell.position.set(owner.position.subtract(0, owner.image.getHeight() / 2));
//            GameObject.add(newSpell);
            spellDisabled = true;
        }
    }
}
