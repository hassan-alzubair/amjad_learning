package com.hassan.firstapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class OrdersRecycleAdapter(private val context: Context, private val orders: List<Order>) :
    RecyclerView.Adapter<OrdersRecycleAdapter.OrderViewHolder>() {


    private var listener: OnOrderClickListener? = null

    fun setOnOrderClickListener(listener: OnOrderClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.note_list_item, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int = orders.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]

        holder.orderIdTextView.text = "${order.orderId}"
        holder.itemNameTextView.text = order.iteName
        holder.clientNameTextView.text = order.clientName
        holder.qtyTextView.text = "${order.qty}"
        holder.priceTextView.text = "${order.price}"

        if(order.qty < 3){
            holder.qtyTextView.setTextColor(
                ContextCompat.getColor(
                    context,
                    android.R.color.holo_red_dark
                )
            )
        }

        holder.itemView.setOnClickListener { listener?.onOrderClicked(order) }
    }

    class OrderViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val orderIdTextView = v.findViewById<TextView>(
            R.id.orderIdTextView
        )
        val itemNameTextView = v.findViewById<TextView>(
            R.id.itemNameTextView
        )
        val clientNameTextView = v.findViewById<TextView>(
            R.id.clientNameTextView
        )
        val qtyTextView = v.findViewById<TextView>(
            R.id.qtyTextView
        )
        val priceTextView = v.findViewById<TextView>(
            R.id.priceTextView
        )
    }

    interface OnOrderClickListener{
        fun onOrderClicked(order: Order)
    }
}