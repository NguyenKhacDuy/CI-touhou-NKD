package Enemies;

import Bases.GameObject;
import Bases.Physics.BoxCollider;
import Players.Player;

public class PlayerDamage {
    public void DamageOfPlayer(Enemy owner){
        BoxCollider boxCollider = owner.getBoxCollider();
        Player player = GameObject.collideWith(boxCollider, Player.class);
        if (player != null){
            player.getHit();
            owner.isActive = false;
        }
    }
}
