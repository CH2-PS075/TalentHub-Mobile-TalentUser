// Generated by view binder compiler. Do not edit!
package com.ch2ps075.talenthub.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ch2ps075.talenthub.R;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSearchBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final SearchBar searchBar;

  @NonNull
  public final SearchView searchView;

  @NonNull
  public final TextView tvTalentSize;

  private FragmentSearchBinding(@NonNull ConstraintLayout rootView, @NonNull SearchBar searchBar,
      @NonNull SearchView searchView, @NonNull TextView tvTalentSize) {
    this.rootView = rootView;
    this.searchBar = searchBar;
    this.searchView = searchView;
    this.tvTalentSize = tvTalentSize;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_search, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSearchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.search_bar;
      SearchBar searchBar = ViewBindings.findChildViewById(rootView, id);
      if (searchBar == null) {
        break missingId;
      }

      id = R.id.search_view;
      SearchView searchView = ViewBindings.findChildViewById(rootView, id);
      if (searchView == null) {
        break missingId;
      }

      id = R.id.tv_talent_size;
      TextView tvTalentSize = ViewBindings.findChildViewById(rootView, id);
      if (tvTalentSize == null) {
        break missingId;
      }

      return new FragmentSearchBinding((ConstraintLayout) rootView, searchBar, searchView,
          tvTalentSize);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
