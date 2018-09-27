package com.starcodex.mvvmdagger.widget

import android.content.Context
import android.support.annotation.UiThread
import android.support.v7.widget.RecyclerView
import java.util.ArrayList

/**
 * Created by Bonestack on 22/09/2018.
 */
abstract class ArrayRecyclerAdapter<T, VH : RecyclerView.ViewHolder>(val context: Context) : RecyclerView.Adapter<VH>(), Iterable<T> {
    internal val list: ArrayList<T>

    init {
        this.list = ArrayList()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @UiThread
    fun reset(items: Collection<T>) {
        clear()
        addAll(items)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): T {
        return list[position]
    }

    fun addItem(item: T) {
        list.add(item)
    }

    fun addAll(items: Collection<T>) {
        list.addAll(items)
    }

    fun addAll(position: Int, items: Collection<T>) {
        list.addAll(position, items)
    }

    @UiThread
    fun addAllWithNotification(items: Collection<T>) {
        val position = itemCount
        addAll(items)
        notifyItemInserted(position)
    }

    fun clear() {
        list.clear()
    }

    override fun iterator(): Iterator<T> {
        return list.iterator()
    }

}
