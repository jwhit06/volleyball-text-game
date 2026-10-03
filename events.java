//Jed Whitaker
import java.io.*;
import java.util.Scanner;
public class events
{
  
  Scanner input=new Scanner(System.in);
  
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
  private double timeUsed = 0; //stores time used in the current day
  
  
  /*
  Start game gives every variable its initial value
  It gives the user a dialouge in which they will find out which team they make
  The higher their skill is set at the better their team will be
  The season schedule will be set and available
  */
  
  public void startGame()
  {
    skill = Math.round((24*Math.random()+1)); //sets skill to a random int 1 - 25
    sanity = Math.round((20*Math.random()+80)); //sets sanity to a random number 80 - 100
    school = 70;
    strength = 100;
    
    //sets the days to have their respective names
    
    for(int i = 0; i < 4; i++) 
    {
      days[i] = "March " + (i+28);
    }
    for(int i = 4; i < 34; i++)
    {
      days[i] = "April " + (i-3);
    }
    for(int i = 34; i < 65; i++)
    {
      days[i] = "May " + (i-33);
    }
    for(int i = 65; i < 90; i++)
    {
      days[i] = "June " + (i-64);
    }
    
    
    //*********************************************
    
    for(int i = 0; i < 10; i++)
    {
      int randomNum = (int)(10*Math.random());
      while(names[randomNum] != null)
      {
        randomNum = (int)(10*Math.random());
      }
      names[randomNum] = namesPreset[randomNum];
      names[randomNum + 10] = namesPreset[randomNum];
    }
    
    
    //sets schedule *****************************
    
    int gameDay;
    
    for(int i = 0; i < 20; i++)
    {
      gameDay = (int)(60*Math.random()+30);
      while(games[gameDay] == true)
      {
        gameDay = (int)(60*Math.random()+30);
      }
	  games[gameDay] = true;
    }
    
    //*******************************************
    
    
    System.out.println("Coach:\nAll those who have made the team will be called forward... \nAnyone left is cut from the team.\n\nNarrator:\nThe coach begins to call numbers, \"Twenty, Three, Forty-One...\" they all step forward.\nAs he continues, all your adversaries step forward.He calls the final number, leaving\nyou the only one who is yet to step forward...\n\nYou have been cut.");
    System.out.println("\nYou get to school the next day and see posters advertising volleyball\n\"Tryouts on March 25th! Come check it out!\"\nThis peaks your interest...");
    System.out.println("\nThe day of tryouts has come around and you go to the gym, it's your first year and highschool\nand everyone is giant next to you. You watch in amazement as they play and start walking on the\ncourt.\n ");
    
    String teamMade;
    
    if(skill > 20)
    {
      teamMade = "You made the team!";
    }
    else
    {
      teamMade = "Your name is not called.\n\nHe continues to Freshmen...\nYou made the team!";
    }
    System.out.println("At the end of tryouts the coach calls numbers forward for each team starting with Varsity...\nYour name is not called.\n\nHe then moves onto JV...\n" + teamMade);
    System.out.println("\nIt's now monday and time to start your volleyball career! Let's go to your first practice!");
    practice();
    System.out.println("\nNarrator: Great Job! You got through your first practice!");
    help();
    
    
  }
  
  public void help()
  {
    System.out.println("\nHere are some of the commands you can use:");
    System.out.println("!help: Shows this menu.");
    System.out.println("!practice: Attend a 2 hour practice to increase skill.");
    System.out.println("!workout: Attend a 1 hour workout to increase skill and strength.");
    System.out.println("!homework: Do your homework for 1 hour (Only increases school if done more than once).");
    System.out.println("!study: Study for 30 minutes (Only increases school if homework is complete).");
    System.out.println("!friends: Go see friends for 1 hour to increase sanity.");
    System.out.println("!rest: Relax for 30 minutes to increase your strength and sanity.");
    System.out.println("!videogame: Play a video game for 30 minutes to increase your sanity.");
    System.out.println("!family: See your family for 30 minutes to increase your sanity.");
    System.out.println("!schedule: Shows the schedule for the season.");
    System.out.println("!stats: Shows your characters current stats.");
    System.out.println("\nHere are a few hints to help you out:");
    System.out.println("1. If any of your stats (besides skill) fall below 50 you can only\nwork on that stat until it is above 50 again.");
    System.out.println("2. If you get sick or injured you will be taken out of physical \nactivity until you are better.");
    System.out.println("3. Your other stats will effect how much you improve and how well\nyou play in games.");
    System.out.println("4. If you win a game, your skill will increase and sanity will\nincrease however, if you lose, your skill and sanity will decrease.");
    System.out.println("5. You only get 5 hours to do work in a day before you have to\nsleep, use them wisely.");
    System.out.println("6. You must complete at least one hour of homework nightly unless\n told otherwise.");
    System.out.println("7. As strength decreases the chance of injury after playing increases.");
  }
  
