package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.FragmentKeyboardBinding

class KeyboardFragment : Fragment() {

    companion object {
        fun newInstance() = KeyboardFragment()
    }

    lateinit var dataPasser: KeyboardInterface

    private lateinit var viewModel: KeyboardViewModel

    private var _binding: FragmentKeyboardBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as KeyboardInterface
    }

    fun passData(data: String){
        dataPasser.keyboardInterface(data)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKeyboardBinding.inflate(inflater, container, false)
        binding.a.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.a)
            passData(getString(R.string.a)) })

        binding.b.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.b)
            passData("B")})

        binding.c.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.c)
            passData("C")})

        binding.d.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.d)
            passData("D")})

        binding.e.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.e)
            passData("E")})

        binding.f.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.f)
            passData("F")})

        binding.g.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.g)
            passData("G")})

        binding.h.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.h)
            passData("H")})

        binding.i.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.i)
            passData("I")})

        binding.j.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.j)
            passData("J")})

        binding.k.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.k)
            passData("K")})

        binding.l.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.l)
            passData("L")})

        binding.m.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.m)
            passData("M")})

        binding.n.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.n)
            passData("N")})

        binding.o.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.o)
            passData("O")})

        binding.p.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.p)
            passData("P")})

        binding.q.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.q)
            passData("Q")})

        binding.r.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.r)
            passData("R")})

        binding.s.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.s)
            passData("S")})

        binding.t.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.t)
            passData("T")})

        binding.u.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.u)
            passData("U")})

        binding.v.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.v)
            passData("V")})

        binding.w.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.w)
            passData("W")})

        binding.x.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.x)
            passData("X")})

        binding.y.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.y)
            passData("Y")})

        binding.z.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.z)
            passData("Z")})

//        val intent = Intent(this.context, MainActivity::class.java)
//        intent.putExtra("letter", letter.text.toString())
//        ContextCompat.startActivity(intent)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(KeyboardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
