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

## Key featuers

- Users put age, weight, height, and target weight
- Two options: beginning of the day vs end of the day
  - Beginning of the day: tells the user the amount of calories to burn
  - End of the day: 
    - Users put what they ate and what exercises they did
    - Calculates the target calories to burn - calories the user burnt
    - Tells the user whether they need to exercise more or not


## Iteration #1 Write up

**What user stories were completed this iteration?**
- A few unit tests for computing BMRs, testing food logs, and testing food. More unit tests need to be written but we have enough for the code we wrote.
- Created objects and interfaces for Exercises, Food, and User
- Created Entry class to run the program and initialize different Menus

**What user stories do you intend to complete next iteration?**
- We will finish implementing the end of the day functionality with calculations

**Is there anything that you implemented but doesn't currently work?**
- We talked in class not to worry about testing the user interface so we probably might have to see how to test the user input.

**What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)**
- Please refer to the section above to see how to run the program.


