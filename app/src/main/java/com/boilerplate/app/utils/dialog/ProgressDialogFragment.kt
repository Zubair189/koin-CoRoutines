package com.boilerplate.app.utils.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.boilerplate.app.R
import com.boilerplate.app.utils.K
import com.boilerplate.app.view.base.BaseActivity

class ProgressDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.progress_dialog_fragment_layout, container, false)
        isCancelable = false
        rootView.layoutParams =
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return rootView
    }

    companion object {
        fun showProgressBar(activity: BaseActivity) {
            try {
                val fm = activity.supportFragmentManager
                val dialogFragment = ProgressDialogFragment()
                dialogFragment.show(fm, K.PROGRESS_DIALOG_TAG)
            } catch (ignored: Exception) {
            }
        }

        fun hideProgressBar(activity: BaseActivity) {
            try {
                val fm = activity.supportFragmentManager
                val dialog = fm.findFragmentByTag(K.PROGRESS_DIALOG_TAG)
                if (dialog != null && dialog is ProgressDialogFragment) {
                    dialog.dismiss()
                }
            } catch (ignored: Exception) {
            }
        }
    }
}