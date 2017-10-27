package Players;

import Bases.GameObject;
import Bases.Physics.BoxCollider;
import Bases.Physics.PhysicsBody;
import Bases.Utils;
import Bases.Vector2D;
import Input.InputManage;

public class Player extends GameObject implements PhysicsBody {
    final int speed = 5; // final = const
    final int left = 20;
    final int right = 370;
    final int top = 20;
    final int bottom = 538;

    public BoxCollider boxCollider;
    PlayerCastSpell playerCastSpell;
    EnemyDamage enemyDamage;

    public Player(){
        position.set(182, 518);
        image = Utils.loadImage("assets/images/players/straight/0.png");
        boxCollider = new BoxCollider(30,30);
        playerCastSpell = new PlayerCastSpell();

    }

    public void run(){
        move();
        playerCastSpell.run(this);
        boxCollider.position.set(this.position);
//        this.enemyDamage.DamageofEnemy(this);
    }


    Vector2D velocity = new Vector2D();

    private void move() {
        velocity.set(0,0);
        InputManage inputManage = InputManage.instance;

        if(inputManage.rightPressed){
            velocity.x += speed;
        }
        if (inputManage.leftPressed){
            velocity.x -= speed;
        }
        if (inputManage.upPressed){
            velocity.y -= speed;
        }
        if (inputManage.downPressed){
            velocity.y +=speed;
        }

        position.addUp(velocity);

        position.x = (int)Utils.clamp(position.x, left, right); // ép kiểu 1 số thì: (kiểu)
        position.y = (int)Utils.clamp(position.y, top, bottom);
    }

    public void getHit() {
        isActive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
