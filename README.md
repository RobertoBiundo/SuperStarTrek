# SuperStarTrek

### Project Status
[![Generate a Sign APK](https://github.com/RobertoBiundo/SuperStarTrek/actions/workflows/build_signed.yml/badge.svg?branch=main)](https://github.com/RobertoBiundo/SuperStarTrek/actions/workflows/build_signed.yml)
[![Run Tests](https://github.com/RobertoBiundo/SuperStarTrek/actions/workflows/test.yml/badge.svg?branch=main)](https://github.com/RobertoBiundo/SuperStarTrek/actions/workflows/test.yml)

# About
This is an android clone of the original Super Star Trek from 1971 which was as best described by [Tom Almy](https://almy.us/sst.html) as 

> ... the best of the "Star Trek" games from the 1970's. Of course, it does not make use of graphics, or even assume a video display, but it still an interesting game to play, particularly for those of us who don't have the reflexes we used to and prefer a more cerebral computer game.

Me deepest thanks to all of the original developers of the Fortran code and to all of the porters and maintainers of the game over the years.

This version of the game, although fully graphical (due to android UX limitation) attempts to be a more or less faithful clone of the original game, but it is not a perfect clone. Keyboard interactions have been replaced with more touch friendly controls while keeping the text interface the same.

As with the original game, I plan to maintain the source code of this one as clean as possible, and as professional as possible, giving any developer a full view of how proper programming and project management and documentation is done. I will keep this also as simple as possible since i'm currently the only developer and maintainer and I'm not sure how much time I'll have to spend on this project.

## Why build this game in 2022?
Because it is a fun game. I have played this years, and every once in a while I come back to it just to remind myself of how much fun you can have by using your imagination and simple text.

Today games have amazing graphics and require powerful hardware to run, but it is of my opinion that fun does not linearly scale up with transistor count and shader pipelines.

# Current State and releases
The game is very much under development. If you whish to participate read the "Contributing" section. I would highly appreciate any help and feedback.

The game will be available on the Google Play Store as soon as it is considered "complete", in the meanwhile you can download from github the APK releases and try it yourself. You can also download the source code and build it if you want to figure out how that works check the "Building" section.

# Building from source
This is a standard Android Native project. In order to build from source you can do it by either the command line or the Android Studio using the gradle build system.

    gradle build

or by simply loading the project in Android Studio and pressing the "Build" button

# Contributing
Feel free to contribute to this project. If you want to contribute to the game, you can either fork the repository and make your own changes, or you can submit a pull request. I'll be happy to review your pull request and if it's accepted I'll merge it into the master branch.

When contributing, please make sure you follow the design of the original game. If you want the source code in C please visit [Tom Almy's website](https://almy.us/sst.html)

Please keep in mind that all pull request should be properly covered by unit tests in order to be accepted and to maintain code quality.