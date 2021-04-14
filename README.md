# 1MoreRep
Description: 1MoreRep is a Java application allowing fitness lovers and starters to set their target weight, and check if they are on the right track based on their nutrition intake and workout. 1MoreRep gets input from users and does some calculations to help guide them to a healthier lifestyle. The target audience are fitness enthusiasts or starters who want to keep track of their fitness progress and goals.

## How to run the program

1. Make sure you have the latest Java version installed
2. Open up your command line/terminal
3. After cloning this project, go into the project-1morerep folder, run `git checkout development`, if you are not on the branch already
4. Allow execution permission for the starting script. Run `chmod +x runscript.sh`
5. Run the script `./runscript.sh` 

Or

Open Eclipse, import the git repo and run Entry.java in onemorerep package

Tips:
You should first choose the beginning of the day and then calculate my BMR to enter personal information.
Otherwise, the caluculate calories burned from workout option may end in error.

## Key features

- Users can calculate their basic BMR with personal information, calories taken in and calories burned
- Two options: beginning of the day vs end of the day
  - Beginning of the day: tells the user the amount of calories to burn
  - End of the day: 
    - Users put what they ate and what exercises they did
    - Calculates the target calories to burn - calories the user burnt (Not implemented yet)
    - Tells the user whether they need to exercise more or not (Not implemented yet)


## Iteration #1 Write up

**What user stories were completed this iteration?**
- A user can see a complete menu in the command line.
- A user can choose the beginning of the day option to calculate his or her BMR.
- A user can choose the end of the day option to operate with food log or exercise log.
- A user can add a food record or view food log summary.

**What user stories do you intend to complete next iteration?**
- We will finish implementing the end of the day functionality with calculations

**Is there anything that you implemented but doesn't currently work?**
- We talked in class not to worry about testing the user interface so we probably might have to see how to test the user input.

**What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)**
- Please refer to the section above to see how to run the program.




## Iteration #2 Write up

**What user stories were completed this iteration?**
- A user can add different kinds of exercise to their record, like bicycling, JumpingRope etc.
- A user can view his or her exercise summary in the menu option.
- Checkout 'gui' branch to see the "incomplete" (complete but not merged to development because some features are halfway there) GUI using Java Swing. Users can see a Welcome screen and can choose the Main Menu in GUI.

**What user stories do you intend to complete next iteration?**
- Continue with implementing the rest of the GUI so we have full transition from command-line-based application to a better UI interface.
- Calculate daily calorie balance according to the calories burned and the calories taken in, which is menu option "Summary of the day".
- Store user information to avoid error if the user do not start with the beginning of the day option

**Is there anything that you implemented but doesn't currently work?**
- GUI is still in the process.

**What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)**
- Please refer to the section above to see how to run the program.
