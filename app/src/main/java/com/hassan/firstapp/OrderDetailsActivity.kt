package com.hassan.firstapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.order_details_activity.*

class OrderDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_details_activity)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val intent = intent
        val order : Order = intent.getSerializableExtra("order") as Order
        supportActionBar?.title = "Order Number ${order.orderId}"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        orderIdTextView.text = order.orderId.toString()
        clientNameTextView.text = order.clientName
        qtyTextView.text = order.qty.toString()
        itemNameTextView.text = order.iteName
        priceTextView.text = order.price.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}