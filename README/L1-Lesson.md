##IDEA的笔记L1  

###Android中View和ViewGroup介绍  
* Android中的View与我们以前理解的“视图”不同。在Android中，View比视图具有更广的含义，它包含了用户交互和显示，更像Windows操作系统中的window。  
* ViewGroup是View的子类，所以它也具有View的特性，但它主要用来充当View的容器，将其中的View视作自己的孩子，对它的子View进行管理，当然它的孩子也可以是ViewGroup类型。  
![](http://i.imgur.com/fSKfuip.png)
###LinearLayout(线性布局)  
* android:orientation="vertical" _垂直线性布局_ , "horizontal" _水平线性布局_   

####android:gravity 与 android:layout_gravity的区别  
* android:gravity是指定本元素的子元素相对它的对齐方式。  
* android:layout_gravity是指定本元素相对它的父元素的对齐方式。  
####gravity  
#####android:gravity="top"(buttom、left、right、center_vertical、fill_vertical、center_horizontal、fill_horizontal、center、fill、clip_vertical、clip_horizontal)控制布局中控件的对齐方式。  
* 如果是没有子控件的控件设置此属性，表示其内容的对齐方式，比如说TextView里面文字的对齐方式；  
* 若是有子控件的控件设置此属性，则表示其子控件的对齐方式，gravity如果需要设置多个属性值，需要使用“|”进行组合；   
#####android:layout_weight  
* 通过设置控件的layout_weight属性以控制各个控件在布局中的相对大小。  
* 线性布局会根据该控件layout_weight值与其所处布局中所有控件weight值之和的比值为该控件分配占用的区域。  

**android:layout\_weight的真实含义是:一旦View设置了该属性(假设有效的情况下)，那么该View的宽度等于原有宽度(android:layout\_width)加上剩余空间的占比！**  
#####我画了个小Demo 仅供参考
![](http://i.imgur.com/uyU5RsN.png)    
  
###RelativeLayout(相对布局)   
####相对布局常用属性介绍  
> 第一类:属性值为true或false  
　　android:layout\_centerHrizontal 水平居中  
　　android:layout\_centerVertical 垂直居中  
　　android:layout\_centerInparent 相对于父元素完全居中  
　　android:layout\_alignParentBottom 贴紧父元素的下边缘  
　　android:layout\_alignParentLeft 贴紧父元素的左边缘   
　　android:layout\_alignParentRight 贴紧父元素的右边缘  
　　android:layout\_alignParentTop 贴紧父元素的上边缘    
  
> 第二类：属性值必须为id的引用名“@id/id-name”  
　　android:layout\_below 在某元素的下方  
　　android:layout\_above 在某元素的的上方  
　　android:layout\_toLeftOf 在某元素的左边   
　　android:layout\_toRightOf 在某元素的右边  
　　android:layout\_alignTop 本元素的上边缘和某元素的的上边缘对齐  
　　android:layout\_alignLeft 本元素的左边缘和某元素的的左边缘对齐  
　　android:layout\_alignBottom 本元素的下边缘和某元素的的下边缘对齐  
　　android:layout\_alignRight 本元素的右边缘和某元素的的右边缘对齐    
  
> 第三类：属性值为具体的像素值，如30dip，40px  
　　android:layout\_marginBottom 离某元素底边缘的距离  
　　android:layout\_marginLeft 离某元素左边缘的距离  
　　android:layout\_marginRight 离某元素右边缘的距离  
　　android:layout\_marginTop 离某元素上边缘的距离    

#####同样画了个小Demo 仅供参考  
![](http://i.imgur.com/ifWx3KM.png)   
####代码奉上  
    <?xml version="1.0" encoding="utf-8"?>
	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:id="@+id/Center"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Center"
        android:layout_centerInParent="true"
        android:width="120dp"
        android:height="120dp"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Up"
        android:layout_above="@id/Center"
        android:layout_centerHorizontal="true"
        android:width="120dp"
        android:height="80dp"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Down"
        android:layout_below="@id/Center"
        android:layout_centerHorizontal="true"
        android:width="120dp"
        android:height="80dp"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Lift"
        android:layout_toLeftOf="@id/Center"
        android:layout_centerVertical="true"
        android:width="80dp"
        android:height="120dp"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Right"
        android:layout_toRightOf="@id/Center"
        android:layout_centerVertical="true"
        android:width="80dp"
        android:height="120dp"/>
	</RelativeLayout>
  
####1C代码练习  
![](http://i.imgur.com/4wulEtj.png)
  
* android:fontFamily  安卓字体  
* android:textStyle="italic|bold"  倾斜加粗