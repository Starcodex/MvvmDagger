package com.starcodex.mvvmdagger.widget

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Bonestack on 23/09/2018.
 */
class BindableHolder<T : ViewDataBinding>(context: Context, parent: ViewGroup, @LayoutRes layoutResId: Int) : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(layoutResId, parent, false)) {

    val binding: T

    init {
        binding = DataBindingUtil.bind(itemView)
    }

}