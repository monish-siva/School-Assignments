import java.util.List;
/**
 * Write a description of class Actor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public interface Actor

//Below is the abstract class version of this interface
//public abstract class Actor
{
  // This is the abstract class version of the statements below
  // abstract public void act(List<Actor> newActors);
  // abstract public boolean isActive();
   
   
   public void act(List<Actor> newActors);
   public boolean isActive();
   
   
   //This is needed for when you change it to an abstract class
   /* public Actor()
   {

   } */
    
}
