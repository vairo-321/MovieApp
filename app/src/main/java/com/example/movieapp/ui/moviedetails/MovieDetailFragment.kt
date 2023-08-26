package com.example.movieapp.ui.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.application.AppConstants
import com.example.movieapp.databinding.FragmentMovieDetailBinding


class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private lateinit var binding: FragmentMovieDetailBinding
    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieDetailBinding.bind(view)

        Glide.with(requireContext()).load(AppConstants.BASE_IMG+"${args.PosterImageUrl}").centerCrop().into(binding.imageMovie)
        Glide.with(requireContext()).load(AppConstants.BASE_IMG+"${args.backgroundImageUrl}").centerCrop().into(binding.imagenBackground)
        binding.txtMovieTitle.text = args.title
        binding.txtDescription.text = args.overview
        binding.txtLanguage.text = "Language ${args.languaje}"
        binding.txtRating.text = "${args.voteAverage} (${args.voteCount} Reviews)"
        binding.txtReleased.text = "Released ${args.releaseDate}"
    }

}