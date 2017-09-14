package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dialog.filter

import android.app.Dialog
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatImageButton
import android.view.*
import android.widget.SeekBar
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Category
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.setBackgroundStateList
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.setDrawableTintList
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover.DiscoverListener
import kotlinx.android.synthetic.main.toolbar_dialog_filter.*
import kotlinx.android.synthetic.main.view_filter.*

/**
 * Created by jcuentas on 5/09/17.
 */
class FilterDialog : DialogFragment(), FilterContract.View {

    val presenter: FilterPresenter by lazy { FilterPresenter() } //singleton
    lateinit var discoverListener: DiscoverListener
    private var isLoadArgument = false

    companion object {
        fun newInstance(distance: Int, rating: Int): FilterDialog {
            val filterDialog = FilterDialog()
            val bundle = Bundle()
            bundle.putInt("distance", distance)
            bundle.putInt("rating", rating)

            filterDialog.arguments = bundle
            return filterDialog
        }
    }

    fun setOnAttach(discoverListener: DiscoverListener) {
        this.discoverListener = discoverListener
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(context).inflate(R.layout.view_filter, container, true)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectPresenter()
        events()
        ui()

        extrasOrLoadInit()
    }

    private fun extrasOrLoadInit() {
        if (!isLoadArgument) {
            if (arguments == null) return
            var rating = -1
            var distance = -1
            if (arguments.containsKey("rating")) {
                rating = arguments.getInt("rating", 0)
            }

            if (arguments.containsKey("distance")) {
                distance = arguments.getInt("distance", 0)
            }

            if (rating != -1 && distance != -1) {
                presenter.init(rating, distance)
            }
            isLoadArgument = true
        } else {
            presenter.loadInit()
        }
    }

    private fun injectPresenter() {
        //if (presenter == null) presenter = FilterPresenter()
        presenter.attached(this)
    }

    private fun events() {
        tviToolbarCancel.setOnClickListener { dismiss() }
        tviToolbarSave.setOnClickListener {
            dismiss()
            presenter.filter()
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                presenter.onChangeDistance(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        ratingBar.setOnRatingBarChangeListener({
            ratingBar, fl, b ->
            presenter.onChangeRating(fl.toInt())
        })


        val clickListener = object : View.OnClickListener {
            override fun onClick(it: View) {
                it.isSelected = !it.isSelected

                if (it.isSelected) {
                    presenter.onSelect(it.id)
                } else presenter.onUnSelect(it.id)
            }
        }
        iviHiking.setOnClickListener(clickListener)
        iviCycling.setOnClickListener(clickListener)
        iviSwimming.setOnClickListener(clickListener)
        iviRunning.setOnClickListener(clickListener)
        iviCampfire.setOnClickListener(clickListener)
        iviAnimal.setOnClickListener(clickListener)
    }

    private fun ui() {
        seekBar.thumbOffset = dpToPx(9)
        seekBar.setPadding(dpToPx(9), 0, dpToPx(9), 0)
        uiFilter()
    }

    fun uiFilter() {
        val colorTint = ContextCompat.getColorStateList(context, R.color.bg_tint_box_filter)
        val colorBackground = ContextCompat.getColorStateList(context, R.color.bg_box_filter)
        val childCount = constraintLayout.childCount

        for (index in 0..childCount - 1) {
            val imageButtom = constraintLayout.getChildAt(index)
            if (imageButtom is AppCompatImageButton) {
                imageButtom.setDrawableTintList(colorTint)
                imageButtom.setBackgroundStateList(R.drawable.bg_box_filter)
            }

        }
    }

    override fun setDistance(distance: Int) {
        seekBar.progress = distance
    }

    override fun setCategorys(list: List<Category>) {
        if (list == null) return
        val colorTint = ContextCompat.getColorStateList(context, R.color.bg_tint_box_filter)
        val childCount = constraintLayout.childCount
        for (index in 0..childCount - 1) {
            val imageButtom = constraintLayout.getChildAt(index)
            if (imageButtom is AppCompatImageButton) {

                val category = list.find { imageButtom.id == it.viewId }
                if (category != null) {
                    imageButtom.isSelected = true
                } else imageButtom.isSelected = false
            }
        }
    }

    override fun setRating(rating: Int) {
        ratingBar.rating = rating.toFloat()
    }

    override fun showRatingVeryBad() {
        tviRating.text = "VERY BAD."
    }

    override fun showRatingBad() {
        tviRating.text = "BAD"
    }

    override fun showRatingNoBad() {
        tviRating.text = "NO BAD."
    }

    override fun showRatingNice() {
        tviRating.text = "NICE"
    }

    override fun showRatingExcellent() {
        tviRating.text = "EXCELLENT!"
    }

    override fun showRatingEmpty() {
        tviRating.text = ""
    }

    override fun onFilter(distance: Int, progress: Int, categoriList: MutableList<Category>) {
        discoverListener.filter(distance, progress, categoriList)
    }

    override fun setupDialog(dialog: Dialog?, style: Int) {
        dialog!!.window.attributes.windowAnimations = R.style.AnimationDialogTop
        super.setupDialog(dialog, STYLE_NO_TITLE)
    }

    override fun onResume() {
        super.onResume()
        val attributes = dialog.window.attributes
        attributes.gravity = Gravity.TOP
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT
        dialog.window.attributes = attributes
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroyed()
    }

    protected fun dpToPx(dp: Int): Int {
        return (dp.toFloat() * Resources.getSystem().getDisplayMetrics().density).toInt()
    }

}