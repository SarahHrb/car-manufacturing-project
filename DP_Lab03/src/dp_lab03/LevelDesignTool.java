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


class GameLevel implements LevelPrototype {
    private String name;
    private String terrain;
    private List<String> obstacles;
    private int enemyCount;

   
    public GameLevel(String name, String terrain, List<String> obstacles, int enemyCount) {
        this.name = name;
        this.terrain = terrain;
        
        this.obstacles = new ArrayList<>(obstacles); 
        this.enemyCount = enemyCount;
    }


    public GameLevel(GameLevel source) {
       
        this.name = source.name + " Clone";
        this.terrain = source.terrain;

        this.obstacles = new ArrayList<>(source.obstacles); 
        this.enemyCount = source.enemyCount;
    }
    
    @Override
    public LevelPrototype cloneLevel() {
        
        return new GameLevel(this);
    }

  
    
    
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
    

    @Override
    public void displayConfiguration() {
        System.out.println("--- " + name + " Configuration ---");
        System.out.println("Terrain: " + terrain);
        System.out.println("Obstacles: " + obstacles);
        System.out.println("Enemy Count: " + enemyCount);
    }
}


public class LevelDesignTool {
    public static void main(String[] args) {
        
        List<String> baseObstacles = new ArrayList<>();
        baseObstacles.add("Wall");
        baseObstacles.add("Pit Trap");
        
        GameLevel prototypeLevel = new GameLevel("Base Desert Level Template", "Desert", baseObstacles, 10);
        
        System.out.println("--- Cloning and Modifying Levels ---");

        
        GameLevel level1 = (GameLevel) prototypeLevel.cloneLevel();
        level1.setName("Level 1: Canyon Assault"); 
        level1.setTerrain("Rocky Canyon"); 
        level1.addObstacle("Landmine");    
        level1.setEnemyCount(15);          

        
        GameLevel level2 = (GameLevel) prototypeLevel.cloneLevel();
        level2.setName("Level 2: Dune Patrol"); 
        level2.setTerrain("Sand Dunes"); 
        level2.setEnemyCount(5);          
        
        
        System.out.println("\n--- Final Configurations ---");
        level1.displayConfiguration();
        System.out.println();
        level2.displayConfiguration();
        System.out.println();
        prototypeLevel.displayConfiguration();
    }
}