  public void practice()
  {
    if(timeUsed <= 3 && strength >= 50 && sanity >= 50)
    {
      timeUsed += 2;
        strength -= (int)(19*Math.random() + 1);
      
      if(strength == 100 && sanity == 100)
      {
        skill += 2;
        System.out.println("Coach: Phenominal practice! You looked very strong and your head was 100% in the game.\nKeep up the good work, it'll pay off!");
      }
      else if(strength == 100 && sanity < 100)
      {
        if(sanity >= 90)
        {
          skill += 1.9;
          System.out.println("Coach: Fantastic practice! You looked very strong and your head was really in the game.\nKeep up the good work, it'll pay off!");
        }
        else if(sanity >= 80)
        {
          skill += 1.8;
          System.out.println("Coach: Great practice. You looked very strong and your head was in the game.\nKeep it up!");
        }
        else if(sanity >= 70)
        {
          skill += 1.7;
          System.out.println("Coach: Good practice. You looked very strong and you're maintaning a healthy mental state.\nWell done.");
        }
        else if(sanity >= 60)
        {
          skill += 1.6;
          System.out.println("Coach: Tough practice... You looked very strong but, you didn't look into it today.\nMake sure you're taking care of your sanity.");          
        }
        else if(sanity >= 50)
        {
          skill += 1.5;
          System.out.println("Coach: Rough practice... You looked very strong but, your head wasn't in it at all today.\nWork on it.");
        }
      }
      else if(sanity == 100 && strength < 100)
      {
        if(strength >= 90)
        {
          skill += 1.9;
          System.out.println("Coach: Fantastic practice! You looked strong and your head was 100% in the game.\nKeep up the good work, it'll pay off!");
        }
        else if(strength >= 80)
        {
          skill += 1.8;
          System.out.println("Coach: Great practice. You looked great and your head was 100% in the game.\nKeep it up!");
        }
        else if(strength >= 70)
        {
          skill += 1.7;
          System.out.println("Coach: Good practice. You looked good and your head was 100% in the game.\nWell done.");
        }
        else if(strength >= 60)
        {
          skill += 1.6;
          System.out.println("Coach: Tough practice... You weren't looking to good today but, your head was 100% in the game.\nMake sure you're taking care of your body.");
        }
        else if(strength >= 50)
        {
          skill += 1.5;
          System.out.println("Coach: Rough practice... You looked weak today but, your head was 100% in the game.\nTake a break and rest, your body needs it.");
        }
      }
      else if(strength >= 90 && sanity >= 90)
      {
        skill += 1.8;
        System.out.println("Coach: Fantastic practice! You're looking very strong and your head was really in the game.\nKeep up the good work, it'll pay off!");
      }
      else if(strength >= 90 && sanity < 90)
      {
        if(sanity >= 80)
        {
          skill += 1.7;
          System.out.println("Coach: Great practice! You looked great and your head is really in the game.\nKeep up the good work, it'll pay off!");
        }
        else if(sanity >= 70)
        {
          skill += 1.6;
          System.out.println("Coach: Good practice. You looked strong and you're maintaning a healthy mental state.\nWell done.");
        }
        else if(sanity >= 60)
        {
          skill += 1.5;
          System.out.println("Coach: Tough practice... You looked strong but, you didn't look into it today.\nMake sure you're taking care of your sanity too.");
        }
        else if(sanity >= 50)
        {
          skill += 1.4;
          System.out.println("Coach: Rough practice... You looked strong but, your head wasn't in it at all today.\nWork on it.");
        }
      }
      else if(sanity >= 90 && strength < 90)
      {
        if(strength >= 80)
        {
          skill += 1.7;
          System.out.println("Coach: Great practice! You looked great and your head was really in the game.\nKeep it up!");
        }
        else if(strength >= 70)
        {
          skill += 1.6;
          System.out.println("Coach: Good practice. You looked good and your head was really in the game.\nWell done.");
        }
        else if(strength >= 60)
        {
          skill += 1.5;
          System.out.println("Coach: Tough practice. You weren't looking to good today but, your head was really in the game.\nMake sure you're taking care of your body.");
        }
        else if(strength >= 50)
        {
          skill += 1.4;
          System.out.println("Coach: Rough practice... You looked weak today but, your head was really in the game.\nTake a break and rest, your body needs it.");
        }
      }
      else if(strength >= 80 && sanity >= 80)
      {
        skill += 1.6;
        System.out.println("Coach: Great practice! You looked great and your head was in the game.\nKeep it up!");
      }
      else if(strength >= 80 && sanity < 80)
      {
        if(sanity >= 70)
        {
          skill += 1.5;
          System.out.println("Coach: Good practice. You looked great and you're maintaning a healthy mental state.\nWell done.");
        }
        else if(sanity >= 60)
        {
          skill += 1.4;
		  System.out.println("Coach: Tough practice... You looked great but, you didn't look into it today.\nMake sure you're taking care of your sanity too.");
        }
        else if(sanity >= 50)
        {
          skill += 1.3;
		  System.out.println("Coach: Rough practice... You looked great but, your head wasn't in it at all today.\nWork on it.");
        }
      }
      else if(sanity >= 80 && strength < 80)
      {
        if(strength >= 70)
        {
          skill += 1.5;
		  System.out.println("Coach: Good practice. You looked good and your head was in the game.\nWell done.");
        }
        else if(strength >= 60)
        {
          skill += 1.4;
		  System.out.println("Coach: Tough practice... You weren't looking to good today but, your head was in the game.\nMake sure you're taking care of your body.");
        }
        else if(strength >= 50)
        {
          skill += 1.3;
		  System.out.println("Coach: Rough practice... You looked weak today, but your head was in the game.\nTake a break and rest, your body needs it.");
        }
      }
      else if(strength >= 70 && sanity >= 70)
      {
        skill += 1.4;
		System.out.println("Coach: Good practice. You looked good and you're maintaning a healthy mental state.\nWell done.");
      }
      else if(strength >= 70 && sanity < 70)
      {
        if(sanity >= 60)
        {
          skill += 1.3;
		  System.out.println("Coach: Tough practice... You looked good but, you didn't look into it today.\nMake sure you're taking care of your sanity too.");
        }
        else if(sanity >= 50)
        {
          skill += 1.2;
		  System.out.println("Coach: Rough practice... You looked good but, your head wasn't in it at all today.\nWork on it.");
        }
      }
      else if(sanity >= 70 && strength < 70)
      {
        if(strength >= 60)
        {
          skill += 1.3;
		  System.out.println("Coach: Tough practice... You weren't looking to good today but, you're maintaning a healthy mental state.\nMake sure you're taking care of your body.");
        }
        else if(strength >= 50)
        {
          skill += 1.2;
		  System.out.println("Coach: Rough practice... You looked weak today but, you're maintaning a healthy mental state.\nTake a break and rest, your body needs it.");
        }
      }
      else if(strength >= 60 && sanity >= 60)
      {
        skill += 1.2;
		System.out.println("Coach: Rough practice... You weren't looking to good today and you didn't look into it today.\nMake sure you're resting and getting your head in the right place.");
      }
      else if(strength >= 60 && sanity < 60)
      {
        skill += 1.1;
		System.out.println("Coach: Rough practice... You weren't looking to good today and your head wasn't in it at all today.\nTake a break to get your head and body back to normal.");
      }
      else if(sanity >= 60 && strength < 60)
      {
        skill += 1.1;
		System.out.println("Coach: Rough practice... You looked weak today and you didn't look into it today.\nTake a break to get your head and body back to normal.");
      }
      else if(sanity == 50 && strength == 50)
      {
        skill += 1;
		System.out.println("Coach: Take a break.");
      }
      stats();
    }
    else
    {
      if(strength < 50 || sanity < 50 || school < 50)
      {
        System.out.println("Narrator: You can not practice until all of your other stats are at least 50.");
      }
      else if(timeUsed > 3)
      {
        System.out.println("Narrator: You don't have enough time to practice today, try something else.");
      }
    }  
  }
  
