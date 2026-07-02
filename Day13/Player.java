/**
 * Concrete subclass of Entity for a player character.
 *
 * Player extends the abstract Entity (so it inherits name, health,
 * the getters and setters, and takeDamage) and implements the
 * Combatant interface (so it must provide attack(Entity)). It adds
 * two fields of its own -- level and specialAbility -- and overrides
 * the abstract display() with a Player-specific format.
 *
 * @author  ITSC 1213
 * @version 2026-07-02
 */
public class Player extends Entity implements Combatant {

    private int    level;
    private String specialAbility;

    public Player(String name, int health, int level, String specialAbility) {
        super(name, health);                    // initialise inherited fields
        this.level          = level;
        this.specialAbility = specialAbility;
    }

    public int    getLevel()                            { return this.level; }
    public void   setLevel(int level)                   { this.level = level; }

    public String getSpecialAbility()                   { return this.specialAbility; }
    public void   setSpecialAbility(String ability)     { this.specialAbility = ability; }

    /** Required by Entity. */
    @Override
    public void display() {
        System.out.println("Player: " + this.name
            + ", Health: " + this.health
            + ", Level: "  + this.level
            + ", Ability: " + this.specialAbility);
    }

    /** Required by Combatant. Damage scales with the player's level. */
    @Override
    public void attack(Entity target) {
        int damage = this.level * 2;
        System.out.println(this.name + " uses " + this.specialAbility
            + " on " + target.getName() + " for " + damage + " damage.");
        target.takeDamage(damage);
    }
}
