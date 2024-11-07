package com.example.beanquest.Fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.beanquest.Adapters.PopularAdapter
import com.example.beanquest.Adapters.imageSliderAdapter
import com.example.beanquest.Models.PopularDish
import com.example.beanquest.R
import com.example.beanquest.databinding.FragmentHomeBinding
import com.example.beanquest.room.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {

    private lateinit var adapter: imageSliderAdapter
    private lateinit var viewPager2: ViewPager2
    private lateinit var imageList: ArrayList<Int>
    private lateinit var handler: Handler

    private lateinit var popularAdapter: PopularAdapter
    private lateinit var listPopular: List<PopularDish>
    private lateinit var homeRV: RecyclerView
    private val appDatabase by lazy {
        AppDatabase.getInstance(requireContext())
    }

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
//        listPopular.add(PopularDish(R.drawable.el_diablo_burger, "Эль-Диабло бургер", "1870тг"))
//        listPopular.add(PopularDish(R.drawable.nuggets_snacks, "Нагетсы", "1199тг"))
//        listPopular.add(PopularDish(R.drawable.cheesy_hot_dog, "Сырный хот-док", "1650тг"))
//        listPopular.add(PopularDish(R.drawable.beef_doner, "Донер с говядиной", "2530тг"))
//        listPopular.add(PopularDish(R.drawable.mushroom_pizza, "Пицца с грибами", "4400тг"))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setTransfarmer()

        viewPager2 = view.findViewById(R.id.imageSlider)
        homeRV = view.findViewById(R.id.home_RV)

        listPopular = appDatabase.dishDao().getDishes()
        popularAdapter = PopularAdapter(requireContext(), listPopular)

        homeRV.layoutManager = LinearLayoutManager(requireContext())
        homeRV.adapter = popularAdapter

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setTransfarmer() {

        val tranformer = CompositePageTransformer()
        tranformer.addTransformer(MarginPageTransformer(10))
        tranformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager2.setPageTransformer(tranformer)

    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)
    }

    private fun init() {

        imageList = ArrayList()
        adapter = imageSliderAdapter(requireContext(), imageList, viewPager2)
        handler = Handler(Looper.myLooper()!!)

        imageList.add(R.drawable.banner_1)
        imageList.add(R.drawable.banner_2)
        imageList.add(R.drawable.banner_3)
        imageList.add(R.drawable.banner_4)
        imageList.add(R.drawable.banner_5)
        imageList.add(R.drawable.banner_6)
        imageList.add(R.drawable.banner_7)
        imageList.add(R.drawable.banner_8)
        imageList.add(R.drawable.banner_9)
        imageList.add(R.drawable.banner_11)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER


    }
}
