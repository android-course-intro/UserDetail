package kz.kyrmyzyanik.userdetail.ui.user

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.kyrmyzyanik.userdetail.R
import kz.kyrmyzyanik.userdetail.model.User


/**
 * This Adapter delivers every single item for Recylerview.
 */
class UserAdapter(private val userList: List<User>, private val context: Context) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private var onClickAction: (User) -> Unit = { _ -> }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName?.text = userList[position].name
        holder.txtInfo?.text = "${userList[position].address.city} : ${userList[position].company.name}"

        holder.itemView.setOnClickListener {
            onClickAction.invoke(userList[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.view_item_user, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setOnClickListener(onClickAction: (User) -> Unit) {
        this.onClickAction = onClickAction
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName = itemView.findViewById<TextView>(R.id.txt_name)
        val txtInfo = itemView.findViewById<TextView>(R.id.txt_info)
    }

}