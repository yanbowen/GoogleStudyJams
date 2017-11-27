# IDEA的笔记L2  
---

### 知识总结  
	android:textAllCaps="true"  
	变量作用域 ： Variable scope  
### 个人觉得视频里的布局太丑了，所有自己改了下：
![](http://i.imgur.com/S1ROAck.png)   

### MainActivity代码  

		/**
		 * This app displays an order form to order coffee.
		 */
		public class MainActivity extends ActionBarActivity {

		private int quantity = 0;

		@Override
    	protected void onCreate(Bundle savedInstanceState) {
        	super.onCreate(savedInstanceState);
        	setContentView(R.layout.myjustjava);
    	}

    	public void increment(View view) {
        	quantity = quantity + 1;
        	display(quantity);
    	}

    	public void decrement(View view) {
        	quantity = quantity - 1;
        	display(quantity);
    	}

    	/**
     	 * This method is called when the order button is clicked.
     	 */
    	public void submitOrder(View view) {
        	display(quantity);
        	displayPrice(quantity * 5);
    	}

    	/**
     	 * This method displays the given quantity value on the screen.
     	 */
    	private void display(int number) {
        	TextView quantityTextView = (TextView) findViewById(
                	R.id.quantity_text_view);
        	quantityTextView.setText("" + number);
    	}

		//    @TargetApi(Build.VERSION_CODES.N)
		//    private void displayPrice(int number){
		//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
		//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    	@TargetApi(Build.VERSION_CODES.N)
    	private void displayPrice(int number) {
        	TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        	priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    	}
	}
#### @SuppressLint("NewApi"）和@TargetApi()的区别  
在Android代码中，我们有时会使用比我们在AndroidManifest中设置的android:minSdkVersion版本更高的方法，此时编译器会提示警告，解决方法是在方法上加上@SuppressLint("NewApi"）或者@TargetApi()。  

那他们之间有什么区别呢，很简单，

@SuppressLint("NewApi"）屏蔽一切新api中才能使用的方法报的android lint错误

@TargetApi() 只屏蔽某一新api中才能使用的方法报的android lint错误

举个例子，某个方法中使用了api9新加入的方法，而项目设置的android:minSdkVersion=8，此时在方法上加@SuppressLint("NewApi"）和@TargetApi(Build.VERSION_CODES.GINGERBREAD)都可以，以上是通用的情况。

而当你在此方法中又引用了一个api11才加入的方法时，@TargetApi(Build.VERSION_CODES.GINGERBREAD)注解的方法又报错了，而@SuppressLint("NewApi"）不会报错，这就是区别。    

当然，不管你使用了哪个注解，作用仅仅是屏蔽android lint错误，所以在方法中还要判断版本做不同的操作，比如：

	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {  
			//  some code
	} else {// Pre GINGERBREAD  
            //  some code
	}   
#### java转义字符表  
![](http://i.imgur.com/fHPfLRw.png)   
