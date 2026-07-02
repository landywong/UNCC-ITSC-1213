/**
 * Driver that exercises the small game hierarchy.
 *
 * The hierarchy is:
 *
 *   Entity (abstract)            Combatant (interface)
 *      |                              |
 *      +--+----------------------+    |
 *         |                      |    |
 *      Player ----- implements --+    |
 *      Monster ---- implements -------+
 *
 * Player and Monster both extend the abstract Entity and implement
 * the Combatant interface. Main creates one of each, calls their
 * inherited and overridden methods, exercises polymorphism through
 * an Entity[], and prints the result of one round of attacks.
 *
 * @author  ITSC 1213
 * @version 2026-07-02
 */
public class Main {

    public static void main(String[] args) {

        // Cannot instantiate Entity directly: it is abstract.
        //   Entity e = new Entity("?", 100);   // would not compile

        Player  player  = new Player("Hero",   100, 5, "claw");
        Monster monster = new Monster("Goblin", 50, "beastly", 10);

        System.out.println("=== Initial state (polymorphism via Entity[]) ===");
        Entity[] entities = { player, monster };
        for (Entity e : entities) {
            // The static type of e is Entity, but display() dispatches
            // to the override on the actual class -- Player.display()
            // for player, Monster.display() for monster.
            e.display();
        }

        System.out.println();
        System.out.println("=== One round of attacks (Combatant interface) ===");
        player.attack(monster);
        monster.attack(player);

        System.out.println();
        System.out.println("=== Final state ===");
        for (Entity e : entities) {
            e.display();
        }
    }
}
