package com.josecuentas.widget;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by iPibeDx on 16/07/17.
 */

public class FilterOptionView extends ConstraintLayout {

  public FilterOptionView(Context context) {
    super(context);
    init();
  }

  public FilterOptionView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public FilterOptionView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    View rootView = LayoutInflater.from(getContext()).inflate(R.layout.filter_option_view, this, true);
    ConstraintLayout layout = (ConstraintLayout) rootView.findViewById(R.id.content_main);

    int previousButtomId = -1;

    for (int i = 1; i <= 6; i++) {
      ImageButton anotherButton = (ImageButton) LayoutInflater.from(getContext()).inflate(R.layout.view_filter_button, this, false);
      anotherButton.setId(i);
      layout.addView(anotherButton, anotherButton.getLayoutParams());

      ConstraintSet set = new ConstraintSet();
      set.clone(layout);
      if (i == 1) set.connect(anotherButton.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, toPx(16));
      else set.connect(anotherButton.getId(), ConstraintSet.START, previousButtomId, ConstraintSet.END, toPx(16));
      set.connect(anotherButton.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, toPx(0));
      set.applyTo(layout);

      previousButtomId = anotherButton.getId();
    }
  }

  private int toPx(int dp) {
    float density = getResources().getDisplayMetrics().density;
    return (int) (dp * density);

  }
}
