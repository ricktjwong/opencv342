# pHash
Simple OpenCV java program to test in a circleci environment with a custom opencv-java docker image

Steps to test:
  - The program will fail if executed locally as it requires OpenCV dependencies which have to be installed
  - Install `circleci` and `docker`
  - `git clone https://github.com/ricktjwong/pHash.git`
  - `cd` into the directory
  - run `circleci build`
