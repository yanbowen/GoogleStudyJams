package com.example.yanbowen.googlestudyjams;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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