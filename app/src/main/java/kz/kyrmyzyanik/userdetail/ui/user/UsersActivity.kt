package kz.kyrmyzyanik.userdetail.ui.user

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.VisibleForTesting
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_user_list.*
import kz.kyrmyzyanik.userdetail.R
import kz.kyrmyzyanik.userdetail.databinding.ActivityUserListBinding
import kz.kyrmyzyanik.userdetail.di.Injectable
import kz.kyrmyzyanik.userdetail.model.User
import javax.inject.Inject

class UsersActivity : AppCompatActivity(), Injectable {

    @Inject
    @VisibleForTesting
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var dataBinding: ActivityUserListBinding
    private lateinit var userViewModel: UserViewModel

    private lateinit var adapter: UserAdapter
    private var usersList: ArrayList<User> = arrayListOf()

    companion object {
        fun start(c: Context) {
            val intent = Intent(c, UsersActivity::class.java)
            c.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)

        adapter = UserAdapter(usersList, this)
        list.also {
            it.adapter = adapter.apply {
                setOnClickListener {
//                    val activity = this@FaveQRFragment.activity as MainActivity
//                    activity.updateFilterStatus(screenName)
                }
            }
            it.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        }

        dataBinding.viewModel = userViewModel

        userViewModel.showErrorToast.observe(this, Observer {
            Toast.makeText(this@UsersActivity, R.string.error_msg, Toast.LENGTH_SHORT).show()
        })

    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    /**
     * Method calls the Viewmodel's method which returns data
     */
    private fun loadData() {
        userViewModel.loadUsers().observe(this, Observer { users ->
            users?.let { updateView(it) }
        })
    }

    /**
     * Method updates the RecyclerView's adapter
     */
    private fun updateView(users: List<User>) {
        usersList.clear()
        usersList.addAll(users)
        adapter.notifyDataSetChanged()
    }
}