  public void workout()
  {
    if(timeUsed <= 4 && sanity >= 50)
    {
      timeUsed += 1;
      if(strength != 100)
      {
        strength += (int)(9*Math.random() + 1);
        if(strength > 100)
        {
          strength = 100;
        }
      }
      
      System.out.println("Narrator: You worked out for one hour.");
      if(strength == 100 && sanity == 100)
      {
        skill += 1;
      }
      else if(strength == 100 && sanity < 100)
      {
        if(sanity >= 90)
        {
          skill += 0.9;
        }
        else if(sanity >= 80)
        {
          skill += 0.8;         
        }
        else if(sanity >= 70)
        {
          skill += 0.7;         
        }
        else if(sanity >= 60)
        {
          skill += 0.6;         
        }
        else if(sanity >= 50)
        {
          skill += 0.5;         
        }
      }
      else if(sanity == 100 && strength < 100)
      {
        if(strength >= 90)
        {
          skill += 0.9;       
        }
        else if(strength >= 80)
        {
          skill += 0.8;          
        }
        else if(strength >= 70)
        {
          skill += 0.7;          
        }
        else if(strength >= 60)
        {
          skill += 0.6;          
        }
        else if(strength >= 50)
        {
          skill += 0.5;          
        }
      }
      else if(strength >= 90 && sanity >= 90)
      {
        skill += 0.8;        
      }
      else if(strength >= 90 && sanity < 90)
      {
        if(sanity >= 80)
        {
          skill += 0.7;          
        }
        else if(sanity >= 70)
        {
          skill += 0.6;          
        }
        else if(sanity >= 60)
        {
          skill += 0.5;          
        }
        else if(sanity >= 50)
        {
          skill += 0.4;
        }
      }
      else if(sanity >= 90 && strength < 90)
      {
        if(strength >= 80)
        {
          skill += 0.7;          
        }
        else if(strength >= 70)
        {
          skill += 0.6;          
        }
        else if(strength >= 60)
        {
          skill += 0.5;          
        }
        else if(strength >= 50)
        {
          skill += 0.4;          
        }
      }
      else if(strength >= 80 && sanity >= 80)
      {
        skill += 0.6;        
      }
      else if(strength >= 80 && sanity < 80)
      {
        if(sanity >= 70)
        {
          skill += 0.5;          
        }
        else if(sanity >= 60)
        {
          skill += 0.4;          
        }
        else if(sanity >= 50)
        {
          skill += 0.3;          
        }
      }
      else if(sanity >= 80 && strength < 80)
      {
        if(strength >= 70)
        {
          skill += 0.5;          
        }
        else if(strength >= 60)
        {
          skill += 0.4;        
        }
        else if(strength >= 50)
        {
          skill += 0.3;        
        }
      }
      else if(strength >= 70 && sanity >= 70)
      {
        skill += 0.4;        
      }
      else if(strength >= 70 && sanity < 70)
      {
        if(sanity >= 60)
        {
          skill += 0.3;          
        }
        else if(sanity >= 50)
        {
          skill += 0.2;          
        }
      }
      else if(sanity >= 70 && strength < 70)
      {
        if(strength >= 60)
        {
          skill += 0.3;          
        }
        else if(strength >= 50)
        {
          skill += 0.2;          
        }
      }
      else if(strength >= 60 && sanity >= 60)
      {
        skill += 0.2;        
      }
      else if(strength >= 60 && sanity < 60)
      {
        skill += 0.1;       
      }
      else if(sanity >= 60 && strength < 60)
      {
        skill += 0.1;      
      }
      stats();
    }
    else
    {
      if(timeUsed > 4)
      {
        System.out.println("Narrator: You don't have enough time to workout today, try something else.");
      }
      else if(sanity < 50)
      {
        System.out.println("Narrrator: You can not practice until all of your other stats are at least 50");
      }
    }
  }
  
