// Generated by view binder compiler. Do not edit!
package com.ch2ps075.talenthub.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ch2ps075.talenthub.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemRowQuestionBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ImageView ivExpanded;

  @NonNull
  public final TextView tvAnswerQuestion;

  @NonNull
  public final TextView tvTitleQuestion;

  private ItemRowQuestionBinding(@NonNull MaterialCardView rootView,
      @NonNull ConstraintLayout constraintLayout, @NonNull ImageView ivExpanded,
      @NonNull TextView tvAnswerQuestion, @NonNull TextView tvTitleQuestion) {
    this.rootView = rootView;
    this.constraintLayout = constraintLayout;
    this.ivExpanded = ivExpanded;
    this.tvAnswerQuestion = tvAnswerQuestion;
    this.tvTitleQuestion = tvTitleQuestion;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemRowQuestionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemRowQuestionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_row_question, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemRowQuestionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.constraint_layout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.iv_expanded;
      ImageView ivExpanded = ViewBindings.findChildViewById(rootView, id);
      if (ivExpanded == null) {
        break missingId;
      }

      id = R.id.tv_answer_question;
      TextView tvAnswerQuestion = ViewBindings.findChildViewById(rootView, id);
      if (tvAnswerQuestion == null) {
        break missingId;
      }

      id = R.id.tv_title_question;
      TextView tvTitleQuestion = ViewBindings.findChildViewById(rootView, id);
      if (tvTitleQuestion == null) {
        break missingId;
      }

      return new ItemRowQuestionBinding((MaterialCardView) rootView, constraintLayout, ivExpanded,
          tvAnswerQuestion, tvTitleQuestion);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
