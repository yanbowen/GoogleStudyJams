#Android 开发艺术探索  
---
## 第一章  
###Activity 的生命周期  
* 当启动一个新的Activity时，旧Activity的onPause方法会先执行，然后才会启动新的Activity的onCreate，onStart，onResume；  
![](http://i.imgur.com/KGtVEmo.png)   
* Activity在异常状态下终止，系统会调用onSaveInstanceState方法来保存当前Activity的状态，这个方法的调用时机是在onStop之前，它和onPause没有既定的时序关系。
* 每个View都有OnSaveInstanceState和onRestoreInstanceState这个两个方法，Activity重建后系统会调用onRestoreInstanceState，获取到保存的Bundle对象。  
![](http://i.imgur.com/5keSn4K.png)   
* 当系统配置发生变化后，Activity会被重启，若不想重启，可设置Activity的ConfigChanges属性。   
![](http://i.imgur.com/vKiXWn8.png)  
###Activity的启动模式  
####给Activity指定启动模式有两种方法：   
#####第一种通过AndroidMenifest  
![](http://i.imgur.com/pGNfrCL.png)  
#####第二种通过Intent中设置标志位  
![](http://i.imgur.com/521Ao98.png)   

* 第二种方法的优先级要高于第一种  
####Activity启动4种模式：  
* 1. standard：标准模式
* 2. singleTop:栈顶复用模式
* 3. singleTask:栈内复用模式---singleTask模式的Activity切换到栈顶会导致它之上的栈内的Activity出栈。
* 4. singleInstance：单实例模式   

通过执行`adb shell dumpsys activity`命令：
![](http://i.imgur.com/AkTeGgv.png)  

* 可以看出去掉singleTask后，连续点击3次，出现了2个任务栈，前台任务栈是第一个红框，里面有4个Activity，后台任务栈是第二个红框，是Android桌面。  
* 
