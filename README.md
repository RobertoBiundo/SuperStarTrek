# SuperStarTrek Android
A "non-faithful" replica of the original Super Star Trek 1970

# Introduction
This project was created with the intent of creating a replica of the original Super Star Trek game from 1970 that can be used in modern smartphones (Android specifically)

This version of the game is not a faithful reproduction. Several changes have been made to the game to ensure that is compatible with the device screens, touch interaction and the general fact that writing text commands on a smartphone is not as easy as it is on a computer. However, non if the changes contradict the original spirit of the game as proposed by the original developers

# What works
- Game main command selection menu
- World generation
- Short range scans
- Long range scans
- Charts

# What does not work
- Any other command

# How to build
1. Download the git repository to your local machine
2. Open the project in Android Studio
3. Create a Virtual Device or connect a physical Android over USB (if a physical device is used ensure you enable USB debugging under development tools in the device)
4. Click Run

# Would APK builds be available in the future?
Yes. There will be a CI/CD to build the project and generate releases when the time comes

# Is the game available in the Google Play Store?
Not at the moment. When the initial development is complete the game will be available in the Google Play Store

# A note about the code
The code base shared here was not intended to be a "clean" development and you will certainly find your share of anti-patterns and possible possible improvements. If you feel keen to it.Please feel free to submit a pull request

# Contributors
Thanks to [Tom Almy](https://almy.us/) --- (who did a port of the game to C) for making possible to get some valuable insight into the original game, its developers and the intent they had when writing the original code in Fortran
