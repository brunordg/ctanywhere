package br.com.codeteam.ctanywhere.utilities

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import br.com.codeteam.ctanywhere.ext.getParentActivity
import com.squareup.picasso.Picasso

//--------------—--------------—--------------—--------------—--------------—
// Itens referentes a listas
//--------------—--------------—--------------—--------------—--------------—
@BindingAdapter("adapter")
@Suppress("unused")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("dividerItemDecoration")
@Suppress("unused")
fun setDividerItemDecoration(view: RecyclerView, dividerItemDecoration: DividerItemDecoration) {
    view.addItemDecoration(dividerItemDecoration)
}

@BindingAdapter("layoutManager")
@Suppress("unused")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    view.layoutManager = layoutManager
}

//--------------—--------------—--------------—--------------—--------------—
// Itens referentes ao viewmodel
//--------------—--------------—--------------—--------------—--------------—
@BindingAdapter("mutableVisibility")
@Suppress("unused")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

@BindingAdapter("mutableText")
@Suppress("unused")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()

    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
    }
}

//--------------—--------------—--------------—--------------—--------------—
// Picasso
//--------------—--------------—--------------—--------------—--------------—
@BindingAdapter("picassoLoad")
@Suppress("unused")
fun loadRemoteImage(iv: ImageView, url: String) {
    Picasso.get()
            .load(url)
            .into(iv)
}

