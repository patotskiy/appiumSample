appiumSample
============

Requirements:
1.	Appium 12+ ( https://bitbucket.org/appium/appium.app/downloads/ )
2.	Chromedriver 2.2 ( http://chromedriver.storage.googleapis.com/index.html )
3.	Emulator or device with root permissions
4.	Chrome stable version on device (https://www.dropbox.com/s/fwaz3ott4jzvrrr/Google_Chrome_v27_0_1453_90_stable.apk )
Configuration:
After extracting chromedriver add the path in system variables. If you configure all correct , execute command : 
For Windows : “where chromedriver”  
For Mac and Linux: “whereis chromedriver”
And you should see path to chromedriver;

For root device you should grant access to folder /data/local
Type in terminal: 
1.	adb shell
2.	su
3.	chmod 777 /data/local

Project:
WebDriver Capabilities: 
  For Android:
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("app", "chrome");
  For iOs:
       capabilities.setCapability("device", "iPhone Simulator");
       capabilities.setCapability("app", "safari");

