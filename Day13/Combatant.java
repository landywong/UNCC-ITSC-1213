/**
 * Contract for any entity that can attack another entity.
 *
 * Combatant is an interface, not a class: it declares a method
 * signature without a body. Any class that implements Combatant
 * promises to provide an `attack(Entity)` method.
 *
 * @author  ITSC 1213
 * @version 2026-07-02
 */
public interface Combatant {

    /**
     * Attack another entity. The implementing class decides how the
     * damage is computed and applied.
     *
     * @param target the entity being attacked; must not be null.
     */
    void attack(Entity target);
}
