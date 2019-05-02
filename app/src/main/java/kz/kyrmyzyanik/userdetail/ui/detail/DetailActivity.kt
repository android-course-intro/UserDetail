package kz.kyrmyzyanik.userdetail.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kz.kyrmyzyanik.userdetail.R
import kz.kyrmyzyanik.userdetail.databinding.ActivityUserDetailBinding
import kz.kyrmyzyanik.userdetail.di.Injectable
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), Injectable {

    @Inject
    @VisibleForTesting
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private lateinit var dataBinding: ActivityUserDetailBinding
    private lateinit var detailViewModel: DetailViewModel
    var userId: Int = 0

    companion object {
        private const val EXTRA_USER_ID = "EXTRA_USER_ID"
        fun start(c: Context, id: Int) {
            val intent = Intent(c, DetailActivity::class.java)
            intent.putExtra(EXTRA_USER_ID, id)
            c.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getInputData()
        dataBind()
        setTitle("User Detail")
    }


    override fun onResume() {
        super.onResume()
        detailViewModel.userById(userId)
    }

    private fun dataBind() {
        detailViewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)
        dataBinding.viewModel = detailViewModel
    }

    private fun getInputData() {
        userId = intent.getIntExtra(EXTRA_USER_ID, 0)
    }
}
