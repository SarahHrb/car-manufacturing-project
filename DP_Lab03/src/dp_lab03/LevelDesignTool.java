package dp_lab03;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Sarah 2211687
 */

// Prototype interface representing a cloneable game level
interface LevelPrototype extends Cloneable {
    LevelPrototype cloneLevel();
    void displayConfiguration();
    void setTerrain(String newTerrain);
    void addObstacle(String obstacle);
}

// Concrete implementation of the Prototype pattern for a Game Level
class GameLevel implements LevelPrototype {
    private String name;
    private String terrain;
    private List<String> obstacles;
    private int enemyCount;

    // Constructor for the prototype
    public GameLevel(String name, String terrain, List<String> obstacles, int enemyCount) {
        this.name = name;
        this.terrain = terrain;
        // Deep copy for the mutable list of obstacles
        this.obstacles = new ArrayList<>(obstacles); 
        this.enemyCount = enemyCount;
    }

    // Copy constructor used internally for deep cloning
    public GameLevel(GameLevel source) {
        // The client code will set the new clone's specific name
        this.name = source.name + " Clone";
        this.terrain = source.terrain;
        // Perform a deep copy of the mutable collection to ensure independence
        this.obstacles = new ArrayList<>(source.obstacles); 
        this.enemyCount = source.enemyCount;
    }
    
    @Override
    public LevelPrototype cloneLevel() {
        // Returns a new object that is a deep copy of the current object
        return new GameLevel(this);
    }

    // --- Public Setter Methods for Customization ---
    
    // **FIX:** Added public setter for the private 'name' field
    public void setName(String name) { 
        this.name = name;
    }
    
    public void setTerrain(String newTerrain) {
        this.terrain = newTerrain;
    }

    public void addObstacle(String obstacle) {
        this.obstacles.add(obstacle);
    }
    
    public void setEnemyCount(int count) {
        this.enemyCount = count;
    }
    // ----------------------------------------------

    @Override
    public void displayConfiguration() {
        System.out.println("--- " + name + " Configuration ---");
        System.out.println("Terrain: " + terrain);
        System.out.println("Obstacles: " + obstacles);
        System.out.println("Enemy Count: " + enemyCount);
    }
}

// Client class (Level Design Tool)
public class LevelDesignTool {
    public static void main(String[] args) {
        // 1. Create a Prototype (Base Level Template)
        List<String> baseObstacles = new ArrayList<>();
        baseObstacles.add("Wall");
        baseObstacles.add("Pit Trap");
        
        GameLevel prototypeLevel = new GameLevel("Base Desert Level Template", "Desert", baseObstacles, 10);
        
        System.out.println("--- Cloning and Modifying Levels ---");

        // 2. Clone the prototype to create Level 1
        GameLevel level1 = (GameLevel) prototypeLevel.cloneLevel();
        level1.setName("Level 1: Canyon Assault"); // **FIX:** Use the public setter
        level1.setTerrain("Rocky Canyon"); // Modify clone
        level1.addObstacle("Landmine");    // Modify clone
        level1.setEnemyCount(15);          // Modify clone

        // 3. Clone the prototype to create Level 2
        GameLevel level2 = (GameLevel) prototypeLevel.cloneLevel();
        level2.setName("Level 2: Dune Patrol"); // **FIX:** Use the public setter
        level2.setTerrain("Sand Dunes"); // Modify clone
        level2.setEnemyCount(5);          // Modify clone
        
        // Display final configurations, showing that modifications to clones did not affect the prototype
        System.out.println("\n--- Final Configurations ---");
        level1.displayConfiguration();
        System.out.println();
        level2.displayConfiguration();
        System.out.println();
        prototypeLevel.displayConfiguration();
    }
}