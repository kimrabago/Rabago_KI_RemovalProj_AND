package com.ucb.eldroid.removalproject.views.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import com.ucb.eldroid.removalproject.R
import com.ucb.eldroid.removalproject.models.MenuItem

class AddItemDialog(
    context: Context,
    private val onAdd: (MenuItem) -> Unit
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_menu_item)

        val foodNameEditText: EditText = findViewById(R.id.foodNameEditText)
        val priceEditText: EditText = findViewById(R.id.priceEditText)
        val addButton: Button = findViewById(R.id.addButton)

        val dialogWidth = context.resources.displayMetrics.widthPixels * 0.9f
        val dialogHeight = LinearLayout.LayoutParams.WRAP_CONTENT

        window?.setLayout(dialogWidth.toInt(), dialogHeight)

        addButton.setOnClickListener {
            val foodName = foodNameEditText.text.toString()
            val priceText = priceEditText.text.toString()

            if (foodName.isNotBlank() && priceText.isNotBlank()) {
                val price = priceText.toDoubleOrNull()
                if (price != null) {
                    onAdd(MenuItem(id = "", foodName = foodName, price = price))
                    dismiss()
                } else {
                    priceEditText.error = "Enter a valid price"
                }
            } else {
                if (foodName.isBlank()) foodNameEditText.error = "Enter a food name"
                if (priceText.isBlank()) priceEditText.error = "Enter a price"
            }
        }
    }
}