  public void homework()
  {
    if(timeUsed <= 4)
    {
      hwdone++;
      if(hwdone >= hwreq)
      {
        school += (int)(2*Math.random()+1);
        System.out.println("Narrator: It is good to see you focusing on school, it will pay off on your grades.");
      }
      else if(hwdone == hwreq)
      {
        System.out.println("Narrator: You have completed the necesary amount of schoolwork for the night.");
      }
      else
      {
        System.out.println("Narrator: You still have " + (hwreq - hwdone) + " hours of schoolwork to complete tonight.");
      }
      timeUsed++;
      stats();
    }
    else if(timeUsed > 4)
    {
      System.out.println("Narrator: You do not have enough time to do schoolwork right now. Try something else.");
    }
  }
  
  public void study()
  {
    if(timeUsed <= 4.5)
    {
      hwdone += 0.5;
      if(hwdone >= hwreq)
      {
        school += (int)(Math.random()+1);
        System.out.println("Narrator: It is good to see you focusing on school, it will pay off on your grades.");
      }
      else if(hwdone == hwreq)
      {
        System.out.println("Narrator: You have completed the necesary amount of schoolwork for the night.");
      }
      else
      {
        System.out.println("Narrator: You still have " + (hwreq - hwdone) + " hours of schoolwork to complete tonight.");
      }
      timeUsed += 0.5;
      stats();
    }
    else
    {
      System.out.println("Narrator: You do not have enough time to study right now. Try something else.");
    }
  }
  
