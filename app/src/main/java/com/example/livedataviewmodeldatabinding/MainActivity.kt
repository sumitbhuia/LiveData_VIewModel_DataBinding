package com.example.livedataviewmodeldatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.livedataviewmodeldatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ActivityMainViewModel
    lateinit var factory: ActivityMainViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setting up DataBinding
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        //ViewModel Factory
        factory = ActivityMainViewModelFactory(100)

        //ViewModel
        viewModel = ViewModelProvider(this,factory)[ActivityMainViewModel::class.java]


        // Connecting variable to viewModel instance
        binding.viewModelVar=viewModel

        // This code ,eliminates individually observing events
        binding.lifecycleOwner = this



        /*


                - Displaying LiveData , i.e. any data change
                - Data of totalSum . display  here(i.e. mainActivity)  what{set resulTxt to totalSum}
                - This can also be done in the activity_main.xml itself , by connecting a variable to viewModel class
                - Thus , the variable can access everything from viewModel class , in a way connected
                - We connected the <textView> , <text> field  to observe totalCount and display
                - Similarly we connected the <button> , <onclick> and assigned it to access updateCounter , for each click


                // WITHOUT USE OF VARIABLES


                            // connecting totalCount and updating textView
                                viewModel.totalCount.observe(this) { binding.textView.text = it.toString() }

                            // handling clicks , with onClickListeners
                                binding.apply {
                                    button.setOnClickListener(){
                                        viewModel.updateCounter(textView.text.toString().toInt())
                                    }
                                }

        */

    }

}