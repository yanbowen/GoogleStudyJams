#Android 开发艺术探索  
---
## 第一章：Activity 启动模式  
* 当启动一个新的Activity时，旧Activity的onPause方法会先执行，然后才会启动新的Activity的onCreate，onStart，onResume；  
![](http://i.imgur.com/KGtVEmo.png)   
* Activity在异常状态下终止，系统会调用onSaveInstanceState方法来保存当前Activity的状态，这个方法的调用时机是在onStop之前，它和onPause没有既定的时序关系。
* 每个View都有OnSaveInstanceState和onRestoreInstanceState这个两个方法，Activity重建后系统会调用onRestoreInstanceState，获取到保存的Bundle对象。  
![](http://i.imgur.com/5keSn4K.png)   


