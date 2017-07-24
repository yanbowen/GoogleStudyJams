#Android 开发艺术探索  
---
## 第二章  
###Android IPC简介  
* IPC是Inter-Process Communication的缩写，含义：进程间通信，指两个进程之间进行数据交换的过程。  
* 线程是CPU调度的最小单元，同时线程是一种有限资源系统资源。  
* 进程一般指一个执行单元，在PC和移动设备上指一个程序或者一个应用。  
<center>__一个进程可以包含多个线程，也可以只有一个线程，即主线程，在Android里面主线程也叫UI线程。__</center>  
* __ANR__:Application Not Responding,即应用无响应。  
  
在Android中使用多进程只有一种方法，那就是给四大组件（Activity、Service、Receiver、ContentProvider）中指定android:process属性。另一种不常用的是通过JNI在native层去fork一个新的进程。  
进程名以“：”开头的进程属于当前应用的私有进程，其他应用的组件不可以和它跑在同一个进程中，而进程名不以“：”开始的属于全局进程，其他应用通过ShareUID方式可以和它跑在同一个进程中。  
#####一般来说，多进程会造成如下几个方面的问题  
* 静态成员和单例模式完全失效  
* 线程同步机制完全失效  
* SharePreferences的可靠性下降。  
* Application会多次创建  
因为不是同一块内存，所以不管是锁对象还是锁全局类都无法保证线程同步，SharePreferences不支持两个进程同时去执行写操作，会导致一定几率数据丢失，这是因为SharePreferences底层是通过读/写XML文件来实现的，并发写显然是会出问题的。  
#####跨进程通信方式：   
* Intent传递消息  
* 共享文件  
* SharePreferences  
* 基于Binder的Messenger  
* AIDL及Socket  
#####Serializable接口  
Serializable是Java所提供的一个序列化接口，它是一个空接口，为对象提供标准的序列化和反序列化操作。操作方法只需该类实现Serializable接口并声明一个SerialVersionUID,如下则是自动序列化过程：  

    private static final long serialVersionUID = 6587943156456215786L  
#####序列化：将对象的状态信息转换为可以存储或传输的形式的过程。在序列化期间，对象将其当前状态写入到临时或持久性存储区。以后可以通过从存储区中读取或反序列化对象的状态，重新创建该对象。  
_对于任何可能包含重要的安全性数据的对象，如果可能，应该使该对象不可序列化。如果它必须为可序列化的，请尝试生成特定字段来保存不可序列化的重要数据。如果无法实现这一点，则应注意该数据会被公开给任何拥有序列化权限的代码，并确保不让任何恶意代码获得该权限。_  
