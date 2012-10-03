SimpleUptime
Android Widget (2.1+)

This widget shows the uptime and load averages of a given web server (or server with LAMP/similar). It is supposed to refresh as often as the user would like…read below.

I am going to open the door for someone to help me out with this. This is my first Android project and it is giving me fits. I can't find any good resources out there for what I am trying to accomplish. Much of it involves using AlarmManagers (I think) and this widget simply won't update… not even on 30 minute intervals like it should by default. 

The core code is there. Installation is two parts, first is the APK and the second is putting the uptime folder in the root of your web server. I want to have the widget go to a configuration page upon initializing so that the user can enter the URL of their web server, but that is something I haven't been able to find a good resource for either.

I'm just throwing this up hoping someone will see it and throw me a bone. 

Licensed under Creative Commons 2012.

TESTING SERVER:

                          .oyhhs:   User: aaron
                 ..--.., shhhhhh-   Hostname: the5thpixel
               -+++++++++`:yyhhyo`  OS: Ubuntu 10.10 i686
          .--  -++++++++/-.-::-`    Kernel: 2.6.35-32-generic-pae
        .::::-   :-----:/+++/++/.   Uptime: 1 day, 14:42
       -:::::-.          .:++++++:  Shell: Bash
  ,,, .:::::-`             .++++++- Terminal: Xterm-256color
./+++/-`-::-                ./////: Packages: 1439
+++++++ .::-                        CPU: Intel(R) Pentium(R) 4 CPU 2.40GHz
./+++/-`-::-                :yyyyyo RAM: 177 MB / 999 MB
  ``` `-::::-`             :yhhhhh: Disk: 46G / 144G
       -:::::-.         `-ohhhhhh+  
        .::::-` -o+///+oyhhyyyhy:   
         `.--  /yhhhhhhhy+,....     
               /hhhhhhhhh-.-:::;    
               `.:://::- -:::::;    
                         `.-:-'   