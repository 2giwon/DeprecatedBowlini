package com.beokbeok.bowlini.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ScrollAwareFABBehavior(context: Context?, attrs: AttributeSet?) :
    FloatingActionButton.Behavior(context, attrs) {

    private var mIsAnimatingOut = false
    private val mInterpolator: FastOutSlowInInterpolator = FastOutSlowInInterpolator()

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean = axes == ViewCompat.SCROLL_AXIS_VERTICAL
            || super.onStartNestedScroll(
        coordinatorLayout,
        child,
        directTargetChild,
        target,
        axes,
        type
    )


    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int
    ) {
        super.onNestedScroll(
            coordinatorLayout,
            child,
            target,
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            type
        )

        if (dyConsumed > 0 && !mIsAnimatingOut && child.visibility == View.VISIBLE) {
            animateOut(child)
        } else if (dyConsumed < 0 && child.visibility != View.VISIBLE) {
            animateIn(child)
        }
    }

    private fun animateIn(button: FloatingActionButton) {
        (button as View).visibility = View.VISIBLE

        ViewCompat.animate(button).run {
            scaleX(1.0F)
            scaleY(1.0F)
            alpha(1.0F)
            interpolator = mInterpolator
            withLayer()
            setListener(null)
        }.start()
    }

    private fun animateOut(button: FloatingActionButton) {
        ViewCompat.animate(button).run {
            scaleX(0f)
            scaleY(0f)
            alpha(0f)
            interpolator = mInterpolator
            withLayer()
            setListener(object : ViewPropertyAnimatorListener {

                override fun onAnimationStart(view: View?) {
                    mIsAnimatingOut = true
                }

                override fun onAnimationCancel(view: View?) {
                    mIsAnimatingOut = false

                }

                override fun onAnimationEnd(view: View?) {
                    mIsAnimatingOut = false
                    view?.let { it.visibility = View.INVISIBLE }
                }
            })
        }.start()
    }
}