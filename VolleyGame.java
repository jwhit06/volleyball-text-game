//Jed  Whitaker
import java.util.*;
public class VolleyGame
{
  public static void main(String[] args)
  {
    Scanner input=new Scanner(System.in);
    String action;
    boolean on = true;
    boolean playAgain = false;
    events one = new events();
    do
    {
      one.startGame();
      while(true)
      {
        one.saveGame();
        action = input.nextLine();
        while(on == true) 
        {
          if(one.getSchool() < 50)
          {
            System.out.println("Narrator: You're school meter fell below 50 and you have been kicked off the team. Game Over.");
            System.out.println("Would you like to play again?");
            action = input.nextLine();
            while(!action.equals("Yes") || !action.equals("No"))
            {
              System.out.println("ERROR: Answer must be \"Yes\" or \"No.\" Try again.");
              action = input.nextLine();
            }
            if(action.equals("Yes"))
            {
              playAgain = true;
            }
            else
            {
              playAgain = false;
            }
          }
          if(one.getGame() == true)
          {
            one.playGame();
          }
          else if(action.equals("!help") || action.equals("!practice") || action.equals("!workout") || action.equals("!homework") || action.equals("!study") || action.equals("!friends") || action.equals("!rest") || action.equals("!videogame") || action.equals("!family") || action.equals("!schedule") || action.equals("!stats") || action.equals("goToGame"))
          {
            one.actions(action);
          }
          else if(!action.equals("!help") && !action.equals("!practice") && !action.equals("!workout") && !action.equals("!homework") && !action.equals("!study") && !action.equals("!friends") && !action.equals("!rest") && !action.equals("!videogame") && !action.equals("!family") && !action.equals("!schedule") && !action.equals("!stats") && !action.equals("goToGame"))
          {
              System.out.println("ERROR: You must give a valid command.");
          }
          on = false;
        }
        if(one.getTime() == 5)
        {
            one.nextDay();
        }
        on = true;
      }
      
    }while(playAgain == true);
  }
}

/*

  private double skill; //stores skill
  private double sanity; //stores sanity
  private double school; //stores school
  private double strength; //stores strength
  private String[] names = new String [20];
  private String[] days = new String[90]; //stores all the days in each season
  private boolean[] games = new boolean[90];
  private String [] namesPreset = {"Brookline", "Needham", "Natick", "Braintree", "Quincy", "Randolph", "Newton North", "Framingham", "Hingham", "Taunton"};
  private double hwdone = 0;
  private double hwreq = 0;
  private int currentGame = 0;
  private int winCount = 0;
  private int lossCount = 0;
  public int currentDay = 0; //stores what the day in the season it is
  public double timeUsed = 0; //stores time used in the current day

*/