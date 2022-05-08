~$ mkdir Coordinates-Location
~$ mkdir North
~$ cd North
~/North$ gedit NDegree.txt
~/North$ gedit NMinutes.txt
~/North$ gedit NSeconds.txt
~/North$ gedit NorthCoordinate.txt
~/North$ cp NorthCoordinate.txt /home/z0d/Coordinates-Location
~/North$ cd ~
~$ cd Coordinates-Location
~/Coordinates-Location$ mv NorthCoordinate.txt North.txt
~/Coordinates-Location$ mkdir East
~/Coordinates-Location$ cd East
~/Coordinates-Location/East$ gedit EDegree.txt
~/Coordinates-Location/East$ gedit EMinutes.txt
~/Coordinates-Location/East$ gedit ESeconds.txt
~/Coordinates-Location/East$ gedit EastCoordinate.txt
~/Coordinates-Location/East$ cp EastCoordinate.txt /home/z0d/Coordinates-Location
~/Coordinates-Location/East$ cd ~
~$ cd Coordinates-Location
~/Coordinates-Location$ mv EastCoordinate.txt East.txt
~/Coordinates-Location$ mv /home/z0d/North /home/z0d/Coordinates-Location
~/Coordinates-Location$ gedit Location-Coordinate.txt