  public void friends()
  {
    if(timeUsed <= 4)
    {
      System.out.println("Narrator: You hung out with friends for 1 hour.");
      sanity += 10;
      timeUsed ++;
      stats();
    }
    else
    {
      System.out.println("Narrator: You do not have enough time to see friends right now. Try something else.");
    }
  }
  
  public void rest()
  {
    if(timeUsed <= 4.5)
    {
      System.out.println("Narrator: You rested for 30 minutes.");
      strength += 10;
      timeUsed += .5;
      stats();
    }
    else
    {
      System.out.println("Narrator: You do not have enough time to rest right now. Try something else.");
    }
    stats();
  }
  
  public void videogame()
  {
    if(timeUsed <= 4.5)
    {
      System.out.println("Narrator: You played a videogame for 30 minutes.");
      sanity += 5;
      timeUsed += .5;
      stats();
    }
    else
    {
      System.out.println("Narrator: You do not have enough time to play games right now. Try something else.");
    }
  }
  
  public void family()
  {
    if(timeUsed <= 4.5)
    {
      int interaction = (int)(2*Math.random());
      sanity += 5;
      timeUsed += .5;
      if(interaction == 0)
      {
        System.out.println("Father: Do you want to play some chess?");
        System.out.println("You: Sure!");
        System.out.println("Father: Lets play outside on the deck.");
        System.out.println("You: Sounds great!");
        int randomNum = (int)(10000*Math.random());
        if(randomNum < 3333)
        {
          System.out.println("Narrator: After 30 minutes of chess ensues, your father beat you by a longshot.");
        }
        else if(randomNum < 6666)
        {
          System.out.println("Narrator: After 30 minutes of chess ensues, your father beat you pretty easily.");
        }
        else if(randomNum < 9998)
        {
          System.out.println("Narrator: After 30 minutes of chess ensues, your father beat you in a close game.");
        }
        else if(randomNum == 9999)
        {
          System.out.println("Narrator: Congratulations you actually beat him, you have won in life.");
          sanity = 100;
          strength = 100;
          school = 100;
        }
      } 
      else if(interaction == 1)
      {
        System.out.println("Brother: Wanna watch some tv?");
        System.out.println("You: Sure, let's watch some Breaking Bad.");
        System.out.println("Narrator: 30 minutes of Breaking Bad ensues.");
      }
      stats();
    }
    else
    {
      System.out.println("Narrator: You do not have enough time to see family right now. Try something else.");
    }
    
  }
  
  public void schedule()
  {
    System.out.println();
    System.out.println("You have games on:");
    for(int i = 0; i < 90; i++)
    {
      if(games[i] == true)
      {
        System.out.println(days[i]);
      }
	}
  }
  
  public void stats()
  {
    System.out.println();
    System.out.println("Here are your current stats:");
    System.out.println("Skill: " + skill);
    System.out.println("School: " + school);
    System.out.println("Sanity: " + sanity);
    System.out.println("Strength: " + strength);
    System.out.println("Day: " + days[currentDay]);
    System.out.println("Time Left: " + (5 - timeUsed) + " hours left");
  }
  
