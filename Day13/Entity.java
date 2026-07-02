/**
 * Abstract parent class for any creature in the game.
 *
 * Entity carries the data and behaviour every creature shares: a
 * name, a health value, getters and setters for both, and a concrete
 * `takeDamage(int)` method that every subclass inherits unchanged.
 *
 * The method `display()` is declared `abstract` because the parent
 * does not know how to format a creature in general -- a Player and
 * a Monster show different fields. Every concrete subclass MUST
 * provide its own `display()`.
 *
 * Because Entity is abstract, `new Entity(...)` is a compile error:
 * Entity exists to be extended, not to be instantiated.
 *
 * @author  ITSC 1213
 * @version 2026-07-02
 */
public abstract class Entity {

    /** Name of this entity (visible to subclasses). */
    protected String name;

    /** Current health (visible to subclasses). */
    protected int health;

    public Entity(String name, int health) {
        this.name   = name;
        this.health = health;
    }

    public String getName()                 { return this.name;   }
    public void   setName(String name)      { this.name = name;   }

    public int    getHealth()               { return this.health; }
    public void   setHealth(int health)     { this.health = health; }

    /**
     * Inflict damage on this entity. Health is clamped at zero so it
     * never goes negative. Concrete; inherited by every subclass.
     */
    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
     * Print a one-line summary of this entity. Abstract: every
     * concrete subclass must override this method.
     */
    public abstract void display();
}
