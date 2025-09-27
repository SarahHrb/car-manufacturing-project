/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dp_lab03;

/**
 *
 * @author Sarah 2211687
 */


// 1. Prototype Interface
interface DocumentTemplate extends Cloneable {
    DocumentTemplate clone(); 
    void customize();         
}

// 2. Concrete Prototype: Article Template
class ArticleTemplate implements DocumentTemplate {
    
    // Internal state could be added here (e.g., private String author, private int version)
    
    @Override
    public DocumentTemplate clone() {
        // For simple classes with no mutable state, calling the constructor is sufficient.
        // For complex objects, a deep copy constructor would be used here.
        return new ArticleTemplate(); 
    }
    
    @Override
    public void customize() {
        System.out.println("Customizing Article Template: change title, font, layout...");
    }
}

// 2. Concrete Prototype: Report Template
class ReportTemplate implements DocumentTemplate {
    
    // Internal state could be added here (e.g., private String department, private List<String> sections)
    
    @Override
    public DocumentTemplate clone() {
        // For simple classes with no mutable state, calling the constructor is sufficient.
        return new ReportTemplate();
    }
    
    @Override
    public void customize() {
        System.out.println("Customizing Report Template: add charts, sections, references...");
    }
}

// 3. Client Class
public class DocumentGeneratorApp {

    public static void main(String[] args) {

        // The client holds and uses the prototypes to create new instances.
        
        // Prototype for Articles
        DocumentTemplate articlePrototype = new ArticleTemplate();

        // Clone 1: Create a new article based on the prototype template
        DocumentTemplate article1 = articlePrototype.clone();
        article1.customize();

        // Clone 2: Create another article
        DocumentTemplate article2 = articlePrototype.clone();
        article2.customize();

        // Prototype for Reports
        DocumentTemplate reportPrototype = new ReportTemplate();
        
        // Clone 3: Create a new report
        DocumentTemplate report1 = reportPrototype.clone();
        report1.customize();
    }
}