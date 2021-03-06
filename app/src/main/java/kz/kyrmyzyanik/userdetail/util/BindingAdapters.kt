package kz.kyrmyzyanik.userdetail.util

import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.databinding.BindingAdapter

@BindingAdapter("textWatcher")
fun bindTextWatcher(view: View, textWatcher: TextWatcher) {
	if (view is EditText) {
		view.addTextChangedListener(textWatcher)
	}
}


@BindingAdapter("enable")
fun bindEnable(view: View, enable: Boolean) {
    view.isEnabled = enable
}

@BindingAdapter("visibility")
fun setVisibility(view: View, value: Boolean?) {
	value?.let {
		view.visibility = if (it) View.VISIBLE else View.GONE
	}
}