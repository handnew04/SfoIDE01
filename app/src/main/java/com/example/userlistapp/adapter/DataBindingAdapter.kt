package com.example.userlistapp.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.userlistapp.*
import com.example.userlistapp.data.Name
import com.example.userlistapp.data.Result
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("bindProfile")
fun CircleImageView.bindImage(imageUri: String?) {
    Glide.with(this.context).load(imageUri).into(this)
}

@BindingAdapter("bindUserName")
fun TextView.bindUserName(userName: Name?) {
    userName?.let {
        val userFullName = "${userName.first} ${userName.last}"
        this.text = userFullName
    }
}

@BindingAdapter("bindTitle", "bindAge")
fun TextView.bindGender(gender: String?, age: Int?) {
       age?.let { setUserGenderIcon(this, gender, age) }
}

fun setUserGenderIcon(view: TextView, gender: String?, age: Int) {
    if (age < 10) {
        view.text = CHILD_TOTAL
    } else if (age < 65) {
        if (gender == "male") {
            view.text = YOUNGER_MALE
        } else {
            view.text = YOUNGER_FEMALE
        }
    } else {
        if (gender == "male") {
            view.text = OLDER_MALE
        } else {
            view.text = OLDER_FEMALE
        }
    }
}

@BindingAdapter("bindFlag")
fun TextView.bindFlag(country: String) {
    val uniCode: String
when(country) {
    "AU" -> uniCode = "\uD83C\uDDE6\uD83C\uDDFA"
    "BR" -> uniCode = "\uD83C\uDDE7\uD83C\uDDF7"
    "CA" -> uniCode = "\uD83C\uDDE8\uD83C\uDDE6"
    "CH" -> uniCode = "\uD83C\uDDE8\uD83C\uDDED"
    "DK" -> uniCode = "\uD83C\uDDE9\uD83C\uDDF0"
    "ES" -> uniCode = "\uD83C\uDDEA\uD83C\uDDF8"
    "FR" -> uniCode = "\uD83C\uDDEB\uD83C\uDDF7"
    "NL" -> uniCode = "\uD83C\uDDE7\uD83C\uDDF6"
    "US" -> uniCode = "\uD83C\uDDFA\uD83C\uDDF8"
    else -> uniCode = ""
}
    this.text = uniCode
}

@BindingAdapter("replaceAll")
fun RecyclerView.replaceAll(item: List<Result>?) {
    if (!item.isNullOrEmpty()) {
        (adapter as MainRecyclerAdapter).setItemList(item as ArrayList<Result>)
    }
}