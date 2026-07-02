/**
 * Concrete subclass of Entity for a monster.
 *
 * Like Player, Monster extends the abstract Entity and implements
 * the Combatant interface. It adds two fields of its own -- type
 * and damage -- and overrides display() with a Monster-specific
 * format.
 *
 * @author  ITSC 1213
 * @version 2026-07-02
 */
public class Monster extends Entity implements Combatant {

    private String type;
    private int    damage;

    public Monster(String name, int health, String type, int damage) {
        super(name, health);
        this.type   = type;
        this.damage = damage;
    }

    public String getType()                 { return this.type; }
    public void   setType(String type)      { this.type = type; }

    public int    getDamage()               { return this.damage; }
    public void   setDamage(int damage)     { this.damage = damage; }

    /** Required by Entity. */
    @Override
    public void display() {
        System.out.println("Monster: " + this.name
            + ", Health: " + this.health
            + ", Type: "   + this.type
            + ", Damage: " + this.damage);
    }

    /** Required by Combatant. Damage is the monster's fixed damage value. */
    @Override
    public void attack(Entity target) {
        System.out.println(this.name + " (" + this.type + ") attacks "
            + target.getName() + " for " + this.damage + " damage.");
        target.takeDamage(this.damage);
    }
}
