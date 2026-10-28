
package com.amur.delivery

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    private val orange = Color.rgb(239, 91, 45)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun showHome() {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.TOP
            setPadding(32, 40, 32, 24)
            setBackgroundColor(Color.WHITE)
        }

        val title = TextView(this).apply {
            text = "🍔 Amur Delivery"
            textSize = 28f
            setTextColor(orange)
            setPadding(0, 0, 0, 12)
        }
        layout.addView(title)

        val subtitle = TextView(this).apply {
            text = "Food delivered to your door!"
            textSize = 16f
            setTextColor(Color.DKGRAY)
        }
        layout.addView(subtitle)

        val search = EditText(this).apply {
            hint = "Search food or restaurants"
            singleLine = true
        }
        layout.addView(search)

        addMode(layout, "🍽 Customer",
            "Browse restaurants and order food")
        addMode(layout, "🏪 Restaurant",
            "Manage menu and incoming orders")
        addMode(layout, "🛵 Delivery Partner",
            "Accept deliveries and track earnings")
        addMode(layout, "🛡 Admin",
            "Manage restaurants, orders and partners")

        setContentView(layout)
    }

    private fun addMode(
        layout: LinearLayout,
        name: String,
        description: String
    ) {
        val button = Button(this).apply {
            text = "$name\n$description"
            isAllCaps = false
            setTextColor(Color.WHITE)
            setBackgroundColor(orange)
            setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "$name selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 12, 0, 4)
        layout.addView(button, params)
    }
}
