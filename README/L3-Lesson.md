#IDEA的笔记L3  
---

###知识总结  

###编译后运行效果图：
![](http://i.imgur.com/chtaaxO.png)

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
        String name = "NO Name";
        EditText nameField = (EditText) findViewById(R.id.name_field);
        if (!nameField.getText().toString().equals("")) {
            name = nameField.getText().toString();
        }

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean haswhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        Boolean haschocolate = chocolateCheckBox.isChecked();

        displayMessage(createOrderSummary(name, haswhippedCream, haschocolate, calculatePrice(haswhippedCream, haschocolate)));
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
        return basePrice;
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

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
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