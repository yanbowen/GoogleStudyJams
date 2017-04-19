#IDEA的笔记L3  
---

###知识总结  

###编译后运行效果图：
![](http://i.imgur.com/Awh5YKt.png)  
![](http://i.imgur.com/MxNDHC4.png)

### MainActivity代码  

	/**
 	 * This app displays an order form to order coffee.
	 */
	public class MainActivity extends ActionBarActivity {

    private int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myjustjava);
    }

    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "喝这么多你会睡不着觉的！！！", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "就剩一杯了你还想怎么样！！！", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String name = "NO Name";
        EditText nameField = (EditText) findViewById(R.id.name_field);
        if (!nameField.getText().toString().equals("")) {
            name = nameField.getText().toString();
        }

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean haswhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        Boolean haschocolate = chocolateCheckBox.isChecked();

        String message = createOrderSummary(name, haswhippedCream, haschocolate, calculatePrice(haswhippedCream, haschocolate));

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice(boolean addwhippedCream, boolean addchocolate) {
        int basePrice = 5;

        if (addwhippedCream) {
            basePrice = basePrice + 1;
        }

        if (addchocolate) {
            basePrice = basePrice + 2;
        }
        return basePrice * quantity;
    }

    /**
     * Create summary of the order.
     *
     * @param price           of the order
     * @param haswhippedCream whether there is whipped Cream
     * @return text summary
     */
    private String createOrderSummary(String name, boolean haswhippedCream, boolean haschocolate, int price) {
        String priceMessage = "Name: " + name + "\nAdd Whipped Cream? " + haswhippedCream + "\nAdd Chocolate? " + haschocolate + "\nQuantity: " + quantity + "\nAmount Due $ " + price + "\nThank you !";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

	}  

  
### XML代码  
    <?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@android:color/white">

        <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:padding="16dp">

            <EditText
                android:id="@+id/name_field"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />

            <TextView
                android:id="@+id/toppings_text"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_below="@+id/name_field"
                android:layout_marginTop="12dp"
                android:text="Toppings"
                android:textAllCaps="true"
                android:textSize="18sp" />

            <CheckBox
                android:id="@+id/whipped_cream_checkbox"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_below="@+id/toppings_text"
                android:layout_centerHorizontal="true"
                android:layout_marginTop="12dp"
                android:duplicateParentState="false"
                android:paddingLeft="24dp"
                android:text="Whipped Cream"
                android:textSize="16sp" />

            <CheckBox
                android:id="@+id/chocolate_checkbox"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_below="@+id/whipped_cream_checkbox"
                android:layout_centerHorizontal="true"
                android:layout_marginTop="12dp"
                android:duplicateParentState="false"
                android:paddingLeft="24dp"
                android:text="Chocolate"
                android:textSize="16sp" />

            <TextView
                android:id="@+id/quantity_text"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_below="@+id/chocolate_checkbox"
                android:layout_marginTop="12dp"
                android:text="Quantity"
                android:textAllCaps="true"
                android:textSize="18sp" />

            <LinearLayout
                android:id="@+id/linear_layout_view_group"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_below="@+id/quantity_text"
                android:layout_centerInParent="true"
                android:layout_marginTop="12dp"
                android:orientation="horizontal">

                <Button
                    android:layout_width="48dp"
                    android:layout_height="48dp"
                    android:layout_marginRight="18dp"
                    android:background="@android:color/holo_blue_light"
                    android:onClick="increment"
                    android:text="+"
                    android:textColor="@android:color/white" />

                <TextView
                    android:id="@+id/quantity_text_view"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginRight="18dp"
                    android:text="2"
                    android:textColor="@android:color/black"
                    android:textSize="16sp" />

                <Button
                    android:layout_width="48dp"
                    android:layout_height="48dp"
                    android:background="@android:color/holo_blue_light"
                    android:onClick="decrement"
                    android:text="-"
                    android:textColor="@android:color/white" />

            </LinearLayout>

            <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_alignParentRight="true"
                android:layout_below="@id/linear_layout_view_group"
                android:layout_marginTop="12dp"
                android:background="@android:color/holo_blue_light"
                android:onClick="submitOrder"
                android:text="Order"
                android:textColor="@android:color/white" />

        </RelativeLayout>
    </ScrollView>
	</LinearLayout>