  public void playGame()
  {
    System.out.println("Narrator: Today you have a game against " + names[currentGame] /*set home/away in intro later*/);
    int wchance = (int)(100*Math.random());
    if(sanity < 50 || strength < 50)
    {
      System.out.println("Coach: I'm not satisfied with the loss we had today, figure out what's wrong.");
      lossCount++;
      sanity -= (int)((5*Math.random()) + 5);
      skill -= 3;
    }
    else if(wchance <= 50)
    {
      System.out.println("Coach: It was a battle but a tough loss, we'll get them next time.");
      lossCount++;
      sanity -= (int)((5*Math.random()) + 5);
      skill -= 3;
    }
    else if(wchance > 50)
    {
      System.out.println("Coach: Congrats on the win! Let's get back to work soon!");
      winCount++;
      sanity += (int)((5*Math.random()) + 5);
      skill += 2;
    }
    strength -= (int)(10*Math.random());
    stats();
    timeUsed = 5;
  }
  
  public void nextDay()
  {
    System.out.println("\nNarrator: It looks like your all done for the night, time to wrap up and head to bed.");
    currentDay++;
    if(hwdone < hwreq)
    {
      sanity -= 10;
      school -= 10;
    }
    if(hwdone > hwreq)
    {
      school += hwdone*2;
    }
    timeUsed = 0;
    hwdone = 0;
    hwreq = (int)(Math.random()+1);
    System.out.println("\nNarrator: You've woken up and gone to school, time to start your day!" + "\nYour teachers have given you " + hwreq + " hours of work tonight");
  }

  public void saveGame()
  {
    try 
    {
      PrintWriter outputStream = new PrintWriter(new FileOutputStream("volleysave.txt"));
      outputStream.println(Double.toString(skill));
      outputStream.println(Double.toString(sanity));
      outputStream.println(Double.toString(school));
      outputStream.println(Double.toString(strength));
      for(int i = 0; i < 20; i++)
      {
        outputStream.println(names[i]);
      }
      for(int i = 0; i < 90; i++)
      {
         outputStream.println(days[i]);
      }
      for(int i = 0; i < 90; i++)
      {
        outputStream.println(Boolean.toString(games[i]));
      }
      outputStream.println(Double.toString(hwdone));
      outputStream.println(Double.toString(hwreq));
      outputStream.println(Integer.toString(currentGame));
      outputStream.println(Integer.toString(winCount));
      outputStream.println(Integer.toString(lossCount));
      outputStream.println(Integer.toString(currentDay));
      outputStream.print(Double.toString(timeUsed));
      outputStream.close();
      }
      catch(FileNotFoundException e)
      {
      System.out.println("Error opening the file");
      System.exit(0);
      }
  }
  
  public void gameEnd()
  {
    
  }
  
  
  
  //shows schedule to user
  public void actions(String option)
  {
    if(option.equals("!help"))
    {
      help();
    }
    
    else if(option.equals("!practice"))
    {
      practice();
    }
    
    else if(option.equals("!workout"))
    {
      workout();
    }
    
    else if(option.equals("!homework"))
    {
      homework();
    }
    
    else if(option.equals("!study"))
    {
      study();
    }
    
    else if(option.equals("!friends"))
    {
      friends();
    }
    
    else if(option.equals("!rest"))
    {
      rest();
    }
    
    else if(option.equals("!videogame"))
    {
      videogame();
    }
    
    else if(option.equals("!family"))
    {
      family();
    }
    
    else if(option.equals("!schedule"))
    {
      schedule();
    }
    
    else if(option.equals("!stats"))
    {
      stats();
    }
    else if(option.equals("goToGame"))
    {
      playGame();
    }
    
  }
  
  public double getSkill()
  {
    return skill;
  }
  
  public double getSanity()
  {
    return sanity;
  }
  
  public double getSchool()
  {
    return school;
  }
  
  public double getStrength()
  {
    return strength;
  }
  public boolean getGame()
  {
    return games[currentDay];
  }
  public double getTime()
  {
    return timeUsed;
  }
  
}

/*


*/
  
  
  