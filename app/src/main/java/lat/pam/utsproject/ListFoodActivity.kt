package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = listOf(
            Food("Dimsum Seafood", "3 pcs dimsum udang, tuna, crab", R.drawable.dimsum_seafood),
            Food("Dimsum Non Seafood", "3 pcs dimsum jamur, beef, ayam", R.drawable.dimsum_nonseafood),
            Food("Dimsum Nori", "3 pcs dimsum nori", R.drawable.dimsum_nori),
            Food("Dimsum Mentai Spesial", "6 pcs dimsum dengan saus mentai", R.drawable.dimsum_mentai),
            Food("Hisitkau", "3 pcs dimsum berbentuk pastel dengan isi ayam udang", R.drawable.hisitkau),
            Food("Xiao Long Bao","3 pcs kulit dimsum yang di dalamnya terdapat kuah kaldu ayam", R.drawable.xiao_long_bao),
            Food("Wonton Chili Oil","5 pcs wonton dengan chili oil", R.drawable.wonton_chilioil)
        )

        adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter

        // Atur listener item klik
        adapter.setOnItemClickListener(object : FoodAdapter.OnItemClickListener {
            override fun onItemClick(food: Food) {
                val intent = Intent(this@ListFoodActivity, OrderActivity::class.java)
                intent.putExtra("foodName", food.name)
                startActivity(intent)
            }
        })

    }
}
