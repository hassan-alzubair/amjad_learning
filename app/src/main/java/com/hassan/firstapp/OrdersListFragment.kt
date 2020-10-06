package com.hassan.firstapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.orders_list_fragment.*

class OrdersListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.orders_list_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val orders = listOf(
            Order(1, "Hassan", 10.0, "Laptop", 1),
            Order(2, "Amjed", 50.0, "cat", 2),
            Order(3, "Ali", 100.0, "pc", 10),
            Order(4, "Mohammed", 200.0, "mouse", 15)
        )

        val adapter = OrdersRecycleAdapter(requireContext(), orders)
        adapter.setOnOrderClickListener(object: OrdersRecycleAdapter.OnOrderClickListener {
            override fun onOrderClicked(order: Order) {
                val intent = Intent(requireContext(),OrderDetailsActivity::class.java)
                intent.putExtra("order", order)
                startActivity(intent)
            }
        })
        ordersRecycleView.adapter = adapter
        ordersRecycleView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        ordersRecycleView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

}