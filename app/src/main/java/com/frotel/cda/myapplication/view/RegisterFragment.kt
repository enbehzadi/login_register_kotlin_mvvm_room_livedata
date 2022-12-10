package com.frotel.cda.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.frotel.cda.livedata_mvvm.modelview.ViewModelUser
import com.frotel.cda.myapplication.databinding.FragmentRegisterBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val ViewModeluser: ViewModelUser by viewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btRegister.setOnClickListener{

            ViewModeluser.insertData(requireContext(), binding.etUsername.text.toString(),binding.etPassword.text.toString())

            Toast.makeText(context,"inserted successfully",Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_RegisterFragment_to_LoginFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}