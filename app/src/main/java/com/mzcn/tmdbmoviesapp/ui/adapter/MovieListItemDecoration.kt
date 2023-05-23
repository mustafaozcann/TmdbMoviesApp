package com.mzcn.tmdbmoviesapp.ui.adapter

import android.graphics.Rect
import android.view.View
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.mzcn.tmdbmoviesapp.R

class MovieListItemDecoration : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val margin = parent.context.resources.getDimensionPixelSize(R.dimen.margin_8dp)

        outRect.bottom = margin
    }

}