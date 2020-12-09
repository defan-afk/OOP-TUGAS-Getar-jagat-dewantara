package com.ananda.oop2.fragments.add


import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ananda.oop2.DataSiswa
import com.ananda.oop2.DataSiswaModelView
import com.ananda.oop2.R
import kotlinx.android.synthetic.main.fragment_add_siswa.*
import kotlinx.android.synthetic.main.fragment_add_siswa.view.*


class FragmentsAdd : Fragment() {

    private  lateinit var mDataSiswaViewModel: DataSiswaModelView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_siswa, container, false)

        mDataSiswaViewModel = ViewModelProvider( this).get(DataSiswaModelView::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun  insertDataToDatabase(){
        val siswa = add_siswa.text.toString()
        val no_induk = add_induk.text.toString()

        if (inputCheck(siswa, no_induk)){
            // check user object
            val siswa = DataSiswa ( 0, siswa, no_induk)
            // add data to Database
            mDataSiswaViewModel.addDataSiswa(siswa)
            Toast.makeText(requireContext(),"Successfully added!", Toast.LENGTH_LONG).show()
            //navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)


        }else{
            Toast.makeText(requireContext(),"Please fill out all field.", Toast.LENGTH_LONG).show()
        }

    }

    private  fun  inputCheck(siswa: String, no_induk: String): Boolean{
        return !(TextUtils.isEmpty(siswa) && TextUtils.isEmpty(no_induk))
    }
}