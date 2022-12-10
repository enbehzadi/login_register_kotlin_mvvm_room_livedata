package com.frotel.cda.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.frotel.cda.livedata_mvvm.modelview.ViewModelUser
import com.frotel.cda.myapplication.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    private val ViewModelUser: ViewModelUser by viewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btRegister.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.btLogin.setOnClickListener{
        ViewModelUser.getLoginDetails(requireContext(), binding.etUsername.text.toString(),binding.etPassword.text.toString())!!.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                    Toast.makeText(requireContext(),"not found user",Toast.LENGTH_SHORT).show()
                }
                else {
                     findNavController().navigate(R.id.action_FirstFragment_to_MainFragment)
            }
        })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}